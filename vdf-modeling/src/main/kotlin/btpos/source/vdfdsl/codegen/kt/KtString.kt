package btpos.source.vdfdsl.codegen.kt

class KtString(val item: String) : KtExpression {
	override fun toKotlinCode(): String {
		return "\"$item\""
	}
}