package btpos.source.vdfdsl.tf2.rafmod.attributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlamethrowerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MinigunAttributes
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
	 * Custom Rafmod attribute.  Works on most projectiles. Requires precaching via [btpos.source.vdfdsl.tf2.rafmod.RafmodWaveScheduleExtensions.precache].
	 *
	 * Example:
	 * ```kotlin
	 * items += Weapons.HUNTSMAN.withAttributes {
	 *      customProjectileModel = "models/props_soho/bookstand002.mdl"
	 * }
	 * ```
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.customProjectileModel: String?
		get() = attrs.getTyped("custom projectile model")
		set(value) = attrs.setNullable("custom projectile model", value)
	
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon.
	 *
	 * @see BaseMeleeAttributes.critFromBehind
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.critFromBehind
		get() = BaseMeleeAttributes.critFromBehind
		set(value) { BaseMeleeAttributes.critFromBehind = value }
}