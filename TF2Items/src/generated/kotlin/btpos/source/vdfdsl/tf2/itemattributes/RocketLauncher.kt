package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface RocketLauncherAttributes : BaseGunAttributes {
	companion object {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val projectiles: ProjectilesAttributes get() = RocketLauncherAttributes.projectiles
	
	override val ammo: AmmoAttributes get() = RocketLauncherAttributes.ammo
	
	override val damage: DamageAttributes get() = RocketLauncherAttributes.damage
	
	override val firing: FiringAttributes get() = RocketLauncherAttributes.firing

	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		/**
		 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow.).
		 */
		open val canRocketJumpWithExplosion: ItemAttributeNamed<Boolean> = ItemAttributeNamed("rocket launch impulse")
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() 
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
}