package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


/**
 * Items: The Righteous Bison, The Pomson 6000
 */
interface RayGunAttributes : RocketLauncherAttributes, IBlockScoped {
	companion object : RayGunAttributes
	
	/**
	 * 
	 *
	 * Removes ammo requirement to fire weapon.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var energyWeaponNoDrain: Boolean?
		get() = attrs.getTyped("energy weapon no drain", BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon no drain", value, BinaryIntCodec)
}

