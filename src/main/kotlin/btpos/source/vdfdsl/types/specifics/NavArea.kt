package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.serialization.IVDFSerializableValue
import btpos.source.vdfdsl.serialization.VDFStringLiteral

class NavArea(override val _vdfRepr: VDFStringLiteral) : IVDFSerializableValue<VDFStringLiteral> {
	companion object
}

val NavArea.Companion.SENTRY_SPOT
	get() = NavArea(VDFStringLiteral("SENTRY_SPOT"))

val NavArea.Companion.SNIPER_SPOT
	get() = NavArea(VDFStringLiteral("SENTRY_SPOT"))

