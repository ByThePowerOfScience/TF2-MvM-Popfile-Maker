package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import kotlin.test.Test

class MyStruct(override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()) : IExtensibleSubtree {
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
	
	override fun copy() = MyStruct(_rawEntries.toMutableMap())
}

val MyStruct.foo: Int? by addField("thing")


class DecoderTest {
	
	
	@Test
	fun runCodegen() {
		Class.forName(this::class.java.packageName + ".DecoderTestKt")
		MyStruct::class.java
		
	    println(IExtensibleSubtree._codegenFieldMappings)
	}
}