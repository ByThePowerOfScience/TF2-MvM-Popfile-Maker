package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression

data class KtNamedFunctionCallArgument(val name: String, val value: KtExpression) : KtExpression {
	override fun toKotlinCode(): String {
		return "$name = ${value.toKotlinCode()}"
	}
}