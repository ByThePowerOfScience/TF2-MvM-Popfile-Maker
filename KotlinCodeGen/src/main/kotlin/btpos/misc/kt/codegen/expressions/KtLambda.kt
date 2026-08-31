package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtParameter
import btpos.misc.kt.codegen.KtStatement

class KtLambda : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(namedParams, lines).flatten().flatMap { it.importsNeeded }
	
	val namedParams = mutableListOf<KtParameter>()
	
	val lines = mutableListOf<KtStatement>()
	
	override fun toKotlinCode(): String {
		val paramsString = if (namedParams.isEmpty() || (namedParams.size == 1 && namedParams[0].name == "it")) ""
							else (" " + (namedParams.joinToString(", ") { it.toKotlinCode() } + " ->"))
		return "{$paramsString\n${lines.joinToString("\n") { it.toKotlinCode() }.prependIndent("\t")}\n}"
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