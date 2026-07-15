package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

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

