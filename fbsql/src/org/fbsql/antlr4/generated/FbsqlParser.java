// Generated from /home/qsecofr/git/fbsql/fbsql/Fbsql.g4 by ANTLR 4.8

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FbsqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, EXPOSE=4, STATIC=5, ROLES=6, TRIGGER=7, BEFORE=8, 
		AFTER=9, AS=10, COMPRESSION=11, NONE=12, BEST=13, SPEED=14, DECLARE=15, 
		PROCEDURE=16, FOR=17, STATEMENT=18, CONNECT=19, TO=20, USER=21, PASSWORD=22, 
		PROPERTIES=23, DRIVER=24, LIB=25, CONNECTION=26, POOL=27, SIZE=28, MIN=29, 
		MAX=30, STATEMENTS=31, ALL=32, DECLARED=33, CONNECTIONS=34, ALLOW=35, 
		REJECT=36, IF=37, EXISTS=38, SWITCH=39, SCHEDULE=40, AT=41, INCLUDE=42, 
		FILE=43, IDENTIFIER=44, NUMERIC_LITERAL=45, STRING_LITERAL=46, SINGLE_LINE_COMMENT=47, 
		MULTILINE_COMMENT=48, SPACES=49, UNEXPECTED_CHAR=50;
	public static final int
		RULE_native_sql = 0, RULE_role_name = 1, RULE_trigger_before_procedure_name = 2, 
		RULE_trigger_after_procedure_name = 3, RULE_compression_level = 4, RULE_connection_alias = 5, 
		RULE_statement_alias = 6, RULE_procedure_name = 7, RULE_java_method_name = 8, 
		RULE_jdbc_url = 9, RULE_user = 10, RULE_password = 11, RULE_jdbc_connection_properties = 12, 
		RULE_jdbc_driver_class_name = 13, RULE_jar_file = 14, RULE_connection_pool_size_min = 15, 
		RULE_connection_pool_size_max = 16, RULE_sql_script_file = 17, RULE_cron_expression = 18, 
		RULE_connect_to_stmt = 19, RULE_switch_to_stmt = 20, RULE_declare_statement_stmt = 21, 
		RULE_declare_procedure_stmt = 22, RULE_include_script_file_stmt = 23, 
		RULE_schedule_stmt = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"native_sql", "role_name", "trigger_before_procedure_name", "trigger_after_procedure_name", 
			"compression_level", "connection_alias", "statement_alias", "procedure_name", 
			"java_method_name", "jdbc_url", "user", "password", "jdbc_connection_properties", 
			"jdbc_driver_class_name", "jar_file", "connection_pool_size_min", "connection_pool_size_max", 
			"sql_script_file", "cron_expression", "connect_to_stmt", "switch_to_stmt", 
			"declare_statement_stmt", "declare_procedure_stmt", "include_script_file_stmt", 
			"schedule_stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "EXPOSE", "STATIC", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "COMPRESSION", "NONE", "BEST", "SPEED", "DECLARE", "PROCEDURE", 
			"FOR", "STATEMENT", "CONNECT", "TO", "USER", "PASSWORD", "PROPERTIES", 
			"DRIVER", "LIB", "CONNECTION", "POOL", "SIZE", "MIN", "MAX", "STATEMENTS", 
			"ALL", "DECLARED", "CONNECTIONS", "ALLOW", "REJECT", "IF", "EXISTS", 
			"SWITCH", "SCHEDULE", "AT", "INCLUDE", "FILE", "IDENTIFIER", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
			"UNEXPECTED_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Fbsql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FbsqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Native_sqlContext extends ParserRuleContext {
		public Native_sqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_native_sql; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterNative_sql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitNative_sql(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitNative_sql(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Native_sqlContext native_sql() throws RecognitionException {
		Native_sqlContext _localctx = new Native_sqlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_native_sql);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(50);
					matchWildcard();
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Role_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Role_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterRole_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitRole_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitRole_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Role_nameContext role_name() throws RecognitionException {
		Role_nameContext _localctx = new Role_nameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_role_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trigger_before_procedure_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public Trigger_before_procedure_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_before_procedure_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterTrigger_before_procedure_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitTrigger_before_procedure_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitTrigger_before_procedure_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trigger_before_procedure_nameContext trigger_before_procedure_name() throws RecognitionException {
		Trigger_before_procedure_nameContext _localctx = new Trigger_before_procedure_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_trigger_before_procedure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trigger_after_procedure_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public Trigger_after_procedure_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_after_procedure_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterTrigger_after_procedure_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitTrigger_after_procedure_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitTrigger_after_procedure_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trigger_after_procedure_nameContext trigger_after_procedure_name() throws RecognitionException {
		Trigger_after_procedure_nameContext _localctx = new Trigger_after_procedure_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_trigger_after_procedure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compression_levelContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(FbsqlParser.NONE, 0); }
		public TerminalNode BEST() { return getToken(FbsqlParser.BEST, 0); }
		public TerminalNode COMPRESSION() { return getToken(FbsqlParser.COMPRESSION, 0); }
		public TerminalNode SPEED() { return getToken(FbsqlParser.SPEED, 0); }
		public Compression_levelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compression_level; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterCompression_level(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitCompression_level(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitCompression_level(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compression_levelContext compression_level() throws RecognitionException {
		Compression_levelContext _localctx = new Compression_levelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compression_level);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(NONE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(BEST);
				setState(64);
				match(COMPRESSION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(BEST);
				setState(66);
				match(SPEED);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Connection_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Connection_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connection_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterConnection_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitConnection_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitConnection_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Connection_aliasContext connection_alias() throws RecognitionException {
		Connection_aliasContext _localctx = new Connection_aliasContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_connection_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Statement_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Statement_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterStatement_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitStatement_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitStatement_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_aliasContext statement_alias() throws RecognitionException {
		Statement_aliasContext _localctx = new Statement_aliasContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Procedure_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Procedure_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterProcedure_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitProcedure_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitProcedure_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Procedure_nameContext procedure_name() throws RecognitionException {
		Procedure_nameContext _localctx = new Procedure_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procedure_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Java_method_nameContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Java_method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_java_method_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJava_method_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJava_method_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJava_method_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Java_method_nameContext java_method_name() throws RecognitionException {
		Java_method_nameContext _localctx = new Java_method_nameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_java_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Jdbc_urlContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_urlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_url(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_url(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_url(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_urlContext jdbc_url() throws RecognitionException {
		Jdbc_urlContext _localctx = new Jdbc_urlContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_jdbc_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UserContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public UserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_user; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterUser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitUser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitUser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserContext user() throws RecognitionException {
		UserContext _localctx = new UserContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_user);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PasswordContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public PasswordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_password; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterPassword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitPassword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitPassword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PasswordContext password() throws RecognitionException {
		PasswordContext _localctx = new PasswordContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_password);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Jdbc_connection_propertiesContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_connection_propertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_connection_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_connection_properties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_connection_properties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_connection_properties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_connection_propertiesContext jdbc_connection_properties() throws RecognitionException {
		Jdbc_connection_propertiesContext _localctx = new Jdbc_connection_propertiesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_jdbc_connection_properties);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Jdbc_driver_class_nameContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_driver_class_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_driver_class_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_driver_class_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_driver_class_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_driver_class_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_driver_class_nameContext jdbc_driver_class_name() throws RecognitionException {
		Jdbc_driver_class_nameContext _localctx = new Jdbc_driver_class_nameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jdbc_driver_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Jar_fileContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jar_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jar_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJar_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJar_file(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJar_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jar_fileContext jar_file() throws RecognitionException {
		Jar_fileContext _localctx = new Jar_fileContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jar_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Connection_pool_size_minContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(FbsqlParser.NUMERIC_LITERAL, 0); }
		public Connection_pool_size_minContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connection_pool_size_min; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterConnection_pool_size_min(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitConnection_pool_size_min(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitConnection_pool_size_min(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Connection_pool_size_minContext connection_pool_size_min() throws RecognitionException {
		Connection_pool_size_minContext _localctx = new Connection_pool_size_minContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_connection_pool_size_min);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(NUMERIC_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Connection_pool_size_maxContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(FbsqlParser.NUMERIC_LITERAL, 0); }
		public Connection_pool_size_maxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connection_pool_size_max; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterConnection_pool_size_max(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitConnection_pool_size_max(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitConnection_pool_size_max(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Connection_pool_size_maxContext connection_pool_size_max() throws RecognitionException {
		Connection_pool_size_maxContext _localctx = new Connection_pool_size_maxContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_connection_pool_size_max);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(NUMERIC_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_script_fileContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Sql_script_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_script_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterSql_script_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitSql_script_file(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitSql_script_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_script_fileContext sql_script_file() throws RecognitionException {
		Sql_script_fileContext _localctx = new Sql_script_fileContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sql_script_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cron_expressionContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Cron_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cron_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterCron_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitCron_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitCron_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cron_expressionContext cron_expression() throws RecognitionException {
		Cron_expressionContext _localctx = new Cron_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cron_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Connect_to_stmtContext extends ParserRuleContext {
		public TerminalNode CONNECT() { return getToken(FbsqlParser.CONNECT, 0); }
		public TerminalNode TO() { return getToken(FbsqlParser.TO, 0); }
		public Jdbc_urlContext jdbc_url() {
			return getRuleContext(Jdbc_urlContext.class,0);
		}
		public Connection_aliasContext connection_alias() {
			return getRuleContext(Connection_aliasContext.class,0);
		}
		public List<TerminalNode> USER() { return getTokens(FbsqlParser.USER); }
		public TerminalNode USER(int i) {
			return getToken(FbsqlParser.USER, i);
		}
		public List<UserContext> user() {
			return getRuleContexts(UserContext.class);
		}
		public UserContext user(int i) {
			return getRuleContext(UserContext.class,i);
		}
		public List<TerminalNode> PASSWORD() { return getTokens(FbsqlParser.PASSWORD); }
		public TerminalNode PASSWORD(int i) {
			return getToken(FbsqlParser.PASSWORD, i);
		}
		public List<PasswordContext> password() {
			return getRuleContexts(PasswordContext.class);
		}
		public PasswordContext password(int i) {
			return getRuleContext(PasswordContext.class,i);
		}
		public List<TerminalNode> PROPERTIES() { return getTokens(FbsqlParser.PROPERTIES); }
		public TerminalNode PROPERTIES(int i) {
			return getToken(FbsqlParser.PROPERTIES, i);
		}
		public List<Jdbc_connection_propertiesContext> jdbc_connection_properties() {
			return getRuleContexts(Jdbc_connection_propertiesContext.class);
		}
		public Jdbc_connection_propertiesContext jdbc_connection_properties(int i) {
			return getRuleContext(Jdbc_connection_propertiesContext.class,i);
		}
		public List<TerminalNode> DRIVER() { return getTokens(FbsqlParser.DRIVER); }
		public TerminalNode DRIVER(int i) {
			return getToken(FbsqlParser.DRIVER, i);
		}
		public List<Jdbc_driver_class_nameContext> jdbc_driver_class_name() {
			return getRuleContexts(Jdbc_driver_class_nameContext.class);
		}
		public Jdbc_driver_class_nameContext jdbc_driver_class_name(int i) {
			return getRuleContext(Jdbc_driver_class_nameContext.class,i);
		}
		public List<TerminalNode> LIB() { return getTokens(FbsqlParser.LIB); }
		public TerminalNode LIB(int i) {
			return getToken(FbsqlParser.LIB, i);
		}
		public List<Jar_fileContext> jar_file() {
			return getRuleContexts(Jar_fileContext.class);
		}
		public Jar_fileContext jar_file(int i) {
			return getRuleContext(Jar_fileContext.class,i);
		}
		public List<TerminalNode> CONNECTION() { return getTokens(FbsqlParser.CONNECTION); }
		public TerminalNode CONNECTION(int i) {
			return getToken(FbsqlParser.CONNECTION, i);
		}
		public List<TerminalNode> POOL() { return getTokens(FbsqlParser.POOL); }
		public TerminalNode POOL(int i) {
			return getToken(FbsqlParser.POOL, i);
		}
		public List<TerminalNode> EXPOSE() { return getTokens(FbsqlParser.EXPOSE); }
		public TerminalNode EXPOSE(int i) {
			return getToken(FbsqlParser.EXPOSE, i);
		}
		public List<TerminalNode> STATEMENTS() { return getTokens(FbsqlParser.STATEMENTS); }
		public TerminalNode STATEMENTS(int i) {
			return getToken(FbsqlParser.STATEMENTS, i);
		}
		public List<TerminalNode> CONNECTIONS() { return getTokens(FbsqlParser.CONNECTIONS); }
		public TerminalNode CONNECTIONS(int i) {
			return getToken(FbsqlParser.CONNECTIONS, i);
		}
		public TerminalNode AS() { return getToken(FbsqlParser.AS, 0); }
		public List<TerminalNode> ALLOW() { return getTokens(FbsqlParser.ALLOW); }
		public TerminalNode ALLOW(int i) {
			return getToken(FbsqlParser.ALLOW, i);
		}
		public List<TerminalNode> ALL() { return getTokens(FbsqlParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(FbsqlParser.ALL, i);
		}
		public List<TerminalNode> DECLARED() { return getTokens(FbsqlParser.DECLARED); }
		public TerminalNode DECLARED(int i) {
			return getToken(FbsqlParser.DECLARED, i);
		}
		public List<TerminalNode> REJECT() { return getTokens(FbsqlParser.REJECT); }
		public TerminalNode REJECT(int i) {
			return getToken(FbsqlParser.REJECT, i);
		}
		public List<TerminalNode> IF() { return getTokens(FbsqlParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(FbsqlParser.IF, i);
		}
		public List<TerminalNode> EXISTS() { return getTokens(FbsqlParser.EXISTS); }
		public TerminalNode EXISTS(int i) {
			return getToken(FbsqlParser.EXISTS, i);
		}
		public List<Native_sqlContext> native_sql() {
			return getRuleContexts(Native_sqlContext.class);
		}
		public Native_sqlContext native_sql(int i) {
			return getRuleContext(Native_sqlContext.class,i);
		}
		public List<TerminalNode> MIN() { return getTokens(FbsqlParser.MIN); }
		public TerminalNode MIN(int i) {
			return getToken(FbsqlParser.MIN, i);
		}
		public List<Connection_pool_size_minContext> connection_pool_size_min() {
			return getRuleContexts(Connection_pool_size_minContext.class);
		}
		public Connection_pool_size_minContext connection_pool_size_min(int i) {
			return getRuleContext(Connection_pool_size_minContext.class,i);
		}
		public List<TerminalNode> MAX() { return getTokens(FbsqlParser.MAX); }
		public TerminalNode MAX(int i) {
			return getToken(FbsqlParser.MAX, i);
		}
		public List<Connection_pool_size_maxContext> connection_pool_size_max() {
			return getRuleContexts(Connection_pool_size_maxContext.class);
		}
		public Connection_pool_size_maxContext connection_pool_size_max(int i) {
			return getRuleContext(Connection_pool_size_maxContext.class,i);
		}
		public Connect_to_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connect_to_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterConnect_to_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitConnect_to_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitConnect_to_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Connect_to_stmtContext connect_to_stmt() throws RecognitionException {
		Connect_to_stmtContext _localctx = new Connect_to_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_connect_to_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(CONNECT);
			setState(98);
			match(TO);
			setState(99);
			jdbc_url();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPOSE) | (1L << USER) | (1L << PASSWORD) | (1L << PROPERTIES) | (1L << DRIVER) | (1L << LIB) | (1L << CONNECTION))) != 0)) {
				{
				setState(152);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					{
					setState(100);
					match(USER);
					setState(101);
					user();
					}
					}
					break;
				case 2:
					{
					{
					setState(102);
					match(PASSWORD);
					setState(103);
					password();
					}
					}
					break;
				case 3:
					{
					{
					setState(104);
					match(PROPERTIES);
					setState(105);
					jdbc_connection_properties();
					}
					}
					break;
				case 4:
					{
					{
					setState(106);
					match(DRIVER);
					setState(107);
					jdbc_driver_class_name();
					}
					}
					break;
				case 5:
					{
					{
					setState(108);
					match(LIB);
					setState(109);
					jar_file();
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(110);
						match(T__0);
						setState(111);
						jar_file();
						}
						}
						setState(116);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 6:
					{
					{
					setState(117);
					match(CONNECTION);
					setState(118);
					match(POOL);
					setState(123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(123);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case MIN:
							{
							{
							setState(119);
							match(MIN);
							setState(120);
							connection_pool_size_min();
							}
							}
							break;
						case MAX:
							{
							{
							setState(121);
							match(MAX);
							setState(122);
							connection_pool_size_max();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(125); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==MIN || _la==MAX );
					}
					}
					break;
				case 7:
					{
					{
					setState(127);
					match(EXPOSE);
					setState(128);
					match(STATEMENTS);
					setState(135);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(129);
						match(ALLOW);
						setState(130);
						match(ALL);
						}
						break;
					case 2:
						{
						setState(131);
						match(ALLOW);
						setState(132);
						match(DECLARED);
						}
						break;
					case 3:
						{
						setState(133);
						match(REJECT);
						setState(134);
						match(ALL);
						}
						break;
					}
					}
					}
					break;
				case 8:
					{
					{
					setState(137);
					match(EXPOSE);
					setState(138);
					match(CONNECTIONS);
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(139);
						match(ALLOW);
						setState(140);
						match(ALL);
						}
						break;
					case 2:
						{
						{
						setState(141);
						match(ALLOW);
						setState(142);
						match(IF);
						setState(143);
						match(EXISTS);
						setState(144);
						match(T__1);
						setState(145);
						native_sql();
						setState(146);
						match(T__2);
						}
						}
						break;
					case 3:
						{
						setState(148);
						match(REJECT);
						setState(149);
						match(ALL);
						}
						break;
					}
					}
					}
					break;
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << IDENTIFIER) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(157);
					match(AS);
					}
				}

				setState(160);
				connection_alias();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Switch_to_stmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(FbsqlParser.SWITCH, 0); }
		public TerminalNode TO() { return getToken(FbsqlParser.TO, 0); }
		public Connection_aliasContext connection_alias() {
			return getRuleContext(Connection_aliasContext.class,0);
		}
		public Switch_to_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_to_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterSwitch_to_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitSwitch_to_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitSwitch_to_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_to_stmtContext switch_to_stmt() throws RecognitionException {
		Switch_to_stmtContext _localctx = new Switch_to_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_switch_to_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(SWITCH);
			setState(164);
			match(TO);
			setState(165);
			connection_alias();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declare_statement_stmtContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(FbsqlParser.DECLARE, 0); }
		public TerminalNode STATEMENT() { return getToken(FbsqlParser.STATEMENT, 0); }
		public Native_sqlContext native_sql() {
			return getRuleContext(Native_sqlContext.class,0);
		}
		public List<TerminalNode> STATIC() { return getTokens(FbsqlParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(FbsqlParser.STATIC, i);
		}
		public TerminalNode AS() { return getToken(FbsqlParser.AS, 0); }
		public Statement_aliasContext statement_alias() {
			return getRuleContext(Statement_aliasContext.class,0);
		}
		public List<TerminalNode> COMPRESSION() { return getTokens(FbsqlParser.COMPRESSION); }
		public TerminalNode COMPRESSION(int i) {
			return getToken(FbsqlParser.COMPRESSION, i);
		}
		public List<Compression_levelContext> compression_level() {
			return getRuleContexts(Compression_levelContext.class);
		}
		public Compression_levelContext compression_level(int i) {
			return getRuleContext(Compression_levelContext.class,i);
		}
		public List<TerminalNode> ROLES() { return getTokens(FbsqlParser.ROLES); }
		public TerminalNode ROLES(int i) {
			return getToken(FbsqlParser.ROLES, i);
		}
		public List<Role_nameContext> role_name() {
			return getRuleContexts(Role_nameContext.class);
		}
		public Role_nameContext role_name(int i) {
			return getRuleContext(Role_nameContext.class,i);
		}
		public List<TerminalNode> TRIGGER() { return getTokens(FbsqlParser.TRIGGER); }
		public TerminalNode TRIGGER(int i) {
			return getToken(FbsqlParser.TRIGGER, i);
		}
		public List<TerminalNode> BEFORE() { return getTokens(FbsqlParser.BEFORE); }
		public TerminalNode BEFORE(int i) {
			return getToken(FbsqlParser.BEFORE, i);
		}
		public List<Trigger_before_procedure_nameContext> trigger_before_procedure_name() {
			return getRuleContexts(Trigger_before_procedure_nameContext.class);
		}
		public Trigger_before_procedure_nameContext trigger_before_procedure_name(int i) {
			return getRuleContext(Trigger_before_procedure_nameContext.class,i);
		}
		public List<TerminalNode> AFTER() { return getTokens(FbsqlParser.AFTER); }
		public TerminalNode AFTER(int i) {
			return getToken(FbsqlParser.AFTER, i);
		}
		public List<Trigger_after_procedure_nameContext> trigger_after_procedure_name() {
			return getRuleContexts(Trigger_after_procedure_nameContext.class);
		}
		public Trigger_after_procedure_nameContext trigger_after_procedure_name(int i) {
			return getRuleContext(Trigger_after_procedure_nameContext.class,i);
		}
		public Declare_statement_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare_statement_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterDeclare_statement_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitDeclare_statement_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitDeclare_statement_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declare_statement_stmtContext declare_statement_stmt() throws RecognitionException {
		Declare_statement_stmtContext _localctx = new Declare_statement_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_declare_statement_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(DECLARE);
			setState(168);
			match(STATEMENT);
			setState(169);
			match(T__1);
			setState(170);
			native_sql();
			setState(171);
			match(T__2);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STATIC) | (1L << ROLES) | (1L << TRIGGER) | (1L << COMPRESSION))) != 0)) {
				{
				setState(193);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(172);
					match(STATIC);
					}
					break;
				case 2:
					{
					{
					setState(173);
					match(COMPRESSION);
					setState(174);
					compression_level();
					}
					}
					break;
				case 3:
					{
					{
					setState(175);
					match(ROLES);
					setState(176);
					match(T__1);
					setState(177);
					role_name();
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(178);
						match(T__0);
						setState(179);
						role_name();
						}
						}
						setState(184);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(185);
					match(T__2);
					}
					}
					break;
				case 4:
					{
					{
					setState(187);
					match(TRIGGER);
					setState(188);
					match(BEFORE);
					setState(189);
					trigger_before_procedure_name();
					}
					}
					break;
				case 5:
					{
					{
					setState(190);
					match(TRIGGER);
					setState(191);
					match(AFTER);
					setState(192);
					trigger_after_procedure_name();
					}
					}
					break;
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(198);
				match(AS);
				}
			}

			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING_LITERAL) {
				{
				setState(201);
				statement_alias();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declare_procedure_stmtContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(FbsqlParser.DECLARE, 0); }
		public TerminalNode PROCEDURE() { return getToken(FbsqlParser.PROCEDURE, 0); }
		public Procedure_nameContext procedure_name() {
			return getRuleContext(Procedure_nameContext.class,0);
		}
		public TerminalNode FOR() { return getToken(FbsqlParser.FOR, 0); }
		public Java_method_nameContext java_method_name() {
			return getRuleContext(Java_method_nameContext.class,0);
		}
		public Declare_procedure_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare_procedure_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterDeclare_procedure_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitDeclare_procedure_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitDeclare_procedure_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declare_procedure_stmtContext declare_procedure_stmt() throws RecognitionException {
		Declare_procedure_stmtContext _localctx = new Declare_procedure_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_declare_procedure_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(DECLARE);
			setState(205);
			match(PROCEDURE);
			setState(206);
			procedure_name();
			setState(207);
			match(FOR);
			setState(208);
			java_method_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Include_script_file_stmtContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(FbsqlParser.INCLUDE, 0); }
		public List<Sql_script_fileContext> sql_script_file() {
			return getRuleContexts(Sql_script_fileContext.class);
		}
		public Sql_script_fileContext sql_script_file(int i) {
			return getRuleContext(Sql_script_fileContext.class,i);
		}
		public Include_script_file_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include_script_file_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterInclude_script_file_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitInclude_script_file_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitInclude_script_file_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Include_script_file_stmtContext include_script_file_stmt() throws RecognitionException {
		Include_script_file_stmtContext _localctx = new Include_script_file_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_include_script_file_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(INCLUDE);
			setState(211);
			sql_script_file();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(212);
				match(T__0);
				setState(213);
				sql_script_file();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schedule_stmtContext extends ParserRuleContext {
		public TerminalNode SCHEDULE() { return getToken(FbsqlParser.SCHEDULE, 0); }
		public Procedure_nameContext procedure_name() {
			return getRuleContext(Procedure_nameContext.class,0);
		}
		public TerminalNode AT() { return getToken(FbsqlParser.AT, 0); }
		public Cron_expressionContext cron_expression() {
			return getRuleContext(Cron_expressionContext.class,0);
		}
		public Schedule_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schedule_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterSchedule_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitSchedule_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitSchedule_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Schedule_stmtContext schedule_stmt() throws RecognitionException {
		Schedule_stmtContext _localctx = new Schedule_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_schedule_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(SCHEDULE);
			setState(220);
			procedure_name();
			setState(221);
			match(AT);
			setState(222);
			cron_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00e3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\5\6F\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\7\25s\n\25\f\25\16\25v\13\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\6\25~\n\25\r\25\16\25\177\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u008a\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u0099\n\25\7\25\u009b\n\25\f\25\16\25\u009e\13\25"+
		"\3\25\5\25\u00a1\n\25\3\25\5\25\u00a4\n\25\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00b7"+
		"\n\27\f\27\16\27\u00ba\13\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7"+
		"\27\u00c4\n\27\f\27\16\27\u00c7\13\27\3\27\5\27\u00ca\n\27\3\27\5\27\u00cd"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00d9\n\31"+
		"\f\31\16\31\u00dc\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\67\2\33\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\3\4\2..\60\60\2\u00e6"+
		"\2\67\3\2\2\2\4:\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nE\3\2\2\2\fG\3\2\2\2\16"+
		"I\3\2\2\2\20K\3\2\2\2\22M\3\2\2\2\24O\3\2\2\2\26Q\3\2\2\2\30S\3\2\2\2"+
		"\32U\3\2\2\2\34W\3\2\2\2\36Y\3\2\2\2 [\3\2\2\2\"]\3\2\2\2$_\3\2\2\2&a"+
		"\3\2\2\2(c\3\2\2\2*\u00a5\3\2\2\2,\u00a9\3\2\2\2.\u00ce\3\2\2\2\60\u00d4"+
		"\3\2\2\2\62\u00dd\3\2\2\2\64\66\13\2\2\2\65\64\3\2\2\2\669\3\2\2\2\67"+
		"8\3\2\2\2\67\65\3\2\2\28\3\3\2\2\29\67\3\2\2\2:;\t\2\2\2;\5\3\2\2\2<="+
		"\7.\2\2=\7\3\2\2\2>?\7.\2\2?\t\3\2\2\2@F\7\16\2\2AB\7\17\2\2BF\7\r\2\2"+
		"CD\7\17\2\2DF\7\20\2\2E@\3\2\2\2EA\3\2\2\2EC\3\2\2\2F\13\3\2\2\2GH\t\2"+
		"\2\2H\r\3\2\2\2IJ\t\2\2\2J\17\3\2\2\2KL\t\2\2\2L\21\3\2\2\2MN\7\60\2\2"+
		"N\23\3\2\2\2OP\7\60\2\2P\25\3\2\2\2QR\t\2\2\2R\27\3\2\2\2ST\7\60\2\2T"+
		"\31\3\2\2\2UV\7\60\2\2V\33\3\2\2\2WX\7\60\2\2X\35\3\2\2\2YZ\7\60\2\2Z"+
		"\37\3\2\2\2[\\\7/\2\2\\!\3\2\2\2]^\7/\2\2^#\3\2\2\2_`\7\60\2\2`%\3\2\2"+
		"\2ab\7\60\2\2b\'\3\2\2\2cd\7\25\2\2de\7\26\2\2e\u009c\5\24\13\2fg\7\27"+
		"\2\2g\u009b\5\26\f\2hi\7\30\2\2i\u009b\5\30\r\2jk\7\31\2\2k\u009b\5\32"+
		"\16\2lm\7\32\2\2m\u009b\5\34\17\2no\7\33\2\2ot\5\36\20\2pq\7\3\2\2qs\5"+
		"\36\20\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\u009b\3\2\2\2vt\3\2"+
		"\2\2wx\7\34\2\2x}\7\35\2\2yz\7\37\2\2z~\5 \21\2{|\7 \2\2|~\5\"\22\2}y"+
		"\3\2\2\2}{\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u009b"+
		"\3\2\2\2\u0081\u0082\7\6\2\2\u0082\u0089\7!\2\2\u0083\u0084\7%\2\2\u0084"+
		"\u008a\7\"\2\2\u0085\u0086\7%\2\2\u0086\u008a\7#\2\2\u0087\u0088\7&\2"+
		"\2\u0088\u008a\7\"\2\2\u0089\u0083\3\2\2\2\u0089\u0085\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u008a\u009b\3\2\2\2\u008b\u008c\7\6\2\2\u008c\u0098\7$\2\2\u008d"+
		"\u008e\7%\2\2\u008e\u0099\7\"\2\2\u008f\u0090\7%\2\2\u0090\u0091\7\'\2"+
		"\2\u0091\u0092\7(\2\2\u0092\u0093\7\4\2\2\u0093\u0094\5\2\2\2\u0094\u0095"+
		"\7\5\2\2\u0095\u0099\3\2\2\2\u0096\u0097\7&\2\2\u0097\u0099\7\"\2\2\u0098"+
		"\u008d\3\2\2\2\u0098\u008f\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\3\2"+
		"\2\2\u009af\3\2\2\2\u009ah\3\2\2\2\u009aj\3\2\2\2\u009al\3\2\2\2\u009a"+
		"n\3\2\2\2\u009aw\3\2\2\2\u009a\u0081\3\2\2\2\u009a\u008b\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a3\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\7\f\2\2\u00a0\u009f\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\5\f\7\2\u00a3\u00a0\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4)\3\2\2\2\u00a5\u00a6\7)\2\2\u00a6\u00a7"+
		"\7\26\2\2\u00a7\u00a8\5\f\7\2\u00a8+\3\2\2\2\u00a9\u00aa\7\21\2\2\u00aa"+
		"\u00ab\7\24\2\2\u00ab\u00ac\7\4\2\2\u00ac\u00ad\5\2\2\2\u00ad\u00c5\7"+
		"\5\2\2\u00ae\u00c4\7\7\2\2\u00af\u00b0\7\r\2\2\u00b0\u00c4\5\n\6\2\u00b1"+
		"\u00b2\7\b\2\2\u00b2\u00b3\7\4\2\2\u00b3\u00b8\5\4\3\2\u00b4\u00b5\7\3"+
		"\2\2\u00b5\u00b7\5\4\3\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00bb\u00bc\7\5\2\2\u00bc\u00c4\3\2\2\2\u00bd\u00be\7\t\2\2\u00be"+
		"\u00bf\7\n\2\2\u00bf\u00c4\5\6\4\2\u00c0\u00c1\7\t\2\2\u00c1\u00c2\7\13"+
		"\2\2\u00c2\u00c4\5\b\5\2\u00c3\u00ae\3\2\2\2\u00c3\u00af\3\2\2\2\u00c3"+
		"\u00b1\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00ca\7\f\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00cd\5\16\b\2\u00cc\u00cb\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd-\3\2\2\2\u00ce\u00cf\7\21\2\2\u00cf\u00d0\7\22\2"+
		"\2\u00d0\u00d1\5\20\t\2\u00d1\u00d2\7\23\2\2\u00d2\u00d3\5\22\n\2\u00d3"+
		"/\3\2\2\2\u00d4\u00d5\7,\2\2\u00d5\u00da\5$\23\2\u00d6\u00d7\7\3\2\2\u00d7"+
		"\u00d9\5$\23\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\61\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de"+
		"\7*\2\2\u00de\u00df\5\20\t\2\u00df\u00e0\7+\2\2\u00e0\u00e1\5&\24\2\u00e1"+
		"\63\3\2\2\2\23\67Et}\177\u0089\u0098\u009a\u009c\u00a0\u00a3\u00b8\u00c3"+
		"\u00c5\u00c9\u00cc\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}