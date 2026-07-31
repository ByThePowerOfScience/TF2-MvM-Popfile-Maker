package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ScattergunAttributes : ShotgunAttributes {
	companion object : IBlockScoped {
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

	override val onHit: OnHitAttributes get() = ScattergunAttributes.onHit
	
	override val reloading: ReloadingAttributes get() = ScattergunAttributes.reloading
	
	override val ammo: AmmoAttributes get() = ScattergunAttributes.ammo
	
	override val damage: DamageAttributes get() = ScattergunAttributes.damage
	
	override val firing: FiringAttributes get() = ScattergunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ScattergunAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ScattergunAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ScattergunAttributes.buildings
	
	override val crits: CritsAttributes get() = ScattergunAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ScattergunAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ScattergunAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ScattergunAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ScattergunAttributes.meta
	
	override val meter: MeterAttributes get() = ScattergunAttributes.meter
	
	override val movement: MovementAttributes get() = ScattergunAttributes.movement
	
	override val heads: HeadsAttributes get() = ScattergunAttributes.heads
	
	override val onKill: OnKillAttributes get() = ScattergunAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = ScattergunAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ScattergunAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ScattergunAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ScattergunAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = ScattergunAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = ScattergunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ScattergunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ScattergunAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ScattergunAttributes.disguise

	open class OnHitAttributes : ShotgunAttributes.OnHitAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Knockback on the target and shooter"
			 * 
			 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
			 */
			val scattergunHasKnockback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun has knockback")
	
			val scattergunKnockbackMult: ItemAttributeNamed<Number> = ItemAttributeNamed("scattergun knockback mult")
		}
	
		/**
		 * In-Game: "Knockback on the target and shooter"
		 * 
		 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
		 */
		context(attrs: IAttributeContainer)
		open var scattergunHasKnockback: Boolean? 
			get() = OnHitAttributes.scattergunHasKnockback.get()
			set(value) { OnHitAttributes.scattergunHasKnockback.set(value) }
	
		context(attrs: IAttributeContainer)
		open var scattergunKnockbackMult: Number? 
			get() = OnHitAttributes.scattergunKnockbackMult.get()
			set(value) { OnHitAttributes.scattergunKnockbackMult.set(value) }
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ShotgunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ShotgunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class ReloadingAttributes : ShotgunAttributes.ReloadingAttributes() {
		companion object : IBlockScoped {
			/**
			 * If 1, reloads entire clip at once.
			 */
			val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
		}
	
		/**
		 * If 1, reloads entire clip at once.
		 */
		context(attrs: IAttributeContainer)
		open var scattergunNoReloadSingle: Boolean? 
			get() = ReloadingAttributes.scattergunNoReloadSingle.get()
			set(value) { ReloadingAttributes.scattergunNoReloadSingle.set(value) }
	}
	
	open class AmmoAttributes : ShotgunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : ShotgunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : ShotgunAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : ShotgunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : ShotgunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ShotgunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : ShotgunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : ShotgunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ShotgunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ShotgunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ShotgunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ShotgunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ShotgunAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : ShotgunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : ShotgunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ShotgunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ShotgunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ShotgunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ShotgunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ShotgunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : ShotgunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ShotgunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : ShotgunAttributes.MeterAttributes() 
	
	open class MovementAttributes : ShotgunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : ShotgunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : ShotgunAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : ShotgunAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : ShotgunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : ShotgunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ShotgunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ShotgunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : ShotgunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : ShotgunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ShotgunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ShotgunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ShotgunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ShotgunAttributes.DisguiseAttributes() 
}