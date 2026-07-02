package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.types.specifics.OutputAction

class TankSpawner : Spawner() {
	
	override val _structIdentifier: String
		get() = "Tank"
}

fun Spawner.Companion.Tank(configure: TankSpawner.() -> Unit = {}) = TankSpawner().apply(configure)

var TankSpawner.health: Int? by addField("Health")

var TankSpawner.speed: Float? by addField("Speed")

var TankSpawner.name: String? by addField("Name")

var TankSpawner.skin: Int? by addField("Skin")

var TankSpawner.startingPathTrackNode: String? by addField("StartingPathTrackNode")

var TankSpawner.onKilledOutput: OutputAction? by addField("OnKilledOutput")

var TankSpawner.onBombDroppedOutput: OutputAction? by addField("OnBombDroppedOutput")
