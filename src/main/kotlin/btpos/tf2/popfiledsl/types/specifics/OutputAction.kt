package btpos.tf2.popfiledsl.types.specifics

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtreeMap
import btpos.tf2.popfiledsl.serialization.IVDFSerializableKeyValue
import org.intellij.lang.annotations.Language

class OutputAction : IMvMSubtreeMap // doesn't have its own name, it's just a map with a name GIVEN to it
{
	override val _rawEntries: MutableMap<Any, IVDFSerializableKeyValue> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}

var OutputAction.target: String? by addField("Target", isRequired = true)

var OutputAction.action: String? by addField("Action", isRequired = true)

@get:Language("Squirrel") @set:Language("Squirrel")
var OutputAction.param: String? by addField("Param")