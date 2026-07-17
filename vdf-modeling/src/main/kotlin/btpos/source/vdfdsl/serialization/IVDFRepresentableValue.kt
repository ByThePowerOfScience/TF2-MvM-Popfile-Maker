package btpos.source.vdfdsl.serialization

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
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
	fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue
	
	companion object {
		/**
		 * Attempts to turn a [value] of an unknown type, along with a [key], into something that can be added to a subtree.
		 *
		 * This solely exists because we can't mark primitives and strings as "VDF representable values".
		 *
		 * Allowed types:
		 * - String
		 * - Number (Int, Float, Double, Long, etc.)
		 * - Boolean
		 * - [IVDFRepresentableValue]
		 * - [VDFObject]
		 */
		fun serializeDynamic(key: VDFPrimitive, value: Any, conditional: String? = null): IVDFRepresentableKeyValue {
			return when (value) {
				is VDFObject -> VDFKeyValue(key, value, conditional)
				is IVDFRepresentable -> when (value) {
					is IVDFRepresentableValue -> value._toKeyValueRepresentable(key, conditional)
					is IVDFRepresentableKeyValue -> throw IllegalArgumentException("Error serializing dynamic keyvalue with '$key': Cannot give keyvalue '$value' a key as it has one already.")
				}
				else -> {
					val primitive = VDFPrimitive.tryCreatePrimitive(value)
					                ?: throw IllegalArgumentException("'$value' must be a String, Number, Boolean, VDFObject, or IVDFRepresentableValue to be dynamically serialized.")
					VDFKeyValue(key, primitive, conditional)
				}
			}
		}
		
		fun isValueRepresentable(cls: Class<*>): Boolean {
			return IVDFRepresentableValue::class.java.isAssignableFrom(cls)
			       || VDFPrimitive.isPrimitive(cls)
		}
		
		fun requireValueRepresentable(cls: Class<*>) {
			if (!isValueRepresentable(cls))
				throw IllegalArgumentException("Type ${cls.simpleName} cannot be represented as a value given a key. Value must either implement IVDFRepresentableValue or be a String, number, or boolean.")
		}
	}
}

fun interface IVDFRepresentableValue_Subtree : IVDFRepresentableValue {
	fun _vdfRepr(parent: VDFSubtree): VDFSubtree
	
	override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return { parent ->
			parent += VDFKeyValue(key, _vdfRepr(parent), conditional)
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
	
	override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return { it += VDFKeyValue(key, _vdfRepr, conditional) }
	}
}

fun IVDFRepresentableValue_Trivial(repr: () -> VDFPrimitive) = object : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive
		get() = repr()
}
