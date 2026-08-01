package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseRocketAttributes : BaseProjectileAttributes {
	companion object : IBlockScoped 

	/**
	 * Uses the "mini rockets" model.
	 */
	val miniRockets: ItemAttributeNamed<Boolean> get() = BaseRocketAttributes.miniRockets.get()
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 */
	val rocketjumpAttackrateBonus: ItemAttributeNamed<Number> get() = BaseRocketAttributes.rocketjumpAttackrateBonus.get()
	
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
	val projectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> get() = BaseRocketAttributes.projectileSpeed.get()
	
	/**
	 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
	 */
	val rocketSpecialist: ItemAttributeNamed<Int> get() = BaseRocketAttributes.rocketSpecialist.get()
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Does pumpkin bombs particle effect.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = BaseRocketAttributes.spellHalloweenPumpkinExplosions.get()
	
	/**
	 * Use the big MvM particle when it explodes.
	 */
	val useLargeSmokeExplosion: ItemAttributeNamed<Int> get() = BaseRocketAttributes.useLargeSmokeExplosion.get()
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% explosion radius"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% explosion radius"
	 */
	val blastRadius: BonusPenalty<Number> get() = BaseRocketAttributes.blastRadius.get()
}