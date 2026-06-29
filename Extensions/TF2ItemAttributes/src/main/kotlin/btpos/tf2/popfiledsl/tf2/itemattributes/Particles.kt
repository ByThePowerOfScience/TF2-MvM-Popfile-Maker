package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
object ParticlesAttributes {
	inline operator fun invoke(scope: ParticlesAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	
	context(attrs: IKeyValueMap)
	var particleEffectUseHeadOrigin: Boolean?
		get() = attrs.getTyped("particle effect use head origin", BinaryIntCodec)
		set(value) = attrs.setNullable("particle effect use head origin", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var particleEffectVerticalOffset: Int?
		get() = attrs.getTyped("particle effect vertical offset")
		set(value) = attrs.setNullable("particle effect vertical offset", value)
}

