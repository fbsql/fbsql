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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.Declare_procedure_stmtContext;
import org.fbsql.antlr4.generated.FbsqlParser.JsonContext;
import org.fbsql.antlr4.generated.FbsqlParser.Json_fileContext;
import org.fbsql.servlet.DbServlet;
import org.fbsql.servlet.NonNativeProcedure;
import org.fbsql.servlet.ProcedureType;
import org.fbsql.servlet.StringUtils;

public class ParseStmtDeclareProcedure {
	/**
	 * DECLARE PROCEDURE statement transfer object
	 * Declare stored procedure or function (can be used only in «init.sql» script)
	 */
	public class StmtDeclareProcedure {
		public String             procedure;
		public NonNativeProcedure nonNativeProcedure;

		@Override
		public String toString() {
			return "StmtDeclareProcedure [procedure=" + procedure + ", nonNativeProcedure=" + nonNativeProcedure + "]";
		}

	}

	private static final String USER_HOME_DIR = System.getProperty("user.home");

	/**
	 * StmtDeclareProcedure transfer object
	 */
	private StmtDeclareProcedure st;

	public ParseStmtDeclareProcedure() {
		st = new StmtDeclareProcedure();
	}

	/**
	 * DECLARE PROCEDURE Statement parser
	 *
	 * E.g.: DECLARE PROCEDURE GET_EMPLOYEES FOR "org.fbsql.examples.StoredProcedures::getEmployees";
	 *
	 * @param sql
	 * @return
	 */
	public StmtDeclareProcedure parse(String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.declare_procedure_stmt();

		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterDeclare_procedure_stmt(Declare_procedure_stmtContext ctx) {
				st.procedure = ctx.getChild(2).getText();
				String procedureTypeStr = ctx.getChild(4).getText().toUpperCase(Locale.ENGLISH);
				st.nonNativeProcedure               = new NonNativeProcedure();
				st.nonNativeProcedure.procedureType = ProcedureType.valueOf(procedureTypeStr);
				st.nonNativeProcedure.optionsJson = "{}"; // default OPTIONS clause
			}

			@Override
			public void enterJson(JsonContext ctx) {
				st.nonNativeProcedure.optionsJson = StringUtils.unquote(ctx.getText().trim());
			}

			@Override
			public void enterJson_file(Json_fileContext ctx) {
				String fileName = StringUtils.unquote(ctx.getText()).trim();
				String url;
				if (fileName.startsWith("http://") || fileName.startsWith("https://"))
					url = fileName;
				else if (fileName.charAt(0) == '/')
					url = "file://" + fileName;
				else
					url = "file://" + USER_HOME_DIR + "/fbsql/config/init/" + fileName;

				try (InputStream is = new URL(url).openStream()) {
					st.nonNativeProcedure.optionsJson = StringUtils.inputSreamToString(is);
				} catch (IOException e) {
					e.printStackTrace();
				}
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
