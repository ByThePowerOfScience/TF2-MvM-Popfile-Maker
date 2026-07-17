package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFTeam

object RafmodSerializers {
	
	@JvmField val BOOL_SER_INVERT = { it: Boolean -> BinaryIntCodec.write(!it) }
	
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
}