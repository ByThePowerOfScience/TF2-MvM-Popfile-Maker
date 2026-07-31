package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.backing.getSubtree
import btpos.source.vdfdsl.tf2.filegeneration.TF2ItemGeneration.BuildConfig
import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder.Type
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute.EffectType
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.fabricateScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.HierarchyNamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.PenaltyBonus
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.Vis
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.IAttrClassScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.selectorCodec
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.io.path.deleteExisting
import kotlin.io.path.exists
import kotlin.io.path.useDirectoryEntries

data class ObjectInProgress(val name: String, val doc: String, val attrs: MutableList<ISortedNamedAttribute> = mutableListOf())


typealias AttrClassName = String


fun <T : Any, U : Any> Map<T?, U>.filterKeysNotNull(): Map<T, U> {
	return this.filterKeys { it != null } as Map<T, U>
}

fun main() {
	println("Running item attributes")
	// get all attributes, but with the descriptions from the ones used in-game
	val namedAttributesInGameDescriptions = UsefulWikiTableParser.parseWiki().associate { it.first.attrName to it.second }.filterValues { it != null && !it.startsWith("Attrib_") } as Map<String, String>
	
	val allNamedAttributes = convertAttributesFromSchema(namedAttributesInGameDescriptions, getItemSchema().getSubtree("attributes")!!)
	
	// TODO figure out why the debugger isn't working and then debug why getParent isn't returning anything
	generateItemAttributes(
		Path(BuildConfig.OUT_DIR),
		BuildConfig.ATTRIBUTES_TARGET_PACKAGE,
		"import btpos.source.vdfdsl.modeling.*\n" +
		"import btpos.source.vdfdsl.serialization.codecs.*\n" +
		"import ${BuildConfig.ATTRIBUTES_TARGET_PACKAGE}.impl.*\n" +
		"import ${BuildConfig.BASE_PACKAGE}.tftypes.*\n" +
		"import java.util.*\n" +
		"import kotlin.time.Duration\n\n",
		allNamedAttributes,
		SDKNotes.attrsByClass
	)
}

/**
 * @param schema The "attributes" subtree (without that key) from either the item schema or some other "item schema"-like definition for attributes.
 */
fun convertAttributesFromSchema(inGameDescriptionsByAttributeName: Map<String, String>, schema: VDFSubtree): List<NamedAttribute> {
	return schema.map { (_id, schema) ->
			val schema: Map<String, String?> = schema.asSubtree!!.associate { it.key.stringValue to it.value.asString }.withDefault { "" }
			val name: String by schema
			val attribute_class: String by schema
			val description_string: String? = inGameDescriptionsByAttributeName[name]
			val description_format: String by schema
			val hidden by schema
			val effect_type by schema
			val armory_desc by schema
			val stored_as_integer by schema
			
			NamedAttribute(
				attrName = name,
				inGameDesc = description_string,
				attrType = description_format.removePrefix("value_is_"),
				className = attribute_class,
				effectType = when (effect_type?.lowercase()) {
					"positive" -> EffectType.Positive
					"negative" -> EffectType.Negative
					else -> EffectType.Neutral
				},
				armory_desc = ArmoryDesc(armory_desc),
				isHidden = hidden?.let { it != "0" }
			)
		}
}

/**
 * Takes in a set of
 */
