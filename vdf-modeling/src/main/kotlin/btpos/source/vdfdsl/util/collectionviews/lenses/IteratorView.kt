package btpos.source.vdfdsl.util.collectionviews.lenses

interface IteratorView<T, out OUT> : Iterator<OUT> {
	val backing: () -> Iterator<T>
	
	val read: (T) -> OUT
	
	override fun next(): OUT {
		return backing().next().let(read)
	}
	
	override fun hasNext(): Boolean {
		return backing().hasNext()
	}
	
	companion object {
	    operator fun <T, OUT> invoke(backing: Iterator<T>, read: (T) -> OUT) = invoke({ backing }, read)
		
	    operator fun <T, OUT> invoke(backing: () -> Iterator<T>, read: (T) -> OUT) = object : IteratorView<T, OUT> {
		    override val backing = backing
		    override val read = read
	    }
	}
}