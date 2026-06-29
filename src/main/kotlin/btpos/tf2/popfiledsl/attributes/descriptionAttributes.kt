package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.modeling.delegate
import btpos.tf2.popfiledsl.serialization.VDFStringLiteral.Companion.literal

class DescriptionAttributes(val _attr: IKeyValueMap) {
	/**
	 * Coated enemies take mini-crits. Can be used to extinguish fire
	 *
	 * percentage
	 */
	val jarateDescription: Double? by _attr.delegate("jarate description".literal())
	
}