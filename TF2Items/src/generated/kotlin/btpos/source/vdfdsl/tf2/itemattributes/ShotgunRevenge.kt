package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Frontier Justice
 */
interface ShotgunRevengeAttributes : ShotgunAttributes, IBlockScoped {
	companion object : ShotgunRevengeAttributes
	
	/**
	 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
	 *
	 * 
	 *
	 * The weapon supports revenge crits if this, `extinguish_revenge`, or `sapper_kills_collect_crits` are set.
	 *
	 * Note that the logic for _gaining_ said crits depends on the weapon. Having one of these set just says it _can_ have them.
	 *
	 * Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
	 */
	context(attrs: IKeyValueMap)
	override var canGainRevengeCrits: Boolean?
		get() = super.canGainRevengeCrits
		set(value) { super.canGainRevengeCrits = value }
}

