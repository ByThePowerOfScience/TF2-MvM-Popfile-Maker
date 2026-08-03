package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ProjectileStickybombAttributes : IBlockScoped, BaseGrenadeProjectileAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Stickybombs fizzle N seconds after landing"
		 * 
		 * Checked on launcher.
		 */
		val stickybombFizzleTime: ItemAttributeNamed<Number> = ItemAttributeNamed("stickybomb fizzle time")
	
		/**
		 * In-Game: "Grenades have very little bounce and roll"
		 * 
		 * Checked on launcher.
		 */
		val grenadeNoBounce: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenade no bounce")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N sec faster bomb arm time"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N sec slower bomb arm time"
		 */
		val stickyArmTime: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("sticky arm time bonus"),
			ItemAttributeNamed("sticky arm time penalty"),
		)
	
		/**
		 * In-Game: "N% damage on contact with surfaces"
		 * 
		 * Checked on launcher.
		 */
		val grenadeDamageReductionOnWorldContact: ItemAttributeNamed<Number> = ItemAttributeNamed("grenade damage reduction on world contact")
	}

	/**
	 * In-Game: "Stickybombs fizzle N seconds after landing"
	 * 
	 * Checked on launcher.
	 */
	val stickybombFizzleTime: ItemAttributeNamed<Number> get() = ProjectileStickybombAttributes.stickybombFizzleTime
	
	/**
	 * In-Game: "Grenades have very little bounce and roll"
	 * 
	 * Checked on launcher.
	 */
	val grenadeNoBounce: ItemAttributeNamed<Boolean> get() = ProjectileStickybombAttributes.grenadeNoBounce
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "N sec faster bomb arm time"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N sec slower bomb arm time"
	 */
	val stickyArmTime: BonusPenalty<Number> get() = ProjectileStickybombAttributes.stickyArmTime
	
	/**
	 * In-Game: "N% damage on contact with surfaces"
	 * 
	 * Checked on launcher.
	 */
	val grenadeDamageReductionOnWorldContact: ItemAttributeNamed<Number> get() = ProjectileStickybombAttributes.grenadeDamageReductionOnWorldContact
}