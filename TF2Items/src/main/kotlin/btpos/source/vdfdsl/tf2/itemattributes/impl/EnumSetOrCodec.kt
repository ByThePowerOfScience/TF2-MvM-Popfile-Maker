package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.codecs.Codec
import java.util.EnumSet
import kotlin.jvm.java

fun <T> EnumSetOrCodec(): IExtensibleSubtree.Serializers.Serializer<EnumSet<T>> where T : Enum<T>, T : IEnumCustomValue {
	return { it: EnumSet<T> ->
		IVDFRepresentableValue.serializeDynamic(it.fold(0) { i, t -> i or t.value })
	}
}