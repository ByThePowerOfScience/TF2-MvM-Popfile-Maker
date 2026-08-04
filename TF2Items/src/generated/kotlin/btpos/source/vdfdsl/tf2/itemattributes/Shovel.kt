package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ShovelAttributes : IBlockScoped, BaseMeleeAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Damage increases as the user becomes injured"
		 * 
		 * Used to specify "shovel type".
		 * 
		 * 0 = Standard.
		 * 
		 * 1 = Equalizer.
		 * 
		 * 2 = Escape Plan.
		 * 
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEqualizer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod shovel damage boost", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "Move speed increases as the user becomes injured"
		 * 
		 * Used to specify "shovel type".
		 * 
		 * 0 = Standard.
		 * 
		 * 1 = Equalizer.
		 * 
		 * 2 = Escape Plan.
		 * 
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEscapePlan: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod shovel speed boost", NumberSelectorCodec(2))
	
		/**
		 * On primary attack, send player flying in the direction they're facing.
		 */
		val airJumpOnAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("air jump on attack")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
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
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}

	/**
	 * In-Game: "Damage increases as the user becomes injured"
	 * 
	 * Used to specify "shovel type".
	 * 
	 * 0 = Standard.
	 * 
	 * 1 = Equalizer.
	 * 
	 * 2 = Escape Plan.
	 * 
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEqualizer: ItemAttributeNamed<Boolean> get() = ShovelAttributes.isEqualizer
	
	/**
	 * In-Game: "Move speed increases as the user becomes injured"
	 * 
	 * Used to specify "shovel type".
	 * 
	 * 0 = Standard.
	 * 
	 * 1 = Equalizer.
	 * 
	 * 2 = Escape Plan.
	 * 
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEscapePlan: ItemAttributeNamed<Boolean> get() = ShovelAttributes.isEscapePlan
	
	/**
	 * On primary attack, send player flying in the direction they're facing.
	 */
	val airJumpOnAttack: ItemAttributeNamed<Boolean> get() = ShovelAttributes.airJumpOnAttack
	
	override val crits: CritsAttributes get() = ShovelAttributes.crits
	
	override val damage: DamageAttributes get() = ShovelAttributes.damage
	
	override val onHit: OnHitAttributes get() = ShovelAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = ShovelAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = ShovelAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = ShovelAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = ShovelAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = ShovelAttributes.demoCharge
	
	override val firing: FiringAttributes get() = ShovelAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ShovelAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ShovelAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ShovelAttributes.meta
	
	override val meter: MeterAttributes get() = ShovelAttributes.meter
	
	override val movement: MovementAttributes get() = ShovelAttributes.movement
	
	override val heads: HeadsAttributes get() = ShovelAttributes.heads
	
	override val onKill: OnKillAttributes get() = ShovelAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = ShovelAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = ShovelAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ShovelAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ShovelAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ShovelAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ShovelAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = ShovelAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ShovelAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = ShovelAttributes.buffItems
	
	override val cloak: CloakAttributes get() = ShovelAttributes.cloak
	
	override val disguise: DisguiseAttributes get() = ShovelAttributes.disguise
	
	override val hud: HudAttributes get() = ShovelAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = ShovelAttributes.spyOnly

	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseMeleeAttributes.DamageAttributes.AlienAttributes() 
	}
	
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
	
	open class HealthAndHealingAttributes : BaseMeleeAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : BaseMeleeAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : BaseMeleeAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
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
	
	open class DisguiseAttributes : BaseMeleeAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BaseMeleeAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseMeleeAttributes.SpyOnlyAttributes() 
	
	object Inherited : ShovelAttributes 
}