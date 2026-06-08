package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileRepresentable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileQuotedString
import btpos.tf2.popfiledsl.types.bots.Attribute.Internal
import java.util.function.IntFunction

/**
 * Container for [Attribute]s
 */
open class AttributeContainer(val identifier: String, val attributes: ArrayList<Attribute> = ArrayList()) : IPopFileRepresentable<PopFileEntry>, MutableList<Attribute> by attributes {
	override val popFileRepr
		get() = PopFileEntry(identifier, attributes.map { it.popFileRepr })
	
	override fun add(element: Attribute): Boolean {
		if (size >= 15)
			throw IndexOutOfBoundsException("Too many attributes added to attribute container. TF2 can only hold 15 item attributes.\nContainer: $attributes")
		return attributes.add(element)
	}
	
	fun <T> get(name: String): T? {
		return attributes.firstOrNull { it is Internal.StringAttribute && it.key == name }?.value as T?
	}
	
	fun set(name: String, value: Any?) {
		if (value == null) {
			attributes.removeIf { it is Internal.StringAttribute && it.key == name }
			return
		}
		
		val new = Internal.StringAttribute(name, value)
		when (val idx = attributes.indexOfFirst { it is Internal.StringAttribute && it.key == name }) {
			-1 -> add(new)
			else -> set(idx, new)
		}
	}
	
	@Deprecated(level=DeprecationLevel.HIDDEN, message="Only included because the compiler yells at me if I don't include this.")
	override fun <T> toArray(generator: IntFunction<Array<out T>>): Array<out T> {
		return attributes.toArray(generator.apply(0))
	}
}

class ItemAttributeContainer(itemName: String) : AttributeContainer("ItemAttributes") {
	companion object {
		val ITEM_NAME = Internal.LiteralAttributeTemplate("ItemName")
	}
	
	init {
		attributes += ITEM_NAME(itemName)
	}
	
}

object WarPaints {
//	var AttributeContainer.WARPAINT_ID by stringAttribute<Int>("paintkit_proto_def_index")
//	var AttributeContainer.WARPAINT_WEAR by stringAttribute<Double>("set_item_texture_wear")
	
	context(attr: AttributeContainer)
	var ID: Int?
		get() = attr.get("paintkit_proto_def_index")
		set(value) = attr.set("paintkit_proto_def_index", value)
	
	enum class Wear(val id: Double) {
		FACTORY_NEW(0.2),
		//TODO
	}
}

object Paint {
	context(attr: AttributeContainer)
	var COLOR: Int?
		get() = attr.get("item color rgb")
		set(value) = attr.set("item color rgb", value)
	
}

sealed class Attribute : IPopFileRepresentable<Pair<Any, Any>> {
	abstract val key: Any
	abstract val value: Any
	
	/**
	 * Backend stuff to make it easier to understand on your side.
	 * Don't worry about these.
	 */
	object Internal {
		internal class LiteralAttribute(override val key: String, override val value: Any) : Attribute() {
			override val popFileRepr
				get() = Pair(key, value)
		}
		
		internal class StringAttribute(override val key: String, override val value: Any) : Attribute() {
			override val popFileRepr: Pair<Any, Any>
				get() = Pair(PopFileQuotedString(key), value)
		}
		
		/**
		 * Attribute "template"
		 */
		class LiteralAttributeTemplate(val keyword: String) {
			fun with(value: Any): Attribute = LiteralAttribute(keyword, value)
			
			operator fun invoke(value: Any) = with(value)
		}
		
		class StringAttributeTemplate(val name: String) {
			fun with(value: Any): Attribute = StringAttribute(name, value)
			
			operator fun invoke(value: Any) = with(value)
		}
	}
	
	companion object {
		val ITEM_NAME = Internal.LiteralAttributeTemplate("ItemName")
		
	}
	
	
}


