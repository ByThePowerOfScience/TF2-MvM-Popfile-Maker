package btpos.source.vdfdsl.serialization

/**
 * A basic key-value pair: a name, and something assigned to that name.
 *
 * These are often members of a [VDFSubtree] that represents some scope.
 *
 * Note: structs are represented as entries with a [VDFSubtree] as a value,
 * as they only differ from the standard "name: value" format in that they name _themselves_.
 */
data class VDFKeyValue(val key: Any, val value: Any) {
	companion object {
		/**
		 * Factory for easy "Only make the entry if the value is set"
		 */
		fun orNull(key: Any, value: Any?): VDFKeyValue? {
	        if (value == null)
				return null
			
			return VDFKeyValue(key, value)
	    }
	}
}