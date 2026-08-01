package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface KnifeAttributes : BaseMeleeAttributes {
	companion object : IBlockScoped {
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
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
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
		val armorPiercing: ItemAttributeNamed<Number> = ItemAttributeNamed("armor piercing")
	
		/**
		 * In-Game: "On Backstab: Absorbs the health from your victim."
		 * 
		 * Gain health on backstab.
		 */
		val gainHealthOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sanguisuge")
	
		/**
		 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
		 */
		val disguiseOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise on backstab")
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
	val setIcicleKnifeMode: ItemAttributeNamed<Boolean> get() = KnifeAttributes.setIcicleKnifeMode.get()
	
	/**
	 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
	 */
	val meltsInFire: ItemAttributeNamed<Boolean> get() = KnifeAttributes.meltsInFire.get()
	
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

	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() {
		companion object : IBlockScoped 
	
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
		context(attrs: IAttributeContainer)
		override var damage: Number? 
			get() = super.damage
			set(value) { super.damage = value }
	
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
		context(attrs: IAttributeContainer)
		open var armorPiercing: Number? 
			get() = KnifeAttributes.armorPiercing.get()
			set(value) { KnifeAttributes.armorPiercing.set(value) }
	}
	
	open class HealthAndHealingAttributes : BaseMeleeAttributes.HealthAndHealingAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "On Backstab: Absorbs the health from your victim."
		 * 
		 * Gain health on backstab.
		 */
		context(attrs: IAttributeContainer)
		open var gainHealthOnBackstab: Boolean? 
			get() = KnifeAttributes.gainHealthOnBackstab.get()
			set(value) { KnifeAttributes.gainHealthOnBackstab.set(value) }
	}
	
	open class DisguiseAttributes : BaseMeleeAttributes.DisguiseAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
		 */
		context(attrs: IAttributeContainer)
		open var disguiseOnBackstab: Boolean? 
			get() = KnifeAttributes.disguiseOnBackstab.get()
			set(value) { KnifeAttributes.disguiseOnBackstab.set(value) }
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseMeleeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BaseMeleeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BaseMeleeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseMeleeAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BaseMeleeAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BaseMeleeAttributes.DemoChargeAttributes() 
	
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
	
		open class KillfeedAttributes : BaseMeleeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseMeleeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseMeleeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseMeleeAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseMeleeAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseMeleeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseMeleeAttributes.MovementAttributes.MoveSpeedAttributes() 
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
	
	open class ResistanceAttributes : BaseMeleeAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseMeleeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseMeleeAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseMeleeAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BaseMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
}