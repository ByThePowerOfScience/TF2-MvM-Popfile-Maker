package btpos.source.vdfdsl.codegen.services


interface ExtensibleSubtreeClassLoader {
	/**
	 * Register what factory methods should be invoked to generate each struct you made, or otherwise classload the places that register the struct factories.
	 *
	 * This function should call [btpos.source.vdfdsl.modeling.IExtensibleSubtree.Codegen._registerStructFactory] for each struct it adds, to allow the code generator to automatically create something for that.
	 */
	fun registerStructFactoryMethods()
	
	/**
	 * [addField][btpos.source.vdfdsl.modeling.IExtensibleSubtree.addField] (and other field creators) automatically creates a code generator mapping the data to that property,
	 * but the addField delegate has to be invoked to generate that.
	 *
	 * For member properties: create an empty instance of each struct you add to create the member delegates.
	 *
	 * For extensions: reference either the object containing struct extension members or some property in each file containing struct extension members, to ensure the `addField` functions are run.
	 */
	fun loadFieldsForCodegen()
}