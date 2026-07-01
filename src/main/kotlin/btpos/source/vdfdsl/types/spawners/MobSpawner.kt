@file:Suppress("DEPRECATION")

package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct

@Deprecated("According to sigsegv: \"Old and crusty\"")
class MobSpawner : Spawner() {
	override val _structIdentifier: Any
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