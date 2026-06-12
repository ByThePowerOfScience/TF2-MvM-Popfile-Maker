package btpos.tf2.popfiledsl

import btpos.tf2.popfiledsl.types.ScoutWeapons
import btpos.tf2.popfiledsl.types.bots.BotSkill
import btpos.tf2.popfiledsl.types.bots.Paint
import btpos.tf2.popfiledsl.types.bots.WarPaints
import btpos.tf2.popfiledsl.types.bots.WeaponAttributes.OnHit.MARK_FOR_DEATH_ON_HIT
import btpos.tf2.popfiledsl.types.bots.WeaponAttributes.OnHit.STUN_MIDAIR_ENEMIES
import btpos.tf2.popfiledsl.types.bots.WeaponAttributes.Penalties.FIRERATE_PENALTY
import btpos.tf2.popfiledsl.types.populators.*
import btpos.tf2.popfiledsl.types.populators.Populator
import btpos.tf2.popfiledsl.types.spawners.TFBot
import btpos.tf2.popfiledsl.types.spawners.classIcon
import btpos.tf2.popfiledsl.types.spawners.health
import btpos.tf2.popfiledsl.types.spawners.items
import btpos.tf2.popfiledsl.types.spawners.skill
import btpos.tf2.popfiledsl.types.*
import btpos.tf2.popfiledsl.types.spawners.Spawners
import btpos.tf2.popfiledsl.types.specifics.Where

fun main() {
	val mission = Populator.Mission {
		beginAtWave = 4
		runForThisManyWaves = 12
		
		spawner = Spawners.TFBot {
			where = Where.ANYWHERE
		}
	}
}

