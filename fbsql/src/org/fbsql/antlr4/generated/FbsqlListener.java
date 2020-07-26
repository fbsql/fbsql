// Generated from Fbsql.g4 by ANTLR 4.8

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

package org.fbsql.antlr4.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FbsqlParser}.
 */
public interface FbsqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#fbsql_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFbsql_stmt(FbsqlParser.Fbsql_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#fbsql_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFbsql_stmt(FbsqlParser.Fbsql_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#native_sql}.
	 * @param ctx the parse tree
	 */
	void enterNative_sql(FbsqlParser.Native_sqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#native_sql}.
	 * @param ctx the parse tree
	 */
	void exitNative_sql(FbsqlParser.Native_sqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#role_name}.
	 * @param ctx the parse tree
	 */
	void enterRole_name(FbsqlParser.Role_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#role_name}.
	 * @param ctx the parse tree
	 */
	void exitRole_name(FbsqlParser.Role_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#statement_alias}.
	 * @param ctx the parse tree
	 */
	void enterStatement_alias(FbsqlParser.Statement_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#statement_alias}.
	 * @param ctx the parse tree
	 */
	void exitStatement_alias(FbsqlParser.Statement_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#expose_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpose_stmt(FbsqlParser.Expose_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#expose_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpose_stmt(FbsqlParser.Expose_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#procedure_name}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_name(FbsqlParser.Procedure_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#procedure_name}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_name(FbsqlParser.Procedure_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#java_method_name}.
	 * @param ctx the parse tree
	 */
	void enterJava_method_name(FbsqlParser.Java_method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#java_method_name}.
	 * @param ctx the parse tree
	 */
	void exitJava_method_name(FbsqlParser.Java_method_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#declare_procedure_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_procedure_stmt(FbsqlParser.Declare_procedure_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#declare_procedure_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_procedure_stmt(FbsqlParser.Declare_procedure_stmtContext ctx);
}