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

package org.fbsql.connection_pool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * Connection pool used to connect to database using a pre-created set of reusable connections.
 * When a new connection is required, an arbitrary available connection is retrieved from the pool.
 * When connection closed, it is returned to connection pool for future use.
 */
public class ConnectionPoolManager implements AutoCloseable {

	private int initialPoolSize;
	private int maxPoolSize;
	//
	private String     jdbcUrl;
	private String     jdbcUser;
	private String     jdbcPassword;
	private Properties jdbcProperties;
	//
	private List<DbConnection>       availableList;
	private Collection<DbConnection> inUseList;

	/**
	 * Constructs ConnectionPoolManager
	 * 
	 * @param jdbcUrl
	 * @param jdbcUser
	 * @param jdbcPassword
	 * @param jdbcProperties
	 * @param initialPoolSize
	 * @param maxPoolSize
	 */
	public ConnectionPoolManager(String jdbcUrl, String jdbcUser, String jdbcPassword, Properties jdbcProperties, int initialPoolSize, int maxPoolSize) {
		this.jdbcUrl         = jdbcUrl;
		this.jdbcUser        = jdbcUser;
		this.jdbcPassword    = jdbcPassword;
		this.jdbcProperties  = jdbcProperties;
		this.initialPoolSize = initialPoolSize;
		this.maxPoolSize     = maxPoolSize;
	}

	/**
	 * Initialize ConnectionPoolManager
	 * 
	 * @throws SQLException
	 */
	public void init() throws SQLException {
		inUseList     = Collections.synchronizedList(new ArrayList<>(initialPoolSize));
		availableList = Collections.synchronizedList(new ArrayList<>(initialPoolSize));
		for (int i = 0; i < initialPoolSize; i++)
			addNewConnection();
	}

	/**
	 * Close ConnectionPoolManager
	 */
	@Override
	public void close() throws SQLException {
		for (Iterator<DbConnection> iterator = inUseList.iterator(); iterator.hasNext();) {
			DbConnection dbConnection = iterator.next();
			dbConnection.getConnection().commit();
			availableList.add(dbConnection);
			iterator.remove();
		}
		for (Iterator<DbConnection> iterator = availableList.iterator(); iterator.hasNext();) {
			iterator.next().getConnection().close();
			iterator.remove();
		}
	}

	/**
	 * Get available connection from pool
	 * 
	 * @return
	 * @throws SQLException
	 */
	public synchronized DbConnection getConnection() throws SQLException {
		if (availableList.isEmpty())
			if (inUseList.size() < maxPoolSize)
				addNewConnection();
			else // no available connections
				throw new SQLException("Connection pool size exceeds maximum value");
		DbConnection dbConnection = availableList.remove(availableList.size() - 1);
		inUseList.add(dbConnection);
		return dbConnection;
	}

	/**
	 * Release connection
	 * 
	 * @param dbConnection
	 * @return true if connection successfully released
	 * @throws SQLException
	 */
	public boolean releaseConnection(DbConnection dbConnection) throws SQLException {
		dbConnection.getConnection().commit();
		availableList.add(dbConnection);
		return inUseList.remove(dbConnection);
	}

	/**
	 * Add new connection to pool
	 * 
	 * @throws SQLException
	 */
	private void addNewConnection() throws SQLException {
		Connection connection;
		if (jdbcProperties != null && !jdbcProperties.isEmpty())
			connection = DriverManager.getConnection(jdbcUrl, jdbcProperties);
		else if (jdbcUser != null)
			connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
		else
			connection = DriverManager.getConnection(jdbcUrl);

		connection.setAutoCommit(false);

		DbConnection dbConnection = new DbConnection(connection);
		availableList.add(dbConnection);
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableList, inUseList, initialPoolSize, jdbcPassword, jdbcProperties, jdbcUrl, jdbcUser, maxPoolSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionPoolManager other = (ConnectionPoolManager) obj;
		return Objects.equals(availableList, other.availableList) && Objects.equals(inUseList, other.inUseList) && initialPoolSize == other.initialPoolSize && Objects.equals(jdbcPassword, other.jdbcPassword) && Objects.equals(jdbcProperties, other.jdbcProperties) && Objects.equals(jdbcUrl, other.jdbcUrl) && Objects.equals(jdbcUser, other.jdbcUser) && maxPoolSize == other.maxPoolSize;
	}

	@Override
	public String toString() {
		return String.format("ConnectionPoolManager [jdbcUrl=%s, jdbcUser=%s, jdbcProperties=%s, initialPoolSize=%s, maxPoolSize=%s]", jdbcUrl, jdbcUser, jdbcProperties, initialPoolSize, maxPoolSize);
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
