package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ShovelAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * In-Game: "Damage increases as the user becomes injured"
		 * 
		 * Used to specify "shovel type".
		 * 
		 * 0 = Standard.
		 * 
		 * 1 = Equalizer.
		 * 
		 * 2 = Escape Plan.
		 * 
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEqualizer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod shovel damage boost", NumberSelectorCodec(1))
	
		/**
		 * In-Game: "Move speed increases as the user becomes injured"
		 * 
		 * Used to specify "shovel type".
		 * 
		 * 0 = Standard.
		 * 
		 * 1 = Equalizer.
		 * 
		 * 2 = Escape Plan.
		 * 
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEscapePlan: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod shovel speed boost", NumberSelectorCodec(2))
	
		/**
		 * On primary attack, send player flying in the direction they're facing.
		 */
		val airJumpOnAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("air jump on attack")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	/**
	 * In-Game: "Damage increases as the user becomes injured"
	 * 
	 * Used to specify "shovel type".
	 * 
	 * 0 = Standard.
	 * 
	 * 1 = Equalizer.
	 * 
	 * 2 = Escape Plan.
	 * 
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEqualizer: ItemAttributeNamed<Boolean> get() = ShovelAttributes.isEqualizer
	
	/**
	 * In-Game: "Move speed increases as the user becomes injured"
	 * 
	 * Used to specify "shovel type".
	 * 
	 * 0 = Standard.
	 * 
	 * 1 = Equalizer.
	 * 
	 * 2 = Escape Plan.
	 * 
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEscapePlan: ItemAttributeNamed<Boolean> get() = ShovelAttributes.isEscapePlan
	
	/**
	 * On primary attack, send player flying in the direction they're facing.
	 */
	val airJumpOnAttack: ItemAttributeNamed<Boolean> get() = ShovelAttributes.airJumpOnAttack
	
	override val crits: CritsAttributes get() = ShovelAttributes.crits
	
	override val damage: DamageAttributes get() = ShovelAttributes.damage
	
	override val onHit: OnHitAttributes get() = ShovelAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = ShovelAttributes.swapWeapons

	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}