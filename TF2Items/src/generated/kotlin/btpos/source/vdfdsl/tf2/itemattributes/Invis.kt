package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface InvisAttributes : WeaponBaseAttributes {
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
	
	override val viewmodel: ViewmodelAttributes get() = InvisAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = InvisAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = InvisAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = InvisAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = InvisAttributes.disguise

	open class CloakAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * How many seconds it takes to decloak.
			 * 
			 * Note that values less than or equal to 0 become 1 second.
			 */
			val multDecloakRate: ItemAttributeNamed<Duration> = ItemAttributeNamed("mult decloak rate")
	
			val multCloakMeterConsumeRate: MultCloakMeterConsumeRateAttributes = MultCloakMeterConsumeRateAttributes()
	
			val multCloakMeterRegenRate: MultCloakMeterRegenRateAttributes = MultCloakMeterRegenRateAttributes()
	
			/**
			 * Disallows ammo boxes from affecting the cloak meter.
			 */
			val cloakNoRegenFromItems: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod_cloak_no_regen_from_items")
	
			/**
			 * In-Game: "No cloak meter from ammo boxes when invisible"
			 * 
			 * If true, cannot receive cloak while cloaked.
			 */
			val noCloakWhenCloaked: ItemAttributeNamed<Boolean> = ItemAttributeNamed("NoCloakWhenCloaked")
	
			/**
			 * In-Game: "N% cloak meter from ammo boxes"
			 * 
			 * Multiplier applied to cloak gained from ammo boxes.
			 */
			val reducedCloakFromAmmo: ItemAttributeNamed<Number> = ItemAttributeNamed("ReducedCloakFromAmmo")
		}
	
		/**
		 * How many seconds it takes to decloak.
		 * 
		 * Note that values less than or equal to 0 become 1 second.
		 */
		context(attrs: IAttributeContainer)
		open var multDecloakRate: Duration? 
			get() = CloakAttributes.multDecloakRate.get()
			set(value) { CloakAttributes.multDecloakRate.set(value) }
	
		/**
		 * Disallows ammo boxes from affecting the cloak meter.
		 */
		context(attrs: IAttributeContainer)
		open var cloakNoRegenFromItems: Boolean? 
			get() = CloakAttributes.cloakNoRegenFromItems.get()
			set(value) { CloakAttributes.cloakNoRegenFromItems.set(value) }
	
		/**
		 * In-Game: "No cloak meter from ammo boxes when invisible"
		 * 
		 * If true, cannot receive cloak while cloaked.
		 */
		context(attrs: IAttributeContainer)
		open var noCloakWhenCloaked: Boolean? 
			get() = CloakAttributes.noCloakWhenCloaked.get()
			set(value) { CloakAttributes.noCloakWhenCloaked.set(value) }
	
		/**
		 * In-Game: "N% cloak meter from ammo boxes"
		 * 
		 * Multiplier applied to cloak gained from ammo boxes.
		 */
		context(attrs: IAttributeContainer)
		open var reducedCloakFromAmmo: Number? 
			get() = CloakAttributes.reducedCloakFromAmmo.get()
			set(value) { CloakAttributes.reducedCloakFromAmmo.set(value) }
	
		open val multCloakMeterConsumeRate: MultCloakMeterConsumeRateAttributes = MultCloakMeterConsumeRateAttributes()
	
		open val multCloakMeterRegenRate: MultCloakMeterRegenRateAttributes = MultCloakMeterRegenRateAttributes()
	
		open class MultCloakMeterConsumeRateAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% cloak drain rate"
				 * 
				 * Multiply cloak consumed per second by this value.
				 * 
				 * Checked on player.
				 */
				val multCloakMeterConsumeRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult cloak meter consume rate")
	
				/**
				 * In-Game: "-N% cloak duration"
				 * 
				 * Multiply cloak consumed per second by this value.
				 * 
				 * Checked on player.
				 */
				val cloakConsumeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak consume rate increased")
	
				/**
				 * In-Game: "+N% cloak duration"
				 * 
				 * Multiply cloak consumed per second by this value.
				 * 
				 * Checked on player.
				 */
				val cloakConsumeRateDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak consume rate decreased")
			}
	
			/**
			 * In-Game: "+N% cloak drain rate"
			 * 
			 * Multiply cloak consumed per second by this value.
			 * 
			 * Checked on player.
			 */
			context(attrs: IAttributeContainer)
			open var multCloakMeterConsumeRate: Number? 
				get() = MultCloakMeterConsumeRateAttributes.multCloakMeterConsumeRate.get()
				set(value) { MultCloakMeterConsumeRateAttributes.multCloakMeterConsumeRate.set(value) }
	
			/**
			 * In-Game: "-N% cloak duration"
			 * 
			 * Multiply cloak consumed per second by this value.
			 * 
			 * Checked on player.
			 */
			context(attrs: IAttributeContainer)
			open var cloakConsumeRateIncreased: Number? 
				get() = MultCloakMeterConsumeRateAttributes.cloakConsumeRateIncreased.get()
				set(value) { MultCloakMeterConsumeRateAttributes.cloakConsumeRateIncreased.set(value) }
	
			/**
			 * In-Game: "+N% cloak duration"
			 * 
			 * Multiply cloak consumed per second by this value.
			 * 
			 * Checked on player.
			 */
			context(attrs: IAttributeContainer)
			open var cloakConsumeRateDecreased: Number? 
				get() = MultCloakMeterConsumeRateAttributes.cloakConsumeRateDecreased.get()
				set(value) { MultCloakMeterConsumeRateAttributes.cloakConsumeRateDecreased.set(value) }
		}
	
		open class MultCloakMeterRegenRateAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% cloak regen rate"
				 */
				val multCloakMeterRegenRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult cloak meter regen rate")
	
				/**
				 * In-Game: "+N% cloak regeneration rate"
				 */
				val cloakRegenRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak regen rate increased")
	
				/**
				 * In-Game: "N% cloak regeneration rate"
				 */
				val cloakRegenRateDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("cloak regen rate decreased")
			}
	
			/**
			 * In-Game: "+N% cloak regen rate"
			 */
			context(attrs: IAttributeContainer)
			open var multCloakMeterRegenRate: Number? 
				get() = MultCloakMeterRegenRateAttributes.multCloakMeterRegenRate.get()
				set(value) { MultCloakMeterRegenRateAttributes.multCloakMeterRegenRate.set(value) }
	
			/**
			 * In-Game: "+N% cloak regeneration rate"
			 */
			context(attrs: IAttributeContainer)
			open var cloakRegenRateIncreased: Number? 
				get() = MultCloakMeterRegenRateAttributes.cloakRegenRateIncreased.get()
				set(value) { MultCloakMeterRegenRateAttributes.cloakRegenRateIncreased.set(value) }
	
			/**
			 * In-Game: "N% cloak regeneration rate"
			 */
			context(attrs: IAttributeContainer)
			open var cloakRegenRateDecreased: Number? 
				get() = MultCloakMeterRegenRateAttributes.cloakRegenRateDecreased.get()
				set(value) { MultCloakMeterRegenRateAttributes.cloakRegenRateDecreased.set(value) }
		}
	}
	
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