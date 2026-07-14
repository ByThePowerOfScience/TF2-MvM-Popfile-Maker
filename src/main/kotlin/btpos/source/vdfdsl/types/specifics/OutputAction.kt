package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import org.intellij.lang.annotations.Language

open class OutputAction : ExtensibleSubtreeImpl() {
	companion object {
		inline operator fun invoke(configure: OutputAction.() -> Unit): OutputAction {
			return OutputAction().apply(configure)
		}
	}
	
	
	open var target: String? by addField("Target")
	
	open var action: String? by addField("Action")
	
	open var param: String? by addField("Param")
	
	open fun trigger(target: String) {
		this.target = target
		this.action = "Trigger"
	}
}


