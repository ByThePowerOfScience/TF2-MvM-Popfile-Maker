package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


interface ProjectileEnergyRingAttributes : BaseProjectileAttributes, IBlockScoped {
	companion object : ProjectileEnergyRingAttributes
	
	/**
	 * In-Game: "Projectile penetrates enemy targets"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var energyWeaponPenetration: Boolean?
		get() = attrs.getTyped("energy weapon penetration", BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon penetration", value, BinaryIntCodec)
}

