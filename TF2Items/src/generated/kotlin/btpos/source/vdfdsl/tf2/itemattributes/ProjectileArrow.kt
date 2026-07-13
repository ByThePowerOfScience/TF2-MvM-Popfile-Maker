package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


interface ProjectileArrowAttributes : BaseRocketAttributes, IBlockScoped {
	companion object : ProjectileArrowAttributes
	
	/**
	 * In-Game: "Fires a special bolt that can repair friendly buildings"
	 *
	 * 
	 *
	 * Checked on player.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var arrowHealsBuildings: Boolean?
		get() = attrs.getTyped("arrow heals buildings", BinaryIntCodec)
		set(value) = attrs.setNullable("arrow heals buildings", value, BinaryIntCodec)
}

