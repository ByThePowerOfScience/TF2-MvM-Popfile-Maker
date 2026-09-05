package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.statements.KtAssignment
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtLambda
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import kotlin.test.Test

class MyStruct(override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()) : IExtensibleSubtree {
	companion object {
		init {
			IExtensibleSubtree.Codegen.registerCodegen<MyStruct> {
				{ fields: List<KtStatement> ->
					
					val arg = fields.find { it is KtAssignment && it.lhs.callee.callableName.name == MyStruct::insideStruct.name }
					
					
					
					val funName = KtName("MyStruct", this::class.java.packageName)
					
					if (arg != null) {
						val body = fields - arg
						
						KtFunctionCall(
							callee = funName,
							args = listOf(
								(arg as KtAssignment).rhs,
								KtLambda(lines = body)
							)
						)
					}
					else {
						KtFunctionCall.createApply(KtFunctionCall(funName), fields)
					}
				}
			}
		}
	}
	
	val insideStruct by addField<String>("insideStruct")
	
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
	}
}