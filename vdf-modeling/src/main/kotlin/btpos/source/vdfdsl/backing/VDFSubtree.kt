package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree

/**
 * A list of keyvalues, wrapped in braces when serialized.
 */
open class VDFSubtree(val parent: VDFSubtree?, val entries: MutableList<VDFKeyValue> = mutableListOf()) : VDFValue(), IVDFRepresentableValue_Subtree, MutableList<VDFKeyValue> by entries {
	constructor(parent: VDFSubtree?, entries: Collection<VDFKeyValue>) : this(parent, entries.toMutableList())
	
	fun withEntry(entry: VDFKeyValue) = this.apply {
		entries += entry
	}
	
	fun withEntries(vararg entries: VDFKeyValue) = this.apply {
		this.entries += entries
	}
	
	fun withEntries(entries: Iterable<VDFKeyValue>) = this.apply {
		this.entries += entries
	}
	
	override fun _vdfRepr(parent: VDFSubtree): VDFSubtree {
		require(parent == this.parent) { "Failed sanity check: VDFSubtree parent '${this.parent}' does not equal the parent given to the function: '$parent'" }
		
		return this;
	}
	
	override fun writeToVDF(writer: Appendable, indent: Int) {
		if (this.parent != null)
			writer.append('{')
		
		val kvindent = indent + if (this.parent == null) 0 else 1
		
		entries.forEach {
			writer.writeLine(kvindent)
			it.writeToVDF(writer, kvindent)
		}
		
		if (this.parent != null)
			writer.writeLine(indent).append('}')
	}
	
	override fun <DATA, RET> accept(visitor: VDFVisitor<DATA, RET>, data: DATA): RET {
		return visitor.visitSubtree(this, data)
	}
	
	override fun <DATA> acceptChildren(visitor: VDFVisitor<DATA, *>, data: DATA) {
		entries.forEach {
			it.accept(visitor, data)
		}
	}
	
	override fun deepCopy(parent: VDFSubtree?) = VDFSubtree(parent ?: this.parent, ArrayList(this.entries.size)).also { newSubtree ->
		for (entry in this.entries) {
			newSubtree.entries += entry.deepCopy(newSubtree)
		}
	}
	
	override fun toString(): String {
		return "VDFSubtree[entries=$entries]"
	}
}

operator fun VDFSubtree.get(index: String) = get(VDFPrimitive.notInterned(index))

operator fun VDFSubtree.get(index: VDFPrimitive) = getSingle(index)


fun VDFSubtree.getSingle(index: String) = getSingle(VDFPrimitive.notInterned(index))
fun VDFSubtree.getSingle(index: VDFPrimitive): VDFObject? {
	return this.entries.filter { it.key == index }.ifEmpty {
		return null;
	}.single().value
}

fun VDFSubtree.getAll(index: String) = getAll(VDFPrimitive.notInterned(index))
fun VDFSubtree.getAll(index: VDFPrimitive): List<VDFObject> {
	return this.entries.asSequence().filter { it.key == index }.map { it.value }.toList()
}

fun VDFSubtree.getSubtree(index: String) = getSubtree(VDFPrimitive.notInterned(index))
fun VDFSubtree.getSubtree(index: VDFPrimitive): VDFSubtree? {
	return this.getSingle(index) as? VDFSubtree
}

fun VDFSubtree.getPrimitive(index: String) = getPrimitive(VDFPrimitive.notInterned(index))
fun VDFSubtree.getPrimitive(index: VDFPrimitive): VDFPrimitive? {
	return (this.getSingle(index) as? VDFPrimitive)
}

fun VDFSubtree.getString(index: String) = getString(VDFPrimitive.notInterned(index))
fun VDFSubtree.getString(index: VDFPrimitive) = getPrimitive(index)?.stringValue


fun VDFSubtree.toMap(): Map<String, VDFObject> {
	val map = this.associate { it.key.stringValue to it.value }
	require(map.size == this.size) {
		"Cannot convert subtree with multiple entries for a single key to a map.\n" +
		"Duplicate keys: ${this.entries.groupBy { it.key }.filterValues { it.size != 1 }.keys.joinToString()}\n" +
		"\n" +
		"Subtree: $this"
	}
	return map
}

fun VDFSubtree.toMultiMap(): Map<String, List<VDFObject>> {
	return this.groupBy({ it.key.stringValue }, { it.value })
}

fun VDFSubtree.getRoot(): VDFSubtree {
	var curr = this
	while (curr.parent != null) {
		curr = curr.parent
	}
	return curr;
}


fun VDFSubtree.addSubtree(identifier: VDFPrimitive, conditional: String? = null) = VDFSubtree(this).also { this.add(VDFKeyValue(identifier, it, conditional)) }