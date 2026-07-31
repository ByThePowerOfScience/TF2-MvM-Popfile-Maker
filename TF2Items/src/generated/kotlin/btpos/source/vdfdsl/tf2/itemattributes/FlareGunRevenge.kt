package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface FlareGunRevengeAttributes : FlareGunAttributes {
	companion object : IBlockScoped {
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

	override val ammo: AmmoAttributes get() = FlareGunRevengeAttributes.ammo
	
	override val damage: DamageAttributes get() = FlareGunRevengeAttributes.damage
	
	override val firing: FiringAttributes get() = FlareGunRevengeAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = FlareGunRevengeAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = FlareGunRevengeAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = FlareGunRevengeAttributes.buildings
	
	override val crits: CritsAttributes get() = FlareGunRevengeAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = FlareGunRevengeAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = FlareGunRevengeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = FlareGunRevengeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = FlareGunRevengeAttributes.meta
	
	override val meter: MeterAttributes get() = FlareGunRevengeAttributes.meter
	
	override val movement: MovementAttributes get() = FlareGunRevengeAttributes.movement
	
	override val heads: HeadsAttributes get() = FlareGunRevengeAttributes.heads
	
	override val onHit: OnHitAttributes get() = FlareGunRevengeAttributes.onHit
	
	override val onKill: OnKillAttributes get() = FlareGunRevengeAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = FlareGunRevengeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = FlareGunRevengeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = FlareGunRevengeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = FlareGunRevengeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = FlareGunRevengeAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = FlareGunRevengeAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = FlareGunRevengeAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = FlareGunRevengeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = FlareGunRevengeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = FlareGunRevengeAttributes.disguise

	open class AmmoAttributes : FlareGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : FlareGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : FlareGunAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : FlareGunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : FlareGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : FlareGunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : FlareGunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : FlareGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : FlareGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : FlareGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : FlareGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : FlareGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : FlareGunAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : FlareGunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : FlareGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : FlareGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : FlareGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : FlareGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : FlareGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : FlareGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : FlareGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : FlareGunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : FlareGunAttributes.MeterAttributes() 
	
	open class MovementAttributes : FlareGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : FlareGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : FlareGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : FlareGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : FlareGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : FlareGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : FlareGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : FlareGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : FlareGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : FlareGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : FlareGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : FlareGunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : FlareGunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : FlareGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : FlareGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : FlareGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : FlareGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : FlareGunAttributes.DisguiseAttributes() 
}