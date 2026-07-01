package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFSerializableKeyValue
import btpos.source.vdfdsl.serialization.IVDFSerializableValue
import btpos.source.vdfdsl.serialization.VDFSubtree
import btpos.source.vdfdsl.serialization.codecs.Codec
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Essentially a list of key-value pairs (e.g. "x, y") that can contain multiple keys as well as multiple values.
 *
 * This is fully extensible with new keys on the fly using the [factories][Companion].
 * See subclasses of [AbstractVDFStruct] for implementation.
 */
interface IExtensibleSubtree {
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
		 */
		fun <EXPOSED : Any, SERIALIZED : Any> addField(serializationKey: String, codec: Codec<EXPOSED, SERIALIZED>) = object : ReadWriteProperty<IExtensibleSubtree, EXPOSED?> {
			// god I wish we could have inlined delegates. I hate having another object just sitting here for no reason just to not repeat code
			// at least this is a tiny DSL and not a full-scale application
			val innerDelegate = addField<SERIALIZED>(serializationKey)
			
			override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): EXPOSED? {
				return innerDelegate.getValue(thisRef, property)?.let { codec.read(it) }
			}
			
			override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: EXPOSED?) {
				innerDelegate.setValue(thisRef, property, value?.let { codec.write(it) })
			}
		}
		
		/**
		 * Extend a map with a field that can only exist a single time per struct.
		 *
		 * @param key The key this item will be serialized under.
		 */
		fun <T : Any> addField(key: Any, isRequired: Boolean = false, initialValue: (() -> T)? = null): ReadWriteProperty<IExtensibleSubtree, T?> {
			return object : ReadWriteProperty<IExtensibleSubtree, T?> {
				private fun getFromMap(thisRef: IExtensibleSubtree, prop: KProperty<*>): NamedValue<Any, T> {
					return thisRef._rawEntries.computeIfAbsent(prop) {
						NamedValue<Any, T>(isRequired, key)
					} as NamedValue<Any, T>
				}
				
				override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): T? {
					return getFromMap(thisRef, property).value
				}
				
				override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: T?) {
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
		fun <T : IVDFSerializableKeyValue> singleStruct(isRequired: Boolean = false) = object : ReadWriteProperty<IExtensibleSubtree, T?> {
			private fun getFromMap(thisRef: IExtensibleSubtree, prop: KProperty<*>) = thisRef._rawEntries.computeIfAbsent(prop) {
				SelfNamedValue<T>(isRequired)
			} as SelfNamedValue<T>
			
			override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): T? {
				return getFromMap(thisRef, property).item
			}
			
			override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: T?) {
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
		fun <T : IVDFSerializableKeyValue> multiStruct(isRequired: Boolean = false): ReadOnlyProperty<IExtensibleSubtree, MutableList<T>> {
			return ReadOnlyProperty<IExtensibleSubtree, MutableList<T>> { thisRef, property ->
				thisRef._rawEntries.computeIfAbsent(property) {
					SelfNamedValueList<T>(isRequired)
				} as SelfNamedValueList<T>
			}
		}
 	}
}

/**
 * A nameless subtree
 */
interface IExtensibleSubtreeMap : IExtensibleSubtree, IVDFSerializableValue<VDFSubtree> {
	override val _vdfRepr: VDFSubtree
		get() {
			try {
				return _rawEntries.values.fold(VDFSubtree()) { map, value -> value._serialize(map) }
			} catch (e: Exception) {
				throw RequiredFieldNotFoundException(_instantiationSite, e)
			}
		}
}

class MvMSubtreeImpl : IExtensibleSubtreeMap {
	override val _rawEntries: MutableMap<Any, IVDFSerializableKeyValue> = mutableMapOf()
	
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}