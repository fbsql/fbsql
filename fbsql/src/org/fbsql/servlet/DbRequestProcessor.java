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

import static org.fbsql.servlet.SqlParseUtils.JAVA_METHOD_SEPARATOR;
import static org.fbsql.servlet.SqlParseUtils.parseNamedPreparedStatement;
import static org.fbsql.servlet.StringUtils.q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.MessageFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

import javax.servlet.AsyncContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fbsql.connection_pool.ConnectionPoolManager;
import org.fbsql.connection_pool.DbConnection;
import org.fbsql.json.parser.JsonUtils;

import com.blueconic.browscap.BrowsCapField;
import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.UserAgentParser;

/**
 * <p><strong>DbRequestProcessor</strong> contains the processing logic that
 * the @link(DbServlet) performs as it receives each servlet request
 * from the container.</p>
 */

public class DbRequestProcessor implements Runnable {

	/**
	 * SQL NULL constant
	 */
	private static final String SQL_NULL = "NULL"; // SQL NULL constant

	/**
	 * SQL FALSE constant
	 */
	private static final String SQL_FALSE = "0"; // SQL FALSE constant

	/**
	 * SQL TRUE constant
	 */
	private static final String SQL_TRUE = "1"; // SQL TRUE constant

	/**
	 * SQL quote character
	 */
	private static final String SQL_QUOTE_CHAR = "'"; // SQL quote character

	/**
	 * Execute type: query
	 * WARNING! This constant used also in JavaScript part
	 */
	private static final String EXEC_TYPE_QUERY = "Q";

	/**
	 * Execute type: update
	 * WARNING! This constant used also in JavaScript part
	 */
	private static final String EXEC_TYPE_UPDATE = "U";

	private static Map<BrowsCapField, Class<?>> browsCapFieldInfoMap;

	static {
		browsCapFieldInfoMap = new HashMap<>();
		browsCapFieldInfoMap.put(BrowsCapField.IS_MASTER_PARENT, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_LITE_MODE, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.PARENT, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.COMMENT, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER_TYPE, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER_BITS, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER_MAKER, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER_MODUS, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER_VERSION, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER_MAJOR_VERSION, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.BROWSER_MINOR_VERSION, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.PLATFORM, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.PLATFORM_VERSION, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.PLATFORM_DESCRIPTION, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.PLATFORM_BITS, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.PLATFORM_MAKER, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_ALPHA, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_BETA, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_WIN16, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_WIN32, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_WIN64, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_IFRAMES, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_FRAMES, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_TABLES, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_COOKIES, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_BACKGROUND_SOUNDS, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_JAVASCRIPT, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_VBSCRIPT, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_JAVA_APPLETS, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_ACTIVEX_CONTROLS, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_MOBILE_DEVICE, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_TABLET, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_SYNDICATION_READER, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_CRAWLER, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_FAKE, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_ANONYMIZED, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.IS_MODIFIED, Boolean.class);
		browsCapFieldInfoMap.put(BrowsCapField.CSS_VERSION, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.AOL_VERSION, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.DEVICE_NAME, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.DEVICE_MAKER, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.DEVICE_TYPE, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.DEVICE_POINTING_METHOD, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.DEVICE_CODE_NAME, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.DEVICE_BRAND_NAME, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.RENDERING_ENGINE_NAME, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.RENDERING_ENGINE_VERSION, Number.class);
		browsCapFieldInfoMap.put(BrowsCapField.RENDERING_ENGINE_DESCRIPTION, String.class);
		browsCapFieldInfoMap.put(BrowsCapField.RENDERING_ENGINE_MAKER, String.class);
	}

	private static final String IN_ROLE_FUNCTION_TOKEN                    = "IN_ROLE(";
	private static final String GET_COOKIE_FUNCTION_TOKEN                 = "COOKIE(";
	private static final String GET_HTTP_HEADER_AS_CHAR_FUNCTION_TOKEN    = "GET_HTTP_HEADER_AS_CHAR(";
	private static final String GET_HTTP_HEADER_AS_DATE_FUNCTION_TOKEN    = "GET_HTTP_HEADER_AS_DATE(";
	private static final String GET_HTTP_HEADER_AS_INTEGER_FUNCTION_TOKEN = "GET_HTTP_HEADER_AS_INTEGER(";
	private static final String SESSION_ATTRIBUTE_SESSION_JSON            = "SESSION_JSON";
	//
	private String       instanceName;
	private AsyncContext asyncContext;

	private ConnectionInfo        connectionInfo;
	private ConnectionPoolManager connectionPoolManager;

	private List<String /* SQL statement */>                                                               whiteList;      // list of SQL statements
	private List<String /* SQL statement name */>                                                          whiteListNames; // list of SQL statements names
	private Map<String /* stored procedure name */, String /* java method */>                              proceduresMap;
	private Map<String /* SQL statement name */, String /* Validator stored procedure name */ >            validatorsMap;  //
	private Map<String /* SQL statement name */, Collection<String /* Notifier stored procedure name */ >> notifiersMap;   //
	private Map<StaticStatement, ReadyResult>                                                              mapJson;
	private Queue<AsyncContext>                                                                            ongoingRequests;
	private DbServlet.SharedCoder                                                                          sharedCoder;
	private UserAgentParser                                                                                userAgentParser;

	/**
	 * Constructs DbRequestProcessor object
	 * 
	 * @param instanceName
	 * @param asyncCtx
	 * @param connectionInfo
	 * @param connectionPoolManager
	 * @param whiteList
	 * @param whiteListNames
	 * @param validatorsMap
	 * @param notifiersMap
	 * @param mapJson
	 * @param ongoingRequests
	 * @param sharedCoder
	 */
	public DbRequestProcessor( //
			String instanceName, //
			AsyncContext asyncCtx, //
			ConnectionInfo connectionInfo, //
			ConnectionPoolManager connectionPoolManager, //
			List<String /* SQL statement */> whiteList, // list of SQL statements
			List<String /* SQL statement name */> whiteListNames, // list of SQL statements names
			Map<String /* stored procedure name */, String /* java method */> proceduresMap, //
			Map<String /* SQL statement name */, String /* Validator stored procedure name */ > validatorsMap, //
			Map<String /* SQL statement name */, Collection<String /* Notifier stored procedure name */ >> notifiersMap, //
			Map<StaticStatement, ReadyResult> mapJson, //
			Queue<AsyncContext> ongoingRequests, //
			DbServlet.SharedCoder sharedCoder, //
			UserAgentParser userAgentParser //
	) {
		this.instanceName          = instanceName;
		this.asyncContext          = asyncCtx;
		this.connectionInfo        = connectionInfo;
		this.connectionPoolManager = connectionPoolManager;
		this.whiteList             = whiteList;            // list of SQL statements
		this.whiteListNames        = whiteListNames;       // list of SQL statements names
		this.proceduresMap         = proceduresMap;
		this.validatorsMap         = validatorsMap;
		this.notifiersMap          = notifiersMap;
		this.mapJson               = mapJson;
		this.ongoingRequests       = ongoingRequests;
		this.sharedCoder           = sharedCoder;
		this.userAgentParser       = userAgentParser;
	}