fun generateItemAttributes(
	outBaseDir: Path,
	targetPackage: String,
	imports: String,
	/**
	 * A set of named attribute definitions from a schema.
	 */
	allNamedAttributes: List<NamedAttribute>,
	/**
	 * What weapon classes use each of these attributes.
	 *
	 * See [SDKNotes] for an example, and make sure to use the names established there if you're generating attributes yourself.
	 */
	attrClassUsagesByBaseClass: List<IAttrClassScope>,
	/**
	 * Make sure all scopes defined in a superclass are mirrored in all subclasses, and any properties referencing the superclass's version of a class are overridden to reference the new one.
	 *
	 * Example:
	 * ```kotlin
	 *
	 * open class WeaponBase {
	 *     open val projectileCategory = Projectiles()
	 *
	 *
	 *     open class Projectiles {
	 *         // ...
	 *     }
	 * }
	 *
	 *
	 * class BaseGun : WeaponBase() {
	 *     override val projectileCategory = Projectiles()
	 *
	 *
	 *     open class Projectiles : WeaponBase.Projectiles() {
	 *         // ...
	 *     }
	 * }
	 * ```
	 *
	 *
	 * This may seem odd, but it's specifically to categorize attributes while _still allowing those categories to be given extension properties that are only usable on subclasses_.
	 *
	 * ```kotlin
	 * // Adding an attribute in the "Projectiles" category that only works (and is visible on) guns or subclasses of BaseGun:
	 * val BaseGun.Projectiles.customAttribute = ...
	 *
	 * ```
	 * If we did it "normally", with objects instead of this jank as hell category inheritance, we'd instead have to do:
	 *
	 * ```kotlin
	 * // HEY GUYS, YOU CAN'T USE THIS ON ANYTHING BUT BaseGun BTW
	 * val WeaponBase.Projectiles.customAttribute = ...
	 * ```
	 */
	patchParentScopes: Boolean = false,
) {
	/*
	- From the wiki:
		- Named attributes with in-game description, attr class,
	- From the notes:
		- Attribute classes with in-code descriptions
	
	What we're doing:
	- Match all named attributes to the weapon type they inherit from
	- Group all attr classes by their weapon type
	- Each weapon type will be an object that inherits from its parent
	- We don't care about the attrclasses for anything except matching the named attributes against the scope they're supposed to go into, which is done based on attr class
	 */
	
	
	/**
	 * Sort all named attributes by their class, group them up into scopes
	 */
	val namedAttributeScopesByClassName: Map<String, List<ISortedNamedAttribute>> =
			allNamedAttributes
				.asSequence()
			.filter { it.className.isNotBlank() && it.className != "set_detonate_mode" } // doing these by hand in additionalWeaponModes.kt
			.onEach {
				when (it.attrName) {
					"medigun charge is crit boost" -> it.setCodec { selectorCodec(1) }
					"medigun charge is resists" -> it.setCodec { selectorCodec(3) }
				}
			}
			.groupBy { it.className }
			.mapValues<_, _, List<ISortedNamedAttribute>> { (clsName, attrsForThisAttrClass) ->
				if (clsName == "set_weapon_mode")
					return@mapValues attrsForThisAttrClass // dump them all separately
				
				if (attrsForThisAttrClass.size == 1) {
					return@mapValues attrsForThisAttrClass // just the one
				}
				
				val isPos = 0; val isNeg = 1; val isNeu = 2; val isHidden = 3
				val groupedByPosNegNeutral = attrsForThisAttrClass.groupBy {
					when {
						it.isHidden == true -> isHidden
						else -> when (it.effectType) {
							EffectType.Positive -> isPos
							EffectType.Negative -> isNeg
							EffectType.Neutral -> isNeu
						}
					}
				}
				
				// If we have multiple bonuses or multiple penalties and they're not just hidden, we should just assign a custom scope
				if (groupedByPosNegNeutral.size == 1 || groupedByPosNegNeutral.any { it.key != isHidden && it.value.size > 1 }) {
					return@mapValues fabricateScope(clsName, attrsForThisAttrClass)
				}
				
				fun groupHiddenItemsIntoPenaltyBonus(allHidden: List<NamedAttribute>): ISortedNamedAttribute {
					return when (allHidden.size) {
						1 -> allHidden.single()
						// Make hidden items into a nested PenaltyBonus
						else -> allHidden.groupBy { it.effectType }.let {
							it.values.firstOrNull { it.size > 1 }?.let {
								error("Too many values: $it")
							}
							PenaltyBonus(
								penalty=it[EffectType.Negative]?.single(),
								bonus=it[EffectType.Positive]?.single(),
								neutral=it[EffectType.Neutral]?.single(),
							)
						}
					}
				}
				
				
				/*
				Variants:
				- If there's only 1 attribute in the class, just return that attribute
				- If there's only 1 positive/negative/neutral + some hiddens -> Vis
				- Else if there's some combination of positive, negative, neutral, hidden, make it a PenaltyBonus
					- If there are multiple hidden, make the hidden ALSO a PenaltyBonus
				 */
				when (groupedByPosNegNeutral.size) {
					1 -> attrsForThisAttrClass // if they're all one type, just do them separately
					2 -> {
						if (isHidden in groupedByPosNegNeutral) { // if there's just a hidden and a visible, do Vis
							val notHidden = groupedByPosNegNeutral.entries.first { it.key != isHidden }.value.single()
							val hidden = groupedByPosNegNeutral[isHidden]!!.let { allHidden ->
								groupHiddenItemsIntoPenaltyBonus(allHidden)
							}
							
							return@mapValues listOf(Vis(notHidden, hidden, clsName))
						}
						// Else it's a custom PenaltyBonus
						return@mapValues listOf(PenaltyBonus(
							groupedByPosNegNeutral[isNeg]?.single(),
							groupedByPosNegNeutral[isPos]?.single(),
							groupedByPosNegNeutral[isNeu]?.single(),
						))
					}
					else -> {
						listOf(
							PenaltyBonus(
								groupedByPosNegNeutral[isNeg]?.single(),
								groupedByPosNegNeutral[isPos]?.single(),
								groupedByPosNegNeutral[isNeu]?.single(),
								groupedByPosNegNeutral[isHidden]?.let { groupHiddenItemsIntoPenaltyBonus(it) }
							)
						)
					}
				}
			}
	

	
	/** Use sorted set to ensure that root scopes are processed before their children for [patchWithParentOverridesRecursive] */
	val hierarchyScopes = mutableListOf<HierarchyNamedAttributeScope>()
	
	val nonHierarchyScopes = mutableListOf<NamedAttributeScope>()
	
	attrClassUsagesByBaseClass.forEach { baseClassScope ->
		val absorbed = baseClassScope.absorb(namedAttributeScopesByClassName)
			               .singleOrNull() as? NamedAttributeScope?
		when (absorbed) {
			null -> {}
			is HierarchyNamedAttributeScope -> hierarchyScopes.add(absorbed)
			else -> nonHierarchyScopes.add(absorbed)
		}
	}
	
	// Generate classes for every single weaponclass, even ones that don't have notes.
	hierarchyScopes.mapTo(mutableSetOf()) { it.scopeName }.let { alreadyIncludedScopes ->
		SDKNotes.hierarchy.nodes.values.forEach { node ->
			if (node.name !in alreadyIncludedScopes) {
				val parent = node.parents.takeIf { it.isNotEmpty() }?.let {
					it.singleOrNull() ?: error("Node ${node.name} has too many parents: ${it.map { it.name }}")
				}?.name
				hierarchyScopes.add(HierarchyNamedAttributeScope(node.name, parent))
			}
		}
	}
	// sort hierarchy by depth to ensure higher-level classes are made before their children
	hierarchyScopes.sortWith(Comparator.comparingInt { it.depth })
	
	val outDir = outBaseDir.resolve(targetPackage.replace('.', File.separatorChar)).also {
		if (it.exists())
			it.useDirectoryEntries("*.kt") { it.forEach { it.deleteExisting() } }
		else
			it.createDirectories()
	}
	
	(hierarchyScopes.asSequence() + nonHierarchyScopes.asSequence()).forEach { scope ->
		outDir.resolve(scope.scopeName + ".kt")
			.bufferedWriter()
			.use { writer ->
				writer.write("package ${targetPackage}\n\n")
				writer.append(imports).append("\n\n")
				
				scope.generateTopLevelType()?.also {
					if (scope is HierarchyNamedAttributeScope) {
						it.withParentScopes(scope)
					}
				}?.let {
					writer.write(it.build())
				}
				
				scope.generateTopLevelMembers()
					.forEach { topLevel ->
						writer.write(topLevel)
						writer.newLine()
						writer.newLine()
					}
			}
	}
	
	outBaseDir.resolve(BuildConfig.ITEM_FACTORY_LOCATION.replace(".", File.separator) + ".kt").bufferedWriter().use { out ->
		out.append("package ").append(BuildConfig.ITEM_FACTORY_LOCATION.substringBeforeLast('.')).append("\n\n")
		out.append("import ").append(targetPackage).appendLine(".*")
		   .append(imports)
		
		out.append("object ").append(BuildConfig.ITEM_FACTORY_LOCATION.substringAfterLast(".")).append(" {\n")
		// generate item factories for each item type in TFItemFactories
		for (weaponType in hierarchyScopes) {
			if ("Projectile" in weaponType.scopeName.lowercase())
				continue;
			
			out.append("\t@JvmField val ").append(weaponType.scopeName.uppercase()).append(" = TFItemFactory(").append(weaponType.clsname).append(")\n\n")
		}
		out.append("}")
	}
}

