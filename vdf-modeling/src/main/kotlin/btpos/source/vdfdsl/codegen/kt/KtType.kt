package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator

open class KtType(val type: String, val importNeeded: String? = null): IKtCodeGenerator {
	constructor(namespacedString: String) : this(namespacedString.substringAfterLast('.'), namespacedString.takeIf { it.contains('.') })
	
	override val importsNeeded: Sequence<String> get() = importNeeded?.let { sequenceOf(it) }.orEmpty()
	
	override fun toKotlinCode(): String {
		return type
	}
}