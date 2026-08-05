package btpos.source.vdfdsl.tf2.rafmod.tests

import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.Companion.ragdolls
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.rafmod.attributes.PotatoCustomAttributes.neverGibs
import btpos.source.vdfdsl.tf2.rafmod.attributes.PotatoCustomAttributes.useRobotVoice
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodCustomAttributes.modelScale
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodCustomAttributes.setTurnToIce

val weaponBaseAttributes = (object : WeaponBaseAttributes {})

object ChaosBotkillers {
	enum class BotkillerType {
		Rust,
		Blood,
		Carbonado,
		Silver_Mk1,
		Silver_Mk2,
		Gold_Mk1,
		Gold_Mk2,
		Diamond;
		
		fun formatName(weaponName: String): String {
			val mk = if (this == Silver_Mk2 || this == Gold_Mk2) {
				"Mk.II"
			} else {
				"Mk.I"
			}
			
			return "${this.name.substringBefore("_")} Botkiller $weaponName $mk"
		}
	}
	
	context(_: IAttributeContainer)
	fun addBotkillerStats(weaponName: String, type: BotkillerType) {
		TFItem.ItemName = type.formatName(weaponName)
		
		with (weaponBaseAttributes) {
			when (type) {
				BotkillerType.Rust -> meta.useRobotVoice = true
				BotkillerType.Blood -> {
					voicePitch = 1.25
					meta.player.modelScale = 0.7
				}
				BotkillerType.Carbonado -> {
					meta.player.headScale = 2
					voicePitch = 0.8
				}
				BotkillerType.Silver_Mk1 -> {
					voicePitch = 1.1
					meta.player.headScale = 0.6
				}
				BotkillerType.Silver_Mk2 -> {
					meta.player.handScale = 1.75
				}
				BotkillerType.Gold_Mk1 -> {
					ragdolls.turnToGold = true
					ragdolls.neverGibs = true
					meta.player.headScale = 0.6
					voicePitch = 1.1
				}
				BotkillerType.Gold_Mk2 -> {
					ragdolls.turnToGold = true
					ragdolls.neverGibs = true
					meta.player.handScale = 1.75
				}
				BotkillerType.Diamond -> {
					ragdolls.setTurnToIce = true
					ragdolls.neverGibs = true
					meta.particles.attachParticleEffect = 36
				}
			}
		}
	}
	
	fun makeBotkillers(configuredStockWeapons: Map<String, TFItem<*>>): List<IAttributeContainer> {
		configuredStockWeapons.values.forEach {
			requireNotNull(it.attributes) {
				"No attributes configured for ${it.name}"
			}
		}
		
		return configuredStockWeapons.flatMap { (name, weapon) ->
			BotkillerType.entries.map { botkillerType ->
				weapon.copy().attributes!!.apply {
					addBotkillerStats(name, botkillerType)
				}
			}
		}
	}
}