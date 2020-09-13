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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fbsql.antlr4.generated.FbsqlBaseListener;
import org.fbsql.antlr4.generated.FbsqlLexer;
import org.fbsql.antlr4.generated.FbsqlParser;
import org.fbsql.antlr4.generated.FbsqlParser.ProcedureContext;

public class ParseNativeStmt {

	/**
	 * Procedure transfer object
	 */
	public class Procedure {
		public String       name;
		public boolean      hasNestedProcedures;
		public int          startIndex;
		public int          stopIndex;
		public List<String> parameters = new ArrayList<>();

		@Override
		public String toString() {
			return "Procedure [name=" + name + ", hasNestedProcedures=" + hasNestedProcedures + ", startIndex=" + startIndex + ", stopIndex=" + stopIndex + ", parameters=" + parameters + "]";
		}

	}

	private Collection<String /* stored procedure name */> nonNativeProceduresNames;
	private Procedure                                      procedure;

	public ParseNativeStmt(Collection<String /* stored procedure name */> nonNativeProceduresNames) {
		this.nonNativeProceduresNames = nonNativeProceduresNames;
	}

	/**
	 * Native statement parser
	 *
	 * @param sql
	 * @return
	 */
	public Procedure parse(String sql) {
		Lexer       lexer  = new FbsqlLexer(CharStreams.fromString(sql));
		FbsqlParser parser = new FbsqlParser(new CommonTokenStream(lexer));
		ParseTree   tree   = parser.native_stmt();

		List<Procedure> procedures = new ArrayList<>();
		ParseTreeWalker.DEFAULT.walk(new FbsqlBaseListener() {

			@Override
			public void enterProcedure(ProcedureContext ctx) {
				String procedureName = ctx.children.get(0).getText().toUpperCase(Locale.ENGLISH);
				if (!nonNativeProceduresNames.contains(procedureName))
					return;
				procedure = new Procedure();
				procedures.add(procedure);
				procedure.name = procedureName;
				for (int i = 1; i < ctx.children.size(); i++) {
					String s = ctx.children.get(i).getText();
					char   c = s.charAt(0);
					if (c == ',' || c == '(' || c == ')')
						continue;
					if (s.endsWith(")"))
						procedure.hasNestedProcedures = true;
					procedure.parameters.add(s);
				}
				procedure.startIndex = ctx.start.getStartIndex();
				procedure.stopIndex  = ctx.stop.getStopIndex();
			}
		}, tree);
		return getFirstUnNestedProcedure(procedures);
	}

	/**
	 * 
	 * @return first un-nested procedure
	 */
	private static Procedure getFirstUnNestedProcedure(List<Procedure> procedures) {
		for (Procedure procedure : procedures) {
			if (procedure.hasNestedProcedures)
				continue;
			return procedure;
		}
		return null;
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
