package btpos.source.vdfdsl.util.collectionviews.mutableimmutables

import kotlin.collections.toPair
import kotlin.reflect.KMutableProperty0

/**
 * A """mutable""" view on an immutable map reference.  "Atomically" (not atomic, just lazy) replaces the backing map every time the map is "mutated".
 */
abstract class MutableImmutableMapView<K, V> : MutableMap<K, V> {
	companion object {
		operator fun <K, V> invoke(prop: KMutableProperty0<Map<K, V>>) = invoke(prop::get, prop::set)
		
		operator fun <K, V> invoke(getMap: () -> Map<K, V>, setMap: (Map<K, V>) -> Unit) = object : MutableImmutableMapView<K, V>() {
			override var map: Map<K, V>
				get() = getMap()
				set(value) = setMap(value)
		}
	}
	
	
	protected abstract var map: Map<K, V>
	
	protected open fun makeEmptyMap(): Map<K, V> = mapOf()
	
	protected open fun makeMap(size: Int): MutableMap<K, V> = LinkedHashMap(size)
	
	
	override fun put(key: K, value: V): V? {
		map.let { original ->
			val newMap = makeMap(original.size + 1).also {
				it.putAll(original)
				it[key] = value
			}
			map = newMap
			return original[key]
		}
	}
	
	override fun remove(key: K): V? {
		map.let { original ->
			val newMap = makeMap(original.size)
			original.filterTo(newMap) { it.key != key }
			map = newMap
			return original[key]
		}
	}
	
	override fun putAll(from: Map<out K, V>) {
		map.let { original ->
			val newMap = makeMap(original.size + from.size).also {
				it.putAll(original)
				it.putAll(from)
			}
			map = newMap
		}
	}
	
	override fun clear() {
		map = makeEmptyMap()
	}
	
	override val size: Int
		get() = map.size
	
	override fun isEmpty(): Boolean {
		return map.isEmpty()
	}
	
	override fun containsKey(key: K): Boolean {
		return map.containsKey(key)
	}
	
	override fun containsValue(value: V): Boolean {
		return map.containsValue(value)
	}
	
	override fun get(key: K): V? {
		return map[key]
	}
	
	
	private inner class MutableEntryIterator<T>(val getItem: (Map.Entry<K, V>) -> T) : MutableIterator<T> {
		private val iter = map.entries.iterator()
		private var lastValue: Map.Entry<K, V>? = null
		
		override fun remove() {
			lastValue?.let {
				this@MutableImmutableMapView.remove(it.key)
			} ?: throw IllegalStateException("next has not been called yet, or the most recent next call has already been followed by a remove call.")
		}
		
		override fun next(): T {
			return iter.next().let {
				lastValue = it
				getItem(it)
			}
		}
		
		override fun hasNext(): Boolean {
			return iter.hasNext()
		}
	}
	
	override val keys: MutableSet<K>
		get() = object : MutableSet<K> {
			private val k get() = map.keys
			
			override fun iterator(): MutableIterator<K> {
				return MutableEntryIterator(Map.Entry<K, V>::key)
			}
			
			override fun add(element: K): Boolean {
				throw UnsupportedOperationException("Map.keySet() collection does not support adding elements.")
			}
			
			override fun addAll(elements: Collection<K>): Boolean {
				throw UnsupportedOperationException("Map.keySet() collection does not support adding elements.")
			}
			
			override fun remove(element: K): Boolean {
				map.let { m ->
					val newMap = m.filterKeys { it != element }
					val wasChanged = m.size != newMap.size
					map = newMap
					return wasChanged
				}
			}
			
			override fun removeAll(elements: Collection<K>): Boolean {
				map.let { m ->
					val newMap = m.filterKeys { it !in elements }
					val wasChanged = m.size != newMap.size
					map = newMap
					return wasChanged
				}
			}
			
			override fun retainAll(elements: Collection<K>): Boolean {
				map.let { m ->
					val newMap = m.filterKeys { it in elements }
					val wasChanged = m.size != newMap.size
					map = newMap
					return wasChanged
				}
			}
			
			override fun clear() {
				map = emptyMap()
			}
			
			override val size: Int
				get() = k.size
			
			override fun isEmpty(): Boolean {
				return k.isEmpty()
			}
			
			override fun contains(element: K): Boolean {
				return k.contains(element)
			}
			
			override fun containsAll(elements: Collection<K>): Boolean {
				return k.containsAll(elements)
			}
		}
	
