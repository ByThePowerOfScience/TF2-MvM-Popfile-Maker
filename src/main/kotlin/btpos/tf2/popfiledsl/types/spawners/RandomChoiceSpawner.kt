package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.multiStruct

class RandomChoiceSpawner : BaseSpawner() {
	val spawners: MutableList<BaseSpawner> by multiStruct()
	
	override val popFileStructIdentifier: Any
		get() = "RandomChoice"
}