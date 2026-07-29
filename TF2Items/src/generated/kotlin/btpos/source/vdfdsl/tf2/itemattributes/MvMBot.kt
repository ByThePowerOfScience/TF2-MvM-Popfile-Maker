package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface MvMBotAttributes : PlayerAttributes {
	
	companion object {
		/**
		 * If true, spawns a rocketjump particle whenever the robot jumps.
		 */
		val customJumpParticle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bot custom jump particle")
	
		/**
		 * Defaults to 50, I guess it's a percentage.
		 */
		val medicUberHealthThreshold: ItemAttributeNamed<Int> = ItemAttributeNamed("bot medic uber health threshold")
	
		/**
		 * Defaults to -1.
		 */
		val medicUberDeployDelayDuration: ItemAttributeNamed<Int> = ItemAttributeNamed("bot medic uber deploy delay duration")
	
		val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		val jumpHeight: JumpHeightAttributes = JumpHeightAttributes()
	
		val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
		val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		val onDamageTaken: OnDamageTakenAttributes = OnDamageTakenAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val denyResupply: DenyResupplyAttributes = DenyResupplyAttributes()
	
		val scoutOnly: ScoutOnlyAttributes = ScoutOnlyAttributes()
	
		val demomanOnly: DemomanOnlyAttributes = DemomanOnlyAttributes()
	
		val sniperOnly: SniperOnlyAttributes = SniperOnlyAttributes()
	
		val medicOnly: MedicOnlyAttributes = MedicOnlyAttributes()
	
		val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	}

	/**
	 * If true, spawns a rocketjump particle whenever the robot jumps.
	 */
	val customJumpParticle: ItemAttributeNamed<Boolean> get() = MvMBotAttributes.customJumpParticle
	
	/**
	 * Defaults to 50, I guess it's a percentage.
	 */
	val medicUberHealthThreshold: ItemAttributeNamed<Int> get() = MvMBotAttributes.medicUberHealthThreshold
	
	/**
	 * Defaults to -1.
	 */
	val medicUberDeployDelayDuration: ItemAttributeNamed<Int> get() = MvMBotAttributes.medicUberDeployDelayDuration
	
	override val vaccinator: VaccinatorAttributes get() = MvMBotAttributes.vaccinator
	
	override val jumpHeight: JumpHeightAttributes get() = MvMBotAttributes.jumpHeight
	
	override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes get() = MvMBotAttributes.dmgTakenFromCritReduced
	
	override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes get() = MvMBotAttributes.dmgTakenFromFireReduced
	
	override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes get() = MvMBotAttributes.dmgTakenFromBulletsReduced
	
	override val generateRageOnDamage: GenerateRageOnDamageAttributes get() = MvMBotAttributes.generateRageOnDamage
	
	override val multChargeTurnControl: MultChargeTurnControlAttributes get() = MvMBotAttributes.multChargeTurnControl
	
	override val aimingMovespeed: AimingMovespeedAttributes get() = MvMBotAttributes.aimingMovespeed
	
	override val moveSpeed: MoveSpeedAttributes get() = MvMBotAttributes.moveSpeed
	
	override val buffType: BuffTypeAttributes get() = MvMBotAttributes.buffType
	
	override val healthRegen: HealthRegenAttributes get() = MvMBotAttributes.healthRegen
	
	override val maxHealthAdditive: MaxHealthAdditiveAttributes get() = MvMBotAttributes.maxHealthAdditive
	
	override val onDamageTaken: OnDamageTakenAttributes get() = MvMBotAttributes.onDamageTaken
	
	override val onKill: OnKillAttributes get() = MvMBotAttributes.onKill
	
	override val denyResupply: DenyResupplyAttributes get() = MvMBotAttributes.denyResupply
	
	override val scoutOnly: ScoutOnlyAttributes get() = MvMBotAttributes.scoutOnly
	
	override val demomanOnly: DemomanOnlyAttributes get() = MvMBotAttributes.demomanOnly
	
	override val sniperOnly: SniperOnlyAttributes get() = MvMBotAttributes.sniperOnly
	
	override val medicOnly: MedicOnlyAttributes get() = MvMBotAttributes.medicOnly
	
	override val spyOnly: SpyOnlyAttributes get() = MvMBotAttributes.spyOnly
	
	override val buildings: BuildingsAttributes get() = MvMBotAttributes.buildings

	
	open class VaccinatorAttributes : PlayerAttributes.VaccinatorAttributes() 
	
	
	open class JumpHeightAttributes : PlayerAttributes.JumpHeightAttributes() 
	
	
	open class DmgTakenFromCritReducedAttributes : PlayerAttributes.DmgTakenFromCritReducedAttributes() 
	
	
	open class DmgTakenFromFireReducedAttributes : PlayerAttributes.DmgTakenFromFireReducedAttributes() 
	
	
	open class DmgTakenFromBulletsReducedAttributes : PlayerAttributes.DmgTakenFromBulletsReducedAttributes() 
	
	
	open class GenerateRageOnDamageAttributes : PlayerAttributes.GenerateRageOnDamageAttributes() 
	
	
	open class MultChargeTurnControlAttributes : PlayerAttributes.MultChargeTurnControlAttributes() 
	
	
	open class AimingMovespeedAttributes : PlayerAttributes.AimingMovespeedAttributes() 
	
	
	open class MoveSpeedAttributes : PlayerAttributes.MoveSpeedAttributes() 
	
	
	open class BuffTypeAttributes : PlayerAttributes.BuffTypeAttributes() 
	
	
	open class HealthRegenAttributes : PlayerAttributes.HealthRegenAttributes() 
	
	
	open class MaxHealthAdditiveAttributes : PlayerAttributes.MaxHealthAdditiveAttributes() 
	
	
	open class OnDamageTakenAttributes : PlayerAttributes.OnDamageTakenAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
	
		open class DmgTakenFromCritReducedAttributes : PlayerAttributes.OnDamageTakenAttributes.DmgTakenFromCritReducedAttributes() 
	
	
		open class DmgTakenFromFireReducedAttributes : PlayerAttributes.OnDamageTakenAttributes.DmgTakenFromFireReducedAttributes() 
	
	
		open class DmgTakenFromBulletsReducedAttributes : PlayerAttributes.OnDamageTakenAttributes.DmgTakenFromBulletsReducedAttributes() 
	}
	
	
	open class OnKillAttributes : PlayerAttributes.OnKillAttributes() 
	
	
	open class DenyResupplyAttributes : PlayerAttributes.DenyResupplyAttributes() 
	
	
	open class ScoutOnlyAttributes : PlayerAttributes.ScoutOnlyAttributes() 
	
	
	open class DemomanOnlyAttributes : PlayerAttributes.DemomanOnlyAttributes() 
	
	
	open class SniperOnlyAttributes : PlayerAttributes.SniperOnlyAttributes() 
	
	
	open class MedicOnlyAttributes : PlayerAttributes.MedicOnlyAttributes() 
	
	
	open class SpyOnlyAttributes : PlayerAttributes.SpyOnlyAttributes() 
	
	
	open class BuildingsAttributes : PlayerAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
	
		open class SentryGunAttributes : PlayerAttributes.BuildingsAttributes.SentryGunAttributes() 
	
	
		open class DispenserAttributes : PlayerAttributes.BuildingsAttributes.DispenserAttributes() 
	
	
		open class TeleporterAttributes : PlayerAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
}