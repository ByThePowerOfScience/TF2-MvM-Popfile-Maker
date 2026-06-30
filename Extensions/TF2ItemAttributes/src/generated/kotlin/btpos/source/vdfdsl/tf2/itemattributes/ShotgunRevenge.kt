package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: Frontier Justice
 */
interface ShotgunRevengeAttributes : btpos.source.vdfdsl.tf2.itemattributes.ShotgunAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : ShotgunRevengeAttributes
	
	/**
	 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
	 *
	 * 
	 *
	 * Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var canGainRevengeCrits: Boolean?
		get() = attrs.getTyped("mod sentry killed revenge", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("mod sentry killed revenge", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

