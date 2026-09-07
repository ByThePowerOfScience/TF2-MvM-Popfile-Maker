package btpos.source.vdfdsl.tf2.codegen

import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.expressions.KtGetValueExpression
import btpos.misc.kt.codegen.identifiers.KtMemberReference
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.statements.KtAssignment
import btpos.misc.kt.codegen.util.ReflectionUtils.declaredMemberPropertiesGettable
import btpos.misc.kt.codegen.util.ReflectionUtils.getUpperBounds
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.source.vdfdsl.backing.intValue
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.Decoders
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.WeirdMutableIterableSubtree
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttribute
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed
import btpos.source.vdfdsl.tf2.itemattributes.impl.ItemAttributeLong
import btpos.misc.kt.codegen.util.ReflectionUtils.actuallyGet
import btpos.source.vdfdsl.util.forEachWithLazyIter
import btpos.source.vdfdsl.util.mapCompact
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.extensionReceiverParameter

typealias PutItemKeyWithDecoderForAttributeType = (ItemAttribute<*>, propertyAccessForThisAttribute: KtGetValueExpression, MutableMap<VDFPrimitive, ValueDecoder<KtStatement>>) -> Unit

/**
 * Singleton for automatically creating codegen mappings for each attribute using reflection.
 *
 * Instantiated by a CodegenProvider at [btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer.CODEGEN_ATTRS]
 */
class AttributesCodegenTraverser {
	/**
	 * The objects containing attributes that should be called in code to access different item attributes for each scope.
	 * Instances of each interface, such as the `Inherited` object.
	 *
	 * Should be populated in a [btpos.source.vdfdsl.codegen.services.TypeDecoderProvider]
	 * before any codegen is actually dispatched.
	 */
	val instancesToCheck = mutableListOf<Any>()
	
	/**
	 * Extension properties that should be added to the codegen to be assembled
	 */
	val extensionProperties = mutableListOf<KProperty1<*, *>>()
	
	/**
	 * How each subclass of [ItemAttribute] should have its values decoded. TODO explain better
	 *
	 * See [AttributesCodegenTraverser]'s initializer for an example.
	 */
	val attributeTypeInitializers = mutableMapOf<KClass<out ItemAttribute<*>>, PutItemKeyWithDecoderForAttributeType>()
	
	
	init {
		attributeTypeInitializers[ItemAttributeNamed::class] = { attr, getThisProp, items ->
			val attr = attr as ItemAttributeNamed<*>
			items[attr.key] = ValueDecoder { value, parent ->
				Decoders.getValueDecoder(attr.type)
					?.decodeValue(value, parent)
					?.mapCompact { KtAssignment(getThisProp, it) }
			}
		}
		attributeTypeInitializers[ItemAttributeLong::class] = { attr, pathToThis, items ->
			val attr = attr as ItemAttributeLong
			// consume and concatenate lowbits and highbits no matter which was read first:
			items[attr.lowBits.key] = ValueDecoder { value, parent ->
				val lowbits = value.asPrimitive?.intValue ?: return@ValueDecoder null;
				var highbits: Int? = null
				parent.forEachWithLazyIter {
					if (highbits != null)
						return@forEachWithLazyIter;
					
					if (it.key == attr.highBits.key) {
						highbits = it.value.asPrimitive?.intValue ?: return@forEachWithLazyIter;
						remove()
					}
				}
				if (highbits == null)
					return@ValueDecoder listOf(KtAssignment(pathToThis.copy(), Codegen.code(lowbits.toString())))
				else
					return@ValueDecoder listOf(KtAssignment(pathToThis.copy(), Codegen.code(highbits.toString() + lowbits.toString())))
			}
			items[attr.highBits.key] = ValueDecoder { value, parent ->
				val highbits = value.asPrimitive?.intValue ?: return@ValueDecoder null;
				var lowbits: Int? = null
				parent.forEachWithLazyIter {
					if (lowbits != null)
						return@forEachWithLazyIter;
					
					if (it.key == attr.lowBits.key) {
						lowbits = it.value.asPrimitive?.intValue ?: return@forEachWithLazyIter;
						remove()
					}
				}
				if (lowbits == null)
					return@ValueDecoder listOf(KtAssignment(pathToThis.copy(), Codegen.code(highbits.toString() + "0".repeat(32))))
				else
					return@ValueDecoder listOf(KtAssignment(pathToThis.copy(), Codegen.code(highbits.toString() + lowbits.toString())))
			}
		}
	}
	
