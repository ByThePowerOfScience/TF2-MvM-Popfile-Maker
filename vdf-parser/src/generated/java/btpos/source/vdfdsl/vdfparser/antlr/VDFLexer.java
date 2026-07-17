// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDF.g4 by ANTLR 4.13.2
package btpos.source.vdfdsl.vdfparser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class VDFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WS=2, STRING=3, LITERAL=4, CONDITIONAL=5, QUOTE=6, COMMENT_START=7, 
		NL=8, OPENBRACE=9, CLOSEBRACE=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "WS", "STRING", "LITERAL", "NON_LITERAL_ELEMENT", "CONDITIONAL", 
			"QUOTE", "COMMENT_START", "STRING_ELEMENT", "NL", "OPENBRACE", "CLOSEBRACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'\"'", "'//'", null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "WS", "STRING", "LITERAL", "CONDITIONAL", "QUOTE", "COMMENT_START", 
			"NL", "OPENBRACE", "CLOSEBRACE"
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


	public VDFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "VDF.g4"; }

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
		"\u0004\u0000\nT\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000"+
		"\f\u0000\u001f\t\u0000\u0001\u0001\u0004\u0001\"\b\u0001\u000b\u0001\f"+
		"\u0001#\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002*\b"+
		"\u0002\n\u0002\f\u0002-\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0005\u00033\b\u0003\n\u0003\f\u00036\t\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0004\u0005<\b\u0005\u000b\u0005\f\u0005"+
		"=\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003\bJ\b\b\u0001\t\u0003\tM\b\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001=\u0000"+
		"\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0000\u000b\u0005"+
		"\r\u0006\u000f\u0007\u0011\u0000\u0013\b\u0015\t\u0017\n\u0001\u0000\u0005"+
		"\u0002\u0000\n\n\r\r\b\u0000\t\t  \u00a0\u00a0\u1680\u1680\u2000\u200a"+
		"\u202f\u202f\u205f\u205f\u3000\u3000\r\u0000\t\n\r\r  \"\"[[{{}}\u00a0"+
		"\u00a0\u1680\u1680\u2000\u200a\u202f\u202f\u205f\u205f\u3000\u3000\f\u0000"+
		"\t\n\r\r  \"\"{{}}\u00a0\u00a0\u1680\u1680\u2000\u200a\u202f\u202f\u205f"+
		"\u205f\u3000\u3000\u0001\u0000\"\"X\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0003"+
		"!\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u00070\u0001"+
		"\u0000\u0000\u0000\t7\u0001\u0000\u0000\u0000\u000b9\u0001\u0000\u0000"+
		"\u0000\rA\u0001\u0000\u0000\u0000\u000fC\u0001\u0000\u0000\u0000\u0011"+
		"I\u0001\u0000\u0000\u0000\u0013L\u0001\u0000\u0000\u0000\u0015P\u0001"+
		"\u0000\u0000\u0000\u0017R\u0001\u0000\u0000\u0000\u0019\u001d\u0003\u000f"+
		"\u0007\u0000\u001a\u001c\b\u0000\u0000\u0000\u001b\u001a\u0001\u0000\u0000"+
		"\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0002\u0001\u0000\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000 \"\u0007\u0001\u0000\u0000"+
		"! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0006\u0001"+
		"\u0000\u0000&\u0004\u0001\u0000\u0000\u0000\'+\u0003\r\u0006\u0000(*\u0003"+
		"\u0011\b\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000./\u0003\r\u0006\u0000/\u0006\u0001\u0000\u0000"+
		"\u000004\b\u0002\u0000\u000013\b\u0003\u0000\u000021\u0001\u0000\u0000"+
		"\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u00005\b\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0007"+
		"\u0003\u0000\u00008\n\u0001\u0000\u0000\u00009;\u0005[\u0000\u0000:<\t"+
		"\u0000\u0000\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0005]\u0000\u0000@\f\u0001\u0000\u0000\u0000AB\u0005\"\u0000"+
		"\u0000B\u000e\u0001\u0000\u0000\u0000CD\u0005/\u0000\u0000DE\u0005/\u0000"+
		"\u0000E\u0010\u0001\u0000\u0000\u0000FG\u0005\\\u0000\u0000GJ\u0005\""+
		"\u0000\u0000HJ\b\u0004\u0000\u0000IF\u0001\u0000\u0000\u0000IH\u0001\u0000"+
		"\u0000\u0000J\u0012\u0001\u0000\u0000\u0000KM\u0005\r\u0000\u0000LK\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NO\u0005\n\u0000\u0000O\u0014\u0001\u0000\u0000\u0000PQ\u0005{\u0000\u0000"+
		"Q\u0016\u0001\u0000\u0000\u0000RS\u0005}\u0000\u0000S\u0018\u0001\u0000"+
		"\u0000\u0000\b\u0000\u001d#+4=IL\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}