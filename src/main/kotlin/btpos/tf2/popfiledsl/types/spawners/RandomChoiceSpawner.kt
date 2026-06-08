package btpos.tf2.popfiledsl.types.spawners

class RandomChoiceSpawner : BaseSpawner() {
	val spawners: MutableList<BaseSpawner> by multiStruct()
	
	override val popFileStructIdentifier: Any
		get() = "RandomChoice"
}