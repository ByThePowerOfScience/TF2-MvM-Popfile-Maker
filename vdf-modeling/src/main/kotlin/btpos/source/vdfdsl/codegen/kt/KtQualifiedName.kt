package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator

open class KtQualifiedName(val name: String, val qualifier: String? = null) : IKtCodeGenerator {
	override val importsNeeded: Sequence<String> get() = qualifier?.let { sequenceOf(it + "." + name) }.orEmpty()
	
	override fun toKotlinCode(): String {
		return name
	}
}