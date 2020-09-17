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

import static org.fbsql.servlet.StringUtils.q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
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
import java.util.Base64.Decoder;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
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

import org.fbsql.antlr4.parser.ParseNativeStmt;
import org.fbsql.antlr4.parser.ParseStmtConnectTo;
import org.fbsql.antlr4.parser.ParseStmtConnectTo.StmtConnectTo;
import org.fbsql.antlr4.parser.ParseStmtDeclareStatement.StmtDeclareStatement;
import org.fbsql.connection_pool.ConnectionPoolManager;
import org.fbsql.connection_pool.DbConnection;
import org.fbsql.json.parser.JsonUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeJSON;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.Scriptable;

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

	/*
	 * Built-in functions
	 */

	/* functions with parameter */
	private static final String FUT_IN_ROLE                               = "IN_ROLE(";
	private static final String FUT_GET_COOKIE                            = "COOKIE(";
	private static final String FUT_GET_HTTP_SESSION_ATTRIBUTE_AS_CHAR    = "GET_HTTP_SESSION_ATTRIBUTE_AS_CHAR(";
	private static final String FUT_GET_HTTP_SESSION_ATTRIBUTE_AS_INTEGER = "GET_HTTP_SESSION_ATTRIBUTE_AS_INTEGER(";
	private static final String FUT_GET_HTTP_HEADER_AS_CHAR               = "GET_HTTP_HEADER_AS_CHAR(";
	private static final String FUT_GET_HTTP_HEADER_AS_DATE               = "GET_HTTP_HEADER_AS_DATE(";
	private static final String FUT_GET_HTTP_HEADER_AS_INTEGER            = "GET_HTTP_HEADER_AS_INTEGER(";

	/* functions without parameters */
	private static final String FUN_REMOTE_USER                       = "REMOTE_USER()";
	private static final String FUN_REMOTE_ROLE                       = "REMOTE_ROLE()";
	private static final String FUN_REMOTE_SESSION_ID                 = "REMOTE_SESSION_ID()";
	private static final String FUN_REMOTE_SESSION_CREATION_TIME      = "REMOTE_SESSION_CREATION_TIME()";
	private static final String FUN_REMOTE_SESSION_LAST_ACCESSED_TIME = "REMOTE_SESSION_LAST_ACCESSED_TIME()";
	private static final String FUN_USER_INFO                         = "USER_INFO()";

	/* system constants (See JavaSctript class Constants in fbsql.js */
	private static final String FBSQL_REMOTE_USER                       = "FBSQL_REMOTE_USER";
	private static final String FBSQL_REMOTE_ROLE                       = "FBSQL_REMOTE_ROLE";
	private static final String FBSQL_REMOTE_SESSION_ID                 = "FBSQL_REMOTE_SESSION_ID";
	private static final String FBSQL_REMOTE_SESSION_CREATION_TIME      = "FBSQL_REMOTE_SESSION_CREATION_TIME";
	private static final String FBSQL_REMOTE_SESSION_LAST_ACCESSED_TIME = "FBSQL_REMOTE_SESSION_LAST_ACCESSED_TIME";
	private static final String FBSQL_USER_INFO                         = "FBSQL_USER_INFO";

	private String        instanceName;
	private String        instanceDirectory;
	private StmtConnectTo stmtConnectTo;
	private AsyncContext  asyncContext;

	private boolean               debug;
	private ConnectionPoolManager connectionPoolManager;

	private Map<String /* SQL statement name */, StmtDeclareStatement>                declaredStatementsMap; // list of SQL statements
	private Map<String /* stored procedure name */, NonNativeProcedure>               proceduresMap;
	private Map<String /* js file name */, Scriptable>                                mapScopes;
	private Map<String /* js file name */, Map<String /* function name */, Function>> mapFunctions;

	private Map<StaticStatement, ReadyResult> mapJson;
	private Queue<AsyncContext>               ongoingRequests;
	private DbServlet.SharedCoder             sharedCoder;
	private ParseNativeStmt                   parseNativeStmt;

	/**
	 * Constructs DbRequestProcessor object
	 * 
	 * @param instanceName
	 * @param stmtConnectTo
	 * @param asyncCtx
	 * @param debug
	 * @param connectionPoolManager
	 * @param declaredStatementsMap
	 * @param proceduresMap
	 * @param mapScopes
	 * @param mapFunctions
	 * @param mapJson
	 * @param ongoingRequests
	 * @param sharedCoder
	 */
	public DbRequestProcessor( //
			String instanceName, //
			String instanceDirectory, //
			StmtConnectTo stmtConnectTo, //
			AsyncContext asyncCtx, //
			boolean debug, //
			ConnectionPoolManager connectionPoolManager, //
			Map<String /* SQL statement name */, StmtDeclareStatement> declaredStatementsMap, // list of SQL statements
			Map<String /* stored procedure name */, NonNativeProcedure> proceduresMap, //
			Map<String /* js file name */, Scriptable> mapScopes, //
			Map<String /* js file name */, Map<String /* function name */, Function>> mapFunctions, //
			Map<StaticStatement, ReadyResult> mapJson, //
			Queue<AsyncContext> ongoingRequests, //
			ParseNativeStmt parseNativeStmt, //
			DbServlet.SharedCoder sharedCoder //
	) {
		this.instanceName          = instanceName;
		this.instanceDirectory     = instanceDirectory;
		this.stmtConnectTo         = stmtConnectTo;
		this.asyncContext          = asyncCtx;
		this.debug                 = debug;
		this.connectionPoolManager = connectionPoolManager;
		this.declaredStatementsMap = declaredStatementsMap; // list of SQL statements
		this.proceduresMap         = proceduresMap;
		this.mapScopes             = mapScopes;
		this.mapFunctions          = mapFunctions;
		this.mapJson               = mapJson;
		this.ongoingRequests       = ongoingRequests;
		this.parseNativeStmt       = parseNativeStmt;
		this.sharedCoder           = sharedCoder;
	}

	/**
	 * Implementation of Runnable.run() method
	 * 
	 * Overview of request processor logic
	 * - Parse request body
	 * - Check SQL statement against white list (list of allowed SQL statements)
	 * - Execute SQL statement if allowed
	 */
	@Override
	public void run() {
		HttpServletRequest  request  = (HttpServletRequest) asyncContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();

		try {
			String etagFromClient = request.getHeader("If-None-Match");

			String   remoteUser = (String) request.getAttribute(DbServlet.REQUEST_ATTRIBUTE_USER);
			String   remoteRole = request.getHeader(DbServlet.CUSTOM_HTTP_HEADER_ROLE);
			Cookie[] cookies    = request.getCookies();
			//
			HttpSession session = request.getSession();

			boolean   reject        = false;
			String    rejectMessage = null;
			Throwable exception     = null;
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
			CharSequence        sessionInfoJson = HttpRequestUtils.generateSessionInfoJson(request, sharedCoder.encoder);
			String              userInfoJson    = generateUserInfoJson(                                                  //
					request,                                                                                             //
					clientInfoJson,                                                                                      //
					sessionInfoJson                                                                                      //
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

			String                    unprocessedNamedPreparedStatement = null;
			String                    namedPreparedStatement            = null;
			List<Map<String, Object>> parametersListOfMaps              = null;
			StmtDeclareStatement      stmtDeclareStatement              = null;

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
				for (StmtDeclareStatement curDeclareStatement : declaredStatementsMap.values()) {
					if (curDeclareStatement.statement.equals(namedPreparedStatement)) {
						statementId          = curDeclareStatement.alias;
						stmtDeclareStatement = declaredStatementsMap.get(statementId);
						break;
					}
				}
				reject = stmtDeclareStatement == null && !stmtConnectTo.exposeUndeclaredStatements;
				if (reject)
					rejectMessage = StringUtils.escapeJson(MessageFormat.format("Rejected. SQL statement \"{0}\" not exposed to frontend", namedPreparedStatement));
			} else { // SQL statement name provided
				reject = statementId.startsWith(ParseStmtConnectTo.NONEXPOSABLE_NAME_PREFIX);
				final String NAME_NOT_FOUND_MSG = StringUtils.escapeJson(MessageFormat.format("Rejected. SQL statement name: ''{0}'' not found", statementId));
				if (reject) // wrong name format
					rejectMessage = NAME_NOT_FOUND_MSG;
				else {
					stmtDeclareStatement = declaredStatementsMap.get(statementId);
					if (stmtDeclareStatement == null) {
						reject        = true;
						rejectMessage = NAME_NOT_FOUND_MSG;
					} else {
						namedPreparedStatement            = stmtDeclareStatement.statement;
						unprocessedNamedPreparedStatement = namedPreparedStatement;
					}
				}
			}

			if (stmtDeclareStatement != null) {
				Collection<String> allowedRoles = stmtDeclareStatement.roles;
				if (!allowedRoles.isEmpty())
					if (!allowedRoles.contains(remoteRole)) {
						reject        = true;
						rejectMessage = StringUtils.escapeJson(MessageFormat.format("Rejected. SQL statement \"{0}\" not allowed for role \"{1}\"", namedPreparedStatement, remoteRole));
					}
			}

			//
			// validate
			//
			parametersListOfMaps = new ArrayList<>(paramJsons.size());
			for (String paramJson : paramJsons) {
				if (stmtDeclareStatement != null) {
					String validatorStoredProcedureName = stmtDeclareStatement.trigger_before_procedure_name;
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

							NonNativeProcedure nonNativeProcedure = proceduresMap.get(validatorStoredProcedureName);
							if (nonNativeProcedure != null) { // Java or JavaScript
								if (nonNativeProcedure.procedureType == ProcedureType.JAVA || nonNativeProcedure.procedureType == ProcedureType.JS) { // Java or JavaScript

									List<Object> parameterValues = new ArrayList<>();
									parameterValues.add(request);
									parameterValues.add(response);
									parameterValues.add(dbConnection0.getConnection());
									parameterValues.add(instanceName);
									parameterValues.add(userInfoJson);
									parameterValues.add(statementInfoJson);
									Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

									Object obj = null;
									if (nonNativeProcedure.procedureType == ProcedureType.JAVA) { // Java
										Method method = CallUtils.getMethod(nonNativeProcedure.optionsJson);
										try {
											obj = (String) method.invoke(null, parametersArray);
										} catch (InvocationTargetException e) {
											exception = e.getTargetException();
										}
									} else if (nonNativeProcedure.procedureType == ProcedureType.JS) { // JavaScript
										//
										// initize Rhino
										// https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino
										//
										Context ctx = Context.enter();
										try {
											ctx.setLanguageVersion(Context.VERSION_1_7);
											ctx.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization
											JsFunction jsFunction = CallUtils.getFunction(instanceDirectory, nonNativeProcedure.optionsJson, mapScopes, mapFunctions);
											try {
												obj = jsFunction.function.call(ctx, jsFunction.scope, null, parametersArray);
											} catch (Exception e) {
												exception = e.getCause();
											}
											if (obj instanceof NativeObject)
												obj = (String) NativeJSON.stringify(ctx, jsFunction.scope, obj, null, null); // to string
										} finally {
											ctx.exit();
										}
									}
									if (obj instanceof ResultSet)
										try (ResultSet rs = (ResultSet) obj) {
											if (rs.next())
												modifiedParamsJson = rs.getString(1);
										} catch (SQLException e) {
											exception = e.getCause();
										}
									else if (obj instanceof CharSequence)
										modifiedParamsJson = obj.toString();
								} else if (nonNativeProcedure.procedureType == ProcedureType.EXEC) { // OS
									List<Object> parameterValues = new ArrayList<>();
									parameterValues.add(instanceName);
									parameterValues.add(userInfoJson);
									parameterValues.add(statementInfoJson);
									Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

									modifiedParamsJson = CallUtils.executeOsProgramm(instanceDirectory, nonNativeProcedure.optionsJson, parametersArray);

								} else if (nonNativeProcedure.procedureType == ProcedureType.URL) { // URL
									Map<String, Object> parametersMap = new LinkedHashMap<>();
									parametersMap.put("instanceName", instanceName);
									parametersMap.put("userInfoJson", userInfoJson);
									parametersMap.put("statementInfoJson", statementInfoJson);

									modifiedParamsJson = CallUtils.executeUrl(instanceDirectory, nonNativeProcedure.optionsJson, parametersMap);
								}
							} else { // Native
								CallableStatement cs = dbConnection0.getCallableStatement("{call " + validatorStoredProcedureName + "(?,?)}");
								cs.setString(1, instanceName);
								cs.setString(2, userInfoJson);
								cs.setString(3, statementInfoJson);

								try (ResultSet rs = cs.executeQuery()) {
									if (rs.next())
										modifiedParamsJson = rs.getString(1);
								}
							}
						} finally {
							if (dbConnection0 != null)
								connectionPoolManager.releaseConnection(dbConnection0);
							if (modifiedParamsJson == null) { // reject if stored procedure return null
								reject = true;
								if (exception == null || exception.getMessage() == null)
									rejectMessage = StringUtils.escapeJson(MessageFormat.format("Rejected. Message: \"Rejected by trigger\". Procedure: {0}. SQL statement: \"{1}\". Parameters: {2}.", validatorStoredProcedureName, namedPreparedStatement, paramJson));
								else
									rejectMessage = exception.getMessage();
							} else
								paramJson = modifiedParamsJson.trim();
						}
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
					os.write(('{' + q("message") + ':' + q(rejectMessage) + '}').getBytes(StandardCharsets.UTF_8));
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
			preparedStatement = preparedStatement.replace(FUN_REMOTE_USER, remoteUser == null ? SQL_NULL : SQL_QUOTE_CHAR + remoteUser + SQL_QUOTE_CHAR);
			preparedStatement = preparedStatement.replace(FUN_REMOTE_ROLE, remoteRole == null ? SQL_NULL : SQL_QUOTE_CHAR + remoteRole + SQL_QUOTE_CHAR);
			preparedStatement = preparedStatement.replace(FUN_REMOTE_SESSION_ID, SQL_QUOTE_CHAR + session.getId() + SQL_QUOTE_CHAR);
			preparedStatement = preparedStatement.replace(FUN_REMOTE_SESSION_CREATION_TIME, Long.toString(session.getCreationTime()));
			preparedStatement = preparedStatement.replace(FUN_REMOTE_SESSION_LAST_ACCESSED_TIME, Long.toString(session.getLastAccessedTime()));
			preparedStatement = preparedStatement.replace(FUN_USER_INFO, userInfoJson == null ? SQL_NULL : SQL_QUOTE_CHAR + userInfoJson + SQL_QUOTE_CHAR);

			//
			// Replace IN_ROLE() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, FUT_IN_ROLE);
				if (offset == -1)
					break;
				int     pos1   = offset + FUT_IN_ROLE.length();
				char    quote  = preparedStatement.charAt(pos1);       // get single «'» or double «"» quote
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
				int offset = SqlParseUtils.indexOf(preparedStatement, FUT_GET_COOKIE);
				if (offset == -1)
					break;
				int    pos1       = offset + FUT_GET_COOKIE.length();
				char   quote      = preparedStatement.charAt(pos1);       // get single «'» or double «"» quote
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
			// Replace GET_HTTP_SESSION_ATTRIBUTE_AS_CHAR() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, FUT_GET_HTTP_SESSION_ATTRIBUTE_AS_CHAR);
				if (offset == -1)
					break;
				int    pos1           = offset + FUT_GET_HTTP_SESSION_ATTRIBUTE_AS_CHAR.length();
				char   quote          = preparedStatement.charAt(pos1);                          // get single «'» or double «"» quote
				String s              = preparedStatement.substring(pos1 + 1);
				int    pos2           = s.indexOf(quote);
				String attributeName  = s.substring(0, pos2);
				Object attributeValue = session.getAttribute(attributeName);
				preparedStatement = preparedStatement.substring(0, offset) + (attributeValue == null ? SQL_NULL : SQL_QUOTE_CHAR + attributeValue.toString() + SQL_QUOTE_CHAR) + preparedStatement.substring(pos1 + attributeName.length() + 3);
			}

			//
			// Replace FUT_GET_HTTP_SESSION_ATTRIBUTE_AS_INTEGER() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, FUT_GET_HTTP_SESSION_ATTRIBUTE_AS_INTEGER);
				if (offset == -1)
					break;
				int    pos1           = offset + FUT_GET_HTTP_SESSION_ATTRIBUTE_AS_INTEGER.length();
				char   quote          = preparedStatement.charAt(pos1);                             // get single «'» or double «"» quote
				String s              = preparedStatement.substring(pos1 + 1);
				int    pos2           = s.indexOf(quote);
				String attributeName  = s.substring(0, pos2);
				Object attributeValue = session.getAttribute(attributeName);
				preparedStatement = preparedStatement.substring(0, offset) + (attributeValue == null ? SQL_NULL : attributeValue.toString()) + preparedStatement.substring(pos1 + attributeName.length() + 3);
			}

			//
			// Replace GET_HTTP_HEADER_AS_CHAR() built-in function with value
			//
			while (true) {
				int offset = SqlParseUtils.indexOf(preparedStatement, FUT_GET_HTTP_HEADER_AS_CHAR);
				if (offset == -1)
					break;
				int    pos1       = offset + FUT_GET_HTTP_HEADER_AS_CHAR.length();
				char   quote      = preparedStatement.charAt(pos1);               // get single «'» or double «"» quote
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
				int offset = SqlParseUtils.indexOf(preparedStatement, FUT_GET_HTTP_HEADER_AS_INTEGER);
				if (offset == -1)
					break;
				int    pos1       = offset + FUT_GET_HTTP_HEADER_AS_INTEGER.length();
				char   quote      = preparedStatement.charAt(pos1);                  // get single «'» or double «"» quote
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
				int offset = SqlParseUtils.indexOf(preparedStatement, FUT_GET_HTTP_HEADER_AS_DATE);
				if (offset == -1)
					break;
				int    pos1       = offset + FUT_GET_HTTP_HEADER_AS_DATE.length();
				char   quote      = preparedStatement.charAt(pos1);               // get single «'» or double «"» quote
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
				if (debug) {
					System.out.println("Statement was delegated to underlying database:");
					System.out.println(unprocessedNamedPreparedStatement);
				}
				DbConnection dbConnection = connectionPoolManager.getConnection();
				try {
					NonNativeProcedure nonNativeProcedure = CallUtils.getCallStatementNonNativeProcedure(unprocessedNamedPreparedStatement, proceduresMap);

					if (nonNativeProcedure != null) {
						if (nonNativeProcedure.procedureType == ProcedureType.JAVA) { // Java
							Method method = CallUtils.getMethod(nonNativeProcedure.optionsJson);
							if (executeTypeUpdate) {
								int rowCount = 0;
								for (Map<String, Object> parametersMap : parametersListOfMaps) {
									List<Object> parameterValues = new ArrayList<>();
									parameterValues.add(request);
									parameterValues.add(response);
									parameterValues.add(dbConnection.getConnection());
									parameterValues.add(instanceName);
									CallUtils.getCallStatementParameterValues(parseNativeStmt, unprocessedNamedPreparedStatement, parametersMap, parameterValues);
									Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

									method.invoke(null, parametersArray);
									rowCount++;
								}
								bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
							} else if (executeTypeQuery) {
								Map<String, Object> parametersMap   = parametersListOfMaps.get(0);
								List<Object>        parameterValues = new ArrayList<>();
								parameterValues.add(request);
								parameterValues.add(response);
								parameterValues.add(dbConnection.getConnection());
								parameterValues.add(instanceName);
								CallUtils.getCallStatementParameterValues(parseNativeStmt, unprocessedNamedPreparedStatement, parametersMap, parameterValues);
								Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

								Object                                                       obj         = method.invoke(null, parametersArray);
								Integer                                                      compression = stmtDeclareStatement == null ? CompressionLevel.BEST_COMPRESSION : stmtDeclareStatement.compressionLevel;
								List<Map<String /* column name */, String /* JSON value */>> list        = null;
								if (obj instanceof ResultSet)
									list = QueryUtils.resutlSetToListOfMapsJsonValues((ResultSet) obj, sharedCoder.encoder);
								else if (obj instanceof CharSequence)
									list = QueryUtils.convertJsonArrayOfObjectsToListOfMaps(obj.toString());
								ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
								bs         = rr.bs;
								etag       = rr.etag;
								compressed = rr.compressed;
							}
						} else if (nonNativeProcedure.procedureType == ProcedureType.JS) { // JavaScript
							//
							// initize Rhino
							// https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino
							//
							Context ctx = Context.enter();

							try {
								ctx.setLanguageVersion(Context.VERSION_1_7);
								ctx.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization
								JsFunction jsFunction = CallUtils.getFunction(instanceDirectory, nonNativeProcedure.optionsJson, mapScopes, mapFunctions);

								if (executeTypeUpdate) {
									int rowCount = 0;
									for (Map<String, Object> parametersMap : parametersListOfMaps) {
										List<Object> parameterValues = new ArrayList<>();
										parameterValues.add(request);
										parameterValues.add(response);
										parameterValues.add(dbConnection.getConnection());
										parameterValues.add(instanceName);
										CallUtils.getCallStatementParameterValues(parseNativeStmt, unprocessedNamedPreparedStatement, parametersMap, parameterValues);
										Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

										jsFunction.function.call(ctx, jsFunction.scope, null, parametersArray);
										rowCount++;
									}
									bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
								} else if (executeTypeQuery) {
									Map<String, Object> parametersMap   = parametersListOfMaps.get(0);
									List<Object>        parameterValues = new ArrayList<>();
									parameterValues.add(request);
									parameterValues.add(response);
									parameterValues.add(dbConnection.getConnection());
									parameterValues.add(instanceName);
									CallUtils.getCallStatementParameterValues(parseNativeStmt, unprocessedNamedPreparedStatement, parametersMap, parameterValues);
									Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

									Object                                                       obj         = jsFunction.function.call(ctx, jsFunction.scope, null, parametersArray);
									Integer                                                      compression = stmtDeclareStatement == null ? CompressionLevel.BEST_COMPRESSION : stmtDeclareStatement.compressionLevel;
									List<Map<String /* column name */, String /* JSON value */>> list        = null;
									if (obj instanceof NativeObject || obj instanceof NativeArray) { // return JSON object that will sent to client
										String json = (String) NativeJSON.stringify(ctx, jsFunction.scope, obj, null, null);
										if (json.startsWith("{") && json.endsWith("}"))
											json = '[' + json + ']';
										list = QueryUtils.convertJsonArrayOfObjectsToListOfMaps(json);
									} else if (obj instanceof ResultSet)
										list = QueryUtils.resutlSetToListOfMapsJsonValues((ResultSet) obj, sharedCoder.encoder);
									else if (obj instanceof CharSequence)
										list = QueryUtils.convertJsonArrayOfObjectsToListOfMaps(obj.toString());
									ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
									bs         = rr.bs;
									etag       = rr.etag;
									compressed = rr.compressed;
								}
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								ctx.exit();
							}
						} else if (nonNativeProcedure.procedureType == ProcedureType.EXEC) { // OS
							if (executeTypeUpdate) {
								int rowCount = 0;
								for (Map<String, Object> parametersMap : parametersListOfMaps) {
									List<Object> parameterValues = new ArrayList<>();
									parameterValues.add(instanceName);
									CallUtils.getCallStatementParameterValues(parseNativeStmt, unprocessedNamedPreparedStatement, parametersMap, parameterValues);
									Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

									CallUtils.executeOsProgramm(instanceDirectory, nonNativeProcedure.optionsJson, parametersArray);
									rowCount++;
								}
								bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
							} else if (executeTypeQuery) {
								Map<String, Object> parametersMap   = parametersListOfMaps.get(0);
								List<Object>        parameterValues = new ArrayList<>();
								parameterValues.add(instanceName);
								CallUtils.getCallStatementParameterValues(parseNativeStmt, unprocessedNamedPreparedStatement, parametersMap, parameterValues);
								Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

								String jsonArray = CallUtils.executeOsProgramm(instanceDirectory, nonNativeProcedure.optionsJson, parametersArray);

								Integer                                                      compression = stmtDeclareStatement == null ? CompressionLevel.BEST_COMPRESSION : stmtDeclareStatement.compressionLevel;
								List<Map<String /* column name */, String /* JSON value */>> list        = QueryUtils.convertJsonArrayOfObjectsToListOfMaps(jsonArray);
								ReadyResult                                                  rr          = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
								bs         = rr.bs;
								etag       = rr.etag;
								compressed = rr.compressed;
							}
						} else if (nonNativeProcedure.procedureType == ProcedureType.URL) { // URL
							if (executeTypeUpdate) {
								int rowCount = 0;
								for (Map<String, Object> parametersMap : parametersListOfMaps) {
									Map<String, Object> parametersMap0 = new LinkedHashMap<>();
									parametersMap0.put("instanceName", instanceName);
									parametersMap0.putAll(parametersMap);

									CallUtils.executeUrl(instanceDirectory, nonNativeProcedure.optionsJson, parametersMap0);
									rowCount++;
								}
								bs = simpleExecuteUpdateResultJson(rowCount).getBytes(StandardCharsets.UTF_8);
							} else if (executeTypeQuery) {
								Map<String, Object> parametersMap = parametersListOfMaps.get(0);

								Map<String, Object> parametersMap0 = new LinkedHashMap<>();
								parametersMap0.put("instanceName", instanceName);
								parametersMap0.putAll(parametersMap);

								String jsonArray = CallUtils.executeUrl(instanceDirectory, nonNativeProcedure.optionsJson, parametersMap0);

								Integer                                                      compression = stmtDeclareStatement == null ? CompressionLevel.BEST_COMPRESSION : stmtDeclareStatement.compressionLevel;
								List<Map<String /* column name */, String /* JSON value */>> list        = QueryUtils.convertJsonArrayOfObjectsToListOfMaps(jsonArray);
								ReadyResult                                                  rr          = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
								bs         = rr.bs;
								etag       = rr.etag;
								compressed = rr.compressed;
							}
						}
					} else { // Native
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
													ps.setString(n, pvalue); // JavaScript Number
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
											} else if (parameterType == Types.BINARY || parameterType == Types.VARBINARY || parameterType == Types.LONGVARBINARY) // JavaScript (ArrayBuffer, Blob, URL, String) converted to BASE64 on client side
												ps.setBytes(n, sharedCoder.decoder.decode(pvalue));
											else if (parameterType == Types.BLOB) { // JavaScript (ArrayBuffer, Blob, URL, String) converted to BASE64 on client side
												Blob blob = ps.getConnection().createBlob();
												blob.setBytes(1L, sharedCoder.decoder.decode(pvalue));
												ps.setBlob(n, blob);
											} else if (parameterType == Types.CLOB) { // JavaScript string stored in CLOB "AS IS" (as String)
												Clob clob = ps.getConnection().createClob();
												clob.setString(1L, pvalue);
												ps.setClob(n, clob);
											} else { // unknown
												if (FBSQL_REMOTE_USER.equals(pvalue))
													ps.setString(n, remoteUser);
												else if (FBSQL_REMOTE_ROLE.equals(pvalue))
													ps.setString(n, remoteRole);
												else if (FBSQL_REMOTE_SESSION_ID.equals(pvalue))
													ps.setString(n, session.getId());
												else if (FBSQL_REMOTE_SESSION_CREATION_TIME.equals(pvalue))
													ps.setLong(n, session.getCreationTime());
												else if (FBSQL_REMOTE_SESSION_LAST_ACCESSED_TIME.equals(pvalue))
													ps.setLong(n, session.getLastAccessedTime());
												else if (FBSQL_USER_INFO.equals(pvalue))
													ps.setString(n, userInfoJson);
												else
													ps.setString(n, pvalue);
											}
										}
									}
							}
							if (executeTypeUpdate)
								ps.addBatch();
						}

						if (executeTypeQuery) { // Execute Query
							Integer                                                      compression = stmtDeclareStatement == null ? CompressionLevel.BEST_COMPRESSION : stmtDeclareStatement.compressionLevel;
							ResultSet                                                    rs          = ps.executeQuery();
							List<Map<String /* column name */, String /* JSON value */>> list        = QueryUtils.resutlSetToListOfMapsJsonValues(rs, sharedCoder.encoder);
							//							try (ResultSet rs = ps.executeQuery()) {
							//								List<Map<String /* column name */, Object /* column value */>> resultsListOfMaps = QueryUtils.resutlSetToListOfMaps(rs);
							//								List<Map<String /* column name */, String /* JSON value */>>   list              = QueryUtils.listOfMapsToListOfMapsJsonValues(resultsListOfMaps, sharedCoder.encoder);

							ReadyResult rr = QueryUtils.createReadyResult(list, resultSetFormat, compression, sharedCoder.encoder);
							bs         = rr.bs;
							etag       = rr.etag;
							compressed = rr.compressed;
							//							} finally {
							//								if (dbConnection != null)
							//									connectionPoolManager.releaseConnection(dbConnection);
							//							}

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
								//							} finally {
								//								if (dbConnection != null)
								//									connectionPoolManager.releaseConnection(dbConnection);
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
						} else
							throw new IllegalArgumentException(execType);
					}
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

				if (!ongoingRequests.isEmpty()) {
					long timestamp = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
					if (stmtDeclareStatement != null) {
						String notifierStoredProcedureName = stmtDeclareStatement.trigger_after_procedure_name;
						for (AsyncContext ac : ongoingRequests) {
							try {
								HttpServletRequest  selfRequest  = (HttpServletRequest) ac.getRequest();
								HttpServletResponse selfResponce = (HttpServletResponse) ac.getResponse();

								if (notifierStoredProcedureName != null) {
									String       selfClientInfoJson  = getClientInfo(selfRequest, sharedCoder.decoder);
									CharSequence selfSessionInfoJson = HttpRequestUtils.generateSessionInfoJson(request, sharedCoder.encoder);

									String selfUserInfoJson = generateUserInfoJson( //
											selfRequest, //
											selfClientInfoJson, //
											selfSessionInfoJson //
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

									String       outEvent      = null; // JSON object that will sent to client
									DbConnection dbConnection0 = null;
									try {
										dbConnection0 = connectionPoolManager.getConnection();
										NonNativeProcedure nonNativeProcedure = proceduresMap.get(notifierStoredProcedureName);
										if (nonNativeProcedure != null) {
											if (nonNativeProcedure.procedureType == ProcedureType.JAVA || nonNativeProcedure.procedureType == ProcedureType.JS) { // Java or JavaScript
												Object obj = null;

												List<Object> parameterValues = new ArrayList<>();
												parameterValues.add(selfRequest);
												parameterValues.add(selfResponce);
												parameterValues.add(dbConnection0.getConnection());
												parameterValues.add(instanceName);
												parameterValues.add(userInfoJson);
												parameterValues.add(selfUserInfoJson);
												parameterValues.add(statementInfoJson);
												parameterValues.add(executionResultJson);
												Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);

												if (nonNativeProcedure.procedureType == ProcedureType.JAVA) { // Java
													Method method = CallUtils.getMethod(nonNativeProcedure.optionsJson);
													obj = method.invoke(null, parametersArray);
												} else if (nonNativeProcedure.procedureType == ProcedureType.JS) { // JavaScript
													//
													// initize Rhino
													// https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino
													//
													Context ctx = Context.enter();
													try {
														ctx.setLanguageVersion(Context.VERSION_1_7);
														ctx.setOptimizationLevel(9); // Rhino optimization: https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino/Optimization
														JsFunction jsFunction = CallUtils.getFunction(instanceDirectory, nonNativeProcedure.optionsJson, mapScopes, mapFunctions);
														obj = jsFunction.function.call(ctx, jsFunction.scope, null, parametersArray);
														if (obj instanceof NativeObject)
															obj = (String) NativeJSON.stringify(ctx, jsFunction.scope, obj, null, null);
													} catch (Exception e) {
														obj = null;
														e.printStackTrace();
													} finally {
														ctx.exit();
													}
												}
												if (obj instanceof ResultSet)
													try (ResultSet rs = (ResultSet) obj) {
														if (rs.next())
															outEvent = rs.getString(1);
													}
												else if (obj instanceof CharSequence)
													outEvent = obj.toString();
											} else if (nonNativeProcedure.procedureType == ProcedureType.EXEC) { // OS
												List<Object> parameterValues = new ArrayList<>();
												parameterValues.add(instanceName);
												parameterValues.add(userInfoJson);
												parameterValues.add(selfUserInfoJson);
												parameterValues.add(statementInfoJson);
												parameterValues.add(executionResultJson);
												Object[] parametersArray = parameterValues.toArray(new Object[parameterValues.size()]);
												outEvent = CallUtils.executeOsProgramm(instanceDirectory, nonNativeProcedure.optionsJson, parametersArray);

											} else if (nonNativeProcedure.procedureType == ProcedureType.URL) { // URL
												Map<String, Object> parametersMap = new LinkedHashMap<>();
												parametersMap.put("instanceName", instanceName);
												parametersMap.put("userInfoJson", userInfoJson);
												parametersMap.put("selfUserInfoJson", selfUserInfoJson);
												parametersMap.put("statementInfoJson", statementInfoJson);
												parametersMap.put("executionResultJson", executionResultJson);

												outEvent = CallUtils.executeUrl(instanceDirectory, nonNativeProcedure.optionsJson, parametersMap);
											}
										} else { // Native
											CallableStatement cs = dbConnection0.getCallableStatement("{call " + notifierStoredProcedureName + "(?,?,?,?)}");
											cs.setString(1, userInfoJson);
											cs.setString(2, selfUserInfoJson);
											cs.setString(3, statementInfoJson);
											cs.setString(4, executionResultJson);

											try (ResultSet rs = cs.executeQuery()) {
												if (rs.next())
													outEvent = rs.getString(1);
											}
										}

									} finally {
										if (dbConnection0 != null)
											connectionPoolManager.releaseConnection(dbConnection0);
										if (outEvent != null) { // send if outEvent is not null
											Writer writer = ac.getResponse().getWriter();
											writer.append(outEvent + '\n');
											writer.flush();
											if (debug) {
												System.out.println("Event was delivered to client:");
												System.out.println(outEvent);
											}
										}
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
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
		} catch (Throwable e) {
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
		sb.append(q("rowCount") + ':' + Integer.toString(rowCount));
		sb.append(',');
		sb.append(q("generatedKeys") + ':' + "[]");
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Generate User Info JSON-formatted string
	 * 
	 * @param request
	 * @param clientInfoJson
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private static String generateUserInfoJson( //
			HttpServletRequest request, //
			String clientInfoJson, //
			CharSequence sessionInfoJson //
	) throws IOException, ParseException {
		String       remoteAddr  = request.getRemoteAddr();
		String       remoteHost  = request.getRemoteHost();
		Integer      remotePort  = request.getRemotePort();
		String       remoteUser  = (String) request.getAttribute(DbServlet.REQUEST_ATTRIBUTE_USER);
		String       remoteRole  = request.getHeader(DbServlet.CUSTOM_HTTP_HEADER_ROLE);
		Cookie[]     cookies     = request.getCookies();
		CharSequence cookiesJson = HttpRequestUtils.getCookiesJson(cookies);
		CharSequence headersJson = HttpRequestUtils.getHttpHeadersJson(request);

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
		sb.append(q("cookies")).append(COLON).append("[]".equals(cookiesJson) ? NULL : cookiesJson).append(COMMA);
		sb.append(q("httpSession")).append(COLON).append(sessionInfoJson);
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
}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
