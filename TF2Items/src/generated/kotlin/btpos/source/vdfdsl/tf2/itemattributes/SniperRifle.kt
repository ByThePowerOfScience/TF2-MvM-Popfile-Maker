package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface SniperRifleAttributes : BaseGunAttributes {
	companion object {
		/**
		 * In-Game: "No headshots"
		 * 
		 * 0: Normal.
		 * 
		 * 1: Sydney Sleeper.
		 * 
		 * 2: Machina.
		 * 
		 * 3: Classic.
		 */
		val cannotHeadshot: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper no headshots", NumberSelectorCodec(1))
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val sniperChargePerSec: SniperChargePerSecAttributes = SniperChargePerSecAttributes()
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * Mult to zoom and unzoom delay on clipless weapons.
		 * 
		 * Fun fact: this is also affected by the Precision mannpower powerup.
		 */
		val fasterReloadRate: ItemAttributeNamed<Float> = ItemAttributeNamed("faster reload rate")
	
		/**
		 * In-Game: "Cannot fire unless zoomed"
		 */
		val canOnlyFireWhenZoomed: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper only fire zoomed")
	
		/**
		 * In-Game: "On Full Charge: Projectiles penetrate players"
		 */
		val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper penetrate players when charged")
	
		/**
		 * In-Game: "No headshots when not fully charged"
		 */
		val cannotHeadshotWithoutFullCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper no headshot without full charge")
	
		/**
		 * In-Game: "Charge and fire shots independent of zoom"
		 * 
		 * Whether the rifle can headshot without being zoomed.
		 * 
		 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
		 */
		val canHeadshotUnscoped: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper crit no scope")
	
		/**
		 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
		 * 
		 * Level of explosive headshot.
		 * 
		 * Checked on attacker.
		 */
		val explosiveHeadshotLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("explosive sniper shot")
	
		/**
		 * In-Game: "On Scoped Hit: Apply Jarate for 2 to N seconds based on charge level. Nature's Call: Scoped headshots always mini-crits and reduce the remaining cooldown of Jarate by 1 second."
		 * 
		 * If greater than 0:.
		 * 
		 * Makes weapon not eject brass.
		 * 
		 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates.
		 * 
		 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
		 */
		val jarateDuration: ItemAttributeNamed<Float> = ItemAttributeNamed("jarate duration")
	
		/**
		 * In-Game: "No flinching when aiming and fully charged"
		 * 
		 * Prevents flinching from damage when scoped and fully charged.
		 */
		val aimingNoFlinch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("aiming no flinch")
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val damage: DamageAttributes get() = SniperRifleAttributes.damage
	
	override val onHit: OnHitAttributes get() = super.onHit
	
	/**
	 * In-Game: "No headshots"
	 * 
	 * 0: Normal.
	 * 
	 * 1: Sydney Sleeper.
	 * 
	 * 2: Machina.
	 * 
	 * 3: Classic.
	 */
	val cannotHeadshot: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.cannotHeadshot
	
	val buffType: BuffTypeAttributes get() = SniperRifleAttributes.buffType
	
	val sniperChargePerSec: SniperChargePerSecAttributes get() = SniperRifleAttributes.sniperChargePerSec
	
	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult to zoom and unzoom delay on clipless weapons.
	 * 
	 * Fun fact: this is also affected by the Precision mannpower powerup.
	 */
	val fasterReloadRate: ItemAttributeNamed<Float> get() = SniperRifleAttributes.fasterReloadRate
	
	/**
	 * In-Game: "Cannot fire unless zoomed"
	 */
	val canOnlyFireWhenZoomed: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.canOnlyFireWhenZoomed
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 */
	val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.penetratesWhenFullyCharged
	
	/**
	 * In-Game: "No headshots when not fully charged"
	 */
	val cannotHeadshotWithoutFullCharge: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.cannotHeadshotWithoutFullCharge
	
	/**
	 * In-Game: "Charge and fire shots independent of zoom"
	 * 
	 * Whether the rifle can headshot without being zoomed.
	 * 
	 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
	 */
	val canHeadshotUnscoped: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.canHeadshotUnscoped
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 * 
	 * Level of explosive headshot.
	 * 
	 * Checked on attacker.
	 */
	val explosiveHeadshotLevel: ItemAttributeNamed<Int> get() = SniperRifleAttributes.explosiveHeadshotLevel
	
	/**
	 * In-Game: "On Scoped Hit: Apply Jarate for 2 to N seconds based on charge level. Nature's Call: Scoped headshots always mini-crits and reduce the remaining cooldown of Jarate by 1 second."
	 * 
	 * If greater than 0:.
	 * 
	 * Makes weapon not eject brass.
	 * 
	 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates.
	 * 
	 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
	 */
	val jarateDuration: ItemAttributeNamed<Float> get() = SniperRifleAttributes.jarateDuration
	
	/**
	 * In-Game: "No flinching when aiming and fully charged"
	 * 
	 * Prevents flinching from damage when scoped and fully charged.
	 */
	val aimingNoFlinch: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.aimingNoFlinch
	
	override val ammo: AmmoAttributes get() = SniperRifleAttributes.ammo
	
	override val firing: FiringAttributes get() = SniperRifleAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = SniperRifleAttributes.projectiles

	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		/**
		 * In-Game: "On Full Charge: +N% damage per shot"
		 * 
		 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
		 */
		open val fullChargeDamageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("sniper full charge damage bonus")
	}
	
	open class OnHitAttributes : IBlockScoped {
		/**
		 * In-Game: "N% movement speed on targets"
		 * 
		 * Multiplier applied to target move-speed on hit.
		 * 
		 * Duration is equal to the rifle's `jarate_duration` attribute.
		 */
		open val appliesSnareEffect: ItemAttributeNamed<Float> = ItemAttributeNamed("applies snare effect")
	}
	
	open class BuffTypeAttributes : IBlockScoped {
		/**
		 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
		 */
		open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
		 */
		open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	}
	
	open class SniperChargePerSecAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% charge rate"
		 */
		open val sniperChargePerSec: ItemAttributeNamed<Float> = ItemAttributeNamed("sniper charge per sec")
	
		/**
		 * In-Game: "N% faster power charge"
		 */
		open val srifleChargeRateIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("SRifle Charge rate increased")
	
		/**
		 * In-Game: "N% slower power charge"
		 */
		open val srifleChargeRateDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("SRifle Charge rate decreased")
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
}