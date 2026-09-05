package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.keyed
import btpos.source.vdfdsl.codegen.map
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addFieldList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.mapEachCond
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerImpl
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerSubtreeSerializable
import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.templates.PopFileTemplate
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.EventChangeAttributes
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.bots.WeaponRestrictions


interface ChangeableBotAttributes : IExtensibleSubtree


val ChangeableBotAttributes.skill by addField<BotSkill>("Skill")


val ChangeableBotAttributes.items by selfNamedList<TFItem<*>>()

val ChangeableBotAttributes.weaponRestriction by addField<WeaponRestrictions>("WeaponRestrictions")

val ChangeableBotAttributes.behaviorModifiers by addFieldList<BehaviorModifiers>("BehaviorModifiers")

val ChangeableBotAttributes.maxVisionRange by addField<Number>("MaxVisionRange")


/**
 * Define arbitrary item attributes without adding the weapon itself.
 *
 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
 *
 * @see addAttributesForExisting
 */
val ChangeableBotAttributes.itemAttributes by addFieldList<IAttributeContainer>("ItemAttributes", serializer=mapEachCond(::AttributeContainerSubtreeSerializable, flatListWithKey()))


val ChangeableBotAttributes.attributes by addFieldList<TFBotAttributes>("Attributes", serializer = flatListWithKey())

val ChangeableBotAttributes.characterAttributes by addField<IAttributeContainer>("CharacterAttributes", serializer=::AttributeContainerSubtreeSerializable)

inline fun ChangeableBotAttributes.characterAttributes(configure: IAttributeContainer.() -> Unit) {
	this.characterAttributes = AttributeContainerImpl().apply(configure)
}


val ChangeableBotAttributes.tags by addFieldList<String>("Tag", serializer = flatListWithKey())


/**
 * Define attributes for an item without adding the item itself.
 *
 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
 */
inline fun <ATTR : Any> ChangeableBotAttributes.addAttributesForExisting(item: TFItem<ATTR>, attrScope: context(AttributeContainerImpl) ATTR.() -> Unit) {
	itemAttributes += item.configureAttributes(AttributeContainerImpl(), attrScope)
}



@Suppress("RedundantModalityModifier")
open class TFBotSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : ChangeableBotAttributes, AbstractSpawner(_subtree) {
	override val _structIdentifier: String
		get() = "TFBot"
	
	override fun copy() = TFBotSpawner(copyInternal())
	
	
	val template by addField<PopFileTemplate>("Template")
	
	val `class` by addField<TFClass>("Class")
	
	val classIcon by addField<String>("ClassIcon")
	
	val health by addField<Int>("Health")
	
	val scale by addField<Number>("Scale")
	
	val name by addField<String>("Name")
	
	/**
	 * (name of info_teamspawn entity)
	 */
	val teleportWhere by addFieldList<String>("TeleportWhere", serializer = flatListWithKey())
	
	val autoJumpMin by addField<Number>("AutoJumpMin")
	
	val autoJumpMax by addField<Number>("AutoJumpMax")
	
	// TODO document these, also make sure I understand EventChangeAttributes
	val eventChangeAttributes by addField<EventChangeAttributes>("EventChangeAttributes", initialValue = ::EventChangeAttributes)
	
	
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
		
		
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<TFBotSpawner> {
			Codegen.basicBlockScope(Spawners::TFBot, mapOf(
				TFBotSpawner::name.name to "name",
				TFBotSpawner::template.name to "template",
			))
		}
		
		val CODEGEN_SELF = CODEGEN.map { it.keyed("TFBot") }
	}
}


/**
 * Define attributes for an item without adding the item itself.
 *
 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
 */
inline fun <ATTR : Any> TFBotSpawner.addAttributesForExisting(item: TFItem<ATTR>, attrScope: context(IAttributeContainer) ATTR.() -> Unit) {
	itemAttributes += item.configureAttributes(AttributeContainerImpl(), attrScope)
}

