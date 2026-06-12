package btpos.tf2.popfiledsl.modeling

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileMap
import btpos.tf2.popfiledsl.serialization.codecs.Codec
import jdk.internal.org.jline.keymap.KeyMap.key
import java.util.function.IntFunction
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
abstract class AbstractMvMStruct(private val subtree: MvMSubtreeImpl = MvMSubtreeImpl()) : IPopFileSerializable<PopFileEntry>, IMvMSubtree by subtree {
	final override val popFileRepr: PopFileEntry
		get() = PopFileEntry(popFileStructIdentifier, subtree.popFileRepr)
	
	abstract val popFileStructIdentifier: Any
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
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [btpos.tf2.popfiledsl.types.spawners.BaseSpawner] and its subclasses),
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
	}
}

abstract class SubtreeEntry(val fieldName: String, val isRequired: Boolean) : IPopFileSerializable<List<PopFileEntry>> {
	final override val popFileRepr: List<PopFileEntry>
		get() = repr.also {
			if (isRequired && it.isEmpty()) {
				throw IllegalStateException("Missing required field: $fieldName")
			}
		}
	
	abstract val repr: List<PopFileEntry>
}

// because we serialize all lists as Key Value1 Key Value2,
// properties that allow multiple values are fine to use a list as the entry
class NamedValue<K : Any, V : Any>(isRequired: Boolean, var key: K, var value: V? = null,)
	: SubtreeEntry(key.toString(), isRequired)
{
	override val repr: List<PopFileEntry>
		get() = listOfNotNull(PopFileEntry.orNull(key, value))
}

class SelfNamedValue<T : IPopFileSerializable<PopFileEntry>>(isRequired: Boolean)
	: SubtreeEntry("subtree", isRequired)
{
	var item: T? = null
	
	override val repr: List<PopFileEntry>
		get() = listOfNotNull(item?.popFileRepr)
}

/**
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them
 */
class SelfNamedValueList<T : IPopFileSerializable<PopFileEntry>>(isRequired: Boolean, val innerList: MutableList<T> = mutableListOf())
	: SubtreeEntry("subtrees", isRequired), MutableList<T> by innerList
{
	override val repr: List<PopFileEntry>
		get() = innerList.map { it.popFileRepr }
}

/**
 * A nameless subtree
 */
interface IMvMSubtreeMap : IMvMSubtree, IPopFileSerializable<PopFileMap> {
	override val popFileRepr: PopFileMap
		get() {
			try {
				return PopFileMap(_rawEntries.values.flatMap { it.popFileRepr })
			} catch (e: Exception) {
				throw RequiredFieldNotFoundException(_instantiationSite, e)
			}
		}
}

class MvMSubtreeImpl : IMvMSubtreeMap {
	override val _rawEntries: MutableMap<Any, IPopFileSerializable<Iterable<PopFileEntry>>> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}

class RequiredFieldNotFoundException(val stacktrace: Array<StackTraceElement>, override val cause: Throwable?) : RuntimeException() {
	override val message: String
		get() = "Required field not found."
	
	override fun getStackTrace(): Array<StackTraceElement> {
		return stacktrace
	}
}