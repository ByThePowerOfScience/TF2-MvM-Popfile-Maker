// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDFGrammar.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VDFGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VDFGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase(VDFGrammarParser.BaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#line_no_newline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_no_newline(VDFGrammarParser.Line_no_newlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#keyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue(VDFGrammarParser.KeyvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#keyable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyable(VDFGrammarParser.KeyableContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#keyvalue_strings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue_strings(VDFGrammarParser.Keyvalue_stringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#keyvalue_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue_table(VDFGrammarParser.Keyvalue_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(VDFGrammarParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(VDFGrammarParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(VDFGrammarParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFGrammarParser#comment_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment_end(VDFGrammarParser.Comment_endContext ctx);
}