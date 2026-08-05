package btpos.source.vdfdsl.tf2.rafmod.tests

object ChaosScatterguns {
	context(_: IAttributeContainer)
	fun ScattergunAttributes.stockScattergunAttributes() {
		projectiles.bullets {
			modBulletsPerShot = 4
			multBulletSpread.penalty = 2.5
		}
		
		healthOnKillPercent = 10
		
		projectiles.penetration = 1
		
		ScaleDamagePerShot.scatterguns(TODO())
	}
	
	val stock = itemSettings()
}