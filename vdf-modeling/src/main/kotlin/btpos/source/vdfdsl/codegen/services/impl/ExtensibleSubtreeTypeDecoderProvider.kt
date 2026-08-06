package btpos.source.vdfdsl.codegen.services.impl

import btpos.source.vdfdsl.codegen.Decoder
import btpos.source.vdfdsl.codegen.TypeDecoder
import btpos.source.vdfdsl.codegen.services.ExtensibleSubtreeClassLoader
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import java.util.ServiceLoader
import kotlin.reflect.KClass

class ExtensibleSubtreeTypeDecoderProvider : TypeDecoderProvider {
	private var hasRun = false
	
	override val decoders: Map<KClass<*>, TypeDecoder> get() {
		if (!hasRun) {
			val services = ServiceLoader.load(ExtensibleSubtreeClassLoader::class.java)
			services.forEach {
				it.registerStructFactoryMethods()
			}
			services.forEach {
				it.loadExtensionsForCodegen()
			}
			hasRun = true
		}
		
		return IExtensibleSubtree._codegenFieldMappings
	}
}