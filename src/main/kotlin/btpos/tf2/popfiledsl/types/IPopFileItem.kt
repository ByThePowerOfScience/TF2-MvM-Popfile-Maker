@file:Suppress("JavaDefaultMethodsNotOverriddenByDelegation")

package btpos.tf2.popfiledsl.types


/**
 * Anything that has a special popfile representation, such as a keyword, a string, or a map.
 */
interface IPopFileItem {
	val popFileRepr: Any
}

class NamedMap(val name: String, val map: Map<Any, Any>)

/**
 * A "string" that will not be wrapped in quotes when serialized.
 *
 * Most instances should already be created, but this is left open so you can extend this library in the future if further keys are added.
 */
class PopFileKeyword private constructor(val keyword: Any) {
	companion object {
		private val interner = HashMap<String, PopFileKeyword>()
		
	    operator fun invoke(name: String): PopFileKeyword {
	        return interner.computeIfAbsent(name, ::PopFileKeyword)
	    }
	}
}
