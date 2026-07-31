package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CannonAttributes : GrenadeLauncherAttributes {
	companion object : IBlockScoped {
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
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

	override val projectiles: ProjectilesAttributes get() = CannonAttributes.projectiles
	
	override val damage: DamageAttributes get() = CannonAttributes.damage
	
	override val ammo: AmmoAttributes get() = CannonAttributes.ammo
	
	override val firing: FiringAttributes get() = CannonAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = CannonAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = CannonAttributes.buildings
	
	override val crits: CritsAttributes get() = CannonAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = CannonAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = CannonAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = CannonAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = CannonAttributes.meta
	
	override val meter: MeterAttributes get() = CannonAttributes.meter
	
	override val movement: MovementAttributes get() = CannonAttributes.movement
	
	override val heads: HeadsAttributes get() = CannonAttributes.heads
	
	override val onHit: OnHitAttributes get() = CannonAttributes.onHit
	
	override val onKill: OnKillAttributes get() = CannonAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = CannonAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = CannonAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = CannonAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = CannonAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = CannonAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = CannonAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = CannonAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = CannonAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = CannonAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = CannonAttributes.disguise

	open class ProjectilesAttributes : GrenadeLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : GrenadeLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : GrenadeLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class DamageAttributes : GrenadeLauncherAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : GrenadeLauncherAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class AmmoAttributes : GrenadeLauncherAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : GrenadeLauncherAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class FiringAttributes : GrenadeLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : GrenadeLauncherAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : GrenadeLauncherAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class AfterburnAttributes : GrenadeLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : GrenadeLauncherAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : GrenadeLauncherAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : GrenadeLauncherAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : GrenadeLauncherAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : GrenadeLauncherAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : GrenadeLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : GrenadeLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : GrenadeLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : GrenadeLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : GrenadeLauncherAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : GrenadeLauncherAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : GrenadeLauncherAttributes.MeterAttributes() 
	
	open class MovementAttributes : GrenadeLauncherAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : GrenadeLauncherAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : GrenadeLauncherAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : GrenadeLauncherAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : GrenadeLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : GrenadeLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : GrenadeLauncherAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : GrenadeLauncherAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : GrenadeLauncherAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : GrenadeLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : GrenadeLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : GrenadeLauncherAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : GrenadeLauncherAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : GrenadeLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : GrenadeLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : GrenadeLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : GrenadeLauncherAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : GrenadeLauncherAttributes.DisguiseAttributes() 
}