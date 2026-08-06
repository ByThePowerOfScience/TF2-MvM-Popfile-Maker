package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator

open class KtLambda : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(namedParams, lines).flatten().flatMap { it.importsNeeded }
	
	val namedParams = mutableListOf<KtParameter>()
	
	val lines = mutableListOf<IKtCodeGenerator>()
	
	override fun toKotlinCode(): String {
		val paramsString = if (namedParams.isEmpty() || (namedParams.size == 1 && namedParams[0].name == "it")) ""
							else (" " + (namedParams.joinToString(", ") { it.toKotlinCode() } + " ->"))
		val bodySep = if (lines.size > 1) "\n" else " "
		val bodyIndent = if (lines.size > 1) { { it: String -> it.prependIndent("\t") } } else { { it } }
		
		return "{$paramsString$bodySep${bodyIndent(lines.joinToString("\n"))}$bodySep}"
	}
}