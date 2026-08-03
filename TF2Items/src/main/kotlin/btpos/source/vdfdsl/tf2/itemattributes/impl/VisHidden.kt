package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed

open class VisHidden<T : Any>(
	/**
	 * The version of this attribute that has an entry in the item's description.
	 */
	val visible: ItemAttribute<T>,
	
	/**
	 * The version of this attribute that will not have an entry in the item's description.
	 */
	val hidden: ItemAttribute<T>
) : ItemAttribute<T> by visible

