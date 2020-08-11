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
		AFTER=9, AS=10, NO=11, COMPRESSION=12, NONE=13, BEST=14, SPEED=15, DECLARE=16, 
		PROCEDURE=17, FOR=18, STATEMENT=19, CONNECT=20, TO=21, USER=22, PASSWORD=23, 
		PROPERTIES=24, DRIVER=25, LIB=26, CONNECTION=27, POOL=28, SIZE=29, MIN=30, 
		MAX=31, UNDECLARED=32, STATEMENTS=33, INCOMING=34, CONNECTIONS=35, ALLOW=36, 
		REJECT=37, IF=38, EXISTS=39, SWITCH=40, SCHEDULE=41, AT=42, INCLUDE=43, 
		FILE=44, IDENTIFIER=45, NUMERIC_LITERAL=46, STRING_LITERAL=47, SINGLE_LINE_COMMENT=48, 
		MULTILINE_COMMENT=49, SPACES=50, UNEXPECTED_CHAR=51;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "EXPOSE", "STATIC", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "NO", "COMPRESSION", "NONE", "BEST", "SPEED", "DECLARE", 
			"PROCEDURE", "FOR", "STATEMENT", "CONNECT", "TO", "USER", "PASSWORD", 
			"PROPERTIES", "DRIVER", "LIB", "CONNECTION", "POOL", "SIZE", "MIN", "MAX", 
			"UNDECLARED", "STATEMENTS", "INCOMING", "CONNECTIONS", "ALLOW", "REJECT", 
			"IF", "EXISTS", "SWITCH", "SCHEDULE", "AT", "INCLUDE", "FILE", "IDENTIFIER", 
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
			null, null, null, null, "EXPOSE", "STATIC", "ROLES", "TRIGGER", "BEFORE", 
			"AFTER", "AS", "NO", "COMPRESSION", "NONE", "BEST", "SPEED", "DECLARE", 
			"PROCEDURE", "FOR", "STATEMENT", "CONNECT", "TO", "USER", "PASSWORD", 
			"PROPERTIES", "DRIVER", "LIB", "CONNECTION", "POOL", "SIZE", "MIN", "MAX", 
			"UNDECLARED", "STATEMENTS", "INCOMING", "CONNECTIONS", "ALLOW", "REJECT", 
			"IF", "EXISTS", "SWITCH", "SCHEDULE", "AT", "INCLUDE", "FILE", "IDENTIFIER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u0271\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3"+
		"(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\7.\u01c3\n.\f.\16.\u01c6"+
		"\13.\3.\3.\3.\3.\3.\7.\u01cd\n.\f.\16.\u01d0\13.\3.\3.\3.\7.\u01d5\n."+
		"\f.\16.\u01d8\13.\3.\3.\3.\7.\u01dd\n.\f.\16.\u01e0\13.\5.\u01e2\n.\3"+
		"/\6/\u01e5\n/\r/\16/\u01e6\3/\3/\7/\u01eb\n/\f/\16/\u01ee\13/\5/\u01f0"+
		"\n/\3/\3/\5/\u01f4\n/\3/\6/\u01f7\n/\r/\16/\u01f8\5/\u01fb\n/\3/\3/\6"+
		"/\u01ff\n/\r/\16/\u0200\3/\3/\5/\u0205\n/\3/\6/\u0208\n/\r/\16/\u0209"+
		"\5/\u020c\n/\5/\u020e\n/\3\60\3\60\3\60\3\60\7\60\u0214\n\60\f\60\16\60"+
		"\u0217\13\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u021f\n\61\f\61\16\61"+
		"\u0222\13\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u022a\n\62\f\62\16\62"+
		"\u022d\13\62\3\62\3\62\3\62\5\62\u0232\n\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3"+
		"<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3"+
		"G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3\u022b\2P\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\2k\2m\2o\2q\2s\2u"+
		"\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d"+
		"\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\3\2"+
		"&\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\4\2\f\f\17"+
		"\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGg"+
		"g\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2"+
		"PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4"+
		"\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u026e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\3\u009f\3\2\2\2\5\u00a1\3\2\2\2\7\u00a3\3\2\2\2\t\u00a5\3\2"+
		"\2\2\13\u00ac\3\2\2\2\r\u00b3\3\2\2\2\17\u00b9\3\2\2\2\21\u00c1\3\2\2"+
		"\2\23\u00c8\3\2\2\2\25\u00ce\3\2\2\2\27\u00d1\3\2\2\2\31\u00d4\3\2\2\2"+
		"\33\u00e0\3\2\2\2\35\u00e5\3\2\2\2\37\u00ea\3\2\2\2!\u00f0\3\2\2\2#\u00f8"+
		"\3\2\2\2%\u0102\3\2\2\2\'\u0106\3\2\2\2)\u0110\3\2\2\2+\u0118\3\2\2\2"+
		"-\u011b\3\2\2\2/\u0120\3\2\2\2\61\u0129\3\2\2\2\63\u0134\3\2\2\2\65\u013b"+
		"\3\2\2\2\67\u013f\3\2\2\29\u014a\3\2\2\2;\u014f\3\2\2\2=\u0154\3\2\2\2"+
		"?\u0158\3\2\2\2A\u015c\3\2\2\2C\u0167\3\2\2\2E\u0172\3\2\2\2G\u017b\3"+
		"\2\2\2I\u0187\3\2\2\2K\u018d\3\2\2\2M\u0194\3\2\2\2O\u0197\3\2\2\2Q\u019e"+
		"\3\2\2\2S\u01a5\3\2\2\2U\u01ae\3\2\2\2W\u01b1\3\2\2\2Y\u01b9\3\2\2\2["+
		"\u01e1\3\2\2\2]\u020d\3\2\2\2_\u020f\3\2\2\2a\u021a\3\2\2\2c\u0225\3\2"+
		"\2\2e\u0235\3\2\2\2g\u0239\3\2\2\2i\u023b\3\2\2\2k\u023d\3\2\2\2m\u023f"+
		"\3\2\2\2o\u0241\3\2\2\2q\u0243\3\2\2\2s\u0245\3\2\2\2u\u0247\3\2\2\2w"+
		"\u0249\3\2\2\2y\u024b\3\2\2\2{\u024d\3\2\2\2}\u024f\3\2\2\2\177\u0251"+
		"\3\2\2\2\u0081\u0253\3\2\2\2\u0083\u0255\3\2\2\2\u0085\u0257\3\2\2\2\u0087"+
		"\u0259\3\2\2\2\u0089\u025b\3\2\2\2\u008b\u025d\3\2\2\2\u008d\u025f\3\2"+
		"\2\2\u008f\u0261\3\2\2\2\u0091\u0263\3\2\2\2\u0093\u0265\3\2\2\2\u0095"+
		"\u0267\3\2\2\2\u0097\u0269\3\2\2\2\u0099\u026b\3\2\2\2\u009b\u026d\3\2"+
		"\2\2\u009d\u026f\3\2\2\2\u009f\u00a0\7.\2\2\u00a0\4\3\2\2\2\u00a1\u00a2"+
		"\7*\2\2\u00a2\6\3\2\2\2\u00a3\u00a4\7+\2\2\u00a4\b\3\2\2\2\u00a5\u00a6"+
		"\5s:\2\u00a6\u00a7\5\u0099M\2\u00a7\u00a8\5\u0089E\2\u00a8\u00a9\5\u0087"+
		"D\2\u00a9\u00aa\5\u008fH\2\u00aa\u00ab\5s:\2\u00ab\n\3\2\2\2\u00ac\u00ad"+
		"\5\u008fH\2\u00ad\u00ae\5\u0091I\2\u00ae\u00af\5k\66\2\u00af\u00b0\5\u0091"+
		"I\2\u00b0\u00b1\5{>\2\u00b1\u00b2\5o8\2\u00b2\f\3\2\2\2\u00b3\u00b4\5"+
		"\u008dG\2\u00b4\u00b5\5\u0087D\2\u00b5\u00b6\5\u0081A\2\u00b6\u00b7\5"+
		"s:\2\u00b7\u00b8\5\u008fH\2\u00b8\16\3\2\2\2\u00b9\u00ba\5\u0091I\2\u00ba"+
		"\u00bb\5\u008dG\2\u00bb\u00bc\5{>\2\u00bc\u00bd\5w<\2\u00bd\u00be\5w<"+
		"\2\u00be\u00bf\5s:\2\u00bf\u00c0\5\u008dG\2\u00c0\20\3\2\2\2\u00c1\u00c2"+
		"\5m\67\2\u00c2\u00c3\5s:\2\u00c3\u00c4\5u;\2\u00c4\u00c5\5\u0087D\2\u00c5"+
		"\u00c6\5\u008dG\2\u00c6\u00c7\5s:\2\u00c7\22\3\2\2\2\u00c8\u00c9\5k\66"+
		"\2\u00c9\u00ca\5u;\2\u00ca\u00cb\5\u0091I\2\u00cb\u00cc\5s:\2\u00cc\u00cd"+
		"\5\u008dG\2\u00cd\24\3\2\2\2\u00ce\u00cf\5k\66\2\u00cf\u00d0\5\u008fH"+
		"\2\u00d0\26\3\2\2\2\u00d1\u00d2\5\u0085C\2\u00d2\u00d3\5\u0087D\2\u00d3"+
		"\30\3\2\2\2\u00d4\u00d5\5o8\2\u00d5\u00d6\5\u0087D\2\u00d6\u00d7\5\u0083"+
		"B\2\u00d7\u00d8\5\u0089E\2\u00d8\u00d9\5\u008dG\2\u00d9\u00da\5s:\2\u00da"+
		"\u00db\5\u008fH\2\u00db\u00dc\5\u008fH\2\u00dc\u00dd\5{>\2\u00dd\u00de"+
		"\5\u0087D\2\u00de\u00df\5\u0085C\2\u00df\32\3\2\2\2\u00e0\u00e1\5\u0085"+
		"C\2\u00e1\u00e2\5\u0087D\2\u00e2\u00e3\5\u0085C\2\u00e3\u00e4\5s:\2\u00e4"+
		"\34\3\2\2\2\u00e5\u00e6\5m\67\2\u00e6\u00e7\5s:\2\u00e7\u00e8\5\u008f"+
		"H\2\u00e8\u00e9\5\u0091I\2\u00e9\36\3\2\2\2\u00ea\u00eb\5\u008fH\2\u00eb"+
		"\u00ec\5\u0089E\2\u00ec\u00ed\5s:\2\u00ed\u00ee\5s:\2\u00ee\u00ef\5q9"+
		"\2\u00ef \3\2\2\2\u00f0\u00f1\5q9\2\u00f1\u00f2\5s:\2\u00f2\u00f3\5o8"+
		"\2\u00f3\u00f4\5\u0081A\2\u00f4\u00f5\5k\66\2\u00f5\u00f6\5\u008dG\2\u00f6"+
		"\u00f7\5s:\2\u00f7\"\3\2\2\2\u00f8\u00f9\5\u0089E\2\u00f9\u00fa\5\u008d"+
		"G\2\u00fa\u00fb\5\u0087D\2\u00fb\u00fc\5o8\2\u00fc\u00fd\5s:\2\u00fd\u00fe"+
		"\5q9\2\u00fe\u00ff\5\u0093J\2\u00ff\u0100\5\u008dG\2\u0100\u0101\5s:\2"+
		"\u0101$\3\2\2\2\u0102\u0103\5u;\2\u0103\u0104\5\u0087D\2\u0104\u0105\5"+
		"\u008dG\2\u0105&\3\2\2\2\u0106\u0107\5\u008fH\2\u0107\u0108\5\u0091I\2"+
		"\u0108\u0109\5k\66\2\u0109\u010a\5\u0091I\2\u010a\u010b\5s:\2\u010b\u010c"+
		"\5\u0083B\2\u010c\u010d\5s:\2\u010d\u010e\5\u0085C\2\u010e\u010f\5\u0091"+
		"I\2\u010f(\3\2\2\2\u0110\u0111\5o8\2\u0111\u0112\5\u0087D\2\u0112\u0113"+
		"\5\u0085C\2\u0113\u0114\5\u0085C\2\u0114\u0115\5s:\2\u0115\u0116\5o8\2"+
		"\u0116\u0117\5\u0091I\2\u0117*\3\2\2\2\u0118\u0119\5\u0091I\2\u0119\u011a"+
		"\5\u0087D\2\u011a,\3\2\2\2\u011b\u011c\5\u0093J\2\u011c\u011d\5\u008f"+
		"H\2\u011d\u011e\5s:\2\u011e\u011f\5\u008dG\2\u011f.\3\2\2\2\u0120\u0121"+
		"\5\u0089E\2\u0121\u0122\5k\66\2\u0122\u0123\5\u008fH\2\u0123\u0124\5\u008f"+
		"H\2\u0124\u0125\5\u0097L\2\u0125\u0126\5\u0087D\2\u0126\u0127\5\u008d"+
		"G\2\u0127\u0128\5q9\2\u0128\60\3\2\2\2\u0129\u012a\5\u0089E\2\u012a\u012b"+
		"\5\u008dG\2\u012b\u012c\5\u0087D\2\u012c\u012d\5\u0089E\2\u012d\u012e"+
		"\5s:\2\u012e\u012f\5\u008dG\2\u012f\u0130\5\u0091I\2\u0130\u0131\5{>\2"+
		"\u0131\u0132\5s:\2\u0132\u0133\5\u008fH\2\u0133\62\3\2\2\2\u0134\u0135"+
		"\5q9\2\u0135\u0136\5\u008dG\2\u0136\u0137\5{>\2\u0137\u0138\5\u0095K\2"+
		"\u0138\u0139\5s:\2\u0139\u013a\5\u008dG\2\u013a\64\3\2\2\2\u013b\u013c"+
		"\5\u0081A\2\u013c\u013d\5{>\2\u013d\u013e\5m\67\2\u013e\66\3\2\2\2\u013f"+
		"\u0140\5o8\2\u0140\u0141\5\u0087D\2\u0141\u0142\5\u0085C\2\u0142\u0143"+
		"\5\u0085C\2\u0143\u0144\5s:\2\u0144\u0145\5o8\2\u0145\u0146\5\u0091I\2"+
		"\u0146\u0147\5{>\2\u0147\u0148\5\u0087D\2\u0148\u0149\5\u0085C\2\u0149"+
		"8\3\2\2\2\u014a\u014b\5\u0089E\2\u014b\u014c\5\u0087D\2\u014c\u014d\5"+
		"\u0087D\2\u014d\u014e\5\u0081A\2\u014e:\3\2\2\2\u014f\u0150\5\u008fH\2"+
		"\u0150\u0151\5{>\2\u0151\u0152\5\u009dO\2\u0152\u0153\5s:\2\u0153<\3\2"+
		"\2\2\u0154\u0155\5\u0083B\2\u0155\u0156\5{>\2\u0156\u0157\5\u0085C\2\u0157"+
		">\3\2\2\2\u0158\u0159\5\u0083B\2\u0159\u015a\5k\66\2\u015a\u015b\5\u0099"+
		"M\2\u015b@\3\2\2\2\u015c\u015d\5\u0093J\2\u015d\u015e\5\u0085C\2\u015e"+
		"\u015f\5q9\2\u015f\u0160\5s:\2\u0160\u0161\5o8\2\u0161\u0162\5\u0081A"+
		"\2\u0162\u0163\5k\66\2\u0163\u0164\5\u008dG\2\u0164\u0165\5s:\2\u0165"+
		"\u0166\5q9\2\u0166B\3\2\2\2\u0167\u0168\5\u008fH\2\u0168\u0169\5\u0091"+
		"I\2\u0169\u016a\5k\66\2\u016a\u016b\5\u0091I\2\u016b\u016c\5s:\2\u016c"+
		"\u016d\5\u0083B\2\u016d\u016e\5s:\2\u016e\u016f\5\u0085C\2\u016f\u0170"+
		"\5\u0091I\2\u0170\u0171\5\u008fH\2\u0171D\3\2\2\2\u0172\u0173\5{>\2\u0173"+
		"\u0174\5\u0085C\2\u0174\u0175\5o8\2\u0175\u0176\5\u0087D\2\u0176\u0177"+
		"\5\u0083B\2\u0177\u0178\5{>\2\u0178\u0179\5\u0085C\2\u0179\u017a\5w<\2"+
		"\u017aF\3\2\2\2\u017b\u017c\5o8\2\u017c\u017d\5\u0087D\2\u017d\u017e\5"+
		"\u0085C\2\u017e\u017f\5\u0085C\2\u017f\u0180\5s:\2\u0180\u0181\5o8\2\u0181"+
		"\u0182\5\u0091I\2\u0182\u0183\5{>\2\u0183\u0184\5\u0087D\2\u0184\u0185"+
		"\5\u0085C\2\u0185\u0186\5\u008fH\2\u0186H\3\2\2\2\u0187\u0188\5k\66\2"+
		"\u0188\u0189\5\u0081A\2\u0189\u018a\5\u0081A\2\u018a\u018b\5\u0087D\2"+
		"\u018b\u018c\5\u0097L\2\u018cJ\3\2\2\2\u018d\u018e\5\u008dG\2\u018e\u018f"+
		"\5s:\2\u018f\u0190\5}?\2\u0190\u0191\5s:\2\u0191\u0192\5o8\2\u0192\u0193"+
		"\5\u0091I\2\u0193L\3\2\2\2\u0194\u0195\5{>\2\u0195\u0196\5u;\2\u0196N"+
		"\3\2\2\2\u0197\u0198\5s:\2\u0198\u0199\5\u0099M\2\u0199\u019a\5{>\2\u019a"+
		"\u019b\5\u008fH\2\u019b\u019c\5\u0091I\2\u019c\u019d\5\u008fH\2\u019d"+
		"P\3\2\2\2\u019e\u019f\5\u008fH\2\u019f\u01a0\5\u0097L\2\u01a0\u01a1\5"+
		"{>\2\u01a1\u01a2\5\u0091I\2\u01a2\u01a3\5o8\2\u01a3\u01a4\5y=\2\u01a4"+
		"R\3\2\2\2\u01a5\u01a6\5\u008fH\2\u01a6\u01a7\5o8\2\u01a7\u01a8\5y=\2\u01a8"+
		"\u01a9\5s:\2\u01a9\u01aa\5q9\2\u01aa\u01ab\5\u0093J\2\u01ab\u01ac\5\u0081"+
		"A\2\u01ac\u01ad\5s:\2\u01adT\3\2\2\2\u01ae\u01af\5k\66\2\u01af\u01b0\5"+
		"\u0091I\2\u01b0V\3\2\2\2\u01b1\u01b2\5{>\2\u01b2\u01b3\5\u0085C\2\u01b3"+
		"\u01b4\5o8\2\u01b4\u01b5\5\u0081A\2\u01b5\u01b6\5\u0093J\2\u01b6\u01b7"+
		"\5q9\2\u01b7\u01b8\5s:\2\u01b8X\3\2\2\2\u01b9\u01ba\5u;\2\u01ba\u01bb"+
		"\5{>\2\u01bb\u01bc\5\u0081A\2\u01bc\u01bd\5s:\2\u01bdZ\3\2\2\2\u01be\u01c4"+
		"\7$\2\2\u01bf\u01c3\n\2\2\2\u01c0\u01c1\7$\2\2\u01c1\u01c3\7$\2\2\u01c2"+
		"\u01bf\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7"+
		"\u01e2\7$\2\2\u01c8\u01ce\7b\2\2\u01c9\u01cd\n\3\2\2\u01ca\u01cb\7b\2"+
		"\2\u01cb\u01cd\7b\2\2\u01cc\u01c9\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0"+
		"\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0"+
		"\u01ce\3\2\2\2\u01d1\u01e2\7b\2\2\u01d2\u01d6\7]\2\2\u01d3\u01d5\n\4\2"+
		"\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7"+
		"\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01e2\7_\2\2\u01da"+
		"\u01de\t\5\2\2\u01db\u01dd\t\6\2\2\u01dc\u01db\3\2\2\2\u01dd\u01e0\3\2"+
		"\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0"+
		"\u01de\3\2\2\2\u01e1\u01be\3\2\2\2\u01e1\u01c8\3\2\2\2\u01e1\u01d2\3\2"+
		"\2\2\u01e1\u01da\3\2\2\2\u01e2\\\3\2\2\2\u01e3\u01e5\5i\65\2\u01e4\u01e3"+
		"\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"\u01ef\3\2\2\2\u01e8\u01ec\7\60\2\2\u01e9\u01eb\5i\65\2\u01ea\u01e9\3"+
		"\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01e8\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01fa\3\2\2\2\u01f1\u01f3\5s:\2\u01f2\u01f4\t\7\2\2\u01f3\u01f2"+
		"\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f6\3\2\2\2\u01f5\u01f7\5i\65\2\u01f6"+
		"\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2"+
		"\2\2\u01f9\u01fb\3\2\2\2\u01fa\u01f1\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb"+
		"\u020e\3\2\2\2\u01fc\u01fe\7\60\2\2\u01fd\u01ff\5i\65\2\u01fe\u01fd\3"+
		"\2\2\2\u01ff\u0200\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201"+
		"\u020b\3\2\2\2\u0202\u0204\5s:\2\u0203\u0205\t\7\2\2\u0204\u0203\3\2\2"+
		"\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206\u0208\5i\65\2\u0207\u0206"+
		"\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"\u020c\3\2\2\2\u020b\u0202\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020e\3\2"+
		"\2\2\u020d\u01e4\3\2\2\2\u020d\u01fc\3\2\2\2\u020e^\3\2\2\2\u020f\u0215"+
		"\7)\2\2\u0210\u0214\n\b\2\2\u0211\u0212\7)\2\2\u0212\u0214\7)\2\2\u0213"+
		"\u0210\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2"+
		"\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217\u0215\3\2\2\2\u0218"+
		"\u0219\7)\2\2\u0219`\3\2\2\2\u021a\u021b\7/\2\2\u021b\u021c\7/\2\2\u021c"+
		"\u0220\3\2\2\2\u021d\u021f\n\t\2\2\u021e\u021d\3\2\2\2\u021f\u0222\3\2"+
		"\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0223\3\2\2\2\u0222"+
		"\u0220\3\2\2\2\u0223\u0224\b\61\2\2\u0224b\3\2\2\2\u0225\u0226\7\61\2"+
		"\2\u0226\u0227\7,\2\2\u0227\u022b\3\2\2\2\u0228\u022a\13\2\2\2\u0229\u0228"+
		"\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u022c\3\2\2\2\u022b\u0229\3\2\2\2\u022c"+
		"\u0231\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u022f\7,\2\2\u022f\u0232\7\61"+
		"\2\2\u0230\u0232\7\2\2\3\u0231\u022e\3\2\2\2\u0231\u0230\3\2\2\2\u0232"+
		"\u0233\3\2\2\2\u0233\u0234\b\62\2\2\u0234d\3\2\2\2\u0235\u0236\t\n\2\2"+
		"\u0236\u0237\3\2\2\2\u0237\u0238\b\63\2\2\u0238f\3\2\2\2\u0239\u023a\13"+
		"\2\2\2\u023ah\3\2\2\2\u023b\u023c\t\13\2\2\u023cj\3\2\2\2\u023d\u023e"+
		"\t\f\2\2\u023el\3\2\2\2\u023f\u0240\t\r\2\2\u0240n\3\2\2\2\u0241\u0242"+
		"\t\16\2\2\u0242p\3\2\2\2\u0243\u0244\t\17\2\2\u0244r\3\2\2\2\u0245\u0246"+
		"\t\20\2\2\u0246t\3\2\2\2\u0247\u0248\t\21\2\2\u0248v\3\2\2\2\u0249\u024a"+
		"\t\22\2\2\u024ax\3\2\2\2\u024b\u024c\t\23\2\2\u024cz\3\2\2\2\u024d\u024e"+
		"\t\24\2\2\u024e|\3\2\2\2\u024f\u0250\t\25\2\2\u0250~\3\2\2\2\u0251\u0252"+
		"\t\26\2\2\u0252\u0080\3\2\2\2\u0253\u0254\t\27\2\2\u0254\u0082\3\2\2\2"+
		"\u0255\u0256\t\30\2\2\u0256\u0084\3\2\2\2\u0257\u0258\t\31\2\2\u0258\u0086"+
		"\3\2\2\2\u0259\u025a\t\32\2\2\u025a\u0088\3\2\2\2\u025b\u025c\t\33\2\2"+
		"\u025c\u008a\3\2\2\2\u025d\u025e\t\34\2\2\u025e\u008c\3\2\2\2\u025f\u0260"+
		"\t\35\2\2\u0260\u008e\3\2\2\2\u0261\u0262\t\36\2\2\u0262\u0090\3\2\2\2"+
		"\u0263\u0264\t\37\2\2\u0264\u0092\3\2\2\2\u0265\u0266\t \2\2\u0266\u0094"+
		"\3\2\2\2\u0267\u0268\t!\2\2\u0268\u0096\3\2\2\2\u0269\u026a\t\"\2\2\u026a"+
		"\u0098\3\2\2\2\u026b\u026c\t#\2\2\u026c\u009a\3\2\2\2\u026d\u026e\t$\2"+
		"\2\u026e\u009c\3\2\2\2\u026f\u0270\t%\2\2\u0270\u009e\3\2\2\2\32\2\u01c2"+
		"\u01c4\u01cc\u01ce\u01d6\u01de\u01e1\u01e6\u01ec\u01ef\u01f3\u01f8\u01fa"+
		"\u0200\u0204\u0209\u020b\u020d\u0213\u0215\u0220\u022b\u0231\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}