package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class ProjectileRocketAttributes : BaseRocketAttributes() {
	companion object : ProjectileRocketAttributes() {
		operator fun invoke(scope: ProjectileRocketAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 *     - Does pumpkin bombs particle effect
	 * 
	 *     - Checks on owner or sentry's owner
	 */
	override context(attrs: IKeyValueMap)
	var SPELLHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
}

