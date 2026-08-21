package btpos.source.vdfdsl.util

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

inline fun <T> MutableCollection<T>.forEachWithIter(action: MutableIterator<T>.(T) -> Unit) {
	val liter = this.iterator()
	
	for (el in liter) {
		liter.action(el)
	}
}

@OptIn(ExperimentalContracts::class)
inline fun <T, C : Collection<T>> C.ifNotEmpty(action: (C) -> Unit): C {
	contract {
		callsInPlace(action, InvocationKind.AT_MOST_ONCE)
	}
	if (this.isNotEmpty())
		action(this)
	
	return this;
}

@OptIn(ExperimentalContracts::class)
inline fun <T, C : Collection<T>> C?.ifNullOrEmpty(action: () -> C?): C? {
	contract {
		callsInPlace(action, InvocationKind.AT_MOST_ONCE)
	}
	if (this.isNullOrEmpty())
		return action()
	
	return this;
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T> ArrayList<T>.compacted(): ArrayList<T> = apply {
	trimToSize()
}

/**
 * Maps the thing in place, but uses either an empty list or single-element list if possible
 */
inline fun <T, U> Collection<T>.mapCompact(mapper: (T) -> U): List<U> {
	return when (this.size) {
		0 -> emptyList()
		1 -> listOf(mapper(this.first()))
		else -> mapTo(ArrayList(size), mapper)
	}
}

/**
 * Optimize a read-only list using the emptylist singleton or a single-item-optimized list object
 */
fun <T> List<T>.compactIfPossible(): List<T> {
	return when (this.size) {
		0 -> emptyList()
		1 -> listOf(this[0])
		else if this is ArrayList<T> -> this.compacted()
		else -> this
	}
}

fun Iterable<*>.collectionSizeOrDefault(default: Int) = if (this is Collection<*>) size else default