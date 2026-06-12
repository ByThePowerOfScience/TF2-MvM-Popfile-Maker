package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.multiStruct

class RandomChoiceSpawner : Spawner() {
	val spawners: MutableList<Spawner> by multiStruct()
	
	override val popFileStructIdentifier: Any
		get() = "RandomChoice"
}

inline fun Spawner.Companion.RandomChoice(spawners: List<Spawner>, configure: RandomChoiceSpawner.() -> Unit = {}): RandomChoiceSpawner {
	val newSpawner = TFBotSpawner()
	if (name != null) {
		newSpawner.name = name
	}
	newSpawner.apply(configure)
	return newSpawner
}