fun ClassBuilder.withParentScopes(thisScope: HierarchyNamedAttributeScope): ClassBuilder = apply {
	val parent = thisScope.getParent() ?: return@apply;
	
	val parentBuilder = parent.generateTopLevelType()
	
	patchWithParentOverridesRecursive(thisScope, this, parentBuilder, listOf())
}


/**
 * Params:
 * - Two classbuilders that should mirror each other: [parentVersionOfOurClass] from this hierarchy's parent, and [ourClass] from this hierarchy.
 * - The root hierarchy scope "[ourRootScope]" that started all of this inheritance stuff. Used to fetch the parent's metadata and for pathing.
 * - [pathFromRootToHere]: A list of namespaces that we've traversed through thus far, SAVE FOR THE ROOT NAME.  Used to fetch metadata from the parent's nested version of a given class.
 *
 * Purpose: make sure [ourClass] has its own version of every single nested class of [parentVersionOfOurClass], with each one of our class's nesteds extending the corresponding parent class's nested.
 *
 * This makes it so we can sort attributes into "categories" (said nested classes), while still letting people tack on extension properties later to _specifically_ a subclass's version of a "category".
 *
 * Example:
 * ```kotlin
 * open class WeaponBaseAttributes {
 *   open val projectiles = WeaponBaseAttributes.ProjectileAttributes()
 *
 *   open class ProjectileAttributes {
 *      // ...
 *   }
 * }
 *
 * open class BaseGunAttributes : WeaponBaseAttributes() {
 *   override val projectiles = BaseGunAttributes.ProjectileAttributes()
 *
 *   // Custom label for WeaponBase's "projectile attributes" category
 *   open class ProjectileAttributes : WeaponBaseAttributes.ProjectileAttributes()
 * }
 *
 * // Example extension property for specifically BaseGun's (and subclass') "projectiles" category
 * val BaseGunAttributes.ProjectileAttributes.foo get() = bar
 *
 * BaseGunAttributes().projectiles.foo // Good!
 * WeaponBaseAttributes().projectiles.foo // NOT FOUND, which is what we want!!!
 * ```
 */
