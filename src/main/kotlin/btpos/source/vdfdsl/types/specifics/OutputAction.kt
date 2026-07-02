package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import org.intellij.lang.annotations.Language

class OutputAction : IExtensibleSubtree // doesn't have its own name, it's just a map with a name GIVEN to it
{
	override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}

var OutputAction.target: String? by addField("Target", isRequired = true)

var OutputAction.action: String? by addField("Action", isRequired = true)

@get:Language("Squirrel") @set:Language("Squirrel")
var OutputAction.param: String? by addField("Param")