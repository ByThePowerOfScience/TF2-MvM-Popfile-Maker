package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface DragonsFuryAttributes : FlamethrowerAttributes {
	companion object : IBlockScoped {
		val airblast: AirblastAttributes = AirblastAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val flames: FlamesAttributes = FlamesAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
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

	override val airblast: AirblastAttributes get() = DragonsFuryAttributes.airblast
	
	override val crits: CritsAttributes get() = DragonsFuryAttributes.crits
	
	override val movement: MovementAttributes get() = DragonsFuryAttributes.movement
	
	override val ammo: AmmoAttributes get() = DragonsFuryAttributes.ammo
	
	override val healthAndHealing: HealthAndHealingAttributes get() = DragonsFuryAttributes.healthAndHealing
	
	override val buffType: BuffTypeAttributes get() = DragonsFuryAttributes.buffType
	
	override val flames: FlamesAttributes get() = DragonsFuryAttributes.flames
	
	override val damage: DamageAttributes get() = DragonsFuryAttributes.damage
	
	override val firing: FiringAttributes get() = DragonsFuryAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = DragonsFuryAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = DragonsFuryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = DragonsFuryAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = DragonsFuryAttributes.demoCharge
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = DragonsFuryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = DragonsFuryAttributes.meta
	
	override val meter: MeterAttributes get() = DragonsFuryAttributes.meter
	
	override val heads: HeadsAttributes get() = DragonsFuryAttributes.heads
	
	override val onHit: OnHitAttributes get() = DragonsFuryAttributes.onHit
	
	override val onKill: OnKillAttributes get() = DragonsFuryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = DragonsFuryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = DragonsFuryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = DragonsFuryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = DragonsFuryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = DragonsFuryAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = DragonsFuryAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = DragonsFuryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = DragonsFuryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = DragonsFuryAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = DragonsFuryAttributes.disguise

	open class AirblastAttributes : FlamethrowerAttributes.AirblastAttributes() 
	
	open class CritsAttributes : FlamethrowerAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : FlamethrowerAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class MovementAttributes : FlamethrowerAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : FlamethrowerAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class AmmoAttributes : FlamethrowerAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : FlamethrowerAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class HealthAndHealingAttributes : FlamethrowerAttributes.HealthAndHealingAttributes() 
	
	open class BuffTypeAttributes : FlamethrowerAttributes.BuffTypeAttributes() {
		override val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		open class BuffTypeAttributes : FlamethrowerAttributes.BuffTypeAttributes.BuffTypeAttributes() 
	}
	
	open class FlamesAttributes : FlamethrowerAttributes.FlamesAttributes() 
	
	open class DamageAttributes : FlamethrowerAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : FlamethrowerAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : FlamethrowerAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : FlamethrowerAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : FlamethrowerAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : FlamethrowerAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : FlamethrowerAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : FlamethrowerAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : FlamethrowerAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : FlamethrowerAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : FlamethrowerAttributes.DemoChargeAttributes() 
	
	open class KnockbackReceivedAttributes : FlamethrowerAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : FlamethrowerAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : FlamethrowerAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : FlamethrowerAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : FlamethrowerAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : FlamethrowerAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : FlamethrowerAttributes.MeterAttributes() 
	
	open class HeadsAttributes : FlamethrowerAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : FlamethrowerAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : FlamethrowerAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : FlamethrowerAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : FlamethrowerAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : FlamethrowerAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : FlamethrowerAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : FlamethrowerAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : FlamethrowerAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : FlamethrowerAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : FlamethrowerAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : FlamethrowerAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : FlamethrowerAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : FlamethrowerAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : FlamethrowerAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : FlamethrowerAttributes.DisguiseAttributes() 
}