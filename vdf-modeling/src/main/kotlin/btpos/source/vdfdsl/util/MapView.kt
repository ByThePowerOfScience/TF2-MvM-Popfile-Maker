package btpos.source.vdfdsl.util

import java.util.function.Consumer

class MapView<K1, V1, K2, V2>(
	val backing: MutableMap<K1, V1>,
	val readKey: (K1) -> K2, val writeKey: (K2) -> K1,
	val readValue: (V1) -> V2, val writeValue: (V2) -> V1
) : MutableMap<K2, V2> {
	override val keys: MutableSet<K2>
		get() = SetView(backing.keys, readKey, writeKey)
	
	override val values: MutableCollection<V2>
		get() = CollectionView(backing.values, readValue, writeValue)
	
	override val entries: MutableSet<MutableMap.MutableEntry<K2, V2>>
		get() = SetView(backing.entries, ::EntryView) { object : MutableMap.MutableEntry<K1, V1> {
			override fun setValue(newValue: V1): V1 {
				return this.value.also {
					value = newValue
				}
			}
			
			override val key: K1 = writeKey(it.key)
			override var value: V1 = writeValue(it.value)
		} }
	
	
	inner class EntryView(val entry: MutableMap.MutableEntry<K1, V1>) : MutableMap.MutableEntry<K2, V2> {
		override fun setValue(newValue: V2): V2 {
			return entry.setValue(newValue.let(writeValue)).let(readValue)
		}
		
		override val key: K2
			get() = readKey(entry.key)
		override val value: V2
			get() = readValue(entry.value)
		
	}
	
	override fun put(key: K2, value: V2): V2? {
		return backing.put(writeKey(key), writeValue(value))?.let(readValue)
	}
	
	override fun remove(key: K2): V2? {
		return backing.remove(writeKey(key))?.let(readValue)
	}
	
	override fun putAll(from: Map<out K2, V2>) {
		return backing.putAll(MapView(from.toMutableMap(), writeKey, readKey, writeValue, readValue))
	}
	
	override fun clear() {
		backing.clear()
	}
	
	override val size: Int
		get() = backing.size
	
	override fun isEmpty(): Boolean {
		return backing.isEmpty()
	}
	
	override fun containsKey(key: K2): Boolean {
		return backing.containsKey(writeKey(key))
	}
	
	override fun containsValue(value: V2): Boolean {
		return backing.containsValue(writeValue(value))
	}
	
	override fun get(key: K2): V2? {
		return backing[writeKey(key)]?.let(readValue)
	}
}

class SetView<T1, T2>(backing: MutableSet<T1>, read: (T1) -> T2, write: (T2) -> T1) : MutableSet<T2>, CollectionView<T1, T2, MutableSet<T1>>(backing, read, write)

class ListView<T1, T2>(backing: MutableList<T1>, read: (T1) -> T2, write: (T2) -> T1) : MutableList<T2>, CollectionView<T1, T2, MutableList<T1>>(backing, read, write) {
	override fun add(index: Int, element: T2) {
		return backing.add(index, write(element))
	}
	
	override fun addAll(index: Int, elements: Collection<T2>): Boolean {
		return backing.addAll(index, elements.map(write))
	}
	
	override fun get(index: Int): T2 {
		return backing[index].let(read)
	}
	
	override fun indexOf(element: T2): Int {
		return backing.indexOf(write(element))
	}
	
	override fun lastIndexOf(element: T2): Int {
		return backing.lastIndexOf(write(element))
	}
	
	override fun listIterator(): MutableListIterator<T2> {
		return ListIteratorView(backing.listIterator(), read, write)
	}
	
	override fun listIterator(index: Int): MutableListIterator<T2> {
		return ListIteratorView(backing.listIterator(index), read, write)
	}
	
	override fun removeAt(index: Int): T2 {
		return backing.removeAt(index).let(read)
	}
	
	override fun set(index: Int, element: T2): T2 {
		return backing.set(index, write(element)).let(read)
	}
	
	override fun subList(fromIndex: Int, toIndex: Int): MutableList<T2> {
		return ListView(backing.subList(fromIndex, toIndex), read, write)
	}
}



open class ListIteratorView<T1, T2>(backing: MutableListIterator<T1>, read: (T1) -> T2, val write: (T2) -> T1) : IteratorView<T1, T2, MutableListIterator<T1>>(backing, read), MutableListIterator<T2> {
	override fun add(element: T2) {
		return backing.add(write(element))
	}
	
	override fun set(element: T2) {
		backing.set(write(element))
	}
	
	override fun hasPrevious(): Boolean {
		return backing.hasPrevious()
	}
	
	override fun previous(): T2 {
		return backing.previous().let(read)
	}
	
	override fun nextIndex(): Int {
		return backing.nextIndex()
	}
	
	override fun previousIndex(): Int {
		return backing.previousIndex()
	}
}

open class IteratorView<T1, T2, C : MutableIterator<T1>>(val backing: C, val read: (T1) -> T2) : MutableIterator<T2> {
	override fun hasNext(): Boolean {
		return backing.hasNext()
	}
	
	override fun next(): T2 {
		return read(backing.next())
	}
	
	override fun remove() {
		return backing.remove()
	}
	
	override fun forEachRemaining(action: Consumer<in T2>) {
		return backing.forEachRemaining { action.accept(read(it)) }
	}
}

class MutableListIteratorView<T1, T2>()

open class CollectionView<T1, T2, C : MutableCollection<T1>>(val backing: C, val read: (T1) -> T2, val write: (T2) -> T1) : MutableCollection<T2> {
	override fun add(element: T2): Boolean {
		return backing.add(write(element))
	}
	
	override fun addAll(elements: Collection<T2>): Boolean {
		return backing.addAll(elements.map(write))
	}
	
	override fun clear() {
		backing.clear()
	}
	
	override fun contains(element: T2): Boolean {
		return backing.contains(write(element))
	}
	
	override fun containsAll(elements: Collection<T2>): Boolean {
		return backing.containsAll(elements.map(write))
	}
	
	override fun isEmpty(): Boolean {
		return backing.isEmpty()
	}
	
	override fun iterator(): MutableIterator<T2> {
		return IteratorView(backing.iterator(), read)
	}
	
	override fun remove(element: T2): Boolean {
		return backing.remove(write(element))
	}
	
	override fun removeAll(elements: Collection<T2>): Boolean {
		return backing.removeAll(elements.mapTo(mutableSetOf(), write))
	}
	
	override fun retainAll(elements: Collection<T2>): Boolean {
		return backing.retainAll(elements.mapTo(mutableSetOf(), write))
	}
	
	override val size: Int
		get() = backing.size
}