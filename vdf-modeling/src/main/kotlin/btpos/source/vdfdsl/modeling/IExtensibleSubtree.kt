@file:Suppress("unused")
@file:OptIn(ExperimentalTypeInference::class)

package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.codegen.Codegen.IS_DOING_CODEGEN
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.CodegenException
import btpos.source.vdfdsl.codegen.Decoders
import btpos.misc.kt.codegen.KtStatement
import btpos.source.vdfdsl.codegen.ExtensibleSubtreeDecoder
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.misc.kt.codegen.statements.KtAssignment
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtGetValueExpression
import btpos.misc.kt.codegen.expressions.KtLambda
import btpos.misc.kt.codegen.identifiers.KtMemberReference
import btpos.misc.kt.codegen.expressions.KtThis
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.util.ReflectionUtils.fqName
import btpos.misc.kt.codegen.util.ReflectionUtils.isExtension
import btpos.source.vdfdsl.backing.VDFValue
import btpos.source.vdfdsl.codegen.SelfNamedDecoder
import btpos.source.vdfdsl.codegen.WeirdMutableIterableSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.serialization.plusAssign
import btpos.source.vdfdsl.util.ClassHierarchyGraph
import btpos.source.vdfdsl.util.SupportsCustomAssignment
import btpos.source.vdfdsl.util.forEachWithIter
import kotlin.collections.forEach
import kotlin.collections.map
import kotlin.error
import kotlin.experimental.ExperimentalTypeInference
import kotlin.jvm.java
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.extensionReceiverParameter
import kotlin.reflect.full.isSubclassOf
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
	 * @param T the type of the data being stored under this key in the subtree's [DataStorage]
	 */
	interface IDataKey<T : Any>
	
	@JvmRecord
	data class FieldKey<T : Any>(val field: ExtField<*>, val conditional: String?) : IDataKey<T>
	
	/**
	 * Used for user-defined keys that take a trivial value, like `"custom jump height modifier" "4"`
	 */
	@JvmRecord
	data class PrimitiveKey<T : Any>(val key: VDFPrimitive, val conditional: String? = null) : IDataKey<T>
	
	@JvmRecord
	data class PropertyKey<T : Any>(val prop: KProperty<*>) : IDataKey<T>
	
	
	interface DataStorage<D : Any> {
		operator fun <T : D> get(key: IDataKey<T>): T?
		
		operator fun <T : D> set(key: IDataKey<T>, data: T)
		
		fun <T : D> remove(key: IDataKey<T>)
		
		fun removeIf(predicate: (IDataKey<*>) -> Boolean)
		
		fun copy(): DataStorage<D>
		
		fun entries(): Iterable<Pair<IDataKey<*>, D>>
		
		fun <T : D> computeIfAbsent(key: IDataKey<T>, initializer: () -> T): T {
			return get(key) ?: initializer().also {
				set(key, it)
			}
		}
	}
	
	val _dataStorage: DataStorageVDFRepresentable
	
	open class DataStorageImpl : DataStorageVDFRepresentable {
		protected val backingMap = LinkedHashMap<IDataKey<out IVDFRepresentableKeyValue>, IVDFRepresentableKeyValue>()
		
		override fun <T : IVDFRepresentableKeyValue> get(key: IDataKey<T>): T? {
			@Suppress("UNCHECKED_CAST")
			return backingMap[key] as T?
		}
		
		override fun <T : IVDFRepresentableKeyValue> set(key: IDataKey<T>, data: T) {
			backingMap[key] = data
		}
		
		override fun <T : IVDFRepresentableKeyValue> remove(key: IDataKey<T>) {
			backingMap.remove(key)
		}
		
		override fun removeIf(predicate: (IDataKey<*>) -> Boolean) {
			backingMap.entries.forEachWithIter {
				if (predicate(it.key)) {
					remove()
				}
			}
		}
		
		override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
			this.backingMap.values.forEach {
				it._serializeInto(input, null)
			}
		}
		
		override fun copy(): DataStorageImpl = DataStorageImpl().also {
			this.backingMap.forEach { (k, v) ->
				it.backingMap[k] = v
			}
		}
		
		override fun entries(): Iterable<Pair<IDataKey<*>, IVDFRepresentableKeyValue>> {
			return backingMap.entries.asSequence().map { it.key to it.value }.asIterable()
		}
	}
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
		
		fun <T : Any> string(toString: (T) -> String): Serializer<T> {
			return {
				VDFPrimitive(toString(it))
			}
		}
		
		fun <T, U : Any> map(mapper: (T) -> U, then: Serializer<U> = IVDFRepresentableValue::serializeDynamic): Serializer<T> {
			return {
				then(mapper(it))
			}
		}
		
		fun <T, U> mapEach(mapper: (T) -> U, then: Serializer<Iterable<U>>): Serializer<Iterable<T>> {
			return {
				then(it.asSequence().map(mapper).asIterable())
			}
		}
		
		fun <T : Any, U : Any> mapEachCond(mapper: (T) -> U, then: Serializer<Iterable<ConditionalValue<U>>>): Serializer<Iterable<ConditionalValue<T>>> {
			return {
				then(it.asSequence().map { ConditionalValue(mapper(it.value), it.conditional) }.asIterable())
			}
		}
		
		fun durationInSeconds(then: Serializer<Double> = VDFPrimitive::invoke): Serializer<Duration> = { it: Duration ->
			then(it.toDouble(DurationUnit.SECONDS))
		}
		
		inline fun <reified T : Any> flatListWithKey(): Serializer<Iterable<T>> {
			IVDFRepresentableValue.requireValueRepresentable(T::class.java)
			return _flatListWithKey()
		}
		
		@PublishedApi
		internal fun <T : Any> _flatListWithKey(): Serializer<Iterable<T>> = { iterable: Iterable<T> ->
			IVDFRepresentableValue { key, conditional ->
				IVDFRepresentableKeyValue { input: VDFSubtree, forcedConditional ->
					iterable.forEach {
						IVDFRepresentableValue.serializeDynamic(key, it, conditional)
							._serializeInto(input, forcedConditional)
					}
				}
			}
		}
		
		fun <T : Any, U : Any> selector(extractor: (T) -> U?): (T) -> U {
			val name = if (extractor is KCallable<*>) {
				" \"${extractor.name}\""
			} else ""
			return {
				extractor(it) ?: throw IllegalArgumentException("Serializer$name returned null.\nValue: $it.")
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
					IVDFRepresentableKeyValue { parent, forcedConditional ->
						parent += VDFKeyValue(
							key,
							VDFSubtree(parent).apply {
								iterable.forEach {
									this += VDFKeyValue(VDFPrimitive(it), dummyValue, forcedConditional)
								}
							},
							forcedConditional ?: conditional
						)
						
					}
				}
			}
		}
		
		fun <T : Any, U : Any> notNull(getter: (T) -> U?): (T) -> U {
			return { it: T ->
				getter(it) ?: error("Expected $getter to return not null.")
			}
		}
		
		@OverloadResolutionByLambdaReturnType
		fun <OWNER : IExtensibleSubtree, FIELDTYPE : Any> getField(getter: (OWNER) -> ExtField<FIELDTYPE>, then: (FIELDTYPE) -> IVDFRepresentableValue = IVDFRepresentableValue::serializeDynamic): Serializer<OWNER> {
			return { owner: OWNER ->
				IVDFRepresentableValue { key, setCond ->
					context(owner) {
						getter(owner)[setCond]?.let(then)?._toKeyValueRepresentable(key, setCond)
							?: error("Expected $getter to be set.")
					}
				}
			}
		}
		
		@JvmName("getBound")
		@OverloadResolutionByLambdaReturnType
		fun <OWNER : IExtensibleSubtree, FIELDTYPE : Any> getField(getter: (OWNER) -> ExtField.Bound<FIELDTYPE>, then: (FIELDTYPE) -> IVDFRepresentableValue = IVDFRepresentableValue::serializeDynamic): Serializer<OWNER> {
			return getField({ owner: OWNER -> getter(owner).field }, then)
		}
		
		
		fun <T : IVDFRepresentableKeyValue> subtreeOfSubtrees(): Serializer<Iterable<T>> {
			return { items ->
				IVDFRepresentableValue_Subtree { parent ->
					VDFSubtree(parent).also { newSubtree ->
						items.forEach { it._serializeInto(newSubtree, null) }
					}
				}
			}
		}
	}
	
	/**
	 * @param T The data being gotten and set through this object, visible to the user.
	 */
	@SupportsCustomAssignment
	interface ExtField<T : Any> {
		val _uuid: String
		
		context(subtree: IExtensibleSubtree)
		fun set(value: T, conditional: String? = null)
		
		context(subtree: IExtensibleSubtree)
		operator fun set(conditional: String?, value: T) = set(value, conditional)
		
		context(subtree: IExtensibleSubtree)
		fun set(other: ExtField<T>) = other.getAll().forEach { (value, conditional) -> set(value, conditional) }
		
		context(subtree: IExtensibleSubtree)
		fun set(other: Bound<T>) = other.field.getAll().forEach { (value, conditional) -> set(value, conditional) }
		
		context(subtree: IExtensibleSubtree)
		operator fun get(conditional: String? = null): T?
		
		/**
		 * Get the value this is set with for each platform.
		 *
		 * Generally only needed for copying the value of one field to another.
		 */
		context(subtree: IExtensibleSubtree)
		fun getAll(): Iterable<ConditionalValue<T>>
		
		context(subtree: IExtensibleSubtree)
		fun clear()
		
		context(subtree: IExtensibleSubtree)
		fun assign(value: T?) = if (value == null) clear() else set(value)
		
		context(subtree: IExtensibleSubtree)
		fun assign(other: ExtField<T>) = set(other)
		
		context(subtree: IExtensibleSubtree)
		fun assign(other: Bound<T>) = set(other)
		
		operator fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>): Bound<T>
		
		override fun equals(other: Any?): Boolean
		
		override fun hashCode(): Int
		
		/**
		 * A way to interact with a given field without needing to give the owner to it each and every time.
		 */
		@SupportsCustomAssignment
		interface Bound<T : Any> {
			val _subtree: IExtensibleSubtree
			
			val field: ExtField<T>
			
			/**
			 * Get the value stored in this field.
			 *
			 * @param conditional If the value was set only for a specific platform, TODO
			 */
			operator fun get(conditional: String? = null): T? {
				return context(_subtree) {
					field.get(conditional)
				}
			}
			
			fun getAll(): Iterable<ConditionalValue<T>> = context(_subtree) { field.getAll() }
			
			val isSet get() = getAll().count() != 0
			
			operator fun set(conditional: String?, value: T) = set(value, conditional)
			
			fun set(value: T, conditional: String?) {
				context(_subtree) {
					field.set(value, conditional)
				}
			}
			
			fun set(other: ExtField<T>) = context(_subtree) { field.set(other) }
			
			fun set(other: Bound<T>) = context(_subtree) { field.set(other) }
			
			fun clear() {
				context(_subtree) {
					field.clear()
				}
			}
			
			fun assign(value: T?) = context(_subtree) { field.assign(value) }
			
			fun assign(other: ExtField<T>) = context(_subtree) { field.assign(other) }
			
			fun assign(other: Bound<T>) = context(_subtree) { field.assign(other) }
		}
	}
	
	interface NonNullExtField<T : Any> : ExtField<T> {
		context(subtree: IExtensibleSubtree)
		override operator fun get(conditional: String?): T
		
		interface Bound<T : Any> : ExtField.Bound<T> {
			override operator fun get(conditional: String?): T
		}
		
		override fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>): Bound<T>
	}
	
	/*
	What are our requirements?
	- Entries must be placed in sequential order
	- Entries must be unique
	- How do we distinguish between setting and overwriting?
	- Anything that isn't a collection should be overwritten when set, but collections are appended to
	- Collections need to support each element having its own conditional
	- Single-element fields need to support being set multiple times with different conditionals
	- Fields must be able to be set with assignment operators
	- Fields must be serialized into a VDF
	- Fields must not conflict with one another.
	- Collection fields may have a conditional applied to its definition that will be applied to any elements that do not have a user-specified conditional
	- Self-named fields must be able to be set with conditionals, which should apply said conditional to anything it serializes at that level
	
	
	Strategy:
	- Objects that purely translate the user-defined data into what is stored in the subtree
	- Data that is stored in the subtree, does not contain multiple values, but rather
	- Key for said data in the map to be retrieved later
		- Since the LinkedHashMap saves the insertion order, this should be the one that contains the conditional
		  so we don't overwrite elements when the same field is set with multiple conditionals
	 */
	abstract class NamedField<T : Any>(override val _uuid: String, serializationKey: String, val definitionConditional: String? = null)
		: ExtField<T>
	{
		val serializationKey = VDFPrimitive(serializationKey)
		
		abstract override fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>): Bound<T>
		
		interface Bound<T : Any> : ExtField.Bound<T> {
			override val field: NamedField<T>
		}
	}
	
	// factory model: factory holds all the data, then instances of the interface are made on the fly
	// to allow it to interact with the parent subtree
	
	open class NamedFieldImpl<T : Any>(
		uuid: String,
		serializationKey: String,
		definitionConditional: String? = null,
		val serializer: ((T) -> Any?)? = null
	) : NamedField<T>(uuid, serializationKey, definitionConditional)
	{
		private inner class Data(val item: T, val conditional: String?) : IVDFRepresentableKeyValue {
			override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
				val out = if (serializer != null)
					serializer(item) ?: return;
				else
					item
				
				return IVDFRepresentableValue.serializeDynamic(serializationKey, out, conditional)
					._serializeInto(input, null)
			}
		}
		
		context(subtree: IExtensibleSubtree)
		override fun get(conditional: String?): T? {
			return subtree._dataStorage[FieldKey<Data>(this, conditional)]?.item
		}
		
		context(subtree: IExtensibleSubtree)
		override fun set(value: T, conditional: String?) {
			subtree._dataStorage[FieldKey<Data>(this, conditional)] = Data(value, conditional)
		}
		
		context(subtree: IExtensibleSubtree)
		override fun clear() {
			subtree._dataStorage.removeIf { it is FieldKey && it.field === this }
		}
		
		
		context(subtree: IExtensibleSubtree)
		override fun getAll(): Iterable<ConditionalValue<T>> {
			return subtree._dataStorage.getAllForField(this).map { (k, v) ->
				val cond = k.conditional
				val value = (v as NamedFieldImpl<T>.Data).item
				
				ConditionalValue(value, cond)
			}.asIterable()
		}
		
		open class Bound<T : Any>(override val _subtree: IExtensibleSubtree, override val field: NamedField<T>) : NamedField.Bound<T>
		
		override fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>): Bound<T> = Bound(subtree, this)
		
		override fun equals(other: Any?): Boolean {
			return other === this || (other != null && other is NamedFieldImpl<T> && other._uuid == this._uuid)
		}
		
		override fun hashCode(): Int {
			return _uuid.hashCode()
		}
	}
	
	open class NamedFieldWithInitialValue<T : Any>(
		uuid: String,
		serializationKey: String,
		definitionConditional: String? = null,
		serializer: ((T) -> Any?)? = null,
		initialValue: () -> T
	) : NamedFieldImpl<T>(uuid, serializationKey, definitionConditional, serializer) {
		private val initialValue by lazy(LazyThreadSafetyMode.NONE, initialValue)
		
		context(subtree: IExtensibleSubtree)
		override fun get(conditional: String?): T {
			return super.get(conditional) ?: initialValue
		}
		
		open class Bound<T : Any>(subtree: IExtensibleSubtree, override val field: NamedFieldWithInitialValue<T>)
			: NamedFieldImpl.Bound<T>(subtree, field), NonNullExtField.Bound<T>
		{
			override fun get(conditional: String?): T {
				return context(_subtree) {
					field.get(conditional)
				}
			}
		}
		
		override operator fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>): Bound<T> {
			return Bound(subtree, this)
		}
	}
	
	
	data class ConditionalValue<T : Any>(val value: T, val conditional: String?) : IVDFRepresentableValue {
		override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
			return IVDFRepresentableValue.serializeDynamic(key, value, this.conditional ?: conditional)
		}
	}
	
	/**
	 * A list of items of type [T] that can also contain conditionals (e.g. `"$WIN32"`) for each element.
	 *
	 * To add elements without using a conditional, use the `+` operator.
	 */
	data class ConditionalList<T : Any>(private val items: List<ConditionalValue<T>> = listOf()) : List<ConditionalValue<T>> by items {
		operator fun plus(element: ConditionalValue<T>): ConditionalList<T> {
			return ConditionalList(items + element)
		}
		
		@JvmName("plusConditionalValues")
		operator fun plus(elements: Iterable<ConditionalValue<T>>): ConditionalList<T> {
			return ConditionalList(items + elements)
		}
		
		operator fun plus(element: T): ConditionalList<T> {
			return plus(ConditionalValue(element, null))
		}
		
		operator fun plus(elements: Iterable<T>): ConditionalList<T> {
			return plus(elements.asSequence().map { ConditionalValue(it, null) }.asIterable())
		}
		
		operator fun plus(elements: Array<out T>): ConditionalList<T> {
			return plus(elements.asSequence().map { ConditionalValue(it, null) }.asIterable())
		}
	}
	
	
	interface ConditionalListField<T : Any> : NonNullExtField<ConditionalList<T>>{
		context(subtree: IExtensibleSubtree)
		operator fun plus(element: T): ConditionalList<T> {
			return this.get(null) + element
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plusAssign(element: T) {
			this.set(plus(element))
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plus(elements: Iterable<T>): ConditionalList<T> {
			return this.get(null) + elements
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plusAssign(elements: Iterable<T>) {
			this.set(plus(elements), null)
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plus(elements: Array<out T>): ConditionalList<T> {
			return this.get(null) + elements
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plusAssign(elements: Array<out T>) {
			this.set(plus(elements), null)
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plus(element: ConditionalValue<T>): ConditionalList<T> {
			return this.get(null) + element
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plusAssign(element: ConditionalValue<T>) {
			this.set(plus(element))
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plus(elements: Collection<ConditionalValue<T>>): ConditionalList<T> {
			return this.get(null) + elements
		}
		
		context(subtree: IExtensibleSubtree)
		operator fun plusAssign(elements: Collection<ConditionalValue<T>>) {
			this.set(plus(elements), null)
		}
		
		context(subtree: IExtensibleSubtree)
		fun add(element: T, conditional: String? = null) {
			add(ConditionalValue(element, conditional))
		}
		
		context(subtree: IExtensibleSubtree)
		fun addAll(elements: Iterable<T>, conditional: String? = null) {
			addAll(elements.map { ConditionalValue(it, conditional) })
		}
		
		context(subtree: IExtensibleSubtree)
		fun addAll(vararg elements: T, conditional: String? = null) {
			addAll(elements.map { ConditionalValue(it, conditional) })
		}
		
		context(subtree: IExtensibleSubtree)
		fun add(element: ConditionalValue<T>) {
			this.set(this.get(null) + element, null)
		}
		
		context(subtree: IExtensibleSubtree)
		fun addAll(elements: Collection<ConditionalValue<T>>, conditional: String? = null) {
			this.set(this.get(null) + elements, null)
		}
		
		context(subtree: IExtensibleSubtree)
		fun assign(elements: Iterable<T>) {
			this.set(ConditionalList(elements.map { ConditionalValue(it, null) }), null)
		}
		
		interface Bound<T : Any> : NonNullExtField.Bound<ConditionalList<T>> {
			override val field: ConditionalListField<T>
			
			operator fun plus(element: T): ConditionalList<T> = context(_subtree) { field.plus(element) }
			
			operator fun plusAssign(element: T) = context(_subtree) { field.plusAssign(element) }
			
			
			operator fun plus(elements: Iterable<T>): ConditionalList<T> = context(_subtree) { field.plus(elements) }
			
			operator fun plusAssign(elements: Iterable<T>) = context(_subtree) { field.plusAssign(elements) }
			
			operator fun plus(elements: Array<out T>): ConditionalList<T> = context(_subtree) { field.plus(elements) }
			
			operator fun plusAssign(elements: Array<out T>) = context(_subtree) { field.plusAssign(elements) }
			
			
			operator fun plus(element: ConditionalValue<T>): ConditionalList<T> = context(_subtree) { field.plus(element) }
			
			operator fun plusAssign(element: ConditionalValue<T>) = context(_subtree) { field.plusAssign(element) }
			
			
			operator fun plus(elements: Collection<ConditionalValue<T>>): ConditionalList<T> = context(_subtree) { field.plus(elements) }
			
			operator fun plusAssign(elements: Collection<ConditionalValue<T>>) = context(_subtree) { field.plusAssign(elements) }
			
			
			fun add(element: T, conditional: String? = null) = context(_subtree) { field.add(element) }
			
			fun addAll(elements: Iterable<T>, conditional: String? = null) = context(_subtree) { field.addAll(elements, conditional) }
			
			fun addAll(vararg elements: T, conditional: String? = null) = context(_subtree) { field.addAll(elements=elements, conditional=conditional) }
			
			
			
			fun add(element: ConditionalValue<T>) = context(_subtree) { field.add(element) }
			
			fun addAll(elements: Collection<ConditionalValue<T>>, conditional: String? = null) = context(_subtree) { field.addAll(elements, conditional) }
			
			fun assign(elements: Iterable<T>) = context(_subtree) { field.assign(elements) }
		}
	}
	
	open class NamedListField<T : Any>(
		uuid: String,
		serializationKey: String, definitionConditional: String? = null,
		val collectionSerializer: Serializers.Serializer<ConditionalList<T>> = Serializers.flatListWithKey()
	) : NamedField<ConditionalList<T>>(uuid, serializationKey, definitionConditional), ConditionalListField<T>
	{
		private inner class Data(val items: ConditionalList<T>, val defaultConditional: String?) : IVDFRepresentableKeyValue {
			override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
				collectionSerializer(items)
					._toKeyValueRepresentable(serializationKey, defaultConditional ?: definitionConditional ?: forcedConditional)
					._serializeInto(input, forcedConditional)
			}
		}
		
		private val dataKey = FieldKey<Data>(this, null)
		
		context(subtree: IExtensibleSubtree)
		override fun get(conditional: String?): ConditionalList<T> {
			return subtree._dataStorage[dataKey]?.items ?: ConditionalList()
		}
		
		context(subtree: IExtensibleSubtree)
		override fun set(value: ConditionalList<T>, conditional: String?) {
			subtree._dataStorage[dataKey] = Data(value, conditional)
		}
		
		context(subtree: IExtensibleSubtree)
		override fun clear() {
			subtree._dataStorage.remove(dataKey)
		}
		
		context(subtree: IExtensibleSubtree)
		override fun getAll(): Iterable<ConditionalValue<ConditionalList<T>>> {
			return subtree._dataStorage.getAllForField(this).map { (k, v) ->
				val cond = k.conditional
				val value = (v as NamedListField<T>.Data).items
				
				ConditionalValue(value, cond)
			}.asIterable()
		}
		
		open class Bound<T : Any>(override val _subtree: IExtensibleSubtree, override val field: NamedListField<T>)
			: NamedField.Bound<ConditionalList<T>>, ConditionalListField.Bound<T>
		{
			override fun get(conditional: String?): ConditionalList<T> = context(_subtree) { field.get(conditional) }
			
		}
		
		override fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>) = Bound(subtree, this)
		
		override fun equals(other: Any?): Boolean {
			return other === this || (other != null && other is NamedListField<T> && other._uuid == this._uuid)
		}
		
		override fun hashCode(): Int {
			return _uuid.hashCode()
		}
	}
	
	
	open class SelfNamedField<T : Any>(val transformer: (T) -> IVDFRepresentableKeyValue, override val _uuid: String) : ExtField<T> {
		protected inner class Data(val item: T, val conditional: String?) : IVDFRepresentableKeyValue {
			override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
				transformer(item)._serializeInto(input, conditional ?: forcedConditional)
			}
		}
		
		
		context(subtree: IExtensibleSubtree)
		override fun set(value: T, conditional: String?) {
			subtree._dataStorage[FieldKey<Data>(this, conditional)] = Data(value, conditional)
		}
		
		context(subtree: IExtensibleSubtree)
		override fun get(conditional: String?): T? {
			return subtree._dataStorage[FieldKey<Data>(this, conditional)]?.item
		}
		
		context(subtree: IExtensibleSubtree)
		override fun clear() {
			subtree._dataStorage.removeIf { it is FieldKey && it.field == this }
		}
		
		context(subtree: IExtensibleSubtree)
		override fun getAll(): Iterable<ConditionalValue<T>> {
			return subtree._dataStorage.getAllForField(this).map { (k, v) ->
				val cond = k.conditional
				val value = (v as SelfNamedField<T>.Data).item
				
				ConditionalValue(value, cond)
			}.asIterable()
		}
		
		
		open class Bound<T : Any>(override val _subtree: IExtensibleSubtree, override val field: SelfNamedField<T>) : ExtField.Bound<T>
		
		override fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>) = Bound(subtree, this)
		
		override fun equals(other: Any?): Boolean {
			return other === this || (other != null && other is SelfNamedField<T> && other._uuid == this._uuid)
		}
		
		override fun hashCode(): Int {
			return _uuid.hashCode()
		}
	}
	
	open class SelfNamedListField<T : Any>(override val _uuid: String, val itemTransformer: (T) -> IVDFRepresentableKeyValue)
		: ExtField<ConditionalList<T>>, ConditionalListField<T>
	{
		protected inner class Data(val items: ConditionalList<T>, val wholeListConditional: String?) : IVDFRepresentableKeyValue {
			override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
				items.forEach {
					itemTransformer(it.value)._serializeInto(input, it.conditional ?: wholeListConditional ?: forcedConditional)
				}
			}
		}
		
		protected val dataKey = FieldKey<Data>(this, null)
		
		context(subtree: IExtensibleSubtree)
		override fun set(value: ConditionalList<T>, conditional: String?) {
			subtree._dataStorage[dataKey] = Data(value, conditional)
		}
		
		context(subtree: IExtensibleSubtree)
		override fun get(conditional: String?): ConditionalList<T> {
			return subtree._dataStorage[dataKey]?.items ?: ConditionalList()
		}
		
		context(subtree: IExtensibleSubtree)
		override fun clear() {
			subtree._dataStorage.remove(dataKey)
		}
		
		context(subtree: IExtensibleSubtree)
		override fun getAll(): Iterable<ConditionalValue<ConditionalList<T>>> {
			return subtree._dataStorage.getAllForField(this).map { (k, v) ->
				val cond = k.conditional
				val value = (v as SelfNamedListField<T>.Data).items
				
				ConditionalValue(value, cond)
			}.asIterable()
		}
		
		override fun equals(other: Any?): Boolean {
			return other === this || (other != null && other is SelfNamedListField<T> && other._uuid == this._uuid)
		}
		
		override fun hashCode(): Int {
			return _uuid.hashCode()
		}
		
		open class Bound<T : Any>(override val _subtree: IExtensibleSubtree, override val field: ConditionalListField<T>) : ExtField.Bound<ConditionalList<T>>, ConditionalListField.Bound<T> {
			override fun get(conditional: String?): ConditionalList<T> = context(_subtree) { field.get(conditional) }
		}
		
		override fun getValue(subtree: IExtensibleSubtree, property: KProperty<*>) = Bound(subtree, this)
	}
	
	open class MergedCategory<T : Merged>(val instance: T) : ReadOnlyProperty<IExtensibleSubtree, T> {
		private val dataKey = object : IDataKey<T> {}
		
		override fun getValue(thisRef: IExtensibleSubtree, property: KProperty<*>): T {
			return thisRef._dataStorage.computeIfAbsent(dataKey) { instance } // instance is an IVDFRepresentableKeyValue already that adds all of its keys to the original struct.  All this does is tell the subtree it's attached to to call it as well.
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
		 * var MyThing.destination by addField<Coord3D>("Destination", serializer={ "$x $y $z" }) // turns Coord3D(x=1, y=2, z=3) into the string "1 2 3"
		 * ```
		 */
		@JvmName("addFieldSerializer")
		inline fun <reified T : Any> addField(serializationKey: String, conditional: String? = null, noinline serializer: Serializers.Serializer<T>? = null): PropertyDelegateProvider<Any?, NamedFieldImpl<T>> {
			return addFieldInternal_nullable(serializationKey, conditional, serializer, if (serializer == null) T::class.java else IVDFRepresentableValue::class.java, T::class)
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
		inline fun <reified T : Any, reified S : Any> addField(serializationKey: String, noinline serializer: T.() -> S?, conditional: String? = null, noinline initialValue: () -> T): PropertyDelegateProvider<Any?, NamedFieldWithInitialValue<T>> {
			@Suppress("UNCHECKED_CAST")
			return addFieldInternal_initialValue(serializationKey, conditional, serializer, initialValue, S::class.java, T::class)
		}
		
		/**
		 * Because Kotlin is broken and won't let me put lambdas in inline functions that reference this companion object,
		 * so now I have to do the Classloading Conga to get everything working...
		 *
		 * @param serializationKey The string that will be used to key this field in the VDF.
		 * @param conditional The conditional (e.g. $WIN32) that should be put on any setting of this field that doesn't supply its own conditional.
		 * @param serializer The function that converts the type the user interacts with - [T] - to something serializable to a VDF.
		 * @param serClass Class for whatever type is being serialized.
		 *                 If [serializer] is given, this will be the return type of that function.
		 *                 Otherwise, it will be the class of type [T].
		 */
		@PublishedApi internal fun <T : Any> addFieldInternal_nullable(
			serializationKey: String, conditional: String?,
			serializer: ((T) -> Any?)?,
			serClass: Class<*>, valueType: KClass<*>
		) : PropertyDelegateProvider<Any?, NamedFieldImpl<T>> {
			checkValidAddFieldType(serClass)
			
			return IDMakingDelegateProvider(valueType) { NamedFieldImpl(it, serializationKey, conditional, serializer) }.let {
				if (IS_DOING_CODEGEN)
					Codegen._CodegenDelegateProvider(it, serializationKey, conditional, valueType)
				else
					it
			}
		}
		
		@PublishedApi internal fun <T : Any> addFieldInternal_initialValue(
			serializationKey: String, conditional: String?,
			serializer: ((T) -> Any?)?, initialValue: () -> T,
			serClass: Class<*>, valueType: KClass<*>
		) : PropertyDelegateProvider<Any?, NamedFieldWithInitialValue<T>> {
			checkValidAddFieldType(serClass)
			
			return IDMakingDelegateProvider(valueType) { NamedFieldWithInitialValue(it, serializationKey, conditional, serializer, initialValue) }.let { fld ->
				if (IS_DOING_CODEGEN)
					Codegen._CodegenDelegateProvider(fld, serializationKey, conditional, valueType)
				else
					fld
			}
		}
		
		internal fun checkValidAddFieldType(type: Class<*>) {
			require(!type.kotlin.isSubclassOf(Collection::class)) {
				"Invalid type for addField: ${type}. Collections must use `addListField()`."
			}
			
			require(IVDFRepresentableValue.isValueRepresentable(type)) {
				if (IVDFRepresentableKeyValue.isKeyValueRepresentable(type)) {
					"Error adding field: ${type.simpleName} is not natively serializable to a keyable VDF value.\n" +
					"As the item is an IVDFRepresentableKeyValue, this is likely an error. Use `selfNamed()` to add this item."
				} else {
					"Error adding field: ${type.simpleName} is not natively serializable to a VDF.\n" +
					"Callers must provide a serializer if the value is not a string, number, boolean, VDFObject, or does not implement IVDFRepresentableValue."
				}
			}
		}
		
		
		
		
		/**
		 * Extend a subtree with a field that can only exist a single time per subtree.
		 *
		 * This method may only be used with natively-serializable values, i.e. numbers, booleans, strings, [VDFObjects][VDFObject], or objects that implement either [IVDFRepresentableValue_Trivial] or [IVDFRepresentableKeyValue].
		 *
		 * @param key The key this item will be serialized under.
		 */
		inline fun <reified T : Any> addField(key: String, conditional: String? = null): PropertyDelegateProvider<Any?, NamedFieldImpl<T>> {
			return addFieldInternal_nullable<T>(key, conditional, serializer = null, serClass = T::class.java, T::class)
		}
		
		
		// is it "functional programming" or "just being wasteful with memory"? the world may never know...
		@PublishedApi internal class IDMakingDelegateProvider<T>(val valueType: KClass<*>, val getThing: (id: String) -> T) : PropertyDelegateProvider<Any?, T> {
			override fun provideDelegate(thisRef: Any?, property: KProperty<*>): T {
				return getThing(_generateUniqueFieldIdentifier(thisRef, property, valueType))
			}
		}
		
		/**
		 * Extend a subtree with a field that can only exist a single time per subtree.
		 *
		 * This method may only be used with natively-serializable values, i.e. numbers, booleans, strings, [VDFObjects][VDFObject], or objects that implement either [IVDFRepresentableValue_Trivial] or [IVDFRepresentableKeyValue].
		 *
		 * @param key The key this item will be serialized under.
		 * @param initialValue Value that should be set before any setting takes place.  This is only called after the first "set", so it does not automatically make this value non-null in the serialized form if nothing ever uses this property.
		 */
		inline fun <reified T : Any> addField(key: String, conditional: String? = null, noinline initialValue: () -> T): PropertyDelegateProvider<Any?, NamedFieldWithInitialValue<T>> {
			@Suppress("UNCHECKED_CAST")
			return addFieldInternal_initialValue(key, conditional, null, initialValue, T::class.java, T::class)
		}
		
		inline fun <reified T : Any> addFieldList(key: String, conditional: String? = null, noinline serializer: Serializers.Serializer<ConditionalList<T>> = Serializers.flatListWithKey()): PropertyDelegateProvider<Any?, NamedListField<T>> {
			return IDMakingDelegateProvider(T::class) { NamedListField(it, key, conditional, serializer) }.let {
				if (IS_DOING_CODEGEN)
					Codegen._CodegenDelegateProvider(it, key, conditional, T::class, true)
				else
					it
			}
		}
		
		
		private data class CachedData<T : Any>(val data: T) : IVDFRepresentableKeyValue {
			override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {}
		}
		
		/**
		 * Lazily-evaluated property stored in this struct that shouldn't be serialized to the final VDF.
		 */
		fun <OWNER : IExtensibleSubtree, T : Any> cacheData(initializer: (OWNER, KProperty<*>) -> T): ReadOnlyProperty<OWNER, T> {
			return ReadOnlyProperty { thisRef, property ->
				val dataKey = PropertyKey<CachedData<T>>(property)
				val gotten = thisRef._dataStorage[dataKey]
				if (gotten != null)
					return@ReadOnlyProperty gotten.data;
				
				val newData = CachedData(initializer(thisRef, property))
				thisRef._dataStorage[dataKey] = newData
				return@ReadOnlyProperty newData.data
			}
		}
		
		
		/**
		 * A struct that may only appear once in the subtree.
		 *
		 * Note that the only difference between a struct and a named subtree is that structs have their _own_ names.
		 * As such, there is no way to name these.
		 *
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [AbstractVDFStruct] and its subclasses),
		 * use [addField] with an [IVDFRepresentableValue_Subtree][IVDFRepresentableValue_Subtree] as its value to allow the parent scope to decide its name.
		 *
		 * Note: Self-named values are expected to provide their own conditionals.
		 */
		inline fun <reified T : IVDFRepresentableKeyValue> selfNamed(): PropertyDelegateProvider<Any?, SelfNamedField<T>> = selfNamed<T> { it }
		
		/**
		 * A struct that may only appear once in the subtree.
		 *
		 * Note that the only difference between a struct and a named subtree is that structs have their _own_ names.
		 * As such, there is no way to name these.
		 *
		 * If a structure doesn't use its name to determine what kind of structure it is (e.g. [AbstractVDFStruct] and its subclasses),
		 * use [addField] with an [IVDFRepresentableValue_Subtree][IVDFRepresentableValue_Subtree] as its value to allow the parent scope to decide its name.
		 *
		 * Note: Self-named values are expected to provide their own conditionals.
		 *
		 * @param transformer Something to turn the item saved in this field into 1+ keyvalues, or otherwise postprocess the value (like adding a conditional if the struct doesn't have one already).
		 */
		inline fun <reified T : Any> selfNamed(noinline transformer: (T) -> IVDFRepresentableKeyValue) = _selfNamed(T::class, transformer)
		
		@PublishedApi internal fun <T : Any> _selfNamed(valueType: KClass<*>, transformer: (T) -> IVDFRepresentableKeyValue): PropertyDelegateProvider<Any?, SelfNamedField<T>> {
			return PropertyDelegateProvider<Any?, _> { owner, prop ->
				if (IS_DOING_CODEGEN)
					Codegen._registerCodegenSelfNamedMapping(owner, prop, valueType)
				
				IDMakingDelegateProvider(valueType) { SelfNamedField(transformer, it) }.provideDelegate(owner, prop)
			}
		}
		
		// detect instance properties and make sure they have something that lets them be equated properly
		fun _generateUniqueFieldIdentifier(owner: Any?, prop: KProperty<*>, valueType: KClass<*>): String {
			return prop.fqName.toKotlinCode() // TODO make this more robust ig
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
		inline fun <reified T : IVDFRepresentableKeyValue> selfNamedList(noinline transformer: (T) -> IVDFRepresentableKeyValue = { it }) = _selfNamedList(T::class, transformer)
		
		
		@PublishedApi internal fun <T : IVDFRepresentableKeyValue> _selfNamedList(valueType: KClass<T>, transformer: (T) -> IVDFRepresentableKeyValue = { it }) = PropertyDelegateProvider<Any?, SelfNamedListField<T>> { owner, prop ->
			if (IS_DOING_CODEGEN)
				Codegen._registerCodegenSelfNamedListMapping(owner, prop, valueType)
			
			IDMakingDelegateProvider(valueType) { SelfNamedListField(it, transformer) }.provideDelegate(owner, prop)
		}
		
		/**
		 * Extend a subtree with another extensible subtree that will have all of its keyvalues merged into this subtree as though it never existed.
		 *
		 * Example:
		 * ```
		 * class WaveSchedule {
		 *     val gameplay by merged(GameplaySettings())
		 *
		 *     class GameplaySettings : ExtensibleSubtreeImpl(), IBlockScoped {
		 *        val startingCurrency by addField<Int>("StartingCurrency")
		 *     }
		 * }
		 *
		 * val waveSchedule = WaveSchedule()
		 * waveSchedule.gameplay {
		 *     startingCurrency = 2
		 * }
		 * println(waveSchedule.toFormattedString()) // WaveSchedule { StartingCurrency 2 }
		 * ```
		 */
		fun <T : Merged> merged(instance: T): PropertyDelegateProvider<Any?, MergedCategory<T>>
		{
			return PropertyDelegateProvider { thisRef, prop ->
				if (IS_DOING_CODEGEN)
					Codegen._registerCodegenMergedMapping(thisRef, prop, instance::class)
				
				MergedCategory(instance)
			}
		}
	}
	
	
	
	
	object Codegen {
		val typeHierarchy = ClassHierarchyGraph()
		
		internal val _codegenFieldMappings = mutableMapOf<KClass<*>, ExtensibleSubtreeDecoder>()
		
		inline fun <reified T : IExtensibleSubtree> forType() = forType(T::class)
		
		fun forType(kclass: KClass<*>) = CodegenProvider { getOrCreateStructDecoder(kclass) }
		
		fun getOrCreateStructDecoder(structType: KClass<*>): ExtensibleSubtreeDecoder {
			if (!IS_DOING_CODEGEN)
				error("Attempted to get struct decoder with type ${structType.qualifiedName} when not in codegen mode.\n" +
				      "Ensure any codegen decoders are wrapped in a CodegenProvider so they're only created or accessed when in codegen mode.")
			
			typeHierarchy.add(structType)
			
			return _codegenFieldMappings.computeIfAbsent(structType) { ExtensibleSubtreeDecoder(it) }
		}
		
		/**
		 * Solely exists because the JVM freaked out with a security exception from referencing [_registerCodegenFieldMapping] from an inline-function's property delegate provider.
		 */
		@PublishedApi internal class _CodegenDelegateProvider<T>(val thingToProvide: PropertyDelegateProvider<Any?, T>, val key: String, val conditional: String?, val valueType: KClass<*>, val isList: Boolean = false) : PropertyDelegateProvider<Any?, T> {
			override fun provideDelegate(thisRef: Any?, property: KProperty<*>): T {
				_registerCodegenFieldMapping(thisRef, property, key, conditional, valueType, isList)
				
				return thingToProvide.provideDelegate(thisRef, property)
			}
		}
		
		fun _registerCodegenFieldMapping(propOwner: Any?, prop: KProperty<*>, serializationKey: String, conditional: String?, valueType: KClass<*>, isList: Boolean) {
			if (!IS_DOING_CODEGEN)
				return;
			
			// this is what the field is filed under
			val receiverType: KClass<*> = prop.getExtensionReceiverType() ?: propOwner!!::class
			
			val operator = if (isList) {
				"+="
			} else {
				"="
			}
			
			getOrCreateStructDecoder(receiverType).apply {
				fieldDecoders.computeIfAbsent(VDFPrimitive.notInterned(serializationKey)) {
					StructFieldDecoderPropExt_Keyed(prop, valueType, operator)
				}
			}
		}
		
		
		fun _registerCodegenSelfNamedMapping(propOwner: Any?, prop: KProperty<*>, valueType: KClass<*>) {
			val receiverType: KClass<*> = prop.getExtensionReceiverType() ?: propOwner!!::class // must extend IExtensibleSubtree, thus must be the receiver of this property
			
			
			getOrCreateStructDecoder(receiverType).apply {
				selfNamedDecoders += StructFieldDecoderPropExt_SelfNamed(prop, valueType, "=")
			}
		}
		
		fun _registerCodegenSelfNamedListMapping(propOwner: Any?, prop: KProperty<*>, valueType: KClass<*>) {
			val receiverType: KClass<*> = prop.getExtensionReceiverType() ?: propOwner!!::class // must extend IExtensibleSubtree, thus must be the receiver of this property
			
			// TODO make this less strict
			getOrCreateStructDecoder(receiverType).apply {
				selfNamedDecoders += StructFieldDecoderPropExt_SelfNamed(prop, valueType, "+=")
			}
		}
		
		fun _registerCodegenMergedMapping(propOwner: Any?, prop: KProperty<*>, valueType: KClass<*>) {
			val receiverType = prop.getExtensionReceiverType() ?: propOwner!!::class
			// TODO make this work with deeper nestings. I just can't think of it rn
			getOrCreateStructDecoder(receiverType).apply {
				selfNamedDecoders += StructFieldDecoderPropExt_Merged(prop)
				/*
				assume default factory method of:
				
				prop {
					x = y
					a = b
				}
				 */
			}
			getOrCreateStructDecoder(valueType).apply {
				factoryMethod = { x ->
					KtFunctionCall(KtMemberReference(prop), mutableListOf(KtLambda(lines = x)))
				}
				shouldCommentLeftovers = false
			}
		}
		
		private fun KProperty<*>.getExtensionReceiverType(): KClass<*>? {
			return this.extensionReceiverParameter?.type?.classifier?.let {
				it as? KClass<*> ?: error("Cannot perform codegen for a property without a definite type: $it for $this")
			}
		}
		
		
		
		
		/**
		 * @param dummyConstructor We need to create an instance of the struct to ensure any properties declared inside the struct are instantiated and have their field codegen entries autogenerated from the `addField` calls
		 * @param factoryMethod What is used to generate the thing for the source code, like `MyStruct { ...assignments }`.
		 */
		inline fun <reified T : IExtensibleSubtree> registerCodegen(noinline dummyConstructor: (() -> T)? = null, customFieldDecoders: () -> Map<String, CodegenProvider<ValueDecoder<KtExpression>>> = { emptyMap() }, factoryMethod: () -> StructFactoryMethod): CodegenProvider<ExtensibleSubtreeDecoder> {
			return registerCodegen(T::class, dummyConstructor, customFieldDecoders(), factoryMethod())
		}
		
		@PublishedApi internal fun <T : IExtensibleSubtree> registerCodegen(cls: KClass<T>, dummyConstructor: (() -> T)?, customFieldDecoders: Map<String, CodegenProvider<ValueDecoder<KtExpression>>>, factoryMethod: StructFactoryMethod): CodegenProvider<ExtensibleSubtreeDecoder> {
			if (!IS_DOING_CODEGEN)
				return CodegenProvider.errorInstance();
			
			val dummyConstructor: () -> T = dummyConstructor
			                                ?: cls.constructors.find { it.parameters.all { it.isOptional } }?.let { { it.callBy(emptyMap()) } }
			                                ?: throw CodegenException("Could not find no-arg constructor for class $cls, and no constructor given to _registerStructFactory to instantiate the object.")
			
			val _ = dummyConstructor()
			
			val x = getOrCreateStructDecoder(cls).apply {
				this.factoryMethod = factoryMethod
				
				customFieldDecoders.forEach {
					this.fieldDecoders[VDFPrimitive(it.key)]!!.override = it.value.get()
				}
			}
			return CodegenProvider { x }
		}
		
		typealias StructFactoryMethod = (fields: List<KtStatement>) -> KtFunctionCall
		
		data class StructFieldDecoderPropExt_Keyed(
			val prop: KProperty<*>,
			val valueType: KClass<*>,
			val operator: String
		) : ValueDecoder<KtStatement> {
			private val valueDecoder by lazy(LazyThreadSafetyMode.NONE) {
				Decoders.getValueDecoder(valueType) ?: error("No value decoder found for type $valueType")
			}
			
			var override: ValueDecoder<KtExpression>? = null
			
			private val propAccess by lazy(LazyThreadSafetyMode.NONE) {
				KtGetValueExpression(KtMemberReference(KtName(prop), prop.isExtension)).apply {
					receiver = KtThis()
				}
			}
			
			override fun decodeValue(value: VDFValue, parentSubtree: WeirdMutableIterableSubtree): List<KtStatement>? {
				val x = (override ?: valueDecoder).decodeValue(value, parentSubtree)
				if (x.isNullOrEmpty())
					return null;
				
				return x.map { KtAssignment(propAccess.copy(), it, operator) }
			}
		}
		
		
		/**
		 * Purpose: decode based on some property's type using a lazily-fetched decoder for said type
		 */
		data class StructFieldDecoderPropExt_SelfNamed(
			val prop: KProperty<*>,
			val valueType: KClass<*>,
			val operator: String
		) : SelfNamedDecoder<KtStatement> {
			private val valueDecoder by lazy(LazyThreadSafetyMode.NONE) {
				Decoders.getDecoder(valueType) ?: error("No decoder found for type $valueType")
			}
			
			private val propAccess by lazy(LazyThreadSafetyMode.NONE) {
				KtGetValueExpression(KtMemberReference(KtName(prop), prop.isExtension)).apply {
					receiver = KtThis()
				}
			}
			
			override fun decode(subtree: WeirdMutableIterableSubtree): List<KtStatement>? {
				val x = valueDecoder.decode(subtree)
				if (x.isNullOrEmpty())
					return null;
				
				return x.map { KtAssignment(propAccess.copy(), it, operator) }
			}
		}
		
		class StructFieldDecoderPropExt_Merged(
			prop: KProperty<*>
		) : SelfNamedDecoder<KtStatement> {
			val valueDecoder = getOrCreateStructDecoder(prop.returnType.classifier as? KClass<*> ?: error("Cannot perform codegen for a property without a definite type: $prop"))
			
			override fun decode(subtree: WeirdMutableIterableSubtree): List<KtStatement> {
				return valueDecoder.decodeValue(subtree.toSubtree(), subtree.parent ?: WeirdMutableIterableSubtree(null, VDFSubtree(null)))
			}
		}
	}
	
	interface Merged : IExtensibleSubtree_VDFRepresentable, IVDFRepresentableKeyValue {
		override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
			input.entries.addAll(
				this._vdfRepr(input.parent ?: VDFSubtree(null))
					.let {
						if (forcedConditional != null)
							it.map { it.copy(conditional=forcedConditional) }
						else
							it
					}
			)
		}
	}
}

interface IExtensibleSubtree_VDFRepresentable : IExtensibleSubtree, IVDFRepresentableValue_Subtree {
	override fun copy(): IExtensibleSubtree_VDFRepresentable
}

interface DataStorageVDFRepresentable : IExtensibleSubtree.DataStorage<IVDFRepresentableKeyValue>, IVDFRepresentableKeyValue {
	override fun copy(): DataStorageVDFRepresentable
}

fun <D : Any> IExtensibleSubtree.DataStorage<D>.getAllForField(field: IExtensibleSubtree.ExtField<*>) = entries().filter { it.first.let { it is IExtensibleSubtree.FieldKey<*> && it.field == field } } as List<Pair<IExtensibleSubtree.FieldKey<*>, D>>

/**
 * Just a subtree. See [AbstractVDFStruct] for a subtree with its own name.
 */
open class ExtensibleSubtreeImpl(
	override val _dataStorage: DataStorageVDFRepresentable = IExtensibleSubtree.DataStorageImpl(),
) : IExtensibleSubtree_VDFRepresentable {
	override fun _vdfRepr(parent: VDFSubtree): VDFSubtree {
		val ourSub = VDFSubtree(parent)
		_dataStorage._serializeInto(ourSub, null)
		return ourSub
	}
	
	override fun copy() = ExtensibleSubtreeImpl(_dataStorage.copy())
}

open class ExtensibleSubtreeMergedImpl(protected val backing: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : IExtensibleSubtree.Merged, IExtensibleSubtree_VDFRepresentable by backing {
	protected fun copyInternal() = backing.copy()
	
	final override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return this
	}
	
	final override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
		return super._serializeInto(input, forcedConditional)
	}
	
	override fun copy(): ExtensibleSubtreeMergedImpl = ExtensibleSubtreeMergedImpl(copyInternal())
}

/**
 * Create a copy of this struct and configure it. Alias for `copy().apply { ... }`
 *
 * @return the copy with the configuration scope applied.
 */
inline fun <reified T : IExtensibleSubtree> T.copy(configure: T.() -> Unit): T {
	val copy = this.copy()
	return (copy as? T)?.apply(configure) ?: onCopyError(T::class.java, copy.javaClass)
}

@PublishedApi
internal fun onCopyError(expectedClass: Class<*>, actualClass: Class<*>): Nothing {
	error("Class '${expectedClass.name}' does not implement `IExtensibleSubtree#copy()`, instead returning a '${actualClass}' instance. Implementers must ALWAYS override this method to return their own type.")
}