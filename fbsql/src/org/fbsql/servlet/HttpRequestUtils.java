package org.fbsql.servlet;

import static org.fbsql.servlet.StringUtils.q;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpRequestUtils {

	/**
	 * Converts HTTP headers to JSON-formatted string
	 *
	 * @param request
	 * @return
	 */
	public static CharSequence getHttpHeadersJson(HttpServletRequest request) {
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
		return sb;
	}

	/**
	 * Converts cookies array to JSON-formatted string
	 *
	 * @param request
	 * @return
	 */
	public static CharSequence getCookiesJson(Cookie[] cookies) {
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
		return sb;
	}

	/**
	 * Converts session attributes to JSON-formatted string
	 *
	 * @param request
	 * @param encoder
	 * @return
	 * @throws SQLException
	 */
	public static CharSequence generateSessionInfoJson(HttpServletRequest request, Base64.Encoder encoder) throws SQLException {
		HttpSession session                 = request.getSession(false);
		String      sessionId               = session.getId();
		long        sessionCreationTime     = session.getCreationTime();
		long        sessionLastAccessedTime = session.getLastAccessedTime();

		final char COLON = ':';
		final char COMMA = ',';

		Enumeration<String> attributeNames = session.getAttributeNames();
		StringBuilder       sb             = new StringBuilder();
		sb.append('{');
		sb.append(q("id")).append(COLON).append(q(sessionId)).append(COMMA);
		sb.append(q("creationTime")).append(COLON).append(Long.toString(sessionCreationTime)).append(COMMA);
		sb.append(q("lastAccessedTime")).append(COLON).append(Long.toString(sessionLastAccessedTime)).append(COMMA);
		sb.append(q("attributes")).append(COLON);
		sb.append('{');
		boolean first = true;
		while (attributeNames.hasMoreElements()) {
			String name   = attributeNames.nextElement();
			Object value  = session.getAttribute(name);
			String svalue = QueryUtils.valueToJsonString(value, encoder);
			if (first)
				first = false;
			else
				sb.append(COMMA);
			sb.append(q(name) + COLON + svalue);
		}
		sb.append('}');
		sb.append('}');
		return sb;
	}

}
