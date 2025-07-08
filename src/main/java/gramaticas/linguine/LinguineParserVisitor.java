package gramaticas.linguine;

// Generated from LinguineParser.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LinguineParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LinguineParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LinguineParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LinguineParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LinguineParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LinguineParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(LinguineParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(LinguineParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(LinguineParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#show_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_statement(LinguineParser.Show_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#match_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_statement(LinguineParser.Match_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(LinguineParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(LinguineParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#asignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignation(LinguineParser.AsignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#aritmetic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritmetic(LinguineParser.AritmeticContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LinguineParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(LinguineParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(LinguineParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase(LinguineParser.CaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguineParser#simbolo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimbolo(LinguineParser.SimboloContext ctx);
}