
package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.tf2.templates.PopFileTemplate

@MustUseReturnValues
object Spawners {
	
	/**
	 * Create a TFBot.
	 *
	 *  To set it as the current [populator][btpos.source.vdfdsl.types.populators.AbstractPopulator]'s spawner, either set the populator's [spawner][btpos.source.vdfdsl.types.populators.AbstractPopulator.spawner] field (`spawner = TFBot { ... }`) or use the unary `+` operator (`+TFBot { ... }`).
	 *
	 * Example usage:
	 * ```kotlin
	 * val jacob = TFBot(name="Jacob") {
	 *      `class` = TFClass.Heavy
	 *      skill = BotSkill.Hard
	 *      items += WeaponsAll.STOCK_MINIGUN {
	 *          fireRate.bonus = 0.5
	 *      }
	 * }
	 * ```
	 *
	 * @param name The "name" field for this bot for easy labeling. Optional. (e.g. `val jacob = TFBot(name="Jacob") { ... }`)
	 * @param template The template this bot should extend, for easy template usage. (e.g. `val FAST_SCOUT = TFBot(template="T_TFBot_Giant_Scout_Fast")`)
	 * @param configure Set fields in here, and they'll be applied to the bot.
	 */
	inline fun TFBot(name: String? = null, template: PopFileTemplate? = null, configure: TFBotSpawner.() -> Unit = {}) = TFBotSpawner(name, template, configure)
	
	
	inline fun RandomChoice(vararg spawners: AbstractSpawner, configure: RandomChoiceSpawner.() -> Unit = {}): RandomChoiceSpawner {
		return RandomChoiceSpawner().apply { this.spawners.addAll(spawners) }.apply(configure)
	}
	
	@Deprecated("Old and crusty")
	fun Mob(count: Int, spawner: AbstractSpawner): MobSpawner {
		return MobSpawner().apply {
			this.count = count
			this.spawner = spawner
		}
	}
	
	inline fun Squad(configure: SquadSpawner.() -> Unit) = SquadSpawner().apply(configure)
	
	inline fun Tank(configure: TankSpawner.() -> Unit = {}) = TankSpawner().apply(configure)
}