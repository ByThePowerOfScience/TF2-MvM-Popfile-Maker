package btpos.source.vdfdsl.util.collectionviews.lenses

interface ListView<T1, T2>
	: List<T2>, CollectionView<T1, T2>
{
	override val backing: () -> List<T1>
	
	private val _backing get() = backing()
	
	override fun get(index: Int): T2 {
		return _backing[index].let(read)
	}
	
	override fun indexOf(element: T2): Int {
		return _backing.indexOf(write(element))
	}
	
	override fun lastIndexOf(element: T2): Int {
		return _backing.lastIndexOf(write(element))
	}
	
	override fun listIterator(): ListIterator<T2> {
		return ListIteratorView(_backing.listIterator(), read)
	}
	
	override fun listIterator(index: Int): ListIterator<T2> {
		return ListIteratorView(_backing.listIterator(index), read)
	}
	
	override fun subList(fromIndex: Int, toIndex: Int): List<T2> {
		return ListView(_backing.subList(fromIndex, toIndex), read, write)
	}
	
	override fun iterator(): IteratorView<T1, T2> {
		return super.iterator()
	}
	
	override val size: Int get() = super.size
	
	override fun isEmpty() = super.isEmpty()
	
	override fun contains(element: T2) = super.contains(element)
	
	override fun containsAll(elements: Collection<T2>) = super.containsAll(elements)
	
	
	companion object {
		operator fun <T1, T2> invoke(backing: List<T1>, read: (T1) -> T2, write: (T2) -> T1) = invoke({ backing }, read, write)
		
		operator fun <T1, T2> invoke(backing: () -> List<T1>, read: (T1) -> T2, write: (T2) -> T1) = object : ListView<T1, T2> {
			override val backing = backing
			override val read = read
			override val write = write
		}
	}
}


