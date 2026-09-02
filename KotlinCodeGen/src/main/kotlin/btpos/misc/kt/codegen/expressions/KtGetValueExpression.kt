package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtCallable
import btpos.misc.kt.codegen.identifiers.KtMemberReference

data class KtGetValueExpression(var callee: KtCallable, var receiver: KtExpression? = null) : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = callee.importsNeeded + receiver?.importsNeeded.orEmpty()
	
	override fun toKotlinCode(): String {
		return receiver?.takeIf { !(it is KtThis && it.target == null) }?.run { toKotlinCode() + "." }.orEmpty() + callee.toKotlinCode()
	}
}