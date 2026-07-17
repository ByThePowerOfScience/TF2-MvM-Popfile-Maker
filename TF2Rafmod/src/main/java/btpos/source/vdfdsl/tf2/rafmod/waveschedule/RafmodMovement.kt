package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.WaveSchedule

abstract class RafmodMovement {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodMovement() {}
	}
	
	/**
	 * Allows true bunnyhopping, disabling the post-jump speed cap imposed by the vanilla game.
	 *
	 * Example:
	 * ```kotlin
	 * allowBunnyHopping = BHop.AUTO_BHOP
	 * ```
	 */
	var WaveSchedule.allowBunnyHopping: BHop? by addField("BunnyHop", conditional = SIGSEGV)
	
	
	class BHop(override val _vdfRepr: VDFPrimitive) : IVDFRepresentableValue_Trivial {
		companion object {
			/**
			 * Players cannot bhop.
			 */
			val NONE = BHop(VDFPrimitive(0))
			
			/**
			 * Allows players to automatically bunny-hop by holding the spacebar.
			 */
			val AUTO_BHOP = BHop(VDFPrimitive(1))
			
			val NO_AUTO_BHOP = BHop(VDFPrimitive(2))
		}
	}
	
	/**
	 * Acceleration experienced when pressing a directional key. (Default: 10 HU/s/s)
	 *
	 * Example:
	 * ```kotlin
	 * groundAcceleration = 100
	 * ```
	 */
	var WaveSchedule.groundAcceleration: Number? by addField("Accelerate", conditional = SIGSEGV)
	
	/**
	 * Air acceleration (turning rate while in the air)
	 *
	 * Example:
	 * ```kotlin
	 * airAcceleration = 100
	 * ```
	 */
	var WaveSchedule.airAcceleration: Number? by addField("AirAccelerate", conditional = SIGSEGV)
	
	
	/**
	 * Max speed limit override. Values above 520 enchance giant scout movement. Values above 521 disable jumping on stuck. (Default: 520)
	 * 
	 * Example:
	 * ```kotlin
	 * maxSpeedLimit = 521
	 * ```
	 */
	var WaveSchedule.maxSpeedLimit: Number? by addField("MaxSpeedLimit", conditional = SIGSEGV)
	
	/**
	 * Maximum entity speed limit override. (Default: 3500 HU/s)
	 *
	 * Example:
	 * ```kotlin
	 * maxEntitySpeed = 10000
	 * ```
	 */
	var WaveSchedule.maxEntitySpeed: Number? by addField("MaxEntitySpeed", conditional = SIGSEGV)
	
	
}

