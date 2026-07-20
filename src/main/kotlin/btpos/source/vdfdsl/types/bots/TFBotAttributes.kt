package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

open class TFBotAttributes(name: String) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr = VDFPrimitive(name)
	
	
	
	companion object {
		@JvmField val RemoveOnDeath = TFBotAttributes("RemoveOnDeath")
		@JvmField val Aggressive = TFBotAttributes("Aggressive")
		@JvmField val SuppressFire = TFBotAttributes("SuppressFire")
		@JvmField val DisableDodge = TFBotAttributes("DisableDodge")
		@JvmField val BecomeSpectatorOnDeath = TFBotAttributes("BecomeSpectatorOnDeath")
		@JvmField val RetainBuildings = TFBotAttributes("RetainBuildings")
		@JvmField val SpawnWithFullCharge = TFBotAttributes("SpawnWithFullCharge")
		@JvmField val AlwaysCrit = TFBotAttributes("AlwaysCrit")
		@JvmField val IgnoreEnemies = TFBotAttributes("IgnoreEnemies")
		@JvmField val HoldFireUntilFullReload = TFBotAttributes("HoldFireUntilFullReload")
		@JvmField val AlwaysFireWeapon = TFBotAttributes("AlwaysFireWeapon")
		@JvmField val TeleportToHint = TFBotAttributes("TeleportToHint")
		@JvmField val MiniBoss = TFBotAttributes("MiniBoss")
		@JvmField val UseBossHealthBar = TFBotAttributes("UseBossHealthBar")
		@JvmField val IgnoreFlag = TFBotAttributes("IgnoreFlag")
		
		@JvmField val AutoJump = TFBotAttributes("AutoJump")
		@JvmField val AirChargeOnly = TFBotAttributes("AirChargeOnly")
		
		
		@JvmField val Parachute = TFBotAttributes("Parachute")
		@JvmField val ProjectileShield = TFBotAttributes("ProjectileShield")
		
		object Vaccinator {
			@JvmField val Bullet = TFBotAttributes("VaccinatorBullets")
			@JvmField val Blast = TFBotAttributes("VaccinatorBlast")
			@JvmField val Fire = TFBotAttributes("VaccinatorFire")
		}
		
		object Immunities {
			@JvmField val BulletImmune = TFBotAttributes("BulletImmune")
			@JvmField val BlastImmune = TFBotAttributes("BlastImmune")
			@JvmField val FireImmune = TFBotAttributes("FireImmune")
		}
	}
}

val TFBotSpawner.Attributes get() = TFBotAttributes.Companion
