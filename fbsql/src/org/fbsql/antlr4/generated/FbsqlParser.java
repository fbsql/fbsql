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
		T__0=1, T__1=2, T__2=3, T__3=4, STATIC=5, ROLES=6, TRIGGER=7, BEFORE=8, 
		AFTER=9, AS=10, NO=11, COMPRESSION=12, BEST=13, SPEED=14, DECLARE=15, 
		PROCEDURE=16, TYPE=17, JAVA=18, JS=19, EXEC=20, URL=21, OPTIONS=22, FILE=23, 
		STATEMENT=24, CONNECT=25, TO=26, USER=27, PASSWORD=28, PROPERTIES=29, 
		DRIVER=30, LIB=31, CONNECTION=32, POOL=33, SIZE=34, MIN=35, MAX=36, UNDECLARED=37, 
		STATEMENTS=38, INCOMING=39, CONNECTIONS=40, ALLOW=41, REJECT=42, IF=43, 
		EXISTS=44, SWITCH=45, SCHEDULE=46, AT=47, INCLUDE=48, NULL=49, IDENTIFIER=50, 
		NUMERIC_LITERAL=51, STRING_LITERAL=52, SINGLE_LINE_COMMENT=53, MULTILINE_COMMENT=54, 
		SPACES=55, UNEXPECTED_CHAR=56;
	public static final int
		RULE_native_sql = 0, RULE_parameter = 1, RULE_procedure = 2, RULE_role_name = 3, 
		RULE_trigger_before_procedure_name = 4, RULE_trigger_after_procedure_name = 5, 
		RULE_compression_level = 6, RULE_connection_alias = 7, RULE_statement_alias = 8, 
		RULE_procedure_name = 9, RULE_json = 10, RULE_jdbc_url = 11, RULE_user = 12, 
		RULE_password = 13, RULE_jdbc_connection_properties = 14, RULE_jdbc_driver_class_name = 15, 
		RULE_jar_file = 16, RULE_connection_pool_size_min = 17, RULE_connection_pool_size_max = 18, 
		RULE_sql_script_file = 19, RULE_json_file = 20, RULE_cron_expression = 21, 
		RULE_connect_to_stmt = 22, RULE_switch_to_stmt = 23, RULE_declare_statement_stmt = 24, 
		RULE_declare_procedure_stmt = 25, RULE_include_script_file_stmt = 26, 
		RULE_schedule_stmt = 27, RULE_native_stmt = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"native_sql", "parameter", "procedure", "role_name", "trigger_before_procedure_name", 
			"trigger_after_procedure_name", "compression_level", "connection_alias", 
			"statement_alias", "procedure_name", "json", "jdbc_url", "user", "password", 
			"jdbc_connection_properties", "jdbc_driver_class_name", "jar_file", "connection_pool_size_min", 
			"connection_pool_size_max", "sql_script_file", "json_file", "cron_expression", 
			"connect_to_stmt", "switch_to_stmt", "declare_statement_stmt", "declare_procedure_stmt", 
			"include_script_file_stmt", "schedule_stmt", "native_stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'('", "','", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "STATIC", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "NO", "COMPRESSION", "BEST", "SPEED", "DECLARE", "PROCEDURE", 
			"TYPE", "JAVA", "JS", "EXEC", "URL", "OPTIONS", "FILE", "STATEMENT", 
			"CONNECT", "TO", "USER", "PASSWORD", "PROPERTIES", "DRIVER", "LIB", "CONNECTION", 
			"POOL", "SIZE", "MIN", "MAX", "UNDECLARED", "STATEMENTS", "INCOMING", 
			"CONNECTIONS", "ALLOW", "REJECT", "IF", "EXISTS", "SWITCH", "SCHEDULE", 
			"AT", "INCLUDE", "NULL", "IDENTIFIER", "NUMERIC_LITERAL", "STRING_LITERAL", 
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
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(58);
					matchWildcard();
					}
					} 
				}
				setState(63);
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

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FbsqlParser.IDENTIFIER, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(FbsqlParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public TerminalNode NULL() { return getToken(FbsqlParser.NULL, 0); }
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parameter);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(T__0);
				setState(65);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(NUMERIC_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(STRING_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				match(NULL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				procedure();
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

	public static class ProcedureContext extends ParserRuleContext {
		public Procedure_nameContext procedure_name() {
			return getRuleContext(Procedure_nameContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitProcedure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			procedure_name();
			setState(73);
			match(T__1);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NULL) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(74);
				parameter();
				}
			}

			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(77);
				match(T__2);
				setState(78);
				parameter();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(T__3);
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
		enterRule(_localctx, 6, RULE_role_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
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
		enterRule(_localctx, 8, RULE_trigger_before_procedure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
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
		enterRule(_localctx, 10, RULE_trigger_after_procedure_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		public TerminalNode NO() { return getToken(FbsqlParser.NO, 0); }
		public TerminalNode COMPRESSION() { return getToken(FbsqlParser.COMPRESSION, 0); }
		public TerminalNode BEST() { return getToken(FbsqlParser.BEST, 0); }
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
		enterRule(_localctx, 12, RULE_compression_level);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(NO);
				setState(93);
				match(COMPRESSION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(BEST);
				setState(95);
				match(COMPRESSION);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(BEST);
				setState(97);
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
		enterRule(_localctx, 14, RULE_connection_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
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
		enterRule(_localctx, 16, RULE_statement_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
		enterRule(_localctx, 18, RULE_procedure_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
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

	public static class JsonContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJson(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJson(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_json);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
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
		enterRule(_localctx, 22, RULE_jdbc_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
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
		enterRule(_localctx, 24, RULE_user);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
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
		enterRule(_localctx, 26, RULE_password);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
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
		enterRule(_localctx, 28, RULE_jdbc_connection_properties);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
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
		enterRule(_localctx, 30, RULE_jdbc_driver_class_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
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
		enterRule(_localctx, 32, RULE_jar_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
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
		enterRule(_localctx, 34, RULE_connection_pool_size_min);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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
		enterRule(_localctx, 36, RULE_connection_pool_size_max);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
		enterRule(_localctx, 38, RULE_sql_script_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
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

	public static class Json_fileContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(FbsqlParser.STRING_LITERAL, 0); }
		public Json_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterJson_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitJson_file(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitJson_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Json_fileContext json_file() throws RecognitionException {
		Json_fileContext _localctx = new Json_fileContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_json_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		enterRule(_localctx, 42, RULE_cron_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
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
		public List<TerminalNode> UNDECLARED() { return getTokens(FbsqlParser.UNDECLARED); }
		public TerminalNode UNDECLARED(int i) {
			return getToken(FbsqlParser.UNDECLARED, i);
		}
		public List<TerminalNode> STATEMENTS() { return getTokens(FbsqlParser.STATEMENTS); }
		public TerminalNode STATEMENTS(int i) {
			return getToken(FbsqlParser.STATEMENTS, i);
		}
		public List<TerminalNode> INCOMING() { return getTokens(FbsqlParser.INCOMING); }
		public TerminalNode INCOMING(int i) {
			return getToken(FbsqlParser.INCOMING, i);
		}
		public List<TerminalNode> CONNECTIONS() { return getTokens(FbsqlParser.CONNECTIONS); }
		public TerminalNode CONNECTIONS(int i) {
			return getToken(FbsqlParser.CONNECTIONS, i);
		}
		public List<Connection_aliasContext> connection_alias() {
			return getRuleContexts(Connection_aliasContext.class);
		}
		public Connection_aliasContext connection_alias(int i) {
			return getRuleContext(Connection_aliasContext.class,i);
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
		public List<TerminalNode> AS() { return getTokens(FbsqlParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(FbsqlParser.AS, i);
		}
		public List<TerminalNode> ALLOW() { return getTokens(FbsqlParser.ALLOW); }
		public TerminalNode ALLOW(int i) {
			return getToken(FbsqlParser.ALLOW, i);
		}
		public List<TerminalNode> REJECT() { return getTokens(FbsqlParser.REJECT); }
		public TerminalNode REJECT(int i) {
			return getToken(FbsqlParser.REJECT, i);
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
		enterRule(_localctx, 44, RULE_connect_to_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(CONNECT);
			setState(131);
			match(TO);
			setState(132);
			jdbc_url();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << USER) | (1L << PASSWORD) | (1L << PROPERTIES) | (1L << DRIVER) | (1L << LIB) | (1L << CONNECTION) | (1L << UNDECLARED) | (1L << INCOMING) | (1L << IDENTIFIER) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(186);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case USER:
					{
					{
					setState(133);
					match(USER);
					setState(134);
					user();
					}
					}
					break;
				case PASSWORD:
					{
					{
					setState(135);
					match(PASSWORD);
					setState(136);
					password();
					}
					}
					break;
				case PROPERTIES:
					{
					{
					setState(137);
					match(PROPERTIES);
					setState(138);
					jdbc_connection_properties();
					}
					}
					break;
				case DRIVER:
					{
					{
					setState(139);
					match(DRIVER);
					setState(140);
					jdbc_driver_class_name();
					}
					}
					break;
				case LIB:
					{
					{
					setState(141);
					match(LIB);
					setState(142);
					jar_file();
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(143);
						match(T__2);
						setState(144);
						jar_file();
						}
						}
						setState(149);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case CONNECTION:
					{
					{
					setState(150);
					match(CONNECTION);
					setState(151);
					match(POOL);
					setState(156); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(156);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case MIN:
							{
							{
							setState(152);
							match(MIN);
							setState(153);
							connection_pool_size_min();
							}
							}
							break;
						case MAX:
							{
							{
							setState(154);
							match(MAX);
							setState(155);
							connection_pool_size_max();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(158); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==MIN || _la==MAX );
					}
					}
					break;
				case UNDECLARED:
					{
					{
					setState(160);
					match(UNDECLARED);
					setState(161);
					match(STATEMENTS);
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(162);
						_la = _input.LA(1);
						if ( !(_la==ALLOW || _la==REJECT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(165); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==ALLOW || _la==REJECT );
					}
					}
					break;
				case INCOMING:
					{
					{
					setState(167);
					match(INCOMING);
					setState(168);
					match(CONNECTIONS);
					setState(170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(169);
						_la = _input.LA(1);
						if ( !(_la==ALLOW || _la==REJECT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(172); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==ALLOW || _la==REJECT );
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IF) {
						{
						setState(174);
						match(IF);
						setState(175);
						match(EXISTS);
						setState(176);
						match(T__1);
						setState(177);
						native_sql();
						setState(178);
						match(T__3);
						}
					}

					}
					}
					break;
				case AS:
				case IDENTIFIER:
				case STRING_LITERAL:
					{
					{
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(182);
						match(AS);
						}
					}

					setState(185);
					connection_alias();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(190);
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
		enterRule(_localctx, 46, RULE_switch_to_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(SWITCH);
			setState(192);
			match(TO);
			setState(193);
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
		public List<Statement_aliasContext> statement_alias() {
			return getRuleContexts(Statement_aliasContext.class);
		}
		public Statement_aliasContext statement_alias(int i) {
			return getRuleContext(Statement_aliasContext.class,i);
		}
		public List<TerminalNode> AS() { return getTokens(FbsqlParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(FbsqlParser.AS, i);
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
		enterRule(_localctx, 48, RULE_declare_statement_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(DECLARE);
			setState(196);
			match(STATEMENT);
			setState(197);
			match(T__1);
			setState(198);
			native_sql();
			setState(199);
			match(T__3);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STATIC) | (1L << ROLES) | (1L << TRIGGER) | (1L << AS) | (1L << COMPRESSION) | (1L << IDENTIFIER) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(200);
					match(STATIC);
					}
					break;
				case 2:
					{
					{
					setState(201);
					match(COMPRESSION);
					setState(202);
					compression_level();
					}
					}
					break;
				case 3:
					{
					{
					setState(203);
					match(ROLES);
					setState(204);
					match(T__1);
					setState(205);
					role_name();
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(206);
						match(T__2);
						setState(207);
						role_name();
						}
						}
						setState(212);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(213);
					match(T__3);
					}
					}
					break;
				case 4:
					{
					{
					setState(215);
					match(TRIGGER);
					setState(216);
					match(BEFORE);
					setState(217);
					trigger_before_procedure_name();
					}
					}
					break;
				case 5:
					{
					{
					setState(218);
					match(TRIGGER);
					setState(219);
					match(AFTER);
					setState(220);
					trigger_after_procedure_name();
					}
					}
					break;
				case 6:
					{
					{
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(221);
						match(AS);
						}
					}

					setState(224);
					statement_alias();
					}
					}
					break;
				}
				}
				setState(229);
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

	public static class Declare_procedure_stmtContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(FbsqlParser.DECLARE, 0); }
		public TerminalNode PROCEDURE() { return getToken(FbsqlParser.PROCEDURE, 0); }
		public Procedure_nameContext procedure_name() {
			return getRuleContext(Procedure_nameContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(FbsqlParser.TYPE, 0); }
		public List<TerminalNode> OPTIONS() { return getTokens(FbsqlParser.OPTIONS); }
		public TerminalNode OPTIONS(int i) {
			return getToken(FbsqlParser.OPTIONS, i);
		}
		public List<JsonContext> json() {
			return getRuleContexts(JsonContext.class);
		}
		public JsonContext json(int i) {
			return getRuleContext(JsonContext.class,i);
		}
		public List<TerminalNode> FILE() { return getTokens(FbsqlParser.FILE); }
		public TerminalNode FILE(int i) {
			return getToken(FbsqlParser.FILE, i);
		}
		public List<Json_fileContext> json_file() {
			return getRuleContexts(Json_fileContext.class);
		}
		public Json_fileContext json_file(int i) {
			return getRuleContext(Json_fileContext.class,i);
		}
		public List<TerminalNode> JAVA() { return getTokens(FbsqlParser.JAVA); }
		public TerminalNode JAVA(int i) {
			return getToken(FbsqlParser.JAVA, i);
		}
		public List<TerminalNode> JS() { return getTokens(FbsqlParser.JS); }
		public TerminalNode JS(int i) {
			return getToken(FbsqlParser.JS, i);
		}
		public List<TerminalNode> EXEC() { return getTokens(FbsqlParser.EXEC); }
		public TerminalNode EXEC(int i) {
			return getToken(FbsqlParser.EXEC, i);
		}
		public List<TerminalNode> URL() { return getTokens(FbsqlParser.URL); }
		public TerminalNode URL(int i) {
			return getToken(FbsqlParser.URL, i);
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
		enterRule(_localctx, 50, RULE_declare_procedure_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(DECLARE);
			setState(231);
			match(PROCEDURE);
			setState(232);
			procedure_name();
			setState(233);
			match(TYPE);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JAVA) | (1L << JS) | (1L << EXEC) | (1L << URL))) != 0)) {
				{
				{
				setState(234);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JAVA) | (1L << JS) | (1L << EXEC) | (1L << URL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(245);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(240);
					match(OPTIONS);
					setState(241);
					json();
					}
					break;
				case 2:
					{
					setState(242);
					match(OPTIONS);
					setState(243);
					match(FILE);
					setState(244);
					json_file();
					}
					break;
				}
				}
				setState(247); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPTIONS );
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
		enterRule(_localctx, 52, RULE_include_script_file_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(INCLUDE);
			setState(250);
			sql_script_file();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(251);
				match(T__2);
				setState(252);
				sql_script_file();
				}
				}
				setState(257);
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
		enterRule(_localctx, 54, RULE_schedule_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(SCHEDULE);
			setState(259);
			procedure_name();
			setState(260);
			match(AT);
			setState(261);
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

	public static class Native_stmtContext extends ParserRuleContext {
		public List<ProcedureContext> procedure() {
			return getRuleContexts(ProcedureContext.class);
		}
		public ProcedureContext procedure(int i) {
			return getRuleContext(ProcedureContext.class,i);
		}
		public Native_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_native_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).enterNative_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FbsqlListener ) ((FbsqlListener)listener).exitNative_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FbsqlVisitor ) return ((FbsqlVisitor<? extends T>)visitor).visitNative_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Native_stmtContext native_stmt() throws RecognitionException {
		Native_stmtContext _localctx = new Native_stmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_native_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << STATIC) | (1L << ROLES) | (1L << TRIGGER) | (1L << BEFORE) | (1L << AFTER) | (1L << AS) | (1L << NO) | (1L << COMPRESSION) | (1L << BEST) | (1L << SPEED) | (1L << DECLARE) | (1L << PROCEDURE) | (1L << TYPE) | (1L << JAVA) | (1L << JS) | (1L << EXEC) | (1L << URL) | (1L << OPTIONS) | (1L << FILE) | (1L << STATEMENT) | (1L << CONNECT) | (1L << TO) | (1L << USER) | (1L << PASSWORD) | (1L << PROPERTIES) | (1L << DRIVER) | (1L << LIB) | (1L << CONNECTION) | (1L << POOL) | (1L << SIZE) | (1L << MIN) | (1L << MAX) | (1L << UNDECLARED) | (1L << STATEMENTS) | (1L << INCOMING) | (1L << CONNECTIONS) | (1L << ALLOW) | (1L << REJECT) | (1L << IF) | (1L << EXISTS) | (1L << SWITCH) | (1L << SCHEDULE) | (1L << AT) | (1L << INCLUDE) | (1L << NULL) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << SINGLE_LINE_COMMENT) | (1L << MULTILINE_COMMENT) | (1L << SPACES) | (1L << UNEXPECTED_CHAR))) != 0)) {
				{
				{
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(263);
						matchWildcard();
						}
						} 
					}
					setState(268);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(269);
				procedure();
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(270);
						matchWildcard();
						}
						} 
					}
					setState(275);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				}
				setState(280);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u011c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3I\n\3\3\4\3\4\3\4\5\4N\n\4\3\4\3\4"+
		"\7\4R\n\4\f\4\16\4U\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\be\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u0094\n\30\f\30\16\30\u0097\13\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\6\30\u009f\n\30\r\30\16\30\u00a0\3\30\3\30\3"+
		"\30\6\30\u00a6\n\30\r\30\16\30\u00a7\3\30\3\30\3\30\6\30\u00ad\n\30\r"+
		"\30\16\30\u00ae\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00b7\n\30\3\30\5\30"+
		"\u00ba\n\30\3\30\7\30\u00bd\n\30\f\30\16\30\u00c0\13\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u00d3\n\32\f\32\16\32\u00d6\13\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u00e1\n\32\3\32\7\32\u00e4\n\32\f\32\16\32\u00e7"+
		"\13\32\3\33\3\33\3\33\3\33\3\33\7\33\u00ee\n\33\f\33\16\33\u00f1\13\33"+
		"\3\33\3\33\3\33\3\33\3\33\6\33\u00f8\n\33\r\33\16\33\u00f9\3\34\3\34\3"+
		"\34\3\34\7\34\u0100\n\34\f\34\16\34\u0103\13\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\7\36\u010b\n\36\f\36\16\36\u010e\13\36\3\36\3\36\7\36\u0112\n"+
		"\36\f\36\16\36\u0115\13\36\7\36\u0117\n\36\f\36\16\36\u011a\13\36\3\36"+
		"\5?\u010c\u0113\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:\2\5\4\2\64\64\66\66\3\2+,\3\2\24\27\2\u0126\2?\3\2\2\2\4H"+
		"\3\2\2\2\6J\3\2\2\2\bX\3\2\2\2\nZ\3\2\2\2\f\\\3\2\2\2\16d\3\2\2\2\20f"+
		"\3\2\2\2\22h\3\2\2\2\24j\3\2\2\2\26l\3\2\2\2\30n\3\2\2\2\32p\3\2\2\2\34"+
		"r\3\2\2\2\36t\3\2\2\2 v\3\2\2\2\"x\3\2\2\2$z\3\2\2\2&|\3\2\2\2(~\3\2\2"+
		"\2*\u0080\3\2\2\2,\u0082\3\2\2\2.\u0084\3\2\2\2\60\u00c1\3\2\2\2\62\u00c5"+
		"\3\2\2\2\64\u00e8\3\2\2\2\66\u00fb\3\2\2\28\u0104\3\2\2\2:\u0118\3\2\2"+
		"\2<>\13\2\2\2=<\3\2\2\2>A\3\2\2\2?@\3\2\2\2?=\3\2\2\2@\3\3\2\2\2A?\3\2"+
		"\2\2BC\7\3\2\2CI\7\64\2\2DI\7\65\2\2EI\7\66\2\2FI\7\63\2\2GI\5\6\4\2H"+
		"B\3\2\2\2HD\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2I\5\3\2\2\2JK\5\24\13"+
		"\2KM\7\4\2\2LN\5\4\3\2ML\3\2\2\2MN\3\2\2\2NS\3\2\2\2OP\7\5\2\2PR\5\4\3"+
		"\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\6\2"+
		"\2W\7\3\2\2\2XY\t\2\2\2Y\t\3\2\2\2Z[\7\64\2\2[\13\3\2\2\2\\]\7\64\2\2"+
		"]\r\3\2\2\2^_\7\r\2\2_e\7\16\2\2`a\7\17\2\2ae\7\16\2\2bc\7\17\2\2ce\7"+
		"\20\2\2d^\3\2\2\2d`\3\2\2\2db\3\2\2\2e\17\3\2\2\2fg\t\2\2\2g\21\3\2\2"+
		"\2hi\t\2\2\2i\23\3\2\2\2jk\t\2\2\2k\25\3\2\2\2lm\7\66\2\2m\27\3\2\2\2"+
		"no\7\66\2\2o\31\3\2\2\2pq\t\2\2\2q\33\3\2\2\2rs\7\66\2\2s\35\3\2\2\2t"+
		"u\7\66\2\2u\37\3\2\2\2vw\7\66\2\2w!\3\2\2\2xy\7\66\2\2y#\3\2\2\2z{\7\65"+
		"\2\2{%\3\2\2\2|}\7\65\2\2}\'\3\2\2\2~\177\7\66\2\2\177)\3\2\2\2\u0080"+
		"\u0081\7\66\2\2\u0081+\3\2\2\2\u0082\u0083\7\66\2\2\u0083-\3\2\2\2\u0084"+
		"\u0085\7\33\2\2\u0085\u0086\7\34\2\2\u0086\u00be\5\30\r\2\u0087\u0088"+
		"\7\35\2\2\u0088\u00bd\5\32\16\2\u0089\u008a\7\36\2\2\u008a\u00bd\5\34"+
		"\17\2\u008b\u008c\7\37\2\2\u008c\u00bd\5\36\20\2\u008d\u008e\7 \2\2\u008e"+
		"\u00bd\5 \21\2\u008f\u0090\7!\2\2\u0090\u0095\5\"\22\2\u0091\u0092\7\5"+
		"\2\2\u0092\u0094\5\"\22\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u00bd\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0098\u0099\7\"\2\2\u0099\u009e\7#\2\2\u009a\u009b\7%\2\2\u009b\u009f"+
		"\5$\23\2\u009c\u009d\7&\2\2\u009d\u009f\5&\24\2\u009e\u009a\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00bd\3\2\2\2\u00a2\u00a3\7\'\2\2\u00a3\u00a5\7(\2\2\u00a4"+
		"\u00a6\t\3\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00bd\3\2\2\2\u00a9\u00aa\7)\2\2\u00aa"+
		"\u00ac\7*\2\2\u00ab\u00ad\t\3\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b6\3\2\2\2\u00b0"+
		"\u00b1\7-\2\2\u00b1\u00b2\7.\2\2\u00b2\u00b3\7\4\2\2\u00b3\u00b4\5\2\2"+
		"\2\u00b4\u00b5\7\6\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00bd\3\2\2\2\u00b8\u00ba\7\f\2\2\u00b9\u00b8\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\5\20\t\2\u00bc\u0087\3"+
		"\2\2\2\u00bc\u0089\3\2\2\2\u00bc\u008b\3\2\2\2\u00bc\u008d\3\2\2\2\u00bc"+
		"\u008f\3\2\2\2\u00bc\u0098\3\2\2\2\u00bc\u00a2\3\2\2\2\u00bc\u00a9\3\2"+
		"\2\2\u00bc\u00b9\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf/\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7/\2\2\u00c2"+
		"\u00c3\7\34\2\2\u00c3\u00c4\5\20\t\2\u00c4\61\3\2\2\2\u00c5\u00c6\7\21"+
		"\2\2\u00c6\u00c7\7\32\2\2\u00c7\u00c8\7\4\2\2\u00c8\u00c9\5\2\2\2\u00c9"+
		"\u00e5\7\6\2\2\u00ca\u00e4\7\7\2\2\u00cb\u00cc\7\16\2\2\u00cc\u00e4\5"+
		"\16\b\2\u00cd\u00ce\7\b\2\2\u00ce\u00cf\7\4\2\2\u00cf\u00d4\5\b\5\2\u00d0"+
		"\u00d1\7\5\2\2\u00d1\u00d3\5\b\5\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2"+
		"\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00d8\7\6\2\2\u00d8\u00e4\3\2\2\2\u00d9\u00da\7\t"+
		"\2\2\u00da\u00db\7\n\2\2\u00db\u00e4\5\n\6\2\u00dc\u00dd\7\t\2\2\u00dd"+
		"\u00de\7\13\2\2\u00de\u00e4\5\f\7\2\u00df\u00e1\7\f\2\2\u00e0\u00df\3"+
		"\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\5\22\n\2\u00e3"+
		"\u00ca\3\2\2\2\u00e3\u00cb\3\2\2\2\u00e3\u00cd\3\2\2\2\u00e3\u00d9\3\2"+
		"\2\2\u00e3\u00dc\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\63\3\2\2\2\u00e7\u00e5\3\2\2"+
		"\2\u00e8\u00e9\7\21\2\2\u00e9\u00ea\7\22\2\2\u00ea\u00eb\5\24\13\2\u00eb"+
		"\u00ef\7\23\2\2\u00ec\u00ee\t\4\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f7\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\7\30\2\2\u00f3\u00f8\5\26\f\2\u00f4\u00f5\7"+
		"\30\2\2\u00f5\u00f6\7\31\2\2\u00f6\u00f8\5*\26\2\u00f7\u00f2\3\2\2\2\u00f7"+
		"\u00f4\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\65\3\2\2\2\u00fb\u00fc\7\62\2\2\u00fc\u0101\5(\25\2\u00fd\u00fe"+
		"\7\5\2\2\u00fe\u0100\5(\25\2\u00ff\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\67\3\2\2\2\u0103\u0101\3\2\2"+
		"\2\u0104\u0105\7\60\2\2\u0105\u0106\5\24\13\2\u0106\u0107\7\61\2\2\u0107"+
		"\u0108\5,\27\2\u01089\3\2\2\2\u0109\u010b\13\2\2\2\u010a\u0109\3\2\2\2"+
		"\u010b\u010e\3\2\2\2\u010c\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0113\5\6\4\2\u0110\u0112\13\2\2\2"+
		"\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0114\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u010c\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119;\3\2\2\2"+
		"\u011a\u0118\3\2\2\2\33?HMSd\u0095\u009e\u00a0\u00a7\u00ae\u00b6\u00b9"+
		"\u00bc\u00be\u00d4\u00e0\u00e3\u00e5\u00ef\u00f7\u00f9\u0101\u010c\u0113"+
		"\u0118";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}