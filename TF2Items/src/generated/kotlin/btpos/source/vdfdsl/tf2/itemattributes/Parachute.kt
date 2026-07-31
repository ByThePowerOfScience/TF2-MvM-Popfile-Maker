package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ParachuteAttributes : BuffItemAttributes {
	companion object : IBlockScoped {
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
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

	override val buffItems: BuffItemsAttributes get() = ParachuteAttributes.buffItems
	
	override val crits: CritsAttributes get() = ParachuteAttributes.crits
	
	override val damage: DamageAttributes get() = ParachuteAttributes.damage
	
	override val onHit: OnHitAttributes get() = ParachuteAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = ParachuteAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = ParachuteAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = ParachuteAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = ParachuteAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = ParachuteAttributes.demoCharge
	
	override val firing: FiringAttributes get() = ParachuteAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ParachuteAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ParachuteAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ParachuteAttributes.meta
	
	override val meter: MeterAttributes get() = ParachuteAttributes.meter
	
	override val movement: MovementAttributes get() = ParachuteAttributes.movement
	
	override val heads: HeadsAttributes get() = ParachuteAttributes.heads
	
	override val onKill: OnKillAttributes get() = ParachuteAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = ParachuteAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = ParachuteAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ParachuteAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ParachuteAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ParachuteAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ParachuteAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = ParachuteAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = ParachuteAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ParachuteAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ParachuteAttributes.disguise

	open class BuffItemsAttributes : BuffItemAttributes.BuffItemsAttributes() {
		override val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		open class BuffTypeAttributes : BuffItemAttributes.BuffItemsAttributes.BuffTypeAttributes() 
	}
	
	open class CritsAttributes : BuffItemAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BuffItemAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : BuffItemAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BuffItemAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : BuffItemAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BuffItemAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BuffItemAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BuffItemAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BuffItemAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BuffItemAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BuffItemAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BuffItemAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BuffItemAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BuffItemAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BuffItemAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BuffItemAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BuffItemAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : BuffItemAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BuffItemAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BuffItemAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BuffItemAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BuffItemAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BuffItemAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BuffItemAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BuffItemAttributes.MeterAttributes() 
	
	open class MovementAttributes : BuffItemAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BuffItemAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BuffItemAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BuffItemAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BuffItemAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BuffItemAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BuffItemAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BuffItemAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BuffItemAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BuffItemAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BuffItemAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BuffItemAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BuffItemAttributes.ViewmodelAttributes() 
	
	open class WhenHitAttributes : BuffItemAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BuffItemAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BuffItemAttributes.DisguiseAttributes() 
}