package btpos.source.vdfdsl.tf2.filegeneration.representations

import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import org.jetbrains.annotations.Contract

interface ISortedNamedAttribute {
	var varName: String
	
	/**
	 * In-game descs and sorted in-game descs of contained attributes
	 */
	val innateDescription: List<String>
	
	/**
	 * Notes on its usage from the SDK
	 */
	var notes: List<String>
	
	fun clone(): ISortedNamedAttribute
	
	/**
	 * Create a basic property builder with the varname, type, doc comment, and initializer,
	 * that can be modified later to add modality, overriding, etc.
	 */
	@Contract("_->new", pure = true)
	fun propertyBuilder(): PropertyBuilder
	
	/**
	 * Generate types or functions that should be at the root of the given file.
	 */
	fun generateTopLevelMembers(): List<String> = emptyList()
	
	fun generateTopLevelType(): ClassBuilder? = null
	
	/**
	 * For nested-scope inheritance: returns whether this attribute already has a nested scope by that name
	 */
	fun getNestedScope(scopePath: List<String>): NamedAttributeScope? = null
	
	/**
	 * Get the type of the attribute
	 */
	fun getKotlinType(): String
	
	fun setCodec(codec: (NamedAttribute) -> FakeCodec?)
}