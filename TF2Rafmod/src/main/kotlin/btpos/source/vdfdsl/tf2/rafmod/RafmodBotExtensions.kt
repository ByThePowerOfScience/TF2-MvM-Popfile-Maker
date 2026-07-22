package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.tf2.rafmod.bot.tasks.SpawnTemplate
import btpos.source.vdfdsl.tf2.rafmod.types.PointTemplate
import btpos.source.vdfdsl.tf2.rafmod.types.RafmodBotAttributes
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

object RafmodBotExtensions {
	/**
	 * Point templates attached to bones on this bot.
	 *
	 * Most of the time, you'll add them with the [+][unaryPlus] operator.
	 *
	 * Example:
	 * ```kotlin
	 * TFBot {
	 *     +SpawnTemplate {
	 *         template = MyPointTemplates.Sentry
	 *         bone = "bip_head"
	 *     }
	 * }
	 * ```
	 */
	var TFBotSpawner.boneTemplates: List<SpawnTemplate> by IExtensibleSubtree.Companion.selfNamedList()
	
	/**
	 * Add a Rafmod-specific struct to this bot.
	 */
	context(spawner: TFBotSpawner)
	operator fun SpawnTemplate.unaryPlus() {
		spawner.boneTemplates += this
	}
	
	
	/**
	 * Extra attributes that can be applied to bots, like vanilla's [attributes][TFBotSpawner.attributes] field.
	 *
	 * Example:
	 * ```kotlin
	 * attributesRafmod += RafmodBotAttributes.MedicLookAtThreats
	 * ```
	 *
	 * @see btpos.source.vdfdsl.tf2.rafmod.types.RafmodBotAttributes.Companion
	 */
	var TFBotSpawner.attributesRafmod: List<RafmodBotAttributes> by IExtensibleSubtree.addField("ExtAttr", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
	
	
	fun TFBotSpawner.attachTemplateToBone(template: PointTemplate, bone: String) {
	    this.boneTemplates += SpawnTemplate().apply {
			this.template = template
		    this.bone = bone
	    }
	}
}