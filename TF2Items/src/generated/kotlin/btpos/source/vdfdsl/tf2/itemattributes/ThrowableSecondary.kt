package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ThrowableSecondaryAttributes : ThrowableAttributes {
	companion object : IBlockScoped {
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
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

	override val projectiles: ProjectilesAttributes get() = ThrowableSecondaryAttributes.projectiles
	
	override val meter: MeterAttributes get() = ThrowableSecondaryAttributes.meter
	
	override val onHit: OnHitAttributes get() = ThrowableSecondaryAttributes.onHit
	
	override val ammo: AmmoAttributes get() = ThrowableSecondaryAttributes.ammo
	
	override val damage: DamageAttributes get() = ThrowableSecondaryAttributes.damage
	
	override val firing: FiringAttributes get() = ThrowableSecondaryAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = ThrowableSecondaryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ThrowableSecondaryAttributes.buildings
	
	override val crits: CritsAttributes get() = ThrowableSecondaryAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ThrowableSecondaryAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ThrowableSecondaryAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ThrowableSecondaryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ThrowableSecondaryAttributes.meta
	
	override val movement: MovementAttributes get() = ThrowableSecondaryAttributes.movement
	
	override val heads: HeadsAttributes get() = ThrowableSecondaryAttributes.heads
	
	override val onKill: OnKillAttributes get() = ThrowableSecondaryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ThrowableSecondaryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ThrowableSecondaryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ThrowableSecondaryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ThrowableSecondaryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ThrowableSecondaryAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = ThrowableSecondaryAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = ThrowableSecondaryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ThrowableSecondaryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ThrowableSecondaryAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ThrowableSecondaryAttributes.disguise

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
	
	open class DamageAttributes : ThrowableAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : ThrowableAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : ThrowableAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ThrowableAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : ThrowableAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class AfterburnAttributes : ThrowableAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ThrowableAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ThrowableAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : ThrowableAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : ThrowableAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ThrowableAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ThrowableAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ThrowableAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ThrowableAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ThrowableAttributes.MetaAttributes.KillfeedAttributes() 
	
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
	
	open class ViewmodelAttributes : ThrowableAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : ThrowableAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ThrowableAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ThrowableAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ThrowableAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ThrowableAttributes.DisguiseAttributes() 
}