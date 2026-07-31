package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface CompoundBowAttributes : StickybombLauncherAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * Mult applied to reload speed.
		 */
		val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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

	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult applied to reload speed.
	 */
	val fasterReloadRate: ItemAttributeNamed<Number> get() = CompoundBowAttributes.fasterReloadRate
	
	override val ammo: AmmoAttributes get() = CompoundBowAttributes.ammo
	
	override val damage: DamageAttributes get() = CompoundBowAttributes.damage
	
	override val firing: FiringAttributes get() = CompoundBowAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = CompoundBowAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = CompoundBowAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = CompoundBowAttributes.buildings
	
	override val crits: CritsAttributes get() = CompoundBowAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = CompoundBowAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = CompoundBowAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = CompoundBowAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = CompoundBowAttributes.meta
	
	override val meter: MeterAttributes get() = CompoundBowAttributes.meter
	
	override val movement: MovementAttributes get() = CompoundBowAttributes.movement
	
	override val heads: HeadsAttributes get() = CompoundBowAttributes.heads
	
	override val onHit: OnHitAttributes get() = CompoundBowAttributes.onHit
	
	override val onKill: OnKillAttributes get() = CompoundBowAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = CompoundBowAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = CompoundBowAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = CompoundBowAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = CompoundBowAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = CompoundBowAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = CompoundBowAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = CompoundBowAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = CompoundBowAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = CompoundBowAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = CompoundBowAttributes.disguise

	open class AmmoAttributes : StickybombLauncherAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : StickybombLauncherAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : StickybombLauncherAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : StickybombLauncherAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : StickybombLauncherAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : StickybombLauncherAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : StickybombLauncherAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : StickybombLauncherAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : StickybombLauncherAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : StickybombLauncherAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : StickybombLauncherAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : StickybombLauncherAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : StickybombLauncherAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : StickybombLauncherAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : StickybombLauncherAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : StickybombLauncherAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : StickybombLauncherAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : StickybombLauncherAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : StickybombLauncherAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : StickybombLauncherAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : StickybombLauncherAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : StickybombLauncherAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : StickybombLauncherAttributes.MeterAttributes() 
	
	open class MovementAttributes : StickybombLauncherAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : StickybombLauncherAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : StickybombLauncherAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : StickybombLauncherAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : StickybombLauncherAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : StickybombLauncherAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : StickybombLauncherAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : StickybombLauncherAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : StickybombLauncherAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : StickybombLauncherAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : StickybombLauncherAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : StickybombLauncherAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : StickybombLauncherAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : StickybombLauncherAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : StickybombLauncherAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : StickybombLauncherAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : StickybombLauncherAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : StickybombLauncherAttributes.DisguiseAttributes() 
}