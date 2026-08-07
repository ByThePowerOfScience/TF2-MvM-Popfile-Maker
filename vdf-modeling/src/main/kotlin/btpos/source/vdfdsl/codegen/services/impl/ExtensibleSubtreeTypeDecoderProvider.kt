package btpos.source.vdfdsl.codegen.services.impl

import btpos.source.vdfdsl.codegen.StructSubclassDecoder
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.services.ExtensibleSubtreeClassLoader
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import java.util.ServiceLoader
import kotlin.reflect.KClass

class ExtensibleSubtreeTypeDecoderProvider : TypeDecoderProvider {
	private var hasRun = false
	
	override val valueDecoders: Map<KClass<*>, ValueDecoder> get() {
		if (!hasRun) {
			val services = ServiceLoader.load(ExtensibleSubtreeClassLoader::class.java)
			services.forEach {
				it.registerStructFactoryMethods()
			}
			services.forEach {
				it.loadFieldsForCodegen()
			}
			hasRun = true
		}
		
		return IExtensibleSubtree.Codegen._codegenFieldMappings
	}
	
	override val selfNamedDecoders: Map<KClass<*>, StructSubclassDecoder> get() = emptyMap()
}