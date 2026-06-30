package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.serialization.IVDFSerializableValue
import btpos.source.vdfdsl.serialization.VDFStringLiteral

/**
 * The name of an info_teamspawn entity, or a [preset][Companion].
 */
class Where private constructor(override val _vdfRepr: Any) : IVDFSerializableValue<Any> {
	companion object {
		/**
		 * Will be unquoted in the popfile. (e.g. `Ahead`)
		 */
	    fun unquoted(location: String) = Where(location)
		
		/**
		 * The name of an `info_teamspawn` entity.  Will be a quoted string in the popfile. (e.g. `"somewhere"`)
		 */
		fun teamspawn(entName: String) = Where(VDFStringLiteral(entName))
		
		val AHEAD = unquoted("Ahead")
		val BEHIND = unquoted("Behind")
		val ANYWHERE = unquoted("Anywhere")
	}
}