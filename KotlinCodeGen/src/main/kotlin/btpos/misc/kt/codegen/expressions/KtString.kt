package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression

data class KtString(val item: String) : KtExpression {
	override fun toKotlinCode(): String {
		return "\"$item\""
	}
}