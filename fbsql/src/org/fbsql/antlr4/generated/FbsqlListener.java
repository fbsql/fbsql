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
	 * Enter a parse tree produced by {@link FbsqlParser#trigger_before_procedure_name}.
	 * @param ctx the parse tree
	 */
	void enterTrigger_before_procedure_name(FbsqlParser.Trigger_before_procedure_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#trigger_before_procedure_name}.
	 * @param ctx the parse tree
	 */
	void exitTrigger_before_procedure_name(FbsqlParser.Trigger_before_procedure_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#trigger_after_procedure_name}.
	 * @param ctx the parse tree
	 */
	void enterTrigger_after_procedure_name(FbsqlParser.Trigger_after_procedure_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#trigger_after_procedure_name}.
	 * @param ctx the parse tree
	 */
	void exitTrigger_after_procedure_name(FbsqlParser.Trigger_after_procedure_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#compression_level}.
	 * @param ctx the parse tree
	 */
	void enterCompression_level(FbsqlParser.Compression_levelContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#compression_level}.
	 * @param ctx the parse tree
	 */
	void exitCompression_level(FbsqlParser.Compression_levelContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#prefetch_on_off}.
	 * @param ctx the parse tree
	 */
	void enterPrefetch_on_off(FbsqlParser.Prefetch_on_offContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#prefetch_on_off}.
	 * @param ctx the parse tree
	 */
	void exitPrefetch_on_off(FbsqlParser.Prefetch_on_offContext ctx);
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
	 * Enter a parse tree produced by {@link FbsqlParser#jdbc_url}.
	 * @param ctx the parse tree
	 */
	void enterJdbc_url(FbsqlParser.Jdbc_urlContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#jdbc_url}.
	 * @param ctx the parse tree
	 */
	void exitJdbc_url(FbsqlParser.Jdbc_urlContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#user}.
	 * @param ctx the parse tree
	 */
	void enterUser(FbsqlParser.UserContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#user}.
	 * @param ctx the parse tree
	 */
	void exitUser(FbsqlParser.UserContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#password}.
	 * @param ctx the parse tree
	 */
	void enterPassword(FbsqlParser.PasswordContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#password}.
	 * @param ctx the parse tree
	 */
	void exitPassword(FbsqlParser.PasswordContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#jdbc_connection_properties}.
	 * @param ctx the parse tree
	 */
	void enterJdbc_connection_properties(FbsqlParser.Jdbc_connection_propertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#jdbc_connection_properties}.
	 * @param ctx the parse tree
	 */
	void exitJdbc_connection_properties(FbsqlParser.Jdbc_connection_propertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#jdbc_driver_class_name}.
	 * @param ctx the parse tree
	 */
	void enterJdbc_driver_class_name(FbsqlParser.Jdbc_driver_class_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#jdbc_driver_class_name}.
	 * @param ctx the parse tree
	 */
	void exitJdbc_driver_class_name(FbsqlParser.Jdbc_driver_class_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#jar_file}.
	 * @param ctx the parse tree
	 */
	void enterJar_file(FbsqlParser.Jar_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#jar_file}.
	 * @param ctx the parse tree
	 */
	void exitJar_file(FbsqlParser.Jar_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#connection_pool_size_min}.
	 * @param ctx the parse tree
	 */
	void enterConnection_pool_size_min(FbsqlParser.Connection_pool_size_minContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#connection_pool_size_min}.
	 * @param ctx the parse tree
	 */
	void exitConnection_pool_size_min(FbsqlParser.Connection_pool_size_minContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#connection_pool_size_max}.
	 * @param ctx the parse tree
	 */
	void enterConnection_pool_size_max(FbsqlParser.Connection_pool_size_maxContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#connection_pool_size_max}.
	 * @param ctx the parse tree
	 */
	void exitConnection_pool_size_max(FbsqlParser.Connection_pool_size_maxContext ctx);
	/**
<<<<<<< HEAD
	 * Enter a parse tree produced by {@link FbsqlParser#sql_script_file}.
=======
	 * Enter a parse tree produced by {@link FbsqlParser#debug_on_off}.
>>>>>>> refs/remotes/origin/master
	 * @param ctx the parse tree
	 */
<<<<<<< HEAD
	void enterSql_script_file(FbsqlParser.Sql_script_fileContext ctx);
=======
	void enterDebug_on_off(FbsqlParser.Debug_on_offContext ctx);
>>>>>>> refs/remotes/origin/master
	/**
<<<<<<< HEAD
	 * Exit a parse tree produced by {@link FbsqlParser#sql_script_file}.
=======
	 * Exit a parse tree produced by {@link FbsqlParser#debug_on_off}.
>>>>>>> refs/remotes/origin/master
	 * @param ctx the parse tree
	 */
<<<<<<< HEAD
	void exitSql_script_file(FbsqlParser.Sql_script_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#cron_expression}.
	 * @param ctx the parse tree
	 */
	void enterCron_expression(FbsqlParser.Cron_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#cron_expression}.
	 * @param ctx the parse tree
	 */
	void exitCron_expression(FbsqlParser.Cron_expressionContext ctx);
=======
	void exitDebug_on_off(FbsqlParser.Debug_on_offContext ctx);
>>>>>>> refs/remotes/origin/master
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#connect_to_stmt}.
	 * @param ctx the parse tree
	 */
	void enterConnect_to_stmt(FbsqlParser.Connect_to_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#connect_to_stmt}.
	 * @param ctx the parse tree
	 */
	void exitConnect_to_stmt(FbsqlParser.Connect_to_stmtContext ctx);
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
	 * Enter a parse tree produced by {@link FbsqlParser#declare_procedure_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_procedure_stmt(FbsqlParser.Declare_procedure_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#declare_procedure_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_procedure_stmt(FbsqlParser.Declare_procedure_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#include_script_file_stmt}.
	 * @param ctx the parse tree
	 */
	void enterInclude_script_file_stmt(FbsqlParser.Include_script_file_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#include_script_file_stmt}.
	 * @param ctx the parse tree
	 */
	void exitInclude_script_file_stmt(FbsqlParser.Include_script_file_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#login_if_exists}.
	 * @param ctx the parse tree
	 */
	void enterLogin_if_exists(FbsqlParser.Login_if_existsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#login_if_exists}.
	 * @param ctx the parse tree
	 */
	void exitLogin_if_exists(FbsqlParser.Login_if_existsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FbsqlParser#schedule_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSchedule_stmt(FbsqlParser.Schedule_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FbsqlParser#schedule_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSchedule_stmt(FbsqlParser.Schedule_stmtContext ctx);
}