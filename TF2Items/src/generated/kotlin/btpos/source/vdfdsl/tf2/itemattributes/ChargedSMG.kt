package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*

interface ChargedSMGAttributes : IBlockScoped, SMGAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
		 * 
		 * Minicrit buff duration.
		 */
		val minicritBoostWhenCharged: ItemAttributeNamed<Number> = ItemAttributeNamed("minicrit_boost_when_charged")
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
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

	/**
	 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
	 * 
	 * Minicrit buff duration.
	 */
	val minicritBoostWhenCharged: ItemAttributeNamed<Number> get() = ChargedSMGAttributes.minicritBoostWhenCharged
	
	override val ammo: AmmoAttributes get() = ChargedSMGAttributes.ammo
	
	override val damage: DamageAttributes get() = ChargedSMGAttributes.damage
	
	override val firing: FiringAttributes get() = ChargedSMGAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ChargedSMGAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ChargedSMGAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ChargedSMGAttributes.buildings
	
	override val crits: CritsAttributes get() = ChargedSMGAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ChargedSMGAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ChargedSMGAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ChargedSMGAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ChargedSMGAttributes.meta
	
	override val meter: MeterAttributes get() = ChargedSMGAttributes.meter
	
	override val movement: MovementAttributes get() = ChargedSMGAttributes.movement
	
	override val heads: HeadsAttributes get() = ChargedSMGAttributes.heads
	
	override val onHit: OnHitAttributes get() = ChargedSMGAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ChargedSMGAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ChargedSMGAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ChargedSMGAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ChargedSMGAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ChargedSMGAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ChargedSMGAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ChargedSMGAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ChargedSMGAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ChargedSMGAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ChargedSMGAttributes.disguise

	open class AmmoAttributes : SMGAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : SMGAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : SMGAttributes.DamageAttributes() 
	
	open class FiringAttributes : SMGAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : SMGAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : SMGAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : SMGAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : SMGAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : SMGAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : SMGAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : SMGAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : SMGAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : SMGAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : SMGAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : SMGAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : SMGAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : SMGAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : SMGAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : SMGAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : SMGAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : SMGAttributes.MeterAttributes() 
	
	open class MovementAttributes : SMGAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : SMGAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : SMGAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : SMGAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : SMGAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : SMGAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : SMGAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : SMGAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : SMGAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : SMGAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : SMGAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : SMGAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : SMGAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : SMGAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : SMGAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : SMGAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : SMGAttributes.DisguiseAttributes() 
}