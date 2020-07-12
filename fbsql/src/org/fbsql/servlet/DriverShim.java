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

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Allows one to load a JDBC driver at runtime.
 * Workaround which allows to use URLClassLoader for JDBC driver loading,
 * because the DriverManager will refuse to use a driver not loaded by
 * the system ClassLoader
 * The workaround for this is to use a shim class that implements
 * java.sql.Driver. This shim class will do nothing but call the methods
 * of an instance of a JDBC driver that is loaded dynamically. This works
 * because DriverShim is loaded by the system class loader, and DriverManager
 * doesn't care that it invokes a class that wasn't.
 * 
 * Note that we must perform the registration on the instance
 * ourselves.
 * Adapted from http://www.kfu.com/~nsayer/Java/dyn-jdbc.html
 */
public class DriverShim implements Driver {

	/**
	 * The JDBC driver we're wrapping.
	 */
	private Driver driver;

	/**
	 * Constructs a DriverShim over the given driver in order to make it look
	 * like it came from this classloader.
	 * 
	 * @param driver the JDBC driver we're wrapping
	 */
	public DriverShim(Driver driver) {
		this.driver = driver;
	}

	/**
	 * Retrieves whether the driver thinks that it can open a connection
	 * to the given URL.  Typically drivers will return <code>true</code> if they
	 * understand the sub-protocol specified in the URL and <code>false</code> if
	 * they do not.
	 *
	 * @param url the URL of the database
	 * @return <code>true</code> if this driver understands the given URL;
	 *         <code>false</code> otherwise
	 * @exception SQLException if a database access error occurs or the url is
	 * {@code null}
	 */
	@Override
	public boolean acceptsURL(String jdbcUrl) throws SQLException {
		return this.driver.acceptsURL(jdbcUrl);
	}

	@Override
	public Connection connect(String jdbcUrl, Properties properties) throws SQLException {
		return this.driver.connect(jdbcUrl, properties);
	}

	/**
	 * Retrieves the driver's major version number. Initially this should be 1.
	 *
	 * @return this driver's major version number
	 */
	@Override
	public int getMajorVersion() {
		return this.driver.getMajorVersion();
	}

	/**
	 * Gets the driver's minor version number. Initially this should be 0.
	 * @return this driver's minor version number
	 */
	@Override
	public int getMinorVersion() {
		return this.driver.getMinorVersion();
	}

	/**
	* Gets information about the possible properties for this driver.
	* <P>
	* The <code>getPropertyInfo</code> method is intended to allow a generic
	* GUI tool to discover what properties it should prompt
	* a human for in order to get
	* enough information to connect to a database.  Note that depending on
	* the values the human has supplied so far, additional values may become
	* necessary, so it may be necessary to iterate though several calls
	* to the <code>getPropertyInfo</code> method.
	*
	* @param url the URL of the database to which to connect
	* @param info a proposed list of tag/value pairs that will be sent on
	*          connect open
	* @return an array of <code>DriverPropertyInfo</code> objects describing
	*          possible properties.  This array may be an empty array if
	*          no properties are required.
	* @exception SQLException if a database access error occurs
	*/
	@Override
	public DriverPropertyInfo[] getPropertyInfo(String jdbcUrl, Properties properties) throws SQLException {
		return this.driver.getPropertyInfo(jdbcUrl, properties);
	}

	/**
	 * Reports whether this driver is a genuine JDBC
	 * Compliant&trade; driver.
	 * A driver may only report <code>true</code> here if it passes the JDBC
	 * compliance tests; otherwise it is required to return <code>false</code>.
	 * <P>
	 * JDBC compliance requires full support for the JDBC API and full support
	 * for SQL 92 Entry Level.  It is expected that JDBC compliant drivers will
	 * be available for all the major commercial databases.
	 * <P>
	 * This method is not intended to encourage the development of non-JDBC
	 * compliant drivers, but is a recognition of the fact that some vendors
	 * are interested in using the JDBC API and framework for lightweight
	 * databases that do not support full database functionality, or for
	 * special databases such as document information retrieval where a SQL
	 * implementation may not be feasible.
	 * 
	 * @return <code>true</code> if this driver is JDBC Compliant;
	 *         <code>false</code> otherwise
	 */
	@Override
	public boolean jdbcCompliant() {
		return this.driver.jdbcCompliant();
	}

	/**
	* Return the parent Logger of all the Loggers used by this driver. This
	* should be the Logger farthest from the root Logger that is
	* still an ancestor of all of the Loggers used by this driver. Configuring
	* this Logger will affect all of the log messages generated by the driver.
	* In the worst case, this may be the root Logger.
	*
	* @return the parent Logger for this driver
	* @throws SQLFeatureNotSupportedException if the driver does not use
	* {@code java.util.logging}.
	* @since 1.7
	*/
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return this.driver.getParentLogger();
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
