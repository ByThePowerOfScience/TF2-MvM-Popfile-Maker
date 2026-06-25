package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface EntityAttributes {
	companion object : EntityAttributes
	
	
	context(attrs: IKeyValueMap)
	var cannotBeBackstabbed: Boolean?
		get() = attrs.getTyped("cannot be backstabbed", BinaryIntCodec)
		set(value) = attrs.setNullable("cannot be backstabbed", value, BinaryIntCodec)
	
	/**
	 * Items: 
	 * 
	 */
	val buildings get() = BuildingsAttributes
}

operator fun EntityAttributes.invoke(scope: EntityAttributes.() -> Unit) {
	this.apply(scope)
}

/**
 * Items: 
 * 
 */
object BuildingsAttributes {
	operator fun invoke(scope: BuildingsAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * Items: 
	 * 
	 */
	val allBuildings get() = AllBuildingsAttributes
	
	/**
	 * Items: 
	 * 
	 */
	val sentry get() = SentryAttributes
	
	/**
	 * Items: 
	 * 
	 */
	val dispenser get() = DispenserAttributes
	
	/**
	 * Items: 
	 * 
	 */
	val teleporter get() = TeleporterAttributes
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var increasedJumpHeight: Float?
		get() = attrs.getTyped("increased jump height")
		set(value) = attrs.setNullable("increased jump height", value)
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var halloweenIncreasedJumpHeight: Float?
		get() = attrs.getTyped("halloween increased jump height")
		set(value) = attrs.setNullable("halloween increased jump height", value)
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% health from packs on wearer
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% health from packs on wearer
	 */
	val healthFromPacksDecreased get() = BonusPenalty<Float, Float>("health from packs increased", "health from packs decreased")
	
	/**
	 * Value type: percentage
	 * 
	 * Only on crossbow impacts?
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reducedHealingFromMedics: Float?
		get() = attrs.getTyped("reduced_healing_from_medics")
		set(value) = attrs.setNullable("reduced_healing_from_medics", value)
	
	/**
	 * Lose this amount of hype if you airdash
	 * 
	 * Note that this only applies to scout hype, not rage in general
	 * 
	 */
	context(attrs: IKeyValueMap)
	var hypeResetsOnJump: Int?
		get() = attrs.getTyped("hype resets on jump")
		set(value) = attrs.setNullable("hype resets on jump", value)
	
	/**
	 * Allows parachute to be deployed
	 * 
	 */
	context(attrs: IKeyValueMap)
	var parachuteAttribute: Boolean?
		get() = attrs.getTyped("parachute attribute", BinaryIntCodec)
		set(value) = attrs.setNullable("parachute attribute", value, BinaryIntCodec)
	
	/**
	 * Only used if the build menu is actually shown
	 * 
	 * 0 = default
	 * 
	 * 1 = pipboy
	 * 
	 */
	context(attrs: IKeyValueMap)
	var hasPipboyBuildInterface: Int?
		get() = attrs.getTyped("has pipboy build interface")
		set(value) = attrs.setNullable("has pipboy build interface", value)
}

/**
 * Items: 
 * 
 */
object AllBuildingsAttributes {
	operator fun invoke(scope: AllBuildingsAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * Multiplies building build time by this amount
	 * 
	 */
	context(attrs: IKeyValueMap)
	var buildRateBonus: Float?
		get() = attrs.getTyped("build rate bonus")
		set(value) = attrs.setNullable("build rate bonus", value)
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * Add x metal to any building hit using player's metal reserve
	 * 
	 * Recall that all players have 100 hidden metal
	 * 
	 */
	context(attrs: IKeyValueMap)
	var upgradeRateDecrease: Float?
		get() = attrs.getTyped("upgrade rate decrease")
		set(value) = attrs.setNullable("upgrade rate decrease", value)
	
	/**
	 * Value type: percentage
	 * 
	 * Only applied if the building is NOT a disposable sentry
	 * 
	 */
	context(attrs: IKeyValueMap)
	var engyBuildingHealthBonus: Float?
		get() = attrs.getTyped("engy building health bonus")
		set(value) = attrs.setNullable("engy building health bonus", value)
}

/**
 * Items: 
 * 
 */
object SentryAttributes {
	operator fun invoke(scope: SentryAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var engySentryRadiusIncreased: Float?
		get() = attrs.getTyped("engy sentry radius increased")
		set(value) = attrs.setNullable("engy sentry radius increased", value)
}

/**
 * Items: 
 * 
 */
object DispenserAttributes {
	operator fun invoke(scope: DispenserAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var engyDispenserRadiusIncreased: Float?
		get() = attrs.getTyped("engy dispenser radius increased")
		set(value) = attrs.setNullable("engy dispenser radius increased", value)
}

/**
 * Items: 
 * 
 */
object TeleporterAttributes {
	operator fun invoke(scope: TeleporterAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * Value type: percentage
	 * 
	 * Flat mult to metal cost to upgrade teleporter
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modTeleporterCost: Float?
		get() = attrs.getTyped("mod teleporter cost")
		set(value) = attrs.setNullable("mod teleporter cost", value)
	
	
	context(attrs: IKeyValueMap)
	var bidirectionalTeleport: Boolean?
		get() = attrs.getTyped("bidirectional teleport", BinaryIntCodec)
		set(value) = attrs.setNullable("bidirectional teleport", value, BinaryIntCodec)
}

