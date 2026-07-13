package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*


object ParticlesAttributes {
	inline operator fun invoke(scope: ParticlesAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	context(attrs: IKeyValueMap)
	var useHeadOrigin: Boolean?
		get() = attrs.getTyped("particle effect use head origin", BinaryIntCodec)
		set(value) = attrs.setNullable("particle effect use head origin", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var verticalOffset: Int?
		get() = attrs.getTyped("particle effect vertical offset")
		set(value) = attrs.setNullable("particle effect vertical offset", value)
}

