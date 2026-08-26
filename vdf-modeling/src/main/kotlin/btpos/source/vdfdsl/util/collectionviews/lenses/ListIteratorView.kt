package btpos.source.vdfdsl.util.collectionviews.lenses

interface ListIteratorView<T, out OUT>
	: IteratorView<T, OUT>, ListIterator<OUT>
{
	override val backing: () -> ListIterator<T>
	
	private val _backing get() = backing()
	
	override fun next() = super.next()
	
	override fun hasNext() = super.hasNext()
	
	override fun hasPrevious() = _backing.hasPrevious()
	
	override fun previous() = _backing.previous().let(read)
	
	override fun nextIndex() = _backing.nextIndex()
	
	override fun previousIndex() = _backing.previousIndex()
	
	companion object {
	    operator fun <T1, T2> invoke(backing: ListIterator<T1>, read: (T1) -> T2) = invoke({ backing }, read)
		
	    operator fun <T1, T2> invoke(backing: () -> ListIterator<T1>, read: (T1) -> T2): ListIteratorView<T1, T2> {
	        return object : ListIteratorView<T1, T2> {
		        override val backing = backing
		        override val read = read
	        }
	    }
	}
}