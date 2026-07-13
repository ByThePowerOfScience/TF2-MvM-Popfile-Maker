package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


/**
 * Items: The Thermal Thruster
 */
interface RocketPackAttributes : BaseMeleeAttributes, IBlockScoped {
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
		get() = attrs.getTyped("thermal_thruster_air_launch", BinaryIntCodec)
		set(value) = attrs.setNullable("thermal_thruster_air_launch", value, BinaryIntCodec)
}

