package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.codegen.ConstantsDecoder
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

open class NavArea(val name: String) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object {
		val SENTRY_SPOT = NavArea("SENTRY_SPOT")
		
		val SNIPER_SPOT = NavArea("SENTRY_SPOT")
		
		
		val CODEGEN = ConstantsDecoder<NavArea>()
	}
}





