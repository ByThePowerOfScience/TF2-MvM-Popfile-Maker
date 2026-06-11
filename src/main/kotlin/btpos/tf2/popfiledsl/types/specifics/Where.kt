package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral

/**
 * The name of an info_teamspawn entity, or a [preset][Companion].
 */
class Where private constructor(override val popFileRepr: Any) : IPopFileSerializable<Any> {
	companion object {
		/**
		 * Will be unquoted in the pop file
		 */
	    fun unquoted(location: String) = Where(location)
		
		/**
		 *
		 */
		fun teamspawn(entName: String) = Where(PopFileStringLiteral(entName))
		
		val AHEAD = unquoted("Ahead")
		val BEHIND = unquoted("Behind")
		val ANYWHERE = unquoted("Anywhere")
	}
}