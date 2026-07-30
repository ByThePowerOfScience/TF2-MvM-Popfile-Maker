package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface EntityAttributes : IBlockScoped {
	companion object {
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val hud: HudAttributes = HudAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}

	val buildings: BuildingsAttributes get() = EntityAttributes.buildings
	
	val healthAndHealing: HealthAndHealingAttributes get() = EntityAttributes.healthAndHealing
	
	val meta: MetaAttributes get() = EntityAttributes.meta
	
	val meter: MeterAttributes get() = EntityAttributes.meter
	
	val movement: MovementAttributes get() = EntityAttributes.movement
	
	val hud: HudAttributes get() = EntityAttributes.hud
	
	val resistance: ResistanceAttributes get() = EntityAttributes.resistance

	open class BuildingsAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% faster build speed"
		 * 
		 * Multiplies building build time by this amount.
		 */
		open val buildRateBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("build rate bonus")
	
		/**
		 * In-Game: "N% slower upgrade rate"
		 * 
		 * Add this amount of metal to any building hit by this player, using player's metal reserve.
		 * 
		 * Recall that all players have 100 hidden metal.
		 */
		open val upgradeRateDecrease: ItemAttributeNamed<Int> = ItemAttributeNamed("upgrade rate decrease")
	
		/**
		 * In-Game: "+N% max building health"
		 * 
		 * Only applied if the building is NOT a disposable sentry.
		 */
		open val engyBuildingHealthBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("engy building health bonus")
	
		open val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open val dispenser: DispenserAttributes = DispenserAttributes()
	
		open val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% sentry range"
			 */
			open val engySentryRadiusIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("engy sentry radius increased")
	
			/**
			 * In-Game: "+N% sentry firing speed"
			 */
			open val engySentryFireRateIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("engy sentry fire rate increased")
		}
	
		open class DispenserAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% dispenser range"
			 */
			open val engyDispenserRadiusIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("engy dispenser radius increased")
		}
	
		open class TeleporterAttributes : IBlockScoped {
			/**
			 * In-Game: "N% metal cost when constructing or upgrading teleporters"
			 * 
			 * Flat mult to metal cost to build.
			 */
			open val teleporterCost: ItemAttributeNamed<Float> = ItemAttributeNamed("mod teleporter cost")
	
			/**
			 * In-Game: "Teleporters can be used in both directions"
			 */
			open val bidirectionalTeleport: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bidirectional teleport")
		}
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		open val healthFromPacks: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("health from packs increased"),
			ItemAttributeNamed("health from packs decreased"),
		)
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Specifically checked on Crossbow Bolt impacts.
		 */
		open val reducedHealingFromMedics: ItemAttributeNamed<Float> = ItemAttributeNamed("reduced_healing_from_medics")
	}
	
	open class MetaAttributes : IBlockScoped 
	
	open class MeterAttributes : IBlockScoped {
		/**
		 * In-Game: "Boost reduced on air jumps"
		 * 
		 * Lose this amount of hype if you airdash.
		 * 
		 * Note that this only applies to scout hype, not rage in general.
		 */
		open val hypeResetsOnJump: ItemAttributeNamed<Int> = ItemAttributeNamed("hype resets on jump")
	}
	
	open class MovementAttributes : IBlockScoped {
		/**
		 * Allows parachute to be deployed. Parachute prop only appears if the BASE Jumper is equipped, but the functionality is the same regardless.
		 */
		open val parachuteAttribute: ItemAttributeNamed<Boolean> = ItemAttributeNamed("parachute attribute")
	
		open val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open class jumpHeightAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% greater jump height when active"
			 */
			open val increasedJumpHeight: ItemAttributeNamed<Float> = ItemAttributeNamed("increased jump height")
	
			open val majorIncreasedJumpHeight: ItemAttributeNamed<Float> = ItemAttributeNamed("major increased jump height")
	
			open val halloweenIncreasedJumpHeight: ItemAttributeNamed<Float> = ItemAttributeNamed("halloween increased jump height")
		}
	}
	
	open class HudAttributes : IBlockScoped {
		/**
		 * Only used if the build menu is actually shown.
		 * 
		 * 0 = default.
		 * 
		 * 1 = pipboy.
		 */
		open val hasPipboyBuildInterface: ItemAttributeNamed<Int> = ItemAttributeNamed("has pipboy build interface")
	}
	
	open class ResistanceAttributes : IBlockScoped {
		/**
		 * In-Game: "Cannot be backstabbed"
		 */
		open val cannotBeBackstabbed: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot be backstabbed")
	}
}