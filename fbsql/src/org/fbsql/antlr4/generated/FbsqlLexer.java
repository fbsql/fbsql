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
		T__0=1, T__1=2, T__2=3, K_EXPOSE=4, K_PREFETCH=5, K_ROLES=6, K_TRIGGER=7, 
		K_BEFORE=8, K_AFTER=9, K_AS=10, K_COMPRESSION=11, K_NONE=12, K_BEST=13, 
		K_SPEED=14, K_ON=15, K_OFF=16, K_DECLARE=17, K_PROCEDURE=18, K_FOR=19, 
		K_CONNECT=20, K_TO=21, K_USER=22, K_PASSWORD=23, K_PROPERTIES=24, K_DRIVER=25, 
		K_JAR=26, K_FILES=27, K_CONNECTION=28, K_POOL=29, K_SIZE=30, K_MIN=31, 
		K_MAX=32, K_DEBUG=33, K_SET=34, K_ALLOW=35, K_LOGIN=36, K_IF=37, K_EXISTS=38, 
		K_SCHEDULE=39, K_AT=40, K_INCLUDE=41, K_SCRIPT=42, K_FILE=43, IDENTIFIER=44, 
		NUMERIC_LITERAL=45, STRING_LITERAL=46, SINGLE_LINE_COMMENT=47, MULTILINE_COMMENT=48, 
		SPACES=49, UNEXPECTED_CHAR=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "K_EXPOSE", "K_PREFETCH", "K_ROLES", "K_TRIGGER", 
			"K_BEFORE", "K_AFTER", "K_AS", "K_COMPRESSION", "K_NONE", "K_BEST", "K_SPEED", 
			"K_ON", "K_OFF", "K_DECLARE", "K_PROCEDURE", "K_FOR", "K_CONNECT", "K_TO", 
			"K_USER", "K_PASSWORD", "K_PROPERTIES", "K_DRIVER", "K_JAR", "K_FILES", 
			"K_CONNECTION", "K_POOL", "K_SIZE", "K_MIN", "K_MAX", "K_DEBUG", "K_SET", 
			"K_ALLOW", "K_LOGIN", "K_IF", "K_EXISTS", "K_SCHEDULE", "K_AT", "K_INCLUDE", 
			"K_SCRIPT", "K_FILE", "IDENTIFIER", "NUMERIC_LITERAL", "STRING_LITERAL", 
			"SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR", 
			"DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u024f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%"+
		"\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		")\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3"+
		"-\3-\3-\3-\7-\u01a1\n-\f-\16-\u01a4\13-\3-\3-\3-\3-\3-\7-\u01ab\n-\f-"+
		"\16-\u01ae\13-\3-\3-\3-\7-\u01b3\n-\f-\16-\u01b6\13-\3-\3-\3-\7-\u01bb"+
		"\n-\f-\16-\u01be\13-\5-\u01c0\n-\3.\6.\u01c3\n.\r.\16.\u01c4\3.\3.\7."+
		"\u01c9\n.\f.\16.\u01cc\13.\5.\u01ce\n.\3.\3.\5.\u01d2\n.\3.\6.\u01d5\n"+
		".\r.\16.\u01d6\5.\u01d9\n.\3.\3.\6.\u01dd\n.\r.\16.\u01de\3.\3.\5.\u01e3"+
		"\n.\3.\6.\u01e6\n.\r.\16.\u01e7\5.\u01ea\n.\5.\u01ec\n.\3/\3/\3/\3/\7"+
		"/\u01f2\n/\f/\16/\u01f5\13/\3/\3/\3\60\3\60\3\60\3\60\7\60\u01fd\n\60"+
		"\f\60\16\60\u0200\13\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0208\n\61"+
		"\f\61\16\61\u020b\13\61\3\61\3\61\3\61\5\61\u0210\n\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\3"+
		"8\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3"+
		"D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3\u0209"+
		"\2O\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\2m\2"+
		"o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2"+
		"\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b"+
		"\2\3\2&\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\4\2"+
		"\f\f\17\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff"+
		"\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2O"+
		"Ooo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4"+
		"\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u024c\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\3\u009d\3\2\2\2\5\u009f\3\2\2\2\7\u00a1\3\2\2\2\t\u00a3\3\2\2\2"+
		"\13\u00aa\3\2\2\2\r\u00b3\3\2\2\2\17\u00b9\3\2\2\2\21\u00c1\3\2\2\2\23"+
		"\u00c8\3\2\2\2\25\u00ce\3\2\2\2\27\u00d1\3\2\2\2\31\u00dd\3\2\2\2\33\u00e2"+
		"\3\2\2\2\35\u00e7\3\2\2\2\37\u00ed\3\2\2\2!\u00f0\3\2\2\2#\u00f4\3\2\2"+
		"\2%\u00fc\3\2\2\2\'\u0106\3\2\2\2)\u010a\3\2\2\2+\u0112\3\2\2\2-\u0115"+
		"\3\2\2\2/\u011a\3\2\2\2\61\u0123\3\2\2\2\63\u012e\3\2\2\2\65\u0135\3\2"+
		"\2\2\67\u0139\3\2\2\29\u013f\3\2\2\2;\u014a\3\2\2\2=\u014f\3\2\2\2?\u0154"+
		"\3\2\2\2A\u0158\3\2\2\2C\u015c\3\2\2\2E\u0162\3\2\2\2G\u0166\3\2\2\2I"+
		"\u016c\3\2\2\2K\u0172\3\2\2\2M\u0175\3\2\2\2O\u017c\3\2\2\2Q\u0185\3\2"+
		"\2\2S\u0188\3\2\2\2U\u0190\3\2\2\2W\u0197\3\2\2\2Y\u01bf\3\2\2\2[\u01eb"+
		"\3\2\2\2]\u01ed\3\2\2\2_\u01f8\3\2\2\2a\u0203\3\2\2\2c\u0213\3\2\2\2e"+
		"\u0217\3\2\2\2g\u0219\3\2\2\2i\u021b\3\2\2\2k\u021d\3\2\2\2m\u021f\3\2"+
		"\2\2o\u0221\3\2\2\2q\u0223\3\2\2\2s\u0225\3\2\2\2u\u0227\3\2\2\2w\u0229"+
		"\3\2\2\2y\u022b\3\2\2\2{\u022d\3\2\2\2}\u022f\3\2\2\2\177\u0231\3\2\2"+
		"\2\u0081\u0233\3\2\2\2\u0083\u0235\3\2\2\2\u0085\u0237\3\2\2\2\u0087\u0239"+
		"\3\2\2\2\u0089\u023b\3\2\2\2\u008b\u023d\3\2\2\2\u008d\u023f\3\2\2\2\u008f"+
		"\u0241\3\2\2\2\u0091\u0243\3\2\2\2\u0093\u0245\3\2\2\2\u0095\u0247\3\2"+
		"\2\2\u0097\u0249\3\2\2\2\u0099\u024b\3\2\2\2\u009b\u024d\3\2\2\2\u009d"+
		"\u009e\7*\2\2\u009e\4\3\2\2\2\u009f\u00a0\7+\2\2\u00a0\6\3\2\2\2\u00a1"+
		"\u00a2\7.\2\2\u00a2\b\3\2\2\2\u00a3\u00a4\5q9\2\u00a4\u00a5\5\u0097L\2"+
		"\u00a5\u00a6\5\u0087D\2\u00a6\u00a7\5\u0085C\2\u00a7\u00a8\5\u008dG\2"+
		"\u00a8\u00a9\5q9\2\u00a9\n\3\2\2\2\u00aa\u00ab\5\u0087D\2\u00ab\u00ac"+
		"\5\u008bF\2\u00ac\u00ad\5q9\2\u00ad\u00ae\5s:\2\u00ae\u00af\5q9\2\u00af"+
		"\u00b0\5\u008fH\2\u00b0\u00b1\5m\67\2\u00b1\u00b2\5w<\2\u00b2\f\3\2\2"+
		"\2\u00b3\u00b4\5\u008bF\2\u00b4\u00b5\5\u0085C\2\u00b5\u00b6\5\177@\2"+
		"\u00b6\u00b7\5q9\2\u00b7\u00b8\5\u008dG\2\u00b8\16\3\2\2\2\u00b9\u00ba"+
		"\5\u008fH\2\u00ba\u00bb\5\u008bF\2\u00bb\u00bc\5y=\2\u00bc\u00bd\5u;\2"+
		"\u00bd\u00be\5u;\2\u00be\u00bf\5q9\2\u00bf\u00c0\5\u008bF\2\u00c0\20\3"+
		"\2\2\2\u00c1\u00c2\5k\66\2\u00c2\u00c3\5q9\2\u00c3\u00c4\5s:\2\u00c4\u00c5"+
		"\5\u0085C\2\u00c5\u00c6\5\u008bF\2\u00c6\u00c7\5q9\2\u00c7\22\3\2\2\2"+
		"\u00c8\u00c9\5i\65\2\u00c9\u00ca\5s:\2\u00ca\u00cb\5\u008fH\2\u00cb\u00cc"+
		"\5q9\2\u00cc\u00cd\5\u008bF\2\u00cd\24\3\2\2\2\u00ce\u00cf\5i\65\2\u00cf"+
		"\u00d0\5\u008dG\2\u00d0\26\3\2\2\2\u00d1\u00d2\5m\67\2\u00d2\u00d3\5\u0085"+
		"C\2\u00d3\u00d4\5\u0081A\2\u00d4\u00d5\5\u0087D\2\u00d5\u00d6\5\u008b"+
		"F\2\u00d6\u00d7\5q9\2\u00d7\u00d8\5\u008dG\2\u00d8\u00d9\5\u008dG\2\u00d9"+
		"\u00da\5y=\2\u00da\u00db\5\u0085C\2\u00db\u00dc\5\u0083B\2\u00dc\30\3"+
		"\2\2\2\u00dd\u00de\5\u0083B\2\u00de\u00df\5\u0085C\2\u00df\u00e0\5\u0083"+
		"B\2\u00e0\u00e1\5q9\2\u00e1\32\3\2\2\2\u00e2\u00e3\5k\66\2\u00e3\u00e4"+
		"\5q9\2\u00e4\u00e5\5\u008dG\2\u00e5\u00e6\5\u008fH\2\u00e6\34\3\2\2\2"+
		"\u00e7\u00e8\5\u008dG\2\u00e8\u00e9\5\u0087D\2\u00e9\u00ea\5q9\2\u00ea"+
		"\u00eb\5q9\2\u00eb\u00ec\5o8\2\u00ec\36\3\2\2\2\u00ed\u00ee\5\u0085C\2"+
		"\u00ee\u00ef\5\u0083B\2\u00ef \3\2\2\2\u00f0\u00f1\5\u0085C\2\u00f1\u00f2"+
		"\5s:\2\u00f2\u00f3\5s:\2\u00f3\"\3\2\2\2\u00f4\u00f5\5o8\2\u00f5\u00f6"+
		"\5q9\2\u00f6\u00f7\5m\67\2\u00f7\u00f8\5\177@\2\u00f8\u00f9\5i\65\2\u00f9"+
		"\u00fa\5\u008bF\2\u00fa\u00fb\5q9\2\u00fb$\3\2\2\2\u00fc\u00fd\5\u0087"+
		"D\2\u00fd\u00fe\5\u008bF\2\u00fe\u00ff\5\u0085C\2\u00ff\u0100\5m\67\2"+
		"\u0100\u0101\5q9\2\u0101\u0102\5o8\2\u0102\u0103\5\u0091I\2\u0103\u0104"+
		"\5\u008bF\2\u0104\u0105\5q9\2\u0105&\3\2\2\2\u0106\u0107\5s:\2\u0107\u0108"+
		"\5\u0085C\2\u0108\u0109\5\u008bF\2\u0109(\3\2\2\2\u010a\u010b\5m\67\2"+
		"\u010b\u010c\5\u0085C\2\u010c\u010d\5\u0083B\2\u010d\u010e\5\u0083B\2"+
		"\u010e\u010f\5q9\2\u010f\u0110\5m\67\2\u0110\u0111\5\u008fH\2\u0111*\3"+
		"\2\2\2\u0112\u0113\5\u008fH\2\u0113\u0114\5\u0085C\2\u0114,\3\2\2\2\u0115"+
		"\u0116\5\u0091I\2\u0116\u0117\5\u008dG\2\u0117\u0118\5q9\2\u0118\u0119"+
		"\5\u008bF\2\u0119.\3\2\2\2\u011a\u011b\5\u0087D\2\u011b\u011c\5i\65\2"+
		"\u011c\u011d\5\u008dG\2\u011d\u011e\5\u008dG\2\u011e\u011f\5\u0095K\2"+
		"\u011f\u0120\5\u0085C\2\u0120\u0121\5\u008bF\2\u0121\u0122\5o8\2\u0122"+
		"\60\3\2\2\2\u0123\u0124\5\u0087D\2\u0124\u0125\5\u008bF\2\u0125\u0126"+
		"\5\u0085C\2\u0126\u0127\5\u0087D\2\u0127\u0128\5q9\2\u0128\u0129\5\u008b"+
		"F\2\u0129\u012a\5\u008fH\2\u012a\u012b\5y=\2\u012b\u012c\5q9\2\u012c\u012d"+
		"\5\u008dG\2\u012d\62\3\2\2\2\u012e\u012f\5o8\2\u012f\u0130\5\u008bF\2"+
		"\u0130\u0131\5y=\2\u0131\u0132\5\u0093J\2\u0132\u0133\5q9\2\u0133\u0134"+
		"\5\u008bF\2\u0134\64\3\2\2\2\u0135\u0136\5{>\2\u0136\u0137\5i\65\2\u0137"+
		"\u0138\5\u008bF\2\u0138\66\3\2\2\2\u0139\u013a\5s:\2\u013a\u013b\5y=\2"+
		"\u013b\u013c\5\177@\2\u013c\u013d\5q9\2\u013d\u013e\5\u008dG\2\u013e8"+
		"\3\2\2\2\u013f\u0140\5m\67\2\u0140\u0141\5\u0085C\2\u0141\u0142\5\u0083"+
		"B\2\u0142\u0143\5\u0083B\2\u0143\u0144\5q9\2\u0144\u0145\5m\67\2\u0145"+
		"\u0146\5\u008fH\2\u0146\u0147\5y=\2\u0147\u0148\5\u0085C\2\u0148\u0149"+
		"\5\u0083B\2\u0149:\3\2\2\2\u014a\u014b\5\u0087D\2\u014b\u014c\5\u0085"+
		"C\2\u014c\u014d\5\u0085C\2\u014d\u014e\5\177@\2\u014e<\3\2\2\2\u014f\u0150"+
		"\5\u008dG\2\u0150\u0151\5y=\2\u0151\u0152\5\u009bN\2\u0152\u0153\5q9\2"+
		"\u0153>\3\2\2\2\u0154\u0155\5\u0081A\2\u0155\u0156\5y=\2\u0156\u0157\5"+
		"\u0083B\2\u0157@\3\2\2\2\u0158\u0159\5\u0081A\2\u0159\u015a\5i\65\2\u015a"+
		"\u015b\5\u0097L\2\u015bB\3\2\2\2\u015c\u015d\5o8\2\u015d\u015e\5q9\2\u015e"+
		"\u015f\5k\66\2\u015f\u0160\5\u0091I\2\u0160\u0161\5u;\2\u0161D\3\2\2\2"+
		"\u0162\u0163\5\u008dG\2\u0163\u0164\5q9\2\u0164\u0165\5\u008fH\2\u0165"+
		"F\3\2\2\2\u0166\u0167\5i\65\2\u0167\u0168\5\177@\2\u0168\u0169\5\177@"+
		"\2\u0169\u016a\5\u0085C\2\u016a\u016b\5\u0095K\2\u016bH\3\2\2\2\u016c"+
		"\u016d\5\177@\2\u016d\u016e\5\u0085C\2\u016e\u016f\5u;\2\u016f\u0170\5"+
		"y=\2\u0170\u0171\5\u0083B\2\u0171J\3\2\2\2\u0172\u0173\5y=\2\u0173\u0174"+
		"\5s:\2\u0174L\3\2\2\2\u0175\u0176\5q9\2\u0176\u0177\5\u0097L\2\u0177\u0178"+
		"\5y=\2\u0178\u0179\5\u008dG\2\u0179\u017a\5\u008fH\2\u017a\u017b\5\u008d"+
		"G\2\u017bN\3\2\2\2\u017c\u017d\5\u008dG\2\u017d\u017e\5m\67\2\u017e\u017f"+
		"\5w<\2\u017f\u0180\5q9\2\u0180\u0181\5o8\2\u0181\u0182\5\u0091I\2\u0182"+
		"\u0183\5\177@\2\u0183\u0184\5q9\2\u0184P\3\2\2\2\u0185\u0186\5i\65\2\u0186"+
		"\u0187\5\u008fH\2\u0187R\3\2\2\2\u0188\u0189\5y=\2\u0189\u018a\5\u0083"+
		"B\2\u018a\u018b\5m\67\2\u018b\u018c\5\177@\2\u018c\u018d\5\u0091I\2\u018d"+
		"\u018e\5o8\2\u018e\u018f\5q9\2\u018fT\3\2\2\2\u0190\u0191\5\u008dG\2\u0191"+
		"\u0192\5m\67\2\u0192\u0193\5\u008bF\2\u0193\u0194\5y=\2\u0194\u0195\5"+
		"\u0087D\2\u0195\u0196\5\u008fH\2\u0196V\3\2\2\2\u0197\u0198\5s:\2\u0198"+
		"\u0199\5y=\2\u0199\u019a\5\177@\2\u019a\u019b\5q9\2\u019bX\3\2\2\2\u019c"+
		"\u01a2\7$\2\2\u019d\u01a1\n\2\2\2\u019e\u019f\7$\2\2\u019f\u01a1\7$\2"+
		"\2\u01a0\u019d\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0"+
		"\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5"+
		"\u01c0\7$\2\2\u01a6\u01ac\7b\2\2\u01a7\u01ab\n\3\2\2\u01a8\u01a9\7b\2"+
		"\2\u01a9\u01ab\7b\2\2\u01aa\u01a7\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ae"+
		"\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae"+
		"\u01ac\3\2\2\2\u01af\u01c0\7b\2\2\u01b0\u01b4\7]\2\2\u01b1\u01b3\n\4\2"+
		"\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01c0\7_\2\2\u01b8"+
		"\u01bc\t\5\2\2\u01b9\u01bb\t\6\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01be\3\2"+
		"\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be"+
		"\u01bc\3\2\2\2\u01bf\u019c\3\2\2\2\u01bf\u01a6\3\2\2\2\u01bf\u01b0\3\2"+
		"\2\2\u01bf\u01b8\3\2\2\2\u01c0Z\3\2\2\2\u01c1\u01c3\5g\64\2\u01c2\u01c1"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01cd\3\2\2\2\u01c6\u01ca\7\60\2\2\u01c7\u01c9\5g\64\2\u01c8\u01c7\3"+
		"\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01c6\3\2\2\2\u01cd\u01ce\3\2"+
		"\2\2\u01ce\u01d8\3\2\2\2\u01cf\u01d1\5q9\2\u01d0\u01d2\t\7\2\2\u01d1\u01d0"+
		"\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d5\5g\64\2\u01d4"+
		"\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2"+
		"\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01cf\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01ec\3\2\2\2\u01da\u01dc\7\60\2\2\u01db\u01dd\5g\64\2\u01dc\u01db\3"+
		"\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df"+
		"\u01e9\3\2\2\2\u01e0\u01e2\5q9\2\u01e1\u01e3\t\7\2\2\u01e2\u01e1\3\2\2"+
		"\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e6\5g\64\2\u01e5\u01e4"+
		"\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8"+
		"\u01ea\3\2\2\2\u01e9\u01e0\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2"+
		"\2\2\u01eb\u01c2\3\2\2\2\u01eb\u01da\3\2\2\2\u01ec\\\3\2\2\2\u01ed\u01f3"+
		"\7)\2\2\u01ee\u01f2\n\b\2\2\u01ef\u01f0\7)\2\2\u01f0\u01f2\7)\2\2\u01f1"+
		"\u01ee\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f5\3\2\2\2\u01f3\u01f1\3\2"+
		"\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f6\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f6"+
		"\u01f7\7)\2\2\u01f7^\3\2\2\2\u01f8\u01f9\7/\2\2\u01f9\u01fa\7/\2\2\u01fa"+
		"\u01fe\3\2\2\2\u01fb\u01fd\n\t\2\2\u01fc\u01fb\3\2\2\2\u01fd\u0200\3\2"+
		"\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\3\2\2\2\u0200"+
		"\u01fe\3\2\2\2\u0201\u0202\b\60\2\2\u0202`\3\2\2\2\u0203\u0204\7\61\2"+
		"\2\u0204\u0205\7,\2\2\u0205\u0209\3\2\2\2\u0206\u0208\13\2\2\2\u0207\u0206"+
		"\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u020a\3\2\2\2\u0209\u0207\3\2\2\2\u020a"+
		"\u020f\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u020d\7,\2\2\u020d\u0210\7\61"+
		"\2\2\u020e\u0210\7\2\2\3\u020f\u020c\3\2\2\2\u020f\u020e\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\u0212\b\61\2\2\u0212b\3\2\2\2\u0213\u0214\t\n\2\2"+
		"\u0214\u0215\3\2\2\2\u0215\u0216\b\62\2\2\u0216d\3\2\2\2\u0217\u0218\13"+
		"\2\2\2\u0218f\3\2\2\2\u0219\u021a\t\13\2\2\u021ah\3\2\2\2\u021b\u021c"+
		"\t\f\2\2\u021cj\3\2\2\2\u021d\u021e\t\r\2\2\u021el\3\2\2\2\u021f\u0220"+
		"\t\16\2\2\u0220n\3\2\2\2\u0221\u0222\t\17\2\2\u0222p\3\2\2\2\u0223\u0224"+
		"\t\20\2\2\u0224r\3\2\2\2\u0225\u0226\t\21\2\2\u0226t\3\2\2\2\u0227\u0228"+
		"\t\22\2\2\u0228v\3\2\2\2\u0229\u022a\t\23\2\2\u022ax\3\2\2\2\u022b\u022c"+
		"\t\24\2\2\u022cz\3\2\2\2\u022d\u022e\t\25\2\2\u022e|\3\2\2\2\u022f\u0230"+
		"\t\26\2\2\u0230~\3\2\2\2\u0231\u0232\t\27\2\2\u0232\u0080\3\2\2\2\u0233"+
		"\u0234\t\30\2\2\u0234\u0082\3\2\2\2\u0235\u0236\t\31\2\2\u0236\u0084\3"+
		"\2\2\2\u0237\u0238\t\32\2\2\u0238\u0086\3\2\2\2\u0239\u023a\t\33\2\2\u023a"+
		"\u0088\3\2\2\2\u023b\u023c\t\34\2\2\u023c\u008a\3\2\2\2\u023d\u023e\t"+
		"\35\2\2\u023e\u008c\3\2\2\2\u023f\u0240\t\36\2\2\u0240\u008e\3\2\2\2\u0241"+
		"\u0242\t\37\2\2\u0242\u0090\3\2\2\2\u0243\u0244\t \2\2\u0244\u0092\3\2"+
		"\2\2\u0245\u0246\t!\2\2\u0246\u0094\3\2\2\2\u0247\u0248\t\"\2\2\u0248"+
		"\u0096\3\2\2\2\u0249\u024a\t#\2\2\u024a\u0098\3\2\2\2\u024b\u024c\t$\2"+
		"\2\u024c\u009a\3\2\2\2\u024d\u024e\t%\2\2\u024e\u009c\3\2\2\2\32\2\u01a0"+
		"\u01a2\u01aa\u01ac\u01b4\u01bc\u01bf\u01c4\u01ca\u01cd\u01d1\u01d6\u01d8"+
		"\u01de\u01e2\u01e7\u01e9\u01eb\u01f1\u01f3\u01fe\u0209\u020f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}