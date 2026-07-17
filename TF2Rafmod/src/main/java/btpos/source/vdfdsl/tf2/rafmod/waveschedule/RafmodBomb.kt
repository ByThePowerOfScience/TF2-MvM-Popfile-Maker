package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.WaveSchedule

abstract class RafmodBomb {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodBomb() {}
	}
	
	
	/**
	 * Scales the flag carrier's movement speed by this amount. (Default: 0.5)
	 *
	 * Example:
	 * ```kotlin
	 * flagCarrierMovementPenalty = 0.4
	 * ```
	 */
	var WaveSchedule.flagCarrierMovementPenalty: Double? by addField("FlagCarrierMovementPenalty", conditional = SIGSEGV)
	
	/**
	 * Allow this many extra bots to latch onto and follow the bomb carrier as they move. (Default: 0)
	 *
	 * Example:
	 * ```kotlin
	 * flagEscortCountOffset = 5 // makes there be 6 bombs on the field
	 * ```
	 */
	var WaveSchedule.additionalEscorts: Int? by addField("FlagEscortCountOffset", conditional = SIGSEGV)
	
	
	
	/**
	 * If false, the bomb carrier cannot fire or swing their weapon. (Default: true)
	 */
	var WaveSchedule.canBombCarrierFight: Boolean? by addField("AllowFlagCarrierToFight", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
}