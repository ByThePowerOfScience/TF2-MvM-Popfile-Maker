package btpos.source.vdfdsl.serialization

import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import kotlin.jvm.java


/**
 * Anything that has a VDF representation that is different from its own object and does not define its own key,
 * such as being serialized to a word/phrase (String), a number, or a [map][btpos.source.vdfdsl.backing.VDFSubtree].
 *
 * Note that lists must be serialized using multiple keyvalues: \[key listitem1], \[key listitem2], etc
 */
interface IVDFRepresentableValue<out T : VDFObject> : IVDFRepresentable {
	/**
	 * The special representation that should be serialized.
	 *
	 * When the data contained in this object can change after it's created, this should be a _lazily-evaluated_ property.
	 * (i.e. use `override val _vdfRepr get() = ...` instead of `override val _vdfRepr = ...`,
	 * since the former is just a method that can be called later and the latter actually calculates and saves it when the object is created.)
	 */
	val _vdfRepr: T
	
	companion object {
		val PRIMITIVE_SERIALIZERS = mapOf<Class<*>, (Any) -> VDFObject>(
			String::class.java to { VDFPrimitive(it as String) },
			Int::class.java to { VDFPrimitive(it as Int) },
			Float::class.java to { VDFPrimitive(it as Float) },
			Double::class.java to { VDFPrimitive((it as Double).toFloat()) },
			Boolean::class.java to { VDFPrimitive(it as Boolean) },
		)
		
		fun isValueRepresentable(cls: Class<*>): Boolean {
			return cls.isAssignableFrom(IVDFRepresentableValue::class.java)
			       || cls.isAssignableFrom(VDFObject::class.java)
			       || cls in PRIMITIVE_SERIALIZERS
		}
		
		/**
		 * Turn an unknown value into a VDFObject.  Primitives (and String) can't be turned into VDFObjects, sadly.
		 */
		fun serializeDynamic(obj: Any): VDFObject {
			return when (obj) {
				is VDFObject -> obj
				is IVDFRepresentable -> when (obj) {
					is IVDFRepresentableValue<*> -> obj._vdfRepr
					is IVDFRepresentableKeyValue -> throw IllegalArgumentException("Cannot serialize keyvalue '$obj' as a value.")
				}
				else -> {
					val serializer = PRIMITIVE_SERIALIZERS[obj.javaClass]
					                 ?: throw IllegalArgumentException("'$obj' must be a String, Int, Float, Double, Boolean, VDFObject, or IVDFRepresentableValue to be dynamically serialized.")
					serializer.invoke(obj)
				}
			}
		}
	}
}