package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Sniper Rifle + Reskins, The Sydney Sleeper, The Machina, The Hitman's Heatmaker, Shooting Star, The Bazaar Bargain, The Classic
 */
interface SniperRifleAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "No headshots"
		 *
		 * 
		 *
		 * 0: Normal.
		 *
		 * 1: Sydney Sleeper.
		 *
		 * 2: Machina.
		 *
		 * 3: Classic.
		 */
		val cannotHeadshot = ItemAttributeNamed<Boolean>("sniper no headshots", NumberSelectorCodec(1))
		
		/**
		 * 
		 *
		 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
		 */
		val soldierBuffType = ItemAttributeNamed<Int>("mod soldier buff type")
		
		/**
		 * 
		 *
		 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
		 */
		val demoBuffType = ItemAttributeNamed<Int>("mod demo buff type")
		
		/**
		 * In-Game: "On Full Charge: +N% damage per shot"
		 *
		 * 
		 *
		 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
		 */
		val fullChargeDamageBonus = ItemAttributeNamed<Float>("sniper full charge damage bonus")
		
		/**
		 * In-Game: "+N% faster reload time"
		 *
		 * 
		 *
		 * Mult to zoom and unzoom delay on clipless weapons.
		 *
		 * Fun fact: this is also affected by the Precision mannpower powerup.
		 */
		val fasterReloadRate = ItemAttributeNamed<Float>("faster reload rate")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% charge rate"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% slower power charge"
		 *
		 * 
		 */
		val srifleChargeRate = BonusPenalty(
			ItemAttributeNamed<Float>("sniper charge per sec"),
			ItemAttributeNamed<Float>("SRifle Charge rate decreased")
		)
		
		/**
		 * In-Game: "Cannot fire unless zoomed"
		 *
		 * 
		 */
		val canOnlyFireWhenZoomed = ItemAttributeNamed<Boolean>("sniper only fire zoomed")
		
		/**
		 * In-Game: "On Full Charge: Projectiles penetrate players"
		 *
		 * 
		 */
		val penetratesWhenFullyCharged = ItemAttributeNamed<Boolean>("sniper penetrate players when charged")
		
		/**
		 * In-Game: "No headshots when not fully charged"
		 *
		 * 
		 */
		val cannotHeadshotWithoutFullCharge = ItemAttributeNamed<Boolean>("sniper no headshot without full charge")
		
		/**
		 * In-Game: "Charge and fire shots independent of zoom"
		 *
		 * 
		 *
		 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
		 */
		val canHeadshotUnscoped = ItemAttributeNamed<Boolean>("sniper crit no scope")
		
		/**
		 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
		 *
		 * 
		 *
		 * Level of explosive headshot.
		 *
		 * Checked on attacker.
		 */
		val explosiveHeadshotLevel = ItemAttributeNamed<Int>("explosive sniper shot")
		
		/**
		 * In-Game: "On Scoped Hit: Apply Jarate for 2 to N seconds based on charge level. Nature's Call: Scoped headshots always mini-crits and reduce the remaining cooldown of Jarate by 1 second."
		 *
		 * 
		 *
		 * If greater than 0:.
		 *
		 * Makes weapon not eject brass.
		 *
		 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates.
		 *
		 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
		 */
		val jarateDuration = ItemAttributeNamed<Float>("jarate duration")
		
		/**
		 * In-Game: "N% movement speed on targets"
		 *
		 * 
		 *
		 * Multiplier applied to target move-speed on hit.
		 *
		 * Duration is equal to the rifle's `jarate_duration` attribute.
		 */
		val appliesSnareEffect = ItemAttributeNamed<Float>("applies snare effect")
		
		/**
		 * In-Game: "No flinching when aiming and fully charged"
		 *
		 * 
		 *
		 * Prevents flinching from damage when scoped and fully charged.
		 */
		val aimingNoFlinch = ItemAttributeNamed<Boolean>("aiming no flinch")
	}

	/**
	 * In-Game: "No headshots"
	 *
	 * 
	 *
	 * 0: Normal.
	 *
	 * 1: Sydney Sleeper.
	 *
	 * 2: Machina.
	 *
	 * 3: Classic.
	 */
	val cannotHeadshot: ItemAttribute<Boolean> get() = SniperRifleAttributes.cannotHeadshot
	
	/**
	 * 
	 *
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	val soldierBuffType: ItemAttribute<Int> get() = SniperRifleAttributes.soldierBuffType
	
	/**
	 * 
	 *
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	val demoBuffType: ItemAttribute<Int> get() = SniperRifleAttributes.demoBuffType
	
	/**
	 * In-Game: "On Full Charge: +N% damage per shot"
	 *
	 * 
	 *
	 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
	 */
	val fullChargeDamageBonus: ItemAttribute<Float> get() = SniperRifleAttributes.fullChargeDamageBonus
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * Mult to zoom and unzoom delay on clipless weapons.
	 *
	 * Fun fact: this is also affected by the Precision mannpower powerup.
	 */
	val fasterReloadRate: ItemAttribute<Float> get() = SniperRifleAttributes.fasterReloadRate
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% charge rate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower power charge"
	 *
	 * 
	 */
	val srifleChargeRate: ItemAttribute<Float> get() = SniperRifleAttributes.srifleChargeRate
	
	/**
	 * In-Game: "Cannot fire unless zoomed"
	 *
	 * 
	 */
	val canOnlyFireWhenZoomed: ItemAttribute<Boolean> get() = SniperRifleAttributes.canOnlyFireWhenZoomed
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 *
	 * 
	 */
	val penetratesWhenFullyCharged: ItemAttribute<Boolean> get() = SniperRifleAttributes.penetratesWhenFullyCharged
	
	/**
	 * In-Game: "No headshots when not fully charged"
	 *
	 * 
	 */
	val cannotHeadshotWithoutFullCharge: ItemAttribute<Boolean> get() = SniperRifleAttributes.cannotHeadshotWithoutFullCharge
	
	/**
	 * In-Game: "Charge and fire shots independent of zoom"
	 *
	 * 
	 *
	 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
	 */
	val canHeadshotUnscoped: ItemAttribute<Boolean> get() = SniperRifleAttributes.canHeadshotUnscoped
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 *
	 * 
	 *
	 * Level of explosive headshot.
	 *
	 * Checked on attacker.
	 */
	val explosiveHeadshotLevel: ItemAttribute<Int> get() = SniperRifleAttributes.explosiveHeadshotLevel
	
	/**
	 * In-Game: "On Scoped Hit: Apply Jarate for 2 to N seconds based on charge level. Nature's Call: Scoped headshots always mini-crits and reduce the remaining cooldown of Jarate by 1 second."
	 *
	 * 
	 *
	 * If greater than 0:.
	 *
	 * Makes weapon not eject brass.
	 *
	 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates.
	 *
	 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
	 */
	val jarateDuration: ItemAttribute<Float> get() = SniperRifleAttributes.jarateDuration
	
	/**
	 * In-Game: "N% movement speed on targets"
	 *
	 * 
	 *
	 * Multiplier applied to target move-speed on hit.
	 *
	 * Duration is equal to the rifle's `jarate_duration` attribute.
	 */
	val appliesSnareEffect: ItemAttribute<Float> get() = SniperRifleAttributes.appliesSnareEffect
	
	/**
	 * In-Game: "No flinching when aiming and fully charged"
	 *
	 * 
	 *
	 * Prevents flinching from damage when scoped and fully charged.
	 */
	val aimingNoFlinch: ItemAttribute<Boolean> get() = SniperRifleAttributes.aimingNoFlinch

   
}

