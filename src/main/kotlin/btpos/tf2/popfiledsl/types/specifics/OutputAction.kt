package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileMap

class OutputAction
	: IPopFileSerializable<PopFileMap> // doesn't have its own name, it's just a map with a name GIVEN to it
{
	var target: String? = null
	
	var action: String? = null
	
	override val popFileRepr: PopFileMap
		get() = PopFileMap(
			PopFileEntry.Companion("Target", target),
			PopFileEntry.Companion("Action", action)
		)
}