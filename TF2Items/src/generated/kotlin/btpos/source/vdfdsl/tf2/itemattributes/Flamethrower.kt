package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Flamethrower + Reskins, The Backburner, The Degreaser, The Phlogistinator, The Rainblower, The Dragon's Fury
 */
interface FlamethrowerAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 *
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		val soldierBuffType = ItemAttributeNamed<Int>("mod soldier buff type")
		
		/**
		 * 
		 *
		 * If greater than 0, enables Phlog crits on having full rage.
		 */
		val demoBuffType = ItemAttributeNamed<Int>("mod demo buff type")
		
		/**
		 * In-Game: "No airblast"
		 *
		 * 
		 */
		val airblastDisabled = ItemAttributeNamed<Boolean>("airblast disabled")
		
		/**
		 * In-Game: "Airblast can now be charged, which will push enemies further"
		 *
		 * 
		 *
		 * Enables charging an airblast for longer for higher push.
		 *
		 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast.
		 */
		val chargedAirblast = ItemAttributeNamed<Boolean>("charged airblast")
		
		/**
		 * 
		 */
		val airblastCost = AirblastCostAttributes()
		
		/**
		 * In-Game: "100% critical hits from behind"
		 *
		 * 
		 */
		val flamethrowerBackCrit = ItemAttributeNamed<Boolean>("mod flamethrower back crit")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% flamethrower ammo consumed per second"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "+N% flamethrower ammo consumed per second"
		 *
		 * 
		 */
		val flameAmmopersec = BonusPenalty(
			ItemAttributeNamed<Float>("flame ammopersec decreased"),
			ItemAttributeNamed<Float>("flame ammopersec increased")
		)
		
		/**
		 * 
		 *
		 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
		 *
		 * Secondary attack delay = 0.75 * this.
		 */
		val multAirblastRefireTime = ItemAttributeNamed<Float>("mult airblast refire time")
		
		/**
		 * 
		 *
		 * Scales the reflect hitbox for your airblast.
		 */
		val deflectionSizeMultiplier = ItemAttributeNamed<Float>("deflection size multiplier")
		
		/**
		 * In-Game: "Extinguishing teammates restores N health"
		 *
		 * 
		 *
		 * How much health your extinguish restores.
		 */
		val extinguishRestoresHealth = ItemAttributeNamed<Int>("extinguish restores health")
		
		/**
		 * In-Game: "+N% airblast push force"
		 *
		 * 
		 */
		val airblastPushbackScale = ItemAttributeNamed<Float>("airblast pushback scale")
		
		/**
		 * 
		 */
		val airblastVerticalPushbackScale = ItemAttributeNamed<Float>("airblast vertical pushback scale")
		
		/**
		 * In-Game: "Halloween Fire"
		 *
		 * 
		 */
		val spellHalloweenGreenFlames = ItemAttributeNamed<Boolean>("SPELL: Halloween green flames")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% more flame spread area"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% less flame spread area"
		 *
		 * 
		 *
		 * Checked on owner.
		 */
		val flameSize = BonusPenalty(
			ItemAttributeNamed<Float>("flame size bonus"),
			ItemAttributeNamed<Float>("flame size penalty")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% more flame distance"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% less flame distance"
		 *
		 * 
		 *
		 * Checked on owner.
		 */
		val flameLife = BonusPenalty(
			ItemAttributeNamed<Float>("flame life bonus"),
			ItemAttributeNamed<Float>("flame life penalty")
		)
		
		/**
		 * 
		 */
		val airblastDestroyProjectile = ItemAttributeNamed<Boolean>("airblast_destroy_projectile")
		
		/**
		 * 
		 */
		val airblastPushbackDisabled = ItemAttributeNamed<Boolean>("airblast_pushback_disabled")
		
		/**
		 * 
		 */
		val flames = FlamesAttributes()
	}

	/**
	 * 
	 *
	 * If greater than 0, enables Phlog crits on having full rage.
	 */
	val soldierBuffType: ItemAttribute<Int> get() = FlamethrowerAttributes.soldierBuffType
	
	/**
	 * 
	 *
	 * If greater than 0, enables Phlog crits on having full rage.
	 */
	val demoBuffType: ItemAttribute<Int> get() = FlamethrowerAttributes.demoBuffType
	
	/**
	 * In-Game: "No airblast"
	 *
	 * 
	 */
	val airblastDisabled: ItemAttribute<Boolean> get() = FlamethrowerAttributes.airblastDisabled
	
	/**
	 * In-Game: "Airblast can now be charged, which will push enemies further"
	 *
	 * 
	 *
	 * Enables charging an airblast for longer for higher push.
	 *
	 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast.
	 */
	val chargedAirblast: ItemAttribute<Boolean> get() = FlamethrowerAttributes.chargedAirblast
	
	/**
	 * 
	 */
	val airblastCost: ItemAttribute<AirblastCost> get() = FlamethrowerAttributes.airblastCost
	
	/**
	 * In-Game: "100% critical hits from behind"
	 *
	 * 
	 */
	val flamethrowerBackCrit: ItemAttribute<Boolean> get() = FlamethrowerAttributes.flamethrowerBackCrit
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% flamethrower ammo consumed per second"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "+N% flamethrower ammo consumed per second"
	 *
	 * 
	 */
	val flameAmmopersec: ItemAttribute<Float> get() = FlamethrowerAttributes.flameAmmopersec
	
	/**
	 * 
	 *
	 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack.
	 *
	 * Secondary attack delay = 0.75 * this.
	 */
	val multAirblastRefireTime: ItemAttribute<Float> get() = FlamethrowerAttributes.multAirblastRefireTime
	
	/**
	 * 
	 *
	 * Scales the reflect hitbox for your airblast.
	 */
	val deflectionSizeMultiplier: ItemAttribute<Float> get() = FlamethrowerAttributes.deflectionSizeMultiplier
	
	/**
	 * In-Game: "Extinguishing teammates restores N health"
	 *
	 * 
	 *
	 * How much health your extinguish restores.
	 */
	val extinguishRestoresHealth: ItemAttribute<Int> get() = FlamethrowerAttributes.extinguishRestoresHealth
	
	/**
	 * In-Game: "+N% airblast push force"
	 *
	 * 
	 */
	val airblastPushbackScale: ItemAttribute<Float> get() = FlamethrowerAttributes.airblastPushbackScale
	
	/**
	 * 
	 */
	val airblastVerticalPushbackScale: ItemAttribute<Float> get() = FlamethrowerAttributes.airblastVerticalPushbackScale
	
	/**
	 * In-Game: "Halloween Fire"
	 *
	 * 
	 */
	val spellHalloweenGreenFlames: ItemAttribute<Boolean> get() = FlamethrowerAttributes.spellHalloweenGreenFlames
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% more flame spread area"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less flame spread area"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val flameSize: ItemAttribute<Float> get() = FlamethrowerAttributes.flameSize
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% more flame distance"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less flame distance"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val flameLife: ItemAttribute<Float> get() = FlamethrowerAttributes.flameLife
	
	/**
	 * 
	 */
	val airblastDestroyProjectile: ItemAttribute<Boolean> get() = FlamethrowerAttributes.airblastDestroyProjectile
	
	/**
	 * 
	 */
	val airblastPushbackDisabled: ItemAttribute<Boolean> get() = FlamethrowerAttributes.airblastPushbackDisabled
	
	/**
	 * 
	 */
	val flames: ItemAttribute<Flames> get() = FlamethrowerAttributes.flames

   
