package btpos.source.vdfdsl.codegen.kt

class KtAssignmentExpression(val lhs: KtName, val rhs: KtExpression, val operator: String = "=") : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(lhs, rhs).flatMap { it.importsNeeded }
	
	override fun toKotlinCode(): String {
		return "${lhs.toKotlinCode()} $operator ${rhs.toKotlinCode()}"
	}
}