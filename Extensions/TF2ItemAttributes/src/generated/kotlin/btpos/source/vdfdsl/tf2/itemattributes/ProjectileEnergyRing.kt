package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface ProjectileEnergyRingAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseProjectileAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
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
		get() = attrs.getTyped("energy weapon penetration", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon penetration", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

