package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface GrenadeLauncherAttributes : BaseGunAttributes {
	companion object {
		/**
		 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
		 */
		val grenadeLauncherMortarMode: ItemAttributeNamed<Duration> = ItemAttributeNamed("grenade launcher mortar mode")
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	}

	override val projectiles: ProjectilesAttributes get() = GrenadeLauncherAttributes.projectiles
	
	override val damage: DamageAttributes get() = GrenadeLauncherAttributes.damage
	
	/**
	 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
	 */
	val grenadeLauncherMortarMode: ItemAttributeNamed<Duration> get() = GrenadeLauncherAttributes.grenadeLauncherMortarMode
	
	override val ammo: AmmoAttributes get() = GrenadeLauncherAttributes.ammo
	
	override val firing: FiringAttributes get() = GrenadeLauncherAttributes.firing

	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		open val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("Projectile speed increased"),
			ItemAttributeNamed<Float>("Projectile speed decreased"),
			ItemAttributeNamed<Float>("Projectile speed increased HIDDEN"),
		)
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		/**
		 * In-Game: "N% damage on grenades that explode on timer"
		 * 
		 * Flat multiplier applied to initial damage.
		 */
		open val grenadeDetonationDamagePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("grenade detonation damage penalty")
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() 
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
}