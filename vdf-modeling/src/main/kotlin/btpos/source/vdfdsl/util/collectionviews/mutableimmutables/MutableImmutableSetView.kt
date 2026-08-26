package btpos.source.vdfdsl.util.collectionviews.mutableimmutables

import kotlin.reflect.KMutableProperty0


/**
 * Exposes the interface of a [MutableSet], but actually replaces the original set on each modification.
 */
abstract class MutableImmutableSetView<T> : MutableSet<T> {
	companion object {
		operator fun <T> invoke(prop: KMutableProperty0<Set<T>>) = invoke(prop::get, prop::set)
		
		operator fun <T> invoke(getList: () -> Set<T>, setList: (Set<T>) -> Unit) = object : MutableImmutableSetView<T>() {
			override var backing: Set<T>
				get() = getList()
				set(value) { setList(value) }
		}
	}
	
	protected abstract var backing: Set<T>
	
	protected open fun makeSet(): Set<T> = setOf()
	
	protected open fun makeSet(size: Int): MutableSet<T> = LinkedHashSet(size)
	
	
	override fun add(element: T): Boolean {
		backing.let { original ->
			val new = makeSet(original.size).also {
				it.addAll(original)
			}
			
			val hasChanged = new.add(element)
			backing = new
			return hasChanged
		}
	}
	
	override fun remove(element: T): Boolean {
		if (element !in backing)
			return false;
		
		backing.let { original ->
			val newSet = makeSet(original.size - 1)
			original.filterNotTo(newSet) { it == element }
			val hasChanged = newSet.size != original.size
			backing = newSet
			return hasChanged
		}
	}
	
	override fun addAll(elements: Collection<T>): Boolean {
		if (elements.isEmpty())
			return false;
		
		backing.let { original ->
			val newSet = makeSet(original.size + elements.size).also {
				it.addAll(original)
				it.addAll(elements)
			}
			val hasChanged = newSet.size != original.size
			backing = newSet
			return hasChanged
		}
	}
	
	
	override fun removeAll(elements: Collection<T>): Boolean {
		backing.let { original ->
			val newSet = makeSet(original.size)
			original.filterTo(newSet) { it !in elements }
			
			val hasChanged = newSet.size != original.size
			backing = newSet
			return hasChanged
		}
	}
	
	override fun retainAll(elements: Collection<T>): Boolean {
		backing.let { original ->
			val newSet = makeSet(original.size)
			original.filterTo(newSet) { it in elements }
			
			val hasChanged = newSet.size != original.size
			backing = newSet
			return hasChanged
		}
	}
	
	override fun clear() {
		backing = makeSet()
	}
	
	override val size: Int
		get() = backing.size
	
	override fun isEmpty() = backing.isEmpty()
	
	override fun contains(element: T) = backing.contains(element)
	
	override fun containsAll(elements: Collection<T>) = backing.containsAll(elements)
	
	override fun iterator(): MutableIterator<T> {
		return object : MutableIterator<T> {
			private var iter = backing.iterator()
			private var lastGot: T? = null
			
			override fun remove() {
				this@MutableImmutableSetView.remove(lastGot)
			}
			
			override fun next() = iter.next().also {
				lastGot = it
			}
			
			override fun hasNext() = iter.hasNext()
		}
	}
}