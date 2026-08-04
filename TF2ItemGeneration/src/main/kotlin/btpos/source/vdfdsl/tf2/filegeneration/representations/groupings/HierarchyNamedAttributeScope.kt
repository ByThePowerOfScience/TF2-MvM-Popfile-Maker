package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.SDKNotes
import btpos.source.vdfdsl.tf2.filegeneration.hierarchiesByName
import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.Modality
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import kotlin.collections.map

class HierarchyNamedAttributeScope(scopeName: String, val extendsFrom: String?, vararg attrs: ISortedNamedAttribute, notes: List<String> = emptyList())
	: NamedAttributeScope(scopeName, attrs = attrs, notes)
{
	fun getParentsRecursive(): Sequence<HierarchyNamedAttributeScope> {
		return generateSequence(getParent()) { it.getParent() }
	}
	
	val depth by lazy {
		getParentsRecursive().count()
	}
	
	fun getParent(): HierarchyNamedAttributeScope? {
		return this.extendsFrom?.let { hierarchiesByName[it] }
	}
	
	init {
		require(scopeName in SDKNotes.hierarchy) {
			"Hierarchy scope '$scopeName' not in class hierarchy"
		}
		hierarchiesByName[scopeName] = this
	}
	
	override fun clone(): HierarchyNamedAttributeScope {
		return HierarchyNamedAttributeScope(scopeName, extendsFrom, attrs=attrs.map { it.clone() }.toTypedArray(), notes).also {
			it.notes = notes
			it.varName = varName
			it.defaultAttribute = defaultAttribute
		}
	}
	
	
	private var cacheTopLevelMember: ClassBuilder? = null
	
	override fun generateType(): ClassBuilder {
		cacheTopLevelMember?.let {
			return it;
		}
		
		val allParentAttributes = getParentsRecursive().map { it.varName }.toList()
		
		fun PropertyBuilder.isOverridden() = allParentAttributes.any { this.name == it }
		
		val cb = super.generateType().apply {
			properties.values.forEach {
				if (it.isOverridden()) {
					it.modality = Modality.OVERRIDE
				}
			}
		}
		
		cacheTopLevelMember = cb
		
		return cb;
	}
}

/**
 * Cache each property in the companion object, and make each instance property instead delegate to that companion object.
 *
 * Before:
 * ```kotlin
 * class Foo {
 *   val x = Bar()
 * }
 * ```
 *
 * After:
 * ```kotlin
 * class Foo {
 *   companion object {
 *     val x = Bar()
 *   }
 *
 *   val x get() = Foo.x
 * }
 * ```
 */
fun ClassBuilder.cachePropertiesInCompanion() {
	val companion = getOrCreateCompanionObject().apply {
		parentInterfaces += "IBlockScoped"
	}
	
	for (prop in properties.values) {
		companion.addProperty(prop.copy())
		
		prop.usesGetter = true
		prop.initializer = "${this.name}.${prop.name}"
		if (!prop.isVal) {
			prop.setter = "${this.name}.${prop.name} = value"
		}
	}
}