package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ChargedSMGAttributes : SMGAttributes {
	companion object {
		/**
		 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
		 * 
		 * Minicrit buff duration.
		 */
		val minicritBoostWhenCharged: ItemAttributeNamed<Float> = ItemAttributeNamed("minicrit_boost_when_charged")
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	/**
	 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
	 * 
	 * Minicrit buff duration.
	 */
	val minicritBoostWhenCharged: ItemAttributeNamed<Float> get() = ChargedSMGAttributes.minicritBoostWhenCharged
	
	override val ammo: AmmoAttributes get() = ChargedSMGAttributes.ammo
	
	override val damage: DamageAttributes get() = ChargedSMGAttributes.damage
	
	override val firing: FiringAttributes get() = ChargedSMGAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ChargedSMGAttributes.projectiles

	open class AmmoAttributes : SMGAttributes.AmmoAttributes() 
	
	open class DamageAttributes : SMGAttributes.DamageAttributes() 
	
	open class FiringAttributes : SMGAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : SMGAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : SMGAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : SMGAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
}