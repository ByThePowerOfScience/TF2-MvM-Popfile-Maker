package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Frontier Justice
 */
interface ShotgunRevengeAttributes : ShotgunAttributes, IBlockScoped {
	companion object : ShotgunRevengeAttributes
	
	/**
	 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
	 *
	 * 
	 *
	 * Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
	 */
	context(attrs: IKeyValueMap)
	var canGainRevengeCrits: Boolean?
		get() = attrs.getTyped("mod sentry killed revenge", BinaryIntCodec)
		set(value) = attrs.setNullable("mod sentry killed revenge", value, BinaryIntCodec)
}

