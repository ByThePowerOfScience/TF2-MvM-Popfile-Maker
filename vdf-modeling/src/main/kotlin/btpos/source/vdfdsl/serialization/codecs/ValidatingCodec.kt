package btpos.source.vdfdsl.serialization.codecs

class ValidatingCodec<T>(
	/**
	 * A function that must throw an exception if the input is malformed.
	 */
	val validator: (T) -> Unit
) : Codec<T, T> {
	override fun read(data: T): T = data
	
	override fun write(input: T): T {
		validator(input)
		return input
	}
}