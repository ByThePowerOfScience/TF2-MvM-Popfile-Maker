// Generated from /home/impro_000/IdeaProjects/TF2/PopFileDSL/vdf-parser/VDF.g4 by ANTLR 4.13.2
package btpos.source.vdfdsl.vdfparser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VDFParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VDFVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VDFParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(VDFParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#header_allowed_lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader_allowed_lines(VDFParser.Header_allowed_linesContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#nl_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNl_line(VDFParser.Nl_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(VDFParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#keyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue(VDFParser.KeyvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#keyable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyable(VDFParser.KeyableContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#keyvalue_strings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue_strings(VDFParser.Keyvalue_stringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#keyvalue_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue_table(VDFParser.Keyvalue_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link VDFParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(VDFParser.TableContext ctx);
}