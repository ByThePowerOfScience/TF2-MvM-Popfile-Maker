package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.codegen.kt.KtAssignmentExpression
import btpos.source.vdfdsl.codegen.kt.KtFunctionCall
import btpos.source.vdfdsl.codegen.kt.KtLambda
import btpos.source.vdfdsl.codegen.kt.KtName
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import kotlin.test.Test

class MyStruct(override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()) : IExtensibleSubtree {
	companion object {
		init {
			IExtensibleSubtree.Codegen._registerStructFactory<MyStruct> { fields: List<KtAssignmentExpression> ->
				val arg = fields.find { it.lhs.name == MyStruct::insideStruct.name }
				
				val body = fields.filter { it.lhs.name != MyStruct::insideStruct.name }
				
				val funName = KtName("MyStruct", this::class.java.packageName)
				
				if (arg != null)
					KtFunctionCall(
						callee = funName,
						args = listOf(
							arg.rhs,
							KtLambda(lines = body)
						)
					)
				else {
					KtFunctionCall.createApply(KtFunctionCall(funName), body)
				}
			}
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
		MyStruct() // need to create an instance to instantiate the instance delegates
		
	    println("_codegenFieldMappings: " + IExtensibleSubtree.Codegen._codegenFieldMappings)
	    println("deferred: " + IExtensibleSubtree.Codegen._deferredCodegenFieldMappings)
	}
}