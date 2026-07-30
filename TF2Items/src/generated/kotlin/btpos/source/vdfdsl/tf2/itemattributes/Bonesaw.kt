package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface BonesawAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * In-Game: "Collect the organs of people you hit"
		 */
		val uberchargePreservedOnSpawnMax: ItemAttributeNamed<Float> = ItemAttributeNamed("ubercharge_preserved_on_spawn_max")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	override val heads: HeadsAttributes get() = super.heads
	
	override val taunting: TauntingAttributes get() = super.taunting
	
	/**
	 * In-Game: "Collect the organs of people you hit"
	 */
	val uberchargePreservedOnSpawnMax: ItemAttributeNamed<Float> get() = BonesawAttributes.uberchargePreservedOnSpawnMax
	
	override val crits: CritsAttributes get() = BonesawAttributes.crits
	
	override val damage: DamageAttributes get() = BonesawAttributes.damage
	
	override val onHit: OnHitAttributes get() = BonesawAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BonesawAttributes.swapWeapons

	open class HeadsAttributes : IBlockScoped {
		/**
		 * In-Game: "Collect the organs of your victims"
		 * 
		 * On kill, take an organ (uses "heads" field like usual).
		 */
		open val addHeadOnKill: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add_head_on_kill")
	
		/**
		 * If the player should take a "head" when dealing damage with a melee.
		 */
		open val addHeadOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add head on hit")
	}
	
	open class TauntingAttributes : IBlockScoped {
		/**
		 * If set, the player will taunt on right click.
		 */
		open val specialTaunt: ItemAttributeNamed<Boolean> = ItemAttributeNamed("special taunt")
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}