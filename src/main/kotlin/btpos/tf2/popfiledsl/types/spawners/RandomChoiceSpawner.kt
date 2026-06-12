package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.multiStruct

class RandomChoiceSpawner : Spawner() {
	val spawners: MutableList<Spawner> by multiStruct()
	
	override val _popFileStructIdentifier: Any
		get() = "RandomChoice"
}

inline fun Spawner.Companion.RandomChoice(spawners: List<Spawner>, configure: RandomChoiceSpawner.() -> Unit = {}): RandomChoiceSpawner {
	return RandomChoiceSpawner().apply { this.spawners.addAll(spawners) }.apply(configure)
}