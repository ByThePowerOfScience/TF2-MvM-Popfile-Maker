@file:Suppress("UNUSED")
package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.modeling.KeyValueMapImpl
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.templates.PopFileTemplate
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.EventChangeAttributes
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.bots.WeaponRestrictions


interface ChangeableBotAttributes : IExtensibleSubtree


var ChangeableBotAttributes.skill: BotSkill? by addField("Skill")


var ChangeableBotAttributes.items: List<TFItem<*>> by selfNamedList()

var ChangeableBotAttributes.weaponRestriction: WeaponRestrictions? by addField("WeaponRestrictions")

var ChangeableBotAttributes.behaviorModifiers: List<BehaviorModifiers> by addField("BehaviorModifiers", serializer = flatListWithKey()) { listOf() }

var ChangeableBotAttributes.maxVisionRange: Number? by addField("MaxVisionRange")


/**
 * Define arbitrary item attributes without adding the weapon itself.
 *
 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
 *
 * @see addAttributesForExisting
 */
var ChangeableBotAttributes.itemAttributes: List<KeyValueMapImpl> by addField("ItemAttributes", serializer=flatListWithKey()) { listOf() }


var ChangeableBotAttributes.attributes: List<TFBotAttributes> by addField("Attributes", serializer = flatListWithKey()) { listOf() }

var ChangeableBotAttributes.characterAttributes: KeyValueMapImpl? by addField("CharacterAttributes")

inline fun ChangeableBotAttributes.characterAttributes(configure: IKeyValueMap.() -> Unit) {
	characterAttributes = KeyValueMapImpl().apply(configure)
}


var ChangeableBotAttributes.tags: List<String> by addField("Tag", serializer = flatListWithKey()) { listOf() }


/**
 * Define attributes for an item without adding the item itself.
 *
 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
 */
inline fun <ATTR : Any> ChangeableBotAttributes.addAttributesForExisting(item: TFItem<ATTR>, attrScope: context(IKeyValueMap) ATTR.() -> Unit) {
	itemAttributes += item.usingAttributesScope(KeyValueMapImpl(), attrScope)
}

@Suppress("RedundantModalityModifier")
open class TFBotSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : ChangeableBotAttributes, AbstractSpawner(_subtree) {
	override val _structIdentifier: String
		get() = "TFBot"
	
	override fun copy() = TFBotSpawner(copyInternal())
	
	
	var template: PopFileTemplate? by addField("Template")
	
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
	
	
	var eventChangeAttributes: List<EventChangeAttributes> by addField("EventChangeAttributes", initialValue=::listOf, serializer = IExtensibleSubtree.Serializers.subtreeOfSubtrees())
	
	
	
	
	companion object {
		inline operator fun invoke(name: String? = null, template: PopFileTemplate? = null, configure: TFBotSpawner.() -> Unit = {}): TFBotSpawner {
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
 * Define attributes for an item without adding the item itself.
 *
 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
 */
inline fun <ATTR : Any> TFBotSpawner.addAttributesForExisting(item: TFItem<ATTR>, attrScope: context(IKeyValueMap) ATTR.() -> Unit) {
	itemAttributes += item.configureAttributes(KeyValueMapImpl(), attrScope)
}

