package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*

interface ProjectileEnergyRingAttributes : IBlockScoped, BaseProjectileAttributes {
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
}