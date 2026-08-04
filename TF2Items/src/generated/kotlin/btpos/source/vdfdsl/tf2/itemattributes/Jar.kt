package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*

interface JarAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
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

	override val projectiles: ProjectilesAttributes get() = JarAttributes.projectiles
	
	override val meter: MeterAttributes get() = JarAttributes.meter
	
	override val onHit: OnHitAttributes get() = JarAttributes.onHit
	
	override val ammo: AmmoAttributes get() = JarAttributes.ammo
	
	override val damage: DamageAttributes get() = JarAttributes.damage
	
	override val firing: FiringAttributes get() = JarAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = JarAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = JarAttributes.buildings
	
	override val crits: CritsAttributes get() = JarAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = JarAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = JarAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = JarAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = JarAttributes.meta
	
	override val movement: MovementAttributes get() = JarAttributes.movement
	
	override val heads: HeadsAttributes get() = JarAttributes.heads
	
	override val onKill: OnKillAttributes get() = JarAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = JarAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = JarAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = JarAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = JarAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = JarAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = JarAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = JarAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = JarAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = JarAttributes.disguise

	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 * 
		 * Used to select the model.
		 * 
		 * Select between `TF_PROJECTILE_FESTIVE_JAR`, `TF_PROJECTILE_BREADMONSTER_JARATE`, and `TF_PROJECTILE_BREADMONSTER_MADMILK`.
		 * 
		 * Otherwise uses default for its class.
		 */
		override val overrideProjectileType: ItemAttributeNamed<TFProjectileType> get() = super.overrideProjectileType
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() {
		/**
		 * In-Game: "Extinguishing teammates reduces cooldown by N%"
		 * 
		 * Subtracts this value from the cooldown.
		 */
		open val extinguishReducesCooldown: ItemAttributeNamed<Number> = ItemAttributeNamed("extinguish reduces cooldown")
	}
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		/**
		 * In-Game: "N% movement speed on targets"
		 * 
		 * If NOT `1.0`, stun the victim.
		 * 
		 * Checked on player.
		 */
		open val appliesSnareEffect: ItemAttributeNamed<Number> = ItemAttributeNamed("applies snare effect")
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
}