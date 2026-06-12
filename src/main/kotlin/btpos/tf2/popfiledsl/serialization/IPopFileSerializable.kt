package btpos.tf2.popfiledsl.serialization


/**
 * Anything that has a special popfile representation, such as a keyword, a string, or a map.
 */
interface IPopFileSerializable<out T> {
	/**
	 * The special representation that should be serialized.
	 *
	 * This should be a lazily-evaluated property. (i.e. have a getter)
	 */
	val _popFileRepr: T
}

/**
 * A basic key-value pair: a name, and something assigned to that name.
 *
 * These are often members of a [PopFileMap] that represents some scope.
 *
 * Note: structs are represented as entries with a [PopFileMap] as a value,
 * as they only differ from the standard "name: value" format in that they name _themselves_.
 */
data class PopFileEntry(val key: Any, val value: Any) {
	companion object {
		/**
		 * Factory for easy "Only make the entry if the value is set"
		 */
		fun orNull(key: Any, value: Any?): PopFileEntry? {
	        if (value == null)
				return null
			
			return PopFileEntry(key, value)
	    }
	}
}

/**
 * Marker class, so we can wrap the collection of pairs in braces when serializing.
 */
data class PopFileMap(val entries: Collection<PopFileEntry>) {
	fun withEntry(entry: PopFileEntry) = PopFileMap(entries + entry)
	
	fun withEntries(vararg entries: PopFileEntry) = PopFileMap(this.entries + entries)
	
	fun withEntries(entries: Iterable<PopFileEntry>) = PopFileMap(this.entries + entries)
}

/**
 * Helper for [IPopFileSerializable] to just auto-quote the string
 */
interface IPopFileLiteralStringSerializable : IPopFileSerializable<PopFileStringLiteral> {
	override val _popFileRepr: PopFileStringLiteral
		get() = PopFileStringLiteral(popFileStringValue)
	
	val popFileStringValue: String
}

@JvmRecord
data class PopFileStringLiteral(val string: String) {
	companion object {
		fun String.literal() = PopFileStringLiteral(this)
	}
}