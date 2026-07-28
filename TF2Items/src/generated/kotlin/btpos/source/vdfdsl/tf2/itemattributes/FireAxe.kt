package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: TF_WEAPON_FIREAXE, The Axtinguisher, The Homewrecker, Upgradeable TF_WEAPON_FIREAXE, The Powerjack, The Back Scratcher, Sharpened Volcano Fragment, The Postal Pummeler, The Maul, The Third Degree, The Lollichop, Festive Axtinguisher
 */
interface FireAxeAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 *
		 * 
		 *
		 * Ignite enemies on hit.
		 */
		val setDamagetypeIgnite = ItemAttributeNamed<Boolean>("Set DamageType Ignite")
	}

	/**
	 * In-Game: "On Hit: target is engulfed in flames"
	 *
	 * 
	 *
	 * Ignite enemies on hit.
	 */
	val setDamagetypeIgnite: ItemAttribute<Boolean> get() = FireAxeAttributes.setDamagetypeIgnite

   
}

