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
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletConfig;

import org.h2.util.ScriptReader;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;

/**
 * Provides utility methods for parsing SQL scripts and statements.
 * 
 * Various utility methods might used to parse SQL scripts or particular SQL statements.
 * Supports syntax of all existing (February 2020) SQL standards. 
*/
public class SqlParseUtils {
	public static final String JAVA_METHOD_SEPARATOR = "::"; // Lambda static method notation: className::methodName

	/**
	 * Special FBSQL statements
	 */
	public static final String SPECIAL_STATEMENT_CONNECT_TO                    = "CONNECT TO";                    // Connect to database instance (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_DECLARE_PROCEDURE             = "DECLARE PROCEDURE";             // Declare stored procedure or function (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_ADD_WHITELIST                 = "ADD WHITELIST";                 // Add whitelist to database instance (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_SET_VALIDATOR                 = "SET VALIDATOR";                 // Set validator stored procedure to SQL statement (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_ADD_NOTIFIER                  = "ADD NOTIFIER";                  // Add notifier stored procedure to SQL statement (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_SCHEDULE                      = "SCHEDULE";                      // Add scheduled stored procedure (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_SET_PREFETCH_FOR              = "SET PREFETCH FOR";              // Set prefetch mode to SQL statement (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_SET_ALLOW_LOGIN_IF_EXISTS     = "SET ALLOW LOGIN IF EXISTS";     // Authenticate/Authorize users (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_SET_ALLOW_STATEMENT_IF_EXISTS = "SET ALLOW STATEMENT IF EXISTS"; // Allow statements (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_CREATE_SESSION                = "CREATE SESSION";                // Session management: Create session
	public static final String SPECIAL_STATEMENT_INVALIDATE_SESSION            = "INVALIDATE SESSION";            // Session management: Invalidate session
	public static final String SPECIAL_STATEMENT_GET_SESSION_INFO              = "GET SESSION INFO";              // Session management: Get session information (session ID, creation time, last accessed time)
	public static final String SPECIAL_STATEMENT_SET_SESSION_ATTRIBUTES        = "SET SESSION ATTRIBUTES";        // Session management: Set custom session attributes
	public static final String SPECIAL_STATEMENT_GET_SESSION_ATTRIBUTES        = "GET SESSION ATTRIBUTES";        // Session management: Get custom session attributes
	public static final String SPECIAL_STATEMENT_ADD_COOKIES                   = "ADD COOKIES";                   // Add cookies
	public static final String SPECIAL_STATEMENT_GET_COOKIES                   = "GET COOKIES";                   // Get cookies

	private static final String[] SPECIAL_CLIENT_STATEMENTS = { //
			SPECIAL_STATEMENT_CREATE_SESSION, //
			SPECIAL_STATEMENT_INVALIDATE_SESSION, //
			SPECIAL_STATEMENT_GET_SESSION_INFO, //
			SPECIAL_STATEMENT_SET_SESSION_ATTRIBUTES, //
			SPECIAL_STATEMENT_GET_SESSION_ATTRIBUTES //
	};

	private static final String[] SPECIAL_SERVER_STATEMENTS = { //
			SPECIAL_STATEMENT_CONNECT_TO, //
			SPECIAL_STATEMENT_DECLARE_PROCEDURE, //
			SPECIAL_STATEMENT_ADD_WHITELIST, //
			SPECIAL_STATEMENT_SET_VALIDATOR, //
			SPECIAL_STATEMENT_ADD_NOTIFIER, //
			SPECIAL_STATEMENT_SCHEDULE, //
			SPECIAL_STATEMENT_SET_PREFETCH_FOR, //
			SPECIAL_STATEMENT_SET_ALLOW_LOGIN_IF_EXISTS, //
			SPECIAL_STATEMENT_SET_ALLOW_STATEMENT_IF_EXISTS //
	};

	/**
	 * SQL statement separator: «;»
	 */
	private static final String STATEMENT_SEPARATOR      = ";";
	/**
	 * Multiline line comment start: «/*»
	 */
	private static final String MULTI_LINE_COMMENT_START = "/*";

