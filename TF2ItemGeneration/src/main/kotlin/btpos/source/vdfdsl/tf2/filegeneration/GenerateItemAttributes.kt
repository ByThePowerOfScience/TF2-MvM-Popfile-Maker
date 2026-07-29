package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asString
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.backing.getSubtree
import btpos.source.vdfdsl.tf2.filegeneration.TF2ItemGeneration.BuildConfig
import btpos.source.vdfdsl.tf2.filegeneration.representations.ClassBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute.EffectType
import btpos.source.vdfdsl.tf2.filegeneration.representations.fabricateScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.HierarchyNamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.PenaltyBonus
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.Vis
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.IAttrClassScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.removeFromPBName
import btpos.source.vdfdsl.tf2.filegeneration.representations.selectorCodec
import java.io.File
import java.nio.file.Path
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.mapNotNull
import kotlin.contracts.Effect
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
		"import java.util.*\n\n",
		allNamedAttributes,
		MyNotesFormatted.attrsByClass
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
	 * See [MyNotesFormatted] for an example, and make sure to use the names established there if you're generating attributes yourself.
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
	

	val scopes = attrClassUsagesByBaseClass.mapNotNull { baseClassScope ->
		baseClassScope.absorb(namedAttributeScopesByClassName)
			.singleOrNull() as NamedAttributeScope?
	}
	
	
	// now go through them recursively to find if they each have all things from their parent
	
	/**
	 * Params: two "identical" classbuilders, one from this hierarchy's parent, and one from this hierarchy.
	 *
	 * Purpose: make sure [fromThis] has versions of every single class nested in [fromParent].
	 */
	fun patchWithParentOverridesRecursive(fromParent: ClassBuilder, fromThis: ClassBuilder, currentPath: List<String>) {
		fromParent.nestedClasses.entries.forEach { (name, parentNested) ->
			val ourVersion = fromThis.nestedClasses[name]
			                 ?: parentNested.copy().apply {
				                 baseClass = currentPath.joinToString(".")
			                 }
			
			patchWithParentOverridesRecursive(parentNested, ourVersion, currentPath + name)
			
			// force any props that construct the newly-overridden object to instantiate this one instead
			val findInstantiation = Regex("$name\\s*\\(")
			parentNested.properties.values.forEach { parentProp ->
				if (parentProp.initializer.contains(findInstantiation)) {
					ourVersion.properties.computeIfAbsent(parentProp.name) {
						parentProp.copy()
					}.apply {
						delegatesToSuper = false
					}
				}
			}
			
			if (name !in fromThis.nestedClasses) {
				fromThis.addNestedClass(ourVersion)
			}
		}
	}
	
	fun ClassBuilder.withParentScopes(itsParent: ClassBuilder): ClassBuilder = apply {
		patchWithParentOverridesRecursive(
			itsParent,
			this,
			listOf(this.name)
		)
	}
	
	
	val outDir = outBaseDir.resolve(targetPackage.replace('.', File.separatorChar)).also {
		if (it.exists())
			it.useDirectoryEntries("*.kt") { it.forEach { it.deleteExisting() } }
		else
			it.createDirectories()
	}
	
	scopes.forEach { scope ->
		outDir.resolve(scope.scopeName + ".kt")
			.bufferedWriter()
			.use { writer ->
				writer.write("package ${targetPackage}\n\n")
				writer.append(imports).append("\n\n")
				
				scope.generateTopLevelType()?.also {
					if (scope is HierarchyNamedAttributeScope) {
						it.withParentScopes(scope.getParent()?.generateTopLevelType() ?: return@also)
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
}