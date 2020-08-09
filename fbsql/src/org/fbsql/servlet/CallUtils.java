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
E-Mail: fbsql.team.team@gmail.com
*/

package org.fbsql.servlet;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

public class CallUtils {

	private static final String USER_HOME_DIR = System.getProperty("user.home");

	private static final String JAVA_METHOD_SEPARATOR = "::"; // Lambda static method notation: className::methodName

	/**
	 * Single quote character constant (string parameter wrapped in single quotes)
	 */
	private static final char Q1 = '\''; // single quote

	/**
	 * Double quote character constant (string parameter wrapped in double quotes)
	 */
	private static final char Q2 = '"'; // double quote

	/**
	 * Comma character constant (parameters separator)
	 */
	private static final char COMMA = ','; // comma

	/**
	 * Get CALL Statement Method
	 *
	 * @param sql
	 * @param proceduresMap
	 * @return
	 * @throws Exception
	 */
	public static String getCallStatementMethod(String sql, Map<String /* stored procedure name */, String /* java method */> proceduresMap) {
		final String CALL_PREFIX = "CALL ";
		if (!sql.toUpperCase(Locale.ENGLISH).startsWith(CALL_PREFIX))
			return null; // Not a CALL statement
		int    OFFSET   = CALL_PREFIX.length(); // "CALL " length: 5
		String procName = sql.substring(OFFSET);

		int posLeft = procName.indexOf('(');
		if (posLeft == -1)
			return null; // Syntax error: missing left parenthesis

		procName = procName.substring(0, posLeft).trim().toUpperCase(Locale.ENGLISH);

		return proceduresMap.get(procName);
	}

	/**
	 * Get CALL Statement Method
	 *
	 * @param sql
	 * @param proceduresMap
	 * @return
	 * @throws Exception
	 */
	public static MethodOrFunction getMethodOrFunction(String javaMethod, Map<String /* stored procedure name */, String /* java method */> proceduresMap, Map<String /* js file name */, Scriptable> mapScopes, Map<String /* js file name */, Map<String /* function name */, Function>> mapFunctions) throws Exception {
		if (javaMethod == null)
			return null; // No Java method declared

		String[] array      = javaMethod.split(JAVA_METHOD_SEPARATOR);
		String   className  = array[0];
		String   methodName = array[1];

		MethodOrFunction methodOrFunction = new MethodOrFunction();
		Class<?>         clazz;
		try {
			// Try Java
			clazz = Class.forName(className);
			Method[] methods = clazz.getMethods();
			for (Method method : methods)
				if (method.getName().equals(methodName)) {
					methodOrFunction.method = method;
					return methodOrFunction;
				}
			// Java method declared, but not found in the class
		} catch (ClassNotFoundException e) {
			// Try JavaScript
			Path jsFilePath = Paths.get(USER_HOME_DIR + "/fbsql/config/js/" + (className.replace('.', '/') + ".js")); // convert className to JavaScript file name
			if (!Files.exists(jsFilePath))
				return null;

			//
			// initize Rhino
			// https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino
			//
			Context ctx = Context.enter();

			ctx.setLanguageVersion(Context.VERSION_1_7);
			ctx.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization

			Scriptable scope = mapScopes.get(className);
			if (scope == null) {
				String content = new String(Files.readAllBytes(jsFilePath), StandardCharsets.UTF_8);
				scope = ctx.initStandardObjects();
				ctx.evaluateString(scope, content, "script", 1, null);
				mapScopes.put(className, scope);
			}

			Map<String /* function name */, Function> map = mapFunctions.get(className);
			if (map == null) {
				map = new HashMap<>();
				mapFunctions.put(className, map);
			}

			Function fct = map.get(methodName);
			if (fct == null) {
				fct = (Function) scope.get(methodName, scope);
				map.put(methodName, fct);
			}

			methodOrFunction.scope    = scope;
			methodOrFunction.function = fct;

			return methodOrFunction;

		}
		return null;
	}

	/**
	 * Get CALL Statement Parameter Values
	 *
	 * @param sql
	 * @param namedParametersMap
	 * @param parameterValues
	 * @throws Exception
	 */
	public static void getCallStatementParameterValues(String sql, Map<String /* parameter name */, Object /* parameter value */> namedParametersMap, List<Object> parameterValues) throws Exception {
		int posLeft = sql.indexOf('(');
		if (posLeft == -1)
			throw new IllegalArgumentException(MessageFormat.format("Syntax error: missing left parenthesis: {0}", sql));

		int posRight = sql.lastIndexOf(')');
		if (posRight != sql.length() - 1)
			throw new IllegalArgumentException(MessageFormat.format("Syntax error: missing right parenthesis: {0}", sql));

		String params = sql.substring(posLeft + 1, posRight).trim();

		List<String> parameterNames = new ArrayList<>();
		for (Object value : parameterValues) // add corresponding entries to parameterNames 
			parameterNames.add(null);
		//
		parseNamedSqlParameters(params, parameterNames, parameterValues);

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
	private static void parseNamedSqlParameters(String s, List<String> parameterNames, List<Object> parameterValues) {
		List<String> strParameters = parseSqlParametersString(s);
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
	public static void parseSqlParameters(String s, List<Object> parameterValues) {
		List<String> strParameters = parseSqlParametersString(s);
		for (String strParameter : strParameters) {
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

	/**
	 * Parse SQL parameters string
	 *
	 * @param s - parameters string E.g "'John', 123.45, NULL, :price"
	 * @return  - parsed parameter values
	 */
	private static List<String> parseSqlParametersString(String s) {
		List<String> parameters = new ArrayList<>();
		if (s.isEmpty())
			return parameters;

		StringBuilder sb             = new StringBuilder();
		boolean       inSingleQuotes = false;
		boolean       inDoubleQuotes = false;

		for (char c : s.toCharArray()) {
			if (inDoubleQuotes) {
				if (c == Q2) {
					inDoubleQuotes = false;
					sb.append(c);
				} else
					sb.append(c);
			} else if (inSingleQuotes) {
				if (c == Q1) {
					inSingleQuotes = false;
					sb.append(c);
				} else
					sb.append(c);
			} else {
				if (c == Q2) {
					inDoubleQuotes = true;
					sb.append(Q2);
				} else if (c == Q1) {
					inSingleQuotes = true;
					sb.append(Q1);
				} else if (c == COMMA) {
					parameters.add(sb.toString().trim());
					sb = new StringBuilder();
				} else
					sb.append(c);
			}
		}
		parameters.add(sb.toString().trim());

		return parameters;
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
