package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PDAEngineerBuildAttributes : PDAAttributes {
	companion object : IBlockScoped {
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	override val afterburn: AfterburnAttributes get() = PDAEngineerBuildAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = PDAEngineerBuildAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = PDAEngineerBuildAttributes.buildings
	
	override val crits: CritsAttributes get() = PDAEngineerBuildAttributes.crits
	
	override val damage: DamageAttributes get() = PDAEngineerBuildAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = PDAEngineerBuildAttributes.demoCharge
	
	override val firing: FiringAttributes get() = PDAEngineerBuildAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = PDAEngineerBuildAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = PDAEngineerBuildAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = PDAEngineerBuildAttributes.meta
	
	override val meter: MeterAttributes get() = PDAEngineerBuildAttributes.meter
	
	override val movement: MovementAttributes get() = PDAEngineerBuildAttributes.movement
	
	override val heads: HeadsAttributes get() = PDAEngineerBuildAttributes.heads
	
	override val onHit: OnHitAttributes get() = PDAEngineerBuildAttributes.onHit
	
	override val onKill: OnKillAttributes get() = PDAEngineerBuildAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = PDAEngineerBuildAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = PDAEngineerBuildAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = PDAEngineerBuildAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = PDAEngineerBuildAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = PDAEngineerBuildAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = PDAEngineerBuildAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = PDAEngineerBuildAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = PDAEngineerBuildAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = PDAEngineerBuildAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = PDAEngineerBuildAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = PDAEngineerBuildAttributes.disguise

	open class AfterburnAttributes : PDAAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : PDAAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : PDAAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : PDAAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : PDAAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : PDAAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : PDAAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : PDAAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class DemoChargeAttributes : PDAAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : PDAAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : PDAAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : PDAAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : PDAAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : PDAAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : PDAAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : PDAAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : PDAAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : PDAAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : PDAAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : PDAAttributes.MeterAttributes() 
	
	open class MovementAttributes : PDAAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : PDAAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : PDAAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : PDAAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : PDAAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : PDAAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : PDAAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : PDAAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : PDAAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : PDAAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : PDAAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : PDAAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : PDAAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : PDAAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : PDAAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : PDAAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : PDAAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : PDAAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : PDAAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : PDAAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : PDAAttributes.DisguiseAttributes() 
}