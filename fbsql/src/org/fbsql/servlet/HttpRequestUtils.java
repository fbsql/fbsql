package org.fbsql.servlet;

import static org.fbsql.servlet.StringUtils.q;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtils {

	/**
	 * Converts HTTP headers to JSON-formatted string
	 *
	 * @param request
	 * @return
	 */
	public static String getHttpHeadersJson(HttpServletRequest request) {
		StringBuilder sb    = new StringBuilder();
		boolean       first = true;
		sb.append('{');
		for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();) {
			String header = e.nextElement();
			String value  = request.getHeader(header);
			if (first)
				first = false;
			else
				sb.append(',');
			sb.append(q(header) + ':' + q(value));
		}
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Converts cookies array to JSON-formatted string
	 *
	 * @param request
	 * @return
	 */
	public static String getCookiesJson(Cookie[] cookies) {
		if (cookies == null)
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < cookies.length; i++) {
			if (i != 0)
				sb.append(',');
			Cookie cookie = cookies[i];
			sb.append("{");
			sb.append(q("name")).append(':').append(cookie.getName() == null ? "null" : q(cookie.getName())).append(',');
			sb.append(q("value")).append(':').append(cookie.getValue() == null ? "null" : q(cookie.getValue()));
			sb.append("}");
		}
		sb.append(']');
		return sb.toString();
	}

}
