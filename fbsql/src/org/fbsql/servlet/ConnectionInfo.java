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

import java.util.List;

/**
 * DTO (Data Transfer Object) that holds RDBMS connection meta data
 * Field values comes from parsing of "CONNECT TO" SQL statement
 * 
 * @see SqlParseUtils#parseConnectStatement(String)
 */
public class ConnectionInfo {
	/**
	 * Value from "CONNECT TO" clause
	 */
	String jdbcUrl;

	/**
	 * Value from "DRIVER_CLASS" clause
	 */
	String driverClassName;

	/**
	 * Value from "DRIVER_JARS" clause
	 */
	List<String> driverJars;

	/**
	 * Value from "USER" clause
	 */
	String user;

	/**
	 * Value from "PASSWORD" clause
	 */
	String password;

	/**
	 * Value from "JDBC PROPERTIES FILE" clause
	 * Java (*.properties) file contains JDBC properties
	 */
	String jdbcPropertiesFile;

	/**
	 * Value from "SYSTEM PROPERTIES FILE" clause
	 * Java (*.properties) file contains JDBC properties
	 */
	String systemPropertiesFile;

	/**
	 * Value from "CONNECTION_POOL_SIZE_MIN" clause
	 */
	Integer connectionPoolSizeMin;

	/**
	 * Value from "CONNECTION_POOL_SIZE_MAX" clause
	 */
	Integer connectionPoolSizeMax;

	/**
	 * Results compression mode (0 - no compression, 1 - compression with best speed strategy, 2 - compression with best compression strategy)
	 */
	Integer compressionLevel;

	/**
	 * Value from "SET AUTHORIZE USERS IF EXISTS" statement
	 */
	String authenticationQuery;

	/**
	 * Value from "SET ALLOW STATEMENTS IF EXISTS" statement
	 */
	String allowStatementsQuery;

	/**
	 * Value from "DEBUG" clause
	 */
	Boolean debug;

	@Override
	public String toString() {
		return "ConnectionInfo [jdbcUrl=" + jdbcUrl + ", driverClassName=" + driverClassName + ", driverJars=" + driverJars + ", user=" + user + ", password=" + password + ", jdbcPropertiesFile=" + jdbcPropertiesFile + ", systemPropertiesFile=" + systemPropertiesFile + ", connectionPoolSizeMin=" + connectionPoolSizeMin + ", connectionPoolSizeMax=" + connectionPoolSizeMax + ", compressionLevel=" + compressionLevel + ", authenticationQuery=" + authenticationQuery + ", allowStatementsQuery=" + allowStatementsQuery + ", debug=" + debug + "]";
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
