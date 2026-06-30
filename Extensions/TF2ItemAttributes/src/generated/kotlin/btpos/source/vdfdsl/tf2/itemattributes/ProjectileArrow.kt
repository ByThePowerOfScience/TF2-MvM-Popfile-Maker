package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface ProjectileArrowAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseRocketAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
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
		get() = attrs.getTyped("arrow heals buildings", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("arrow heals buildings", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

