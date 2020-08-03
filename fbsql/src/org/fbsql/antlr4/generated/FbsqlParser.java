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
		T__0=1, T__1=2, T__2=3, EXPOSE=4, PREFETCH=5, ROLES=6, TRIGGER=7, BEFORE=8, 
		AFTER=9, AS=10, COMPRESSION=11, NONE=12, BEST=13, SPEED=14, ON=15, OFF=16, 
		DECLARE=17, PROCEDURE=18, FOR=19, CONNECT=20, TO=21, USER=22, PASSWORD=23, 
<<<<<<< HEAD
		PROPERTIES=24, DRIVER=25, LIB=26, CONNECTION=27, POOL=28, MIN=29, MAX=30, 
		LOGIN=31, IF=32, EXISTS=33, SCHEDULE=34, AT=35, INCLUDE=36, FILE=37, IDENTIFIER=38, 
		NUMERIC_LITERAL=39, STRING_LITERAL=40, SINGLE_LINE_COMMENT=41, MULTILINE_COMMENT=42, 
		SPACES=43, UNEXPECTED_CHAR=44;
=======
		PROPERTIES=24, DRIVER=25, JAR=26, FILES=27, CONNECTION=28, POOL=29, SIZE=30, 
		MIN=31, MAX=32, DEBUG=33, SET=34, ALLOW=35, LOGIN=36, IF=37, EXISTS=38, 
		SCHEDULE=39, AT=40, INCLUDE=41, SCRIPT=42, FILE=43, IDENTIFIER=44, NUMERIC_LITERAL=45, 
		STRING_LITERAL=46, SINGLE_LINE_COMMENT=47, MULTILINE_COMMENT=48, SPACES=49, 
		UNEXPECTED_CHAR=50;
>>>>>>> refs/remotes/origin/master
	public static final int
<<<<<<< HEAD
		RULE_native_sql = 0, RULE_role_name = 1, RULE_trigger_before_procedure_name = 2, 
		RULE_trigger_after_procedure_name = 3, RULE_compression_level = 4, RULE_prefetch_on_off = 5, 
		RULE_statement_alias = 6, RULE_procedure_name = 7, RULE_java_method_name = 8, 
		RULE_jdbc_url = 9, RULE_user = 10, RULE_password = 11, RULE_jdbc_connection_properties = 12, 
		RULE_jdbc_driver_class_name = 13, RULE_jar_file = 14, RULE_connection_pool_size_min = 15, 
		RULE_connection_pool_size_max = 16, RULE_sql_script_file = 17, RULE_cron_expression = 18, 
		RULE_connect_to_stmt = 19, RULE_expose_stmt = 20, RULE_declare_procedure_stmt = 21, 
		RULE_include_script_file_stmt = 22, RULE_login_if_exists = 23, RULE_schedule_stmt = 24;
=======
		RULE_fbsql_stmt = 0, RULE_native_sql = 1, RULE_role_name = 2, RULE_trigger_before_procedure_name = 3, 
		RULE_trigger_after_procedure_name = 4, RULE_compression = 5, RULE_prefetch_on_off = 6, 
		RULE_statement_alias = 7, RULE_expose_stmt = 8, RULE_procedure_name = 9, 
		RULE_java_method_name = 10, RULE_declare_procedure_stmt = 11, RULE_jdbc_url = 12, 
		RULE_jdbc_user = 13, RULE_jdbc_password = 14, RULE_jdbc_properties = 15, 
		RULE_jdbc_driver = 16, RULE_jdbc_driver_jar = 17, RULE_connection_pool_size_min = 18, 
		RULE_connection_pool_size_max = 19, RULE_debug_on_off = 20, RULE_connect_to_stmt = 21, 
		RULE_file = 22, RULE_include_script_file_stmt = 23, RULE_set_allow_login_if_exists = 24, 
		RULE_cron_expression = 25, RULE_schedule_stmt = 26;
