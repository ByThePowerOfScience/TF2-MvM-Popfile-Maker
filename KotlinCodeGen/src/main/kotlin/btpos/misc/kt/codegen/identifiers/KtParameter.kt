package btpos.misc.kt.codegen.identifiers

import btpos.misc.kt.codegen.IKtCodeGenerator

data class KtParameter(var name: String, var type: KtType) : IKtCodeGenerator {
	override val importsNeeded: Sequence<String>
		get() = type.importsNeeded
	
	override fun toKotlinCode(): String {
		return "$name: ${type.toKotlinCode()}"
	}
}