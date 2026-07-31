package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface JarMilkAttributes : JarAttributes {
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

	override val projectiles: ProjectilesAttributes get() = JarMilkAttributes.projectiles
	
	override val meter: MeterAttributes get() = JarMilkAttributes.meter
	
	override val onHit: OnHitAttributes get() = JarMilkAttributes.onHit
	
	override val ammo: AmmoAttributes get() = JarMilkAttributes.ammo
	
	override val damage: DamageAttributes get() = JarMilkAttributes.damage
	
	override val firing: FiringAttributes get() = JarMilkAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = JarMilkAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = JarMilkAttributes.buildings
	
	override val crits: CritsAttributes get() = JarMilkAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = JarMilkAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = JarMilkAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = JarMilkAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = JarMilkAttributes.meta
	
	override val movement: MovementAttributes get() = JarMilkAttributes.movement
	
	override val heads: HeadsAttributes get() = JarMilkAttributes.heads
	
	override val onKill: OnKillAttributes get() = JarMilkAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = JarMilkAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = JarMilkAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = JarMilkAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = JarMilkAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = JarMilkAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = JarMilkAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = JarMilkAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = JarMilkAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = JarMilkAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = JarMilkAttributes.disguise

	open class ProjectilesAttributes : JarAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : JarAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : JarAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class MeterAttributes : JarAttributes.MeterAttributes() 
	
	open class OnHitAttributes : JarAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : JarAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : JarAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class AmmoAttributes : JarAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : JarAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : JarAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : JarAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : JarAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : JarAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : JarAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class AfterburnAttributes : JarAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : JarAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : JarAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : JarAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : JarAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : JarAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : JarAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : JarAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : JarAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : JarAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : JarAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : JarAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MovementAttributes : JarAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : JarAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : JarAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : JarAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : JarAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : JarAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : JarAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : JarAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : JarAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : JarAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : JarAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : JarAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : JarAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : JarAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : JarAttributes.DisguiseAttributes() 
}