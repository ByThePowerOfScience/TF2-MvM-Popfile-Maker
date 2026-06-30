package btpos.source.vdfdsl.itemattributesgenerator.representations

fun selectorCodec(number: Int) = FakeCodec("Boolean", "NumberSelectorCodec($number)")

class FakeCodec(val visibleType: String, val codecIdentifier: String) {
	override fun toString(): String {
		return """FakeCodec("$visibleType", "$codecIdentifier")"""
	}
}

val bool = FakeCodec("Boolean", "BinaryIntCodec")