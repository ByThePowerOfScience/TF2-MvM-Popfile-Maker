package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

object RafmodSerializers {
	@JvmField val DURATION_IN_SECONDS = { it: Duration -> it.toSeconds() }
	
	@JvmField val BOOL_SER_INVERT = { it: Boolean -> BinaryIntCodec.write(!it) }
	
}