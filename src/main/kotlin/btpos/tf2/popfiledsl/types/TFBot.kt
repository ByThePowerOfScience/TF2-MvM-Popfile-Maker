package btpos.tf2.popfiledsl.types

import btpos.tf2.popfiledsl.serialization.IPopFileItem
import btpos.tf2.popfiledsl.serialization.NamedMap
import btpos.tf2.popfiledsl.types.bots.CharacterAttributes
import btpos.tf2.popfiledsl.types.bots.EventChangeAttributes
import btpos.tf2.popfiledsl.types.bots.ItemAttributes
import btpos.tf2.popfiledsl.types.bots.TFBotAttribute
import btpos.tf2.popfiledsl.types.bots.BehaviorModifier
import btpos.tf2.popfiledsl.types.bots.BotSkill
import btpos.tf2.popfiledsl.types.bots.TFClass
import btpos.tf2.popfiledsl.types.bots.TFItem
import btpos.tf2.popfiledsl.types.bots.WeaponRestriction
import java.nio.file.Path

/**
 * You can use the [copy] method to reuse previous bots with a single thing changed, like this:
 * ```
 * val SNIPER_BOT = TFBot(tfclass = Sniper, skill = HARD)
 *
 * val SYDNEY_SNIPER_BOT = SNIPER_BOT.copy(item = TFItems.Sniper.SYDNEY_SLEEPER)
 * ```
 */
data class TFBot(
	val template: String? = null,
	
	val tfclass: TFClass? = null,
	
	val classIcon: Path? = null,
	
	val health: Int? = null,
	
	val scale: Float? = null,
	
	val name: String? = null,
	
	val teleportWhere: List<String>? = null,
	
	val autoJumpMin: Float? = null,
	
	val autoJumpMax: Float? = null,
	
	val skill: BotSkill? = null,
	
	val weaponRestriction: WeaponRestriction? = null,
	
	val behaviorModifiers: List<BehaviorModifier>? = null,
	
	val maxVisionRange: Float? = null,
	
	val item: List<TFItem>? = null,
	
	val attributes: List<TFBotAttribute>? = null,
	
	val itemAttributes: ItemAttributes? = null,
	
	val characterAttributes: CharacterAttributes? = null,
	
	val eventChangeAttributes: EventChangeAttributes? = null
) : IPopFileItem<NamedMap> {
	override val popFileRepr
		get() = NamedMap("TFBot", mapOf(
			"Template" to template,
			"Class" to tfclass,
			"ClassIcon" to classIcon,
			"Health" to health,
			"Scale" to scale,
			"Name" to name,
			"TeleportWhere" to teleportWhere,
			"AutoJumpMin" to autoJumpMin,
			"AutoJumpMax" to autoJumpMax,
			"Skill" to skill,
			"WeaponRestriction" to weaponRestriction,
			"BehaviorModifiers" to behaviorModifiers,
			"MaxVisionRange" to maxVisionRange,
			"Item" to item,
			"Attributes" to attributes,
			"ItemAttributes" to itemAttributes,
			"CharacterAttributes" to characterAttributes,
			"EventChangeAttributes" to eventChangeAttributes
		).filterValues { it != null } as Map<Any, Any>)
}