package btpos.source.vdfdsl.backing

interface VDFVisitor<DATA, RET> {
	fun visitObject(obj: VDFObject, data: DATA): RET
	
	fun visitKeyValue(obj: VDFKeyValue, data: DATA): RET = visitObject(obj, data)
	
	fun visitPrimitive(obj: VDFPrimitive, data: DATA): RET = visitObject(obj, data)
	
	fun visitSubtree(obj: VDFSubtree, data: DATA): RET = visitObject(obj, data)
}