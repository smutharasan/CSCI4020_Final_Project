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
		T__24=25, T__25=26, T__26=27, NUMBER=28, STRING=29, BOOLEAN=30, ID=31, 
		WS=32, COMMENT=33, LINE_COMMENT=34;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_assignment = 2, RULE_expression = 3, 
		RULE_value = 4, RULE_loop = 5, RULE_whileloop = 6, RULE_arguments = 7, 
		RULE_function = 8, RULE_paramList = 9, RULE_ifelse = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "assignment", "expression", "value", "loop", 
			"whileloop", "arguments", "function", "paramList", "ifelse"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "' ;'", "'print'", "'('", "')'", "'='", "'*'", "'/'", "'+'", 
			"'-'", "'++'", "'<'", "'>'", "'<='", "'>='", "'!='", "'=='", "'for'", 
			"'in'", "'..'", "'{'", "'}'", "'while'", "','", "'function'", "'if'", 
			"'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "NUMBER", "STRING", "BOOLEAN", "ID", "WS", "COMMENT", 
			"LINE_COMMENT"
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4135845912L) != 0) {
				{
				{
				setState(22);
				((ProgramContext)_localctx).statement = statement();
				((ProgramContext)_localctx).statements.add(((ProgramContext)_localctx).statement);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((StatementContext)_localctx).assignment = assignment();
				setState(34);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(32);
					match(T__0);
					}
					break;
				case EOF:
				case T__2:
				case T__3:
				case T__17:
				case T__21:
				case T__22:
				case T__24:
				case T__25:
				case NUMBER:
				case STRING:
				case BOOLEAN:
				case ID:
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
				setState(38);
				((StatementContext)_localctx).expression = expression(0);
				setState(39);
				match(T__0);
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).expression.expr; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				((StatementContext)_localctx).expression = expression(0);
				setState(43);
				match(T__1);
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).expression.expr; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				match(T__2);
				setState(47);
				match(T__3);
				setState(48);
				((StatementContext)_localctx).expression = expression(0);
				setState(49);
				match(T__4);
				setState(52);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(50);
					match(T__0);
					}
					break;
				case EOF:
				case T__2:
				case T__3:
				case T__17:
				case T__21:
				case T__22:
				case T__24:
				case T__25:
				case NUMBER:
				case STRING:
				case BOOLEAN:
				case ID:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 ((StatementContext)_localctx).expr =  new PrintExpr(((StatementContext)_localctx).expression.expr); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				((StatementContext)_localctx).loop = loop();
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).loop.expr; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				((StatementContext)_localctx).function = function();
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).function.funcResult;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(62);
				((StatementContext)_localctx).ifelse = ifelse();
				 ((StatementContext)_localctx).expr =  ((StatementContext)_localctx).ifelse.expr; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(65);
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
		public Token ID;
		public ExpressionContext expression;
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
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			((AssignmentContext)_localctx).ID = match(ID);
			setState(71);
			match(T__5);
			setState(72);
			((AssignmentContext)_localctx).expression = expression(0);
			 ((AssignmentContext)_localctx).expr =  new AssignmentExpr((((AssignmentContext)_localctx).ID!=null?((AssignmentContext)_localctx).ID.getText():null), ((AssignmentContext)_localctx).expression.expr); 
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
		public ValueContext value;
		public Token ID;
		public ArgumentsContext arguments;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
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
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(76);
				match(T__3);
				setState(77);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(78);
				match(T__4);
				 ((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).expression.expr; 
				}
				break;
			case 2:
				{
				setState(81);
				((ExpressionContext)_localctx).value = value();
				 ((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).value.expr; 
				}
				break;
			case 3:
				{
				setState(84);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).expr =  new VariableExpr((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 4:
				{
				setState(86);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(87);
				match(T__3);
				setState(88);
				((ExpressionContext)_localctx).arguments = arguments();
				setState(89);
				match(T__4);
				((ExpressionContext)_localctx).expr =  new Invoke((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).arguments.args);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(95);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(6);
						 
						                  ((ExpressionContext)_localctx).expr =  new Arithmetics((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("*") ? Operator.Mul : Operator.Div, ((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr); 
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(100);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(5);
						 
						                  ((ExpressionContext)_localctx).expr =  new Arithmetics((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("+") ? Operator.Add : Operator.Sub, ((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr); 
						              
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(105);
						match(T__10);
						setState(106);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(4);
						 ((ExpressionContext)_localctx).expr =  new ConcatExpr(((ExpressionContext)_localctx).left.expr, ((ExpressionContext)_localctx).right.expr); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(110);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(3);
						 
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
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class ValueContext extends ParserRuleContext {
		public Expr expr;
		public Token NUMBER;
		public Token STRING;
		public Token BOOLEAN;
		public TerminalNode NUMBER() { return getToken(PLParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(PLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(PLParser.BOOLEAN, 0); }
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
		enterRule(_localctx, 8, RULE_value);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				((ValueContext)_localctx).NUMBER = match(NUMBER);
				 ((ValueContext)_localctx).expr =  new IntExpr((((ValueContext)_localctx).NUMBER!=null?((ValueContext)_localctx).NUMBER.getText():null)); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((ValueContext)_localctx).STRING = match(STRING);
				 ((ValueContext)_localctx).expr =  new StringExpr((((ValueContext)_localctx).STRING!=null?((ValueContext)_localctx).STRING.getText():null).substring(1, (((ValueContext)_localctx).STRING!=null?((ValueContext)_localctx).STRING.getText():null).length() - 1)); 
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				((ValueContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((ValueContext)_localctx).expr =  new BooleanLiteral((((ValueContext)_localctx).BOOLEAN!=null?((ValueContext)_localctx).BOOLEAN.getText():null)); 
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
	public static class LoopContext extends ParserRuleContext {
		public Expr expr;
		public Token ID;
		public ExpressionContext startexpr;
		public ExpressionContext endexpr;
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
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
		enterRule(_localctx, 10, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__17);
			setState(128);
			match(T__3);
			setState(129);
			((LoopContext)_localctx).ID = match(ID);
			setState(130);
			match(T__18);
			setState(131);
			((LoopContext)_localctx).startexpr = expression(0);
			setState(132);
			match(T__19);
			setState(133);
			((LoopContext)_localctx).endexpr = expression(0);
			setState(134);
			match(T__4);
			setState(135);
			match(T__20);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4135845912L) != 0) {
				{
				{
				setState(136);
				((LoopContext)_localctx).statement = statement();
				((LoopContext)_localctx).statements.add(((LoopContext)_localctx).statement);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__21);

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
		enterRule(_localctx, 12, RULE_whileloop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__22);
			setState(146);
			match(T__3);
			setState(147);
			((WhileloopContext)_localctx).condition = expression(0);
			setState(148);
			match(T__4);
			setState(149);
			match(T__20);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4135845912L) != 0) {
				{
				{
				setState(150);
				((WhileloopContext)_localctx).statement = statement();
				((WhileloopContext)_localctx).statements.add(((WhileloopContext)_localctx).statement);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(T__21);

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
		public ExpressionContext first;
		public ExpressionContext expression;
		public List<ExpressionContext> others = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 14, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531856L) != 0) {
				{
				setState(159);
				((ArgumentsContext)_localctx).first = expression(0);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(160);
					match(T__23);
					setState(161);
					((ArgumentsContext)_localctx).expression = expression(0);
					((ArgumentsContext)_localctx).others.add(((ArgumentsContext)_localctx).expression);
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			        ((ArgumentsContext)_localctx).args =  new ArrayList<>();
			        if (((ArgumentsContext)_localctx).first.expr != null) { // Check if at least one expression is matched
			            _localctx.args.add(((ArgumentsContext)_localctx).first.expr); // Add the first matched expression to the list
			        }
			        if (((ArgumentsContext)_localctx).others != null) { // Check if there are additional expressions matched
			            for (ExpressionContext exprCtx : ((ArgumentsContext)_localctx).others) { // Iterate over the additional expressions
			                _localctx.args.add(exprCtx.expr); // Add each to the list
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
		public ParamListContext params;
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
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
		enterRule(_localctx, 16, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__24);
			setState(172);
			((FunctionContext)_localctx).ID = match(ID);
			setState(173);
			match(T__3);
			setState(174);
			((FunctionContext)_localctx).params = paramList();
			setState(175);
			match(T__4);
			setState(176);
			match(T__20);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4135845912L) != 0) {
				{
				{
				setState(177);
				((FunctionContext)_localctx).statement = statement();
				((FunctionContext)_localctx).statements.add(((FunctionContext)_localctx).statement);
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(T__21);

			            List<Expr> exprList = new ArrayList<>();
			            for (StatementContext stmt : ((FunctionContext)_localctx).statements) {
			                exprList.add(stmt.expr);
			            } // This closing brace ends the for-loop
			            ((FunctionContext)_localctx).funcResult =  new Declare((((FunctionContext)_localctx).ID!=null?((FunctionContext)_localctx).ID.getText():null), ((FunctionContext)_localctx).params.paramNames, new Block(exprList));
			        
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
	public static class ParamListContext extends ParserRuleContext {
		public List<String> paramNames;
		public Token id;
		public List<TerminalNode> ID() { return getTokens(PLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PLParser.ID, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PLListener ) ((PLListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParamListContext)_localctx).paramNames =  new ArrayList<>(); 
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(187);
				((ParamListContext)_localctx).id = match(ID);
				 _localctx.paramNames.add((((ParamListContext)_localctx).id!=null?((ParamListContext)_localctx).id.getText():null)); 
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(189);
					match(T__23);
					setState(190);
					((ParamListContext)_localctx).id = match(ID);
					 _localctx.paramNames.add((((ParamListContext)_localctx).id!=null?((ParamListContext)_localctx).id.getText():null)); 
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
	public static class IfelseContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionContext condition;
		public StatementContext statement;
		public List<StatementContext> trueStatements = new ArrayList<StatementContext>();
		public List<StatementContext> falseStatements = new ArrayList<StatementContext>();
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
		enterRule(_localctx, 20, RULE_ifelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__25);
			setState(200);
			match(T__3);
			setState(201);
			((IfelseContext)_localctx).condition = expression(0);
			setState(202);
			match(T__4);
			setState(203);
			match(T__20);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4135845912L) != 0) {
				{
				{
				setState(204);
				((IfelseContext)_localctx).statement = statement();
				((IfelseContext)_localctx).trueStatements.add(((IfelseContext)_localctx).statement);
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			match(T__21);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(211);
				match(T__26);
				setState(212);
				match(T__20);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4135845912L) != 0) {
					{
					{
					setState(213);
					((IfelseContext)_localctx).statement = statement();
					((IfelseContext)_localctx).falseStatements.add(((IfelseContext)_localctx).statement);
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(219);
				match(T__21);
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
		"\u0004\u0001\"\u00e1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000\u0018"+
		"\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001E\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003]\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"s\b\u0003\n\u0003\f\u0003v\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004~\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u008a\b\u0005\n\u0005"+
		"\f\u0005\u008d\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u0098\b\u0006\n\u0006\f\u0006\u009b\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00a3\b\u0007\n"+
		"\u0007\f\u0007\u00a6\t\u0007\u0003\u0007\u00a8\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b"+
		"\u00b3\b\b\n\b\f\b\u00b6\t\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u00c1\b\t\n\t\f\t\u00c4\t\t\u0003\t"+
		"\u00c6\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00ce"+
		"\b\n\n\n\f\n\u00d1\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00d7\b"+
		"\n\n\n\f\n\u00da\t\n\u0001\n\u0003\n\u00dd\b\n\u0001\n\u0001\n\u0001\n"+
		"\u0000\u0001\u0006\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0000\u0003\u0001\u0000\u0007\b\u0001\u0000\t\n\u0001\u0000\f\u0011"+
		"\u00f2\u0000\u0019\u0001\u0000\u0000\u0000\u0002D\u0001\u0000\u0000\u0000"+
		"\u0004F\u0001\u0000\u0000\u0000\u0006\\\u0001\u0000\u0000\u0000\b}\u0001"+
		"\u0000\u0000\u0000\n\u007f\u0001\u0000\u0000\u0000\f\u0091\u0001\u0000"+
		"\u0000\u0000\u000e\u00a7\u0001\u0000\u0000\u0000\u0010\u00ab\u0001\u0000"+
		"\u0000\u0000\u0012\u00ba\u0001\u0000\u0000\u0000\u0014\u00c7\u0001\u0000"+
		"\u0000\u0000\u0016\u0018\u0003\u0002\u0001\u0000\u0017\u0016\u0001\u0000"+
		"\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c\u0001\u0000"+
		"\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0000"+
		"\u0000\u0001\u001d\u001e\u0006\u0000\uffff\uffff\u0000\u001e\u0001\u0001"+
		"\u0000\u0000\u0000\u001f\"\u0003\u0004\u0002\u0000 #\u0005\u0001\u0000"+
		"\u0000!#\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"!\u0001\u0000"+
		"\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0006\u0001\uffff\uffff\u0000"+
		"%E\u0001\u0000\u0000\u0000&\'\u0003\u0006\u0003\u0000\'(\u0005\u0001\u0000"+
		"\u0000()\u0006\u0001\uffff\uffff\u0000)E\u0001\u0000\u0000\u0000*+\u0003"+
		"\u0006\u0003\u0000+,\u0005\u0002\u0000\u0000,-\u0006\u0001\uffff\uffff"+
		"\u0000-E\u0001\u0000\u0000\u0000./\u0005\u0003\u0000\u0000/0\u0005\u0004"+
		"\u0000\u000001\u0003\u0006\u0003\u000014\u0005\u0005\u0000\u000025\u0005"+
		"\u0001\u0000\u000035\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"43\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0006\u0001\uffff"+
		"\uffff\u00007E\u0001\u0000\u0000\u000089\u0003\n\u0005\u00009:\u0006\u0001"+
		"\uffff\uffff\u0000:E\u0001\u0000\u0000\u0000;<\u0003\u0010\b\u0000<=\u0006"+
		"\u0001\uffff\uffff\u0000=E\u0001\u0000\u0000\u0000>?\u0003\u0014\n\u0000"+
		"?@\u0006\u0001\uffff\uffff\u0000@E\u0001\u0000\u0000\u0000AB\u0003\f\u0006"+
		"\u0000BC\u0006\u0001\uffff\uffff\u0000CE\u0001\u0000\u0000\u0000D\u001f"+
		"\u0001\u0000\u0000\u0000D&\u0001\u0000\u0000\u0000D*\u0001\u0000\u0000"+
		"\u0000D.\u0001\u0000\u0000\u0000D8\u0001\u0000\u0000\u0000D;\u0001\u0000"+
		"\u0000\u0000D>\u0001\u0000\u0000\u0000DA\u0001\u0000\u0000\u0000E\u0003"+
		"\u0001\u0000\u0000\u0000FG\u0005\u001f\u0000\u0000GH\u0005\u0006\u0000"+
		"\u0000HI\u0003\u0006\u0003\u0000IJ\u0006\u0002\uffff\uffff\u0000J\u0005"+
		"\u0001\u0000\u0000\u0000KL\u0006\u0003\uffff\uffff\u0000LM\u0005\u0004"+
		"\u0000\u0000MN\u0003\u0006\u0003\u0000NO\u0005\u0005\u0000\u0000OP\u0006"+
		"\u0003\uffff\uffff\u0000P]\u0001\u0000\u0000\u0000QR\u0003\b\u0004\u0000"+
		"RS\u0006\u0003\uffff\uffff\u0000S]\u0001\u0000\u0000\u0000TU\u0005\u001f"+
		"\u0000\u0000U]\u0006\u0003\uffff\uffff\u0000VW\u0005\u001f\u0000\u0000"+
		"WX\u0005\u0004\u0000\u0000XY\u0003\u000e\u0007\u0000YZ\u0005\u0005\u0000"+
		"\u0000Z[\u0006\u0003\uffff\uffff\u0000[]\u0001\u0000\u0000\u0000\\K\u0001"+
		"\u0000\u0000\u0000\\Q\u0001\u0000\u0000\u0000\\T\u0001\u0000\u0000\u0000"+
		"\\V\u0001\u0000\u0000\u0000]t\u0001\u0000\u0000\u0000^_\n\u0005\u0000"+
		"\u0000_`\u0007\u0000\u0000\u0000`a\u0003\u0006\u0003\u0006ab\u0006\u0003"+
		"\uffff\uffff\u0000bs\u0001\u0000\u0000\u0000cd\n\u0004\u0000\u0000de\u0007"+
		"\u0001\u0000\u0000ef\u0003\u0006\u0003\u0005fg\u0006\u0003\uffff\uffff"+
		"\u0000gs\u0001\u0000\u0000\u0000hi\n\u0003\u0000\u0000ij\u0005\u000b\u0000"+
		"\u0000jk\u0003\u0006\u0003\u0004kl\u0006\u0003\uffff\uffff\u0000ls\u0001"+
		"\u0000\u0000\u0000mn\n\u0002\u0000\u0000no\u0007\u0002\u0000\u0000op\u0003"+
		"\u0006\u0003\u0003pq\u0006\u0003\uffff\uffff\u0000qs\u0001\u0000\u0000"+
		"\u0000r^\u0001\u0000\u0000\u0000rc\u0001\u0000\u0000\u0000rh\u0001\u0000"+
		"\u0000\u0000rm\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u0007\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000wx\u0005\u001c\u0000\u0000x~\u0006\u0004"+
		"\uffff\uffff\u0000yz\u0005\u001d\u0000\u0000z~\u0006\u0004\uffff\uffff"+
		"\u0000{|\u0005\u001e\u0000\u0000|~\u0006\u0004\uffff\uffff\u0000}w\u0001"+
		"\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"~\t\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0012\u0000\u0000\u0080"+
		"\u0081\u0005\u0004\u0000\u0000\u0081\u0082\u0005\u001f\u0000\u0000\u0082"+
		"\u0083\u0005\u0013\u0000\u0000\u0083\u0084\u0003\u0006\u0003\u0000\u0084"+
		"\u0085\u0005\u0014\u0000\u0000\u0085\u0086\u0003\u0006\u0003\u0000\u0086"+
		"\u0087\u0005\u0005\u0000\u0000\u0087\u008b\u0005\u0015\u0000\u0000\u0088"+
		"\u008a\u0003\u0002\u0001\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0016\u0000\u0000\u008f"+
		"\u0090\u0006\u0005\uffff\uffff\u0000\u0090\u000b\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005\u0017\u0000\u0000\u0092\u0093\u0005\u0004\u0000\u0000"+
		"\u0093\u0094\u0003\u0006\u0003\u0000\u0094\u0095\u0005\u0005\u0000\u0000"+
		"\u0095\u0099\u0005\u0015\u0000\u0000\u0096\u0098\u0003\u0002\u0001\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005\u0016\u0000\u0000\u009d\u009e\u0006\u0006\uffff\uffff"+
		"\u0000\u009e\r\u0001\u0000\u0000\u0000\u009f\u00a4\u0003\u0006\u0003\u0000"+
		"\u00a0\u00a1\u0005\u0018\u0000\u0000\u00a1\u00a3\u0003\u0006\u0003\u0000"+
		"\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a7\u009f\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0006\u0007\uffff\uffff"+
		"\u0000\u00aa\u000f\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0019\u0000"+
		"\u0000\u00ac\u00ad\u0005\u001f\u0000\u0000\u00ad\u00ae\u0005\u0004\u0000"+
		"\u0000\u00ae\u00af\u0003\u0012\t\u0000\u00af\u00b0\u0005\u0005\u0000\u0000"+
		"\u00b0\u00b4\u0005\u0015\u0000\u0000\u00b1\u00b3\u0003\u0002\u0001\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0005\u0016\u0000\u0000\u00b8\u00b9\u0006\b\uffff\uffff\u0000"+
		"\u00b9\u0011\u0001\u0000\u0000\u0000\u00ba\u00c5\u0006\t\uffff\uffff\u0000"+
		"\u00bb\u00bc\u0005\u001f\u0000\u0000\u00bc\u00c2\u0006\t\uffff\uffff\u0000"+
		"\u00bd\u00be\u0005\u0018\u0000\u0000\u00be\u00bf\u0005\u001f\u0000\u0000"+
		"\u00bf\u00c1\u0006\t\uffff\uffff\u0000\u00c0\u00bd\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00bb\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u0013\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0005\u001a\u0000\u0000\u00c8\u00c9\u0005\u0004\u0000\u0000"+
		"\u00c9\u00ca\u0003\u0006\u0003\u0000\u00ca\u00cb\u0005\u0005\u0000\u0000"+
		"\u00cb\u00cf\u0005\u0015\u0000\u0000\u00cc\u00ce\u0003\u0002\u0001\u0000"+
		"\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d2\u00dc\u0005\u0016\u0000\u0000\u00d3\u00d4\u0005\u001b\u0000\u0000"+
		"\u00d4\u00d8\u0005\u0015\u0000\u0000\u00d5\u00d7\u0003\u0002\u0001\u0000"+
		"\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00db\u00dd\u0005\u0016\u0000\u0000\u00dc\u00d3\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000"+
		"\u00de\u00df\u0006\n\uffff\uffff\u0000\u00df\u0015\u0001\u0000\u0000\u0000"+
		"\u0012\u0019\"4D\\rt}\u008b\u0099\u00a4\u00a7\u00b4\u00c2\u00c5\u00cf"+
		"\u00d8\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}