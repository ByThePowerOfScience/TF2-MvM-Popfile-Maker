package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class ProjectileArrowAttributes : BaseRocketAttributes() {
	companion object : ProjectileArrowAttributes() {
		operator fun invoke(scope: ProjectileArrowAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Checked on player
	 */
	context(attrs: IKeyValueMap)
	var arrowHealsBuildings: Boolean?
		get() = attrs.getTyped("arrow heals buildings", BinaryIntCodec)
		set(value) = attrs.setNullable("arrow heals buildings", value, BinaryIntCodec)
}

