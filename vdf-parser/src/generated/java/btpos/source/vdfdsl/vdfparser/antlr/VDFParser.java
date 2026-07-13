// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDF.g4 by ANTLR 4.13.2
package btpos.source.vdfdsl.vdfparser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class VDFParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WS=2, STRING=3, LITERAL=4, QUOTE=5, COMMENT_START=6, NL=7, 
		OPENBRACE=8, CLOSEBRACE=9;
	public static final int
		RULE_root = 0, RULE_line = 1, RULE_keyvalue = 2, RULE_keyable = 3, RULE_keyvalue_strings = 4, 
		RULE_keyvalue_table = 5, RULE_table = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "line", "keyvalue", "keyable", "keyvalue_strings", "keyvalue_table", 
			"table"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'\"'", "'//'", null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "WS", "STRING", "LITERAL", "QUOTE", "COMMENT_START", 
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

	@Override
	public String getGrammarFileName() { return "VDF.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VDFParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public LineContext line;
		public List<LineContext> lines = new ArrayList<LineContext>();
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(VDFParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(VDFParser.NL, i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			((RootContext)_localctx).line = line();
			((RootContext)_localctx).lines.add(((RootContext)_localctx).line);
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(15);
				match(NL);
				setState(16);
				((RootContext)_localctx).line = line();
				((RootContext)_localctx).lines.add(((RootContext)_localctx).line);
				}
				}
				setState(21);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public KeyvalueContext keyvalue() {
			return getRuleContext(KeyvalueContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(VDFParser.COMMENT, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING || _la==LITERAL) {
				{
				setState(22);
				keyvalue();
				}
			}

			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(25);
				match(COMMENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeyvalueContext extends ParserRuleContext {
		public Keyvalue_stringsContext keyvalue_strings() {
			return getRuleContext(Keyvalue_stringsContext.class,0);
		}
		public Keyvalue_tableContext keyvalue_table() {
			return getRuleContext(Keyvalue_tableContext.class,0);
		}
		public KeyvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterKeyvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitKeyvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitKeyvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyvalueContext keyvalue() throws RecognitionException {
		KeyvalueContext _localctx = new KeyvalueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keyvalue);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				keyvalue_strings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				keyvalue_table();
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeyableContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(VDFParser.LITERAL, 0); }
		public TerminalNode STRING() { return getToken(VDFParser.STRING, 0); }
		public KeyableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterKeyable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitKeyable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitKeyable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyableContext keyable() throws RecognitionException {
		KeyableContext _localctx = new KeyableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_keyable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==LITERAL) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Keyvalue_stringsContext extends ParserRuleContext {
		public KeyableContext key;
		public KeyableContext value;
		public List<KeyableContext> keyable() {
			return getRuleContexts(KeyableContext.class);
		}
		public KeyableContext keyable(int i) {
			return getRuleContext(KeyableContext.class,i);
		}
		public Keyvalue_stringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvalue_strings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterKeyvalue_strings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitKeyvalue_strings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitKeyvalue_strings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyvalue_stringsContext keyvalue_strings() throws RecognitionException {
		Keyvalue_stringsContext _localctx = new Keyvalue_stringsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_keyvalue_strings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			((Keyvalue_stringsContext)_localctx).key = keyable();
			setState(35);
			((Keyvalue_stringsContext)_localctx).value = keyable();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Keyvalue_tableContext extends ParserRuleContext {
		public KeyableContext key;
		public Token COMMENT;
		public List<Token> keyEOLComment = new ArrayList<Token>();
		public TableContext value;
		public KeyableContext keyable() {
			return getRuleContext(KeyableContext.class,0);
		}
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(VDFParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(VDFParser.NL, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(VDFParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(VDFParser.COMMENT, i);
		}
		public Keyvalue_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvalue_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterKeyvalue_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitKeyvalue_table(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitKeyvalue_table(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyvalue_tableContext keyvalue_table() throws RecognitionException {
		Keyvalue_tableContext _localctx = new Keyvalue_tableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_keyvalue_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			((Keyvalue_tableContext)_localctx).key = keyable();
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(38);
					((Keyvalue_tableContext)_localctx).COMMENT = match(COMMENT);
					((Keyvalue_tableContext)_localctx).keyEOLComment.add(((Keyvalue_tableContext)_localctx).COMMENT);
					}
				}

				setState(41);
				match(NL);
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMENT || _la==NL );
			setState(46);
			((Keyvalue_tableContext)_localctx).value = table();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TableContext extends ParserRuleContext {
		public Token tableLBracketComment;
		public LineContext line;
		public List<LineContext> lines = new ArrayList<LineContext>();
		public TerminalNode OPENBRACE() { return getToken(VDFParser.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(VDFParser.CLOSEBRACE, 0); }
		public List<TerminalNode> NL() { return getTokens(VDFParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(VDFParser.NL, i);
		}
		public TerminalNode COMMENT() { return getToken(VDFParser.COMMENT, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(OPENBRACE);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(49);
				((TableContext)_localctx).tableLBracketComment = match(COMMENT);
				}
			}

			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				match(NL);
				setState(53);
				((TableContext)_localctx).line = line();
				((TableContext)_localctx).lines.add(((TableContext)_localctx).line);
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(58);
			match(CLOSEBRACE);
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
		"\u0004\u0001\t=\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0001"+
		"\u0003\u0001\u0018\b\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u001f\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005(\b"+
		"\u0005\u0001\u0005\u0004\u0005+\b\u0005\u000b\u0005\f\u0005,\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u00063\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0004\u00067\b\u0006\u000b\u0006\f\u00068\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000"+
		"\u0001\u0001\u0000\u0003\u0004=\u0000\u000e\u0001\u0000\u0000\u0000\u0002"+
		"\u0017\u0001\u0000\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000\u0006"+
		" \u0001\u0000\u0000\u0000\b\"\u0001\u0000\u0000\u0000\n%\u0001\u0000\u0000"+
		"\u0000\f0\u0001\u0000\u0000\u0000\u000e\u0013\u0003\u0002\u0001\u0000"+
		"\u000f\u0010\u0005\u0007\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000"+
		"\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0015\u0001\u0000\u0000\u0000"+
		"\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000"+
		"\u0014\u0001\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000"+
		"\u0016\u0018\u0003\u0004\u0002\u0000\u0017\u0016\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u001a\u0001\u0000\u0000\u0000"+
		"\u0019\u001b\u0005\u0001\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000"+
		"\u001c\u001f\u0003\b\u0004\u0000\u001d\u001f\u0003\n\u0005\u0000\u001e"+
		"\u001c\u0001\u0000\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f"+
		"\u0005\u0001\u0000\u0000\u0000 !\u0007\u0000\u0000\u0000!\u0007\u0001"+
		"\u0000\u0000\u0000\"#\u0003\u0006\u0003\u0000#$\u0003\u0006\u0003\u0000"+
		"$\t\u0001\u0000\u0000\u0000%*\u0003\u0006\u0003\u0000&(\u0005\u0001\u0000"+
		"\u0000\'&\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0001\u0000"+
		"\u0000\u0000)+\u0005\u0007\u0000\u0000*\'\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000./\u0003\f\u0006\u0000/\u000b\u0001\u0000\u0000"+
		"\u000002\u0005\b\u0000\u000013\u0005\u0001\u0000\u000021\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000045\u0005\u0007"+
		"\u0000\u000057\u0003\u0002\u0001\u000064\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:;\u0005\t\u0000\u0000;\r\u0001\u0000\u0000"+
		"\u0000\b\u0013\u0017\u001a\u001e\',28";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}