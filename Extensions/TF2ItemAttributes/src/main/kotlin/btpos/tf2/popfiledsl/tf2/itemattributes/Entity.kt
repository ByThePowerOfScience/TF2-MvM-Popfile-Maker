package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class EntityAttributes {
	companion object : EntityAttributes() {
		operator fun invoke(scope: EntityAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
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
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	val healthFromPacksDecreased = BonusPenalty<Float, Float>("health from packs increased", "health from packs decreased")
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
	 */
	context(attrs: IKeyValueMap)
	var buildRateBonus: Float?
		get() = attrs.getTyped("build rate bonus")
		set(value) = attrs.setNullable("build rate bonus", value)
}

/**
 * Items: 
 * 
 */
object SentryAttributes {
	operator fun invoke(scope: SentryAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	
}

/**
 * Items: 
 * 
 */
object DispenserAttributes {
	operator fun invoke(scope: DispenserAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	
}

/**
 * Items: 
 * 
 */
object TeleporterAttributes {
	operator fun invoke(scope: TeleporterAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	
}

