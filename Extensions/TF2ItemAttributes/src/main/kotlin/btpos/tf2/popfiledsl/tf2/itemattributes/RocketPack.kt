package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Thermal Thruster
 * 
 */
abstract class RocketPackAttributes : BaseMeleeAttributes() {
	companion object : RocketPackAttributes() {
		operator fun invoke(scope: RocketPackAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * The MvM upgrade that lets you launch while launching
	 */
	context(attrs: IKeyValueMap)
	var thermalThrusterAirLaunch: Boolean?
		get() = attrs.getTyped("thermal_thruster_air_launch", BinaryIntCodec)
		set(value) = attrs.setNullable("thermal_thruster_air_launch", value, BinaryIntCodec)
}

