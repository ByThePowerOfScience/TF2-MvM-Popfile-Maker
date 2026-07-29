package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ProjectileGrenadeAttributes : WeaponBaseAttributes {
	
	companion object {
		/**
		 * Checked on launcher.
		 */
		val useLargeSmokeExplosion: ItemAttributeNamed<Boolean> = ItemAttributeNamed("use large smoke explosion")
	
		/**
		 * In-Game: "Pumpkin Bombs"
		 * 
		 * Checked on launcher.
		 */
		val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween pumpkin explosions")
	
		val blastRadius: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("Blast radius increased"),
			ItemAttributeNamed("Blast radius decreased"),
		)
	
		/**
		 * In-Game: "N% fuse time on grenades"
		 * 
		 * Checked on owner.
		 */
		val fuseBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("fuse bonus")
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * Checked on launcher.
	 */
	val useLargeSmokeExplosion: ItemAttributeNamed<Boolean> get() = ProjectileGrenadeAttributes.useLargeSmokeExplosion
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Checked on launcher.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = ProjectileGrenadeAttributes.spellHalloweenPumpkinExplosions
	
	val blastRadius: BonusPenalty<Float> get() = ProjectileGrenadeAttributes.blastRadius
	
	/**
	 * In-Game: "N% fuse time on grenades"
	 * 
	 * Checked on owner.
	 */
	val fuseBonus: ItemAttributeNamed<Float> get() = ProjectileGrenadeAttributes.fuseBonus
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = ProjectileGrenadeAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = ProjectileGrenadeAttributes.damage
	
	override val fireRate: FireRateAttributes get() = ProjectileGrenadeAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = ProjectileGrenadeAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = ProjectileGrenadeAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = ProjectileGrenadeAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = ProjectileGrenadeAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = ProjectileGrenadeAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : WeaponBaseAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : WeaponBaseAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
}