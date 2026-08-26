package btpos.source.vdfdsl.util.collectionviews.lenses

interface CollectionView<T1, T2> : Collection<T2> {
	val backing: () -> Collection<T1>
	
	private val _backing get() = backing()
	
	val read: (T1) -> T2
	
	val write: (T2) -> T1
	
	override fun contains(element: T2): Boolean {
		return _backing.contains(write(element))
	}
	
	override fun containsAll(elements: Collection<T2>): Boolean {
		return _backing.containsAll(elements.map(write))
	}
	
	override fun isEmpty(): Boolean {
		return _backing.isEmpty()
	}
	
	override fun iterator(): IteratorView<T1, T2> {
		return IteratorView(_backing.iterator(), read)
	}
	
	override val size: Int
		get() = _backing.size
	
	
	companion object {
		operator fun <T1, T2> invoke(backing: Collection<T1>, read: (T1) -> T2, write: (T2) -> T1) = invoke({ backing }, read, write)
		
		operator fun <T1, T2> invoke(backing: () -> Collection<T1>, read: (T1) -> T2, write: (T2) -> T1) = object : CollectionView<T1, T2> {
			override val backing = backing
			override val read = read
			override val write = write
		}
	}
}