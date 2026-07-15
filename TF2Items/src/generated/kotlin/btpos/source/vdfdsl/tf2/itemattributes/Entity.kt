package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface EntityAttributes : IBlockScoped {
	companion object : EntityAttributes
	
	/**
	 * In-Game: "Cannot be backstabbed"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var cannotBeBackstabbed: Boolean?
		get() = attrs.getTyped("cannot be backstabbed", BinaryIntCodec)
		set(value) = attrs.setNullable("cannot be backstabbed", value, BinaryIntCodec)
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var increasedJumpHeight: Number?
		get() = attrs.getTyped("increased jump height")
		set(value) = attrs.setNullable("increased jump height", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var majorIncreasedJumpHeight: Number?
		get() = attrs.getTyped("major increased jump height")
		set(value) = attrs.setNullable("major increased jump height", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var halloweenIncreasedJumpHeight: Number?
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
	val healthFromPacks get() = BonusPenalty<Number, Number>("health from packs increased", "health from packs decreased")
	
	/**
	 * In-Game: "N% less healing from Medic sources"
	 *
	 * 
	 *
	 * Specifically checked on Crossbow Bolt impacts.
	 */
	context(attrs: IKeyValueMap)
	var reducedHealingFromMedics: Number?
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
	context(attrs: IKeyValueMap)
	var hypeResetsOnJump: Int?
		get() = attrs.getTyped("hype resets on jump")
		set(value) = attrs.setNullable("hype resets on jump", value)
	
	/**
	 * 
	 *
	 * Allows parachute to be deployed.
	 */
	context(attrs: IKeyValueMap)
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
	context(attrs: IKeyValueMap)
	var hasPipboyBuildInterface: Int?
		get() = attrs.getTyped("has pipboy build interface")
		set(value) = attrs.setNullable("has pipboy build interface", value)
	
	/**
	 * 
	 */
	val buildings get() = BuildingsAttributes
}


object BuildingsAttributes {
	inline operator fun invoke(scope: BuildingsAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "+N% faster build speed"
	 */
	context(attrs: IKeyValueMap)
	var buildRateBonus: Number?
		get() = attrs.getTyped("build rate bonus")
		set(value) = attrs.setNullable("build rate bonus", value)
	
	/**
	 * In-Game: "N% slower upgrade rate"
	 */
	context(attrs: IKeyValueMap)
	var upgradeRateDecrease: Number?
		get() = attrs.getTyped("upgrade rate decrease")
		set(value) = attrs.setNullable("upgrade rate decrease", value)
	
	/**
	 * In-Game: "+N% max building health"
	 */
	context(attrs: IKeyValueMap)
	var engyBuildingHealthBonus: Number?
		get() = attrs.getTyped("engy building health bonus")
		set(value) = attrs.setNullable("engy building health bonus", value)
	
	
	val sentryGun get() = SentryGunAttributes
}


object SentryGunAttributes {
	inline operator fun invoke(scope: SentryGunAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "+N% sentry range"
	 */
	context(attrs: IKeyValueMap)
	var engySentryRadiusIncreased: Number?
		get() = attrs.getTyped("engy sentry radius increased")
		set(value) = attrs.setNullable("engy sentry radius increased", value)
	
	/**
	 * In-Game: "+N% sentry firing speed"
	 */
	context(attrs: IKeyValueMap)
	var engySentryFireRateIncreased: Number?
		get() = attrs.getTyped("engy sentry fire rate increased")
		set(value) = attrs.setNullable("engy sentry fire rate increased", value)
	
	
	val dispenser get() = DispenserAttributes
	
	
	val teleporter get() = TeleporterAttributes
}


object DispenserAttributes {
	inline operator fun invoke(scope: DispenserAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "+N% dispenser range"
	 */
	context(attrs: IKeyValueMap)
	var engyDispenserRadiusIncreased: Number?
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
	context(attrs: IKeyValueMap)
	var teleporterCost: Number?
		get() = attrs.getTyped("mod teleporter cost")
		set(value) = attrs.setNullable("mod teleporter cost", value)
	
	/**
	 * In-Game: "Teleporters can be used in both directions"
	 */
	context(attrs: IKeyValueMap)
	var bidirectionalTeleport: Boolean?
		get() = attrs.getTyped("bidirectional teleport", BinaryIntCodec)
		set(value) = attrs.setNullable("bidirectional teleport", value, BinaryIntCodec)
}

