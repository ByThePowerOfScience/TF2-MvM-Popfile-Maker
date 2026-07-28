package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.hierarchiesByName
import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import java.util.stream.Collectors.toList
import kotlin.collections.map

class HierarchyNamedAttributeScope(scopeName: String, val extendsFrom: String?, vararg attrs: ISortedNamedAttribute, notes: List<String> = emptyList())
	: NamedAttributeScope(scopeName, attrs = attrs, notes)
{
	fun getParentsRecursive(): Sequence<HierarchyNamedAttributeScope> {
		return generateSequence(getParent()) { it.getParent() }
	}
	
	fun getParent(): HierarchyNamedAttributeScope? {
		return this.extendsFrom?.let { hierarchiesByName[it] }
	}
	
	init {
		hierarchiesByName[scopeName] = this
	}
	
	override fun clone(): ISortedNamedAttribute {
		return HierarchyNamedAttributeScope(_scopeName, extendsFrom, attrs=attrs.map { it.clone() }.toTypedArray(), notes)
	}
	
	override fun generateNestedTypes(baseHierarchyItem: HierarchyNamedAttributeScope, currentPath: List<String>): List<ClassBuilder> {
		return emptyList()
	}
	
	private var cacheTopLevelMember: ClassBuilder? = null
	
	override fun generateTopLevelType(): ClassBuilder {
		cacheTopLevelMember?.let {
			return it;
		}
		
		// what do I need to do here?
		
		/*
		1. Make sure any attributes that are base-level are JUST overridden with additional documentation
			and NOT actually given new items
		2. Store all custom attributes in the companion object
		3. Make the interface extend its parent, and include getters that wire to the items in the companion
		4. Put any nested types in here
		5. For the entire tree of nested classes coming from here, make sure that any type that exists in
			the parent version of this is extended by this subclass's nested version
		 */
		
		
		
		val interfaceBuilder = ClassBuilder(clsname, ClassBuilder.Type.INTERFACE)
		
		val directParent = getParent()?.generateTopLevelType()
		val allParents = getParentsRecursive().map { it.generateTopLevelType() }.toList()
		
		
		fun PropertyBuilder.isOverridden() = allParents.any { this in it }
		
		
		val attrProperties = attrs.map { it.propertyBuilder() }
		
		interfaceBuilder.companionObject = ClassBuilder("", ClassBuilder.Type.COMPANION_OBJECT) {
			addProperties(
				if (allParents.isEmpty())
					attrProperties
				else
					attrProperties.filterNot { it.isOverridden() }
			)
		}
		
		interfaceBuilder.addProperties(
			if (allParents.isEmpty()) {
				attrProperties.onEach {
					it.modality = PropertyBuilder.Modality.OPEN
				}
			} else {
				attrProperties.map { prop ->
					
					prop.copy().apply {
						if (isOverridden()) {
							modality = PropertyBuilder.Modality.OVERRIDE
							delegatesToSuper = true
						} else {
							modality = PropertyBuilder.Modality.OPEN
						}
					}
				}
			}
		)
		
		interfaceBuilder.addNestedClasses(attrs.asSequence().filterIsInstance<NamedAttributeScope>().flatMap {
			it.generateNestedTypes(this, emptyList())
		}.map { it.copy() }.asIterable())
		
		return interfaceBuilder.also {
			cacheTopLevelMember = it
		}
	}
	
	
}