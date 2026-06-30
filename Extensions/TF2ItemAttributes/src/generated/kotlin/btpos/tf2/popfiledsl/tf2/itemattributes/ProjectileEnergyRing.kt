package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



interface ProjectileEnergyRingAttributes : BaseProjectileAttributes, IBlockScoped {
	companion object : ProjectileEnergyRingAttributes
	
	/**
	 * In-Game: "Projectile penetrates enemy targets"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	context(attrs: IKeyValueMap)
	var energyWeaponPenetration: Boolean?
		get() = attrs.getTyped("energy weapon penetration", BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon penetration", value, BinaryIntCodec)
}

