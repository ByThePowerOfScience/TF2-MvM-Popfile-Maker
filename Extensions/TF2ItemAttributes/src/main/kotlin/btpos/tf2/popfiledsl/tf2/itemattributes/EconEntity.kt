package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
object EconEntityAttributes {
	inline operator fun invoke(scope: EconEntityAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * Attaches festivizer
	 * 
	 */
	context(attrs: IKeyValueMap)
	var isFestivized: Boolean?
		get() = attrs.getTyped("is_festivized", BinaryIntCodec)
		set(value) = attrs.setNullable("is_festivized", value, BinaryIntCodec)
	
	/**
	 * Value type: particle_index
	 * 
	 * Attaches static particle, such as smoking a pipe
	 * 
	 * Cosmetics can only have one
	 * 
	 */
	context(attrs: IKeyValueMap)
	var attachParticleEffectStatic: ParticleIndex?
		get() = attrs.getTyped("attach particle effect static")
		set(value) = attrs.setNullable("attach particle effect static", value)
	
	/**
	 * Value type: particle_index
	 * 
	 * Dynamic particle systems, such as unusuals
	 * 
	 */
	context(attrs: IKeyValueMap)
	var attachParticleEffect: ParticleIndex?
		get() = attrs.getTyped("attach particle effect")
		set(value) = attrs.setNullable("attach particle effect", value)
	
	/**
	 * If false, attaches the `set_attached_particle` to the item itself
	 * 
	 * If true, the particle only applies to the throwable particle trail? Though I don't actually see that occurring anywhere in here
	 * 
	 */
	context(attrs: IKeyValueMap)
	var throwableParticleTrailOnly: Boolean?
		get() = attrs.getTyped("throwable particle trail only", BinaryIntCodec)
		set(value) = attrs.setNullable("throwable particle trail only", value, BinaryIntCodec)
}

