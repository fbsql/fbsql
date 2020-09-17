/*
MIT License

Copyright (c) 2020 FBSQL Team

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Home:   https://fbsql.github.io
E-Mail: fbsql.team@gmail.com
*/

package org.fbsql.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.fbsql.antlr4.parser.ParseNativeStmt;
import org.fbsql.antlr4.parser.ParseNativeStmt.Procedure;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

public class CallUtils {

	/* JS */
	private static final String PLT_OPTIONS_JS_FILE     = "file";
	private static final String PLT_OPTIONS_JS_FUNCTION = "function";

	/* JVM */
	private static final String PLT_OPTIONS_JVM_CLASS  = "class";
	private static final String PLT_OPTIONS_JVM_METHOD = "method";

	/* OS */
	private static final String PLT_OPTIONS_OS_FILE = "file";

	/* URL */
	private static final String PLT_OPTIONS_URL_URL = "url";

	/**
	 * Get CALL Statement Method
	 *
	 * @param sql
	 * @param proceduresMap
	 * @return
	 * @throws Exception
	 */
	public static NonNativeProcedure getCallStatementNonNativeProcedure(String sql, Map<String /* stored procedure name */, NonNativeProcedure> proceduresMap) {
		String text = SqlParseUtils.canonizeSql(sql);
		if (!text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_CALL))
			return null; // Not a CALL statement

