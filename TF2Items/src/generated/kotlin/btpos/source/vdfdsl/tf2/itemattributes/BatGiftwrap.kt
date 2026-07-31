package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BatGiftwrapAttributes : BatWoodAttributes {
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

	override val crits: CritsAttributes get() = BatGiftwrapAttributes.crits
	
	override val damage: DamageAttributes get() = BatGiftwrapAttributes.damage
	
	override val onHit: OnHitAttributes get() = BatGiftwrapAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BatGiftwrapAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BatGiftwrapAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BatGiftwrapAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BatGiftwrapAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BatGiftwrapAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BatGiftwrapAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BatGiftwrapAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BatGiftwrapAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BatGiftwrapAttributes.meta
	
	override val meter: MeterAttributes get() = BatGiftwrapAttributes.meter
	
	override val movement: MovementAttributes get() = BatGiftwrapAttributes.movement
	
	override val heads: HeadsAttributes get() = BatGiftwrapAttributes.heads
	
	override val onKill: OnKillAttributes get() = BatGiftwrapAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BatGiftwrapAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BatGiftwrapAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BatGiftwrapAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BatGiftwrapAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BatGiftwrapAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BatGiftwrapAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = BatGiftwrapAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = BatGiftwrapAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BatGiftwrapAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BatGiftwrapAttributes.disguise

	open class CritsAttributes : BatWoodAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BatWoodAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : BatWoodAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BatWoodAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : BatWoodAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BatWoodAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BatWoodAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BatWoodAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BatWoodAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BatWoodAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BatWoodAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BatWoodAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BatWoodAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BatWoodAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BatWoodAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BatWoodAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BatWoodAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : BatWoodAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BatWoodAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BatWoodAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BatWoodAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BatWoodAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BatWoodAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BatWoodAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BatWoodAttributes.MeterAttributes() 
	
	open class MovementAttributes : BatWoodAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BatWoodAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BatWoodAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BatWoodAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BatWoodAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BatWoodAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BatWoodAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BatWoodAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BatWoodAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BatWoodAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BatWoodAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BatWoodAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BatWoodAttributes.ViewmodelAttributes() 
	
	open class WhenHitAttributes : BatWoodAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BatWoodAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BatWoodAttributes.DisguiseAttributes() 
}