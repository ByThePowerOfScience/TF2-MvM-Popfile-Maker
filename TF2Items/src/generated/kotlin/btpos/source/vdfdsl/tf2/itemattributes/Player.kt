package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


interface PlayerAttributes : EntityAttributes, IBlockScoped {
	companion object : PlayerAttributes
	
	/**
	 * In-Game: "Allows you to see enemy health"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var seeEnemyHealth: Boolean?
		get() = attrs.getTyped("mod see enemy health", BinaryIntCodec)
		set(value) = attrs.setNullable("mod see enemy health", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Unable to see enemy health"
	 *
	 * 
	 *
	 * Always true in MvM.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var hideEnemyHealth: Boolean?
		get() = attrs.getTyped("hide enemy health", BinaryIntCodec)
		set(value) = attrs.setNullable("hide enemy health", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	val spyOnly get() = SpyOnlyAttributes
}


object SpyOnlyAttributes {
	inline operator fun invoke(scope: SpyOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var hasPipboyBuildInterface: Int?
		get() = attrs.getTyped("has pipboy build interface")
		set(value) = attrs.setNullable("has pipboy build interface", value)
}

