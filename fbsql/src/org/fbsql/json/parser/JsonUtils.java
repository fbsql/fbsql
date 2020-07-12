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

package org.fbsql.json.parser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonUtils {

	/**
	 * Parse JSON float
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseJsonObject(CharSequence cs) {
		return (Map<String, String>) parseJson(cs);
	}

	/**
	 * Parse JSON attay
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> parseJsonArray(CharSequence s) {
		return (List<String>) parseJson(s);
	}

	/**
	 * Parse JSON String
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public static String parseJsonString(CharSequence s) {
		return (String) parseJson(s);
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean parseJsonBoolean(CharSequence s) {
		return (Boolean) parseJson(s);
	}

	/**
	 * Parse JSON number
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public static Number parseJsonNumber(CharSequence s) {
		return (Number) parseJson(s);
	}

	/**
	 * Parse JSON short
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public static Short parseJsonShort(CharSequence s) {
		Number number = parseJsonNumber(s);
		if (number == null)
			return null;
		return number.shortValue();
	}

	/**
	 * Parse JSON integer
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public static Integer parseJsonInt(CharSequence s) {
		Number number = parseJsonNumber(s);
		if (number == null)
			return null;
		return number.intValue();
	}

	/**
	 * Parse JSON long
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public static Long parseJsonLong(CharSequence s) {
		Number number = parseJsonNumber(s);
		if (number == null)
			return null;
		return number.longValue();
	}

	/**
	 * Parse JSON double
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public static Double parseJsonDouble(CharSequence s) {
		Number number = parseJsonNumber(s);
		if (number == null)
			return null;
		return number.doubleValue();
	}

	/**
	 * Parse JSON float
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public static Float parseJsonFloat(CharSequence s) {
		Number number = parseJsonNumber(s);
		if (number == null)
			return null;
		return number.floatValue();
	}

	/**
	 * Parse JSON null
	 *
	 * @param s - character sequence to parse
	 * @return
	 */
	public Object parseJsonNull(CharSequence s) {
		return parseJson(s);
	}

	/**
	 * Parse JSON object
	 *
	 * @param cs - character sequence to parse
	 * @return   - Object
	 */
	public static Object parseJson(CharSequence cs) {
		String s = cs.toString();
		s = s.trim();
		char c1 = s.charAt(0);
		char c2 = s.charAt(s.length() - 1);
		if (c1 == '{' && c2 == '}')
			return parseObject(cut(s));
		else if (c1 == '[' && c2 == ']')
			return parseArray(cut(s));
		else if (c1 == '\"' && c2 == '\"')
			return parseString(cut(s));
		else if ("true".equals(s))
			return true;
		else if ("false".equals(s))
			return false;
		else if ("null".equals(s))
			return null;
		else if (s.contains("."))
			return Double.parseDouble(s);
		else
			return Long.parseLong(s);
	}

	/**
	 * Parse JSON string
	 *
	 * @param s - character sequence to parse
	 * @return  - string
	 */
	private static String parseString(CharSequence s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '\\')
				sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * Parse JSON array to list of strings
	 *
	 * @param s - character sequence to parse
	 * @return  - list of strings
	 */
	private static List<String> parseArray(CharSequence s) {
		return parseSeparated(s, ',');
	}

	/**
	 * Parse JSON object to map of strings
	 *
	 * @param s - character sequence to parse
	 * @return  - map of strings
	 */
	private static Map<String, String> parseObject(CharSequence s) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		List<String> keyValuesStrs = parseSeparated(s, ',');
		for (String keyValueStr : keyValuesStrs) {
			List<String> keyValue = parseSeparated(keyValueStr, ':');
			String dirtyKey = keyValue.get(0);
			String key = cut(dirtyKey);
			String value = keyValue.get(1);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * Trim first and last characters
	 *
	 * @param s - character sequence to process
	 * @return  - trimmed string
	 */
	private static String cut(CharSequence s) {
		return s.subSequence(1, s.length() - 1).toString();
	}

	/**
	 * Parse character sequence separated by particular separator
	 * into list of tokens
	 *
	 * @param s         - character sequence to parse
	 * @param separator - separator
	 * @return          - list of tokens
	 */
	private static List<String> parseSeparated(CharSequence s, char separator) {
		List<String> list = new ArrayList<String>();
		boolean string = false;
		int array = 0;
		int object = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//
			if (string) {
				if (c == '"') {
					char cPrev = s.charAt(i - 1);
					if (cPrev == '"')
						string = false;
					else if (cPrev != '\\')
						string = false;
				}
			} else {
				if (c == '"')
					string = true;
			}
			//
			if (!string) {
				if (c == '[')
					array++;
				else if (c == ']')
					array--;
				else if (c == '{')
					object++;
				else if (c == '}')
					object--;
			}
			//
			if (i == s.length() - 1) {
				sb.append(c);
				list.add(sb.toString().trim());
			} else {
				if (c == separator && !string && array == 0 && object == 0) {
					list.add(sb.toString().trim());
					sb = new StringBuilder();
				} else
					sb.append(c);
			}
		}
		return list;
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
