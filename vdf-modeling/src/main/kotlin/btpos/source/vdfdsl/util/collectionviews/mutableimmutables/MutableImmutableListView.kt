package btpos.source.vdfdsl.util.collectionviews.mutableimmutables

import btpos.source.vdfdsl.util.collectionviews.utils.adding
import btpos.source.vdfdsl.util.collectionviews.utils.removingAt
import btpos.source.vdfdsl.util.collectionviews.utils.setting
import sun.security.jca.ProviderList.newList
import kotlin.reflect.KMutableProperty0

/**
 * Exposes the interface of a [MutableList], but actually replaces the original list.
 */
abstract class MutableImmutableListView<T> : MutableList<T> {
	companion object {
	    operator fun <T> invoke(prop: KMutableProperty0<List<T>>) = invoke(prop::get, prop::set)
		
	    operator fun <T> invoke(getList: () -> List<T>, setList: (List<T>) -> Unit) = object : MutableImmutableListView<T>() {
		    override var list: List<T>
			    get() = getList()
			    set(value) { setList(value) }
	    }
	}
	
	protected abstract var list: List<T>
	
	protected open fun makeList(): List<T> = listOf()
	
	protected open fun makeList(size: Int): MutableList<T> = ArrayList(size)
	
	override fun add(element: T): Boolean {
		list.let { original ->
			val newList = makeList(original.size + 1).also {
				it.addAll(original)
				it.add(element)
			}
			list = newList
			return newList.size > original.size
		}
	}
	
	override fun remove(element: T): Boolean {
		list.let { original ->
			val newList = makeList(original.size - 1)
			
			var hasTaken = false
			original.forEach {
				if (!hasTaken && it == element) {
					hasTaken = true
				} else {
					newList.add(it)
				}
			}
			
			return hasTaken
		}
	}
	
	override fun addAll(elements: Collection<T>): Boolean {
		list.let { original ->
			val newList = makeList(original.size + elements.size).also {
				it.addAll(original)
				it.addAll(elements)
			}
			list = newList
			return newList.size > original.size
		}
	}
	
	override fun addAll(index: Int, elements: Collection<T>): Boolean {
		list.let { original ->
			if (index !in original.indices)
				throw IndexOutOfBoundsException(index)
			
			val newList = makeList(original.size + elements.size)
			
			original.forEachIndexed { currentIndex, el ->
				newList.add(el)
				
				if (currentIndex == index) {
					newList.addAll(elements)
				}
			}
			
			list = newList
			
			return newList.size > original.size
		}
	}
	
	override fun removeAll(elements: Collection<T>): Boolean {
		list.let { original ->
			val newList = makeList(original.size)
			original.filterNotTo(newList) { it in elements }
			
			list = newList
			
			return newList.size < original.size
		}
	}
	
	override fun retainAll(elements: Collection<T>): Boolean {
		list.let { original ->
			val newList = makeList(original.size)
			original.filterTo(newList) { it in elements }
			
			list = newList
			
			return newList.size < original.size
		}
	}
	
	override fun clear() {
		list = makeList()
	}
	
	override fun set(index: Int, element: T): T {
		list.let { original ->
			if (index !in original.indices)
				throw IndexOutOfBoundsException(index)
			
			val newList = makeList(original.size)
			
			var oldElement: T? = null
			
			original.forEachIndexed { currIndex, el ->
				if (currIndex == index) {
					oldElement = el
					newList.add(element)
				}
				else
					newList.add(el)
				
			}
			
			list = newList
			
			return oldElement as T
		}
	}
	
	override fun add(index: Int, element: T) {
		list.let { original ->
			if (index !in 0..original.size)
				throw IndexOutOfBoundsException(index)
			
			val newList = makeList(original.size + 1)
			
			original.forEachIndexed { currentIndex, el ->
				newList.add(el)
				
				if (currentIndex == index) {
					newList.add(element)
				}
			}
			
			list = newList
		}
	}
	
	override fun removeAt(index: Int): T {
		list.let { original ->
			if (index !in original.indices)
				throw IndexOutOfBoundsException(index)
			
			val newList = makeList(original.size - 1)
			
			var fromIndex: T? = null
			
			original.forEachIndexed { currentIndex, el ->
				if (currentIndex != index) {
					newList.add(el)
				} else {
					fromIndex = el
				}
			}
			
			list = newList
			
			return fromIndex as T
		}
	}
	
	
	
	override fun listIterator(): MutableListIterator<T> {
		return listIterator(0)
	}
	
	override fun listIterator(index: Int): MutableListIterator<T> {
		return LIter(index, this)
	}
	
	open class LIter<T>(startIndex: Int, protected val outer: MutableImmutableListView<T>) : MutableListIterator<T> {
		protected var backingIter = outer.list.listIterator(startIndex)
		
		protected var currentIndex = startIndex - 1
		
		override fun add(element: T) {
			outer.add(currentIndex, element)
			backingIter = outer.list.listIterator(currentIndex)
		}
		
		override fun hasNext(): Boolean {
			return backingIter.hasNext()
		}
		
		override fun next(): T {
			++currentIndex
			return backingIter.next()
		}
		
		override fun hasPrevious(): Boolean {
			return backingIter.hasPrevious()
		}
		
		override fun nextIndex(): Int {
			return backingIter.nextIndex()
		}
		
		override fun previous(): T {
			--currentIndex
			return backingIter.previous()
		}
		
		override fun previousIndex(): Int {
			return backingIter.previousIndex()
		}
		
		override fun remove() {
			outer.removeAt(currentIndex)
			backingIter = outer.list.listIterator(currentIndex)
		}
		
		override fun set(element: T) {
			outer[currentIndex] = element
			backingIter = outer.list.listIterator(currentIndex)
		}
	}
	
	override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
		return MutableImmutableListView({
			list.subList(fromIndex, toIndex)
		}, { newList ->
			val currList = list
			list = makeList(currList.size - (toIndex - fromIndex) + newList.size).apply {
				var haveDeposited = false
				
				currList.forEachIndexed { currIndex, el ->
					if (currIndex !in fromIndex..<toIndex) {
						add(el)
					} else if (!haveDeposited) {
						addAll(newList)
						haveDeposited = true
					}
				}
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
		return listIterator()
	}
}