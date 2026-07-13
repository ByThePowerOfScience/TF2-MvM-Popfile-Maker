package btpos.source.vdfdsl.serialization

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFPrimitive.Companion.PRIMITIVE_SERIALIZERS
import btpos.source.vdfdsl.backing.VDFSubtree
import kotlin.jvm.java

/**
 * Anything that has a VDF representation that is different from its own object and does not define its own key,
 * such as being serialized to a word/phrase (String), a number, or a [map][btpos.source.vdfdsl.backing.VDFSubtree].
 *
 * This is a functional interface that returns an `IVDFRepresentableKeyValue` to allow the value to control how it is added to a [VDFSubtree][btpos.source.vdfdsl.backing.VDFSubtree].
 *
 * (Basically, it's `(key) -> (subtree) -> (subtree + (key, this))`.)
 */
fun interface IVDFRepresentableValue : IVDFRepresentable {
	/**
	 * Add this value to the subtree with the specified key.
	 *
	 * Allows full manipulation and traversal of the tree.
	 *
	 * @param key The key this value should be given.
	 * @return A function that adds this value, with the corresponding key, to a subtree, allowing full traversal of the tree. (see [IVDFRepresentableKeyValue._serializeInto])
	 */
	fun _toKeyValueRepresentable(key: VDFPrimitive): IVDFRepresentableKeyValue
	
	companion object {
		fun serializeDynamic(key: VDFPrimitive, obj: Any): IVDFRepresentableKeyValue {
			return when (obj) {
				is VDFObject -> VDFKeyValue(key, obj)
				is IVDFRepresentable -> when (obj) {
					is IVDFRepresentableValue -> obj._toKeyValueRepresentable(key)
					is IVDFRepresentableKeyValue -> throw IllegalArgumentException("Error serializing dynamic keyvalue with '$key': Cannot give keyvalue '$obj' a key as it has one already.")
				}
				else -> {
					val serializer = PRIMITIVE_SERIALIZERS[obj.javaClass]
					                 ?: throw IllegalArgumentException("'$obj' must be a String, Int, Float, Double, Boolean, VDFObject, or IVDFRepresentableValue to be dynamically serialized.")
					VDFKeyValue(key, serializer.invoke(obj))
				}
			}
		}
	}
}

interface IVDFRepresentableValue_Subtree : IVDFRepresentableValue {
	fun _vdfRepr(parent: VDFSubtree): VDFSubtree
	
	override fun _toKeyValueRepresentable(key: VDFPrimitive): IVDFRepresentableKeyValue {
		return { parent ->
			parent += VDFKeyValue(key, _vdfRepr(parent))
		}
	}
}

/**
 * Anything that has a VDF representation that is different from its own object and does not define its own key,
 * such as being serialized to a word/phrase (String), a number, or a [map][btpos.source.vdfdsl.backing.VDFSubtree].
 *
 * This is a simpler interface for things that don't need to manually govern how they're added to the tree and can just be added plainly.
 */
interface IVDFRepresentableValue_Trivial : IVDFRepresentableValue {
	/**
	 * The special representation that should be serialized.
	 *
	 * When the data contained in this object can change after it's created, this should be a _lazily-evaluated_ property.
	 * (i.e. use `override val _vdfRepr get() = ...` instead of `override val _vdfRepr = ...`,
	 * since the former is just a method that can be called later and the latter actually calculates and saves it when the object is created.)
	 */
	val _vdfRepr: VDFPrimitive
	
	override fun _toKeyValueRepresentable(key: VDFPrimitive): IVDFRepresentableKeyValue {
		return { it += VDFKeyValue(key, _vdfRepr) }
	}
	
	companion object {
		fun isValueRepresentable(cls: Class<*>): Boolean {
			return IVDFRepresentableValue::class.java.isAssignableFrom(cls)
			       || VDFPrimitive::class.java.isAssignableFrom(cls)
			       || VDFSubtree::class.java.isAssignableFrom(cls)
			       || cls in PRIMITIVE_SERIALIZERS
		}
		
		fun requireValueRepresentable(cls: Class<*>) {
			if (!isValueRepresentable(cls))
				throw IllegalArgumentException("Type ${cls.simpleName} cannot be represented as a value given a key. Value must either implement IVDFRepresentableValue or be a String, number, or boolean.")
		}
	}
}

