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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.CommonDataSource;

import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeJSON;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

public class RhinoUtils {

	/**
	 * Convert JSON string to Object
	 *
	 * @param json
	 * @return
	 */
	public static Object toObject(String json) {
		Context context = Context.enter();
		context.setLanguageVersion(Context.VERSION_ES6);
		context.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization
		context.getWrapFactory().setJavaPrimitiveWrap(false);
		Scriptable scriptable = context.initStandardObjects();
		Object     object     = NativeJSON.parse(context, scriptable, json, new Callable() {
									@Override
									public Object call(Context arg0, Scriptable arg1, Scriptable arg2, Object[] objects) {
										Object obj = objects[1];
										if (obj instanceof Map)
											return new LinkedHashMap<>((Map) obj);
										if (obj instanceof NativeArray) {
											NativeArray nativeArray = (NativeArray) obj;
											return Arrays.asList(nativeArray.toArray());
										}
										return obj;
									}
								});
		context.exit();
		return object;
	}

	public static void main(String[] args) throws IOException {
		Map<String /* js file name */, Scriptable> mapScopes = new HashMap<>();
		Map<String /* js file name */, Map<String /* function name */, Function>>  mapFunctions = new HashMap<>();
		String script = "/home/qsecofr/fbsql/config/db/my-sqlite/a.js";
		//String   script     = "function abc(x,y) {return [{a: x+y}]};";
		final Object[] parameters = new Object[] { 2, 3 };
		Object   result     = callJavaScriptFunction(mapScopes, mapFunctions, "/home/qsecofr/fbsql/config/db/my-sqlite/a.js", "abc", parameters);
		System.out.println(result);
		final Object[] parameters2 = new Object[] { 20, 30 };
		result     = callJavaScriptFunction(mapScopes, mapFunctions, "/home/qsecofr/fbsql/config/db/my-sqlite/a.js",  "abc", parameters2);
		System.out.println(result);

		new Thread() {
			public void run() {
				final Object[] parameters3 = new Object[] { 20, 30 };
				Object result = null;
				try {
					result = callJavaScriptFunction(mapScopes, mapFunctions, "/home/qsecofr/fbsql/config/db/my-sqlite/b.js",  "eee", parameters3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(result);			
			};
		}.start();

		new Thread() {
			public void run() {
				final Object[] parameters = new Object[] { 20, 30 };
				Object result = null;
				try {
					result = callJavaScriptFunction(mapScopes, mapFunctions, "/home/qsecofr/fbsql/config/db/my-sqlite/a.js",  "rrr", parameters);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(result);
			};
		}.start();


		Object[] parameters4 = new Object[] { 20, 30 };
		result     = callJavaScriptFunction(mapScopes, mapFunctions, "/home/qsecofr/fbsql/config/db/my-sqlite/a.js",  "abc", parameters4);
		System.out.println(result);


	}

	/**
	 * 
	 * @param mapScopes
	 * @param mapFunctions
	 * @param scriptFile
	 * @param funcName
	 * @param parameters
	 * @return
	 * @throws IOException
	 */
	public static Object callJavaScriptFunction(Map<String /* js file name */, Scriptable> mapScopes, Map<String /* js file name */, Map<String /* function name */, Function>> mapFunctions, String scriptFile, String funcName, Object[] parameters) throws IOException {
		try {
			//
			// initize Rhino
			// https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino
			//
			Context ctx = Context.enter();

			ctx.setLanguageVersion(Context.VERSION_1_7);
			ctx.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization
			
			Scriptable scope = mapScopes.get(scriptFile);
			if (scope == null) {
				String content = new String(Files.readAllBytes(Paths.get(scriptFile)), StandardCharsets.UTF_8);
				scope = ctx.initStandardObjects();
				ctx.evaluateString(scope, content, "script", 1, null);
				mapScopes.put(scriptFile, scope);
			}

			Map<String /* function name */, Function> map = mapFunctions.get(scriptFile);
			if (map == null) {
				map = new HashMap<>();
				mapFunctions.put(scriptFile, map);
			} 
			Function fct = map.get(funcName);
			if (fct == null) {
				fct = (Function) scope.get(funcName, scope);
				map.put(funcName, fct);
			}

			Object result = fct.call(ctx, scope, null, parameters);
			if (result instanceof NativeObject || result instanceof NativeArray) // return JSON object that will sent to client
				return (String) NativeJSON.stringify(ctx, scope, result, null, null);
			return null;
		} finally {
			Context.exit();
		}
	}

//	/**
//	 * 
//	 * @param script
//	 * @param funcName
//	 * @param parameters
//	 * @return
//	 */
//	public static Object callJavaScriptFunction2222(String script, String funcName, Object[] parameters) {
//		try {
//			//
//			// initize Rhino
//			// https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino
//			//
//			Context ctx = Context.enter();
//			ctx.getWrapFactory().setJavaPrimitiveWrap(true);
//			ctx.setLanguageVersion(Context.VERSION_1_7);
//			ctx.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization
//			Scriptable scope = ctx.initStandardObjects(); // scope
//			ctx.evaluateString(scope, script, "", 1, null);
//			Scriptable that = ctx.newObject(scope);
//
//			Function fct    = ctx.compileFunction(that, script, "script", 1, null);
//			Object   result = fct.call(ctx, scope, that, parameters);
//			if (result instanceof NativeObject || result instanceof NativeArray) // return JSON object that will sent to client
//				return (String) NativeJSON.stringify(ctx, scope, result, null, null);
//			return null; // notification will not sent to client
//		} finally {
//			Context.exit();
//		}
//	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
