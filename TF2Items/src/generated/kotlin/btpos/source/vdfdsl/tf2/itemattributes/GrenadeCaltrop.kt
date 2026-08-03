package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface GrenadeCaltropAttributes : IBlockScoped, WeaponBaseGrenadeAttributes {
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

	override val afterburn: AfterburnAttributes get() = GrenadeCaltropAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = GrenadeCaltropAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = GrenadeCaltropAttributes.buildings
	
	override val crits: CritsAttributes get() = GrenadeCaltropAttributes.crits
	
	override val damage: DamageAttributes get() = GrenadeCaltropAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = GrenadeCaltropAttributes.demoCharge
	
	override val firing: FiringAttributes get() = GrenadeCaltropAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = GrenadeCaltropAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = GrenadeCaltropAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = GrenadeCaltropAttributes.meta
	
	override val meter: MeterAttributes get() = GrenadeCaltropAttributes.meter
	
	override val movement: MovementAttributes get() = GrenadeCaltropAttributes.movement
	
	override val heads: HeadsAttributes get() = GrenadeCaltropAttributes.heads
	
	override val onHit: OnHitAttributes get() = GrenadeCaltropAttributes.onHit
	
	override val onKill: OnKillAttributes get() = GrenadeCaltropAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = GrenadeCaltropAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = GrenadeCaltropAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = GrenadeCaltropAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = GrenadeCaltropAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = GrenadeCaltropAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = GrenadeCaltropAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = GrenadeCaltropAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = GrenadeCaltropAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = GrenadeCaltropAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = GrenadeCaltropAttributes.disguise

	open class AfterburnAttributes : WeaponBaseGrenadeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WeaponBaseGrenadeAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : WeaponBaseGrenadeAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : WeaponBaseGrenadeAttributes.CritsAttributes() 
	
	open class DamageAttributes : WeaponBaseGrenadeAttributes.DamageAttributes() 
	
	open class DemoChargeAttributes : WeaponBaseGrenadeAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : WeaponBaseGrenadeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseGrenadeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : WeaponBaseGrenadeAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WeaponBaseGrenadeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseGrenadeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseGrenadeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WeaponBaseGrenadeAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseGrenadeAttributes.MeterAttributes() 
	
	open class MovementAttributes : WeaponBaseGrenadeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseGrenadeAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : WeaponBaseGrenadeAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseGrenadeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : WeaponBaseGrenadeAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : WeaponBaseGrenadeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : WeaponBaseGrenadeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseGrenadeAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : WeaponBaseGrenadeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseGrenadeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseGrenadeAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseGrenadeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseGrenadeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseGrenadeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseGrenadeAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WeaponBaseGrenadeAttributes.DisguiseAttributes() 
}