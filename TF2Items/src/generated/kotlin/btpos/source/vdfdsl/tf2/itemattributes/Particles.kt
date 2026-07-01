package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec


object ParticlesAttributes {
	inline operator fun invoke(scope: ParticlesAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var useHeadOrigin: Boolean?
		get() = attrs.getTyped("particle effect use head origin", BinaryIntCodec)
		set(value) = attrs.setNullable("particle effect use head origin", value, BinaryIntCodec)
	
	
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var verticalOffset: Int?
		get() = attrs.getTyped("particle effect vertical offset")
		set(value) = attrs.setNullable("particle effect vertical offset", value)
}

