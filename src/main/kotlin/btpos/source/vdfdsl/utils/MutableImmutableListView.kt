package btpos.source.vdfdsl.utils

/**
 * Exposes the interface of a [MutableList], but actually replaces the original list atomically.
 */
class MutableImmutableListView<T> (
	private val getList: () -> List<T>,
	private val setList: (List<T>) -> Unit
) : MutableList<T> {
	private var list: List<T>
		get() = getList()
		set(value) = setList(value)
	
	override fun add(element: T): Boolean {
		list = list + element
		return true
	}
	
	override fun remove(element: T): Boolean {
		val hadItem = list.contains(element)
		list = list - element
		return hadItem
	}
	
	override fun addAll(elements: Collection<T>): Boolean {
		if (elements.isEmpty())
			return false
		list += elements
		
		return true
	}
	
	override fun addAll(index: Int, elements: Collection<T>): Boolean {
		if (index !in indices) {
			throw IndexOutOfBoundsException()
		}
		
		if (elements.isEmpty())
			return false;
		
		val currentList = list
		list = buildList(size + elements.size) {
			addAll(currentList.subList(0, index))
			addAll(elements)
			addAll(currentList.subList(index, size))
		}
		return true
	}
	
	override fun removeAll(elements: Collection<T>): Boolean {
		return list.run {
			val oldSize = size
			
			val newList = filter { it in elements }
			
			list = newList
			
			oldSize != newList.size
		}
	}
	
	override fun retainAll(elements: Collection<T>): Boolean {
		return list.run {
			val oldSize = size
			
			val newList = filter { it !in elements }
			
			list = newList
			
			oldSize != newList.size
		}
	}
	
	override fun clear() {
		list = listOf()
	}
	
	
	
	override fun set(index: Int, element: T): T {
		return list.run {
			val old = get(index)
			list = setting(index, element)
			old
		}
	}
	
	override fun add(index: Int, element: T) {
		list = list.adding(index, element)
	}
	
	override fun removeAt(index: Int): T {
		return list.run {
			val old = get(index)
			list = removingAt(index)
			old
		}
	}
	
	
	
	override fun listIterator(): MutableListIterator<T> {
		TODO("Not yet implemented")
	}
	
	override fun listIterator(index: Int): MutableListIterator<T> {
		TODO("Not yet implemented")
	}
	
	override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
		return MutableImmutableListView({
			list.subList(fromIndex, toIndex)
		}, { newList ->
			val currList = list
			list = buildList {
				addAll(currList.take(fromIndex - 1))
				addAll(newList)
				addAll(currList.takeLast(currList.size - toIndex))
			}
		})
	}
	
	override val size: Int
		get() = list.size
	
	override fun isEmpty() = list.isEmpty()
	
	override fun contains(element: T) = list.contains(element)
	
	override fun containsAll(elements: Collection<T>) = list.containsAll(elements)
	
	override fun get(index: Int) = list[index]
	
	override fun indexOf(element: T) = list.indexOf(element)
	
	override fun lastIndexOf(element: T) = list.lastIndexOf(element)
	
	override fun iterator(): MutableIterator<T> {
		TODO("Not yet implemented")
	}
	
	inner class Iterator : MutableListIterator<T> {
		override fun next(): T {
			TODO("Not yet implemented")
		}
		
		override fun hasNext(): Boolean {
			TODO("Not yet implemented")
		}
		
		override fun remove() {
			TODO("Not yet implemented")
		}
		
		override fun set(element: T) {
			TODO("Not yet implemented")
		}
		
		override fun add(element: T) {
			TODO("Not yet implemented")
		}
		
		override fun hasPrevious(): Boolean {
			TODO("Not yet implemented")
		}
		
		override fun previous(): T {
			TODO("Not yet implemented")
		}
		
		override fun nextIndex(): Int {
			TODO("Not yet implemented")
		}
		
		override fun previousIndex(): Int {
			TODO("Not yet implemented")
		}
		
	}
}