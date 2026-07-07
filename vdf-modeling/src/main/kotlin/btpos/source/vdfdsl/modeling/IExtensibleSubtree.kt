@file:Suppress("unused")

package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
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
	val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue>
	
	/**
	 * Keep a stacktrace log of where the object was created,
	 * so we can throw it if a required field isn't set and it gives the line where it was set.
	 */
	val _instantiationSite: Array<StackTraceElement>
	
	/**
	 * Create a deep copy of this subtree.
	 *
	 * Implementers of this interface should always override this method to return their own type.  I wish there were a way to do this with generics.
	 */
	fun copy(): IExtensibleSubtree
	
	/**
	 * Serializes to multiple versions of the same key in the same subtree, like this:
	 *
	 * ```
	 * // given [foo, bar]:
	 * Item foo
	 * Item bar
	 * ```
	 */
	object Serializers {
		inline fun <reified T : Any> flatListWithKey(key: String): ((Iterable<T>) -> IVDFRepresentableKeyValue) {
			IVDFRepresentableValue.requireValueRepresentable(T::class.java)
			return _flatListWithKey(key.intern())
		}
		
		@PublishedApi internal fun <T : Any> _flatListWithKey(key: String) = { iterable: Iterable<T> ->
			IVDFRepresentableKeyValue { input: VDFSubtree ->
				val prim = VDFPrimitive(key)
				input.withEntries(iterable.map { VDFKeyValue(prim, IVDFRepresentableValue.serializeDynamic(it)) })
			}
		}
		
		/**
		 * A list represented as a subtree, with the keys being the items in the list and its values being ignored. (usually `"1"`)
		 *
		 * ```
		 * // given [item1, item2, item3]:
		 * "my_items"
		 * {
		 *   "item1" "1"
		 *   "item2" "1"
		 *   "item3" "1"
		 * }
		 */
		inline fun <reified T : Any> listAsMap(dummyValue: String? = null): (String) -> ((Iterable<T>) -> IVDFRepresentableValue<VDFSubtree>) {
			IVDFRepresentableValue.requireValueRepresentable(T::class.java)
			return { _ -> _listAsMap(dummyValue?.let { VDFPrimitive(it) } ?: VDFPrimitive.TRUE) }
		}
		
		@PublishedApi internal fun <T : Any> _listAsMap(dummyValue: VDFPrimitive): (Iterable<T>) -> IVDFRepresentableValue<VDFSubtree> {
			return { iterable ->
				object : IVDFRepresentableValue<VDFSubtree> {
					override val _vdfRepr: VDFSubtree
						get() = VDFSubtree(iterable.map { VDFKeyValue(VDFPrimitive(it), dummyValue) })
				}
			}
		}
		
		fun <T : Any, U : Any> notNull(getter: (T) -> U?): (T) -> U {
			return { it: T ->
				getter(it) ?: error("Expected $getter to return not null.")
			}
		}
	}
	
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
		 * var MissionPopulator.objective by addField("Objective", StringLiteralCodec)
		 * ```
		 */
		inline fun <T : Any, reified S : Any> addField(serializationKey: String, noinline serializer: ((T) -> S), isRequired: Boolean = false): ReadWriteProperty<IExtensibleSubtree, T?> {
			return addField_serializer(serializationKey, serializer, null, isRequired, S::class.java)
		}
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
		 * var MissionPopulator.objective by addField("Objective", StringLiteralCodec)
		 * ```
		 */
		inline fun <T : Any, reified S : Any> addField(serializationKey: String, noinline serializer: ((T) -> S), isRequired: Boolean = false, noinline initialValue: () -> T): ReadWriteProperty<IExtensibleSubtree, T> {
			@Suppress("UNCHECKED_CAST")
			return addField_serializer(serializationKey, serializer, initialValue, isRequired, S::class.java) as ReadWriteProperty<IExtensibleSubtree, T>
		}
		
		@PublishedApi internal fun <T : Any, S : Any> addField_serializer(serializationKey: String, serializer: (T) -> S, initialValue: (() -> T)?, isRequired: Boolean, serClass: Class<S>): ReadWriteProperty<IExtensibleSubtree, T?> {
			require(IVDFRepresentableValue.isValueRepresentable(serClass) || IVDFRepresentableKeyValue.isKeyValueRepresentable(serClass)) {
				"Post-serialized type ${serClass.simpleName} is neither a valid value or keyvalue."
			}
			
			val serializationKey = serializationKey.intern()
			
			return object : ReadWriteProperty<IExtensibleSubtree, T?> {
				private fun getFromMap(thisRef: IExtensibleSubtree, prop: KProperty<*>): NamedValue<T> {
					@Suppress("UNCHECKED_CAST")
					return thisRef._rawEntries.computeIfAbsent(prop) {
						NamedValue(isRequired, serializationKey, initialValue?.invoke(), serializer)
					} as NamedValue<T>
				}
				
				override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): T? {
					return getFromMap(thisRef, property).value
				}
				
				override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: T?) {
					getFromMap(thisRef, property).value = value.let {
						if (it is String)
							it.intern() as T
						else
							it
					}
				}
			}
		}
		
		/**
		 * Extend a subtree with a field that can only exist a single time per subtree.
		 *
		 * This method may only be used with natively-serializable values, i.e. numbers, booleans, strings, [VDFObjects][btpos.source.vdfdsl.backing.VDFObject], or objects that implement either [IVDFRepresentableValue] or [IVDFRepresentableKeyValue].
		 *
		 * @param key The key this item will be serialized under.
		 * @param isRequired If true, serialization throws an error if this value is not set.
		 */
		inline fun <reified T : Any, reified SUB : T> addField(key: String, isRequired: Boolean = false): ReadWriteProperty<IExtensibleSubtree, T?> {
			return addField_noSerializer(key, isRequired, SUB::class.java, null)
		}
		
		/**
		 * Extend a subtree with a field that can only exist a single time per subtree.
		 *
		 * This method may only be used with natively-serializable values, i.e. numbers, booleans, strings, [VDFObjects][btpos.source.vdfdsl.backing.VDFObject], or objects that implement either [IVDFRepresentableValue] or [IVDFRepresentableKeyValue].
		 *
		 * @param key The key this item will be serialized under.
		 * @param isRequired If true, serialization throws an error if this value is not set.
		 * @param initialValue Value that should be set before any setting takes place.  This is only called after the first "set", so it does not automatically make this value non-null in the serialized form if nothing ever uses this property.
		 */
		inline fun <reified T : Any, reified SUB : T> addField(key: String, isRequired: Boolean = false, noinline initialValue: (key: String) -> SUB): ReadWriteProperty<IExtensibleSubtree, T> {
			@Suppress("UNCHECKED_CAST")
			return addField_noSerializer(key, isRequired, SUB::class.java, initialValue) as ReadWriteProperty<IExtensibleSubtree, T>
		}
		
		@PublishedApi internal fun <T : Any, V : T> addField_noSerializer(key: String, isRequired: Boolean, subclass: Class<V>, initialValue: ((String) -> V)?): ReadWriteProperty<IExtensibleSubtree, T?> {
			require(IVDFRepresentableValue.isValueRepresentable(subclass) || IVDFRepresentableKeyValue.isKeyValueRepresentable(subclass)) {
				"${subclass.simpleName} is not natively serializable to a VDF.\n" +
				"Callers must provide a serializer if the value is not a string, number, boolean, VDFObject, or does not implement IVDFRepresentableKeyValue or IVDFRepresentableValue.\n"
			}
			
			val key = key.intern()
			
			return object : ReadWriteProperty<IExtensibleSubtree, T?> {
				private fun getFromMap(thisRef: IExtensibleSubtree, prop: KProperty<*>): NamedValue<T> {
					@Suppress("UNCHECKED_CAST")
					return thisRef._rawEntries.computeIfAbsent(prop) {
						NamedValue<T>(isRequired, key, initialValue?.invoke(key), null)
					} as NamedValue<T>
				}
				
				override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): T? {
					return getFromMap(thisRef, property).value
				}
				
				override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: T?) {
					getFromMap(thisRef, property).value = value.let {
						if (it is String)
							it.intern() as T
						else
							it
					}
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
			@Suppress("UNCHECKED_CAST")
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
			@Suppress("UNCHECKED_CAST")
			return ReadOnlyProperty<IExtensibleSubtree, MutableList<T>> { thisRef, property ->
				thisRef._rawEntries.computeIfAbsent(property) {
					SelfNamedValueList<T>(isRequired)
				} as SelfNamedValueList<T>
			}
		}
 	}
}

