package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface EntityAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Cannot be backstabbed"
		 *
		 * 
		 */
		val cannotBeBackstabbed = ItemAttributeNamed<Boolean>("cannot be backstabbed")
		
		/**
		 * In-Game: "+N% greater jump height when active"
		 *
		 * 
		 */
		val increasedJumpHeight = ItemAttributeNamed<Float>("increased jump height")
		
		/**
		 * 
		 */
		val majorIncreasedJumpHeight = ItemAttributeNamed<Float>("major increased jump height")
		
		/**
		 * 
		 */
		val halloweenIncreasedJumpHeight = ItemAttributeNamed<Float>("halloween increased jump height")
		
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
		val healthFromPacks = BonusPenalty(
			ItemAttributeNamed<Float>("health from packs increased"),
			ItemAttributeNamed<Float>("health from packs decreased")
		)
		
		/**
		 * In-Game: "N% less healing from Medic sources"
		 *
		 * 
		 *
		 * Specifically checked on Crossbow Bolt impacts.
		 */
		val reducedHealingFromMedics = ItemAttributeNamed<Float>("reduced_healing_from_medics")
		
		/**
		 * In-Game: "Boost reduced on air jumps"
		 *
		 * 
		 *
		 * Lose this amount of hype if you airdash.
		 *
		 * Note that this only applies to scout hype, not rage in general.
		 */
		val hypeResetsOnJump = ItemAttributeNamed<Int>("hype resets on jump")
		
		/**
		 * 
		 *
		 * Allows parachute to be deployed.
		 */
		val parachuteAttribute = ItemAttributeNamed<Boolean>("parachute attribute")
		
		/**
		 * 
		 *
		 * Only used if the build menu is actually shown.
		 *
		 * 0 = default.
		 *
		 * 1 = pipboy.
		 */
		val hasPipboyBuildInterface = ItemAttributeNamed<Int>("has pipboy build interface")
		
		/**
		 * 
		 */
		val buildings = BuildingsAttributes()
	}

	/**
	 * In-Game: "Cannot be backstabbed"
	 *
	 * 
	 */
	val cannotBeBackstabbed: ItemAttribute<Boolean> get() = EntityAttributes.cannotBeBackstabbed
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 *
	 * 
	 */
	val increasedJumpHeight: ItemAttribute<Float> get() = EntityAttributes.increasedJumpHeight
	
	/**
	 * 
	 */
	val majorIncreasedJumpHeight: ItemAttribute<Float> get() = EntityAttributes.majorIncreasedJumpHeight
	
	/**
	 * 
	 */
	val halloweenIncreasedJumpHeight: ItemAttribute<Float> get() = EntityAttributes.halloweenIncreasedJumpHeight
	
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
	val healthFromPacks: ItemAttribute<Float> get() = EntityAttributes.healthFromPacks
	
	/**
	 * In-Game: "N% less healing from Medic sources"
	 *
	 * 
	 *
	 * Specifically checked on Crossbow Bolt impacts.
	 */
	val reducedHealingFromMedics: ItemAttribute<Float> get() = EntityAttributes.reducedHealingFromMedics
	
	/**
	 * In-Game: "Boost reduced on air jumps"
	 *
	 * 
	 *
	 * Lose this amount of hype if you airdash.
	 *
	 * Note that this only applies to scout hype, not rage in general.
	 */
	val hypeResetsOnJump: ItemAttribute<Int> get() = EntityAttributes.hypeResetsOnJump
	
	/**
	 * 
	 *
	 * Allows parachute to be deployed.
	 */
	val parachuteAttribute: ItemAttribute<Boolean> get() = EntityAttributes.parachuteAttribute
	
	/**
	 * 
	 *
	 * Only used if the build menu is actually shown.
	 *
	 * 0 = default.
	 *
	 * 1 = pipboy.
	 */
	val hasPipboyBuildInterface: ItemAttribute<Int> get() = EntityAttributes.hasPipboyBuildInterface
	
	/**
	 * 
	 */
	val buildings: ItemAttribute<Buildings> get() = EntityAttributes.buildings

   
open class BuildingsAttributes : IBlockScoped {
	/**
	 * In-Game: "+N% faster build speed"
	 */
	open val buildRateBonus = ItemAttributeNamed<Float>("build rate bonus")
	
	/**
	 * In-Game: "N% slower upgrade rate"
	 */
	open val upgradeRateDecrease = ItemAttributeNamed<Int>("upgrade rate decrease")
	
	/**
	 * In-Game: "+N% max building health"
	 */
	open val engyBuildingHealthBonus = ItemAttributeNamed<Int>("engy building health bonus")
	
	
	open val sentryGun = SentryGunAttributes()
	
	
	open val dispenser = DispenserAttributes()
	
	
	open val teleporter = TeleporterAttributes()

	
open class SentryGunAttributes : IBlockScoped {
	/**
	 * In-Game: "+N% sentry range"
	 */
	open val engySentryRadiusIncreased = ItemAttributeNamed<Float>("engy sentry radius increased")
	
	/**
	 * In-Game: "+N% sentry firing speed"
	 */
	open val engySentryFireRateIncreased = ItemAttributeNamed<Float>("engy sentry fire rate increased")

	
}	
open class DispenserAttributes : IBlockScoped {
	/**
	 * In-Game: "+N% dispenser range"
	 */
	open val engyDispenserRadiusIncreased = ItemAttributeNamed<Float>("engy dispenser radius increased")

	
}	
open class TeleporterAttributes : IBlockScoped {
	/**
	 * In-Game: "N% metal cost when constructing or upgrading teleporters"
	 */
	open val teleporterCost = ItemAttributeNamed<Float>("mod teleporter cost")
	
	/**
	 * In-Game: "Teleporters can be used in both directions"
	 */
	open val bidirectionalTeleport = ItemAttributeNamed<Boolean>("bidirectional teleport")

	
}
}
}

