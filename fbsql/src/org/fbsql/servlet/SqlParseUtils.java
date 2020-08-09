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

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletConfig;

import org.fbsql.antlr4.parser.ParseStmtConnectTo;
import org.fbsql.antlr4.parser.ParseStmtConnectTo.StmtConnectTo;
import org.fbsql.antlr4.parser.ParseStmtDeclareProcedure;
import org.fbsql.antlr4.parser.ParseStmtDeclareProcedure.StmtDeclareProcedure;
import org.fbsql.antlr4.parser.ParseStmtExpose;
import org.fbsql.antlr4.parser.ParseStmtExpose.StmtExpose;
import org.fbsql.antlr4.parser.ParseStmtInclude;
import org.fbsql.antlr4.parser.ParseStmtScheduleAt;
import org.fbsql.antlr4.parser.ParseStmtScheduleAt.StmtScheduleAt;
import org.fbsql.antlr4.parser.ParseStmtSwitchTo;
import org.fbsql.antlr4.parser.ParseStmtSwitchTo.StmtSwitchTo;
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

	/**
	 * Special FBSQL statements that
	 * can be used only in «init.sql» script
	 */
	public static final String SPECIAL_STATEMENT_CONNECT_TO        = canonizeSql("CONNECT TO");        // Connect to database instance (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_SWITCH_TO         = canonizeSql("SWITCH TO");         // Switch connection to database instance (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_DECLARE_PROCEDURE = canonizeSql("DECLARE PROCEDURE"); // Declare non native stored procedure written in one of JVM languages
	public static final String SPECIAL_STATEMENT_SCHEDULE          = canonizeSql("SCHEDULE");          // Add scheduled stored procedure (can be used only in «init.sql» script)
	public static final String SPECIAL_STATEMENT_EXPOSE            = canonizeSql("EXPOSE");            // Expose corresponding native SQL statement to frontend
	public static final String SPECIAL_STATEMENT_INCLUDE           = canonizeSql("INCLUDE");           // Include script file(s) (can be used only in «init.sql» script)

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
	 * Parse CONNECT statement
	 *
	 * @param sql  - CONNECT statement
	 * @param info - ConnectionInfo Transfer object
	 */
	public static StmtConnectTo parseConnectStatement(ServletConfig servletConfig, String sql) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		return new ParseStmtConnectTo().parse(servletConfig, sql);
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

		StmtDeclareProcedure stmtDeclareProcedure = new ParseStmtDeclareProcedure().parse(sql);
		stmtDeclareProcedure.procedure = stmtDeclareProcedure.procedure.toUpperCase(Locale.ENGLISH);

		String storedProcedureName = stmtDeclareProcedure.procedure.toUpperCase(Locale.ENGLISH);
		String javaMethod          = stmtDeclareProcedure.javaMethod;                           // <class name> + <::> + <method name>

		proceduresMap.put(storedProcedureName, javaMethod);
	}

	/**
	 * Parse EXPOSE statement
	 *
	 * @param sql - EXPOSE statement
	 * @throws NoSuchAlgorithmException 
	 */
	public static StmtExpose parseExposeStatement(ServletConfig servletConfig, String sql) {
		sql = stripComments(sql).trim();
		sql = sql.replace('\n', ' ');
		sql = sql.replace('\r', ' ');
		sql = processStatement(sql);

		ParseStmtExpose parseStmtExpose = new ParseStmtExpose();
		StmtExpose      stmtExpose      = parseStmtExpose.parse(sql);

		stmtExpose.statement = processStatement(stmtExpose.statement);
		return stmtExpose;
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

		StmtScheduleAt scheduleAt          = new ParseStmtScheduleAt().parse(sql);
		String         storedProcedureName = scheduleAt.procedure;
		String         cronExpression      = scheduleAt.cronExpression;

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
		return map;
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
	 * @param list      - list of all presented in script SQL statements (output parameter)
	 * @throws IOException 
	 */
	private static void readSqlScriptToList(String sqlScript, List<String /* SQL statements */> list) throws IOException {
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

	/**
	 * Recursive method to process "INCLUDE SCRIPT FILE" statement
	 *
	 * @param path       - path to SQL script to parse
	 * @param list       - list of all presented in script SQL statements with injected includes (output parameter)
	 * @throws IOException
	 */
	private static void processIncludes(Path path, List<String /* SQL statements */> list) throws IOException {
		List<String /* SQL statements */> singleFileList = new ArrayList<>();
		readSqlScriptToList(StringUtils.readAsText(path), singleFileList);

		for (String statement : singleFileList) {
			String statementUpperCase = statement.toUpperCase(Locale.ENGLISH);
			if (statementUpperCase.startsWith(SPECIAL_STATEMENT_INCLUDE)) {
				List<String> fileNames = new ParseStmtInclude().parse(statement).fileNames;
				for (String fileName : fileNames) {
					if (fileName.startsWith("/"))
						path = Paths.get(fileName);
					else
						path = Paths.get(path.getParent().toString(), fileName);
					if (Files.exists(path))
						processIncludes(path, list); // recursive call
				}
			} else
				list.add(statement);
		}
	}

	/**
	 * Read 'init.sql' file record by record and divide it by instance name to map
	 *
	 * @param path
	 * @param map
	 * @throws IOException
	 */
	private static void separateSqlFile(List<String /* SQL statements */> list, Map<String /* connection name */, List<String /* SQL statements */>> map) throws IOException {
		String       instanceName = null;
		List<String> listBuffer   = null;
		for (String statement : list) {
			String canonizedStatement = canonizeSql(statement);
			if (canonizedStatement.startsWith(SPECIAL_STATEMENT_CONNECT_TO)) {
				StmtConnectTo stmtConnectTo = new ParseStmtConnectTo().parse(null, statement);
				instanceName = stmtConnectTo.instanceName;
				listBuffer   = new ArrayList<>();
				listBuffer.add(statement);
				map.put(instanceName, listBuffer);
			} else if (canonizedStatement.startsWith(SPECIAL_STATEMENT_SWITCH_TO)) {
				StmtSwitchTo stmtSwitchTo = new ParseStmtSwitchTo().parse(null, statement);
				instanceName = stmtSwitchTo.instanceName;
				listBuffer   = map.get(instanceName);
				if (listBuffer == null)
					throw new Error("CONNECT TO required prior " + statement);
			} else {
				if (listBuffer == null)
					throw new Error("CONNECT TO required prior " + statement);
				listBuffer.add(statement);
			}
		}
	}

	/**
	 * Iterate directory recursive, find 'init.sql' files, and process them.
	 *
	 * @param path
	 * @param map
	 * @throws IOException
	 */
	public static void processInitSqlFiles(File file, Map<String /* connection name */, List<String /* SQL statements */>> map) throws IOException {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files)
					processInitSqlFiles(f, map);
			}
		} else if (file.getName().equals("init.sql"))
			processInitSqlFile(file.toPath(), map);
	}

	/**
	 * Read 'init.sql' file, process 'includes', iterate record by record and divide it by instance name to map
	 *
	 * @param path
	 * @param map
	 * @throws IOException
	 */
	private static void processInitSqlFile(Path path, Map<String /* connection name */, List<String /* SQL statements */>> map) throws IOException {
		List<String /* SQL statements */> list = new ArrayList<>();
		processIncludes(path, list);
		separateSqlFile(list, map);
	}

	public static void main(String[] args) throws IOException {
		Map<String /* connection name */, List<String /* SQL statements */>> map = new LinkedHashMap<>();
		//processInitSqlFile(Paths.get("/home/qsecofr/fbsql/config/db/my-sqlite/init.sql"), map);
		processInitSqlFiles(Paths.get("/home/qsecofr/fbsql/config/db").toFile(), map);
		//processInitSqlFile(Paths.get("/home/qsecofr/fbsql/config/db"), map);
		System.out.println(map);
	}

	/**
	 * Canonize SQL statement for compare (startsWith)
	 * 
	 * E.g. "connect to" - > "CONNECTTO"
	 * @param sql
	 * @return
	 */
	public static String canonizeSql(String sql) {
		sql = stripComments(sql).trim();
		sql = sql.replace("\n", "");
		sql = sql.replace("\r", "");
		sql = sql.replace("\t", "");
		sql = sql.replace(" ", "");
		sql = sql.toUpperCase(Locale.ENGLISH);
		return sql;
	}
}
/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
