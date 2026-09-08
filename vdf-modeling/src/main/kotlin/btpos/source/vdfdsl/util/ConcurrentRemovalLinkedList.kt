package btpos.source.vdfdsl.util

import kotlin.reflect.jvm.javaField

/**
 * A linkedlist that allows you to remove elements from a separate iterator without affecting the current iterator.
 */
class ConcurrentRemovalLinkedList<T>() : MutableCollection<T> {
	private inner class Node(val value: T, var next: Node?) {
		var isRemoved = false
		
		fun getNextInChain(): Node? {
			var n = next
			while (n != null && n.isRemoved) {
				n = n.next
			}
			this.next = n // skip removed items permanently
			return n
		}
	}
	private var head: Node? = null
		get() {
			if (field?.isRemoved == true)
				field = field?.getNextInChain()
			
			return field
		}
		set(value) {
			if (field == null) {
				tail = value // works for both "setting both to null" AND "creating the first element"
			}
			field = value
		}
	
	/**
	 * Semi-lazy property that caches the current last element of this singly-linked list.
	 *
	 * Should **only** be modified by [head] and its own getter. Do not call the setter anywhere else.
	 */
	private var tail: Node? = null
		get() {
			fun calcTail(from: Node?): Node? {
				var curr: Node? = from ?: return null;
				var lastNotRemoved: Node? = null
				while (curr != null && curr.next != null) {
					if (!curr.isRemoved)
						lastNotRemoved = curr
					
					curr = curr.getNextInChain()
				}
				return lastNotRemoved
			}
			// yes I KNOW this isn't linearizable but I am NOT multithreading this shit so I DO NOT CARE
			field?.let {
				if (it.isRemoved) {
					val n = it.getNextInChain()
					if (n == null)
						field = calcTail(head)
					else
						field = n
				} else if (it.next != null) {
					field = calcTail(it)
				}
			} ?: run {
				field = calcTail(head)
			}
			
			return field;
		}
	
	
	constructor(original: Iterable<T>) : this() {
		original.toList().asReversed().forEach(::addHead)
	}
	
	
	
	override val size: Int
		get() {
			var count = 0
			forEachNonRemovedElement {
				++count
			}
			return count;
		}
	
	private inline fun forEachNonRemovedElement(action: (Node) -> Unit) {
		if (head == null)
			return;
		
		var curr = head
		while (curr != null) {
			if (!curr.isRemoved) {
				action(curr)
			}
			curr = curr.getNextInChain()
		}
	}
	
	
	override fun iterator(): MutableIterator<T> {
		return TMutableIterator(head)
	}
	
	private inner class TMutableIterator(start: Node?) : MutableIterator<T> {
		private var prev: Node? = null
		private var next: Node? = start
		
		override fun hasNext(): Boolean {
			val n = next
			        ?: return false;
			
			if (n.isRemoved)
				next = n.getNextInChain()
			
			return next != null
		}
		
		override fun next(): T {
			var n = next ?: throw NoSuchElementException()
			if (n.isRemoved) {
				n = n.getNextInChain() ?: throw ConcurrentModificationException("Items removed on another thread between the hasNext() call and next() call.")
			}
			next = n.getNextInChain()
			prev = n
			return n.value
		}
		
		override fun remove() {
			prev?.let { it.isRemoved = true } ?: throw NoSuchElementException("next() has not been called")
		}
	}
	
	
	override fun contains(element: T): Boolean {
		return this.any { it == element }
	}
	
	override fun containsAll(elements: Collection<T>): Boolean {
		val found = HashSet(elements)
		this.forEach {
			found.remove(it)
		}
		return found.isEmpty()
	}
	
	override fun isEmpty(): Boolean {
		return size == 0
	}
	
	
	/**
	 * @return the newly created node
	 */
	private fun Node.addAfter(element: T): Node {
		return Node(element, this.next).also {
			this.next = it
		}
	}
	
	private fun createFirstNode(element: T): Node {
		return Node(element, null).also {
			head = it
		}
	}
	
	
	private fun _addTail(element: T): Node {
		return tail?.addAfter(element) ?: createFirstNode(element)
	}
	
	private fun addHead(element: T): Node {
		return Node(element, head).also {
			head = it
		}
	}
	
	override fun add(element: T): Boolean {
		_addTail(element)
		return true;
	}
	
	override fun addAll(elements: Collection<T>): Boolean {
		if (elements.isEmpty())
			return false;
		
		elements.forEach(::_addTail)
		return true;
	}
	
	override fun clear() {
		head = null
	}
	
	override fun remove(element: T): Boolean {
		forEachNonRemovedElement {
			if (it.value == element) {
				it.isRemoved = true
				return true;
			}
		}
		return false;
	}
	
	override fun removeAll(elements: Collection<T>): Boolean {
		if (elements.isEmpty())
			return false;
		
		var haveRemoved = false
		forEachNonRemovedElement {
			if (it.value in elements) {
				it.isRemoved = true
				haveRemoved = true
			}
		}
		return haveRemoved
	}
	
	override fun retainAll(elements: Collection<T>): Boolean {
		if (elements.isEmpty())
			return false;
		
		var haveRemoved = false
		forEachNonRemovedElement {
			if (it.value !in elements) {
				it.isRemoved = true
				haveRemoved = true
			}
		}
		return haveRemoved
	}
}