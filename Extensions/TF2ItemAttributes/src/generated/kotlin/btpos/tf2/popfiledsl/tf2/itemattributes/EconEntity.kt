package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



object EconEntityAttributes {
	inline operator fun invoke(scope: EconEntityAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "Festivized"
	 */
	context(attrs: IKeyValueMap)
	var isFestivized: Boolean?
		get() = attrs.getTyped("is_festivized", BinaryIntCodec)
		set(value) = attrs.setNullable("is_festivized", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var attachParticleEffectStatic: Int?
		get() = attrs.getTyped("attach particle effect static")
		set(value) = attrs.setNullable("attach particle effect static", value)
	
	/**
	 * In-Game: "★ Unusual Effect: N"
	 */
	context(attrs: IKeyValueMap)
	var attachParticleEffect: Int?
		get() = attrs.getTyped("attach particle effect")
		set(value) = attrs.setNullable("attach particle effect", value)
	
	
	context(attrs: IKeyValueMap)
	var throwableParticleTrailOnly: Boolean?
		get() = attrs.getTyped("throwable particle trail only", BinaryIntCodec)
		set(value) = attrs.setNullable("throwable particle trail only", value, BinaryIntCodec)
}

