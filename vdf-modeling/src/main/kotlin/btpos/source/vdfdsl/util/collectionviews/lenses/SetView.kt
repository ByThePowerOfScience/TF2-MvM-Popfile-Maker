package btpos.source.vdfdsl.util.collectionviews.lenses

interface SetView<T1, T2> : Set<T2>, CollectionView<T1, T2> {
	override val backing: () -> Set<T1>
	
	override val size: Int get() = super.size
	
	override fun isEmpty() = super.isEmpty()
	
	override fun contains(element: T2) = super.contains(element)
	
	override fun iterator() = super.iterator()
	
	override fun containsAll(elements: Collection<T2>) = super.containsAll(elements)
	
	companion object {
		operator fun <T1, T2> invoke(backing: Set<T1>, read: (T1) -> T2, write: (T2) -> T1) = invoke({ backing }, read, write)
		
		operator fun <T1, T2> invoke(backing: () -> Set<T1>, read: (T1) -> T2, write: (T2) -> T1) = object : SetView<T1, T2> {
			override val backing = backing
			override val read = read
			override val write = write
		}
	}
}