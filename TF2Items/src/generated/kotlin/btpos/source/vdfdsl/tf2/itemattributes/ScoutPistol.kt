package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ScoutPistolAttributes : PistolAttributes {
	companion object {
		/**
		 * If true, can headshot when behind an enemy.
		 */
		val backHeadshot: ItemAttributeNamed<Boolean> = ItemAttributeNamed("back headshot")
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	/**
	 * If true, can headshot when behind an enemy.
	 */
	val backHeadshot: ItemAttributeNamed<Boolean> get() = ScoutPistolAttributes.backHeadshot
	
	override val ammo: AmmoAttributes get() = ScoutPistolAttributes.ammo
	
	override val damage: DamageAttributes get() = ScoutPistolAttributes.damage
	
	override val firing: FiringAttributes get() = ScoutPistolAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ScoutPistolAttributes.projectiles

	open class AmmoAttributes : PistolAttributes.AmmoAttributes() 
	
	open class DamageAttributes : PistolAttributes.DamageAttributes() 
	
	open class FiringAttributes : PistolAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : PistolAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : PistolAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : PistolAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
}