package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Flare Gun, The Scorch Shot, The Detonator, The Manmelter
 */
interface FlareGunAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
		 *
		 * 
		 *
		 * 0: Normal.
		 *
		 * 1: Detonator.
		 *
		 * 2: Manmelter.
		 *
		 * 3: Scorch Shot.
		 */
		val flaregunFiresPelletsWithKnockback = ItemAttributeNamed<Boolean>("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
	}

	/**
	 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
	 *
	 * 
	 *
	 * 0: Normal.
	 *
	 * 1: Detonator.
	 *
	 * 2: Manmelter.
	 *
	 * 3: Scorch Shot.
	 */
	val flaregunFiresPelletsWithKnockback: ItemAttribute<Boolean> get() = FlareGunAttributes.flaregunFiresPelletsWithKnockback

   
}

