package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable

class RandomChoiceSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	val spawners: MutableList<AbstractSpawner> by multiStruct()
	
	override val _structIdentifier: String
		get() = "RandomChoice"
	
	override fun copy() = RandomChoiceSpawner(copyInternal())
	
	operator fun AbstractSpawner.unaryPlus() {
		this@RandomChoiceSpawner.spawners += this@unaryPlus.copy()
	}
}

inline fun Spawners.RandomChoice(spawners: List<AbstractSpawner>, configure: RandomChoiceSpawner.() -> Unit = {}): RandomChoiceSpawner {
	return RandomChoiceSpawner().apply { this.spawners.addAll(spawners) }.apply(configure)
}

inline fun RandomChoice(vararg spawners: AbstractSpawner, configure: RandomChoiceSpawner.() -> Unit = {}) = Spawners.RandomChoice(spawners.asList(), configure)