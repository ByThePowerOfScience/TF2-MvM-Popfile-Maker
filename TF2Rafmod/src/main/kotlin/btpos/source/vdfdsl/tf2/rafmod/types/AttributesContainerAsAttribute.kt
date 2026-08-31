package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerImpl
import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute
import btpos.source.vdfdsl.tf2.itemattributes.collectToSubtree
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

/**
 * Serializes to `"attr1|attr1value|attr2|attr2value"`
 */
class AttributesContainerAsAttribute(private val impl: IAttributeContainer = AttributeContainerImpl()) : IAttributeContainer by impl, IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive
		get() {
			val outSubtree = VDFSubtree(null).also {
				collectToSubtree(it)
			}
			
			if (outSubtree.isEmpty())
				return VDFPrimitive.EMPTY
			
			return VDFPrimitive(outSubtree.joinToString("|") {
				it.value.asString ?: error("Attribute not set with a stringifiable value.")
			})
		}
}


context(attrsWithDuration: AttrContainerWithDuration)
fun <T : Any> ItemAttribute<T>.setWithDuration(value: T?, duration: Duration) {
	attrsWithDuration.setWithDuration(this, value, duration)
}
context(attrsWithDuration: AttrContainerWithDuration)
fun <T : Any> ItemAttribute<T>.assign(valueWithDuration: Pair<T, Duration>) {
	attrsWithDuration.setWithDuration(this, valueWithDuration.first, valueWithDuration.second)
}


class AttrContainerWithDuration(
	val defaultDuration: Duration? = null,
	private val attributes: MutableMap<ItemAttribute<Any>, Pair<Any?, Duration?>> = mutableMapOf()
) : IAttributeContainer, IVDFRepresentableValue_Trivial {
	fun <T : Any> setWithDuration(attribute: ItemAttribute<T>, value: T?, duration: Duration?) {
		attributes[attribute as ItemAttribute<Any>] = value to duration
	}
	
	@Suppress("UNCHECKED_CAST")
	override fun <T : Any> get(key: ItemAttribute<T>): T? {
		return attributes[key as ItemAttribute<Any>]?.first as T?
	}
	
	override fun <T : Any> set(key: ItemAttribute<T>, value: T?) {
		attributes[key as ItemAttribute<Any>] = value to defaultDuration
	}
	
	override fun copy() = AttrContainerWithDuration(defaultDuration, attributes.toMutableMap())
	
	override val _vdfRepr: VDFPrimitive
		get() {
			val addedKeysToDurations = attributes.entries.map { (attr, value) ->
				VDFSubtree(null).apply { attr.serialize(value.first)._serializeInto(this, null) } to (value.second ?: run {
					defaultDuration ?: error("Attempted to set $attr = ${value.first} without a duration set, and with no default duration.\nAttributes Container: $this")
				})
			}
			
			if (addedKeysToDurations.isEmpty()) {
				return VDFPrimitive.EMPTY
			}
			
			return VDFPrimitive.notInterned(addedKeysToDurations.joinToString("|") { (addedKeys, duration) ->
				val durationInSeconds = duration.toSeconds()
				addedKeys.joinToString("|") { (k, v) -> "$k|$v|$durationInSeconds" }
			})
		}
	
	override fun iterator(): Iterator<Pair<ItemAttribute<Any>, Any?>> {
		return attributes.entries.asSequence().map { it.key to it.value.first }.iterator()
	}
}