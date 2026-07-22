package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamed
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.utils.delegates.withSetter

/**
 * Base class for Add/RemoveAttribute. Only has a single attribute and an item it's applied to.
 */
abstract class SingleAttributeBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodBotExtension(subtree), IKeyValueMap {
	companion object {
		val FIELD_ITEM = VDFPrimitive("Item")
		val FIELD_NAME = VDFPrimitive("Name")
		val FIELD_VALUE = VDFPrimitive("Value")
		
		val VALUE_PLAYER = VDFPrimitive("Player")
		val VALUE_ACTIVE = VDFPrimitive("Active")
	}
	
	abstract override fun copy(): SingleAttributeBotExt
	
	/**
	 * Applies the specified attribute to the current bot.
	 */
	val player = object {}
	
	/**
	 * Applies the specified attribute to whatever the bot's active weapon is.
	 */
	val activeWeapon = object {}
	
	/**
	 * What this attribute should be applied to.
	 *
	 * Must be [player], [activeWeapon], or a [TFItem].
	 */
	var target: Any? by selfNamed<Any> { target ->
		when (target) {
			player -> VDFKeyValue(FIELD_ITEM, VALUE_PLAYER)
			activeWeapon -> VDFKeyValue(FIELD_ITEM, VALUE_ACTIVE)
			else -> IVDFRepresentableValue.serializeDynamic(FIELD_ITEM, target)
		}
	}.withSetter {
		if (!(it is TFItem<*> || it == player || it == activeWeapon)) {
			Result.failure(IllegalArgumentException("Invalid target type \"${it?.javaClass?.name}\" for Add/Remove-Attribute block.\n" +
			                                        "Valid targets:\n" +
			                                        "- TFItem instance (attribute applies to that weapon)\n" +
			                                        "- `player` (attribute applies to current player)\n" +
			                                        "- `activeWeapon` (attribute applies to the player's active weapon)"))
		} else Result.success(it)
	}
	
	/**
	 * The single attribute being set in this block.
	 *
	 * Since this block only supports a single attribute, any successive additions to this object as an [IKeyValueMap] will overwrite the current value stored in this field.
	 */
	protected var value: Pair<String, Any>? by selfNamed { (k, v) ->
		IVDFRepresentableKeyValue { subtree ->
			subtree += VDFKeyValue(FIELD_NAME, VDFPrimitive(k))
			IVDFRepresentableValue.serializeDynamic(FIELD_VALUE, v)._serializeInto(subtree)
		}
	}
	
	override fun <FRONTEND : Any> getTyped(key: String, codec: Codec<FRONTEND, Any>): FRONTEND? {
		return value?.takeIf { it.first == key }?.second?.let(codec::read)
	}
	
	override fun <FRONTEND : Any> setNullable(key: String, value: FRONTEND?, codec: Codec<FRONTEND, Any>) {
		if (value == null) {
			this.value = null
		} else {
			this.value = key to value
		}
	}
}

class AddAttributeBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : SingleAttributeBotExt(subtree) {
	override val _structIdentifier: String
		get() = "AddAttribute"
	
	override fun copy() = AddAttributeBotExt(copyInternal())
}

class RemoveAttributeBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : SingleAttributeBotExt(subtree) {
	override val _structIdentifier: String
		get() = "RemoveAttribute"
	
	override fun copy() = RemoveAttributeBotExt(copyInternal())
}