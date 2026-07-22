package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.cacheData
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.compose
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.spawners.TFBotSpawner
import btpos.source.vdfdsl.utils.MutableImmutableMapView
import java.awt.Color


private val FIELD_ITEMNAME = VDFPrimitive("ItemName")
private val FIELD_RED = VDFPrimitive("Red")
private val FIELD_GREEN = VDFPrimitive("Green")
private val FIELD_BLUE = VDFPrimitive("Blue")

internal var TFBotSpawner._itemColors: Map<TFItem<*>, Color> by addField(
	serializationKey = "ItemColor",
	conditional = SIGSEGV,
	initialValue = ::mapOf,
	serializer = flatListWithKey<IVDFRepresentableValue_Subtree>().compose { map ->
		map.asSequence().map { (item, color) ->
			IVDFRepresentableValue_Subtree { parent ->
				VDFSubtree(
					parent,
					mutableListOf(
						VDFKeyValue(FIELD_ITEMNAME, item.namePrimitive),
						VDFKeyValue(FIELD_RED, VDFPrimitive(color.red)),
						VDFKeyValue(FIELD_GREEN, VDFPrimitive(color.green)),
						VDFKeyValue(FIELD_BLUE, VDFPrimitive(color.blue)),
					)
				)
			}
		}.asIterable()
	}
)


/**
 * Rafmod bot extension. Set the color of an item.
 *
 * Usage:
 * ```kotlin
 * itemColors[Weapons.GUNBOATS] = Color(255, 0, 0)
 * ```
 */
val TFBotSpawner.itemColors: MutableMap<TFItem<*>, Color> by cacheData { thisRef, _ ->
	MutableImmutableMapView(thisRef::_itemColors::get, thisRef::_itemColors::set)
}