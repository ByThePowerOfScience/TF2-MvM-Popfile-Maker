package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration



interface LunchboxAttributes : WeaponBaseAttributes {
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
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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
	
	override val viewmodel: ViewmodelAttributes get() = LunchboxAttributes.viewmodel
	
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
	
	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : WeaponBaseAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class DemoChargeAttributes : WeaponBaseAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : WeaponBaseAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : WeaponBaseAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
	
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
	
	open class ViewmodelAttributes : WeaponBaseAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WeaponBaseAttributes.DisguiseAttributes() 
}