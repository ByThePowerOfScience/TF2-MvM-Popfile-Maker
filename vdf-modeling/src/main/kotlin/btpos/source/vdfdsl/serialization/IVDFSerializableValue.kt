package btpos.source.vdfdsl.serialization


/**
 * Anything that has a popfile representation that is different from its own object,
 * such as being serialized to a word/phrase, a number, or a [map][VDFSubtree].
 *
 * Note that lists must be serialized using multiple keyvalues: \[key listitem1], \[key listitem2], etc
 */
interface IVDFSerializableValue<out T> {
	/**
	 * The special representation that should be serialized.
	 *
	 * When the data contained in this object can change after it's created, this should be a _lazily-evaluated_ property.
	 * (i.e. use `override val _vdfRepr get() = ...` instead of `override val _vdfRepr = ...`,
	 * since the former is just a method that can be called later and the latter actually calculates and saves it when the object is created.)
	 */
	val _vdfRepr: T
}

interface IVDFSerializableKeyValue {
	/**
	 * Add this value to the currently-serialized map.
	 *
	 * @param input The current state of the map to be serialized.
	 * @return The new map to be serialized.
	 */
	fun _serialize(input: VDFSubtree): VDFSubtree
}

/**
 * An item that just serializes to a single key-value entry.
 */
interface IVDFSerializableKeyValueSingle : IVDFSerializableKeyValue {
	fun popFileEntryRepr(): VDFKeyValue
	
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		return input.withEntry(this.popFileEntryRepr())
	}
}

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

/**
 * Marker class, so we can wrap the collection of pairs in braces when serializing.
 */
data class VDFSubtree(val entries: Collection<VDFKeyValue> = listOf()) {
	fun withEntry(entry: VDFKeyValue) = VDFSubtree(entries + entry)
	
	fun withEntries(vararg entries: VDFKeyValue) = VDFSubtree(this.entries + entries)
	
	fun withEntries(entries: Iterable<VDFKeyValue>) = VDFSubtree(this.entries + entries)
	
	operator fun plus(entry: VDFKeyValue) = withEntry(entry)
	
	
	operator fun plus(entries: Iterable<VDFKeyValue>) = withEntries(entries)
}