package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



interface PlayerAttributes : EntityAttributes, IBlockScoped {
	companion object : PlayerAttributes
	
	/**
	 * In-Game: "Allows you to see enemy health"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
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
	context(attrs: IKeyValueMap)
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
	
	context(attrs: IKeyValueMap)
	var hasPipboyBuildInterface: Int?
		get() = attrs.getTyped("has pipboy build interface")
		set(value) = attrs.setNullable("has pipboy build interface", value)
}

