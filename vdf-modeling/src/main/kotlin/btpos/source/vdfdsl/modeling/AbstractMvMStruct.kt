package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFSerializableValue
import btpos.source.vdfdsl.serialization.IVDFSerializableKeyValue
import btpos.source.vdfdsl.serialization.VDFKeyValue
import btpos.source.vdfdsl.serialization.VDFSubtree
import btpos.source.vdfdsl.serialization.codecs.Codec
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A structure in an MvM popfile, modeled as an extensible map that can contain multiple mappings for a single key.
 *
 * Structs resolve to a [VDFKeyValue] that is a pair of its _identifier_ and its _map_.
 *
 * Structs essentially only differ from normal "key: someMap" entries in that they have their own unchanging key that defines their type.
 */
abstract class AbstractMvMStruct(protected val _subtree: MvMSubtreeImpl = MvMSubtreeImpl()) : IVDFSerializableKeyValue, IMvMSubtree by _subtree {
	override fun _serialize(input: VDFSubtree): VDFSubtree = input.withEntry(VDFKeyValue(_popFileStructIdentifier, _subtree._vdfRepr))
	
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
	val _rawEntries: MutableMap<Any, IVDFSerializableKeyValue>
	
	/**
	 * Keep a stacktrace log of where the object was created,
	 * so we can throw it if a required field isn't set and it gives the line where it was set.
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
		 * @param serializationKey Either a regular string if it should be unquoted in the popfile (e.g. `Objective` instead of `"Objective"`) or a [PopFileLiteralString][btpos.source.vdfdsl.serialization.VDFStringLiteral] if the key should be quoted in the popfile (e.g. `"mark for death"` instead of `mark for death`)
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
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [btpos.source.vdfdsl.types.spawners.Spawner] and its subclasses),
		 * use [addField] with a [PopFileMap][btpos.source.vdfdsl.serialization.VDFSubtree]
		 * as its value to allow the parent scope to decide its name.
		 */
		fun <T : IVDFSerializableKeyValue> singleStruct(isRequired: Boolean = false) = object : ReadWriteProperty<IMvMSubtree, T?> {
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
		fun <T : IVDFSerializableKeyValue> multiStruct(isRequired: Boolean = false): ReadOnlyProperty<IMvMSubtree, MutableList<T>> {
			return ReadOnlyProperty<IMvMSubtree, MutableList<T>> { thisRef, property ->
				thisRef._rawEntries.computeIfAbsent(property) {
					SelfNamedValueList<T>(isRequired)
				} as SelfNamedValueList<T>
			}
		}
 	}
}

abstract class SubtreeEntry(val fieldName: String, val isRequired: Boolean) : IVDFSerializableKeyValue {
	protected fun throwIfRequired() {
		if (isRequired)
			error("Missing required field: $fieldName")
	}
}

// because we serialize all lists as Key Value1 Key Value2,
// properties that allow multiple values are fine to use a list as the entry
class NamedValue<K : Any, V : Any>(isRequired: Boolean, var key: K, var value: V? = null,)
	: SubtreeEntry(key.toString(), isRequired)
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		val value = value ?: run {
			throwIfRequired()
			return input;
		}
		
		return input + VDFKeyValue(key, value)
	}
}

class SelfNamedValue<T : IVDFSerializableKeyValue>(isRequired: Boolean)
	: SubtreeEntry("subtree", isRequired)
{
	var item: T? = null
	
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		return item?._serialize(input) ?: run {
			throwIfRequired()
			input
		}
	}
}

/**
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them
 */
class SelfNamedValueList<T : IVDFSerializableKeyValue>(isRequired: Boolean, val innerList: MutableList<T> = mutableListOf())
	: SubtreeEntry("subtrees", isRequired), MutableList<T> by innerList
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		if (innerList.isEmpty())
			throwIfRequired()
		
		return innerList.fold(input) { input, value -> value._serialize(input) }
	}
}

/**
 * A nameless subtree
 */
interface IMvMSubtreeMap : IMvMSubtree, IVDFSerializableValue<VDFSubtree> {
	override val _vdfRepr: VDFSubtree
		get() {
			try {
				return _rawEntries.values.fold(VDFSubtree()) { map, value -> value._serialize(map) }
			} catch (e: Exception) {
				throw RequiredFieldNotFoundException(_instantiationSite, e)
			}
		}
}

class MvMSubtreeImpl : IMvMSubtreeMap {
	override val _rawEntries: MutableMap<Any, IVDFSerializableKeyValue> = mutableMapOf()
	
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}

class RequiredFieldNotFoundException(val originalDeclarationSiteTrace: Array<StackTraceElement>, override val cause: Throwable?) : RuntimeException() {
	override val message: String
		get() = "Required field not found."
	
	override fun getStackTrace(): Array<StackTraceElement> {
		return originalDeclarationSiteTrace
	}
}