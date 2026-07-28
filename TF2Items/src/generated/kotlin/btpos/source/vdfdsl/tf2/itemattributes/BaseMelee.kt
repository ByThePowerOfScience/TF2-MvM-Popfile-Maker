package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Frying Pan, Saxxy, The Conscientious Objector, The Freedom Staff, The Bat Outta Hell, Memory Maker, The Ham Shank, Gold Frying Pan, Necro Smasher, The Crossing Guard, Powerup Strength, Powerup Haste, Powerup Regen, Powerup Resist, Powerup Vampire, Powerup Reflect, Powerup Precision, Powerup Agility, Powerup Knockout, Powerup King, Powerup Plague, Powerup Supernova, Prinny Machete, The Hot Hand, Kukri, The Tribalman's Shiv, The Bushwacka, The Shahanshah
 */
interface BaseMeleeAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
		 *
		 * 
		 *
		 * Marked for death when switching to weapon.
		 */
		val selfMarkForDeath = ItemAttributeNamed<Boolean>("self mark for death")
		
		/**
		 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
		 *
		 * 
		 *
		 * If 1, set swing range to 72, else 48.
		 */
		val isASword = ItemAttributeNamed<Boolean>("is_a_sword")
		
		/**
		 * 
		 *
		 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
		 *
		 * Yes, it DOES use a bounding box. I think. That's what this implies, I guess.
		 */
		val meleeBoundsMultiplier = ItemAttributeNamed<Float>("melee bounds multiplier")
		
		/**
		 * In-Game: "Damage removes Sappers"
		 *
		 * 
		 *
		 * Damage sappers with swing.
		 */
		val damageAppliesToSappers = ItemAttributeNamed<Int>("damage applies to sappers")
		
		/**
		 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
		 *
		 * 
		 *
		 * Applies speed boost cond to yourself and the teammate you hit.
		 */
		val speedBuffAlly = ItemAttributeNamed<Boolean>("speed buff ally")
		
		/**
		 * In-Game: "On Miss: Hit yourself. Idiot."
		 *
		 * 
		 *
		 * Idiot.
		 */
		val hitSelfOnMiss = ItemAttributeNamed<Boolean>("hit self on miss")
		
		/**
		 * In-Game: "Gain a speed boost when you hit an enemy player"
		 *
		 * 
		 *
		 * Used as arg to addcond speedboost.
		 */
		val speedBoostOnHitEnemy = ItemAttributeNamed<Float>("speed_boost_on_hit_enemy")
		
		/**
		 * In-Game: "Always critical hit from behind"
		 *
		 * 
		 */
		val critFromBehind = ItemAttributeNamed<Boolean>("crit from behind")
		
		/**
		 * In-Game: "Critical hit forces victim to laugh"
		 *
		 * 
		 */
		val critForcesVictimToLaugh = ItemAttributeNamed<Boolean>("crit forces victim to laugh")
		
		/**
		 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
		 *
		 * 
		 *
		 * Force enemies to laugh if they're also wielding this weapon.
		 */
		val tickleEnemiesWieldingSameWeapon = ItemAttributeNamed<Boolean>("tickle enemies wielding same weapon")
		
		/**
		 * In-Game: "Critical hits do no damage"
		 *
		 * 
		 */
		val critDoesNoDamage = ItemAttributeNamed<Boolean>("crit does no damage")
		
		/**
		 * In-Game: "N% increase in damage when health <50% of max"
		 *
		 * 
		 *
		 * If health < 50%, apply mult.
		 */
		val dmgBonusWhileHalfDead = ItemAttributeNamed<Float>("dmg bonus while half dead")
		
		/**
		 * In-Game: "N% decrease in damage when health >50% of max"
		 *
		 * 
		 *
		 * If health >= 50%, apply mult.
		 */
		val dmgPenaltyWhileHalfAlive = ItemAttributeNamed<Float>("dmg penalty while half alive")
	}

	/**
	 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
	 *
	 * 
	 *
	 * Marked for death when switching to weapon.
	 */
	val selfMarkForDeath: ItemAttribute<Boolean> get() = BaseMeleeAttributes.selfMarkForDeath
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 *
	 * 
	 *
	 * If 1, set swing range to 72, else 48.
	 */
	val isASword: ItemAttribute<Boolean> get() = BaseMeleeAttributes.isASword
	
	/**
	 * 
	 *
	 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
	 *
	 * Yes, it DOES use a bounding box. I think. That's what this implies, I guess.
	 */
	val meleeBoundsMultiplier: ItemAttribute<Float> get() = BaseMeleeAttributes.meleeBoundsMultiplier
	
	/**
	 * In-Game: "Damage removes Sappers"
	 *
	 * 
	 *
	 * Damage sappers with swing.
	 */
	val damageAppliesToSappers: ItemAttribute<Int> get() = BaseMeleeAttributes.damageAppliesToSappers
	
	/**
	 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
	 *
	 * 
	 *
	 * Applies speed boost cond to yourself and the teammate you hit.
	 */
	val speedBuffAlly: ItemAttribute<Boolean> get() = BaseMeleeAttributes.speedBuffAlly
	
	/**
	 * In-Game: "On Miss: Hit yourself. Idiot."
	 *
	 * 
	 *
	 * Idiot.
	 */
	val hitSelfOnMiss: ItemAttribute<Boolean> get() = BaseMeleeAttributes.hitSelfOnMiss
	
	/**
	 * In-Game: "Gain a speed boost when you hit an enemy player"
	 *
	 * 
	 *
	 * Used as arg to addcond speedboost.
	 */
	val speedBoostOnHitEnemy: ItemAttribute<Float> get() = BaseMeleeAttributes.speedBoostOnHitEnemy
	
	/**
	 * In-Game: "Always critical hit from behind"
	 *
	 * 
	 */
	val critFromBehind: ItemAttribute<Boolean> get() = BaseMeleeAttributes.critFromBehind
	
	/**
	 * In-Game: "Critical hit forces victim to laugh"
	 *
	 * 
	 */
	val critForcesVictimToLaugh: ItemAttribute<Boolean> get() = BaseMeleeAttributes.critForcesVictimToLaugh
	
	/**
	 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
	 *
	 * 
	 *
	 * Force enemies to laugh if they're also wielding this weapon.
	 */
	val tickleEnemiesWieldingSameWeapon: ItemAttribute<Boolean> get() = BaseMeleeAttributes.tickleEnemiesWieldingSameWeapon
	
	/**
	 * In-Game: "Critical hits do no damage"
	 *
	 * 
	 */
	val critDoesNoDamage: ItemAttribute<Boolean> get() = BaseMeleeAttributes.critDoesNoDamage
	
	/**
	 * In-Game: "N% increase in damage when health <50% of max"
	 *
	 * 
	 *
	 * If health < 50%, apply mult.
	 */
	val dmgBonusWhileHalfDead: ItemAttribute<Float> get() = BaseMeleeAttributes.dmgBonusWhileHalfDead
	
	/**
	 * In-Game: "N% decrease in damage when health >50% of max"
	 *
	 * 
	 *
	 * If health >= 50%, apply mult.
	 */
	val dmgPenaltyWhileHalfAlive: ItemAttribute<Float> get() = BaseMeleeAttributes.dmgPenaltyWhileHalfAlive

   
}

