package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.types.WaveSchedule
import kotlin.time.Duration

abstract class RafmodGameplay {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodGameplay() {}
	}
	
	/**
	 * Proportion of damage dealt returned as healing while the Concheror effect is active. (Default: 0.35)
	 *
	 * Example:
	 * ```kotlin
	 * conchHealthOnHit = 0.77
	 * ```
	 */
	open var WaveSchedule.conchHealthOnHit: Double? by addField("ConchHealthOnHit", conditional = SIGSEGV)
	
	/**
	 * Number of seconds the "Marked for Death" status lasts on a target.
	 *
	 * (Default: 15)
	 *
	 * Example:
	 * ```kotlin
	 * markedForDeathLifetime = 1
	 * ```
	 */
	open var WaveSchedule.markedForDeathLifetime: Duration? by addField("MarkedForDeathLifetime", conditional = SIGSEGV, serializer = IExtensibleSubtree.Serializers.durationInSeconds())
	
	/**
	 * Number of ubercharges the Vaccinator can hold. (Default: 4)
	 *
	 * Example:
	 * ```kotlin
	 * numVaccinatorCharges = 16
	 * ```
	 */
	open var WaveSchedule.numVaccinatorCharges: Int? by addField("VacNumCharges", conditional = SIGSEGV)
	
	/**
	 * The maximum amount of time that can pass between hitting an enemy with the cannonball and said cannonball exploding to hit a double-donk on the target. (Default: 0.5 seconds)
	 * 
	 * Example:
	 * ```kotlin
	 * doubleDonkWindow = 99.seconds
	 * ```
	 */
	open var WaveSchedule.doubleDonkWindow: Duration? by addField("DoubleDonkWindow", conditional = SIGSEGV)
	
	/**
	 * Speed boost provided by the Concheror buff in Hammer Units per second, capped to a 40% total speed increase on the player. (Default: 105)
	 * 
	 * Example:
	 * ```kotlin
	 * conchSpeedBoost = 10
	 * ```
	 */
	open var WaveSchedule.conchSpeedBoost: Number? by addField("ConchSpeedBoost", conditional = SIGSEGV)
	
	/**
	 * Multiplier to damage received while cloaked. (Default: 0.8)
	 *
	 * Example:
	 * ```kotlin
	 * stealthDamageReduction = 0.1
	 * ```
	 */
	open var WaveSchedule.cloakedDamageMultiplier: Double? by addField("StealthDamageReduction", conditional = SIGSEGV)
	
	/**
	 * If true, heal-on-kill - when proc'd by melee weapons - can overheal the user.
	 */
	open var WaveSchedule.healOnKillOverhealMelee: Boolean? by addField("HealOnKillOverhealMelee", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, fixes the Huntsman's "damage bonus" upgrade so it is applied properly. (Default: false)
	 */
	open var WaveSchedule.fixHuntsmanDamageBonus: Boolean? by addField("FixHuntsmanDamageBonus", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	
	
}