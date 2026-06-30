package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Thermal Thruster
 */
interface RocketPackAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : RocketPackAttributes
	
	/**
	 * In-Game: "Able to re-launch while already in-flight"
	 *
	 * 
	 *
	 * The MvM upgrade that lets you launch while launching.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var thermalThrusterAirLaunch: Boolean?
		get() = attrs.getTyped("thermal_thruster_air_launch", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("thermal_thruster_air_launch", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

