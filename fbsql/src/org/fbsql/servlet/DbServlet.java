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
import static org.fbsql.servlet.SqlParseUtils.parseConnectStatement;
import static org.fbsql.servlet.SqlParseUtils.parseExposeStatement;
import static org.fbsql.servlet.SqlParseUtils.parseNamedPreparedStatement;
import static org.fbsql.servlet.SqlParseUtils.parseSetIfExistsStatement;
import static org.fbsql.servlet.StringUtils.q;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fbsql.antlr4.parser.ParseStmtConnectTo.StmtConnectTo;
import org.fbsql.antlr4.parser.ParseStmtExpose.StmtExpose;
import org.fbsql.connection_pool.ConnectionPoolManager;
import org.fbsql.connection_pool.DbConnection;
import org.fbsql.servlet.Logger.Severity;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

@WebServlet(asyncSupported = true)
public class DbServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Debug mode flag
	 *
	 * true in debug mode
	 * false in production mode
	 */
	//public static final boolean DEBUG = "true".equals(System.getenv("FBSQL_DEBUG"));
	public static final boolean DEBUG = true; //!!!!!!!!!!!

	/* https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cache-Control */
	private static final String HTTP_HEADER_CACHE_CONTROL = "Cache-Control";

	/* https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Authorization */
	private static final String HTTP_HEADER_AUTHORIZATION = "Authorization";

	/* https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Origin */
	private static final String HTTP_HEADER_ORIGIN = "Origin";

	/* https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers */
	private static final String HTTP_HEADER_ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";

	/* https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin */
	private static final String HTTP_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

	/* https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials */
	private static final String HTTP_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";

	/* https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Methods */
	private static final String HTTP_HEADER_ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

	/**
	 * Custom HTTP header to send SQL statement with GET method
	 * WARNING! This constant used also in JavaScript part
	 */
	public static final String CUSTOM_HTTP_HEADER_CLIENT_INFO = "X-FB-SQL-Client-Info";

	/**
	 * Custom HTTP header to send SQL statement with GET method
	 * WARNING! This constant used also in JavaScript part
	 */
	public static final String CUSTOM_HTTP_HEADER_STATEMENT = "X-FB-SQL-Statement";

	/**
	 * Custom HTTP header to send user role
	 * WARNING! This constant used also in JavaScript part
	 */
	public static final String CUSTOM_HTTP_HEADER_ROLE = "X-FB-SQL-Role";

	/**
	 * Custom HttpServletRequest attribute name to store user name
	 */
	public static final String REQUEST_ATTRIBUTE_USER = "REQUEST_ATTRIBUTE_USER";

	/**
	 * Custom HttpServletRequest attribute name to store session ID
	 */
	public static final String REQUEST_ATTRIBUTE_SESSION_ID = "REQUEST_ATTRIBUTE_SESSION_ID";

	public static final String DB_CONNECTORS_DIR = "DB_CONNECTORS_DIR";
	public static final String CORS_ALLOW_ORIGIN = "CORS_ALLOW_ORIGIN";

	private Map<String /* instance name */, StmtConnectTo>                                                     connectionInfoMap;
	private Map<String /* instance name */, String /* authentication query SQL */>                             authenticationQueryMap;
	private Map<String /* instance name */, ConnectionPoolManager>                                             connectionPoolManagerMap;
	private Map<String /* instance name */, Map<String /* SQL statement name */, StmtExpose>>                  whiteListMap;
	private Map<String /* instance name */, Map<StaticStatement, ReadyResult>>                                 staticJsonsMap;
	private Map<String /* instance name */, Queue<AsyncContext>>                                               ongoingRequestsMap;
	private Map<String /* instance name */, Connection>                                                        connectionMap;
	private Map<String /* instance name */, Map<String /* stored procedure name */, String /* java method */>> instancesProceduresMap;

	private Collection<String> instances;

	/**
	 * Transfer encoding/decoding functionality to request processor 
	 * Instances of Base64.Encoder/Base64.Decoder class are safe for use by multiple concurrent threads.
	 */
	class SharedCoder {
		/**
		 * Base64.Encoder instance
		 */
		Encoder encoder;

		/**
		 * Base64.Decoder instance
		 */
		Decoder decoder;
	}

	private ServletConfig servletConfig;
	private SharedCoder   sharedCoder;

	private ServiceLoader<Driver> loadedDrivers;

	/**
	 * Called by the servlet container to indicate to a servlet that the 
	 * servlet is being placed into service.
	 * 
	 * The servlet container calls the init
	 * method exactly once after instantiating the servlet.
	 * The init method must complete successfully
	 * before the servlet can receive any requests.
	 * 
	 * 
	 * The servlet container cannot place the servlet into service
	 * if the init method
	 * 
	 * @param servletConfig a servlet configuration object used by a servlet container to pass information to a servlet during initialization.
	 * 
	 * Throws a ServletException
	 * Does not return within a time period defined by the Web server
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
		loadedDrivers      = ServiceLoader.load(Driver.class);

		try {
			for (Driver driver : loadedDrivers) {
				DriverManager.registerDriver(driver);
				Logger.out(Severity.INFO, MessageFormat.format("JDBC driver registered: \"{0}\"", driver.getClass().getName()));
			}

			/*
			 * Getting service home directory from servlet parameter (See: 'web.xml' file)
			 */
			String dbConnectorsDir = servletConfig.getInitParameter(DB_CONNECTORS_DIR);
			if (dbConnectorsDir == null || dbConnectorsDir.trim().isEmpty())
				throw new IllegalArgumentException(DB_CONNECTORS_DIR + " is null or empty string");
			// Preprocess name of 'home' directory (initial parameter from 'web.xml' file)
			dbConnectorsDir = StringUtils.putVars(dbConnectorsDir);
			if (dbConnectorsDir.endsWith("/")) // clean path from trailing slash (if specified)
				dbConnectorsDir = dbConnectorsDir.substring(0, dbConnectorsDir.length() - 1);
			Path dbConnectorsDirPath = Paths.get(dbConnectorsDir);
			if (dbConnectorsDirPath.isAbsolute()) {
				Files.createDirectories(dbConnectorsDirPath);
				Logger.out(Severity.INFO, MessageFormat.format("Database connectors directory is: \"{0}\"", dbConnectorsDir));
			} else {
				String message = MessageFormat.format("Bad database connectors directory: \"{0}\". Not absolute path", dbConnectorsDir);
				Logger.out(Severity.FATAL, message);
				throw new ServletException(message);
			}

			/*
			 * Initialize SharedCoder
			 */
			sharedCoder         = new SharedCoder();
			sharedCoder.encoder = Base64.getEncoder().withoutPadding();
			sharedCoder.decoder = Base64.getDecoder();

			File[] instancesDirs = new File(dbConnectorsDir).listFiles(new FileFilter() {

				@Override
				public boolean accept(File file) {
					return file.isDirectory();
				}
			});

			int instancesCount = instancesDirs.length;
			if (instancesCount == 0)
				Logger.out(Severity.WARN, "No connection instances found");
			else
				Logger.out(Severity.INFO, MessageFormat.format("{0} connection instance(s) found", instancesCount));
			//
			connectionPoolManagerMap = new HashMap<>(instancesCount);
			whiteListMap             = new HashMap<>(instancesCount);
			staticJsonsMap           = new HashMap<>(instancesCount);
			connectionInfoMap        = new HashMap<>(instancesCount);
			authenticationQueryMap   = new HashMap<>(instancesCount);
			ongoingRequestsMap       = new HashMap<>(instancesCount);
			connectionMap            = new HashMap<>(instancesCount);
			instancesProceduresMap   = new HashMap<>(instancesCount);

			instances = new ArrayList<>(instancesCount);

			for (File instancesDir : instancesDirs)
				try {
					String instanceName = openInstance(instancesDir);
					instances.add(instanceName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			System.out.println("*** FBSQL started ***");
		} catch (Throwable e) {
			throw new ServletException(e);
		}
	}

	/**
	 * Open database connection instance
	 * 
	 * @param instanceDir
	 * @return
	 * @throws Exception 
	 */
	private String openInstance(File instanceDir) throws Exception {
		String instanceName = instanceDir.getName();

		Logger.out(Severity.INFO, MessageFormat.format("Instance found: ''{0}''", instanceName));

		Path initSqlPath = Paths.get(instanceDir.toPath().toString(), "init.sql");

		List<String /* SQL statements */> initList = new ArrayList<>();
		SqlParseUtils.processIncludes(initSqlPath, initList);

		if (initList.isEmpty())
			return instanceName;

		StmtConnectTo info = null;
		for (String statement : initList) {
			String text = SqlParseUtils.canonizeSql(statement);
			if (text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_CONNECT_TO)) {
				info = parseConnectStatement(servletConfig, statement);
				if (info.jdbcUrl == null) {
					Logger.out(Severity.INFO, MessageFormat.format("Can't connect to ''{0}''. Bad 'CONNECT TO' statement in file: ''{1}''", instanceName, initSqlPath));
					return instanceName;
				}
			} else if (text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_SET_ALLOW_LOGIN_IF_EXISTS)) {
				String authenticationQuery = parseSetIfExistsStatement(servletConfig, statement);
				authenticationQueryMap.put(instanceName, authenticationQuery);
			}
		}

		final boolean debug = info.debug;
		if (debug)
			System.out.println(info);

		connectionInfoMap.put(instanceName, info);
		Queue<AsyncContext> ongoingRequests = new ConcurrentLinkedQueue<>();

		ongoingRequestsMap.put(instanceName, ongoingRequests);

		// Try to register JDBC driver declared into CONNECT TO statement
		ClassLoaderUtils.registerJdbcDriver(info.driverClassName, info.driverJars);

		String     jdbcUrl        = StringUtils.putVars(info.jdbcUrl);
		Properties jdbcProperties = new Properties();
		if (info.jdbcPropertiesFile != null) {
			Path propertiesFilePath = Paths.get(info.jdbcPropertiesFile);
			if (Files.exists(propertiesFilePath) && !Files.isDirectory(propertiesFilePath) && Files.isReadable(propertiesFilePath))
				try (InputStream is = new FileInputStream(info.jdbcPropertiesFile)) {
					jdbcProperties.load(is);
				}
		}

		ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager(jdbcUrl, info.user, info.password, jdbcProperties, info.connectionPoolSizeMin, info.connectionPoolSizeMax);
		try {
			connectionPoolManager.init();
			connectionPoolManagerMap.put(instanceName, connectionPoolManager);
		} catch (SQLException e) {
			Logger.out(Severity.FATAL, MessageFormat.format("WARNING Connection filed: ''{0}''", jdbcUrl));
		}
		//
		Map<StaticStatement, ReadyResult> mapReadyResults = new HashMap<>();
		staticJsonsMap.put(instanceName, mapReadyResults);
		//
		Connection connection;
		if (!jdbcProperties.isEmpty())
			connection = DriverManager.getConnection(jdbcUrl, jdbcProperties);
		else if (info.user != null)
			connection = DriverManager.getConnection(jdbcUrl, info.user, info.password);
		else
			connection = DriverManager.getConnection(jdbcUrl);

		connectionMap.put(instanceName, connection);

		Map<String /* stored procedure name */, String /* java method */>        proceduresMap     = new HashMap<>();
		Map<String /* Cron expression */, List<String /* SQL statement name */>> schedulersMap     = new HashMap<>();
		Map<String /* SQL statement name */, StmtExpose>                         exposedStatements = new HashMap<>();

		whiteListMap.put(instanceName, exposedStatements);
		try (Statement st = connection.createStatement()) {
			//
			// Execute all statements from 'init.sql' script
			// "CONNECT TO" and "SET ALLOW LOGIN IF EXISTS" statements are ignored
			//

			instancesProceduresMap.put(instanceName, proceduresMap);

			for (String statement : initList) {
				if (DEBUG)
					System.out.println("init.sql: -->" + statement + "<--");
				String text = SqlParseUtils.canonizeSql(statement);

				Method method = CallUtils.getCallStatementMethod(statement, proceduresMap);
				if (method != null) { // Process CALL statement
					List<Object> parameterValues = new ArrayList<>();
					parameterValues.add(connection);
					parameterValues.add(instanceName);
					CallUtils.parseSqlParameters(statement, parameterValues);
					method.invoke(null, parameterValues.toArray(new Object[parameterValues.size()]));
				} //
				else if (text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_DECLARE_PROCEDURE)) // Process DECLARE PROCEDURE statement
					SqlParseUtils.parseDeclareProcedureStatement(servletConfig, statement, proceduresMap);
				else if (text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_SCHEDULE))
					SqlParseUtils.parseScheduleStatement(servletConfig, statement, schedulersMap);
				else if (text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_EXPOSE)) {
					StmtExpose stmtExpose = parseExposeStatement(servletConfig, statement);
					exposedStatements.put(stmtExpose.alias, stmtExpose);
				} //
				else if (text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_CONNECT_TO))
					; // ignore
				else if (text.startsWith(SqlParseUtils.SPECIAL_STATEMENT_SET_ALLOW_LOGIN_IF_EXISTS))
					; // ignore
				else // Not a special statements => native SQL
					try {
						st.execute(statement);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}

			for (StmtExpose stmtExpose : exposedStatements.values()) {
				if (!stmtExpose.prefetch)
					continue;

				String sql = stmtExpose.statement;
				//
				// prefetch:
				// «warmed up» static queries with no interaction with underlying database
				//
				try (ResultSet rs = st.executeQuery(sql)) {
					List<Map<String /* column name */, Object /* column value */>> resultsListOfMaps = QueryUtils.resutlSetToListOfMaps(rs);
					List<Map<String /* column name */, String /* JSON value */>>   list              = QueryUtils.listOfMapsToListOfMapsJsonValues(resultsListOfMaps, sharedCoder.encoder);

					//
					// cover all possible result set output formats
					//

					// In this case we ignore user defined compression level and use maximal compression level
					// because we prepare result offline.

					// array of objects
					StaticStatement staticStatement = new StaticStatement(sql, QueryUtils.RESULT_FORMAT_ARRAY_OF_OBJECTS);
					ReadyResult     readyResult     = QueryUtils.createReadyResult(list, staticStatement.resultSetFormat, CompressionLevel.BEST_COMPRESSION, sharedCoder.encoder);
					mapReadyResults.put(staticStatement, readyResult);

					// array of arrays
					staticStatement = new StaticStatement(sql, QueryUtils.RESULT_FORMAT_ARRAY_OF_ARRAYS);
					readyResult     = QueryUtils.createReadyResult(list, staticStatement.resultSetFormat, CompressionLevel.BEST_COMPRESSION, sharedCoder.encoder);
					mapReadyResults.put(staticStatement, readyResult);
				}
			}
		}

		//
		// Schedule jobs
		//
		for (Map.Entry<String /* Cron expression */, List<String /* Scheduled stored procedure name */>> entry : schedulersMap.entrySet()) {
			String       cronExpression       = entry.getKey();
			List<String> storedProcedureNames = entry.getValue();

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					try {
						for (String storedProcedureName : storedProcedureNames) {
							DbConnection dbConnection0 = null;
							try {
								dbConnection0 = connectionPoolManager.getConnection();

								String outEvent   = null;
								String javaMethod = proceduresMap.get(storedProcedureName);
								if (javaMethod == null) {
									CallableStatement cs = dbConnection0.getCallableStatement("{call " + storedProcedureName + "(?,?)}");
									cs.setString(1, instanceName);
									cs.setString(2, cronExpression);
									boolean b = cs.execute();
									if (b) // first result is a ResultSet object
										try (ResultSet rs = cs.getResultSet()) {
											if (rs.next())
												outEvent = rs.getString(1);
										}
								} else {
									String[] array      = javaMethod.split(JAVA_METHOD_SEPARATOR);
									String   className  = array[0];
									String   methodName = array[1];

									Class<?> clazz  = Class.forName(className);
									Method   method = clazz.getMethod(methodName, Connection.class, String.class, String.class);
									Object   result = method.invoke(null, dbConnection0.getConnection(), instanceName, cronExpression);
									if (result instanceof String)
										outEvent = (String) result;
									else if (result instanceof ResultSet)
										try (ResultSet rs = (ResultSet) result) {
											if (rs.next())
												outEvent = rs.getString(1);
										}
								}

								for (AsyncContext ac : ongoingRequests) {
									if (outEvent != null) { // send if outEvent is not null
										Writer writer = ac.getResponse().getWriter();
										writer.append(outEvent + '\n');
										writer.flush();
										if (debug) {
											System.out.println("Background job event was delivered to client:");
											System.out.println(outEvent);
										}
									}
								}
							} finally {
								if (dbConnection0 != null)
									connectionPoolManager.releaseConnection(dbConnection0);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};

			JobDataMap jobDataMap = new JobDataMap();
			jobDataMap.put(RunnableJob.KEY_RUNNABLE, runnable);

			JobDetail jobDetail = JobBuilder.newJob(RunnableJob.class) //
					.usingJobData(jobDataMap) //
					.build();

			Trigger trigger = TriggerBuilder.newTrigger() //
					.startNow() //
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)) //
					.build(); //

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		}

		return instanceName;

	}

	/**
	 * Called by the servlet container to indicate to a servlet that the
	 * servlet is being taken out of service.  This method is
	 * only called once all threads within the servlet's
	 * service method have exited or after a timeout
	 * period has passed. After the servlet container calls this 
	 * method, it will not call the service method again
	 * on this servlet.
	 * 
	 * This method gives the servlet an opportunity 
	 * to clean up any resources that are being held (for example, memory,
	 * file handles, threads) and make sure that any persistent state is
	 * synchronized with the servlet's current state in memory. 
	 */
	@Override
	public void destroy() {
		Logger.out(Severity.INFO, "Servlet destroy() method called by container.");
		List<String> instanceNames = new ArrayList<>(connectionInfoMap.keySet());
		for (String instanceName : instanceNames) {
			Queue<AsyncContext> ongoingRequests = ongoingRequestsMap.remove(instanceName);
			for (Iterator<AsyncContext> iterator = ongoingRequests.iterator(); iterator.hasNext();) {
				AsyncContext asyncContext = iterator.next();
				asyncContext.complete();
				iterator.remove();
			}
			connectionInfoMap.remove(instanceName);
			whiteListMap.remove(instanceName);
			staticJsonsMap.remove(instanceName);
			Connection connection = connectionMap.remove(instanceName);
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ConnectionPoolManager connectionPoolManager = connectionPoolManagerMap.remove(instanceName);
			if (connectionPoolManager != null)
				try {
					connectionPoolManager.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		for (Iterator<Driver> iterator = loadedDrivers.iterator(); iterator.hasNext();) {
			Driver driver = iterator.next();
			try {
				DriverManager.deregisterDriver(driver);
				Logger.out(Severity.INFO, MessageFormat.format("JDBC driver deregistered: \"{0}\"", driver.getClass().getName()));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				iterator.remove();
			}
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] inst_and_oper = getInstanceAndOperation(request);
		if (inst_and_oper.length == 0) { // No instance specified in URL
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No instance specified in URL");
			return;
		}

		String instanceName = inst_and_oper[0];

		if (!connectionInfoMap.containsKey(instanceName)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, StringUtils.formatMessage("Instance Not Found: \"{0}\"", instanceName));
			return;
		}

		request.setAttribute(REQUEST_ATTRIBUTE_USER, request.getRemoteUser());

		//
		// CORS
		// https://developer.mozilla.org/en-US/docs/Glossary/CORS
		//

		response.addHeader(HTTP_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

		String origin          = request.getHeader(HTTP_HEADER_ORIGIN);
		String corsAllowOrigin = servletConfig.getInitParameter(CORS_ALLOW_ORIGIN);

		if (origin == null)
			response.addHeader(HTTP_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		else if (origin.equals("null") || origin.startsWith("file:"))
			response.addHeader(HTTP_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN, origin);
		else if (corsAllowOrigin != null && !corsAllowOrigin.trim().isEmpty())
			response.addHeader(HTTP_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN, corsAllowOrigin);
		else
			response.addHeader(HTTP_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN, origin);

		response.addHeader(HTTP_HEADER_ACCESS_CONTROL_ALLOW_METHODS, "GET,POST");

		response.addHeader(HTTP_HEADER_ACCESS_CONTROL_ALLOW_HEADERS, //
				HTTP_HEADER_CACHE_CONTROL + ',' + //
						HTTP_HEADER_AUTHORIZATION + ',' + //
						CUSTOM_HTTP_HEADER_CLIENT_INFO + ',' + //
						CUSTOM_HTTP_HEADER_STATEMENT + ',' + //
						CUSTOM_HTTP_HEADER_ROLE //
		);

		String authenticationQuery = authenticationQueryMap.get(instanceName);
		if (authenticationQuery != null) {
			String authorization = request.getHeader(HTTP_HEADER_AUTHORIZATION);
			if (authorization != null && authorization.toLowerCase(Locale.ENGLISH).startsWith("basic")) {
				String base64Credentials = authorization.substring("Basic".length()).trim();
				String credentials       = new String(sharedCoder.decoder.decode(base64Credentials), StandardCharsets.UTF_8);
				/* parse username:password */
				String[] userAndPassword = credentials.split(":", 2);

				String user     = userAndPassword[0];
				String password = userAndPassword[1];
				String role     = request.getHeader(CUSTOM_HTTP_HEADER_ROLE);

				//
				// parameters of custom "SET AUTHORIZE USERS IF EXISTS" SQL statement
				//
				Map<String, Object> paramsMap = new HashMap<>();
				paramsMap.put("user", user); // :user parameter
				paramsMap.put("password", password); // :password parameter
				paramsMap.put("role", role); // :role parameter

				try {
					Connection    connection          = connectionMap.get(instanceName);
					StringBuilder preparedStatementSb = new StringBuilder();

					Map<String /* name */, List<Integer /* index */>> paramsIndexes = parseNamedPreparedStatement(authenticationQuery, preparedStatementSb);
					PreparedStatement                                 ps            = connection.prepareStatement(preparedStatementSb.toString());
					ParameterMetaData                                 pmd           = ps.getParameterMetaData();

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
					boolean authorized = false;
					try (ResultSet rs = ps.executeQuery()) {
						authorized = rs.next();
					} finally {
						if (!authorized) {
							authorizationError(response, "Bad combination of user, password, role. Authorization Failed.");
							return;
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
					authorizationError(response, "Authorization query error. Authorization Failed.");
				}

				request.setAttribute(REQUEST_ATTRIBUTE_USER, user);
			} else {
				if (!request.getMethod().trim().toUpperCase(Locale.ENGLISH).equals("OPTIONS")) {
					authorizationError(response, "Authorization Required");
					return;
				}
			}
		}

		String remoteUser = request.getRemoteUser();
		if (remoteUser != null) {
			String role = request.getHeader(CUSTOM_HTTP_HEADER_ROLE);
			if (remoteUser != null && role != null && !request.isUserInRole(role)) {
				authorizationError(response, "User is not in role");
				return;
			}
		}
		super.service(request, response);
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_ACCEPTED); // 202 Accepted. (https://tools.ietf.org/html/rfc7231#section-6.3.3)
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] inst_and_oper = getInstanceAndOperation(request);
		if (inst_and_oper.length == 2) {
			String instanceName = inst_and_oper[0];
			String operName     = inst_and_oper[1];

			//			if (operName.equals("session"))
			//				request.getSession();
			if (operName.equals("events")) {
				Queue<AsyncContext> ongoingRequests = ongoingRequestsMap.get(instanceName);

				response.setHeader("Content-Type", "text/plain; charset=UTF-8");
				response.setHeader(HTTP_HEADER_CACHE_CONTROL, "no-cache, no-store");
				response.setHeader("Connection", "keep-alive");
				//response.setHeader("Transfer-Encoding", "chunked");

				/**
				 * https://tomcat.apache.org/tomcat-9.0-doc/api/org/apache/catalina/Globals.html#ASYNC_SUPPORTED_ATTR
				 */
				//request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
				AsyncContext asyncCtx = request.startAsync(request, response);
				asyncCtx.setTimeout(0); // A timeout value of zero or less indicates no timeout. (https://docs.oracle.com/javaee/6/api/javax/servlet/AsyncContext.html#setTimeout(long))
				asyncCtx.addListener(new AsyncListener() {

					@Override
					public void onComplete(AsyncEvent ae) {
						AsyncContext asyncContext = ae.getAsyncContext();
						ongoingRequests.remove(asyncContext);
					}

					@Override
					public void onTimeout(AsyncEvent ae) {
						AsyncContext asyncContext = null;
						try {
							asyncContext = ae.getAsyncContext();
							asyncContext.complete();
						} catch (Throwable e) {
							e.printStackTrace();
						} finally {
							ongoingRequests.remove(asyncContext);
						}
					}

					@Override
					public void onError(AsyncEvent ae) {
						AsyncContext asyncContext = null;
						try {
							asyncContext = ae.getAsyncContext();
							asyncContext.complete();
						} catch (Throwable e) {
							e.printStackTrace();
						} finally {
							ongoingRequests.remove(asyncContext);
						}
					}

					@Override
					public void onStartAsync(AsyncEvent ae) throws IOException {
					}
				}, request, response);
				ongoingRequests.add(asyncCtx);
			}
		} else
			doDbRequest(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDbRequest(request, response);
	}

	private void doDbRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] inst_and_oper = getInstanceAndOperation(request);

		String                                                            instanceName          = inst_and_oper[0];
		StmtConnectTo                                                     connectionInfo        = connectionInfoMap.get(instanceName);
		ConnectionPoolManager                                             connectionPoolManager = connectionPoolManagerMap.get(instanceName);
		Map<String /* SQL statement name */, StmtExpose>                  whiteList             = whiteListMap.get(instanceName);
		Map<String /* stored procedure name */, String /* java method */> proceduresMap         = instancesProceduresMap.get(instanceName);

		Queue<AsyncContext> ongoingRequests = ongoingRequestsMap.get(instanceName);

		Map<StaticStatement, ReadyResult> mapJson = staticJsonsMap.get(instanceName);
		/**
		 * https://tomcat.apache.org/tomcat-9.0-doc/api/org/apache/catalina/Globals.html#ASYNC_SUPPORTED_ATTR
		 */
		request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		AsyncContext asyncCtx = request.startAsync();
		asyncCtx.setTimeout(0); // A timeout value of zero or less indicates no timeout. (https://docs.oracle.com/javaee/6/api/javax/servlet/AsyncContext.html#setTimeout(long))
		asyncCtx.addListener(new AsyncListener() {

			@Override
			public void onComplete(AsyncEvent ae) {
			}

			@Override
			public void onTimeout(AsyncEvent ae) {
				AsyncContext asyncContext = null;
				try {
					asyncContext = ae.getAsyncContext();
					asyncContext.complete();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onError(AsyncEvent ae) {
				AsyncContext asyncContext = null;
				try {
					asyncContext = ae.getAsyncContext();
					asyncContext.complete();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onStartAsync(AsyncEvent ae) throws IOException {
			}
		}, request, response);
		new DbRequestProcessor( //
				instanceName, //
				asyncCtx, //
				connectionInfo.debug, //
				connectionPoolManager, //
				whiteList, //
				proceduresMap, //
				mapJson, //
				ongoingRequests, //
				sharedCoder //
		).run();

	}

	/**
	 * Extract instance name from request
	 *
	 * @param request - HttpServletRequest request
	 * @return        - empty array if instance was not specified in URL
	 *                - array with single element (instance name) if operation was not specified in URL
	 *                - array with two elements (instance name and operation) if instance name and operation was specified in URL
	 */
	private static String[] getInstanceAndOperation(HttpServletRequest request) {
		String path = request.getPathInfo();
		if (path == null) // case when URL come without slash at the end (E.g. http://localhost:8080/app).
			return new String[0];
		return path.substring(1).split("/");
	}

	/**
	 * 
	 * @param response
	 * @param message
	 * @throws IOException
	 */
	private static void authorizationError(HttpServletResponse response, String message) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		try (OutputStream os = response.getOutputStream()) {
			os.write(("{" + q("message") + ":" + q(message) + "}").getBytes(StandardCharsets.UTF_8));
			os.flush();
		}
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
