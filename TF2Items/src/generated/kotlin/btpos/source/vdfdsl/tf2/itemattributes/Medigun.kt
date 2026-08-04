package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface MedigunAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% heal rate"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% heal rate"
		 */
		val healRate: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("heal rate bonus"),
			ItemAttributeNamed("heal rate penalty"),
		)
	
		/**
		 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
		 * 
		 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
		 * 
		 * Checked on player.
		 */
		val preserveUbercharge: ItemAttributeNamed<Int> = ItemAttributeNamed("preserve ubercharge")
	
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 */
		val healingMastery: ItemAttributeNamed<Int> = ItemAttributeNamed("healing mastery")
	
		val giveCrits: GiveCritsAttributes = GiveCritsAttributes()
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% max overheal"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% max overheal"
		 */
		val overheal: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("overheal bonus"),
			ItemAttributeNamed("overheal penalty"),
		)
	
		val overhealDecay: OverhealDecayAttributes = OverhealDecayAttributes()
	
		/**
		 * In-Game: "+25% more overheal, +50% longer duration per point"
		 * 
		 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
		 * 
		 * decay mult is same but divided by 2.
		 * 
		 * Checked on owner.
		 */
		val overhealExpert: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal expert")
	
		/**
		 * In-Game: "N% ÜberCharge rate on Overhealed patients"
		 * 
		 * Checked on owner.
		 */
		val uberchargeOverhealRatePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("ubercharge overheal rate penalty")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% ÜberCharge rate"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% ÜberCharge rate"
		 */
		val uberchargeRate: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("ubercharge rate bonus"),
			ItemAttributeNamed("ubercharge rate penalty"),
		)
	
		/**
		 * In-Game: "Über duration increased N seconds"
		 * 
		 * Checked on owner.
		 */
		val uberDurationBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("uber duration bonus")
	
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * This is your shield level.
		 * 
		 * Checked on owner.
		 */
		val generateRageOnHeal: ItemAttributeNamed<Int> = ItemAttributeNamed("generate rage on heal")
	
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
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}

	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% heal rate"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% heal rate"
	 */
	val healRate: BonusPenalty<Number> get() = MedigunAttributes.healRate
	
	/**
	 * In-Game: "On death up to N% of your stored ÜberCharge is retained"
	 * 
	 * Percentage saved on death or dropping weapon (e.g. `25` = 25% uber).
	 * 
	 * Checked on player.
	 */
	val preserveUbercharge: ItemAttributeNamed<Int> get() = MedigunAttributes.preserveUbercharge
	
	/**
	 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
	 */
	val healingMastery: ItemAttributeNamed<Int> get() = MedigunAttributes.healingMastery
	
	val giveCrits: GiveCritsAttributes get() = MedigunAttributes.giveCrits
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% max overheal"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% max overheal"
	 */
	val overheal: BonusPenalty<Number> get() = MedigunAttributes.overheal
	
	val overhealDecay: OverhealDecayAttributes get() = MedigunAttributes.overhealDecay
	
	/**
	 * In-Game: "+25% more overheal, +50% longer duration per point"
	 * 
	 * Overheal bonus = overheal bonus + overhealexpert/4 or just overheal bonus, whichever is higher.
	 * 
	 * decay mult is same but divided by 2.
	 * 
	 * Checked on owner.
	 */
	val overhealExpert: ItemAttributeNamed<Number> get() = MedigunAttributes.overhealExpert
	
	/**
	 * In-Game: "N% ÜberCharge rate on Overhealed patients"
	 * 
	 * Checked on owner.
	 */
	val uberchargeOverhealRatePenalty: ItemAttributeNamed<Number> get() = MedigunAttributes.uberchargeOverhealRatePenalty
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% ÜberCharge rate"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% ÜberCharge rate"
	 */
	val uberchargeRate: BonusPenalty<Number> get() = MedigunAttributes.uberchargeRate
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 * 
	 * Checked on owner.
	 */
	val uberDurationBonus: ItemAttributeNamed<Int> get() = MedigunAttributes.uberDurationBonus
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 * 
	 * This is your shield level.
	 * 
	 * Checked on owner.
	 */
	val generateRageOnHeal: ItemAttributeNamed<Int> get() = MedigunAttributes.generateRageOnHeal
	
	override val ammo: AmmoAttributes get() = MedigunAttributes.ammo
	
	override val damage: DamageAttributes get() = MedigunAttributes.damage
	
	override val firing: FiringAttributes get() = MedigunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = MedigunAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = MedigunAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = MedigunAttributes.buildings
	
	override val crits: CritsAttributes get() = MedigunAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = MedigunAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = MedigunAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = MedigunAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = MedigunAttributes.meta
	
	override val meter: MeterAttributes get() = MedigunAttributes.meter
	
	override val movement: MovementAttributes get() = MedigunAttributes.movement
	
	override val heads: HeadsAttributes get() = MedigunAttributes.heads
	
	override val onHit: OnHitAttributes get() = MedigunAttributes.onHit
	
	override val onKill: OnKillAttributes get() = MedigunAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = MedigunAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = MedigunAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = MedigunAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = MedigunAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = MedigunAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = MedigunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = MedigunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = MedigunAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = MedigunAttributes.buffItems
	
	override val cloak: CloakAttributes get() = MedigunAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = MedigunAttributes.disguise
	
	override val hud: HudAttributes get() = MedigunAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = MedigunAttributes.spyOnly

	open class GiveCritsAttributes : IBlockScoped {
		/**
		 * In-Game: "ÜberCharge grants 100% critical chance"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val giveCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is crit boost", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "ÜberCharge increases healing to 300% and grants immunity to movement-impairing effects"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val medigunChargeIsMegaheal: ItemAttributeNamed<Int> = ItemAttributeNamed("medigun charge is megaheal")
	
		/**
		 * In-Game: "Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type."
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		open val giveResistanceType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is resists", NumberSelectorCodec(3))
	}
	
	open class OverhealDecayAttributes : IBlockScoped {
		/**
		 * In-Game: "N% shorter overheal time"
		 */
		open val overhealDecayPenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay penalty")
	
		/**
		 * In-Game: "+N% longer overheal time"
		 */
		open val overhealDecayBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay bonus")
	
		/**
		 * In-Game: "Overheal bonus doesn't decay"
		 */
		open val overhealDecayDisabled: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay disabled")
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BaseGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
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
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BaseGunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BaseGunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BaseGunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BaseGunAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BaseGunAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BaseGunAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BaseGunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BaseGunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BaseGunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BaseGunAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BaseGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BaseGunAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BaseGunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BaseGunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BaseGunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BaseGunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseGunAttributes.SpyOnlyAttributes() 
	
	object Inherited : MedigunAttributes 
}