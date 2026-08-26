package btpos.source.vdfdsl.util.collectionviews.lenses

interface MutableCollectionView<T1, T2>
	: MutableCollection<T2>, CollectionView<T1, T2>
{
	override val backing: () -> MutableCollection<T1>
	
	private val _backing get() = backing()
	
	override fun add(element: T2): Boolean {
		return _backing.add(write(element))
	}
	
	override fun addAll(elements: Collection<T2>): Boolean {
		return _backing.addAll(elements.map(write))
	}
	
	override fun clear() {
		_backing.clear()
	}
	
	override fun remove(element: T2): Boolean {
		return _backing.remove(write(element))
	}
	
	override fun removeAll(elements: Collection<T2>): Boolean {
		return _backing.removeAll(elements.mapTo(mutableSetOf(), write))
	}
	
	override fun retainAll(elements: Collection<T2>): Boolean {
		return _backing.retainAll(elements.mapTo(mutableSetOf(), write))
	}
	
	override fun iterator(): MutableIteratorView<T1, T2> {
		return MutableIteratorView(_backing.iterator(), read)
	}
	
	companion object {
		operator fun <T1, T2> invoke(backing: MutableCollection<T1>, read: (T1) -> T2, write: (T2) -> T1) = invoke({ backing }, read, write)
		operator fun <T1, T2> invoke(backing: () -> MutableCollection<T1>, read: (T1) -> T2, write: (T2) -> T1) = object : MutableCollectionView<T1, T2> {
			override val backing = backing
			override val read = read
			override val write = write
		}
	}
}