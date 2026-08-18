package btpos.source.vdfdsl.tf2.codegen

import btpos.misc.kt.codegen.identifiers.KtMemberReference
import btpos.source.vdfdsl.backing.VDFPrimitive

class AttributesNav {
	/**
	 * Just take the highest case of it and assume it's good enough.
	 */
	val namedAttributesToLocations: MutableMap<VDFPrimitive, KtMemberReference> = HashMap()
}

