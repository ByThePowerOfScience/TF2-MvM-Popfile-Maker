package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.serialization.IVDFSerializableValue
import btpos.tf2.popfiledsl.serialization.VDFStringLiteral

class NavArea(override val _vdfRepr: VDFStringLiteral) : IVDFSerializableValue<VDFStringLiteral> {
	companion object
}

val NavArea.Companion.SENTRY_SPOT
	get() = NavArea(VDFStringLiteral("SENTRY_SPOT"))

val NavArea.Companion.SNIPER_SPOT
	get() = NavArea(VDFStringLiteral("SENTRY_SPOT"))

