package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ProjectileFlareAttributes : BaseProjectileAttributes {
	
	companion object {
		val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("Projectile speed increased"),
			ItemAttributeNamed<Float>("Projectile speed decreased"),
			ItemAttributeNamed<Float>("Projectile speed increased HIDDEN"),
		)
	
		val blastRadius: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Blast radius increased"),
			ItemAttributeNamed("Blast radius decreased"),
		)
	}

	val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> get() = ProjectileFlareAttributes.projectileSpeed
	
	val blastRadius: BonusPenalty<Float> get() = ProjectileFlareAttributes.blastRadius
}