package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.statements.KtAssignment
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtLambda
import btpos.misc.kt.codegen.expressions.KtLiteral
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.expressions.KtNamedFunctionCallArgument
import btpos.misc.kt.codegen.expressions.KtString
import btpos.misc.kt.codegen.identifiers.KtType
import btpos.misc.kt.codegen.identifiers.toName
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.util.forEachWithIter
import kotlin.collections.toMutableList
import kotlin.error
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaConstructor
import kotlin.reflect.jvm.javaMethod

object Codegen {
	const val CODEGEN_PROP = "vdfdsl.codegen"
	val IS_DOING_CODEGEN = System.getProperty(CODEGEN_PROP) == "true"
	
	/**
	 * Returns the thing given as a string literal wrapped in quotes
	 */
	fun string(it: String): KtString {
		return KtString(it)
	}
	
	/**
	 * Returns the thing given without any postprocessing
	 */
	fun code(code: String, vararg imports: String): KtLiteral {
		return KtLiteral(code, imports.toSet())
	}
	
	fun blockComment(body: String): KtLiteral {
		return KtLiteral("/*\n" + body + "\n*/")
	}
	
	inline fun <reified T : Any> basicApplyFactory(): IExtensibleSubtree.Codegen.StructFactoryMethod {
		return basicApplyFactory(T::class)
	}
	
	/**
	 * Creates a new instance and calls `apply {}` on it, with the assignments put in the body of the `apply` block.
	 *
	 * Example: `basicApplyFactory(MobSpawner::class)` -> `MobSpawner().apply { ...assignments }`
	 */
	fun basicApplyFactory(kclass: KClass<*>): IExtensibleSubtree.Codegen.StructFactoryMethod {
		val ctor = KtName.qualified(kclass.qualifiedName!!)
		
		return { assignments ->
			KtFunctionCall.createApply(KtFunctionCall(ctor), assignments)
		}
	}
	
	/**
	 * Invokes the [function] that ends with a lambda that all of the remaining assignments will be put inside of.
	 *
	 * Example: `basicBlockScope(Factories::myClass, mapOf(MyFactory::template.name to "thing1"))` -> `Factories.myClass(thing1=<template if present>) { ...remaining assignments }`
	 */
	fun basicBlockScope(function: KFunction<*>, fieldsToArgNames: Map<String, String> = mapOf()): IExtensibleSubtree.Codegen.StructFactoryMethod {
		if (!IS_DOING_CODEGEN)
			return { TODO("Error message for trying to make a block scope when codegen mode is disabled") }
		
		val funcName = KtName(function)
		
		if (fieldsToArgNames.isEmpty()) {
			return {
				KtFunctionCall(funcName, listOf(KtLambda(lines=it)))
			}
		}
		
		return { assignments ->
			val assignments = assignments.toMutableList()
			val namedArguments = mutableListOf<KtNamedFunctionCallArgument>()
			
			assignments.forEachWithIter { assignment ->
				if (assignment !is KtAssignment)
					return@forEachWithIter;
				
				fieldsToArgNames[assignment.lhs.name]?.let {
					namedArguments += KtNamedFunctionCallArgument(it, assignment.rhs)
					remove()
				}
			}
			
			KtFunctionCall(funcName).apply {
				args += namedArguments
				args += KtLambda(lines=assignments)
			}
		}
	}
}

/**
 * This is the closest we can get to a preprocessor macro to not construct any of this nonsense when codegen is disabled.
 *
 * Everything should stay hidden in a function that hopefully gets elided by the JIT since [Codegen.IS_DOING_CODEGEN] will never change.
 */
class CodegenProvider<out D : Decoder<*>> private constructor(private val getCodegen: () -> D) {
	private var codegen: D? = null
	
	private val toApply = ArrayList<(D) -> Unit>(0)
	
	fun get(): D {
		if (!Codegen.IS_DOING_CODEGEN)
			error(ERROR_MESSAGE)
		
		codegen?.let {
			return it;
		}
		
		val x = getCodegen()
		toApply.forEach {
			it(x)
		}
		
		toApply.clear()
		codegen = x
		
		return x
	}
	
	/**
	 * Apply this function to the item this provides only if/when the thing is actually instantiated,
	 * to avoid collapsing the lazy instantiation.
	 */
	fun applyToContained(action: (D) -> Unit): CodegenProvider<D> {
		codegen?.let {
			it.apply(action)
			return this;
		}
		
		toApply += action
		
		return this;
	}
	
	companion object {
	    operator fun <D : Decoder<*>> invoke(getCodegen: () -> D): CodegenProvider<D> {
	        if (!Codegen.IS_DOING_CODEGEN)
				return errorInstance()
		    
		    return CodegenProvider(getCodegen)
	    }
		
		@Suppress("UNCHECKED_CAST")
		fun <D : Decoder<*>> errorInstance(): CodegenProvider<D> = ERROR_INSTANCE as CodegenProvider<D>
		
		private val ERROR_INSTANCE = CodegenProvider<Decoder<*>> {
			error(ERROR_MESSAGE)
		}
		
		const val ERROR_MESSAGE = "Attempted to run code generation when not in codegen mode.  Rerun the program with the JVM argument \"-D${Codegen.CODEGEN_PROP}=true\"."
	}
}