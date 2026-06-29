package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface PlayerAttributes : EntityAttributes {
	companion object : PlayerAttributes
	
	
	context(attrs: IKeyValueMap)
	var modSeeEnemyHealth: Boolean?
		get() = attrs.getTyped("mod see enemy health", BinaryIntCodec)
		set(value) = attrs.setNullable("mod see enemy health", value, BinaryIntCodec)
	
	/**
	 * Always true in MvM
	 * 
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

inline operator fun PlayerAttributes.invoke(scope: PlayerAttributes.() -> Unit) {
	this.apply(scope)
}

/**
 * 
 */
object SpyOnlyAttributes {
	inline operator fun invoke(scope: SpyOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * You can set a spy build menu??
	 * 
	 */
	context(attrs: IKeyValueMap)
	var hasPipboyBuildInterface: Int?
		get() = attrs.getTyped("has pipboy build interface")
		set(value) = attrs.setNullable("has pipboy build interface", value)
}

