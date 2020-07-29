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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FbsqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FbsqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#fbsql_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFbsql_stmt(FbsqlParser.Fbsql_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#native_sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNative_sql(FbsqlParser.Native_sqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#role_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRole_name(FbsqlParser.Role_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#trigger_before_procedure_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrigger_before_procedure_name(FbsqlParser.Trigger_before_procedure_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#trigger_after_procedure_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrigger_after_procedure_name(FbsqlParser.Trigger_after_procedure_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#compression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompression(FbsqlParser.CompressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#prefetch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefetch(FbsqlParser.PrefetchContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#statement_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_alias(FbsqlParser.Statement_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#expose_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpose_stmt(FbsqlParser.Expose_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#procedure_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_name(FbsqlParser.Procedure_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#java_method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJava_method_name(FbsqlParser.Java_method_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#declare_procedure_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_procedure_stmt(FbsqlParser.Declare_procedure_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#jdbc_url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJdbc_url(FbsqlParser.Jdbc_urlContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#jdbc_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJdbc_user(FbsqlParser.Jdbc_userContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#jdbc_password}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJdbc_password(FbsqlParser.Jdbc_passwordContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#jdbc_properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJdbc_properties(FbsqlParser.Jdbc_propertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#jdbc_driver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJdbc_driver(FbsqlParser.Jdbc_driverContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#jdbc_driver_jar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJdbc_driver_jar(FbsqlParser.Jdbc_driver_jarContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#connection_pool_size_min}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnection_pool_size_min(FbsqlParser.Connection_pool_size_minContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#connection_pool_size_max}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnection_pool_size_max(FbsqlParser.Connection_pool_size_maxContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#debug}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebug(FbsqlParser.DebugContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#connect_to_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnect_to_stmt(FbsqlParser.Connect_to_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(FbsqlParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#include_script_file_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude_script_file_stmt(FbsqlParser.Include_script_file_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#set_allow_login_if_exists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_allow_login_if_exists(FbsqlParser.Set_allow_login_if_existsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#cron_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCron_expression(FbsqlParser.Cron_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FbsqlParser#schedule_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchedule_stmt(FbsqlParser.Schedule_stmtContext ctx);
}