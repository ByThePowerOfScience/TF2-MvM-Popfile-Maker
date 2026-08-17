package btpos.misc.kt.codegen.identifiers

import btpos.misc.kt.codegen.KtElement
import btpos.misc.kt.codegen.types.KtType

data class KtParameter(var name: String, var type: KtType) : KtElement {
	override val importsNeeded: Sequence<String>
		get() = type.importsNeeded
	
	override fun toKotlinCode(): String {
		return "$name: ${type.identifier}"
	}
}