fun patchWithParentOverridesRecursive(
	ourRootScope: HierarchyNamedAttributeScope,
	ourClass: ClassBuilder,
	parentVersionOfOurClass: ClassBuilder,
	pathFromRootToHere: List<String>
) {
	// for each nested class in the parent, add a copy of it to ours if it isn't there already, but configure both
	for ((nestedClassName, parentNestedClass) in parentVersionOfOurClass.nestedClasses) {
		val ourNestedClass = ourClass.nestedClasses.computeIfAbsent(nestedClassName) {
			parentNestedClass.copy().apply {
				properties.clear()
				nestedClasses.clear()
				companionObject = null
			}
		}
		
		val pathOfCurrentScope = pathFromRootToHere + ourNestedClass.name
		
		
        ourNestedClass.apply {
			baseClass = ourRootScope.getParent()!!.clsname + "." + pathOfCurrentScope.joinToString(".")
			parentInterfaces -= "IBlockScoped"
			isOpen = true
		}
		
		patchWithParentOverridesRecursive(ourRootScope, ourNestedClass, parentNestedClass, pathOfCurrentScope)
		
		ourNestedClass.ensureOverriddenPropertiesAreMarkedOverride(ourRootScope, pathOfCurrentScope)
		
		ourClass.redirectPropertiesToNewType(ourNestedClass, parentVersionOfOurClass)
	}
}