		ParseNativeStmt parseNativeStmt = new ParseNativeStmt(proceduresMap.keySet());
		Procedure       procedure       = parseNativeStmt.parse(sql);
		return proceduresMap.get(procedure.name);
	}

	public static String executeOsProgramm(String instanceDirectory, String optionsJson, Object[] parameters) throws Exception {
		Map<String, Object> options  = RhinoUtils.asMap(optionsJson);
		String              fileName = (String) options.get(PLT_OPTIONS_OS_FILE);
		Path                pgmPath;
		if (fileName.charAt(0) == '/')
			pgmPath = Paths.get(fileName);
		else
			pgmPath = Paths.get(instanceDirectory + '/' + fileName);

		List<String> cmds = new ArrayList<>(parameters.length);
		cmds.add(pgmPath.toString());
		for (Object parameter : parameters)
			cmds.add(parameter.toString());

		ProcessBuilder processBuilder = new ProcessBuilder(cmds);
		try {

			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			StringBuilder sb = new StringBuilder();
			String        line;
			while ((line = reader.readLine()) != null)
				sb.append(line);
			int exitCode = process.waitFor();
			return sb.toString().trim();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String executeUrl(String instanceDirectory, String optionsJson, Map<String, Object> parametersMap) throws Exception {
		Map<String, Object> options = RhinoUtils.asMap(optionsJson);
		String              urlStr  = (String) options.get(PLT_OPTIONS_URL_URL);
		Path                path;
		InputStream         is;
		if (urlStr.charAt(0) == '/') {
			path = Paths.get(urlStr);
			is   = new FileInputStream(path.toFile());
		} else if (!urlStr.startsWith("http://") && !urlStr.startsWith("https://")) {
			path = Paths.get(instanceDirectory + '/' + urlStr);
			is   = new FileInputStream(path.toFile());
		} else {
			boolean first = true;
			for (Map.Entry<String, Object> entry : parametersMap.entrySet()) {
				String name  = entry.getKey();
				String value = URLEncoder.encode(entry.getValue().toString().trim(), StandardCharsets.UTF_8.name());
				if (first) {
					first   = false;
					urlStr += '?';
				} else
					urlStr += '&';
				urlStr += name + '=' + value;
			}
			URL url = new URL(urlStr);
			is = url.openStream();
		}
		try (is) {
			return StringUtils.inputSreamToString(is);
		}
	}

	public static String executeFile(String instanceDirectory, String text) throws Exception {
		return executeUrl(instanceDirectory, "file://" + text, Collections.EMPTY_MAP);
	}

	/**
	 * Get Java Method
	 *
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public static Method getMethod(String text) throws Exception {
		Map<String, Object> cfg        = RhinoUtils.asMap(text);
		String              className  = (String) cfg.get(PLT_OPTIONS_JVM_CLASS);
		String              methodName = (String) cfg.get(PLT_OPTIONS_JVM_METHOD);

		Class<?> clazz   = Class.forName(className);
		Method[] methods = clazz.getMethods();
		for (Method method : methods)
			if (method.getName().equals(methodName))
				return method;
		throw new Exception("Java method declared, but not found in the class");
	}

	/**
	 * Get JavaScript Function
	 *
	 * @param text
	 * @param mapScopes
	 * @param mapFunctions
	 * @return
	 * @throws Exception
	 */
	public static JsFunction getFunction(String instanceDirectory, String text, Map<String /* js file name */, Scriptable> mapScopes, Map<String /* js file name */, Map<String /* function name */, Function>> mapFunctions) throws Exception {
		Map<String, Object> cfg          = RhinoUtils.asMap(text);
		String              jsFileName   = (String) cfg.get(PLT_OPTIONS_JS_FILE);
		String              functionName = (String) cfg.get(PLT_OPTIONS_JS_FUNCTION);

		Path jsFilePath;
		if (jsFileName.charAt(0) == '/')
			jsFilePath = Paths.get(jsFileName); // convert className to JavaScript file name
		else
			jsFilePath = Paths.get(instanceDirectory + '/' + jsFileName); // convert className to JavaScript file name

		//
		// initize Rhino
		// https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino
		//
		Context ctx = Context.enter();

		ctx.setLanguageVersion(Context.VERSION_1_7);
		ctx.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization

		Scriptable scope = mapScopes.get(jsFileName);
		if (scope == null) {
			String content = new String(Files.readAllBytes(jsFilePath), StandardCharsets.UTF_8);
			scope = ctx.initStandardObjects();
			ctx.evaluateString(scope, content, "script", 1, null);
			mapScopes.put(jsFileName, scope);
		}

		Map<String /* function name */, Function> map = mapFunctions.get(jsFileName);
		if (map == null) {
			map = new HashMap<>();
			mapFunctions.put(jsFileName, map);
		}

		Function fct = map.get(functionName);
		if (fct == null) {
			fct = (Function) scope.get(functionName, scope);
			map.put(functionName, fct);
		}

		JsFunction jsFunction = new JsFunction();
		jsFunction.scope    = scope;
		jsFunction.function = fct;

		return jsFunction;
	}

	/**
	 * Get CALL Statement Parameter Values
	 *
	 * @param sql
	 * @param namedParametersMap
	 * @param parameterValues
	 * @throws Exception
	 */
	public static void getCallStatementParameterValues(ParseNativeStmt parseNativeStmt, String sql, Map<String /* parameter name */, Object /* parameter value */> namedParametersMap, List<Object> parameterValues) throws Exception {
		Procedure procedure = parseNativeStmt.parse(sql);

		//		int posLeft = sql.indexOf('(');
		//		if (posLeft == -1)
		//			throw new IllegalArgumentException(MessageFormat.format("Syntax error: missing left parenthesis: {0}", sql));
		//
		//		int posRight = sql.lastIndexOf(')');
		//		if (posRight != sql.length() - 1)
		//			throw new IllegalArgumentException(MessageFormat.format("Syntax error: missing right parenthesis: {0}", sql));

		//String params = sql.substring(posLeft + 1, posRight).trim();

		List<String> parameterNames = new ArrayList<>();
		for (Object value : parameterValues) // add corresponding entries to parameterNames 
			parameterNames.add(null);
		//
		parseNamedSqlParameters(procedure.parameters, parameterNames, parameterValues);

		for (int i = 0; i < parameterNames.size(); i++) {
			String parameterName  = parameterNames.get(i);
			Object parameterValue = parameterValues.get(i);
			if (parameterName != null) {
				parameterValue = namedParametersMap.get(parameterName);
				parameterValues.set(i, parameterValue);
			}
		}
	}

	/**
	 * Parse named SQL parameters
	 *
	 * @param s               - parameters string E.g "'John', 123.45, NULL, :price"
	 * @param parameterNames  - parsed parameter names (output)
	 * @param parameterValues - parsed parameter values (output)
	 */
	private static void parseNamedSqlParameters(List<String> strParameters, List<String> parameterNames, List<Object> parameterValues) {
		for (String strParameter : strParameters) {
			String parameterName;
			Object parameterValue;
			if (strParameter.startsWith("'") || strParameter.startsWith("\"")) {
				parameterName  = null;
				parameterValue = strParameter.substring(1, strParameter.length() - 1);
			} else if (strParameter.toUpperCase(Locale.ENGLISH).equals("NULL")) {
				parameterName  = null;
				parameterValue = null;
			} else if (strParameter.startsWith(":")) {
				parameterName  = strParameter.substring(1);
				parameterValue = null;
			} else {
				parameterName = null;
				try {
					parameterValue = NumberFormat.getInstance().parse(strParameter);
				} catch (ParseException e) {
					parameterValue = strParameter;
				}
			}
			parameterNames.add(parameterName);
			parameterValues.add(parameterValue);
		}
	}

	/**
	 * Parse SQL parameters
	 *
	 * @param s               - parameters string E.g "'John', 123.45, NULL"
	 * @param parameterValues - parsed parameter values (output)
	 */
	public static void parseSqlParameters(ParseNativeStmt parseNativeStmt, String s, List<Object> parameterValues) {
		Procedure procedure = parseNativeStmt.parse(s);

		for (String strParameter : procedure.parameters) {
			Object parameterValue;
			if (strParameter.startsWith("'") || strParameter.startsWith("\""))
				parameterValue = strParameter.substring(1, strParameter.length() - 1);
			else if (strParameter.toUpperCase(Locale.ENGLISH).equals("NULL"))
				parameterValue = null;
			else if (strParameter.startsWith(":"))
				parameterValue = null;
			else
				try {
					parameterValue = NumberFormat.getInstance().parse(strParameter);
				} catch (ParseException e) {
					parameterValue = strParameter;
				}
			parameterValues.add(parameterValue);
		}
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
