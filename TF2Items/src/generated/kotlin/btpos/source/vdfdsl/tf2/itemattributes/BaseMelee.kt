package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseMeleeAttributes : WeaponBaseAttributes {
	companion object : IBlockScoped {
		/**
		 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
		 */
		val meleeBoundsMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("melee bounds multiplier")
	
		/**
		 * In-Game: "On Miss: Hit yourself. Idiot."
		 * 
		 * Idiot.
		 */
		val hitSelfOnMiss: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hit self on miss")
	
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

	override val crits: CritsAttributes get() = BaseMeleeAttributes.crits
	
	override val damage: DamageAttributes get() = BaseMeleeAttributes.damage
	
	override val onHit: OnHitAttributes get() = BaseMeleeAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BaseMeleeAttributes.swapWeapons
	
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
	val meleeBoundsMultiplier: ItemAttributeNamed<Number> get() = BaseMeleeAttributes.meleeBoundsMultiplier
	
	/**
	 * In-Game: "On Miss: Hit yourself. Idiot."
	 * 
	 * Idiot.
	 */
	val hitSelfOnMiss: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.hitSelfOnMiss
	
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
	
	override val viewmodel: ViewmodelAttributes get() = BaseMeleeAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = BaseMeleeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BaseMeleeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BaseMeleeAttributes.disguise

	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() {
		companion object : IBlockScoped {
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
		}
	
		/**
		 * In-Game: "Always critical hit from behind"
		 */
		context(attrs: IAttributeContainer)
		open var critFromBehind: Boolean? 
			get() = CritsAttributes.critFromBehind.get()
			set(value) { CritsAttributes.critFromBehind.set(value) }
	
		/**
		 * In-Game: "Critical hit forces victim to laugh"
		 */
		context(attrs: IAttributeContainer)
		open var critForcesVictimToLaugh: Boolean? 
			get() = CritsAttributes.critForcesVictimToLaugh.get()
			set(value) { CritsAttributes.critForcesVictimToLaugh.set(value) }
	
		/**
		 * In-Game: "Critical hits do no damage"
		 */
		context(attrs: IAttributeContainer)
		open var critDoesNoDamage: Boolean? 
			get() = CritsAttributes.critDoesNoDamage.get()
			set(value) { CritsAttributes.critDoesNoDamage.set(value) }
	
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "N% increase in damage when health <50% of max"
			 * 
			 * If health < 50%, apply mult.
			 */
			val dmgBonusWhileHalfDead: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg bonus while half dead")
	
			/**
			 * In-Game: "N% decrease in damage when health >50% of max"
			 * 
			 * If health >= 50%, apply mult.
			 */
			val dmgPenaltyWhileHalfAlive: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty while half alive")
		}
	
		/**
		 * In-Game: "N% increase in damage when health <50% of max"
		 * 
		 * If health < 50%, apply mult.
		 */
		context(attrs: IAttributeContainer)
		open var dmgBonusWhileHalfDead: Number? 
			get() = DamageAttributes.dmgBonusWhileHalfDead.get()
			set(value) { DamageAttributes.dmgBonusWhileHalfDead.set(value) }
	
		/**
		 * In-Game: "N% decrease in damage when health >50% of max"
		 * 
		 * If health >= 50%, apply mult.
		 */
		context(attrs: IAttributeContainer)
		open var dmgPenaltyWhileHalfAlive: Number? 
			get() = DamageAttributes.dmgPenaltyWhileHalfAlive.get()
			set(value) { DamageAttributes.dmgPenaltyWhileHalfAlive.set(value) }
	
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : WeaponBaseAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Damage removes Sappers"
			 * 
			 * Damage sappers with swing.
			 */
			val damageAppliesToSappers: ItemAttributeNamed<Int> = ItemAttributeNamed("damage applies to sappers")
	
			/**
			 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
			 * 
			 * Applies speed boost cond to yourself and the teammate you hit.
			 */
			val speedBuffAlly: ItemAttributeNamed<Boolean> = ItemAttributeNamed("speed buff ally")
	
			/**
			 * In-Game: "Gain a speed boost when you hit an enemy player"
			 * 
			 * Used as arg to addcond speedboost.
			 */
			val speedBoostOnHitEnemy: ItemAttributeNamed<Number> = ItemAttributeNamed("speed_boost_on_hit_enemy")
	
			/**
			 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
			 * 
			 * Force enemies to laugh if they're also wielding this weapon.
			 */
			val tickleEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("tickle enemies wielding same weapon")
		}
	
		/**
		 * In-Game: "Damage removes Sappers"
		 * 
		 * Damage sappers with swing.
		 */
		context(attrs: IAttributeContainer)
		open var damageAppliesToSappers: Int? 
			get() = OnHitAttributes.damageAppliesToSappers.get()
			set(value) { OnHitAttributes.damageAppliesToSappers.set(value) }
	
		/**
		 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
		 * 
		 * Applies speed boost cond to yourself and the teammate you hit.
		 */
		context(attrs: IAttributeContainer)
		open var speedBuffAlly: Boolean? 
			get() = OnHitAttributes.speedBuffAlly.get()
			set(value) { OnHitAttributes.speedBuffAlly.set(value) }
	
		/**
		 * In-Game: "Gain a speed boost when you hit an enemy player"
		 * 
		 * Used as arg to addcond speedboost.
		 */
		context(attrs: IAttributeContainer)
		open var speedBoostOnHitEnemy: Number? 
			get() = OnHitAttributes.speedBoostOnHitEnemy.get()
			set(value) { OnHitAttributes.speedBoostOnHitEnemy.set(value) }
	
		/**
		 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
		 * 
		 * Force enemies to laugh if they're also wielding this weapon.
		 */
		context(attrs: IAttributeContainer)
		open var tickleEnemiesWieldingSameWeapon: Boolean? 
			get() = OnHitAttributes.tickleEnemiesWieldingSameWeapon.get()
			set(value) { OnHitAttributes.tickleEnemiesWieldingSameWeapon.set(value) }
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
			 * 
			 * Mark self for death when switching to this weapon.
			 */
			val selfMarkForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("self mark for death")
		}
	
		/**
		 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
		 * 
		 * Mark self for death when switching to this weapon.
		 */
		context(attrs: IAttributeContainer)
		open var selfMarkForDeath: Boolean? 
			get() = SwapWeaponsAttributes.selfMarkForDeath.get()
			set(value) { SwapWeaponsAttributes.selfMarkForDeath.set(value) }
	
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
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WeaponBaseAttributes.DisguiseAttributes() 
}