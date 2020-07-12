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

package org.fbsql.connection_pool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * DbConnection contains JDBC Connection and associated with this connection prepared statements
 */
public class DbConnection {
	private Connection                     connection;
	private Map<String, PreparedStatement> mapPreparedStatements = new HashMap<>();
	private Map<String, CallableStatement> mapCallableStatements = new HashMap<>();
	private Statement                      st;

	/**
	 * Constructs DbConnection
	 *
	 * @param connection
	 */
	public DbConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Get JDBC Connection
	 *
	 * @return Connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Get PreparedStatement
	 * If the PreparedStatement is not prepared before it will be prepared and stored in map
	 *
	 * @param sql - SQL statement
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		PreparedStatement ps = mapPreparedStatements.get(sql);
		if (ps == null) {
			ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			mapPreparedStatements.put(sql, ps);
		}
		ps.clearParameters();
		return ps;
	}

	/**
	 * Get CallableStatement
	 * If the CallableStatement is not prepared before it will be prepared and stored in map
	 *
	 * @param sql - SQL statement
	 * @return CallableStatement
	 * @throws SQLException
	 */
	public CallableStatement getCallableStatement(String sql) throws SQLException {
		CallableStatement ps = mapCallableStatements.get(sql);
		if (ps == null) {
			ps = connection.prepareCall(sql);
			mapCallableStatements.put(sql, ps);
		}
		ps.clearParameters();
		return ps;
	}

	/**
	 * Get Statement
	 * If the Statement is not created before it will be created and stored as class member
	 *
	 * @return Statement
	 * @throws SQLException
	 */
	public Statement getStatement() throws SQLException {
		if (st == null)
			st = connection.createStatement();
		return st;
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
