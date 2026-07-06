package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

class TFBotAttribute(val name: String) : IVDFRepresentableValue<VDFPrimitive> {
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object {
		@JvmField val RemoveOnDeath = TFBotAttribute("RemoveOnDeath")
		@JvmField val Aggressive = TFBotAttribute("Aggressive")
		@JvmField val SuppressFire = TFBotAttribute("SuppressFire")
		@JvmField val DisableDodge = TFBotAttribute("DisableDodge")
		@JvmField val BecomeSpectatorOnDeath = TFBotAttribute("BecomeSpectatorOnDeath")
		@JvmField val RetainBuildings = TFBotAttribute("RetainBuildings")
		@JvmField val SpawnWithFullCharge = TFBotAttribute("SpawnWithFullCharge")
		@JvmField val AlwaysCrit = TFBotAttribute("AlwaysCrit")
		@JvmField val IgnoreEnemies = TFBotAttribute("IgnoreEnemies")
		@JvmField val HoldFireUntilFullReload = TFBotAttribute("HoldFireUntilFullReload")
		@JvmField val AlwaysFireWeapon = TFBotAttribute("AlwaysFireWeapon")
		@JvmField val TeleportToHint = TFBotAttribute("TeleportToHint")
		@JvmField val MiniBoss = TFBotAttribute("MiniBoss")
		@JvmField val UseBossHealthBar = TFBotAttribute("UseBossHealthBar")
		@JvmField val IgnoreFlag = TFBotAttribute("IgnoreFlag")
		
		@JvmField val AutoJump = TFBotAttribute("AutoJump")
		@JvmField val AirChargeOnly = TFBotAttribute("AirChargeOnly")
		
		
		@JvmField val Parachute = TFBotAttribute("Parachute")
		@JvmField val ProjectileShield = TFBotAttribute("ProjectileShield")
		
		object Vaccinator {
			@JvmField val Bullet = TFBotAttribute("VaccinatorBullets")
			@JvmField val Blast = TFBotAttribute("VaccinatorBlast")
			@JvmField val Fire = TFBotAttribute("VaccinatorFire")
		}
		
		object Immunities {
			@JvmField val BulletImmune = TFBotAttribute("BulletImmune")
			@JvmField val BlastImmune = TFBotAttribute("BlastImmune")
			@JvmField val FireImmune = TFBotAttribute("FireImmune")
		}
	}
}
