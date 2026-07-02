package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

class NavArea(override val _vdfRepr: String) : IVDFRepresentableValue<String> {
	companion object
}

val NavArea.Companion.SENTRY_SPOT
	get() = NavArea("SENTRY_SPOT")

val NavArea.Companion.SNIPER_SPOT
	get() = NavArea("SENTRY_SPOT")

