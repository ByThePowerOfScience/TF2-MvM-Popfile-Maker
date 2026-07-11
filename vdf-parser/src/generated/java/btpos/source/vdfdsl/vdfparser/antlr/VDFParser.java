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
		COMMENT=1, WS=2, STRING=3, NUMBER=4, LITERAL=5, COMMENT_START=6, NL=7, 
		OPENBRACE=8, CLOSEBRACE=9, PRAGMA=10;
	public static final int
		RULE_root = 0, RULE_header_allowed_lines = 1, RULE_nl_line = 2, RULE_line = 3, 
		RULE_keyvalue = 4, RULE_keyable = 5, RULE_keyvalue_strings = 6, RULE_keyvalue_table = 7, 
		RULE_table = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "header_allowed_lines", "nl_line", "line", "keyvalue", "keyable", 
			"keyvalue_strings", "keyvalue_table", "table"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'//'", null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "WS", "STRING", "NUMBER", "LITERAL", "COMMENT_START", 
			"NL", "OPENBRACE", "CLOSEBRACE", "PRAGMA"
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
		public Header_allowed_linesContext header_allowed_lines;
		public List<Header_allowed_linesContext> bases = new ArrayList<Header_allowed_linesContext>();
		public LineContext firstLine;
		public Nl_lineContext nl_line;
		public List<Nl_lineContext> rest = new ArrayList<Nl_lineContext>();
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public List<Header_allowed_linesContext> header_allowed_lines() {
			return getRuleContexts(Header_allowed_linesContext.class);
		}
		public Header_allowed_linesContext header_allowed_lines(int i) {
			return getRuleContext(Header_allowed_linesContext.class,i);
		}
		public List<Nl_lineContext> nl_line() {
			return getRuleContexts(Nl_lineContext.class);
		}
		public Nl_lineContext nl_line(int i) {
			return getRuleContext(Nl_lineContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(18);
					((RootContext)_localctx).header_allowed_lines = header_allowed_lines();
					((RootContext)_localctx).bases.add(((RootContext)_localctx).header_allowed_lines);
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(24);
			((RootContext)_localctx).firstLine = line();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(25);
				((RootContext)_localctx).nl_line = nl_line();
				((RootContext)_localctx).rest.add(((RootContext)_localctx).nl_line);
				}
				}
				setState(30);
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
	public static class Header_allowed_linesContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(VDFParser.COMMENT, 0); }
		public List<TerminalNode> NL() { return getTokens(VDFParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(VDFParser.NL, i);
		}
		public TerminalNode PRAGMA() { return getToken(VDFParser.PRAGMA, 0); }
		public Header_allowed_linesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header_allowed_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterHeader_allowed_lines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitHeader_allowed_lines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitHeader_allowed_lines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Header_allowed_linesContext header_allowed_lines() throws RecognitionException {
		Header_allowed_linesContext _localctx = new Header_allowed_linesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header_allowed_lines);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRAGMA:
				{
				{
				setState(31);
				match(PRAGMA);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(32);
					match(COMMENT);
					}
				}

				}
				}
				break;
			case COMMENT:
				{
				setState(35);
				match(COMMENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(39); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(38);
					match(NL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(41); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Nl_lineContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(VDFParser.NL, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public Nl_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).enterNl_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VDFListener ) ((VDFListener)listener).exitNl_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VDFVisitor ) return ((VDFVisitor<? extends T>)visitor).visitNl_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nl_lineContext nl_line() throws RecognitionException {
		Nl_lineContext _localctx = new Nl_lineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nl_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(NL);
			setState(44);
			line();
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
		enterRule(_localctx, 6, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) {
				{
				setState(46);
				keyvalue();
				}
			}

			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(49);
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
		enterRule(_localctx, 8, RULE_keyvalue);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				keyvalue_strings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
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
		public TerminalNode NUMBER() { return getToken(VDFParser.NUMBER, 0); }
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
		enterRule(_localctx, 10, RULE_keyable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) ) {
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
		enterRule(_localctx, 12, RULE_keyvalue_strings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((Keyvalue_stringsContext)_localctx).key = keyable();
			setState(59);
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
		enterRule(_localctx, 14, RULE_keyvalue_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			((Keyvalue_tableContext)_localctx).key = keyable();
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(62);
					((Keyvalue_tableContext)_localctx).COMMENT = match(COMMENT);
					((Keyvalue_tableContext)_localctx).keyEOLComment.add(((Keyvalue_tableContext)_localctx).COMMENT);
					}
				}

				setState(65);
				match(NL);
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMENT || _la==NL );
			setState(70);
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
		public Nl_lineContext nl_line;
		public List<Nl_lineContext> lines = new ArrayList<Nl_lineContext>();
		public TerminalNode OPENBRACE() { return getToken(VDFParser.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(VDFParser.CLOSEBRACE, 0); }
		public TerminalNode COMMENT() { return getToken(VDFParser.COMMENT, 0); }
		public List<Nl_lineContext> nl_line() {
			return getRuleContexts(Nl_lineContext.class);
		}
		public Nl_lineContext nl_line(int i) {
			return getRuleContext(Nl_lineContext.class,i);
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
		enterRule(_localctx, 16, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(OPENBRACE);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(73);
				((TableContext)_localctx).tableLBracketComment = match(COMMENT);
				}
			}

			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				((TableContext)_localctx).nl_line = nl_line();
				((TableContext)_localctx).lines.add(((TableContext)_localctx).nl_line);
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(81);
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
		"\u0004\u0001\nT\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001b\b\u0000\n\u0000\f\u0000"+
		"\u001e\t\u0000\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001\u0001\u0001"+
		"\u0003\u0001%\b\u0001\u0001\u0001\u0004\u0001(\b\u0001\u000b\u0001\f\u0001"+
		")\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u00030\b\u0003"+
		"\u0001\u0003\u0003\u00033\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004"+
		"7\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0003\u0007@\b\u0007\u0001\u0007\u0004\u0007"+
		"C\b\u0007\u000b\u0007\f\u0007D\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0003\bK\b\b\u0001\b\u0004\bN\b\b\u000b\b\f\bO\u0001\b\u0001\b\u0001"+
		"\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0001"+
		"\u0001\u0000\u0003\u0005V\u0000\u0015\u0001\u0000\u0000\u0000\u0002$\u0001"+
		"\u0000\u0000\u0000\u0004+\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000"+
		"\u0000\b6\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000\f:\u0001"+
		"\u0000\u0000\u0000\u000e=\u0001\u0000\u0000\u0000\u0010H\u0001\u0000\u0000"+
		"\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013\u0012\u0001\u0000\u0000"+
		"\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0018\u0001\u0000\u0000"+
		"\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u001c\u0003\u0006\u0003"+
		"\u0000\u0019\u001b\u0003\u0004\u0002\u0000\u001a\u0019\u0001\u0000\u0000"+
		"\u0000\u001b\u001e\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u0001\u0001\u0000\u0000"+
		"\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001f!\u0005\n\u0000\u0000"+
		" \"\u0005\u0001\u0000\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"%\u0001\u0000\u0000\u0000#%\u0005\u0001\u0000\u0000$\u001f\u0001"+
		"\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000"+
		"&(\u0005\u0007\u0000\u0000\'&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"+
		"\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*\u0003\u0001"+
		"\u0000\u0000\u0000+,\u0005\u0007\u0000\u0000,-\u0003\u0006\u0003\u0000"+
		"-\u0005\u0001\u0000\u0000\u0000.0\u0003\b\u0004\u0000/.\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000\u0000\u000013\u0005\u0001"+
		"\u0000\u000021\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0007"+
		"\u0001\u0000\u0000\u000047\u0003\f\u0006\u000057\u0003\u000e\u0007\u0000"+
		"64\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u00007\t\u0001\u0000\u0000"+
		"\u000089\u0007\u0000\u0000\u00009\u000b\u0001\u0000\u0000\u0000:;\u0003"+
		"\n\u0005\u0000;<\u0003\n\u0005\u0000<\r\u0001\u0000\u0000\u0000=B\u0003"+
		"\n\u0005\u0000>@\u0005\u0001\u0000\u0000?>\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0005\u0007\u0000\u0000"+
		"B?\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0003\u0010"+
		"\b\u0000G\u000f\u0001\u0000\u0000\u0000HJ\u0005\b\u0000\u0000IK\u0005"+
		"\u0001\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"KM\u0001\u0000\u0000\u0000LN\u0003\u0004\u0002\u0000ML\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0005\t\u0000\u0000R\u0011\u0001"+
		"\u0000\u0000\u0000\f\u0015\u001c!$)/26?DJO";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}