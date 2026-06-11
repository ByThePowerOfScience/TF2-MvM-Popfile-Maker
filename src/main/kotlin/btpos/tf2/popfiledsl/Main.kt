package btpos.tf2.popfiledsl

import btpos.tf2.popfiledsl.types.ScoutWeapons
import btpos.tf2.popfiledsl.types.bots.BotSkill
import btpos.tf2.popfiledsl.types.bots.Paint
import btpos.tf2.popfiledsl.types.bots.WarPaints
import btpos.tf2.popfiledsl.types.bots.WeaponAttributes.OnHit.MARK_FOR_DEATH_ON_HIT
import btpos.tf2.popfiledsl.types.bots.WeaponAttributes.OnHit.STUN_MIDAIR_ENEMIES
import btpos.tf2.popfiledsl.types.bots.WeaponAttributes.Penalties.FIRERATE_PENALTY
import btpos.tf2.popfiledsl.types.spawners.TFBot
import btpos.tf2.popfiledsl.types.spawners.classIcon
import btpos.tf2.popfiledsl.types.spawners.health
import btpos.tf2.popfiledsl.types.spawners.items
import btpos.tf2.popfiledsl.types.spawners.skill

fun main() {
val cursedScout = TFBot("Cursed Scout") {
	classIcon = "scout_cursed"
	health = 10_000
	skill = BotSkill.HARD
	
	items = listOf(
		ScoutWeapons.SCATTERGUN {
			MARK_FOR_DEATH_ON_HIT = true
			STUN_MIDAIR_ENEMIES = true
			FIRERATE_PENALTY = 1.5
			
			
			WarPaints.ID = 255
			Paint.COLOR = 65380
		},
		ScoutWeapons.BAT
	)
}
}


