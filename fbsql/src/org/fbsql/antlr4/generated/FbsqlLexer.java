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
		T__0=1, T__1=2, T__2=3, K_EXPOSE=4, K_PREFETCH=5, K_ROLES=6, K_AS=7, K_DECLARE=8, 
		K_PROCEDURE=9, K_FOR=10, IDENTIFIER=11, STRING_LITERAL=12, SINGLE_LINE_COMMENT=13, 
		MULTILINE_COMMENT=14, SPACES=15, UNEXPECTED_CHAR=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "K_EXPOSE", "K_PREFETCH", "K_ROLES", "K_AS", 
			"K_DECLARE", "K_PROCEDURE", "K_FOR", "IDENTIFIER", "STRING_LITERAL", 
			"SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
			null, null, null, null, "K_EXPOSE", "K_PREFETCH", "K_ROLES", "K_AS", 
			"K_DECLARE", "K_PROCEDURE", "K_FOR", "IDENTIFIER", "STRING_LITERAL", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u0111\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\7\f\u0091\n\f\f\f\16\f\u0094\13\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u009b\n\f\f\f\16\f\u009e\13\f\3\f\3\f\3\f\7\f\u00a3\n\f\f"+
		"\f\16\f\u00a6\13\f\3\f\3\f\3\f\7\f\u00ab\n\f\f\f\16\f\u00ae\13\f\5\f\u00b0"+
		"\n\f\3\r\3\r\3\r\3\r\7\r\u00b6\n\r\f\r\16\r\u00b9\13\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\7\16\u00c1\n\16\f\16\16\16\u00c4\13\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\7\17\u00cc\n\17\f\17\16\17\u00cf\13\17\3\17\3\17\3\17\5"+
		"\17\u00d4\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3\u00cd"+
		"\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2"+
		"C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2\3\2$\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2))\4\2\f\f\17\17\5\2\13\r\17\17\"\"\4\2CCcc\4\2DDdd\4\2EE"+
		"ee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2"+
		"NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4"+
		"\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0104\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2"+
		"\7[\3\2\2\2\t]\3\2\2\2\13d\3\2\2\2\rm\3\2\2\2\17s\3\2\2\2\21v\3\2\2\2"+
		"\23~\3\2\2\2\25\u0088\3\2\2\2\27\u00af\3\2\2\2\31\u00b1\3\2\2\2\33\u00bc"+
		"\3\2\2\2\35\u00c7\3\2\2\2\37\u00d7\3\2\2\2!\u00db\3\2\2\2#\u00dd\3\2\2"+
		"\2%\u00df\3\2\2\2\'\u00e1\3\2\2\2)\u00e3\3\2\2\2+\u00e5\3\2\2\2-\u00e7"+
		"\3\2\2\2/\u00e9\3\2\2\2\61\u00eb\3\2\2\2\63\u00ed\3\2\2\2\65\u00ef\3\2"+
		"\2\2\67\u00f1\3\2\2\29\u00f3\3\2\2\2;\u00f5\3\2\2\2=\u00f7\3\2\2\2?\u00f9"+
		"\3\2\2\2A\u00fb\3\2\2\2C\u00fd\3\2\2\2E\u00ff\3\2\2\2G\u0101\3\2\2\2I"+
		"\u0103\3\2\2\2K\u0105\3\2\2\2M\u0107\3\2\2\2O\u0109\3\2\2\2Q\u010b\3\2"+
		"\2\2S\u010d\3\2\2\2U\u010f\3\2\2\2WX\7*\2\2X\4\3\2\2\2YZ\7+\2\2Z\6\3\2"+
		"\2\2[\\\7.\2\2\\\b\3\2\2\2]^\5+\26\2^_\5Q)\2_`\5A!\2`a\5? \2ab\5G$\2b"+
		"c\5+\26\2c\n\3\2\2\2de\5A!\2ef\5E#\2fg\5+\26\2gh\5-\27\2hi\5+\26\2ij\5"+
		"I%\2jk\5\'\24\2kl\5\61\31\2l\f\3\2\2\2mn\5E#\2no\5? \2op\59\35\2pq\5+"+
		"\26\2qr\5G$\2r\16\3\2\2\2st\5#\22\2tu\5G$\2u\20\3\2\2\2vw\5)\25\2wx\5"+
		"+\26\2xy\5\'\24\2yz\59\35\2z{\5#\22\2{|\5E#\2|}\5+\26\2}\22\3\2\2\2~\177"+
		"\5A!\2\177\u0080\5E#\2\u0080\u0081\5? \2\u0081\u0082\5\'\24\2\u0082\u0083"+
		"\5+\26\2\u0083\u0084\5)\25\2\u0084\u0085\5K&\2\u0085\u0086\5E#\2\u0086"+
		"\u0087\5+\26\2\u0087\24\3\2\2\2\u0088\u0089\5-\27\2\u0089\u008a\5? \2"+
		"\u008a\u008b\5E#\2\u008b\26\3\2\2\2\u008c\u0092\7$\2\2\u008d\u0091\n\2"+
		"\2\2\u008e\u008f\7$\2\2\u008f\u0091\7$\2\2\u0090\u008d\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u00b0\7$\2\2\u0096\u009c\7b\2"+
		"\2\u0097\u009b\n\3\2\2\u0098\u0099\7b\2\2\u0099\u009b\7b\2\2\u009a\u0097"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00b0\7b"+
		"\2\2\u00a0\u00a4\7]\2\2\u00a1\u00a3\n\4\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00b0\7_\2\2\u00a8\u00ac\t\5\2\2\u00a9"+
		"\u00ab\t\6\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u008c\3\2\2\2\u00af\u0096\3\2\2\2\u00af\u00a0\3\2\2\2\u00af\u00a8\3\2"+
		"\2\2\u00b0\30\3\2\2\2\u00b1\u00b7\7)\2\2\u00b2\u00b6\n\7\2\2\u00b3\u00b4"+
		"\7)\2\2\u00b4\u00b6\7)\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7)\2\2\u00bb\32\3\2\2\2\u00bc\u00bd"+
		"\7/\2\2\u00bd\u00be\7/\2\2\u00be\u00c2\3\2\2\2\u00bf\u00c1\n\b\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\b\16\2\2\u00c6"+
		"\34\3\2\2\2\u00c7\u00c8\7\61\2\2\u00c8\u00c9\7,\2\2\u00c9\u00cd\3\2\2"+
		"\2\u00ca\u00cc\13\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d3\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00d0\u00d1\7,\2\2\u00d1\u00d4\7\61\2\2\u00d2\u00d4\7\2\2\3\u00d3"+
		"\u00d0\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b\17"+
		"\2\2\u00d6\36\3\2\2\2\u00d7\u00d8\t\t\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da"+
		"\b\20\2\2\u00da \3\2\2\2\u00db\u00dc\13\2\2\2\u00dc\"\3\2\2\2\u00dd\u00de"+
		"\t\n\2\2\u00de$\3\2\2\2\u00df\u00e0\t\13\2\2\u00e0&\3\2\2\2\u00e1\u00e2"+
		"\t\f\2\2\u00e2(\3\2\2\2\u00e3\u00e4\t\r\2\2\u00e4*\3\2\2\2\u00e5\u00e6"+
		"\t\16\2\2\u00e6,\3\2\2\2\u00e7\u00e8\t\17\2\2\u00e8.\3\2\2\2\u00e9\u00ea"+
		"\t\20\2\2\u00ea\60\3\2\2\2\u00eb\u00ec\t\21\2\2\u00ec\62\3\2\2\2\u00ed"+
		"\u00ee\t\22\2\2\u00ee\64\3\2\2\2\u00ef\u00f0\t\23\2\2\u00f0\66\3\2\2\2"+
		"\u00f1\u00f2\t\24\2\2\u00f28\3\2\2\2\u00f3\u00f4\t\25\2\2\u00f4:\3\2\2"+
		"\2\u00f5\u00f6\t\26\2\2\u00f6<\3\2\2\2\u00f7\u00f8\t\27\2\2\u00f8>\3\2"+
		"\2\2\u00f9\u00fa\t\30\2\2\u00fa@\3\2\2\2\u00fb\u00fc\t\31\2\2\u00fcB\3"+
		"\2\2\2\u00fd\u00fe\t\32\2\2\u00feD\3\2\2\2\u00ff\u0100\t\33\2\2\u0100"+
		"F\3\2\2\2\u0101\u0102\t\34\2\2\u0102H\3\2\2\2\u0103\u0104\t\35\2\2\u0104"+
		"J\3\2\2\2\u0105\u0106\t\36\2\2\u0106L\3\2\2\2\u0107\u0108\t\37\2\2\u0108"+
		"N\3\2\2\2\u0109\u010a\t \2\2\u010aP\3\2\2\2\u010b\u010c\t!\2\2\u010cR"+
		"\3\2\2\2\u010d\u010e\t\"\2\2\u010eT\3\2\2\2\u010f\u0110\t#\2\2\u0110V"+
		"\3\2\2\2\17\2\u0090\u0092\u009a\u009c\u00a4\u00ac\u00af\u00b5\u00b7\u00c2"+
		"\u00cd\u00d3\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}