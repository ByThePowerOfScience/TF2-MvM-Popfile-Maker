package btpos.tf2.popfiledsl.types.spawners

@Deprecated("\"Old and crusty\"")
class MobSpawner(count: Int, spawners: List<BaseSpawner>) : BaseSpawner() {
	var count: Int? by singleKeyedValue("Count")
	val spawners: MutableList<BaseSpawner> by multiStruct()
	
	init {
		this.count = count
		this.spawners.clear()
		this.spawners.addAll(spawners)
	}
	
	override val popFileStructIdentifier: Any
		get() = "Mob"
}