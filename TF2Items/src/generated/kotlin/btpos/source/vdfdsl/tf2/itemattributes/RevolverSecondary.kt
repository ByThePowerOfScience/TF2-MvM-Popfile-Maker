package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface RevolverSecondaryAttributes : RevolverAttributes {
	companion object : IBlockScoped {
		val heads: HeadsAttributes = HeadsAttributes()
	
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
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
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

	override val heads: HeadsAttributes get() = RevolverSecondaryAttributes.heads
	
	override val ammo: AmmoAttributes get() = RevolverSecondaryAttributes.ammo
	
	override val damage: DamageAttributes get() = RevolverSecondaryAttributes.damage
	
	override val firing: FiringAttributes get() = RevolverSecondaryAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = RevolverSecondaryAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = RevolverSecondaryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = RevolverSecondaryAttributes.buildings
	
	override val crits: CritsAttributes get() = RevolverSecondaryAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = RevolverSecondaryAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = RevolverSecondaryAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = RevolverSecondaryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = RevolverSecondaryAttributes.meta
	
	override val meter: MeterAttributes get() = RevolverSecondaryAttributes.meter
	
	override val movement: MovementAttributes get() = RevolverSecondaryAttributes.movement
	
	override val onHit: OnHitAttributes get() = RevolverSecondaryAttributes.onHit
	
	override val onKill: OnKillAttributes get() = RevolverSecondaryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = RevolverSecondaryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = RevolverSecondaryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = RevolverSecondaryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = RevolverSecondaryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = RevolverSecondaryAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = RevolverSecondaryAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = RevolverSecondaryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = RevolverSecondaryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = RevolverSecondaryAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = RevolverSecondaryAttributes.disguise

	open class HeadsAttributes : RevolverAttributes.HeadsAttributes() 
	
	open class AmmoAttributes : RevolverAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : RevolverAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : RevolverAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : RevolverAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : RevolverAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RevolverAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : RevolverAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : RevolverAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RevolverAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RevolverAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : RevolverAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RevolverAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : RevolverAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : RevolverAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : RevolverAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : RevolverAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : RevolverAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RevolverAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RevolverAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : RevolverAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : RevolverAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RevolverAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : RevolverAttributes.MeterAttributes() 
	
	open class MovementAttributes : RevolverAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : RevolverAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class OnHitAttributes : RevolverAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : RevolverAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : RevolverAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : RevolverAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : RevolverAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : RevolverAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : RevolverAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RevolverAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RevolverAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : RevolverAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : RevolverAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RevolverAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RevolverAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RevolverAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : RevolverAttributes.DisguiseAttributes() 
}