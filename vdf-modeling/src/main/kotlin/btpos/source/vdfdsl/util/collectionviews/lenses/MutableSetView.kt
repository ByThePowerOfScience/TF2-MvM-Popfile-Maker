package btpos.source.vdfdsl.util.collectionviews.lenses

interface MutableSetView<T1, T2> : MutableSet<T2>, MutableCollectionView<T1, T2>, SetView<T1, T2> {
	override val backing: () -> MutableSet<T1>
	
	override fun add(element: T2) = super.add(element)
	
	override fun remove(element: T2) = super.remove(element)
	
	override fun addAll(elements: Collection<T2>) = super.addAll(elements)
	
	override fun removeAll(elements: Collection<T2>) = super.removeAll(elements)
	
	override fun retainAll(elements: Collection<T2>) = super.retainAll(elements)
	
	override fun clear() = super.clear()
	
	override val size: Int
		get() = super<MutableCollectionView>. size
		        
    override fun isEmpty() = super<MutableCollectionView>.isEmpty()
	
	override fun contains(element: T2) = super<MutableCollectionView>.contains(element)
	
	override fun containsAll(elements: Collection<T2>) = super<MutableCollectionView>.containsAll(elements)
	
	override fun iterator(): MutableIteratorView<T1, T2> = super<MutableCollectionView>.iterator()
	
	companion object {
		operator fun <T1, T2> invoke(backing: MutableSet<T1>, read: (T1) -> T2, write: (T2) -> T1) = invoke({ backing }, read, write)
		
		operator fun <T1, T2> invoke(backing: () -> MutableSet<T1>, read: (T1) -> T2, write: (T2) -> T1) = object : MutableSetView<T1, T2> {
			override val backing = backing
			override val read = read
			override val write = write
		}
	}
}