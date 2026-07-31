package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BatWoodAttributes : BatAttributes {
	companion object : IBlockScoped {
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	override val crits: CritsAttributes get() = BatWoodAttributes.crits
	
	override val damage: DamageAttributes get() = BatWoodAttributes.damage
	
	override val onHit: OnHitAttributes get() = BatWoodAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BatWoodAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BatWoodAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BatWoodAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BatWoodAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BatWoodAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BatWoodAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BatWoodAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BatWoodAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BatWoodAttributes.meta
	
	override val meter: MeterAttributes get() = BatWoodAttributes.meter
	
	override val movement: MovementAttributes get() = BatWoodAttributes.movement
	
	override val heads: HeadsAttributes get() = BatWoodAttributes.heads
	
	override val onKill: OnKillAttributes get() = BatWoodAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BatWoodAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BatWoodAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BatWoodAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BatWoodAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BatWoodAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BatWoodAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = BatWoodAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = BatWoodAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BatWoodAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BatWoodAttributes.disguise

	open class CritsAttributes : BatAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BatAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : BatAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BatAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : BatAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BatAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BatAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BatAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BatAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BatAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BatAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BatAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BatAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BatAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BatAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BatAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BatAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : BatAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BatAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BatAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BatAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BatAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BatAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BatAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BatAttributes.MeterAttributes() 
	
	open class MovementAttributes : BatAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BatAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BatAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BatAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BatAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BatAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BatAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BatAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BatAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BatAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BatAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BatAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BatAttributes.ViewmodelAttributes() 
	
	open class WhenHitAttributes : BatAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BatAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BatAttributes.DisguiseAttributes() 
}