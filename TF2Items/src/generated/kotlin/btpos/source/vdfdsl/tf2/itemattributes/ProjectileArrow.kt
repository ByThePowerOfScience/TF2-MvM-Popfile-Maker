package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface ProjectileArrowAttributes : BaseRocketAttributes, IBlockScoped {
	companion object : ProjectileArrowAttributes
	
	/**
	 * In-Game: "Fires a special bolt that can repair friendly buildings"
	 *
	 * 
	 *
	 * Checked on player.
	 */
	context(attrs: IKeyValueMap)
	var arrowHealsBuildings: Boolean?
		get() = attrs.getTyped("arrow heals buildings", BinaryIntCodec)
		set(value) = attrs.setNullable("arrow heals buildings", value, BinaryIntCodec)
}

