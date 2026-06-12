package btpos.tf2.popfiledsl.utils

fun <T> List<T>.setting(index: Int, element: T): List<T> {
	if (index !in indices)
		throw IndexOutOfBoundsException()
	
	return buildList(size) {
		addAll(this@setting.subList(0, index))
		add(element)
		addAll(this@setting.subList(index + 1, size))
	}
}

fun <T> List<T>.adding(index: Int, element: T): List<T> {
	return buildList(size + 1) {
		addAll(this@adding.subList(0, index))
		add(element)
		addAll(this@adding.subList(index, size))
	}
}

fun <T> List<T>.removingAt(index: Int): List<T> {
	return buildList(size - 1) {
		addAll(this@removingAt.subList(0, index))
		addAll(this@removingAt.subList(index + 1, size))
	}
}