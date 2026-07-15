@file:Suppress("unused")

package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IEnumCustomValue
import java.util.EnumSet


enum class TFCritCondition : IEnumCustomValue {
	/**
	 * Currently on fire, whether or not they experience afterburn damage. (Includes Pyros currently caught in flames.)
	 *
	 * TF_COND_BURNING
	 */
	Burning,
	
	/**
	 * Scoped into a sniper-rifle OR revved-up with a minigun.
	 *
	 * TF_COND_BURNING
	 */
	Aiming,
	
	/**
	 * Scoped into a sniper-rifle.
	 *
	 * TF_COND_ZOOMED
	 */
	Zoomed,
	
	/**
	 * In the act of disguising, where the cloud of smoke surrounds them.
	 *
	 * TF_COND_DISGUISING
	 */
	Disguising,
	
	/**
	 * Currently disguised as another player.
	 *
	 * TF_COND_DISGUISED
	 */
	Disguised,
	
	/**
	 * Currently cloaked and fully invisible.
	 *
	 * TF_COND_STEALTHED
	 */
	Cloaked,
	
	/**
	 * Under the effects of a stock Ubercharge.
	 *
	 * TF_COND_INVULNERABLE
	 */
	Invulnerable,
	
	/**
	 * Recently teleported by a teleporter, with the ring of light around their feet.
	 *
	 * TF_COND_TELEPORTED
	 */
	Teleported,
	
	/**
	 * Currently taunting.
	 *
	 * TF_COND_TAUNTING
	 */
	Taunting,
	
	/**
	 * Under the effects of a stock Ubercharge, where the effect has started to flash to indicate it is about to disappear.
	 *
	 * TF_COND_INVULNERABLE_WEARINGOFF
	 */
	Invulnerable_WearingOff,
	
	/**
	 * When a cloaked spy is bumped by another player, or the Cloak and Dagger has run out of charge but the spy is still moving.
	 *
	 * TF_COND_STEALTHED_BLINK
	 */
	Cloaked_Blink,
	
	/**
	 * When a teleporter has selected this entity to be teleported, and they are experiencing the flash of light and camera distortion leading up to their teleportation.
	 *
	 * TF_COND_SELECTED_TO_TELEPORT
	 */
	SelectedToTeleport,
	
	/**
	 * Crit-boosted, such as during a Kritzkrieg Ubercharge or after capturing the flag in CTF.
	 *
	 * TF_COND_CRITBOOSTED
	 */
	CritBoosted,
	
	/**
	 * Unimplemented.
	 *
	 * TF_COND_TMPDAMAGEBONUS
	 */
	TmpDamageBonus,
	
	/**
	 * The condition taken on by a player after their Dead Ringer has been triggered, where they are temporarily immune to afterburn or having their cloak blink upon contact with enemies or taking damage.
	 *
	 * TF_COND_FEIGN_DEATH
	 */
	FeignDeath,
	
	/**
	 * The condition taken on by drinking the Bonk! Atomic Punch, where the player is restricted to melee-only, is immune to all damage for the duration, and has their movement speed reduced after it expires based on how much damage they would have taken while the effect was active.
	 *
	 * TF_COND_PHASE
	 */
	BonkPhase,
	
	/**
	 * The stun effect applied by the Sandman or `mod_stun_waist_high_airborne`.
	 *
	 * TF_COND_STUNNED
	 */
	Stunned,
	
	/**
	 * Applied when a player is being healed over time by a Medi-Gun or dispenser.
	 *
	 * TF_COND_HEALTH_BUFF
	 */
	BeingHealed,
	
	/**
	 * Applied when a player has overheal.
	 *
	 * TF_COND_HEALTH_OVERHEALED
	 */
	Overhealed,
	
	/**
	 * Targets take minicrits and are covered in high-tier martial arts.
	 *
	 * TF_COND_URINE
	 */
	Jarate,
	
	/**
	 * Minicrit-boost applied by the Crit-a-Cola, Cleaner's Carbine, and Buffalo Steak Sandvich.  Not applied by the Buff Banner.
	 *
	 * TF_COND_ENERGY_BUFF
	 */
	MinicritBoosted;
	
	infix fun or(other: TFCritCondition): EnumSet<TFCritCondition> = EnumSet.of(this, other)
	
	override val value: Int
		get() = 1 shl this.ordinal
	
}

infix fun EnumSet<TFCritCondition>.or(other: TFCritCondition) = this.apply { add(other) }
infix fun EnumSet<TFCritCondition>.or(other: EnumSet<TFCritCondition>) = this.apply { addAll(other) }