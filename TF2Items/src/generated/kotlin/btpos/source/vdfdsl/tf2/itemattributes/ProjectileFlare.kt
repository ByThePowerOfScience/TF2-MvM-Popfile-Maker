package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Flare Gun, The Detonator, The Manmelter, The Scorch Shot
 */
interface ProjectileFlareAttributes : IBlockScoped {
	companion object {
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
		 *
		 * Checked on launcher.
		 */
		val projectileSpeed = BonusPenalty(
			VisHidden("ItemAttributeNamed<Float>("Projectile speed increased")", "ItemAttributeNamed<Float>("Projectile speed increased HIDDEN")"),
			ItemAttributeNamed<Float>("Projectile speed decreased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% explosion radius"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% explosion radius"
		 *
		 * 
		 *
		 * Checked on launcher.
		 */
		val blastRadius = BonusPenalty(
			ItemAttributeNamed<Float>("Blast radius increased"),
			ItemAttributeNamed<Float>("Blast radius decreased")
		)
	}

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
	 *
	 * Checked on launcher.
	 */
	val projectileSpeed: ItemAttribute<Float> get() = ProjectileFlareAttributes.projectileSpeed
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% explosion radius"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% explosion radius"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val blastRadius: ItemAttribute<Float> get() = ProjectileFlareAttributes.blastRadius

   
}

