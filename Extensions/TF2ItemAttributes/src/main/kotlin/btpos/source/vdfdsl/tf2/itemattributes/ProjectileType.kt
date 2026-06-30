package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.IVDFSerializableValue

class ProjectileType(val number: Int) : IVDFSerializableValue<Int> {
	override val _vdfRepr: Int get() = number
	
	companion object {
		val TF_PROJECTILE_NONE = ProjectileType(0)
		val TF_PROJECTILE_BULLET = ProjectileType(1)
		val TF_PROJECTILE_ROCKET = ProjectileType(2)
		val TF_PROJECTILE_PIPEBOMB = ProjectileType(3)
		val TF_PROJECTILE_PIPEBOMB_REMOTE = ProjectileType(4)
		val TF_PROJECTILE_SYRINGE = ProjectileType(5)
		val TF_PROJECTILE_FLARE = ProjectileType(6)
		val TF_PROJECTILE_JAR = ProjectileType(7)
		val TF_PROJECTILE_ARROW = ProjectileType(8)
		val TF_PROJECTILE_FLAME_ROCKET = ProjectileType(9)
		val TF_PROJECTILE_JAR_MILK = ProjectileType(10)
		val TF_PROJECTILE_HEALING_BOLT = ProjectileType(11)
		val TF_PROJECTILE_ENERGY_BALL = ProjectileType(12)
		val TF_PROJECTILE_ENERGY_RING = ProjectileType(13)
		val TF_PROJECTILE_PIPEBOMB_PRACTICE = ProjectileType(14)
		val TF_PROJECTILE_CLEAVER = ProjectileType(15)
		val TF_PROJECTILE_STICKY_BALL = ProjectileType(16)
		val TF_PROJECTILE_CANNONBALL = ProjectileType(17)
		val TF_PROJECTILE_BUILDING_REPAIR_BOLT = ProjectileType(18)
		val TF_PROJECTILE_FESTIVE_ARROW = ProjectileType(19)
		val TF_PROJECTILE_THROWABLE = ProjectileType(20)
		val TF_PROJECTILE_SPELL = ProjectileType(21)
		val TF_PROJECTILE_FESTIVE_JAR = ProjectileType(22)
		val TF_PROJECTILE_FESTIVE_HEALING_BOLT = ProjectileType(23)
		val TF_PROJECTILE_BREADMONSTER_JARATE = ProjectileType(24)
		val TF_PROJECTILE_BREADMONSTER_MADMILK = ProjectileType(25)
		val TF_PROJECTILE_GRAPPLINGHOOK = ProjectileType(26)
		val TF_PROJECTILE_SENTRY_ROCKET = ProjectileType(27)
		val TF_PROJECTILE_BREAD_MONSTER = ProjectileType(28)
	}
}