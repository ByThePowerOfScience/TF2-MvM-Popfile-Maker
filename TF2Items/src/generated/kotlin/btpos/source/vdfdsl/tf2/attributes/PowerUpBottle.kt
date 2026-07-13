package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*


interface PowerUpBottleAttributes : WearableAttributes, IBlockScoped {
	companion object : PowerUpBottleAttributes
	
	/**
	 * In-Game: "Each charge lasts N seconds"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var powerupDuration: Int?
		get() = attrs.getTyped("powerup duration")
		set(value) = attrs.setNullable("powerup duration", value)
	
	/**
	 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
	 *
	 * 
	 *
	 * Discounts canteens by 10 * level.
	 *
	 * Adds extra time to the base powerup duration based on level.
	 *
	 * Checked on player.
	 */
	context(attrs: IKeyValueMap)
	override var canteenSpecialist: Int?
		get() = super.canteenSpecialist
		set(value) { super.canteenSpecialist = value }
	
	/**
	 * In-Game: "Holds a maximum of N charges"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var powerupMaxCharges: Int?
		get() = attrs.getTyped("powerup max charges")
		set(value) = attrs.setNullable("powerup max charges", value)
	
	/**
	 * 
	 */
	val type get() = TypeAttributes
}


object TypeAttributes {
	inline operator fun invoke(scope: TypeAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "Consumable: Become Crit Boosted for 5 seconds (and double your sentry's firing speed)"
	 */
	context(attrs: IKeyValueMap)
	var critboost: Boolean?
		get() = attrs.getTyped("critboost", BinaryIntCodec)
		set(value) = attrs.setNullable("critboost", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Become Übercharged for 5 seconds (and shield your sentry from damage)"
	 */
	context(attrs: IKeyValueMap)
	var ubercharge: Boolean?
		get() = attrs.getTyped("ubercharge", BinaryIntCodec)
		set(value) = attrs.setNullable("ubercharge", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly teleport to spawn"
	 */
	context(attrs: IKeyValueMap)
	var recall: Boolean?
		get() = attrs.getTyped("recall", BinaryIntCodec)
		set(value) = attrs.setNullable("recall", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly refill all weapon clips and ammo"
	 */
	context(attrs: IKeyValueMap)
	var refillAmmo: Boolean?
		get() = attrs.getTyped("refill_ammo", BinaryIntCodec)
		set(value) = attrs.setNullable("refill_ammo", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly upgrade all buildings to max level"
	 */
	context(attrs: IKeyValueMap)
	var buildingInstantUpgrade: Boolean?
		get() = attrs.getTyped("building instant upgrade", BinaryIntCodec)
		set(value) = attrs.setNullable("building instant upgrade", value, BinaryIntCodec)
}

