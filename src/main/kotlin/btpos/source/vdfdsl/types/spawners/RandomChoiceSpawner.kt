package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct

class RandomChoiceSpawner(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
	val spawners: MutableList<Spawner> by multiStruct()
	
	override val _structIdentifier: String
		get() = "RandomChoice"
	
	override fun copy() = RandomChoiceSpawner(copyInternal())
}

inline fun Spawner.Companion.RandomChoice(spawners: List<Spawner>, configure: RandomChoiceSpawner.() -> Unit = {}): RandomChoiceSpawner {
	return RandomChoiceSpawner().apply { this.spawners.addAll(spawners) }.apply(configure)
}