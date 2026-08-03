package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface FlareGunAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
		 * 
		 * 0: Normal.
		 * 
		 * 1: Detonator.
		 * 
		 * 2: Manmelter.
		 * 
		 * 3: Scorch Shot.
		 */
		val flaregunFiresPelletsWithKnockback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
	
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
	 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
	 * 
	 * 0: Normal.
	 * 
	 * 1: Detonator.
	 * 
	 * 2: Manmelter.
	 * 
	 * 3: Scorch Shot.
	 */
	val flaregunFiresPelletsWithKnockback: ItemAttributeNamed<Boolean> get() = FlareGunAttributes.flaregunFiresPelletsWithKnockback
	
	override val ammo: AmmoAttributes get() = FlareGunAttributes.ammo
	
	override val damage: DamageAttributes get() = FlareGunAttributes.damage
	
	override val firing: FiringAttributes get() = FlareGunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = FlareGunAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = FlareGunAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = FlareGunAttributes.buildings
	
	override val crits: CritsAttributes get() = FlareGunAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = FlareGunAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = FlareGunAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = FlareGunAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = FlareGunAttributes.meta
	
	override val meter: MeterAttributes get() = FlareGunAttributes.meter
	
	override val movement: MovementAttributes get() = FlareGunAttributes.movement
	
	override val heads: HeadsAttributes get() = FlareGunAttributes.heads
	
	override val onHit: OnHitAttributes get() = FlareGunAttributes.onHit
	
	override val onKill: OnKillAttributes get() = FlareGunAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = FlareGunAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = FlareGunAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = FlareGunAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = FlareGunAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = FlareGunAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = FlareGunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = FlareGunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = FlareGunAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = FlareGunAttributes.disguise

	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
}