package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SniperRifleDecapAttributes : SniperRifleAttributes {
	companion object : IBlockScoped {
		val damage: DamageAttributes = DamageAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val sniperChargePerSec: SniperChargePerSecAttributes = SniperChargePerSecAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
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

	override val damage: DamageAttributes get() = SniperRifleDecapAttributes.damage
	
	override val onHit: OnHitAttributes get() = SniperRifleDecapAttributes.onHit
	
	override val buffType: BuffTypeAttributes get() = SniperRifleDecapAttributes.buffType
	
	override val sniperChargePerSec: SniperChargePerSecAttributes get() = SniperRifleDecapAttributes.sniperChargePerSec
	
	override val ammo: AmmoAttributes get() = SniperRifleDecapAttributes.ammo
	
	override val firing: FiringAttributes get() = SniperRifleDecapAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = SniperRifleDecapAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = SniperRifleDecapAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = SniperRifleDecapAttributes.buildings
	
	override val crits: CritsAttributes get() = SniperRifleDecapAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = SniperRifleDecapAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SniperRifleDecapAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SniperRifleDecapAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SniperRifleDecapAttributes.meta
	
	override val meter: MeterAttributes get() = SniperRifleDecapAttributes.meter
	
	override val movement: MovementAttributes get() = SniperRifleDecapAttributes.movement
	
	override val heads: HeadsAttributes get() = SniperRifleDecapAttributes.heads
	
	override val onKill: OnKillAttributes get() = SniperRifleDecapAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = SniperRifleDecapAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = SniperRifleDecapAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SniperRifleDecapAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SniperRifleDecapAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SniperRifleDecapAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = SniperRifleDecapAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = SniperRifleDecapAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SniperRifleDecapAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SniperRifleDecapAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = SniperRifleDecapAttributes.disguise

	open class DamageAttributes : SniperRifleAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : SniperRifleAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : SniperRifleAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : SniperRifleAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : SniperRifleAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class BuffTypeAttributes : SniperRifleAttributes.BuffTypeAttributes() 
	
	open class SniperChargePerSecAttributes : SniperRifleAttributes.SniperChargePerSecAttributes() 
	
	open class AmmoAttributes : SniperRifleAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : SniperRifleAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class FiringAttributes : SniperRifleAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : SniperRifleAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : SniperRifleAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : SniperRifleAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : SniperRifleAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : SniperRifleAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : SniperRifleAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : SniperRifleAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : SniperRifleAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : SniperRifleAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : SniperRifleAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : SniperRifleAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : SniperRifleAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : SniperRifleAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : SniperRifleAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : SniperRifleAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : SniperRifleAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : SniperRifleAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : SniperRifleAttributes.MeterAttributes() 
	
	open class MovementAttributes : SniperRifleAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : SniperRifleAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : SniperRifleAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : SniperRifleAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : SniperRifleAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : SniperRifleAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : SniperRifleAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : SniperRifleAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : SniperRifleAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : SniperRifleAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : SniperRifleAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : SniperRifleAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : SniperRifleAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : SniperRifleAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : SniperRifleAttributes.DisguiseAttributes() 
}