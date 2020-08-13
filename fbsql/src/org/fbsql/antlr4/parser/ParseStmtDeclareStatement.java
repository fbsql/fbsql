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

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Compression_levelContext;
import org.fbsql.antlr4.generated.FbsqlParser.Declare_statement_stmtContext;
import org.fbsql.antlr4.generated.FbsqlParser.Native_sqlContext;
import org.fbsql.antlr4.generated.FbsqlParser.Role_nameContext;
import org.fbsql.antlr4.generated.FbsqlParser.Statement_aliasContext;
import org.fbsql.antlr4.generated.FbsqlParser.Trigger_after_procedure_nameContext;
import org.fbsql.antlr4.generated.FbsqlParser.Trigger_before_procedure_nameContext;
import org.fbsql.servlet.CompressionLevel;

public class ParseStmtDeclareStatement {
	/**
	 * EXPOSE statement transfer object
	 * Expose particular SQL statement to frontend (can be used only in «init.sql» script)
	 */
	public class StmtDeclareStatement {
		public String             statement;
		public boolean            prefetch;
		public Collection<String> roles;
		public String             trigger_before_procedure_name;
		public String             trigger_after_procedure_name;
		public String             alias;

		/**
		 * Results compression mode (0 - no compression, 1 - compression with best speed strategy, 9 - compression with best compression strategy (default))
		 */
		public int compressionLevel;

		@Override
		public String toString() {
			return "StmtExpose [statement=" + statement + ", prefetch=" + prefetch + ", roles=" + roles + ", trigger_before_procedure_name=" + trigger_before_procedure_name + ", trigger_after_procedure_name=" + trigger_after_procedure_name + ", alias=" + alias + ", compressionLevel=" + compressionLevel + "]";
		}
	}

	/**
	 * StmtExpose transfer object
	 */
	private StmtDeclareStatement st;

	public ParseStmtDeclareStatement() {
		st       = new StmtDeclareStatement();
		st.roles = new HashSet<>();
	}

	/**
	 * EXPOSE Statement parser
	 *
	 * E.g.: EXPOSE PREFETCH ( SELECT * FROM MYTABLE ) ROLES (aamin, manager) AS myselect
	 *
	 * @param sql
	 * @return
	 */
	public StmtDeclareStatement parse(String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.declare_statement_stmt();

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
			public void enterDeclare_statement_stmt(Declare_statement_stmtContext ctx) {
				st.prefetch = ctx.STATIC() != null && ctx.STATIC().size() != 0;
			}

			@Override
			public void enterCompression_level(Compression_levelContext ctx) {
				if (ctx.BEST() != null && ctx.COMPRESSION() != null)
					st.compressionLevel = CompressionLevel.BEST_COMPRESSION;
				else if (ctx.BEST() != null && ctx.SPEED() != null)
					st.compressionLevel = CompressionLevel.BEST_SPEED;
				else
					st.compressionLevel = CompressionLevel.NO_COMPRESSION;
			}

			@Override
			public void enterNative_sql(Native_sqlContext ctx) {
				int      startIndex = ctx.start.getStartIndex();
				int      stopIndex  = ctx.stop.getStopIndex();
				Interval interval   = new Interval(startIndex, stopIndex);
				st.statement = ctx.start.getInputStream().getText(interval);
			}

			@Override
			public void enterRole_name(Role_nameContext ctx) {
				st.roles.add(ctx.getText());
			}

			@Override
			public void enterTrigger_before_procedure_name(Trigger_before_procedure_nameContext ctx) {
				st.trigger_before_procedure_name = ctx.getText();
			}

			@Override
			public void enterTrigger_after_procedure_name(Trigger_after_procedure_nameContext ctx) {
				st.trigger_after_procedure_name = ctx.getText();
			}
		}, tree);

		if (st.alias == null)
			st.alias = ParseStmtConnectTo.NONEXPOSABLE_NAME_PREFIX + UUID.randomUUID().toString();
		return st;
	}

	public static void main(String[] args) {
		String                                         sql = "DECLARE STATEMENT ( SELECT log AS x FROM t1 \n" +                                //
				"GROUP BY x /* aaaa */ \n" +                                                                                                   //
				"HAVING count(*) >= 4 \n" +                                                                                                    //
				"ORDER BY max(n) + 0 )  static COMPRESSION BEST SPEED TRIGGER BEFORE MYVALIDATOR ROLES(aaa, bbb) TRIGGER AFTER MYNOTIFIER zz"; //
		ParseStmtDeclareStatement                      p   = new ParseStmtDeclareStatement();
		ParseStmtDeclareStatement.StmtDeclareStatement se  = p.parse(sql);
		System.out.println(se);
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
