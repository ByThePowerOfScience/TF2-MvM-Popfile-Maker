package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.serialization.PopFileQuotedString
import btpos.tf2.popfiledsl.types.OutputAction

class TankSpawner : BaseSpawner() {
	var health: Int? by singleKeyedValue("Health", { require(it >= 0) { "Health may not be negative." }; it }, { it })
	
	var speed: Float? by singleKeyedValue("Speed")
	
	var name: String? by singleKeyedValue("Name", ::PopFileQuotedString, PopFileQuotedString::string)
	
	var skin: Int? by singleKeyedValue("Skin")
	
	var startingPathTrackNode: String? by singleKeyedValue("StartingPathTrackNode", ::PopFileQuotedString, PopFileQuotedString::string)
	
	var onKilledOutput: OutputAction? by singleKeyedValue("OnKilledOutput")
	
	var onBombDroppedOutput: OutputAction? by singleKeyedValue("OnBombDroppedOutput")
	
	override val popFileStructIdentifier
		get() = "Tank"
}