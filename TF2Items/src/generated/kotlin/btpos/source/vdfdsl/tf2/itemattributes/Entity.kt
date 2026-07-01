package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.itemattributes.impl.BonusPenalty
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


interface EntityAttributes : IBlockScoped {
	companion object : EntityAttributes
	
	/**
	 * In-Game: "Cannot be backstabbed"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var cannotBeBackstabbed: Boolean?
		get() = attrs.getTyped("cannot be backstabbed", BinaryIntCodec)
		set(value) = attrs.setNullable("cannot be backstabbed", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	val buildings get() = BuildingsAttributes
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var increasedJumpHeight: Float?
		get() = attrs.getTyped("increased jump height")
		set(value) = attrs.setNullable("increased jump height", value)
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var majorIncreasedJumpHeight: Float?
		get() = attrs.getTyped("major increased jump height")
		set(value) = attrs.setNullable("major increased jump height", value)
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var halloweenIncreasedJumpHeight: Float?
		get() = attrs.getTyped("halloween increased jump height")
		set(value) = attrs.setNullable("halloween increased jump height", value)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% health from packs on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% health from packs on wearer"
	 *
	 * 
	 */
	val healthFromPacks get() = BonusPenalty<Float, Float>("health from packs increased", "health from packs decreased")
	
	/**
	 * In-Game: "N% less healing from Medic sources"
	 *
	 * 
	 *
	 * Only on crossbow impacts.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var reducedHealingFromMedics: Float?
		get() = attrs.getTyped("reduced_healing_from_medics")
		set(value) = attrs.setNullable("reduced_healing_from_medics", value)
	
	/**
	 * In-Game: "Boost reduced on air jumps"
	 *
	 * 
	 *
	 * Lose this amount of hype if you airdash.
	 *
	 * Note that this only applies to scout hype, not rage in general.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var hypeResetsOnJump: Int?
		get() = attrs.getTyped("hype resets on jump")
		set(value) = attrs.setNullable("hype resets on jump", value)
	
	/**
	 * 
	 *
	 * Allows parachute to be deployed.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var parachuteAttribute: Boolean?
		get() = attrs.getTyped("parachute attribute", BinaryIntCodec)
		set(value) = attrs.setNullable("parachute attribute", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Only used if the build menu is actually shown.
	 *
	 * 0 = default.
	 *
	 * 1 = pipboy.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var hasPipboyBuildInterface: Int?
		get() = attrs.getTyped("has pipboy build interface")
		set(value) = attrs.setNullable("has pipboy build interface", value)
}


object BuildingsAttributes {
	inline operator fun invoke(scope: BuildingsAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	val allBuildings get() = AllBuildingsAttributes
	
	
	val sentry get() = SentryAttributes
	
	
	val dispenser get() = DispenserAttributes
	
	
	val teleporter get() = TeleporterAttributes
}


object AllBuildingsAttributes {
	inline operator fun invoke(scope: AllBuildingsAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * In-Game: "+N% faster build speed"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var buildRateBonus: Float?
		get() = attrs.getTyped("build rate bonus")
		set(value) = attrs.setNullable("build rate bonus", value)
	
	/**
	 * In-Game: "N% slower upgrade rate"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var upgradeRateDecrease: Float?
		get() = attrs.getTyped("upgrade rate decrease")
		set(value) = attrs.setNullable("upgrade rate decrease", value)
	
	/**
	 * In-Game: "+N% max building health"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var engyBuildingHealthBonus: Float?
		get() = attrs.getTyped("engy building health bonus")
		set(value) = attrs.setNullable("engy building health bonus", value)
}


object SentryAttributes {
	inline operator fun invoke(scope: SentryAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * In-Game: "+N% sentry range"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var engySentryRadiusIncreased: Float?
		get() = attrs.getTyped("engy sentry radius increased")
		set(value) = attrs.setNullable("engy sentry radius increased", value)
}


object DispenserAttributes {
	inline operator fun invoke(scope: DispenserAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * In-Game: "+N% dispenser range"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var engyDispenserRadiusIncreased: Float?
		get() = attrs.getTyped("engy dispenser radius increased")
		set(value) = attrs.setNullable("engy dispenser radius increased", value)
}


object TeleporterAttributes {
	inline operator fun invoke(scope: TeleporterAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * In-Game: "N% metal cost when constructing or upgrading teleporters"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var teleporterCost: Float?
		get() = attrs.getTyped("mod teleporter cost")
		set(value) = attrs.setNullable("mod teleporter cost", value)
	
	/**
	 * In-Game: "Teleporters can be used in both directions"
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var bidirectionalTeleport: Boolean?
		get() = attrs.getTyped("bidirectional teleport", BinaryIntCodec)
		set(value) = attrs.setNullable("bidirectional teleport", value, BinaryIntCodec)
}

