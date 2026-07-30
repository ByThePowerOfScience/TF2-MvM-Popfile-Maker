package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface MinigunAttributes : BaseGunAttributes {
	companion object {
		/**
		 * In-Game: "Silent Killer: No barrel spin sound"
		 */
		val silentBarrel: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minigun no spin sounds")
	
		val minigunSpinupTime: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("minigun spinup time decreased"),
			ItemAttributeNamed("minigun spinup time increased"),
		)
	
		/**
		 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
		 * 
		 * Overridden by "raid gamemode" to 1.
		 */
		val attackProjectiles: ItemAttributeNamed<Boolean> = ItemAttributeNamed("attack projectiles")
	
		/**
		 * In-Game: "Creates a ring of flames while spun up"
		 */
		val ringOfFireWhileAiming: ItemAttributeNamed<Int> = ItemAttributeNamed("ring of fire while aiming")
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val ammo: AmmoAttributes get() = MinigunAttributes.ammo
	
	/**
	 * In-Game: "Silent Killer: No barrel spin sound"
	 */
	val silentBarrel: ItemAttributeNamed<Boolean> get() = MinigunAttributes.silentBarrel
	
	val minigunSpinupTime: BonusPenalty<Float> get() = MinigunAttributes.minigunSpinupTime
	
	/**
	 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
	 * 
	 * Overridden by "raid gamemode" to 1.
	 */
	val attackProjectiles: ItemAttributeNamed<Boolean> get() = MinigunAttributes.attackProjectiles
	
	/**
	 * In-Game: "Creates a ring of flames while spun up"
	 */
	val ringOfFireWhileAiming: ItemAttributeNamed<Int> get() = MinigunAttributes.ringOfFireWhileAiming
	
	override val damage: DamageAttributes get() = MinigunAttributes.damage
	
	override val firing: FiringAttributes get() = MinigunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = MinigunAttributes.projectiles

	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		/**
		 * In-Game: "Consumes an additional N ammo per second while spun up"
		 * 
		 * Amount of ammo drained per second.
		 */
		open val spinupAmmoDrain: ItemAttributeNamed<Int> = ItemAttributeNamed("uses ammo while aiming")
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
}