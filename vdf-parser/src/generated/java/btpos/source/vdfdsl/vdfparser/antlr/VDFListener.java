// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDF.g4 by ANTLR 4.13.2
package btpos.source.vdfdsl.vdfparser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VDFParser}.
 */
public interface VDFListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VDFParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(VDFParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(VDFParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#header_allowed_lines}.
	 * @param ctx the parse tree
	 */
	void enterHeader_allowed_lines(VDFParser.Header_allowed_linesContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#header_allowed_lines}.
	 * @param ctx the parse tree
	 */
	void exitHeader_allowed_lines(VDFParser.Header_allowed_linesContext ctx);
	/**
	 * Enter a parse tree produced by {@link VDFParser#nl_line}.
	 * @param ctx the parse tree
	 */
	void enterNl_line(VDFParser.Nl_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link VDFParser#nl_line}.
	 * @param ctx the parse tree
	 */
	void exitNl_line(VDFParser.Nl_lineContext ctx);
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
}