package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral.Companion.literal

class WarPaintsScope(private val container: IKeyValueMap)  {
	var id: Int?
		get() = container.getTyped("paintkit_proto_def_index".literal())
		set(value) = container.setNullable("paint_kit_proto_def_index".literal(), value)
	
	var wear: Wear?
		get() = container.getTyped("set_item_texture_wear".literal())
		set(value) = container.setNullable("set_item_texture_wear".literal(), value)
	
	class Wear(val id: Double) : IPopFileSerializable<Double> {
		override val _popFileRepr: Double
			get() = id
		
		companion object {
			val FACTORY_NEW = Wear(0.2)
			//TODO
		}
	}
}

val WeaponAttributesContainer.WarPaints
	get() = WarPaintsScope(this)

inline fun WeaponAttributesContainer.WarPaints(configure: WarPaintsScope.() -> Unit) {
	WarPaints.apply(configure)
}