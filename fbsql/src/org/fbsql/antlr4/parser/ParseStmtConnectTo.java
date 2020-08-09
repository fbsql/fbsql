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

package org.fbsql.antlr4.parser;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletConfig;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Connect_to_stmtContext;
import org.fbsql.antlr4.generated.FbsqlParser.Connection_aliasContext;
import org.fbsql.antlr4.generated.FbsqlParser.Connection_pool_size_maxContext;
import org.fbsql.antlr4.generated.FbsqlParser.Connection_pool_size_minContext;
import org.fbsql.antlr4.generated.FbsqlParser.Jdbc_connection_propertiesContext;
import org.fbsql.antlr4.generated.FbsqlParser.Jdbc_driver_class_nameContext;
import org.fbsql.antlr4.generated.FbsqlParser.Jdbc_urlContext;
import org.fbsql.antlr4.generated.FbsqlParser.Native_sqlContext;
import org.fbsql.antlr4.generated.FbsqlParser.PasswordContext;
import org.fbsql.antlr4.generated.FbsqlParser.UserContext;
import org.fbsql.servlet.CommonUtils;
import org.fbsql.servlet.ExposeMode;
import org.fbsql.servlet.SqlParseUtils;
import org.fbsql.servlet.StringUtils;

/*
 * ANTLR4 grammar:
 *
 * connect_to_stmt
 * : CONNECT TO jdbc_url
 * (
 *  (USER user) |
 *  (PASSWORD password) |
 *  (PROPERTIES jdbc_connection_properties) |
 *  (DRIVER jdbc_driver_class_name) |
 *  (LIB jar_file ( ',' jar_file )* ) |
 *  (CONNECTION POOL
 *   (
 *    (MIN connection_pool_size_min) |
 *    (MAX connection_pool_size_max)
 *   )+
 *  )
 * )*
 * (
 * EXPOSE
 * (IF EXISTS '(' native_sql ')')?
 * AS? connection_alias
 * )?
 * ;
 */
public class ParseStmtConnectTo {
	public static final String  NONEXPOSABLE_NAME_PREFIX = "NONEXPOSABLE_NAME:";
	private static final String ENCODED_PASSWORD_PREFIX  = "base64:";

	private static final int DEFAULT_CONNECTION_POOL_SIZE_MIN = 1;
	private static final int DEFAULT_CONNECTION_POOL_SIZE_MAX = 100;
	private static final int DEFAULT_EXPOSE_MODE              = ExposeMode.NONE;

	/**
	 * DTO (Data Transfer Object) that holds RDBMS connection meta data
	 * Field values comes from parsing of "CONNECT TO" SQL statement
	 * 
	 * @see SqlParseUtils#parseConnectStatement(String)
	 */
	public class StmtConnectTo {

		/**
		 * Value from "CONNECT TO" clause
		 */
		public String jdbcUrl;

		/**
		 * Value from "DRIVER" clause
		 */
		public String driverClassName;

		/**
		 * Value from "JARS" clause
		 */
		public List<String> driverJars;

		/**
		 * Value from "USER" clause
		 */
		public String user;

		/**
		 * Value from "PASSWORD" clause
		 */
		public String password;

		/**
		 * Value from "PROPERTIES" clause
		 * Java (*.properties) file contains JDBC properties
		 */
		public String jdbcPropertiesFile;

		/**
		 * Value from "CONNECTION POOL -> MIN" clause
		 */
		public int connectionPoolSizeMin = DEFAULT_CONNECTION_POOL_SIZE_MIN;

		/**
		 * Value from "CONNECTION POOL -> MAX" clause
		 */
		public int connectionPoolSizeMax = DEFAULT_CONNECTION_POOL_SIZE_MAX;

		public int exposeMode = DEFAULT_EXPOSE_MODE;

		/**
		 * Value from "IF EXISTS" clause
		 */
		public String authenticationQuery;

		public boolean allowConnections;

		/**
		 * Value from "AS" clause
		 */
		public String instanceName;

		@Override
		public String toString() {
			return "StmtConnectTo [jdbcUrl=" + jdbcUrl + ", driverClassName=" + driverClassName + ", driverJars=" + driverJars + ", user=" + user + ", password=" + password + ", jdbcPropertiesFile=" + jdbcPropertiesFile + ", connectionPoolSizeMin=" + connectionPoolSizeMin + ", connectionPoolSizeMax=" + connectionPoolSizeMax + ", exposeMode=" + exposeMode + ", authenticationQuery=" + authenticationQuery + ", allowConnections=" + allowConnections + ", instanceName=" + instanceName + "]";
		}

	}

	private static final String[] ALLOW_CONNECTIONS_ALL    = new String[] { "ALLOW", "CONNECTIONS", "ALL" };
	private static final String[] ALLOW_STATEMENTS_ALL     = new String[] { "ALLOW", "STATEMENTS", "ALL" };
	private static final String[] ALLOW_STATEMENTS_EXPOSED = new String[] { "ALLOW", "STATEMENTS", "EXPOSED" };

