package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BuilderAttributes : WeaponBaseAttributes {
	companion object : IBlockScoped {
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	/**
	 * In-Game: "Self mark for death when hauling buildings"
	 * 
	 * Checked on owner.
	 */
	val markForDeathOnBuildingPickup: ItemAttributeNamed<Boolean> get() = BuilderAttributes.markForDeathOnBuildingPickup.get()
	
	/**
	 * If 1.0, it's a wheatley sapper.
	 */
	val sapperVoicePak: ItemAttributeNamed<Number> get() = BuilderAttributes.sapperVoicePak.get()
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 * 
	 * If greater than 0 on base builder: If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot), gives the sapper a radius instead of being single-target.
	 */
	val roboSapper: ItemAttributeNamed<Int> get() = BuilderAttributes.roboSapper.get()
	
	override val afterburn: AfterburnAttributes get() = BuilderAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BuilderAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BuilderAttributes.buildings
	
	override val crits: CritsAttributes get() = BuilderAttributes.crits
	
	override val damage: DamageAttributes get() = BuilderAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = BuilderAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BuilderAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BuilderAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BuilderAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BuilderAttributes.meta
	
	override val meter: MeterAttributes get() = BuilderAttributes.meter
	
	override val movement: MovementAttributes get() = BuilderAttributes.movement
	
	override val heads: HeadsAttributes get() = BuilderAttributes.heads
	
	override val onHit: OnHitAttributes get() = BuilderAttributes.onHit
	
	override val onKill: OnKillAttributes get() = BuilderAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BuilderAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BuilderAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BuilderAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BuilderAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BuilderAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BuilderAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = BuilderAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = BuilderAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BuilderAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BuilderAttributes.disguise

	open class AfterburnAttributes : WeaponBaseAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WeaponBaseAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WeaponBaseAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : WeaponBaseAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() 
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() 
	
	open class DemoChargeAttributes : WeaponBaseAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : WeaponBaseAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : WeaponBaseAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WeaponBaseAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WeaponBaseAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WeaponBaseAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseAttributes.MeterAttributes() 
	
	open class MovementAttributes : WeaponBaseAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : WeaponBaseAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : WeaponBaseAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : WeaponBaseAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : WeaponBaseAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : WeaponBaseAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WeaponBaseAttributes.DisguiseAttributes() 
}