package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ProjectileGrenadeAttributes : WeaponBaseAttributes {
	companion object {
		/**
		 * Checked on launcher.
		 */
		val useLargeSmokeExplosion: ItemAttributeNamed<Boolean> = ItemAttributeNamed("use large smoke explosion")
	
		/**
		 * In-Game: "Pumpkin Bombs"
		 * 
		 * Checked on launcher.
		 */
		val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween pumpkin explosions")
	
		val blastRadius: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Blast radius increased"),
			ItemAttributeNamed("Blast radius decreased"),
		)
	
		/**
		 * In-Game: "N% fuse time on grenades"
		 * 
		 * Checked on owner.
		 */
		val fuseBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("fuse bonus")
	
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
	 * Checked on launcher.
	 */
	val useLargeSmokeExplosion: ItemAttributeNamed<Boolean> get() = ProjectileGrenadeAttributes.useLargeSmokeExplosion
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Checked on launcher.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = ProjectileGrenadeAttributes.spellHalloweenPumpkinExplosions
	
	val blastRadius: BonusPenalty<Float> get() = ProjectileGrenadeAttributes.blastRadius
	
	/**
	 * In-Game: "N% fuse time on grenades"
	 * 
	 * Checked on owner.
	 */
	val fuseBonus: ItemAttributeNamed<Float> get() = ProjectileGrenadeAttributes.fuseBonus
	
	override val afterburn: AfterburnAttributes get() = ProjectileGrenadeAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = ProjectileGrenadeAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = ProjectileGrenadeAttributes.buildings
	
	override val crits: CritsAttributes get() = ProjectileGrenadeAttributes.crits
	
	override val damage: DamageAttributes get() = ProjectileGrenadeAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = ProjectileGrenadeAttributes.demoCharge
	
	override val firing: FiringAttributes get() = ProjectileGrenadeAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ProjectileGrenadeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ProjectileGrenadeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ProjectileGrenadeAttributes.meta
	
	override val meter: MeterAttributes get() = ProjectileGrenadeAttributes.meter
	
	override val movement: MovementAttributes get() = ProjectileGrenadeAttributes.movement
	
	override val heads: HeadsAttributes get() = ProjectileGrenadeAttributes.heads
	
	override val onHit: OnHitAttributes get() = ProjectileGrenadeAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ProjectileGrenadeAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = ProjectileGrenadeAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = ProjectileGrenadeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ProjectileGrenadeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ProjectileGrenadeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ProjectileGrenadeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ProjectileGrenadeAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = ProjectileGrenadeAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = ProjectileGrenadeAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ProjectileGrenadeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ProjectileGrenadeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ProjectileGrenadeAttributes.disguise

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
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
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