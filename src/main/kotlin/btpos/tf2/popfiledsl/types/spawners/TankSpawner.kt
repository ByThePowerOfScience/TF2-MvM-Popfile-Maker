package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.serialization.codecs.StringLiteralCodec
import btpos.tf2.popfiledsl.types.OutputAction

class TankSpawner : BaseSpawner() {
	
	override val popFileStructIdentifier
		get() = "Tank"
}

var TankSpawner.health: Int? by addField("Health")

var TankSpawner.speed: Float? by addField("Speed")

var TankSpawner.name: String? by addField("Name", StringLiteralCodec)

var TankSpawner.skin: Int? by addField("Skin")

var TankSpawner.startingPathTrackNode: String? by addField("StartingPathTrackNode", StringLiteralCodec)

var TankSpawner.onKilledOutput: OutputAction? by addField("OnKilledOutput")

var TankSpawner.onBombDroppedOutput: OutputAction? by addField("OnBombDroppedOutput")
