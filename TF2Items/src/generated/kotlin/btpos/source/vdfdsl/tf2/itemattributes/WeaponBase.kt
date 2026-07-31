package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WeaponBaseAttributes : BaseCombatWeaponAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
		 * 
		 * If true, make weapon deploy and holster 75% slower.
		 */
		val isASword: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is_a_sword")
	
		/**
		 * In-Game: "Replaces the Sentry with a Mini-Sentry"
		 * 
		 * Determines the hand used in the model.
		 */
		val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod wrench builds minisentry")
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}

	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If true, make weapon deploy and holster 75% slower.
	 */
	val isASword: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.isASword
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 * 
	 * Determines the hand used in the model.
	 */
	val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.wrenchBuildsMinisentry
	
	val afterburn: AfterburnAttributes get() = WeaponBaseAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = WeaponBaseAttributes.ammo
	
	val buildings: BuildingsAttributes get() = WeaponBaseAttributes.buildings
	
	override val crits: CritsAttributes get() = WeaponBaseAttributes.crits
	
	override val damage: DamageAttributes get() = WeaponBaseAttributes.damage
	
	val demoCharge: DemoChargeAttributes get() = WeaponBaseAttributes.demoCharge
	
	val firing: FiringAttributes get() = WeaponBaseAttributes.firing
	
	val healthAndHealing: HealthAndHealingAttributes get() = WeaponBaseAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WeaponBaseAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = WeaponBaseAttributes.meta
	
	override val meter: MeterAttributes get() = WeaponBaseAttributes.meter
	
	val movement: MovementAttributes get() = WeaponBaseAttributes.movement
	
	val heads: HeadsAttributes get() = WeaponBaseAttributes.heads
	
	val onHit: OnHitAttributes get() = WeaponBaseAttributes.onHit
	
	val onKill: OnKillAttributes get() = WeaponBaseAttributes.onKill
	
	val projectiles: ProjectilesAttributes get() = WeaponBaseAttributes.projectiles
	
	val reloading: ReloadingAttributes get() = WeaponBaseAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = WeaponBaseAttributes.resistance
	
	val revengeCrits: RevengeCritsAttributes get() = WeaponBaseAttributes.revengeCrits
	
	val statusEffects: StatusEffectsAttributes get() = WeaponBaseAttributes.statusEffects
	
	val taunting: TauntingAttributes get() = WeaponBaseAttributes.taunting
	
	val viewmodel: ViewmodelAttributes get() = WeaponBaseAttributes.viewmodel
	
	val swapWeapons: SwapWeaponsAttributes get() = WeaponBaseAttributes.swapWeapons
	
	val whenHit: WhenHitAttributes get() = WeaponBaseAttributes.whenHit
	
	val ragdolls: RagdollsAttributes get() = WeaponBaseAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = WeaponBaseAttributes.disguise

	open class AfterburnAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "On Hit: target is engulfed in flames"
			 * 
			 * Ignites player on hit.
			 */
			val setDamagetypeIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Set DamageType Ignite")
	
			val weaponBurnDmgReduced: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("weapon burn dmg increased"),
				ItemAttributeNamed("weapon burn dmg reduced"),
			)
	
			val weaponBurnTimeReduced: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("weapon burn time increased"),
				ItemAttributeNamed("weapon burn time reduced"),
			)
	
			/**
			 * In-Game: "Halloween Fire"
			 * 
			 * Makes afterburn green.
			 */
			val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
		}
	
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignites player on hit.
		 */
		context(attrs: IAttributeContainer)
		open var setDamagetypeIgnite: Boolean? 
			get() = AfterburnAttributes.setDamagetypeIgnite.get()
			set(value) { AfterburnAttributes.setDamagetypeIgnite.set(value) }
	
		context(attrs: IAttributeContainer)
		open var weaponBurnDmgReduced: Number? 
			get() = AfterburnAttributes.weaponBurnDmgReduced.get()
			set(value) { AfterburnAttributes.weaponBurnDmgReduced.set(value) }
	
		context(attrs: IAttributeContainer)
		open var weaponBurnTimeReduced: Number? 
			get() = AfterburnAttributes.weaponBurnTimeReduced.get()
			set(value) { AfterburnAttributes.weaponBurnTimeReduced.set(value) }
	
		/**
		 * In-Game: "Halloween Fire"
		 * 
		 * Makes afterburn green.
		 */
		context(attrs: IAttributeContainer)
		open var spellHalloweenGreenFlames: Boolean? 
			get() = AfterburnAttributes.spellHalloweenGreenFlames.get()
			set(value) { AfterburnAttributes.spellHalloweenGreenFlames.set(value) }
	}
	
	open class AmmoAttributes : BaseCombatWeaponAttributes.AmmoAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "No ammo from dispensers when active"
			 */
			val noPrimaryAmmoFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no primary ammo from dispensers while active")
	
			/**
			 * In-Game: "No metal from dispensers when active."
			 */
			val noMetalFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no metal from dispensers while active")
		}
	
		/**
		 * In-Game: "No ammo from dispensers when active"
		 */
		context(attrs: IAttributeContainer)
		open var noPrimaryAmmoFromDispensersWhileActive: Boolean? 
			get() = AmmoAttributes.noPrimaryAmmoFromDispensersWhileActive.get()
			set(value) { AmmoAttributes.noPrimaryAmmoFromDispensersWhileActive.set(value) }
	
		/**
		 * In-Game: "No metal from dispensers when active."
		 */
		context(attrs: IAttributeContainer)
		open var noMetalFromDispensersWhileActive: Boolean? 
			get() = AmmoAttributes.noMetalFromDispensersWhileActive.get()
			set(value) { AmmoAttributes.noMetalFromDispensersWhileActive.set(value) }
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseCombatWeaponAttributes.AmmoAttributes.ClipSizeAttributes() {
			companion object : IBlockScoped {
				val clipSize: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
					ItemAttributeNamed<Number>("clip size bonus"),
					ItemAttributeNamed<Number>("clip size penalty"),
					ItemAttributeNamed<Number>("clip size penalty HIDDEN"),
				)
	
				/**
				 * In-Game: "+N% clip size"
				 */
				val clipSizeBonusUpgrade: ItemAttributeNamed<Int> = ItemAttributeNamed("clip size bonus upgrade")
	
				/**
				 * In-Game: "+N clip size"
				 * 
				 * MVM attribute that specifically handles rocket and grenade launchers.
				 * 
				 * Note that all three of these are different classes, which means they stack.
				 */
				val clipSizeUpgradeAtomic: ItemAttributeNamed<Int> = ItemAttributeNamed("clip size upgrade atomic")
	
				/**
				 * In-Game: "Clip size increased on kill"
				 */
				val clipsizeIncreaseOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("clipsize increase on kill")
			}
	
			context(attrs: IAttributeContainer)
			open var clipSize: Number? 
				get() = ClipSizeAttributes.clipSize.get()
				set(value) { ClipSizeAttributes.clipSize.set(value) }
	
			/**
			 * In-Game: "+N% clip size"
			 */
			context(attrs: IAttributeContainer)
			open var clipSizeBonusUpgrade: Int? 
				get() = ClipSizeAttributes.clipSizeBonusUpgrade.get()
				set(value) { ClipSizeAttributes.clipSizeBonusUpgrade.set(value) }
	
			/**
			 * In-Game: "+N clip size"
			 * 
			 * MVM attribute that specifically handles rocket and grenade launchers.
			 * 
			 * Note that all three of these are different classes, which means they stack.
			 */
			context(attrs: IAttributeContainer)
			open var clipSizeUpgradeAtomic: Int? 
				get() = ClipSizeAttributes.clipSizeUpgradeAtomic.get()
				set(value) { ClipSizeAttributes.clipSizeUpgradeAtomic.set(value) }
	
			/**
			 * In-Game: "Clip size increased on kill"
			 */
			context(attrs: IAttributeContainer)
			open var clipsizeIncreaseOnKill: Int? 
				get() = ClipSizeAttributes.clipsizeIncreaseOnKill.get()
				set(value) { ClipSizeAttributes.clipsizeIncreaseOnKill.set(value) }
		}
	}
	
	open class BuildingsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
			 * 
			 * Metal cost to pick up a building at range.
			 * 
			 * Restricted to the default rescue ranger range, but can be used by any weapon.
			 */
			val engineerBuildingTeleportingPickup: ItemAttributeNamed<Int> = ItemAttributeNamed("engineer building teleporting pickup")
		}
	
		/**
		 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
		 * 
		 * Metal cost to pick up a building at range.
		 * 
		 * Restricted to the default rescue ranger range, but can be used by any weapon.
		 */
		context(attrs: IAttributeContainer)
		open var engineerBuildingTeleportingPickup: Int? 
			get() = BuildingsAttributes.engineerBuildingTeleportingPickup.get()
			set(value) { BuildingsAttributes.engineerBuildingTeleportingPickup.set(value) }
	}
	
	open class CritsAttributes : BaseCombatWeaponAttributes.CritsAttributes() {
		companion object : IBlockScoped {
			val critChance: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("crit mod disabled"), ItemAttributeNamed<Number>("crit mod disabled hidden"))
	
			/**
			 * In-Game: "Cannot be crit boosted"
			 * 
			 * Can't be crit-boosted.
			 */
			val noCritBoost: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit boost")
	
			val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
			/**
			 * In-Game: "100% critical hit vs wet players"
			 */
			val critVsWetPlayers: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit vs wet players")
	
			/**
			 * In-Game: "100% critical hit vs non-burning players"
			 * 
			 * Crit against players that DON'T have these conditions.
			 */
			val critVsNonBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs non burning players", EnumSetOrCodec())
	
			/**
			 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
			 * 
			 * On hitting a burning player, crit them from behind or minicrit them otherwise.
			 */
			val axtinguisherProperties: ItemAttributeNamed<Boolean> = ItemAttributeNamed("axtinguisher properties")
	
			/**
			 * In-Game: "Deals crits while the wielder is rocket jumping"
			 * 
			 * Critical hit enemies if the player was launched into the air by an explosion.
			 * 
			 * Only works when not in Mannpower mode.
			 */
			val critWhileAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod crit while airborne")
	
			/**
			 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
			 * 
			 * Only activates if the weapon deals `DMG_MELEE`.
			 */
			val attackMinicritsAndConsumesBurning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("attack_minicrits_and_consumes_burning")
	
			/**
			 * In-Game: "100% minicrits vs burning players"
			 * 
			 * Minicrits if the damage dealt is NOT `DMG_BURN`.
			 */
			val minicritVsBurningPlayer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrit vs burning player")
	
			/**
			 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
			 * 
			 * Mini-crits targets launched airborne by an explosion.
			 * 
			 * Only procs when not in Mannpower mode.
			 */
			val minicritAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod mini-crit airborne")
	
			/**
			 * In-Game: "Mini-crits targets when fired at their back from close range"
			 * 
			 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
			 */
			val closerangeBackattackMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("closerange backattack minicrits")
	
			/**
			 * In-Game: "Crits whenever it would normally mini-crit"
			 */
			val minicritsBecomeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrits become crits")
	
			/**
			 * In-Game: "No critical hits vs non-burning players"
			 * 
			 * Note: Even prevents criticals when crit-boosted.
			 */
			val noCritVsNonburning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit vs nonburning")
	
			/**
			 * In-Game: "Critical damage is affected by range"
			 * 
			 * If true, crits have damage falloff (Ambassador).
			 */
			val critDmgFalloff: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit_dmg_falloff")
	
			/**
			 * In-Game: "Minicrits whenever it would normally crit"
			 */
			val critsBecomeMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crits_become_minicrits")
		}
	
		context(attrs: IAttributeContainer)
		open var critChance: Number? 
			get() = CritsAttributes.critChance.get()
			set(value) { CritsAttributes.critChance.set(value) }
	
		/**
		 * In-Game: "Cannot be crit boosted"
		 * 
		 * Can't be crit-boosted.
		 */
		context(attrs: IAttributeContainer)
		open var noCritBoost: Boolean? 
			get() = CritsAttributes.noCritBoost.get()
			set(value) { CritsAttributes.noCritBoost.set(value) }
	
		/**
		 * In-Game: "100% critical hit vs wet players"
		 */
		context(attrs: IAttributeContainer)
		open var critVsWetPlayers: Boolean? 
			get() = CritsAttributes.critVsWetPlayers.get()
			set(value) { CritsAttributes.critVsWetPlayers.set(value) }
	
		/**
		 * In-Game: "100% critical hit vs non-burning players"
		 * 
		 * Crit against players that DON'T have these conditions.
		 */
		context(attrs: IAttributeContainer)
		open var critVsNonBurningPlayers: EnumSet<TFCritCondition>? 
			get() = CritsAttributes.critVsNonBurningPlayers.get()
			set(value) { CritsAttributes.critVsNonBurningPlayers.set(value) }
	
		/**
		 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
		 * 
		 * On hitting a burning player, crit them from behind or minicrit them otherwise.
		 */
		context(attrs: IAttributeContainer)
		open var axtinguisherProperties: Boolean? 
			get() = CritsAttributes.axtinguisherProperties.get()
			set(value) { CritsAttributes.axtinguisherProperties.set(value) }
	
		/**
		 * In-Game: "Deals crits while the wielder is rocket jumping"
		 * 
		 * Critical hit enemies if the player was launched into the air by an explosion.
		 * 
		 * Only works when not in Mannpower mode.
		 */
		context(attrs: IAttributeContainer)
		open var critWhileAirborne: Boolean? 
			get() = CritsAttributes.critWhileAirborne.get()
			set(value) { CritsAttributes.critWhileAirborne.set(value) }
	
		/**
		 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
		 * 
		 * Only activates if the weapon deals `DMG_MELEE`.
		 */
		context(attrs: IAttributeContainer)
		open var attackMinicritsAndConsumesBurning: Boolean? 
			get() = CritsAttributes.attackMinicritsAndConsumesBurning.get()
			set(value) { CritsAttributes.attackMinicritsAndConsumesBurning.set(value) }
	
		/**
		 * In-Game: "100% minicrits vs burning players"
		 * 
		 * Minicrits if the damage dealt is NOT `DMG_BURN`.
		 */
		context(attrs: IAttributeContainer)
		open var minicritVsBurningPlayer: Boolean? 
			get() = CritsAttributes.minicritVsBurningPlayer.get()
			set(value) { CritsAttributes.minicritVsBurningPlayer.set(value) }
	
		/**
		 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
		 * 
		 * Mini-crits targets launched airborne by an explosion.
		 * 
		 * Only procs when not in Mannpower mode.
		 */
		context(attrs: IAttributeContainer)
		open var minicritAirborne: Boolean? 
			get() = CritsAttributes.minicritAirborne.get()
			set(value) { CritsAttributes.minicritAirborne.set(value) }
	
		/**
		 * In-Game: "Mini-crits targets when fired at their back from close range"
		 * 
		 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
		 */
		context(attrs: IAttributeContainer)
		open var closerangeBackattackMinicrits: Boolean? 
			get() = CritsAttributes.closerangeBackattackMinicrits.get()
			set(value) { CritsAttributes.closerangeBackattackMinicrits.set(value) }
	
		/**
		 * In-Game: "Crits whenever it would normally mini-crit"
		 */
		context(attrs: IAttributeContainer)
		open var minicritsBecomeCrits: Boolean? 
			get() = CritsAttributes.minicritsBecomeCrits.get()
			set(value) { CritsAttributes.minicritsBecomeCrits.set(value) }
	
		/**
		 * In-Game: "No critical hits vs non-burning players"
		 * 
		 * Note: Even prevents criticals when crit-boosted.
		 */
		context(attrs: IAttributeContainer)
		open var noCritVsNonburning: Boolean? 
			get() = CritsAttributes.noCritVsNonburning.get()
			set(value) { CritsAttributes.noCritVsNonburning.set(value) }
	
		/**
		 * In-Game: "Critical damage is affected by range"
		 * 
		 * If true, crits have damage falloff (Ambassador).
		 */
		context(attrs: IAttributeContainer)
		open var critDmgFalloff: Boolean? 
			get() = CritsAttributes.critDmgFalloff.get()
			set(value) { CritsAttributes.critDmgFalloff.set(value) }
	
		/**
		 * In-Game: "Minicrits whenever it would normally crit"
		 */
		context(attrs: IAttributeContainer)
		open var critsBecomeMinicrits: Boolean? 
			get() = CritsAttributes.critsBecomeMinicrits.get()
			set(value) { CritsAttributes.critsBecomeMinicrits.set(value) }
	
		open val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "100% critical hit vs burning players"
				 * 
				 * The weapon's "crit players with X condition" stat.
				 */
				val critVsBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs burning players", EnumSetOrCodec())
	
				/**
				 * In-Game: "100% critical hit vs disguised players"
				 * 
				 * The weapon's "crit players with X condition" stat.
				 */
				val critVsDisguisedPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs disguised players", EnumSetOrCodec())
	
				/**
				 * In-Game: "100% critical hit vs stunned players"
				 * 
				 * The weapon's "crit players with X condition" stat.
				 */
				val critVsStunnedPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs stunned players", EnumSetOrCodec())
			}
	
			/**
			 * In-Game: "100% critical hit vs burning players"
			 * 
			 * The weapon's "crit players with X condition" stat.
			 */
			context(attrs: IAttributeContainer)
			open var critVsBurningPlayers: EnumSet<TFCritCondition>? 
				get() = CritVsBurningPlayersAttributes.critVsBurningPlayers.get()
				set(value) { CritVsBurningPlayersAttributes.critVsBurningPlayers.set(value) }
	
			/**
			 * In-Game: "100% critical hit vs disguised players"
			 * 
			 * The weapon's "crit players with X condition" stat.
			 */
			context(attrs: IAttributeContainer)
			open var critVsDisguisedPlayers: EnumSet<TFCritCondition>? 
				get() = CritVsBurningPlayersAttributes.critVsDisguisedPlayers.get()
				set(value) { CritVsBurningPlayersAttributes.critVsDisguisedPlayers.set(value) }
	
			/**
			 * In-Game: "100% critical hit vs stunned players"
			 * 
			 * The weapon's "crit players with X condition" stat.
			 */
			context(attrs: IAttributeContainer)
			open var critVsStunnedPlayers: EnumSet<TFCritCondition>? 
				get() = CritVsBurningPlayersAttributes.critVsStunnedPlayers.get()
				set(value) { CritVsBurningPlayersAttributes.critVsStunnedPlayers.set(value) }
		}
	}
	
	open class DamageAttributes : BaseCombatWeaponAttributes.DamageAttributes() {
		companion object : IBlockScoped {
			val damage: DamageAttributes = DamageAttributes()
	
			val dmgVsBuildings: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("dmg bonus vs buildings"), ItemAttributeNamed<Number>("dmg penalty vs buildings"))
	
			/**
			 * In-Game: "N% damage vs players"
			 */
			val dmgPenaltyVsPlayers: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs players")
	
			/**
			 * In-Game: "N% damage vs non-burning players"
			 */
			val dmgPenaltyVsNonburning: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs nonburning")
	
			/**
			 * In-Game: "N% damage bonus vs burning players"
			 */
			val damageBonusVsBurning: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus vs burning")
	
			/**
			 * In-Game: "Attacks pierce damage resistance effects and bonuses"
			 * 
			 * Damage pierces through all resistances, such as Vaccinator ubercharges and the Battalion's Backup.
			 */
			val dmgPiercesResistsAbsorbs: ItemAttributeNamed<Boolean> = ItemAttributeNamed("dmg pierces resists absorbs")
	
			/**
			 * In-Game: "N% increased damage to your sentry's target"
			 */
			val damageBonusBulletVsSentryTarget: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus bullet vs sentry target")
	
			/**
			 * In-Game: "N% damage on body shot"
			 * 
			 * Multiplier applied to bodyshot damage.
			 */
			val damagePenaltyOnBodyshot: ItemAttributeNamed<Number> = ItemAttributeNamed("damage penalty on bodyshot")
		}
	
		context(attrs: IAttributeContainer)
		open var dmgVsBuildings: Number? 
			get() = DamageAttributes.dmgVsBuildings.get()
			set(value) { DamageAttributes.dmgVsBuildings.set(value) }
	
		/**
		 * In-Game: "N% damage vs players"
		 */
		context(attrs: IAttributeContainer)
		open var dmgPenaltyVsPlayers: Number? 
			get() = DamageAttributes.dmgPenaltyVsPlayers.get()
			set(value) { DamageAttributes.dmgPenaltyVsPlayers.set(value) }
	
		/**
		 * In-Game: "N% damage vs non-burning players"
		 */
		context(attrs: IAttributeContainer)
		open var dmgPenaltyVsNonburning: Number? 
			get() = DamageAttributes.dmgPenaltyVsNonburning.get()
			set(value) { DamageAttributes.dmgPenaltyVsNonburning.set(value) }
	
		/**
		 * In-Game: "N% damage bonus vs burning players"
		 */
		context(attrs: IAttributeContainer)
		open var damageBonusVsBurning: Number? 
			get() = DamageAttributes.damageBonusVsBurning.get()
			set(value) { DamageAttributes.damageBonusVsBurning.set(value) }
	
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 * 
		 * Damage pierces through all resistances, such as Vaccinator ubercharges and the Battalion's Backup.
		 */
		context(attrs: IAttributeContainer)
		open var dmgPiercesResistsAbsorbs: Boolean? 
			get() = DamageAttributes.dmgPiercesResistsAbsorbs.get()
			set(value) { DamageAttributes.dmgPiercesResistsAbsorbs.set(value) }
	
		/**
		 * In-Game: "N% increased damage to your sentry's target"
		 */
		context(attrs: IAttributeContainer)
		open var damageBonusBulletVsSentryTarget: Number? 
			get() = DamageAttributes.damageBonusBulletVsSentryTarget.get()
			set(value) { DamageAttributes.damageBonusBulletVsSentryTarget.set(value) }
	
		/**
		 * In-Game: "N% damage on body shot"
		 * 
		 * Multiplier applied to bodyshot damage.
		 */
		context(attrs: IAttributeContainer)
		open var damagePenaltyOnBodyshot: Number? 
			get() = DamageAttributes.damagePenaltyOnBodyshot.get()
			set(value) { DamageAttributes.damagePenaltyOnBodyshot.set(value) }
	
		open val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "N% damage penalty"
				 */
				val damagePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("damage penalty")
	
				/**
				 * In-Game: "+N% damage bonus"
				 */
				val damageBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus")
	
				/**
				 * In-Game: "+N% damage bonus"
				 */
				val damageBonusHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus HIDDEN")
	
				/**
				 * In-Game: "+N% damage bonus"
				 */
				val cardDamageBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: damage bonus")
			}
	
			/**
			 * In-Game: "N% damage penalty"
			 */
			context(attrs: IAttributeContainer)
			open var damagePenalty: Number? 
				get() = DamageAttributes.damagePenalty.get()
				set(value) { DamageAttributes.damagePenalty.set(value) }
	
			/**
			 * In-Game: "+N% damage bonus"
			 */
			context(attrs: IAttributeContainer)
			open var damageBonus: Number? 
				get() = DamageAttributes.damageBonus.get()
				set(value) { DamageAttributes.damageBonus.set(value) }
	
			/**
			 * In-Game: "+N% damage bonus"
			 */
			context(attrs: IAttributeContainer)
			open var damageBonusHidden: Number? 
				get() = DamageAttributes.damageBonusHidden.get()
				set(value) { DamageAttributes.damageBonusHidden.set(value) }
	
			/**
			 * In-Game: "+N% damage bonus"
			 */
			context(attrs: IAttributeContainer)
			open var cardDamageBonus: Number? 
				get() = DamageAttributes.cardDamageBonus.get()
				set(value) { DamageAttributes.cardDamageBonus.set(value) }
		}
	}
	
	open class DemoChargeAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Melee hits refill  N% of your charge meter."
			 * 
			 * Restores demoman shield charge on hit.
			 */
			val chargeMeterOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("charge meter on hit")
	
			/**
			 * In-Game: "Ammo boxes collected also give Charge"
			 * 
			 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
			 */
			val ammoPacksGiveDemoknightCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ammo gives charge")
		}
	
		/**
		 * In-Game: "Melee hits refill  N% of your charge meter."
		 * 
		 * Restores demoman shield charge on hit.
		 */
		context(attrs: IAttributeContainer)
		open var chargeMeterOnHit: Number? 
			get() = DemoChargeAttributes.chargeMeterOnHit.get()
			set(value) { DemoChargeAttributes.chargeMeterOnHit.set(value) }
	
		/**
		 * In-Game: "Ammo boxes collected also give Charge"
		 * 
		 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
		 */
		context(attrs: IAttributeContainer)
		open var ammoPacksGiveDemoknightCharge: Boolean? 
			get() = DemoChargeAttributes.ammoPacksGiveDemoknightCharge.get()
			set(value) { DemoChargeAttributes.ammoPacksGiveDemoknightCharge.set(value) }
	}
	
	open class FiringAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val autoFiresFullClip: BonusPenalty<Boolean> = BonusPenalty(
				ItemAttributeNamed("auto fires full clip"),
				ItemAttributeNamed("auto fires full clip penalty"),
			)
	
			val autoFiresFullClipAllAtOnce: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires full clip all at once")
	
			val autoFiresWhenFull: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires when full")
	
			/**
			 * In-Game: "Overloading the chamber will cause a misfire"
			 * 
			 * Deals damage to the player when overloaded.
			 */
			val canOverload: ItemAttributeNamed<Boolean> = ItemAttributeNamed("can overload")
	
			val fireRate: FireRateAttributes = FireRateAttributes()
		}
	
		context(attrs: IAttributeContainer)
		open var autoFiresFullClip: Boolean? 
			get() = FiringAttributes.autoFiresFullClip.get()
			set(value) { FiringAttributes.autoFiresFullClip.set(value) }
	
		context(attrs: IAttributeContainer)
		open var autoFiresFullClipAllAtOnce: Boolean? 
			get() = FiringAttributes.autoFiresFullClipAllAtOnce.get()
			set(value) { FiringAttributes.autoFiresFullClipAllAtOnce.set(value) }
	
		context(attrs: IAttributeContainer)
		open var autoFiresWhenFull: Boolean? 
			get() = FiringAttributes.autoFiresWhenFull.get()
			set(value) { FiringAttributes.autoFiresWhenFull.set(value) }
	
		/**
		 * In-Game: "Overloading the chamber will cause a misfire"
		 * 
		 * Deals damage to the player when overloaded.
		 */
		context(attrs: IAttributeContainer)
		open var canOverload: Boolean? 
			get() = FiringAttributes.canOverload.get()
			set(value) { FiringAttributes.canOverload.set(value) }
	
		open val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : IBlockScoped {
			companion object : IBlockScoped {
				val fireRate: FireRateAttributes = FireRateAttributes()
			}
	
			open val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : IBlockScoped {
				companion object : IBlockScoped {
					/**
					 * In-Game: "N% slower firing speed"
					 * 
					 * After firing, you wait a bit before you can fire again. That's the "delay".
					 */
					val fireRatePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("fire rate penalty")
	
					/**
					 * In-Game: "+N% faster firing speed"
					 * 
					 * After firing, you wait a bit before you can fire again. That's the "delay".
					 */
					val fireRateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("fire rate bonus")
	
					/**
					 * After firing, you wait a bit before you can fire again. That's the "delay".
					 */
					val fireRatePenaltyHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("fire rate penalty HIDDEN")
	
					/**
					 * In-Game: "+N% faster firing speed"
					 * 
					 * After firing, you wait a bit before you can fire again. That's the "delay".
					 */
					val fireRateBonusHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("fire rate bonus HIDDEN")
	
					/**
					 * In-Game: "+N% faster melee attack speed"
					 * 
					 * After firing, you wait a bit before you can fire again. That's the "delay".
					 */
					val meleeAttackRateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("melee attack rate bonus")
				}
	
				/**
				 * In-Game: "N% slower firing speed"
				 * 
				 * After firing, you wait a bit before you can fire again. That's the "delay".
				 */
				context(attrs: IAttributeContainer)
				open var fireRatePenalty: Number? 
					get() = FireRateAttributes.fireRatePenalty.get()
					set(value) { FireRateAttributes.fireRatePenalty.set(value) }
	
				/**
				 * In-Game: "+N% faster firing speed"
				 * 
				 * After firing, you wait a bit before you can fire again. That's the "delay".
				 */
				context(attrs: IAttributeContainer)
				open var fireRateBonus: Number? 
					get() = FireRateAttributes.fireRateBonus.get()
					set(value) { FireRateAttributes.fireRateBonus.set(value) }
	
				/**
				 * After firing, you wait a bit before you can fire again. That's the "delay".
				 */
				context(attrs: IAttributeContainer)
				open var fireRatePenaltyHidden: Number? 
					get() = FireRateAttributes.fireRatePenaltyHidden.get()
					set(value) { FireRateAttributes.fireRatePenaltyHidden.set(value) }
	
				/**
				 * In-Game: "+N% faster firing speed"
				 * 
				 * After firing, you wait a bit before you can fire again. That's the "delay".
				 */
				context(attrs: IAttributeContainer)
				open var fireRateBonusHidden: Number? 
					get() = FireRateAttributes.fireRateBonusHidden.get()
					set(value) { FireRateAttributes.fireRateBonusHidden.set(value) }
	
				/**
				 * In-Game: "+N% faster melee attack speed"
				 * 
				 * After firing, you wait a bit before you can fire again. That's the "delay".
				 */
				context(attrs: IAttributeContainer)
				open var meleeAttackRateBonus: Number? 
					get() = FireRateAttributes.meleeAttackRateBonus.get()
					set(value) { FireRateAttributes.meleeAttackRateBonus.set(value) }
			}
		}
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Blocks healing while in use"
			 * 
			 * Prevents mediguns from latching onto you.
			 */
			val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
			val activeHealthDegen: BonusPenalty<Int> = BonusPenalty(
				ItemAttributeNamed("active health regen"),
				ItemAttributeNamed("active health degen"),
			)
	
			/**
			 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
			 * 
			 * Multiplier applied to your healer's ubercharge rate.
			 * 
			 * NOTE: Only applied if user is outside of the respawn room.
			 */
			val uberchargeRateBonusForHealer: ItemAttributeNamed<Number> = ItemAttributeNamed("ubercharge rate bonus for healer")
	
			/**
			 * In-Game: "On Hit: Gain up to +N health per attack"
			 * 
			 * Maximum amount of health that can be gained from an AoE damage source.
			 * 
			 * Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
			 */
			val healthOnRadiusDamage: ItemAttributeNamed<Int> = ItemAttributeNamed("health on radius damage")
	
			/**
			 * In-Game: "N% health from healers on wearer"
			 * 
			 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
			 */
			val multHealthFromhealersPenaltyActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_health_fromhealers_penalty_active")
	
			/**
			 * In-Game: "N% Overheal build rate."
			 * 
			 * Checked on the player that is healing an entity.
			 */
			val overhealFillRateReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal fill rate reduced")
	
			/**
			 * In-Game: "N% less healing from Medic sources"
			 * 
			 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
			 */
			val reducedHealingFromMedics: ItemAttributeNamed<Number> = ItemAttributeNamed("reduced_healing_from_medics")
	
			val healingReceived: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("healing received bonus"),
				ItemAttributeNamed("healing received penalty"),
			)
	
			/**
			 * In-Game: "Maximum health is drained while item is active"
			 * 
			 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
			 */
			val maxhealthDrainRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_maxhealth_drain_rate")
		}
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * Prevents mediguns from latching onto you.
		 */
		context(attrs: IAttributeContainer)
		open var weaponBlocksHealing: Boolean? 
			get() = HealthAndHealingAttributes.weaponBlocksHealing.get()
			set(value) { HealthAndHealingAttributes.weaponBlocksHealing.set(value) }
	
		context(attrs: IAttributeContainer)
		open var activeHealthDegen: Int? 
			get() = HealthAndHealingAttributes.activeHealthDegen.get()
			set(value) { HealthAndHealingAttributes.activeHealthDegen.set(value) }
	
		/**
		 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
		 * 
		 * Multiplier applied to your healer's ubercharge rate.
		 * 
		 * NOTE: Only applied if user is outside of the respawn room.
		 */
		context(attrs: IAttributeContainer)
		open var uberchargeRateBonusForHealer: Number? 
			get() = HealthAndHealingAttributes.uberchargeRateBonusForHealer.get()
			set(value) { HealthAndHealingAttributes.uberchargeRateBonusForHealer.set(value) }
	
		/**
		 * In-Game: "On Hit: Gain up to +N health per attack"
		 * 
		 * Maximum amount of health that can be gained from an AoE damage source.
		 * 
		 * Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
		 */
		context(attrs: IAttributeContainer)
		open var healthOnRadiusDamage: Int? 
			get() = HealthAndHealingAttributes.healthOnRadiusDamage.get()
			set(value) { HealthAndHealingAttributes.healthOnRadiusDamage.set(value) }
	
		/**
		 * In-Game: "N% health from healers on wearer"
		 * 
		 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
		 */
		context(attrs: IAttributeContainer)
		open var multHealthFromhealersPenaltyActive: Number? 
			get() = HealthAndHealingAttributes.multHealthFromhealersPenaltyActive.get()
			set(value) { HealthAndHealingAttributes.multHealthFromhealersPenaltyActive.set(value) }
	
		/**
		 * In-Game: "N% Overheal build rate."
		 * 
		 * Checked on the player that is healing an entity.
		 */
		context(attrs: IAttributeContainer)
		open var overhealFillRateReduced: Number? 
			get() = HealthAndHealingAttributes.overhealFillRateReduced.get()
			set(value) { HealthAndHealingAttributes.overhealFillRateReduced.set(value) }
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
		 */
		context(attrs: IAttributeContainer)
		open var reducedHealingFromMedics: Number? 
			get() = HealthAndHealingAttributes.reducedHealingFromMedics.get()
			set(value) { HealthAndHealingAttributes.reducedHealingFromMedics.set(value) }
	
		context(attrs: IAttributeContainer)
		open var healingReceived: Number? 
			get() = HealthAndHealingAttributes.healingReceived.get()
			set(value) { HealthAndHealingAttributes.healingReceived.set(value) }
	
		/**
		 * In-Game: "Maximum health is drained while item is active"
		 * 
		 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
		 */
		context(attrs: IAttributeContainer)
		open var maxhealthDrainRate: Number? 
			get() = HealthAndHealingAttributes.maxhealthDrainRate.get()
			set(value) { HealthAndHealingAttributes.maxhealthDrainRate.set(value) }
	}
	
	open class KnockbackReceivedAttributes : BaseCombatWeaponAttributes.KnockbackReceivedAttributes() {
		companion object : IBlockScoped {
			val selfDmgPushForce: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("self dmg push force increased"),
				ItemAttributeNamed("self dmg push force decreased"),
			)
	
			val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
		}
	
		context(attrs: IAttributeContainer)
		open var selfDmgPushForce: Number? 
			get() = KnockbackReceivedAttributes.selfDmgPushForce.get()
			set(value) { KnockbackReceivedAttributes.selfDmgPushForce.set(value) }
	
		open val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "N% reduction in push force taken from damage"
				 * 
				 * Attribute class is a flat multiplier applied to push force received from damage.
				 */
				val damageForceReduction: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force reduction")
	
				/**
				 * In-Game: "N% increase in push force taken from damage"
				 * 
				 * Attribute class is a flat multiplier applied to push force received from damage.
				 */
				val damageForceIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase")
	
				/**
				 * In-Game: "N% increase in push force taken from damage"
				 * 
				 * Attribute class is a flat multiplier applied to push force received from damage.
				 */
				val damageForceIncreaseHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase hidden")
	
				/**
				 * In-Game: "Increase in push force taken from damage and airblast"
				 * 
				 * Attribute class is a flat multiplier applied to push force received from damage.
				 */
				val damageForceIncreaseText: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase text")
			}
	
			/**
			 * In-Game: "N% reduction in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceReduction: Number? 
				get() = DamageForceReductionAttributes.damageForceReduction.get()
				set(value) { DamageForceReductionAttributes.damageForceReduction.set(value) }
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceIncrease: Number? 
				get() = DamageForceReductionAttributes.damageForceIncrease.get()
				set(value) { DamageForceReductionAttributes.damageForceIncrease.set(value) }
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceIncreaseHidden: Number? 
				get() = DamageForceReductionAttributes.damageForceIncreaseHidden.get()
				set(value) { DamageForceReductionAttributes.damageForceIncreaseHidden.set(value) }
	
			/**
			 * In-Game: "Increase in push force taken from damage and airblast"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			context(attrs: IAttributeContainer)
			open var damageForceIncreaseText: Number? 
				get() = DamageForceReductionAttributes.damageForceIncreaseText.get()
				set(value) { DamageForceReductionAttributes.damageForceIncreaseText.set(value) }
		}
	}
	
	open class MetaAttributes : BaseCombatWeaponAttributes.MetaAttributes() {
		companion object : IBlockScoped {
			/**
			 * What "Strange Part" kills with this weapon should contribute to.
			 */
			val killEaterKillType: ItemAttributeNamed<Int> = ItemAttributeNamed("kill eater kill type")
		}
	
		/**
		 * What "Strange Part" kills with this weapon should contribute to.
		 */
		context(attrs: IAttributeContainer)
		open var killEaterKillType: Int? 
			get() = MetaAttributes.killEaterKillType.get()
			set(value) { MetaAttributes.killEaterKillType.set(value) }
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseCombatWeaponAttributes.MetaAttributes.KillfeedAttributes() {
			companion object : IBlockScoped {
				val isGigerCounter: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is giger counter")
	
				/**
				 * Sets killfeed background gold.
				 */
				val isAustraliumItem: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is australium item")
	
				/**
				 * In-Game: "Imbued with an ancient power"
				 * 
				 * Sets killfeed background gold.
				 */
				val turnToGold: ItemAttributeNamed<Boolean> = ItemAttributeNamed("turn to gold")
	
				/**
				 * In-Game: "Silent Killer: No attack noise from backstabs"
				 * 
				 * Kills will not show up in the killfeed.
				 */
				val silentKiller: ItemAttributeNamed<Boolean> = ItemAttributeNamed("silent killer")
			}
	
			context(attrs: IAttributeContainer)
			open var isGigerCounter: Boolean? 
				get() = KillfeedAttributes.isGigerCounter.get()
				set(value) { KillfeedAttributes.isGigerCounter.set(value) }
	
			/**
			 * Sets killfeed background gold.
			 */
			context(attrs: IAttributeContainer)
			open var isAustraliumItem: Boolean? 
				get() = KillfeedAttributes.isAustraliumItem.get()
				set(value) { KillfeedAttributes.isAustraliumItem.set(value) }
	
			/**
			 * In-Game: "Imbued with an ancient power"
			 * 
			 * Sets killfeed background gold.
			 */
			context(attrs: IAttributeContainer)
			open var turnToGold: Boolean? 
				get() = KillfeedAttributes.turnToGold.get()
				set(value) { KillfeedAttributes.turnToGold.set(value) }
	
			/**
			 * In-Game: "Silent Killer: No attack noise from backstabs"
			 * 
			 * Kills will not show up in the killfeed.
			 */
			context(attrs: IAttributeContainer)
			open var silentKiller: Boolean? 
				get() = KillfeedAttributes.silentKiller.get()
				set(value) { KillfeedAttributes.silentKiller.set(value) }
		}
	
		open class ItemsAttributes : BaseCombatWeaponAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseCombatWeaponAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseCombatWeaponAttributes.MeterAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "+N% increase in recharge rate"
			 * 
			 * For things like throwable recharge timers, jetpack charging, etc: how much it recharges per second.
			 */
			val effectBarRechargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("effect bar recharge rate increased")
		}
	
		/**
		 * In-Game: "+N% increase in recharge rate"
		 * 
		 * For things like throwable recharge timers, jetpack charging, etc: how much it recharges per second.
		 */
		context(attrs: IAttributeContainer)
		open var effectBarRechargeRateIncreased: Number? 
			get() = MeterAttributes.effectBarRechargeRateIncreased.get()
			set(value) { MeterAttributes.effectBarRechargeRateIncreased.set(value) }
	}
	
	open class MovementAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "+N% greater jump height when active"
			 * 
			 * Only takes effect while this weapon is active.
			 */
			val increasedJumpHeightFromWeapon: ItemAttributeNamed<Number> = ItemAttributeNamed("increased jump height from weapon")
	
			/**
			 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
			 * 
			 * If greater than 0, attacks minicrit while airborne.
			 * 
			 * Only procs on Scout.
			 */
			val airDashCount: ItemAttributeNamed<Int> = ItemAttributeNamed("air dash count")
	
			val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
		}
	
		/**
		 * In-Game: "+N% greater jump height when active"
		 * 
		 * Only takes effect while this weapon is active.
		 */
		context(attrs: IAttributeContainer)
		open var increasedJumpHeightFromWeapon: Number? 
			get() = MovementAttributes.increasedJumpHeightFromWeapon.get()
			set(value) { MovementAttributes.increasedJumpHeightFromWeapon.set(value) }
	
		/**
		 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
		 * 
		 * If greater than 0, attacks minicrit while airborne.
		 * 
		 * Only procs on Scout.
		 */
		context(attrs: IAttributeContainer)
		open var airDashCount: Int? 
			get() = MovementAttributes.airDashCount.get()
			set(value) { MovementAttributes.airDashCount.set(value) }
	
		open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * Multiplier applied to movement speed scaled by ubercharge percentage.
				 * 
				 * Only works if the player using this item is a Medic with a Medigun.
				 */
				val moveSpeedBonusResourceLevel: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus resource level")
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 * 
				 * Multiplier applied to player movement speed only while this is the active weapon.
				 */
				val multPlayerMovespeedActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_player_movespeed_active")
			}
	
			/**
			 * Multiplier applied to movement speed scaled by ubercharge percentage.
			 * 
			 * Only works if the player using this item is a Medic with a Medigun.
			 */
			context(attrs: IAttributeContainer)
			open var moveSpeedBonusResourceLevel: Number? 
				get() = MoveSpeedAttributes.moveSpeedBonusResourceLevel.get()
				set(value) { MoveSpeedAttributes.moveSpeedBonusResourceLevel.set(value) }
	
			/**
			 * In-Game: "+N% faster move speed on wearer"
			 * 
			 * Multiplier applied to player movement speed only while this is the active weapon.
			 */
			context(attrs: IAttributeContainer)
			open var multPlayerMovespeedActive: Number? 
				get() = MoveSpeedAttributes.multPlayerMovespeedActive.get()
				set(value) { MoveSpeedAttributes.multPlayerMovespeedActive.set(value) }
		}
	}
	
	open class HeadsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	}
	
	open class OnHitAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "+N% cloak on hit"
			 * 
			 * Adds this amount of cloak on hit.
			 * 
			 * Only procs on Spy.
			 */
			val addCloakOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on hit")
	
			/**
			 * In-Game: "On Hit: damage dealt is returned as ammo"
			 * 
			 * Gain ammo equivalent to damage dealt on hit.
			 */
			val addOnhitAddammo: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add onhit addammo")
	
			/**
			 * In-Game: "On Hit Spy: Reveal cloaked Spy"
			 */
			val revealCloakedVictimOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal cloaked victim on hit")
	
			/**
			 * In-Game: "On Hit Spy: Reveal disguised Spy"
			 */
			val revealDisguisedVictimOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal disguised victim on hit")
	
			val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
			/**
			 * In-Game: "On Hit: Gain a speed boost"
			 * 
			 * Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`.
			 */
			val speedBoostOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_hit")
	
			/**
			 * In-Game: "On Hit: N% ÜberCharge added"
			 * 
			 * Only procs if on a Medic.
			 */
			val addUberChargeOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("add uber charge on hit")
	
			val rageOnHit: BonusPenalty<Int> = BonusPenalty(
				ItemAttributeNamed("mod rage on hit bonus"),
				ItemAttributeNamed("mod rage on hit penalty"),
			)
	
			/**
			 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
			 * 
			 * Gain Scout's "hype" meter on hit.
			 * 
			 * This exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
			 */
			val boostOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boost on damage")
	
			val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
			/**
			 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
			 */
			val markForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mark for death")
	
			/**
			 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
			 * 
			 * Stun airborne targets.
			 */
			val stunWaistHighAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod stun waist high airborne")
	
			/**
			 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
			 * 
			 * Percentage as an int, e.g. `25` = 25% = 0.25.
			 * 
			 * Drain scaled over distance.
			 */
			val subtractVictimMedigunChargeOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim medigun charge on hit")
	
			/**
			 * In-Game: "On Hit: Victim loses up to N% cloak"
			 * 
			 * Subtracts an actual value.
			 * 
			 * Drain still scaled over distance.
			 */
			val subtractVictimCloakOnHit: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim cloak on hit")
	
			/**
			 * In-Game: "On Hit: N% chance to slow target"
			 * 
			 * Gain speedboost on hit.
			 */
			val slowEnemyOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit")
	
			/**
			 * In-Game: "On Hit: Slow target movement by 40% for Ns"
			 * 
			 * Gain speedboost for N seconds.
			 */
			val slowEnemyOnHitMajor: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit major")
	
			/**
			 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
			 * 
			 * Applies Mad Milk with a duration of 4 seconds, and each subsequent hit on the same target adds 0.5 seconds to the duration.
			 */
			val madMilkSyringes: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mad milk syringes")
	
			/**
			 * In-Game: "Stuns enemies who are also wielding this weapon"
			 */
			val stunEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("stun enemies wielding same weapon")
	
			/**
			 * In-Game: "All players connected via Medigun beams are hit"
			 * 
			 * Damage all players connected to the target by medigun beams.
			 */
			val damageAllConnected: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage all connected")
	
			/**
			 * Apply this amount of z velocity to players hit with this weapon.
			 */
			val applyZVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply z velocity on damage")
	
			/**
			 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
			 */
			val applyLookVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply look velocity on damage")
	
			/**
			 * Push force applied to target when hitting an enemy.
			 * 
			 * Scales by range, to a minimum of 50% of the given value.
			 */
			val damageBlastPush: ItemAttributeNamed<Number> = ItemAttributeNamed("damage blast push")
	
			/**
			 * In-Game: "On Hit: Bleed for N seconds"
			 * 
			 * Apply bleed on hit.
			 * 
			 * Value is a time in seconds.
			 */
			val bleedingDuration: ItemAttributeNamed<Number> = ItemAttributeNamed("bleeding duration")
		}
	
		/**
		 * In-Game: "+N% cloak on hit"
		 * 
		 * Adds this amount of cloak on hit.
		 * 
		 * Only procs on Spy.
		 */
		context(attrs: IAttributeContainer)
		open var addCloakOnHit: Int? 
			get() = OnHitAttributes.addCloakOnHit.get()
			set(value) { OnHitAttributes.addCloakOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: damage dealt is returned as ammo"
		 * 
		 * Gain ammo equivalent to damage dealt on hit.
		 */
		context(attrs: IAttributeContainer)
		open var addOnhitAddammo: Boolean? 
			get() = OnHitAttributes.addOnhitAddammo.get()
			set(value) { OnHitAttributes.addOnhitAddammo.set(value) }
	
		/**
		 * In-Game: "On Hit Spy: Reveal cloaked Spy"
		 */
		context(attrs: IAttributeContainer)
		open var revealCloakedVictimOnHit: Boolean? 
			get() = OnHitAttributes.revealCloakedVictimOnHit.get()
			set(value) { OnHitAttributes.revealCloakedVictimOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit Spy: Reveal disguised Spy"
		 */
		context(attrs: IAttributeContainer)
		open var revealDisguisedVictimOnHit: Boolean? 
			get() = OnHitAttributes.revealDisguisedVictimOnHit.get()
			set(value) { OnHitAttributes.revealDisguisedVictimOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Gain a speed boost"
		 * 
		 * Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`.
		 */
		context(attrs: IAttributeContainer)
		open var speedBoostOnHit: Int? 
			get() = OnHitAttributes.speedBoostOnHit.get()
			set(value) { OnHitAttributes.speedBoostOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: N% ÜberCharge added"
		 * 
		 * Only procs if on a Medic.
		 */
		context(attrs: IAttributeContainer)
		open var addUberChargeOnHit: Number? 
			get() = OnHitAttributes.addUberChargeOnHit.get()
			set(value) { OnHitAttributes.addUberChargeOnHit.set(value) }
	
		context(attrs: IAttributeContainer)
		open var rageOnHit: Int? 
			get() = OnHitAttributes.rageOnHit.get()
			set(value) { OnHitAttributes.rageOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
		 * 
		 * Gain Scout's "hype" meter on hit.
		 * 
		 * This exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
		 */
		context(attrs: IAttributeContainer)
		open var boostOnDamage: Boolean? 
			get() = OnHitAttributes.boostOnDamage.get()
			set(value) { OnHitAttributes.boostOnDamage.set(value) }
	
		/**
		 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
		 */
		context(attrs: IAttributeContainer)
		open var markForDeath: Boolean? 
			get() = OnHitAttributes.markForDeath.get()
			set(value) { OnHitAttributes.markForDeath.set(value) }
	
		/**
		 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
		 * 
		 * Stun airborne targets.
		 */
		context(attrs: IAttributeContainer)
		open var stunWaistHighAirborne: Boolean? 
			get() = OnHitAttributes.stunWaistHighAirborne.get()
			set(value) { OnHitAttributes.stunWaistHighAirborne.set(value) }
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
		 * 
		 * Percentage as an int, e.g. `25` = 25% = 0.25.
		 * 
		 * Drain scaled over distance.
		 */
		context(attrs: IAttributeContainer)
		open var subtractVictimMedigunChargeOnHit: Int? 
			get() = OnHitAttributes.subtractVictimMedigunChargeOnHit.get()
			set(value) { OnHitAttributes.subtractVictimMedigunChargeOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% cloak"
		 * 
		 * Subtracts an actual value.
		 * 
		 * Drain still scaled over distance.
		 */
		context(attrs: IAttributeContainer)
		open var subtractVictimCloakOnHit: Int? 
			get() = OnHitAttributes.subtractVictimCloakOnHit.get()
			set(value) { OnHitAttributes.subtractVictimCloakOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: N% chance to slow target"
		 * 
		 * Gain speedboost on hit.
		 */
		context(attrs: IAttributeContainer)
		open var slowEnemyOnHit: Number? 
			get() = OnHitAttributes.slowEnemyOnHit.get()
			set(value) { OnHitAttributes.slowEnemyOnHit.set(value) }
	
		/**
		 * In-Game: "On Hit: Slow target movement by 40% for Ns"
		 * 
		 * Gain speedboost for N seconds.
		 */
		context(attrs: IAttributeContainer)
		open var slowEnemyOnHitMajor: Number? 
			get() = OnHitAttributes.slowEnemyOnHitMajor.get()
			set(value) { OnHitAttributes.slowEnemyOnHitMajor.set(value) }
	
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 * 
		 * Applies Mad Milk with a duration of 4 seconds, and each subsequent hit on the same target adds 0.5 seconds to the duration.
		 */
		context(attrs: IAttributeContainer)
		open var madMilkSyringes: Boolean? 
			get() = OnHitAttributes.madMilkSyringes.get()
			set(value) { OnHitAttributes.madMilkSyringes.set(value) }
	
		/**
		 * In-Game: "Stuns enemies who are also wielding this weapon"
		 */
		context(attrs: IAttributeContainer)
		open var stunEnemiesWieldingSameWeapon: Boolean? 
			get() = OnHitAttributes.stunEnemiesWieldingSameWeapon.get()
			set(value) { OnHitAttributes.stunEnemiesWieldingSameWeapon.set(value) }
	
		/**
		 * In-Game: "All players connected via Medigun beams are hit"
		 * 
		 * Damage all players connected to the target by medigun beams.
		 */
		context(attrs: IAttributeContainer)
		open var damageAllConnected: Boolean? 
			get() = OnHitAttributes.damageAllConnected.get()
			set(value) { OnHitAttributes.damageAllConnected.set(value) }
	
		/**
		 * Apply this amount of z velocity to players hit with this weapon.
		 */
		context(attrs: IAttributeContainer)
		open var applyZVelocityOnDamage: Number? 
			get() = OnHitAttributes.applyZVelocityOnDamage.get()
			set(value) { OnHitAttributes.applyZVelocityOnDamage.set(value) }
	
		/**
		 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
		 */
		context(attrs: IAttributeContainer)
		open var applyLookVelocityOnDamage: Number? 
			get() = OnHitAttributes.applyLookVelocityOnDamage.get()
			set(value) { OnHitAttributes.applyLookVelocityOnDamage.set(value) }
	
		/**
		 * Push force applied to target when hitting an enemy.
		 * 
		 * Scales by range, to a minimum of 50% of the given value.
		 */
		context(attrs: IAttributeContainer)
		open var damageBlastPush: Number? 
			get() = OnHitAttributes.damageBlastPush.get()
			set(value) { OnHitAttributes.damageBlastPush.set(value) }
	
		/**
		 * In-Game: "On Hit: Bleed for N seconds"
		 * 
		 * Apply bleed on hit.
		 * 
		 * Value is a time in seconds.
		 */
		context(attrs: IAttributeContainer)
		open var bleedingDuration: Number? 
			get() = OnHitAttributes.bleedingDuration.get()
			set(value) { OnHitAttributes.bleedingDuration.set(value) }
	
		open val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "On Hit: Gain up to +N health"
				 * 
				 * Add this amount of health on hit.
				 */
				val healOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for rapidfire")
	
				/**
				 * In-Game: "On Hit: N health"
				 * 
				 * Add this amount of health on hit.
				 */
				val selfdmgOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for rapidfire")
	
				/**
				 * In-Game: "On Hit: Gain up to +N health"
				 * 
				 * Add this amount of health on hit.
				 */
				val healOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for slowfire")
	
				/**
				 * In-Game: "On Hit: N health"
				 * 
				 * Add this amount of health on hit.
				 */
				val selfdmgOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for slowfire")
			}
	
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var healOnHitForRapidfire: Int? 
				get() = HealOnHitForRapidfireAttributes.healOnHitForRapidfire.get()
				set(value) { HealOnHitForRapidfireAttributes.healOnHitForRapidfire.set(value) }
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var selfdmgOnHitForRapidfire: Int? 
				get() = HealOnHitForRapidfireAttributes.selfdmgOnHitForRapidfire.get()
				set(value) { HealOnHitForRapidfireAttributes.selfdmgOnHitForRapidfire.set(value) }
	
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var healOnHitForSlowfire: Int? 
				get() = HealOnHitForRapidfireAttributes.healOnHitForSlowfire.get()
				set(value) { HealOnHitForRapidfireAttributes.healOnHitForSlowfire.set(value) }
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			context(attrs: IAttributeContainer)
			open var selfdmgOnHitForSlowfire: Int? 
				get() = HealOnHitForRapidfireAttributes.selfdmgOnHitForSlowfire.get()
				set(value) { HealOnHitForRapidfireAttributes.selfdmgOnHitForSlowfire.set(value) }
		}
	
		open class GenerateRageOnDamageAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
				 * 
				 * Knockback rage on enemy if you're a heavy and your rage is draining.
				 */
				val generateRageOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
				/**
				 * In-Game: "Generate building rescue energy on damage"
				 * 
				 * Knockback rage on enemy if you're a heavy and your rage is draining.
				 */
				val engineerRageOnDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
			}
	
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			context(attrs: IAttributeContainer)
			open var generateRageOnDamage: Boolean? 
				get() = GenerateRageOnDamageAttributes.generateRageOnDamage.get()
				set(value) { GenerateRageOnDamageAttributes.generateRageOnDamage.set(value) }
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			context(attrs: IAttributeContainer)
			open var engineerRageOnDmg: Boolean? 
				get() = GenerateRageOnDamageAttributes.engineerRageOnDmg.get()
				set(value) { GenerateRageOnDamageAttributes.engineerRageOnDmg.set(value) }
		}
	}
	
	open class OnKillAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "On Kill: N seconds of 100% critical chance"
			 * 
			 * Seconds of crit-boost gained on kill.
			 * 
			 * Note: actual time is `this + 1`.
			 */
			val critboostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("critboost on kill")
	
			/**
			 * In-Game: "On Kill: Gain Mini-crits for N seconds."
			 * 
			 * Seconds of minicrit-boost gained on kill.
			 * 
			 * Note: actual time is `this + 1`.
			 */
			val minicritboostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("minicritboost on kill")
	
			/**
			 * In-Game: "On Kill: Gain N% of base health on kill"
			 * 
			 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
			 * 
			 * Post-heal player health value is capped at 1.5x the player's normal max health.
			 * 
			 * Negative values are ignored.
			 */
			val restoreHealthOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("restore health on kill")
	
			/**
			 * In-Game: "+N health restored on kill"
			 * 
			 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
			 * 
			 * Negative values are NOT ignored.
			 */
			val healOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on kill")
	
			/**
			 * In-Game: "Gain a speed boost on kill"
			 */
			val speedBoostOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_kill")
	
			/**
			 * In-Game: "Exorcism"
			 * 
			 * Exorcism spell effect.
			 */
			val spellHalloweenDeathGhosts: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween death ghosts")
		}
	
		/**
		 * In-Game: "On Kill: N seconds of 100% critical chance"
		 * 
		 * Seconds of crit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		context(attrs: IAttributeContainer)
		open var critboostOnKill: Int? 
			get() = OnKillAttributes.critboostOnKill.get()
			set(value) { OnKillAttributes.critboostOnKill.set(value) }
	
		/**
		 * In-Game: "On Kill: Gain Mini-crits for N seconds."
		 * 
		 * Seconds of minicrit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		context(attrs: IAttributeContainer)
		open var minicritboostOnKill: Int? 
			get() = OnKillAttributes.minicritboostOnKill.get()
			set(value) { OnKillAttributes.minicritboostOnKill.set(value) }
	
		/**
		 * In-Game: "On Kill: Gain N% of base health on kill"
		 * 
		 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
		 * 
		 * Post-heal player health value is capped at 1.5x the player's normal max health.
		 * 
		 * Negative values are ignored.
		 */
		context(attrs: IAttributeContainer)
		open var restoreHealthOnKill: Int? 
			get() = OnKillAttributes.restoreHealthOnKill.get()
			set(value) { OnKillAttributes.restoreHealthOnKill.set(value) }
	
		/**
		 * In-Game: "+N health restored on kill"
		 * 
		 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
		 * 
		 * Negative values are NOT ignored.
		 */
		context(attrs: IAttributeContainer)
		open var healOnKill: Int? 
			get() = OnKillAttributes.healOnKill.get()
			set(value) { OnKillAttributes.healOnKill.set(value) }
	
		/**
		 * In-Game: "Gain a speed boost on kill"
		 */
		context(attrs: IAttributeContainer)
		open var speedBoostOnKill: Int? 
			get() = OnKillAttributes.speedBoostOnKill.get()
			set(value) { OnKillAttributes.speedBoostOnKill.set(value) }
	
		/**
		 * In-Game: "Exorcism"
		 * 
		 * Exorcism spell effect.
		 */
		context(attrs: IAttributeContainer)
		open var spellHalloweenDeathGhosts: Boolean? 
			get() = OnKillAttributes.spellHalloweenDeathGhosts.get()
			set(value) { OnKillAttributes.spellHalloweenDeathGhosts.set(value) }
	}
	
	open class ProjectilesAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
			/**
			 * Note: "Projectile" includes bullets.
			 */
			val centerfireProjectile: ItemAttributeNamed<Boolean> = ItemAttributeNamed("centerfire projectile")
	
			/**
			 * In-Game: "+N degrees random projectile deviation"
			 * 
			 * Does not include bullets.
			 */
			val projectileSpreadAnglePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("projectile spread angle penalty")
	
			val bullets: BulletsAttributes = BulletsAttributes()
		}
	
		/**
		 * Note: "Projectile" includes bullets.
		 */
		context(attrs: IAttributeContainer)
		open var centerfireProjectile: Boolean? 
			get() = ProjectilesAttributes.centerfireProjectile.get()
			set(value) { ProjectilesAttributes.centerfireProjectile.set(value) }
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Does not include bullets.
		 */
		context(attrs: IAttributeContainer)
		open var projectileSpreadAnglePenalty: Number? 
			get() = ProjectilesAttributes.projectileSpreadAnglePenalty.get()
			set(value) { ProjectilesAttributes.projectileSpreadAnglePenalty.set(value) }
	
		open val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "Projectiles penetrate enemy players"
				 * 
				 * How many players your "projectile" (*including bullets*) should penetrate.
				 */
				val projectilePenetration: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration")
	
				/**
				 * In-Game: "Bullets penetrate +N enemies"
				 * 
				 * How many players your "projectile" (*including bullets*) should penetrate.
				 */
				val projectilePenetrationHeavy: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration heavy")
			}
	
			/**
			 * In-Game: "Projectiles penetrate enemy players"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			context(attrs: IAttributeContainer)
			open var projectilePenetration: Int? 
				get() = ProjectilePenetrationAttributes.projectilePenetration.get()
				set(value) { ProjectilePenetrationAttributes.projectilePenetration.set(value) }
	
			/**
			 * In-Game: "Bullets penetrate +N enemies"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			context(attrs: IAttributeContainer)
			open var projectilePenetrationHeavy: Int? 
				get() = ProjectilePenetrationAttributes.projectilePenetrationHeavy.get()
				set(value) { ProjectilePenetrationAttributes.projectilePenetrationHeavy.set(value) }
		}
	
		open class BulletsAttributes : IBlockScoped {
			companion object : IBlockScoped {
				/**
				 * In-Game: "+N% bullets per shot"
				 */
				val bulletsPerShotBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("bullets per shot bonus")
	
				/**
				 * In-Game: "Fires tracer rounds"
				 * 
				 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
				 * 
				 * Used when firing bullets.
				 */
				val sniperFiresTracer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer")
	
				/**
				 * In-Game: "Fires tracer rounds"
				 * 
				 * Same as `sniper_fires_tracer`.
				 */
				val sniperFiresTracerHidden: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer HIDDEN")
	
				/**
				 * In-Game: "On Full Charge: Projectiles penetrate players"
				 */
				val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper penetrate players when charged")
	
				/**
				 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
				 * 
				 * Only applies if in a gamemode with upgrades, but applies to all headshots.
				 * 
				 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
				 */
				val explosiveHeadshotLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("explosive sniper shot")
			}
	
			/**
			 * In-Game: "+N% bullets per shot"
			 */
			context(attrs: IAttributeContainer)
			open var bulletsPerShotBonus: Number? 
				get() = BulletsAttributes.bulletsPerShotBonus.get()
				set(value) { BulletsAttributes.bulletsPerShotBonus.set(value) }
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
			 * 
			 * Used when firing bullets.
			 */
			context(attrs: IAttributeContainer)
			open var sniperFiresTracer: Boolean? 
				get() = BulletsAttributes.sniperFiresTracer.get()
				set(value) { BulletsAttributes.sniperFiresTracer.set(value) }
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Same as `sniper_fires_tracer`.
			 */
			context(attrs: IAttributeContainer)
			open var sniperFiresTracerHidden: Boolean? 
				get() = BulletsAttributes.sniperFiresTracerHidden.get()
				set(value) { BulletsAttributes.sniperFiresTracerHidden.set(value) }
	
			/**
			 * In-Game: "On Full Charge: Projectiles penetrate players"
			 */
			context(attrs: IAttributeContainer)
			open var penetratesWhenFullyCharged: Boolean? 
				get() = BulletsAttributes.penetratesWhenFullyCharged.get()
				set(value) { BulletsAttributes.penetratesWhenFullyCharged.set(value) }
	
			/**
			 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
			 * 
			 * Only applies if in a gamemode with upgrades, but applies to all headshots.
			 * 
			 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
			 */
			context(attrs: IAttributeContainer)
			open var explosiveHeadshotLevel: Int? 
				get() = BulletsAttributes.explosiveHeadshotLevel.get()
				set(value) { BulletsAttributes.explosiveHeadshotLevel.set(value) }
		}
	}
	
	open class ReloadingAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val reloadTime: BonusPenalty<Number> = BonusPenalty(
				ItemAttributeNamed("Reload time decreased"),
				ItemAttributeNamed("Reload time increased"),
			)
	
			/**
			 * In-Game: "N% slower reload time"
			 */
			val reloadTimeIncreasedHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time increased hidden")
	
			/**
			 * In-Game: "+N% faster reload time"
			 * 
			 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
			 */
			val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
			/**
			 * Halloween reload time multiplier.
			 * 
			 * Checked on player.
			 */
			val halloweenReloadTimeDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween reload time decreased")
	
			/**
			 * In-Game: "N% faster reload time while being healed"
			 */
			val reloadTimeDecreasedWhileHealed: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time decreased while healed")
		}
	
		context(attrs: IAttributeContainer)
		open var reloadTime: Number? 
			get() = ReloadingAttributes.reloadTime.get()
			set(value) { ReloadingAttributes.reloadTime.set(value) }
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		context(attrs: IAttributeContainer)
		open var reloadTimeIncreasedHidden: Number? 
			get() = ReloadingAttributes.reloadTimeIncreasedHidden.get()
			set(value) { ReloadingAttributes.reloadTimeIncreasedHidden.set(value) }
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
		 */
		context(attrs: IAttributeContainer)
		open var fasterReloadRate: Number? 
			get() = ReloadingAttributes.fasterReloadRate.get()
			set(value) { ReloadingAttributes.fasterReloadRate.set(value) }
	
		/**
		 * Halloween reload time multiplier.
		 * 
		 * Checked on player.
		 */
		context(attrs: IAttributeContainer)
		open var halloweenReloadTimeDecreased: Number? 
			get() = ReloadingAttributes.halloweenReloadTimeDecreased.get()
			set(value) { ReloadingAttributes.halloweenReloadTimeDecreased.set(value) }
	
		/**
		 * In-Game: "N% faster reload time while being healed"
		 */
		context(attrs: IAttributeContainer)
		open var reloadTimeDecreasedWhileHealed: Number? 
			get() = ReloadingAttributes.reloadTimeDecreasedWhileHealed.get()
			set(value) { ReloadingAttributes.reloadTimeDecreasedWhileHealed.set(value) }
	}
	
	open class ResistanceAttributes : BaseCombatWeaponAttributes.ResistanceAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
			 * 
			 * Addcond parameter.
			 */
			val becomeFireproofOnHitByFire: ItemAttributeNamed<Number> = ItemAttributeNamed("become fireproof on hit by fire")
	
			/**
			 * In-Game: "N% damage vulnerability on wearer"
			 */
			val multDmgtakenActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_dmgtaken_active")
	
			/**
			 * In-Game: "+N% damage from melee sources while active"
			 * 
			 * Multiplier applied to incoming melee damage.
			 */
			val dmgFromMeleeIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from melee increased")
	
			/**
			 * In-Game: "N% damage from ranged sources while active"
			 * 
			 * Multiplier applied to incoming blast, bullet, buckshot, ignite, and sonic damage.
			 */
			val dmgFromRangedReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from ranged reduced")
	
			/**
			 * In-Game: "No self inflicted blast damage taken"
			 * 
			 * Also forces the "whistling" sound to play when rocket jumping.
			 */
			val noSelfBlastDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no self blast dmg")
	
			/**
			 * In-Game: "+N% damage to self"
			 * 
			 * Multiplier applied to blast damage taken from an explosion caused by said entity.
			 */
			val blastDmgToSelfIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("blast dmg to self increased")
	
			/**
			 * In-Game: "+N% fire damage resistance while deployed"
			 * 
			 * Resist this proportion of fire damage only while this weapon is active.
			 */
			val dmgTakenFromFireReducedOnActive: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire reduced on active")
	
			/**
			 * In-Game: "+N% damage vulnerability while active"
			 * 
			 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
			 */
			val energyBuffDmgTakenMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("energy buff dmg taken multiplier")
	
			/**
			 * In-Game: "The wearer cannot be killed by headshots"
			 * 
			 * When a headshot would kill you, reduce health to 1.
			 */
			val setBonusNoDeathFromHeadshots: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: no death from headshots")
		}
	
		/**
		 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
		 * 
		 * Addcond parameter.
		 */
		context(attrs: IAttributeContainer)
		open var becomeFireproofOnHitByFire: Number? 
			get() = ResistanceAttributes.becomeFireproofOnHitByFire.get()
			set(value) { ResistanceAttributes.becomeFireproofOnHitByFire.set(value) }
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var multDmgtakenActive: Number? 
			get() = ResistanceAttributes.multDmgtakenActive.get()
			set(value) { ResistanceAttributes.multDmgtakenActive.set(value) }
	
		/**
		 * In-Game: "+N% damage from melee sources while active"
		 * 
		 * Multiplier applied to incoming melee damage.
		 */
		context(attrs: IAttributeContainer)
		open var dmgFromMeleeIncreased: Number? 
			get() = ResistanceAttributes.dmgFromMeleeIncreased.get()
			set(value) { ResistanceAttributes.dmgFromMeleeIncreased.set(value) }
	
		/**
		 * In-Game: "N% damage from ranged sources while active"
		 * 
		 * Multiplier applied to incoming blast, bullet, buckshot, ignite, and sonic damage.
		 */
		context(attrs: IAttributeContainer)
		open var dmgFromRangedReduced: Number? 
			get() = ResistanceAttributes.dmgFromRangedReduced.get()
			set(value) { ResistanceAttributes.dmgFromRangedReduced.set(value) }
	
		/**
		 * In-Game: "No self inflicted blast damage taken"
		 * 
		 * Also forces the "whistling" sound to play when rocket jumping.
		 */
		context(attrs: IAttributeContainer)
		open var noSelfBlastDmg: Boolean? 
			get() = ResistanceAttributes.noSelfBlastDmg.get()
			set(value) { ResistanceAttributes.noSelfBlastDmg.set(value) }
	
		/**
		 * In-Game: "+N% damage to self"
		 * 
		 * Multiplier applied to blast damage taken from an explosion caused by said entity.
		 */
		context(attrs: IAttributeContainer)
		open var blastDmgToSelfIncreased: Number? 
			get() = ResistanceAttributes.blastDmgToSelfIncreased.get()
			set(value) { ResistanceAttributes.blastDmgToSelfIncreased.set(value) }
	
		/**
		 * In-Game: "+N% fire damage resistance while deployed"
		 * 
		 * Resist this proportion of fire damage only while this weapon is active.
		 */
		context(attrs: IAttributeContainer)
		open var dmgTakenFromFireReducedOnActive: Number? 
			get() = ResistanceAttributes.dmgTakenFromFireReducedOnActive.get()
			set(value) { ResistanceAttributes.dmgTakenFromFireReducedOnActive.set(value) }
	
		/**
		 * In-Game: "+N% damage vulnerability while active"
		 * 
		 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
		 */
		context(attrs: IAttributeContainer)
		open var energyBuffDmgTakenMultiplier: Number? 
			get() = ResistanceAttributes.energyBuffDmgTakenMultiplier.get()
			set(value) { ResistanceAttributes.energyBuffDmgTakenMultiplier.set(value) }
	
		/**
		 * In-Game: "The wearer cannot be killed by headshots"
		 * 
		 * When a headshot would kill you, reduce health to 1.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusNoDeathFromHeadshots: Boolean? 
			get() = ResistanceAttributes.setBonusNoDeathFromHeadshots.get()
			set(value) { ResistanceAttributes.setBonusNoDeathFromHeadshots.set(value) }
	}
	
	open class RevengeCritsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
			 * 
			 * Weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` is set.
			 */
			val sapperKillsCollectCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sapper kills collect crits")
	
			/**
			 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
			 * 
			 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` is set.
			 */
			val extinguishEarnsRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("extinguish earns revenge crits")
	
			/**
			 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
			 * 
			 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `extinguish_revenge` is set.
			 */
			val canGainRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod sentry killed revenge")
		}
	
		/**
		 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
		 * 
		 * Weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` is set.
		 */
		context(attrs: IAttributeContainer)
		open var sapperKillsCollectCrits: Boolean? 
			get() = RevengeCritsAttributes.sapperKillsCollectCrits.get()
			set(value) { RevengeCritsAttributes.sapperKillsCollectCrits.set(value) }
	
		/**
		 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` is set.
		 */
		context(attrs: IAttributeContainer)
		open var extinguishEarnsRevengeCrits: Boolean? 
			get() = RevengeCritsAttributes.extinguishEarnsRevengeCrits.get()
			set(value) { RevengeCritsAttributes.extinguishEarnsRevengeCrits.set(value) }
	
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `extinguish_revenge` is set.
		 */
		context(attrs: IAttributeContainer)
		open var canGainRevengeCrits: Boolean? 
			get() = RevengeCritsAttributes.canGainRevengeCrits.get()
			set(value) { RevengeCritsAttributes.canGainRevengeCrits.set(value) }
	}
	
	open class StatusEffectsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Ignited enemies explode"
			 * 
			 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.	This attribute does not specifically check for the Gas Passer.	For example, if a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
			 * 
			 * Only the afterburn specifically checks for the Gas Passer.
			 */
			val explodeOnIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("explode_on_ignite")
		}
	
		/**
		 * In-Game: "Ignited enemies explode"
		 * 
		 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.	This attribute does not specifically check for the Gas Passer.	For example, if a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
		 * 
		 * Only the afterburn specifically checks for the Gas Passer.
		 */
		context(attrs: IAttributeContainer)
		open var explodeOnIgnite: Boolean? 
			get() = StatusEffectsAttributes.explodeOnIgnite.get()
			set(value) { StatusEffectsAttributes.explodeOnIgnite.set(value) }
	}
	
	open class TauntingAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
			 * 
			 * Makes default weapon taunt perform the Amputator radial healing effect.
			 */
			val enablesAoeHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("enables aoe heal")
	
			/**
			 * If true, prevents holiday taunts from being used.
			 */
			val specialTaunt: ItemAttributeNamed<Boolean> = ItemAttributeNamed("special taunt")
		}
	
		/**
		 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
		 * 
		 * Makes default weapon taunt perform the Amputator radial healing effect.
		 */
		context(attrs: IAttributeContainer)
		open var enablesAoeHeal: Boolean? 
			get() = TauntingAttributes.enablesAoeHeal.get()
			set(value) { TauntingAttributes.enablesAoeHeal.set(value) }
	
		/**
		 * If true, prevents holiday taunts from being used.
		 */
		context(attrs: IAttributeContainer)
		open var specialTaunt: Boolean? 
			get() = TauntingAttributes.specialTaunt.get()
			set(value) { TauntingAttributes.specialTaunt.set(value) }
	}
	
	open class ViewmodelAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val weaponAllowInspect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("weapon_allow_inspect")
	
			val weaponStattrakModuleScale: ItemAttributeNamed<Number> = ItemAttributeNamed("weapon_stattrak_module_scale")
	
			val minViewmodelOffset: ItemAttributeNamed<String> = ItemAttributeNamed("min_viewmodel_offset")
		}
	
		context(attrs: IAttributeContainer)
		open var weaponAllowInspect: Boolean? 
			get() = ViewmodelAttributes.weaponAllowInspect.get()
			set(value) { ViewmodelAttributes.weaponAllowInspect.set(value) }
	
		context(attrs: IAttributeContainer)
		open var weaponStattrakModuleScale: Number? 
			get() = ViewmodelAttributes.weaponStattrakModuleScale.get()
			set(value) { ViewmodelAttributes.weaponStattrakModuleScale.set(value) }
	
		context(attrs: IAttributeContainer)
		open var minViewmodelOffset: String? 
			get() = ViewmodelAttributes.minViewmodelOffset.get()
			set(value) { ViewmodelAttributes.minViewmodelOffset.set(value) }
	}
	
	open class SwapWeaponsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "When weapon is active:"
			 * 
			 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
			 * 
			 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
			 */
			val provideOnActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("provide on active")
	
			/**
			 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
			 * 
			 * Multiplier applied if NOT being healed by a medic.
			 * 
			 * Checked on player.
			 */
			val medicHealedDeployTimePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("mod medic healed deploy time penalty")
	
			/**
			 * Should force switch to this item when your current weapon is unavailable?.
			 */
			val forceWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("force weapon switch")
	
			/**
			 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
			 * 
			 * Takes 50 health when holstering before it gets a kill.
			 */
			val honorbound: ItemAttributeNamed<Boolean> = ItemAttributeNamed("honorbound")
	
			/**
			 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
			 */
			val holsterAnimTime: ItemAttributeNamed<Number> = ItemAttributeNamed("holster_anim_time")
	
			val deploy: DeployAttributes = DeployAttributes()
		}
	
		/**
		 * In-Game: "When weapon is active:"
		 * 
		 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
		 * 
		 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
		 */
		context(attrs: IAttributeContainer)
		open var provideOnActive: Boolean? 
			get() = SwapWeaponsAttributes.provideOnActive.get()
			set(value) { SwapWeaponsAttributes.provideOnActive.set(value) }
	
		/**
		 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
		 * 
		 * Multiplier applied if NOT being healed by a medic.
		 * 
		 * Checked on player.
		 */
		context(attrs: IAttributeContainer)
		open var medicHealedDeployTimePenalty: Number? 
			get() = SwapWeaponsAttributes.medicHealedDeployTimePenalty.get()
			set(value) { SwapWeaponsAttributes.medicHealedDeployTimePenalty.set(value) }
	
		/**
		 * Should force switch to this item when your current weapon is unavailable?.
		 */
		context(attrs: IAttributeContainer)
		open var forceWeaponSwitch: Boolean? 
			get() = SwapWeaponsAttributes.forceWeaponSwitch.get()
			set(value) { SwapWeaponsAttributes.forceWeaponSwitch.set(value) }
	
		/**
		 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
		 * 
		 * Takes 50 health when holstering before it gets a kill.
		 */
		context(attrs: IAttributeContainer)
		open var honorbound: Boolean? 
			get() = SwapWeaponsAttributes.honorbound.get()
			set(value) { SwapWeaponsAttributes.honorbound.set(value) }
	
		/**
		 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
		 */
		context(attrs: IAttributeContainer)
		open var holsterAnimTime: Number? 
			get() = SwapWeaponsAttributes.holsterAnimTime.get()
			set(value) { SwapWeaponsAttributes.holsterAnimTime.set(value) }
	
		open val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : IBlockScoped {
			companion object : IBlockScoped {
				val deployTime: BonusPenalty<Number> = BonusPenalty(
					ItemAttributeNamed("deploy time decreased"),
					ItemAttributeNamed("deploy time increased"),
				)
	
				val singleWepDeployTime: BonusPenalty<Number> = BonusPenalty(
					ItemAttributeNamed("single wep deploy time decreased"),
					ItemAttributeNamed("single wep deploy time increased"),
				)
	
				val singleWepHolsterTime: BonusPenalty<Number> = BonusPenalty(
					ItemAttributeNamed("switch from wep deploy time decreased"),
					ItemAttributeNamed("single wep holster time increased"),
				)
			}
	
			context(attrs: IAttributeContainer)
			open var deployTime: Number? 
				get() = DeployAttributes.deployTime.get()
				set(value) { DeployAttributes.deployTime.set(value) }
	
			context(attrs: IAttributeContainer)
			open var singleWepDeployTime: Number? 
				get() = DeployAttributes.singleWepDeployTime.get()
				set(value) { DeployAttributes.singleWepDeployTime.set(value) }
	
			context(attrs: IAttributeContainer)
			open var singleWepHolsterTime: Number? 
				get() = DeployAttributes.singleWepHolsterTime.get()
				set(value) { DeployAttributes.singleWepHolsterTime.set(value) }
		}
	}
	
	open class WhenHitAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * Knocks back attacker when wielder receives damage.
			 */
			val damageCausesAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage causes airblast")
		}
	
		/**
		 * Knocks back attacker when wielder receives damage.
		 */
		context(attrs: IAttributeContainer)
		open var damageCausesAirblast: Boolean? 
			get() = WhenHitAttributes.damageCausesAirblast.get()
			set(value) { WhenHitAttributes.damageCausesAirblast.set(value) }
	}
	
	open class RagdollsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
			 */
			val critKillWillGib: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit kill will gib")
	
			/**
			 * If false, this weapon can only gib if it deals blast damage or over half of its damage falloff.
			 */
			val critOnHardHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit on hard hit")
	
			/**
			 * In-Game: "Backstab turns victim to ice"
			 * 
			 * Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
			 */
			val freezeBackstabVictim: ItemAttributeNamed<Boolean> = ItemAttributeNamed("freeze backstab victim")
	
			/**
			 * In-Game: "Imbued with an ancient power"
			 * 
			 * Saxxy/golden pan effect.
			 */
			val turnToGold: ItemAttributeNamed<Boolean> = ItemAttributeNamed("turn to gold")
	
			/**
			 * Flamethrower kills.
			 */
			val ragdollsBecomeAsh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls become ash")
	
			/**
			 * Phlogistinator kills.
			 */
			val ragdollsPlasmaEffect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls plasma effect")
		}
	
		/**
		 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
		 */
		context(attrs: IAttributeContainer)
		open var critKillWillGib: Boolean? 
			get() = RagdollsAttributes.critKillWillGib.get()
			set(value) { RagdollsAttributes.critKillWillGib.set(value) }
	
		/**
		 * If false, this weapon can only gib if it deals blast damage or over half of its damage falloff.
		 */
		context(attrs: IAttributeContainer)
		open var critOnHardHit: Boolean? 
			get() = RagdollsAttributes.critOnHardHit.get()
			set(value) { RagdollsAttributes.critOnHardHit.set(value) }
	
		/**
		 * In-Game: "Backstab turns victim to ice"
		 * 
		 * Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
		 */
		context(attrs: IAttributeContainer)
		open var freezeBackstabVictim: Boolean? 
			get() = RagdollsAttributes.freezeBackstabVictim.get()
			set(value) { RagdollsAttributes.freezeBackstabVictim.set(value) }
	
		/**
		 * In-Game: "Imbued with an ancient power"
		 * 
		 * Saxxy/golden pan effect.
		 */
		context(attrs: IAttributeContainer)
		open var turnToGold: Boolean? 
			get() = RagdollsAttributes.turnToGold.get()
			set(value) { RagdollsAttributes.turnToGold.set(value) }
	
		/**
		 * Flamethrower kills.
		 */
		context(attrs: IAttributeContainer)
		open var ragdollsBecomeAsh: Boolean? 
			get() = RagdollsAttributes.ragdollsBecomeAsh.get()
			set(value) { RagdollsAttributes.ragdollsBecomeAsh.set(value) }
	
		/**
		 * Phlogistinator kills.
		 */
		context(attrs: IAttributeContainer)
		open var ragdollsPlasmaEffect: Boolean? 
			get() = RagdollsAttributes.ragdollsPlasmaEffect.get()
			set(value) { RagdollsAttributes.ragdollsPlasmaEffect.set(value) }
	}
	
	open class DisguiseAttributes : BaseCombatWeaponAttributes.DisguiseAttributes() 
}