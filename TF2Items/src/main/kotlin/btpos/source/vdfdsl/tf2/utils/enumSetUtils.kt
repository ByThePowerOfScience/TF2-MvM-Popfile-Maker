package btpos.source.vdfdsl.tf2.utils

import java.util.*

infix fun <T : Enum<T>> T.or(other: T) = EnumSet.of(this, other)
infix fun <T : Enum<T>> T.or(other: EnumSet<T>) = EnumSet.copyOf(other) or this
infix fun <T : Enum<T>> EnumSet<T>.or(other: T) = this.apply { add(other) }
infix fun <T : Enum<T>> EnumSet<T>.or(other: EnumSet<T>) = this.apply { addAll(other) }