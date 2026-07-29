package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ProjectileStickybombAttributes : IBlockScoped {
	
	companion object {
		/**
		 * In-Game: "Stickybombs fizzle N seconds after landing"
		 * 
		 * Checked on launcher.
		 */
		val stickybombFizzleTime: ItemAttributeNamed<Float> = ItemAttributeNamed("stickybomb fizzle time")
	
		/**
		 * In-Game: "Grenades have very little bounce and roll"
		 * 
		 * Checked on launcher.
		 */
		val grenadeNoBounce: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenade no bounce")
	
		val stickyArmTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("sticky arm time bonus"),
			ItemAttributeNamed("sticky arm time penalty"),
		)
	
		/**
		 * In-Game: "N% damage on contact with surfaces"
		 * 
		 * Checked on launcher.
		 */
		val grenadeDamageReductionOnWorldContact: ItemAttributeNamed<Float> = ItemAttributeNamed("grenade damage reduction on world contact")
	}

	/**
	 * In-Game: "Stickybombs fizzle N seconds after landing"
	 * 
	 * Checked on launcher.
	 */
	val stickybombFizzleTime: ItemAttributeNamed<Float> get() = ProjectileStickybombAttributes.stickybombFizzleTime
	
	/**
	 * In-Game: "Grenades have very little bounce and roll"
	 * 
	 * Checked on launcher.
	 */
	val grenadeNoBounce: ItemAttributeNamed<Boolean> get() = ProjectileStickybombAttributes.grenadeNoBounce
	
	val stickyArmTime: BonusPenalty<Float> get() = ProjectileStickybombAttributes.stickyArmTime
	
	/**
	 * In-Game: "N% damage on contact with surfaces"
	 * 
	 * Checked on launcher.
	 */
	val grenadeDamageReductionOnWorldContact: ItemAttributeNamed<Float> get() = ProjectileStickybombAttributes.grenadeDamageReductionOnWorldContact
}