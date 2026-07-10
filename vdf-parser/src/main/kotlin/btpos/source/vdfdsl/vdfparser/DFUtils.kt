package btpos.source.vdfdsl.vdfparser

import com.mojang.datafixers.util.Either
import com.mojang.datafixers.util.Pair


val <L> Either<L, *>.leftOrNull: L? get() = this.left().orElse(null)
val <R> Either<*, R>.rightOrNull: R? get() = this.right().orElse(null)

fun <SUPER, T : SUPER, U : SUPER> Either<T, U>.unify(): SUPER {
	return java.util.function.Function.identity<SUPER>().let { map(it, it) }
}

fun <L, R, R2> Either<L, R>.flatMapRight(functor: (R) -> Either<L, R2>): Either<L, R2> {
	return map(Either<L, R>::left, functor)
}

@get:JvmName("nullable_left")
val <T> Either<T, Nothing?>.nullable
	get() = this.leftOrNull

@get:JvmName("nullable_right")
val <T> Either<Nothing?, T>.nullable
	get() = rightOrNull


operator fun <L, R> Pair<L, R>.component1(): L = this.first
operator fun <L, R> Pair<L, R>.component2(): R = this.second