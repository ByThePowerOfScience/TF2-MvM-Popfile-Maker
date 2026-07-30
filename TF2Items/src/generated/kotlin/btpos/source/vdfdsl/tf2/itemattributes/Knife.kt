package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface KnifeAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * 0: Stock.
		 * 
		 * 1: Your Eternal Reward.
		 * 
		 * 2: Cloak and Dagger (idk why).
		 * 
		 * 3: Spycicle.
		 */
		val setIcicleKnifeMode: ItemAttributeNamed<Boolean> = ItemAttributeNamed("set icicle knife mode", NumberSelectorCodec(3))
	
		/**
		 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
		 */
		val meltsInFire: ItemAttributeNamed<Boolean> = ItemAttributeNamed("melts in fire")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	}

	override val damage: DamageAttributes get() = KnifeAttributes.damage
	
	override val healthAndHealing: HealthAndHealingAttributes get() = super.healthAndHealing
	
	override val disguise: DisguiseAttributes get() = super.disguise
	
	/**
	 * 0: Stock.
	 * 
	 * 1: Your Eternal Reward.
	 * 
	 * 2: Cloak and Dagger (idk why).
	 * 
	 * 3: Spycicle.
	 */
	val setIcicleKnifeMode: ItemAttributeNamed<Boolean> get() = KnifeAttributes.setIcicleKnifeMode
	
	/**
	 * In-Game: "Melts in fire, regenerates in N seconds and by picking up ammo"
	 */
	val meltsInFire: ItemAttributeNamed<Boolean> get() = KnifeAttributes.meltsInFire
	
	override val crits: CritsAttributes get() = KnifeAttributes.crits
	
	override val onHit: OnHitAttributes get() = KnifeAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = KnifeAttributes.swapWeapons

	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() {
		/**
		 * In-Game: "Increase backstab damage against Giant Robots by N%"
		 * 
		 * Spy only does 25% damage against minibosses by default.	The number here is added to that percentage, up to a max of 100% + 25% = 125%.
		 * 
		 * Note that this is an actual PERCENTAGE of armor penetrated, not a proportion:	`25.0`, `50.0`, up to `100.0`.
		 * 
		 * Also, with max armor penetration, you apparently do 25% *more* damage against minibosses than you do against regular bots.
		 * 
		 * Checked on player.
		 */
		open val armorPiercing: ItemAttributeNamed<Float> = ItemAttributeNamed("armor piercing")
	
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : IBlockScoped {
			/**
			 * In-Game: "N% damage penalty"
			 * 
			 * Base backstab damage against minibosses is 250 * this proportion.
			 */
			open val damagePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("damage penalty")
	
			/**
			 * In-Game: "+N% damage bonus"
			 * 
			 * Base backstab damage against minibosses is 250 * this proportion.
			 */
			open val damageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus")
	
			/**
			 * In-Game: "+N% damage bonus"
			 * 
			 * Base backstab damage against minibosses is 250 * this proportion.
			 */
			open val damageBonusHidden: ItemAttributeNamed<Float> = ItemAttributeNamed("damage bonus HIDDEN")
	
			/**
			 * In-Game: "+N% damage bonus"
			 * 
			 * Base backstab damage against minibosses is 250 * this proportion.
			 */
			open val cardDamageBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("CARD: damage bonus")
		}
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		/**
		 * In-Game: "On Backstab: Absorbs the health from your victim."
		 * 
		 * Gain health on backstab.
		 */
		open val gainHealthOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sanguisuge")
	}
	
	open class DisguiseAttributes : IBlockScoped {
		/**
		 * In-Game: "Upon a successful backstab against a human target, you rapidly disguise as your victim"
		 */
		open val disguiseOnBackstab: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise on backstab")
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() 
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() 
}