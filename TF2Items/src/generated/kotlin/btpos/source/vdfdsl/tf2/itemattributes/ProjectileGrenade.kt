package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*

interface ProjectileGrenadeAttributes : IBlockScoped, WeaponBaseAttributes {
	companion object : IBlockScoped {
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
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% explosion radius"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% explosion radius"
		 */
		val blastRadius: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("Blast radius increased"),
			ItemAttributeNamed("Blast radius decreased"),
		)
	
		/**
		 * In-Game: "N% fuse time on grenades"
		 * 
		 * Checked on owner.
		 */
		val fuseBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("fuse bonus")
	
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
	 * Checked on launcher.
	 */
	val useLargeSmokeExplosion: ItemAttributeNamed<Boolean> get() = ProjectileGrenadeAttributes.useLargeSmokeExplosion
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Checked on launcher.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = ProjectileGrenadeAttributes.spellHalloweenPumpkinExplosions
	
	/**
	 * Bonus:
	 * 
	 * 	- In-Game: "+N% explosion radius"
	 * 
	 * Penalty:
	 * 
	 * 	- In-Game: "N% explosion radius"
	 */
	val blastRadius: BonusPenalty<Number> get() = ProjectileGrenadeAttributes.blastRadius
	
	/**
	 * In-Game: "N% fuse time on grenades"
	 * 
	 * Checked on owner.
	 */
	val fuseBonus: ItemAttributeNamed<Number> get() = ProjectileGrenadeAttributes.fuseBonus
	
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