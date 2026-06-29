package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface ProjectileArrowAttributes : BaseRocketAttributes {
	companion object : ProjectileArrowAttributes
	
	/**
	 * Checked on player
	 * 
	 */
	context(attrs: IKeyValueMap)
	var arrowHealsBuildings: Boolean?
		get() = attrs.getTyped("arrow heals buildings", BinaryIntCodec)
		set(value) = attrs.setNullable("arrow heals buildings", value, BinaryIntCodec)
}

inline operator fun ProjectileArrowAttributes.invoke(scope: ProjectileArrowAttributes.() -> Unit) {
	this.apply(scope)
}

