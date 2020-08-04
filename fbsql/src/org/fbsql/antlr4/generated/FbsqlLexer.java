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
		T__0=1, T__1=2, T__2=3, EXPOSE=4, PREFETCH=5, ROLES=6, TRIGGER=7, BEFORE=8, 
		AFTER=9, AS=10, COMPRESSION=11, NONE=12, BEST=13, SPEED=14, ON=15, OFF=16, 
		DECLARE=17, PROCEDURE=18, FOR=19, CONNECT=20, TO=21, USER=22, PASSWORD=23, 
		PROPERTIES=24, DRIVER=25, LIB=26, CONNECTION=27, POOL=28, SIZE=29, MIN=30, 
		MAX=31, SWITCH=32, LOGIN=33, IF=34, EXISTS=35, SCHEDULE=36, AT=37, INCLUDE=38, 
		FILE=39, IDENTIFIER=40, NUMERIC_LITERAL=41, STRING_LITERAL=42, SINGLE_LINE_COMMENT=43, 
		MULTILINE_COMMENT=44, SPACES=45, UNEXPECTED_CHAR=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "EXPOSE", "PREFETCH", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "COMPRESSION", "NONE", "BEST", "SPEED", "ON", "OFF", "DECLARE", 
			"PROCEDURE", "FOR", "CONNECT", "TO", "USER", "PASSWORD", "PROPERTIES", 
			"DRIVER", "LIB", "CONNECTION", "POOL", "SIZE", "MIN", "MAX", "SWITCH", 
			"LOGIN", "IF", "EXISTS", "SCHEDULE", "AT", "INCLUDE", "FILE", "IDENTIFIER", 
			"NUMERIC_LITERAL", "STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", 
			"SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
			"V", "W", "X", "Y", "Z"
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
			"DRIVER", "LIB", "CONNECTION", "POOL", "SIZE", "MIN", "MAX", "SWITCH", 
			"LOGIN", "IF", "EXISTS", "SCHEDULE", "AT", "INCLUDE", "FILE", "IDENTIFIER", 
			"NUMERIC_LITERAL", "STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", 
			"SPACES", "UNEXPECTED_CHAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0231\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\7)\u0183\n)\f)\16"+
		")\u0186\13)\3)\3)\3)\3)\3)\7)\u018d\n)\f)\16)\u0190\13)\3)\3)\3)\7)\u0195"+
		"\n)\f)\16)\u0198\13)\3)\3)\3)\7)\u019d\n)\f)\16)\u01a0\13)\5)\u01a2\n"+
		")\3*\6*\u01a5\n*\r*\16*\u01a6\3*\3*\7*\u01ab\n*\f*\16*\u01ae\13*\5*\u01b0"+
		"\n*\3*\3*\5*\u01b4\n*\3*\6*\u01b7\n*\r*\16*\u01b8\5*\u01bb\n*\3*\3*\6"+
		"*\u01bf\n*\r*\16*\u01c0\3*\3*\5*\u01c5\n*\3*\6*\u01c8\n*\r*\16*\u01c9"+
		"\5*\u01cc\n*\5*\u01ce\n*\3+\3+\3+\3+\7+\u01d4\n+\f+\16+\u01d7\13+\3+\3"+
		"+\3,\3,\3,\3,\7,\u01df\n,\f,\16,\u01e2\13,\3,\3,\3-\3-\3-\3-\7-\u01ea"+
		"\n-\f-\16-\u01ed\13-\3-\3-\3-\5-\u01f2\n-\3-\3-\3.\3.\3.\3.\3/\3/\3\60"+
		"\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3"+
		"B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3\u01eb\2K\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2"+
		"y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d"+
		"\2\u008f\2\u0091\2\u0093\2\3\2&\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C"+
		"\\aac|\4\2--//\3\2))\4\2\f\f\17\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc"+
		"\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2L"+
		"Lll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4"+
		"\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u022e"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3\u0095\3\2\2\2"+
		"\5\u0097\3\2\2\2\7\u0099\3\2\2\2\t\u009b\3\2\2\2\13\u00a2\3\2\2\2\r\u00ab"+
		"\3\2\2\2\17\u00b1\3\2\2\2\21\u00b9\3\2\2\2\23\u00c0\3\2\2\2\25\u00c6\3"+
		"\2\2\2\27\u00c9\3\2\2\2\31\u00d5\3\2\2\2\33\u00da\3\2\2\2\35\u00df\3\2"+
		"\2\2\37\u00e5\3\2\2\2!\u00e8\3\2\2\2#\u00ec\3\2\2\2%\u00f4\3\2\2\2\'\u00fe"+
		"\3\2\2\2)\u0102\3\2\2\2+\u010a\3\2\2\2-\u010d\3\2\2\2/\u0112\3\2\2\2\61"+
		"\u011b\3\2\2\2\63\u0126\3\2\2\2\65\u012d\3\2\2\2\67\u0131\3\2\2\29\u013c"+
		"\3\2\2\2;\u0141\3\2\2\2=\u0146\3\2\2\2?\u014a\3\2\2\2A\u014e\3\2\2\2C"+
		"\u0155\3\2\2\2E\u015b\3\2\2\2G\u015e\3\2\2\2I\u0165\3\2\2\2K\u016e\3\2"+
		"\2\2M\u0171\3\2\2\2O\u0179\3\2\2\2Q\u01a1\3\2\2\2S\u01cd\3\2\2\2U\u01cf"+
		"\3\2\2\2W\u01da\3\2\2\2Y\u01e5\3\2\2\2[\u01f5\3\2\2\2]\u01f9\3\2\2\2_"+
		"\u01fb\3\2\2\2a\u01fd\3\2\2\2c\u01ff\3\2\2\2e\u0201\3\2\2\2g\u0203\3\2"+
		"\2\2i\u0205\3\2\2\2k\u0207\3\2\2\2m\u0209\3\2\2\2o\u020b\3\2\2\2q\u020d"+
		"\3\2\2\2s\u020f\3\2\2\2u\u0211\3\2\2\2w\u0213\3\2\2\2y\u0215\3\2\2\2{"+
		"\u0217\3\2\2\2}\u0219\3\2\2\2\177\u021b\3\2\2\2\u0081\u021d\3\2\2\2\u0083"+
		"\u021f\3\2\2\2\u0085\u0221\3\2\2\2\u0087\u0223\3\2\2\2\u0089\u0225\3\2"+
		"\2\2\u008b\u0227\3\2\2\2\u008d\u0229\3\2\2\2\u008f\u022b\3\2\2\2\u0091"+
		"\u022d\3\2\2\2\u0093\u022f\3\2\2\2\u0095\u0096\7.\2\2\u0096\4\3\2\2\2"+
		"\u0097\u0098\7*\2\2\u0098\6\3\2\2\2\u0099\u009a\7+\2\2\u009a\b\3\2\2\2"+
		"\u009b\u009c\5i\65\2\u009c\u009d\5\u008fH\2\u009d\u009e\5\177@\2\u009e"+
		"\u009f\5}?\2\u009f\u00a0\5\u0085C\2\u00a0\u00a1\5i\65\2\u00a1\n\3\2\2"+
		"\2\u00a2\u00a3\5\177@\2\u00a3\u00a4\5\u0083B\2\u00a4\u00a5\5i\65\2\u00a5"+
		"\u00a6\5k\66\2\u00a6\u00a7\5i\65\2\u00a7\u00a8\5\u0087D\2\u00a8\u00a9"+
		"\5e\63\2\u00a9\u00aa\5o8\2\u00aa\f\3\2\2\2\u00ab\u00ac\5\u0083B\2\u00ac"+
		"\u00ad\5}?\2\u00ad\u00ae\5w<\2\u00ae\u00af\5i\65\2\u00af\u00b0\5\u0085"+
		"C\2\u00b0\16\3\2\2\2\u00b1\u00b2\5\u0087D\2\u00b2\u00b3\5\u0083B\2\u00b3"+
		"\u00b4\5q9\2\u00b4\u00b5\5m\67\2\u00b5\u00b6\5m\67\2\u00b6\u00b7\5i\65"+
		"\2\u00b7\u00b8\5\u0083B\2\u00b8\20\3\2\2\2\u00b9\u00ba\5c\62\2\u00ba\u00bb"+
		"\5i\65\2\u00bb\u00bc\5k\66\2\u00bc\u00bd\5}?\2\u00bd\u00be\5\u0083B\2"+
		"\u00be\u00bf\5i\65\2\u00bf\22\3\2\2\2\u00c0\u00c1\5a\61\2\u00c1\u00c2"+
		"\5k\66\2\u00c2\u00c3\5\u0087D\2\u00c3\u00c4\5i\65\2\u00c4\u00c5\5\u0083"+
		"B\2\u00c5\24\3\2\2\2\u00c6\u00c7\5a\61\2\u00c7\u00c8\5\u0085C\2\u00c8"+
		"\26\3\2\2\2\u00c9\u00ca\5e\63\2\u00ca\u00cb\5}?\2\u00cb\u00cc\5y=\2\u00cc"+
		"\u00cd\5\177@\2\u00cd\u00ce\5\u0083B\2\u00ce\u00cf\5i\65\2\u00cf\u00d0"+
		"\5\u0085C\2\u00d0\u00d1\5\u0085C\2\u00d1\u00d2\5q9\2\u00d2\u00d3\5}?\2"+
		"\u00d3\u00d4\5{>\2\u00d4\30\3\2\2\2\u00d5\u00d6\5{>\2\u00d6\u00d7\5}?"+
		"\2\u00d7\u00d8\5{>\2\u00d8\u00d9\5i\65\2\u00d9\32\3\2\2\2\u00da\u00db"+
		"\5c\62\2\u00db\u00dc\5i\65\2\u00dc\u00dd\5\u0085C\2\u00dd\u00de\5\u0087"+
		"D\2\u00de\34\3\2\2\2\u00df\u00e0\5\u0085C\2\u00e0\u00e1\5\177@\2\u00e1"+
		"\u00e2\5i\65\2\u00e2\u00e3\5i\65\2\u00e3\u00e4\5g\64\2\u00e4\36\3\2\2"+
		"\2\u00e5\u00e6\5}?\2\u00e6\u00e7\5{>\2\u00e7 \3\2\2\2\u00e8\u00e9\5}?"+
		"\2\u00e9\u00ea\5k\66\2\u00ea\u00eb\5k\66\2\u00eb\"\3\2\2\2\u00ec\u00ed"+
		"\5g\64\2\u00ed\u00ee\5i\65\2\u00ee\u00ef\5e\63\2\u00ef\u00f0\5w<\2\u00f0"+
		"\u00f1\5a\61\2\u00f1\u00f2\5\u0083B\2\u00f2\u00f3\5i\65\2\u00f3$\3\2\2"+
		"\2\u00f4\u00f5\5\177@\2\u00f5\u00f6\5\u0083B\2\u00f6\u00f7\5}?\2\u00f7"+
		"\u00f8\5e\63\2\u00f8\u00f9\5i\65\2\u00f9\u00fa\5g\64\2\u00fa\u00fb\5\u0089"+
		"E\2\u00fb\u00fc\5\u0083B\2\u00fc\u00fd\5i\65\2\u00fd&\3\2\2\2\u00fe\u00ff"+
		"\5k\66\2\u00ff\u0100\5}?\2\u0100\u0101\5\u0083B\2\u0101(\3\2\2\2\u0102"+
		"\u0103\5e\63\2\u0103\u0104\5}?\2\u0104\u0105\5{>\2\u0105\u0106\5{>\2\u0106"+
		"\u0107\5i\65\2\u0107\u0108\5e\63\2\u0108\u0109\5\u0087D\2\u0109*\3\2\2"+
		"\2\u010a\u010b\5\u0087D\2\u010b\u010c\5}?\2\u010c,\3\2\2\2\u010d\u010e"+
		"\5\u0089E\2\u010e\u010f\5\u0085C\2\u010f\u0110\5i\65\2\u0110\u0111\5\u0083"+
		"B\2\u0111.\3\2\2\2\u0112\u0113\5\177@\2\u0113\u0114\5a\61\2\u0114\u0115"+
		"\5\u0085C\2\u0115\u0116\5\u0085C\2\u0116\u0117\5\u008dG\2\u0117\u0118"+
		"\5}?\2\u0118\u0119\5\u0083B\2\u0119\u011a\5g\64\2\u011a\60\3\2\2\2\u011b"+
		"\u011c\5\177@\2\u011c\u011d\5\u0083B\2\u011d\u011e\5}?\2\u011e\u011f\5"+
		"\177@\2\u011f\u0120\5i\65\2\u0120\u0121\5\u0083B\2\u0121\u0122\5\u0087"+
		"D\2\u0122\u0123\5q9\2\u0123\u0124\5i\65\2\u0124\u0125\5\u0085C\2\u0125"+
		"\62\3\2\2\2\u0126\u0127\5g\64\2\u0127\u0128\5\u0083B\2\u0128\u0129\5q"+
		"9\2\u0129\u012a\5\u008bF\2\u012a\u012b\5i\65\2\u012b\u012c\5\u0083B\2"+
		"\u012c\64\3\2\2\2\u012d\u012e\5w<\2\u012e\u012f\5q9\2\u012f\u0130\5c\62"+
		"\2\u0130\66\3\2\2\2\u0131\u0132\5e\63\2\u0132\u0133\5}?\2\u0133\u0134"+
		"\5{>\2\u0134\u0135\5{>\2\u0135\u0136\5i\65\2\u0136\u0137\5e\63\2\u0137"+
		"\u0138\5\u0087D\2\u0138\u0139\5q9\2\u0139\u013a\5}?\2\u013a\u013b\5{>"+
		"\2\u013b8\3\2\2\2\u013c\u013d\5\177@\2\u013d\u013e\5}?\2\u013e\u013f\5"+
		"}?\2\u013f\u0140\5w<\2\u0140:\3\2\2\2\u0141\u0142\5\u0085C\2\u0142\u0143"+
		"\5q9\2\u0143\u0144\5\u0093J\2\u0144\u0145\5i\65\2\u0145<\3\2\2\2\u0146"+
		"\u0147\5y=\2\u0147\u0148\5q9\2\u0148\u0149\5{>\2\u0149>\3\2\2\2\u014a"+
		"\u014b\5y=\2\u014b\u014c\5a\61\2\u014c\u014d\5\u008fH\2\u014d@\3\2\2\2"+
		"\u014e\u014f\5\u0085C\2\u014f\u0150\5\u008dG\2\u0150\u0151\5q9\2\u0151"+
		"\u0152\5\u0087D\2\u0152\u0153\5e\63\2\u0153\u0154\5o8\2\u0154B\3\2\2\2"+
		"\u0155\u0156\5w<\2\u0156\u0157\5}?\2\u0157\u0158\5m\67\2\u0158\u0159\5"+
		"q9\2\u0159\u015a\5{>\2\u015aD\3\2\2\2\u015b\u015c\5q9\2\u015c\u015d\5"+
		"k\66\2\u015dF\3\2\2\2\u015e\u015f\5i\65\2\u015f\u0160\5\u008fH\2\u0160"+
		"\u0161\5q9\2\u0161\u0162\5\u0085C\2\u0162\u0163\5\u0087D\2\u0163\u0164"+
		"\5\u0085C\2\u0164H\3\2\2\2\u0165\u0166\5\u0085C\2\u0166\u0167\5e\63\2"+
		"\u0167\u0168\5o8\2\u0168\u0169\5i\65\2\u0169\u016a\5g\64\2\u016a\u016b"+
		"\5\u0089E\2\u016b\u016c\5w<\2\u016c\u016d\5i\65\2\u016dJ\3\2\2\2\u016e"+
		"\u016f\5a\61\2\u016f\u0170\5\u0087D\2\u0170L\3\2\2\2\u0171\u0172\5q9\2"+
		"\u0172\u0173\5{>\2\u0173\u0174\5e\63\2\u0174\u0175\5w<\2\u0175\u0176\5"+
		"\u0089E\2\u0176\u0177\5g\64\2\u0177\u0178\5i\65\2\u0178N\3\2\2\2\u0179"+
		"\u017a\5k\66\2\u017a\u017b\5q9\2\u017b\u017c\5w<\2\u017c\u017d\5i\65\2"+
		"\u017dP\3\2\2\2\u017e\u0184\7$\2\2\u017f\u0183\n\2\2\2\u0180\u0181\7$"+
		"\2\2\u0181\u0183\7$\2\2\u0182\u017f\3\2\2\2\u0182\u0180\3\2\2\2\u0183"+
		"\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2"+
		"\2\2\u0186\u0184\3\2\2\2\u0187\u01a2\7$\2\2\u0188\u018e\7b\2\2\u0189\u018d"+
		"\n\3\2\2\u018a\u018b\7b\2\2\u018b\u018d\7b\2\2\u018c\u0189\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2"+
		"\2\2\u018f\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u01a2\7b\2\2\u0192"+
		"\u0196\7]\2\2\u0193\u0195\n\4\2\2\u0194\u0193\3\2\2\2\u0195\u0198\3\2"+
		"\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199\3\2\2\2\u0198"+
		"\u0196\3\2\2\2\u0199\u01a2\7_\2\2\u019a\u019e\t\5\2\2\u019b\u019d\t\6"+
		"\2\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u017e\3\2"+
		"\2\2\u01a1\u0188\3\2\2\2\u01a1\u0192\3\2\2\2\u01a1\u019a\3\2\2\2\u01a2"+
		"R\3\2\2\2\u01a3\u01a5\5_\60\2\u01a4\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2"+
		"\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01af\3\2\2\2\u01a8\u01ac"+
		"\7\60\2\2\u01a9\u01ab\5_\60\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2"+
		"\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac"+
		"\3\2\2\2\u01af\u01a8\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01ba\3\2\2\2\u01b1"+
		"\u01b3\5i\65\2\u01b2\u01b4\t\7\2\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2"+
		"\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b7\5_\60\2\u01b6\u01b5\3\2\2\2\u01b7"+
		"\u01b8\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bb\3\2"+
		"\2\2\u01ba\u01b1\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01ce\3\2\2\2\u01bc"+
		"\u01be\7\60\2\2\u01bd\u01bf\5_\60\2\u01be\u01bd\3\2\2\2\u01bf\u01c0\3"+
		"\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01cb\3\2\2\2\u01c2"+
		"\u01c4\5i\65\2\u01c3\u01c5\t\7\2\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c8\5_\60\2\u01c7\u01c6\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\3\2"+
		"\2\2\u01cb\u01c2\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd"+
		"\u01a4\3\2\2\2\u01cd\u01bc\3\2\2\2\u01ceT\3\2\2\2\u01cf\u01d5\7)\2\2\u01d0"+
		"\u01d4\n\b\2\2\u01d1\u01d2\7)\2\2\u01d2\u01d4\7)\2\2\u01d3\u01d0\3\2\2"+
		"\2\u01d3\u01d1\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6"+
		"\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01d9\7)\2\2\u01d9"+
		"V\3\2\2\2\u01da\u01db\7/\2\2\u01db\u01dc\7/\2\2\u01dc\u01e0\3\2\2\2\u01dd"+
		"\u01df\n\t\2\2\u01de\u01dd\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2"+
		"\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3"+
		"\u01e4\b,\2\2\u01e4X\3\2\2\2\u01e5\u01e6\7\61\2\2\u01e6\u01e7\7,\2\2\u01e7"+
		"\u01eb\3\2\2\2\u01e8\u01ea\13\2\2\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3"+
		"\2\2\2\u01eb\u01ec\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01f1\3\2\2\2\u01ed"+
		"\u01eb\3\2\2\2\u01ee\u01ef\7,\2\2\u01ef\u01f2\7\61\2\2\u01f0\u01f2\7\2"+
		"\2\3\u01f1\u01ee\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3"+
		"\u01f4\b-\2\2\u01f4Z\3\2\2\2\u01f5\u01f6\t\n\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f8\b.\2\2\u01f8\\\3\2\2\2\u01f9\u01fa\13\2\2\2\u01fa^\3\2\2\2\u01fb"+
		"\u01fc\t\13\2\2\u01fc`\3\2\2\2\u01fd\u01fe\t\f\2\2\u01feb\3\2\2\2\u01ff"+
		"\u0200\t\r\2\2\u0200d\3\2\2\2\u0201\u0202\t\16\2\2\u0202f\3\2\2\2\u0203"+
		"\u0204\t\17\2\2\u0204h\3\2\2\2\u0205\u0206\t\20\2\2\u0206j\3\2\2\2\u0207"+
		"\u0208\t\21\2\2\u0208l\3\2\2\2\u0209\u020a\t\22\2\2\u020an\3\2\2\2\u020b"+
		"\u020c\t\23\2\2\u020cp\3\2\2\2\u020d\u020e\t\24\2\2\u020er\3\2\2\2\u020f"+
		"\u0210\t\25\2\2\u0210t\3\2\2\2\u0211\u0212\t\26\2\2\u0212v\3\2\2\2\u0213"+
		"\u0214\t\27\2\2\u0214x\3\2\2\2\u0215\u0216\t\30\2\2\u0216z\3\2\2\2\u0217"+
		"\u0218\t\31\2\2\u0218|\3\2\2\2\u0219\u021a\t\32\2\2\u021a~\3\2\2\2\u021b"+
		"\u021c\t\33\2\2\u021c\u0080\3\2\2\2\u021d\u021e\t\34\2\2\u021e\u0082\3"+
		"\2\2\2\u021f\u0220\t\35\2\2\u0220\u0084\3\2\2\2\u0221\u0222\t\36\2\2\u0222"+
		"\u0086\3\2\2\2\u0223\u0224\t\37\2\2\u0224\u0088\3\2\2\2\u0225\u0226\t"+
		" \2\2\u0226\u008a\3\2\2\2\u0227\u0228\t!\2\2\u0228\u008c\3\2\2\2\u0229"+
		"\u022a\t\"\2\2\u022a\u008e\3\2\2\2\u022b\u022c\t#\2\2\u022c\u0090\3\2"+
		"\2\2\u022d\u022e\t$\2\2\u022e\u0092\3\2\2\2\u022f\u0230\t%\2\2\u0230\u0094"+
		"\3\2\2\2\32\2\u0182\u0184\u018c\u018e\u0196\u019e\u01a1\u01a6\u01ac\u01af"+
		"\u01b3\u01b8\u01ba\u01c0\u01c4\u01c9\u01cb\u01cd\u01d3\u01d5\u01e0\u01eb"+
		"\u01f1\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}