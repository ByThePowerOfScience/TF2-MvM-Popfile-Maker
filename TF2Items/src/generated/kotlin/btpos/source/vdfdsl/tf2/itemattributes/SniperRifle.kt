package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SniperRifleAttributes : BaseGunAttributes {
	companion object : IBlockScoped {
		val sniperChargePerSec: SniperChargePerSecAttributes = SniperChargePerSecAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * In-Game: "On Full Charge: +N% damage per shot"
		 * 
		 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
		 */
		val fullChargeDamageBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("sniper full charge damage bonus")
	
		/**
		 * In-Game: "N% movement speed on targets"
		 * 
		 * Multiplier applied to target move-speed on hit.
		 * 
		 * Duration is equal to the rifle's `jarate_duration` attribute.
		 */
		val appliesSnareEffect: ItemAttributeNamed<Number> = ItemAttributeNamed("applies snare effect")
	
		/**
		 * In-Game: "N% faster power charge"
		 */
		val srifleChargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("SRifle Charge rate increased")
	
		/**
		 * In-Game: "N% slower power charge"
		 */
		val srifleChargeRateDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("SRifle Charge rate decreased")
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
	val cannotHeadshot: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.cannotHeadshot.get()
	
	/**
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	val soldierBuffType: ItemAttributeNamed<Int> get() = SniperRifleAttributes.soldierBuffType.get()
	
	/**
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	val demoBuffType: ItemAttributeNamed<Int> get() = SniperRifleAttributes.demoBuffType.get()
	
	val sniperChargePerSec: SniperChargePerSecAttributes get() = SniperRifleAttributes.sniperChargePerSec
	
	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult to zoom and unzoom delay on clipless weapons.
	 * 
	 * Fun fact: this is also affected by the Precision mannpower powerup.
	 */
	val fasterReloadRate: ItemAttributeNamed<Number> get() = SniperRifleAttributes.fasterReloadRate.get()
	
	/**
	 * In-Game: "Cannot fire unless zoomed"
	 */
	val canOnlyFireWhenZoomed: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.canOnlyFireWhenZoomed.get()
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 */
	val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.penetratesWhenFullyCharged.get()
	
	/**
	 * In-Game: "No headshots when not fully charged"
	 */
	val cannotHeadshotWithoutFullCharge: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.cannotHeadshotWithoutFullCharge.get()
	
	/**
	 * In-Game: "Charge and fire shots independent of zoom"
	 * 
	 * Whether the rifle can headshot without being zoomed.
	 * 
	 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
	 */
	val canHeadshotUnscoped: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.canHeadshotUnscoped.get()
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 * 
	 * Level of explosive headshot.
	 * 
	 * Checked on attacker.
	 */
	val explosiveHeadshotLevel: ItemAttributeNamed<Int> get() = SniperRifleAttributes.explosiveHeadshotLevel.get()
	
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
	val jarateDuration: ItemAttributeNamed<Number> get() = SniperRifleAttributes.jarateDuration.get()
	
	/**
	 * In-Game: "No flinching when aiming and fully charged"
	 * 
	 * Prevents flinching from damage when scoped and fully charged.
	 */
	val aimingNoFlinch: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.aimingNoFlinch.get()
	
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
	
	override val swapWeapons: SwapWeaponsAttributes get() = SniperRifleAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SniperRifleAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SniperRifleAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = SniperRifleAttributes.disguise

	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "On Full Charge: +N% damage per shot"
		 * 
		 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
		 */
		context(attrs: IAttributeContainer)
		open var fullChargeDamageBonus: Number? 
			get() = SniperRifleAttributes.fullChargeDamageBonus.get()
			set(value) { SniperRifleAttributes.fullChargeDamageBonus.set(value) }
	}
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "N% movement speed on targets"
		 * 
		 * Multiplier applied to target move-speed on hit.
		 * 
		 * Duration is equal to the rifle's `jarate_duration` attribute.
		 */
		context(attrs: IAttributeContainer)
		open var appliesSnareEffect: Number? 
			get() = SniperRifleAttributes.appliesSnareEffect.get()
			set(value) { SniperRifleAttributes.appliesSnareEffect.set(value) }
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SniperChargePerSecAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "+N% charge rate"
		 */
		context(attrs: IAttributeContainer)
		open var sniperChargePerSec: Number? 
			get() = SniperRifleAttributes.sniperChargePerSec.get()
			set(value) { SniperRifleAttributes.sniperChargePerSec.set(value) }
	
		/**
		 * In-Game: "N% faster power charge"
		 */
		context(attrs: IAttributeContainer)
		open var srifleChargeRateIncreased: Number? 
			get() = SniperRifleAttributes.srifleChargeRateIncreased.get()
			set(value) { SniperRifleAttributes.srifleChargeRateIncreased.set(value) }
	
		/**
		 * In-Game: "N% slower power charge"
		 */
		context(attrs: IAttributeContainer)
		open var srifleChargeRateDecreased: Number? 
			get() = SniperRifleAttributes.srifleChargeRateDecreased.get()
			set(value) { SniperRifleAttributes.srifleChargeRateDecreased.set(value) }
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
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
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
}