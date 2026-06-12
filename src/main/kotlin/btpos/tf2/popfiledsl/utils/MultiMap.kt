package btpos.tf2.popfiledsl.utils

import kotlin.sequences.filter


class MultiMap<K : Any, V : Any> : Iterable<Pair<K, V>> {
	private typealias L<K, V> = MutableList<Pair<K, V>>
	
	
	/**
	 * "functional programming" thing to D.R.Y the "it.first == key" predicate
	 */
	private inline fun <ANY : Any, OUT> ANY.applyMatchingKey(key: K, function: ANY.((Pair<K, V>) -> Boolean) -> OUT): OUT {
		return this.function { it.first == key }
	}
	
	private val backingList: L<K, V> = mutableListOf()
	
	fun getSingle(key: K): V? {
		return backingList.applyMatchingKey(key, L<K, V>::firstOrNull)?.second
	}
	
	fun getMulti(key: K): List<V> {
		return backingList.asSequence()
			.applyMatchingKey(key, Sequence<Pair<K, V>>::filter)
			.map { it.second }
			.toList()
	}
	
	fun add(key: K, value: V) {
		backingList.add(key to value)
	}
	
	fun set(key: K, value: V) {
		remove(key)
		add(key, value)
	}
	
	fun remove(key: K) {
		backingList.applyMatchingKey(key, L<K, V>::removeAll)
	}
	
	override fun iterator(): Iterator<Pair<K, V>> {
		return backingList.iterator()
	}
}