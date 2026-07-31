package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ProjectileFlareAttributes : BaseProjectileAttributes {
	companion object : IBlockScoped {
		val projectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
			ItemAttributeNamed<Number>("Projectile speed increased"),
			ItemAttributeNamed<Number>("Projectile speed decreased"),
			ItemAttributeNamed<Number>("Projectile speed increased HIDDEN"),
		)
	
		val blastRadius: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("Blast radius increased"),
			ItemAttributeNamed("Blast radius decreased"),
		)
	}

	val projectileSpeed: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> get() = ProjectileFlareAttributes.projectileSpeed
	
	val blastRadius: BonusPenalty<Number> get() = ProjectileFlareAttributes.blastRadius
}