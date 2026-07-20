package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.types.ItemSlot
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

/**
 * Remove items from this bot by name. This can be used to remove cosmetics, including zombie cosmetics.
 *
 * Example:
 * ```kotlin
 * strippedItems += Cosmetics.ZOMBIE_SPY // removes zombie from this spy
 * ```
 */
var TFBotSpawner.strippedItems: List<TFItem<*>> by addField("StripItem", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)

/**
 * Any weapons in these slots will be removed.
 * 
 * Example:
 * ```kotlin
 * strippedWeaponSlots += listOf(ItemSlot.PRIMARY, ItemSlot.MELEE) // can only use secondary
 * ```
 */
var TFBotSpawner.strippedWeaponSlots: List<ItemSlot> by addField("StripItemSlot", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)