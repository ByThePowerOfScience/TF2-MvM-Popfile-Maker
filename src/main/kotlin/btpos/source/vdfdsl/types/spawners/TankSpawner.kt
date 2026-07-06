package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.populators.Populator
import btpos.source.vdfdsl.types.specifics.OutputAction

class TankSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
	override val _structIdentifier: String
		get() = "Tank"
	
	override fun copy() = TankSpawner(copyInternal())
	
	
	var health: Int? by addField("Health")
	
	var speed: Number? by addField("Speed")
	
	var name: String? by addField("Name")
	
	var skin: Int? by addField("Skin")
	
	var startingPathTrackNode: String? by addField("StartingPathTrackNode")
	
	var onKilledOutput: OutputAction? by addField("OnKilledOutput")
	
	var onBombDroppedOutput: OutputAction? by addField("OnBombDroppedOutput")
}

inline fun Spawner.Companion.Tank(configure: TankSpawner.() -> Unit = {}) = TankSpawner().apply(configure)

inline fun Tank(configure: TankSpawner.() -> Unit) = Spawner.Tank(configure)

