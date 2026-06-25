package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Frontier Justice
 * 
 */
abstract class ShotgunRevengeAttributes : ShotgunAttributes() {
	companion object : ShotgunRevengeAttributes() {
		operator fun invoke(scope: ShotgunRevengeAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
	 */
	context(attrs: IKeyValueMap)
	var modSentryKilledRevenge: Boolean?
		get() = attrs.getTyped("mod sentry killed revenge", BinaryIntCodec)
		set(value) = attrs.setNullable("mod sentry killed revenge", value, BinaryIntCodec)
}

