// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDF.g4 by ANTLR 4.13.2
package btpos.source.vdfdsl.vdfparser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VDFParser}.
 */
public interface VDFListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VDFParser#base}.
	 * @param ctx the parse tree
	 */
	void enterBase(VDFParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#base}.
	 * @param ctx the parse tree
	 */
	void exitBase(VDFParser.BaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#line_no_newline}.
	 * @param ctx the parse tree
	 */
	void enterLine_no_newline(VDFParser.Line_no_newlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#line_no_newline}.
	 * @param ctx the parse tree
	 */
	void exitLine_no_newline(VDFParser.Line_no_newlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue(VDFParser.KeyvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue(VDFParser.KeyvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#keyable}.
	 * @param ctx the parse tree
	 */
	void enterKeyable(VDFParser.KeyableContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#keyable}.
	 * @param ctx the parse tree
	 */
	void exitKeyable(VDFParser.KeyableContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#keyvalue_strings}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue_strings(VDFParser.Keyvalue_stringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#keyvalue_strings}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue_strings(VDFParser.Keyvalue_stringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#keyvalue_table}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue_table(VDFParser.Keyvalue_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#keyvalue_table}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue_table(VDFParser.Keyvalue_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(VDFParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(VDFParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(VDFParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(VDFParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(VDFParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(VDFParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#comment_end}.
	 * @param ctx the parse tree
	 */
	void enterComment_end(VDFParser.Comment_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#comment_end}.
	 * @param ctx the parse tree
	 */
	void exitComment_end(VDFParser.Comment_endContext ctx);
}