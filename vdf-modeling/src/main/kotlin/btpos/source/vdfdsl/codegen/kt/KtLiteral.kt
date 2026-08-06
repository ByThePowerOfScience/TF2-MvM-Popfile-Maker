package btpos.source.vdfdsl.codegen.kt

class KtLiteral(val code: String, val imports: Set<String> = emptySet()) : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = imports.asSequence()
	
	override fun toKotlinCode(): String {
		return code
	}
}