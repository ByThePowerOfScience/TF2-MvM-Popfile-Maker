package btpos.source.vdfdsl.serialization.codecs

/**
 * When we need a toggle on something that sets an attribute to a certain value.
 *
 * Specifically used for `set_weapon_mode` in vanilla.
 */


fun NumberSelectorCodec(number: Int): (Boolean) -> Int = {
	if (it)
		number
	else
		0
}