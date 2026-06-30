package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.IMvMSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.codecs.StringLiteralCodec
import btpos.source.vdfdsl.types.specifics.OutputAction

class TankSpawner : Spawner() {
	
	override val _popFileStructIdentifier
		get() = "Tank"
}

fun Spawner.Companion.Tank(configure: TankSpawner.() -> Unit = {}) = TankSpawner().apply(configure)

var TankSpawner.health: Int? by addField("Health")

var TankSpawner.speed: Float? by addField("Speed")

var TankSpawner.name: String? by addField("Name", StringLiteralCodec)

var TankSpawner.skin: Int? by addField("Skin")

var TankSpawner.startingPathTrackNode: String? by addField("StartingPathTrackNode", StringLiteralCodec)

var TankSpawner.onKilledOutput: OutputAction? by addField("OnKilledOutput")

var TankSpawner.onBombDroppedOutput: OutputAction? by addField("OnBombDroppedOutput")
