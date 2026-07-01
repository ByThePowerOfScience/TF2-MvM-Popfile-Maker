package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.IVDFSerializableValue_Primitive
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped

object WarPaintsAttributes : IBlockScoped {
	context(attrs: IKeyValueMap)
	var id: Int?
		get() = attrs.getTyped("paintkit_proto_def_index")
		set(value) = attrs.setNullable("paint_kit_proto_def_index", value)
	
	
	context(attrs: IKeyValueMap)
	var wear: Wear?
		get() = attrs.getTyped("set_item_texture_wear")
		set(value) = attrs.setNullable("set_item_texture_wear", value)
	
	/**
	 * The RNG seed for the war paint.
	 */
	context(attrs: IKeyValueMap)
	var seed: Long?
		get() {
			val lowBits = attrs.getTyped<Int>("custom_paintkit_seed_lo") ?: return null;
			val highBits = attrs.getTyped<Int>("custom_paintkit_seed_hi") ?: return null;
			
			return (lowBits.toLong() shl 32) or highBits.toLong()
		}
		set(value) {
			if (value == null) {
				attrs.setNullable("custom_paintkit_seed_lo", null)
				attrs.setNullable("custom_paintkit_seed_hi", null)
				return;
			}
			
			val lowBits = (value and ((1L shl 32) - 1)).toInt()
			val highBits = (value shr 32).toInt()
			attrs.setNullable("custom_paintkit_seed_lo", lowBits)
			attrs.setNullable("custom_paintkit_seed_hi", highBits)
		}
	
	
	class Wear(val id: Double) : IVDFSerializableValue_Primitive<Double> {
		override val _primitiveRepr: Double
			get() = id
		
		companion object {
			val FACTORY_NEW = Wear(0.2)
			val MINIMAL_WEAR = Wear(0.4)
			val FIELD_TESTED = Wear(0.6)
			val WELL_WORN = Wear(0.8)
			val BATTLE_SCARRED = Wear(1.0)
		}
	}
}

val WeaponBaseAttributes.WarPaints get() = WarPaintsAttributes