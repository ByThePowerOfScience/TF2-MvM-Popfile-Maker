package btpos.source.vdfdsl.util.collectionviews.lenses

interface MutableListView<T1, T2>
	: MutableList<T2>, ListView<T1, T2>
{
	override val backing: () -> MutableList<T1>
	
	
	private val _backing get() = backing()
	
	override fun add(index: Int, element: T2) {
		return _backing.add(index, write(element))
	}
	
	override fun add(element: T2): Boolean {
		return _backing.add(write(element))
	}
	
	override fun remove(element: T2): Boolean {
		return _backing.remove(write(element))
	}
	
	override fun addAll(elements: Collection<T2>): Boolean {
		return _backing.addAll(elements.map(write))
	}
	
	override fun addAll(index: Int, elements: Collection<T2>): Boolean {
		return _backing.addAll(index, elements.map(write))
	}
	
	override fun removeAll(elements: Collection<T2>): Boolean {
		return _backing.removeAll(elements.map(write))
	}
	
	override fun retainAll(elements: Collection<T2>): Boolean {
		return _backing.retainAll(elements.map(write))
	}
	
	override fun clear() {
		return _backing.clear()
	}
	
	override fun removeAt(index: Int): T2 {
		return _backing.removeAt(index).let(read)
	}
	
	override fun set(index: Int, element: T2): T2 {
		return _backing.set(index, write(element)).let(read)
	}
	
	override fun iterator(): MutableListIteratorView<T1, T2> {
		return listIterator()
	}
	
	override fun listIterator(): MutableListIteratorView<T1, T2> {
		return MutableListIteratorView(_backing.listIterator(), read, write)
	}
	
	override fun listIterator(index: Int): MutableListIterator<T2> {
		return MutableListIteratorView(_backing.listIterator(index), read, write)
	}
	
	override fun subList(fromIndex: Int, toIndex: Int): MutableList<T2> {
		return MutableListView(_backing.subList(fromIndex, toIndex), read, write)
	}
	
	companion object {
		operator fun <T1, T2> invoke(backing: MutableList<T1>, read: (T1) -> T2, write: (T2) -> T1) = invoke({ backing }, read, write)
		
		operator fun <T1, T2> invoke(backing: () -> MutableList<T1>, read: (T1) -> T2, write: (T2) -> T1) = object : MutableListView<T1, T2> {
			override val backing = backing
			override val read = read
			override val write = write
		}
	}
}