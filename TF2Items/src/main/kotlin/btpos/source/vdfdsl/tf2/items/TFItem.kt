package btpos.source.vdfdsl.tf2.items

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtLambda
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.VDFValue
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.backing.getPrimitive
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.SelfNamedDecoder
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.SafeRemovalVDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerImpl
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerSubtreeSerializable
import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed
import btpos.source.vdfdsl.tf2.items.weapons.Weapons
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsMelee
import btpos.source.vdfdsl.util.forEachWithIter

typealias AttributeConfigurationScope<T> = context(IAttributeContainer) T.() -> Unit

@PopFileDSL
class TFItem<ATTR : Any>(
	val name: String,
	val attributes: AttributeContainerSubtreeSerializable? = null,
	val scopedAttributeFunctions: ATTR,
	private val conditional: String? = null
) : IVDFRepresentableKeyValue
{
	val namePrimitive = VDFPrimitive(name)
	
	override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
		input +=
			listOfNotNull(
				VDFKeyValue(VDFPrimitive("Item"), namePrimitive, forcedConditional),
				VDFKeyValue.orNull(
					VDFPrimitive("ItemAttributes"),
					attributes?._vdfRepr(input)?.withEntry(VDFKeyValue(VDFPrimitive("ItemName"), namePrimitive, null)),
					forcedConditional ?: conditional
				)
		)
	}
	
	/**
	 * Create a new instance of this item with the provided attributes added.
	 *
	 * Example:
	 * ```kotlin
	 * val myItem = Weapons.HUNTSMAN.withAttributes {
	 *   damage.multDmg.bonus = 1.5
	 * }
	 * ```
	 */
	inline fun withAttributes(attributesScope: context(IAttributeContainer) ATTR.() -> Unit): TFItem<ATTR> {
		val attrs = attributes?.copy() ?: AttributeContainerSubtreeSerializable()
		configureAttributes(attrs, attributesScope)
		return this.copy(attributes=attrs)
	}
	
	/**
	 * Create a copy of this item with the provided attributes added.
	 */
	inline operator fun invoke(attributesScope: context(IAttributeContainer) ATTR.() -> Unit) = withAttributes(attributesScope)
	
	/**
	 * Just configure an attributes map in the _context_ of an item's allowed attributes, without creating a new TFItem object for it.
	 *
	 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
	 *
	 *
	 * Example:
	 * ```kotlin
	 * // Will have `ItemName "The Huntsman"`, along with the attributes.
	 * val myHuntsmanAttributes: AttributeContainerImpl = Weapons.HUNTSMAN.configureAttributes(AttributeContainerImpl()) {
	 *   damage.multDmg.bonus = 1.5
	 * }
	 * ```
	 */
	inline fun <MAP : IAttributeContainer> configureAttributes(map: MAP, configure: context(MAP) ATTR.() -> Unit): MAP {
		return map.apply {
			scopedAttributeFunctions.configure()
			this.set(ItemName, this@TFItem.name)
		}
	}
	
	/**
	 * Create a new attributes map in the _context_ of an item's allowed attributes, without creating a new TFItem object for it as well.
	 *
	 * This is generally only needed if you're using a template that already has an item set on it, and you just want to configure that item.
	 *
	 *
	 * Example:
	 * ```kotlin
	 * // Will have `ItemName "The Huntsman"`, along with the attributes.
	 * val myHuntsmanAttributes: AttributeContainerImpl = Weapons.HUNTSMAN.configureAttributes {
	 *   damage.multDmg.bonus = 1.5
	 * }
	 * ```
	 */
	inline fun configureAttributes(configurationScope: context(AttributeContainerImpl) ATTR.() -> Unit): AttributeContainerImpl {
		return configureAttributes(AttributeContainerImpl(), configurationScope)
	}
	
	fun copy(name: String = this.name, attributes: AttributeContainerSubtreeSerializable? = this.attributes?.copy(), conditional: String? = this.conditional): TFItem<ATTR> {
		return TFItem(name, attributes, this.scopedAttributeFunctions, conditional)
	}
	
	companion object {
		@Suppress("RemoveRedundantQualifierName", "RedundantSuppression")
		val WeaponsByClass get() = btpos.source.vdfdsl.tf2.items.weapons.WeaponsByClass
		
		val WeaponsByName get() = Weapons
		
		val MeleeWeapons get() = WeaponsMelee
		
		val ItemName = ItemAttributeNamed<String>("ItemName")
		
		val CODEGEN = CodegenProvider {
			Codegen()
		}
	}

	/*
	So, this needs to:
	- find all `Item` keys, and do += thatItem
	- for each one of those, find all `ItemAttributes { ItemName thatItemName }` blocks and combine them into the items
	 */
	// this should be a singleton
	class Codegen : SelfNamedDecoder<KtExpression>, ValueDecoder<KtExpression> {
		val itemNameToTFItemInstance: MutableMap<VDFPrimitive, KtExpression> = HashMap()
		
		private val key_item = VDFPrimitive("Item")
		private val key_itemName = VDFPrimitive("ItemName")
		private val key_itemAttributes = VDFPrimitive("ItemAttributes")
		
		override fun decodeValue(value: VDFValue, parentSubtree: SafeRemovalVDFSubtree): List<KtExpression>? {
			return value.asPrimitive?.let { itemNameToTFItemInstance[it] }?.let { listOf(it) }
		}
		
		
		override fun decode(subtree: SafeRemovalVDFSubtree): List<KtExpression> {
			val itemsToAttributesSubtree = HashMap<VDFPrimitive, KtLambda?>()
			
			fun findAllItemKeys() {
				subtree.forEachWithIter { kv ->
					if (kv.key == key_item) {
						val itemPrim = kv.value.asPrimitive
											   ?.takeIf { it in itemNameToTFItemInstance }
								               ?: return@forEachWithIter;
						
						itemsToAttributesSubtree[itemPrim] = null // add it to the keyset
						
						remove()
					}
				}
			}
			
			fun findAssociatedItemAttributes() {
				subtree.forEachWithIter { kv ->
					if (kv.key != key_itemAttributes)
						return@forEachWithIter;
					
					val attrSubtree = kv.value.asSubtree ?: return@forEachWithIter;
					
					val itemAttrsAreFor = attrSubtree.getPrimitive(key_itemName)
													 ?.takeIf { it in itemsToAttributesSubtree }
			                                         ?: return@forEachWithIter;
					
					// make sure it can actually be decoded first before removing it from the subtree
					val decoded = IAttributeContainer.CODEGEN_SCOPE.get().let {
						it.decodeToLambdaLines(
							SafeRemovalVDFSubtree(subtree, attrSubtree.deepCopy().apply {
								removeIf { it.key == key_itemName }
							})
						)
					}
					
					if (attrSubtree.isNotEmpty() && decoded.isEmpty())
						return@forEachWithIter;
					
					itemsToAttributesSubtree[itemAttrsAreFor] = KtLambda(lines=decoded)
					
					remove()
				}
			}
			
			findAllItemKeys()
			findAssociatedItemAttributes()
			
			return itemsToAttributesSubtree.map { (itemName, attributes) ->
				itemToCode(itemName, attributes)
			}
		}
		
		private fun itemToCode(itemName: VDFPrimitive, attributes: KtLambda?): KtExpression {
			val itemVariableGet = itemNameToTFItemInstance[itemName]!!
			
			if (attributes == null) {
				return itemVariableGet;
			}
			
			return itemVariableGet.withAttributes(attributes)
		}
		
		private fun KtExpression.withAttributes(attributesScope: KtLambda): KtExpression {
			return KtFunctionCall(KtName(TFItem<*>::withAttributes.name), listOf(attributesScope)).also {
				it.receiver = this
			}
		}
	}
}