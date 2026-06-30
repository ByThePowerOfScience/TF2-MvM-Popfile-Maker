package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface PowerUpBottleAttributes : btpos.source.vdfdsl.tf2.itemattributes.WearableAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : PowerUpBottleAttributes
	
	/**
	 * In-Game: "Each charge lasts N seconds"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var powerupDuration: Int?
		get() = attrs.getTyped("powerup duration")
		set(value) = attrs.setNullable("powerup duration", value)
	
	/**
	 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
	 *
	 * 
	 *
	 * Adds extra time to the base powerup duration based on level.
	 *
	 * Checked on player.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var canteenSpecialist: Int?
		get() = attrs.getTyped("canteen specialist")
		set(value) = attrs.setNullable("canteen specialist", value)
	
	/**
	 * In-Game: "Holds a maximum of N charges"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var powerupMaxCharges: Int?
		get() = attrs.getTyped("powerup max charges")
		set(value) = attrs.setNullable("powerup max charges", value)
	
	/**
	 * 
	 */
	val type get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.TypeAttributes
}


object TypeAttributes {
	inline operator fun invoke(scope: TypeAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "Consumable: Become Crit Boosted for 5 seconds (and double your sentry's firing speed)"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var critboost: Boolean?
		get() = attrs.getTyped("critboost", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("critboost", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Become Übercharged for 5 seconds (and shield your sentry from damage)"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var ubercharge: Boolean?
		get() = attrs.getTyped("ubercharge", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("ubercharge", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly teleport to spawn"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var recall: Boolean?
		get() = attrs.getTyped("recall", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("recall", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly upgrade all buildings to max level"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var buildingInstantUpgrade: Boolean?
		get() = attrs.getTyped("building instant upgrade", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("building instant upgrade", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

