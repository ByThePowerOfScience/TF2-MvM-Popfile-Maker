package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration



interface SwordAttributes : BaseMeleeAttributes {
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

	override val onKill: OnKillAttributes get() = SwordAttributes.onKill
	
	override val crits: CritsAttributes get() = SwordAttributes.crits
	
	override val damage: DamageAttributes get() = SwordAttributes.damage
	
	override val onHit: OnHitAttributes get() = SwordAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = SwordAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = SwordAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = SwordAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = SwordAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = SwordAttributes.demoCharge
	
	override val firing: FiringAttributes get() = SwordAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SwordAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SwordAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SwordAttributes.meta
	
	override val meter: MeterAttributes get() = SwordAttributes.meter
	
	override val movement: MovementAttributes get() = SwordAttributes.movement
	
	override val heads: HeadsAttributes get() = SwordAttributes.heads
	
	override val projectiles: ProjectilesAttributes get() = SwordAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = SwordAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = SwordAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SwordAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SwordAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SwordAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = SwordAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = SwordAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SwordAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = SwordAttributes.disguise

	open class OnKillAttributes : BaseMeleeAttributes.OnKillAttributes() {
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.	Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 * 
		 * If greater than 0 on Demoman, reduces max health gained from the Knockout rune to 20.
		 */
		open val decapitateType: ItemAttributeNamed<Int> = ItemAttributeNamed("decapitate type")
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BaseMeleeAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BaseMeleeAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseMeleeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BaseMeleeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BaseMeleeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseMeleeAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BaseMeleeAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BaseMeleeAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BaseMeleeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseMeleeAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BaseMeleeAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : BaseMeleeAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseMeleeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseMeleeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BaseMeleeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseMeleeAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseMeleeAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseMeleeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseMeleeAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BaseMeleeAttributes.HeadsAttributes() 
	
	open class ProjectilesAttributes : BaseMeleeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BaseMeleeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BaseMeleeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BaseMeleeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseMeleeAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseMeleeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseMeleeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseMeleeAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BaseMeleeAttributes.ViewmodelAttributes() 
	
	open class WhenHitAttributes : BaseMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseMeleeAttributes.DisguiseAttributes() 
}