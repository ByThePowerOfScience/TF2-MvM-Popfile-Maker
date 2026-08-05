package btpos.source.vdfdsl.tf2.rafmod.tests

import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ScattergunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.impl.invoke
import btpos.source.vdfdsl.tf2.rafmod.rafmod
import btpos.source.vdfdsl.types.WaveSchedule
import btpos.source.vdfdsl.utils.div
import btpos.source.vdfdsl.utils.plus
import btpos.source.vdfdsl.utils.times



fun calcDamageMult(baseDamage: Int, wantedDamage: Int): Double {
	return wantedDamage.toDouble() / baseDamage
}
object ScaleDamagePerShot {
	
	/**
	 * Calculate damage per pellet and damage falloff needed to satisfy the two damage thresholds
	 */
	context(_: IAttributeContainer)
	fun scatterguns(meatshotDamage: Int) {
		val nativeBaseDmgPerPellet = 6
		val nativeNumPellets = 10
		val nativeMaxRampup = 1.75 // 10.5 per pellet
		
		val currentBulletsPerShot = nativeNumPellets + (modBulletsPerShot.get() ?: 0)
		val newBaseDamagePerPellet = (meatshotDamage / currentBulletsPerShot) / nativeMaxRampup
		
		val damageMult = (newBaseDamagePerPellet * currentBulletsPerShot) / (nativeBaseDmgPerPellet * nativeNumPellets)
		multDmg = damageMult
	}
}



class chaos_weapons {
	
	
	
	
	
	fun make() = WaveSchedule {
		rafmod {
			noMissionInfo = true
			negativeDamageHealsTargets = false
			negativeDamageOverhealsTargets = false
			
			botBehavior {
				disableRomevision = true
			}
			
			halloween {
				botsDropSpells = false
				giantsDropRareSpells = false
				spellDropRateGiant = 0
				spellDropRateCommon = 0
			}
		}
		
		
	}
}