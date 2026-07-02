package btpos.source.vdfdsl.backing

import com.mojang.serialization.DataResult


/**
 * Raw data directly representative of the VDF.
 */
sealed class VDFObject

fun VDFObject.isNil() = this === VDFNull


val VDFObject.asSubtree: DataResult<VDFSubtree>
	get() = (this as? VDFSubtree)?.let { DataResult.success(it) } ?: DataResult.error { "Not a subtree: $this" }

val VDFObject.asPrimitive: DataResult<VDFPrimitive>
	get() = (this as? VDFPrimitive)?.let { DataResult.success(it) } ?: DataResult.error { "Not a primitive: $this" }