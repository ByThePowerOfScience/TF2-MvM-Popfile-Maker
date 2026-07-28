package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Thermal Thruster
 */
interface RocketPackAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Able to re-launch while already in-flight"
		 *
		 * 
		 *
		 * The MvM upgrade that lets you repeatedly launch without a cooldown.
		 */
		val thermalThrusterAirLaunch = ItemAttributeNamed<Boolean>("thermal_thruster_air_launch")
	}

	/**
	 * In-Game: "Able to re-launch while already in-flight"
	 *
	 * 
	 *
	 * The MvM upgrade that lets you repeatedly launch without a cooldown.
	 */
	val thermalThrusterAirLaunch: ItemAttribute<Boolean> get() = RocketPackAttributes.thermalThrusterAirLaunch

   
}

