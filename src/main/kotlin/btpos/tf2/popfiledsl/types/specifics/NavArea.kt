package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral

class NavArea(override val _popFileRepr: PopFileStringLiteral) : IPopFileSerializable<PopFileStringLiteral> {
	companion object
}

val NavArea.Companion.SENTRY_SPOT
	get() = NavArea(PopFileStringLiteral("SENTRY_SPOT"))

val NavArea.Companion.SNIPER_SPOT
	get() = NavArea(PopFileStringLiteral("SENTRY_SPOT"))

