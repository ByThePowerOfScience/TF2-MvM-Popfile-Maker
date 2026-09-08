package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import org.intellij.lang.annotations.Language

open class OutputAction : ExtensibleSubtreeImpl() {
	open val target by addField<String>("Target")
	
	open val action by addField<String>("Action")
	
	open val param by addField<String>("Param")
	
	open fun trigger(target: String) {
		this.target = target
		this.action = "Trigger"
	}
	
	companion object {
		inline operator fun invoke(configure: OutputAction.() -> Unit): OutputAction {
			return OutputAction().apply(configure)
		}
		
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<OutputAction> { Codegen.companionOperatorInvoke(OutputAction::class) }
	}
}