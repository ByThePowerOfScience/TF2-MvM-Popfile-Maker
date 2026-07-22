package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.selector
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFTeam
import btpos.source.vdfdsl.tf2.rafmod.types.PointTemplate

object RafmodSerializers {
	@JvmField val BOOL_SER_INVERT = Boolean::not
	
	@JvmField val COORD3D = { it: Vec3 -> "${it.x} ${it.y} ${it.z}" }
	
	@JvmField val TFTEAM_NUMBER = { it: TFTeam -> when (it) {
		TFTeam.RED -> 2
		TFTeam.BLU -> 3
		TFTeam.NEUTRAL -> 5
		else -> error("Unrecognized team: $it")
	} }
	
	@JvmField val TFTEAM_NAME = { it: TFTeam ->
		when (it) {
			TFTeam.BLU -> "Blue"
			TFTeam.RED -> "Red"
			else -> error("Invalid team: $this")
		}
	}
	
	@JvmField val POINTTEMPLATE_NAME = selector(PointTemplate::name)
}