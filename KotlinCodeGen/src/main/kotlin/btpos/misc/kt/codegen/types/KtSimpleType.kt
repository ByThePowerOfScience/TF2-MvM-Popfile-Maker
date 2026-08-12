package btpos.misc.kt.codegen.types

import kotlin.reflect.KClass

class KtSimpleType(
	var classifier: KtClass,
	var isNullable: Boolean,
	val typeArguments: MutableList<KtType> = mutableListOf()
) : KtType() {
	override val importsNeeded: Sequence<String>
		get() = classifier.importsNeeded + typeArguments.asSequence().flatMap { it.importsNeeded }
	
	override val identifier: String
		get() = classifier.simpleName
	
	override fun toKotlinCode(): String {
		val genericString = if (typeArguments.isNotEmpty()) {
			"<" + typeArguments.joinToString { it.toKotlinCode() } + ">"
		} else ""
		
		return classifier.toKotlinCode() + genericString + if (isNullable) "?" else ""
	}
	
	companion object {
		@JvmField val UNIT = KtClass("kotlin.Unit")
		
		operator fun invoke(cls: KClass<*>, isNullable: Boolean = false): KtSimpleType {
			return KtSimpleType(KtClass.Companion(cls), isNullable)
		}
	}
}