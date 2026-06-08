package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.types.bots.AttributeContainer
import btpos.tf2.popfiledsl.types.bots.BehaviorModifier
import btpos.tf2.popfiledsl.types.bots.BotSkill
import btpos.tf2.popfiledsl.types.bots.TFBotAttribute
import btpos.tf2.popfiledsl.types.bots.TFClass
import btpos.tf2.popfiledsl.types.bots.TFItem
import btpos.tf2.popfiledsl.types.bots.WeaponRestriction

/**
 * ```
 * val SNIPER_BOT = TFBot(tfclass = Sniper, skill = HARD)
 *
 * val SYDNEY_SNIPER_BOT = SNIPER_BOT.copy(item = listOf(TFItems.Sniper.SYDNEY_SLEEPER))
 * ```
 */
class TFBotSpawner(name: String? = null) : BaseSpawner() {
	override val popFileStructIdentifier
		get() = "TFBot"
	
	var template: String? by singleKeyedValue("Template")
	
	var tfclass: TFClass? by singleKeyedValue("Class")
	
	var classIcon: String? by singleKeyedValue("ClassIcon")
	
	var health: Int? by singleKeyedValue("Health")
	
	var scale: Float? by singleKeyedValue("Scale")
	
	var name: String? by singleKeyedValue("Name")
	
	init {
		if (name != null) {
			this.name = name
		}
	}
	
	/**
	 * (name of info_teamspawn entity)
	 */
	var teleportWhere: List<String>? by singleKeyedValue("TeleportWhere")
	
	var autoJumpMin: Float? by singleKeyedValue("AutoJumpMin")
	
	var autoJumpMax: Float? by singleKeyedValue("AutoJumpMax")
	
	var skill: BotSkill? by singleKeyedValue("Skill")
	
	var weaponRestriction: WeaponRestriction? by singleKeyedValue("WeaponRestriction")
	
	var behaviorModifiers: List<BehaviorModifier>? by singleKeyedValue("BehaviorModifiers")
	
	var maxVisionRange: Float? by singleKeyedValue("MaxVisionRange")
	
	var items: List<TFItem>? by singleKeyedValue("Item")
	
	var attributes: List<TFBotAttribute>? by singleKeyedValue("Attributes")
	
	var characterAttributes: AttributeContainer? by singleKeyedValue("CharacterAttributes")
	
	var eventChangeAttributes: AttributeContainer? by singleKeyedValue("EventChangeAttributes")
}

inline fun TFBot(name: String? = null, configure: TFBotSpawner.() -> Unit): TFBotSpawner {
	return TFBotSpawner(name).apply(configure)
}