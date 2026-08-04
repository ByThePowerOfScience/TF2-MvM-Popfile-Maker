package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

open class StunOnHitType(val name: String) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive = VDFPrimitive.Companion(name)
	
	companion object {
		/**
		 * Slow the player by the amount specified in [stunOnHitSlow].
		 */
		val Movement = StunOnHitType("movement")
		
		/**
		 * Inflict the
		 */
		val Panic = StunOnHitType("panic")
		
		/**
		 * Inflict the Halloween ghosts' "BOO!" stun effect.
		 */
		val Ghost = StunOnHitType("ghost")
		
		/**
		 * Inflict the Sandman's "BONK!" stun effect.
		 */
		val BigBonk = StunOnHitType("bigbonk")
	}
}