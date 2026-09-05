package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.WaveSchedule

abstract class RafmodBomb : IBlockScoped {
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
	open var WaveSchedule.flagCarrierMovementPenalty: Double? by addField("FlagCarrierMovementPenalty", conditional = SIGSEGV)
	
	/**
	 * Allow this many extra bots to latch onto and follow the bomb carrier as they move. (Default: 0)
	 *
	 * Example:
	 * ```kotlin
	 * flagEscortCountOffset = 5 // makes there be 6 bombs on the field
	 * ```
	 */
	val numBombEscorts by addField<Int>("FlagEscortCountOffset", conditional = SIGSEGV, serializer = { this - 1 })
	
	/**
	 * If false, the bomb carrier cannot fire or swing their weapon. (Default: true)
	 */
	val canBombCarrierAttack by addField<Boolean>("AllowFlagCarrierToFight", conditional = SIGSEGV)
	
	/**
	 * If true, players carrying the bomb for enough time will gain the same defense, health regen, and eventually crits that bots do. (Default: false)
	 */
	val allowBombBuffsForPlayerCarriers by addField<Boolean>("AllowBombBuffsForPlayerCarriers", conditional = SIGSEGV)
	
	
}