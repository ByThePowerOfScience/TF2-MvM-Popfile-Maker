package btpos.source.vdfdsl.vdfparser

import btpos.source.vdfdsl.vdfparser.Parser.ParseFail
import btpos.source.vdfdsl.vdfparser.Parser.ParseSuccess
import com.mojang.datafixers.util.Either
import com.mojang.datafixers.util.Pair
import kotlin.jvm.optionals.getOrNull
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

typealias ParseResult<T> = Either<ParseSuccess<T>, ParseFail>

/**
 * Alias for [flatMapRight] that takes the furthest successful parse instead of the second one
 */
fun <T> ParseResult<T>.recover(next: () -> ParseResult<T>): ParseResult<T> {
	return this.flatMapRight { firstFail ->
		next().mapRight { nextFail ->
			when {
				firstFail.isEOF -> nextFail
				nextFail.isEOF -> firstFail
				firstFail.indexOfFailure > firstFail.indexOfFailure -> firstFail
				else -> nextFail
			}
		}
	}
}

fun String.immutableIterator() = CopyableStringIterator(this, 0)

class CopyableStringIterator(val string: String, val currentIndex: Int) {
	data class NextChar(val char: Char, val nextIter: CopyableStringIterator)
	
	fun hasNext() = currentIndex < string.length
	
	fun next() = NextChar(string[currentIndex], CopyableStringIterator(string, currentIndex + 1))
	
	override fun toString(): String {
		return if (currentIndex in string.indices) string.substring(currentIndex) else ""
	}
	
	fun peek() = string[currentIndex]
}

