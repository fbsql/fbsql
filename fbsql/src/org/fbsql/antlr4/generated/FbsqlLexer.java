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
		T__0=1, T__1=2, T__2=3, EXPOSE=4, STATIC=5, ROLES=6, TRIGGER=7, BEFORE=8, 
		AFTER=9, AS=10, COMPRESSION=11, NONE=12, BEST=13, SPEED=14, DECLARE=15, 
		PROCEDURE=16, FOR=17, STATEMENT=18, CONNECT=19, TO=20, USER=21, PASSWORD=22, 
		PROPERTIES=23, DRIVER=24, LIB=25, CONNECTION=26, POOL=27, SIZE=28, MIN=29, 
		MAX=30, STATEMENTS=31, ALL=32, DECLARED=33, CONNECTIONS=34, ALLOW=35, 
		REJECT=36, IF=37, EXISTS=38, SWITCH=39, SCHEDULE=40, AT=41, INCLUDE=42, 
		FILE=43, IDENTIFIER=44, NUMERIC_LITERAL=45, STRING_LITERAL=46, SINGLE_LINE_COMMENT=47, 
		MULTILINE_COMMENT=48, SPACES=49, UNEXPECTED_CHAR=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "EXPOSE", "STATIC", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "COMPRESSION", "NONE", "BEST", "SPEED", "DECLARE", "PROCEDURE", 
			"FOR", "STATEMENT", "CONNECT", "TO", "USER", "PASSWORD", "PROPERTIES", 
			"DRIVER", "LIB", "CONNECTION", "POOL", "SIZE", "MIN", "MAX", "STATEMENTS", 
			"ALL", "DECLARED", "CONNECTIONS", "ALLOW", "REJECT", "IF", "EXISTS", 
			"SWITCH", "SCHEDULE", "AT", "INCLUDE", "FILE", "IDENTIFIER", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
			"UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", 
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
			"X", "Y", "Z"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0265\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3"+
		"%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		",\3-\3-\3-\3-\7-\u01b7\n-\f-\16-\u01ba\13-\3-\3-\3-\3-\3-\7-\u01c1\n-"+
		"\f-\16-\u01c4\13-\3-\3-\3-\7-\u01c9\n-\f-\16-\u01cc\13-\3-\3-\3-\7-\u01d1"+
		"\n-\f-\16-\u01d4\13-\5-\u01d6\n-\3.\6.\u01d9\n.\r.\16.\u01da\3.\3.\7."+
		"\u01df\n.\f.\16.\u01e2\13.\5.\u01e4\n.\3.\3.\5.\u01e8\n.\3.\6.\u01eb\n"+
		".\r.\16.\u01ec\5.\u01ef\n.\3.\3.\6.\u01f3\n.\r.\16.\u01f4\3.\3.\5.\u01f9"+
		"\n.\3.\6.\u01fc\n.\r.\16.\u01fd\5.\u0200\n.\5.\u0202\n.\3/\3/\3/\3/\7"+
		"/\u0208\n/\f/\16/\u020b\13/\3/\3/\3\60\3\60\3\60\3\60\7\60\u0213\n\60"+
		"\f\60\16\60\u0216\13\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u021e\n\61"+
		"\f\61\16\61\u0221\13\61\3\61\3\61\3\61\5\61\u0226\n\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\3"+
		"8\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3"+
		"D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3\u021f"+
		"\2O\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\2m\2"+
		"o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2"+
		"\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b"+
		"\2\3\2&\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\4\2"+
		"\f\f\17\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff"+
		"\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2O"+
		"Ooo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4"+
		"\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0262\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\3\u009d\3\2\2\2\5\u009f\3\2\2\2\7\u00a1\3\2\2\2\t\u00a3\3\2\2\2"+
		"\13\u00aa\3\2\2\2\r\u00b1\3\2\2\2\17\u00b7\3\2\2\2\21\u00bf\3\2\2\2\23"+
		"\u00c6\3\2\2\2\25\u00cc\3\2\2\2\27\u00cf\3\2\2\2\31\u00db\3\2\2\2\33\u00e0"+
		"\3\2\2\2\35\u00e5\3\2\2\2\37\u00eb\3\2\2\2!\u00f3\3\2\2\2#\u00fd\3\2\2"+
		"\2%\u0101\3\2\2\2\'\u010b\3\2\2\2)\u0113\3\2\2\2+\u0116\3\2\2\2-\u011b"+
		"\3\2\2\2/\u0124\3\2\2\2\61\u012f\3\2\2\2\63\u0136\3\2\2\2\65\u013a\3\2"+
		"\2\2\67\u0145\3\2\2\29\u014a\3\2\2\2;\u014f\3\2\2\2=\u0153\3\2\2\2?\u0157"+
		"\3\2\2\2A\u0162\3\2\2\2C\u0166\3\2\2\2E\u016f\3\2\2\2G\u017b\3\2\2\2I"+
		"\u0181\3\2\2\2K\u0188\3\2\2\2M\u018b\3\2\2\2O\u0192\3\2\2\2Q\u0199\3\2"+
		"\2\2S\u01a2\3\2\2\2U\u01a5\3\2\2\2W\u01ad\3\2\2\2Y\u01d5\3\2\2\2[\u0201"+
		"\3\2\2\2]\u0203\3\2\2\2_\u020e\3\2\2\2a\u0219\3\2\2\2c\u0229\3\2\2\2e"+
		"\u022d\3\2\2\2g\u022f\3\2\2\2i\u0231\3\2\2\2k\u0233\3\2\2\2m\u0235\3\2"+
		"\2\2o\u0237\3\2\2\2q\u0239\3\2\2\2s\u023b\3\2\2\2u\u023d\3\2\2\2w\u023f"+
		"\3\2\2\2y\u0241\3\2\2\2{\u0243\3\2\2\2}\u0245\3\2\2\2\177\u0247\3\2\2"+
		"\2\u0081\u0249\3\2\2\2\u0083\u024b\3\2\2\2\u0085\u024d\3\2\2\2\u0087\u024f"+
		"\3\2\2\2\u0089\u0251\3\2\2\2\u008b\u0253\3\2\2\2\u008d\u0255\3\2\2\2\u008f"+
		"\u0257\3\2\2\2\u0091\u0259\3\2\2\2\u0093\u025b\3\2\2\2\u0095\u025d\3\2"+
		"\2\2\u0097\u025f\3\2\2\2\u0099\u0261\3\2\2\2\u009b\u0263\3\2\2\2\u009d"+
		"\u009e\7.\2\2\u009e\4\3\2\2\2\u009f\u00a0\7*\2\2\u00a0\6\3\2\2\2\u00a1"+
		"\u00a2\7+\2\2\u00a2\b\3\2\2\2\u00a3\u00a4\5q9\2\u00a4\u00a5\5\u0097L\2"+
		"\u00a5\u00a6\5\u0087D\2\u00a6\u00a7\5\u0085C\2\u00a7\u00a8\5\u008dG\2"+
		"\u00a8\u00a9\5q9\2\u00a9\n\3\2\2\2\u00aa\u00ab\5\u008dG\2\u00ab\u00ac"+
		"\5\u008fH\2\u00ac\u00ad\5i\65\2\u00ad\u00ae\5\u008fH\2\u00ae\u00af\5y"+
		"=\2\u00af\u00b0\5m\67\2\u00b0\f\3\2\2\2\u00b1\u00b2\5\u008bF\2\u00b2\u00b3"+
		"\5\u0085C\2\u00b3\u00b4\5\177@\2\u00b4\u00b5\5q9\2\u00b5\u00b6\5\u008d"+
		"G\2\u00b6\16\3\2\2\2\u00b7\u00b8\5\u008fH\2\u00b8\u00b9\5\u008bF\2\u00b9"+
		"\u00ba\5y=\2\u00ba\u00bb\5u;\2\u00bb\u00bc\5u;\2\u00bc\u00bd\5q9\2\u00bd"+
		"\u00be\5\u008bF\2\u00be\20\3\2\2\2\u00bf\u00c0\5k\66\2\u00c0\u00c1\5q"+
		"9\2\u00c1\u00c2\5s:\2\u00c2\u00c3\5\u0085C\2\u00c3\u00c4\5\u008bF\2\u00c4"+
		"\u00c5\5q9\2\u00c5\22\3\2\2\2\u00c6\u00c7\5i\65\2\u00c7\u00c8\5s:\2\u00c8"+
		"\u00c9\5\u008fH\2\u00c9\u00ca\5q9\2\u00ca\u00cb\5\u008bF\2\u00cb\24\3"+
		"\2\2\2\u00cc\u00cd\5i\65\2\u00cd\u00ce\5\u008dG\2\u00ce\26\3\2\2\2\u00cf"+
		"\u00d0\5m\67\2\u00d0\u00d1\5\u0085C\2\u00d1\u00d2\5\u0081A\2\u00d2\u00d3"+
		"\5\u0087D\2\u00d3\u00d4\5\u008bF\2\u00d4\u00d5\5q9\2\u00d5\u00d6\5\u008d"+
		"G\2\u00d6\u00d7\5\u008dG\2\u00d7\u00d8\5y=\2\u00d8\u00d9\5\u0085C\2\u00d9"+
		"\u00da\5\u0083B\2\u00da\30\3\2\2\2\u00db\u00dc\5\u0083B\2\u00dc\u00dd"+
		"\5\u0085C\2\u00dd\u00de\5\u0083B\2\u00de\u00df\5q9\2\u00df\32\3\2\2\2"+
		"\u00e0\u00e1\5k\66\2\u00e1\u00e2\5q9\2\u00e2\u00e3\5\u008dG\2\u00e3\u00e4"+
		"\5\u008fH\2\u00e4\34\3\2\2\2\u00e5\u00e6\5\u008dG\2\u00e6\u00e7\5\u0087"+
		"D\2\u00e7\u00e8\5q9\2\u00e8\u00e9\5q9\2\u00e9\u00ea\5o8\2\u00ea\36\3\2"+
		"\2\2\u00eb\u00ec\5o8\2\u00ec\u00ed\5q9\2\u00ed\u00ee\5m\67\2\u00ee\u00ef"+
		"\5\177@\2\u00ef\u00f0\5i\65\2\u00f0\u00f1\5\u008bF\2\u00f1\u00f2\5q9\2"+
		"\u00f2 \3\2\2\2\u00f3\u00f4\5\u0087D\2\u00f4\u00f5\5\u008bF\2\u00f5\u00f6"+
		"\5\u0085C\2\u00f6\u00f7\5m\67\2\u00f7\u00f8\5q9\2\u00f8\u00f9\5o8\2\u00f9"+
		"\u00fa\5\u0091I\2\u00fa\u00fb\5\u008bF\2\u00fb\u00fc\5q9\2\u00fc\"\3\2"+
		"\2\2\u00fd\u00fe\5s:\2\u00fe\u00ff\5\u0085C\2\u00ff\u0100\5\u008bF\2\u0100"+
		"$\3\2\2\2\u0101\u0102\5\u008dG\2\u0102\u0103\5\u008fH\2\u0103\u0104\5"+
		"i\65\2\u0104\u0105\5\u008fH\2\u0105\u0106\5q9\2\u0106\u0107\5\u0081A\2"+
		"\u0107\u0108\5q9\2\u0108\u0109\5\u0083B\2\u0109\u010a\5\u008fH\2\u010a"+
		"&\3\2\2\2\u010b\u010c\5m\67\2\u010c\u010d\5\u0085C\2\u010d\u010e\5\u0083"+
		"B\2\u010e\u010f\5\u0083B\2\u010f\u0110\5q9\2\u0110\u0111\5m\67\2\u0111"+
		"\u0112\5\u008fH\2\u0112(\3\2\2\2\u0113\u0114\5\u008fH\2\u0114\u0115\5"+
		"\u0085C\2\u0115*\3\2\2\2\u0116\u0117\5\u0091I\2\u0117\u0118\5\u008dG\2"+
		"\u0118\u0119\5q9\2\u0119\u011a\5\u008bF\2\u011a,\3\2\2\2\u011b\u011c\5"+
		"\u0087D\2\u011c\u011d\5i\65\2\u011d\u011e\5\u008dG\2\u011e\u011f\5\u008d"+
		"G\2\u011f\u0120\5\u0095K\2\u0120\u0121\5\u0085C\2\u0121\u0122\5\u008b"+
		"F\2\u0122\u0123\5o8\2\u0123.\3\2\2\2\u0124\u0125\5\u0087D\2\u0125\u0126"+
		"\5\u008bF\2\u0126\u0127\5\u0085C\2\u0127\u0128\5\u0087D\2\u0128\u0129"+
		"\5q9\2\u0129\u012a\5\u008bF\2\u012a\u012b\5\u008fH\2\u012b\u012c\5y=\2"+
		"\u012c\u012d\5q9\2\u012d\u012e\5\u008dG\2\u012e\60\3\2\2\2\u012f\u0130"+
		"\5o8\2\u0130\u0131\5\u008bF\2\u0131\u0132\5y=\2\u0132\u0133\5\u0093J\2"+
		"\u0133\u0134\5q9\2\u0134\u0135\5\u008bF\2\u0135\62\3\2\2\2\u0136\u0137"+
		"\5\177@\2\u0137\u0138\5y=\2\u0138\u0139\5k\66\2\u0139\64\3\2\2\2\u013a"+
		"\u013b\5m\67\2\u013b\u013c\5\u0085C\2\u013c\u013d\5\u0083B\2\u013d\u013e"+
		"\5\u0083B\2\u013e\u013f\5q9\2\u013f\u0140\5m\67\2\u0140\u0141\5\u008f"+
		"H\2\u0141\u0142\5y=\2\u0142\u0143\5\u0085C\2\u0143\u0144\5\u0083B\2\u0144"+
		"\66\3\2\2\2\u0145\u0146\5\u0087D\2\u0146\u0147\5\u0085C\2\u0147\u0148"+
		"\5\u0085C\2\u0148\u0149\5\177@\2\u01498\3\2\2\2\u014a\u014b\5\u008dG\2"+
		"\u014b\u014c\5y=\2\u014c\u014d\5\u009bN\2\u014d\u014e\5q9\2\u014e:\3\2"+
		"\2\2\u014f\u0150\5\u0081A\2\u0150\u0151\5y=\2\u0151\u0152\5\u0083B\2\u0152"+
		"<\3\2\2\2\u0153\u0154\5\u0081A\2\u0154\u0155\5i\65\2\u0155\u0156\5\u0097"+
		"L\2\u0156>\3\2\2\2\u0157\u0158\5\u008dG\2\u0158\u0159\5\u008fH\2\u0159"+
		"\u015a\5i\65\2\u015a\u015b\5\u008fH\2\u015b\u015c\5q9\2\u015c\u015d\5"+
		"\u0081A\2\u015d\u015e\5q9\2\u015e\u015f\5\u0083B\2\u015f\u0160\5\u008f"+
		"H\2\u0160\u0161\5\u008dG\2\u0161@\3\2\2\2\u0162\u0163\5i\65\2\u0163\u0164"+
		"\5\177@\2\u0164\u0165\5\177@\2\u0165B\3\2\2\2\u0166\u0167\5o8\2\u0167"+
		"\u0168\5q9\2\u0168\u0169\5m\67\2\u0169\u016a\5\177@\2\u016a\u016b\5i\65"+
		"\2\u016b\u016c\5\u008bF\2\u016c\u016d\5q9\2\u016d\u016e\5o8\2\u016eD\3"+
		"\2\2\2\u016f\u0170\5m\67\2\u0170\u0171\5\u0085C\2\u0171\u0172\5\u0083"+
		"B\2\u0172\u0173\5\u0083B\2\u0173\u0174\5q9\2\u0174\u0175\5m\67\2\u0175"+
		"\u0176\5\u008fH\2\u0176\u0177\5y=\2\u0177\u0178\5\u0085C\2\u0178\u0179"+
		"\5\u0083B\2\u0179\u017a\5\u008dG\2\u017aF\3\2\2\2\u017b\u017c\5i\65\2"+
		"\u017c\u017d\5\177@\2\u017d\u017e\5\177@\2\u017e\u017f\5\u0085C\2\u017f"+
		"\u0180\5\u0095K\2\u0180H\3\2\2\2\u0181\u0182\5\u008bF\2\u0182\u0183\5"+
		"q9\2\u0183\u0184\5{>\2\u0184\u0185\5q9\2\u0185\u0186\5m\67\2\u0186\u0187"+
		"\5\u008fH\2\u0187J\3\2\2\2\u0188\u0189\5y=\2\u0189\u018a\5s:\2\u018aL"+
		"\3\2\2\2\u018b\u018c\5q9\2\u018c\u018d\5\u0097L\2\u018d\u018e\5y=\2\u018e"+
		"\u018f\5\u008dG\2\u018f\u0190\5\u008fH\2\u0190\u0191\5\u008dG\2\u0191"+
		"N\3\2\2\2\u0192\u0193\5\u008dG\2\u0193\u0194\5\u0095K\2\u0194\u0195\5"+
		"y=\2\u0195\u0196\5\u008fH\2\u0196\u0197\5m\67\2\u0197\u0198\5w<\2\u0198"+
		"P\3\2\2\2\u0199\u019a\5\u008dG\2\u019a\u019b\5m\67\2\u019b\u019c\5w<\2"+
		"\u019c\u019d\5q9\2\u019d\u019e\5o8\2\u019e\u019f\5\u0091I\2\u019f\u01a0"+
		"\5\177@\2\u01a0\u01a1\5q9\2\u01a1R\3\2\2\2\u01a2\u01a3\5i\65\2\u01a3\u01a4"+
		"\5\u008fH\2\u01a4T\3\2\2\2\u01a5\u01a6\5y=\2\u01a6\u01a7\5\u0083B\2\u01a7"+
		"\u01a8\5m\67\2\u01a8\u01a9\5\177@\2\u01a9\u01aa\5\u0091I\2\u01aa\u01ab"+
		"\5o8\2\u01ab\u01ac\5q9\2\u01acV\3\2\2\2\u01ad\u01ae\5s:\2\u01ae\u01af"+
		"\5y=\2\u01af\u01b0\5\177@\2\u01b0\u01b1\5q9\2\u01b1X\3\2\2\2\u01b2\u01b8"+
		"\7$\2\2\u01b3\u01b7\n\2\2\2\u01b4\u01b5\7$\2\2\u01b5\u01b7\7$\2\2\u01b6"+
		"\u01b3\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb"+
		"\u01d6\7$\2\2\u01bc\u01c2\7b\2\2\u01bd\u01c1\n\3\2\2\u01be\u01bf\7b\2"+
		"\2\u01bf\u01c1\7b\2\2\u01c0\u01bd\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c4"+
		"\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c5\u01d6\7b\2\2\u01c6\u01ca\7]\2\2\u01c7\u01c9\n\4\2"+
		"\2\u01c8\u01c7\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb"+
		"\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01d6\7_\2\2\u01ce"+
		"\u01d2\t\5\2\2\u01cf\u01d1\t\6\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2"+
		"\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4"+
		"\u01d2\3\2\2\2\u01d5\u01b2\3\2\2\2\u01d5\u01bc\3\2\2\2\u01d5\u01c6\3\2"+
		"\2\2\u01d5\u01ce\3\2\2\2\u01d6Z\3\2\2\2\u01d7\u01d9\5g\64\2\u01d8\u01d7"+
		"\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01e3\3\2\2\2\u01dc\u01e0\7\60\2\2\u01dd\u01df\5g\64\2\u01de\u01dd\3"+
		"\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1"+
		"\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01dc\3\2\2\2\u01e3\u01e4\3\2"+
		"\2\2\u01e4\u01ee\3\2\2\2\u01e5\u01e7\5q9\2\u01e6\u01e8\t\7\2\2\u01e7\u01e6"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01eb\5g\64\2\u01ea"+
		"\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01ef\3\2\2\2\u01ee\u01e5\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u0202\3\2\2\2\u01f0\u01f2\7\60\2\2\u01f1\u01f3\5g\64\2\u01f2\u01f1\3"+
		"\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5"+
		"\u01ff\3\2\2\2\u01f6\u01f8\5q9\2\u01f7\u01f9\t\7\2\2\u01f8\u01f7\3\2\2"+
		"\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\3\2\2\2\u01fa\u01fc\5g\64\2\u01fb\u01fa"+
		"\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u0200\3\2\2\2\u01ff\u01f6\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0202\3\2"+
		"\2\2\u0201\u01d8\3\2\2\2\u0201\u01f0\3\2\2\2\u0202\\\3\2\2\2\u0203\u0209"+
		"\7)\2\2\u0204\u0208\n\b\2\2\u0205\u0206\7)\2\2\u0206\u0208\7)\2\2\u0207"+
		"\u0204\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207\3\2"+
		"\2\2\u0209\u020a\3\2\2\2\u020a\u020c\3\2\2\2\u020b\u0209\3\2\2\2\u020c"+
		"\u020d\7)\2\2\u020d^\3\2\2\2\u020e\u020f\7/\2\2\u020f\u0210\7/\2\2\u0210"+
		"\u0214\3\2\2\2\u0211\u0213\n\t\2\2\u0212\u0211\3\2\2\2\u0213\u0216\3\2"+
		"\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\3\2\2\2\u0216"+
		"\u0214\3\2\2\2\u0217\u0218\b\60\2\2\u0218`\3\2\2\2\u0219\u021a\7\61\2"+
		"\2\u021a\u021b\7,\2\2\u021b\u021f\3\2\2\2\u021c\u021e\13\2\2\2\u021d\u021c"+
		"\3\2\2\2\u021e\u0221\3\2\2\2\u021f\u0220\3\2\2\2\u021f\u021d\3\2\2\2\u0220"+
		"\u0225\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0223\7,\2\2\u0223\u0226\7\61"+
		"\2\2\u0224\u0226\7\2\2\3\u0225\u0222\3\2\2\2\u0225\u0224\3\2\2\2\u0226"+
		"\u0227\3\2\2\2\u0227\u0228\b\61\2\2\u0228b\3\2\2\2\u0229\u022a\t\n\2\2"+
		"\u022a\u022b\3\2\2\2\u022b\u022c\b\62\2\2\u022cd\3\2\2\2\u022d\u022e\13"+
		"\2\2\2\u022ef\3\2\2\2\u022f\u0230\t\13\2\2\u0230h\3\2\2\2\u0231\u0232"+
		"\t\f\2\2\u0232j\3\2\2\2\u0233\u0234\t\r\2\2\u0234l\3\2\2\2\u0235\u0236"+
		"\t\16\2\2\u0236n\3\2\2\2\u0237\u0238\t\17\2\2\u0238p\3\2\2\2\u0239\u023a"+
		"\t\20\2\2\u023ar\3\2\2\2\u023b\u023c\t\21\2\2\u023ct\3\2\2\2\u023d\u023e"+
		"\t\22\2\2\u023ev\3\2\2\2\u023f\u0240\t\23\2\2\u0240x\3\2\2\2\u0241\u0242"+
		"\t\24\2\2\u0242z\3\2\2\2\u0243\u0244\t\25\2\2\u0244|\3\2\2\2\u0245\u0246"+
		"\t\26\2\2\u0246~\3\2\2\2\u0247\u0248\t\27\2\2\u0248\u0080\3\2\2\2\u0249"+
		"\u024a\t\30\2\2\u024a\u0082\3\2\2\2\u024b\u024c\t\31\2\2\u024c\u0084\3"+
		"\2\2\2\u024d\u024e\t\32\2\2\u024e\u0086\3\2\2\2\u024f\u0250\t\33\2\2\u0250"+
		"\u0088\3\2\2\2\u0251\u0252\t\34\2\2\u0252\u008a\3\2\2\2\u0253\u0254\t"+
		"\35\2\2\u0254\u008c\3\2\2\2\u0255\u0256\t\36\2\2\u0256\u008e\3\2\2\2\u0257"+
		"\u0258\t\37\2\2\u0258\u0090\3\2\2\2\u0259\u025a\t \2\2\u025a\u0092\3\2"+
		"\2\2\u025b\u025c\t!\2\2\u025c\u0094\3\2\2\2\u025d\u025e\t\"\2\2\u025e"+
		"\u0096\3\2\2\2\u025f\u0260\t#\2\2\u0260\u0098\3\2\2\2\u0261\u0262\t$\2"+
		"\2\u0262\u009a\3\2\2\2\u0263\u0264\t%\2\2\u0264\u009c\3\2\2\2\32\2\u01b6"+
		"\u01b8\u01c0\u01c2\u01ca\u01d2\u01d5\u01da\u01e0\u01e3\u01e7\u01ec\u01ee"+
		"\u01f4\u01f8\u01fd\u01ff\u0201\u0207\u0209\u0214\u021f\u0225\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}