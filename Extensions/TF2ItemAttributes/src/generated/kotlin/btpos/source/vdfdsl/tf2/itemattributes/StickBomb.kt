package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Ullapool Caber
 */
interface StickBombAttributes : btpos.source.vdfdsl.tf2.itemattributes.BottleAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : StickBombAttributes
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var spellHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

