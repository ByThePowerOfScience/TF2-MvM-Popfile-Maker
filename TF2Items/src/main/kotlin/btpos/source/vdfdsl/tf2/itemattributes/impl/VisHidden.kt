package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.Codec

open class VisHidden<VIS : Any, HIDDEN : Any>(private val visible_attrName: String, private val hidden_attrName: String, private val visibleCodec: Codec<VIS, Any> = Codec.Companion.identity(), private val hiddenCodec: Codec<HIDDEN, Any> = Codec.Companion.identity()) {
	context(attrs: IKeyValueMap)
	var visible: VIS?
	    get() = attrs.getTyped(visible_attrName, visibleCodec)
	    set(value) = attrs.setNullable(visible_attrName, value, visibleCodec)
	
	context(attrs: IKeyValueMap)
	var hidden: HIDDEN?
	    get() = attrs.getTyped(hidden_attrName, hiddenCodec)
	    set(value) = attrs.setNullable(hidden_attrName, value, hiddenCodec)
}