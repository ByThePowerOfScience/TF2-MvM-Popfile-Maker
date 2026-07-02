package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.backing.VDFSubtree
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
interface IExtensibleSubtree : IVDFRepresentableValue<VDFSubtree> {
	/**
	 * A bunch of raw items, keyed by whatever arbitrary value is used to retrieve them for user use.
	 *
	 * All keys will be ignored when serializing the entries to a popfile. Values are expected to provide their own keys.
	 */
	val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue>
	
	/**
	 * Keep a stacktrace log of where the object was created,
	 * so we can throw it if a required field isn't set and it gives the line where it was set.
	 */
	val _instantiationSite: Array<StackTraceElement>
	
	@Suppress("UNCHECKED_CAST")
	companion object {
		/**
		 * Extend a struct with a field that can only be in that subtree once.
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
		inline fun <EXPOSED : Any, reified SERIALIZED : Any> addField(serializationKey: String, codec: Codec<EXPOSED, SERIALIZED>, isRequired: Boolean = false): ReadWriteProperty<IExtensibleSubtree, EXPOSED?> {
			return addField_codec(serializationKey, codec, isRequired, SERIALIZED::class.java)
		}
		
		
		@PublishedApi
		internal fun <EXPOSED : Any, SERIALIZED : Any> addField_codec(serializationKey: String, codec: Codec<EXPOSED, SERIALIZED>, isRequired: Boolean, serializedClass: Class<SERIALIZED>): ReadWriteProperty<IExtensibleSubtree, EXPOSED?> {
			IVDFRepresentableValue.requireValueRepresentable(serializedClass)
			
			return object : ReadWriteProperty<IExtensibleSubtree, EXPOSED?> {
				val innerDelegate = addField_noCodec(serializationKey, isRequired, serializedClass, null)
				
				override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): EXPOSED? {
					return innerDelegate.getValue(thisRef, property)
						?.let { codec.read(it) }
				}
				
				override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: EXPOSED?) {
					innerDelegate.setValue(thisRef, property, value?.let { codec.write(it) })
				}
			}
		}
		
		/**
		 * Extend a subtree with a field that can only exist a single time per subtree.
		 *
		 * @param key The key this item will be serialized under.
		 * @param isRequired If true, serialization throws an error if this value is not set.
		 */
		inline fun <reified V : Any> addField(key: String, isRequired: Boolean = false, noinline initialValue: ((key: String) -> V)? = null): ReadWriteProperty<IExtensibleSubtree, V?> {
			return addField_noCodec(key, isRequired, V::class.java, initialValue)
		}
		
		@PublishedApi
		internal fun <V : Any> addField_noCodec(key: String, isRequired: Boolean, valueClass: Class<V>, initialValue: ((String) -> V)?): ReadWriteProperty<IExtensibleSubtree, V?> {
			require(!(valueClass.isAssignableFrom(Collection::class.java) && !valueClass.isAssignableFrom(IVDFRepresentableKeyValue::class.java))) {
				"Raw lists may not be used as values.\nSince lists do not exist in VDFs, there are many different ways of representing them. Use a type that properly serializes, such as VDFList_Flat or VDFList_Map."
			}
			
			IVDFRepresentableValue.requireValueRepresentable(valueClass)
			
			return object : ReadWriteProperty<IExtensibleSubtree, V?> {
				private fun getFromMap(thisRef: IExtensibleSubtree, prop: KProperty<*>): NamedValue<V> {
					return thisRef._rawEntries.computeIfAbsent(prop) {
						NamedValue<V>(isRequired, key, initialValue?.invoke(key))
					} as NamedValue<V>
				}
				
				override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): V? {
					return getFromMap(thisRef, property).value
				}
				
				override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: V?) {
					getFromMap(thisRef, property).value = value
				}
			}
		}
		
		
		/**
		 * A struct that may only appear once in the subtree.
		 *
		 * Note that the only difference between a struct and a named subtree is that structs have their _own_ names.
		 * As such, there is no way to name these.
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [btpos.source.vdfdsl.types.spawners.Spawner] and its subclasses),
		 * use [addField] with a [VDFSubtree] as its value to allow the parent scope to decide its name.
		 *
		 * @param isRequired If true, throws an error if this value is not set when serializing.
		 */
		fun <T : IVDFRepresentableKeyValue> singleStruct(isRequired: Boolean = false) = object : ReadWriteProperty<IExtensibleSubtree, T?> {
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
		 *
		 * @param isRequired If true, throws an error if this value is not set when serializing.
		 */
		fun <T : IVDFRepresentableKeyValue> multiStruct(isRequired: Boolean = false): ReadOnlyProperty<IExtensibleSubtree, MutableList<T>> {
			return ReadOnlyProperty<IExtensibleSubtree, MutableList<T>> { thisRef, property ->
				thisRef._rawEntries.computeIfAbsent(property) {
					SelfNamedValueList<T>(isRequired)
				} as SelfNamedValueList<T>
			}
		}
 	}
	
	override val _vdfRepr: VDFSubtree
		get() {
			try {
				return _rawEntries.values.fold(VDFSubtree()) { map, value -> value._serialize(map) }
			} catch (e: Exception) {
				throw RequiredFieldNotFoundException(_instantiationSite, e)
			}
		}
}

class ExtensibleSubtreeImpl : IExtensibleSubtree {
	override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}