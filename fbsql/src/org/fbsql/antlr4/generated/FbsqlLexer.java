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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FbsqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STATIC=5, ROLES=6, TRIGGER=7, BEFORE=8, 
		AFTER=9, AS=10, NO=11, COMPRESSION=12, BEST=13, SPEED=14, DECLARE=15, 
		PROCEDURE=16, TYPE=17, JVM=18, JS=19, EXEC=20, URL=21, OPTIONS=22, FILE=23, 
		STATEMENT=24, CONNECT=25, TO=26, USER=27, PASSWORD=28, PROPERTIES=29, 
		DRIVER=30, LIB=31, CONNECTION=32, POOL=33, SIZE=34, MIN=35, MAX=36, UNDECLARED=37, 
		STATEMENTS=38, INCOMING=39, CONNECTIONS=40, ALLOW=41, REJECT=42, IF=43, 
		EXISTS=44, SWITCH=45, SCHEDULE=46, AT=47, INCLUDE=48, NULL=49, IDENTIFIER=50, 
		NUMERIC_LITERAL=51, STRING_LITERAL=52, SINGLE_LINE_COMMENT=53, MULTILINE_COMMENT=54, 
		SPACES=55, UNEXPECTED_CHAR=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "STATIC", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "NO", "COMPRESSION", "BEST", "SPEED", "DECLARE", "PROCEDURE", 
			"TYPE", "JVM", "JS", "EXEC", "URL", "OPTIONS", "FILE", "STATEMENT", "CONNECT", 
			"TO", "USER", "PASSWORD", "PROPERTIES", "DRIVER", "LIB", "CONNECTION", 
			"POOL", "SIZE", "MIN", "MAX", "UNDECLARED", "STATEMENTS", "INCOMING", 
			"CONNECTIONS", "ALLOW", "REJECT", "IF", "EXISTS", "SWITCH", "SCHEDULE", 
			"AT", "INCLUDE", "NULL", "IDENTIFIER", "NUMERIC_LITERAL", "STRING_LITERAL", 
			"SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR", 
			"DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
			"TYPE", "JVM", "JS", "EXEC", "URL", "OPTIONS", "FILE", "STATEMENT", "CONNECT", 
			"TO", "USER", "PASSWORD", "PROPERTIES", "DRIVER", "LIB", "CONNECTION", 
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


	public FbsqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Fbsql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u028f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u01e1\n\63\f\63\16\63\u01e4\13\63"+
		"\3\63\3\63\3\63\3\63\3\63\7\63\u01eb\n\63\f\63\16\63\u01ee\13\63\3\63"+
		"\3\63\3\63\7\63\u01f3\n\63\f\63\16\63\u01f6\13\63\3\63\3\63\3\63\7\63"+
		"\u01fb\n\63\f\63\16\63\u01fe\13\63\5\63\u0200\n\63\3\64\6\64\u0203\n\64"+
		"\r\64\16\64\u0204\3\64\3\64\7\64\u0209\n\64\f\64\16\64\u020c\13\64\5\64"+
		"\u020e\n\64\3\64\3\64\5\64\u0212\n\64\3\64\6\64\u0215\n\64\r\64\16\64"+
		"\u0216\5\64\u0219\n\64\3\64\3\64\6\64\u021d\n\64\r\64\16\64\u021e\3\64"+
		"\3\64\5\64\u0223\n\64\3\64\6\64\u0226\n\64\r\64\16\64\u0227\5\64\u022a"+
		"\n\64\5\64\u022c\n\64\3\65\3\65\3\65\3\65\7\65\u0232\n\65\f\65\16\65\u0235"+
		"\13\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u023d\n\66\f\66\16\66\u0240"+
		"\13\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u0248\n\67\f\67\16\67\u024b"+
		"\13\67\3\67\3\67\3\67\5\67\u0250\n\67\3\67\3\67\38\38\38\38\39\39\3:\3"+
		":\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3"+
		"F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3"+
		"Q\3R\3R\3S\3S\3T\3T\3\u0249\2U\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64g\65i\66k\67m8o9q:s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2"+
		"\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095"+
		"\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7"+
		"\2\3\2&\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\4\2"+
		"\f\f\17\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff"+
		"\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2O"+
		"Ooo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4"+
		"\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u028c\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\3\u00a9\3\2\2\2\5\u00ab\3\2\2\2\7\u00ad\3\2\2\2\t\u00af\3\2\2\2\13"+
		"\u00b1\3\2\2\2\r\u00b8\3\2\2\2\17\u00be\3\2\2\2\21\u00c6\3\2\2\2\23\u00cd"+
		"\3\2\2\2\25\u00d3\3\2\2\2\27\u00d6\3\2\2\2\31\u00d9\3\2\2\2\33\u00e5\3"+
		"\2\2\2\35\u00ea\3\2\2\2\37\u00f0\3\2\2\2!\u00f8\3\2\2\2#\u0102\3\2\2\2"+
		"%\u0107\3\2\2\2\'\u010b\3\2\2\2)\u010e\3\2\2\2+\u0113\3\2\2\2-\u0117\3"+
		"\2\2\2/\u011f\3\2\2\2\61\u0124\3\2\2\2\63\u012e\3\2\2\2\65\u0136\3\2\2"+
		"\2\67\u0139\3\2\2\29\u013e\3\2\2\2;\u0147\3\2\2\2=\u0152\3\2\2\2?\u0159"+
		"\3\2\2\2A\u015d\3\2\2\2C\u0168\3\2\2\2E\u016d\3\2\2\2G\u0172\3\2\2\2I"+
		"\u0176\3\2\2\2K\u017a\3\2\2\2M\u0185\3\2\2\2O\u0190\3\2\2\2Q\u0199\3\2"+
		"\2\2S\u01a5\3\2\2\2U\u01ab\3\2\2\2W\u01b2\3\2\2\2Y\u01b5\3\2\2\2[\u01bc"+
		"\3\2\2\2]\u01c3\3\2\2\2_\u01cc\3\2\2\2a\u01cf\3\2\2\2c\u01d7\3\2\2\2e"+
		"\u01ff\3\2\2\2g\u022b\3\2\2\2i\u022d\3\2\2\2k\u0238\3\2\2\2m\u0243\3\2"+
		"\2\2o\u0253\3\2\2\2q\u0257\3\2\2\2s\u0259\3\2\2\2u\u025b\3\2\2\2w\u025d"+
		"\3\2\2\2y\u025f\3\2\2\2{\u0261\3\2\2\2}\u0263\3\2\2\2\177\u0265\3\2\2"+
		"\2\u0081\u0267\3\2\2\2\u0083\u0269\3\2\2\2\u0085\u026b\3\2\2\2\u0087\u026d"+
		"\3\2\2\2\u0089\u026f\3\2\2\2\u008b\u0271\3\2\2\2\u008d\u0273\3\2\2\2\u008f"+
		"\u0275\3\2\2\2\u0091\u0277\3\2\2\2\u0093\u0279\3\2\2\2\u0095\u027b\3\2"+
		"\2\2\u0097\u027d\3\2\2\2\u0099\u027f\3\2\2\2\u009b\u0281\3\2\2\2\u009d"+
		"\u0283\3\2\2\2\u009f\u0285\3\2\2\2\u00a1\u0287\3\2\2\2\u00a3\u0289\3\2"+
		"\2\2\u00a5\u028b\3\2\2\2\u00a7\u028d\3\2\2\2\u00a9\u00aa\7<\2\2\u00aa"+
		"\4\3\2\2\2\u00ab\u00ac\7*\2\2\u00ac\6\3\2\2\2\u00ad\u00ae\7.\2\2\u00ae"+
		"\b\3\2\2\2\u00af\u00b0\7+\2\2\u00b0\n\3\2\2\2\u00b1\u00b2\5\u0099M\2\u00b2"+
		"\u00b3\5\u009bN\2\u00b3\u00b4\5u;\2\u00b4\u00b5\5\u009bN\2\u00b5\u00b6"+
		"\5\u0085C\2\u00b6\u00b7\5y=\2\u00b7\f\3\2\2\2\u00b8\u00b9\5\u0097L\2\u00b9"+
		"\u00ba\5\u0091I\2\u00ba\u00bb\5\u008bF\2\u00bb\u00bc\5}?\2\u00bc\u00bd"+
		"\5\u0099M\2\u00bd\16\3\2\2\2\u00be\u00bf\5\u009bN\2\u00bf\u00c0\5\u0097"+
		"L\2\u00c0\u00c1\5\u0085C\2\u00c1\u00c2\5\u0081A\2\u00c2\u00c3\5\u0081"+
		"A\2\u00c3\u00c4\5}?\2\u00c4\u00c5\5\u0097L\2\u00c5\20\3\2\2\2\u00c6\u00c7"+
		"\5w<\2\u00c7\u00c8\5}?\2\u00c8\u00c9\5\177@\2\u00c9\u00ca\5\u0091I\2\u00ca"+
		"\u00cb\5\u0097L\2\u00cb\u00cc\5}?\2\u00cc\22\3\2\2\2\u00cd\u00ce\5u;\2"+
		"\u00ce\u00cf\5\177@\2\u00cf\u00d0\5\u009bN\2\u00d0\u00d1\5}?\2\u00d1\u00d2"+
		"\5\u0097L\2\u00d2\24\3\2\2\2\u00d3\u00d4\5u;\2\u00d4\u00d5\5\u0099M\2"+
		"\u00d5\26\3\2\2\2\u00d6\u00d7\5\u008fH\2\u00d7\u00d8\5\u0091I\2\u00d8"+
		"\30\3\2\2\2\u00d9\u00da\5y=\2\u00da\u00db\5\u0091I\2\u00db\u00dc\5\u008d"+
		"G\2\u00dc\u00dd\5\u0093J\2\u00dd\u00de\5\u0097L\2\u00de\u00df\5}?\2\u00df"+
		"\u00e0\5\u0099M\2\u00e0\u00e1\5\u0099M\2\u00e1\u00e2\5\u0085C\2\u00e2"+
		"\u00e3\5\u0091I\2\u00e3\u00e4\5\u008fH\2\u00e4\32\3\2\2\2\u00e5\u00e6"+
		"\5w<\2\u00e6\u00e7\5}?\2\u00e7\u00e8\5\u0099M\2\u00e8\u00e9\5\u009bN\2"+
		"\u00e9\34\3\2\2\2\u00ea\u00eb\5\u0099M\2\u00eb\u00ec\5\u0093J\2\u00ec"+
		"\u00ed\5}?\2\u00ed\u00ee\5}?\2\u00ee\u00ef\5{>\2\u00ef\36\3\2\2\2\u00f0"+
		"\u00f1\5{>\2\u00f1\u00f2\5}?\2\u00f2\u00f3\5y=\2\u00f3\u00f4\5\u008bF"+
		"\2\u00f4\u00f5\5u;\2\u00f5\u00f6\5\u0097L\2\u00f6\u00f7\5}?\2\u00f7 \3"+
		"\2\2\2\u00f8\u00f9\5\u0093J\2\u00f9\u00fa\5\u0097L\2\u00fa\u00fb\5\u0091"+
		"I\2\u00fb\u00fc\5y=\2\u00fc\u00fd\5}?\2\u00fd\u00fe\5{>\2\u00fe\u00ff"+
		"\5\u009dO\2\u00ff\u0100\5\u0097L\2\u0100\u0101\5}?\2\u0101\"\3\2\2\2\u0102"+
		"\u0103\5\u009bN\2\u0103\u0104\5\u00a5S\2\u0104\u0105\5\u0093J\2\u0105"+
		"\u0106\5}?\2\u0106$\3\2\2\2\u0107\u0108\5\u0087D\2\u0108\u0109\5\u009f"+
		"P\2\u0109\u010a\5\u008dG\2\u010a&\3\2\2\2\u010b\u010c\5\u0087D\2\u010c"+
		"\u010d\5\u0099M\2\u010d(\3\2\2\2\u010e\u010f\5}?\2\u010f\u0110\5\u00a3"+
		"R\2\u0110\u0111\5}?\2\u0111\u0112\5y=\2\u0112*\3\2\2\2\u0113\u0114\5\u009d"+
		"O\2\u0114\u0115\5\u0097L\2\u0115\u0116\5\u008bF\2\u0116,\3\2\2\2\u0117"+
		"\u0118\5\u0091I\2\u0118\u0119\5\u0093J\2\u0119\u011a\5\u009bN\2\u011a"+
		"\u011b\5\u0085C\2\u011b\u011c\5\u0091I\2\u011c\u011d\5\u008fH\2\u011d"+
		"\u011e\5\u0099M\2\u011e.\3\2\2\2\u011f\u0120\5\177@\2\u0120\u0121\5\u0085"+
		"C\2\u0121\u0122\5\u008bF\2\u0122\u0123\5}?\2\u0123\60\3\2\2\2\u0124\u0125"+
		"\5\u0099M\2\u0125\u0126\5\u009bN\2\u0126\u0127\5u;\2\u0127\u0128\5\u009b"+
		"N\2\u0128\u0129\5}?\2\u0129\u012a\5\u008dG\2\u012a\u012b\5}?\2\u012b\u012c"+
		"\5\u008fH\2\u012c\u012d\5\u009bN\2\u012d\62\3\2\2\2\u012e\u012f\5y=\2"+
		"\u012f\u0130\5\u0091I\2\u0130\u0131\5\u008fH\2\u0131\u0132\5\u008fH\2"+
		"\u0132\u0133\5}?\2\u0133\u0134\5y=\2\u0134\u0135\5\u009bN\2\u0135\64\3"+
		"\2\2\2\u0136\u0137\5\u009bN\2\u0137\u0138\5\u0091I\2\u0138\66\3\2\2\2"+
		"\u0139\u013a\5\u009dO\2\u013a\u013b\5\u0099M\2\u013b\u013c\5}?\2\u013c"+
		"\u013d\5\u0097L\2\u013d8\3\2\2\2\u013e\u013f\5\u0093J\2\u013f\u0140\5"+
		"u;\2\u0140\u0141\5\u0099M\2\u0141\u0142\5\u0099M\2\u0142\u0143\5\u00a1"+
		"Q\2\u0143\u0144\5\u0091I\2\u0144\u0145\5\u0097L\2\u0145\u0146\5{>\2\u0146"+
		":\3\2\2\2\u0147\u0148\5\u0093J\2\u0148\u0149\5\u0097L\2\u0149\u014a\5"+
		"\u0091I\2\u014a\u014b\5\u0093J\2\u014b\u014c\5}?\2\u014c\u014d\5\u0097"+
		"L\2\u014d\u014e\5\u009bN\2\u014e\u014f\5\u0085C\2\u014f\u0150\5}?\2\u0150"+
		"\u0151\5\u0099M\2\u0151<\3\2\2\2\u0152\u0153\5{>\2\u0153\u0154\5\u0097"+
		"L\2\u0154\u0155\5\u0085C\2\u0155\u0156\5\u009fP\2\u0156\u0157\5}?\2\u0157"+
		"\u0158\5\u0097L\2\u0158>\3\2\2\2\u0159\u015a\5\u008bF\2\u015a\u015b\5"+
		"\u0085C\2\u015b\u015c\5w<\2\u015c@\3\2\2\2\u015d\u015e\5y=\2\u015e\u015f"+
		"\5\u0091I\2\u015f\u0160\5\u008fH\2\u0160\u0161\5\u008fH\2\u0161\u0162"+
		"\5}?\2\u0162\u0163\5y=\2\u0163\u0164\5\u009bN\2\u0164\u0165\5\u0085C\2"+
		"\u0165\u0166\5\u0091I\2\u0166\u0167\5\u008fH\2\u0167B\3\2\2\2\u0168\u0169"+
		"\5\u0093J\2\u0169\u016a\5\u0091I\2\u016a\u016b\5\u0091I\2\u016b\u016c"+
		"\5\u008bF\2\u016cD\3\2\2\2\u016d\u016e\5\u0099M\2\u016e\u016f\5\u0085"+
		"C\2\u016f\u0170\5\u00a7T\2\u0170\u0171\5}?\2\u0171F\3\2\2\2\u0172\u0173"+
		"\5\u008dG\2\u0173\u0174\5\u0085C\2\u0174\u0175\5\u008fH\2\u0175H\3\2\2"+
		"\2\u0176\u0177\5\u008dG\2\u0177\u0178\5u;\2\u0178\u0179\5\u00a3R\2\u0179"+
		"J\3\2\2\2\u017a\u017b\5\u009dO\2\u017b\u017c\5\u008fH\2\u017c\u017d\5"+
		"{>\2\u017d\u017e\5}?\2\u017e\u017f\5y=\2\u017f\u0180\5\u008bF\2\u0180"+
		"\u0181\5u;\2\u0181\u0182\5\u0097L\2\u0182\u0183\5}?\2\u0183\u0184\5{>"+
		"\2\u0184L\3\2\2\2\u0185\u0186\5\u0099M\2\u0186\u0187\5\u009bN\2\u0187"+
		"\u0188\5u;\2\u0188\u0189\5\u009bN\2\u0189\u018a\5}?\2\u018a\u018b\5\u008d"+
		"G\2\u018b\u018c\5}?\2\u018c\u018d\5\u008fH\2\u018d\u018e\5\u009bN\2\u018e"+
		"\u018f\5\u0099M\2\u018fN\3\2\2\2\u0190\u0191\5\u0085C\2\u0191\u0192\5"+
		"\u008fH\2\u0192\u0193\5y=\2\u0193\u0194\5\u0091I\2\u0194\u0195\5\u008d"+
		"G\2\u0195\u0196\5\u0085C\2\u0196\u0197\5\u008fH\2\u0197\u0198\5\u0081"+
		"A\2\u0198P\3\2\2\2\u0199\u019a\5y=\2\u019a\u019b\5\u0091I\2\u019b\u019c"+
		"\5\u008fH\2\u019c\u019d\5\u008fH\2\u019d\u019e\5}?\2\u019e\u019f\5y=\2"+
		"\u019f\u01a0\5\u009bN\2\u01a0\u01a1\5\u0085C\2\u01a1\u01a2\5\u0091I\2"+
		"\u01a2\u01a3\5\u008fH\2\u01a3\u01a4\5\u0099M\2\u01a4R\3\2\2\2\u01a5\u01a6"+
		"\5u;\2\u01a6\u01a7\5\u008bF\2\u01a7\u01a8\5\u008bF\2\u01a8\u01a9\5\u0091"+
		"I\2\u01a9\u01aa\5\u00a1Q\2\u01aaT\3\2\2\2\u01ab\u01ac\5\u0097L\2\u01ac"+
		"\u01ad\5}?\2\u01ad\u01ae\5\u0087D\2\u01ae\u01af\5}?\2\u01af\u01b0\5y="+
		"\2\u01b0\u01b1\5\u009bN\2\u01b1V\3\2\2\2\u01b2\u01b3\5\u0085C\2\u01b3"+
		"\u01b4\5\177@\2\u01b4X\3\2\2\2\u01b5\u01b6\5}?\2\u01b6\u01b7\5\u00a3R"+
		"\2\u01b7\u01b8\5\u0085C\2\u01b8\u01b9\5\u0099M\2\u01b9\u01ba\5\u009bN"+
		"\2\u01ba\u01bb\5\u0099M\2\u01bbZ\3\2\2\2\u01bc\u01bd\5\u0099M\2\u01bd"+
		"\u01be\5\u00a1Q\2\u01be\u01bf\5\u0085C\2\u01bf\u01c0\5\u009bN\2\u01c0"+
		"\u01c1\5y=\2\u01c1\u01c2\5\u0083B\2\u01c2\\\3\2\2\2\u01c3\u01c4\5\u0099"+
		"M\2\u01c4\u01c5\5y=\2\u01c5\u01c6\5\u0083B\2\u01c6\u01c7\5}?\2\u01c7\u01c8"+
		"\5{>\2\u01c8\u01c9\5\u009dO\2\u01c9\u01ca\5\u008bF\2\u01ca\u01cb\5}?\2"+
		"\u01cb^\3\2\2\2\u01cc\u01cd\5u;\2\u01cd\u01ce\5\u009bN\2\u01ce`\3\2\2"+
		"\2\u01cf\u01d0\5\u0085C\2\u01d0\u01d1\5\u008fH\2\u01d1\u01d2\5y=\2\u01d2"+
		"\u01d3\5\u008bF\2\u01d3\u01d4\5\u009dO\2\u01d4\u01d5\5{>\2\u01d5\u01d6"+
		"\5}?\2\u01d6b\3\2\2\2\u01d7\u01d8\5\u008fH\2\u01d8\u01d9\5\u009dO\2\u01d9"+
		"\u01da\5\u008bF\2\u01da\u01db\5\u008bF\2\u01dbd\3\2\2\2\u01dc\u01e2\7"+
		"$\2\2\u01dd\u01e1\n\2\2\2\u01de\u01df\7$\2\2\u01df\u01e1\7$\2\2\u01e0"+
		"\u01dd\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2"+
		"\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5"+
		"\u0200\7$\2\2\u01e6\u01ec\7b\2\2\u01e7\u01eb\n\3\2\2\u01e8\u01e9\7b\2"+
		"\2\u01e9\u01eb\7b\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ee"+
		"\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ef\u0200\7b\2\2\u01f0\u01f4\7]\2\2\u01f1\u01f3\n\4\2"+
		"\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5"+
		"\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u0200\7_\2\2\u01f8"+
		"\u01fc\t\5\2\2\u01f9\u01fb\t\6\2\2\u01fa\u01f9\3\2\2\2\u01fb\u01fe\3\2"+
		"\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe"+
		"\u01fc\3\2\2\2\u01ff\u01dc\3\2\2\2\u01ff\u01e6\3\2\2\2\u01ff\u01f0\3\2"+
		"\2\2\u01ff\u01f8\3\2\2\2\u0200f\3\2\2\2\u0201\u0203\5s:\2\u0202\u0201"+
		"\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u020d\3\2\2\2\u0206\u020a\7\60\2\2\u0207\u0209\5s:\2\u0208\u0207\3\2"+
		"\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u0206\3\2\2\2\u020d\u020e\3\2"+
		"\2\2\u020e\u0218\3\2\2\2\u020f\u0211\5}?\2\u0210\u0212\t\7\2\2\u0211\u0210"+
		"\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214\3\2\2\2\u0213\u0215\5s:\2\u0214"+
		"\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2"+
		"\2\2\u0217\u0219\3\2\2\2\u0218\u020f\3\2\2\2\u0218\u0219\3\2\2\2\u0219"+
		"\u022c\3\2\2\2\u021a\u021c\7\60\2\2\u021b\u021d\5s:\2\u021c\u021b\3\2"+
		"\2\2\u021d\u021e\3\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f"+
		"\u0229\3\2\2\2\u0220\u0222\5}?\2\u0221\u0223\t\7\2\2\u0222\u0221\3\2\2"+
		"\2\u0222\u0223\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u0226\5s:\2\u0225\u0224"+
		"\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228"+
		"\u022a\3\2\2\2\u0229\u0220\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022c\3\2"+
		"\2\2\u022b\u0202\3\2\2\2\u022b\u021a\3\2\2\2\u022ch\3\2\2\2\u022d\u0233"+
		"\7)\2\2\u022e\u0232\n\b\2\2\u022f\u0230\7)\2\2\u0230\u0232\7)\2\2\u0231"+
		"\u022e\3\2\2\2\u0231\u022f\3\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2"+
		"\2\2\u0233\u0234\3\2\2\2\u0234\u0236\3\2\2\2\u0235\u0233\3\2\2\2\u0236"+
		"\u0237\7)\2\2\u0237j\3\2\2\2\u0238\u0239\7/\2\2\u0239\u023a\7/\2\2\u023a"+
		"\u023e\3\2\2\2\u023b\u023d\n\t\2\2\u023c\u023b\3\2\2\2\u023d\u0240\3\2"+
		"\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0241\3\2\2\2\u0240"+
		"\u023e\3\2\2\2\u0241\u0242\b\66\2\2\u0242l\3\2\2\2\u0243\u0244\7\61\2"+
		"\2\u0244\u0245\7,\2\2\u0245\u0249\3\2\2\2\u0246\u0248\13\2\2\2\u0247\u0246"+
		"\3\2\2\2\u0248\u024b\3\2\2\2\u0249\u024a\3\2\2\2\u0249\u0247\3\2\2\2\u024a"+
		"\u024f\3\2\2\2\u024b\u0249\3\2\2\2\u024c\u024d\7,\2\2\u024d\u0250\7\61"+
		"\2\2\u024e\u0250\7\2\2\3\u024f\u024c\3\2\2\2\u024f\u024e\3\2\2\2\u0250"+
		"\u0251\3\2\2\2\u0251\u0252\b\67\2\2\u0252n\3\2\2\2\u0253\u0254\t\n\2\2"+
		"\u0254\u0255\3\2\2\2\u0255\u0256\b8\2\2\u0256p\3\2\2\2\u0257\u0258\13"+
		"\2\2\2\u0258r\3\2\2\2\u0259\u025a\t\13\2\2\u025at\3\2\2\2\u025b\u025c"+
		"\t\f\2\2\u025cv\3\2\2\2\u025d\u025e\t\r\2\2\u025ex\3\2\2\2\u025f\u0260"+
		"\t\16\2\2\u0260z\3\2\2\2\u0261\u0262\t\17\2\2\u0262|\3\2\2\2\u0263\u0264"+
		"\t\20\2\2\u0264~\3\2\2\2\u0265\u0266\t\21\2\2\u0266\u0080\3\2\2\2\u0267"+
		"\u0268\t\22\2\2\u0268\u0082\3\2\2\2\u0269\u026a\t\23\2\2\u026a\u0084\3"+
		"\2\2\2\u026b\u026c\t\24\2\2\u026c\u0086\3\2\2\2\u026d\u026e\t\25\2\2\u026e"+
		"\u0088\3\2\2\2\u026f\u0270\t\26\2\2\u0270\u008a\3\2\2\2\u0271\u0272\t"+
		"\27\2\2\u0272\u008c\3\2\2\2\u0273\u0274\t\30\2\2\u0274\u008e\3\2\2\2\u0275"+
		"\u0276\t\31\2\2\u0276\u0090\3\2\2\2\u0277\u0278\t\32\2\2\u0278\u0092\3"+
		"\2\2\2\u0279\u027a\t\33\2\2\u027a\u0094\3\2\2\2\u027b\u027c\t\34\2\2\u027c"+
		"\u0096\3\2\2\2\u027d\u027e\t\35\2\2\u027e\u0098\3\2\2\2\u027f\u0280\t"+
		"\36\2\2\u0280\u009a\3\2\2\2\u0281\u0282\t\37\2\2\u0282\u009c\3\2\2\2\u0283"+
		"\u0284\t \2\2\u0284\u009e\3\2\2\2\u0285\u0286\t!\2\2\u0286\u00a0\3\2\2"+
		"\2\u0287\u0288\t\"\2\2\u0288\u00a2\3\2\2\2\u0289\u028a\t#\2\2\u028a\u00a4"+
		"\3\2\2\2\u028b\u028c\t$\2\2\u028c\u00a6\3\2\2\2\u028d\u028e\t%\2\2\u028e"+
		"\u00a8\3\2\2\2\32\2\u01e0\u01e2\u01ea\u01ec\u01f4\u01fc\u01ff\u0204\u020a"+
		"\u020d\u0211\u0216\u0218\u021e\u0222\u0227\u0229\u022b\u0231\u0233\u023e"+
		"\u0249\u024f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}