	private fun handleExtensionProperties(properties: Iterable<KProperty1<Any, Any>>, outMap: MutableMap<VDFPrimitive, ValueDecoder<KtStatement>>) {
		/**
		 * For each class `XAttributes.SomeSubScope`, maps to its getter `XAttributes.Inherited.getSomeSubScope`
		 */
		val mapOfClassToScopePath = HashMap<KClass<*>, Pair<Any, KtGetValueExpression>>()
		
		//region find the navigation from each property to each whatever the fuck
		fun calcScopePropGetRecursive(cls: KClass<*>, inst: Any, getThisInst: KtGetValueExpression?) {
			val nesteds = cls.nestedClasses.filterNotTo(mutableSetOf()) { it.simpleName == "Inherited" }
			
			cls.declaredMemberPropertiesGettable().forEach { prop ->
				// if prop returns an inner class, it's a scope that needs to be recorded.
				(prop.returnType.classifier as? KClass<*>)?.takeIf { it in nesteds }?.let {
					val get = KtGetValueExpression(KtMemberReference(prop), getThisInst)
					val propValue = prop.actuallyGet(inst)
					mapOfClassToScopePath[it] = propValue to get
					calcScopePropGetRecursive(it, propValue, get)
				}
			}
		}
		
		instancesToCheck.forEach { inst ->
			val cls = inst::class.let {
				if (it.simpleName == "Inherited") {
					it.java.declaringClass?.kotlin ?: it
				} else it
			}
			
			calcScopePropGetRecursive(cls, inst, null)
		}
		//endregion
		
		
		properties.forEach { prop ->
			val extOf = prop.extensionReceiverParameter ?: return@forEach;
			val (scopeInst, getScopeVar) = extOf.type.classifier
												?.getUpperBounds() // some extension properties might be <T : WeaponBaseAttributes> hatever idfk no that wouldn't make sense they should ust use WeaponBaseAttributes.propName
												?.firstNotNullOfOrNull { mapOfClassToScopePath[it] }
					                                ?: return@forEach;
			
			attributeTypeInitializers[prop.returnType.classifier]?.invoke(prop.actuallyGet(scopeInst) as ItemAttribute<*>, KtGetValueExpression(KtMemberReference(prop), getScopeVar), outMap)
				?: defaultInitializer(prop.actuallyGet(scopeInst), KtGetValueExpression(KtMemberReference(prop), getScopeVar), outMap)
		}
	}
	
	private fun Any.handleItemAttribute(qualifier: KtGetValueExpression?, propName: String, items: MutableMap<VDFPrimitive, ValueDecoder<KtStatement>>) {
		val getThisProp = KtGetValueExpression(KtName(propName), receiver = qualifier)
		
		if (this is ItemAttribute<*>)
			(attributeTypeInitializers[this::class] ?: ::defaultInitializer).invoke(this, getThisProp, items)
		else
			defaultInitializer(this, getThisProp, items)
	}
	
	private fun defaultInitializer(attr: Any, getThisProp: KtGetValueExpression, items: MutableMap<VDFPrimitive, ValueDecoder<KtStatement>>) {
		// we assume any properties that can't be decoded normally are a scope that holds other attributes
		
		for (property in attr::class.declaredMemberProperties) {
			@Suppress("UNCHECKED_CAST")
			val inst = (property as KProperty1<Any, Any>).actuallyGet(attr)
			inst.handleItemAttribute(getThisProp, property.name, items)
		}
	}
	
	/**
	 * Make the IAttributeContainer default code generator
	 */
	fun build(): IAttributeContainerCodegen {
		val items = HashMap<VDFPrimitive, ValueDecoder<KtStatement>>()
		
		/*
		for each class to check:
		- For each property P:
		  - If it's an ItemAttributeNamed, add `pathToP.P = it.key`
		  - If it's a BonusPenalty-typed thing, add `pathToP.P.bonus = it.bonus.key`, etc.
		  - If it's a nested scope, recurse and continue, adding the current P to the pathToP
		 */
		
		instancesToCheck.forEach { inst ->
			inst::class.declaredMemberPropertiesGettable().forEach { prop ->
				prop.actuallyGet(inst).handleItemAttribute(null, prop.name, items)
			}
		}
		
		val extPRops = extensionProperties as List<KProperty1<Any, Any>>
		
		handleExtensionProperties(extPRops, items)
		// TODO test this shit 
		
		return IAttributeContainerCodegen(items)
	}
	
	/**
	 * Decodes [btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer] subtrees
	 */
	class IAttributeContainerCodegen(val attributeLocations: MutableMap<VDFPrimitive, ValueDecoder<KtStatement>> = HashMap()) {
		fun decodeToLambdaLines(subtree: WeirdMutableIterableSubtree): List<KtStatement> {
			val out = mutableListOf<KtStatement>()
			
			subtree.forEachWithLazyIter { (key, item) ->
				val it = attributeLocations[key]?.decodeValue(item, subtree)
				if (it.isNullOrEmpty())
					return@forEachWithLazyIter;
				
				out += it
				remove()
			}
			
			return out
		}
	}
}
