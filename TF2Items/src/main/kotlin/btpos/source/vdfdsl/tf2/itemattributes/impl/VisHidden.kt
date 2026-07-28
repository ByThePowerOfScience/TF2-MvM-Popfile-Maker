package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute

data class VisHidden<T : Any>(
	/**
	 * The version of this attribute that has an entry in the item's description.
	 */
	val visible: ItemAttribute<T>,
	
	/**
	 * The version of this attribute that will not have an entry in the item's description.
	 */
	val hidden: ItemAttribute<T>
) : ItemAttribute<T> {
	/**
	 * Overloaded assignment operator to implicitly set the visible one
	 */
	context(attrs: IAttributeContainer)
	override fun assign(value: T?) {
		this.visible.assign(value)
	}
}

