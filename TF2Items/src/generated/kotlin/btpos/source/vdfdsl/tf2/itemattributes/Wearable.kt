package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Cosmetics, The Manntreads, The Gunboats, The Razorback, Darwin's Danger Shield, The Cozy Camper, Ali Baba's Wee Booties, The Bootlegger
 */
interface WearableAttributes : BaseEntityAttributes, IBlockScoped {
	companion object : WearableAttributes
	
	/**
	 * In-Game: "Immune to the effects of afterburn."
	 *
	 * 
	 *
	 * For the base "`Wearable`", only checked on Sniper.
	 */
	context(attrs: IKeyValueMap)
	var afterburnImmunity: Boolean?
		get() = attrs.getTyped("afterburn immunity", BinaryIntCodec)
		set(value) = attrs.setNullable("afterburn immunity", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Duck Power : N / 5"
	 *
	 * 
	 *
	 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
	 */
	context(attrs: IKeyValueMap)
	var duckBadgeLevel: Int?
		get() = attrs.getTyped("duck badge level")
		set(value) = attrs.setNullable("duck badge level", value)
	
	/**
	 * 
	 *
	 * Overrides the skin used for the player. (e.g. Zombie).
	 */
	context(attrs: IKeyValueMap)
	var playerSkinOverride: Int?
		get() = attrs.getTyped("player skin override")
		set(value) = attrs.setNullable("player skin override", value)
}

