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

package org.fbsql.antlr4.parser;

import javax.servlet.ServletConfig;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Connection_aliasContext;
import org.fbsql.servlet.DbServlet;
import org.fbsql.servlet.SqlParseUtils;
import org.fbsql.servlet.StringUtils;

/*
 * ANTLR4 grammar:
 *
 * switch_to_stmt
 *  : SWITCH TO connection_alias
 *  ;
 */
public class ParseStmtSwitchTo {

	/**
	 * DTO (Data Transfer Object) that holds RDBMS connection meta data
	 * Field values comes from parsing of "SWITCH TO" SQL statement
	 * 
	 * @see SqlParseUtils#parseConnectStatement(String)
	 */
	public class StmtSwitchTo {

		/**
		 * Value from "AS" clause
		 */
		public String instanceName;

		@Override
		public String toString() {
			return "StmtSwitchTo [instanceName=" + instanceName + "]";
		}
	}

	/**
	 * StmtConnectTo transfer object
	 */
	private StmtSwitchTo st;

	public ParseStmtSwitchTo() {
		st = new StmtSwitchTo();
	}

	/**
	 * SWITCH TO Statement parser
	 *
	 * E.g.: SWITCH TO mycon
	 *
	 * @param sql
	 * @return
	 */
	public StmtSwitchTo parse(ServletConfig servletConfig, String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.switch_to_stmt();

		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterConnection_alias(Connection_aliasContext ctx) {
				st.instanceName = StringUtils.unquote(ctx.getText());
			}

		}, tree);

		if (DbServlet.DEBUG)
			System.out.println(st);

		return st;
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
