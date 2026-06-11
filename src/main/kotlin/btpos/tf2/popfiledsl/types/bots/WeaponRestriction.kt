package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable

enum class WeaponRestriction : IPopFileSerializable<String> {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val popFileRepr = name
}