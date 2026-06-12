package btpos.tf2.popfiledsl.modeling

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileMap
import btpos.tf2.popfiledsl.serialization.codecs.Codec
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A structure in an MvM popfile, modeled as an extensible map that can contain multiple mappings for a single key.
 *
 * Structs resolve to a [PopFileEntry] that is a pair of its _identifier_ and its _map_.
 *
 * Structs essentially only differ from normal "key: someMap" entries in that they have their own unchanging key that defines their type.
 */
abstract class AbstractMvMStruct(val _subtree: MvMSubtreeImpl = MvMSubtreeImpl()) : IPopFileSerializable<PopFileEntry>, IMvMSubtree by _subtree {
	final override val _popFileRepr: PopFileEntry
		get() = PopFileEntry(_popFileStructIdentifier, _subtree._popFileRepr)
	
	abstract val _popFileStructIdentifier: Any
}


/**
 * Essentially a list of key-value pairs (e.g. "x, y") that can contain multiple keys as well as multiple values.
 *
 * This is fully extensible with new keys on the fly using the [factories][Companion].
 * See subclasses of [AbstractMvMStruct] for implementation.
 */
interface IMvMSubtree {
	/**
	 * A bunch of raw items, keyed by whatever arbitrary value is used to retrieve them for user use.
	 *
	 * All keys will be ignored when serializing the entries to a popfile. Values are expected to provide their own keys.
	 */
	val _rawEntries: MutableMap<Any, IPopFileSerializable<Iterable<PopFileEntry>>>
	
	val _customHandlers: MutableMap<Any, CustomHandler<*>>
	
	/**
	 * Keep a stacktrace log of where the object was created,
	 * so we can throw it if a required field isn't set and it gives the line in question.
	 */
	val _instantiationSite: Array<StackTraceElement>
	
	@Suppress("UNCHECKED_CAST")
	companion object {
		/**
		 * Extend a struct with a field that can only be in that struct once.
		 *
		 * This version of the method allows you to specify a codec, which allows the user to input one thing and then it serializes another.
		 *
		 * ## Example:
		 *
		 * Popfile:
		 * ```txt
		 * Mission
		 * {
		 *      Objective "DestroySentries"
		 * }
		 * ```
		 *
		 * Property:
		 * ```kotlin
		 * var MissionPopulator.objective by singleKeyedValue("Objective", StringLiteralCodec)
		 * ```
		 *
		 * @param serializationKey Either a regular string if it should be unquoted in the popfile (e.g. `Objective` instead of `"Objective"`) or a [PopFileLiteralString][btpos.tf2.popfiledsl.serialization.PopFileStringLiteral] if the key should be quoted in the popfile (e.g. `"mark for death"` instead of `mark for death`)
		 */
		fun <EXPOSED : Any, SERIALIZED : Any> addField(serializationKey: Any, codec: Codec<EXPOSED, SERIALIZED>) = object : ReadWriteProperty<IMvMSubtree, EXPOSED?> {
			// god I wish we could have inlined delegates. I hate having another object just sitting here for no reason just to not repeat code
			// at least this is a tiny DSL and not a full-scale application
			val innerDelegate = addField<SERIALIZED>(serializationKey)
			
			override fun getValue(thisRef: IMvMSubtree, property: KProperty<*>): EXPOSED? {
				return innerDelegate.getValue(thisRef, property)?.let { codec.read(it) }
			}
			
			override fun setValue(thisRef: IMvMSubtree, property: KProperty<*>, value: EXPOSED?) {
				innerDelegate.setValue(thisRef, property, value?.let { codec.write(it) })
			}
		}
		
		/**
		 * Extend a map with a field that can only exist a single time per struct.
		 *
		 * @param key The key this item will be serialized under.
		 */
		fun <T : Any> addField(key: Any, isRequired: Boolean = false, initialValue: (() -> T)? = null): ReadWriteProperty<IMvMSubtree, T?> {
			return object : ReadWriteProperty<IMvMSubtree, T?> {
				private fun getFromMap(thisRef: IMvMSubtree, prop: KProperty<*>): NamedValue<Any, T> {
					return thisRef._rawEntries.computeIfAbsent(prop) {
						NamedValue<Any, T>(isRequired, key)
					} as NamedValue<Any, T>
				}
				
				override fun getValue(thisRef: IMvMSubtree, property: KProperty<*>): T? {
					return getFromMap(thisRef, property).value
				}
				
				override fun setValue(thisRef: IMvMSubtree, property: KProperty<*>, value: T?) {
					getFromMap(thisRef, property).value = value
				}
			}
		}
		
		
		
		
		
		/**
		 * A struct that may only appear once in the subtree.
		 *
		 * Note that the only difference between a struct and a named map is that structs have their _own_ names.
		 * As such, there is no way to name these.
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [btpos.tf2.popfiledsl.types.spawners.Spawner] and its subclasses),
		 * use [addField] with a [PopFileMap][btpos.tf2.popfiledsl.serialization.PopFileMap]
		 * as its value to allow the parent scope to decide its name.
		 */
		fun <T : IPopFileSerializable<PopFileEntry>> singleStruct(isRequired: Boolean = false) = object : ReadWriteProperty<IMvMSubtree, T?> {
			private fun getFromMap(thisRef: IMvMSubtree, prop: KProperty<*>) = thisRef._rawEntries.computeIfAbsent(prop) {
				SelfNamedValue<T>(isRequired)
			} as SelfNamedValue<T>
			
			override fun getValue(thisRef: IMvMSubtree, property: KProperty<*>): T? {
				return getFromMap(thisRef, property).item
			}
			
			override fun setValue(thisRef: IMvMSubtree, property: KProperty<*>, value: T?) {
				getFromMap(thisRef, property).item = value
			}
		}
		
		/**
		 * A struct type that may have multiple instances in this subtree.
		 *
		 * For example:
		 * ```
		 * TFBot
		 * {
		 *  ...
		 * }
		 *
		 * TFBot
		 * {
		 *  ...
		 * }
		 * ```
		 */
		fun <T : IPopFileSerializable<PopFileEntry>> multiStruct(isRequired: Boolean = false): ReadOnlyProperty<IMvMSubtree, MutableList<T>> {
			return ReadOnlyProperty<IMvMSubtree, MutableList<T>> { thisRef, property ->
				thisRef._rawEntries.computeIfAbsent(property) {
					SelfNamedValueList<T>(isRequired)
				} as SelfNamedValueList<T>
			}
		}
		
		/**
		 * Gives full control of the subtree to this property before serializing, allowing it to serialize to something completely different than the natural nested-object structure, as well as possibly redefine other parts of the map.
		 *
		 * Used for complex behavior or easier-to-write constructs that don't directly mirror the resulting tree.
		 *
		 * @param isRequired If true, the user must set this property when creating the subtree.  If they don't, it displays an error message with the [displayName] showing them what property they forgot.
		 * @param displayName Not used for serialization, just shown to the user in an error message if this property was required but is not included.
		 *
		 */
		fun <T : Any> customHandler(isRequired: Boolean = false, displayName: String? = null, defaultValue: (() -> T)? = null, serializer: (currentMap: PopFileMap, thisValue: T) -> PopFileMap) : ReadWriteProperty<IMvMSubtree, T> {
			if (isRequired) {
				requireNotNull(displayName) { "Must provide a display name to required properties." }
			}
			
			return object : ReadWriteProperty<IMvMSubtree, T> {
				override fun getValue(thisRef: IMvMSubtree, property: KProperty<*>): T {
					return thisRef._customHandlers.computeIfAbsent(property) {
						CustomHandler(isRequired, displayName, serializer, defaultValue?.invoke())
					}.value as T
				}
				
				override fun setValue(thisRef: IMvMSubtree, property: KProperty<*>, value: T) {
					(thisRef._customHandlers.computeIfAbsent(property) {
						CustomHandler(isRequired, displayName, serializer, defaultValue?.invoke())
					} as CustomHandler<T>).value = value
				}
			}
		}
 	}
}