	/**
	 * Multiline comment stop: «*​/»
	 */
	private static final String MULTI_LINE_COMMENT_STOP = "*/";

	/**
	 * Single line comment start: «--»
	 */
	private static final String SINGLE_LINE_COMMENT_START = "--";

	/**
	 * Single line comment stop: (Caret return)
	 */
	private static final String SINGLE_LINE_COMMENT_STOP = "\n";

	/**
	 * Single quote: «'»
	 */
	private static final char Q1 = '\'';

	/**
	 * Double quote: «"»
	 */
	private static final char Q2 = '"';

	/**
	 * Returns the index within  SQL  string of the first occurrence of
	 * the specified token.
	 * If a token with value <code>token</code> occurs in the character
	 * sequence represented by  SQL  string  <code>sql</code>, then the
	 * index of the first such occurrence is returned.
	 * This index is the smallest value <i>i</i> such that:
	 * <blockquote><pre>
	 * sql.charAt(<i>i</i>) == token[0]
	 * </pre></blockquote>
	 * is true.
	 *
	 * @param   sql a SQL string.
	 * @param   token to search
	 * @return  the index of the first occurrence of the token in the
	 *          SQL string, or
	 *          <code>-1</code> if the token does not occur.
	 */
	public static int indexOf(String sql, String token) {
		boolean inQ1     = false; // in single quotes flag
		int     inQ1_len = 0;     // counter to count characters inside single quotes
		//
		boolean inQ2     = false; // in double quotes flag
		int     inQ2_len = 0;     // counter to count characters inside double quotes
		//
		int savedTokenOffset = -1;
		int k                = 0; // to iterate inside token
		//
		for (int i = 0; i < sql.length(); i++) {
			char c = sql.charAt(i);
			if (inQ1) {
				if (c == Q1) {
					if ((i != 0 && sql.charAt(i - 1) != Q1) || inQ1_len == 0) { // reset single quotes
						inQ1     = false;
						inQ1_len = 0;
					}
				} else
					inQ1_len++;
			} else if (inQ2) {
				if (c == Q2) {
					if ((i != 0 && sql.charAt(i - 1) != Q2) || inQ2_len == 0) { // reset double quotes
						inQ2     = false;
						inQ2_len = 0;
					}
				} else
					inQ2_len++;
			} else {
				if (c == Q1)
					inQ1 = true;
				else if (c == Q2)
					inQ2 = true;
				else {
					char tc = token.charAt(k);
					if (c == tc) {
						if (k == 0) {
							savedTokenOffset = i;
							if (k == token.length() - 1)
								return savedTokenOffset;
							else
								k++;
						} else if (k == token.length() - 1)
							return savedTokenOffset;
						else
							k++;
					} else {
						savedTokenOffset = -1;
						k                = 0;
					}
				}
			}
		}
		if (k == token.length())
			return savedTokenOffset;
		return -1;
	}

