package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.types.populators.Populator
import btpos.source.vdfdsl.types.specifics.OutputAction

class TankSpawner(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
	override val _structIdentifier: String
		get() = "Tank"
	
	override fun copy() = TankSpawner(copyInternal())
}

inline fun Spawner.Companion.Tank(configure: TankSpawner.() -> Unit = {}) = TankSpawner().apply(configure)

inline fun Populator.Tank(configure: TankSpawner.() -> Unit) = Spawner.Tank(configure).also {
	this.spawner = it
}

var TankSpawner.health: Int? by addField("Health")

var TankSpawner.speed: Float? by addField("Speed")

var TankSpawner.name: String? by addField("Name")

var TankSpawner.skin: Int? by addField("Skin")

var TankSpawner.startingPathTrackNode: String? by addField("StartingPathTrackNode")

var TankSpawner.onKilledOutput: OutputAction? by addField("OnKilledOutput")

var TankSpawner.onBombDroppedOutput: OutputAction? by addField("OnBombDroppedOutput")
