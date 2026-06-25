package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class PlayerAttributes : EntityAttributes() {
	companion object : PlayerAttributes() {
		operator fun invoke(scope: PlayerAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
	context(attrs: IKeyValueMap)
	var modSeeEnemyHealth: Boolean?
		get() = attrs.getTyped("mod see enemy health", BinaryIntCodec)
		set(value) = attrs.setNullable("mod see enemy health", value, BinaryIntCodec)
	
	/**
	 * Always true in MvM
	 */
	context(attrs: IKeyValueMap)
	var hideEnemyHealth: Boolean?
		get() = attrs.getTyped("hide enemy health", BinaryIntCodec)
		set(value) = attrs.setNullable("hide enemy health", value, BinaryIntCodec)
	
	/**
	 * Items: 
	 * 
	 */
	val spyOnly get() = SpyOnlyAttributes
}

/**
 * Items: 
 * 
 */
object SpyOnlyAttributes {
	operator fun invoke(scope: SpyOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * You can set a spy build menu??
	 */
	context(attrs: IKeyValueMap)
	var hasPipboyBuildInterface: Int?
		get() = attrs.getTyped("has pipboy build interface")
		set(value) = attrs.setNullable("has pipboy build interface", value)
}

