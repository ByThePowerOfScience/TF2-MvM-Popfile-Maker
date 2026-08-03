package btpos.source.vdfdsl.tf2.tftypes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

open class FootstepOverride(val index: Int) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive = VDFPrimitive(index)
	
	companion object {
		val Default = FootstepOverride(0)
		val SoccerCleats = FootstepOverride(1)
		val HeavyGiant = FootstepOverride(2)
		val SoldierGiant = FootstepOverride(3)
		val DemoGiant = FootstepOverride(4)
		val ScoutGiant = FootstepOverride(5)
		val PyroGiant = FootstepOverride(6)
		val SentryBuster = FootstepOverride(7)
		val TreasureChest = FootstepOverride(8)
		val Octopus = FootstepOverride(9)
	}
}