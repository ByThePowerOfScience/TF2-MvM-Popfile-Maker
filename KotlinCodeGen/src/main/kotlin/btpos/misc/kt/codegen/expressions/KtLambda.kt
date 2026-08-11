package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtParameter
import btpos.misc.kt.codegen.KtStatement

open class KtLambda : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(namedParams, lines).flatten().flatMap { it.importsNeeded }
	
	val namedParams = mutableListOf<KtParameter>()
	
	val lines = mutableListOf<KtStatement>()
	
	override fun toKotlinCode(): String {
		val paramsString = if (namedParams.isEmpty() || (namedParams.size == 1 && namedParams[0].name == "it")) ""
							else (" " + (namedParams.joinToString(", ") { it.toKotlinCode() } + " ->"))
		val bodySep = if (lines.size > 1) "\n" else " "
		val bodyIndent = if (lines.size > 1) { { it: String -> it.prependIndent("\t") } } else { { it } }
		
		return "{$paramsString$bodySep${bodyIndent(lines.joinToString("\n") { it.toKotlinCode() })}$bodySep}"
	}
	
	companion object {
	    operator fun invoke(namedParams: List<KtParameter> = listOf(), lines: List<KtStatement>): KtLambda {
	        return KtLambda().apply {
				this.namedParams += namedParams
		        this.lines += lines
	        }
	    }
	}
}