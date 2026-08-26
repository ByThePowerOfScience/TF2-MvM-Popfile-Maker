package btpos.source.vdfdsl.util.collectionviews.lenses

interface MutableIteratorView<T1, T2> : IteratorView<T1, T2>, MutableIterator<T2> {
	override val backing: () -> MutableIterator<T1>
	
	private val _backing get() = backing()
	
	override fun remove() {
		return _backing.remove()
	}
	
	companion object {
	    operator fun <T, OUT> invoke(backing: MutableIterator<T>, read: (T) -> OUT) = invoke({ backing }, read)
		
		operator fun <T, OUT> invoke(backing: () -> MutableIterator<T>, read: (T) -> OUT): MutableIteratorView<T, OUT> {
	        return object : MutableIteratorView<T, OUT> {
		        override val backing = backing
		        override val read = read
			}
	    }
	}
}