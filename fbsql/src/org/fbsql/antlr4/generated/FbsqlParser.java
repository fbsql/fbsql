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
		T__0=1, T__1=2, T__2=3, K_EXPOSE=4, K_PREFETCH=5, K_ROLES=6, K_TRIGGER=7, 
		K_BEFORE=8, K_AFTER=9, K_AS=10, K_COMPRESSION=11, K_NONE=12, K_BEST=13, 
		K_SPEED=14, K_ON=15, K_OFF=16, K_DECLARE=17, K_PROCEDURE=18, K_FOR=19, 
		K_CONNECT=20, K_TO=21, K_USER=22, K_PASSWORD=23, K_PROPERTIES=24, K_DRIVER=25, 
		K_JAR=26, K_FILES=27, K_CONNECTION=28, K_POOL=29, K_SIZE=30, K_MIN=31, 
		K_MAX=32, K_DEBUG=33, K_SET=34, K_ALLOW=35, K_LOGIN=36, K_IF=37, K_EXISTS=38, 
		K_SCHEDULE=39, K_AT=40, K_INCLUDE=41, K_SCRIPT=42, K_FILE=43, IDENTIFIER=44, 
		NUMERIC_LITERAL=45, STRING_LITERAL=46, SINGLE_LINE_COMMENT=47, MULTILINE_COMMENT=48, 
		SPACES=49, UNEXPECTED_CHAR=50;
	public static final int
		RULE_fbsql_stmt = 0, RULE_native_sql = 1, RULE_role_name = 2, RULE_trigger_before_procedure_name = 3, 
		RULE_trigger_after_procedure_name = 4, RULE_compression = 5, RULE_prefetch = 6, 
		RULE_statement_alias = 7, RULE_expose_stmt = 8, RULE_procedure_name = 9, 
		RULE_java_method_name = 10, RULE_declare_procedure_stmt = 11, RULE_jdbc_url = 12, 
		RULE_jdbc_user = 13, RULE_jdbc_password = 14, RULE_jdbc_properties = 15, 
		RULE_jdbc_driver = 16, RULE_jdbc_driver_jar = 17, RULE_connection_pool_size_min = 18, 
		RULE_connection_pool_size_max = 19, RULE_debug = 20, RULE_connect_to_stmt = 21, 
		RULE_file = 22, RULE_include_script_file_stmt = 23, RULE_set_allow_login_if_exists = 24, 
		RULE_cron_expression = 25, RULE_schedule_stmt = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"fbsql_stmt", "native_sql", "role_name", "trigger_before_procedure_name", 
			"trigger_after_procedure_name", "compression", "prefetch", "statement_alias", 
			"expose_stmt", "procedure_name", "java_method_name", "declare_procedure_stmt", 
			"jdbc_url", "jdbc_user", "jdbc_password", "jdbc_properties", "jdbc_driver", 
			"jdbc_driver_jar", "connection_pool_size_min", "connection_pool_size_max", 
			"debug", "connect_to_stmt", "file", "include_script_file_stmt", "set_allow_login_if_exists", 
			"cron_expression", "schedule_stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "K_EXPOSE", "K_PREFETCH", "K_ROLES", "K_TRIGGER", 
			"K_BEFORE", "K_AFTER", "K_AS", "K_COMPRESSION", "K_NONE", "K_BEST", "K_SPEED", 
			"K_ON", "K_OFF", "K_DECLARE", "K_PROCEDURE", "K_FOR", "K_CONNECT", "K_TO", 
			"K_USER", "K_PASSWORD", "K_PROPERTIES", "K_DRIVER", "K_JAR", "K_FILES", 
			"K_CONNECTION", "K_POOL", "K_SIZE", "K_MIN", "K_MAX", "K_DEBUG", "K_SET", 
			"K_ALLOW", "K_LOGIN", "K_IF", "K_EXISTS", "K_SCHEDULE", "K_AT", "K_INCLUDE", 
			"K_SCRIPT", "K_FILE", "IDENTIFIER", "NUMERIC_LITERAL", "STRING_LITERAL", 
			"SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"
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
			case K_CONNECT:
				{
				setState(54);
				connect_to_stmt();
				}
				break;
			case K_DECLARE:
				{
				setState(55);
				declare_procedure_stmt();
				}
				break;
			case K_EXPOSE:
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
		enterRule(_localctx, 2, RULE_native_sql);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(59);
					matchWildcard();
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		enterRule(_localctx, 4, RULE_role_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
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
		enterRule(_localctx, 6, RULE_trigger_before_procedure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
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
		enterRule(_localctx, 8, RULE_trigger_after_procedure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
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

	public static class CompressionContext extends ParserRuleContext {
		public TerminalNode K_NONE() { return getToken(FbsqlParser.K_NONE, 0); }
		public TerminalNode K_BEST() { return getToken(FbsqlParser.K_BEST, 0); }
		public TerminalNode K_COMPRESSION() { return getToken(FbsqlParser.K_COMPRESSION, 0); }
		public TerminalNode K_SPEED() { return getToken(FbsqlParser.K_SPEED, 0); }
		public CompressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterCompression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitCompression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitCompression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompressionContext compression() throws RecognitionException {
		CompressionContext _localctx = new CompressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_compression);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(K_NONE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(K_BEST);
				setState(73);
				match(K_COMPRESSION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(K_BEST);
				setState(75);
				match(K_SPEED);
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

	public static class PrefetchContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(FbsqlParser.K_ON, 0); }
		public TerminalNode K_OFF() { return getToken(FbsqlParser.K_OFF, 0); }
		public PrefetchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefetch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterPrefetch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitPrefetch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitPrefetch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefetchContext prefetch() throws RecognitionException {
		PrefetchContext _localctx = new PrefetchContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prefetch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !(_la==K_ON || _la==K_OFF) ) {
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
		enterRule(_localctx, 14, RULE_statement_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
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

	public static class Expose_stmtContext extends ParserRuleContext {
		public TerminalNode K_EXPOSE() { return getToken(FbsqlParser.K_EXPOSE, 0); }
		public Native_sqlContext native_sql() {
			return getRuleContext(Native_sqlContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(FbsqlParser.K_AS, 0); }
		public Statement_aliasContext statement_alias() {
			return getRuleContext(Statement_aliasContext.class,0);
		}
		public List<TerminalNode> K_PREFETCH() { return getTokens(FbsqlParser.K_PREFETCH); }
		public TerminalNode K_PREFETCH(int i) {
			return getToken(FbsqlParser.K_PREFETCH, i);
		}
		public List<PrefetchContext> prefetch() {
			return getRuleContexts(PrefetchContext.class);
		}
		public PrefetchContext prefetch(int i) {
			return getRuleContext(PrefetchContext.class,i);
		}
		public List<TerminalNode> K_COMPRESSION() { return getTokens(FbsqlParser.K_COMPRESSION); }
		public TerminalNode K_COMPRESSION(int i) {
			return getToken(FbsqlParser.K_COMPRESSION, i);
		}
		public List<CompressionContext> compression() {
			return getRuleContexts(CompressionContext.class);
		}
		public CompressionContext compression(int i) {
			return getRuleContext(CompressionContext.class,i);
		}
		public List<TerminalNode> K_ROLES() { return getTokens(FbsqlParser.K_ROLES); }
		public TerminalNode K_ROLES(int i) {
			return getToken(FbsqlParser.K_ROLES, i);
		}
		public List<Role_nameContext> role_name() {
			return getRuleContexts(Role_nameContext.class);
		}
		public Role_nameContext role_name(int i) {
			return getRuleContext(Role_nameContext.class,i);
		}
		public List<TerminalNode> K_TRIGGER() { return getTokens(FbsqlParser.K_TRIGGER); }
		public TerminalNode K_TRIGGER(int i) {
			return getToken(FbsqlParser.K_TRIGGER, i);
		}
		public List<TerminalNode> K_BEFORE() { return getTokens(FbsqlParser.K_BEFORE); }
		public TerminalNode K_BEFORE(int i) {
			return getToken(FbsqlParser.K_BEFORE, i);
		}
		public List<Trigger_before_procedure_nameContext> trigger_before_procedure_name() {
			return getRuleContexts(Trigger_before_procedure_nameContext.class);
		}
		public Trigger_before_procedure_nameContext trigger_before_procedure_name(int i) {
			return getRuleContext(Trigger_before_procedure_nameContext.class,i);
		}
		public List<TerminalNode> K_AFTER() { return getTokens(FbsqlParser.K_AFTER); }
		public TerminalNode K_AFTER(int i) {
			return getToken(FbsqlParser.K_AFTER, i);
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
			match(K_EXPOSE);
			setState(83);
			match(T__0);
			setState(84);
			native_sql();
			setState(85);
			match(T__1);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_PREFETCH) | (1L << K_ROLES) | (1L << K_TRIGGER) | (1L << K_COMPRESSION))) != 0)) {
				{
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					{
					setState(86);
					match(K_PREFETCH);
					setState(87);
					prefetch();
					}
					}
					break;
				case 2:
					{
					{
					setState(88);
					match(K_COMPRESSION);
					setState(89);
					compression();
					}
					}
					break;
				case 3:
					{
					{
					setState(90);
					match(K_ROLES);
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
					match(K_TRIGGER);
					setState(103);
					match(K_BEFORE);
					setState(104);
					trigger_before_procedure_name();
					}
					}
					break;
				case 5:
					{
					{
					setState(105);
					match(K_TRIGGER);
					setState(106);
					match(K_AFTER);
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
			if (_la==K_AS) {
				{
				setState(113);
				match(K_AS);
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
		enterRule(_localctx, 18, RULE_procedure_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
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
		enterRule(_localctx, 20, RULE_java_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
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

	public static class Declare_procedure_stmtContext extends ParserRuleContext {
		public TerminalNode K_DECLARE() { return getToken(FbsqlParser.K_DECLARE, 0); }
		public TerminalNode K_PROCEDURE() { return getToken(FbsqlParser.K_PROCEDURE, 0); }
		public Procedure_nameContext procedure_name() {
			return getRuleContext(Procedure_nameContext.class,0);
		}
		public TerminalNode K_FOR() { return getToken(FbsqlParser.K_FOR, 0); }
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
			match(K_DECLARE);
			setState(124);
			match(K_PROCEDURE);
			setState(125);
			procedure_name();
			setState(126);
			match(K_FOR);
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
		enterRule(_localctx, 24, RULE_jdbc_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
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

	public static class Jdbc_userContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_userContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_user; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_user(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_user(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_user(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_userContext jdbc_user() throws RecognitionException {
		Jdbc_userContext _localctx = new Jdbc_userContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jdbc_user);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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

	public static class Jdbc_passwordContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_passwordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_password; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_password(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_password(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_password(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_passwordContext jdbc_password() throws RecognitionException {
		Jdbc_passwordContext _localctx = new Jdbc_passwordContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jdbc_password);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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

	public static class Jdbc_propertiesContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_propertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_properties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_properties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_properties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_propertiesContext jdbc_properties() throws RecognitionException {
		Jdbc_propertiesContext _localctx = new Jdbc_propertiesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jdbc_properties);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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

	public static class Jdbc_driverContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_driverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_driver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_driver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_driver(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_driver(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_driverContext jdbc_driver() throws RecognitionException {
		Jdbc_driverContext _localctx = new Jdbc_driverContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jdbc_driver);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
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

	public static class Jdbc_driver_jarContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Jdbc_driver_jarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jdbc_driver_jar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJdbc_driver_jar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJdbc_driver_jar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJdbc_driver_jar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jdbc_driver_jarContext jdbc_driver_jar() throws RecognitionException {
		Jdbc_driver_jarContext _localctx = new Jdbc_driver_jarContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_jdbc_driver_jar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
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
		enterRule(_localctx, 36, RULE_connection_pool_size_min);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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
		enterRule(_localctx, 38, RULE_connection_pool_size_max);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
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

	public static class DebugContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(FbsqlParser.K_ON, 0); }
		public TerminalNode K_OFF() { return getToken(FbsqlParser.K_OFF, 0); }
		public DebugContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debug; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterDebug(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitDebug(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitDebug(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DebugContext debug() throws RecognitionException {
		DebugContext _localctx = new DebugContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_debug);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !(_la==K_ON || _la==K_OFF) ) {
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
		public TerminalNode K_CONNECT() { return getToken(FbsqlParser.K_CONNECT, 0); }
		public TerminalNode K_TO() { return getToken(FbsqlParser.K_TO, 0); }
		public Jdbc_urlContext jdbc_url() {
			return getRuleContext(Jdbc_urlContext.class,0);
		}
		public List<TerminalNode> K_USER() { return getTokens(FbsqlParser.K_USER); }
		public TerminalNode K_USER(int i) {
			return getToken(FbsqlParser.K_USER, i);
		}
		public List<Jdbc_userContext> jdbc_user() {
			return getRuleContexts(Jdbc_userContext.class);
		}
		public Jdbc_userContext jdbc_user(int i) {
			return getRuleContext(Jdbc_userContext.class,i);
		}
		public List<TerminalNode> K_PASSWORD() { return getTokens(FbsqlParser.K_PASSWORD); }
		public TerminalNode K_PASSWORD(int i) {
			return getToken(FbsqlParser.K_PASSWORD, i);
		}
		public List<Jdbc_passwordContext> jdbc_password() {
			return getRuleContexts(Jdbc_passwordContext.class);
		}
		public Jdbc_passwordContext jdbc_password(int i) {
			return getRuleContext(Jdbc_passwordContext.class,i);
		}
		public List<TerminalNode> K_PROPERTIES() { return getTokens(FbsqlParser.K_PROPERTIES); }
		public TerminalNode K_PROPERTIES(int i) {
			return getToken(FbsqlParser.K_PROPERTIES, i);
		}
		public List<Jdbc_propertiesContext> jdbc_properties() {
			return getRuleContexts(Jdbc_propertiesContext.class);
		}
		public Jdbc_propertiesContext jdbc_properties(int i) {
			return getRuleContext(Jdbc_propertiesContext.class,i);
		}
		public List<TerminalNode> K_DRIVER() { return getTokens(FbsqlParser.K_DRIVER); }
		public TerminalNode K_DRIVER(int i) {
			return getToken(FbsqlParser.K_DRIVER, i);
		}
		public List<Jdbc_driverContext> jdbc_driver() {
			return getRuleContexts(Jdbc_driverContext.class);
		}
		public Jdbc_driverContext jdbc_driver(int i) {
			return getRuleContext(Jdbc_driverContext.class,i);
		}
		public List<TerminalNode> K_JAR() { return getTokens(FbsqlParser.K_JAR); }
		public TerminalNode K_JAR(int i) {
			return getToken(FbsqlParser.K_JAR, i);
		}
		public List<TerminalNode> K_FILES() { return getTokens(FbsqlParser.K_FILES); }
		public TerminalNode K_FILES(int i) {
			return getToken(FbsqlParser.K_FILES, i);
		}
		public List<Jdbc_driver_jarContext> jdbc_driver_jar() {
			return getRuleContexts(Jdbc_driver_jarContext.class);
		}
		public Jdbc_driver_jarContext jdbc_driver_jar(int i) {
			return getRuleContext(Jdbc_driver_jarContext.class,i);
		}
		public List<TerminalNode> K_CONNECTION() { return getTokens(FbsqlParser.K_CONNECTION); }
		public TerminalNode K_CONNECTION(int i) {
			return getToken(FbsqlParser.K_CONNECTION, i);
		}
		public List<TerminalNode> K_POOL() { return getTokens(FbsqlParser.K_POOL); }
		public TerminalNode K_POOL(int i) {
			return getToken(FbsqlParser.K_POOL, i);
		}
		public List<TerminalNode> K_SIZE() { return getTokens(FbsqlParser.K_SIZE); }
		public TerminalNode K_SIZE(int i) {
			return getToken(FbsqlParser.K_SIZE, i);
		}
		public List<TerminalNode> K_MIN() { return getTokens(FbsqlParser.K_MIN); }
		public TerminalNode K_MIN(int i) {
			return getToken(FbsqlParser.K_MIN, i);
		}
		public List<Connection_pool_size_minContext> connection_pool_size_min() {
			return getRuleContexts(Connection_pool_size_minContext.class);
		}
		public Connection_pool_size_minContext connection_pool_size_min(int i) {
			return getRuleContext(Connection_pool_size_minContext.class,i);
		}
		public List<TerminalNode> K_MAX() { return getTokens(FbsqlParser.K_MAX); }
		public TerminalNode K_MAX(int i) {
			return getToken(FbsqlParser.K_MAX, i);
		}
		public List<Connection_pool_size_maxContext> connection_pool_size_max() {
			return getRuleContexts(Connection_pool_size_maxContext.class);
		}
		public Connection_pool_size_maxContext connection_pool_size_max(int i) {
			return getRuleContext(Connection_pool_size_maxContext.class,i);
		}
		public List<TerminalNode> K_DEBUG() { return getTokens(FbsqlParser.K_DEBUG); }
		public TerminalNode K_DEBUG(int i) {
			return getToken(FbsqlParser.K_DEBUG, i);
		}
		public List<DebugContext> debug() {
			return getRuleContexts(DebugContext.class);
		}
		public DebugContext debug(int i) {
			return getRuleContext(DebugContext.class,i);
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
			match(K_CONNECT);
			setState(148);
			match(K_TO);
			setState(149);
			jdbc_url();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_USER) | (1L << K_PASSWORD) | (1L << K_PROPERTIES) | (1L << K_DRIVER) | (1L << K_JAR) | (1L << K_CONNECTION) | (1L << K_DEBUG))) != 0)) {
				{
				setState(183);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					{
					setState(150);
					match(K_USER);
					setState(151);
					jdbc_user();
					}
					}
					break;
				case 2:
					{
					{
					setState(152);
					match(K_PASSWORD);
					setState(153);
					jdbc_password();
					}
					}
					break;
				case 3:
					{
					{
					setState(154);
					match(K_PROPERTIES);
					setState(155);
					jdbc_properties();
					}
					}
					break;
				case 4:
					{
					{
					setState(156);
					match(K_DRIVER);
					setState(157);
					jdbc_driver();
					}
					}
					break;
				case 5:
					{
					{
					setState(158);
					match(K_JAR);
					setState(159);
					match(K_FILES);
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
				case 6:
					{
					{
					setState(171);
					match(K_CONNECTION);
					setState(172);
					match(K_POOL);
					setState(173);
					match(K_SIZE);
					setState(174);
					match(K_MIN);
					setState(175);
					connection_pool_size_min();
					}
					}
					break;
				case 7:
					{
					{
					setState(176);
					match(K_CONNECTION);
					setState(177);
					match(K_POOL);
					setState(178);
					match(K_SIZE);
					setState(179);
					match(K_MAX);
					setState(180);
					connection_pool_size_max();
					}
					}
					break;
				case 8:
					{
					{
					setState(181);
					match(K_DEBUG);
					setState(182);
					debug();
					}
					}
					break;
				}
				}
				setState(187);
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
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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

	public static class Include_script_file_stmtContext extends ParserRuleContext {
		public TerminalNode K_INCLUDE() { return getToken(FbsqlParser.K_INCLUDE, 0); }
		public TerminalNode K_SCRIPT() { return getToken(FbsqlParser.K_SCRIPT, 0); }
		public TerminalNode K_FILE() { return getToken(FbsqlParser.K_FILE, 0); }
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
			setState(190);
			match(K_INCLUDE);
			setState(191);
			match(K_SCRIPT);
			setState(192);
			match(K_FILE);
			setState(193);
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
		public TerminalNode K_SET() { return getToken(FbsqlParser.K_SET, 0); }
		public TerminalNode K_ALLOW() { return getToken(FbsqlParser.K_ALLOW, 0); }
		public TerminalNode K_LOGIN() { return getToken(FbsqlParser.K_LOGIN, 0); }
		public TerminalNode K_IF() { return getToken(FbsqlParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(FbsqlParser.K_EXISTS, 0); }
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
			setState(195);
			match(K_SET);
			setState(196);
			match(K_ALLOW);
			setState(197);
			match(K_LOGIN);
			setState(198);
			match(K_IF);
			setState(199);
			match(K_EXISTS);
			setState(200);
			match(T__0);
			setState(201);
			native_sql();
			setState(202);
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
		enterRule(_localctx, 50, RULE_cron_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
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

	public static class Schedule_stmtContext extends ParserRuleContext {
		public TerminalNode K_SCHEDULE() { return getToken(FbsqlParser.K_SCHEDULE, 0); }
		public Procedure_nameContext procedure_name() {
			return getRuleContext(Procedure_nameContext.class,0);
		}
		public TerminalNode K_AT() { return getToken(FbsqlParser.K_AT, 0); }
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
		enterRule(_localctx, 52, RULE_schedule_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(K_SCHEDULE);
			setState(207);
			procedure_name();
			setState(208);
			match(K_AT);
			setState(209);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00d6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\5\2<\n\2\3\3\7\3?\n\3\f\3\16"+
		"\3B\13\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nb\n\n"+
		"\f\n\16\ne\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\no\n\n\f\n\16\nr\13"+
		"\n\3\n\5\nu\n\n\3\n\5\nx\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00a7\n\27\f\27\16\27\u00aa\13"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\7\27\u00ba\n\27\f\27\16\27\u00bd\13\27\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3@\2\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\66\2\4\4\2..\60\60\3\2\21\22\2\u00d0\2;\3\2\2\2\4@"+
		"\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2\nG\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20R\3"+
		"\2\2\2\22T\3\2\2\2\24y\3\2\2\2\26{\3\2\2\2\30}\3\2\2\2\32\u0083\3\2\2"+
		"\2\34\u0085\3\2\2\2\36\u0087\3\2\2\2 \u0089\3\2\2\2\"\u008b\3\2\2\2$\u008d"+
		"\3\2\2\2&\u008f\3\2\2\2(\u0091\3\2\2\2*\u0093\3\2\2\2,\u0095\3\2\2\2."+
		"\u00be\3\2\2\2\60\u00c0\3\2\2\2\62\u00c5\3\2\2\2\64\u00ce\3\2\2\2\66\u00d0"+
		"\3\2\2\28<\5,\27\29<\5\30\r\2:<\5\22\n\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2"+
		"<\3\3\2\2\2=?\13\2\2\2>=\3\2\2\2?B\3\2\2\2@A\3\2\2\2@>\3\2\2\2A\5\3\2"+
		"\2\2B@\3\2\2\2CD\t\2\2\2D\7\3\2\2\2EF\7.\2\2F\t\3\2\2\2GH\7.\2\2H\13\3"+
		"\2\2\2IO\7\16\2\2JK\7\17\2\2KO\7\r\2\2LM\7\17\2\2MO\7\20\2\2NI\3\2\2\2"+
		"NJ\3\2\2\2NL\3\2\2\2O\r\3\2\2\2PQ\t\3\2\2Q\17\3\2\2\2RS\t\2\2\2S\21\3"+
		"\2\2\2TU\7\6\2\2UV\7\3\2\2VW\5\4\3\2Wp\7\4\2\2XY\7\7\2\2Yo\5\16\b\2Z["+
		"\7\r\2\2[o\5\f\7\2\\]\7\b\2\2]^\7\3\2\2^c\5\6\4\2_`\7\5\2\2`b\5\6\4\2"+
		"a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\4\2\2"+
		"go\3\2\2\2hi\7\t\2\2ij\7\n\2\2jo\5\b\5\2kl\7\t\2\2lm\7\13\2\2mo\5\n\6"+
		"\2nX\3\2\2\2nZ\3\2\2\2n\\\3\2\2\2nh\3\2\2\2nk\3\2\2\2or\3\2\2\2pn\3\2"+
		"\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\7\f\2\2ts\3\2\2\2tu\3\2\2\2uw\3\2"+
		"\2\2vx\5\20\t\2wv\3\2\2\2wx\3\2\2\2x\23\3\2\2\2yz\t\2\2\2z\25\3\2\2\2"+
		"{|\7\60\2\2|\27\3\2\2\2}~\7\23\2\2~\177\7\24\2\2\177\u0080\5\24\13\2\u0080"+
		"\u0081\7\25\2\2\u0081\u0082\5\26\f\2\u0082\31\3\2\2\2\u0083\u0084\7\60"+
		"\2\2\u0084\33\3\2\2\2\u0085\u0086\t\2\2\2\u0086\35\3\2\2\2\u0087\u0088"+
		"\7\60\2\2\u0088\37\3\2\2\2\u0089\u008a\7\60\2\2\u008a!\3\2\2\2\u008b\u008c"+
		"\7\60\2\2\u008c#\3\2\2\2\u008d\u008e\7\60\2\2\u008e%\3\2\2\2\u008f\u0090"+
		"\7/\2\2\u0090\'\3\2\2\2\u0091\u0092\7/\2\2\u0092)\3\2\2\2\u0093\u0094"+
		"\t\3\2\2\u0094+\3\2\2\2\u0095\u0096\7\26\2\2\u0096\u0097\7\27\2\2\u0097"+
		"\u00bb\5\32\16\2\u0098\u0099\7\30\2\2\u0099\u00ba\5\34\17\2\u009a\u009b"+
		"\7\31\2\2\u009b\u00ba\5\36\20\2\u009c\u009d\7\32\2\2\u009d\u00ba\5 \21"+
		"\2\u009e\u009f\7\33\2\2\u009f\u00ba\5\"\22\2\u00a0\u00a1\7\34\2\2\u00a1"+
		"\u00a2\7\35\2\2\u00a2\u00a3\7\3\2\2\u00a3\u00a8\5$\23\2\u00a4\u00a5\7"+
		"\5\2\2\u00a5\u00a7\5$\23\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ac\7\4\2\2\u00ac\u00ba\3\2\2\2\u00ad\u00ae\7\36\2\2\u00ae"+
		"\u00af\7\37\2\2\u00af\u00b0\7 \2\2\u00b0\u00b1\7!\2\2\u00b1\u00ba\5&\24"+
		"\2\u00b2\u00b3\7\36\2\2\u00b3\u00b4\7\37\2\2\u00b4\u00b5\7 \2\2\u00b5"+
		"\u00b6\7\"\2\2\u00b6\u00ba\5(\25\2\u00b7\u00b8\7#\2\2\u00b8\u00ba\5*\26"+
		"\2\u00b9\u0098\3\2\2\2\u00b9\u009a\3\2\2\2\u00b9\u009c\3\2\2\2\u00b9\u009e"+
		"\3\2\2\2\u00b9\u00a0\3\2\2\2\u00b9\u00ad\3\2\2\2\u00b9\u00b2\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc-\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\60\2\2\u00bf/\3"+
		"\2\2\2\u00c0\u00c1\7+\2\2\u00c1\u00c2\7,\2\2\u00c2\u00c3\7-\2\2\u00c3"+
		"\u00c4\5.\30\2\u00c4\61\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6\u00c7\7%\2\2"+
		"\u00c7\u00c8\7&\2\2\u00c8\u00c9\7\'\2\2\u00c9\u00ca\7(\2\2\u00ca\u00cb"+
		"\7\3\2\2\u00cb\u00cc\5\4\3\2\u00cc\u00cd\7\4\2\2\u00cd\63\3\2\2\2\u00ce"+
		"\u00cf\7\60\2\2\u00cf\65\3\2\2\2\u00d0\u00d1\7)\2\2\u00d1\u00d2\5\24\13"+
		"\2\u00d2\u00d3\7*\2\2\u00d3\u00d4\5\64\33\2\u00d4\67\3\2\2\2\r;@Ncnpt"+
		"w\u00a8\u00b9\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}