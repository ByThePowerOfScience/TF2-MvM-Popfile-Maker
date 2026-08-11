package btpos.source.vdfdsl.codegen.services.impl

import btpos.source.vdfdsl.codegen.Decoder
import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.codegen.services.ExtensibleSubtreeClassLoader
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import java.util.ServiceLoader
import kotlin.reflect.KClass

class ExtensibleSubtreeTypeDecoderProvider : TypeDecoderProvider {
	private var hasRun = false
	
	override val typeDecoders: Map<KClass<*>, Decoder<KtExpression>>
		get() {
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
}