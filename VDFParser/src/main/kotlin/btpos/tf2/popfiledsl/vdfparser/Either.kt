import btpos.tf2.popfiledsl.vdfparser.leftOrNull
import btpos.tf2.popfiledsl.vdfparser.rightOrNull
import com.mojang.datafixers.util.Either

//package btpos.tf2.popfiledsl.vdfparser
//
//import btpos.tf2.popfiledsl.vdfparser.mapRight
//
//sealed class Either<L, R> {
//	val leftOrNull: L?
//		get() = (this as? Left)?.value
//
//	val rightOrNull: R?
//		get() = (this as? Right)?.value
//
//}
//
//class Left<L, _R>(val value: L) : Either<L, _R>()
//class Right<_L, R>(val value: R) : Either<_L, R>()
//
//
//fun <L, R, R2> Either<L, R>.mapRight(functor: (R) -> R2): Either<L, R2> {
//	return when (this) {
//		is Right -> Right(functor(value))
//		is Left -> this as Either<L, R2>
//	}
//}
//
//fun <L, R, L2> Either<L, R>.mapLeft(functor: (L) -> L2): Either<L2, R> {
//	return when (this) {
//		is Left -> Left(functor(value))
//		is Right -> this as Either<L2, R>
//	}
//}
//
//fun <L, L2, R> Either<L, R>.flatMapLeft(functor: (L) -> Either<L2, R>): Either<L2, R> {
//	return when (this) {
//		is Left -> functor(value)
//		is Right -> this as Right<L2, R>
//	}
//}
//
//@JvmName("flatMapLeft_newR")
//fun <L, L2, R, R2> Either<L, R>.flatMapLeft(functor: (L) -> Either<L2, R2>): Either<L2, Either<R, R2>> {
//	return when (this) {
//		is Left -> functor(value).mapRight { Right(it) }
//		is Right -> Right(Left(this.value))
//	}
//}
//
//fun <L, R, R2> Either<L, R>.flatMapRight(functor: (R) -> Either<L, R2>): Either<L, R2> {
//	return when (this) {
//		is Left -> this as Either<L, R2>
//		is Right -> functor(value)
//	}
//}
//
//@JvmName("flatMapRight_newL")
//fun <L, L2, R, R2> Either<L, R>.flatMapRight(functor: (R) -> Either<L2, R2>): Either<Either<L, L2>, R2> {
//	return when (this) {
//		is Right -> functor(value).mapLeft { Right(it) }
//		is Left -> Left(Left(this.value))
//	}
//}
//
//@JvmName("flattenEitherL1R_L2R")
//fun <L1, L2, R> Either<Either<L1, R>, Either<L2, R>>.flatten(): Either<Either<L1, L2>, R> {
//	return this.leftOrNull?.mapLeft { Left(it) } ?: this.rightOrNull!!.mapLeft { Right(it) }
//}
//
//@JvmName("flattenEitherLR1_LR2")
//fun <L, R1, R2> Either<Either<L, R1>, Either<L, R2>>.flatten(): Either<L, Either<R1, R2>> {
//	return this.leftOrNull?.mapRight { Left(it) } ?: this.rightOrNull!!.mapRight { Right(it) }
//}
//
//
//@JvmName("flattenEitherL_LR")
//fun <L, R> Either<L, Either<L, R>>.flatten(): Either<L, R> {
//	return this.rightOrNull ?: Left(this.leftOrNull!!)
//}
//
//@JvmName("flattenEitherLR_R")
//fun <L, R> Either<Either<L, R>, R>.flatten(): Either<L, R> {
//	return this.rightOrNull?.let { Right(it) } ?: this.leftOrNull!!
//}
//
//
//
//@JvmName("flattenSameL")
//fun <L, R1, R2> Either<Pair<L, R1>, Pair<L, R2>>.flatten(): Pair<L, Either<R1, R2>> {
//	return this.rightOrNull?.let { it.first to Right(it.second) } ?: this.leftOrNull?.let { it.first to Left(it.second) }!!
//}
//
//
//
//@JvmName("flattenSameR")
//fun <L1, L2, R> Either<Pair<L1, R>, Pair<L2, R>>.flatten(): Pair<Either<L1, L2>, R> {
//	return this.rightOrNull?.let { Right<L1, L2>(it.first) to it.second } ?: this.leftOrNull?.let { Left<L1, L2>(it.first) to it.second }!!
//}
//
//@JvmName("flattenNullableL_Rnullable")
//fun <L, R1, R2> Either<Pair<L, R1>, Pair<L?, R2>>.flatten(): Pair<L?, Either<R1, R2>> {
//	return this.leftOrNull?.let { it.first to Left(it.second) }
//	       ?: this.rightOrNull?.let { it.first to Right(it.second) }!!
//}
//
//@JvmName("flattenNullableL_Lnullable")
//fun <L, R1, R2> Either<Pair<L?, R1>, Pair<L, R2>>.flatten(): Pair<L?, Either<R1, R2>> {
//	return this.leftOrNull?.let { it.first to Left(it.second) }
//	       ?: this.rightOrNull?.let { it.first to Right(it.second) }!!
//}
//
//@JvmName("flattenNullableR_Lnullable")
//fun <L1, L2, R> Either<Pair<L1, R?>, Pair<L2, R>>.flatten(): Pair<Either<L1, L2>, R?> {
//	return this.leftOrNull?.let { Left<L1, L2>(it.first) to it.second }
//	       ?: this.rightOrNull!!.let { Right<L1, L2>(it.first) to it.second }
//}
//
//@JvmName("flattenNullableR_Rnullable")
//fun <L1, L2, R> Either<Pair<L1, R>, Pair<L2, R?>>.flatten(): Pair<Either<L1, L2>, R?> {
//	return this.leftOrNull?.let { Left<L1, L2>(it.first) to it.second }
//	       ?: this.rightOrNull?.let { Right<L1, L2>(it.first) to it.second }!!
//}

