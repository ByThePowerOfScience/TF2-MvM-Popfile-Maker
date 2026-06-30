//package btpos.source.vdfdsl.vdfparser
//
//import btpos.source.vdfdsl.vdfparser.Types.keyvalue
//import com.mojang.datafixers.DSL
//import com.mojang.datafixers.types.DynamicOps
//import com.mojang.datafixers.types.Type
//import com.mojang.datafixers.types.templates.Const
//import com.mojang.datafixers.util.Pair
//import jdk.internal.org.jline.keymap.KeyMap.key
//import java.util.Optional
//import java.util.stream.Stream
//
//object Types {
//	val keyvalue = DSL.and(DSL.string(), DSL.remainderType())
//}
//
//object VDFOps : DynamicOps<VDFObject> {
//	override fun empty(): VDFObject {
//		return VDFNull // this is used for values that don't have a key, I guess, so it's just liek whatthe fuckeever
//	}
//	/*
//	Instead of parsers returning null, have them return the character at index that made them fail.
//	If the outer parser can adapt to the error ("or"), just discard that, otherwise propogate it up to the previous one
//	 */
//
//	override fun getType(input: VDFObject): Type<*> {
//		return when (input) {
//			is VDFSubtree -> DSL.compoundList(DSL.remainderType(), DSL.remainderType())
//			is VDFPrimitive -> when (input.value) {
//				is String -> DSL.string()
//				is Int -> DSL.intType()
//				is Long -> DSL.longType()
//				is Float -> DSL.floatType()
//				else -> error("")
//			}
//			is VDFKeyValue -> keyvalue
//			is VDFStringLiteral -> DSL.string()
//		}
//	}
//
//	override fun getNumberValue(input: VDFObject): Optional<Number> {
//		return Optional.ofNullable((input as? VDFPrimitive)?.value as? Number)
//	}
//
//	override fun createNumeric(i: Number): VDFObject {
//		return VDFPrimitive(i)
//	}
//
//	override fun getStringValue(input: VDFObject): Optional<String> {
//		return Optional.ofNullable(((input as? VDFPrimitive)?.value as? String) ?: (input as? VDFStringLiteral)?.string)
//	}
//
//	override fun createString(value: String): VDFObject {
//		return VDFStringLiteral(value)
//	}
//
//	override fun mergeInto(input: VDFObject, value: VDFObject): VDFObject {
//		return (input as? VDFList)?.withItem(value) ?: input
//	}
//
//	override fun mergeInto(input: VDFObject, key: VDFObject, value: VDFObject): VDFObject {
//		if (input !is VDFSubtree)
//			return input;
//
//		return input.withEntry(VDFKeyValue(key, value))
//	}
//
//	override fun merge(first: VDFObject, second: VDFObject): VDFObject {
//		return when (first) {
//			is VDFList if second is VDFList -> first.withItems(second.items)
//			is VDFSubtree if second is VDFSubtree -> first.withEntries(second.entries)
//			else -> when {
//				first.isEmpty() -> second
//				second.isEmpty() -> first
//				else -> throw IllegalArgumentException("Could not merge $first and $second")
//			}
//		}
//	}
//
//	override fun getMapValues(input: VDFObject): Optional<Map<VDFObject, VDFObject>> {
//		return Optional.ofNullable((input as? VDFSubtree)?.entries?.associate { it.key to it.value })
//	}
//
//	override fun createMap(map: Map<VDFObject, VDFObject>): VDFObject {
//		return VDFSubtree(map.entries.map { VDFKeyValue(it.key, it.value) })
//	}
//
//	override fun getStream(input: VDFObject): Optional<Stream<VDFObject>> {
//		return Optional.ofNullable((input as? VDFList)?.items?.stream())
//	}
//
//	override fun createList(input: Stream<VDFObject>): VDFObject {
//		return input.toList().let(::VDFList)
//	}
//
//	override fun remove(input: VDFObject, key: String): VDFObject {
//		if (input !is VDFSubtree)
//			return input
//
//		return VDFSubtree(input.entries.filterNot { it.key.let { it is VDFPrimitive && it.value == key }})
//	}
//
//	override fun toString(): String {
//		return "VDF"
//	}
//}