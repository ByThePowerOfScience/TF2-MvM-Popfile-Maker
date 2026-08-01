package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CrossbowAttributes : RocketLauncherAttributes {
	companion object : IBlockScoped {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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

	override val reloading: ReloadingAttributes get() = CrossbowAttributes.reloading
	
	override val projectiles: ProjectilesAttributes get() = CrossbowAttributes.projectiles
	
	override val ammo: AmmoAttributes get() = CrossbowAttributes.ammo
	
	override val damage: DamageAttributes get() = CrossbowAttributes.damage
	
	override val firing: FiringAttributes get() = CrossbowAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = CrossbowAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = CrossbowAttributes.buildings
	
	override val crits: CritsAttributes get() = CrossbowAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = CrossbowAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = CrossbowAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = CrossbowAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = CrossbowAttributes.meta
	
	override val meter: MeterAttributes get() = CrossbowAttributes.meter
	
	override val movement: MovementAttributes get() = CrossbowAttributes.movement
	
	override val heads: HeadsAttributes get() = CrossbowAttributes.heads
	
	override val onHit: OnHitAttributes get() = CrossbowAttributes.onHit
	
	override val onKill: OnKillAttributes get() = CrossbowAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = CrossbowAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = CrossbowAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = CrossbowAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = CrossbowAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = CrossbowAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = CrossbowAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = CrossbowAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = CrossbowAttributes.disguise

	open class ReloadingAttributes : RocketLauncherAttributes.ReloadingAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster reload time"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower reload time"
		 */
		context(attrs: IAttributeContainer)
		override var reloadTime: Number? 
			get() = super.reloadTime
			set(value) { super.reloadTime = value }
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		context(attrs: IAttributeContainer)
		override var reloadTimeIncreasedHidden: Number? 
			get() = super.reloadTimeIncreasedHidden
			set(value) { super.reloadTimeIncreasedHidden = value }
	
		/**
		 * In-Game: "+N% faster reload time"
		 */
		context(attrs: IAttributeContainer)
		override var fasterReloadRate: Number? 
			get() = super.fasterReloadRate
			set(value) { super.fasterReloadRate = value }
	}
	
	open class ProjectilesAttributes : RocketLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RocketLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RocketLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AmmoAttributes : RocketLauncherAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : RocketLauncherAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : RocketLauncherAttributes.DamageAttributes() 
	
	open class FiringAttributes : RocketLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RocketLauncherAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : RocketLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RocketLauncherAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : RocketLauncherAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : RocketLauncherAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : RocketLauncherAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : RocketLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RocketLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RocketLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : RocketLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : RocketLauncherAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : RocketLauncherAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RocketLauncherAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : RocketLauncherAttributes.MeterAttributes() 
	
	open class MovementAttributes : RocketLauncherAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : RocketLauncherAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : RocketLauncherAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : RocketLauncherAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : RocketLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : RocketLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : RocketLauncherAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : RocketLauncherAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : RocketLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RocketLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RocketLauncherAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : RocketLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RocketLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RocketLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RocketLauncherAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : RocketLauncherAttributes.DisguiseAttributes() 
}