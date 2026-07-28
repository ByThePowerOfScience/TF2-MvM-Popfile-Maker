package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BaseRocketAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * Uses the "mini rockets" model.
		 */
		val miniRockets = ItemAttributeNamed<Boolean>("mini rockets")
		
		/**
		 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
		 *
		 * 
		 *
		 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%.
		 */
		val rocketjumpAttackrateBonus = ItemAttributeNamed<Float>("rocketjump attackrate bonus")
		
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
		 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
		 *
		 * 
		 */
		val rocketSpecialist = ItemAttributeNamed<Int>("rocket specialist")
		
		/**
		 * In-Game: "Pumpkin Bombs"
		 *
		 * 
		 *
		 * Does pumpkin bombs particle effect.
		 */
		val spellHalloweenPumpkinExplosions = ItemAttributeNamed<Int>("SPELL: Halloween pumpkin explosions")
		
		/**
		 * 
		 *
		 * Use the big MvM particle when it explodes.
		 */
		val useLargeSmokeExplosion = ItemAttributeNamed<Int>("use large smoke explosion")
		
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
		 */
		val blastRadius = BonusPenalty(
			ItemAttributeNamed<Float>("Blast radius increased"),
			ItemAttributeNamed<Float>("Blast radius decreased")
		)
	}

	/**
	 * 
	 *
	 * Uses the "mini rockets" model.
	 */
	val miniRockets: ItemAttribute<Boolean> get() = BaseRocketAttributes.miniRockets
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 *
	 * 
	 *
	 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%.
	 */
	val rocketjumpAttackrateBonus: ItemAttribute<Float> get() = BaseRocketAttributes.rocketjumpAttackrateBonus
	
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
	val projectileSpeed: ItemAttribute<Float> get() = BaseRocketAttributes.projectileSpeed
	
	/**
	 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
	 *
	 * 
	 */
	val rocketSpecialist: ItemAttribute<Int> get() = BaseRocketAttributes.rocketSpecialist
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 *
	 * Does pumpkin bombs particle effect.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttribute<Int> get() = BaseRocketAttributes.spellHalloweenPumpkinExplosions
	
	/**
	 * 
	 *
	 * Use the big MvM particle when it explodes.
	 */
	val useLargeSmokeExplosion: ItemAttribute<Int> get() = BaseRocketAttributes.useLargeSmokeExplosion
	
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
	 */
	val blastRadius: ItemAttribute<Float> get() = BaseRocketAttributes.blastRadius

   
}

