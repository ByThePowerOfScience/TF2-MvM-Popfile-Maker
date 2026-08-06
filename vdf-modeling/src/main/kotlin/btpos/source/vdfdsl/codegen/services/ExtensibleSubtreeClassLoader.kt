package btpos.source.vdfdsl.codegen.services


interface ExtensibleSubtreeClassLoader {
	/**
	 * Register what factory methods should be invoked to generate each struct you made.
	 *
	 * This function should call [btpos.source.vdfdsl.modeling.IExtensibleSubtree._registerStructFactory] for each struct it adds, to allow the code generator to automatically create something for that.
	 */
	fun registerStructFactoryMethods()
	
	/**
	 * Reference either the object containing struct extension members or some property in each file containing struct extension members, to ensure the `addField` functions are run.
	 *
	 * [addField][btpos.source.vdfdsl.modeling.IExtensibleSubtree.addField] automatically creates a code generator mapping the data to that property,
	 * but the file it's in needs to be referenced to do that.
	 */
	fun loadExtensionsForCodegen()
}