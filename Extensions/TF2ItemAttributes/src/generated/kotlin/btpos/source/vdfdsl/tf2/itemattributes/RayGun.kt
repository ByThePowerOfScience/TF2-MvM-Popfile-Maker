package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Righteous Bison, The Pomson 6000
 */
interface RayGunAttributes : btpos.source.vdfdsl.tf2.itemattributes.RocketLauncherAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : RayGunAttributes
	
	/**
	 * 
	 *
	 * Removes ammo requirement to fire weapon.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var energyWeaponNoDrain: Boolean?
		get() = attrs.getTyped("energy weapon no drain", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("energy weapon no drain", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

