package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseRocketAttributes : IBlockScoped, BaseProjectileAttributes {
	companion object : IBlockScoped {
		/**
		 * Uses the "mini rockets" model.
		 */
		val miniRockets: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mini rockets")
	
		/**
		 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
		 */
		val rocketjumpAttackrateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("rocketjump attackrate bonus")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% projectile speed"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% projectile speed"
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "+N% projectile speed"
		 */
		val multProjectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
		    ItemAttributeNamed<Number>("Projectile speed increased"),
		    ItemAttributeNamed<Number>("Projectile speed decreased"),
		    ItemAttributeNamed<Number>("Projectile speed increased HIDDEN"),
		)
	
		/**
		 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
		 */
		val rocketSpecialist: ItemAttributeNamed<Int> = ItemAttributeNamed("rocket specialist")
	
		/**
		 * In-Game: "Pumpkin Bombs"
		 * 
		 * Does pumpkin bombs particle effect.
		 */
		val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween pumpkin explosions")
	
		/**
		 * Use the big MvM particle when it explodes.
		 */
		val useLargeSmokeExplosion: ItemAttributeNamed<Int> = ItemAttributeNamed("use large smoke explosion")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% explosion radius"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% explosion radius"
		 */
		val multExplosionRadius: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("Blast radius increased"),
		    ItemAttributeNamed("Blast radius decreased"),
		)
	}
	
	/**
	 * Uses the "mini rockets" model.
	 */
	val miniRockets: ItemAttributeNamed<Boolean> get() = BaseRocketAttributes.miniRockets
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 */
	val rocketjumpAttackrateBonus: ItemAttributeNamed<Number> get() = BaseRocketAttributes.rocketjumpAttackrateBonus
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% projectile speed"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% projectile speed"
	 * 
	 * Hidden:
	 * 
	 * 	- In-Game: "+N% projectile speed"
	 */
	val multProjectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> get() = BaseRocketAttributes.multProjectileSpeed
	
	/**
	 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
	 */
	val rocketSpecialist: ItemAttributeNamed<Int> get() = BaseRocketAttributes.rocketSpecialist
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Does pumpkin bombs particle effect.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = BaseRocketAttributes.spellHalloweenPumpkinExplosions
	
	/**
	 * Use the big MvM particle when it explodes.
	 */
	val useLargeSmokeExplosion: ItemAttributeNamed<Int> get() = BaseRocketAttributes.useLargeSmokeExplosion
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% explosion radius"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% explosion radius"
	 */
	val multExplosionRadius: BonusPenalty<Number> get() = BaseRocketAttributes.multExplosionRadius
	
	object Inherited : BaseRocketAttributes 
}