package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ThrowablePrimaryAttributes : IBlockScoped, ThrowableAttributes {
	companion object : IBlockScoped {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
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
	}

	override val projectiles: ProjectilesAttributes get() = ThrowablePrimaryAttributes.projectiles
	
	override val meter: MeterAttributes get() = ThrowablePrimaryAttributes.meter
	
	override val onHit: OnHitAttributes get() = ThrowablePrimaryAttributes.onHit
	
	override val ammo: AmmoAttributes get() = ThrowablePrimaryAttributes.ammo
	
	override val damage: DamageAttributes get() = ThrowablePrimaryAttributes.damage
	
	override val firing: FiringAttributes get() = ThrowablePrimaryAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = ThrowablePrimaryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ThrowablePrimaryAttributes.buildings
	
	override val crits: CritsAttributes get() = ThrowablePrimaryAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ThrowablePrimaryAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ThrowablePrimaryAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ThrowablePrimaryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ThrowablePrimaryAttributes.meta
	
	override val movement: MovementAttributes get() = ThrowablePrimaryAttributes.movement
	
	override val heads: HeadsAttributes get() = ThrowablePrimaryAttributes.heads
	
	override val onKill: OnKillAttributes get() = ThrowablePrimaryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ThrowablePrimaryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ThrowablePrimaryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ThrowablePrimaryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ThrowablePrimaryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ThrowablePrimaryAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ThrowablePrimaryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ThrowablePrimaryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ThrowablePrimaryAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ThrowablePrimaryAttributes.disguise

	open class ProjectilesAttributes : ThrowableAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ThrowableAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ThrowableAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class MeterAttributes : ThrowableAttributes.MeterAttributes() 
	
	open class OnHitAttributes : ThrowableAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ThrowableAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ThrowableAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class AmmoAttributes : ThrowableAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : ThrowableAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : ThrowableAttributes.DamageAttributes() 
	
	open class FiringAttributes : ThrowableAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ThrowableAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : ThrowableAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ThrowableAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ThrowableAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ThrowableAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ThrowableAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ThrowableAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ThrowableAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ThrowableAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ThrowableAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ThrowableAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ThrowableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ThrowableAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MovementAttributes : ThrowableAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : ThrowableAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : ThrowableAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : ThrowableAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : ThrowableAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : ThrowableAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : ThrowableAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ThrowableAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ThrowableAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ThrowableAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ThrowableAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ThrowableAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ThrowableAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ThrowableAttributes.DisguiseAttributes() 
}