	/**
	 * Parse "SET ... IF EXISTS (..." statements (Example: "SET ALLOW LOGIN IF EXISTS (...")
	 *
	 * @param servletConfig - ServletConfig object
	 * @param prefix        - "SET ... IF EXISTS" prefix
	 * @param sql           - "SET ... IF EXISTS (..." statement
	 * @param info          - ConnectionInfo Transfer object
	 * @return              - internal SQL statement
	 */
	public static String parseSetIfExistsStatement(ServletConfig servletConfig, String prefix, String sql) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		String s = sql.substring(prefix.length()).trim();
		return s.substring(1, s.length() - 1).trim();
	}

	/**
	 * Parse CONNECT statement
	 *
	 * @param sql  - CONNECT statement
	 * @param info - ConnectionInfo Transfer object
	 */
	public static void parseConnectStatement(ServletConfig servletConfig, String sql, ConnectionInfo info) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		info.jdbcUrl               = extractClauseAsString(servletConfig, sql, SPECIAL_STATEMENT_CONNECT_TO); // string
		info.user                  = extractClauseAsString(servletConfig, sql, "USER");                       // string
		info.driverClassName       = extractClauseAsString(servletConfig, sql, "JDBC DRIVER CLASS");          // string
		info.driverJars            = extractClauseAsListOfStrings(servletConfig, sql, "JAR FILES");           // list of strings
		info.password              = extractClauseAsString(servletConfig, sql, "PASSWORD");                   // string
		info.jdbcPropertiesFile    = extractClauseAsString(servletConfig, sql, "JDBC PROPERTIES FILE");       // string
		info.systemPropertiesFile  = extractClauseAsString(servletConfig, sql, "SYSTEM PROPERTIES FILE");     // string   // TODO: Not yet implemented
		info.connectionPoolSizeMin = extractClauseAsInt(servletConfig, sql, "CONNECTION_POOL_SIZE_MIN");      // integer
		info.connectionPoolSizeMax = extractClauseAsInt(servletConfig, sql, "CONNECTION_POOL_SIZE_MAX");      // integer
		info.compressionLevel      = extractClauseAsInt(servletConfig, sql, "COMPRESSION_LEVEL");             // integer
		info.debug                 = extractClauseAsBoolean(servletConfig, sql, "DEBUG");                     // boolean
	}

	/**
	 * Parse SET PREFETCH FOR statement
	 *
	 * @param sql                - SET PREFETCH FOR statement
	 * @param prefetchStatements - Prefetch set for specific SQL statement name
	 */
	public static void parseSetPrefetchStatement(ServletConfig servletConfig, String sql, Collection<String /* SQL statement name */ > prefetchStatements) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		String sqlStatementName = extractClause(servletConfig, sql, SPECIAL_STATEMENT_SET_PREFETCH_FOR);
		prefetchStatements.add(sqlStatementName);
	}

	/**
	 * Parse SET VALIDATOR statement
	 *
	 * @param sql           - SET VALIDATOR statement
	 * @param validatorsMap - Validators Map for specific SQL statement name
	 */
	public static void parseSetValidatorStatement(ServletConfig servletConfig, String sql, Map<String /* SQL statement name */, String /* Validator stored procedure name */> validatorsMap) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		String storedProcedureName = extractClause(servletConfig, sql, SPECIAL_STATEMENT_SET_VALIDATOR);
		String sqlStatementName    = extractClauseAsString(servletConfig, sql, "TO");

		validatorsMap.put(sqlStatementName, storedProcedureName);
	}

	/**
	 * Parse DECLARE PROCEDURE statement
	 *
	 * @param sql           - DECLARE PROCEDURE statement
	 * @param proceduresMap - procedures Map for specific stored procedure name
	 */
	public static void parseDeclareProcedureStatement(ServletConfig servletConfig, String sql, Map<String /* stored procedure name */, String /* java method */> proceduresMap) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		String storedProcedureName = extractClause(servletConfig, sql, SPECIAL_STATEMENT_DECLARE_PROCEDURE).toUpperCase(Locale.ENGLISH);
		String javaMethod          = extractClauseAsString(servletConfig, sql, "FOR");                                                  // <class name> + <.> + <method name>

		proceduresMap.put(storedProcedureName, javaMethod);
	}

	/**
	 * Parse ADD NOTIFIER statement
	 *
	 * @param sql          - ADD NOTIFIER statement
	 * @param notifiersMap - Notifiers Map for specific SQL statement name
	 */
	public static void parseAddNotifierStatement(ServletConfig servletConfig, String sql, Map<String /* SQL statement name */, Collection<String /* Notifier stored procedure name */>> notifiersMap) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		String storedProcedureName = extractClause(servletConfig, sql, SPECIAL_STATEMENT_ADD_NOTIFIER);
		String sqlStatementName    = extractClauseAsString(servletConfig, sql, "TO");

		Collection<String /* Notifier stored procedure name */> notifiers = notifiersMap.get(sqlStatementName);
		if (notifiers == null) {
			notifiers = new LinkedHashSet<>();
			notifiersMap.put(sqlStatementName, notifiers);
		}
		notifiers.add(storedProcedureName);
	}

	/**
	 * Parse ADD WHITELIST statement
	 *
	 * @param sql          - ADD WHITELIST statement
	 * @param notifiersMap - Notifiers Map for specific SQL statement name
	 */
	public static void parseAddWhitelistStatement(ServletConfig servletConfig, String sql, Collection<String /* whitelist file names */ > whiteListFileNames) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		String whiteListFileName = extractClauseAsString(servletConfig, sql, SPECIAL_STATEMENT_ADD_WHITELIST);
		whiteListFileNames.add(whiteListFileName);
	}

	/**
	 * Parse SCHEDULE statement
	 *
	 * @param sql           - SCHEDULE statement
	 * @param schedulersMap - Schedulers Map for specific SQL stored procedures
	 */
	public static void parseScheduleStatement(ServletConfig servletConfig, String sql, Map<String /* Cron expression */, List<String /* Scheduled stored procedure name */ >> schedulersMap) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		String storedProcedureName = extractClauseAsString(servletConfig, sql, SPECIAL_STATEMENT_SCHEDULE);
		String cronExpression      = extractClauseAsString(servletConfig, sql, "AT");

		List<String /* Scheduled stored procedure name */> sqlStatementNames = schedulersMap.get(cronExpression);
		if (sqlStatementNames == null) {
			sqlStatementNames = new ArrayList<>();
			schedulersMap.put(cronExpression, sqlStatementNames);
		}
		sqlStatementNames.add(storedProcedureName);
	}

	/**
	 * Extract particular clause value from SQL statement
	 * 
	 * @param sql    - source SQL statement (trimmed)
	 * @param clause - clause to search (trimmed)
	 * @return       - clause value
	 */
	static List<Object> extractClauseAsList(ServletConfig servletConfig, String sql, String clause) {
		String s = extractClause(servletConfig, sql, clause);
		if (s == null)
			return null;
		String[]     arr    = s.split(",");
		List<Object> values = new ArrayList<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			String val = arr[i].trim();
			if (val.isEmpty())
				values.add(null);
			else if (val.startsWith("'") || val.startsWith("\""))
				values.add(val.substring(1, val.length() - 1));
			else if (val.toLowerCase(Locale.ENGLISH).equals("null"))
				values.add(null);
			else if (val.toLowerCase(Locale.ENGLISH).equals("true"))
				values.add(true);
			else if (val.toLowerCase(Locale.ENGLISH).equals("false"))
				values.add(false);
			else if (val.charAt(0) == '-' || Character.isDigit(val.charAt(0)))
				values.add(Double.parseDouble(val));
			else
				values.add(val);
		}
		return values;
	}

	/**
	 * Extract particular clause value from SQL statement
	 * 
	 * @param sql    - source SQL statement (trimmed)
	 * @param clause - clause to search (trimmed)
	 * @return       - clause value
	 */
	static List<String> extractClauseAsListOfStrings(ServletConfig servletConfig, String sql, String clause) {
		String s = extractClause(servletConfig, sql, clause);
		if (s == null)
			return null;
		List<Object> values    = extractClauseAsList(servletConfig, sql, clause);
		List<String> strValues = new ArrayList<>(values.size());
		for (int i = 0; i < values.size(); i++) {
			Object val = values.get(i);
			if (val instanceof String) {
				String v = (String) val;
				if (!v.isEmpty())
					strValues.add(v);
			}
		}
		return strValues;
	}

	/**
	 * Extract particular clause value from SQL statement
	 * 
	 * @param sql    - source SQL statement (trimmed)
	 * @param clause - clause to search (trimmed)
	 * @return       - clause value
	 */
	public static String extractClauseAsString(ServletConfig servletConfig, String sql, String clause) {
		String s = extractClause(servletConfig, sql, clause);
		if (s == null)
			return null;
		return s;
	}

	/**
	 * Extract particular clause value from SQL statement
	 * 
	 * @param sql    - source SQL statement (trimmed)
	 * @param clause - clause to search (trimmed)
	 * @return       - clause value
	 */
	static Integer extractClauseAsInt(ServletConfig servletConfig, String sql, String clause) {
		String s = extractClause(servletConfig, sql, clause);
		if (s == null)
			return null;
		return Integer.parseInt(s);
	}

	/**
	 * Extract particular clause value from SQL statement
	 * 
	 * @param sql    - source SQL statement (trimmed)
	 * @param clause - clause to search (trimmed)
	 * @return       - clause value
	 */
	static boolean extractClauseAsBoolean(ServletConfig servletConfig, String sql, String clause) {
		String s = extractClause(servletConfig, sql, clause);
		if (s == null)
			return false;
		return Boolean.parseBoolean(s);
	}

	/**
	 * Extract particular clause value from SQL statement
	 * 
	 * @param sql    - source SQL statement (trimmed)
	 * @param clause - clause to search (trimmed)
	 * @return       - clause value
	 */
	private static String extractClause(ServletConfig servletConfig, String sql, String clause) {
		String upperSql    = sql.toUpperCase(Locale.ENGLISH);
		String upperClause = clause.toUpperCase(Locale.ENGLISH);
		while (true) {
			int pos = indexOf(upperSql, upperClause);
			if (pos == -1) {
				if (servletConfig == null)
					return null;
				String value = servletConfig.getInitParameter(upperClause);
				if (value == null || value.trim().isEmpty())
					return null;
				return value;
			}

			if (pos != 0) {
				char prevChar = sql.charAt(pos - 1);
				if (!(prevChar == ' ' || prevChar == '\t' || prevChar == '/' || prevChar == '\'' || prevChar == '"' || prevChar == ')')) { // previous clause must be ended
					sql      = sql.substring(pos + 1);
					upperSql = upperSql.substring(pos + 1);
					continue;
				}
			}

			int nextCharPos = pos + clause.length();
			if (nextCharPos <= sql.length() - 1) {
				char nextChar = sql.charAt(nextCharPos);
				if (!(nextChar == ' ' || nextChar == '\t' || nextChar == '/' || nextChar == '\'' || nextChar == '"' || nextChar == '(')) { // next clause must be ended
					sql      = sql.substring(pos + 1);
					upperSql = upperSql.substring(pos + 1);
					continue;
				}
			}

			String value = sql.substring(pos + clause.length()).trim();
			char   quote = value.charAt(0);                            // get single «'» or double «"» quote
			if (quote == Q1 || quote == Q2) { // string
				pos = value.indexOf(quote, 1);
				return value.substring(1, pos).trim();
			} else if (quote == '(') { // list
				pos = value.indexOf(')', 1);
				return value.substring(1, pos).trim();
			} else { // number
				int posBlank = pos = value.indexOf(' ');
				int posTab   = value.indexOf('\t');
				if (posBlank == -1 && posTab != -1)
					pos = posTab;
				else if (posBlank != -1 && posTab == -1)
					pos = posBlank;
				else if (posBlank != -1 && posTab != -1)
					pos = Math.min(posBlank, posTab);
				else
					pos = value.length();
				return value.substring(0, pos).trim();
			}
		}
	}

	/**
	 * Remove the comments from SQL statement, if exists.
	 * Multiline line (block) comments (start: «/*», stop: «*​/»)
	 * Single line comments    (start: «--», stop: «\n»)
	 *
	 * @param   sql a SQL string with comments.
	 * @return  a SQL string without comments
	 */
	static String stripComments(String sql) {
		sql = stripBlockComments(sql); // Strip block comments (start: «/*» stop: «*​/»)
		sql = stripLineComments(sql);  // Strip line comments (start: «--», stop: «\n»)
		return sql;
	}

	/**
	 * Remove the comments from SQL statement, if exists.
	 * Multiline line (block) comments (start: «/*», stop: «*​/»)
	 * Single line comments    (start: «--», stop: «\n»)
	 *
	 * @param   sql a SQL string with comments.
	 * @return  a SQL string without comments
	 */
	private static String stripLineComments(String sql) {
		// Strip line comments (start: «--», stop: «\n»)
		while (true) {
			int offset = indexOf(sql, SINGLE_LINE_COMMENT_START);
			if (offset == -1)
				break;
			int pos2 = sql.indexOf(SINGLE_LINE_COMMENT_STOP, offset);
			if (pos2 == -1)
				sql = sql.substring(0, offset);
			else
				sql = sql.substring(0, offset) + sql.substring(pos2);
		}
		return sql.trim();
	}

	/**
	 * Remove the comments from SQL statement, if exists.
	 * Multiline line (block) comments (start: «/*», stop: «*​/»)
	 * Single line comments    (start: «--», stop: «\n»)
	 *
	 * @param   sql a SQL string with comments.
	 * @return  a SQL string without comments
	 */
	private static String stripBlockComments(String sql) {
		// Strip block comments (start: «/*» stop: «*​/»)
		while (true) {
			int offset = indexOf(sql, MULTI_LINE_COMMENT_START);
			if (offset == -1)
				break;
			int pos2 = sql.indexOf(MULTI_LINE_COMMENT_STOP, offset);
			sql = sql.substring(0, offset) + sql.substring(pos2 + 2);
		}
		return sql.trim();
	}

	/**
	 * Parse SQL script by splitting it on SQL statements
	 * Standard semicolon character «;» is used as statement separator.
	 *
	 * This method also:
	 * - compress row(s) of each SQL statement by removing
	 * ambiguous  trailing white spaces characters.
	 * - remove trailing statement separator «;»
	 *
	 * @param sqlScript  - SQL script to parse
	 * @param list       - list of all presented in script SQL statements
	 * @param names      - list of names presented in script SQL statements (null entry if name was not specified)
	 * @param roles      - list of roles presented in script SQL statements (null entry if name was not specified)
	 * @param statics    - list of immutable SQL statements presented in script (null entry if name was not specified)
	 * @param validators - list of JavaScript validator function name
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	static void parseScript(String sqlScript, List<String /* SQL statements */> list, List<String /* SQL statement name */> $names) throws IOException, NoSuchAlgorithmException {
		try (ScriptReader scriptReader = new ScriptReader(new StringReader(sqlScript))) {
			while (true) {
				/**
				 * Trimmed SQL statement
				 */
				String stat = scriptReader.readStatement();
				if (stat == null)
					break;
				stat = stat.trim();

				/**
				 * SQL statement name
				 */
				String $name = null;

				/* Search for provided SQL statement name */
				String[] lines = stat.split("\n");
				for (int i = 0; i < lines.length; i++) {
					String line = lines[i].trim();
					if (line.startsWith("-- #")) { // name declaration found («#» - statement name prefix)
						$name = line.substring(4).trim(); // $name («#» character is not included)
						int pos = $name.indexOf(' ');
						if (pos == -1)
							pos = $name.indexOf('\t');
						if (pos != -1)
							$name = $name.substring(0, pos).trim();
						break;
					}
				}
				if ($name == null) // name not provided, create default
					$name = calcSha256(stat);

				String sql = processStatement(stat);
				if (!sql.isEmpty()) {
					list.add(sql);
					$names.add($name);
				}
			}
		}
	}

	/**
	 * Calculate SHA-256 hash of string
	 *
	 * @param s - source string
	 * @return  - lower case SHA-256 hash of source string
	 * @throws NoSuchAlgorithmException
	 */
	private static String calcSha256(String s) throws NoSuchAlgorithmException {
		MessageDigest digest    = MessageDigest.getInstance("SHA-256");
		byte[]        bs        = digest.digest(s.getBytes(StandardCharsets.UTF_8));
		StringBuffer  hexString = new StringBuffer();
		for (int i = 0; i < bs.length; i++) {
			String hex = Integer.toHexString(0xff & bs[i]).toLowerCase(Locale.ENGLISH);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	/**
	 * Process SQL statement
	 *
	 * @param sql - SQL statement
	 * @return    - processed SQL statement
	 */
	public static String processStatement(String sql) {
		sql = sql.trim();
		while (sql.endsWith(STATEMENT_SEPARATOR)) // remove trailing separator(s)
			sql = sql.substring(0, sql.length() - 1).trim();
		sql = stripComments(sql).trim();
		StringBuilder sb    = new StringBuilder();
		String[]      lines = sql.split("\n");
		for (int i = 0; i < lines.length; i++)
			sb.append(' ' + lines[i].trim() + '\n');
		return sb.toString().trim();
	}

	/**
	 * Parse SQL script by splitting it on SQL statements
	 * Standard semicolon character «;» is used as statement separator.
	 *
	 * This method also:
	 * - compress row(s) of each SQL statement by removing
	 * ambiguous  trailing white spaces characters.
	 * - remove trailing statement separator «;»
	 *
	 * @param sqlScript - SQL script to parse
	 * @param list      - list of all presented in script SQL statements
	 * @throws IOException 
	 */
	static void parseScript(String sqlScript, List<String /* SQL statements */> list) throws IOException {
		try (ScriptReader scriptReader = new ScriptReader(new StringReader(sqlScript))) {
			while (true) {
				String stat = scriptReader.readStatement();
				if (stat == null)
					break;
				stat = stat.trim();
				stat = stripComments(stat).trim();
				if (!stat.isEmpty())
					list.add(stat);
			}
		}

	}

	//	/**
	//	 * Parse named prepared statement and return parameter name to index map and
	//	 * replace host variables with '?' character to provide standard prepared statement form
	//	 * 
	//	 * @param sql       - named prepared statement
	//	 * @param resultSQL - standard prepared statement
	//	 * @return            map parameter name to index (indexes starts from 1) 
	//	 */
	//	public static Map<String /* name */, List<Integer /* index */>> parseNamedPreparedStatement222(String sql, StringBuilder resultSQL) {
	//		Map<String /* name */, List<Integer /* index */>> map = new LinkedHashMap<>();
	//
	//		int index = 0;
	//		while (true) {
	//			int offset = indexOf(sql, ":");
	//			if (offset == -1)
	//				break;
	//			int pos = indexOf(sql, offset, "= ,+-*/)"); // list of 'stop' characters
	//			if (pos == -1) // end of line and end of variable are reached
	//				pos = sql.length();
	//			String name = sql.substring(offset + 1, pos).trim();
	//			index++;
	//			//
	//			List<Integer /* index */> indexes = map.get(name);
	//			if (indexes == null) {
	//				indexes = new ArrayList<>();
	//				map.put(name, indexes);
	//			}
	//			indexes.add(index);
	//
	//			sql = sql.substring(0, offset) + '?' + sql.substring(pos);
	//		}
	//		resultSQL.append(sql);
	//		return map;
	//	}

	/**
	 * Parse named prepared statement and return parameter name to index map and
	 * replace host variables with '?' character to provide standard prepared statement form
	 * 
	 * @param sql       - named prepared statement
	 * @param resultSQL - standard prepared statement
	 * @return            map parameter name to index (indexes starts from 1) 
	 */
	public static Map<String /* name */, List<Integer /* index */>> parseNamedPreparedStatement(String sql, StringBuilder resultSQL) {
		Map<String /* name */, List<Integer /* index */>> map = new LinkedHashMap<>();

		ParsedSql psql = NamedParameterUtils.parseSqlStatement(sql);
		resultSQL.append(NamedParameterUtils.parseSqlStatementIntoString(sql));

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		List<SqlParameter>    params                = NamedParameterUtils.buildSqlParameterList(psql, mapSqlParameterSource);
		//		
		for (int i = 0; i < params.size(); i++) {
			String name = params.get(i).getName();

			List<Integer /* index */> indexes = map.get(name);
			if (indexes == null) {
				indexes = new ArrayList<>();
				map.put(name, indexes);
			}
			indexes.add(i + 1);
		}
		//		int index = 0;
		//		while (true) {
		//			int offset = indexOf(sql, ":");
		//			if (offset == -1)
		//				break;
		//			int pos = indexOf(sql, offset, "= ,+-*/)"); // list of 'stop' characters
		//			if (pos == -1) // end of line and end of variable are reached
		//				pos = sql.length();
		//			String name = sql.substring(offset + 1, pos).trim();
		//			index++;
		//			//
		//			List<Integer /* index */> indexes = map.get(name);
		//			if (indexes == null) {
		//				indexes = new ArrayList<>();
		//				map.put(name, indexes);
		//			}
		//			indexes.add(index);
		//
		//			sql = sql.substring(0, offset) + '?' + sql.substring(pos);
		//		}
		//		resultSQL.append(sql);
		return map;
	}

	public static void main(String[] args) {
		//	replaceFunction(null, "SELCET MY(?, 'zz, ?, z', ?, 333, ?) FROM ttt", "MY", null);

		//		processCallStatement(null, "CALL MY(the quick,\"brown, fox jumps\", ?, 12.5, :zek, -300, over,\"the\",,\"lazy dog\") > 0", "MY", null);
		//		//replaceFunction(null, "SELCET MY(?, \"zz, ?, z\", ?, 333, ?) FROM ttt", "MY", null);
		String    sql1  = "/*+ HINT */ xxx /* comment ? */ :a 'yyyy' :b :c :a zzzzz -- :xx XX\n";
		ParsedSql psql1 = NamedParameterUtils.parseSqlStatement(sql1);
		//		//		  assertEquals("/*+ HINT */ xxx /* comment ? */ ? yyyy ? ? ? zzzzz -- :xx XX\n",
		//		//		      NamedParameterUtils.substituteNamedParameters(psql1, null));
		String z = NamedParameterUtils.parseSqlStatementIntoString(sql1);
		System.out.println(z);
		MapSqlParameterSource map    = new MapSqlParameterSource();
		List<SqlParameter>    params = NamedParameterUtils.buildSqlParameterList(psql1, map);
		//		
		for (SqlParameter object : params) {
			System.out.println(object.getName());
		}
		//		//System.out.println(params);
		//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		//		paramMap.addValue("a", "a");
		//		paramMap.addValue("b", "b");
		//		paramMap.addValue("c", "c");
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<String> parseSqlFile(Path path) throws IOException {
		List<String> list = new ArrayList<>();
		String       s    = StringUtils.readAsText(path);
		parseScript(s, list);
		return list;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isSpecialClientStatement(String s) {
		for (String st : SPECIAL_CLIENT_STATEMENTS)
			if (indexOf(s, st) == 0)
				return true;
		return false;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isSpecialServerStatement(String s) {
		for (String st : SPECIAL_SERVER_STATEMENTS)
			if (indexOf(s, st) == 0)
				return true;
		return false;
	}

	//	/**
	//	 * Iterate over 'stop' characters list and return index of closest to offset 'stop' character
	//	 * or -1 if end of string reached.
	//	 * 
	//	 * @param s      - search source
	//	 * @param offset - the index to start the search from.
	//	 * @param chars  - list of stop-characters.
	//	 * @return       - index of closest to offset 'stop' character
	//	 * or -1 if end of string reached.
	//	 */
	//	private static int indexOf(String s, int offset, String chars) {
	//		int     minPos = -1;
	//		boolean found  = false;
	//		for (int i = 0; i < chars.length(); i++) {
	//			char c   = chars.charAt(i);
	//			int  pos = s.indexOf(c, offset);
	//			if (pos == -1)
	//				continue;
	//			if (found)
	//				minPos = Math.min(minPos, pos);
	//			else {
	//				found  = true;
	//				minPos = pos;
	//			}
	//		}
	//		return minPos;
	//	}

}
/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
