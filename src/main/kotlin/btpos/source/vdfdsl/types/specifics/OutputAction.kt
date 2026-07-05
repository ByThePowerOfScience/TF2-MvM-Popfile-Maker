package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import org.intellij.lang.annotations.Language

class OutputAction : ExtensibleSubtreeImpl()


var OutputAction.target: String? by addField("Target", isRequired = true)

var OutputAction.action: String? by addField("Action", isRequired = true)

@get:Language("Squirrel") @set:Language("Squirrel")
var OutputAction.param: String? by addField("Param")

fun OutputAction.trigger(target: String) {
	this.target = target
	this.action = "Trigger"
}