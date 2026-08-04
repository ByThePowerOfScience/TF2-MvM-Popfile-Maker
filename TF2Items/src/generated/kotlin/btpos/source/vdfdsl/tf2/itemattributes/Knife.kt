package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface KnifeAttributes : IBlockScoped, BaseMeleeAttributes {
	companion object : IBlockScoped {
		val damage: DamageAttributes = DamageAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * 0: Stock.
		 * 
		 * 1: Your Eternal Reward.
		 * 
		 * 2: Cloak and Dagger (idk why).
		 * 
		 * 3: Spycicle.
		 */
		val setIcicleKnifeMode: ItemAttributeNamed<Boolean> = ItemAttributeNamed("set icicle knife mode", NumberSelectorCodec(3))
	
		/**
		 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
		 */
		val meltsInFire: ItemAttributeNamed<Boolean> = ItemAttributeNamed("melts in fire")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}

	override val damage: DamageAttributes get() = KnifeAttributes.damage
	
	override val healthAndHealing: HealthAndHealingAttributes get() = KnifeAttributes.healthAndHealing
	
	override val disguise: DisguiseAttributes get() = KnifeAttributes.disguise
	
	/**
	 * 0: Stock.
	 * 
	 * 1: Your Eternal Reward.
	 * 
	 * 2: Cloak and Dagger (idk why).
	 * 
	 * 3: Spycicle.
	 */
	val setIcicleKnifeMode: ItemAttributeNamed<Boolean> get() = KnifeAttributes.setIcicleKnifeMode
	
	/**
	 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
	 */
	val meltsInFire: ItemAttributeNamed<Boolean> get() = KnifeAttributes.meltsInFire
	
	override val crits: CritsAttributes get() = KnifeAttributes.crits
	
	override val onHit: OnHitAttributes get() = KnifeAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = KnifeAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = KnifeAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = KnifeAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = KnifeAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = KnifeAttributes.demoCharge
	
	override val firing: FiringAttributes get() = KnifeAttributes.firing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = KnifeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = KnifeAttributes.meta
	
	override val meter: MeterAttributes get() = KnifeAttributes.meter
	
	override val movement: MovementAttributes get() = KnifeAttributes.movement
	
	override val heads: HeadsAttributes get() = KnifeAttributes.heads
	
	override val onKill: OnKillAttributes get() = KnifeAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = KnifeAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = KnifeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = KnifeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = KnifeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = KnifeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = KnifeAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = KnifeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = KnifeAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = KnifeAttributes.buffItems
	
	override val cloak: CloakAttributes get() = KnifeAttributes.cloak
	
	override val hud: HudAttributes get() = KnifeAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = KnifeAttributes.spyOnly

	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% damage penalty"
		 * 
		 * Neutral:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 */
		override val damage: BonusPenaltyNeutralHidden<Number, ItemAttributeNamed<Number>> get() = super.damage
	
		/**
		 * In-Game: "Increase backstab damage against Giant Robots by N%"
		 * 
		 * Spy only does 25% damage against minibosses by default.  The number here is added to that percentage, up to a max of 100% + 25% = 125%.
		 * 
		 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:  `25.0`, `50.0`, up to `100.0`.
		 * 
		 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
		 * 
		 * Checked on player.
		 */
		open val armorPiercing: ItemAttributeNamed<Number> = ItemAttributeNamed("armor piercing")
	
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseMeleeAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseMeleeAttributes.HealthAndHealingAttributes() {
		/**
		 * In-Game: "On Backstab: Absorbs the health from your victim."
		 * 
		 * Gain health on backstab.
		 */
		open val gainHealthOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sanguisuge")
	
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BaseMeleeAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BaseMeleeAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class DisguiseAttributes : BaseMeleeAttributes.DisguiseAttributes() {
		/**
		 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
		 */
		open val disguiseOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise on backstab")
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	
		open class FallingAttributes : BaseMeleeAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseMeleeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BaseMeleeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BaseMeleeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseMeleeAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BaseMeleeAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : BaseMeleeAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BaseMeleeAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BaseMeleeAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BaseMeleeAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class DemoChargeAttributes : BaseMeleeAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : BaseMeleeAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class FiringAttributes : BaseMeleeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseMeleeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class KnockbackReceivedAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseMeleeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BaseMeleeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseMeleeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseMeleeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseMeleeAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BaseMeleeAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BaseMeleeAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BaseMeleeAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BaseMeleeAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : BaseMeleeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseMeleeAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : BaseMeleeAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : BaseMeleeAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	
		open class jumpHeightAttributes : BaseMeleeAttributes.MovementAttributes.jumpHeightAttributes() 
	}
	
	open class HeadsAttributes : BaseMeleeAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BaseMeleeAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BaseMeleeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BaseMeleeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BaseMeleeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BaseMeleeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseMeleeAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : BaseMeleeAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : BaseMeleeAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : BaseMeleeAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : BaseMeleeAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BaseMeleeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseMeleeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseMeleeAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BaseMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BaseMeleeAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BaseMeleeAttributes.CloakAttributes() 
	
	open class HudAttributes : BaseMeleeAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseMeleeAttributes.SpyOnlyAttributes() 
	
	object Inherited : KnifeAttributes 
}