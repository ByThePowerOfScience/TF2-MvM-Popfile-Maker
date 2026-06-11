package btpos.tf2.popfiledsl.serialization.codecs

interface Codec<DESERIALIZED, SERIALIZED> {
	companion object
	
	fun read(data: SERIALIZED): DESERIALIZED
	
	fun write(input: DESERIALIZED): SERIALIZED
}