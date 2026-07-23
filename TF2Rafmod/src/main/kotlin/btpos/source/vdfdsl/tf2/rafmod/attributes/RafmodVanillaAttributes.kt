package btpos.source.vdfdsl.tf2.rafmod.attributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CompoundBowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CrossbowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.DispenserAttributes
import btpos.source.vdfdsl.tf2.itemattributes.EntityAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MinigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MvMBotAttributes
import btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RevolverAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SentryGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SniperRifleAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WearableAttributes

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
	var EntityAttributes.modTeleporterSpeedBoost: Boolean?
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
	 * If true, forbids you from floating upwards with the jump button in the water.
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
	 * On kill, gives N% fire-rate bonus, stacking up to 3 times.  Killing a different class than the previous kill resets the combo.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.killComboFireRateBoost: Float?
		get() = attrs.getTyped("kill combo fire rate boost")
		set(value) = attrs.setNullable("kill combo fire rate boost", value)
	
	/**
	 * Multiplier for health, ammo, and metal dispenser rate. Queried on the builder.
	 */
	context(attrs: IKeyValueMap)
	var DispenserAttributes.multDispenserResupplyRate: Float?
		get() = attrs.getTyped("mult dispenser rate")
		set(value) = attrs.setNullable("mult dispenser rate", value)
	
	/**
	 * Sentry max ammo multiplier. Queried on the builder.
	 */
	context(attrs: IKeyValueMap)
	var SentryGunAttributes.multSentryAmmo: Float?
		get() = attrs.getTyped("mvm sentry ammo")
		set(value) = attrs.setNullable("mvm sentry ammo", value)
	
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, the bot will distribute its currency on death instead of leaving a pickup, like when killed by a Sniper.
	 */
	context(attrs: IKeyValueMap)
	var MvMBotAttributes.forceDistributeCurrencyOnDeath: Boolean?
		get() = attrs.getTyped("force distribute currency on death", BinaryIntCodec)
		set(value) = attrs.setNullable("force distribute currency on death", value, BinaryIntCodec)
	
	
}

object RafmodCustomAttributes {

}

