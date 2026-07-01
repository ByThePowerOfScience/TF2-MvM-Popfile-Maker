package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec


object EconEntityAttributes {
	inline operator fun invoke(scope: EconEntityAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * In-Game: "Festivized"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var isFestivized: Boolean?
		get() = attrs.getTyped("is_festivized", BinaryIntCodec)
		set(value) = attrs.setNullable("is_festivized", value, BinaryIntCodec)
	
	
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var attachParticleEffectStatic: Int?
		get() = attrs.getTyped("attach particle effect static")
		set(value) = attrs.setNullable("attach particle effect static", value)
	
	/**
	 * In-Game: "★ Unusual Effect: N"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var attachParticleEffect: Int?
		get() = attrs.getTyped("attach particle effect")
		set(value) = attrs.setNullable("attach particle effect", value)
	
	
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var throwableParticleTrailOnly: Boolean?
		get() = attrs.getTyped("throwable particle trail only", BinaryIntCodec)
		set(value) = attrs.setNullable("throwable particle trail only", value, BinaryIntCodec)
}

