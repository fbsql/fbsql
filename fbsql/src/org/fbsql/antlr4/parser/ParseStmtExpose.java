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

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Expose_stmtContext;
import org.fbsql.antlr4.generated.FbsqlParser.Native_sqlContext;
import org.fbsql.antlr4.generated.FbsqlParser.Role_nameContext;
import org.fbsql.antlr4.generated.FbsqlParser.Statement_aliasContext;

public class ParseStmtExpose {
	/**
	 * EXPOSE statement transfer object
	 * Expose particular SQL statement to frontend (can be used only in «init.sql» script)
	 */
	public class StmtExpose {
		public boolean      prefetch;
		public List<String> roles;
		public String       statement;
		public String       alias;

		@Override
		public String toString() {
			return "StmtExpose [prefetch=" + prefetch + ", roles=" + roles + ", statement=" + statement + ", alias=" + alias + "]";
		}
	}

	/**
	 * StmtExpose transfer object
	 */
	private StmtExpose st;

	public ParseStmtExpose() {
		st       = new StmtExpose();
		st.roles = new ArrayList<>();
	}

	/**
	 * EXPOSE Statement parser
	 *
	 * E.g.: EXPOSE PREFETCH ( SELECT * FROM MYTABLE ) ROLES (aamin, manager) AS myselect
	 *
	 * @param sql
	 * @return
	 */
	public StmtExpose parse(String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.expose_stmt();

		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterStatement_alias(Statement_aliasContext ctx) {
				int len = ctx.getChildCount();
				if (len == 1)
					st.alias = ctx.getChild(0).getText();
				if (len == 2)
					st.alias = ctx.getChild(1).getText();
			}

			@Override
			public void enterExpose_stmt(Expose_stmtContext ctx) {
				TerminalNode prefetchNode = ctx.K_PREFETCH();
				st.prefetch = prefetchNode != null;
			}

			@Override
			public void enterNative_sql(Native_sqlContext ctx) {
				int      a        = ctx.start.getStartIndex();
				int      b        = ctx.stop.getStopIndex();
				Interval interval = new Interval(a, b);
				st.statement = ctx.start.getInputStream().getText(interval);
			}

			@Override
			public void enterRole_name(Role_nameContext ctx) {
				st.roles.add(ctx.getText());
			}
		}, tree);

		return st;
	}

	public static void main(String[] args) {
		String                     sql = "EXPOSE prefetch ( SELECT log AS x FROM t1 \n" +   //
				"GROUP BY x /* aaaa */ \n" +                                                //
				"HAVING count(*) >= 4 \n" +                                                 //
				"ORDER BY max(n) + 0 ) ROLES(aaa, bbb) AS kkk";                             //
		ParseStmtExpose            p   = new ParseStmtExpose();
		ParseStmtExpose.StmtExpose se  = p.parse(sql);
		System.out.println(se);
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
