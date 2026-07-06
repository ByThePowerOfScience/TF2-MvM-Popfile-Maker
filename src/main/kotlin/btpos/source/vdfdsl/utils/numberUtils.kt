package btpos.source.vdfdsl.utils

import kotlin.math.floor
import kotlin.time.Duration
import kotlin.time.DurationUnit

private fun Double.orInt(): Number {
	val intValue = floor(this)
	if (this - intValue == 0.0) // if it has no decimal component
		return this.toInt()
	else
		return this
}

operator fun Number.plus(other: Number): Number {
	return (this.toDouble() + other.toDouble()).orInt()
}

operator fun Number.minus(other: Number): Number = (this.toDouble() - other.toDouble()).orInt()

operator fun Number.times(other: Number): Number = (this.toDouble() * other.toDouble()).orInt()

operator fun Number.div(other: Number): Number = (this.toDouble() / other.toDouble()).orInt()

operator fun Number.rem(other: Number): Number = (this.toDouble() % other.toDouble()).orInt()

operator fun Number.compareTo(other: Number): Int = this.toDouble().compareTo(other.toDouble())

operator fun Number.unaryMinus(): Number = (-this.toDouble()).orInt()

fun Duration.toSeconds() = this.toDouble(DurationUnit.SECONDS).orInt()



