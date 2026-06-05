package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileItem
import btpos.tf2.popfiledsl.serialization.NamedMap
import java.util.function.IntFunction

/**
 * Container for [ItemAttribute]s
 */
class ItemAttributes(val attributes: ArrayList<ItemAttribute> = ArrayList()) : IPopFileItem<NamedMap>, MutableList<ItemAttribute> by attributes {
	override val popFileRepr
		get() = NamedMap("ItemAttributes", attributes.associate { it.key to it.value })
	
	@Deprecated(level=DeprecationLevel.HIDDEN, message="Only included because the compiler yells at me if I don't include this.")
	override fun <T> toArray(generator: IntFunction<Array<out T>>): Array<out T> {
		return attributes.toArray(generator.apply(0))
	}
}

data class ItemAttribute(val key: Any, val value: Any)

object WarPaints {
	context(attrs: ItemAttributes)
	fun byId(id: Int, wear: Wear) {
		attrs.add(ItemAttribute("paintkit_proto_def_index", id))
		attrs.add(ItemAttribute("set_item_texture_wear", wear.id))
	}
	
	enum class Wear(val id: Double) {
		FACTORY_NEW(0.2),
		//TODO
	}
}