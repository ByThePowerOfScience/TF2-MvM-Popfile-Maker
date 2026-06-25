package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface ProjectileRocketAttributes : BaseRocketAttributes {
	companion object : ProjectileRocketAttributes
	
	/**
	 * Does pumpkin bombs particle effect
	 * 
	 * 
	 * Checks on owner or sentry's owner
	 * 
	 */
	override context(attrs: IKeyValueMap)
	var sPELLHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
}

operator fun ProjectileRocketAttributes.invoke(scope: ProjectileRocketAttributes.() -> Unit) {
	this.apply(scope)
}

