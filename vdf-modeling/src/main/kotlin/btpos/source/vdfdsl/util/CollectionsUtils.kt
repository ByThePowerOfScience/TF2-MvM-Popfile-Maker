package btpos.source.vdfdsl.util

inline fun <T> MutableCollection<T>.forEachWithIter(action: MutableIterator<T>.(T) -> Unit) {
	val liter = this.iterator()
	
	for (el in liter) {
		liter.action(el)
	}
}