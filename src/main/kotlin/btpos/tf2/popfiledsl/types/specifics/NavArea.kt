package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral

class NavArea(val name: String) : IPopFileSerializable<PopFileStringLiteral> {
	override val popFileRepr: PopFileStringLiteral
		get() = PopFileStringLiteral(name)
	
	companion object
}

val NavArea.Companion.SENTRY_SPOT
	get() = NavArea("SENTRY_SPOT")

val NavArea.Companion.SNIPER_SPOT
	get() = NavArea("SNIPER_SPOT")

