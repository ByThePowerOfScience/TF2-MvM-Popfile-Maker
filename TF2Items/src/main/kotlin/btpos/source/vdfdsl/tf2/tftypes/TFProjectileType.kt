package btpos.source.vdfdsl.tf2.tftypes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

class TFProjectileType(val number: Int) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive get() = VDFPrimitive(number)
	
	companion object {
		val TF_PROJECTILE_NONE = TFProjectileType(0)
		val TF_PROJECTILE_BULLET = TFProjectileType(1)
		val TF_PROJECTILE_ROCKET = TFProjectileType(2)
		val TF_PROJECTILE_PIPEBOMB = TFProjectileType(3)
		val TF_PROJECTILE_PIPEBOMB_REMOTE = TFProjectileType(4)
		val TF_PROJECTILE_SYRINGE = TFProjectileType(5)
		val TF_PROJECTILE_FLARE = TFProjectileType(6)
		val TF_PROJECTILE_JAR = TFProjectileType(7)
		val TF_PROJECTILE_ARROW = TFProjectileType(8)
		val TF_PROJECTILE_FLAME_ROCKET = TFProjectileType(9)
		val TF_PROJECTILE_JAR_MILK = TFProjectileType(10)
		val TF_PROJECTILE_HEALING_BOLT = TFProjectileType(11)
		val TF_PROJECTILE_ENERGY_BALL = TFProjectileType(12)
		val TF_PROJECTILE_ENERGY_RING = TFProjectileType(13)
		val TF_PROJECTILE_PIPEBOMB_PRACTICE = TFProjectileType(14)
		val TF_PROJECTILE_CLEAVER = TFProjectileType(15)
		val TF_PROJECTILE_STICKY_BALL = TFProjectileType(16)
		val TF_PROJECTILE_CANNONBALL = TFProjectileType(17)
		val TF_PROJECTILE_BUILDING_REPAIR_BOLT = TFProjectileType(18)
		val TF_PROJECTILE_FESTIVE_ARROW = TFProjectileType(19)
		val TF_PROJECTILE_THROWABLE = TFProjectileType(20)
		val TF_PROJECTILE_SPELL = TFProjectileType(21)
		val TF_PROJECTILE_FESTIVE_JAR = TFProjectileType(22)
		val TF_PROJECTILE_FESTIVE_HEALING_BOLT = TFProjectileType(23)
		val TF_PROJECTILE_BREADMONSTER_JARATE = TFProjectileType(24)
		val TF_PROJECTILE_BREADMONSTER_MADMILK = TFProjectileType(25)
		val TF_PROJECTILE_GRAPPLINGHOOK = TFProjectileType(26)
		val TF_PROJECTILE_SENTRY_ROCKET = TFProjectileType(27)
		val TF_PROJECTILE_BREAD_MONSTER = TFProjectileType(28)
	}
}