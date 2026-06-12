package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtreeMap
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry

class OutputAction : IMvMSubtreeMap // doesn't have its own name, it's just a map with a name GIVEN to it
{
	override val _rawEntries: MutableMap<Any, IPopFileSerializable<Iterable<PopFileEntry>>> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}

var OutputAction.target: String? by addField("Target", isRequired = true)

var OutputAction.action: String? by addField("Action", isRequired = true)