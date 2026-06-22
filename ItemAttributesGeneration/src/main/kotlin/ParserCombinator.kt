//package btpos.tf2.popfiledsl
//
//import org.intellij.lang.annotations.Language
//
//
//@JvmInline
//value class Either<L, R>(private val value: Any?) {
//	private class Right(val value: Any?)
//
//	val isLeft
//		get() = !isRight
//
//	val isRight
//		get() = value is Right
//
//	fun leftOrNull() = value.takeIf { isLeft } as L?
//
//	fun rightOrNull() = (value as? Right)?.value as R?
//
//	companion object {
//		fun <L, R> left(item: L) = Either<L, R>(item)
//
//		fun <L, R> right(item: R) = Either<L, R>(Right(item))
//	}
//}
//
//class CopyableStringIterator(val string: String, var currentIndex: Int = 0) : CharIterator() {
//	override fun nextChar(): Char {
//		if (!hasNext()) {
//			throw NoSuchElementException()
//		}
//		return string[currentIndex++]
//	}
//
//	override fun hasNext(): Boolean {
//		return currentIndex < string.length
//	}
//
//	fun copy() = CopyableStringIterator(string, currentIndex)
//}
//
//fun interface Parser<T> {
//	operator fun invoke(input: CopyableStringIterator): Pair<T, CopyableStringIterator>?
//
//	companion object {
//		val empty: Parser<Nothing?> = Parser { null to it }
//
//		fun literal(char: Char): Parser<Char> {
//			return Parser { input ->
//				val nextChar = input.nextChar()
//				if (nextChar == char) {
//					nextChar to input
//				}
//				null
//			}
//		}
//
//		fun regex(@Language("RegExp") pattern: String): Parser<String> {
//			val re = Regex("($pattern)")
//			return Parser {
//				val res = re.matchAt(it.string, it.currentIndex)
//				          ?: return@Parser null;
//
//				return@Parser res.groupValues[0] to CopyableStringIterator(it.string, res.range.last + 1)
//			}
//		}
//	}
//}
//
//infix fun <T> Parser<T>.or(other: Parser<T>): Parser<T> {
//	return Parser { input ->
//		val copy = input.copy()
//		this(input)
//			?: other(copy)
//			?: error("Expected '$this' or '$other' but '$input' was neither.")
//	}
//}
//
//infix fun <T, U> Parser<T>.or(other: Parser<U>): Parser<Either<T, U>> {
//	return Parser { input ->
//		val copy = input.copy()
//		this(input)?.let { Either.left<T, U>(it.first) to it.second }
//			?: other(copy)?.let { Either.right<T, U>(it.first) to it.second }
//			?: error("Expected '$this' or '$other' but '$input' was neither.")
//	}
//}
//
//
//@JvmName("tThenT")
//operator fun <T> Parser<T>.times(next: Parser<T>) : Parser<List<T>> {
//	return Parser { input ->
//		val (fromFirst, remaining1) = this(input) ?: return@Parser null;
//		val (fromSecond, remaining2) = next(remaining1) ?: return@Parser null;
//		listOf(fromFirst, fromSecond) to remaining2
//	}
//}
//@JvmName("tThenList")
//operator fun <T> Parser<T>.times(next: Parser<List<T>>) : Parser<List<T>> {
//	return Parser { input ->
//		val (fromFirst, remaining1) = this(input) ?: return@Parser null;
//		val (fromSecond, remaining2) = next(remaining1) ?: return@Parser null;
//		(listOf(fromFirst) + fromSecond) to remaining2
//	}
//}
//@JvmName("listThenT")
//operator fun <T> Parser<List<T>>.times(next: Parser<T>) : Parser<List<T>> {
//	return Parser { input ->
//		val (fromFirst, remaining1) = this(input) ?: return@Parser null;
//		val (fromSecond, remaining2) = next(remaining1) ?: return@Parser null;
//		(fromFirst + fromSecond) to remaining2
//	}
//}
//@JvmName("listThenList")
//operator fun <T> Parser<List<T>>.times(next: Parser<List<T>>) : Parser<List<T>> {
//	return Parser { input ->
//		val (fromFirst, remaining1) = this(input) ?: return@Parser null;
//		val (fromSecond, remaining2) = next(remaining1) ?: return@Parser null;
//		(fromFirst + fromSecond) to remaining2
//	}
//}
//
//@JvmName("tThenU")
//operator fun <T, U> Parser<T>.times(next: Parser<U>) : Parser<Pair<T, U>> {
//	return Parser { input ->
//		val (fromFirst, remaining1) = this(input) ?: return@Parser null;
//		val (fromSecond, remaining2) = next(remaining1) ?: return@Parser null;
//		(fromFirst to fromSecond) to remaining2
//	}
//}