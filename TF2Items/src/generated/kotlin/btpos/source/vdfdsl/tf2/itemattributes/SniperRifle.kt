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
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	override val damage: DamageAttributes get() = SniperRifleAttributes.damage
	
	override val onHit: OnHitAttributes get() = SniperRifleAttributes.onHit
	
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
	
	override val afterburn: AfterburnAttributes get() = SniperRifleAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = SniperRifleAttributes.buildings
	
	override val crits: CritsAttributes get() = SniperRifleAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = SniperRifleAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SniperRifleAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SniperRifleAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SniperRifleAttributes.meta
	
	override val meter: MeterAttributes get() = SniperRifleAttributes.meter
	
	override val movement: MovementAttributes get() = SniperRifleAttributes.movement
	
	override val heads: HeadsAttributes get() = SniperRifleAttributes.heads
	
	override val onKill: OnKillAttributes get() = SniperRifleAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = SniperRifleAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = SniperRifleAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SniperRifleAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SniperRifleAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SniperRifleAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = SniperRifleAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = SniperRifleAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SniperRifleAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SniperRifleAttributes.ragdolls

	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		/**
		 * In-Game: "On Full Charge: +N% damage per shot"
		 * 
		 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
		 */
		open val fullChargeDamageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("sniper full charge damage bonus")
	
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BaseGunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		/**
		 * In-Game: "N% movement speed on targets"
		 * 
		 * Multiplier applied to target move-speed on hit.
		 * 
		 * Duration is equal to the rifle's `jarate_duration` attribute.
		 */
		open val appliesSnareEffect: ItemAttributeNamed<Float> = ItemAttributeNamed("applies snare effect")
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
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
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BaseGunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BaseGunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
}