package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface StickybombLauncherAttributes : BaseGunAttributes {
	
	companion object {
		/**
		 * In-Game: "Max charge time decreased by N%"
		 * 
		 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
		 */
		val stickybombChargeRate: ItemAttributeNamed<Float> = ItemAttributeNamed("stickybomb charge rate")
	
		/**
		 * In-Game: "Able to destroy enemy stickybomb"
		 * 
		 * If 1, stickies destroy other stickies.
		 */
		val stickiesDetonateStickies: ItemAttributeNamed<Boolean> = ItemAttributeNamed("stickies detonate stickies")
	
		/**
		 * In-Game: "Up to +N% damage based on charge"
		 * 
		 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
		 */
		val stickybombChargeDamageIncrease: ItemAttributeNamed<Float> = ItemAttributeNamed("stickybomb_charge_damage_increase")
	
		val maxStickies: BonusPenalty<Int> = BonusPenalty(
			ItemAttributeNamed("max pipebombs increased"),
			ItemAttributeNamed("max pipebombs decreased"),
		)
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * In-Game: "Max charge time decreased by N%"
	 * 
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	val stickybombChargeRate: ItemAttributeNamed<Float> get() = StickybombLauncherAttributes.stickybombChargeRate
	
	/**
	 * In-Game: "Able to destroy enemy stickybomb"
	 * 
	 * If 1, stickies destroy other stickies.
	 */
	val stickiesDetonateStickies: ItemAttributeNamed<Boolean> get() = StickybombLauncherAttributes.stickiesDetonateStickies
	
	/**
	 * In-Game: "Up to +N% damage based on charge"
	 * 
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
	 */
	val stickybombChargeDamageIncrease: ItemAttributeNamed<Float> get() = StickybombLauncherAttributes.stickybombChargeDamageIncrease
	
	val maxStickies: BonusPenalty<Int> get() = StickybombLauncherAttributes.maxStickies
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = StickybombLauncherAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = StickybombLauncherAttributes.damage
	
	override val fireRate: FireRateAttributes get() = StickybombLauncherAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = StickybombLauncherAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = StickybombLauncherAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = StickybombLauncherAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = StickybombLauncherAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = StickybombLauncherAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : BaseGunAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : BaseGunAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : BaseGunAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
}