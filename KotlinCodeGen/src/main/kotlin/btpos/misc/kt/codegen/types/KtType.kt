package btpos.misc.kt.codegen.types

import btpos.misc.kt.codegen.IKtCodeGenerator
import btpos.misc.kt.codegen.types.KtClass.Companion.defaultType

sealed class KtType : IKtCodeGenerator {
	abstract val identifier: String
	
	companion object {
		val UNIT = KtClass.UNIT.defaultType
	}
}