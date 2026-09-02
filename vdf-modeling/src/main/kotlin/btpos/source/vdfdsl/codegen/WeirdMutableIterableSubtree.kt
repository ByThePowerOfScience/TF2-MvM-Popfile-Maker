package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFSubtree

/**
 * // idea: a singly-linked list where items can be removed from anywhere without affecting iteration order
 * 	// We mark each node as "in the list" if it's still there or "not in the list" if it's been removed.
 * 	// Since no elements can be added, only removed, we just skip over anything that's been removed
 * 	//      until we find the next item that's actually in the list and relink ourselves to that one
 *
 */
class WeirdMutableIterableSubtree(
	val parent: WeirdMutableIterableSubtree?,
	private val original: VDFSubtree
) : MutableIterable<VDFKeyValue>, Collection<VDFKeyValue> {
	
	private inner class Node(val value: VDFKeyValue, private var next: Node?) {
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
	
	override val size: Int
		get() {
			if (head == null)
				return 0;
			
			var count = 0
			var curr = head
			while (curr != null) {
				if (!curr.isRemoved)
					++count
				curr = curr.getNextInChain()
			}
			
			return count;
		}
	
	init {
		original.asReversed().forEach {
			head = Node(it, head)
		}
	}
	
	override fun iterator(): MutableIterator<VDFKeyValue> {
		head?.let {
			if (it.isRemoved)
				head = it.getNextInChain()
		}
		
		return object : MutableIterator<VDFKeyValue> {
			private var prev: Node? = null
			private var next = head
			
			override fun hasNext(): Boolean {
				val n = next
				        ?: return false;
				
				if (n.isRemoved)
					next = n.getNextInChain()
				
				return next != null
			}
			
			override fun next(): VDFKeyValue {
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
	}
	
	
	override fun contains(element: VDFKeyValue): Boolean {
		return this.any { it == element }
	}
	
	override fun containsAll(elements: Collection<VDFKeyValue>): Boolean {
		val found = HashSet(elements)
		this.forEach {
			found.remove(it)
		}
		return found.isEmpty()
	}
	
	override fun isEmpty(): Boolean {
		return size == 0
	}
	
	inline fun forEachWithLazyIter(action: MutableIterator<VDFKeyValue>.(VDFKeyValue) -> Unit) {
		val iter = this.iterator()
		for (el in iter) {
			iter.action(el)
		}
	}
	
	fun getRoot(): WeirdMutableIterableSubtree {
		var curr = this
		while (true) {
			curr = curr.parent
			       ?: return curr;
		}
	}
	
	fun toSubtree(): VDFSubtree {
		return VDFSubtree(parent?.original, this.toMutableList())
	}
}