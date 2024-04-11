// Generated from java-escape by ANTLR 4.11.1

  //package backend;
  import backend.*;
  import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, RANGE_OP=27, DOT_OP=28, AND_OP=29, OR_OP=30, NOT_OP=31, 
		LBRACK=32, RBRACK=33, LPARANTHESIS=34, RPARANTHESIS=35, COMMA=36, NUMBER=37, 
		STRING=38, BOOLEAN=39, ID=40, WS=41, COMMENT=42, LINE_COMMENT=43, DOUBLE=44;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_assignment = 2, RULE_expression = 3, 
		RULE_parenExpr = 4, RULE_functionCall = 5, RULE_value = 6, RULE_arrayLiteral = 7, 
		RULE_loop = 8, RULE_whileloop = 9, RULE_arguments = 10, RULE_function = 11, 
		RULE_parameters = 12, RULE_methodCall = 13, RULE_ifelse = 14, RULE_type = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "assignment", "expression", "parenExpr", "functionCall", 
			"value", "arrayLiteral", "loop", "whileloop", "arguments", "function", 
			"parameters", "methodCall", "ifelse", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'print'", "'='", "'*'", "'/'", "'+'", "'-'", "'++'", "'<'", 
			"'>'", "'<='", "'>='", "'!='", "'=='", "'for'", "'in'", "'{'", "'}'", 
			"'while'", "'function'", "'if'", "'else'", "'Int'", "'String'", "'Boolean'", 
			"'Double'", "'..'", "'.'", "'&&'", "'||'", "'!'", "'['", "']'", "'('", 
			"')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "RANGE_OP", "DOT_OP", "AND_OP", "OR_OP", "NOT_OP", 
			"LBRACK", "RBRACK", "LPARANTHESIS", "RPARANTHESIS", "COMMA", "NUMBER", 
			"STRING", "BOOLEAN", "ID", "WS", "COMMENT", "LINE_COMMENT", "DOUBLE"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    void error(String message) {
	        System.err.println("Error: " + message);
	        throw new RuntimeException(message);
	    }

	public PLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Expr expr;
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode EOF() { return getToken(PLParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677522198532L) != 0) {
				{
				{
				setState(32);
				((ProgramContext)_localctx).statement = statement();
				((ProgramContext)_localctx).statements.add(((ProgramContext)_localctx).statement);
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
			 
			        List<Expr> exprList = new ArrayList<>();
			        for (StatementContext stmt : ((ProgramContext)_localctx).statements) {
			            exprList.add(stmt.expr);
			        }
			        ((ProgramContext)_localctx).expr =  new Block(exprList);
			    
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
		public Expr expr;
		public AssignmentContext assignment;
		public ExpressionContext expression;
		public LoopContext loop;
		public FunctionContext function;
		public IfelseContext ifelse;
		public WhileloopContext whileloop;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public IfelseContext ifelse() {
			return getRuleContext(IfelseContext.class,0);
		}
		public WhileloopContext whileloop() {
			return getRuleContext(WhileloopContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				((StatementContext)_localctx).assignment = assignment();
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(42);
					match(T__0);
					}
					break;
				case EOF:
				case T__1:
				case T__14:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case NOT_OP:
				case LBRACK:
				case LPARANTHESIS:
				case NUMBER:
				case STRING:
				case BOOLEAN:
				case ID:
				case DOUBLE:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).assignment.expr; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				((StatementContext)_localctx).expression = expression(0);
				setState(49);
				match(T__0);
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).expression.expr; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				match(T__1);
				setState(53);
				match(LPARANTHESIS);
				setState(54);
				((StatementContext)_localctx).expression = expression(0);
				setState(55);
				match(RPARANTHESIS);
				setState(58);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(56);
					match(T__0);
					}
					break;
				case EOF:
				case T__1:
				case T__14:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case NOT_OP:
				case LBRACK:
				case LPARANTHESIS:
				case NUMBER:
				case STRING:
				case BOOLEAN:
				case ID:
				case DOUBLE:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 ((StatementContext)_localctx).expr =  new PrintExpr(((StatementContext)_localctx).expression.expr); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				((StatementContext)_localctx).loop = loop();
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).loop.expr; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				((StatementContext)_localctx).function = function();
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).function.funcResult;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				((StatementContext)_localctx).ifelse = ifelse();
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).ifelse.expr; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(71);
				((StatementContext)_localctx).whileloop = whileloop();
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).whileloop.expr; 
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
	public static class AssignmentContext extends ParserRuleContext {
		public Expr expr;
		public TypeContext type;
		public Token ID;
		public ExpressionContext expression;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
			case T__23:
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				((AssignmentContext)_localctx).type = type();
				setState(77);
				((AssignmentContext)_localctx).ID = match(ID);
				setState(78);
				match(T__2);
				setState(79);
				((AssignmentContext)_localctx).expression = expression(0);
				 ((AssignmentContext)_localctx).expr =  new AssignmentExpr((((AssignmentContext)_localctx).ID!=null?((AssignmentContext)_localctx).ID.getText():null), (((AssignmentContext)_localctx).type!=null?_input.getText(((AssignmentContext)_localctx).type.start,((AssignmentContext)_localctx).type.stop):null), ((AssignmentContext)_localctx).expression.expr); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((AssignmentContext)_localctx).ID = match(ID);
				setState(83);
				match(T__2);
				setState(84);
				((AssignmentContext)_localctx).expression = expression(0);
				 ((AssignmentContext)_localctx).expr =  new AssignmentExpr((((AssignmentContext)_localctx).ID!=null?((AssignmentContext)_localctx).ID.getText():null), null, ((AssignmentContext)_localctx).expression.expr); 
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
	public static class ExpressionContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionContext left;
		public ExpressionContext expression;
		public FunctionCallContext functionCall;
		public ValueContext value;
		public Token ID;
		public Token op;
		public ExpressionContext right;
		public ArgumentsContext arguments;
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode NOT_OP() { return getToken(PLParser.NOT_OP, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode AND_OP() { return getToken(PLParser.AND_OP, 0); }
		public TerminalNode OR_OP() { return getToken(PLParser.OR_OP, 0); }
		public TerminalNode DOT_OP() { return getToken(PLParser.DOT_OP, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(90);
				match(LPARANTHESIS);
				setState(91);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(92);
				match(RPARANTHESIS);
				 ((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).expression.expr; 
				}
				break;
			case 2:
				{
				setState(95);
				((ExpressionContext)_localctx).functionCall = functionCall();
				 ((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).functionCall.expr; 
				}
				break;
			case 3:
				{
				setState(98);
				match(NOT_OP);
				setState(99);
				((ExpressionContext)_localctx).expression = expression(10);
				 ((ExpressionContext)_localctx).expr =  new LogicalNotExpr(((ExpressionContext)_localctx).expression.expr); 
				}
				break;
			case 4:
				{
				setState(102);
				((ExpressionContext)_localctx).value = value();
				 ((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).value.expr; 
				}
				break;
			case 5:
				{
				setState(105);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).expr =  new VariableExpr((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(110);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						 
						                  ((ExpressionContext)_localctx).expr =  new Arithmetics((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("*") ? Operator.Mul : Operator.Div, ((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr); 
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(115);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(116);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(9);
						 
						                  ((ExpressionContext)_localctx).expr =  new Arithmetics((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("+") ? Operator.Add : Operator.Sub, ((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr); 
						              
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(120);
						match(AND_OP);
						setState(121);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(7);

						                  ((ExpressionContext)_localctx).expr =  new LogicalAndExpr(((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr);
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(124);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(125);
						match(OR_OP);
						setState(126);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(6);

						                  ((ExpressionContext)_localctx).expr =  new LogicalOrExpr(((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr);
						              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(130);
						match(T__7);
						setState(131);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(5);
						 ((ExpressionContext)_localctx).expr =  new ConcatExpr(((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(134);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(135);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 32256L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(4);
						 
						                  backend.Comparator comparator = null; // Initialize with null
						                  switch ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)) {
						                      case "<": comparator  = backend.Comparator.LT; break;
						                      case ">": comparator  = backend.Comparator.GT; break;
						                      case "<=": comparator = backend.Comparator.LE; break;
						                      case ">=": comparator = backend.Comparator.GE; break;
						                      case "!=": comparator = backend.Comparator.NE; break;
						                      case "==": comparator = backend.Comparator.EQ; break;
						                      default: throw new IllegalArgumentException("Unsupported operator: " + (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                  }
						                  ((ExpressionContext)_localctx).expr =  new Compare(comparator, ((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr); 
						              
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(139);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(140);
						match(DOT_OP);
						setState(141);
						((ExpressionContext)_localctx).ID = match(ID);
						setState(142);
						match(LPARANTHESIS);
						setState(143);
						((ExpressionContext)_localctx).arguments = arguments();
						setState(144);
						match(RPARANTHESIS);

						                  ((ExpressionContext)_localctx).expr =  new MethodCallExpr(((ExpressionContext)_localctx).expression.expr, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).arguments.args);
						              
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class ParenExprContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionContext expression;
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public ParenExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitParenExpr(this);
		}
	}

	public final ParenExprContext parenExpr() throws RecognitionException {
		ParenExprContext _localctx = new ParenExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parenExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(LPARANTHESIS);
			setState(153);
			((ParenExprContext)_localctx).expression = expression(0);
			setState(154);
			match(RPARANTHESIS);
			 ((ParenExprContext)_localctx).expr =  ((ParenExprContext)_localctx).expression.expr; 
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
	public static class FunctionCallContext extends ParserRuleContext {
		public Expr expr;
		public Token ID;
		public ArgumentsContext arguments;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((FunctionCallContext)_localctx).ID = match(ID);
			setState(158);
			match(LPARANTHESIS);
			setState(159);
			((FunctionCallContext)_localctx).arguments = arguments();
			setState(160);
			match(RPARANTHESIS);
			((FunctionCallContext)_localctx).expr =  new Invoke((((FunctionCallContext)_localctx).ID!=null?((FunctionCallContext)_localctx).ID.getText():null), ((FunctionCallContext)_localctx).arguments.args);
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
	public static class ValueContext extends ParserRuleContext {
		public Expr expr;
		public Token NUMBER;
		public Token STRING;
		public Token BOOLEAN;
		public Token DOUBLE;
		public ArrayLiteralContext arrayLiteral;
		public TerminalNode NUMBER() { return getToken(PLParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(PLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(PLParser.BOOLEAN, 0); }
		public TerminalNode DOUBLE() { return getToken(PLParser.DOUBLE, 0); }
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				((ValueContext)_localctx).NUMBER = match(NUMBER);
				 ((ValueContext)_localctx).expr =  new IntExpr((((ValueContext)_localctx).NUMBER!=null?((ValueContext)_localctx).NUMBER.getText():null)); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				((ValueContext)_localctx).STRING = match(STRING);
				 ((ValueContext)_localctx).expr =  new StringExpr((((ValueContext)_localctx).STRING!=null?((ValueContext)_localctx).STRING.getText():null).substring(1, (((ValueContext)_localctx).STRING!=null?((ValueContext)_localctx).STRING.getText():null).length() - 1)); 
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				((ValueContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((ValueContext)_localctx).expr =  new BooleanLiteral((((ValueContext)_localctx).BOOLEAN!=null?((ValueContext)_localctx).BOOLEAN.getText():null)); 
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				((ValueContext)_localctx).DOUBLE = match(DOUBLE);
				 ((ValueContext)_localctx).expr =  new DoubleExpr((((ValueContext)_localctx).DOUBLE!=null?((ValueContext)_localctx).DOUBLE.getText():null)); 
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				((ValueContext)_localctx).arrayLiteral = arrayLiteral();
				 ((ValueContext)_localctx).expr =  ((ValueContext)_localctx).arrayLiteral.expr; 
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
	public static class ArrayLiteralContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionContext expression;
		public List<ExpressionContext> elements = new ArrayList<ExpressionContext>();
		public TerminalNode LBRACK() { return getToken(PLParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PLParser.RBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PLParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitArrayLiteral(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(LBRACK);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677392666624L) != 0) {
				{
				setState(177);
				((ArrayLiteralContext)_localctx).expression = expression(0);
				((ArrayLiteralContext)_localctx).elements.add(((ArrayLiteralContext)_localctx).expression);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(178);
					match(COMMA);
					setState(179);
					((ArrayLiteralContext)_localctx).expression = expression(0);
					((ArrayLiteralContext)_localctx).elements.add(((ArrayLiteralContext)_localctx).expression);
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(187);
			match(RBRACK);

			        List<Expr> exprList = new ArrayList<>();
			        for (ExpressionContext element : ((ArrayLiteralContext)_localctx).elements) {
			            exprList.add(element.expr); // Convert each ExpressionContext to Expr
			        }
			        ((ArrayLiteralContext)_localctx).expr =  new ArrayExpr(exprList);
			    
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
	public static class LoopContext extends ParserRuleContext {
		public Expr expr;
		public Token ID;
		public ExpressionContext startexpr;
		public ExpressionContext endexpr;
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode RANGE_OP() { return getToken(PLParser.RANGE_OP, 0); }
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__14);
			setState(191);
			match(LPARANTHESIS);
			setState(192);
			((LoopContext)_localctx).ID = match(ID);
			setState(193);
			match(T__15);
			setState(194);
			((LoopContext)_localctx).startexpr = expression(0);
			setState(195);
			match(RANGE_OP);
			setState(196);
			((LoopContext)_localctx).endexpr = expression(0);
			setState(197);
			match(RPARANTHESIS);
			setState(198);
			match(T__16);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677522198532L) != 0) {
				{
				{
				setState(199);
				((LoopContext)_localctx).statement = statement();
				((LoopContext)_localctx).statements.add(((LoopContext)_localctx).statement);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			match(T__17);

			        List<Expr> exprList = new ArrayList<>();
			        for (StatementContext stmt : ((LoopContext)_localctx).statements) {
			            exprList.add(stmt.expr);
			        } // This closing brace ends the for-loop
			        ((LoopContext)_localctx).expr =  new ForLoopExpr((((LoopContext)_localctx).ID!=null?((LoopContext)_localctx).ID.getText():null), ((LoopContext)_localctx).startexpr.expr, ((LoopContext)_localctx).endexpr.expr, new Block(exprList));
			      
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
	public static class WhileloopContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionContext condition;
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterWhileloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitWhileloop(this);
		}
	}

	public final WhileloopContext whileloop() throws RecognitionException {
		WhileloopContext _localctx = new WhileloopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileloop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__18);
			setState(209);
			match(LPARANTHESIS);
			setState(210);
			((WhileloopContext)_localctx).condition = expression(0);
			setState(211);
			match(RPARANTHESIS);
			setState(212);
			match(T__16);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677522198532L) != 0) {
				{
				{
				setState(213);
				((WhileloopContext)_localctx).statement = statement();
				((WhileloopContext)_localctx).statements.add(((WhileloopContext)_localctx).statement);
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
			match(T__17);

			        List<Expr> exprList = new ArrayList<>();
			        for (StatementContext stmt : ((WhileloopContext)_localctx).statements) {
			            exprList.add(stmt.expr);
			        }
			        ((WhileloopContext)_localctx).expr =  new While(((WhileloopContext)_localctx).condition.expr, new Block(exprList));
			    
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expr> args;
		public ExpressionContext expression;
		public List<ExpressionContext> expressionList = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PLParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677392666624L) != 0) {
				{
				setState(222);
				((ArgumentsContext)_localctx).expression = expression(0);
				((ArgumentsContext)_localctx).expressionList.add(((ArgumentsContext)_localctx).expression);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(223);
					match(COMMA);
					setState(224);
					((ArgumentsContext)_localctx).expression = expression(0);
					((ArgumentsContext)_localctx).expressionList.add(((ArgumentsContext)_localctx).expression);
					}
					}
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			        ((ArgumentsContext)_localctx).args =  new ArrayList<>();
			        if (((ArgumentsContext)_localctx).expressionList != null) { // Check if any expressions were matched
			            for (ExpressionContext exprCtx : ((ArgumentsContext)_localctx).expressionList) {
			                if (exprCtx != null && exprCtx.expr != null) {
			                    // Safely add the expression's corresponding Expr object
			                    _localctx.args.add(exprCtx.expr);
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
	public static class FunctionContext extends ParserRuleContext {
		public Expr funcResult;
		public Token ID;
		public ParametersContext params;
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__19);
			setState(235);
			((FunctionContext)_localctx).ID = match(ID);
			setState(236);
			match(LPARANTHESIS);
			setState(237);
			((FunctionContext)_localctx).params = parameters();
			setState(238);
			match(RPARANTHESIS);
			setState(239);
			match(T__16);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677522198532L) != 0) {
				{
				{
				setState(240);
				((FunctionContext)_localctx).statement = statement();
				((FunctionContext)_localctx).statements.add(((FunctionContext)_localctx).statement);
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			match(T__17);

			            List<Expr> exprList = new ArrayList<>();
			            for (StatementContext stmt : ((FunctionContext)_localctx).statements) {
			                exprList.add(stmt.expr);
			            } // This closing brace ends the for-loop
			            ((FunctionContext)_localctx).funcResult =  new Declare((((FunctionContext)_localctx).ID!=null?((FunctionContext)_localctx).ID.getText():null), ((FunctionContext)_localctx).params.ids, new Block(exprList));
			        
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
	public static class ParametersContext extends ParserRuleContext {
		public List<String> ids;
		public Token first;
		public Token ID;
		public List<Token> rest = new ArrayList<Token>();
		public List<TerminalNode> ID() { return getTokens(PLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PLParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PLParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(249);
				((ParametersContext)_localctx).first = match(ID);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(250);
					match(COMMA);
					setState(251);
					((ParametersContext)_localctx).ID = match(ID);
					((ParametersContext)_localctx).rest.add(((ParametersContext)_localctx).ID);
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			    ((ParametersContext)_localctx).ids =  new ArrayList<>();
			    if (((ParametersContext)_localctx).first != null) {
			        _localctx.ids.add((((ParametersContext)_localctx).first!=null?((ParametersContext)_localctx).first.getText():null));
			        if (((ParametersContext)_localctx).rest != null) {
			            for (Token id : ((ParametersContext)_localctx).rest) {
			                _localctx.ids.add(id.getText());
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
	public static class MethodCallContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionContext expression;
		public Token methodName;
		public ArgumentsContext arguments;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_OP() { return getToken(PLParser.DOT_OP, 0); }
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			((MethodCallContext)_localctx).expression = expression(0);
			setState(262);
			match(DOT_OP);
			setState(263);
			((MethodCallContext)_localctx).methodName = match(ID);
			setState(264);
			match(LPARANTHESIS);
			setState(265);
			((MethodCallContext)_localctx).arguments = arguments();
			setState(266);
			match(RPARANTHESIS);

			        ((MethodCallContext)_localctx).expr =  new MethodCallExpr(((MethodCallContext)_localctx).expression.expr, (((MethodCallContext)_localctx).methodName!=null?((MethodCallContext)_localctx).methodName.getText():null), ((MethodCallContext)_localctx).arguments.args);
			      
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
	public static class IfelseContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionContext condition;
		public StatementContext statement;
		public List<StatementContext> trueStatements = new ArrayList<StatementContext>();
		public List<StatementContext> falseStatements = new ArrayList<StatementContext>();
		public TerminalNode LPARANTHESIS() { return getToken(PLParser.LPARANTHESIS, 0); }
		public TerminalNode RPARANTHESIS() { return getToken(PLParser.RPARANTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterIfelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitIfelse(this);
		}
	}

	public final IfelseContext ifelse() throws RecognitionException {
		IfelseContext _localctx = new IfelseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__20);
			setState(270);
			match(LPARANTHESIS);
			setState(271);
			((IfelseContext)_localctx).condition = expression(0);
			setState(272);
			match(RPARANTHESIS);
			setState(273);
			match(T__16);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677522198532L) != 0) {
				{
				{
				setState(274);
				((IfelseContext)_localctx).statement = statement();
				((IfelseContext)_localctx).trueStatements.add(((IfelseContext)_localctx).statement);
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(280);
			match(T__17);
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(281);
				match(T__21);
				setState(282);
				match(T__16);
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 19677522198532L) != 0) {
					{
					{
					setState(283);
					((IfelseContext)_localctx).statement = statement();
					((IfelseContext)_localctx).falseStatements.add(((IfelseContext)_localctx).statement);
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(289);
				match(T__17);
				}
			}


			        List<Expr> trueExprList = new ArrayList<>();
			        for (StatementContext stmt : ((IfelseContext)_localctx).trueStatements) {
			            trueExprList.add(stmt.expr);
			        }
			        
			        List<Expr> falseExprList = new ArrayList<>();
			        if (((IfelseContext)_localctx).falseStatements != null) { // Check if there are statements in the else block
			            for (StatementContext stmt : ((IfelseContext)_localctx).falseStatements) {
			                falseExprList.add(stmt.expr);
			            }
			        }
			        
			        ((IfelseContext)_localctx).expr =  new Ifelse(((IfelseContext)_localctx).condition.expr, new Block(trueExprList), new Block(falseExprList));
			      
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0) ) {
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
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u0129\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"-\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"K\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002X\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003l\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u0094\b\u0003\n\u0003\f\u0003\u0097\t\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00af\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00b5\b\u0007\n\u0007\f\u0007"+
		"\u00b8\t\u0007\u0003\u0007\u00ba\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0005\b\u00c9\b\b\n\b\f\b\u00cc\t\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00d7\b\t\n"+
		"\t\f\t\u00da\t\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00e2\b\n\n\n\f\n\u00e5\t\n\u0003\n\u00e7\b\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00f2\b\u000b\n\u000b\f\u000b\u00f5\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00fd\b\f\n\f"+
		"\f\f\u0100\t\f\u0003\f\u0102\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0114\b\u000e\n"+
		"\u000e\f\u000e\u0117\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u011d\b\u000e\n\u000e\f\u000e\u0120\t\u000e\u0001\u000e"+
		"\u0003\u000e\u0123\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0000\u0001\u0006\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000"+
		"\u0004\u0005\u0001\u0000\u0006\u0007\u0001\u0000\t\u000e\u0001\u0000\u0017"+
		"\u001a\u013d\u0000#\u0001\u0000\u0000\u0000\u0002J\u0001\u0000\u0000\u0000"+
		"\u0004W\u0001\u0000\u0000\u0000\u0006k\u0001\u0000\u0000\u0000\b\u0098"+
		"\u0001\u0000\u0000\u0000\n\u009d\u0001\u0000\u0000\u0000\f\u00ae\u0001"+
		"\u0000\u0000\u0000\u000e\u00b0\u0001\u0000\u0000\u0000\u0010\u00be\u0001"+
		"\u0000\u0000\u0000\u0012\u00d0\u0001\u0000\u0000\u0000\u0014\u00e6\u0001"+
		"\u0000\u0000\u0000\u0016\u00ea\u0001\u0000\u0000\u0000\u0018\u0101\u0001"+
		"\u0000\u0000\u0000\u001a\u0105\u0001\u0000\u0000\u0000\u001c\u010d\u0001"+
		"\u0000\u0000\u0000\u001e\u0126\u0001\u0000\u0000\u0000 \"\u0003\u0002"+
		"\u0001\u0000! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000"+
		"%#\u0001\u0000\u0000\u0000&\'\u0005\u0000\u0000\u0001\'(\u0006\u0000\uffff"+
		"\uffff\u0000(\u0001\u0001\u0000\u0000\u0000),\u0003\u0004\u0002\u0000"+
		"*-\u0005\u0001\u0000\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000,+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0006\u0001"+
		"\uffff\uffff\u0000/K\u0001\u0000\u0000\u000001\u0003\u0006\u0003\u0000"+
		"12\u0005\u0001\u0000\u000023\u0006\u0001\uffff\uffff\u00003K\u0001\u0000"+
		"\u0000\u000045\u0005\u0002\u0000\u000056\u0005\"\u0000\u000067\u0003\u0006"+
		"\u0003\u00007:\u0005#\u0000\u00008;\u0005\u0001\u0000\u00009;\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<=\u0006\u0001\uffff\uffff\u0000=K\u0001\u0000\u0000"+
		"\u0000>?\u0003\u0010\b\u0000?@\u0006\u0001\uffff\uffff\u0000@K\u0001\u0000"+
		"\u0000\u0000AB\u0003\u0016\u000b\u0000BC\u0006\u0001\uffff\uffff\u0000"+
		"CK\u0001\u0000\u0000\u0000DE\u0003\u001c\u000e\u0000EF\u0006\u0001\uffff"+
		"\uffff\u0000FK\u0001\u0000\u0000\u0000GH\u0003\u0012\t\u0000HI\u0006\u0001"+
		"\uffff\uffff\u0000IK\u0001\u0000\u0000\u0000J)\u0001\u0000\u0000\u0000"+
		"J0\u0001\u0000\u0000\u0000J4\u0001\u0000\u0000\u0000J>\u0001\u0000\u0000"+
		"\u0000JA\u0001\u0000\u0000\u0000JD\u0001\u0000\u0000\u0000JG\u0001\u0000"+
		"\u0000\u0000K\u0003\u0001\u0000\u0000\u0000LM\u0003\u001e\u000f\u0000"+
		"MN\u0005(\u0000\u0000NO\u0005\u0003\u0000\u0000OP\u0003\u0006\u0003\u0000"+
		"PQ\u0006\u0002\uffff\uffff\u0000QX\u0001\u0000\u0000\u0000RS\u0005(\u0000"+
		"\u0000ST\u0005\u0003\u0000\u0000TU\u0003\u0006\u0003\u0000UV\u0006\u0002"+
		"\uffff\uffff\u0000VX\u0001\u0000\u0000\u0000WL\u0001\u0000\u0000\u0000"+
		"WR\u0001\u0000\u0000\u0000X\u0005\u0001\u0000\u0000\u0000YZ\u0006\u0003"+
		"\uffff\uffff\u0000Z[\u0005\"\u0000\u0000[\\\u0003\u0006\u0003\u0000\\"+
		"]\u0005#\u0000\u0000]^\u0006\u0003\uffff\uffff\u0000^l\u0001\u0000\u0000"+
		"\u0000_`\u0003\n\u0005\u0000`a\u0006\u0003\uffff\uffff\u0000al\u0001\u0000"+
		"\u0000\u0000bc\u0005\u001f\u0000\u0000cd\u0003\u0006\u0003\nde\u0006\u0003"+
		"\uffff\uffff\u0000el\u0001\u0000\u0000\u0000fg\u0003\f\u0006\u0000gh\u0006"+
		"\u0003\uffff\uffff\u0000hl\u0001\u0000\u0000\u0000ij\u0005(\u0000\u0000"+
		"jl\u0006\u0003\uffff\uffff\u0000kY\u0001\u0000\u0000\u0000k_\u0001\u0000"+
		"\u0000\u0000kb\u0001\u0000\u0000\u0000kf\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000l\u0095\u0001\u0000\u0000\u0000mn\n\t\u0000\u0000no"+
		"\u0007\u0000\u0000\u0000op\u0003\u0006\u0003\npq\u0006\u0003\uffff\uffff"+
		"\u0000q\u0094\u0001\u0000\u0000\u0000rs\n\b\u0000\u0000st\u0007\u0001"+
		"\u0000\u0000tu\u0003\u0006\u0003\tuv\u0006\u0003\uffff\uffff\u0000v\u0094"+
		"\u0001\u0000\u0000\u0000wx\n\u0006\u0000\u0000xy\u0005\u001d\u0000\u0000"+
		"yz\u0003\u0006\u0003\u0007z{\u0006\u0003\uffff\uffff\u0000{\u0094\u0001"+
		"\u0000\u0000\u0000|}\n\u0005\u0000\u0000}~\u0005\u001e\u0000\u0000~\u007f"+
		"\u0003\u0006\u0003\u0006\u007f\u0080\u0006\u0003\uffff\uffff\u0000\u0080"+
		"\u0094\u0001\u0000\u0000\u0000\u0081\u0082\n\u0004\u0000\u0000\u0082\u0083"+
		"\u0005\b\u0000\u0000\u0083\u0084\u0003\u0006\u0003\u0005\u0084\u0085\u0006"+
		"\u0003\uffff\uffff\u0000\u0085\u0094\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\n\u0003\u0000\u0000\u0087\u0088\u0007\u0002\u0000\u0000\u0088\u0089\u0003"+
		"\u0006\u0003\u0004\u0089\u008a\u0006\u0003\uffff\uffff\u0000\u008a\u0094"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\n\u0007\u0000\u0000\u008c\u008d\u0005"+
		"\u001c\u0000\u0000\u008d\u008e\u0005(\u0000\u0000\u008e\u008f\u0005\""+
		"\u0000\u0000\u008f\u0090\u0003\u0014\n\u0000\u0090\u0091\u0005#\u0000"+
		"\u0000\u0091\u0092\u0006\u0003\uffff\uffff\u0000\u0092\u0094\u0001\u0000"+
		"\u0000\u0000\u0093m\u0001\u0000\u0000\u0000\u0093r\u0001\u0000\u0000\u0000"+
		"\u0093w\u0001\u0000\u0000\u0000\u0093|\u0001\u0000\u0000\u0000\u0093\u0081"+
		"\u0001\u0000\u0000\u0000\u0093\u0086\u0001\u0000\u0000\u0000\u0093\u008b"+
		"\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0007"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\"\u0000\u0000\u0099\u009a\u0003\u0006\u0003\u0000\u009a\u009b\u0005"+
		"#\u0000\u0000\u009b\u009c\u0006\u0004\uffff\uffff\u0000\u009c\t\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005(\u0000\u0000\u009e\u009f\u0005\""+
		"\u0000\u0000\u009f\u00a0\u0003\u0014\n\u0000\u00a0\u00a1\u0005#\u0000"+
		"\u0000\u00a1\u00a2\u0006\u0005\uffff\uffff\u0000\u00a2\u000b\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0005%\u0000\u0000\u00a4\u00af\u0006\u0006\uffff"+
		"\uffff\u0000\u00a5\u00a6\u0005&\u0000\u0000\u00a6\u00af\u0006\u0006\uffff"+
		"\uffff\u0000\u00a7\u00a8\u0005\'\u0000\u0000\u00a8\u00af\u0006\u0006\uffff"+
		"\uffff\u0000\u00a9\u00aa\u0005,\u0000\u0000\u00aa\u00af\u0006\u0006\uffff"+
		"\uffff\u0000\u00ab\u00ac\u0003\u000e\u0007\u0000\u00ac\u00ad\u0006\u0006"+
		"\uffff\uffff\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00a3\u0001"+
		"\u0000\u0000\u0000\u00ae\u00a5\u0001\u0000\u0000\u0000\u00ae\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ae\u00a9\u0001\u0000\u0000\u0000\u00ae\u00ab\u0001"+
		"\u0000\u0000\u0000\u00af\r\u0001\u0000\u0000\u0000\u00b0\u00b9\u0005 "+
		"\u0000\u0000\u00b1\u00b6\u0003\u0006\u0003\u0000\u00b2\u00b3\u0005$\u0000"+
		"\u0000\u00b3\u00b5\u0003\u0006\u0003\u0000\u00b4\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005!\u0000\u0000\u00bc\u00bd\u0006\u0007\uffff\uffff"+
		"\u0000\u00bd\u000f\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\u000f\u0000"+
		"\u0000\u00bf\u00c0\u0005\"\u0000\u0000\u00c0\u00c1\u0005(\u0000\u0000"+
		"\u00c1\u00c2\u0005\u0010\u0000\u0000\u00c2\u00c3\u0003\u0006\u0003\u0000"+
		"\u00c3\u00c4\u0005\u001b\u0000\u0000\u00c4\u00c5\u0003\u0006\u0003\u0000"+
		"\u00c5\u00c6\u0005#\u0000\u0000\u00c6\u00ca\u0005\u0011\u0000\u0000\u00c7"+
		"\u00c9\u0003\u0002\u0001\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0012\u0000\u0000\u00ce"+
		"\u00cf\u0006\b\uffff\uffff\u0000\u00cf\u0011\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0005\u0013\u0000\u0000\u00d1\u00d2\u0005\"\u0000\u0000\u00d2\u00d3"+
		"\u0003\u0006\u0003\u0000\u00d3\u00d4\u0005#\u0000\u0000\u00d4\u00d8\u0005"+
		"\u0011\u0000\u0000\u00d5\u00d7\u0003\u0002\u0001\u0000\u00d6\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00db\u0001"+
		"\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005"+
		"\u0012\u0000\u0000\u00dc\u00dd\u0006\t\uffff\uffff\u0000\u00dd\u0013\u0001"+
		"\u0000\u0000\u0000\u00de\u00e3\u0003\u0006\u0003\u0000\u00df\u00e0\u0005"+
		"$\u0000\u0000\u00e0\u00e2\u0003\u0006\u0003\u0000\u00e1\u00df\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00de\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0006\n\uffff\uffff\u0000\u00e9\u0015\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0005\u0014\u0000\u0000\u00eb\u00ec\u0005(\u0000"+
		"\u0000\u00ec\u00ed\u0005\"\u0000\u0000\u00ed\u00ee\u0003\u0018\f\u0000"+
		"\u00ee\u00ef\u0005#\u0000\u0000\u00ef\u00f3\u0005\u0011\u0000\u0000\u00f0"+
		"\u00f2\u0003\u0002\u0001\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u0012\u0000\u0000\u00f7"+
		"\u00f8\u0006\u000b\uffff\uffff\u0000\u00f8\u0017\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fe\u0005(\u0000\u0000\u00fa\u00fb\u0005$\u0000\u0000\u00fb\u00fd"+
		"\u0005(\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u0100\u0001"+
		"\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001"+
		"\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u00fe\u0001"+
		"\u0000\u0000\u0000\u0101\u00f9\u0001\u0000\u0000\u0000\u0101\u0102\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0104\u0006"+
		"\f\uffff\uffff\u0000\u0104\u0019\u0001\u0000\u0000\u0000\u0105\u0106\u0003"+
		"\u0006\u0003\u0000\u0106\u0107\u0005\u001c\u0000\u0000\u0107\u0108\u0005"+
		"(\u0000\u0000\u0108\u0109\u0005\"\u0000\u0000\u0109\u010a\u0003\u0014"+
		"\n\u0000\u010a\u010b\u0005#\u0000\u0000\u010b\u010c\u0006\r\uffff\uffff"+
		"\u0000\u010c\u001b\u0001\u0000\u0000\u0000\u010d\u010e\u0005\u0015\u0000"+
		"\u0000\u010e\u010f\u0005\"\u0000\u0000\u010f\u0110\u0003\u0006\u0003\u0000"+
		"\u0110\u0111\u0005#\u0000\u0000\u0111\u0115\u0005\u0011\u0000\u0000\u0112"+
		"\u0114\u0003\u0002\u0001\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114"+
		"\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117"+
		"\u0115\u0001\u0000\u0000\u0000\u0118\u0122\u0005\u0012\u0000\u0000\u0119"+
		"\u011a\u0005\u0016\u0000\u0000\u011a\u011e\u0005\u0011\u0000\u0000\u011b"+
		"\u011d\u0003\u0002\u0001\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d"+
		"\u0120\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0001\u0000\u0000\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0121\u0123\u0005\u0012\u0000\u0000\u0122"+
		"\u0119\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124\u0125\u0006\u000e\uffff\uffff\u0000"+
		"\u0125\u001d\u0001\u0000\u0000\u0000\u0126\u0127\u0007\u0003\u0000\u0000"+
		"\u0127\u001f\u0001\u0000\u0000\u0000\u0015#,:JWk\u0093\u0095\u00ae\u00b6"+
		"\u00b9\u00ca\u00d8\u00e3\u00e6\u00f3\u00fe\u0101\u0115\u011e\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}