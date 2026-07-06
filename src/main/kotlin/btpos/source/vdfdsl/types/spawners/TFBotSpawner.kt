package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
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
class TFBotSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
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
	var teleportWhere: List<String> by addField("TeleportWhere", serializer = flatListWithKey("TeleportWhere")) { listOf() }
	
	var autoJumpMin: Number? by addField("AutoJumpMin")
	
	var autoJumpMax: Number? by addField("AutoJumpMax")
	
	var skill: BotSkill? by addField("Skill")
	
	var weaponRestriction: WeaponRestrictions? by addField("WeaponRestrictions")
	
	var behaviorModifiers: List<BehaviorModifiers> by addField("BehaviorModifiers", serializer = flatListWithKey("BehaviorModifiers")) { listOf() }
	
	var maxVisionRange: Number? by addField("MaxVisionRange")
	
	val items: MutableList<TFItem<*>> by multiStruct()
	
	var attributes: List<TFBotAttributes> by addField("Attributes", serializer = flatListWithKey("Attributes")) { listOf() }
	
	var characterAttributes: KeyValueMapImpl? by addField("CharacterAttributes")
	
	var eventChangeAttributes: KeyValueMapImpl? by addField("EventChangeAttributes")
	
	var tags: List<String> by addField("Tag", serializer = flatListWithKey("Tag")) { listOf() }
	
	
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
 * Create a TFBot and implicitly set it as the populator's [spawner].
 */
inline fun TFBot(name: String? = null, template: String? = null, configure: TFBotSpawner.() -> Unit = {}) = TFBotSpawner()
	.apply {
		if (name != null)
			this.name = name
		if (template != null)
			this.template = template
	}
	.apply(configure)

inline fun Spawner.Companion.TFBot(name: String? = null, template: String? = null, configure: TFBotSpawner.() -> Unit = {}) = TFBotSpawner(name, template, configure)

