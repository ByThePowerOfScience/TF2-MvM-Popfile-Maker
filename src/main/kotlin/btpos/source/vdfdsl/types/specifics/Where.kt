package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

/**
 * The name of an info_teamspawn entity, or a [preset][Companion].
 */
class Where(val name: String) : IVDFRepresentableValue<VDFPrimitive> {
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object {
		@JvmField val AHEAD = Where("Ahead")
		@JvmField val BEHIND = Where("Behind")
		@JvmField val ANYWHERE = Where("Anywhere")
	}
}