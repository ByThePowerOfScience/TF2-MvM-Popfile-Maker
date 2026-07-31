package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SodaPopperAttributes : ScattergunAttributes {
	companion object : IBlockScoped {
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
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

	override val onHit: OnHitAttributes get() = SodaPopperAttributes.onHit
	
	override val reloading: ReloadingAttributes get() = SodaPopperAttributes.reloading
	
	override val ammo: AmmoAttributes get() = SodaPopperAttributes.ammo
	
	override val damage: DamageAttributes get() = SodaPopperAttributes.damage
	
	override val firing: FiringAttributes get() = SodaPopperAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = SodaPopperAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = SodaPopperAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = SodaPopperAttributes.buildings
	
	override val crits: CritsAttributes get() = SodaPopperAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = SodaPopperAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SodaPopperAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SodaPopperAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SodaPopperAttributes.meta
	
	override val meter: MeterAttributes get() = SodaPopperAttributes.meter
	
	override val movement: MovementAttributes get() = SodaPopperAttributes.movement
	
	override val heads: HeadsAttributes get() = SodaPopperAttributes.heads
	
	override val onKill: OnKillAttributes get() = SodaPopperAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = SodaPopperAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SodaPopperAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SodaPopperAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SodaPopperAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = SodaPopperAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = SodaPopperAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SodaPopperAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SodaPopperAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = SodaPopperAttributes.disguise

	open class OnHitAttributes : ScattergunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ScattergunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ScattergunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class ReloadingAttributes : ScattergunAttributes.ReloadingAttributes() 
	
	open class AmmoAttributes : ScattergunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : ScattergunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : ScattergunAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : ScattergunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : ScattergunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ScattergunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : ScattergunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : ScattergunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ScattergunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ScattergunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ScattergunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ScattergunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ScattergunAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : ScattergunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : ScattergunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ScattergunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ScattergunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ScattergunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ScattergunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ScattergunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : ScattergunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ScattergunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : ScattergunAttributes.MeterAttributes() 
	
	open class MovementAttributes : ScattergunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : ScattergunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : ScattergunAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : ScattergunAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : ScattergunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : ScattergunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ScattergunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ScattergunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : ScattergunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : ScattergunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ScattergunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ScattergunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ScattergunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ScattergunAttributes.DisguiseAttributes() 
}