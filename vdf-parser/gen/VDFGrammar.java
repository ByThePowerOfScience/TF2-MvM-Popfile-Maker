// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDFGrammar.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class VDFGrammar extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LITERAL=1, STRING=2, NUMBER=3, NL=4, OPENBRACE=5, CLOSEBRACE=6, COMMENT_START=7;
	public static final int
		RULE_s = 0, RULE_line_no_newline = 1, RULE_keyvalue = 2, RULE_keyable = 3, 
		RULE_keyvalue_strings = 4, RULE_keyvalue_table = 5, RULE_table = 6, RULE_line = 7, 
		RULE_comment = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "line_no_newline", "keyvalue", "keyable", "keyvalue_strings", "keyvalue_table", 
			"table", "line", "comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LITERAL", "STRING", "NUMBER", "NL", "OPENBRACE", "CLOSEBRACE", 
			"COMMENT_START"
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
	public String getGrammarFileName() { return "VDFGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VDFGrammar(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public Line_no_newlineContext line_no_newline;
		public List<Line_no_newlineContext> lines = new ArrayList<Line_no_newlineContext>();
		public LineContext line;
		public List<LineContext> rest = new ArrayList<LineContext>();
		public Line_no_newlineContext line_no_newline() {
			return getRuleContext(Line_no_newlineContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			((SContext)_localctx).line_no_newline = line_no_newline();
			((SContext)_localctx).lines.add(((SContext)_localctx).line_no_newline);
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(19);
				((SContext)_localctx).line = line();
				((SContext)_localctx).rest.add(((SContext)_localctx).line);
				}
				}
				setState(24);
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
	public static class Line_no_newlineContext extends ParserRuleContext {
		public KeyvalueContext keyvalue() {
			return getRuleContext(KeyvalueContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public Line_no_newlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_no_newline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterLine_no_newline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitLine_no_newline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitLine_no_newline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_no_newlineContext line_no_newline() throws RecognitionException {
		Line_no_newlineContext _localctx = new Line_no_newlineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line_no_newline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(25);
			keyvalue();
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_START) {
				{
				setState(26);
				comment();
				}
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
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterKeyvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitKeyvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitKeyvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyvalueContext keyvalue() throws RecognitionException {
		KeyvalueContext _localctx = new KeyvalueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keyvalue);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				keyvalue_strings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
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
		public TerminalNode LITERAL() { return getToken(VDFGrammar.LITERAL, 0); }
		public TerminalNode STRING() { return getToken(VDFGrammar.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(VDFGrammar.NUMBER, 0); }
		public KeyableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterKeyable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitKeyable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitKeyable(this);
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
			setState(33);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) ) {
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
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterKeyvalue_strings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitKeyvalue_strings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitKeyvalue_strings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyvalue_stringsContext keyvalue_strings() throws RecognitionException {
		Keyvalue_stringsContext _localctx = new Keyvalue_stringsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_keyvalue_strings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((Keyvalue_stringsContext)_localctx).key = keyable();
			setState(36);
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
		public CommentContext keyEOLComment;
		public TableContext value;
		public TerminalNode NL() { return getToken(VDFGrammar.NL, 0); }
		public KeyableContext keyable() {
			return getRuleContext(KeyableContext.class,0);
		}
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public Keyvalue_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvalue_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterKeyvalue_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitKeyvalue_table(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitKeyvalue_table(this);
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
			setState(38);
			((Keyvalue_tableContext)_localctx).key = keyable();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_START) {
				{
				setState(39);
				((Keyvalue_tableContext)_localctx).keyEOLComment = comment();
				}
			}

			setState(42);
			match(NL);
			setState(43);
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
		public CommentContext tableLBracketComment;
		public LineContext line;
		public List<LineContext> lines = new ArrayList<LineContext>();
		public TerminalNode OPENBRACE() { return getToken(VDFGrammar.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(VDFGrammar.CLOSEBRACE, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
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
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitTable(this);
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
			setState(45);
			match(OPENBRACE);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_START) {
				{
				setState(46);
				((TableContext)_localctx).tableLBracketComment = comment();
				}
			}

			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				((TableContext)_localctx).line = line();
				((TableContext)_localctx).lines.add(((TableContext)_localctx).line);
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(54);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(VDFGrammar.NL, 0); }
		public KeyvalueContext keyvalue() {
			return getRuleContext(KeyvalueContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(NL);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) {
				{
				setState(57);
				keyvalue();
				}
			}

			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_START) {
				{
				setState(60);
				comment();
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
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT_START() { return getToken(VDFGrammar.COMMENT_START, 0); }
		public List<TerminalNode> NL() { return getTokens(VDFGrammar.NL); }
		public TerminalNode NL(int i) {
			return getToken(VDFGrammar.NL, i);
		}
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFGrammarListener ) ((VDFGrammarListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFGrammarVisitor ) return ((VDFGrammarVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(COMMENT_START);
			setState(65); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(64);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(67); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\u0004\u0001\u0007F\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0005\u0000\u0015\b\u0000\n\u0000\f"+
		"\u0000\u0018\t\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u001c\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0003\u0002 \b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005"+
		")\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u00060\b\u0006\u0001\u0006\u0004\u00063\b\u0006\u000b\u0006\f\u0006"+
		"4\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007;\b\u0007"+
		"\u0001\u0007\u0003\u0007>\b\u0007\u0001\b\u0001\b\u0004\bB\b\b\u000b\b"+
		"\f\bC\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0000\u0002\u0001\u0000\u0001\u0003\u0001\u0000\u0004\u0004E\u0000\u0012"+
		"\u0001\u0000\u0000\u0000\u0002\u0019\u0001\u0000\u0000\u0000\u0004\u001f"+
		"\u0001\u0000\u0000\u0000\u0006!\u0001\u0000\u0000\u0000\b#\u0001\u0000"+
		"\u0000\u0000\n&\u0001\u0000\u0000\u0000\f-\u0001\u0000\u0000\u0000\u000e"+
		"8\u0001\u0000\u0000\u0000\u0010?\u0001\u0000\u0000\u0000\u0012\u0016\u0003"+
		"\u0002\u0001\u0000\u0013\u0015\u0003\u000e\u0007\u0000\u0014\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0001\u0001"+
		"\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0019\u001b\u0003"+
		"\u0004\u0002\u0000\u001a\u001c\u0003\u0010\b\u0000\u001b\u001a\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0003\u0001\u0000"+
		"\u0000\u0000\u001d \u0003\b\u0004\u0000\u001e \u0003\n\u0005\u0000\u001f"+
		"\u001d\u0001\u0000\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 \u0005"+
		"\u0001\u0000\u0000\u0000!\"\u0007\u0000\u0000\u0000\"\u0007\u0001\u0000"+
		"\u0000\u0000#$\u0003\u0006\u0003\u0000$%\u0003\u0006\u0003\u0000%\t\u0001"+
		"\u0000\u0000\u0000&(\u0003\u0006\u0003\u0000\')\u0003\u0010\b\u0000(\'"+
		"\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0004\u0000\u0000+,\u0003\f\u0006\u0000,\u000b\u0001\u0000"+
		"\u0000\u0000-/\u0005\u0005\u0000\u0000.0\u0003\u0010\b\u0000/.\u0001\u0000"+
		"\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000\u0000\u000013\u0003"+
		"\u000e\u0007\u000021\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000067\u0005\u0006\u0000\u00007\r\u0001\u0000\u0000\u00008:\u0005\u0004"+
		"\u0000\u00009;\u0003\u0004\u0002\u0000:9\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<>\u0003\u0010\b\u0000=<\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\u000f\u0001\u0000\u0000"+
		"\u0000?A\u0005\u0007\u0000\u0000@B\b\u0001\u0000\u0000A@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000D\u0011\u0001\u0000\u0000\u0000\t\u0016\u001b\u001f(/4:=C";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}