@file:Suppress("DEPRECATION")

package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable

@Deprecated("According to sigsegv: \"Old and crusty\"")
class MobSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	override val _structIdentifier: String
		get() = "Mob"
	
	var count: Int? by addField("Count")
	var spawner: AbstractSpawner? by singleStruct()
	
	
	override fun copy() = MobSpawner(copyInternal())
}



@Deprecated("Old and crusty")
fun Spawners.Mob(count: Int, spawner: AbstractSpawner): MobSpawner {
	return MobSpawner().apply {
		this.count = count
		this.spawner = spawner
	}
}
