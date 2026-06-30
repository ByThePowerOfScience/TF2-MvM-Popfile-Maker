package btpos.tf2.popfiledsl.itemattributesgenerator.representations

interface ISortedNamedAttribute {
	val varName: String
	
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
	 * Some property reference to this object, assuming it's given the opportunity to name its own property.
	 *
	 * Should include the comment. Use [buildComment] to convert a list of strings into
	 */
	fun propertyString(isOverridden: Boolean): String
	
	/**
	 * If this value is not an [NamedAttribute], it'll be some kind of object. This is a reference to that object.
	 */
	fun propertyValue(): String
	
	/**
	 * will be called before [propertyString]
	 */
	fun generateTopLevelMembers(): List<String> = emptyList()
	
	/**
	 * Get the type of the resulting object
	 */
	fun getKotlinType(): String
	
	fun setCodec(codec: (NamedAttribute) -> FakeCodec?)
	
	companion object {
		/**
		 * Formats a list of strings into a single block comment, prepending `\n<indent> * ` to each line
		 */
		fun buildComment(comments: List<String>): String {
			return comments.takeIf { it.isNotEmpty() }
				       ?.run {
					       "/**${joinToString("\n *") { "\n * $it" }}\n */"
				       } ?: ""
		}
	}
	
}