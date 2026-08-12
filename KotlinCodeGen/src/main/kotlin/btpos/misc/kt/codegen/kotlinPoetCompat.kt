package btpos.misc.kt.codegen

import btpos.misc.kt.codegen.enums.AccessModifier
import btpos.misc.kt.codegen.enums.Modality
import btpos.misc.kt.codegen.identifiers.KtParameter
import btpos.misc.kt.codegen.types.KtType
import btpos.misc.kt.codegen.declarations.KtClassDeclaration
import btpos.misc.kt.codegen.declarations.KtFunctionBody
import btpos.misc.kt.codegen.declarations.KtFunctionDeclaration
import btpos.misc.kt.codegen.declarations.KtPropertyDeclaration
import btpos.misc.kt.codegen.declarations.statements
import btpos.misc.kt.codegen.types.KtClass
import btpos.misc.kt.codegen.types.KtSimpleType
import btpos.misc.kt.codegen.types.KtTypeParameter
import btpos.misc.kt.codegen.enums.KtVariance
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ContextParameter
import com.squareup.kotlinpoet.ExperimentalKotlinPoetApi
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName

fun Modality.toSpec(): KModifier {
	return when (this) {
		Modality.FINAL -> KModifier.FINAL
		Modality.OPEN -> KModifier.OPEN
		Modality.OVERRIDE -> KModifier.OVERRIDE
	}
}

@OptIn(ExperimentalKotlinPoetApi::class)
fun KtPropertyDeclaration.toSpec(): PropertySpec {
	fun makeSetterWithBody(type: TypeName, body: KtFunctionBody): FunSpec {
		return FunSpec.setterBuilder()
			.addParameter(ParameterSpec.builder("value", type).build())
			.apply {
				body.statements.forEach {
					addStatement(it.toKotlinCode())
				}
			}
			.build()
	}
	
	fun makeGetterFromBody(body: KtFunctionBody): FunSpec {
		return FunSpec.getterBuilder()
			.apply {
				body.statements.forEach {
					addStatement(it.toKotlinCode())
				}
			}
			.build()
	}
	
	
	val type = this.rType.toSpec()
	val bldr = PropertySpec.builder(
		this.name, type,
		listOf(
			access.toSpec(),
			modality.toSpec()
		)
	)
	
	bldr.mutable(isVar)
	
	extensionOf?.let {
		bldr.receiver(it.toSpec())
	}
	
	setter?.let {
		bldr.setter(makeSetterWithBody(type, it))
	}
	
	getter?.let {
		bldr.getter(makeGetterFromBody(it))
	}
	
	docComment.forEach {
		bldr.addKdoc(it)
	}
	
	contextParams.forEach {
		bldr.contextParameter(it.toContextParameterSpec())
	}
	
	return bldr.build()
}

fun AccessModifier.toSpec(): KModifier {
	return when (this) {
		AccessModifier.PUBLIC -> KModifier.PUBLIC
		AccessModifier.PRIVATE -> KModifier.PRIVATE
		AccessModifier.INTERNAL -> KModifier.INTERNAL
		AccessModifier.PROTECTED -> KModifier.PROTECTED
	}
}

fun KtClassDeclaration.toSpec(): TypeSpec {
	val bldr = when (this.type) {
		KtClassDeclaration.Type.INTERFACE -> TypeSpec.interfaceBuilder(this.name)
		KtClassDeclaration.Type.ABSTRACT_CLASS, KtClassDeclaration.Type.CLASS -> TypeSpec.classBuilder(this.name)
		KtClassDeclaration.Type.OBJECT -> TypeSpec.objectBuilder(this.name)
		KtClassDeclaration.Type.COMPANION_OBJECT -> TypeSpec.companionObjectBuilder()
	}
	
	bldr.addSuperinterfaces(this.parentInterfaces.map { it.toSpec() })
	
	this.baseClass?.let {
		bldr.superclass(it.toSpec())
	}
	
	if (isOpen)
		bldr.addModifiers(KModifier.OPEN)
	
	bldr.addProperties(this.properties.values.map { it.toSpec() })
	
	bldr.addFunctions(this.functions.map { toFunSpec(it) })
	
	this.docComment.forEach {
		bldr.addKdoc(it)
	}
	
	companionObject?.let {
		bldr.addType(it.toSpec())
	}
	
	bldr.addTypes(nestedClasses.values.map { it.toSpec() })
	
	return bldr.build()
}

fun KtParameter.toParameterSpec(): ParameterSpec {
	return ParameterSpec.builder(this.name, this.type.toSpec())
		.build()
}

fun KtParameter.toContextParameterSpec(): ContextParameter {
	return ContextParameter(this.name, this.type.toSpec())
}

fun KtType.toSpec(): TypeName {
	when (this) {
		is KtSimpleType -> {
			val baseType = this.classifier.toSpec()
			if (typeArguments.isEmpty()) {
				return baseType.copy(isNullable)
			}
			
			return baseType.parameterizedBy(
				typeArguments.map { it.toSpec() }
			).copy(isNullable)
		}
		
		is KtTypeParameter -> {
			val upper = this.upperBound?.toSpec()
			val variance = this.variance.toSpec()
			return TypeVariableName(this.name, listOfNotNull(upper), variance)
		}
	}
}

fun KtVariance.toSpec(): KModifier? {
	return when (this) {
		KtVariance.INVARIANT -> null
		KtVariance.IN -> KModifier.IN
		KtVariance.OUT -> KModifier.OUT
	}
}

fun KtClass.toSpec(): ClassName {
	return ClassName.bestGuess(this.fqName)
}

@OptIn(ExperimentalKotlinPoetApi::class)
fun toFunSpec(ktFunctionDeclaration: KtFunctionDeclaration): FunSpec {
	val bldr = FunSpec.builder(ktFunctionDeclaration.name).returns(ktFunctionDeclaration.returnType.toSpec())
	
	if (ktFunctionDeclaration.isInline)
		bldr.addModifiers(KModifier.INLINE)
	
	bldr.addModifiers(ktFunctionDeclaration.access.toSpec(), ktFunctionDeclaration.modality.toSpec())
	
	ktFunctionDeclaration.valueParameters.forEach {
		bldr.addParameter(it.toParameterSpec())
	}
	
	ktFunctionDeclaration.contextParameters.forEach {
		bldr.contextParameter(it.toContextParameterSpec())
	}
	
	ktFunctionDeclaration.docCommentLines.forEach {
		bldr.addKdoc(it)
	}
	
	ktFunctionDeclaration.extensionReceiver?.let {
		bldr.receiver(it.toSpec())
	}
	
	ktFunctionDeclaration.body.statements.forEach {
		bldr.addStatement(it.toKotlinCode())
	}
	
	return bldr.build()
}