interface IExtensibleSubtree_VDFRepresentable : IExtensibleSubtree, IVDFRepresentableValue<VDFSubtree> {
	override fun copy(): IExtensibleSubtree_VDFRepresentable
}


/**
 * Just a subtree. See [AbstractVDFStruct] for a subtree with its own name.
 */
open class ExtensibleSubtreeImpl(
	override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf(),
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
) : IExtensibleSubtree_VDFRepresentable {
	override val _vdfRepr: VDFSubtree
		get() {
			try {
				return _rawEntries.values.fold(VDFSubtree()) { map, value -> value._serialize(map) }
			} catch (e: Exception) {
				throw RequiredFieldNotFoundException(_instantiationSite, e)
			}
		}
	
	protected fun copyEntries() = _rawEntries.toMutableMap()
	
	override fun copy() = ExtensibleSubtreeImpl(copyEntries())
}

/**
 * Create a copy of this struct and configure it. Alias for `copy().apply { ... }`
 *
 * @return the copy with the configuration scope applied.
 */
inline operator fun <reified T : IExtensibleSubtree> T.invoke(configure: T.() -> Unit): T {
	return (this.copy() as? T)?.apply(configure) ?: error("Class ${T::class.java.simpleName} does not implement `IExtensibleSubtree#copy()` correctly. Implementers should always override this method to return their own type.")
}