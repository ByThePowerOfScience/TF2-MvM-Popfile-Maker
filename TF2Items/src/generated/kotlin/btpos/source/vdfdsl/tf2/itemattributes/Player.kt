package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PlayerAttributes : BaseEntityAttributes {
	companion object : IBlockScoped {
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val cloak: CloakAttributes = CloakAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val hud: HudAttributes = HudAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}

	val ammo: AmmoAttributes get() = PlayerAttributes.ammo
	
	val buffItems: BuffItemsAttributes get() = PlayerAttributes.buffItems
	
	val buildings: BuildingsAttributes get() = PlayerAttributes.buildings
	
	val cloak: CloakAttributes get() = PlayerAttributes.cloak
	
	override val damage: DamageAttributes get() = PlayerAttributes.damage
	
	val demoCharge: DemoChargeAttributes get() = PlayerAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = PlayerAttributes.disguise
	
	val firing: FiringAttributes get() = PlayerAttributes.firing
	
	val heads: HeadsAttributes get() = PlayerAttributes.heads
	
	val healthAndHealing: HealthAndHealingAttributes get() = PlayerAttributes.healthAndHealing
	
	val hud: HudAttributes get() = PlayerAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = PlayerAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = PlayerAttributes.meta
	
	override val meter: MeterAttributes get() = PlayerAttributes.meter
	
	val movement: MovementAttributes get() = PlayerAttributes.movement
	
	val onHit: OnHitAttributes get() = PlayerAttributes.onHit
	
	val onKill: OnKillAttributes get() = PlayerAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = PlayerAttributes.resistance
	
	val taunting: TauntingAttributes get() = PlayerAttributes.taunting
	
	val swapWeapons: SwapWeaponsAttributes get() = PlayerAttributes.swapWeapons
	
	val whenHit: WhenHitAttributes get() = PlayerAttributes.whenHit
	
	val spyOnly: SpyOnlyAttributes get() = PlayerAttributes.spyOnly
	
	override val crits: CritsAttributes get() = PlayerAttributes.crits

	open class AmmoAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val grenades1ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades1_resupply_denied")
	
			val grenades2ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades2_resupply_denied")
	
			val grenades3ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades3_resupply_denied")
	
			/**
			 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
			 * 
			 * Percentage of ammo regenerated every 5 seconds.
			 */
			val ammoRegen: ItemAttributeNamed<Number> = ItemAttributeNamed("ammo regen")
	
			/**
			 * In-Game: "N% less metal from pickups and dispensers"
			 * 
			 * Multiplier applied to metal gained from ammo boxes.
			 */
			val metalPickupDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("metal_pickup_decreased")
	
			/**
			 * In-Game: "+N metal regenerated every 5 seconds on wearer"
			 * 
			 * Amount of metal regenerated every 5 seconds.
			 */
			val metalRegen: ItemAttributeNamed<Int> = ItemAttributeNamed("metal regen")
	
			val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
		}
	
		context(attrs: IAttributeContainer)
		open var grenades1ResupplyDenied: Boolean? 
			get() = AmmoAttributes.grenades1ResupplyDenied.get()
			set(value) { AmmoAttributes.grenades1ResupplyDenied.set(value) }
	
		context(attrs: IAttributeContainer)
		open var grenades2ResupplyDenied: Boolean? 
			get() = AmmoAttributes.grenades2ResupplyDenied.get()
			set(value) { AmmoAttributes.grenades2ResupplyDenied.set(value) }
	
		context(attrs: IAttributeContainer)
		open var grenades3ResupplyDenied: Boolean? 
			get() = AmmoAttributes.grenades3ResupplyDenied.get()
			set(value) { AmmoAttributes.grenades3ResupplyDenied.set(value) }
	
		/**
		 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
		 * 
		 * Percentage of ammo regenerated every 5 seconds.
		 */
		context(attrs: IAttributeContainer)
		open var ammoRegen: Number? 
			get() = AmmoAttributes.ammoRegen.get()
			set(value) { AmmoAttributes.ammoRegen.set(value) }
	
		/**
		 * In-Game: "N% less metal from pickups and dispensers"
		 * 
		 * Multiplier applied to metal gained from ammo boxes.
		 */
		context(attrs: IAttributeContainer)
		open var metalPickupDecreased: Number? 
			get() = AmmoAttributes.metalPickupDecreased.get()
			set(value) { AmmoAttributes.metalPickupDecreased.set(value) }
	
		/**
		 * In-Game: "+N metal regenerated every 5 seconds on wearer"
		 * 
		 * Amount of metal regenerated every 5 seconds.
		 */
		context(attrs: IAttributeContainer)
		open var metalRegen: Int? 
			get() = AmmoAttributes.metalRegen.get()
			set(value) { AmmoAttributes.metalRegen.set(value) }
	
		open val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : IBlockScoped {
			companion object : IBlockScoped {
				val maxammoPrimaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
					ItemAttributeNamed<Int>("maxammo primary increased"),
					ItemAttributeNamed<Int>("maxammo primary reduced"),
					ItemAttributeNamed<Int>("hidden primary max ammo bonus"),
				)
	
				val maxammoSecondaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
					ItemAttributeNamed<Int>("maxammo secondary increased"),
					ItemAttributeNamed<Int>("maxammo secondary reduced"),
					ItemAttributeNamed<Int>("hidden secondary max ammo penalty"),
				)
	
				val maxammoMetalReduced: BonusPenalty<Int> = BonusPenalty(
					ItemAttributeNamed("maxammo metal increased"),
					ItemAttributeNamed("maxammo metal reduced"),
				)
	
				/**
				 * In-Game: "+N% max misc ammo on wearer"
				 * 
				 * Only used for bat balls.
				 */
				val maxammoGrenades1Increased: ItemAttributeNamed<Int> = ItemAttributeNamed("maxammo grenades1 increased")
			}
	
			context(attrs: IAttributeContainer)
			open var maxammoPrimaryReduced: Int? 
				get() = MaxAmmoAttributes.maxammoPrimaryReduced.get()
				set(value) { MaxAmmoAttributes.maxammoPrimaryReduced.set(value) }
	
			context(attrs: IAttributeContainer)
			open var maxammoSecondaryReduced: Int? 
				get() = MaxAmmoAttributes.maxammoSecondaryReduced.get()
				set(value) { MaxAmmoAttributes.maxammoSecondaryReduced.set(value) }
	
			context(attrs: IAttributeContainer)
			open var maxammoMetalReduced: Int? 
				get() = MaxAmmoAttributes.maxammoMetalReduced.get()
				set(value) { MaxAmmoAttributes.maxammoMetalReduced.set(value) }
	
			/**
			 * In-Game: "+N% max misc ammo on wearer"
			 * 
			 * Only used for bat balls.
			 */
			context(attrs: IAttributeContainer)
			open var maxammoGrenades1Increased: Int? 
				get() = MaxAmmoAttributes.maxammoGrenades1Increased.get()
				set(value) { MaxAmmoAttributes.maxammoGrenades1Increased.set(value) }
		}
	}
	
	open class BuffItemsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
			val buffDuration: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("increase buff duration"), ItemAttributeNamed<Number>("increase buff duration HIDDEN"))
		}
	
		context(attrs: IAttributeContainer)
		open var buffDuration: Number? 
			get() = BuffItemsAttributes.buffDuration.get()
			set(value) { BuffItemsAttributes.buffDuration.set(value) }
	
		open val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		open class BuffTypeAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
				 */
				val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
				/**
				 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
				 */
				val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
			}
	
			/**
			 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
			 */
			context(attrs: IAttributeContainer)
			open var soldierBuffType: Int? 
				get() = BuffTypeAttributes.soldierBuffType.get()
				set(value) { BuffTypeAttributes.soldierBuffType.set(value) }
	
			/**
			 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
			 */
			context(attrs: IAttributeContainer)
			open var demoBuffType: Int? 
				get() = BuffTypeAttributes.demoBuffType.get()
				set(value) { BuffTypeAttributes.demoBuffType.set(value) }
		}
	}
	
	open class BuildingsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "+N% faster build speed"
			 * 
			 * Multiplies building build time by this amount.
			 */
			val buildRateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("build rate bonus")
	
			/**
			 * In-Game: "N% slower upgrade rate"
			 * 
			 * Add this amount of metal to any building hit by this player, using player's metal reserve.
			 * 
			 * Recall that all players have 100 hidden metal.
			 */
			val upgradeRateDecrease: ItemAttributeNamed<Int> = ItemAttributeNamed("upgrade rate decrease")
	
			/**
			 * In-Game: "+N% max building health"
			 * 
			 * Only applied if the building is NOT a disposable sentry.
			 */
			val engyBuildingHealthBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("engy building health bonus")
	
			/**
			 * In-Game: "Cannot carry buildings"
			 * 
			 * Prevents player from picking up buildings.
			 */
			val cannotPickUpBuildings: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up buildings")
	
			/**
			 * In-Game: "N metal reduction in building cost"
			 * 
			 * Sets the cost to construct any building type to this value.
			 */
			val buildingCostReduction: ItemAttributeNamed<Int> = ItemAttributeNamed("building cost reduction")
	
			/**
			 * In-Game: "Sentry build speed increased by N%"
			 */
			val engineerSentryBuildRateMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer sentry build rate multiplier")
	
			val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
			val dispenser: DispenserAttributes = DispenserAttributes()
	
			val teleporter: TeleporterAttributes = TeleporterAttributes()
		}
	
		/**
		 * In-Game: "+N% faster build speed"
		 * 
		 * Multiplies building build time by this amount.
		 */
		context(attrs: IAttributeContainer)
		open var buildRateBonus: Number? 
			get() = BuildingsAttributes.buildRateBonus.get()
			set(value) { BuildingsAttributes.buildRateBonus.set(value) }
	
		/**
		 * In-Game: "N% slower upgrade rate"
		 * 
		 * Add this amount of metal to any building hit by this player, using player's metal reserve.
		 * 
		 * Recall that all players have 100 hidden metal.
		 */
		context(attrs: IAttributeContainer)
		open var upgradeRateDecrease: Int? 
			get() = BuildingsAttributes.upgradeRateDecrease.get()
			set(value) { BuildingsAttributes.upgradeRateDecrease.set(value) }
	
		/**
		 * In-Game: "+N% max building health"
		 * 
		 * Only applied if the building is NOT a disposable sentry.
		 */
		context(attrs: IAttributeContainer)
		open var engyBuildingHealthBonus: Int? 
			get() = BuildingsAttributes.engyBuildingHealthBonus.get()
			set(value) { BuildingsAttributes.engyBuildingHealthBonus.set(value) }
	
		/**
		 * In-Game: "Cannot carry buildings"
		 * 
		 * Prevents player from picking up buildings.
		 */
		context(attrs: IAttributeContainer)
		open var cannotPickUpBuildings: Boolean? 
			get() = BuildingsAttributes.cannotPickUpBuildings.get()
			set(value) { BuildingsAttributes.cannotPickUpBuildings.set(value) }
	
		/**
		 * In-Game: "N metal reduction in building cost"
		 * 
		 * Sets the cost to construct any building type to this value.
		 */
		context(attrs: IAttributeContainer)
		open var buildingCostReduction: Int? 
			get() = BuildingsAttributes.buildingCostReduction.get()
			set(value) { BuildingsAttributes.buildingCostReduction.set(value) }
	
		/**
		 * In-Game: "Sentry build speed increased by N%"
		 */
		context(attrs: IAttributeContainer)
		open var engineerSentryBuildRateMultiplier: Number? 
			get() = BuildingsAttributes.engineerSentryBuildRateMultiplier.get()
			set(value) { BuildingsAttributes.engineerSentryBuildRateMultiplier.set(value) }
	
		open val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open val dispenser: DispenserAttributes = DispenserAttributes()
	
		open val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% sentry range"
				 */
				val engySentryRadiusIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("engy sentry radius increased")
	
				/**
				 * In-Game: "+N% sentry firing speed"
				 */
				val engySentryFireRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("engy sentry fire rate increased")
	
				/**
				 * In-Game: "Build +N additional disposable-sentry"
				 * 
				 * Number of disposable sentries you're allowed to build.
				 * 
				 * Checked when checking if the player can build something.
				 * 
				 * Only works if the "uses upgrades" gamerule is set.
				 */
				val engyDisposableSentries: ItemAttributeNamed<Int> = ItemAttributeNamed("engy disposable sentries")
			}
	
			/**
			 * In-Game: "+N% sentry range"
			 */
			context(attrs: IAttributeContainer)
			open var engySentryRadiusIncreased: Number? 
				get() = SentryGunAttributes.engySentryRadiusIncreased.get()
				set(value) { SentryGunAttributes.engySentryRadiusIncreased.set(value) }
	
			/**
			 * In-Game: "+N% sentry firing speed"
			 */
			context(attrs: IAttributeContainer)
			open var engySentryFireRateIncreased: Number? 
				get() = SentryGunAttributes.engySentryFireRateIncreased.get()
				set(value) { SentryGunAttributes.engySentryFireRateIncreased.set(value) }
	
			/**
			 * In-Game: "Build +N additional disposable-sentry"
			 * 
			 * Number of disposable sentries you're allowed to build.
			 * 
			 * Checked when checking if the player can build something.
			 * 
			 * Only works if the "uses upgrades" gamerule is set.
			 */
			context(attrs: IAttributeContainer)
			open var engyDisposableSentries: Int? 
				get() = SentryGunAttributes.engyDisposableSentries.get()
				set(value) { SentryGunAttributes.engyDisposableSentries.set(value) }
		}
	
		open class DispenserAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% dispenser range"
				 */
				val engyDispenserRadiusIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("engy dispenser radius increased")
	
				/**
				 * In-Game: "Increases teleporter build speed by N%."
				 * 
				 * Multiplier applied to passive build time for dispensers and teleporters.
				 */
				val engineerTeleporterBuildRateMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer teleporter build rate multiplier")
			}
	
			/**
			 * In-Game: "+N% dispenser range"
			 */
			context(attrs: IAttributeContainer)
			open var engyDispenserRadiusIncreased: Number? 
				get() = DispenserAttributes.engyDispenserRadiusIncreased.get()
				set(value) { DispenserAttributes.engyDispenserRadiusIncreased.set(value) }
	
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			context(attrs: IAttributeContainer)
			open var engineerTeleporterBuildRateMultiplier: Number? 
				get() = DispenserAttributes.engineerTeleporterBuildRateMultiplier.get()
				set(value) { DispenserAttributes.engineerTeleporterBuildRateMultiplier.set(value) }
		}
	
		open class TeleporterAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Teleporters can be used in both directions"
				 */
				val bidirectionalTeleport: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bidirectional teleport")
	
				/**
				 * In-Game: "N% metal cost when constructing or upgrading teleporters"
				 * 
				 * Multiplier applied to teleporter construction cost.
				 */
				val teleporterCost: ItemAttributeNamed<Number> = ItemAttributeNamed("mod teleporter cost")
	
				/**
				 * In-Game: "Increases teleporter build speed by N%."
				 * 
				 * Multiplier applied to passive build time for dispensers and teleporters.
				 */
				val engineerTeleporterBuildRateMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer teleporter build rate multiplier")
			}
	
			/**
			 * In-Game: "Teleporters can be used in both directions"
			 */
			context(attrs: IAttributeContainer)
			open var bidirectionalTeleport: Boolean? 
				get() = TeleporterAttributes.bidirectionalTeleport.get()
				set(value) { TeleporterAttributes.bidirectionalTeleport.set(value) }
	
			/**
			 * In-Game: "N% metal cost when constructing or upgrading teleporters"
			 * 
			 * Multiplier applied to teleporter construction cost.
			 */
			context(attrs: IAttributeContainer)
			open var teleporterCost: Number? 
				get() = TeleporterAttributes.teleporterCost.get()
				set(value) { TeleporterAttributes.teleporterCost.set(value) }
	
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			context(attrs: IAttributeContainer)
			open var engineerTeleporterBuildRateMultiplier: Number? 
				get() = TeleporterAttributes.engineerTeleporterBuildRateMultiplier.get()
				set(value) { TeleporterAttributes.engineerTeleporterBuildRateMultiplier.set(value) }
		}
	}
	
	open class CloakAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "N sec longer cloak blink time"
			 * 
			 * Multiplier.
			 */
			val setBonusCloakBlinkTimePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: cloak blink time penalty")
	
			/**
			 * In-Game: "N sec increase in time to cloak"
			 */
			val multCloakRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult cloak rate")
	
			/**
			 * In-Game: "Reduced decloak sound volume"
			 * 
			 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
			 */
			val setBonusQuietUnstealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: quiet unstealth")
	
			val multDecloakRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult decloak rate")
		}
	
		/**
		 * In-Game: "N sec longer cloak blink time"
		 * 
		 * Multiplier.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusCloakBlinkTimePenalty: Number? 
			get() = CloakAttributes.setBonusCloakBlinkTimePenalty.get()
			set(value) { CloakAttributes.setBonusCloakBlinkTimePenalty.set(value) }
	
		/**
		 * In-Game: "N sec increase in time to cloak"
		 */
		context(attrs: IAttributeContainer)
		open var multCloakRate: Number? 
			get() = CloakAttributes.multCloakRate.get()
			set(value) { CloakAttributes.multCloakRate.set(value) }
	
		/**
		 * In-Game: "Reduced decloak sound volume"
		 * 
		 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusQuietUnstealth: Boolean? 
			get() = CloakAttributes.setBonusQuietUnstealth.get()
			set(value) { CloakAttributes.setBonusQuietUnstealth.set(value) }
	
		context(attrs: IAttributeContainer)
		open var multDecloakRate: Number? 
			get() = CloakAttributes.multDecloakRate.get()
			set(value) { CloakAttributes.multDecloakRate.set(value) }
	}
	
	open class DamageAttributes : BaseEntityAttributes.DamageAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Deals 3x falling damage to the player you land on"
			 * 
			 * Deal 3x falling damage to player you land on.
			 */
			val bootsFallingStomp: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boots falling stomp")
	
			/**
			 * In-Game: "Headshots deal an extra +N% damage"
			 * 
			 * Multiplier applied to headshot damage.
			 */
			val headshotDamageIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("headshot damage increase")
	
			val alien: AlienAttributes = AlienAttributes()
		}
	
		/**
		 * In-Game: "Deals 3x falling damage to the player you land on"
		 * 
		 * Deal 3x falling damage to player you land on.
		 */
		context(attrs: IAttributeContainer)
		open var bootsFallingStomp: Boolean? 
			get() = DamageAttributes.bootsFallingStomp.get()
			set(value) { DamageAttributes.bootsFallingStomp.set(value) }
	
		/**
		 * In-Game: "Headshots deal an extra +N% damage"
		 * 
		 * Multiplier applied to headshot damage.
		 */
		context(attrs: IAttributeContainer)
		open var headshotDamageIncrease: Number? 
			get() = DamageAttributes.headshotDamageIncrease.get()
			set(value) { DamageAttributes.headshotDamageIncrease.set(value) }
	
		open val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Increased Melee damage against Isolated Merc Set"
				 * 
				 * Deal extra damage to players wearing the Alien set.
				 */
				val setBonusAlienIsolationXenoBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation xeno bonus pos")
	
				/**
				 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
				 * 
				 * Deal extra damage to players wearing the Xenomorph set.
				 */
				val setBonusAlienIsolationMercBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation merc bonus pos")
			}
	
			/**
			 * In-Game: "Increased Melee damage against Isolated Merc Set"
			 * 
			 * Deal extra damage to players wearing the Alien set.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusAlienIsolationXenoBonusPos: Boolean? 
				get() = AlienAttributes.setBonusAlienIsolationXenoBonusPos.get()
				set(value) { AlienAttributes.setBonusAlienIsolationXenoBonusPos.set(value) }
	
			/**
			 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
			 * 
			 * Deal extra damage to players wearing the Xenomorph set.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusAlienIsolationMercBonusPos: Boolean? 
				get() = AlienAttributes.setBonusAlienIsolationMercBonusPos.get()
				set(value) { AlienAttributes.setBonusAlienIsolationMercBonusPos.set(value) }
		}
	}
	
	open class DemoChargeAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
			/**
			 * In-Game: "Taking damage while shield charging reduces remaining charging time"
			 * 
			 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
			 */
			val loseDemoChargeOnDamageWhenCharging: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lose demo charge on damage when charging")
	
			/**
			 * In-Game: "Melee kills refill N% of your charge meter."
			 * 
			 * Amount of targe-charge meter gained on kill.  Scaled by various values.
			 */
			val killRefillsMeter: ItemAttributeNamed<Number> = ItemAttributeNamed("kill refills meter")
	
			val chargeTime: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("charge time increased"), ItemAttributeNamed<Number>("charge time decreased"))
	
			/**
			 * In-Game: "+N% increase in charge recharge rate"
			 * 
			 * Only applies to Demoman.
			 */
			val chargeRechargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("charge recharge rate increased")
		}
	
		/**
		 * In-Game: "Taking damage while shield charging reduces remaining charging time"
		 * 
		 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
		 */
		context(attrs: IAttributeContainer)
		open var loseDemoChargeOnDamageWhenCharging: Boolean? 
			get() = DemoChargeAttributes.loseDemoChargeOnDamageWhenCharging.get()
			set(value) { DemoChargeAttributes.loseDemoChargeOnDamageWhenCharging.set(value) }
	
		/**
		 * In-Game: "Melee kills refill N% of your charge meter."
		 * 
		 * Amount of targe-charge meter gained on kill.  Scaled by various values.
		 */
		context(attrs: IAttributeContainer)
		open var killRefillsMeter: Number? 
			get() = DemoChargeAttributes.killRefillsMeter.get()
			set(value) { DemoChargeAttributes.killRefillsMeter.set(value) }
	
		context(attrs: IAttributeContainer)
		open var chargeTime: Number? 
			get() = DemoChargeAttributes.chargeTime.get()
			set(value) { DemoChargeAttributes.chargeTime.set(value) }
	
		/**
		 * In-Game: "+N% increase in charge recharge rate"
		 * 
		 * Only applies to Demoman.
		 */
		context(attrs: IAttributeContainer)
		open var chargeRechargeRateIncreased: Number? 
			get() = DemoChargeAttributes.chargeRechargeRateIncreased.get()
			set(value) { DemoChargeAttributes.chargeRechargeRateIncreased.set(value) }
	
		open val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% increase in turning control while charging"
				 * 
				 * Default is 0.45f, and this is a multiplier applied to it.
				 */
				val multChargeTurnControl: ItemAttributeNamed<Number> = ItemAttributeNamed("mult charge turn control")
	
				/**
				 * In-Game: "Full turning control while charging"
				 * 
				 * Default is 0.45f, and this is a multiplier applied to it.
				 */
				val fullChargeTurnControl: ItemAttributeNamed<Number> = ItemAttributeNamed("full charge turn control")
			}
	
			/**
			 * In-Game: "+N% increase in turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			context(attrs: IAttributeContainer)
			open var multChargeTurnControl: Number? 
				get() = MultChargeTurnControlAttributes.multChargeTurnControl.get()
				set(value) { MultChargeTurnControlAttributes.multChargeTurnControl.set(value) }
	
			/**
			 * In-Game: "Full turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			context(attrs: IAttributeContainer)
			open var fullChargeTurnControl: Number? 
				get() = MultChargeTurnControlAttributes.fullChargeTurnControl.get()
				set(value) { MultChargeTurnControlAttributes.fullChargeTurnControl.set(value) }
		}
	}
	
	open class DisguiseAttributes : BaseEntityAttributes.DisguiseAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Immune to fire damage while disguised"
			 * 
			 * Prevent afterburn while disguised.
			 */
			val disguiseNoBurn: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise no burn")
	
			/**
			 * In-Game: "Wearer cannot disguise"
			 */
			val cannotDisguise: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot disguise")
		}
	
		/**
		 * In-Game: "Immune to fire damage while disguised"
		 * 
		 * Prevent afterburn while disguised.
		 */
		context(attrs: IAttributeContainer)
		open var disguiseNoBurn: Boolean? 
			get() = DisguiseAttributes.disguiseNoBurn.get()
			set(value) { DisguiseAttributes.disguiseNoBurn.set(value) }
	
		/**
		 * In-Game: "Wearer cannot disguise"
		 */
		context(attrs: IAttributeContainer)
		open var cannotDisguise: Boolean? 
			get() = DisguiseAttributes.cannotDisguise.get()
			set(value) { DisguiseAttributes.cannotDisguise.set(value) }
	}
	
	open class FiringAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * Prevents player from attacking.
			 */
			val noAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_attack")
		}
	
		/**
		 * Prevents player from attacking.
		 */
		context(attrs: IAttributeContainer)
		open var noAttack: Boolean? 
			get() = FiringAttributes.noAttack.get()
			set(value) { FiringAttributes.noAttack.set(value) }
	}
	
	open class HeadsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * This attribute only works on players that are a Medic wielding the Vitasaw. For the all-class version, see `extra_damage_on_hit` (unimplemented in vanilla, accessible via Rafmod).
			 * 
			 * Gives extra player movespeed the more heads you have. (Partially implemented.).
			 * 
			 * Will not work if the player is not a Medic wielding the VitaSaw.
			 */
			val addHeadOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add head on hit")
		}
	
		/**
		 * This attribute only works on players that are a Medic wielding the Vitasaw. For the all-class version, see `extra_damage_on_hit` (unimplemented in vanilla, accessible via Rafmod).
		 * 
		 * Gives extra player movespeed the more heads you have. (Partially implemented.).
		 * 
		 * Will not work if the player is not a Medic wielding the VitaSaw.
		 */
		context(attrs: IAttributeContainer)
		open var addHeadOnHit: Boolean? 
			get() = HeadsAttributes.addHeadOnHit.get()
			set(value) { HeadsAttributes.addHeadOnHit.set(value) }
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
			 * 
			 * On Medic only, each level raises the Medic's passive regen by 25% of its normal value.
			 */
			val healingMastery: ItemAttributeNamed<Int> = ItemAttributeNamed("healing mastery")
	
			val healthFromPacks: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("health from packs increased"),
				ItemAttributeNamed("health from packs decreased"),
			)
	
			/**
			 * In-Game: "N% less healing from Medic sources"
			 * 
			 * Specifically checked on Crossbow Bolt impacts.
			 */
			val reducedHealingFromMedics: ItemAttributeNamed<Number> = ItemAttributeNamed("reduced_healing_from_medics")
	
			val healthFromHealersReduced: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("health from healers increased"),
				ItemAttributeNamed("health from healers reduced"),
			)
	
			/**
			 * In-Game: "Blocks healing while in use"
			 * 
			 * If set, this player may not be targeted by heal-beams or healed from Crossbow impacts.
			 */
			val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
			val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase. See also: [addMaxHealth].
			 */
			val hiddenMaxhealthNonBuffed: ItemAttributeNamed<Int> = ItemAttributeNamed("hidden maxhealth non buffed")
	
			val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
		}
	
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 * 
		 * On Medic only, each level raises the Medic's passive regen by 25% of its normal value.
		 */
		context(attrs: IAttributeContainer)
		open var healingMastery: Int? 
			get() = HealthAndHealingAttributes.healingMastery.get()
			set(value) { HealthAndHealingAttributes.healingMastery.set(value) }
	
		context(attrs: IAttributeContainer)
		open var healthFromPacks: Number? 
			get() = HealthAndHealingAttributes.healthFromPacks.get()
			set(value) { HealthAndHealingAttributes.healthFromPacks.set(value) }
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Specifically checked on Crossbow Bolt impacts.
		 */
		context(attrs: IAttributeContainer)
		open var reducedHealingFromMedics: Number? 
			get() = HealthAndHealingAttributes.reducedHealingFromMedics.get()
			set(value) { HealthAndHealingAttributes.reducedHealingFromMedics.set(value) }
	
		context(attrs: IAttributeContainer)
		open var healthFromHealersReduced: Number? 
			get() = HealthAndHealingAttributes.healthFromHealersReduced.get()
			set(value) { HealthAndHealingAttributes.healthFromHealersReduced.set(value) }
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * If set, this player may not be targeted by heal-beams or healed from Crossbow impacts.
		 */
		context(attrs: IAttributeContainer)
		open var weaponBlocksHealing: Boolean? 
			get() = HealthAndHealingAttributes.weaponBlocksHealing.get()
			set(value) { HealthAndHealingAttributes.weaponBlocksHealing.set(value) }
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase. See also: [addMaxHealth].
		 */
		context(attrs: IAttributeContainer)
		open var hiddenMaxhealthNonBuffed: Int? 
			get() = HealthAndHealingAttributes.hiddenMaxhealthNonBuffed.get()
			set(value) { HealthAndHealingAttributes.hiddenMaxhealthNonBuffed.set(value) }
	
		open val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		open val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N health regenerated per second on wearer"
				 * 
				 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
				 */
				val healthRegen: ItemAttributeNamed<Number> = ItemAttributeNamed("health regen")
	
				/**
				 * In-Game: "N health drained per second on wearer"
				 * 
				 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
				 */
				val healthDrain: ItemAttributeNamed<Number> = ItemAttributeNamed("health drain")
	
				/**
				 * In-Game: "+N health regenerated per second on wearer"
				 * 
				 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
				 */
				val setBonusHealthRegenSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: health regen set bonus")
	
				/**
				 * In-Game: "N health regenerated per second on wearer"
				 * 
				 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
				 */
				val healthDrainMedic: ItemAttributeNamed<Number> = ItemAttributeNamed("health drain medic")
	
				/**
				 * In-Game: "+N health regenerated per second on wearer"
				 * 
				 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
				 */
				val cardHealthRegen: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: health regen")
			}
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var healthRegen: Number? 
				get() = HealthRegenAttributes.healthRegen.get()
				set(value) { HealthRegenAttributes.healthRegen.set(value) }
	
			/**
			 * In-Game: "N health drained per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var healthDrain: Number? 
				get() = HealthRegenAttributes.healthDrain.get()
				set(value) { HealthRegenAttributes.healthDrain.set(value) }
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusHealthRegenSetBonus: Number? 
				get() = HealthRegenAttributes.setBonusHealthRegenSetBonus.get()
				set(value) { HealthRegenAttributes.setBonusHealthRegenSetBonus.set(value) }
	
			/**
			 * In-Game: "N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var healthDrainMedic: Number? 
				get() = HealthRegenAttributes.healthDrainMedic.get()
				set(value) { HealthRegenAttributes.healthDrainMedic.set(value) }
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var cardHealthRegen: Number? 
				get() = HealthRegenAttributes.cardHealthRegen.get()
				set(value) { HealthRegenAttributes.cardHealthRegen.set(value) }
		}
	
		open class MaxHealthAdditiveAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N max health on wearer"
				 * 
				 * Additive maximum health increase only checked when overhealing.
				 */
				val maxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive bonus")
	
				/**
				 * In-Game: "N max health on wearer"
				 * 
				 * Additive maximum health increase only checked when overhealing.
				 */
				val maxHealthAdditivePenalty: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive penalty")
	
				/**
				 * In-Game: "+N max health on wearer"
				 * 
				 * Additive maximum health increase only checked when overhealing.
				 */
				val setBonusMaxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: max health additive bonus")
			}
	
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			context(attrs: IAttributeContainer)
			open var maxHealthAdditiveBonus: Int? 
				get() = MaxHealthAdditiveAttributes.maxHealthAdditiveBonus.get()
				set(value) { MaxHealthAdditiveAttributes.maxHealthAdditiveBonus.set(value) }
	
			/**
			 * In-Game: "N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			context(attrs: IAttributeContainer)
			open var maxHealthAdditivePenalty: Int? 
				get() = MaxHealthAdditiveAttributes.maxHealthAdditivePenalty.get()
				set(value) { MaxHealthAdditiveAttributes.maxHealthAdditivePenalty.set(value) }
	
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusMaxHealthAdditiveBonus: Int? 
				get() = MaxHealthAdditiveAttributes.setBonusMaxHealthAdditiveBonus.get()
				set(value) { MaxHealthAdditiveAttributes.setBonusMaxHealthAdditiveBonus.set(value) }
		}
	}
	
	open class HudAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * Only used if the build menu is actually shown.
			 * 
			 * 0 = default.
			 * 
			 * 1 = pipboy.
			 * 
			 * Works on Engineer and Spy (if you can give him a build menu).
			 */
			val hasPipboyBuildInterface: ItemAttributeNamed<Int> = ItemAttributeNamed("has pipboy build interface")
	
			/**
			 * In-Game: "Allows you to see enemy health"
			 */
			val seeEnemyHealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod see enemy health")
	
			/**
			 * In-Game: "Unable to see enemy health"
			 * 
			 * Always true in MvM.
			 */
			val hideEnemyHealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hide enemy health")
		}
	
		/**
		 * Only used if the build menu is actually shown.
		 * 
		 * 0 = default.
		 * 
		 * 1 = pipboy.
		 * 
		 * Works on Engineer and Spy (if you can give him a build menu).
		 */
		context(attrs: IAttributeContainer)
		open var hasPipboyBuildInterface: Int? 
			get() = HudAttributes.hasPipboyBuildInterface.get()
			set(value) { HudAttributes.hasPipboyBuildInterface.set(value) }
	
		/**
		 * In-Game: "Allows you to see enemy health"
		 */
		context(attrs: IAttributeContainer)
		open var seeEnemyHealth: Boolean? 
			get() = HudAttributes.seeEnemyHealth.get()
			set(value) { HudAttributes.seeEnemyHealth.set(value) }
	
		/**
		 * In-Game: "Unable to see enemy health"
		 * 
		 * Always true in MvM.
		 */
		context(attrs: IAttributeContainer)
		open var hideEnemyHealth: Boolean? 
			get() = HudAttributes.hideEnemyHealth.get()
			set(value) { HudAttributes.hideEnemyHealth.set(value) }
	}
	
	open class KnockbackReceivedAttributes : BaseEntityAttributes.KnockbackReceivedAttributes() {
		companion object : IBlockScoped {
			val airblastVulnerabilityMultiplier: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("airblast vulnerability multiplier"), ItemAttributeNamed<Number>("airblast vulnerability multiplier hidden"))
	
			val airblastVerticalVulnerabilityMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast vertical vulnerability multiplier")
	
			/**
			 * In-Game: "Knockback reduced by N% when aiming"
			 * 
			 * Only works on Sniper.
			 */
			val aimingKnockbackResistance: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming knockback resistance")
		}
	
		context(attrs: IAttributeContainer)
		open var airblastVulnerabilityMultiplier: Number? 
			get() = KnockbackReceivedAttributes.airblastVulnerabilityMultiplier.get()
			set(value) { KnockbackReceivedAttributes.airblastVulnerabilityMultiplier.set(value) }
	
		context(attrs: IAttributeContainer)
		open var airblastVerticalVulnerabilityMultiplier: Number? 
			get() = KnockbackReceivedAttributes.airblastVerticalVulnerabilityMultiplier.get()
			set(value) { KnockbackReceivedAttributes.airblastVerticalVulnerabilityMultiplier.set(value) }
	
		/**
		 * In-Game: "Knockback reduced by N% when aiming"
		 * 
		 * Only works on Sniper.
		 */
		context(attrs: IAttributeContainer)
		open var aimingKnockbackResistance: Number? 
			get() = KnockbackReceivedAttributes.aimingKnockbackResistance.get()
			set(value) { KnockbackReceivedAttributes.aimingKnockbackResistance.set(value) }
	}
	
	open class MetaAttributes : BaseEntityAttributes.MetaAttributes() {
		companion object : IBlockScoped {
			/**
			 * If 1, create a soccer ball on the ground when the player spawns.
			 */
			val spawnWithPhysicsToy: ItemAttributeNamed<Int> = ItemAttributeNamed("spawn with physics toy")
	
			/**
			 * In-Game: "Leave a Calling Card on your victims."
			 * 
			 * Defines the calling card that should be dropped when this player kills another player.
			 */
			val setBonusCallingCardOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: calling card on kill")
	
			val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
			val items: ItemsAttributes = ItemsAttributes()
	
			val player: PlayerAttributes = PlayerAttributes()
	
			val gameplay: GameplayAttributes = GameplayAttributes()
	
			val particles: ParticlesAttributes = ParticlesAttributes()
		}
	
		/**
		 * If 1, create a soccer ball on the ground when the player spawns.
		 */
		context(attrs: IAttributeContainer)
		open var spawnWithPhysicsToy: Int? 
			get() = MetaAttributes.spawnWithPhysicsToy.get()
			set(value) { MetaAttributes.spawnWithPhysicsToy.set(value) }
	
		/**
		 * In-Game: "Leave a Calling Card on your victims."
		 * 
		 * Defines the calling card that should be dropped when this player kills another player.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusCallingCardOnKill: Int? 
			get() = MetaAttributes.setBonusCallingCardOnKill.get()
			set(value) { MetaAttributes.setBonusCallingCardOnKill.set(value) }
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		open val items: ItemsAttributes = ItemsAttributes()
	
		open val player: PlayerAttributes = PlayerAttributes()
	
		open val gameplay: GameplayAttributes = GameplayAttributes()
	
		open val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseEntityAttributes.MetaAttributes.KillfeedAttributes() {
			companion object : IBlockScoped {
				/**
				 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
				 */
				val fishDamageOverride: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fish damage override")
			}
	
			/**
			 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
			 */
			context(attrs: IAttributeContainer)
			open var fishDamageOverride: Boolean? 
				get() = KillfeedAttributes.fishDamageOverride.get()
				set(value) { KillfeedAttributes.fishDamageOverride.set(value) }
		}
	
		open class NoisemakersAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Noise Maker"
				 * 
				 * Uses noise maker when pressing action slot key.
				 */
				val noiseMaker: ItemAttributeNamed<Boolean> = ItemAttributeNamed("noise maker")
	
				val unlimitedQuantity: VisHidden<Boolean> = VisHidden(ItemAttributeNamed<Boolean>("unlimited quantity"), ItemAttributeNamed<Boolean>("unlimited quantity hidden"))
			}
	
			/**
			 * In-Game: "Noise Maker"
			 * 
			 * Uses noise maker when pressing action slot key.
			 */
			context(attrs: IAttributeContainer)
			open var noiseMaker: Boolean? 
				get() = NoisemakersAttributes.noiseMaker.get()
				set(value) { NoisemakersAttributes.noiseMaker.set(value) }
	
			context(attrs: IAttributeContainer)
			open var unlimitedQuantity: Boolean? 
				get() = NoisemakersAttributes.unlimitedQuantity.get()
				set(value) { NoisemakersAttributes.unlimitedQuantity.set(value) }
		}
	
		open class ItemsAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Killstreaks Active"
				 */
				val killstreakTier: ItemAttributeNamed<Int> = ItemAttributeNamed("killstreak tier")
			}
	
			/**
			 * In-Game: "Killstreaks Active"
			 */
			context(attrs: IAttributeContainer)
			open var killstreakTier: Int? 
				get() = ItemsAttributes.killstreakTier.get()
				set(value) { ItemsAttributes.killstreakTier.set(value) }
		}
	
		open class PlayerAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Jingle all the way"
				 * 
				 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
				 */
				val addJingleToFootsteps: ItemAttributeNamed<Int> = ItemAttributeNamed("add jingle to footsteps")
	
				/**
				 * In-Game: "N"
				 * 
				 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
				 */
				val spellSetHalloweenFootstepType: ItemAttributeNamed<Int> = ItemAttributeNamed("SPELL: set Halloween footstep type")
	
				val overrideFootstepSoundSet: ItemAttributeNamed<FootstepOverride> = ItemAttributeNamed("override footstep sound set")
	
				/**
				 * In-Game: "Explode spectacularly on death"
				 */
				val bombinomiconEffectOnDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bombinomicon effect on death")
	
				/**
				 * If true, the Voodoo-Cursed Soul skin is equipped.
				 */
				val zombiezombiezombiezombie: ItemAttributeNamed<Boolean> = ItemAttributeNamed("zombiezombiezombiezombie")
	
				/**
				 * In-Game: "Disables double jump"
				 */
				val headScale: ItemAttributeNamed<Number> = ItemAttributeNamed("head scale")
	
				val torsoScale: ItemAttributeNamed<Number> = ItemAttributeNamed("torso scale")
	
				val handScale: ItemAttributeNamed<Number> = ItemAttributeNamed("hand scale")
	
				/**
				 * DSP used when emitting sounds created by this player.
				 */
				val setBonusSpecialDsp: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: special dsp")
			}
	
			/**
			 * In-Game: "Jingle all the way"
			 * 
			 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
			 */
			context(attrs: IAttributeContainer)
			open var addJingleToFootsteps: Int? 
				get() = PlayerAttributes.addJingleToFootsteps.get()
				set(value) { PlayerAttributes.addJingleToFootsteps.set(value) }
	
			/**
			 * In-Game: "N"
			 * 
			 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
			 */
			context(attrs: IAttributeContainer)
			open var spellSetHalloweenFootstepType: Int? 
				get() = PlayerAttributes.spellSetHalloweenFootstepType.get()
				set(value) { PlayerAttributes.spellSetHalloweenFootstepType.set(value) }
	
			context(attrs: IAttributeContainer)
			open var overrideFootstepSoundSet: FootstepOverride? 
				get() = PlayerAttributes.overrideFootstepSoundSet.get()
				set(value) { PlayerAttributes.overrideFootstepSoundSet.set(value) }
	
			/**
			 * In-Game: "Explode spectacularly on death"
			 */
			context(attrs: IAttributeContainer)
			open var bombinomiconEffectOnDeath: Boolean? 
				get() = PlayerAttributes.bombinomiconEffectOnDeath.get()
				set(value) { PlayerAttributes.bombinomiconEffectOnDeath.set(value) }
	
			/**
			 * If true, the Voodoo-Cursed Soul skin is equipped.
			 */
			context(attrs: IAttributeContainer)
			open var zombiezombiezombiezombie: Boolean? 
				get() = PlayerAttributes.zombiezombiezombiezombie.get()
				set(value) { PlayerAttributes.zombiezombiezombiezombie.set(value) }
	
			/**
			 * In-Game: "Disables double jump"
			 */
			context(attrs: IAttributeContainer)
			open var headScale: Number? 
				get() = PlayerAttributes.headScale.get()
				set(value) { PlayerAttributes.headScale.set(value) }
	
			context(attrs: IAttributeContainer)
			open var torsoScale: Number? 
				get() = PlayerAttributes.torsoScale.get()
				set(value) { PlayerAttributes.torsoScale.set(value) }
	
			context(attrs: IAttributeContainer)
			open var handScale: Number? 
				get() = PlayerAttributes.handScale.get()
				set(value) { PlayerAttributes.handScale.set(value) }
	
			/**
			 * DSP used when emitting sounds created by this player.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusSpecialDsp: Int? 
				get() = PlayerAttributes.setBonusSpecialDsp.get()
				set(value) { PlayerAttributes.setBonusSpecialDsp.set(value) }
		}
	
		open class GameplayAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N capture rate on wearer"
				 */
				val increasePlayerCaptureValue: ItemAttributeNamed<Int> = ItemAttributeNamed("increase player capture value")
	
				/**
				 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
				 * 
				 * Discounts canteens by 10 * level.
				 */
				val canteenSpecialist: ItemAttributeNamed<Int> = ItemAttributeNamed("canteen specialist")
	
				/**
				 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
				 */
				val cannotPickUpIntelligence: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up intelligence")
			}
	
			/**
			 * In-Game: "+N capture rate on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var increasePlayerCaptureValue: Int? 
				get() = GameplayAttributes.increasePlayerCaptureValue.get()
				set(value) { GameplayAttributes.increasePlayerCaptureValue.set(value) }
	
			/**
			 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
			 * 
			 * Discounts canteens by 10 * level.
			 */
			context(attrs: IAttributeContainer)
			open var canteenSpecialist: Int? 
				get() = GameplayAttributes.canteenSpecialist.get()
				set(value) { GameplayAttributes.canteenSpecialist.set(value) }
	
			/**
			 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
			 */
			context(attrs: IAttributeContainer)
			open var cannotPickUpIntelligence: Boolean? 
				get() = GameplayAttributes.cannotPickUpIntelligence.get()
				set(value) { GameplayAttributes.cannotPickUpIntelligence.set(value) }
		}
	
		open class ParticlesAttributes : IBlockScoped {
			companion object : IBlockScoped {
				val useHeadOrigin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("particle effect use head origin")
	
				val verticalOffset: ItemAttributeNamed<Number> = ItemAttributeNamed("particle effect vertical offset")
			}
	
			context(attrs: IAttributeContainer)
			open var useHeadOrigin: Boolean? 
				get() = ParticlesAttributes.useHeadOrigin.get()
				set(value) { ParticlesAttributes.useHeadOrigin.set(value) }
	
			context(attrs: IAttributeContainer)
			open var verticalOffset: Number? 
				get() = ParticlesAttributes.verticalOffset.get()
				set(value) { ParticlesAttributes.verticalOffset.set(value) }
		}
	}
	
	open class MeterAttributes : BaseEntityAttributes.MeterAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
			 * 
			 * Gain shield meter from damage healed. Only works on Medic.
			 */
			val generateRageOnHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on heal")
	
			/**
			 * In-Game: "Gain Focus on kills and assists"
			 * 
			 * Amount of Sniper rage gained on kill.  Only works on Sniper.
			 */
			val rageOnKill: ItemAttributeNamed<Number> = ItemAttributeNamed("rage on kill")
	
			/**
			 * In-Game: "Boost reduced on air jumps"
			 * 
			 * Lose this amount of hype if you airdash.
			 * 
			 * Note that this only applies to scout hype, not rage in general.
			 */
			val hypeResetsOnJump: ItemAttributeNamed<Int> = ItemAttributeNamed("hype resets on jump")
	
			val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
			/**
			 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
			 */
			val rageGivingScale: ItemAttributeNamed<Number> = ItemAttributeNamed("rage giving scale")
	
			/**
			 * In-Game: "On Hit: Builds Hype"
			 * 
			 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
			 */
			val hypeOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hype on damage")
	
			/**
			 * Only procs on Sniper. Gain this amount of rage meter on assists.
			 */
			val rageOnAssists: ItemAttributeNamed<Number> = ItemAttributeNamed("rage on assists")
	
			/**
			 * In-Game: "Hype Decays Over Time."
			 * 
			 * How much the Scout's hype meter decays every tick.
			 */
			val hypeDecaysOverTime: ItemAttributeNamed<Number> = ItemAttributeNamed("hype decays over time")
	
			/**
			 * In-Game: "Boost reduced when hit"
			 * 
			 * Amount of hype lost per point of damage taken.
			 */
			val loseHypeOnTakeDamage: ItemAttributeNamed<Int> = ItemAttributeNamed("lose hype on take damage")
		}
	
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * Gain shield meter from damage healed. Only works on Medic.
		 */
		context(attrs: IAttributeContainer)
		open var generateRageOnHeal: Boolean? 
			get() = MeterAttributes.generateRageOnHeal.get()
			set(value) { MeterAttributes.generateRageOnHeal.set(value) }
	
		/**
		 * In-Game: "Gain Focus on kills and assists"
		 * 
		 * Amount of Sniper rage gained on kill.  Only works on Sniper.
		 */
		context(attrs: IAttributeContainer)
		open var rageOnKill: Number? 
			get() = MeterAttributes.rageOnKill.get()
			set(value) { MeterAttributes.rageOnKill.set(value) }
	
		/**
		 * In-Game: "Boost reduced on air jumps"
		 * 
		 * Lose this amount of hype if you airdash.
		 * 
		 * Note that this only applies to scout hype, not rage in general.
		 */
		context(attrs: IAttributeContainer)
		open var hypeResetsOnJump: Int? 
			get() = MeterAttributes.hypeResetsOnJump.get()
			set(value) { MeterAttributes.hypeResetsOnJump.set(value) }
	
		/**
		 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
		 */
		context(attrs: IAttributeContainer)
		open var rageGivingScale: Number? 
			get() = MeterAttributes.rageGivingScale.get()
			set(value) { MeterAttributes.rageGivingScale.set(value) }
	
		/**
		 * In-Game: "On Hit: Builds Hype"
		 * 
		 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
		 */
		context(attrs: IAttributeContainer)
		open var hypeOnDamage: Boolean? 
			get() = MeterAttributes.hypeOnDamage.get()
			set(value) { MeterAttributes.hypeOnDamage.set(value) }
	
		/**
		 * Only procs on Sniper. Gain this amount of rage meter on assists.
		 */
		context(attrs: IAttributeContainer)
		open var rageOnAssists: Number? 
			get() = MeterAttributes.rageOnAssists.get()
			set(value) { MeterAttributes.rageOnAssists.set(value) }
	
		/**
		 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAMEBALL.
		 */
		context(attrs: IAttributeContainer)
		override var chargeType: TFMeterRechargeType? 
			get() = super.chargeType
			set(value) { super.chargeType = value }
	
		/**
		 * In-Game: "Hype Decays Over Time."
		 * 
		 * How much the Scout's hype meter decays every tick.
		 */
		context(attrs: IAttributeContainer)
		open var hypeDecaysOverTime: Number? 
			get() = MeterAttributes.hypeDecaysOverTime.get()
			set(value) { MeterAttributes.hypeDecaysOverTime.set(value) }
	
		/**
		 * In-Game: "Boost reduced when hit"
		 * 
		 * Amount of hype lost per point of damage taken.
		 */
		context(attrs: IAttributeContainer)
		open var loseHypeOnTakeDamage: Int? 
			get() = MeterAttributes.loseHypeOnTakeDamage.get()
			set(value) { MeterAttributes.loseHypeOnTakeDamage.set(value) }
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
				 * 
				 * Only works on Engineer and Heavy.
				 * 
				 * On Engineer, adds all damage dealt to the rage meter.
				 * 
				 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
				 */
				val generateRageOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
				/**
				 * In-Game: "Generate building rescue energy on damage"
				 * 
				 * Only works on Engineer and Heavy.
				 * 
				 * On Engineer, adds all damage dealt to the rage meter.
				 * 
				 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
				 */
				val engineerRageOnDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
			}
	
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
			 */
			context(attrs: IAttributeContainer)
			open var generateRageOnDamage: Boolean? 
				get() = GenerateRageOnDamageAttributes.generateRageOnDamage.get()
				set(value) { GenerateRageOnDamageAttributes.generateRageOnDamage.set(value) }
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
			 */
			context(attrs: IAttributeContainer)
			open var engineerRageOnDmg: Boolean? 
				get() = GenerateRageOnDamageAttributes.engineerRageOnDmg.get()
				set(value) { GenerateRageOnDamageAttributes.engineerRageOnDmg.set(value) }
		}
	}
	
	open class MovementAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
			/**
			 * Allows parachute to be deployed. Parachute prop only appears if the BASE Jumper is equipped, but the functionality is the same regardless.
			 */
			val parachuteAttribute: ItemAttributeNamed<Boolean> = ItemAttributeNamed("parachute attribute")
	
			/**
			 * In-Game: "N% increased air control."
			 * 
			 * Note: the jetpack condition always multiplies your air acceleration by 50%.
			 */
			val increasedAirControl: ItemAttributeNamed<Number> = ItemAttributeNamed("increased air control")
	
			/**
			 * In-Game: "N% increased air control when blast jumping."
			 * 
			 * Specifically while blast-jumping, as opposed to global.
			 */
			val airControlBlastJump: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_air_control_blast_jump")
	
			/**
			 * Prevents player from jumping.
			 */
			val noJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_jump")
	
			/**
			 * Prevents player from crouching.
			 */
			val noDuck: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_duck")
	
			/**
			 * In-Game: "Disables double jump"
			 */
			val noDoubleJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no double jump")
	
			val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
		}
	
		/**
		 * Allows parachute to be deployed. Parachute prop only appears if the BASE Jumper is equipped, but the functionality is the same regardless.
		 */
		context(attrs: IAttributeContainer)
		open var parachuteAttribute: Boolean? 
			get() = MovementAttributes.parachuteAttribute.get()
			set(value) { MovementAttributes.parachuteAttribute.set(value) }
	
		/**
		 * In-Game: "N% increased air control."
		 * 
		 * Note: the jetpack condition always multiplies your air acceleration by 50%.
		 */
		context(attrs: IAttributeContainer)
		open var increasedAirControl: Number? 
			get() = MovementAttributes.increasedAirControl.get()
			set(value) { MovementAttributes.increasedAirControl.set(value) }
	
		/**
		 * In-Game: "N% increased air control when blast jumping."
		 * 
		 * Specifically while blast-jumping, as opposed to global.
		 */
		context(attrs: IAttributeContainer)
		open var airControlBlastJump: Number? 
			get() = MovementAttributes.airControlBlastJump.get()
			set(value) { MovementAttributes.airControlBlastJump.set(value) }
	
		/**
		 * Prevents player from jumping.
		 */
		context(attrs: IAttributeContainer)
		open var noJump: Boolean? 
			get() = MovementAttributes.noJump.get()
			set(value) { MovementAttributes.noJump.set(value) }
	
		/**
		 * Prevents player from crouching.
		 */
		context(attrs: IAttributeContainer)
		open var noDuck: Boolean? 
			get() = MovementAttributes.noDuck.get()
			set(value) { MovementAttributes.noDuck.set(value) }
	
		/**
		 * In-Game: "Disables double jump"
		 */
		context(attrs: IAttributeContainer)
		open var noDoubleJump: Boolean? 
			get() = MovementAttributes.noDoubleJump.get()
			set(value) { MovementAttributes.noDoubleJump.set(value) }
	
		open val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% greater jump height when active"
				 */
				val increasedJumpHeight: ItemAttributeNamed<Number> = ItemAttributeNamed("increased jump height")
	
				val majorIncreasedJumpHeight: ItemAttributeNamed<Number> = ItemAttributeNamed("major increased jump height")
	
				val halloweenIncreasedJumpHeight: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween increased jump height")
			}
	
			/**
			 * In-Game: "+N% greater jump height when active"
			 */
			context(attrs: IAttributeContainer)
			open var increasedJumpHeight: Number? 
				get() = jumpHeightAttributes.increasedJumpHeight.get()
				set(value) { jumpHeightAttributes.increasedJumpHeight.set(value) }
	
			context(attrs: IAttributeContainer)
			open var majorIncreasedJumpHeight: Number? 
				get() = jumpHeightAttributes.majorIncreasedJumpHeight.get()
				set(value) { jumpHeightAttributes.majorIncreasedJumpHeight.set(value) }
	
			context(attrs: IAttributeContainer)
			open var halloweenIncreasedJumpHeight: Number? 
				get() = jumpHeightAttributes.halloweenIncreasedJumpHeight.get()
				set(value) { jumpHeightAttributes.halloweenIncreasedJumpHeight.set(value) }
		}
	
		open class MoveSpeedAttributes : IBlockScoped {
			companion object : IBlockScoped {
				val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
				val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
				/**
				 * In-Game: "+N% faster move speed on wearer (shield required)"
				 */
				val moveSpeedBonusShieldRequired: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus shield required")
			}
	
			/**
			 * In-Game: "+N% faster move speed on wearer (shield required)"
			 */
			context(attrs: IAttributeContainer)
			open var moveSpeedBonusShieldRequired: Number? 
				get() = MoveSpeedAttributes.moveSpeedBonusShieldRequired.get()
				set(value) { MoveSpeedAttributes.moveSpeedBonusShieldRequired.set(value) }
	
			open val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : IBlockScoped {
				companion object : IBlockScoped {
					/**
					 * In-Game: "+N% faster move speed while deployed"
					 * 
					 * Only applies to players that have TF_COND_AIMING.
					 * 
					 * If Heavy, default aiming movespeed is 110.
					 * 
					 * Else if player is using a compound bow, 160.
					 * 
					 * Else 80.
					 */
					val aimingMovespeedIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming movespeed increased")
	
					/**
					 * In-Game: "N% slower move speed while deployed"
					 * 
					 * Only applies to players that have TF_COND_AIMING.
					 * 
					 * If Heavy, default aiming movespeed is 110.
					 * 
					 * Else if player is using a compound bow, 160.
					 * 
					 * Else 80.
					 */
					val aimingMovespeedDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming movespeed decreased")
	
					/**
					 * In-Game: "N% slower move speed when aiming"
					 * 
					 * Only applies to players that have TF_COND_AIMING.
					 * 
					 * If Heavy, default aiming movespeed is 110.
					 * 
					 * Else if player is using a compound bow, 160.
					 * 
					 * Else 80.
					 */
					val sniperAimingMovespeedDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("sniper aiming movespeed decreased")
				}
	
				/**
				 * In-Game: "+N% faster move speed while deployed"
				 * 
				 * Only applies to players that have TF_COND_AIMING.
				 * 
				 * If Heavy, default aiming movespeed is 110.
				 * 
				 * Else if player is using a compound bow, 160.
				 * 
				 * Else 80.
				 */
				context(attrs: IAttributeContainer)
				open var aimingMovespeedIncreased: Number? 
					get() = AimingMovespeedAttributes.aimingMovespeedIncreased.get()
					set(value) { AimingMovespeedAttributes.aimingMovespeedIncreased.set(value) }
	
				/**
				 * In-Game: "N% slower move speed while deployed"
				 * 
				 * Only applies to players that have TF_COND_AIMING.
				 * 
				 * If Heavy, default aiming movespeed is 110.
				 * 
				 * Else if player is using a compound bow, 160.
				 * 
				 * Else 80.
				 */
				context(attrs: IAttributeContainer)
				open var aimingMovespeedDecreased: Number? 
					get() = AimingMovespeedAttributes.aimingMovespeedDecreased.get()
					set(value) { AimingMovespeedAttributes.aimingMovespeedDecreased.set(value) }
	
				/**
				 * In-Game: "N% slower move speed when aiming"
				 * 
				 * Only applies to players that have TF_COND_AIMING.
				 * 
				 * If Heavy, default aiming movespeed is 110.
				 * 
				 * Else if player is using a compound bow, 160.
				 * 
				 * Else 80.
				 */
				context(attrs: IAttributeContainer)
				open var sniperAimingMovespeedDecreased: Number? 
					get() = AimingMovespeedAttributes.sniperAimingMovespeedDecreased.get()
					set(value) { AimingMovespeedAttributes.sniperAimingMovespeedDecreased.set(value) }
			}
	
			open class MoveSpeedAttributes : IBlockScoped {
				companion object : IBlockScoped {
					/**
					 * In-Game: "N% slower move speed on wearer"
					 */
					val moveSpeedPenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed penalty")
	
					/**
					 * In-Game: "+N% faster move speed on wearer"
					 */
					val moveSpeedBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus")
	
					val majorMoveSpeedBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("major move speed bonus")
	
					/**
					 * In-Game: "+N% faster move speed on wearer"
					 */
					val setBonusMoveSpeedSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: move speed set bonus")
	
					/**
					 * In-Game: "+N% faster move speed on wearer"
					 */
					val cardMoveSpeedBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: move speed bonus")
				}
	
				/**
				 * In-Game: "N% slower move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var moveSpeedPenalty: Number? 
					get() = MoveSpeedAttributes.moveSpeedPenalty.get()
					set(value) { MoveSpeedAttributes.moveSpeedPenalty.set(value) }
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var moveSpeedBonus: Number? 
					get() = MoveSpeedAttributes.moveSpeedBonus.get()
					set(value) { MoveSpeedAttributes.moveSpeedBonus.set(value) }
	
				context(attrs: IAttributeContainer)
				open var majorMoveSpeedBonus: Number? 
					get() = MoveSpeedAttributes.majorMoveSpeedBonus.get()
					set(value) { MoveSpeedAttributes.majorMoveSpeedBonus.set(value) }
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var setBonusMoveSpeedSetBonus: Number? 
					get() = MoveSpeedAttributes.setBonusMoveSpeedSetBonus.get()
					set(value) { MoveSpeedAttributes.setBonusMoveSpeedSetBonus.set(value) }
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var cardMoveSpeedBonus: Number? 
					get() = MoveSpeedAttributes.cardMoveSpeedBonus.get()
					set(value) { MoveSpeedAttributes.cardMoveSpeedBonus.set(value) }
			}
		}
	}
	
	open class OnHitAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val falling: FallingAttributes = FallingAttributes()
		}
	
		open val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
				 * 
				 * Requires player to have the `TF_COND_ROCKETPACK` condition.
				 * 
				 * Pushes back nearby players around the landing site.
				 */
				val fallingImpactRadiusPushback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("falling_impact_radius_pushback")
	
				/**
				 * In-Game: "Stun enemies when you land"
				 * 
				 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
				 */
				val fallingImpactRadiusStun: ItemAttributeNamed<Boolean> = ItemAttributeNamed("falling_impact_radius_stun")
			}
	
			/**
			 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
			 * 
			 * Requires player to have the `TF_COND_ROCKETPACK` condition.
			 * 
			 * Pushes back nearby players around the landing site.
			 */
			context(attrs: IAttributeContainer)
			open var fallingImpactRadiusPushback: Boolean? 
				get() = FallingAttributes.fallingImpactRadiusPushback.get()
				set(value) { FallingAttributes.fallingImpactRadiusPushback.set(value) }
	
			/**
			 * In-Game: "Stun enemies when you land"
			 * 
			 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
			 */
			context(attrs: IAttributeContainer)
			open var fallingImpactRadiusStun: Boolean? 
				get() = FallingAttributes.fallingImpactRadiusStun.get()
				set(value) { FallingAttributes.fallingImpactRadiusStun.set(value) }
		}
	}
	
	open class OnKillAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "On Kill: A small health pack is dropped"
			 * 
			 * Drop a small health pack when killing an enemy.
			 */
			val dropHealthPackOnKill: ItemAttributeNamed<Boolean> = ItemAttributeNamed("drop health pack on kill")
	
			/**
			 * In-Game: "On Kill: Burst into joyous laughter"
			 * 
			 * On killing an enemy, schadenfreude.
			 */
			val killForcesAttackerToLaugh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("kill forces attacker to laugh")
	
			/**
			 * In-Game: "N% damage penalty"
			 * 
			 * More like a boolean.	Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
			 * 
			 * Checked on all hitscan attacks, including melee swings.
			 */
			val decapitateType: ItemAttributeNamed<Int> = ItemAttributeNamed("decapitate type")
	
			/**
			 * In-Game: "+N% cloak on kill"
			 * 
			 * Value: amount of cloak gained on kill.
			 * 
			 * Only works on Spy.
			 */
			val addCloakOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on kill")
		}
	
		/**
		 * In-Game: "On Kill: A small health pack is dropped"
		 * 
		 * Drop a small health pack when killing an enemy.
		 */
		context(attrs: IAttributeContainer)
		open var dropHealthPackOnKill: Boolean? 
			get() = OnKillAttributes.dropHealthPackOnKill.get()
			set(value) { OnKillAttributes.dropHealthPackOnKill.set(value) }
	
		/**
		 * In-Game: "On Kill: Burst into joyous laughter"
		 * 
		 * On killing an enemy, schadenfreude.
		 */
		context(attrs: IAttributeContainer)
		open var killForcesAttackerToLaugh: Boolean? 
			get() = OnKillAttributes.killForcesAttackerToLaugh.get()
			set(value) { OnKillAttributes.killForcesAttackerToLaugh.set(value) }
	
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.	Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 * 
		 * Checked on all hitscan attacks, including melee swings.
		 */
		context(attrs: IAttributeContainer)
		open var decapitateType: Int? 
			get() = OnKillAttributes.decapitateType.get()
			set(value) { OnKillAttributes.decapitateType.set(value) }
	
		/**
		 * In-Game: "+N% cloak on kill"
		 * 
		 * Value: amount of cloak gained on kill.
		 * 
		 * Only works on Spy.
		 */
		context(attrs: IAttributeContainer)
		open var addCloakOnKill: Int? 
			get() = OnKillAttributes.addCloakOnKill.get()
			set(value) { OnKillAttributes.addCloakOnKill.set(value) }
	}
	
	open class ResistanceAttributes : BaseEntityAttributes.ResistanceAttributes() {
		companion object : IBlockScoped {
			val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
			val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
			val dmgTakenFromBlast: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("dmg taken from blast reduced"),
				ItemAttributeNamed("dmg taken from blast increased"),
			)
	
			val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
			/**
			 * In-Game: "N% damage vulnerability on wearer"
			 * 
			 * Multiplier to damage taken from all sources.
			 */
			val dmgTakenIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken increased")
	
			/**
			 * In-Game: "+N% sentry damage resistance on wearer"
			 */
			val setBonusDmgFromSentryReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg from sentry reduced")
	
			val rocketJumpDamageReduction: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("rocket jump damage reduction"), ItemAttributeNamed<Number>("rocket jump damage reduction HIDDEN"))
	
			/**
			 * In-Game: "Wearer never takes falling damage"
			 */
			val cancelFallingDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cancel falling damage")
	
			/**
			 * In-Game: "N% damage resistance when below 50% health and spun up"
			 * 
			 * Only procs on Heavies that are currently spun up on less than 50% HP.
			 */
			val spunupDamageResistance: ItemAttributeNamed<Number> = ItemAttributeNamed("spunup_damage_resistance")
	
			val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
		}
	
		context(attrs: IAttributeContainer)
		open var dmgTakenFromBlast: Number? 
			get() = ResistanceAttributes.dmgTakenFromBlast.get()
			set(value) { ResistanceAttributes.dmgTakenFromBlast.set(value) }
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 * 
		 * Multiplier to damage taken from all sources.
		 */
		context(attrs: IAttributeContainer)
		open var dmgTakenIncreased: Number? 
			get() = ResistanceAttributes.dmgTakenIncreased.get()
			set(value) { ResistanceAttributes.dmgTakenIncreased.set(value) }
	
		/**
		 * In-Game: "+N% sentry damage resistance on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var setBonusDmgFromSentryReduced: Number? 
			get() = ResistanceAttributes.setBonusDmgFromSentryReduced.get()
			set(value) { ResistanceAttributes.setBonusDmgFromSentryReduced.set(value) }
	
		context(attrs: IAttributeContainer)
		open var rocketJumpDamageReduction: Number? 
			get() = ResistanceAttributes.rocketJumpDamageReduction.get()
			set(value) { ResistanceAttributes.rocketJumpDamageReduction.set(value) }
	
		/**
		 * In-Game: "Wearer never takes falling damage"
		 */
		context(attrs: IAttributeContainer)
		open var cancelFallingDamage: Boolean? 
			get() = ResistanceAttributes.cancelFallingDamage.get()
			set(value) { ResistanceAttributes.cancelFallingDamage.set(value) }
	
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 * 
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		context(attrs: IAttributeContainer)
		open var spunupDamageResistance: Number? 
			get() = ResistanceAttributes.spunupDamageResistance.get()
			set(value) { ResistanceAttributes.spunupDamageResistance.set(value) }
	
		open val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		open val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		open val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		open val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% critical hit damage resistance on wearer"
				 */
				val dmgTakenFromCritReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from crit reduced")
	
				/**
				 * In-Game: "N% critical hit damage vulnerability on wearer"
				 */
				val dmgTakenFromCritIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from crit increased")
	
				/**
				 * In-Game: "+N% critical hit damage resistance on wearer"
				 */
				val setBonusDmgTakenFromCritReducedSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from crit reduced set bonus")
			}
	
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromCritReduced: Number? 
				get() = DmgTakenFromCritReducedAttributes.dmgTakenFromCritReduced.get()
				set(value) { DmgTakenFromCritReducedAttributes.dmgTakenFromCritReduced.set(value) }
	
			/**
			 * In-Game: "N% critical hit damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromCritIncreased: Number? 
				get() = DmgTakenFromCritReducedAttributes.dmgTakenFromCritIncreased.get()
				set(value) { DmgTakenFromCritReducedAttributes.dmgTakenFromCritIncreased.set(value) }
	
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var setBonusDmgTakenFromCritReducedSetBonus: Number? 
				get() = DmgTakenFromCritReducedAttributes.setBonusDmgTakenFromCritReducedSetBonus.get()
				set(value) { DmgTakenFromCritReducedAttributes.setBonusDmgTakenFromCritReducedSetBonus.set(value) }
		}
	
		open class DmgTakenFromFireReducedAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% fire damage resistance on wearer"
				 */
				val dmgTakenFromFireReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire reduced")
	
				/**
				 * In-Game: "N% fire damage vulnerability on wearer"
				 */
				val dmgTakenFromFireIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire increased")
	
				/**
				 * In-Game: "+N% fire damage resistance on wearer"
				 */
				val setBonusDmgTakenFromFireReducedSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from fire reduced set bonus")
			}
	
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromFireReduced: Number? 
				get() = DmgTakenFromFireReducedAttributes.dmgTakenFromFireReduced.get()
				set(value) { DmgTakenFromFireReducedAttributes.dmgTakenFromFireReduced.set(value) }
	
			/**
			 * In-Game: "N% fire damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromFireIncreased: Number? 
				get() = DmgTakenFromFireReducedAttributes.dmgTakenFromFireIncreased.get()
				set(value) { DmgTakenFromFireReducedAttributes.dmgTakenFromFireIncreased.set(value) }
	
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var setBonusDmgTakenFromFireReducedSetBonus: Number? 
				get() = DmgTakenFromFireReducedAttributes.setBonusDmgTakenFromFireReducedSetBonus.get()
				set(value) { DmgTakenFromFireReducedAttributes.setBonusDmgTakenFromFireReducedSetBonus.set(value) }
		}
	
		open class DmgTakenFromBulletsReducedAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% bullet damage resistance on wearer"
				 */
				val dmgTakenFromBulletsReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from bullets reduced")
	
				/**
				 * In-Game: "N% bullet damage vulnerability on wearer"
				 */
				val dmgTakenFromBulletsIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from bullets increased")
	
				/**
				 * In-Game: "N% bullet damage vulnerability on wearer"
				 */
				val setBonusDmgTakenFromBulletsIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from bullets increased")
	
				/**
				 * In-Game: "+N% bullet damage resistance on wearer"
				 */
				val cardDmgTakenFromBulletsReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: dmg taken from bullets reduced")
			}
	
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromBulletsReduced: Number? 
				get() = DmgTakenFromBulletsReducedAttributes.dmgTakenFromBulletsReduced.get()
				set(value) { DmgTakenFromBulletsReducedAttributes.dmgTakenFromBulletsReduced.set(value) }
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromBulletsIncreased: Number? 
				get() = DmgTakenFromBulletsReducedAttributes.dmgTakenFromBulletsIncreased.get()
				set(value) { DmgTakenFromBulletsReducedAttributes.dmgTakenFromBulletsIncreased.set(value) }
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var setBonusDmgTakenFromBulletsIncreased: Number? 
				get() = DmgTakenFromBulletsReducedAttributes.setBonusDmgTakenFromBulletsIncreased.get()
				set(value) { DmgTakenFromBulletsReducedAttributes.setBonusDmgTakenFromBulletsIncreased.set(value) }
	
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var cardDmgTakenFromBulletsReduced: Number? 
				get() = DmgTakenFromBulletsReducedAttributes.cardDmgTakenFromBulletsReduced.get()
				set(value) { DmgTakenFromBulletsReducedAttributes.cardDmgTakenFromBulletsReduced.set(value) }
		}
	
		open class VaccinatorAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BULLET_RESIST.
				 */
				val medigunBulletResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun bullet resist deployed")
	
				/**
				 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST.
				 */
				val medigunBulletResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun bullet resist passive")
	
				/**
				 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST.
				 */
				val medigunBlastResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun blast resist deployed")
	
				/**
				 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST.
				 */
				val medigunBlastResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun blast resist passive")
	
				/**
				 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST.
				 */
				val medigunFireResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun fire resist deployed")
	
				/**
				 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST.
				 */
				val medigunFireResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun fire resist passive")
			}
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BULLET_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBulletResistDeployed: Number? 
				get() = VaccinatorAttributes.medigunBulletResistDeployed.get()
				set(value) { VaccinatorAttributes.medigunBulletResistDeployed.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBulletResistPassive: Number? 
				get() = VaccinatorAttributes.medigunBulletResistPassive.get()
				set(value) { VaccinatorAttributes.medigunBulletResistPassive.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBlastResistDeployed: Number? 
				get() = VaccinatorAttributes.medigunBlastResistDeployed.get()
				set(value) { VaccinatorAttributes.medigunBlastResistDeployed.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBlastResistPassive: Number? 
				get() = VaccinatorAttributes.medigunBlastResistPassive.get()
				set(value) { VaccinatorAttributes.medigunBlastResistPassive.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunFireResistDeployed: Number? 
				get() = VaccinatorAttributes.medigunFireResistDeployed.get()
				set(value) { VaccinatorAttributes.medigunFireResistDeployed.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunFireResistPassive: Number? 
				get() = VaccinatorAttributes.medigunFireResistPassive.get()
				set(value) { VaccinatorAttributes.medigunFireResistPassive.set(value) }
		}
	}
	
	open class TauntingAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "+N% faster taunt speed on wearer"
			 * 
			 * Multiplier applied to taunt speed.
			 */
			val gestureSpeedIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("gesture speed increase")
	
			/**
			 * Sound to be played when performing a taunt.
			 */
			val cosmeticTauntSound: ItemAttributeNamed<String> = ItemAttributeNamed("cosmetic taunt sound")
	
			/**
			 * In-Game: "Extra effects when taunting."
			 * 
			 * Use Saharan Spy particle effect when performing a stock knife taunt.  Only works on Spy.
			 */
			val setBonusCustomTauntParticleAttr: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: custom taunt particle attr")
		}
	
		/**
		 * In-Game: "+N% faster taunt speed on wearer"
		 * 
		 * Multiplier applied to taunt speed.
		 */
		context(attrs: IAttributeContainer)
		open var gestureSpeedIncrease: Number? 
			get() = TauntingAttributes.gestureSpeedIncrease.get()
			set(value) { TauntingAttributes.gestureSpeedIncrease.set(value) }
	
		/**
		 * Sound to be played when performing a taunt.
		 */
		context(attrs: IAttributeContainer)
		open var cosmeticTauntSound: String? 
			get() = TauntingAttributes.cosmeticTauntSound.get()
			set(value) { TauntingAttributes.cosmeticTauntSound.set(value) }
	
		/**
		 * In-Game: "Extra effects when taunting."
		 * 
		 * Use Saharan Spy particle effect when performing a stock knife taunt.  Only works on Spy.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusCustomTauntParticleAttr: Boolean? 
			get() = TauntingAttributes.setBonusCustomTauntParticleAttr.get()
			set(value) { TauntingAttributes.setBonusCustomTauntParticleAttr.set(value) }
	}
	
	open class SwapWeaponsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val disableWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disable weapon switch")
		}
	
		context(attrs: IAttributeContainer)
		open var disableWeaponSwitch: Boolean? 
			get() = SwapWeaponsAttributes.disableWeaponSwitch.get()
			set(value) { SwapWeaponsAttributes.disableWeaponSwitch.set(value) }
	}
	
	open class WhenHitAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * Number of seconds the player who hit this entity should be marked for death.
			 * 
			 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
			 */
			val markAttackerForDeath: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_mark_attacker_for_death")
	
			/**
			 * In-Game: "When backstabbed: Jarate attacker"
			 * 
			 * If true, jarates anyone who backstabs this player.
			 * 
			 * Note: does not block backstabs on its own.
			 */
			val jarateBackstabber: ItemAttributeNamed<Boolean> = ItemAttributeNamed("jarate backstabber")
		}
	
		/**
		 * Number of seconds the player who hit this entity should be marked for death.
		 * 
		 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
		 */
		context(attrs: IAttributeContainer)
		open var markAttackerForDeath: Number? 
			get() = WhenHitAttributes.markAttackerForDeath.get()
			set(value) { WhenHitAttributes.markAttackerForDeath.set(value) }
	
		/**
		 * In-Game: "When backstabbed: Jarate attacker"
		 * 
		 * If true, jarates anyone who backstabs this player.
		 * 
		 * Note: does not block backstabs on its own.
		 */
		context(attrs: IAttributeContainer)
		open var jarateBackstabber: Boolean? 
			get() = WhenHitAttributes.jarateBackstabber.get()
			set(value) { WhenHitAttributes.jarateBackstabber.set(value) }
	}
	
	open class SpyOnlyAttributes : IBlockScoped {
		companion object : IBlockScoped 
	}
	
	open class CritsAttributes : BaseEntityAttributes.CritsAttributes() 
}