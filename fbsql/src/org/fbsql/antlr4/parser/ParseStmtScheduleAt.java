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
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Cron_expressionContext;
import org.fbsql.antlr4.generated.FbsqlParser.Procedure_nameContext;
import org.fbsql.servlet.StringUtils;

public class ParseStmtScheduleAt {
	/**
	 * DECLARE PROCEDURE statement transfer object
	 * Declare stored procedure or function (can be used only in «init.sql» script)
	 */
	public class StmtScheduleAt {
		public String procedure;
		public String cronExpression;

		@Override
		public String toString() {
			return "StmtScheduleAt [procedure=" + procedure + ", cronExpression=" + cronExpression + "]";
		}
	}

	/**
	 * StmtScheduleAt transfer object
	 */
	private StmtScheduleAt st;

	public ParseStmtScheduleAt() {
		st = new StmtScheduleAt();
	}

	/**
	 * SCHEDULE Statement parser
	 *
	 * E.g.: SCHEDULE MY_PERIODIC_RUN AT "0/5 * * * * ?"
	 *
	 * @param sql
	 * @return
	 */
	public StmtScheduleAt parse(String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.schedule_stmt();

		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterProcedure_name(Procedure_nameContext ctx) {
				st.procedure = StringUtils.unquote(ctx.getText());
			}

			@Override
			public void enterCron_expression(Cron_expressionContext ctx) {
				st.cronExpression = StringUtils.unquote(ctx.getText());
			}
		}, tree);

		return st;
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