abstract class SubtreeEntry(val fieldName: String, val isRequired: Boolean) : IPopFileSerializable<List<PopFileEntry>> {
	final override val _popFileRepr: List<PopFileEntry>
		get() = _repr.also {
			if (isRequired && it.isEmpty()) {
				throw IllegalStateException("Missing required field: $fieldName")
			}
		}
	
	abstract val _repr: List<PopFileEntry>
}

// because we serialize all lists as Key Value1 Key Value2,
// properties that allow multiple values are fine to use a list as the entry
class NamedValue<K : Any, V : Any>(isRequired: Boolean, var key: K, var value: V? = null,)
	: SubtreeEntry(key.toString(), isRequired)
{
	override val _repr: List<PopFileEntry>
		get() = listOfNotNull(PopFileEntry.orNull(key, value))
}

class SelfNamedValue<T : IPopFileSerializable<PopFileEntry>>(isRequired: Boolean)
	: SubtreeEntry("subtree", isRequired)
{
	var item: T? = null
	
	override val _repr: List<PopFileEntry>
		get() = listOfNotNull(item?._popFileRepr)
}

/**
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them
 */
class SelfNamedValueList<T : IPopFileSerializable<PopFileEntry>>(isRequired: Boolean, val innerList: MutableList<T> = mutableListOf())
	: SubtreeEntry("subtrees", isRequired), MutableList<T> by innerList
{
	override val _repr: List<PopFileEntry>
		get() = innerList.map { it._popFileRepr }
}

class CustomHandler<T : Any>(val isRequired: Boolean, val displayName: String?, val serializer: (PopFileMap, T) -> PopFileMap, var value: T? = null) {
	
	fun transformMapForSerialization(currentMap: PopFileMap): PopFileMap {
		val value = value
		if (value == null) {
			if (isRequired && displayName != null)
				throw IllegalStateException("Missing required field: $displayName")
			return currentMap
		}
		
		return serializer(currentMap, value)
	}
}

/**
 * A nameless subtree
 */
interface IMvMSubtreeMap : IMvMSubtree, IPopFileSerializable<PopFileMap> {
	override val _popFileRepr: PopFileMap
		get() {
			try {
				return _customHandlers.values.fold(PopFileMap(_rawEntries.values.flatMap { it._popFileRepr })) { map, item: CustomHandler<*> ->
					item.transformMapForSerialization(map)
				}
			} catch (e: Exception) {
				throw RequiredFieldNotFoundException(_instantiationSite, e)
			}
		}
}

class MvMSubtreeImpl : IMvMSubtreeMap {
	override val _rawEntries: MutableMap<Any, IPopFileSerializable<Iterable<PopFileEntry>>> = mutableMapOf()
	
	override val _customHandlers: MutableMap<Any, CustomHandler<*>> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}

class RequiredFieldNotFoundException(val stacktrace: Array<StackTraceElement>, override val cause: Throwable?) : RuntimeException() {
	override val message: String
		get() = "Required field not found."
	
	override fun getStackTrace(): Array<StackTraceElement> {
		return stacktrace
	}
}