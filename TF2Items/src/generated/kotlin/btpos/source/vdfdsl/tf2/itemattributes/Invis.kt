package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface InvisAttributes : IBlockScoped, WeaponBaseAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
		 * 
		 * Used to specify "invis type".
		 */
		val setCloakIsFeignDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("set cloak is feign death", NumberSelectorCodec(2))
	
		/**
		 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
		 * 
		 * Used to specify "invis type".
		 */
		val setCloakIsMovementBased: ItemAttributeNamed<Boolean> = ItemAttributeNamed("set cloak is movement based", NumberSelectorCodec(1))
	
		val cloak: CloakAttributes = CloakAttributes()
	
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
	 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
	 * 
	 * Used to specify "invis type".
	 */
	val setCloakIsFeignDeath: ItemAttributeNamed<Boolean> get() = InvisAttributes.setCloakIsFeignDeath
	
	/**
	 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
	 * 
	 * Used to specify "invis type".
	 */
	val setCloakIsMovementBased: ItemAttributeNamed<Boolean> get() = InvisAttributes.setCloakIsMovementBased
	
	val cloak: CloakAttributes get() = InvisAttributes.cloak
	
	override val afterburn: AfterburnAttributes get() = InvisAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = InvisAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = InvisAttributes.buildings
	
	override val crits: CritsAttributes get() = InvisAttributes.crits
	
	override val damage: DamageAttributes get() = InvisAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = InvisAttributes.demoCharge
	
	override val firing: FiringAttributes get() = InvisAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = InvisAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = InvisAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = InvisAttributes.meta
	
	override val meter: MeterAttributes get() = InvisAttributes.meter
	
	override val movement: MovementAttributes get() = InvisAttributes.movement
	
	override val heads: HeadsAttributes get() = InvisAttributes.heads
	
	override val onHit: OnHitAttributes get() = InvisAttributes.onHit
	
	override val onKill: OnKillAttributes get() = InvisAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = InvisAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = InvisAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = InvisAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = InvisAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = InvisAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = InvisAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = InvisAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = InvisAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = InvisAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = InvisAttributes.disguise

	open class CloakAttributes : IBlockScoped {
		/**
		 * How many seconds it takes to decloak.
		 * 
		 * Note that values less than or equal to 0 become 1 second.
		 */
		open val multDecloakRate: ItemAttributeNamed<Duration> = ItemAttributeNamed("mult decloak rate")
	
		open val multCloakMeterConsumeRate: MultCloakMeterConsumeRateAttributes = MultCloakMeterConsumeRateAttributes()
	
		open val multCloakMeterRegenRate: MultCloakMeterRegenRateAttributes = MultCloakMeterRegenRateAttributes()
	
		/**
		 * Disallows ammo boxes from affecting the cloak meter.
		 */
		open val cloakNoRegenFromItems: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod_cloak_no_regen_from_items")
	
		/**
		 * In-Game: "No cloak meter from ammo boxes when invisible"
		 * 
		 * If true, cannot receive cloak while cloaked.
		 */
		open val noCloakWhenCloaked: ItemAttributeNamed<Boolean> = ItemAttributeNamed("NoCloakWhenCloaked")
	
		/**
		 * In-Game: "N% cloak meter from ammo boxes"
		 * 
		 * Multiplier applied to cloak gained from ammo boxes.
		 */
		open val reducedCloakFromAmmo: ItemAttributeNamed<Number> = ItemAttributeNamed("ReducedCloakFromAmmo")
	
		open class MultCloakMeterConsumeRateAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% cloak drain rate"
			 * 
			 * Multiply cloak consumed per second by this value.
			 * 
			 * Checked on player.
			 */
			open val multCloakMeterConsumeRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult cloak meter consume rate")
	
			/**
			 * In-Game: "-N% cloak duration"
			 * 
			 * Multiply cloak consumed per second by this value.
			 * 
			 * Checked on player.
			 */
			open val cloakConsumeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak consume rate increased")
	
			/**
			 * In-Game: "+N% cloak duration"
			 * 
			 * Multiply cloak consumed per second by this value.
			 * 
			 * Checked on player.
			 */
			open val cloakConsumeRateDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak consume rate decreased")
		}
	
		open class MultCloakMeterRegenRateAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% cloak regen rate"
			 */
			open val multCloakMeterRegenRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult cloak meter regen rate")
	
			/**
			 * In-Game: "+N% cloak regeneration rate"
			 */
			open val cloakRegenRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak regen rate increased")
	
			/**
			 * In-Game: "N% cloak regeneration rate"
			 */
			open val cloakRegenRateDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak regen rate decreased")
		}
	}
	
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