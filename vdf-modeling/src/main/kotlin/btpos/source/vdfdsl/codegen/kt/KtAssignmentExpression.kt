package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator

class KtAssignmentExpression(val lhs: KtQualifiedName, val operator: String,  val rhs: KtExpression) : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(lhs, rhs).flatMap { it.importsNeeded }
	
	override fun toKotlinCode(): String {
		return "$lhs $operator $rhs"
	}
}