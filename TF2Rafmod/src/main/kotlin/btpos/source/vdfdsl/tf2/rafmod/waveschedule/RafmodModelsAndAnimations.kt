package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.WaveSchedule

abstract class RafmodModelsAndAnimations : IBlockScoped {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodModelsAndAnimations() {}
	}
	
	/**
	 * If true, robots use player animations instead of robot ones.
	 */
	val robotsUsePlayerAnimation by addField<Boolean>("PlayerRobotsUsePlayerAnimation", conditional = SIGSEGV)
	
	/**
	 * If true, fixes the lack of player animations after firing the [setCustomModel] input on a player.
	 */
	val fixSetCustomModelInput by addField<Boolean>("FixSetCustomModelInput", conditional = SIGSEGV)
	
	/**
	 * If set at all, bots use human models. If 1, bots cannot be sapped, but if set to 2, they can.
	 *
	 * Example:
	 * ```kotlin
	 * botsAreHumans = 1 // Makes bots use human models, and bots cannot be sapped.
	 * ```
	 */
	val botsAreHumans by addField<Int>("BotsAreHumans", conditional = SIGSEGV)
	
	/**
	 * How fast the [headScale][btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes.headScale], [torsoScale][btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes.torsoScale], and [handScale][btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes.handScale] attributes scale robot body parts. (Default: 1)
	 *
	 * Example:
	 * ```kotlin
	 * bodyPartScaleSpeed = 2
	 * ```
	 */
	val bodyPartScaleSpeed by addField<Number>("BodyPartScaleSpeed", conditional = SIGSEGV)
}