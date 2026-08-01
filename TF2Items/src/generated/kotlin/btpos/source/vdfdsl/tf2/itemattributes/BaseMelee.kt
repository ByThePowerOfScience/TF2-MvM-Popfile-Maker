package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseMeleeAttributes : WeaponBaseAttributes {
	companion object : IBlockScoped {
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
	
		/**
		 * In-Game: "Always critical hit from behind"
		 */
		val critFromBehind: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit from behind")
	
		/**
		 * In-Game: "Critical hit forces victim to laugh"
		 */
		val critForcesVictimToLaugh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit forces victim to laugh")
	
		/**
		 * In-Game: "Critical hits do no damage"
		 */
		val critDoesNoDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit does no damage")
	
		/**
		 * In-Game: "N% increase in damage when health <50% of max"
		 * 
		 * If health < 50%, apply mult.
		 */
		val multDmgWhileHalfDead: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg bonus while half dead")
	
		/**
		 * In-Game: "N% decrease in damage when health >50% of max"
		 * 
		 * If health >= 50%, apply mult.
		 */
		val multDmgWhileHalfAlive: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty while half alive")
	
		/**
		 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
		 * 
		 * Applies speed boost condition to yourself and the teammate you hit.
		 */
		val speedBuffAlly: ItemAttributeNamed<Boolean> = ItemAttributeNamed("speed buff ally")
	
		/**
		 * In-Game: "Gain a speed boost when you hit an enemy player"
		 * 
		 * Value is how long the speed boost condition should be applied.
		 */
		val speedBoostOnHitEnemy: ItemAttributeNamed<Duration> = ItemAttributeNamed("speed_boost_on_hit_enemy")
	
		/**
		 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
		 * 
		 * Force enemies to laugh if they're also wielding this weapon.
		 */
		val tickleEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("tickle enemies wielding same weapon")
	
		/**
		 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
		 */
		val selfMarkForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("self mark for death")
	}

	override val crits: CritsAttributes get() = BaseMeleeAttributes.crits
	
	override val damage: DamageAttributes get() = BaseMeleeAttributes.damage
	
	override val onHit: OnHitAttributes get() = BaseMeleeAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BaseMeleeAttributes.swapWeapons
	
	/**
	 * In-Game: "Damage removes Sappers"
	 * 
	 * Damage applies to hit sappers.  The amount of damage dealt is determined by [DamageAttributes.multDmgVsBuildings].
	 */
	val canDamageSappers: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.canDamageSappers.get()
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If true, set swing range to 72, else 48.
	 * 
	 * If true, make weapon deploy and holster 75% slower. (This part can be used on all weapons.  See SwapWeapons.Deploy).
	 */
	override val isASword: ItemAttributeNamed<Boolean> get() = super.isASword
	
	/**
	 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
	 */
	val meleeBoundsMultiplier: ItemAttributeNamed<Number> get() = BaseMeleeAttributes.meleeBoundsMultiplier.get()
	
	/**
	 * In-Game: "On Miss: Hit yourself. Idiot."
	 */
	val hitSelfOnMiss: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.hitSelfOnMiss.get()
	
	override val afterburn: AfterburnAttributes get() = BaseMeleeAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BaseMeleeAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BaseMeleeAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BaseMeleeAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BaseMeleeAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BaseMeleeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BaseMeleeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BaseMeleeAttributes.meta
	
	override val meter: MeterAttributes get() = BaseMeleeAttributes.meter
	
	override val movement: MovementAttributes get() = BaseMeleeAttributes.movement
	
	override val heads: HeadsAttributes get() = BaseMeleeAttributes.heads
	
	override val onKill: OnKillAttributes get() = BaseMeleeAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BaseMeleeAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BaseMeleeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BaseMeleeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BaseMeleeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BaseMeleeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BaseMeleeAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = BaseMeleeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BaseMeleeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BaseMeleeAttributes.disguise

	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Always critical hit from behind"
		 */
		context(attrs: IAttributeContainer)
		open var critFromBehind: Boolean? 
			get() = BaseMeleeAttributes.critFromBehind.get()
			set(value) { BaseMeleeAttributes.critFromBehind.set(value) }
	
		/**
		 * In-Game: "Critical hit forces victim to laugh"
		 */
		context(attrs: IAttributeContainer)
		open var critForcesVictimToLaugh: Boolean? 
			get() = BaseMeleeAttributes.critForcesVictimToLaugh.get()
			set(value) { BaseMeleeAttributes.critForcesVictimToLaugh.set(value) }
	
		/**
		 * In-Game: "Critical hits do no damage"
		 */
		context(attrs: IAttributeContainer)
		open var critDoesNoDamage: Boolean? 
			get() = BaseMeleeAttributes.critDoesNoDamage.get()
			set(value) { BaseMeleeAttributes.critDoesNoDamage.set(value) }
	}
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "N% increase in damage when health <50% of max"
		 * 
		 * If health < 50%, apply mult.
		 */
		context(attrs: IAttributeContainer)
		open var multDmgWhileHalfDead: Number? 
			get() = BaseMeleeAttributes.multDmgWhileHalfDead.get()
			set(value) { BaseMeleeAttributes.multDmgWhileHalfDead.set(value) }
	
		/**
		 * In-Game: "N% decrease in damage when health >50% of max"
		 * 
		 * If health >= 50%, apply mult.
		 */
		context(attrs: IAttributeContainer)
		open var multDmgWhileHalfAlive: Number? 
			get() = BaseMeleeAttributes.multDmgWhileHalfAlive.get()
			set(value) { BaseMeleeAttributes.multDmgWhileHalfAlive.set(value) }
	}
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
		 * 
		 * Applies speed boost condition to yourself and the teammate you hit.
		 */
		context(attrs: IAttributeContainer)
		open var speedBuffAlly: Boolean? 
			get() = BaseMeleeAttributes.speedBuffAlly.get()
			set(value) { BaseMeleeAttributes.speedBuffAlly.set(value) }
	
		/**
		 * In-Game: "Gain a speed boost when you hit an enemy player"
		 * 
		 * Value is how long the speed boost condition should be applied.
		 */
		context(attrs: IAttributeContainer)
		open var speedBoostOnHitEnemy: Duration? 
			get() = BaseMeleeAttributes.speedBoostOnHitEnemy.get()
			set(value) { BaseMeleeAttributes.speedBoostOnHitEnemy.set(value) }
	
		/**
		 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
		 * 
		 * Force enemies to laugh if they're also wielding this weapon.
		 */
		context(attrs: IAttributeContainer)
		open var tickleEnemiesWieldingSameWeapon: Boolean? 
			get() = BaseMeleeAttributes.tickleEnemiesWieldingSameWeapon.get()
			set(value) { BaseMeleeAttributes.tickleEnemiesWieldingSameWeapon.set(value) }
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
		 */
		context(attrs: IAttributeContainer)
		open var selfMarkForDeath: Boolean? 
			get() = BaseMeleeAttributes.selfMarkForDeath.get()
			set(value) { BaseMeleeAttributes.selfMarkForDeath.set(value) }
	
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : WeaponBaseAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WeaponBaseAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WeaponBaseAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : WeaponBaseAttributes.BuildingsAttributes() 
	
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
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WeaponBaseAttributes.DisguiseAttributes() 
}