package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*

interface ShovelAttributes : IBlockScoped, BaseMeleeAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Damage increases as the user becomes injured"
		 * 
		 * Used to specify "shovel type".
		 * 
		 * 0 = Standard.
		 * 
		 * 1 = Equalizer.
		 * 
		 * 2 = Escape Plan.
		 * 
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEqualizer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod shovel damage boost", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "Move speed increases as the user becomes injured"
		 * 
		 * Used to specify "shovel type".
		 * 
		 * 0 = Standard.
		 * 
		 * 1 = Equalizer.
		 * 
		 * 2 = Escape Plan.
		 * 
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEscapePlan: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod shovel speed boost", NumberSelectorCodec(2))
	
		/**
		 * On primary attack, send player flying in the direction they're facing.
		 */
		val airJumpOnAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("air jump on attack")
	
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
	 * In-Game: "Damage increases as the user becomes injured"
	 * 
	 * Used to specify "shovel type".
	 * 
	 * 0 = Standard.
	 * 
	 * 1 = Equalizer.
	 * 
	 * 2 = Escape Plan.
	 * 
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEqualizer: ItemAttributeNamed<Boolean> get() = ShovelAttributes.isEqualizer
	
	/**
	 * In-Game: "Move speed increases as the user becomes injured"
	 * 
	 * Used to specify "shovel type".
	 * 
	 * 0 = Standard.
	 * 
	 * 1 = Equalizer.
	 * 
	 * 2 = Escape Plan.
	 * 
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEscapePlan: ItemAttributeNamed<Boolean> get() = ShovelAttributes.isEscapePlan
	
	/**
	 * On primary attack, send player flying in the direction they're facing.
	 */
	val airJumpOnAttack: ItemAttributeNamed<Boolean> get() = ShovelAttributes.airJumpOnAttack
	
	override val crits: CritsAttributes get() = ShovelAttributes.crits
	
	override val damage: DamageAttributes get() = ShovelAttributes.damage
	
	override val onHit: OnHitAttributes get() = ShovelAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = ShovelAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = ShovelAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = ShovelAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = ShovelAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = ShovelAttributes.demoCharge
	
	override val firing: FiringAttributes get() = ShovelAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ShovelAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ShovelAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ShovelAttributes.meta
	
	override val meter: MeterAttributes get() = ShovelAttributes.meter
	
	override val movement: MovementAttributes get() = ShovelAttributes.movement
	
	override val heads: HeadsAttributes get() = ShovelAttributes.heads
	
	override val onKill: OnKillAttributes get() = ShovelAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = ShovelAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = ShovelAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ShovelAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ShovelAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ShovelAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ShovelAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = ShovelAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ShovelAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ShovelAttributes.disguise

	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
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
	
		open class FireRateAttributes : BaseMeleeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseMeleeAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseMeleeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseMeleeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseMeleeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseMeleeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseMeleeAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseMeleeAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseMeleeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseMeleeAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BaseMeleeAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BaseMeleeAttributes.OnKillAttributes() 
	
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
	
	open class WhenHitAttributes : BaseMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseMeleeAttributes.DisguiseAttributes() 
}