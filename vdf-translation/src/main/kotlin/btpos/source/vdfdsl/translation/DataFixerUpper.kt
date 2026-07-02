package btpos.source.vdfdsl.translation

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFList
import btpos.source.vdfdsl.backing.VDFNull
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asList
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.backing.isNil
import btpos.source.vdfdsl.backing.withListItem
import btpos.source.vdfdsl.vdfparser.component1
import btpos.source.vdfdsl.vdfparser.component2

import com.mojang.datafixers.DSL
import com.mojang.datafixers.util.Pair
import com.mojang.serialization.DataResult
import com.mojang.serialization.DynamicOps
import com.mojang.serialization.MapLike
import java.util.Optional
import java.util.stream.Collectors.toList
import java.util.stream.Stream

fun <T> T.dataResult() = DataResult.success(this)

inline fun <T> DataResult<T>.recover(ifError: (DataResult.Error<T>) -> DataResult<T>): DataResult<T> {
	if (this is DataResult.Error) {
		return ifError(this)
	}
	return this
}

object Types {
	val keyvalue = DSL.and(DSL.string(), DSL.remainderType())
}

object VDFOps : DynamicOps<VDFObject> {
	override fun empty(): VDFObject {
		return VDFNull // this is used for values that don't have a key, I guess, so it's just liek whatthe fuckeever
	}
	
	override fun <U : Any> convertTo(outOps: DynamicOps<U>, input: VDFObject): U {
		TODO("Not yet implemented")
	}
	/*
	Instead of parsers returning null, have them return the character at index that made them fail.
	If the outer parser can adapt to the error ("or"), just discard that, otherwise propogate it up to the previous one
	 */

//	override fun getType(input: VDFObject): Type<*> {
//		return when (input) {
//			is VDFSubtree -> DSL.compoundList(DSL.remainderType(), DSL.remainderType())
//			is VDFPrimitive -> DSL.string()
//			is VDFKeyValue -> keyvalue
//			is VDFNull -> DSL.emptyPartType()
//			is VDFList -> DSL.list(DSL.remainderType())
//		}
//	}

	override fun getNumberValue(input: VDFObject): DataResult<Number> {
		return (input as? VDFPrimitive)?.let { it.numberValue }?.let { DataResult.success(it) }
		       ?: DataResult.error { "Not a number: $input" }
	}

	override fun createNumeric(i: Number): VDFObject {
		return VDFPrimitive.fromNumber(i)
	}
	
	override fun getBooleanValue(input: VDFObject): DataResult<Boolean> {
		return (input as? VDFPrimitive)?.let { it.booleanValue }?.let { DataResult.success(it) }
		       ?: DataResult.error { "Not a boolean: $input" }
	}
	
	override fun createBoolean(value: Boolean): VDFObject {
		return VDFPrimitive(value)
	}
	
	override fun getStringValue(input: VDFObject): DataResult<String> {
		return (input as? VDFPrimitive)?.let { DataResult.success(it.stringValue) }
		       ?: DataResult.error { "Not a string: $input" }
	}

	override fun createString(value: String): VDFObject {
		return VDFPrimitive(value)
	}
	
	override fun mergeToList(list: VDFObject, value: VDFObject): DataResult<VDFObject> {
		if (list.isNil()) {
			if (value.isNil())
				return VDFSubtree().dataResult()
			return DataResult.success(VDFSubtree(listOf(VDFKeyValue(value, VDFPrimitive.TRUE))))
		} else if (list is VDFSubtree) {
			if (value.isNil())
				return list.dataResult()
			return list.withListItem(value).dataResult()
		} else {
			return DataResult.error({ "mergeToList called with not a list: $list" }, list)
		}
	}
	
	override fun mergeToMap(map: VDFObject, key: VDFObject, value: VDFObject): DataResult<VDFObject> {
		if (key !is VDFPrimitive)
			return DataResult.error({ "key is not a primitive: $key" }, map)
		
		return if (map.isNil()) {
			VDFSubtree(listOf(VDFKeyValue(key, value))).dataResult()
		} else if (map is VDFSubtree) {
			map.withEntry(VDFKeyValue(key, value)).dataResult()
		} else {
			DataResult.error({ "mergeToMap called with not a map: $map" }, map)
		}
	}
	
	override fun mergeToMap(map: VDFObject, values: MapLike<VDFObject>): DataResult<VDFObject> {
	
	}
	
	override fun getMapValues(input: VDFObject): DataResult<Stream<Pair<VDFObject, VDFObject>>> {
		if (input is VDFSubtree) {
			return DataResult.success(input.entries.stream().map { Pair(it.key, it.value) })
		} else {
			return DataResult.error({ "Not a subtree: $input" })
		}
	}
	
	
	override fun createMap(map: Stream<Pair<VDFObject, VDFObject>>): VDFObject {
		return VDFSubtree(map.map { (k, v) ->
			if (k !is VDFPrimitive)
				throw IllegalArgumentException("Key '$k' is not a primitive.")
			VDFKeyValue(k, v)
		}.toList())
	}
	
	override fun createMap(map: Map<VDFObject, VDFObject>): VDFObject {
		return VDFSubtree(map.entries.map { (k, v) ->
			if (k !is VDFPrimitive) {
				throw IllegalArgumentException("Key '$k' is not a primitive.\nFrom map: $map")
			}
			VDFKeyValue(k, v)
		})
	}

	override fun getStream(input: VDFObject): DataResult<Stream<VDFObject>> {
		if (input is VDFSubtree) {
			return (input.entries.stream().map { it as VDFObject }).dataResult()
		} else {
			return DataResult.error { "Not a subtree: $input" }
		}
	}

	override fun createList(input: Stream<VDFObject>): VDFObject {
		return input.map {  }.toList().let { VDFSubtree }
	}

	override fun remove(input: VDFObject, key: String): VDFObject {
		if (input !is VDFSubtree)
			return input

		return VDFSubtree(input.entries.filterNot { it.key.let { it is VDFPrimitive && it.stringValue == key } })
	}

	override fun toString(): String {
		return "VDF"
	}
}