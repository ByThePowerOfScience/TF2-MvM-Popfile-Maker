package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder.Type
import btpos.source.vdfdsl.tf2.filegeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.filegeneration.representations.FunctionBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.Modality
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.overrideVarName

/**
 * Scopes are all top-level object declarations. Any properties just reference them with getters.
 */
open class NamedAttributeScope(
	var scopeName: String,
	vararg attrs: ISortedNamedAttribute,
	override var innateDescription: List<String> = emptyList(),
	val _varName: String? = null,
) : ISortedNamedAttribute {
	override var varName: String = (_varName ?: this.scopeName).decapitalize().overrideVarName()
	
	override fun clone(): NamedAttributeScope {
		return NamedAttributeScope(this.scopeName, attrs=attrs.map { it.clone() }.toTypedArray(), innateDescription = innateDescription, _varName=_varName).also {
			it.varName = varName
			it.notes = notes
			it.defaultAttribute = defaultAttribute
		}
	}
	
	val attrs = attrs.distinct()
	
	override fun propertyBuilder(): PropertyBuilder {
		return PropertyBuilder(varName, getKotlinType()) {
			initializer = "$clsname()"
			docComment += innateDescription
		}
	}
	
	val clsname = scopeName + "Attributes"
	
	fun containsAttribute(varName: String): Boolean {
		return this.attrs.any { it.varName == varName }
	}
	
	operator fun contains(attr: ISortedNamedAttribute) = this.attrs.any { it.varName == attr.varName }
	
	
	var defaultAttribute: ISortedNamedAttribute? = null
	
	/**
	 * Just generate a class representing this scope, not worrying about overrides or extensions or anything at all.
	 *
	 * Let the hierarchy handle overrides.
	 */
	override fun generateType(): ClassBuilder {
		return ClassBuilder(this.clsname, Type.CLASS) {
			parentInterfaces += "IBlockScoped"
			
			for (attr in attrs) {
				addProperty(attr.propertyBuilder())
				
				attr.generateType()?.let {
					addNestedClass(it)
				}
			}
			
			defaultAttribute?.let {
				delegateItemAttributeTo(it)
			}
		}
	}
	
	private fun ClassBuilder.delegateItemAttributeTo(attr: ISortedNamedAttribute) {
		val valueType = attr.getKotlinType()
		parentInterfaces += "ItemAttribute<$valueType>"
		
		functions += FunctionBuilder("set").apply {
			valueParams += "value" to "$valueType?"
			contextParams += "_" to "IAttributeContainer"
			body += "${attr.varName} = value"
			modality = Modality.OVERRIDE
		}
		
		functions += FunctionBuilder("get", "$valueType?").apply {
			contextParams += "_" to "IAttributeContainer"
			body += "return ${attr.varName}.get()"
			modality = Modality.OVERRIDE
		}
		
		functions += FunctionBuilder("serialize", "$valueType?").apply {
			body += "return ${attr.varName}.serialize()"
			modality = Modality.OVERRIDE
		}
	}
	
	
	override fun getNestedScope(scopePath: List<String>): NamedAttributeScope? {
		if (scopePath.isEmpty())
			return this;
		
		val currItem = scopePath.first()
		val found = attrs.firstOrNull { it is NamedAttributeScope && it.clsname == currItem } as NamedAttributeScope?
		
		if (scopePath.size == 1) { // this was the last unit of the path
			return found
		} else {
			return found?.getNestedScope(scopePath.drop(1))
		}
	}
	
	override fun getKotlinType(): String {
		return clsname
	}
	
	override var notes = listOf<String>()
		set(value) {
			field = value
			attrs.forEach { it.notes = value }
		}
	
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		this.attrs.forEach {
			it.setCodec(codec)
		}
	}
	
	override fun toString(): String {
		return "NamedAttributeScope(scopeName='$scopeName', attrs=$attrs, notes=$notes)"
	}
	
	override fun contains(attrName: String): Boolean {
		return attrs.any { attrName in it }
	}
	
	
	protected fun PropertyBuilder.getSetAttrFromCompanion(clsName: String, attr: ISortedNamedAttribute) {
		this.isVal = false
		this.usesGetter = true
		this.initializer = "$clsName.${this.name}.get()"
		this.setter = "$clsName.${this.name}.set(value)"
		this.contextParams += "attrs" to "IAttributeContainer"
		this.kType = attr.getKotlinType() + "?"
	}
}

/*
My goal is to have overridable nested scopes, so like this:

BaseEntity
	open val projectileAttributes: BaseEntityProjectileAttributes = BaseEntityProjectileAttributes()
	
	
BaseGun
	override val projectileAttributes: BaseGunProjectileAttributes
	
BaseEntityProjectileAttributes
BaseGunProjectileAttributes : BaseEntityProjectileAttributes

and so on and so forth, so each nested scope can LATER have extensions like:

// projectile-related attributes but ONLY FOR GUNS:
val BaseGunProjectileAttributes.gunThing = ItemAttribute("whatever")

so it shows up when doing:
BaseGunAttributes.projectiles {
	gunThing
}

but not when doing:
BaseEntityAttributes.projectiles {
	gunThing // <-- ERROR
}


to do this, I need to inform it of the parent attribute so it knows what scope to override
I guess????? the name could be implicit, like assume everything is defined as such:
BaseEntityAttributes {
	open class Projectiles : IBlockScoped {
	
	}
	
	open val projectiles = Projectiles()
}

so then we just do, knowing the name of the parent:
BaseGunAttributes {
	open class Projectiles : WeaponBaseAttributes.Projectiles() {
		// anything inside this nested scope, if applicable
	}
	
	override val projectiles = Projectiles()
}

hmmmm but this does raise the question: how does it know what scopes have yet to be created....
I guess we could go over them again? or just check the nested scopes to see if there's a scope in there already by that name, so we don't autogenerate it again


Alright so, the big thing is: nested scopes are no longer top-level members OR EVEN OBJECTS. So generateTopLevelMembers is out.
Now it should just be "generateMembersInScope", or we could even add a new method for that.

 */