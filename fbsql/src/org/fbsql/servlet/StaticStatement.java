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

/**
 * DTO (Data Transfer Object) that represent SQL DQL statement abstraction
 * combined with result set format
 *
 */
public class StaticStatement {

	/**
	 * SQL statement
	 */
	String sql;

	/**
	 * Result set JSON format
	 */
	int resultSetFormat;

	/**
	 * Constructs StaticStatement object
	 * @param sql             - SQL statement
	 * @param resultSetFormat - result set JSON format
	 */
	public StaticStatement(String sql, int resultSetFormat) {
		this.sql             = sql;
		this.resultSetFormat = resultSetFormat;
	}

	@Override
	public int hashCode() {
		final int prime  = 31;
		int       result = 1;
		result = prime * result + resultSetFormat;
		result = prime * result + ((sql == null) ? 0 : sql.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaticStatement other = (StaticStatement) obj;
		if (resultSetFormat != other.resultSetFormat)
			return false;
		if (sql == null) {
			if (other.sql != null)
				return false;
		} else if (!sql.equals(other.sql))
			return false;
		return true;

	}

	@Override
	public String toString() {
		return "StaticStatement [resultSetFormat=" + resultSetFormat + ", sql=" + sql + "]";
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */

