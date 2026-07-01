package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.serialization.IVDFSerializableValue

/**
 * The name of an info_teamspawn entity, or a [preset][Companion].
 */
class Where(override val _vdfRepr: String) : IVDFSerializableValue<String> {
	companion object {
		fun teamspawn(entName: String) = Where(entName)
		
		@JvmField val AHEAD = Where("Ahead")
		@JvmField val BEHIND = Where("Behind")
		@JvmField val ANYWHERE = Where("Anywhere")
	}
}