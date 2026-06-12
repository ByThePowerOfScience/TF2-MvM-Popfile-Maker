package btpos.tf2.popfiledsl.types

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral
import btpos.tf2.popfiledsl.types.bots.TFItem
import java.awt.Color

class PaintColors(val color: Color) : IPopFileSerializable<PopFileStringLiteral> {
	override val _popFileRepr: PopFileStringLiteral
		get() = PopFileStringLiteral(rgbToString(color.red, color.blue, color.green))
	
	companion object {
		val `An Air of Debonair (RED)` = Color(101, 71, 64)
		val `An Air of Debonair (BLU)` = Color(40, 57, 77)
		
		val `Cream Spirit (RED)` = Color(195, 108, 45)
		val `Operator's Overalls (RED)` = Color(72, 56, 56)
		val `Team Spirit (RED)` = Color(184, 56, 59)
		val `The Value of Teamwork (RED)` = Color(128, 48, 32)
		val `Waterlogged Lab Coat (RED)` = Color(168, 154, 140)
		
		val `Cream Spirit (BLU)` = Color(24, 35, 61)
		val `Operator's Overalls (BLU)` = Color(184, 128, 53)
		val `Team Spirit (BLU)` = Color(56, 66, 72)
		val `The Value of Teamwork (BLU)` = Color(37, 109, 141)
		val `Waterlogged Lab Coat (BLU)` = Color(131, 159, 163)
		
		val `A Color Similar to Slate` = Color(47, 79, 79)
		val `A Deep Commitment to Purple` = Color(125, 64, 113)
		val `A Distinctive Lack of Hue` = Color(20, 20, 20)
		val `A Mann's Mint` = Color(188, 221, 179)
		val `After Eight` = Color(45, 45, 36)
		val `Aged Moustache Grey` = Color(126, 126, 126)
		val `An Extraordinary Abundance of Tinge` = Color(230, 230, 230)
		val `Australium Gold` = Color(231, 181, 59)
		val `Color No 216-190-216` = Color(216, 190, 216)
		val `Dark Salmon Injustice` = Color(233, 150, 122)
		val `Drably Olive` = Color(128, 128, 0)
		val `Indubitably Green` = Color(114, 158, 66)
		val `Mann Co Orange` = Color(207, 115, 54)
		val Muskelmannbraun = Color(165, 117, 69)
		val `Noble Hatter's Violet` = Color(81, 56, 74)
		val `Peculiarly Drab Tincture` = Color(197, 175, 145)
		val `Pink as Hell` = Color(255, 105, 180)
		val `Radigan Conagher Brown` = Color(105, 77, 58)
		val `The Bitter Taste of Defeat and Lime` = Color(50, 205, 50)
		val `The Color of a Gentlemann's Business Pants` = Color(240, 230, 140)
		val `Ye Olde Rustic Colour` = Color(124, 108, 87)
		val `Zepheniah's Greed` = Color(66, 79, 59)
		
		private fun rgbToString(r: Int, g: Int, b: Int): String {
			return ((r shl 16) or (g shl 8) or b).toString(10)
		}
	}
}

object ScoutWeapons {
	val SCATTERGUN = TFItem("Upgradeable TF_WEAPON_SCATTERGUN")
	val BAT = TFItem("Upgradeable TF_WEAPON_SCATTERGUN")
}



