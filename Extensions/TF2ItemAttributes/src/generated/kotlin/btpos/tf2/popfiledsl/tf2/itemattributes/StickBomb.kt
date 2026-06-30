package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Ullapool Caber
 */
interface StickBombAttributes : BottleAttributes, IBlockScoped {
	companion object : StickBombAttributes
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var spellHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
}

