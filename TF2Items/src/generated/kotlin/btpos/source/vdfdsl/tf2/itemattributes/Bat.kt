package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: TF_WEAPON_BAT, Upgradeable TF_WEAPON_BAT, The Candy Cane, The Boston Basher, Sun-on-a-Stick, The Fan O'War, The Atomizer, Three-Rune Blade, Festive Bat 2011, Batsaber
 */
interface BatAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Alt-Fire: Launches a ball that slows opponents"
		 *
		 * 
		 *
		 * If 0, cannot create a ball.
		 */
		val batLaunchesBalls = ItemAttributeNamed<Boolean>("mod bat launches balls", NumberSelectorCodec(1))
		
		/**
		 * In-Game: "Alt-Fire: Launches a festive ornament that shatters causing bleed"
		 *
		 * 
		 *
		 * If 0, cannot create a ball.
		 */
		val batLaunchesOrnaments = ItemAttributeNamed<Boolean>("mod bat launches ornaments", NumberSelectorCodec(2))
	}

	/**
	 * In-Game: "Alt-Fire: Launches a ball that slows opponents"
	 *
	 * 
	 *
	 * If 0, cannot create a ball.
	 */
	val batLaunchesBalls: ItemAttribute<Boolean> get() = BatAttributes.batLaunchesBalls
	
	/**
	 * In-Game: "Alt-Fire: Launches a festive ornament that shatters causing bleed"
	 *
	 * 
	 *
	 * If 0, cannot create a ball.
	 */
	val batLaunchesOrnaments: ItemAttribute<Boolean> get() = BatAttributes.batLaunchesOrnaments

   
}

