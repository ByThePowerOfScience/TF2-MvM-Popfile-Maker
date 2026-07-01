package btpos.source.vdfdsl.serialization


/**
 * Anything that has a VDF representation that is different from its own object,
 * such as being serialized to a word/phrase (String), a number, or a [map][VDFSubtree].
 *
 * Note that lists must be serialized using multiple keyvalues: \[key listitem1], \[key listitem2], etc
 */
interface IVDFSerializableValue<out T : IVDFSerializable> : IVDFSerializable {
	/**
	 * The special representation that should be serialized.
	 *
	 * When the data contained in this object can change after it's created, this should be a _lazily-evaluated_ property.
	 * (i.e. use `override val _vdfRepr get() = ...` instead of `override val _vdfRepr = ...`,
	 * since the former is just a method that can be called later and the latter actually calculates and saves it when the object is created.)
	 */
	val _vdfRepr: T
}

interface IVDFSerializableValue_Primitive<out T : Any> : IVDFSerializableValue<VDFPrimitive> {
	val _primitiveRepr: T
	
	override val _vdfRepr: VDFPrimitive
		get() = VDFPrimitive(_primitiveRepr)
}