	override val values: MutableCollection<V>
		get() = object : MutableCollection<V> {
			private val v get() = map.values
			
			/**
			 * Note that the iterator is saved at the beginning of iteration.
			 *
			 * As such, if the backing map is changed during iteration,
			 * the values given will desync with the backing map,
			 * though any changes will still write-through.
			 *
			 * This is our version of undefined behavior for concurrent modification
			 * as given in the [java.util.Map.keySet] contract.
			 */
			override fun iterator(): MutableIterator<V> {
				return MutableEntryIterator(Map.Entry<K, V>::value)
			}
			
			override fun add(element: V): Boolean {
				throw UnsupportedOperationException("Map.values() collection does not support adding elements.")
			}
			
			override fun addAll(elements: Collection<V>): Boolean {
				throw UnsupportedOperationException("Map.values() collection does not support adding elements.")
			}
			
			// should be linearizable to the start of each method if I got this right
			override fun remove(element: V): Boolean {
				map.let { m ->
					val newMap = m.filterValues { it != element }
					val wasChanged = m.size != newMap.size
					map = newMap
					return wasChanged
				}
			}
			
			override fun removeAll(elements: Collection<V>): Boolean {
				map.let { m ->
					val newMap = m.filterValues { it !in elements }
					val wasChanged = m.size != newMap.size
					map = newMap
					return wasChanged
				}
			}
			
			override fun retainAll(elements: Collection<V>): Boolean {
				map.let { m ->
					val newMap = m.filterValues { it in elements }
					
					val wasChanged = m.size != newMap.size
					map = newMap
					return wasChanged
				}
			}
			
			override fun clear() {
				map = mapOf()
			}
			
			override val size: Int
				get() = v.size
			
			override fun isEmpty(): Boolean {
				return v.isEmpty()
			}
			
			override fun contains(element: V): Boolean {
				return element in v
			}
			
			override fun containsAll(elements: Collection<V>): Boolean {
				return v.containsAll(elements)
			}
		}
	
	
	private inner class FakeMutableEntry(private var backing: Map.Entry<K, V>) : MutableMap.MutableEntry<K, V> {
		override fun setValue(newValue: V): V {
			this@MutableImmutableMapView[backing.key] = newValue
			val oldValue = backing.value
			backing = object : Map.Entry<K, V> {
				override val key: K = backing.key
				override val value: V = newValue
			}
			return oldValue
		}
		
		override val key: K
			get() = backing.key
		
		override val value: V
			get() = backing.value
		
	}
	
	override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
		get() = object : MutableSet<MutableMap.MutableEntry<K, V>> {
			private val e get() = map.entries
			
			override fun iterator() = MutableEntryIterator { FakeMutableEntry(it) }
			
			override fun add(element: MutableMap.MutableEntry<K, V>): Boolean {
				return this@MutableImmutableMapView.put(element.key, element.value) != null
			}
			
			override fun remove(element: MutableMap.MutableEntry<K, V>): Boolean {
				return this@MutableImmutableMapView.remove(element.key, element.value)
			}
			
			override fun addAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
				val oldSize = map.size
				this@MutableImmutableMapView.putAll(elements.asSequence().map { it.toPair() })
				return oldSize != map.size
			}
			
			override fun removeAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
				val oldSize = map.size
				this@MutableImmutableMapView.putAll(elements.asSequence().map { it.toPair() })
				return oldSize != map.size
			}
			
			override fun retainAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
				map.let { m ->
					val newMap = m.filter { (k, v) -> elements.any { it.key == k && it.value == v } }
					val hasChanged = m.size != newMap.size
					map = newMap
					return hasChanged
				}
			}
			
			override fun clear() {
				this@MutableImmutableMapView.clear()
			}
			
			override val size: Int
				get() = e.size
			
			override fun isEmpty() = e.isEmpty()
			
			override fun contains(element: MutableMap.MutableEntry<K, V>) = e.contains(element)
			
			override fun containsAll(elements: Collection<MutableMap.MutableEntry<K, V>>) = e.containsAll(elements)
		}
	
}