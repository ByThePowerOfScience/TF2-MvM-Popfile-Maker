package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable

class TFBotAttribute(override val _popFileRepr: Any) : IPopFileSerializable<Any> {
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
