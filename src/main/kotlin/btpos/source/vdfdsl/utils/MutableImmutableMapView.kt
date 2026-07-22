package btpos.source.vdfdsl.utils

/**
 * A """mutable""" view on an immutable map reference.  "Atomically" (not atomic, just lazy) replaces the backing map every time the map is "mutated".
 */
class MutableImmutableMapView<K, V>(val getMap: () -> Map<K, V>, val setMap: (Map<K, V>) -> Unit) : MutableMap<K, V> {
	private var map: Map<K, V>
		get() = getMap()
		set(value) { setMap(value) }
	
	private fun setItem(key: K, value: V): V? {
		val oldValue = map[key]
		map += (key to value)
		return oldValue
	}
	
	override val keys: MutableSet<K>
		get() = map.keys.toMutableSet()
	override val values: MutableCollection<V>
		get() = map.values.toMutableList()
	
	private inner class FakeMutableEntry(override val key: K) : MutableMap.MutableEntry<K, V> {
		override fun setValue(newValue: V): V {
			return setItem(key, newValue)!!
		}
		
		override val value get() = map[key]!!
	}
	
	override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
		get() = map.keys.mapTo(mutableSetOf()) { FakeMutableEntry(it) }
	
	override fun put(key: K, value: V): V? {
		return setItem(key, value)
	}
	
	override fun remove(key: K): V? {
		val oldValue = map[key]
		map -= key
		return oldValue
	}
	
	override fun putAll(from: Map<out K, V>) {
		map += from
	}
	
	override fun clear() {
		map = emptyMap()
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
}