package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.codegen.kt.KtLiteral
import btpos.source.vdfdsl.codegen.kt.KtString

object Codegen {
	/**
	 * Returns the thing given as a string literal wrapped in quotes
	 */
	fun string(it: String): IKtCodeGenerator {
		return KtString(it)
	}
	
	/**
	 * Returns the thing given without any postprocessing
	 */
	fun code(code: String, vararg imports: String): IKtCodeGenerator {
		return KtLiteral(code, imports.toSet())
	}
}