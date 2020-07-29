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

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Native_sqlContext;

public class ParseStmtSetAllowLoginIfExists {
	/**
	 * EXPOSE statement transfer object
	 * Expose particular SQL statement to frontend (can be used only in «init.sql» script)
	 */
	public class StmtSetAllowLoginIfExists {
		public String authenticationQuery;

		@Override
		public String toString() {
			return "StmtExpose [authenticationQuery=" + authenticationQuery + "]";
		}
	}

	/**
	 * StmtSetAllowLoginIfExists transfer object
	 */
	private StmtSetAllowLoginIfExists st;

	public ParseStmtSetAllowLoginIfExists() {
		st = new StmtSetAllowLoginIfExists();
	}

	/**
	 * EXPOSE Statement parser
	 *
	 * E.g.: EXPOSE PREFETCH ( SELECT * FROM MYTABLE ) ROLES (aamin, manager) AS myselect
	 *
	 * @param sql
	 * @return
	 */
	public StmtSetAllowLoginIfExists parse(String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.set_allow_login_if_exists();

		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterNative_sql(Native_sqlContext ctx) {
				int      startIndex = ctx.start.getStartIndex();
				int      stopIndex  = ctx.stop.getStopIndex();
				Interval interval   = new Interval(startIndex, stopIndex);
				st.authenticationQuery = ctx.start.getInputStream().getText(interval);
			}

		}, tree);

		return st;
	}

//	public static void main(String[] args) {
//		String                                    sql = "EXPOSE  ( SELECT log AS x FROM t1 \n" +                                                         //
//				"GROUP BY x /* aaaa */ \n" +                                                                                                             //
//				"HAVING count(*) >= 4 \n" +                                                                                                              //
//				"ORDER BY max(n) + 0 ) prefetch ON COMPRESSION BEST COMPRESSION TRIGGER BEFORE MYVALIDATOR ROLES(aaa, bbb) TRIGGER AFTER MYNOTIFIER zz"; //
//		ParseStmtSetAllowLoginIfExists            p   = new ParseStmtSetAllowLoginIfExists();
//		ParseStmtSetAllowLoginIfExists.StmtExpose se  = p.parse(sql);
//		System.out.println(se);
//	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
