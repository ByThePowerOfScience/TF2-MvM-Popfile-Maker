package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.serialization.IVDFSerializableValue_Primitive

class NavArea(override val _primitiveRepr: String) : IVDFSerializableValue_Primitive<String> {
	companion object
}

val NavArea.Companion.SENTRY_SPOT
	get() = NavArea("SENTRY_SPOT")

val NavArea.Companion.SNIPER_SPOT
	get() = NavArea("SENTRY_SPOT")

