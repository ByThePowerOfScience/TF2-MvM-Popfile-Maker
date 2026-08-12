package btpos.misc.kt.codegen.types

import btpos.misc.kt.codegen.enums.KtVariance

data class KtTypeParameter(
	var name: String,
	var upperBound: KtType? = null,
	var variance: KtVariance = KtVariance.INVARIANT
) : KtType() {
	override val importsNeeded: Sequence<String>
		get() = upperBound?.importsNeeded.orEmpty()
	
	override val identifier: String
		get() = name
	
	override fun toKotlinCode(): String {
		val varianceString = when (variance) {
			KtVariance.INVARIANT -> ""
			KtVariance.IN -> "in "
			KtVariance.OUT -> "out "
		}
		
		val boundString = upperBound?.let {
			": ${it.toKotlinCode()}"
		}.orEmpty()
		
		return varianceString + name + boundString
	}
}