private fun ClassBuilder.ensureOverriddenPropertiesAreMarkedOverride(ourRootScope: HierarchyNamedAttributeScope, pathOfCurrentScope: List<String>) {
	val allInheritedProperties = ourRootScope.getParentsRecursive()
		.mapNotNull { it.getNestedScope(pathOfCurrentScope) }
		.flatMap { it.attrs }
		.map { it.varName }
		.distinct()
		.toSet()
	
	for (prop in this.properties.values) {
		if (prop.name in allInheritedProperties) {
			prop.modality = PropertyBuilder.Modality.OVERRIDE
			if (prop.kType !in this.nestedClasses)
				prop.delegatesToSuper = true
		}
	}
}

fun ClassBuilder.redirectPropertiesToNewType(newType: ClassBuilder, ourParent: ClassBuilder) {
	if (this.type != Type.INTERFACE) {
		// we might not have every property that should be overridden in us already, so add them if we don't have them
		ourParent.properties.values.forEach { parentProp ->
			if (parentProp.kType != newType.name)
				return@forEach;
			
			val ourVersionOfProp = this.properties.computeIfAbsent(parentProp.name) {
				parentProp.copy().apply {
					kType = newType.name
				}
			}
			
			// force it to create our version of the object
			ourVersionOfProp.isGetter = false
			ourVersionOfProp.delegatesToSuper = false // should never delegate to super, because we're forcing it to have a new type
			ourVersionOfProp.initializer = newType.name + "()"
		}
		
		return;
	}
	
	// if it's an interface, we need to make two new properties:
	//   - companion object field to hold the instance
	//   - interface getter that delegates to that companion object field
	
	val ourCompanion = getOrCreateCompanionObject()
	
	val parentCompanion = ourParent.companionObject ?: error("No companion object present on interface parent $ourParent")
	
	for (parentItfProperty in ourParent.properties.values) {
		if (parentItfProperty.kType == newType.name) {
			// we might not have every property in our interface that needs to be overridden in us already, so add them if we don't have them
			
			val ourInterfaceProp = this.properties.computeIfAbsent(parentItfProperty.name) {
				parentItfProperty.copy()
			}
			
			ourInterfaceProp.modality = PropertyBuilder.Modality.OVERRIDE
			ourInterfaceProp.delegatesToSuper = false
			ourInterfaceProp.isGetter = true
			ourInterfaceProp.initializer = this.name + "." + ourInterfaceProp.name
			
			
			// add the backing field to the companion object,
			// but make it private if it isn't part of the initial interface so we don't clutter the namespace
			val companionObjectProp = ourCompanion.properties.computeIfAbsent(ourInterfaceProp.name) {
				parentCompanion.properties[it]?.copy() ?: PropertyBuilder(it, ourInterfaceProp.kType) {
					docComment += parentItfProperty.docComment
					access = PropertyBuilder.AccessModifier.PRIVATE
				}
			}
			
			companionObjectProp.initializer = newType.name + "()"
			companionObjectProp.isGetter = false
		}
	}
}