package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.specifics.NavArea

class RandomPlacementPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "RandomPlacement"
	
	override fun copy() = RandomPlacementPopulator(copyInternal())
	
	
	var count: Int? by addField("Count")
	
	var minimumSeparation: Int? by addField("MinimumSeparation")
	
	var navAreaFilter: NavArea? by addField("NavAreaFilter")
}


	