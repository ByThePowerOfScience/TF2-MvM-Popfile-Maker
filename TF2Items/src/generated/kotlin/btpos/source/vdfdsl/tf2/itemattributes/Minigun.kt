package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface MinigunAttributes : BaseGunAttributes {
	
	companion object {
		/**
		 * In-Game: "Silent Killer: No barrel spin sound"
		 */
		val silentBarrel: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minigun no spin sounds")
	
		val minigunSpinupTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("minigun spinup time decreased"),
			ItemAttributeNamed("minigun spinup time increased"),
		)
	
		/**
		 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
		 * 
		 * Overridden by "raid gamemode" to 1.
		 */
		val attackProjectiles: ItemAttributeNamed<Boolean> = ItemAttributeNamed("attack projectiles")
	
		/**
		 * In-Game: "Creates a ring of flames while spun up"
		 */
		val ringOfFireWhileAiming: ItemAttributeNamed<Int> = ItemAttributeNamed("ring of fire while aiming")
	
		/**
		 * In-Game: "Consumes an additional N ammo per second while spun up"
		 * 
		 * Amount of ammo drained per second.
		 */
		val spinupAmmoDrain: ItemAttributeNamed<Int> = ItemAttributeNamed("uses ammo while aiming")
	}

	/**
	 * In-Game: "Silent Killer: No barrel spin sound"
	 */
	val silentBarrel: ItemAttributeNamed<Boolean> get() = MinigunAttributes.silentBarrel
	
	val minigunSpinupTime: BonusPenalty<Float> get() = MinigunAttributes.minigunSpinupTime
	
	/**
	 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
	 * 
	 * Overridden by "raid gamemode" to 1.
	 */
	val attackProjectiles: ItemAttributeNamed<Boolean> get() = MinigunAttributes.attackProjectiles
	
	/**
	 * In-Game: "Creates a ring of flames while spun up"
	 */
	val ringOfFireWhileAiming: ItemAttributeNamed<Int> get() = MinigunAttributes.ringOfFireWhileAiming
	
	/**
	 * In-Game: "Consumes an additional N ammo per second while spun up"
	 * 
	 * Amount of ammo drained per second.
	 */
	val spinupAmmoDrain: ItemAttributeNamed<Int> get() = MinigunAttributes.spinupAmmoDrain
}