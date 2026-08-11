package btpos.misc.kt.codegen.statements

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.KtStatement

class KtAssignment(val lhs: KtName, val rhs: KtExpression, val operator: String = "=") : KtStatement {
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(lhs, rhs).flatMap { it.importsNeeded }
	
	override fun toKotlinCode(): String {
		return "${lhs.toKotlinCode()} $operator ${rhs.toKotlinCode()}"
	}
}