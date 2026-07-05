package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.collections.VDFList_Flat
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.KeyValueMapImpl
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.types.bots.BehaviorModifier
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFBotAttribute
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.bots.WeaponRestriction
import btpos.source.vdfdsl.types.populators.MissionPopulator
import btpos.source.vdfdsl.types.populators.spawner

/**
 * ```
 * val SNIPER_BOT = TFBot(tfclass = Sniper, skill = HARD)
 *
 * val SYDNEY_SNIPER_BOT = SNIPER_BOT.copy(item = listOf(TFItems.Sniper.SYDNEY_SLEEPER))
 * ```
 */
class TFBotSpawner(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
	override val _structIdentifier: String
		get() = "TFBot"
	
	override fun copy() = TFBotSpawner(copyInternal())
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
var TFBotSpawner.teleportWhere: VDFList_Flat<String>? by addField("TeleportWhere") { VDFList_Flat(it) }

var TFBotSpawner.autoJumpMin: Number? by addField("AutoJumpMin")

var TFBotSpawner.autoJumpMax: Number? by addField("AutoJumpMax")

var TFBotSpawner.skill: BotSkill? by addField("Skill")

var TFBotSpawner.weaponRestriction: WeaponRestriction? by addField("WeaponRestriction")

var TFBotSpawner.behaviorModifiers: VDFList_Flat<BehaviorModifier>? by addField("BehaviorModifiers") { VDFList_Flat(it) }

var TFBotSpawner.maxVisionRange: Number? by addField("MaxVisionRange")

val TFBotSpawner.items: MutableList<TFItem<*>> by multiStruct()

var TFBotSpawner.attributes: VDFList_Flat<TFBotAttribute>? by addField("Attributes") { VDFList_Flat(it) }

var TFBotSpawner.characterAttributes: KeyValueMapImpl? by addField("CharacterAttributes")

var TFBotSpawner.eventChangeAttributes: KeyValueMapImpl? by addField("EventChangeAttributes")


/**
 * Create a TFBot and implicitly set it as the mission's [spawner][MissionPopulator.spawner].
 */
inline fun MissionPopulator.TFBot(name: String? = null, configure: TFBotSpawner.() -> Unit) = Spawner.TFBot(name, configure).also {
	this.spawner = it
}

inline fun Spawner.Companion.TFBot(name: String? = null, configure: TFBotSpawner.() -> Unit): TFBotSpawner {
	val newSpawner = TFBotSpawner()
	if (name != null) {
		newSpawner.name = name
	}
	newSpawner.apply(configure)
	return newSpawner
}