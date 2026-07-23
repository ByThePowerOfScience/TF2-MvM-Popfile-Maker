package btpos.source.vdfdsl.tf2.rafmod.attributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.itemattributes.BaseEntityAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BuffItemAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CompoundBowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CrossbowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.DispenserAttributes
import btpos.source.vdfdsl.tf2.itemattributes.EntityAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlamethrowerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MedigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MinigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MvMBotAttributes
import btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RevolverAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SentryGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SniperRifleAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SpyOnlyAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SyringeGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.TeleporterAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WearableAttributes
import btpos.source.vdfdsl.tf2.itemattributes.impl.EnumSetOrCodec
import btpos.source.vdfdsl.tf2.itemattributes.impl.IEnumCustomValue
import btpos.source.vdfdsl.tf2.rafmod.codecs.DurationCodec
import java.util.EnumSet
import kotlin.time.Duration

/**
 * Modifications made to vanilla attributes.
 */
@Suppress("UnusedReceiverParameter")
object RafmodVanillaAttributes {
	/**
	 * Rafmod implementation of a vanilla attribute.
	 *
	 * Prevents the user from using alt-fire on their weapon.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.altFireDisabled: Boolean?
		get() = attrs.getTyped("alt-fire disabled", BinaryIntCodec)
		set(value) = attrs.setNullable("alt-fire disabled", value, BinaryIntCodec)
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon, not just melee weapons.
	 *
	 * @see BaseMeleeAttributes.dmgPenaltyWhileHalfAlive
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.dmgBonusWhileHalfDead: Number?
	    get() = BaseMeleeAttributes.dmgPenaltyWhileHalfAlive
	    set(value) { BaseMeleeAttributes.dmgPenaltyWhileHalfAlive = value }
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon, not just melee weapons.
	 *
	 * @see BaseMeleeAttributes.dmgPenaltyWhileHalfAlive
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.dmgPenaltyWhileHalfAlive: Number?
		get() = BaseMeleeAttributes.dmgPenaltyWhileHalfAlive
		set(value) { BaseMeleeAttributes.dmgPenaltyWhileHalfAlive = value }
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on the [Mantreads][btpos.source.vdfdsl.tf2.items.weapons.Weapons.MANTREADS].
	 *
	 * @see WeaponBaseAttributes.damage
	 */
	val WearableAttributes.damage
		get() = WeaponBaseAttributes.damage
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on the [Mantreads][btpos.source.vdfdsl.tf2.items.weapons.Weapons.MANTREADS].
	 *
	 * @see WeaponBaseAttributes.dmgPenaltyVsPlayers
	 */
	context(attrs: IKeyValueMap)
	var WearableAttributes.dmgPenaltyVsPlayers
		get() = WeaponBaseAttributes.dmgPenaltyVsPlayers
		set(value) { WeaponBaseAttributes.dmgPenaltyVsPlayers = value }
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on the [Mantreads][btpos.source.vdfdsl.tf2.items.weapons.Weapons.MANTREADS].
	 *
	 * @see WeaponBaseAttributes.restoreHealthOnKill
	 */
	context(attrs: IKeyValueMap)
	var WearableAttributes.restoreHealthOnKill: Int?
	    get() = WeaponBaseAttributes.restoreHealthOnKill
	    set(value) { WeaponBaseAttributes.restoreHealthOnKill = value }
	
	
	/**
	 * Rafmod reimplementation of a vanilla attribute.
	 *
	 * Multiplier to firing speed, inversely scaled by the user's "current health to maximum health" proportion.
	 *
	 * Formerly the attribute used for the Panic Attack, now unimplemented in the base game.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.fireRateBonusWithReducedHealth: Number?
		get() = attrs.getTyped("fire rate bonus with reduced health")
		set(value) = attrs.setNullable("fire rate bonus with reduced health", value)
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon.
	 *
	 * @see MinigunAttributes.attackProjectiles
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.attackProjectiles
		get() = MinigunAttributes.attackProjectiles
		set(value) { MinigunAttributes.attackProjectiles = value }
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon.
	 *
	 * @see BaseMeleeAttributes.critFromBehind
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.critFromBehind
		get() = BaseMeleeAttributes.critFromBehind
		set(value) { BaseMeleeAttributes.critFromBehind = value }
	
	
	
	
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Prevents parachute from being deployed, but still allows it to be retracted.
	 */
	context(attrs: IKeyValueMap)
	var EntityAttributes.parachuteDisabled: Boolean?
		get() = attrs.getTyped("parachute disabled", BinaryIntCodec)
		set(value) = attrs.setNullable("parachute disabled", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, alt-fire fires a crossbow bolt that applies Mad Milk to its target.
	 */
	context(attrs: IKeyValueMap)
	var CrossbowAttributes.firesMilkBolt: Boolean?
		get() = attrs.getTyped("fires milk bolt", BinaryIntCodec)
		set(value) = attrs.setNullable("fires milk bolt", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Hit all targets in swing instead of just the first valid one.
	 */
	context(attrs: IKeyValueMap)
	var BaseMeleeAttributes.meleeCleaveAttack: Boolean?
		get() = attrs.getTyped("melee cleave attack", BinaryIntCodec)
		set(value) = attrs.setNullable("melee cleave attack", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Gain this many heads on hitting a target with this weapon.
	 *
	 * @see extraDamageOnHit
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.headsGainedOnHit: Int?
		get() = attrs.getTyped("extra damage on hit")
		set(value) = attrs.setNullable("extra damage on hit", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Gain this many heads on hit.  Deal +1% extra damage per head.
	 *
	 * Same attribute as [headsGainedOnHit], but the damage is only valid for the Revolver.
	 *
	 * @see headsGainedOnHit
	 * @see extraDamageOnHitPenalty
	 */
	context(attrs: IKeyValueMap)
	var RevolverAttributes.extraDamageOnHit: Int?
		get() = attrs.getTyped("extra damage on hit")
		set(value) = attrs.setNullable("extra damage on hit", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Lose this many heads per missed shot.
	 *
	 * @see extraDamageOnHit
	 * @see headsGainedOnHit
	 */
	context(attrs: IKeyValueMap)
	var RevolverAttributes.extraDamageOnHitPenalty: Int?
		get() = attrs.getTyped("extra damage on hit penalty")
		set(value) = attrs.setNullable("extra damage on hit penalty", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, teleporter adds the [speed boost condition][btpos.source.vdfdsl.tf2.tftypes.TFCondition.SpeedBoost] with arg `4.0` to the teleported player.
	 */
	context(attrs: IKeyValueMap)
	var TeleporterAttributes.modTeleporterSpeedBoost: Boolean?
		get() = attrs.getTyped("mod teleporter speed boost", BinaryIntCodec)
		set(value) = attrs.setNullable("mod teleporter speed boost", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, the player can breathe underwater.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.canBreatheUnderwater: Boolean?
		get() = attrs.getTyped("can breathe under water", BinaryIntCodec)
		set(value) = attrs.setNullable("can breathe under water", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, forbids you from Numbering upwards with the jump button in the water.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.cannotSwim: Boolean?
		get() = attrs.getTyped("cannot swim", BinaryIntCodec)
		set(value) = attrs.setNullable("cannot swim", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If false or not present, move speed is 80% while swimming.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.swimmingMastery: Boolean?
		get() = attrs.getTyped("swimming mastery", BinaryIntCodec)
		set(value) = attrs.setNullable("swimming mastery", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, add `kills + captures + defenses + buildingsdestroyed - (3 * deaths)` to player score, on top of the default scoring algorithm.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.scoreboardMinigame: Boolean?
		get() = attrs.getTyped("scoreboard minigame", BinaryIntCodec)
		set(value) = attrs.setNullable("scoreboard minigame", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, makes the player immune to "wet" status effects: Jarate, Mad Milk, Gas Passer.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.wetImmunity: Boolean?
		get() = attrs.getTyped("wet immunity", BinaryIntCodec)
		set(value) = attrs.setNullable("wet immunity", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Mult to zoom/unzoom delay on clipless weapons
	 * - Mult by level: 1=0.6, 2=0.3
	 * Mult to charge speed
	 * - 1=1.5, 2=3.0
	 *
	 * Value: the level of the ability.
	 */
	context(attrs: IKeyValueMap)
	var SniperRifleAttributes.abilityMasterSniper: Int?
		get() = attrs.getTyped("ability master sniper")
		set(value) = attrs.setNullable("ability master sniper", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Applies mult to reload speed: 1 = 0.6, 2 = 0.3
	 *
	 * Does not stack with Haste powerup.
	 */
	context(attrs: IKeyValueMap)
	var CompoundBowAttributes.abilityMasterSniper: Int?
		get() = attrs.getTyped("ability master sniper")
		set(value) = attrs.setNullable("ability master sniper", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * When reloading, if you only have 1 round left in your clip, get crit-boosted.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.lastShotCrits: Boolean?
		get() = attrs.getTyped("last shot crits", BinaryIntCodec)
		set(value) = attrs.setNullable("last shot crits", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, spies will keep their disguise when attacking with this weapon.
	 */
	context(attrs: IKeyValueMap)
	var BaseGunAttributes.keepDisguiseOnAttacking: Boolean?
		get() = attrs.getTyped("keep disguise on attack", BinaryIntCodec)
		set(value) = attrs.setNullable("keep disguise on attack", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Transfer this amount of health from yourself to your teammate when hitting them.
	 */
	context(attrs: IKeyValueMap)
	var BaseMeleeAttributes.giveHealthToTeammateOnHit: Int?
		get() = attrs.getTyped("add give health to teammate on hit")
		set(value) = attrs.setNullable("add give health to teammate on hit", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Can switch to other weapons while spinning minigun.
	 */
	context(attrs: IKeyValueMap)
	var MinigunAttributes.minigunCanHolsterWhileSpinning: Boolean?
		get() = attrs.getTyped("mod minigun can holster while spinning", BinaryIntCodec)
		set(value) = attrs.setNullable("mod minigun can holster while spinning", value, BinaryIntCodec)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * On kill, gives N% fire-rate bonus, stacking up to 3 times.  Killing a different class than the previous kill resets the combo.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.killComboFireRateBoost: Number?
		get() = attrs.getTyped("kill combo fire rate boost")
		set(value) = attrs.setNullable("kill combo fire rate boost", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Multiplier for health, ammo, and metal dispenser rate. Queried on the builder.
	 */
	context(attrs: IKeyValueMap)
	var DispenserAttributes.multDispenserResupplyRate: Number?
		get() = attrs.getTyped("mult dispenser rate")
		set(value) = attrs.setNullable("mult dispenser rate", value)
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Sentry max ammo multiplier. Queried on the builder.
	 */
	context(attrs: IKeyValueMap)
	var SentryGunAttributes.multSentryAmmo: Number?
		get() = attrs.getTyped("mvm sentry ammo")
		set(value) = attrs.setNullable("mvm sentry ammo", value)
	
	/**
	 * Sentry is 20% smaller with 33% less health, and requires 25% less metal to upgrade. Queried on the builder.
	 */
	context(attrs: IKeyValueMap)
	var SentryGunAttributes.buildSmallSentries: Boolean?
		get() = attrs.getTyped("build small sentries")
		set(value) = attrs.setNullable("build small sentries", value)
	
	/**
	 * Teleporter recharge duration multiplier. Queried on the builder.
	 */
	context(attrs: IKeyValueMap)
	var TeleporterAttributes.multTeleporterRechargeRate: Number?
		get() = attrs.getTyped("mult teleporter recharge rate")
		set(value) = attrs.setNullable("mult teleporter recharge rate", value)
	
	/**
	 * As spy, disguise as a dispenser when crouching.
	 */
	context(attrs: IKeyValueMap)
	var SpyOnlyAttributes.disguiseAsDispenserOnCrouch: Boolean?
		get() = attrs.getTyped("disguise as dispenser on crouch")
		set(value) = attrs.setNullable("disguise as dispenser on crouch", value)
	
	/**
	 * Uses this much ubercharge % per shot instead of normal ammunition.
	 */
	context(attrs: IKeyValueMap)
	var SyringeGunAttributes.uberchargeAmmo: Number?
		get() = attrs.getTyped("ubercharge ammo")
		set(value) = attrs.setNullable("ubercharge ammo", value)
	
	/**
	 * If `ubercharge_ammo` is set, hitting any other medic with the weapon will transfer this much ubercharge % to them.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.uberchargeTransfer: Number?
		get() = attrs.getTyped("ubercharge transfer")
		set(value) = attrs.setNullable("ubercharge transfer", value)
	
	
	
	
	/**
	 * On receiving fatal damage: x% chance of being immediately revived at spawn with 1 health.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.teleportInsteadOfDie: Number?
		get() = attrs.getTyped("teleport instead of die")
		set(value) = attrs.setNullable("teleport instead of die", value)
	
	/**
	 * Damage vs same class multiplier
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.multDmgVsSameClass: Number?
		get() = attrs.getTyped("mult dmg vs same class")
		set(value) = attrs.setNullable("mult dmg vs same class", value)
	
	/**
	 * On taking damage: x% chance of being ubercharged for 3 seconds
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.uberOnDamageTaken: Number?
		get() = attrs.getTyped("uber on damage taken")
		set(value) = attrs.setNullable("uber on damage taken", value)
	
	/**
	 * Damage taken from melee multiplier
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.multDmgtakenFromMelee: Number?
		get() = attrs.getTyped("mult dmgtaken from melee")
		set(value) = attrs.setNullable("mult dmgtaken from melee", value)
	
	/**
	 * Gain crit boost when below this proportion of health. (e.g. 0.6 = 60%)
	 */
	context(attrs: IKeyValueMap)
	var BaseEntityAttributes.multCritWhenHealthIsBelowPercent: Number?
		get() = attrs.getTyped("mult crit when health is below percent")
		set(value) = attrs.setNullable("mult crit when health is below percent", value)
	
	/**
	 * Multiplier applied to a bullet's damage after each successive player it penetrates.  Can also be used as a damage bonus applied exponentially per player penetrated.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.penetrationDamagePenalty: Number?
		get() = attrs.getTyped("penetration damage penalty")
		set(value) = attrs.setNullable("penetration damage penalty", value)
	
	/**
	 * Pulls the user forward with x velocity while firing the weapon.  Limited by ground move speed cap.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.firingForwardPull: Number?
		get() = attrs.getTyped("firing forward pull")
		set(value) = attrs.setNullable("firing forward pull", value)
	
	/**
	 * On all weapons, pulls the user forward with x velocity while firing the weapon.  Limited by ground move speed cap.
	 *
	 * Additionally on the flamethrower: applies [speed boost condition][btpos.source.vdfdsl.tf2.tftypes.TFCondition.SpeedBoost] while firing.
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.firingForwardPull: Number?
		get() = attrs.getTyped("firing forward pull")
		set(value) = attrs.setNullable("firing forward pull", value)
	
	
	
	/**
	 * Multiplier for Soldier's banner buff range. Base is 450 HU.
	 */
	context(attrs: IKeyValueMap)
	var BuffItemAttributes.multSoldierBuffRange: Number?
		get() = attrs.getTyped("mod soldier buff range")
		set(value) = attrs.setNullable("mod soldier buff range", value)
	
	/**
	 * Deploy speed bonus when rocket jumping
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.multRocketjumpDeployTime: Number?
		get() = attrs.getTyped("mult rocketjump deploy time")
		set(value) = attrs.setNullable("mult rocketjump deploy time", value)
	
	/**
	 * Fire rate multiplier when not rocket jumping.
	 */
	context(attrs: IKeyValueMap)
	var BaseGunAttributes.mulNonrocketjumpAttackrate: Number?
		get() = attrs.getTyped("mul nonrocketjump attackrate")
		set(value) = attrs.setNullable("mul nonrocketjump attackrate", value)
	
	/**
	 * On hit: refire time * (x/60) % chance for aoe heal for 1s (24 hp healed total). use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.aoeHealChance: Number?
		get() = attrs.getTyped("aoe heal chance")
		set(value) = attrs.setNullable("aoe heal chance", value)
	
	/**
	 * On hit: refire time * (x/60) % chance for crit boost for 3s.  use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.critsOnDamage: Number?
		get() = attrs.getTyped("crits on damage")
		set(value) = attrs.setNullable("crits on damage", value)
	
	/**
	 * On hit: refire time * (x/60) % chance for stun for 3s. use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.stunOnDamage: Number?
		get() = attrs.getTyped("stun on damage")
		set(value) = attrs.setNullable("stun on damage", value)
	
	/**
	 * On hit: refire time * (x/60) % chance for 100 hu blast that stuns players for 2 seconds and applies bleed. use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.aoeBlastOnDamage: Number?
		get() = attrs.getTyped("aoe blast on damage")
		set(value) = attrs.setNullable("aoe blast on damage", value)
	
	/**
	 * Multiplier applied to damage proportion that is multiplied by "player maximum health" / "player current health".
	 */
	context(attrs: IKeyValueMap)
	var BaseMeleeAttributes.multDmgWithReducedHealth: Number?
		get() = attrs.getTyped("mult dmg with reduced health")
		set(value) = attrs.setNullable("mult dmg with reduced health", value)
	
	/**
	 * Multiplier of how fast primary fire specifically can be used after airblasting.
	 *
	 * Primary attack delay = this * refire_time * base
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.multAirblastPrimaryRefireTime: Number?
		get() = attrs.getTyped("mult airblast primary refire time")
		set(value) = attrs.setNullable("mult airblast primary refire time", value)
	
	/**
	 * Spin up time for flamethrowers, like the delay between starting to rev up a minigun and being able to fire.
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.modFlamethrowerSpinupTime: Duration?
		get() = attrs.getTyped("mod flamethrower spinup time", DurationCodec)
		set(value) = attrs.setNullable("mod flamethrower spinup time", value, DurationCodec)
	
	/**
	 * Scales the cone used to push players by this amount.
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.multAirblastConeScale: Number?
		get() = attrs.getTyped("mult airblast cone scale")
		set(value) = attrs.setNullable("mult airblast cone scale", value)
	
	/**
	 * Combination of flamethrower flags, used to limit airblast functionality.
	 *
	 * If empty or not set,
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.airblastFunctionalityFlags: EnumSet<AirblastFunctionalityFlags>?
		get() = attrs.getTyped("airblast functionality flags", EnumSetOrCodec())
		set(value) = attrs.setNullable("airblast functionality flags", value, EnumSetOrCodec())
	
	/**
	 * Determines which of these things an airblast can do.
	 *
	 * @see airblastFunctionalityFlags
	 */
	enum class AirblastFunctionalityFlags : IEnumCustomValue {
		/**
		 * If set, airblast knocks targets away from the user in a cone.
		 *
		 * @see PUSHBACK_STUN
		 * @see PUSHBACK_VIEW_PUNCH
		 */
		PUSHBACK,
		/** If set, airblast can put out teammates that are on fire. */
		EXTINGUISH_TEAMMATES,
		/** If set, the airblast can reflect any projectiles back at enemy players. */
		REFLECT_PROJECTILES,
		/**
		 * If set, airblast hinders players' air acceleration until they next touch the ground.
		 *
		 * Requires [PUSHBACK].
		 */
		PUSHBACK_STUN,
		/**
		 * If set, airblast flinches ("aimpunches") players it connects with.
		 *
		 * Requires [PUSHBACK].
		 */
		PUSHBACK_VIEW_PUNCH;
		
		override val value: Int
			get() = 1 shl ordinal
	}
	
	/**
	 * Airblast pushes players towards the user.
	 *
	 * If [airblastFunctionalityFlags] is configured, requires [the ability to push enemies back][AirblastFunctionalityFlags.PUSHBACK].
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.reverseAirblast: Boolean?
		get() = attrs.getTyped("reverse airblast")
		set(value) = attrs.setNullable("reverse airblast", value)
	
	/**
	 * Airblast pushes the pyro instead of enemies. Affected by airblast push force.
	 *
	 * Flamethrowers with this attribute cannot reflect projectiles.
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.airblastDashes: Boolean?
		get() = attrs.getTyped("airblast dashes")
		set(value) = attrs.setNullable("airblast dashes", value)
	
	/**
	 * Sniper rifle charge rate when looking at the enemy. Still subject to the 200% charge rate limit
	 */
	context(attrs: IKeyValueMap)
	var SniperRifleAttributes.multSniperChargePerSecWithEnemyUnderCrosshair: Number?
		get() = attrs.getTyped("mult sniper charge per sec with enemy under crosshair")
		set(value) = attrs.setNullable("mult sniper charge per sec with enemy under crosshair", value)
	
	/**
	 * Plays `doomsday.warhead` sound when an enemy appears under your crosshair.
	 */
	context(attrs: IKeyValueMap)
	var SniperRifleAttributes.sniperBeepWithEnemyUnderCrosshair: Boolean?
		get() = attrs.getTyped("sniper beep with enemy under crosshair")
		set(value) = attrs.setNullable("sniper beep with enemy under crosshair", value)
	
	/**
	 * If set to 1, enables healing buildings as medic. increases building healing rate by 10% for each point
	 */
	context(attrs: IKeyValueMap)
	var MedigunAttributes.medicMachineryBeam: Int?
		get() = attrs.getTyped("medic machinery beam")
		set(value) = attrs.setNullable("medic machinery beam", value)
	
	/**
	 * Bots with this attribute distribute their currency on death, like with sniper kills (red money)
	 */
	context(attrs: IKeyValueMap)
	var MvMBotAttributes.forceDistributeCurrencyOnDeath: Boolean?
		get() = attrs.getTyped("force distribute currency on death")
		set(value) = attrs.setNullable("force distribute currency on death", value)
}
