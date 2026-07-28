package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Grenade Launcher + Reskins, The Loch-n-Load, The Iron Bomber, The Loose Cannon
 */
interface GrenadeLauncherAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "N% damage on grenades that explode on timer"
		 *
		 * 
		 *
		 * Flat multiplier applied to initial damage.
		 */
		val grenadeDetonationDamagePenalty = ItemAttributeNamed<Float>("grenade detonation damage penalty")
		
		/**
		 * Bonus:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "+N% projectile speed"
		 *
		 * 	- Hidden:
		 *
		 * 		- In-Game: "+N% projectile speed"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% projectile speed"
		 *
		 * 
		 */
		val projectileSpeed = BonusPenalty(
			VisHidden("ItemAttributeNamed<Float>("Projectile speed increased")", "ItemAttributeNamed<Float>("Projectile speed increased HIDDEN")"),
			ItemAttributeNamed<Float>("Projectile speed decreased")
		)
		
		/**
		 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
		 *
		 * 
		 */
		val grenadeLauncherMortarMode = ItemAttributeNamed<Float>("grenade launcher mortar mode")
	}

	/**
	 * In-Game: "N% damage on grenades that explode on timer"
	 *
	 * 
	 *
	 * Flat multiplier applied to initial damage.
	 */
	val grenadeDetonationDamagePenalty: ItemAttribute<Float> get() = GrenadeLauncherAttributes.grenadeDetonationDamagePenalty
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% projectile speed"
	 *
	 * 
	 */
	val projectileSpeed: ItemAttribute<Float> get() = GrenadeLauncherAttributes.projectileSpeed
	
	/**
	 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
	 *
	 * 
	 */
	val grenadeLauncherMortarMode: ItemAttribute<Float> get() = GrenadeLauncherAttributes.grenadeLauncherMortarMode

   
}

