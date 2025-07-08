package gramaticas.linguine;

// Generated from LinguineParser.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LinguineParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, IF=2, THEN=3, ELSE=4, FUN=5, MATCH=6, WITH=7, SHOW=8, WHILE=9, 
		FOR=10, ID=11, STRING=12, INT=13, FLOAT=14, LPAREN=15, RPAREN=16, PLUS=17, 
		MENOS=18, ASTERISCO=19, DIVISION=20, BARRA=21, INTERR=22, PLUSONE=23, 
		MINUSSONE=24, GT=25, GTE=26, LT=27, LTE=28, EQ=29, SEMICOLON=30, COMA=31, 
		COMILLA=32, ASIGNACION=33, WS=34;
	public static final int
		RULE_prog = 0, RULE_statement = 1, RULE_declaration = 2, RULE_conditional = 3, 
		RULE_function = 4, RULE_function_call = 5, RULE_show_statement = 6, RULE_match_statement = 7, 
		RULE_forLoop = 8, RULE_whileLoop = 9, RULE_asignation = 10, RULE_aritmetic = 11, 
		RULE_expression = 12, RULE_comparator = 13, RULE_param_list = 14, RULE_case = 15, 
		RULE_simbolo = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "statement", "declaration", "conditional", "function", "function_call", 
			"show_statement", "match_statement", "forLoop", "whileLoop", "asignation", 
			"aritmetic", "expression", "comparator", "param_list", "case", "simbolo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'if'", "'then'", "'else'", "'fun'", "'match'", "'with'", 
			"'show'", "'while'", "'for'", null, null, null, null, "'('", "')'", "'+'", 
			"'-'", "'*'", "'/'", "'|'", "'?'", "'++'", "'--'", "'>'", "'>='", "'<'", 
			"'<='", "'='", "';'", "','", "'\"'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "IF", "THEN", "ELSE", "FUN", "MATCH", "WITH", "SHOW", "WHILE", 
			"FOR", "ID", "STRING", "INT", "FLOAT", "LPAREN", "RPAREN", "PLUS", "MENOS", 
			"ASTERISCO", "DIVISION", "BARRA", "INTERR", "PLUSONE", "MINUSSONE", "GT", 
			"GTE", "LT", "LTE", "EQ", "SEMICOLON", "COMA", "COMILLA", "ASIGNACION", 
			"WS"
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
	public String getGrammarFileName() { return "LinguineParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LinguineParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(LinguineParser.SEMICOLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				statement();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3942L) != 0) );
			setState(39);
			match(SEMICOLON);
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
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Show_statementContext show_statement() {
			return getRuleContext(Show_statementContext.class,0);
		}
		public Match_statementContext match_statement() {
			return getRuleContext(Match_statementContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				declaration();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				conditional();
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				function();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				function_call();
				}
				break;
			case SHOW:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				show_statement();
				}
				break;
			case MATCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				match_statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 7);
				{
				setState(47);
				forLoop();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(48);
				whileLoop();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(LinguineParser.LET, 0); }
		public TerminalNode ID() { return getToken(LinguineParser.ID, 0); }
		public TerminalNode EQ() { return getToken(LinguineParser.EQ, 0); }
		public AritmeticContext aritmetic() {
			return getRuleContext(AritmeticContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(LET);
			setState(52);
			match(ID);
			setState(53);
			match(EQ);
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case STRING:
			case INT:
			case FLOAT:
			case LPAREN:
				{
				setState(54);
				aritmetic(0);
				}
				break;
			case IF:
				{
				setState(55);
				conditional();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ConditionalContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LinguineParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LinguineParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(LinguineParser.ID, 0); }
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public AritmeticContext aritmetic() {
			return getRuleContext(AritmeticContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguineParser.RPAREN, 0); }
		public TerminalNode THEN() { return getToken(LinguineParser.THEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LinguineParser.ELSE, 0); }
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_conditional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IF);
			setState(59);
			match(LPAREN);
			setState(60);
			match(ID);
			setState(61);
			comparator();
			setState(62);
			aritmetic(0);
			setState(63);
			match(RPAREN);
			setState(64);
			match(THEN);
			setState(65);
			expression();
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(66);
				match(ELSE);
				setState(67);
				expression();
				}
				break;
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
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(LinguineParser.FUN, 0); }
		public TerminalNode ID() { return getToken(LinguineParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(LinguineParser.LPAREN, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguineParser.RPAREN, 0); }
		public TerminalNode ASIGNACION() { return getToken(LinguineParser.ASIGNACION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(FUN);
			setState(71);
			match(ID);
			setState(72);
			match(LPAREN);
			setState(73);
			param_list();
			setState(74);
			match(RPAREN);
			setState(75);
			match(ASIGNACION);
			setState(76);
			expression();
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
	public static class Function_callContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LinguineParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LinguineParser.ID, i);
		}
		public TerminalNode EQ() { return getToken(LinguineParser.EQ, 0); }
		public TerminalNode LPAREN() { return getToken(LinguineParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LinguineParser.RPAREN, 0); }
		public List<AritmeticContext> aritmetic() {
			return getRuleContexts(AritmeticContext.class);
		}
		public AritmeticContext aritmetic(int i) {
			return getRuleContext(AritmeticContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(LinguineParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(LinguineParser.COMA, i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_call);
		int _la;
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(ID);
				setState(79);
				match(EQ);
				setState(80);
				match(ID);
				setState(81);
				match(LPAREN);
				{
				setState(82);
				aritmetic(0);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(83);
					match(COMA);
					setState(84);
					aritmetic(0);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(90);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(ID);
				setState(93);
				match(LPAREN);
				{
				setState(94);
				aritmetic(0);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(95);
					match(COMA);
					setState(96);
					aritmetic(0);
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(102);
				match(RPAREN);
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
	public static class Show_statementContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(LinguineParser.SHOW, 0); }
		public TerminalNode LPAREN() { return getToken(LinguineParser.LPAREN, 0); }
		public AritmeticContext aritmetic() {
			return getRuleContext(AritmeticContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguineParser.RPAREN, 0); }
		public Show_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitShow_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_statementContext show_statement() throws RecognitionException {
		Show_statementContext _localctx = new Show_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_show_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(SHOW);
			setState(107);
			match(LPAREN);
			setState(108);
			aritmetic(0);
			setState(109);
			match(RPAREN);
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
	public static class Match_statementContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(LinguineParser.MATCH, 0); }
		public TerminalNode ID() { return getToken(LinguineParser.ID, 0); }
		public TerminalNode WITH() { return getToken(LinguineParser.WITH, 0); }
		public List<CaseContext> case_() {
			return getRuleContexts(CaseContext.class);
		}
		public CaseContext case_(int i) {
			return getRuleContext(CaseContext.class,i);
		}
		public Match_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitMatch_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_statementContext match_statement() throws RecognitionException {
		Match_statementContext _localctx = new Match_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_match_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(MATCH);
			setState(112);
			match(ID);
			setState(113);
			match(WITH);
			setState(115); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(114);
					case_();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(117); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LinguineParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(LinguineParser.LPAREN, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LinguineParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LinguineParser.SEMICOLON, i);
		}
		public List<TerminalNode> ID() { return getTokens(LinguineParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LinguineParser.ID, i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public AritmeticContext aritmetic() {
			return getRuleContext(AritmeticContext.class,0);
		}
		public TerminalNode PLUSONE() { return getToken(LinguineParser.PLUSONE, 0); }
		public TerminalNode RPAREN() { return getToken(LinguineParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(FOR);
			setState(120);
			match(LPAREN);
			setState(121);
			declaration();
			setState(122);
			match(SEMICOLON);
			setState(123);
			match(ID);
			setState(124);
			comparator();
			setState(125);
			aritmetic(0);
			setState(126);
			match(SEMICOLON);
			setState(127);
			match(ID);
			setState(128);
			match(PLUSONE);
			setState(129);
			match(RPAREN);
			setState(130);
			expression();
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
	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LinguineParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(LinguineParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(LinguineParser.ID, 0); }
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public AritmeticContext aritmetic() {
			return getRuleContext(AritmeticContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LinguineParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(WHILE);
			setState(133);
			match(LPAREN);
			setState(134);
			match(ID);
			setState(135);
			comparator();
			setState(136);
			aritmetic(0);
			setState(137);
			match(RPAREN);
			setState(138);
			expression();
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
	public static class AsignationContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(LinguineParser.INT, 0); }
		public TerminalNode ID() { return getToken(LinguineParser.ID, 0); }
		public TerminalNode FLOAT() { return getToken(LinguineParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(LinguineParser.STRING, 0); }
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public AsignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitAsignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignationContext asignation() throws RecognitionException {
		AsignationContext _localctx = new AsignationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_asignation);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(FLOAT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				function_call();
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
	public static class AritmeticContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(LinguineParser.LPAREN, 0); }
		public List<AritmeticContext> aritmetic() {
			return getRuleContexts(AritmeticContext.class);
		}
		public AritmeticContext aritmetic(int i) {
			return getRuleContext(AritmeticContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(LinguineParser.RPAREN, 0); }
		public AsignationContext asignation() {
			return getRuleContext(AsignationContext.class,0);
		}
		public TerminalNode ASTERISCO() { return getToken(LinguineParser.ASTERISCO, 0); }
		public TerminalNode DIVISION() { return getToken(LinguineParser.DIVISION, 0); }
		public TerminalNode PLUS() { return getToken(LinguineParser.PLUS, 0); }
		public TerminalNode MENOS() { return getToken(LinguineParser.MENOS, 0); }
		public AritmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aritmetic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitAritmetic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AritmeticContext aritmetic() throws RecognitionException {
		return aritmetic(0);
	}

	private AritmeticContext aritmetic(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AritmeticContext _localctx = new AritmeticContext(_ctx, _parentState);
		AritmeticContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_aritmetic, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(148);
				match(LPAREN);
				setState(149);
				aritmetic(0);
				setState(150);
				match(RPAREN);
				}
				break;
			case ID:
			case STRING:
			case INT:
			case FLOAT:
				{
				setState(152);
				asignation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(167);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AritmeticContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aritmetic);
						setState(155);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(156);
						match(ASTERISCO);
						setState(157);
						aritmetic(6);
						}
						break;
					case 2:
						{
						_localctx = new AritmeticContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aritmetic);
						setState(158);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(159);
						match(DIVISION);
						setState(160);
						aritmetic(5);
						}
						break;
					case 3:
						{
						_localctx = new AritmeticContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aritmetic);
						setState(161);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(162);
						match(PLUS);
						setState(163);
						aritmetic(4);
						}
						break;
					case 4:
						{
						_localctx = new AritmeticContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aritmetic);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						match(MENOS);
						setState(166);
						aritmetic(3);
						}
						break;
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Show_statementContext show_statement() {
			return getRuleContext(Show_statementContext.class,0);
		}
		public Match_statementContext match_statement() {
			return getRuleContext(Match_statementContext.class,0);
		}
		public AritmeticContext aritmetic() {
			return getRuleContext(AritmeticContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				conditional();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				function_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				show_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				match_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				aritmetic(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				forLoop();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				whileLoop();
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
	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(LinguineParser.GT, 0); }
		public TerminalNode GTE() { return getToken(LinguineParser.GTE, 0); }
		public TerminalNode LT() { return getToken(LinguineParser.LT, 0); }
		public TerminalNode LTE() { return getToken(LinguineParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(LinguineParser.EQ, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1040187392L) != 0)) ) {
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
	public static class Param_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LinguineParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LinguineParser.ID, i);
		}
		public List<TerminalNode> COMA() { return getTokens(LinguineParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(LinguineParser.COMA, i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param_list);
		int _la;
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(ID);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(185);
					match(COMA);
					setState(186);
					match(ID);
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				function();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FUN || _la==COMA) {
					{
					setState(196);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMA:
						{
						setState(193);
						match(COMA);
						setState(194);
						match(ID);
						}
						break;
					case FUN:
						{
						setState(195);
						function();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class CaseContext extends ParserRuleContext {
		public TerminalNode BARRA() { return getToken(LinguineParser.BARRA, 0); }
		public TerminalNode ASIGNACION() { return getToken(LinguineParser.ASIGNACION, 0); }
		public TerminalNode INT() { return getToken(LinguineParser.INT, 0); }
		public TerminalNode INTERR() { return getToken(LinguineParser.INTERR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> COMILLA() { return getTokens(LinguineParser.COMILLA); }
		public TerminalNode COMILLA(int i) {
			return getToken(LinguineParser.COMILLA, i);
		}
		public TerminalNode ID() { return getToken(LinguineParser.ID, 0); }
		public CaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseContext case_() throws RecognitionException {
		CaseContext _localctx = new CaseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(BARRA);
			setState(204);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==INTERR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(205);
			match(ASIGNACION);
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
			case IF:
			case MATCH:
			case SHOW:
			case WHILE:
			case FOR:
			case ID:
			case STRING:
			case INT:
			case FLOAT:
			case LPAREN:
				{
				setState(206);
				expression();
				}
				break;
			case COMILLA:
				{
				setState(207);
				match(COMILLA);
				setState(208);
				match(ID);
				setState(209);
				match(COMILLA);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class SimboloContext extends ParserRuleContext {
		public TerminalNode ASTERISCO() { return getToken(LinguineParser.ASTERISCO, 0); }
		public TerminalNode DIVISION() { return getToken(LinguineParser.DIVISION, 0); }
		public TerminalNode PLUS() { return getToken(LinguineParser.PLUS, 0); }
		public TerminalNode MENOS() { return getToken(LinguineParser.MENOS, 0); }
		public SimboloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simbolo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguineParserVisitor ) return ((LinguineParserVisitor<? extends T>)visitor).visitSimbolo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimboloContext simbolo() throws RecognitionException {
		SimboloContext _localctx = new SimboloContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_simbolo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return aritmetic_sempred((AritmeticContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean aritmetic_sempred(AritmeticContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00d7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0004\u0000$\b\u0000\u000b\u0000"+
		"\f\u0000%\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"2\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00029\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003E\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"V\b\u0005\n\u0005\f\u0005Y\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005b\b\u0005"+
		"\n\u0005\f\u0005e\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005i\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007t\b\u0007\u000b\u0007"+
		"\f\u0007u\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u0092\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u009a\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a8\b\u000b\n"+
		"\u000b\f\u000b\u00ab\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00b5\b\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u00bc\b\u000e\n\u000e\f\u000e\u00bf\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c5\b\u000e"+
		"\n\u000e\f\u000e\u00c8\t\u000e\u0003\u000e\u00ca\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00d3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0001\u0016"+
		"\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \u0000\u0003\u0001\u0000\u0019\u001d\u0002\u0000\r"+
		"\r\u0016\u0016\u0001\u0000\u0011\u0014\u00e8\u0000#\u0001\u0000\u0000"+
		"\u0000\u00021\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006"+
		":\u0001\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000"+
		"\u0000\fj\u0001\u0000\u0000\u0000\u000eo\u0001\u0000\u0000\u0000\u0010"+
		"w\u0001\u0000\u0000\u0000\u0012\u0084\u0001\u0000\u0000\u0000\u0014\u0091"+
		"\u0001\u0000\u0000\u0000\u0016\u0099\u0001\u0000\u0000\u0000\u0018\u00b4"+
		"\u0001\u0000\u0000\u0000\u001a\u00b6\u0001\u0000\u0000\u0000\u001c\u00c9"+
		"\u0001\u0000\u0000\u0000\u001e\u00cb\u0001\u0000\u0000\u0000 \u00d4\u0001"+
		"\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000"+
		"$%\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&\'\u0001\u0000\u0000\u0000\'(\u0005\u001e\u0000\u0000(\u0001\u0001"+
		"\u0000\u0000\u0000)2\u0003\u0004\u0002\u0000*2\u0003\u0006\u0003\u0000"+
		"+2\u0003\b\u0004\u0000,2\u0003\n\u0005\u0000-2\u0003\f\u0006\u0000.2\u0003"+
		"\u000e\u0007\u0000/2\u0003\u0010\b\u000002\u0003\u0012\t\u00001)\u0001"+
		"\u0000\u0000\u00001*\u0001\u0000\u0000\u00001+\u0001\u0000\u0000\u0000"+
		"1,\u0001\u0000\u0000\u00001-\u0001\u0000\u0000\u00001.\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000010\u0001\u0000\u0000\u00002\u0003\u0001"+
		"\u0000\u0000\u000034\u0005\u0001\u0000\u000045\u0005\u000b\u0000\u0000"+
		"58\u0005\u001d\u0000\u000069\u0003\u0016\u000b\u000079\u0003\u0006\u0003"+
		"\u000086\u0001\u0000\u0000\u000087\u0001\u0000\u0000\u00009\u0005\u0001"+
		"\u0000\u0000\u0000:;\u0005\u0002\u0000\u0000;<\u0005\u000f\u0000\u0000"+
		"<=\u0005\u000b\u0000\u0000=>\u0003\u001a\r\u0000>?\u0003\u0016\u000b\u0000"+
		"?@\u0005\u0010\u0000\u0000@A\u0005\u0003\u0000\u0000AD\u0003\u0018\f\u0000"+
		"BC\u0005\u0004\u0000\u0000CE\u0003\u0018\f\u0000DB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000E\u0007\u0001\u0000\u0000\u0000FG\u0005\u0005"+
		"\u0000\u0000GH\u0005\u000b\u0000\u0000HI\u0005\u000f\u0000\u0000IJ\u0003"+
		"\u001c\u000e\u0000JK\u0005\u0010\u0000\u0000KL\u0005!\u0000\u0000LM\u0003"+
		"\u0018\f\u0000M\t\u0001\u0000\u0000\u0000NO\u0005\u000b\u0000\u0000OP"+
		"\u0005\u001d\u0000\u0000PQ\u0005\u000b\u0000\u0000QR\u0005\u000f\u0000"+
		"\u0000RW\u0003\u0016\u000b\u0000ST\u0005\u001f\u0000\u0000TV\u0003\u0016"+
		"\u000b\u0000US\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000Z[\u0005\u0010\u0000\u0000[i\u0001\u0000\u0000"+
		"\u0000\\]\u0005\u000b\u0000\u0000]^\u0005\u000f\u0000\u0000^c\u0003\u0016"+
		"\u000b\u0000_`\u0005\u001f\u0000\u0000`b\u0003\u0016\u000b\u0000a_\u0001"+
		"\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000fg\u0005\u0010\u0000\u0000gi\u0001\u0000\u0000\u0000hN\u0001\u0000"+
		"\u0000\u0000h\\\u0001\u0000\u0000\u0000i\u000b\u0001\u0000\u0000\u0000"+
		"jk\u0005\b\u0000\u0000kl\u0005\u000f\u0000\u0000lm\u0003\u0016\u000b\u0000"+
		"mn\u0005\u0010\u0000\u0000n\r\u0001\u0000\u0000\u0000op\u0005\u0006\u0000"+
		"\u0000pq\u0005\u000b\u0000\u0000qs\u0005\u0007\u0000\u0000rt\u0003\u001e"+
		"\u000f\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v\u000f\u0001\u0000\u0000"+
		"\u0000wx\u0005\n\u0000\u0000xy\u0005\u000f\u0000\u0000yz\u0003\u0004\u0002"+
		"\u0000z{\u0005\u001e\u0000\u0000{|\u0005\u000b\u0000\u0000|}\u0003\u001a"+
		"\r\u0000}~\u0003\u0016\u000b\u0000~\u007f\u0005\u001e\u0000\u0000\u007f"+
		"\u0080\u0005\u000b\u0000\u0000\u0080\u0081\u0005\u0017\u0000\u0000\u0081"+
		"\u0082\u0005\u0010\u0000\u0000\u0082\u0083\u0003\u0018\f\u0000\u0083\u0011"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005\t\u0000\u0000\u0085\u0086\u0005"+
		"\u000f\u0000\u0000\u0086\u0087\u0005\u000b\u0000\u0000\u0087\u0088\u0003"+
		"\u001a\r\u0000\u0088\u0089\u0003\u0016\u000b\u0000\u0089\u008a\u0005\u0010"+
		"\u0000\u0000\u008a\u008b\u0003\u0018\f\u0000\u008b\u0013\u0001\u0000\u0000"+
		"\u0000\u008c\u0092\u0005\r\u0000\u0000\u008d\u0092\u0005\u000b\u0000\u0000"+
		"\u008e\u0092\u0005\u000e\u0000\u0000\u008f\u0092\u0005\f\u0000\u0000\u0090"+
		"\u0092\u0003\n\u0005\u0000\u0091\u008c\u0001\u0000\u0000\u0000\u0091\u008d"+
		"\u0001\u0000\u0000\u0000\u0091\u008e\u0001\u0000\u0000\u0000\u0091\u008f"+
		"\u0001\u0000\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0015"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0006\u000b\uffff\uffff\u0000\u0094"+
		"\u0095\u0005\u000f\u0000\u0000\u0095\u0096\u0003\u0016\u000b\u0000\u0096"+
		"\u0097\u0005\u0010\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098"+
		"\u009a\u0003\u0014\n\u0000\u0099\u0093\u0001\u0000\u0000\u0000\u0099\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u00a9\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\n\u0005\u0000\u0000\u009c\u009d\u0005\u0013\u0000\u0000\u009d\u00a8\u0003"+
		"\u0016\u000b\u0006\u009e\u009f\n\u0004\u0000\u0000\u009f\u00a0\u0005\u0014"+
		"\u0000\u0000\u00a0\u00a8\u0003\u0016\u000b\u0005\u00a1\u00a2\n\u0003\u0000"+
		"\u0000\u00a2\u00a3\u0005\u0011\u0000\u0000\u00a3\u00a8\u0003\u0016\u000b"+
		"\u0004\u00a4\u00a5\n\u0002\u0000\u0000\u00a5\u00a6\u0005\u0012\u0000\u0000"+
		"\u00a6\u00a8\u0003\u0016\u000b\u0003\u00a7\u009b\u0001\u0000\u0000\u0000"+
		"\u00a7\u009e\u0001\u0000\u0000\u0000\u00a7\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a4\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u0017\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ac\u00b5\u0003\u0004\u0002\u0000\u00ad\u00b5\u0003\u0006\u0003\u0000"+
		"\u00ae\u00b5\u0003\n\u0005\u0000\u00af\u00b5\u0003\f\u0006\u0000\u00b0"+
		"\u00b5\u0003\u000e\u0007\u0000\u00b1\u00b5\u0003\u0016\u000b\u0000\u00b2"+
		"\u00b5\u0003\u0010\b\u0000\u00b3\u00b5\u0003\u0012\t\u0000\u00b4\u00ac"+
		"\u0001\u0000\u0000\u0000\u00b4\u00ad\u0001\u0000\u0000\u0000\u00b4\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b4\u00af\u0001\u0000\u0000\u0000\u00b4\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u0019"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0007\u0000\u0000\u0000\u00b7\u001b"+
		"\u0001\u0000\u0000\u0000\u00b8\u00bd\u0005\u000b\u0000\u0000\u00b9\u00ba"+
		"\u0005\u001f\u0000\u0000\u00ba\u00bc\u0005\u000b\u0000\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00ca"+
		"\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c6"+
		"\u0003\b\u0004\u0000\u00c1\u00c2\u0005\u001f\u0000\u0000\u00c2\u00c5\u0005"+
		"\u000b\u0000\u0000\u00c3\u00c5\u0003\b\u0004\u0000\u00c4\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c9\u00b8\u0001\u0000\u0000\u0000\u00c9\u00c0\u0001\u0000"+
		"\u0000\u0000\u00ca\u001d\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0015"+
		"\u0000\u0000\u00cc\u00cd\u0007\u0001\u0000\u0000\u00cd\u00d2\u0005!\u0000"+
		"\u0000\u00ce\u00d3\u0003\u0018\f\u0000\u00cf\u00d0\u0005 \u0000\u0000"+
		"\u00d0\u00d1\u0005\u000b\u0000\u0000\u00d1\u00d3\u0005 \u0000\u0000\u00d2"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d2\u00cf\u0001\u0000\u0000\u0000\u00d3"+
		"\u001f\u0001\u0000\u0000\u0000\u00d4\u00d5\u0007\u0002\u0000\u0000\u00d5"+
		"!\u0001\u0000\u0000\u0000\u0012%18DWchu\u0091\u0099\u00a7\u00a9\u00b4"+
		"\u00bd\u00c4\u00c6\u00c9\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}