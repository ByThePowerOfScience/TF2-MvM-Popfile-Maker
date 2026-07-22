package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.WaveSchedule

abstract class RafmodCash {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodCash() {}
	}
	
	/**
	 * The ratio of cash collected to total cash required to award the players 50 bonus credits at the end of the wave. (Default: 0.95)
	 * 
	 * Example:
	 * ```kotlin
	 * ratioForHalfBonus = 0.75
	 * ```
	 */
	open var WaveSchedule.ratioForHalfBonus: Double? by addField("BonusRatioHalf", conditional = SIGSEGV)
	
	/**
	 * The ratio of collected cash to total cash dropped required to award the players 100 bonus credits at the end of the wave. (Default: 1.0)
	 * 
	 * Example:
	 * ```kotlin
	 * ratioForFullBonus = 0.8
	 * ```
	 */
	open var WaveSchedule.ratioForFullBonus: Double? by addField("BonusRatioFull", conditional = SIGSEGV)
	
	/**
	 * If true, players can only buy a quick respawn a set number of times per wave, specified via [fixedBuybacksPerWave].
	 * 
	 * Note: fixed buybacks are free.
	 */
	open var WaveSchedule.useFixedBuybacks: Boolean? by addField("FixedBuybacks", conditional = SIGSEGV)
	
	/**
	 * How many times a player can buy a quick respawn if [useFixedBuybacks] is true. (Default: 0)
	 * 
	 * Example:
	 * ```kotlin
	 * fixedBuybacksPerWave = 6
	 * ```
	 */
	open var WaveSchedule.fixedBuybacksPerWave: Int? by addField("BuybacksPerWave", conditional = SIGSEGV)
	
	/**
	 * How many credits players will lose upon death. (Default: 0)
	 * 
	 * Example:
	 * ```kotlin
	 * creditsLostOnDeath = 100
	 * ```
	 */
	open var WaveSchedule.creditsLostOnDeath: Int? by addField("DeathPenalty", conditional = SIGSEGV)
	
	/**
	 * If true, credits spawn with zero velocity, and drop straight to the ground when a robot is killed.
	 */
	open var WaveSchedule.noCreditsVelocity: Boolean? by addField("NoCreditsVelocity", conditional = SIGSEGV)
	
}