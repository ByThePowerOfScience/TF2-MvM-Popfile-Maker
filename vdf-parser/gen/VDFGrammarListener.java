// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDFGrammar.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VDFGrammarParser}.
 */
public interface VDFGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void enterBase(VDFGrammarParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#base}.
	 * @param ctx the parse tree
	 */
	void exitBase(VDFGrammarParser.BaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#line_no_newline}.
	 * @param ctx the parse tree
	 */
	void enterLine_no_newline(VDFGrammarParser.Line_no_newlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#line_no_newline}.
	 * @param ctx the parse tree
	 */
	void exitLine_no_newline(VDFGrammarParser.Line_no_newlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue(VDFGrammarParser.KeyvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue(VDFGrammarParser.KeyvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#keyable}.
	 * @param ctx the parse tree
	 */
	void enterKeyable(VDFGrammarParser.KeyableContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#keyable}.
	 * @param ctx the parse tree
	 */
	void exitKeyable(VDFGrammarParser.KeyableContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#keyvalue_strings}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue_strings(VDFGrammarParser.Keyvalue_stringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#keyvalue_strings}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue_strings(VDFGrammarParser.Keyvalue_stringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#keyvalue_table}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue_table(VDFGrammarParser.Keyvalue_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#keyvalue_table}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue_table(VDFGrammarParser.Keyvalue_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(VDFGrammarParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(VDFGrammarParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(VDFGrammarParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(VDFGrammarParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(VDFGrammarParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(VDFGrammarParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFGrammarParser#comment_end}.
	 * @param ctx the parse tree
	 */
	void enterComment_end(VDFGrammarParser.Comment_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFGrammarParser#comment_end}.
	 * @param ctx the parse tree
	 */
	void exitComment_end(VDFGrammarParser.Comment_endContext ctx);
}