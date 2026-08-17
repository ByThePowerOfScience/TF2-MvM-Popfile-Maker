package btpos.misc.kt.codegen.types

import btpos.misc.kt.codegen.KtElement
import btpos.misc.kt.codegen.types.KtClass.Companion.defaultType

sealed class KtType : KtElement {
	abstract val identifier: String
	
	companion object {
		val UNIT = KtClass.UNIT.defaultType
	}
}