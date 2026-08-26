package btpos.source.vdfdsl.util.collectionviews.lenses

interface MutableListIteratorView<T1, T2>
	: MutableIteratorView<T1, T2>, ListIteratorView<T1, T2>, MutableListIterator<T2>
{
	override val backing: () -> MutableListIterator<T1>
	
	val write: (T2) -> T1
	
	
	
	private val _backing get() = backing()
	
	override fun add(element: T2) {
		return _backing.add(write(element))
	}
	
	override fun next() = super<ListIteratorView>.next()
	
	override fun hasNext() = super<ListIteratorView>.hasNext()
	
	override fun remove() = super.remove()
	
	override fun set(element: T2) {
		_backing.set(write(element))
	}
	
	override fun hasPrevious(): Boolean {
		return _backing.hasPrevious()
	}
	
	override fun previous(): T2 {
		return _backing.previous().let(read)
	}
	
	override fun nextIndex(): Int {
		return _backing.nextIndex()
	}
	
	override fun previousIndex(): Int {
		return _backing.previousIndex()
	}
	
	companion object {
		operator fun <T1, T2> invoke(backing: MutableListIterator<T1>, read: (T1) -> T2, write: (T2) -> T1) = invoke({ backing }, read, write)
		
		operator fun <T1, T2> invoke(backing: () -> MutableListIterator<T1>, read: (T1) -> T2, write: (T2) -> T1) = object : MutableListIteratorView<T1, T2> {
			override val backing = backing
			override val read = read
			override val write = write
		}
	}
}