>>>>>>> refs/remotes/origin/master
	private static String[] makeRuleNames() {
		return new String[] {
<<<<<<< HEAD
			"native_sql", "role_name", "trigger_before_procedure_name", "trigger_after_procedure_name", 
			"compression_level", "prefetch_on_off", "statement_alias", "procedure_name", 
			"java_method_name", "jdbc_url", "user", "password", "jdbc_connection_properties", 
			"jdbc_driver_class_name", "jar_file", "connection_pool_size_min", "connection_pool_size_max", 
			"sql_script_file", "cron_expression", "connect_to_stmt", "expose_stmt", 
			"declare_procedure_stmt", "include_script_file_stmt", "login_if_exists", 
			"schedule_stmt"
=======
			"fbsql_stmt", "native_sql", "role_name", "trigger_before_procedure_name", 
			"trigger_after_procedure_name", "compression", "prefetch_on_off", "statement_alias", 
			"expose_stmt", "procedure_name", "java_method_name", "declare_procedure_stmt", 
			"jdbc_url", "jdbc_user", "jdbc_password", "jdbc_properties", "jdbc_driver", 
			"jdbc_driver_jar", "connection_pool_size_min", "connection_pool_size_max", 
			"debug_on_off", "connect_to_stmt", "file", "include_script_file_stmt", 
			"set_allow_login_if_exists", "cron_expression", "schedule_stmt"
>>>>>>> refs/remotes/origin/master
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
			null, null, null, null, "EXPOSE", "PREFETCH", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "COMPRESSION", "NONE", "BEST", "SPEED", "ON", "OFF", "DECLARE", 
			"PROCEDURE", "FOR", "CONNECT", "TO", "USER", "PASSWORD", "PROPERTIES", 
<<<<<<< HEAD
			"DRIVER", "LIB", "CONNECTION", "POOL", "MIN", "MAX", "LOGIN", "IF", "EXISTS", 
			"SCHEDULE", "AT", "INCLUDE", "FILE", "IDENTIFIER", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
			"UNEXPECTED_CHAR"
=======
			"DRIVER", "JAR", "FILES", "CONNECTION", "POOL", "SIZE", "MIN", "MAX", 
			"DEBUG", "SET", "ALLOW", "LOGIN", "IF", "EXISTS", "SCHEDULE", "AT", "INCLUDE", 
			"SCRIPT", "FILE", "IDENTIFIER", "NUMERIC_LITERAL", "STRING_LITERAL", 
			"SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"
>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
=======
	public static class Fbsql_stmtContext extends ParserRuleContext {
		public Connect_to_stmtContext connect_to_stmt() {
			return getRuleContext(Connect_to_stmtContext.class,0);
		}
		public Declare_procedure_stmtContext declare_procedure_stmt() {
			return getRuleContext(Declare_procedure_stmtContext.class,0);
		}
		public Expose_stmtContext expose_stmt() {
			return getRuleContext(Expose_stmtContext.class,0);
		}
		public Fbsql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fbsql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterFbsql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitFbsql_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitFbsql_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fbsql_stmtContext fbsql_stmt() throws RecognitionException {
		Fbsql_stmtContext _localctx = new Fbsql_stmtContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fbsql_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONNECT:
				{
				setState(54);
				connect_to_stmt();
				}
				break;
			case DECLARE:
				{
				setState(55);
				declare_procedure_stmt();
				}
				break;
			case EXPOSE:
				{
				setState(56);
				expose_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
	public static class Compression_levelContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(FbsqlParser.NONE, 0); }
		public TerminalNode BEST() { return getToken(FbsqlParser.BEST, 0); }
		public TerminalNode COMPRESSION() { return getToken(FbsqlParser.COMPRESSION, 0); }
		public TerminalNode SPEED() { return getToken(FbsqlParser.SPEED, 0); }
		public Compression_levelContext(ParserRuleContext parent, int invokingState) {
=======
	public static class CompressionContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(FbsqlParser.NONE, 0); }
		public TerminalNode BEST() { return getToken(FbsqlParser.BEST, 0); }
		public TerminalNode COMPRESSION() { return getToken(FbsqlParser.COMPRESSION, 0); }
		public TerminalNode SPEED() { return getToken(FbsqlParser.SPEED, 0); }
		public CompressionContext(ParserRuleContext parent, int invokingState) {
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
				setState(62);
=======
				setState(71);
>>>>>>> refs/remotes/origin/master
				match(NONE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< HEAD
				setState(63);
				match(BEST);
				setState(64);
=======
				setState(72);
				match(BEST);
				setState(73);
>>>>>>> refs/remotes/origin/master
				match(COMPRESSION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< HEAD
				setState(65);
				match(BEST);
				setState(66);
=======
				setState(74);
				match(BEST);
				setState(75);
>>>>>>> refs/remotes/origin/master
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

	public static class Prefetch_on_offContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(FbsqlParser.ON, 0); }
		public TerminalNode OFF() { return getToken(FbsqlParser.OFF, 0); }
		public Prefetch_on_offContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefetch_on_off; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterPrefetch_on_off(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitPrefetch_on_off(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitPrefetch_on_off(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefetch_on_offContext prefetch_on_off() throws RecognitionException {
		Prefetch_on_offContext _localctx = new Prefetch_on_offContext(_ctx, getState());
<<<<<<< HEAD
		enterRule(_localctx, 10, RULE_prefetch_on_off);
=======
		enterRule(_localctx, 12, RULE_prefetch_on_off);
>>>>>>> refs/remotes/origin/master
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==ON || _la==OFF) ) {
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

<<<<<<< HEAD
=======
	public static class Expose_stmtContext extends ParserRuleContext {
		public TerminalNode EXPOSE() { return getToken(FbsqlParser.EXPOSE, 0); }
		public Native_sqlContext native_sql() {
			return getRuleContext(Native_sqlContext.class,0);
		}
		public TerminalNode AS() { return getToken(FbsqlParser.AS, 0); }
		public Statement_aliasContext statement_alias() {
			return getRuleContext(Statement_aliasContext.class,0);
		}
		public List<TerminalNode> PREFETCH() { return getTokens(FbsqlParser.PREFETCH); }
		public TerminalNode PREFETCH(int i) {
			return getToken(FbsqlParser.PREFETCH, i);
		}
		public List<Prefetch_on_offContext> prefetch_on_off() {
			return getRuleContexts(Prefetch_on_offContext.class);
		}
		public Prefetch_on_offContext prefetch_on_off(int i) {
			return getRuleContext(Prefetch_on_offContext.class,i);
		}
		public List<TerminalNode> COMPRESSION() { return getTokens(FbsqlParser.COMPRESSION); }
		public TerminalNode COMPRESSION(int i) {
			return getToken(FbsqlParser.COMPRESSION, i);
		}
		public List<CompressionContext> compression() {
			return getRuleContexts(CompressionContext.class);
		}
		public CompressionContext compression(int i) {
			return getRuleContext(CompressionContext.class,i);
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
		public Expose_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expose_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterExpose_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitExpose_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitExpose_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expose_stmtContext expose_stmt() throws RecognitionException {
		Expose_stmtContext _localctx = new Expose_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expose_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(EXPOSE);
			setState(83);
			match(T__0);
			setState(84);
			native_sql();
			setState(85);
			match(T__1);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFETCH) | (1L << ROLES) | (1L << TRIGGER) | (1L << COMPRESSION))) != 0)) {
				{
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					{
					setState(86);
					match(PREFETCH);
					setState(87);
					prefetch_on_off();
					}
					}
					break;
				case 2:
					{
					{
					setState(88);
					match(COMPRESSION);
					setState(89);
					compression();
					}
					}
					break;
				case 3:
					{
					{
					setState(90);
					match(ROLES);
					setState(91);
					match(T__0);
					setState(92);
					role_name();
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(93);
						match(T__2);
						setState(94);
						role_name();
						}
						}
						setState(99);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(100);
					match(T__1);
					}
					}
					break;
				case 4:
					{
					{
					setState(102);
					match(TRIGGER);
					setState(103);
					match(BEFORE);
					setState(104);
					trigger_before_procedure_name();
					}
					}
					break;
				case 5:
					{
					{
					setState(105);
					match(TRIGGER);
					setState(106);
					match(AFTER);
					setState(107);
					trigger_after_procedure_name();
					}
					}
					break;
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(113);
				match(AS);
				}
			}

			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING_LITERAL) {
				{
				setState(116);
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

>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
=======
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
		enterRule(_localctx, 22, RULE_declare_procedure_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(DECLARE);
			setState(124);
			match(PROCEDURE);
			setState(125);
			procedure_name();
			setState(126);
			match(FOR);
			setState(127);
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

>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
	public static class Sql_script_fileContext extends ParserRuleContext {
=======
	public static class Debug_on_offContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(FbsqlParser.ON, 0); }
		public TerminalNode OFF() { return getToken(FbsqlParser.OFF, 0); }
		public Debug_on_offContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debug_on_off; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterDebug_on_off(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitDebug_on_off(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitDebug_on_off(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Debug_on_offContext debug_on_off() throws RecognitionException {
		Debug_on_offContext _localctx = new Debug_on_offContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_debug_on_off);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !(_la==ON || _la==OFF) ) {
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

	public static class Connect_to_stmtContext extends ParserRuleContext {
		public TerminalNode CONNECT() { return getToken(FbsqlParser.CONNECT, 0); }
		public TerminalNode TO() { return getToken(FbsqlParser.TO, 0); }
		public Jdbc_urlContext jdbc_url() {
			return getRuleContext(Jdbc_urlContext.class,0);
		}
		public List<TerminalNode> USER() { return getTokens(FbsqlParser.USER); }
		public TerminalNode USER(int i) {
			return getToken(FbsqlParser.USER, i);
		}
		public List<Jdbc_userContext> jdbc_user() {
			return getRuleContexts(Jdbc_userContext.class);
		}
		public Jdbc_userContext jdbc_user(int i) {
			return getRuleContext(Jdbc_userContext.class,i);
		}
		public List<TerminalNode> PASSWORD() { return getTokens(FbsqlParser.PASSWORD); }
		public TerminalNode PASSWORD(int i) {
			return getToken(FbsqlParser.PASSWORD, i);
		}
		public List<Jdbc_passwordContext> jdbc_password() {
			return getRuleContexts(Jdbc_passwordContext.class);
		}
		public Jdbc_passwordContext jdbc_password(int i) {
			return getRuleContext(Jdbc_passwordContext.class,i);
		}
		public List<TerminalNode> PROPERTIES() { return getTokens(FbsqlParser.PROPERTIES); }
		public TerminalNode PROPERTIES(int i) {
			return getToken(FbsqlParser.PROPERTIES, i);
		}
		public List<Jdbc_propertiesContext> jdbc_properties() {
			return getRuleContexts(Jdbc_propertiesContext.class);
		}
		public Jdbc_propertiesContext jdbc_properties(int i) {
			return getRuleContext(Jdbc_propertiesContext.class,i);
		}
		public List<TerminalNode> DRIVER() { return getTokens(FbsqlParser.DRIVER); }
		public TerminalNode DRIVER(int i) {
			return getToken(FbsqlParser.DRIVER, i);
		}
		public List<Jdbc_driverContext> jdbc_driver() {
			return getRuleContexts(Jdbc_driverContext.class);
		}
		public Jdbc_driverContext jdbc_driver(int i) {
			return getRuleContext(Jdbc_driverContext.class,i);
		}
		public List<TerminalNode> JAR() { return getTokens(FbsqlParser.JAR); }
		public TerminalNode JAR(int i) {
			return getToken(FbsqlParser.JAR, i);
		}
		public List<TerminalNode> FILES() { return getTokens(FbsqlParser.FILES); }
		public TerminalNode FILES(int i) {
			return getToken(FbsqlParser.FILES, i);
		}
		public List<Jdbc_driver_jarContext> jdbc_driver_jar() {
			return getRuleContexts(Jdbc_driver_jarContext.class);
		}
		public Jdbc_driver_jarContext jdbc_driver_jar(int i) {
			return getRuleContext(Jdbc_driver_jarContext.class,i);
		}
		public List<TerminalNode> CONNECTION() { return getTokens(FbsqlParser.CONNECTION); }
		public TerminalNode CONNECTION(int i) {
			return getToken(FbsqlParser.CONNECTION, i);
		}
		public List<TerminalNode> POOL() { return getTokens(FbsqlParser.POOL); }
		public TerminalNode POOL(int i) {
			return getToken(FbsqlParser.POOL, i);
		}
		public List<TerminalNode> SIZE() { return getTokens(FbsqlParser.SIZE); }
		public TerminalNode SIZE(int i) {
			return getToken(FbsqlParser.SIZE, i);
		}
		public List<TerminalNode> DEBUG() { return getTokens(FbsqlParser.DEBUG); }
		public TerminalNode DEBUG(int i) {
			return getToken(FbsqlParser.DEBUG, i);
		}
		public List<Debug_on_offContext> debug_on_off() {
			return getRuleContexts(Debug_on_offContext.class);
		}
		public Debug_on_offContext debug_on_off(int i) {
			return getRuleContext(Debug_on_offContext.class,i);
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
		enterRule(_localctx, 42, RULE_connect_to_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(CONNECT);
			setState(148);
			match(TO);
			setState(149);
			jdbc_url();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << USER) | (1L << PASSWORD) | (1L << PROPERTIES) | (1L << DRIVER) | (1L << JAR) | (1L << CONNECTION) | (1L << DEBUG))) != 0)) {
				{
				setState(184);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case USER:
					{
					{
					setState(150);
					match(USER);
					setState(151);
					jdbc_user();
					}
					}
					break;
				case PASSWORD:
					{
					{
					setState(152);
					match(PASSWORD);
					setState(153);
					jdbc_password();
					}
					}
					break;
				case PROPERTIES:
					{
					{
					setState(154);
					match(PROPERTIES);
					setState(155);
					jdbc_properties();
					}
					}
					break;
				case DRIVER:
					{
					{
					setState(156);
					match(DRIVER);
					setState(157);
					jdbc_driver();
					}
					}
					break;
				case JAR:
					{
					{
					setState(158);
					match(JAR);
					setState(159);
					match(FILES);
					setState(160);
					match(T__0);
					setState(161);
					jdbc_driver_jar();
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(162);
						match(T__2);
						setState(163);
						jdbc_driver_jar();
						}
						}
						setState(168);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(169);
					match(T__1);
					}
					}
					break;
				case CONNECTION:
					{
					{
					setState(171);
					match(CONNECTION);
					setState(172);
					match(POOL);
					setState(173);
					match(SIZE);
					setState(178); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(178);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case MIN:
							{
							{
							setState(174);
							match(MIN);
							setState(175);
							connection_pool_size_min();
							}
							}
							break;
						case MAX:
							{
							{
							setState(176);
							match(MAX);
							setState(177);
							connection_pool_size_max();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(180); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==MIN || _la==MAX );
					}
					}
					break;
				case DEBUG:
					{
					{
					setState(182);
					match(DEBUG);
					setState(183);
					debug_on_off();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(188);
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

	public static class FileContext extends ParserRuleContext {
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
			setState(93);
=======
			setState(189);
>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
=======
	public static class Include_script_file_stmtContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(FbsqlParser.INCLUDE, 0); }
		public TerminalNode SCRIPT() { return getToken(FbsqlParser.SCRIPT, 0); }
		public TerminalNode FILE() { return getToken(FbsqlParser.FILE, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(INCLUDE);
			setState(192);
			match(SCRIPT);
			setState(193);
			match(FILE);
			setState(194);
			file();
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

	public static class Set_allow_login_if_existsContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(FbsqlParser.SET, 0); }
		public TerminalNode ALLOW() { return getToken(FbsqlParser.ALLOW, 0); }
		public TerminalNode LOGIN() { return getToken(FbsqlParser.LOGIN, 0); }
		public TerminalNode IF() { return getToken(FbsqlParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(FbsqlParser.EXISTS, 0); }
		public Native_sqlContext native_sql() {
			return getRuleContext(Native_sqlContext.class,0);
		}
		public Set_allow_login_if_existsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_allow_login_if_exists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterSet_allow_login_if_exists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitSet_allow_login_if_exists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitSet_allow_login_if_exists(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_allow_login_if_existsContext set_allow_login_if_exists() throws RecognitionException {
		Set_allow_login_if_existsContext _localctx = new Set_allow_login_if_existsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_set_allow_login_if_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(SET);
			setState(197);
			match(ALLOW);
			setState(198);
			match(LOGIN);
			setState(199);
			match(IF);
			setState(200);
			match(EXISTS);
			setState(201);
			match(T__0);
			setState(202);
			native_sql();
			setState(203);
			match(T__1);
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

>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
			setState(95);
=======
			setState(205);
>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
	public static class Connect_to_stmtContext extends ParserRuleContext {
		public TerminalNode CONNECT() { return getToken(FbsqlParser.CONNECT, 0); }
		public TerminalNode TO() { return getToken(FbsqlParser.TO, 0); }
		public Jdbc_urlContext jdbc_url() {
			return getRuleContext(Jdbc_urlContext.class,0);
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
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << USER) | (1L << PASSWORD) | (1L << PROPERTIES) | (1L << DRIVER) | (1L << LIB) | (1L << CONNECTION))) != 0)) {
				{
				setState(127);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case USER:
					{
					{
					setState(100);
					match(USER);
					setState(101);
					user();
					}
					}
					break;
				case PASSWORD:
					{
					{
					setState(102);
					match(PASSWORD);
					setState(103);
					password();
					}
					}
					break;
				case PROPERTIES:
					{
					{
					setState(104);
					match(PROPERTIES);
					setState(105);
					jdbc_connection_properties();
					}
					}
					break;
				case DRIVER:
					{
					{
					setState(106);
					match(DRIVER);
					setState(107);
					jdbc_driver_class_name();
					}
					}
					break;
				case LIB:
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
				case CONNECTION:
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
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(131);
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

	public static class Expose_stmtContext extends ParserRuleContext {
		public TerminalNode EXPOSE() { return getToken(FbsqlParser.EXPOSE, 0); }
		public Native_sqlContext native_sql() {
			return getRuleContext(Native_sqlContext.class,0);
		}
		public TerminalNode AS() { return getToken(FbsqlParser.AS, 0); }
		public Statement_aliasContext statement_alias() {
			return getRuleContext(Statement_aliasContext.class,0);
		}
		public List<TerminalNode> PREFETCH() { return getTokens(FbsqlParser.PREFETCH); }
		public TerminalNode PREFETCH(int i) {
			return getToken(FbsqlParser.PREFETCH, i);
		}
		public List<Prefetch_on_offContext> prefetch_on_off() {
			return getRuleContexts(Prefetch_on_offContext.class);
		}
		public Prefetch_on_offContext prefetch_on_off(int i) {
			return getRuleContext(Prefetch_on_offContext.class,i);
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
		public Expose_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expose_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterExpose_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitExpose_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitExpose_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expose_stmtContext expose_stmt() throws RecognitionException {
		Expose_stmtContext _localctx = new Expose_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expose_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(EXPOSE);
			setState(133);
			match(T__1);
			setState(134);
			native_sql();
			setState(135);
			match(T__2);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFETCH) | (1L << ROLES) | (1L << TRIGGER) | (1L << COMPRESSION))) != 0)) {
				{
				setState(158);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					{
					setState(136);
					match(PREFETCH);
					setState(137);
					prefetch_on_off();
					}
					}
					break;
				case 2:
					{
					{
					setState(138);
					match(COMPRESSION);
					setState(139);
					compression_level();
					}
					}
					break;
				case 3:
					{
					{
					setState(140);
					match(ROLES);
					setState(141);
					match(T__1);
					setState(142);
					role_name();
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(143);
						match(T__0);
						setState(144);
						role_name();
						}
						}
						setState(149);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(150);
					match(T__2);
					}
					}
					break;
				case 4:
					{
					{
					setState(152);
					match(TRIGGER);
					setState(153);
					match(BEFORE);
					setState(154);
					trigger_before_procedure_name();
					}
					}
					break;
				case 5:
					{
					{
					setState(155);
					match(TRIGGER);
					setState(156);
					match(AFTER);
					setState(157);
					trigger_after_procedure_name();
					}
					}
					break;
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(163);
				match(AS);
				}
			}

			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING_LITERAL) {
				{
				setState(166);
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
=======
	public static class Schedule_stmtContext extends ParserRuleContext {
		public TerminalNode SCHEDULE() { return getToken(FbsqlParser.SCHEDULE, 0); }
>>>>>>> refs/remotes/origin/master
		public Procedure_nameContext procedure_name() {
			return getRuleContext(Procedure_nameContext.class,0);
		}
<<<<<<< HEAD
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
		enterRule(_localctx, 42, RULE_declare_procedure_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(DECLARE);
			setState(170);
			match(PROCEDURE);
			setState(171);
			procedure_name();
			setState(172);
			match(FOR);
			setState(173);
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
		enterRule(_localctx, 44, RULE_include_script_file_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(INCLUDE);
			setState(176);
			sql_script_file();
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(177);
				match(T__0);
				setState(178);
				sql_script_file();
				}
				}
				setState(183);
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

	public static class Login_if_existsContext extends ParserRuleContext {
		public TerminalNode LOGIN() { return getToken(FbsqlParser.LOGIN, 0); }
		public TerminalNode IF() { return getToken(FbsqlParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(FbsqlParser.EXISTS, 0); }
		public Native_sqlContext native_sql() {
			return getRuleContext(Native_sqlContext.class,0);
		}
		public Login_if_existsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_login_if_exists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterLogin_if_exists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitLogin_if_exists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitLogin_if_exists(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Login_if_existsContext login_if_exists() throws RecognitionException {
		Login_if_existsContext _localctx = new Login_if_existsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_login_if_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(LOGIN);
			setState(185);
			match(IF);
			setState(186);
			match(EXISTS);
			setState(187);
			match(T__1);
			setState(188);
			native_sql();
			setState(189);
			match(T__2);
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
=======
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
			setState(191);
			match(SCHEDULE);
			setState(192);
			procedure_name();
			setState(193);
			match(AT);
			setState(194);
=======
			setState(207);
			match(SCHEDULE);
			setState(208);
			procedure_name();
			setState(209);
			match(AT);
			setState(210);
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u00c7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
=======
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00d7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
>>>>>>> refs/remotes/origin/master
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
<<<<<<< HEAD
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\5\6F\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\7\25s\n\25\f\25\16\25v\13\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\6\25~\n\25\r\25\16\25\177\7\25\u0082\n\25\f\25\16\25\u0085\13"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7"+
		"\26\u0094\n\26\f\26\16\26\u0097\13\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\7\26\u00a1\n\26\f\26\16\26\u00a4\13\26\3\26\5\26\u00a7\n\26\3"+
		"\26\5\26\u00aa\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\7\30\u00b6\n\30\f\30\16\30\u00b9\13\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\67\2\33\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\2\4\4\2((**\3\2\21\22\2\u00c2\2\67\3\2"+
		"\2\2\4:\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nE\3\2\2\2\fG\3\2\2\2\16I\3\2\2"+
		"\2\20K\3\2\2\2\22M\3\2\2\2\24O\3\2\2\2\26Q\3\2\2\2\30S\3\2\2\2\32U\3\2"+
		"\2\2\34W\3\2\2\2\36Y\3\2\2\2 [\3\2\2\2\"]\3\2\2\2$_\3\2\2\2&a\3\2\2\2"+
		"(c\3\2\2\2*\u0086\3\2\2\2,\u00ab\3\2\2\2.\u00b1\3\2\2\2\60\u00ba\3\2\2"+
		"\2\62\u00c1\3\2\2\2\64\66\13\2\2\2\65\64\3\2\2\2\669\3\2\2\2\678\3\2\2"+
		"\2\67\65\3\2\2\28\3\3\2\2\29\67\3\2\2\2:;\t\2\2\2;\5\3\2\2\2<=\7(\2\2"+
		"=\7\3\2\2\2>?\7(\2\2?\t\3\2\2\2@F\7\16\2\2AB\7\17\2\2BF\7\r\2\2CD\7\17"+
		"\2\2DF\7\20\2\2E@\3\2\2\2EA\3\2\2\2EC\3\2\2\2F\13\3\2\2\2GH\t\3\2\2H\r"+
		"\3\2\2\2IJ\t\2\2\2J\17\3\2\2\2KL\t\2\2\2L\21\3\2\2\2MN\7*\2\2N\23\3\2"+
		"\2\2OP\7*\2\2P\25\3\2\2\2QR\t\2\2\2R\27\3\2\2\2ST\7*\2\2T\31\3\2\2\2U"+
		"V\7*\2\2V\33\3\2\2\2WX\7*\2\2X\35\3\2\2\2YZ\7*\2\2Z\37\3\2\2\2[\\\7)\2"+
		"\2\\!\3\2\2\2]^\7)\2\2^#\3\2\2\2_`\7*\2\2`%\3\2\2\2ab\7*\2\2b\'\3\2\2"+
		"\2cd\7\26\2\2de\7\27\2\2e\u0083\5\24\13\2fg\7\30\2\2g\u0082\5\26\f\2h"+
		"i\7\31\2\2i\u0082\5\30\r\2jk\7\32\2\2k\u0082\5\32\16\2lm\7\33\2\2m\u0082"+
		"\5\34\17\2no\7\34\2\2ot\5\36\20\2pq\7\3\2\2qs\5\36\20\2rp\3\2\2\2sv\3"+
		"\2\2\2tr\3\2\2\2tu\3\2\2\2u\u0082\3\2\2\2vt\3\2\2\2wx\7\35\2\2x}\7\36"+
		"\2\2yz\7\37\2\2z~\5 \21\2{|\7 \2\2|~\5\"\22\2}y\3\2\2\2}{\3\2\2\2~\177"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081f\3\2"+
		"\2\2\u0081h\3\2\2\2\u0081j\3\2\2\2\u0081l\3\2\2\2\u0081n\3\2\2\2\u0081"+
		"w\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2"+
		"\u0084)\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\6\2\2\u0087\u0088\7"+
		"\4\2\2\u0088\u0089\5\2\2\2\u0089\u00a2\7\5\2\2\u008a\u008b\7\7\2\2\u008b"+
		"\u00a1\5\f\7\2\u008c\u008d\7\r\2\2\u008d\u00a1\5\n\6\2\u008e\u008f\7\b"+
		"\2\2\u008f\u0090\7\4\2\2\u0090\u0095\5\4\3\2\u0091\u0092\7\3\2\2\u0092"+
		"\u0094\5\4\3\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0099\7\5\2\2\u0099\u00a1\3\2\2\2\u009a\u009b\7\t\2\2\u009b\u009c\7\n"+
		"\2\2\u009c\u00a1\5\6\4\2\u009d\u009e\7\t\2\2\u009e\u009f\7\13\2\2\u009f"+
		"\u00a1\5\b\5\2\u00a0\u008a\3\2\2\2\u00a0\u008c\3\2\2\2\u00a0\u008e\3\2"+
		"\2\2\u00a0\u009a\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a5\u00a7\7\f\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u00aa\5\16\b\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa+\3\2\2\2\u00ab\u00ac\7\23\2\2\u00ac\u00ad\7\24\2\2\u00ad"+
		"\u00ae\5\20\t\2\u00ae\u00af\7\25\2\2\u00af\u00b0\5\22\n\2\u00b0-\3\2\2"+
		"\2\u00b1\u00b2\7&\2\2\u00b2\u00b7\5$\23\2\u00b3\u00b4\7\3\2\2\u00b4\u00b6"+
		"\5$\23\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8/\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7!\2\2\u00bb"+
		"\u00bc\7\"\2\2\u00bc\u00bd\7#\2\2\u00bd\u00be\7\4\2\2\u00be\u00bf\5\2"+
		"\2\2\u00bf\u00c0\7\5\2\2\u00c0\61\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2\u00c3"+
		"\5\20\t\2\u00c3\u00c4\7%\2\2\u00c4\u00c5\5&\24\2\u00c5\63\3\2\2\2\17\67"+
		"Et}\177\u0081\u0083\u0095\u00a0\u00a2\u00a6\u00a9\u00b7";
=======
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\5\2<\n\2\3\3\7\3?\n\3\f\3\16"+
		"\3B\13\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nb\n\n"+
		"\f\n\16\ne\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\no\n\n\f\n\16\nr\13"+
		"\n\3\n\5\nu\n\n\3\n\5\nx\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00a7\n\27\f\27\16\27\u00aa\13"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\6\27\u00b5\n\27\r\27"+
		"\16\27\u00b6\3\27\3\27\7\27\u00bb\n\27\f\27\16\27\u00be\13\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3@\2\35\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\4\4\2..\60\60\3\2\21\22\2\u00d2"+
		"\2;\3\2\2\2\4@\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2\nG\3\2\2\2\fN\3\2\2\2\16"+
		"P\3\2\2\2\20R\3\2\2\2\22T\3\2\2\2\24y\3\2\2\2\26{\3\2\2\2\30}\3\2\2\2"+
		"\32\u0083\3\2\2\2\34\u0085\3\2\2\2\36\u0087\3\2\2\2 \u0089\3\2\2\2\"\u008b"+
		"\3\2\2\2$\u008d\3\2\2\2&\u008f\3\2\2\2(\u0091\3\2\2\2*\u0093\3\2\2\2,"+
		"\u0095\3\2\2\2.\u00bf\3\2\2\2\60\u00c1\3\2\2\2\62\u00c6\3\2\2\2\64\u00cf"+
		"\3\2\2\2\66\u00d1\3\2\2\28<\5,\27\29<\5\30\r\2:<\5\22\n\2;8\3\2\2\2;9"+
		"\3\2\2\2;:\3\2\2\2<\3\3\2\2\2=?\13\2\2\2>=\3\2\2\2?B\3\2\2\2@A\3\2\2\2"+
		"@>\3\2\2\2A\5\3\2\2\2B@\3\2\2\2CD\t\2\2\2D\7\3\2\2\2EF\7.\2\2F\t\3\2\2"+
		"\2GH\7.\2\2H\13\3\2\2\2IO\7\16\2\2JK\7\17\2\2KO\7\r\2\2LM\7\17\2\2MO\7"+
		"\20\2\2NI\3\2\2\2NJ\3\2\2\2NL\3\2\2\2O\r\3\2\2\2PQ\t\3\2\2Q\17\3\2\2\2"+
		"RS\t\2\2\2S\21\3\2\2\2TU\7\6\2\2UV\7\3\2\2VW\5\4\3\2Wp\7\4\2\2XY\7\7\2"+
		"\2Yo\5\16\b\2Z[\7\r\2\2[o\5\f\7\2\\]\7\b\2\2]^\7\3\2\2^c\5\6\4\2_`\7\5"+
		"\2\2`b\5\6\4\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2"+
		"\2\2fg\7\4\2\2go\3\2\2\2hi\7\t\2\2ij\7\n\2\2jo\5\b\5\2kl\7\t\2\2lm\7\13"+
		"\2\2mo\5\n\6\2nX\3\2\2\2nZ\3\2\2\2n\\\3\2\2\2nh\3\2\2\2nk\3\2\2\2or\3"+
		"\2\2\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\7\f\2\2ts\3\2\2\2tu\3"+
		"\2\2\2uw\3\2\2\2vx\5\20\t\2wv\3\2\2\2wx\3\2\2\2x\23\3\2\2\2yz\t\2\2\2"+
		"z\25\3\2\2\2{|\7\60\2\2|\27\3\2\2\2}~\7\23\2\2~\177\7\24\2\2\177\u0080"+
		"\5\24\13\2\u0080\u0081\7\25\2\2\u0081\u0082\5\26\f\2\u0082\31\3\2\2\2"+
		"\u0083\u0084\7\60\2\2\u0084\33\3\2\2\2\u0085\u0086\t\2\2\2\u0086\35\3"+
		"\2\2\2\u0087\u0088\7\60\2\2\u0088\37\3\2\2\2\u0089\u008a\7\60\2\2\u008a"+
		"!\3\2\2\2\u008b\u008c\7\60\2\2\u008c#\3\2\2\2\u008d\u008e\7\60\2\2\u008e"+
		"%\3\2\2\2\u008f\u0090\7/\2\2\u0090\'\3\2\2\2\u0091\u0092\7/\2\2\u0092"+
		")\3\2\2\2\u0093\u0094\t\3\2\2\u0094+\3\2\2\2\u0095\u0096\7\26\2\2\u0096"+
		"\u0097\7\27\2\2\u0097\u00bc\5\32\16\2\u0098\u0099\7\30\2\2\u0099\u00bb"+
		"\5\34\17\2\u009a\u009b\7\31\2\2\u009b\u00bb\5\36\20\2\u009c\u009d\7\32"+
		"\2\2\u009d\u00bb\5 \21\2\u009e\u009f\7\33\2\2\u009f\u00bb\5\"\22\2\u00a0"+
		"\u00a1\7\34\2\2\u00a1\u00a2\7\35\2\2\u00a2\u00a3\7\3\2\2\u00a3\u00a8\5"+
		"$\23\2\u00a4\u00a5\7\5\2\2\u00a5\u00a7\5$\23\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7\4\2\2\u00ac\u00bb\3\2\2\2\u00ad"+
		"\u00ae\7\36\2\2\u00ae\u00af\7\37\2\2\u00af\u00b4\7 \2\2\u00b0\u00b1\7"+
		"!\2\2\u00b1\u00b5\5&\24\2\u00b2\u00b3\7\"\2\2\u00b3\u00b5\5(\25\2\u00b4"+
		"\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bb\3\2\2\2\u00b8\u00b9\7#\2\2\u00b9"+
		"\u00bb\5*\26\2\u00ba\u0098\3\2\2\2\u00ba\u009a\3\2\2\2\u00ba\u009c\3\2"+
		"\2\2\u00ba\u009e\3\2\2\2\u00ba\u00a0\3\2\2\2\u00ba\u00ad\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd-\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\60\2\2\u00c0/\3"+
		"\2\2\2\u00c1\u00c2\7+\2\2\u00c2\u00c3\7,\2\2\u00c3\u00c4\7-\2\2\u00c4"+
		"\u00c5\5.\30\2\u00c5\61\3\2\2\2\u00c6\u00c7\7$\2\2\u00c7\u00c8\7%\2\2"+
		"\u00c8\u00c9\7&\2\2\u00c9\u00ca\7\'\2\2\u00ca\u00cb\7(\2\2\u00cb\u00cc"+
		"\7\3\2\2\u00cc\u00cd\5\4\3\2\u00cd\u00ce\7\4\2\2\u00ce\63\3\2\2\2\u00cf"+
		"\u00d0\7\60\2\2\u00d0\65\3\2\2\2\u00d1\u00d2\7)\2\2\u00d2\u00d3\5\24\13"+
		"\2\u00d3\u00d4\7*\2\2\u00d4\u00d5\5\64\33\2\u00d5\67\3\2\2\2\17;@Ncnp"+
		"tw\u00a8\u00b4\u00b6\u00ba\u00bc";
>>>>>>> refs/remotes/origin/master
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}