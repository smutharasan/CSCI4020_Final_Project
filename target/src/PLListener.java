// Generated from java-escape by ANTLR 4.11.1

  //package backend;
  import backend.*;
  import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PLParser}.
 */
public interface PLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(PLParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(PLParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#whileloop}.
	 * @param ctx the parse tree
	 */
	void enterWhileloop(PLParser.WhileloopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#whileloop}.
	 * @param ctx the parse tree
	 */
	void exitWhileloop(PLParser.WhileloopContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PLParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PLParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(PLParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(PLParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(PLParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(PLParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(PLParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(PLParser.IfelseContext ctx);
}