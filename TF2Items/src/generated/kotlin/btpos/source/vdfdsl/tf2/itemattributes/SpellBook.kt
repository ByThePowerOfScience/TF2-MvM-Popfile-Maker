package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SpellBookAttributes : ThrowableAttributes {
	companion object : IBlockScoped {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	override val projectiles: ProjectilesAttributes get() = SpellBookAttributes.projectiles
	
	override val meter: MeterAttributes get() = SpellBookAttributes.meter
	
	override val onHit: OnHitAttributes get() = SpellBookAttributes.onHit
	
	override val ammo: AmmoAttributes get() = SpellBookAttributes.ammo
	
	override val damage: DamageAttributes get() = SpellBookAttributes.damage
	
	override val firing: FiringAttributes get() = SpellBookAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = SpellBookAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = SpellBookAttributes.buildings
	
	override val crits: CritsAttributes get() = SpellBookAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = SpellBookAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SpellBookAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SpellBookAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SpellBookAttributes.meta
	
	override val movement: MovementAttributes get() = SpellBookAttributes.movement
	
	override val heads: HeadsAttributes get() = SpellBookAttributes.heads
	
	override val onKill: OnKillAttributes get() = SpellBookAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = SpellBookAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = SpellBookAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SpellBookAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SpellBookAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SpellBookAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = SpellBookAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SpellBookAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SpellBookAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = SpellBookAttributes.disguise

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
	
	open class DamageAttributes : ThrowableAttributes.DamageAttributes() 
	
	open class FiringAttributes : ThrowableAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ThrowableAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : ThrowableAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ThrowableAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ThrowableAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ThrowableAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ThrowableAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ThrowableAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ThrowableAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ThrowableAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ThrowableAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ThrowableAttributes.MetaAttributes.ViewmodelAttributes() 
	
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
	
	open class SwapWeaponsAttributes : ThrowableAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ThrowableAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ThrowableAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ThrowableAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ThrowableAttributes.DisguiseAttributes() 
}