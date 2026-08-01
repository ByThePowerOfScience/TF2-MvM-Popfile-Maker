package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface StickybombLauncherAttributes : BaseGunAttributes {
	companion object : IBlockScoped {
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
	 * In-Game: "Max charge time decreased by N%"
	 * 
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	val stickybombChargeRate: ItemAttributeNamed<Number> get() = StickybombLauncherAttributes.stickybombChargeRate.get()
	
	/**
	 * In-Game: "Able to destroy enemy stickybomb"
	 * 
	 * If 1, stickies destroy other stickies.
	 */
	val stickiesDetonateStickies: ItemAttributeNamed<Boolean> get() = StickybombLauncherAttributes.stickiesDetonateStickies.get()
	
	/**
	 * In-Game: "Up to +N% damage based on charge"
	 * 
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
	 */
	val stickybombChargeDamageIncrease: ItemAttributeNamed<Number> get() = StickybombLauncherAttributes.stickybombChargeDamageIncrease.get()
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N max stickybombs out"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N max stickybombs out"
	 */
	val maxStickies: BonusPenalty<Int> get() = StickybombLauncherAttributes.maxStickies.get()
	
	override val ammo: AmmoAttributes get() = StickybombLauncherAttributes.ammo
	
	override val damage: DamageAttributes get() = StickybombLauncherAttributes.damage
	
	override val firing: FiringAttributes get() = StickybombLauncherAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = StickybombLauncherAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = StickybombLauncherAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = StickybombLauncherAttributes.buildings
	
	override val crits: CritsAttributes get() = StickybombLauncherAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = StickybombLauncherAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = StickybombLauncherAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = StickybombLauncherAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = StickybombLauncherAttributes.meta
	
	override val meter: MeterAttributes get() = StickybombLauncherAttributes.meter
	
	override val movement: MovementAttributes get() = StickybombLauncherAttributes.movement
	
	override val heads: HeadsAttributes get() = StickybombLauncherAttributes.heads
	
	override val onHit: OnHitAttributes get() = StickybombLauncherAttributes.onHit
	
	override val onKill: OnKillAttributes get() = StickybombLauncherAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = StickybombLauncherAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = StickybombLauncherAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = StickybombLauncherAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = StickybombLauncherAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = StickybombLauncherAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = StickybombLauncherAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = StickybombLauncherAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = StickybombLauncherAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = StickybombLauncherAttributes.disguise

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