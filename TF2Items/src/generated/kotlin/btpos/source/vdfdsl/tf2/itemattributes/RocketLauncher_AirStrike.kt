package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface RocketLauncher_AirStrikeAttributes : RocketLauncherAttributes {
	companion object : IBlockScoped {
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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

	override val ammo: AmmoAttributes get() = RocketLauncher_AirStrikeAttributes.ammo
	
	override val projectiles: ProjectilesAttributes get() = RocketLauncher_AirStrikeAttributes.projectiles
	
	override val damage: DamageAttributes get() = RocketLauncher_AirStrikeAttributes.damage
	
	override val firing: FiringAttributes get() = RocketLauncher_AirStrikeAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = RocketLauncher_AirStrikeAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = RocketLauncher_AirStrikeAttributes.buildings
	
	override val crits: CritsAttributes get() = RocketLauncher_AirStrikeAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = RocketLauncher_AirStrikeAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = RocketLauncher_AirStrikeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = RocketLauncher_AirStrikeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = RocketLauncher_AirStrikeAttributes.meta
	
	override val meter: MeterAttributes get() = RocketLauncher_AirStrikeAttributes.meter
	
	override val movement: MovementAttributes get() = RocketLauncher_AirStrikeAttributes.movement
	
	override val heads: HeadsAttributes get() = RocketLauncher_AirStrikeAttributes.heads
	
	override val onHit: OnHitAttributes get() = RocketLauncher_AirStrikeAttributes.onHit
	
	override val onKill: OnKillAttributes get() = RocketLauncher_AirStrikeAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = RocketLauncher_AirStrikeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = RocketLauncher_AirStrikeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = RocketLauncher_AirStrikeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = RocketLauncher_AirStrikeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = RocketLauncher_AirStrikeAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = RocketLauncher_AirStrikeAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = RocketLauncher_AirStrikeAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = RocketLauncher_AirStrikeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = RocketLauncher_AirStrikeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = RocketLauncher_AirStrikeAttributes.disguise

	open class AmmoAttributes : RocketLauncherAttributes.AmmoAttributes() {
		companion object : IBlockScoped 
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : RocketLauncherAttributes.AmmoAttributes.ClipSizeAttributes() {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Clip size increased on kill"
			 * 
			 * This attribute is on all weapons, but it's specifically checked for on the Air Strike.
			 */
			context(attrs: IAttributeContainer)
			override var clipsizeIncreaseOnKill: Int? 
				get() = super.clipsizeIncreaseOnKill
				set(value) { super.clipsizeIncreaseOnKill = value }
		}
	}
	
	open class ProjectilesAttributes : RocketLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RocketLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RocketLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class DamageAttributes : RocketLauncherAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : RocketLauncherAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : RocketLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RocketLauncherAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : RocketLauncherAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class AfterburnAttributes : RocketLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RocketLauncherAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : RocketLauncherAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : RocketLauncherAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : RocketLauncherAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : RocketLauncherAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : RocketLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RocketLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RocketLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : RocketLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
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
	
	open class ReloadingAttributes : RocketLauncherAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : RocketLauncherAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : RocketLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RocketLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RocketLauncherAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : RocketLauncherAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : RocketLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RocketLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RocketLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RocketLauncherAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : RocketLauncherAttributes.DisguiseAttributes() 
}