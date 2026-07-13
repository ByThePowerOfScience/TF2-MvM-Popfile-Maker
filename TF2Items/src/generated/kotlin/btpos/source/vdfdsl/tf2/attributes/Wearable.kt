package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*


interface WearableAttributes : BaseEntityAttributes, IBlockScoped {
	companion object : WearableAttributes
	
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
	 * Overrides the skin used when disguising as this player.
	 */
	context(attrs: IKeyValueMap)
	var playerSkinOverride: Int?
		get() = attrs.getTyped("player skin override")
		set(value) = attrs.setNullable("player skin override", value)
}

