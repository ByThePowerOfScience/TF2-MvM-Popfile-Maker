package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileRepresentable

enum class WeaponRestriction : IPopFileRepresentable<String> {
	PrimaryOnly,
	SecondaryOnly,
	MeleeOnly;
	
	override val popFileRepr = name
}