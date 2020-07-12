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

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeJSON;
import org.mozilla.javascript.Scriptable;

public class JsonRhinoUtils {

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
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
