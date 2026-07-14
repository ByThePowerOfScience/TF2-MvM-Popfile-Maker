package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable

class RandomChoiceSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	var spawners: List<AbstractSpawner> by selfNamedList()
	
	override val _structIdentifier: String
		get() = "RandomChoice"
	
	override fun copy() = RandomChoiceSpawner(copyInternal())
	
	operator fun AbstractSpawner.unaryPlus() {
		this@RandomChoiceSpawner.spawners += this@unaryPlus.copy()
	}
}
