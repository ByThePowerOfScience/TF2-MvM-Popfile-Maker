package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

class NavArea(val name: String) : IVDFRepresentableValue<VDFPrimitive> {
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object
}

val NavArea.Companion.SENTRY_SPOT
	get() = NavArea("SENTRY_SPOT")

val NavArea.Companion.SNIPER_SPOT
	get() = NavArea("SENTRY_SPOT")

