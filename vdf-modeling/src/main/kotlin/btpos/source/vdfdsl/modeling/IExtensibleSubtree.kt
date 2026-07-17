@file:Suppress("unused")

package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import kotlin.jvm.java
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlin.time.Duration
import kotlin.time.DurationUnit

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
		typealias Serializer<T> = (T) -> IVDFRepresentableValue
		
		/**
		 * Transform the input before [this] serializer reaches it.
		 */
		fun <T, U> Serializer<U>.compose(transformer: (T) -> U): Serializer<T> {
			return { it: T ->
				this(transformer(it))
			}
		}
		
		fun durationInSeconds(): Serializer<Duration> = { it: Duration ->
			IVDFRepresentableValue_Trivial {
				VDFPrimitive(it.toDouble(DurationUnit.SECONDS))
			}
		}
		
		inline fun <reified T : Any> flatListWithKey(): Serializer<Iterable<T>> {
			IVDFRepresentableValue.requireValueRepresentable(T::class.java)
			return _flatListWithKey()
		}
		
		@PublishedApi
		internal fun <T : Any> _flatListWithKey(): Serializer<Iterable<T>> = { iterable: Iterable<T> ->
			IVDFRepresentableValue { key, conditional ->
				IVDFRepresentableKeyValue { input: VDFSubtree ->
					iterable.forEach {
						IVDFRepresentableValue.serializeDynamic(key, it, conditional)
							._serializeInto(input)
					}
				}
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
		inline fun <reified T : Any> listAsMap(dummyValue: String? = null): Serializer<Iterable<T>> {
			VDFPrimitive.requirePrimitive(T::class.java)
			return _listAsMap(dummyValue?.let { VDFPrimitive(it) } ?: VDFPrimitive.TRUE)
		}
		
		@PublishedApi
		internal fun <T : Any> _listAsMap(dummyValue: VDFPrimitive): Serializer<Iterable<T>> {
			return { iterable ->
				IVDFRepresentableValue { key, conditional ->
					IVDFRepresentableKeyValue { parent ->
						parent += VDFKeyValue(
							key,
							VDFSubtree(parent).apply {
								iterable.forEach {
									this += VDFKeyValue(VDFPrimitive(it), dummyValue, null)
								}
							},
							conditional
						)
						
					}
				}
			}
		}
	}
	
	companion object {
		/**
		 * Extend a struct with a field that can only be in that subtree once. VALUES MUST BE **IMMUTABLE** FOR DEEP COPYING TO WORK CORRECTLY. (i.e. don't use `MutableList`, use `List`.)
		 *
		 * This version of the method allows you to specify a serializer, which allows the user to input one thing and then it serializes another.
		 *
		 * ## Example:
		 * ```kotlin
		 * var MyThing.destination: Coord3D? by addField("Destination", serializer={ "$x $y $z" }) // turns Coord3D(x=1, y=2, z=3) into the string "1 2 3"
		 * ```
		 */
		@JvmName("addFieldSerializer")
		inline fun <T : Any, reified S : Any> addField(serializationKey: String, conditional: String? = null, noinline serializer: (T.() -> S?)): ReadWriteProperty<IExtensibleSubtree, T?> {
			return addField_serializer(serializationKey, conditional, serializer, null, S::class.java)
		}
		
		/**
		 * Extend a struct with a field that can only be in that subtree once.  VALUES MUST BE **IMMUTABLE** FOR DEEP COPYING TO WORK CORRECTLY. (i.e. don't use `MutableList`, use `List`.)
		 *
		 * This version of the method allows you to specify a serializer, which allows the user to input one thing and then it serializes another.
		 *
		 * ## Example:
		 * ```kotlin
		 * var TFBot.items: List<Item> by addField("Item", IExtensibleSubtree.Serializers.flatListWithKey()) { listOf() }
		 * //                                    key ^  |   ^ serializes each item in the subtree as `Item <it>` |   ^ a default value so you can use `+=` without a "null" warning
		 * ```
		 *
		 * @param serializationKey The key this value should have in the VDF.
		 * @param serializer A function or lambda that transforms the value of type `T` into something serializable with type `S`.
		 * @param initialValue An initial value for this property so it will not be null when retrieving it. (Only created when the property is first accessed.)
		 * @param T The actual type of the item the user can put in this property.
		 * @param S Some [serializable type][IVDFRepresentableValue.serializeDynamic].
		 */
		inline fun <T : Any, reified S : Any> addField(serializationKey: String, noinline serializer: T.() -> S?, conditional: String? = null, noinline initialValue: () -> T): ReadWriteProperty<IExtensibleSubtree, T> {
			@Suppress("UNCHECKED_CAST")
			return addField_serializer(serializationKey, conditional, serializer, initialValue, S::class.java) as ReadWriteProperty<IExtensibleSubtree, T>
		}
		
		@PublishedApi
		internal fun <T : Any, S : Any> addField_serializer(serializationKey: String, conditional: String?, serializer: (T) -> S?, initialValue: (() -> T)?, serClass: Class<S>): ReadWriteProperty<IExtensibleSubtree, T?> {
			require(IVDFRepresentableValue.isValueRepresentable(serClass) || IVDFRepresentableKeyValue.isKeyValueRepresentable(serClass)) {
				"Post-serialized type ${serClass.simpleName} is neither a valid value or keyvalue."
			}
			
			return RegularFieldProperty(serializationKey.intern(), initialValue, conditional, serializer)
		}
		
		private class RegularFieldProperty<T : Any>(val key: String, val initialValue: (() -> T)?, val conditional: String?, val serializer: ((T) -> Any?)?) : ReadWriteProperty<IExtensibleSubtree, T?> {
			override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): T? {
				@Suppress("UNCHECKED_CAST")
				return (thisRef._rawEntries[property] as NamedValue<T>?)?.value ?: initialValue?.invoke()
			}
			
			override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: T?) {
				if (value == null) {
					thisRef._rawEntries.remove(property)
					return;
				}
				@Suppress("UNCHECKED_CAST")
				thisRef._rawEntries[property] = NamedValue(key, ((value as? String)?.intern() ?: value) as T, conditional, serializer)
			}
		}
		
		/**
		 * Extend a subtree with a field that can only exist a single time per subtree.
		 *
		 * This method may only be used with natively-serializable values, i.e. numbers, booleans, strings, [VDFObjects][btpos.source.vdfdsl.backing.VDFObject], or objects that implement either [IVDFRepresentableValue_Trivial] or [IVDFRepresentableKeyValue].
		 *
		 * @param key The key this item will be serialized under.
		 */
		inline fun <reified T : Any> addField(key: String, conditional: String? = null): ReadWriteProperty<IExtensibleSubtree, T?> {
			return addField_noSerializer(key, T::class.java, conditional, null)
		}
		
		/**
		 * Extend a subtree with a field that can only exist a single time per subtree.
		 *
		 * This method may only be used with natively-serializable values, i.e. numbers, booleans, strings, [VDFObjects][btpos.source.vdfdsl.backing.VDFObject], or objects that implement either [IVDFRepresentableValue_Trivial] or [IVDFRepresentableKeyValue].
		 *
		 * @param key The key this item will be serialized under.
		 * @param initialValue Value that should be set before any setting takes place.  This is only called after the first "set", so it does not automatically make this value non-null in the serialized form if nothing ever uses this property.
		 */
		inline fun <reified T : Any> addField(key: String, conditional: String? = null, noinline initialValue: () -> T): ReadWriteProperty<IExtensibleSubtree, T> {
			@Suppress("UNCHECKED_CAST")
			return addField_noSerializer(key, T::class.java, conditional, initialValue) as ReadWriteProperty<IExtensibleSubtree, T>
		}
		
		@PublishedApi
		internal fun <T : Any> addField_noSerializer(key: String, subclass: Class<T>, conditional: String?, initialValue: (() -> T)?): ReadWriteProperty<IExtensibleSubtree, T?> {
			require(!IVDFRepresentableKeyValue.isKeyValueRepresentable(subclass)) {
				"Cannot give an IVDFRepresentableKeyValue a key, as it determines its own key.  This is likely an error.  Use the `selfNamed()` provider to declare this field."
			}
			
			require(IVDFRepresentableValue.isValueRepresentable(subclass)) {
				"${subclass.simpleName} is not natively serializable to a VDF.\n" +
				"Callers must provide a serializer if the value is not a string, number, boolean, VDFObject, or does not implement IVDFRepresentableValue.\n"
			}
			
			return RegularFieldProperty(key, initialValue, conditional, null)
		}
		
		
		/**
		 * A struct that may only appear once in the subtree.
		 *
		 * Note that the only difference between a struct and a named subtree is that structs have their _own_ names.
		 * As such, there is no way to name these.
		 *
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [AbstractVDFStruct] and its subclasses),
		 * use [addField] with an [IVDFRepresentableValue_Subtree][btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree] as its value to allow the parent scope to decide its name.
		 *
		 * @param transformer Something to postprocess the value in some way before its representation is pulled, like giving it a conditional.
		 */
		fun <T : IVDFRepresentableKeyValue> selfNamed(transformer: (T) -> IVDFRepresentableKeyValue = { it }) = object : ReadWriteProperty<IExtensibleSubtree, T?> {
			@Suppress("UNCHECKED_CAST")
			private fun getFromMap(thisRef: IExtensibleSubtree, prop: KProperty<*>) = thisRef._rawEntries[prop] as SelfNamedValue<T>?
			
			override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): T? {
				return getFromMap(thisRef, property)?.item
			}
			
			override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: T?) {
				if (value == null)
					thisRef._rawEntries.remove(property)
				else
					thisRef._rawEntries[property] = SelfNamedValue(value, transformer)
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
		 */
		fun <T : IVDFRepresentableKeyValue> selfNamedList(transformer: (T) -> IVDFRepresentableKeyValue = { it }): ReadWriteProperty<IExtensibleSubtree, List<T>> {
			@Suppress("UNCHECKED_CAST")
			return object : ReadWriteProperty<IExtensibleSubtree, List<T>> {
				override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): List<T> {
					return (thisRef._rawEntries[property] as SelfNamedValueList<T>?)?.innerList ?: emptyList()
				}
				
				override fun setValue(thisRef: IExtensibleSubtree, property: KProperty<*>, value: List<T>) {
					thisRef._rawEntries[property] = SelfNamedValueList(value, transformer)
				}
			}
		}
	}
}

interface IExtensibleSubtree_VDFRepresentable : IExtensibleSubtree, IVDFRepresentableValue {
	override fun copy(): IExtensibleSubtree_VDFRepresentable
}


/**
 * Just a subtree. See [AbstractVDFStruct] for a subtree with its own name.
 */
open class ExtensibleSubtreeImpl(
	override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf(),
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
) : IExtensibleSubtree_VDFRepresentable {
	override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return { parent ->
			try {
				val ourSub = VDFSubtree(parent)
				_rawEntries.values.forEach { it._serializeInto(ourSub) }
				parent += VDFKeyValue(key, ourSub, conditional)
			} catch (e: Exception) {
				throw RequiredFieldNotFoundException(_instantiationSite, e)
			}
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
	return (this.copy() as? T)?.apply(configure)
	       ?: error("Class ${T::class.java.simpleName} does not implement `IExtensibleSubtree#copy()` correctly. Implementers should always override this method to return their own type.")
}