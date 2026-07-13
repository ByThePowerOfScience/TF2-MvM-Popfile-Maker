package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*


interface ProjectileEnergyRingAttributes : BaseProjectileAttributes, IBlockScoped {
	companion object : ProjectileEnergyRingAttributes
	
	/**
	 * In-Game: "Projectile penetrates enemy targets"
	 *
	 * 
	 *
	 * Checked on player.
	 */
	context(attrs: IKeyValueMap)
	var energyWeaponPenetration: Boolean?
		get() = attrs.getTyped("energy weapon penetration", BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon penetration", value, BinaryIntCodec)
}

