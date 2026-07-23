package btpos.source.vdfdsl.tf2.rafmod.codecs

import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

object DurationCodec : Codec<Duration, Any> {
	override fun read(data: Any): Duration? {
		return when (val data = data as Number) {
			is Long -> data.toDuration(DurationUnit.SECONDS)
			is Int -> data.toDuration(DurationUnit.SECONDS)
			is Double -> data.toDuration(DurationUnit.SECONDS)
			else -> null
		}
	}
	
	override fun write(input: Duration): Any {
		return input.toSeconds()
	}
}