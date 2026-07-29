package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ShovelAttributes : BaseMeleeAttributes {
	
	companion object {
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
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = ShovelAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = ShovelAttributes.damage
	
	override val fireRate: FireRateAttributes get() = ShovelAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = ShovelAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = ShovelAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = ShovelAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = ShovelAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = ShovelAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : BaseMeleeAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : BaseMeleeAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : BaseMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : BaseMeleeAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : BaseMeleeAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : BaseMeleeAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
}