fun interface Parser<T> {
	data class ParseSuccess<out T>(val item: T, val remainder: CopyableStringIterator) {
		inline fun <U> mapItem(mapper: (T) -> U): ParseSuccess<U> {
			return ParseSuccess(mapper(item), remainder)
		}
	}
	data class ParseFail(val iter: CopyableStringIterator? = null, val parser: Parser<*>) {
		val isEOF get() = iter == null
		
		val indexOfFailure get() = iter?.currentIndex ?: Int.MAX_VALUE
		
		val message: String get() {
			if (iter == null) {
				return "Expected $parser, instead reached end of file."
			} else {
				return "Expected $parser, found unexpected char '${iter.next().char}' at ${iter.currentIndex}."
			}
		}
	}
	
	
	
	
	/**
	 * @return The item with the next part of the string to be parsed, or null if it failed to match.
	 */
	operator fun invoke(iter: CopyableStringIterator): ParseResult<T>
	
	companion object {
		fun <T> success(item: T, remainder: CopyableStringIterator): ParseResult<T> = Either.left(ParseSuccess(item, remainder))
		
		private var failCount = 0
		private var prevHighestStack = -1L
		
		private var prevFurthest: Pair<CopyableStringIterator, Parser<*>>? = null
		
		private val stackWalker = StackWalker.getInstance()
		
		fun <T> Parser<T>.eof(iter: CopyableStringIterator): ParseResult<T> {
			return Either.right(ParseFail(null, this))
		}
		fun <T> Parser<T>.fail(iter: CopyableStringIterator): ParseResult<T> {
//			prevFurthest?.let { prev ->
//				val currentStackDepth = stackWalker.walk { it.count() }
//
//				if (currentStackDepth < prevHighestStack && iter.currentIndex < prev.first.currentIndex) {
//					// we're unwinding and have made negative progress
//					println("breakpoint")
//				} else {
//					prevHighestStack = currentStackDepth
//					prevFurthest = Pair(iter, this)
//				}
//			} ?: run {
//				prevFurthest = Pair(iter, this)
//			}
//			
			return Either.right(ParseFail(iter, this))
		}
	
		fun literal(c: Char) = LiteralParser(c)
		
		val empty: Parser<Nothing?> = Parser { iter ->
			success(null, iter)
		}.named("λ", useRawName = true)
		
		class LiteralParser(val literal: Char) : Parser<Char> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<Char> {
				if (!iter.hasNext())
					return eof(iter);
				val (nextChar, nextIter) = iter.next()
				if (nextChar == literal)
					return success(literal, nextIter);
				return fail(iter);
			}
			
			override fun toString(): String {
				return when (literal) {
					'-', '$', '|', '[', ']', '{', '}', '(', ')', '^' -> "\\$literal"
					else -> literal.toString().replace("\n", "\\n")
				}
			}
		}
		
		class StringParser(val stringToMatchAgainst: String) : Parser<String> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<String> {
				var currentIter = iter
				for (c in stringToMatchAgainst) {
					if (!currentIter.hasNext())
						return eof(currentIter)
					
					val (nextChar, nextIter) = currentIter.next()
					if (nextChar != c)
						return fail(currentIter);
					
					currentIter = nextIter
				}
				return success(stringToMatchAgainst, currentIter)
			}
			
			override fun toString(): String {
				return "(?:$stringToMatchAgainst)"
			}
		}
		
		fun string(s: String) = StringParser(s)
		
		class ThunkParser<T>(val deferred: () -> Parser<T>) : Parser<T> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<T> {
				return deferred()(iter)
			}
			
			override fun toString(): String {
				return deferred().toString()
			}
		}
		
		fun <T> (() -> Parser<T>).thunk(): Parser<T> = ThunkParser(this)
		
		private data class OrParser_Either<T, U>(val x: Parser<T>, val y: Parser<U>) : Parser<Either<T, U>> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<Either<T, U>> {
				return x(iter).mapLeft { left -> left.mapItem { Either.left<T, U>(it) } }
					.recover {
						y(iter).mapLeft { left -> left.mapItem { Either.right(it) } }
					}
			}
			
			override fun toString(): String {
				return "(?:$x|$y)"
			}
		}
		
		private data class OrParser<T>(val x: Parser<T>, val y: Parser<T>) : Parser<T> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<T> {
				return x(iter).recover {
					y(iter)
				}
			}
			
			override fun toString(): String {
				return "(?:$x|$y)"
			}
		}
		
		
		
		@JvmName("parserOrEither")
		infix fun <T, U> Parser<T>.or(other: Parser<U>) : Parser<Either<T, U>> {
			return OrParser_Either(this, other)
		}
		
		@JvmName("tOrT")
		infix fun <T> Parser<T>.or(other: Parser<T>) : Parser<T> {
			return OrParser(this, other)
		}
		
		@JvmName("tOrNothing")
		infix fun <T> Parser<T>.or(nothing: Parser<Nothing?>) : Parser<T?> {
			return OrParser_Either(this, nothing).map { it.nullable }
		}
		
		@JvmName("nothingOrT")
		infix fun <T> Parser<Nothing?>.or(other: Parser<T>) : Parser<T?> {
			return OrParser_Either(this, other).map { it.nullable }
		}
		
		private data class MapParser<T, U>(val parser: Parser<T>, val mapper: (T) -> U) : Parser<U> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<U> {
				return parser(iter).mapLeft { it.mapItem(mapper) }
			}
			
			override fun toString(): String {
				return parser.toString()
			}
		}
		
		fun <T, U> Parser<T>.map(mapper: (T) -> U): Parser<U> {
			return MapParser(this, mapper)
		}
		
		private data class ThenParser<T, U, V>(val first: Parser<T>, val second: Parser<U>, val collector: (T, U) -> V) : Parser<V> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<V> {
				return first(iter).flatMap { (item, next) ->
					second(next).mapLeft { (nextitem, after) ->
						ParseSuccess(collector(item, nextitem), after)
					}
				}
			}
			
			override fun toString(): String {
				return "(?:$first$second)"
			}
		}
		
		private val _discardRight = { l: Any?, _: Any? -> l }
		@Suppress("UNCHECKED_CAST")
		fun <T, U> discardRight(): (T, U) -> T = _discardRight as (T, U) -> T
		
		private val _discardLeft = { _: Any?, r: Any? -> r }
		@Suppress("UNCHECKED_CAST")
		fun <T, U> discardPrev(): (T, U) -> U = _discardLeft as (T, U) -> U
		
		private val _discardBoth = { _: Any?, _: Any? -> null }
		fun <T, U> discardBoth(): (T, U) -> Nothing? = _discardBoth as (T, U) -> Nothing?
		
		
		fun <T, U, V> Parser<T>.then(other: Parser<U>, collector: (T, U) -> V): Parser<V> {
			return ThenParser(this, other, collector)
		}
		
		@JvmName("tThenU_implicitPairCollector")
		infix fun <T, U> Parser<T>.then(other: Parser<U>): Parser<Pair<T, U>> = then(other, ::Pair)
		
		@JvmName("nothingThenNothing")
		infix fun Parser<Nothing?>.then(other: Parser<Nothing?>) = this.then(other, discardBoth())
		
		@JvmName("stringThenChar")
		infix fun Parser<String>.then(other: Parser<Char>): Parser<String> {
			return then(other) { i, j -> i + j }
		}
		
		@JvmName("nothingThenT")
		infix fun <T> Parser<Nothing?>.then(other: Parser<T>) = this.then(other, discardPrev())
		
		@JvmName("tThenNothing")
		infix fun <T> Parser<T>.then(other: Parser<Nothing?>) = this.then(other, discardRight())
		
		@JvmName("charThenString")
		infix fun Parser<Char>.then(other: Parser<String>): Parser<String> {
			return then(other) { i, j -> i + j }
		}
		
		
		private data class StarParser<T, COLL : Any, OUT>(val parser: Parser<T>, val makeList: () -> COLL, val append: COLL.(T) -> Unit, val after: COLL.() -> OUT) : Parser<OUT> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<OUT> {
				if (!iter.hasNext())
					return eof(iter);
				
				var currIter = iter
				val currItems = makeList()
				while (currIter.hasNext()) {
					val (nextItem, nextIter) = parser(currIter).left().getOrNull() ?: break
					
					currItems.append(nextItem)
					currIter = nextIter
				}
				
				return success(currItems.after(), currIter);
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
		
		private val _alwaysNull = { _: Any? -> null }
		
		fun <T> Parser<T>.discard(): Parser<Nothing?> {
			return map(_alwaysNull)
		}
		
		@JvmName("tPlus")
		fun <T> Parser<T>.plus(): Parser<List<T>> {
			return this.map { listOf(it) }
					.then(this.star()) { i, j -> i + j }
					.named("$this+", useRawName = true)
		}
		
		private data class PlusParser_Char(val parser: Parser<Char>) : Parser<String> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<String> {
				if (!iter.hasNext())
					return eof(iter);
				
				val currItems = StringBuilder()
				val (item, niter) = parser(iter).let {
					it.leftOrNull ?: return Either.right(it.rightOrNull!!)
				}
				currItems.append(item)
				
				var currIter = niter
				while (true) {
					val (nextItem, nextIter) = parser(currIter).leftOrNull ?: break;
					currItems.append(nextItem)
					currIter = nextIter
				}
				
				return success(currItems.toString(), currIter);
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
		
		data class ConditionalParser(val name: String, val dontEscapeName: Boolean, val predicate: CharPredicate) : Parser<Char> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<Char> {
				if (!iter.hasNext())
					return eof(iter);
				
				val (nextChar, nextIter) = iter.next()
				if (predicate.test(nextChar))
					return success(nextChar, nextIter);
				return fail(nextIter);
			}
			
			override fun toString(): String {
				if (dontEscapeName)
					return name
				return "$\"$name\""
			}
		}
		
		fun conditional(name: String, dontEscapeName: Boolean, predicate: CharPredicate) = ConditionalParser(name, dontEscapeName, predicate)
		fun conditional(name: String, predicate: CharPredicate) = conditional(name, false, predicate)
		
		fun <T> Parser<T>.optional() = OptionalParser(this)
		
		class OptionalParser<T>(val parser: Parser<T>) : Parser<T?> {
			@Suppress("UNCHECKED_CAST")
			override fun invoke(iter: CopyableStringIterator): ParseResult<T?> {
				return (parser(iter) as ParseResult<T?>)
					.flatMapRight { Either.left<ParseSuccess<T?>, ParseFail>(ParseSuccess(null, iter)) }
			}
			
			override fun toString(): String {
				return "$parser?"
			}
		}
		
		val wordChar = conditional("\\w", dontEscapeName = true) { it.isLetterOrDigit() || it == '-' || it == '_' }
		val whitespace = conditional("\\s", dontEscapeName = true, Char::isWhitespace)
		val phrase = conditional("[\\w\\s]", dontEscapeName = true) { it.isLetterOrDigit() || it == '-' || it == '_' || it.isWhitespace() }.plus()
		
		fun <T> Parser<T>.parse(string: String): T? {
			val result = this.invoke(CopyableStringIterator(string, 0))
			return result.leftOrNull?.item
		}
		fun <T> Parser<T>.parseOrThrow(string: String): T {
			val result = this.invoke(CopyableStringIterator(string, 0))
			return result.ifRight {
				error(it.message)
			}.leftOrNull?.item!!
		}
		
		class NamedParser<T>(val name: String, val parser: Parser<T>, val dontEscapeName: Boolean) : Parser<T> {
			override fun invoke(iter: CopyableStringIterator): ParseResult<T> {
				return parser(iter)
			}
			
			override fun toString(): String {
				if (dontEscapeName)
					return name
				return "$\"$name\""
			}
		}
		
		fun <T> Parser<T>.named(name: String, useRawName: Boolean = false) = NamedParser(name, this, useRawName)
		
		operator fun <T> Parser<T>.provideDelegate(thisRef: Any?, prop: KProperty<*>):  ReadOnlyProperty<Any?, Parser<T>> {
			val named = this.named(prop.name)
			return ReadOnlyProperty<Any?, Parser<T>> { _, _ ->
				named
			}
		}
	}
}
