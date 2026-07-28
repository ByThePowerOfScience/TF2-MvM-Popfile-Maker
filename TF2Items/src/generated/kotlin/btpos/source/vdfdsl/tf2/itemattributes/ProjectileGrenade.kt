package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Grenade Launcher, The Iron Bomber, The Loose Cannon
 */
interface ProjectileGrenadeAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * Checked on launcher.
		 */
		val useLargeSmokeExplosion = ItemAttributeNamed<Boolean>("use large smoke explosion")
		
		/**
		 * In-Game: "Pumpkin Bombs"
		 *
		 * 
		 *
		 * Checked on launcher.
		 */
		val spellHalloweenPumpkinExplosions = ItemAttributeNamed<Boolean>("SPELL: Halloween pumpkin explosions")
		
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
		
		/**
		 * In-Game: "N% fuse time on grenades"
		 *
		 * 
		 *
		 * Checked on owner.
		 */
		val fuseBonus = ItemAttributeNamed<Float>("fuse bonus")
	}

	/**
	 * 
	 *
	 * Checked on launcher.
	 */
	val useLargeSmokeExplosion: ItemAttribute<Boolean> get() = ProjectileGrenadeAttributes.useLargeSmokeExplosion
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttribute<Boolean> get() = ProjectileGrenadeAttributes.spellHalloweenPumpkinExplosions
	
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
	val blastRadius: ItemAttribute<Float> get() = ProjectileGrenadeAttributes.blastRadius
	
	/**
	 * In-Game: "N% fuse time on grenades"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val fuseBonus: ItemAttribute<Float> get() = ProjectileGrenadeAttributes.fuseBonus

   
}

