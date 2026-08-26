package btpos.source.vdfdsl.util.collectionviews.utils

/**
 * Create a new list with all elements of [this] except for the element at [index] which will be replaced with the new [element].
 */
fun <T> List<T>.setting(index: Int, element: T): List<T> {
	if (index !in indices)
		throw IndexOutOfBoundsException(index)
	
	return buildList(size + 1) {
		var currIndex = 0
		for (oldElement in this@setting) {
			if (currIndex == index)
				add(element)
			else
				add(oldElement)
			
			++currIndex
		}
	}
}

fun <T> List<T>.adding(index: Int, element: T): List<T> {
	if (index !in 0..size)
		throw IndexOutOfBoundsException(index)
	
	return buildList(size + 1) {
		var currIndex = 0
		for (oldElement in this@adding) {
			add(oldElement)
			
			if (currIndex == index)
				add(element)
			
			++currIndex
		}
	}
}

fun <T> List<T>.adding(index: Int, elements: Iterable<T>): List<T> {
	if (index !in 0..size)
		throw IndexOutOfBoundsException(index)
	
	return buildList(size + 1) {
		var currIndex = 0
		for (oldElement in this@adding) {
			add(oldElement)
			
			if (currIndex == index)
				addAll(elements)
			
			++currIndex
		}
	}
}

fun <T> List<T>.removingAt(index: Int): List<T> {
	if (index !in indices)
		throw IndexOutOfBoundsException(index)
	
	return buildList(size - 1) {
		var currIndex = 0
		for (oldElement in this@removingAt) {
			if (currIndex != index)
				add(oldElement)
			
			++currIndex
		}
	}
}