open class AirblastCostAttributes : IBlockScoped {
	/**
	 * In-Game: "+N% airblast cost"
	 */
	open val airblastCostIncreased = ItemAttributeNamed<Float>("airblast cost increased")
	
	/**
	 * In-Game: "N% airblast cost"
	 */
	open val airblastCostDecreased = ItemAttributeNamed<Float>("airblast cost decreased")
	
	
	open val airblastCostScaleHidden = ItemAttributeNamed<Float>("airblast cost scale hidden")

	
}

	
open class FlamesAttributes : IBlockScoped {
	
	open val flameSpreadDegree = ItemAttributeNamed<Float>("flame_spread_degree")
	
	
	open val redirectedFlameSizeMult = ItemAttributeNamed<Float>("redirected_flame_size_mult")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% more flame spread area"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less flame spread area"
	 */
	open val flameSize = BonusPenalty(
		ItemAttributeNamed<Float>("flame size bonus"),
		ItemAttributeNamed<Float>("flame size penalty")
	)
	
	
	open val multEndFlameSize = ItemAttributeNamed<Float>("mult_end_flame_size")
	
	
	open val flameIgnorePlayerVelocity = ItemAttributeNamed<Float>("flame_ignore_player_velocity")
	
	
	open val flameReflectionAddLifeTime = ItemAttributeNamed<Float>("flame_reflection_add_life_time")
	
	
	open val reflectedFlameDmgReduction = ItemAttributeNamed<Float>("reflected_flame_dmg_reduction")
	
	
	open val maxFlameReflectionCount = ItemAttributeNamed<Int>("max_flame_reflection_count")
	
	
	open val flameReflectOnCollision = ItemAttributeNamed<Boolean>("flame_reflect_on_collision")
	
	
	open val flameSpeed = ItemAttributeNamed<Float>("flame_speed")
	
	
	open val flameLifetime = ItemAttributeNamed<Float>("flame_lifetime")
	
	
	open val flameRandomLifeTimeOffset = ItemAttributeNamed<Float>("flame_random_life_time_offset")
	
	
	open val flameGravity = ItemAttributeNamed<Float>("flame_gravity")
	
	
	open val flameDrag = ItemAttributeNamed<Float>("flame_drag")
	
	
	open val flameUpSpeed = ItemAttributeNamed<Float>("flame_up_speed")

	
}
}