	/**
	 * StmtConnectTo transfer object
	 */
	private StmtConnectTo st;

	public ParseStmtConnectTo() {
		st            = new StmtConnectTo();
		st.driverJars = new ArrayList<>();
	}

	/**
	 * CONNECT TO Statement parser
	 *
	 * E.g.: CONNECT TO ( SELECT * FROM MYTABLE ) ROLES (aamin, manager) AS myselect
	 *
	 * @param sql
	 * @return
	 */
	public StmtConnectTo parse(ServletConfig servletConfig, String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.connect_to_stmt();

		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterConnect_to_stmt(Connect_to_stmtContext ctx) {
				String[] array = new String[ctx.children.size()];
				int      n     = 0;
				for (ParseTree parseTree : ctx.children)
					array[n++] = parseTree.getText().toUpperCase(Locale.ENGLISH);

				if (CommonUtils.indexOf(array, ALLOW_STATEMENTS_ALL) != -1)
					st.exposeMode = ExposeMode.ALL;
				else if (CommonUtils.indexOf(array, ALLOW_STATEMENTS_EXPOSED) != -1)
					st.exposeMode = ExposeMode.EXPOSED;

				if (CommonUtils.indexOf(array, ALLOW_CONNECTIONS_ALL) != -1)
					st.allowConnections = true;
			}

			@Override
			public void enterJdbc_url(Jdbc_urlContext ctx) {
				st.jdbcUrl = StringUtils.unquote(ctx.getText());
			}

			@Override
			public void enterUser(UserContext ctx) {
				st.user = StringUtils.unquote(ctx.getText());
			}

			@Override
			public void enterPassword(PasswordContext ctx) {
				st.password = StringUtils.unquote(ctx.getText());
			}

			@Override
			public void enterJdbc_driver_class_name(Jdbc_driver_class_nameContext ctx) {
				st.driverClassName = StringUtils.unquote(ctx.getText());
			}

			@Override
			public void enterJdbc_connection_properties(Jdbc_connection_propertiesContext ctx) {
				st.jdbcPropertiesFile = StringUtils.unquote(ctx.getText());
			}

			@Override
			public void enterConnection_pool_size_min(Connection_pool_size_minContext ctx) {
				try {
					st.connectionPoolSizeMin = Integer.parseInt(ctx.getText());
				} catch (NumberFormatException e) {
					if (servletConfig != null) {
						String s = servletConfig.getInitParameter("CONNECTION_POOL_SIZE_MIN");
						if (s != null && !s.trim().isEmpty())
							try {
								st.connectionPoolSizeMin = Integer.parseInt(s.trim());
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							}
					}
				}
			}

			@Override
			public void enterConnection_pool_size_max(Connection_pool_size_maxContext ctx) {
				try {
					st.connectionPoolSizeMax = Integer.parseInt(ctx.getText());
				} catch (NumberFormatException e) {
					if (servletConfig != null) {
						String s = servletConfig.getInitParameter("CONNECTION_POOL_SIZE_MAX");
						if (s != null && !s.trim().isEmpty())
							try {
								st.connectionPoolSizeMax = Integer.parseInt(s.trim());
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							}
					}
				}
			}

			@Override
			public void enterNative_sql(Native_sqlContext ctx) {
				int      startIndex = ctx.start.getStartIndex();
				int      stopIndex  = ctx.stop.getStopIndex();
				Interval interval   = new Interval(startIndex, stopIndex);
				st.authenticationQuery = ctx.start.getInputStream().getText(interval);
			}

			@Override
			public void enterConnection_alias(Connection_aliasContext ctx) {
				st.instanceName = StringUtils.unquote(ctx.getText());
			}

		}, tree);

		if (st.instanceName == null)
			st.instanceName = NONEXPOSABLE_NAME_PREFIX + UUID.randomUUID().toString();

		if (st.password != null)
			if (st.password.startsWith(ENCODED_PASSWORD_PREFIX)) {
				st.password = st.password.substring(ENCODED_PASSWORD_PREFIX.length());
				st.password = new String(Base64.getDecoder().decode(st.password), StandardCharsets.UTF_8);
			}
		return st;
	}

	public static void main(String[] args) {
		String sql = "CONNECT TO 'jdbc://h2.prefetch' \n DRIVER 'org.h2.Driver' CONNECTION POOL MIN 21 MAX 62 PASSWORD 'base64:cHJpVmV0' ALLOW STATEMENTS exposed USER uuu ALLOW CONNECTIONS IF EXISTS (SELECT * from USERS where USER=:user) AS ali";
		//		String             sql = "CONNECT TO 'jdbc://h2.prefetch' \n DRIVER 'org.h2.Driver' CONNECTION POOL MIN 21 MAX 62 PASSWORD 'base64:cHJpVmV0' ALLOW STATEMENTS EXPOSED USER uuu ALLOW CONNECTIONS NONE AS ali";
		ParseStmtConnectTo p  = new ParseStmtConnectTo();
		StmtConnectTo      se = p.parse(null, sql);
		System.out.println(se);
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
