package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValueSingle
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExtensibleSubtreeImplTest {
	
	private var ExtensibleSubtreeImpl.thing: String? by addField("Thing")
	
	
	
	@Test
	fun copy() {
		val subtree = ExtensibleSubtreeImpl()
		
		subtree.thing = "foo"
		
		val copy = subtree.copy()
		copy.thing = "bar"
		
		assertNotEquals(subtree.thing, copy.thing)
	}
}