@file:Suppress("DEPRECATION")

package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.populators.MissionPopulator

@Deprecated("According to sigsegv: \"Old and crusty\"")
class MobSpawner(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
	override val _structIdentifier: String
		get() = "Mob"
	
	override fun copy() = MobSpawner(copyInternal())
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
