package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.types.bots.AttributeContainer
import btpos.tf2.popfiledsl.types.bots.BehaviorModifier
import btpos.tf2.popfiledsl.types.bots.BotSkill
import btpos.tf2.popfiledsl.types.bots.TFBotAttribute
import btpos.tf2.popfiledsl.types.bots.TFClass
import btpos.tf2.popfiledsl.types.bots.TFItem
import btpos.tf2.popfiledsl.types.bots.WeaponRestriction
import btpos.tf2.popfiledsl.types.spawners.TFBot
import kotlin.apply

/**
 * ```
 * val SNIPER_BOT = TFBot(tfclass = Sniper, skill = HARD)
 *
 * val SYDNEY_SNIPER_BOT = SNIPER_BOT.copy(item = listOf(TFItems.Sniper.SYDNEY_SLEEPER))
 * ```
 */
class TFBotSpawner : Spawner() {
	override val _popFileStructIdentifier
		get() = "TFBot"
}

var TFBotSpawner.template: String? by addField("Template")

var TFBotSpawner.tfclass: TFClass? by addField("Class")

var TFBotSpawner.classIcon: String? by addField("ClassIcon")

var TFBotSpawner.health: Int? by addField("Health")

var TFBotSpawner.scale: Float? by addField("Scale")

var TFBotSpawner.name: String? by addField("Name")

/**
 * (name of info_teamspawn entity)
 */
var TFBotSpawner.teleportWhere: MutableList<String>? by addField("TeleportWhere") { mutableListOf() }

var TFBotSpawner.autoJumpMin: Float? by addField("AutoJumpMin")

var TFBotSpawner.autoJumpMax: Float? by addField("AutoJumpMax")

var TFBotSpawner.skill: BotSkill? by addField("Skill")

var TFBotSpawner.weaponRestriction: WeaponRestriction? by addField("WeaponRestriction")

var TFBotSpawner.behaviorModifiers: MutableList<BehaviorModifier>? by addField("BehaviorModifiers") { mutableListOf() }

var TFBotSpawner.maxVisionRange: Float? by addField("MaxVisionRange")

var TFBotSpawner.items: MutableList<TFItem>? by addField("Item") { mutableListOf() }

var TFBotSpawner.attributes: MutableList<TFBotAttribute>? by addField("Attributes") { mutableListOf() }

var TFBotSpawner.characterAttributes: AttributeContainer? by addField("CharacterAttributes")

var TFBotSpawner.eventChangeAttributes: AttributeContainer? by addField("EventChangeAttributes")


inline fun TFBot(name: String? = null, configure: TFBotSpawner.() -> Unit) = Spawner.TFBot(name, configure)

inline fun Spawner.Companion.TFBot(name: String? = null, configure: TFBotSpawner.() -> Unit): TFBotSpawner {
	val newSpawner = TFBotSpawner()
	if (name != null) {
		newSpawner.name = name
	}
	newSpawner.apply(configure)
	return newSpawner
}