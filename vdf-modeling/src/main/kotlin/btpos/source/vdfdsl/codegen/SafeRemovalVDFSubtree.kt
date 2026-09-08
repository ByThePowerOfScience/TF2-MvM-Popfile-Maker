package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.util.ConcurrentRemovalLinkedList

/**
 * // idea: a singly-linked list where items can be removed from anywhere without affecting iteration order
 * 	// We mark each node as "in the list" if it's still there or "not in the list" if it's been removed.
 * 	// Since no elements can be added, only removed, we just skip over anything that's been removed
 * 	//      until we find the next item that's actually in the list and relink ourselves to that one
 *
 */
class SafeRemovalVDFSubtree(
	val parent: SafeRemovalVDFSubtree?,
	original: VDFSubtree
) : MutableCollection<VDFKeyValue> by ConcurrentRemovalLinkedList(original) {
	/**
	 * Returns this wrapped in a VDFSubtree instance.
	 *
	 * Any changes to the resulting subtree will be reflected in this collection.
	 */
	fun asSubtree(): VDFSubtree = VDFSubtree(parent?.asSubtree(), this)
	
	fun getRoot(): SafeRemovalVDFSubtree {
		var curr = this
		while (curr.parent != null) {
			curr = curr.parent
		}
		return curr;
	}
}