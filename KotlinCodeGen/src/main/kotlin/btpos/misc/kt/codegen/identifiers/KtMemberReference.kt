package btpos.misc.kt.codegen.identifiers

import btpos.misc.kt.codegen.util.ReflectionUtils.fqName
import kotlin.reflect.KFunction
import kotlin.reflect.full.extensionReceiverParameter

// TODO what is the point of this?
//  like, it's to make sure extensions are really imported separately from others,
//  but could I not just merge this into KtName?
data class KtMemberReference(
	val target: KtName,
	val isExtension: Boolean = false
) : KtCallable {
	constructor(ref: KFunction<*>) : this(ref.fqName, ref.extensionReceiverParameter != null)
	
	override val importsNeeded: Sequence<String>
		get() = if (isExtension) target.importsNeeded else emptySequence()
	
	override val callableName: KtName
		get() = target
	
	override fun toKotlinCode(): String {
		return target.toKotlinCode()
	}
}
