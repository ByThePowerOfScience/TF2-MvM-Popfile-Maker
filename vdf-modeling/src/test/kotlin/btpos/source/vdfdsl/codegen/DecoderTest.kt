package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.codegen.kt.KtAssignmentExpression
import btpos.source.vdfdsl.codegen.kt.KtFunctionCall
import btpos.source.vdfdsl.codegen.kt.KtName
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import kotlin.test.Test

class MyStruct(override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()) : IExtensibleSubtree {
	companion object {
		init {
//			IExtensibleSubtree._registerStructFactory { fields: List<KtAssignmentExpression> ->
//				val arg = fields.find { it.lhs.name == "insideStruct" }
//
//				if (arg != null)
//					KtFunctionCall(callee = KtName("MyStruct", this::class.java.packageName)).apply {
//
//					}
//			}
		}
	}
	
	var insideStruct: String? by addField("insideStruct")
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
	
	override fun copy() = MyStruct(_rawEntries.toMutableMap())
}

inline fun MyStruct(insideStruct: String, configure: MyStruct.() -> Unit): MyStruct {
	return MyStruct().apply {
		this.insideStruct = insideStruct
		configure()
	}
}

val MyStruct.foo: Int? by addField("thing")


class DecoderTest {
	
	
	@Test
	fun runCodegen() {
		System.setProperty("vdfdsl.codegen", "true")
		Class.forName(this::class.java.packageName + ".DecoderTestKt")
		MyStruct::class.java
		
	    println(IExtensibleSubtree._codegenFieldMappings)
	}
}