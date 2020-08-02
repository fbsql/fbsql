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
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Sql_script_fileContext;
import org.fbsql.servlet.StringUtils;

public class ParseStmtInclude {
	/**
	 * DECLARE PROCEDURE statement transfer object
	 * Declare stored procedure or function (can be used only in «init.sql» script)
	 */
	public class StmtInclude {
		public List<String> fileNames;

		@Override
		public String toString() {
			return "StmtIncludeScriptFile [fileNames=" + fileNames + "]";
		}
	}

	/**
	 * StmtInclude transfer object
	 */
	private StmtInclude st;

	public ParseStmtInclude() {
		st = new StmtInclude();
		st.fileNames = new ArrayList<>();
	}

	/**
	 * DECLARE PROCEDURE Statement parser
	 *
	 * E.g.: DECLARE PROCEDURE GET_EMPLOYEES FOR "org.fbsql.examples.StoredProcedures::getEmployees";
	 *
	 * @param sql
	 * @return
	 */
	public StmtInclude parse(String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.include_script_file_stmt();

		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterSql_script_file(Sql_script_fileContext ctx) {
				st.fileNames.add(StringUtils.unquote(ctx.getText()));
			}

		}, tree);

		return st;
	}
	
		public static void main(String[] args) {
			String                                    sql = "INCLUDE  'abc', '123', 'kk'";
			ParseStmtInclude            p   = new ParseStmtInclude();
			ParseStmtInclude.StmtInclude se  = p.parse(sql);
			System.out.println(se);
		}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