	/**
	 * Implementation of Runnable.run() method
	 * 
	 * Overview of request processor logic
	 * - Parse request body
	 * - Check SQL statement against white list (list of allowed SQL statements)
	 * - Execut SQL statement if allowed
	 */
	@Override
	public void run() {
		HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
		try {
			HttpServletRequest request        = (HttpServletRequest) asyncContext.getRequest();
			String             etagFromClient = request.getHeader("If-None-Match");

			String      remoteUser  = (String) request.getAttribute(DbServlet.REQUEST_ATTRIBUTE_USER);
			String      remoteRole  = request.getHeader(DbServlet.CUSTOM_HTTP_HEADER_ROLE);
			Cookie[]    cookies     = request.getCookies();
			String      cookiesJson = getCookiesJson(cookies);
			HttpSession session     = request.getSession(false);

			String sessionId;
			Long   sessionCreationTime;
			Long   sessionLastAccessedTime;
			String sessionAttributesJson;

			if (session == null) {
				sessionId               = null;
				sessionCreationTime     = null;
				sessionLastAccessedTime = null;
				sessionAttributesJson   = null;
			} else {
				sessionId               = session.getId();
				sessionCreationTime     = session.getCreationTime();
				sessionLastAccessedTime = session.getLastAccessedTime();

				sessionAttributesJson = (String) session.getAttribute(SESSION_ATTRIBUTE_SESSION_JSON);
				if (sessionAttributesJson == null)
					sessionAttributesJson = "{}";
			}

			//
			boolean reject        = false;
			String  rejectMessage = null;
			String  rejectJson    = null;
			//
			String              clientInfoJson  = getClientInfo(request, sharedCoder.decoder);
			BufferedReader      br              = getCustomDataReader(request, sharedCoder.decoder);
			String              jsonLine        = br.readLine();
			Map<String, String> bodyMap         = JsonUtils.parseJsonObject(jsonLine);
			String              statementId     = (String) JsonUtils.parseJson(bodyMap.get("statementId"));
			String              execType        = (String) JsonUtils.parseJson(bodyMap.get("execType"));
			String              jsonStrFormat   = bodyMap.get("format");
			Integer             resultSetFormat = JsonUtils.parseJsonInt(jsonStrFormat);
			String              parameters      = bodyMap.get("parameters");
			String              userInfoJson    = generateUserInfoJson(                                    //
					request,                                                                               //
					userAgentParser,                                                                       //
					clientInfoJson                                                                         //
			);

			String updateResultJson = null;

			String  paramJsonArray;
			boolean batch;
			if (parameters.startsWith("[")) {
				batch          = true;
				paramJsonArray = parameters;
			} else {
				batch          = false;
				paramJsonArray = '[' + parameters + ']';
			}

			List<String> paramJsons = JsonUtils.parseJsonArray(paramJsonArray);

			boolean executeTypeQuery  = execType.equals(EXEC_TYPE_QUERY);
			boolean executeTypeUpdate = execType.equals(EXEC_TYPE_UPDATE);

			if (reject) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				try (OutputStream os = response.getOutputStream()) {
					os.write(("{" + q("message") + ":" + q(rejectMessage) + "}").getBytes(StandardCharsets.UTF_8));
					os.flush();
				}
				asyncContext.complete();
				return;
			}
			//
			String unprocessedNamedPreparedStatement = null;
			String namedPreparedStatement            = null;
			if (statementId == null) { // SQL statement provided
				StringBuilder unprocessedNamedPreparedStatementSb = new StringBuilder();
				while (true) {
					String line = br.readLine();
					if (line == null)
						break;
					unprocessedNamedPreparedStatementSb.append(' ' + line.trim() + '\n');
				}
				unprocessedNamedPreparedStatement = unprocessedNamedPreparedStatementSb.toString().trim();
				namedPreparedStatement            = SqlParseUtils.processStatement(unprocessedNamedPreparedStatement);
				if (whiteList == null)
					reject = false;
				else {
					int sqlIndex = whiteList.indexOf(namedPreparedStatement);
					reject = sqlIndex == -1;
					if (reject)
						rejectMessage = StringUtils.escapeJson(MessageFormat.format("Rejected. SQL statement \"{0}\" not found in white list", namedPreparedStatement));
					else
						statementId = whiteListNames.get(sqlIndex);
				}
			} else { // SQL statement name provided
				reject = whiteListNames == null || !whiteListNames.contains(statementId);
				if (reject)
					rejectMessage = StringUtils.escapeJson(MessageFormat.format("Rejected. SQL statement name: ''{0}'' not found", statementId));
				else {
					int sqlIndex = whiteListNames.indexOf(statementId);
					namedPreparedStatement            = whiteList.get(sqlIndex);
					unprocessedNamedPreparedStatement = namedPreparedStatement;
				}
			}
			if (connectionInfo.allowStatementsQuery != null) {
				//
				// parameters of custom "SET ALLOW STATEMENTS IF EXISTS" SQL statement
				//
				Map<String, Object> paramsMap = new HashMap<>();
				paramsMap.put("statement_id", statementId); // :statement_id parameter
				paramsMap.put("statement", unprocessedNamedPreparedStatement); // :statement parameter
				paramsMap.put("user", remoteUser); // :user parameter
				paramsMap.put("role", remoteRole); // :role parameter

				DbConnection dbConnection = null;
				try {
					dbConnection = connectionPoolManager.getConnection();
					StringBuilder preparedStatementSb = new StringBuilder();

					Map<String /* name */, List<Integer /* index */>> paramsIndexes        = parseNamedPreparedStatement(connectionInfo.allowStatementsQuery, preparedStatementSb);
					String                                            preparedStatementSql = preparedStatementSb.toString();
					PreparedStatement                                 ps;
					if (preparedStatementSql.startsWith("{") && preparedStatementSql.endsWith("}"))
						ps = dbConnection.getCallableStatement(preparedStatementSql);
					else
						ps = dbConnection.getPreparedStatement(preparedStatementSql);
					ParameterMetaData pmd = ps.getParameterMetaData();

					for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
						String                    name    = entry.getKey();
						Object                    value   = entry.getValue();
						List<Integer /* index */> indexes = paramsIndexes.get(name);
						if (indexes != null)
							for (int n : indexes) {
								int parameterType = pmd.getParameterType(n);
								if (value == null)
									ps.setNull(n, parameterType);
								else
									ps.setString(n, value.toString());
							}
					}
					boolean allow = false;
					try (ResultSet rs = ps.executeQuery()) {
						allow = rs.next();
					} finally {
						if (!allow) {
							reject        = true;
							rejectMessage = StringUtils.escapeJson(MessageFormat.format("Rejected. SQL statement \"{0}\" not allowed for role \"{1}\"", namedPreparedStatement, remoteRole));
						}
					}
				} finally {
					if (dbConnection != null)
						connectionPoolManager.releaseConnection(dbConnection);
				}
			}
			List<Map<String, Object>> parametersListOfMaps = new ArrayList<>(paramJsons.size());
			for (String paramJson : paramJsons) {
				String validatorStoredProcedureName = validatorsMap.get(statementId);
				if (validatorStoredProcedureName != null) {
					String statementInfoJson = generateStatementInfoJson( //
							instanceName, //
							statementId, //
							unprocessedNamedPreparedStatement, //
							paramJson //
					);

					DbConnection dbConnection0      = null;
					String       modifiedParamsJson = null;
					try {
						dbConnection0 = connectionPoolManager.getConnection();

						String javaMethod = proceduresMap.get(validatorStoredProcedureName);
						if (javaMethod == null) {
							CallableStatement cs = dbConnection0.getCallableStatement("{call " + validatorStoredProcedureName + "(?,?)}");
							cs.setString(1, userInfoJson);
							cs.setString(2, statementInfoJson);

							try (ResultSet rs = cs.executeQuery()) {
								if (rs.next())
									modifiedParamsJson = rs.getString(1);
							}
						} else {
							String[] array      = javaMethod.split(JAVA_METHOD_SEPARATOR);
							String   className  = array[0];
							String   methodName = array[1];

							Class<?> clazz  = Class.forName(className);
							Method   method = clazz.getMethod(methodName, Connection.class, String.class, String.class);
							modifiedParamsJson = (String) method.invoke(null, request, dbConnection0.getConnection(), userInfoJson, statementInfoJson);
						}
					} finally {
						if (dbConnection0 != null)
							connectionPoolManager.releaseConnection(dbConnection0);
						if (modifiedParamsJson == null) { // reject if stored procedure return null
							reject        = true;
							rejectMessage = StringUtils.escapeJson(MessageFormat.format("Rejected. SQL statement \"{0}\". Bad parameters: \"{1}\"", namedPreparedStatement, paramJson));
						} else
							paramJson = modifiedParamsJson.trim();
					}
				}

				Map<String, String> parametersJsonStrs = JsonUtils.parseJsonObject(paramJson);
				Map<String, Object> parametersMap      = new LinkedHashMap<>(parametersJsonStrs.size());
				for (Map.Entry<String, String> parameterNameValueEntry : parametersJsonStrs.entrySet()) {
					String pname      = parameterNameValueEntry.getKey();
					String pvalueJson = parameterNameValueEntry.getValue();
					Object pvalueObj  = JsonUtils.parseJson(pvalueJson);
					parametersMap.put(pname, pvalueObj);
				}
				parametersListOfMaps.add(parametersMap);
			}

