package btpos.source.vdfdsl.tf2.rafmod.tftypes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

class TFSpell(override val _vdfRepr: VDFPrimitive) : IVDFRepresentableValue_Trivial {
	constructor(name: String) : this(VDFPrimitive(name))
	
	companion object {
		@JvmField
		val `Healing Aura` = TFSpell("Healing Aura")
		
		@JvmField
		val Fireball = TFSpell("Fireball")
		
		@JvmField
		val `Ball O' Bats` = TFSpell("Ball O' Bats")
		
		@JvmField
		val `Pumpkin Bombs` = TFSpell("Pumpkin MIRV")
		
		@JvmField
		val Superjump = TFSpell("Superjump")
		
		@JvmField
		val Invisibility = TFSpell("Invisibility")
		
		@JvmField
		val Teleport = TFSpell("Teleport")
		
		@JvmField
		val `Tesla Bolt` = TFSpell("Tesla Bolt")
		
		@JvmField
		val Minify = TFSpell("Minify")
		
		@JvmField
		val `Meteor Shower` = TFSpell("Meteor Shower")
		
		@JvmField
		val `Summon Monoculous` = TFSpell("Summon Monoculous")
		
		@JvmField
		val `Summon Skeletons` = TFSpell("Summon Skeletons")
		
		
	}
}