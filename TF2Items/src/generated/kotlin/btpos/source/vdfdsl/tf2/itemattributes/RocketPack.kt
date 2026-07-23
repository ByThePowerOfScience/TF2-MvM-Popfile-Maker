package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

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
	 * The MvM upgrade that lets you repeatedly launch without a cooldown.
	 */
	context(attrs: IKeyValueMap)
	var thermalThrusterAirLaunch: Boolean?
		get() = attrs.getTyped("thermal_thruster_air_launch", BinaryIntCodec)
		set(value) = attrs.setNullable("thermal_thruster_air_launch", value, BinaryIntCodec)
}

