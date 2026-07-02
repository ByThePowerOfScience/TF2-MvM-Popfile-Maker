package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

class TFBotAttribute(val name: String) : IVDFRepresentableValue<VDFPrimitive> {
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object {
		val RemoveOnDeath = TFBotAttribute("RemoveOnDeath")
		val Aggressive = TFBotAttribute("Aggressive")
		val SuppressFire = TFBotAttribute("SuppressFire")
		val DisableDodge = TFBotAttribute("DisableDodge")
		val BecomeSpectatorOnDeath = TFBotAttribute("BecomeSpectatorOnDeath")
		val RetainBuildings = TFBotAttribute("RetainBuildings")
		val SpawnWithFullCharge = TFBotAttribute("SpawnWithFullCharge")
		val AlwaysCrit = TFBotAttribute("AlwaysCrit")
		val IgnoreEnemies = TFBotAttribute("IgnoreEnemies")
		val HoldFireUntilFullReload = TFBotAttribute("HoldFireUntilFullReload")
		val AlwaysFireWeapon = TFBotAttribute("AlwaysFireWeapon")
		val TeleportToHint = TFBotAttribute("TeleportToHint")
		val MiniBoss = TFBotAttribute("MiniBoss")
		val UseBossHealthBar = TFBotAttribute("UseBossHealthBar")
		val IgnoreFlag = TFBotAttribute("IgnoreFlag")
		
		val AutoJump = TFBotAttribute("AutoJump")
		val AirChargeOnly = TFBotAttribute("AirChargeOnly")
		
		
		val Parachute = TFBotAttribute("Parachute")
		val ProjectileShield = TFBotAttribute("ProjectileShield")
		
		object Vaccinator {
			val Bullet = TFBotAttribute("VaccinatorBullets")
			val Blast = TFBotAttribute("VaccinatorBlast")
			val Fire = TFBotAttribute("VaccinatorFire")
		}
		
		object Immunities {
			val BulletImmune = TFBotAttribute("BulletImmune")
			val BlastImmune = TFBotAttribute("BlastImmune")
			val FireImmune = TFBotAttribute("FireImmune")
		}
	}
}
