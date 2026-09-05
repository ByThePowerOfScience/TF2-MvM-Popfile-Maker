package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.specifics.NavArea

class RandomPlacementPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "RandomPlacement"
	
	override fun copy() = RandomPlacementPopulator(copyInternal())
	
	
	val count by addField<Int>("Count")
	
	val minimumSeparation by addField<Int>("MinimumSeparation")
	
	val navAreaFilter by addField<NavArea>("NavAreaFilter")
	
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<RandomPlacementPopulator> { Codegen.basicBlockScope(Populators::RandomPlacement) }
	}
}


	