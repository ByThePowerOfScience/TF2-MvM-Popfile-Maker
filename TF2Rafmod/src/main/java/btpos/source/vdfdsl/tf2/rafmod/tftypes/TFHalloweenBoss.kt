package btpos.source.vdfdsl.tf2.rafmod.tftypes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

class TFHalloweenBoss(override val _vdfRepr: VDFPrimitive) : IVDFRepresentableValue_Trivial {
	constructor(name: String) : this(VDFPrimitive(name))
	
	companion object {
		@JvmField val MONOCULUS = TFHalloweenBoss("MONOCULUS")
		@JvmField val MERASMUS = TFHalloweenBoss("Merasmus")
		@JvmField val HORSELESS_HEADLESS_HORSEMANN = TFHalloweenBoss("HHH")
		@JvmField val SKELETONSMALL = TFHalloweenBoss("SkeletonSmall")
		@JvmField val SKELETONNORMAL = TFHalloweenBoss("SkeletonNormal")
		@JvmField val SKELETONKING = TFHalloweenBoss("SkeletonKing")
	}
}