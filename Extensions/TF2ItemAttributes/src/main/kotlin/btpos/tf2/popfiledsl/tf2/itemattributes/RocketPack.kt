package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Thermal Thruster
 * 
 */
interface RocketPackAttributes : BaseMeleeAttributes {
	companion object : RocketPackAttributes
	
	/**
	 * The MvM upgrade that lets you launch while launching
	 * 
	 */
	context(attrs: IKeyValueMap)
	var thermalThrusterAirLaunch: Boolean?
		get() = attrs.getTyped("thermal_thruster_air_launch", BinaryIntCodec)
		set(value) = attrs.setNullable("thermal_thruster_air_launch", value, BinaryIntCodec)
}

operator fun RocketPackAttributes.invoke(scope: RocketPackAttributes.() -> Unit) {
	this.apply(scope)
}

