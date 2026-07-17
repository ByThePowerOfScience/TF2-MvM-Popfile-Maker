package btpos.source.vdfdsl.tf2.rafmod.tftypes


class TFTeam(private val s: String) {
	companion object {
		val BLU = TFTeam("BLU")
		val RED = TFTeam("RED")
	}
	
	override fun toString(): String {
		return "TFTeam($s)"
	}
}