package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface StickBombAttributes : IBlockScoped {
	
	companion object {
		/**
		 * In-Game: "Pumpkin Bombs"
		 */
		val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween pumpkin explosions")
	}

	/**
	 * In-Game: "Pumpkin Bombs"
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = StickBombAttributes.spellHalloweenPumpkinExplosions
}