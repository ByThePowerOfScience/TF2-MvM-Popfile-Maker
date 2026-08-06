package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator

open class KtParameter(var name: String, var type: KtType) : IKtCodeGenerator {
	override val importsNeeded: Sequence<String>
		get() = type.importsNeeded
	
	override fun toKotlinCode(): String {
		return "$name: ${type.toKotlinCode()}"
	}
}