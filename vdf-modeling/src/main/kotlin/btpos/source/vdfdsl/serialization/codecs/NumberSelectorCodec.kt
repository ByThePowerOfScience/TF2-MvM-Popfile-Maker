package btpos.source.vdfdsl.serialization.codecs

/**
 * When we need a toggle on something that sets an attribute to a certain value.
 *
 * Specifically used for `set_weapon_mode` in vanilla.
 */
class NumberSelectorCodec(val number: Int) : Codec<Boolean, Any> {
	override fun read(data: Any): Boolean {
		return data == number
	}
	
	override fun write(input: Boolean): Int {
		if (input)
			return number
		else
			return 0
	}
}