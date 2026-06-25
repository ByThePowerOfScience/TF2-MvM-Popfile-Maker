package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class PowerUpBottleAttributes : WearableAttributes() {
	companion object : PowerUpBottleAttributes() {
		operator fun invoke(scope: PowerUpBottleAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
	context(attrs: IKeyValueMap)
	var powerupDuration: Int?
		get() = attrs.getTyped("powerup duration")
		set(value) = attrs.setNullable("powerup duration", value)
	
	/**
	 *     - Adds extra time to the base powerup duration based on level?
	 * Checked on player
	 */
	context(attrs: IKeyValueMap)
	var canteenSpecialist: Int?
		get() = attrs.getTyped("canteen specialist")
		set(value) = attrs.setNullable("canteen specialist", value)
	
	
	context(attrs: IKeyValueMap)
	var powerupMaxCharges: Int?
		get() = attrs.getTyped("powerup max charges")
		set(value) = attrs.setNullable("powerup max charges", value)
	
	/**
	 * Items: 
	 * 
	 */
	val type get() = TypeAttributes
}

/**
 * Items: 
 * 
 */
object TypeAttributes {
	operator fun invoke(scope: TypeAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	
	context(attrs: IKeyValueMap)
	var critboost: Boolean?
		get() = attrs.getTyped("critboost", BinaryIntCodec)
		set(value) = attrs.setNullable("critboost", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var ubercharge: Boolean?
		get() = attrs.getTyped("ubercharge", BinaryIntCodec)
		set(value) = attrs.setNullable("ubercharge", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var recall: Boolean?
		get() = attrs.getTyped("recall", BinaryIntCodec)
		set(value) = attrs.setNullable("recall", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var buildingInstantUpgrade: Boolean?
		get() = attrs.getTyped("building instant upgrade", BinaryIntCodec)
		set(value) = attrs.setNullable("building instant upgrade", value, BinaryIntCodec)
}

