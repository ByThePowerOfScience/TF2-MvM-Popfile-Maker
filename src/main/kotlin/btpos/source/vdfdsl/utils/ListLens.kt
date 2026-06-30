package btpos.source.vdfdsl.utils

class ListLens<INNER, EXPOSED>(val backingList: MutableList<INNER>, val reader: (INNER) -> EXPOSED, val writer: (EXPOSED) -> INNER) : MutableList<EXPOSED> {
	override fun add(element: EXPOSED) = backingList.add(writer(element))
	
	override fun remove(element: EXPOSED) = backingList.remove(writer(element))
	
	override fun addAll(elements: Collection<EXPOSED>) = backingList.addAll(elements.map(writer))
	
	override fun addAll(index: Int, elements: Collection<EXPOSED>) = backingList.addAll(index, elements.map(writer))
	
	override fun removeAll(elements: Collection<EXPOSED>) = backingList.removeAll(elements.map(writer))
	
	override fun retainAll(elements: Collection<EXPOSED>) = backingList.retainAll(elements.map(writer))
	
	override fun clear() = backingList.clear()
	
	override fun set(index: Int, element: EXPOSED) = reader(backingList.set(index, writer(element)))
	
	override fun add(index: Int, element: EXPOSED) = backingList.add(index, writer(element))
	
	override fun removeAt(index: Int) = reader(backingList.removeAt(index))
	
	
	inner class TransformingIterator(startIndex: Int = 0) : MutableListIterator<EXPOSED> {
		val innerIter = backingList.listIterator(startIndex)
		
		override fun next() = reader(innerIter.next())
		
		override fun hasNext() = innerIter.hasNext()
		
		override fun remove() = innerIter.remove()
		
		override fun set(element: EXPOSED) = innerIter.set(writer(element))
		
		override fun add(element: EXPOSED) = innerIter.add(writer(element))
		
		override fun hasPrevious() = innerIter.hasPrevious()
		
		override fun previous() = reader(innerIter.previous())
		
		override fun nextIndex() = innerIter.nextIndex()
		
		override fun previousIndex() = innerIter.previousIndex()
	}
	
	override fun listIterator() = TransformingIterator()
	
	override fun listIterator(index: Int) = TransformingIterator(index)
	
	override fun subList(fromIndex: Int, toIndex: Int) = ListLens(backingList.subList(fromIndex, toIndex), reader, writer)
	
	override val size: Int
		get() = backingList.size
	
	override fun isEmpty() = backingList.isEmpty()
	
	override fun contains(element: EXPOSED) = backingList.contains(writer(element))
	
	override fun containsAll(elements: Collection<EXPOSED>) = backingList.containsAll(elements.map(writer))
	
	override fun get(index: Int) = reader(backingList.get(index))
	
	override fun indexOf(element: EXPOSED) = backingList.indexOf(writer(element))
	
	override fun lastIndexOf(element: EXPOSED) = backingList.lastIndexOf(writer(element))
	
	override fun iterator() = TransformingIterator()
}