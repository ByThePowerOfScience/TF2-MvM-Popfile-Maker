package btpos.source.vdfdsl.tf2.items

import java.awt.Color


object PaintColors {
	@JvmField val `An Air of Debonair (RED)` = Color(101, 71, 64)
	@JvmField val `An Air of Debonair (BLU)` = Color(40, 57, 77)
	
	@JvmField val `Cream Spirit (RED)` = Color(195, 108, 45)
	@JvmField val `Operator's Overalls (RED)` = Color(72, 56, 56)
	@JvmField val `Team Spirit (RED)` = Color(184, 56, 59)
	@JvmField val `The Value of Teamwork (RED)` = Color(128, 48, 32)
	@JvmField val `Waterlogged Lab Coat (RED)` = Color(168, 154, 140)
	
	@JvmField val `Cream Spirit (BLU)` = Color(24, 35, 61)
	@JvmField val `Operator's Overalls (BLU)` = Color(184, 128, 53)
	@JvmField val `Team Spirit (BLU)` = Color(56, 66, 72)
	@JvmField val `The Value of Teamwork (BLU)` = Color(37, 109, 141)
	@JvmField val `Waterlogged Lab Coat (BLU)` = Color(131, 159, 163)
	
	@JvmField val `A Color Similar to Slate` = Color(47, 79, 79)
	@JvmField val `A Deep Commitment to Purple` = Color(125, 64, 113)
	@JvmField val `A Distinctive Lack of Hue` = Color(20, 20, 20)
	@JvmField val `A Mann's Mint` = Color(188, 221, 179)
	@JvmField val `After Eight` = Color(45, 45, 36)
	@JvmField val `Aged Moustache Grey` = Color(126, 126, 126)
	@JvmField val `An Extraordinary Abundance of Tinge` = Color(230, 230, 230)
	@JvmField val `Australium Gold` = Color(231, 181, 59)
	@JvmField val `Color No 216-190-216` = Color(216, 190, 216)
	@JvmField val `Dark Salmon Injustice` = Color(233, 150, 122)
	@JvmField val `Drably Olive` = Color(128, 128, 0)
	@JvmField val `Indubitably Green` = Color(114, 158, 66)
	@JvmField val `Mann Co Orange` = Color(207, 115, 54)
	@JvmField val Muskelmannbraun = Color(165, 117, 69)
	@JvmField val `Noble Hatter's Violet` = Color(81, 56, 74)
	@JvmField val `Peculiarly Drab Tincture` = Color(197, 175, 145)
	@JvmField val `Pink as Hell` = Color(255, 105, 180)
	@JvmField val `Radigan Conagher Brown` = Color(105, 77, 58)
	@JvmField val `The Bitter Taste of Defeat and Lime` = Color(50, 205, 50)
	@JvmField val `The Color of a Gentlemann's Business Pants` = Color(240, 230, 140)
	@JvmField val `Ye Olde Rustic Colour` = Color(124, 108, 87)
	@JvmField val `Zepheniah's Greed` = Color(66, 79, 59)
	
	private fun rgbToString(r: Int, g: Int, b: Int): String {
		return ((r shl 16) or (g shl 8) or b).toString(10)
	}
}
