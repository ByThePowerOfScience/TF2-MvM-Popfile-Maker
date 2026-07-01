package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.serialization.IVDFSerializableValue_Primitive

/**
 * The name of an info_teamspawn entity, or a [preset][Companion].
 */
class Where(override val _primitiveRepr: String) : IVDFSerializableValue_Primitive<String> {
	companion object {
		@JvmField val AHEAD = Where("Ahead")
		@JvmField val BEHIND = Where("Behind")
		@JvmField val ANYWHERE = Where("Anywhere")
	}
}