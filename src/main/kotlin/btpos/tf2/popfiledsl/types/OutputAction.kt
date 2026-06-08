package btpos.tf2.popfiledsl.types

import btpos.tf2.popfiledsl.serialization.IPopFileRepresentable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileMap

class OutputAction
	: IPopFileRepresentable<PopFileMap> // doesn't have its own name, it's just a map with a name GIVEN to it
{
	var target: String? = null
	
	var action: String? = null
	
	override val popFileRepr: PopFileMap
		get() = PopFileMap(
			PopFileEntry("Target", target),
			PopFileEntry("Action", action)
		)
}