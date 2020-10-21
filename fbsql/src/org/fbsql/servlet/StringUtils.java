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

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Scanner;

public class StringUtils {

	/**
	 * Escape JSON string
	 *
	 * @param s - source string
	 * @return  - escaped string
	 */
	public static String escapeJson(String s) {
		s = s.replace("\\", "\\\\");
		s = s.replace("\"", "\\\"");
		s = s.replace("\b", "\\b");
		s = s.replace("\f", "\\f");
		s = s.replace("\n", "\\n");
		s = s.replace("\r", "\\r");
		s = s.replace("\t", "\\t");
		return s;
	}

	/**
	 * Format and escape message
	 *
	 * @param s    - source string (message)
	 * @param objs - parameters
	 * @return     - formatted and JSON escaped string
	 */
	public static String formatMessage(String s, Object... objs) {
		return escapeJson(MessageFormat.format(s, objs));
	}

	/**
	 * Wrap string into double quotes
	 * This is a helper method used to build JSON string
	 *
	 * @param s - source string
	 * @return  - quoted string
	 */
	public static String q(String s) {
		return '"' + escapeJson(s) + '"';
	}

	/**
	 * Take given string and replace names like ${myvar} and $[myvar]
	 * with appropriate Java System Properties values or OS environment variables
	 * Syntax ${myvar} is used for Java System Properties values
	 * Syntax  $[myvar] is used for OS environment variables
	 * 
	 * @param s   - source String
	 * @return    - string with replaced values
	 */
	public static String putVars(String s) {
		//
		// replace system properties
		//
		while (true) {
			int pos = s.indexOf("${"); // name begin
			if (pos == -1)
				break;
			String rest     = s.substring(pos + 2);
			int    pos2     = rest.indexOf("}");          // name end
			String varName  = rest.substring(0, pos2);
			String replacer = System.getProperty(varName);
			if (replacer == null)
				throw new IllegalArgumentException(varName);
			s = s.substring(0, pos) + replacer + s.substring(pos + varName.length() + 3);
		}
		//
		// replace OS environment variables
		//
		while (true) {
			int pos = s.indexOf("$["); // name begin
			if (pos == -1)
				break;
			String rest     = s.substring(pos + 2);
			int    pos2     = rest.indexOf("]");      // name end
			String varName  = rest.substring(0, pos2);
			String replacer = System.getenv(varName);
			if (replacer == null)
				throw new IllegalArgumentException(varName);
			s = s.substring(0, pos) + replacer + s.substring(pos + varName.length() + 3);
		}
		return s;
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String readAsText(Path path) {
		try {
			return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return "";
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String unquote(String s) {
		char quote = s.charAt(0);
		if (quote == '\'' || quote == '"')
			return s.substring(1, s.length() - 1).trim();
		return s;
	}

	public static String inputSreamToString(InputStream is) {
		Scanner s = new Scanner(is, StandardCharsets.UTF_8.name()).useDelimiter("\\A");
		return s.hasNext() ? s.next().trim() : "";
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
