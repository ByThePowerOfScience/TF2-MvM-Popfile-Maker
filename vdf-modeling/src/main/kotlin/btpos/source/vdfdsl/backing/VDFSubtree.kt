package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree

/**
 * A list of keyvalues, wrapped in braces when serialized.
 */
open class VDFSubtree(val parent: VDFSubtree?, val entries: MutableList<VDFKeyValue> = mutableListOf()) : VDFObject(), IVDFRepresentableValue_Subtree, MutableList<VDFKeyValue> by entries {
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
	
	override fun toString(): String {
		return "VDFSubtree[entries=$entries]"
	}
}

operator fun VDFSubtree.get(index: String) = getSingle(index)

fun VDFSubtree.getSingle(index: String): VDFObject? {
	return this.entries.filter { it.key.stringValue == index }.ifEmpty {
		return null;
	}.single().value
}

fun VDFSubtree.getAll(index: String): List<VDFObject> {
	return this.entries.asSequence().filter { it.key.stringValue == index }.map { it.value }.toList()
}

fun VDFSubtree.getSubtree(index: String): VDFSubtree? {
	return this.getSingle(index) as? VDFSubtree
}

fun VDFSubtree.getString(index: String): String? {
	return (this.getSingle(index) as? VDFPrimitive)?.stringValue
}

fun VDFSubtree.toMap(): Map<String, VDFObject> {
	val map = this.associate { it.key.stringValue to it.value }
	require(map.size == this.size) {
		"Cannot convert subtree with multiple entries for a single key to a map.\n" +
		"Duplicate keys: ${this.entries.groupBy { it.key }.filterValues { it.size == 1 }.keys.joinToString()}\n" +
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