package btpos.source.vdfdsl.serialization

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFSubtree
import kotlin.jvm.java

fun interface IVDFRepresentableKeyValue : IVDFRepresentable {
	/**
	 * Add this value to the currently-serialized map.
	 *
	 * @param input The current state of the map to be serialized.
	 */
	fun _serializeInto(input: VDFSubtree)
	
	companion object {
		fun isKeyValueRepresentable(cls: Class<*>): Boolean {
			return IVDFRepresentableKeyValue::class.java.isAssignableFrom(cls)
		}
	}
}


/**
 * An item that just serializes to a single key-value entry.
 */
interface IVDFRepresentableKeyValueSingle : IVDFRepresentableKeyValue {
	fun _popFileEntryRepr(): VDFKeyValue
	
	override fun _serializeInto(input: VDFSubtree) {
		input += this._popFileEntryRepr()
	}
}

operator fun VDFSubtree.plusAssign(representableValue: IVDFRepresentableKeyValue) {
	representableValue._serializeInto(this)
}
