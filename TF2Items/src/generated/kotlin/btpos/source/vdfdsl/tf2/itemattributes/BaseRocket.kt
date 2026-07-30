package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface BaseRocketAttributes : BaseProjectileAttributes {
	companion object {
		/**
		 * Uses the "mini rockets" model.
		 */
		val miniRockets: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mini rockets")
	
		/**
		 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
		 * 
		 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%.
		 */
		val rocketjumpAttackrateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("rocketjump attackrate bonus")
	
		val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("Projectile speed increased"),
			ItemAttributeNamed<Float>("Projectile speed decreased"),
			ItemAttributeNamed<Float>("Projectile speed increased HIDDEN"),
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
		val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Int> = ItemAttributeNamed("SPELL: Halloween pumpkin explosions")
	
		/**
		 * Use the big MvM particle when it explodes.
		 */
		val useLargeSmokeExplosion: ItemAttributeNamed<Int> = ItemAttributeNamed("use large smoke explosion")
	
		val blastRadius: BonusPenalty<Float> = BonusPenalty(
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
	 * 
	 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%.
	 */
	val rocketjumpAttackrateBonus: ItemAttributeNamed<Float> get() = BaseRocketAttributes.rocketjumpAttackrateBonus
	
	val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> get() = BaseRocketAttributes.projectileSpeed
	
	/**
	 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
	 */
	val rocketSpecialist: ItemAttributeNamed<Int> get() = BaseRocketAttributes.rocketSpecialist
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Does pumpkin bombs particle effect.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Int> get() = BaseRocketAttributes.spellHalloweenPumpkinExplosions
	
	/**
	 * Use the big MvM particle when it explodes.
	 */
	val useLargeSmokeExplosion: ItemAttributeNamed<Int> get() = BaseRocketAttributes.useLargeSmokeExplosion
	
	val blastRadius: BonusPenalty<Float> get() = BaseRocketAttributes.blastRadius
}