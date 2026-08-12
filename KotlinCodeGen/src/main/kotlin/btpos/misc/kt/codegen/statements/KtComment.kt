package btpos.misc.kt.codegen.statements

import btpos.misc.kt.codegen.KtStatement

sealed class KtComment : KtStatement {
	data class Line(var body: String) : KtComment() {
		override fun toKotlinCode(): String {
			return body.prependIndent("// ")
		}
	}
	
	data class Block(val body: MutableList<String> = mutableListOf()) : KtComment() {
		override fun toKotlinCode(): String {
			val hasMoreThanOneLine: Boolean = (body.size > 1) || run {
				for (line in body) {
					if ("\n" in line) {
						return@run true
					}
				}
				false
			}
			
			val newline = if (!hasMoreThanOneLine) { // just make it "/* body */
				" "
			} else {
				"\n"
			}
			
			return "/*$newline" + body.joinToString("\n") + "$newline*/"
		}
	}
}