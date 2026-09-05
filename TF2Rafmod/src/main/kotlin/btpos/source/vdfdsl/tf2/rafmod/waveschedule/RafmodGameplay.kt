package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.types.WaveSchedule
import kotlin.time.Duration

class RafmodGameplay(subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : NestedScope(subtree) {
	override fun copy() = RafmodGameplay(copyInternal())
	
	/**
	 * If true, minibosses only count as a single kill on a sentry gun instead of multiple.
	 */
	val minibossSentrySingleKill by addField<Boolean>("MinibossSentrySingleKill", conditional = SIGSEGV)
	
	
	/**
	 * If true, hitting a target for negative damage will heal them. (Default: true)
	 */
	val negativeDamageHealsTargets by addField<Boolean>("RestoreNegativeDamageHealing", conditional = SIGSEGV)
	
	/**
	 * Proportion of damage dealt returned as healing while the Concheror effect is active. (Default: 0.35)
	 *
	 * Example:
	 * ```kotlin
	 * conchHealthOnHit = 0.77
	 * ```
	 */
	val negativeDamageOverhealsTargets by addField<Boolean>("RestoreNegativeDamageOverheal", conditional = SIGSEGV)
	
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
	val allowMultipleSappers by addField<Boolean>("AllowMultipleSappers", conditional = SIGSEGV)
	
	
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
	val grapplingHooksDisconnectAfter by addField<Duration>("RemoveGrapplingHooks", conditional = SIGSEGV, serializer = durationInSeconds())
	
	
}