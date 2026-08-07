package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.codegen.kt.KtFunctionCall
import btpos.source.vdfdsl.codegen.kt.KtLambda
import btpos.source.vdfdsl.codegen.kt.KtLiteral
import btpos.source.vdfdsl.codegen.kt.KtName
import btpos.source.vdfdsl.codegen.kt.KtNamedFunctionCallArgument
import btpos.source.vdfdsl.codegen.kt.KtString
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

object Codegen {
	val IS_DOING_CODEGEN = System.getProperty("vdfdsl.codegen") == "true"
	
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
	
	inline fun <reified T : Any> basicApplyFactory(): IExtensibleSubtree.Codegen.StructFactoryMethod {
		return basicApplyFactory(T::class)
	}
	
	/**
	 * Creates a new instance and calls `apply {}` on it, with the assignments put in the body of the `apply` block.
	 *
	 * Example: `basicApplyFactory(MobSpawner::class)` -> `MobSpawner().apply { ...assignments }`
	 */
	fun basicApplyFactory(kclass: KClass<*>): IExtensibleSubtree.Codegen.StructFactoryMethod {
		val ctor = KtName(kclass.qualifiedName!!)
		
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
		val funcName = KtName(function)
		
		if (fieldsToArgNames.isEmpty()) {
			return {
				KtFunctionCall(funcName, listOf(KtLambda(lines=it)))
			}
		}
		
		
		return { assignments ->
			val assignments = assignments.toMutableList()
			val namedArguments = mutableListOf<KtNamedFunctionCallArgument>()
			
			val liter = assignments.listIterator()
			for (assignment in liter) {
				fieldsToArgNames[assignment.lhs.name]?.let {
					namedArguments += KtNamedFunctionCallArgument(it, assignment.rhs)
					liter.remove()
				}
			}
			
			KtFunctionCall(funcName).apply {
				args += namedArguments
				args += KtLambda(lines=assignments)
			}
		}
	}
}