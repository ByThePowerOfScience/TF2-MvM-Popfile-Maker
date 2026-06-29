package btpos.tf2.popfiledsl.serialization.codecs

/**
 * Booleans are serialized as 0/1 values in VDFs, so this translates them.
 */
object BinaryIntCodec : Codec<Boolean, Any> {
	override fun read(data: Any): Boolean {
		return data == 1
	}
	
	override fun write(input: Boolean): Int {
		return if (input) 1 else 0
	}
}