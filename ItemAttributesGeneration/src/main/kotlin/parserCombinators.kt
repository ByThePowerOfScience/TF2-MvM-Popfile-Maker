package btpos.tf2.popfiledsl.itemattributesgenerator


import kotlin.collections.plus

sealed class Either<L, R> {
	val left: L?
		get() = (this as? Left)?.value
	
	val right: R?
		get() = (this as? Right)?.value
}

class Left<L, R>(val value: L) : Either<L, R>()
class Right<L, R>(val value: R) : Either<L, R>()

fun String.immutableIterator() = CopyableStringIterator(this, 0)

class CopyableStringIterator(val string: String, val currentIndex: Int) {
	data class NextChar(val char: Char, val nextIter: CopyableStringIterator)
	
	fun hasNext() = currentIndex < string.length
	
	fun next() = NextChar(string[currentIndex], CopyableStringIterator(string, currentIndex + 1))
	
	override fun toString(): String {
		return if (currentIndex in string.indices) string.substring(currentIndex) else ""
	}
}

fun interface Parser<T> {
	/**
	 * @return The item with the next part of the string to be parsed, or null if it failed to match.
	 */
	operator fun invoke(iter: CopyableStringIterator): Pair<T, CopyableStringIterator>?
	
	companion object {
		fun literal(c: Char) = LiteralParser(c)
		
		val empty: Parser<Nothing?> = Parser { iter ->
			null to iter
		}.named("λ")
		
		class LiteralParser(val literal: Char) : Parser<Char> {
			override fun invoke(iter: CopyableStringIterator): Pair<Char, CopyableStringIterator>? {
				if (!iter.hasNext())
					return debug_eof();
				val nextIter = iter.next()
				if (nextIter.char == literal)
					return literal to nextIter.nextIter;
				return null;
			}
			
			override fun toString(): String {
				return when (literal) {
					'-', '$', '|', '[', ']', '{', '}', '(', ')', '^' -> "\\$literal"
					else -> literal.toString()
				}
			}
		}
		
		class StringParser(val stringToMatchAgainst: String) : Parser<String> {
			override fun invoke(iter: CopyableStringIterator): Pair<String, CopyableStringIterator>? {
				var currentIter = iter
				for (c in stringToMatchAgainst) {
					if (!currentIter.hasNext())
						return debug_eof()
					
					val (nextChar, nextIter) = currentIter.next()
					if (nextChar != c)
						return null;
					
					currentIter = nextIter
				}
				return stringToMatchAgainst to currentIter
			}
			
			override fun toString(): String {
				return "(?:$stringToMatchAgainst)"
			}
		}
		
		fun string(s: String) = StringParser(s)
		
		class ThunkParser<T>(val deferred: () -> Parser<T>) : Parser<T> {
			override fun invoke(iter: CopyableStringIterator): Pair<T, CopyableStringIterator>? {
				return deferred()(iter)
			}
			
			override fun toString(): String {
				return deferred().toString()
			}
		}
		
		fun <T> (() -> Parser<T>).thunk() = ThunkParser(this)
		
		private data class OrParser_Either<T, U>(val x: Parser<T>, val y: Parser<U>) : Parser<Either<T, U>> {
			override fun invoke(iter: CopyableStringIterator): Pair<Either<T, U>, CopyableStringIterator>? {
				return x(iter)?.run { Left<T, U>(first) to second }
				       ?: y(iter)?.run { Right<T, U>(first) to second }
				       ?: debug_fail()
			}
			
			override fun toString(): String {
				return "(?:$x|$y)"
			}
		}
		
		private data class OrParser<T>(val x: Parser<T>, val y: Parser<T>) : Parser<T> {
			override fun invoke(iter: CopyableStringIterator): Pair<T, CopyableStringIterator>? {
				return x(iter)
				       ?: y(iter)
				       ?: debug_fail()
			}
			
			override fun toString(): String {
				return "(?:$x|$y)"
			}
		}
		
		private fun debug_fail(): Nothing? {
			return null
		}
		
		private fun debug_eof(): Nothing? {
			return null
		}
		
		@JvmName("parserOrEither")
		infix fun <T, U> Parser<T>.or(other: Parser<U>) : Parser<Either<T, U>> {
			return OrParser_Either(this, other)
		}
		
		infix fun <T> Parser<T>.or(other: Parser<T>) : Parser<T> {
			return OrParser(this, other)
		}
		
		private data class MapParser<T, U>(val parser: Parser<T>, val mapper: (T) -> U) : Parser<U> {
			override fun invoke(iter: CopyableStringIterator): Pair<U, CopyableStringIterator>? {
				return parser(iter)?.run { mapper(first) to second }
			}
			
			override fun toString(): String {
				return parser.toString()
			}
		}
		
		fun <T, U> Parser<T>.map(mapper: (T) -> U): Parser<U> {
			return MapParser(this, mapper)
		}
		
		private data class ThenParser<T, U, V>(val first: Parser<T>, val second: Parser<U>, val collector: (T, U) -> V) : Parser<V> {
			override fun invoke(iter: CopyableStringIterator): Pair<V, CopyableStringIterator>? {
				return first(iter)?.let { (item, next) ->
					second(next)?.let { (nextitem, after) ->
						collector(item, nextitem) to after
					}
					?: debug_fail()
				} ?: debug_fail()
			}
			
			override fun toString(): String {
				return "(?:$first$second)"
			}
		}
		
		fun <T, U, V> Parser<T>.then(other: Parser<U>, collector: (T, U) -> V): Parser<V> {
			return ThenParser(this, other, collector)
		}
		
		@JvmName("thenString")
		fun Parser<String>.then(other: Parser<Char>): Parser<String> {
			return then(other) { i, j -> i + j }
		}
		
		private data class StarParser<T, COLL : Any, OUT>(val parser: Parser<T>, val makeList: () -> COLL, val append: COLL.(T) -> Unit, val after: COLL.() -> OUT) : Parser<OUT> {
			override fun invoke(iter: CopyableStringIterator): Pair<OUT, CopyableStringIterator>? {
				if (!iter.hasNext())
					return debug_eof();
				
				var currIter = iter
				val currItems = makeList()
				while (currIter.hasNext()) {
					val (nextItem, nextIter) = parser(currIter) ?: break
					
					currItems.append(nextItem)
					currIter = nextIter
				}
				
				return currItems.after() to currIter;
			}
			
			override fun toString(): String {
				return "$parser*"
			}
		}
		
		@JvmName("starList")
		fun <T> Parser<T>.star(): Parser<List<T>> {
			return StarParser<T, MutableList<T>, List<T>>(this, { mutableListOf() }, { add(it) }, { this.toList() })
		}
		
		@JvmName("starString")
		fun Parser<Char>.star(): Parser<String> {
			return StarParser(this, { StringBuilder() }, StringBuilder::append, StringBuilder::toString)
		}
		
		@JvmName("tPlus")
		fun <T> Parser<T>.plus(): Parser<List<T>> {
			return this.map { listOf(it) }
					.then(this.star()) { i, j -> i + j }
					.named("$this+")
		}
		
		private data class PlusParser_Char(val parser: Parser<Char>) : Parser<String> {
			override fun invoke(iter: CopyableStringIterator): Pair<String, CopyableStringIterator>? {
				if (!iter.hasNext())
					return debug_eof();
				
				val currItems = StringBuilder()
				val (item, niter) = parser(iter)
				                    ?: return null
				currItems.append(item)
				
				var currIter = niter
				while (true) {
					val (nextItem, nextIter) = parser(currIter) ?: break
					currItems.append(nextItem)
					currIter = nextIter
				}
				
				return currItems.toString() to currIter;
			}
			
			override fun toString(): String {
				return "$parser+"
			}
		}
		
		fun Parser<Char>.plus(): Parser<String> {
			return PlusParser_Char(this)
		}
		
		fun interface CharPredicate {
			fun test(char: Char): Boolean
		}
		
		data class ConditionalParser(val name: String, val predicate: CharPredicate) : Parser<Char> {
			override fun invoke(iter: CopyableStringIterator): Pair<Char, CopyableStringIterator>? {
				if (!iter.hasNext())
					return debug_eof();
				
				val (nextChar, nextIter) = iter.next()
				if (predicate.test(nextChar))
					return nextChar to nextIter;
				return null;
			}
			
			override fun toString(): String {
				return "$\"$name\""
			}
		}
		
		fun conditional(name: String, predicate: CharPredicate) = ConditionalParser(name, predicate)
		
		fun <T> Parser<T>.optional() = OptionalParser(this)
		
		class OptionalParser<T>(val parser: Parser<T>) : Parser<T?> {
			override fun invoke(iter: CopyableStringIterator): Pair<T?, CopyableStringIterator>? {
				return parser(iter) ?: (null to iter)
			}
			
			override fun toString(): String {
				return "$parser?"
			}
		}
		
		val wordChar = conditional("\\w") { it.isLetterOrDigit() || it == '-' || it == '_' }
		val whitespace = conditional("\\s", Char::isWhitespace)
		val phrase = conditional("[\\w\\s]") { it.isLetterOrDigit() || it == '-' || it == '_' || it.isWhitespace() }.plus()
		
		fun <T> Parser<T>.parse(string: String): T? {
			return this.invoke(CopyableStringIterator(string, 0))?.first
		}
		
		class NamedParser<T>(val name: String, val parser: Parser<T>) : Parser<T> {
			override fun invoke(iter: CopyableStringIterator): Pair<T, CopyableStringIterator>? {
				return parser(iter)
			}
			
			override fun toString(): String {
				return "$\"$name\""
			}
		}
		
		fun <T> Parser<T>.named(name: String) = NamedParser(name, this)
	}
}
