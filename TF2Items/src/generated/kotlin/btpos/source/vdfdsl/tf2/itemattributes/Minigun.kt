package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Minigun + Reskins, Natascha, The Brass Beast, Tomislav
 */
interface MinigunAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Silent Killer: No barrel spin sound"
		 *
		 * 
		 */
		val silentBarrel = ItemAttributeNamed<Boolean>("minigun no spin sounds")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% faster spin up time"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% slower spin up time"
		 *
		 * 
		 */
		val minigunSpinupTime = BonusPenalty(
			ItemAttributeNamed<Float>("minigun spinup time decreased"),
			ItemAttributeNamed<Float>("minigun spinup time increased")
		)
		
		/**
		 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
		 *
		 * 
		 *
		 * Overridden by "raid gamemode" to 1.
		 */
		val attackProjectiles = ItemAttributeNamed<Boolean>("attack projectiles")
		
		/**
		 * In-Game: "Creates a ring of flames while spun up"
		 *
		 * 
		 */
		val ringOfFireWhileAiming = ItemAttributeNamed<Int>("ring of fire while aiming")
		
		/**
		 * In-Game: "Consumes an additional N ammo per second while spun up"
		 *
		 * 
		 *
		 * Amount of ammo drained per second.
		 */
		val spinupAmmoDrain = ItemAttributeNamed<Int>("uses ammo while aiming")
	}

	/**
	 * In-Game: "Silent Killer: No barrel spin sound"
	 *
	 * 
	 */
	val silentBarrel: ItemAttribute<Boolean> get() = MinigunAttributes.silentBarrel
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% faster spin up time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower spin up time"
	 *
	 * 
	 */
	val minigunSpinupTime: ItemAttribute<Float> get() = MinigunAttributes.minigunSpinupTime
	
	/**
	 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
	 *
	 * 
	 *
	 * Overridden by "raid gamemode" to 1.
	 */
	val attackProjectiles: ItemAttribute<Boolean> get() = MinigunAttributes.attackProjectiles
	
	/**
	 * In-Game: "Creates a ring of flames while spun up"
	 *
	 * 
	 */
	val ringOfFireWhileAiming: ItemAttribute<Int> get() = MinigunAttributes.ringOfFireWhileAiming
	
	/**
	 * In-Game: "Consumes an additional N ammo per second while spun up"
	 *
	 * 
	 *
	 * Amount of ammo drained per second.
	 */
	val spinupAmmoDrain: ItemAttribute<Int> get() = MinigunAttributes.spinupAmmoDrain

   
}

