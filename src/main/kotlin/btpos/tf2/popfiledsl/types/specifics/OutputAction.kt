package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.modeling.IMvMSubtree
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileMap

class OutputAction : IMvMSubtree, IPopFileSerializable<PopFileMap> // doesn't have its own name, it's just a map with a name GIVEN to it
{
	override val _rawEntries: MutableMap<Any, IPopFileSerializable<Iterable<PopFileEntry>>> = mutableMapOf()
	
	override val popFileRepr: PopFileMap
		get() = PopFileMap(
			PopFileEntry.Companion("Target", target),
			PopFileEntry.Companion("Action", action)
		)
}

var OutputAction.target: String? by addField("Target")

var OutputAction.action: String? by addField("Action")