			if (reject) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				try (OutputStream os = response.getOutputStream()) {
					os.write(('{' + q("message") + ':' + q(rejectMessage) + ',' + q("rejectObject") + ':' + rejectJson + '}').getBytes(StandardCharsets.UTF_8));
					os.flush();
				}
				asyncContext.complete();
				return;
			}

			StringBuilder                                     preparedStatementSb = new StringBuilder();
			Map<String /* name */, List<Integer /* index */>> mapParams           = SqlParseUtils.parseNamedPreparedStatement(namedPreparedStatement, preparedStatementSb);
			String                                            preparedStatement   = preparedStatementSb.toString();

			//
			// Replace built-in functions with values
			//
			preparedStatement = preparedStatement.replace("REMOTE_USER()", remoteUser == null ? SQL_NULL : SQL_QUOTE_CHAR + remoteUser + SQL_QUOTE_CHAR);
			preparedStatement = preparedStatement.replace("REMOTE_ROLE()", remoteRole == null ? SQL_NULL : SQL_QUOTE_CHAR + remoteRole + SQL_QUOTE_CHAR);

			preparedStatement = preparedStatement.replace("REMOTE_SESSION_ID()", sessionId == null ? SQL_NULL : SQL_QUOTE_CHAR + sessionId + SQL_QUOTE_CHAR);
			preparedStatement = preparedStatement.replace("REMOTE_SESSION_CREATION_TIME()", sessionCreationTime == null ? SQL_NULL : Long.toString(sessionCreationTime));
			preparedStatement = preparedStatement.replace("REMOTE_SESSION_LAST_ACCESSED_TIME()", sessionLastAccessedTime == null ? SQL_NULL : Long.toString(sessionLastAccessedTime));
			preparedStatement = preparedStatement.replace("REMOTE_SESSION_ATTRIBUTES()", sessionAttributesJson == null ? SQL_NULL : SQL_QUOTE_CHAR + sessionAttributesJson + SQL_QUOTE_CHAR);

			preparedStatement = preparedStatement.replace("USER_INFO()", userInfoJson == null ? SQL_NULL : SQL_QUOTE_CHAR + userInfoJson + SQL_QUOTE_CHAR);

			//			preparedStatement = preparedStatement.replace("REMOTE_INFO()", SQL_QUOTE_CHAR + remoteInfoJson + SQL_QUOTE_CHAR);
			//			preparedStatement = preparedStatement.replace("CLIENT_INFO()", SQL_QUOTE_CHAR + clientInfoJson + SQL_QUOTE_CHAR);
			//			preparedStatement = preparedStatement.replace("COOKIES()", SQL_QUOTE_CHAR + cookiesJson + SQL_QUOTE_CHAR);

			//
			// TODO Implement COOKIE('name') function
			//

			//
			// Replace IN_ROLE() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, IN_ROLE_FUNCTION_TOKEN);
				if (offset == -1)
					break;
				int     pos1   = offset + IN_ROLE_FUNCTION_TOKEN.length();
				char    quote  = preparedStatement.charAt(pos1);          // get single «'» or double «"» quote
				String  s      = preparedStatement.substring(pos1 + 1);
				int     pos2   = s.indexOf(quote);
				String  role   = s.substring(0, pos2);
				boolean inRole = request.isUserInRole(role);
				if (!inRole)
					inRole = role.equals(remoteRole);
				preparedStatement = preparedStatement.substring(0, offset) + (inRole ? SQL_TRUE : SQL_FALSE) + preparedStatement.substring(pos1 + role.length() + 3);
			}

			//
			// Replace COOKIE() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, GET_COOKIE_FUNCTION_TOKEN);
				if (offset == -1)
					break;
				int    pos1       = offset + GET_COOKIE_FUNCTION_TOKEN.length();
				char   quote      = preparedStatement.charAt(pos1);             // get single «'» or double «"» quote
				String s          = preparedStatement.substring(pos1 + 1);
				int    pos2       = s.indexOf(quote);
				String cookieName = s.substring(0, pos2);
				String value      = null;
				for (Cookie cookie : cookies) {
					if (cookieName.equals(cookie.getName())) {
						value = cookie.getValue();
						break;
					}
				}
				preparedStatement = preparedStatement.substring(0, offset) + (value == null ? SQL_NULL : SQL_QUOTE_CHAR + value + SQL_QUOTE_CHAR) + preparedStatement.substring(pos1 + cookieName.length() + 3);
			}

			//
			// Replace GET_HTTP_HEADER_AS_CHAR() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, GET_HTTP_HEADER_AS_CHAR_FUNCTION_TOKEN);
				if (offset == -1)
					break;
				int    pos1       = offset + GET_HTTP_HEADER_AS_CHAR_FUNCTION_TOKEN.length();
				char   quote      = preparedStatement.charAt(pos1);                          // get single «'» or double «"» quote
				String s          = preparedStatement.substring(pos1 + 1);
				int    pos2       = s.indexOf(quote);
				String headerName = s.substring(0, pos2);
				String header     = request.getHeader(headerName);
				preparedStatement = preparedStatement.substring(0, offset) + (header == null ? SQL_NULL : SQL_QUOTE_CHAR + header + SQL_QUOTE_CHAR) + preparedStatement.substring(pos1 + headerName.length() + 3);
			}

			//
			// Replace GET_HTTP_HEADER_AS_INTEGER() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, GET_HTTP_HEADER_AS_INTEGER_FUNCTION_TOKEN);
				if (offset == -1)
					break;
				int    pos1       = offset + GET_HTTP_HEADER_AS_INTEGER_FUNCTION_TOKEN.length();
				char   quote      = preparedStatement.charAt(pos1);                             // get single «'» or double «"» quote
				String s          = preparedStatement.substring(pos1 + 1);
				int    pos2       = s.indexOf(quote);
				String headerName = s.substring(0, pos2);
				int    header     = request.getIntHeader(headerName);
				preparedStatement = preparedStatement.substring(0, offset) + (header == -1 ? SQL_NULL : header) + preparedStatement.substring(pos1 + headerName.length() + 3);
			}

			//
			// Replace GET_HTTP_HEADER_AS_DATE() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, GET_HTTP_HEADER_AS_DATE_FUNCTION_TOKEN);
				if (offset == -1)
					break;
				int    pos1       = offset + GET_HTTP_HEADER_AS_DATE_FUNCTION_TOKEN.length();
				char   quote      = preparedStatement.charAt(pos1);                          // get single «'» or double «"» quote
				String s          = preparedStatement.substring(pos1 + 1);
				int    pos2       = s.indexOf(quote);
				String headerName = s.substring(0, pos2);
				long   header     = request.getDateHeader(headerName);
				preparedStatement = preparedStatement.substring(0, offset) + (header == -1 ? SQL_NULL : header) + preparedStatement.substring(pos1 + headerName.length() + 3);
			}

			ReadyResult readyResult = mapJson.get(new StaticStatement(preparedStatement, resultSetFormat));
			String      etag        = null;
			boolean     compressed  = false;
			byte[]      bs          = null;

			if (readyResult == null) {
				DbConnection dbConnection = connectionPoolManager.getConnection();

				Method method = CallUtils.getCallStatementMethod(unprocessedNamedPreparedStatement, proceduresMap);
				if (method != null) {
					if (executeTypeUpdate) {
						int rowCount = 0;
						for (Map<String, Object> parametersMap : parametersListOfMaps) {
							List<Object> parameterValues = new ArrayList<>();
							parameterValues.add(request);
							parameterValues.add(dbConnection.getConnection());
							CallUtils.getCallStatementParameterValues(unprocessedNamedPreparedStatement, parametersMap, parameterValues);
							method.invoke(null, parameterValues.toArray(new Object[parameterValues.size()]));
							rowCount++;
						}
						bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
					} else if (executeTypeQuery) {
						Map<String, Object> parametersMap   = parametersListOfMaps.get(0);
						List<Object>        parameterValues = new ArrayList<>();
						parameterValues.add(request);
						parameterValues.add(dbConnection.getConnection());
						CallUtils.getCallStatementParameterValues(unprocessedNamedPreparedStatement, parametersMap, parameterValues);
						try (ResultSet rs = (ResultSet) method.invoke(null, parameterValues.toArray(new Object[parameterValues.size()]))) {
							Integer                                                        compression       = connectionInfo.compressionLevel == null ? QueryUtils.COMPRESSION_NONE : connectionInfo.compressionLevel;
							List<Map<String /* column name */, Object /* column value */>> resultsListOfMaps = QueryUtils.resutlSetToListOfMaps(rs);
							List<Map<String /* column name */, String /* JSON value */>>   list              = QueryUtils.listOfMapsToListOfMapsJsonValues(resultsListOfMaps, sharedCoder.encoder);

							ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
							bs         = rr.bs;
							etag       = rr.etag;
							compressed = rr.compressed;
						} finally {
							if (dbConnection != null)
								connectionPoolManager.releaseConnection(dbConnection);
						}
					}
				} else if (SqlParseUtils.indexOf(preparedStatement, SqlParseUtils.SPECIAL_STATEMENT_CREATE_SESSION) == 0) {
					if (executeTypeUpdate) { // Execute Update
						int rowCount;
						if (session == null) {
							rowCount                = 1;
							session                 = request.getSession();
							sessionId               = session.getId();
							sessionCreationTime     = session.getCreationTime();
							sessionLastAccessedTime = session.getLastAccessedTime();
						} else
							rowCount = 0;

						bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
					} else {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						try (OutputStream os = response.getOutputStream()) {
							os.write(("{" + q("message") + ":" + q(SqlParseUtils.SPECIAL_STATEMENT_CREATE_SESSION + " require PreparedStatement.executeUpdate() method") + "}").getBytes(StandardCharsets.UTF_8));
							os.flush();
						}
						asyncContext.complete();
						return;
					}

				} else if (SqlParseUtils.indexOf(preparedStatement, SqlParseUtils.SPECIAL_STATEMENT_INVALIDATE_SESSION) == 0) {
					if (executeTypeUpdate) { // Execute Update
						int rowCount;
						if (session == null)
							rowCount = 0;
						else {
							rowCount = 1;
							session.invalidate();
						}
						bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
					} else {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						try (OutputStream os = response.getOutputStream()) {
							os.write(("{" + q("message") + ":" + q(SqlParseUtils.SPECIAL_STATEMENT_INVALIDATE_SESSION + " require PreparedStatement.executeUpdate() method") + "}").getBytes(StandardCharsets.UTF_8));
							os.flush();
						}
						asyncContext.complete();
						return;
					}

				} else if (SqlParseUtils.indexOf(preparedStatement, SqlParseUtils.SPECIAL_STATEMENT_SET_SESSION_ATTRIBUTES) == 0) {
					if (executeTypeUpdate) { // Execute Update
						int rowCount;
						if (session == null)
							rowCount = 0;
						else {
							rowCount = 1;
							session.setAttribute(SESSION_ATTRIBUTE_SESSION_JSON, paramJsons.get(0));
						}
						bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
					} else {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						try (OutputStream os = response.getOutputStream()) {
							os.write(("{" + q("message") + ":" + q(SqlParseUtils.SPECIAL_STATEMENT_SET_SESSION_ATTRIBUTES + " require PreparedStatement.executeUpdate() method") + "}").getBytes(StandardCharsets.UTF_8));
							os.flush();
						}
						asyncContext.complete();
						return;
					}
				} else if (SqlParseUtils.indexOf(preparedStatement, SqlParseUtils.SPECIAL_STATEMENT_GET_SESSION_ATTRIBUTES) == 0) {
					if (executeTypeQuery) { // Execute Query
						String sessionJson;
						if (session == null)
							sessionJson = "{}";
						else {
							sessionJson = (String) session.getAttribute(SESSION_ATTRIBUTE_SESSION_JSON);
							if (sessionJson == null)
								sessionJson = "{}";
						}
						String                                                       sessionJsons = '[' + sessionJson + ']';
						Integer                                                      compression  = connectionInfo.compressionLevel == null ? QueryUtils.COMPRESSION_NONE : connectionInfo.compressionLevel;
						List<String /* JSON object */ >                              jsonObjStrs  = JsonUtils.parseJsonArray(sessionJsons);
						List<Map<String /* column name */, String /* JSON value */>> list         = new ArrayList<>(jsonObjStrs.size());
						for (String jsonObjStr : jsonObjStrs) {
							Map<String /* column name */, String /* JSON value */> map = JsonUtils.parseJsonObject(jsonObjStr);
							list.add(map);
						}
						ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
						bs         = rr.bs;
						etag       = rr.etag;
						compressed = rr.compressed;
					} else {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						try (OutputStream os = response.getOutputStream()) {
							os.write(("{" + q("message") + ":" + q(SqlParseUtils.SPECIAL_STATEMENT_GET_SESSION_ATTRIBUTES + " require PreparedStatement.executeQuery() method") + "}").getBytes(StandardCharsets.UTF_8));
							os.flush();
						}
						asyncContext.complete();
						return;
					}
				} else if (SqlParseUtils.indexOf(preparedStatement, SqlParseUtils.SPECIAL_STATEMENT_GET_SESSION_INFO) == 0) {
					if (executeTypeQuery) { // Execute Query
						String sessionJson;
						if (session == null)
							sessionJson = "{}";
						else {
							sessionJson = '{' + //
									q("SESSION_ID") + ':' + q(sessionId) + ',' + //
									q("SESSION_CREATION_TIME") + ':' + sessionCreationTime + ',' + //
									q("SESSION_LAST_ACCESSED_TIME") + ':' + sessionLastAccessedTime + //
									'}';
						}
						String                                                       sessionJsons = '[' + sessionJson + ']';
						Integer                                                      compression  = connectionInfo.compressionLevel == null ? QueryUtils.COMPRESSION_NONE : connectionInfo.compressionLevel;
						List<String /* JSON object */ >                              jsonObjStrs  = JsonUtils.parseJsonArray(sessionJsons);
						List<Map<String /* column name */, String /* JSON value */>> list         = new ArrayList<>(jsonObjStrs.size());
						for (String jsonObjStr : jsonObjStrs) {
							Map<String /* column name */, String /* JSON value */> map = JsonUtils.parseJsonObject(jsonObjStr);
							list.add(map);
						}
						ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
						bs         = rr.bs;
						etag       = rr.etag;
						compressed = rr.compressed;
					} else {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						try (OutputStream os = response.getOutputStream()) {
							os.write(("{" + q("message") + ":" + q(SqlParseUtils.SPECIAL_STATEMENT_GET_SESSION_INFO + " require PreparedStatement.executeQuery() method") + "}").getBytes(StandardCharsets.UTF_8));
							os.flush();
						}
						asyncContext.complete();
						return;
					}
				} else if (SqlParseUtils.indexOf(preparedStatement, SqlParseUtils.SPECIAL_STATEMENT_ADD_COOKIES) == 0) {
					if (executeTypeUpdate) { // Execute Update
						for (String paramJson : paramJsons) {
							Map<String, Object> map = (Map<String, Object>) JsonRhinoUtils.toObject(paramJson);

							String  name     = (String) map.get("name");
							String  value    = (String) map.get("value");
							String  comment  = (String) map.get("comment");
							String  domain   = (String) map.get("domain");
							String  path     = (String) map.get("path");
							Integer maxAge   = (Integer) map.get("maxAge");
							Integer version  = (Integer) map.get("version");
							Boolean secure   = (Boolean) map.get("secure");
							Boolean httpOnly = (Boolean) map.get("httpOnly");

							Cookie cookie = new Cookie(name, value);
							if (comment != null)
								cookie.setComment(comment);
							if (domain != null)
								cookie.setDomain(domain);
							if (path != null)
								cookie.setPath(path);
							if (maxAge != null)
								cookie.setMaxAge(maxAge);
							if (version != null)
								cookie.setVersion(version);
							if (secure != null)
								cookie.setSecure(secure);
							if (httpOnly != null)
								cookie.setHttpOnly(httpOnly);

							response.addCookie(cookie);
						}
						int rowCount = paramJsons.size();
						bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
					} else {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						try (OutputStream os = response.getOutputStream()) {
							os.write(("{" + q("message") + ":" + q(SqlParseUtils.SPECIAL_STATEMENT_SET_SESSION_ATTRIBUTES + " require PreparedStatement.executeUpdate() method") + "}").getBytes(StandardCharsets.UTF_8));
							os.flush();
						}
						asyncContext.complete();
						return;
					}
				} else if (SqlParseUtils.indexOf(preparedStatement, SqlParseUtils.SPECIAL_STATEMENT_GET_COOKIES) == 0) {
					if (executeTypeQuery) { // Execute Query
						Integer                                                      compression = connectionInfo.compressionLevel == null ? QueryUtils.COMPRESSION_NONE : connectionInfo.compressionLevel;
						List<String /* JSON object */ >                              jsonObjStrs = JsonUtils.parseJsonArray(cookiesJson);
						List<Map<String /* column name */, String /* JSON value */>> list        = new ArrayList<>(jsonObjStrs.size());
						for (String jsonObjStr : jsonObjStrs) {
							Map<String /* column name */, String /* JSON value */> map = JsonUtils.parseJsonObject(jsonObjStr);
							list.add(map);
						}
						ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
						bs         = rr.bs;
						etag       = rr.etag;
						compressed = rr.compressed;
					} else {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						try (OutputStream os = response.getOutputStream()) {
							os.write(("{" + q("message") + ":" + q(SqlParseUtils.SPECIAL_STATEMENT_GET_SESSION_INFO + " require PreparedStatement.executeQuery() method") + "}").getBytes(StandardCharsets.UTF_8));
							os.flush();
						}
						asyncContext.complete();
						return;
					}
				} else {
					try {
						if (connectionInfo.debug) {
							System.out.println("Statement was delegated to underlying database:");
							System.out.println(unprocessedNamedPreparedStatement);
						}
						PreparedStatement ps  = dbConnection.getPreparedStatement(preparedStatement);
						ParameterMetaData pmd = ps.getParameterMetaData();
						for (Map<String, Object> parametersMap : parametersListOfMaps) {
							for (Map.Entry<String, Object> parameterMapEntry : parametersMap.entrySet()) {
								String pname     = parameterMapEntry.getKey();
								Object pvalueObj = parameterMapEntry.getValue();
								String pvalue    = pvalueObj == null ? null : pvalueObj.toString();

								List<Integer /* index */> indexes = mapParams.get(pname);
								if (indexes != null)
									for (int n : indexes) {
										int parameterType = pmd.getParameterType(n);
										if (pvalue == null) // JavaScript null
											ps.setNull(n, parameterType);
										else {
											if (parameterType == Types.SMALLINT) // JavaScript Number
												ps.setShort(n, Short.parseShort(pvalue));
											else if (parameterType == Types.INTEGER) // JavaScript Number
												ps.setInt(n, Integer.parseInt(pvalue));
											else if (parameterType == Types.BIGINT) // JavaScript Number
												ps.setLong(n, Long.parseLong(pvalue));
											else if (parameterType == Types.FLOAT) // JavaScript Number
												ps.setFloat(n, Float.parseFloat(pvalue));
											else if (parameterType == Types.DOUBLE) // JavaScript Number
												ps.setDouble(n, Double.parseDouble(pvalue));
											else if (parameterType == Types.BOOLEAN || parameterType == Types.BIT) // JavaScript Boolean
												ps.setBoolean(n, Boolean.parseBoolean(pvalue));
											else if (parameterType == Types.DATE) {
												if (pvalue.contains("T")) { // JavaScript Date
													Instant   instant = Instant.parse(pvalue);
													Timestamp ts      = Timestamp.from(instant);
													long      time    = ts.getTime();
													ps.setDate(n, new Date(time));
												} else if (pvalue.contains("-")) // JavaScript String
													ps.setString(n, pvalue);
												else if (pvalue.charAt(0) > '0' && pvalue.charAt(0) <= '9') // JavaScript Number
													ps.setDate(n, new Date(Long.parseLong(pvalue)));
												else
													ps.setString(n, pvalue);
											} else if (parameterType == Types.TIME) {
												if (pvalue.contains("T")) { // JavaScript Date
													Instant   instant = Instant.parse(pvalue);
													Timestamp ts      = Timestamp.from(instant);
													ps.setTime(n, new Time(ts.getTime()));
												} else if (pvalue.contains(":")) // JavaScript String
													ps.setString(n, pvalue);
												else if (pvalue.charAt(0) > '0' && pvalue.charAt(0) <= '9') // JavaScript Number
													ps.setTime(n, new Time(Long.parseLong(pvalue)));
												else
													ps.setString(n, pvalue);
											} else if (parameterType == Types.TIMESTAMP) {
												if (pvalue.contains("T")) { // JavaScript Date
													Instant   instant = Instant.parse(pvalue);
													Timestamp ts      = Timestamp.from(instant);
													ps.setTimestamp(n, ts);
												} else if (pvalue.charAt(0) > '0' && pvalue.charAt(0) <= '9') // JavaScript Number
													ps.setTime(n, new Time(Long.parseLong(pvalue)));
												else
													ps.setString(n, pvalue);
											} else if (parameterType == Types.BINARY || parameterType == Types.VARBINARY || parameterType == Types.LONGVARBINARY) { // JavaScript ArrayBuffer
												pvalue = extractData(pvalue);
												ps.setBytes(n, sharedCoder.decoder.decode(pvalue));
											} else if (parameterType == Types.BLOB) { // JavaScript ArrayBuffer converted to BASE64 at client side and stored in BLOB "AS IS" (as BASE64 string)
												pvalue = extractData(pvalue);
												Blob blob = ps.getConnection().createBlob();
												blob.setBytes(1L, sharedCoder.decoder.decode(pvalue));
												ps.setBlob(n, blob);
											} else if (parameterType == Types.CLOB) { // JavaScript string stored in CLOB "AS IS" (as String)
												Clob clob = ps.getConnection().createClob();
												clob.setString(1L, pvalue);
												ps.setClob(n, clob);
											} else // unknown
												ps.setString(n, pvalue);
										}
									}
							}
							if (executeTypeUpdate)
								ps.addBatch();
						}
						//
						if (executeTypeQuery) { // Execute Query
							try (ResultSet rs = ps.executeQuery()) {
								Integer                                                        compression       = connectionInfo.compressionLevel == null ? QueryUtils.COMPRESSION_NONE : connectionInfo.compressionLevel;
								List<Map<String /* column name */, Object /* column value */>> resultsListOfMaps = QueryUtils.resutlSetToListOfMaps(rs);
								List<Map<String /* column name */, String /* JSON value */>>   list              = QueryUtils.listOfMapsToListOfMapsJsonValues(resultsListOfMaps, sharedCoder.encoder);

								ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
								bs         = rr.bs;
								etag       = rr.etag;
								compressed = rr.compressed;
							} finally {
								if (dbConnection != null)
									connectionPoolManager.releaseConnection(dbConnection);
							}

						} else if (executeTypeUpdate) { // Execute Update
							List<Map<String /* column name */, Object /* JSON value */>> gkList;
							int[]                                                        rowCounts = ps.executeBatch();
							try (ResultSet rsgk = ps.getGeneratedKeys()) {
								if (rsgk == null)
									gkList = Collections.emptyList();
								else
									gkList = QueryUtils.resutlSetToListOfMaps(rsgk);
							} catch (Throwable e) {
								e.printStackTrace();
								gkList = Collections.emptyList();
							} finally {
								if (dbConnection != null)
									connectionPoolManager.releaseConnection(dbConnection);
							}

							List<Map<String /* column name */, String /* JSON value */>> generatedKeys = QueryUtils.listOfMapsToListOfMapsJsonValues(gkList, sharedCoder.encoder);

							//
							// Build executeUpdate result JSON
							//

							StringBuilder resultSb = new StringBuilder();
							resultSb.append('{');
							resultSb.append(q("rowCount"));
							resultSb.append(':');
							resultSb.append(batch ? Arrays.toString(rowCounts).replace(" ", "") : Integer.toString(rowCounts[0])); // JavaScript array of numbers (batch) or number
							resultSb.append(',');
							resultSb.append(q("generatedKeys"));
							resultSb.append(':');
							resultSb.append(QueryUtils.convertToJsonArray(generatedKeys, resultSetFormat));
							resultSb.append('}');

							updateResultJson = resultSb.toString();
							bs               = updateResultJson.getBytes(StandardCharsets.UTF_8);
							//
							//
							if (!ongoingRequests.isEmpty()) {
								long timestamp = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
								for (AsyncContext ac : ongoingRequests) {
									try {
										HttpServletRequest selfRequest = (HttpServletRequest) ac.getRequest();

										Collection<String /* Notifier stored procedure name */ > notifiers = notifiersMap.get(statementId);
										if (notifiers != null) {

											String selfClientInfoJson = getClientInfo(selfRequest, sharedCoder.decoder);

											String selfUserInfoJson = generateUserInfoJson( //
													selfRequest, //
													userAgentParser, //
													selfClientInfoJson //
											);

											String statementInfoJson = generateStatementInfoJson( //
													instanceName, //
													statementId, //
													unprocessedNamedPreparedStatement, //
													paramJsonArray //
											);

											String executionResultJson = generateExecutionResultJson( //
													timestamp, //
													updateResultJson);

											for (String notifierStoredProcedureName : notifiers) {

												String       outEvent      = null;
												DbConnection dbConnection0 = null;
												try {
													dbConnection0 = connectionPoolManager.getConnection();
													String javaMethod = proceduresMap.get(notifierStoredProcedureName);
													if (javaMethod == null) {
														CallableStatement cs = dbConnection0.getCallableStatement("{call " + notifierStoredProcedureName + "(?,?,?,?)}");
														cs.setString(1, userInfoJson);
														cs.setString(2, selfUserInfoJson);
														cs.setString(3, statementInfoJson);
														cs.setString(4, executionResultJson);

														try (ResultSet rs = cs.executeQuery()) {
															if (rs.next())
																outEvent = rs.getString(1);
														}
													} else {
														String[] array      = javaMethod.split(JAVA_METHOD_SEPARATOR);
														String   className  = array[0];
														String   methodName = array[1];

														Class<?> clazz        = Class.forName(className);
														Method   notifyMethod = clazz.getMethod(methodName, Connection.class, String.class, String.class, String.class, String.class);
														outEvent = (String) notifyMethod.invoke(null, selfRequest, dbConnection0.getConnection(), userInfoJson, selfUserInfoJson, statementInfoJson, executionResultJson);
													}
												} finally {
													if (dbConnection0 != null)
														connectionPoolManager.releaseConnection(dbConnection0);
													if (outEvent != null) { // send if outEvent is not null
														Writer writer = ac.getResponse().getWriter();
														writer.append(outEvent + '\n');
														writer.flush();
														if (connectionInfo.debug) {
															System.out.println("Event was delivered to client:");
															System.out.println(outEvent);
														}
													}
												}
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
										//									} finally {
										//										if (dbConnection != null)
										//											connectionPoolManager.releaseConnection(dbConnection);
									}
								}
							}

						} else
							throw new IllegalArgumentException(execType);
					} catch (SQLException e) {
						e.printStackTrace();
						try (OutputStream os = response.getOutputStream()) {
							String message  = e.getMessage();
							String sqlState = e.getSQLState();
							String msg      = "{" + q("message") + ":" + (message == null ? "null" : q(message)) + "," + q("errorCode") + ":" + e.getErrorCode() + "," + q("SQLState") + ":" + (sqlState == null ? "null" : q(sqlState)) + "}";
							os.write(msg.getBytes(StandardCharsets.UTF_8));
							os.flush();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						asyncContext.complete();
						return;
					} finally {
						if (dbConnection != null)
							connectionPoolManager.releaseConnection(dbConnection);
					}
				}
			} else {
				bs         = readyResult.bs;
				etag       = readyResult.etag;
				compressed = readyResult.compressed;
			}
			if (executeTypeQuery) { // Execute Query
				if (etag.equals(etagFromClient)) {
					response.setStatus(HttpServletResponse.SC_NOT_MODIFIED); // setting HTTP 304 and returning with empty body
					asyncContext.complete();
					return;
				} else {
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.setContentLength(bs.length);
					if (compressed)
						response.setHeader("Content-Encoding", "deflate");
					response.setHeader("Cache-Control", "no-cache");
					response.addHeader("ETag", etag);
				}
			} else if (executeTypeUpdate) { // Execute Update
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setContentLength(bs.length);
			}
			try (OutputStream os = response.getOutputStream()) {
				os.write(bs);
				os.flush();
			}
		} catch (

		Throwable e) {
			e.printStackTrace();
			try (OutputStream os = response.getOutputStream()) {
				os.write(("{" + q("message") + ":" + q(e.getMessage()) + "}").getBytes(StandardCharsets.UTF_8));
				os.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				asyncContext.complete();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	/**
	 * This method extracts data part from data URI
	 *
	 * @param s
	 * @return
	 */
	private static String extractData(String s) {
		if (s.startsWith("data:")) { // data URI
			int pos = s.indexOf(";base64,"); // The data, separated from the preceding part by a comma (,)
			if (pos != -1)
				return s.substring(pos + 8);
		}
		return s;
	}

	private static String getClientInfo(HttpServletRequest request, Decoder decoder) throws IOException {
		String base64 = request.getHeader(DbServlet.CUSTOM_HTTP_HEADER_CLIENT_INFO);
		byte[] bs     = decoder.decode(base64);
		return new String(bs, StandardCharsets.UTF_8);
	}

	private static BufferedReader getCustomDataReader(HttpServletRequest request, Decoder decoder) throws IOException {
		String         method = request.getMethod().toUpperCase(Locale.ENGLISH);
		BufferedReader br;
		if (method.equals("GET")) {
			String base64 = request.getHeader(DbServlet.CUSTOM_HTTP_HEADER_STATEMENT);
			byte[] bs     = decoder.decode(base64);
			String s      = new String(bs, StandardCharsets.UTF_8);
			br = new BufferedReader(new StringReader(s));
		} else if (method.equals("POST"))
			br = request.getReader();
		else
			throw new IllegalArgumentException(method);
		return br;
	}

	/**
	 * Utility method generates ExecuteUpdate result JSON
	 *
	 * @param rowCount
	 * @return
	 */
	private static String simpleExecuteUpdateResultJson(int rowCount) {
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		sb.append(q("rowCount"));
		sb.append(':');
		sb.append(Integer.toString(rowCount));
		sb.append(',');
		sb.append(q("generatedKeys"));
		sb.append(':');
		sb.append("[]");
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Generate User Info JSON-formatted string
	 * 
	 * @param request
	 * @param userAgentParser
	 * @param clientInfoJson
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private static String generateUserInfoJson( //
			HttpServletRequest request, //
			UserAgentParser userAgentParser, //
			String clientInfoJson //
	) throws IOException, ParseException {
		String      remoteAddr        = request.getRemoteAddr();
		String      remoteHost        = request.getRemoteHost();
		Integer     remotePort        = request.getRemotePort();
		String      remoteUser        = (String) request.getAttribute(DbServlet.REQUEST_ATTRIBUTE_USER);
		String      remoteRole        = request.getHeader(DbServlet.CUSTOM_HTTP_HEADER_ROLE);
		Cookie[]    cookies           = request.getCookies();
		String      cookiesJson       = getCookiesJson(cookies);
		HttpSession session           = request.getSession(false);
		String      headersJson       = getHttpHeadersJson(request);
		String      userAgentInfoJson = getUserAgentInfo(request, userAgentParser);

		String sessionId;
		Long   sessionCreationTime;
		Long   sessionLastAccessedTime;
		String sessionAttributesJson;

		if (session == null) {
			sessionId               = null;
			sessionCreationTime     = null;
			sessionLastAccessedTime = null;
			sessionAttributesJson   = null;
		} else {
			sessionId               = session.getId();
			sessionCreationTime     = session.getCreationTime();
			sessionLastAccessedTime = session.getLastAccessedTime();

			sessionAttributesJson = (String) session.getAttribute(SESSION_ATTRIBUTE_SESSION_JSON);
			if (sessionAttributesJson == null)
				sessionAttributesJson = "{}";
		}

		final String  NULL  = "null";
		final char    COLON = ':';
		final char    COMMA = ',';
		StringBuilder sb    = new StringBuilder();

		sb.append('{');
		sb.append(q("remoteUser")).append(COLON).append(remoteUser == null ? NULL : q(remoteUser)).append(COMMA);
		sb.append(q("remoteRole")).append(COLON).append(remoteRole == null ? NULL : q(remoteRole)).append(COMMA);
		sb.append(q("remoteAddr")).append(COLON).append(remoteAddr == null ? NULL : q(remoteAddr)).append(COMMA);
		sb.append(q("remoteHost")).append(COLON).append(remoteHost == null ? NULL : q(remoteHost)).append(COMMA);
		sb.append(q("remotePort")).append(COLON).append(remotePort == null ? NULL : Integer.toString(remotePort)).append(COMMA);
		sb.append(q("client")).append(COLON).append(clientInfoJson).append(COMMA);
		sb.append(q("headers")).append(COLON).append(headersJson).append(COMMA);
		sb.append(q("userAgentInfo")).append(COLON).append(userAgentInfoJson).append(COMMA);
		sb.append(q("cookies")).append(COLON).append("[]".equals(cookiesJson) ? NULL : cookiesJson).append(COMMA);
		sb.append(q("httpSession")).append(COLON);
		if (sessionId == null)
			sb.append(NULL);
		else {
			sb.append('{');
			sb.append(q("id")).append(COLON).append(q(sessionId)).append(COMMA);
			sb.append(q("creationTime")).append(COLON).append(Long.toString(sessionCreationTime)).append(COMMA);
			sb.append(q("lastAccessedTime")).append(COLON).append(Long.toString(sessionLastAccessedTime)).append(COMMA);
			sb.append(q("attributes")).append(COLON).append("{}".equals(sessionAttributesJson) ? NULL : sessionAttributesJson);
			sb.append('}');
		}
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Generate Statement Info JSON-formatted string
	 *
	 * @param instanceName
	 * @param statementId
	 * @param unprocessedNamedPreparedStatement
	 * @param paramArrayJson
	 * @return
	 */
	private static String generateStatementInfoJson( //
			String instanceName, //
			String statementId, //
			String unprocessedNamedPreparedStatement, //
			String paramArrayJson) {
		final String  NULL  = "null";
		final char    COLON = ':';
		final char    COMMA = ',';
		StringBuilder sb    = new StringBuilder();

		sb.append('{');
		sb.append(q("instanceName")).append(COLON).append(q(instanceName)).append(COMMA);
		sb.append(q("statementId")).append(COLON).append(statementId == null ? NULL : q(statementId)).append(COMMA);
		sb.append(q("statement")).append(COLON).append(q(unprocessedNamedPreparedStatement)).append(COMMA);
		sb.append(q("parameters")).append(COLON).append(paramArrayJson);
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Generate Execution Result JSON-formatted string
	 *
	 * @param timestamp
	 * @param updateResultJson
		 * @return
	 */
	private static String generateExecutionResultJson( //
			long timestamp, //
			String updateResultJson //
	) {
		final char    COLON = ':';
		final char    COMMA = ',';
		StringBuilder sb    = new StringBuilder();

		sb.append('{');
		sb.append(q("timestamp")).append(COLON).append(timestamp).append(COMMA);
		sb.append(q("updateResult")).append(COLON).append(updateResultJson);
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Converts HTTP headers to JSON-formatted string
	 *
	 * @param request
	 * @return
	 */
	private static String getHttpHeadersJson(HttpServletRequest request) {
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
	private static String getCookiesJson(Cookie[] cookies) {
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

	private static String getUserAgentInfo(HttpServletRequest request, UserAgentParser userAgentParser) throws IOException, ParseException {
		String userAgent = request.getHeader("User-Agent");

		final Capabilities         capabilities = userAgentParser.parse(userAgent);
		Map<BrowsCapField, String> map          = capabilities.getValues();
		StringBuilder              sb           = new StringBuilder();
		boolean                    first        = true;
		sb.append("{");
		for (Map.Entry<BrowsCapField, String> entry : map.entrySet()) {
			BrowsCapField key   = entry.getKey();
			Class<?>      type  = browsCapFieldInfoMap.get(key);
			String        value = entry.getValue().trim();
			if (type == Boolean.class) {
				if (!"true".equals(value) && !"false".equals(value))
					value = "null";
			} else if (type == Number.class)
				try {
					Double.parseDouble(value);
				} catch (NumberFormatException e) {
					value = "null";
				}
			else if (type == String.class)
				value = q(value);
			String name = key.name().toLowerCase(Locale.ENGLISH);
			if (name.startsWith("is_"))
				name = name.substring(3);
			if (first)
				first = false;
			else
				sb.append(',');
			sb.append(q(name) + ':' + value);
		}
		sb.append("}");
		return sb.toString();
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
