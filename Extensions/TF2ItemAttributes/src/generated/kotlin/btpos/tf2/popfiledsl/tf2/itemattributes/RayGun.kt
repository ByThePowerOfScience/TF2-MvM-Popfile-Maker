package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


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
	context(attrs: IKeyValueMap)
	var energyWeaponNoDrain: Boolean?
		get() = attrs.getTyped("energy weapon no drain", BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon no drain", value, BinaryIntCodec)
}

