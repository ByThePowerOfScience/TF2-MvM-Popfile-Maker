package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface MedigunAttributes : BaseGunAttributes {
	companion object : IBlockScoped {
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
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
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
	
	override val viewmodel: ViewmodelAttributes get() = MedigunAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = MedigunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = MedigunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = MedigunAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = MedigunAttributes.disguise

	open class GiveCritsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "ÜberCharge grants 100% critical chance"
			 * 
			 * Ubercharge type. Each resist uber also has its own entry.
			 */
			val giveCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is crit boost", NumberSelectorCodec(1))
	
			/**
			 * In-Game: "ÜberCharge increases healing to 300% and grants immunity to movement-impairing effects"
			 * 
			 * Ubercharge type. Each resist uber also has its own entry.
			 */
			val medigunChargeIsMegaheal: ItemAttributeNamed<Int> = ItemAttributeNamed("medigun charge is megaheal")
	
			/**
			 * In-Game: "Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type."
			 * 
			 * Ubercharge type. Each resist uber also has its own entry.
			 */
			val giveResistanceType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("medigun charge is resists", NumberSelectorCodec(3))
		}
	
		/**
		 * In-Game: "ÜberCharge grants 100% critical chance"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		context(attrs: IAttributeContainer)
		open var giveCrits: Boolean? 
			get() = GiveCritsAttributes.giveCrits.get()
			set(value) { GiveCritsAttributes.giveCrits.set(value) }
	
		/**
		 * In-Game: "ÜberCharge increases healing to 300% and grants immunity to movement-impairing effects"
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		context(attrs: IAttributeContainer)
		open var medigunChargeIsMegaheal: Int? 
			get() = GiveCritsAttributes.medigunChargeIsMegaheal.get()
			set(value) { GiveCritsAttributes.medigunChargeIsMegaheal.set(value) }
	
		/**
		 * In-Game: "Press your reload key to cycle through resist types. While healing, provides you and your target with a constant 10% resistance to the selected damage type."
		 * 
		 * Ubercharge type. Each resist uber also has its own entry.
		 */
		context(attrs: IAttributeContainer)
		open var giveResistanceType: Boolean? 
			get() = GiveCritsAttributes.giveResistanceType.get()
			set(value) { GiveCritsAttributes.giveResistanceType.set(value) }
	}
	
	open class OverhealDecayAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "N% shorter overheal time"
			 */
			val overhealDecayPenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay penalty")
	
			/**
			 * In-Game: "+N% longer overheal time"
			 */
			val overhealDecayBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay bonus")
	
			/**
			 * In-Game: "Overheal bonus doesn't decay"
			 */
			val overhealDecayDisabled: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal decay disabled")
		}
	
		/**
		 * In-Game: "N% shorter overheal time"
		 */
		context(attrs: IAttributeContainer)
		open var overhealDecayPenalty: Number? 
			get() = OverhealDecayAttributes.overhealDecayPenalty.get()
			set(value) { OverhealDecayAttributes.overhealDecayPenalty.set(value) }
	
		/**
		 * In-Game: "+N% longer overheal time"
		 */
		context(attrs: IAttributeContainer)
		open var overhealDecayBonus: Number? 
			get() = OverhealDecayAttributes.overhealDecayBonus.get()
			set(value) { OverhealDecayAttributes.overhealDecayBonus.set(value) }
	
		/**
		 * In-Game: "Overheal bonus doesn't decay"
		 */
		context(attrs: IAttributeContainer)
		open var overhealDecayDisabled: Number? 
			get() = OverhealDecayAttributes.overhealDecayDisabled.get()
			set(value) { OverhealDecayAttributes.overhealDecayDisabled.set(value) }
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BaseGunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BaseGunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BaseGunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
}