package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface LunchboxAttributes : IBlockScoped, WeaponBaseAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Adds +50 max health for 30 seconds"
		 * 
		 * 0 = LUNCHBOX_STANDARD.
		 * 
		 * Used for both the bonk atomic punch or the sandvich.
		 * 
		 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
		 */
		val lunchboxAddsMaxhealthBonus: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "Sets weapon mode #N"
		 * 
		 * 0 = LUNCHBOX_STANDARD.
		 * 
		 * Used for both the bonk atomic punch or the sandvich.
		 * 
		 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
		 */
		val lunchboxAddsMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lunchbox adds minicrits", NumberSelectorCodec(2))
	
		/**
		 * In-Game: "N% healing effect"
		 */
		val lunchboxHealingDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("lunchbox healing decreased")
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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
	 * In-Game: "Adds +50 max health for 30 seconds"
	 * 
	 * 0 = LUNCHBOX_STANDARD.
	 * 
	 * Used for both the bonk atomic punch or the sandvich.
	 * 
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
	 */
	val lunchboxAddsMaxhealthBonus: ItemAttributeNamed<Boolean> get() = LunchboxAttributes.lunchboxAddsMaxhealthBonus
	
	/**
	 * In-Game: "Sets weapon mode #N"
	 * 
	 * 0 = LUNCHBOX_STANDARD.
	 * 
	 * Used for both the bonk atomic punch or the sandvich.
	 * 
	 * Fun fact: LUNCHBOX_ADDS_AMMO is fully implemented.
	 */
	val lunchboxAddsMinicrits: ItemAttributeNamed<Boolean> get() = LunchboxAttributes.lunchboxAddsMinicrits
	
	/**
	 * In-Game: "N% healing effect"
	 */
	val lunchboxHealingDecreased: ItemAttributeNamed<Number> get() = LunchboxAttributes.lunchboxHealingDecreased
	
	override val afterburn: AfterburnAttributes get() = LunchboxAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = LunchboxAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = LunchboxAttributes.buildings
	
	override val crits: CritsAttributes get() = LunchboxAttributes.crits
	
	override val damage: DamageAttributes get() = LunchboxAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = LunchboxAttributes.demoCharge
	
	override val firing: FiringAttributes get() = LunchboxAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = LunchboxAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = LunchboxAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = LunchboxAttributes.meta
	
	override val meter: MeterAttributes get() = LunchboxAttributes.meter
	
	override val movement: MovementAttributes get() = LunchboxAttributes.movement
	
	override val heads: HeadsAttributes get() = LunchboxAttributes.heads
	
	override val onHit: OnHitAttributes get() = LunchboxAttributes.onHit
	
	override val onKill: OnKillAttributes get() = LunchboxAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = LunchboxAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = LunchboxAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = LunchboxAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = LunchboxAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = LunchboxAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = LunchboxAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = LunchboxAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = LunchboxAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = LunchboxAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = LunchboxAttributes.disguise

	open class AfterburnAttributes : WeaponBaseAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WeaponBaseAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WeaponBaseAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : WeaponBaseAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() 
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() 
	
	open class DemoChargeAttributes : WeaponBaseAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : WeaponBaseAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : WeaponBaseAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WeaponBaseAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WeaponBaseAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WeaponBaseAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseAttributes.MeterAttributes() 
	
	open class MovementAttributes : WeaponBaseAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : WeaponBaseAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : WeaponBaseAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : WeaponBaseAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : WeaponBaseAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : WeaponBaseAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WeaponBaseAttributes.DisguiseAttributes() 
}