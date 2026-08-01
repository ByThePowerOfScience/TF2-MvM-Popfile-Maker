package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface StickBombAttributes : BreakableMeleeAttributes {
	companion object : IBlockScoped {
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	/**
	 * In-Game: "Pumpkin Bombs"
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = StickBombAttributes.spellHalloweenPumpkinExplosions.get()
	
	override val crits: CritsAttributes get() = StickBombAttributes.crits
	
	override val damage: DamageAttributes get() = StickBombAttributes.damage
	
	override val onHit: OnHitAttributes get() = StickBombAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = StickBombAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = StickBombAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = StickBombAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = StickBombAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = StickBombAttributes.demoCharge
	
	override val firing: FiringAttributes get() = StickBombAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = StickBombAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = StickBombAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = StickBombAttributes.meta
	
	override val meter: MeterAttributes get() = StickBombAttributes.meter
	
	override val movement: MovementAttributes get() = StickBombAttributes.movement
	
	override val heads: HeadsAttributes get() = StickBombAttributes.heads
	
	override val onKill: OnKillAttributes get() = StickBombAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = StickBombAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = StickBombAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = StickBombAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = StickBombAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = StickBombAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = StickBombAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = StickBombAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = StickBombAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = StickBombAttributes.disguise

	open class CritsAttributes : BreakableMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BreakableMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BreakableMeleeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BreakableMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BreakableMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BreakableMeleeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BreakableMeleeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BreakableMeleeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BreakableMeleeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BreakableMeleeAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BreakableMeleeAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BreakableMeleeAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BreakableMeleeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BreakableMeleeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BreakableMeleeAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BreakableMeleeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BreakableMeleeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BreakableMeleeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BreakableMeleeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BreakableMeleeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BreakableMeleeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BreakableMeleeAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BreakableMeleeAttributes.MeterAttributes() 
	
	open class MovementAttributes : BreakableMeleeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BreakableMeleeAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BreakableMeleeAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BreakableMeleeAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BreakableMeleeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BreakableMeleeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BreakableMeleeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BreakableMeleeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BreakableMeleeAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BreakableMeleeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BreakableMeleeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BreakableMeleeAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BreakableMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BreakableMeleeAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BreakableMeleeAttributes.DisguiseAttributes() 
}