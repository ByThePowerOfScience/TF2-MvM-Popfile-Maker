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
		 * 
		 *
		 * Checked on launcher.
		 */
		val stickybombFizzleTime = ItemAttributeNamed<Float>("stickybomb fizzle time")
		
		/**
		 * In-Game: "Grenades have very little bounce and roll"
		 *
		 * 
		 *
		 * Checked on launcher.
		 */
		val grenadeNoBounce = ItemAttributeNamed<Boolean>("grenade no bounce")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N sec faster bomb arm time"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N sec slower bomb arm time"
		 *
		 * 
		 *
		 * Checked on launcher.
		 */
		val stickyArmTime = BonusPenalty(
			ItemAttributeNamed<Float>("sticky arm time bonus"),
			ItemAttributeNamed<Float>("sticky arm time penalty")
		)
		
		/**
		 * In-Game: "N% damage on contact with surfaces"
		 *
		 * 
		 *
		 * Checked on launcher.
		 */
		val grenadeDamageReductionOnWorldContact = ItemAttributeNamed<Float>("grenade damage reduction on world contact")
	}

	/**
	 * In-Game: "Stickybombs fizzle N seconds after landing"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val stickybombFizzleTime: ItemAttribute<Float> get() = ProjectileStickybombAttributes.stickybombFizzleTime
	
	/**
	 * In-Game: "Grenades have very little bounce and roll"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val grenadeNoBounce: ItemAttribute<Boolean> get() = ProjectileStickybombAttributes.grenadeNoBounce
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N sec faster bomb arm time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N sec slower bomb arm time"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val stickyArmTime: ItemAttribute<Float> get() = ProjectileStickybombAttributes.stickyArmTime
	
	/**
	 * In-Game: "N% damage on contact with surfaces"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val grenadeDamageReductionOnWorldContact: ItemAttribute<Float> get() = ProjectileStickybombAttributes.grenadeDamageReductionOnWorldContact

   
}

