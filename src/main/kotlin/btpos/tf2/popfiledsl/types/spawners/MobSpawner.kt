@file:Suppress("DEPRECATION")
package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleStruct

@Deprecated("According to sigsegv: \"Old and crusty\"")
class MobSpawner : Spawner() {
	override val _popFileStructIdentifier: Any
		get() = "Mob"
}

var MobSpawner.count: Int? by addField("Count")
var MobSpawner.spawner: Spawner? by singleStruct()


@Deprecated("Old and crusty")
fun Spawner.Companion.Mob(count: Int, spawner: Spawner): MobSpawner {
	return MobSpawner().apply {
		this.count = count
		this.spawner = spawner
	}
}