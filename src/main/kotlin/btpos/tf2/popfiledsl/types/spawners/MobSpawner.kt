package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleKeyedValue
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleStruct

@Deprecated("According to sigsegv: \"Old and crusty\"")
class MobSpawner : BaseSpawner() {
	override val popFileStructIdentifier: Any
		get() = "Mob"
}

var MobSpawner.count: Int? by singleKeyedValue("Count")
var MobSpawner.spawner: BaseSpawner? by singleStruct()

fun MobSpawner(count: Int, spawner: BaseSpawner): MobSpawner {
	return MobSpawner().apply {
		this.count = count
		this.spawner = spawner
	}
}