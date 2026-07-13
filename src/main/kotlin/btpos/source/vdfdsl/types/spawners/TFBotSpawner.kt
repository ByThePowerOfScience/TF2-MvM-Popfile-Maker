package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.modeling.KeyValueMapImpl
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.bots.WeaponRestrictions
import kotlin.apply

/**
 * ```
 * val SNIPER_BOT = TFBot(tfclass = Sniper, skill = HARD)
 *
 * val SYDNEY_SNIPER_BOT = SNIPER_BOT.copy(item = listOf(TFItems.Sniper.SYDNEY_SLEEPER))
 * ```
 */
class TFBotSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	override val _structIdentifier: String
		get() = "TFBot"
	
	override fun copy() = TFBotSpawner(copyInternal())
	
	
	var template: String? by addField("Template")
	
	var `class`: TFClass? by addField("Class")
	
	var classIcon: String? by addField("ClassIcon")
	
	var health: Int? by addField("Health")
	
	var scale: Number? by addField("Scale")
	
	var name: String? by addField("Name")
	
	/**
	 * (name of info_teamspawn entity)
	 */
	var teleportWhere: List<String> by addField("TeleportWhere", serializer = flatListWithKey()) { listOf() }
	
	var autoJumpMin: Number? by addField("AutoJumpMin")
	
	var autoJumpMax: Number? by addField("AutoJumpMax")
	
	var skill: BotSkill? by addField("Skill")
	
	var weaponRestriction: WeaponRestrictions? by addField("WeaponRestrictions")
	
	var behaviorModifiers: List<BehaviorModifiers> by addField("BehaviorModifiers", serializer = flatListWithKey()) { listOf() }
	
	var maxVisionRange: Number? by addField("MaxVisionRange")
	
	val items: MutableList<TFItem<*>> by multiStruct()
	
	var attributes: List<TFBotAttributes> by addField("Attributes", serializer = flatListWithKey()) { listOf() }
	
	var characterAttributes: KeyValueMapImpl? by addField("CharacterAttributes")
	
	final inline fun characterAttributes(configure: IKeyValueMap.() -> Unit) {
		characterAttributes = KeyValueMapImpl().apply(configure)
	}
	
	var eventChangeAttributes: KeyValueMapImpl? by addField("EventChangeAttributes")
	
	final inline fun eventChangeAttributes(configure: IKeyValueMap.() -> Unit) {
		characterAttributes = KeyValueMapImpl().apply(configure)
	}
	
	var tags: List<String> by addField("Tag", serializer = flatListWithKey()) { listOf() }
	
	
	companion object {
		inline operator fun invoke(name: String? = null, template: String? = null, configure: TFBotSpawner.() -> Unit = {}): TFBotSpawner {
			val newSpawner = TFBotSpawner()
			if (name != null)
				newSpawner.name = name
			if (template != null)
				newSpawner.template = template
			newSpawner.apply(configure)
			return newSpawner
		}
	}
}


/**
 * Create a TFBot.
 *
 *  To set it as the current [populator][btpos.source.vdfdsl.types.populators.AbstractPopulator]'s spawner, either set the populator's [spawner][btpos.source.vdfdsl.types.populators.AbstractPopulator.spawner] field (`spawner = TFBot { ... }`) or use the unary `+` operator (`+TFBot { ... }`).
 *
 * Example usage:
 * ```kotlin
 * val jacob = TFBot(name="Jacob") {
 *      `class` = TFClass.Heavy
 *      skill = BotSkill.Hard
 *      items += WeaponsAll.STOCK_MINIGUN {
 *          fireRate.bonus = 0.5
 *      }
 * }
 * ```
 *
 * @param name The "name" field for this bot for easy labeling. Optional. (e.g. `val jacob = TFBot(name="Jacob") { ... }`)
 * @param template The template this bot should extend, for easy template usage. (e.g. `val FAST_SCOUT = TFBot(template="T_TFBot_Giant_Scout_Fast")`)
 * @param configure Set fields in here, and they'll be applied to the bot.
 */
inline fun TFBot(name: String? = null, template: String? = null, configure: TFBotSpawner.() -> Unit = {}) = TFBotSpawner(name, template, configure)

inline fun Spawners.TFBot(name: String? = null, template: String? = null, configure: TFBotSpawner.() -> Unit = {}) = TFBotSpawner(name, template, configure)

