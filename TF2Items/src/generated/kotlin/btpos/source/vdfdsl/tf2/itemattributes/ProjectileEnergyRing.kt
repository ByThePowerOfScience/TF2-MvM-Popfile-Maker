package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ProjectileEnergyRingAttributes : IBlockScoped, ProjectileBaseMiscAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Projectile penetrates enemy targets"
		 * 
		 * Checked on owner.
		 */
		val energyWeaponPenetration: ItemAttributeNamed<Boolean> = ItemAttributeNamed("energy weapon penetration")
	}
	
	/**
	 * In-Game: "Projectile penetrates enemy targets"
	 * 
	 * Checked on owner.
	 */
	val energyWeaponPenetration: ItemAttributeNamed<Boolean> get() = ProjectileEnergyRingAttributes.energyWeaponPenetration
	
	object Inherited : ProjectileEnergyRingAttributes 
}