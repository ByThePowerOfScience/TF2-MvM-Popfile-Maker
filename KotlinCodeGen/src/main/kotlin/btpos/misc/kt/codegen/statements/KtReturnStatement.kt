package btpos.misc.kt.codegen.statements

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.KtStatement

class KtReturnStatement(var expr: KtExpression) : KtStatement {
	var returnTarget: KtFunctionCall? = null
	
	override val importsNeeded: Sequence<String>
		get() = expr.importsNeeded
	
	override fun toKotlinCode(): String {
		return "return${returnTarget?.let { "@${it.callee.toKotlinCode()}" }.orEmpty()} ${expr.toKotlinCode()}"
	}
}