package btpos.source.vdfdsl.tf2.tftypes

/**
 * Documentation sourced from [https://developer.valvesoftware.com/wiki/Condition_list]
 */
class TFCondition(
	/**
	 * The full name of the condition, e.g. `"TF_COND_AIMING"`.
	 */
	val TF_COND: String,
	/**
	 * The ID or index of this condition in the list, e.g. "aiming" is condition `0`.
	 */
	val index: Int
) {
	companion object {
		private var currentIndex = 0
		
		/**
		 * Slowed (as in when revving Minigun or zooming in with Sniper Rifles). Places the player in their class's zoomed/revved pose (for classes without this animation, this uses the reference pose).
		 */
		@JvmField val Aiming = TFCondition("TF_COND_AIMING", 0)
		
		/**
		 * Sniper Rifle zoom/scope. If applied whilst in third person, the player will appear invisible. Upon switching out of a weapon whilst this condition is active when the weapon does not allow zooming, the game will crash.
		 */
		@JvmField val Zoomed = TFCondition("TF_COND_ZOOMED", 1)
		
		/**
		 * Disguise smoke.
		 */
		@JvmField val Disguising = TFCondition("TF_COND_DISGUISING", 2)
		
		/**
		 * Disguise donning.
		 */
		@JvmField val Disguised = TFCondition("TF_COND_DISGUISED", 3)
		
		/**
		 * Cloak effect. Applying this effect as Spy initiates cloaking but with no sound (with the selected PDA's deploy animation playing). When applied as a class other than Spy, the player will immediately uncloak with no noise.
		 */
		@JvmField val Stealthed = TFCondition("TF_COND_STEALTHED", 4)
		
		/**
		 * Medi Gun invulnerability effect. Will drop as soon as the user starts to receive continuous healing from a Dispenser, Payload cart or Medic's secondary healing gun. Also drops from a Medic as soon as he activates or comes to the end of his own ÜberCharge. Not affected by a Medic's self-healing.
		 */
		@JvmField val Invulnerable = TFCondition("TF_COND_INVULNERABLE", 5)
		
		/**
		 * Teleporter dust.
		 */
		@JvmField val Teleported = TFCondition("TF_COND_TELEPORTED", 6)
		
		/**
		 * Intended to be taunting. Does nothing via addcond, but can be used with removecond to immediately stop taunting.
		 */
		@JvmField val Taunting = TFCondition("TF_COND_TAUNTING", 7)
		
		/**
		 * ÜberCharge expiration effect, if the player is ÜberCharged.
		 */
		@JvmField val InvulnerableWearingoff = TFCondition("TF_COND_INVULNERABLE_WEARINGOFF", 8)
		
		/**
		 * Intended to be flickering effect if Cloaked. Removed immediately if added.
		 */
		@JvmField val StealthedBlink = TFCondition("TF_COND_STEALTHED_BLINK", 9)
		
		/**
		 * Intended to be condition for Teleporting. Prevents you from doing things you normally wouldn't be able to do when teleporting (e.g. picking up The Intelligence).
		 */
		@JvmField val SelectedToTeleport = TFCondition("TF_COND_SELECTED_TO_TELEPORT", 10)
		
		/**
		 * Crit boost (Kritzkrieg, Revenge crits). Drops under the same conditions as 5.
		 */
		@JvmField val CritBoosted = TFCondition("TF_COND_CRITBOOSTED", 11)
		
		/**
		 * Intended to be a temporary damage buff. Does nothing.
		 */
		@JvmField val TmpDamageBonus = TFCondition("TF_COND_TMPDAMAGEBONUS", 12)
		
		/**
		 * Dead Ringer Cloak defense buff, works with any watch as Spy. Will automatically add condition 4.
		 */
		@JvmField val FeignDeath = TFCondition("TF_COND_FEIGN_DEATH", 13)
		
		/**
		 * Bonk! Atomic Punch effect.
		 */
		@JvmField val Phase = TFCondition("TF_COND_PHASE", 14)
		
		/**
		 * Intended to be the Stunned effect, but simply adds the slowing effect icon in the HUD without any change to movement speed. Can be used with removecond to remove a stun.
		 */
		@JvmField val Stunned = TFCondition("TF_COND_STUNNED", 15)
		
		/**
		 * Buff Banner effect.
		 */
		@JvmField val OffenseBuff = TFCondition("TF_COND_OFFENSEBUFF", 16)
		
		/**
		 * Chargin' Targe effect. Will cause any class to begin moving forward with a restricted turn rate as if charging, while emitting the Demoman's charging yell (the Demoman's speed will increase to 750 HU/s, and for Demomen this condition will expire when the charge meter empties).
		 */
		@JvmField val ShieldCharge = TFCondition("TF_COND_SHIELD_CHARGE", 17)
		
		/**
		 * Intended to be the glowing eye effect associated with the Eyelander's head-taking capability. Can be used with removecond to remove such a glow.
		 */
		@JvmField val DemoBuff = TFCondition("TF_COND_DEMO_BUFF", 18)
		
		/**
		 * Crit-a-Cola/Buffalo Steak Sandvich/Cleaner's Carbine effect.
		 */
		@JvmField val EnergyBuff = TFCondition("TF_COND_ENERGY_BUFF", 19)
		
		/**
		 * Medicating Melody effect (does not heal, only adds rings around the player's feet; the rings are removed after a taunt ends, though the condition persists).
		 */
		@JvmField val RadiusHeal = TFCondition("TF_COND_RADIUSHEAL", 20)
		
		/**
		 * Intended to be the effect associated with any kind of continuous healing. Can be used with removecond to remove such an effect.
		 */
		@JvmField val HealthBuff = TFCondition("TF_COND_HEALTH_BUFF", 21)
		
		/**
		 * Fire Ignite reaction (sound and speech, but no fire). Can be used with removecond to remove afterburn.
		 */
		@JvmField val Burning = TFCondition("TF_COND_BURNING", 22)
		
		/**
		 * Intended to indicate Overhealing. Does nothing.
		 */
		@JvmField val HealthOverhealed = TFCondition("TF_COND_HEALTH_OVERHEALED", 23)
		
		/**
		 * Jarate effect.
		 */
		@JvmField val Urine = TFCondition("TF_COND_URINE", 24)
		
		/**
		 * Intended to be the Bleeding effect. Can only be used with removecond to remove bleeding.
		 */
		@JvmField val Bleeding = TFCondition("TF_COND_BLEEDING", 25)
		
		/**
		 * Battalion's Backup effect.
		 */
		@JvmField val Defensebuff = TFCondition("TF_COND_DEFENSEBUFF", 26)
		
		/**
		 * Mad Milk effect.
		 */
		@JvmField val MadMilk = TFCondition("TF_COND_MAD_MILK", 27)
		
		/**
		 * Quick-Fix visual effects + knock back/movement immunity (no healing). Drops under the same conditions as 5.
		 */
		@JvmField val Megaheal = TFCondition("TF_COND_MEGAHEAL", 28)
		
		/**
		 * Concheror effect.
		 */
		@JvmField val Regenondamagebuff = TFCondition("TF_COND_REGENONDAMAGEBUFF", 29)
		
		/**
		 * Fan o' War effect (marked for death).
		 */
		@JvmField val Markedfordeath = TFCondition("TF_COND_MARKEDFORDEATH", 30)
		
		/**
		 * All attacks are mini-crits (no mini-crit glow occurs, but mini-crit hit sounds and effects occur). Player cannot be healed in any way.
		 */
		@JvmField val NoHealingDamageBuff = TFCondition("TF_COND_NOHEALINGDAMAGEBUFF", 31)
		
		/**
		 * Disciplinary Action effect.
		 */
		@JvmField val SpeedBoost = TFCondition("TF_COND_SPEED_BOOST", 32)
		
		/**
		 * Halloween pumpkin crit boost.
		 */
		@JvmField val CritBoosted_Pumpkin = TFCondition("TF_COND_CRITBOOSTED_PUMPKIN", 33)
		
		/**
		 * Power Up Canteen crit boost. Provides critical hits and doubles Sentry Gun firing rate.
		 */
		@JvmField val CritBoosted_UserBuff = TFCondition("TF_COND_CRITBOOSTED_USER_BUFF", 34)
		
		/**
		 * Player's weapon gains crit glow and emits crit sound cues as if charging (but does not gain a crit boost). Automatically added by condition 17 when the player's charge meter drops below 75%.
		 */
		@JvmField val CritBoosted_DemoCharge = TFCondition("TF_COND_CRITBOOSTED_DEMO_CHARGE", 35)
		
		/**
		 * Soda Popper's "Hype" multiple jump. On classes other than Scout, this provides the purple glow effect on weapons, but no additional jumps are granted.
		 */
		@JvmField val SodaPopperHype = TFCondition("TF_COND_SODAPOPPER_HYPE", 36)
		
		/**
		 * First blood crit boost.
		 */
		@JvmField val CriBboosted_FirstBlood = TFCondition("TF_COND_CRITBOOSTED_FIRST_BLOOD", 37)
		
		/**
		 * Winning team crit boost.
		 */
		@JvmField val CritBoosted_BonusTime = TFCondition("TF_COND_CRITBOOSTED_BONUS_TIME", 38)
		
		/**
		 * Intelligence capture crit boost.
		 */
		@JvmField val CritBoosted_CTFCapture = TFCondition("TF_COND_CRITBOOSTED_CTF_CAPTURE", 39)
		
		/**
		 * Crit boost from crit-on-kill weapons (Killing Gloves of Boxing).
		 */
		@JvmField val CritBoosted_OnKill = TFCondition("TF_COND_CRITBOOSTED_ON_KILL", 40)
		
		/**
		 * Cannot switch away from melee weapon (as for Buffalo Steak Sandvich).
		 */
		@JvmField val CannotSwitchFromMelee = TFCondition("TF_COND_CANNOT_SWITCH_FROM_MELEE", 41)
		
		/**
		 * Player takes 35% less damage (50% less from Sentry Guns), gains team-colored buff rings. This is used for the Mann vs. Machine bomb carrier defensive buff. This is similar to condition 26, though without the icon above the health bar in the HUD.
		 */
		@JvmField val DefenseBuff_NoCritBlock = TFCondition("TF_COND_DEFENSEBUFF_NO_CRIT_BLOCK", 42)
		
		/**
		 * "Reprogrammed". This condition no longer functions. Previous behavior: swaps the player from BLU to RED for the duration of the condition. Removal of this condition causes the player to swap from RED to BLU. Adds sparks to player's head. Automatically adds condition 15 and slows the player for 5 seconds.
		 */
		@JvmField val Reprogrammed = TFCondition("TF_COND_REPROGRAMMED", 43)
		
		/**
		 * Mmmph crit boost.
		 */
		@JvmField val CritBoosted_RageBuff = TFCondition("TF_COND_CRITBOOSTED_RAGE_BUFF", 44)
		
		/**
		 * Mmmph activation defense buff.
		 */
		@JvmField val DefenseBuff_High = TFCondition("TF_COND_DEFENSEBUFF_HIGH", 45)
		
		/**
		 * Focus effect. This affects only Sniper primaries, but not the Classic, the Huntsman or Fortified Compound. All other weapons gain the lightning effects, however.
		 */
		@JvmField val SniperChargeRageBuff = TFCondition("TF_COND_SNIPERCHARGE_RAGE_BUFF", 46)
		
		/**
		 * Causes the Enforcer to lose its 20% damage bonus, as when firing it to remove a disguise.
		 */
		@JvmField val DisguiseWearingoff = TFCondition("TF_COND_DISGUISE_WEARINGOFF", 47)
		
		/**
		 * Self marked for death (as with Rescue Ranger hauling).
		 */
		@JvmField val MarkedForDeath_Silent = TFCondition("TF_COND_MARKEDFORDEATH_SILENT", 48)
		
		/**
		 * Crouching causes the player to appear to be a Dispenser of the enemy team to enemy players. As a side effect, it forces the player's speed to 450 Hammer Units per second (diagonal movement is at 520 HU/s). Swapping weapons while in this state will cause the player to briefly stop moving, and then return to 450 HU/s. This condition also causes Sentry Guns to ignore the player, which was possibly used for a Spy disguise that was later scrapped.
		 */
		@JvmField val DisguisedAsDispenser = TFCondition("TF_COND_DISGUISED_AS_DISPENSER", 49)
		
		/**
		 * Adds a sparking effect to the player's head (associated with sapping a Robot in Mann vs. Machine).
		 */
		@JvmField val Sapped = TFCondition("TF_COND_SAPPED", 50)
		
		/**
		 * "Hidden" ÜberCharge (player sees their viewmodel as ÜberCharged, but their appearance is not ÜberCharged unless they are hit by a source of damage, after which the player appears ÜberCharged for several seconds. Much like Robots on a Mann vs. Machine wave before entering the arena).
		 */
		@JvmField val Invulnerable_HideUnlessDamaged = TFCondition("TF_COND_INVULNERABLE_HIDE_UNLESS_DAMAGED", 51)
		
		/**
		 * Canteen ÜberCharge. Reduces damage to your Sentry Gun. Also used for Mannpower respawn Über protection.
		 */
		@JvmField val Invulnerable_UserBuff = TFCondition("TF_COND_INVULNERABLE_USER_BUFF", 52)
		
		/**
		 * Player is forced into thirdperson and hears the Bombinomicon's lines as if their head were turned into a bomb. If Merasmus is active on the map, a bomb appears on the player's head. This condition may cause users to crash if added on a map other than Ghost Fort.
		 */
		@JvmField val HalloweenBombHead = TFCondition("TF_COND_HALLOWEEN_BOMB_HEAD", 53)
		
		/**
		 * Player cannot move and hears the Ghost Fort dancing music. Any taunts performed will be the Thriller taunt.
		 */
		@JvmField val HalloweenThriller = TFCondition("TF_COND_HALLOWEEN_THRILLER", 54)
		
		/**
		 * Automatically adds condition 20 and 21 and causes the player and every nearby teammate to begin gaining health as if being healed by the Amputator. The player gets the credit for any healing that occurs.
		 *
		 * Conditions 20 and 21 are automatically removed when the player ends any taunt, but condition 55 remains active (though it does nothing after this point).
		 */
		@JvmField val RadiusHealOnDamage = TFCondition("TF_COND_RADIUSHEAL_ON_DAMAGE", 55)
		
		/**
		 * Miscellaneous crit boost. Likely used for the Wheel of Fate Critical Hits effect.
		 */
		@JvmField val Critboosted_CardEffect = TFCondition("TF_COND_CRITBOOSTED_CARD_EFFECT", 56)
		
		/**
		 * Miscellaneous ÜberCharge. Likely used for the Wheel of Fate ÜberCharge effect.
		 */
		@JvmField val Invulnerable_CardEffect = TFCondition("TF_COND_INVULNERABLE_CARD_EFFECT", 57)
		
		/**
		 * Vaccinator Über bullet resistance.
		 */
		@JvmField val MedigunUberBulletResist = TFCondition("TF_COND_MEDIGUN_UBER_BULLET_RESIST", 58)
		
		/**
		 * Vaccinator Über blast resistance.
		 */
		@JvmField val MedigunUberBlastResist = TFCondition("TF_COND_MEDIGUN_UBER_BLAST_RESIST", 59)
		
		/**
		 * Vaccinator Über fire resistance.
		 */
		@JvmField val MedigunUberFireResist = TFCondition("TF_COND_MEDIGUN_UBER_FIRE_RESIST", 60)
		
		/**
		 * Vaccinator passive bullet resistance.
		 */
		@JvmField val MedigunSmallBulletResist = TFCondition("TF_COND_MEDIGUN_SMALL_BULLET_RESIST", 61)
		
		/**
		 * Vaccinator passive blast resistance.
		 */
		@JvmField val MedigunSmallBlastResist = TFCondition("TF_COND_MEDIGUN_SMALL_BLAST_RESIST", 62)
		
		/**
		 * Vaccinator passive fire resistance.
		 */
		@JvmField val MedigunSmallFireResist = TFCondition("TF_COND_MEDIGUN_SMALL_FIRE_RESIST", 63)
		
		/**
		 * Player will Cloak immediately regardless of class. Used for the Invisibility Magic spell.
		 */
		@JvmField val StealthedUserBuff = TFCondition("TF_COND_STEALTHED_USER_BUFF", 64)
		
		/**
		 * Unknown.
		 */
		@JvmField val MedigunDebuff = TFCondition("TF_COND_MEDIGUN_DEBUFF", 65)
		
		/**
		 * Player is ignored by enemy bots and Sentry Guns, and fades to Invisibility. Attacking will make the player visible, but the player will rapidly fade out again, during which the player will be unable to attack. Player gains a shadowed-border "Stealth" overlay. Used when the Invisibility Magic spell is fading.
		 */
		@JvmField val StealthedUserBuffFading = TFCondition("TF_COND_STEALTHED_USER_BUFF_FADING", 66)
		
		/**
		 * Bullet damage immunity.
		 */
		@JvmField val BulletImmune = TFCondition("TF_COND_BULLET_IMMUNE", 67)
		
		/**
		 * Blast damage immunity.
		 */
		@JvmField val BlastImmune = TFCondition("TF_COND_BLAST_IMMUNE", 68)
		
		/**
		 * Fire damage immunity.
		 */
		@JvmField val FireImmune = TFCondition("TF_COND_FIRE_IMMUNE", 69)
		
		/**
		 * Player will survive all damage until their health reaches 1, after which this condition will be automatically removed. Damage that would be fatal will not show as combat text above the player's head to the attacker.
		 */
		@JvmField val PreventDeath = TFCondition("TF_COND_PREVENT_DEATH", 70)
		
		/**
		 * MvM Bot gate-capture stun (automatically stuns bots and adds a radio effect above their heads, but has no effect on human players).
		 */
		@JvmField val MvmBotStunRadiowave = TFCondition("TF_COND_MVM_BOT_STUN_RADIOWAVE", 71)
		
		/**
		 * Player gains speed boost, firing rate boost, reload speed boost, and infinite air jumps. Used for the Minify Magic spell.
		 */
		@JvmField val HalloweenSpeedBoost = TFCondition("TF_COND_HALLOWEEN_SPEED_BOOST", 72)
		
		/**
		 * Quick-Fix-like healing effect. Automatically adds condition 21 for the duration of the effect, as well as condition 28 for a brief period. Used for the Healing Aura Magic spell.
		 */
		@JvmField val HalloweenQuickHeal = TFCondition("TF_COND_HALLOWEEN_QUICK_HEAL", 73)
		
		/**
		 * Player is doubled in size, but movement speed, melee range, and damage remain unchanged. The player's max health is scaled upwards by 10 and any ammo lost while under this effect is regenerated instantly. The player is forced into the Medieval thirdperson shoulder view.
		 */
		@JvmField val HalloweenGiant = TFCondition("TF_COND_HALLOWEEN_GIANT", 74)
		
		/**
		 * Player is halved in size, although head size, movement speed, melee range, and damage remain unchanged. The player is forced into thirdperson. Used for the Bumper Cars in Carnival of Carnage and Gravestone.
		 */
		@JvmField val HalloweenTiny = TFCondition("TF_COND_HALLOWEEN_TINY", 75)
		
		/**
		 * Player gains condition 77 upon death, used for when the player is in Hell.
		 */
		@JvmField val HalloweenInHell = TFCondition("TF_COND_HALLOWEEN_IN_HELL", 76)
		
		/**
		 * Player becomes a Ghost. Can be reverted with removecond.
		 */
		@JvmField val HalloweenGhostMode = TFCondition("TF_COND_HALLOWEEN_GHOST_MODE", 77)
		
		/**
		 * Unknown. Intended to be mini-crit boost from mini-crit-on-kill weapons (like the Cleaner's Carbine before the December 17, 2015 Patch, but is unused.
		 */
		@JvmField val MinicritboostedOnKill = TFCondition("TF_COND_MINICRITBOOSTED_ON_KILL", 78)
		
		/**
		 * Player has a 75% chance to dodge every time damage is taken (dodged damage will cause the MISS! effect from condition 14 to appear).
		 */
		@JvmField val ObscuredSmoke = TFCondition("TF_COND_OBSCURED_SMOKE", 79)
		
		/**
		 * Player gains a parachute if airborne. Removed upon landing.
		 */
		@JvmField val ParachuteActive = TFCondition("TF_COND_PARACHUTE_ACTIVE", 80)
		
		/**
		 * Player gains fire rate bonus on the Air Strike.
		 */
		@JvmField val Blastjumping = TFCondition("TF_COND_BLASTJUMPING", 81)
		
		/**
		 * Player gains Bumper Car movement, controls and bumper car model. Associated HUD will not be visible.
		 */
		@JvmField val HalloweenKart = TFCondition("TF_COND_HALLOWEEN_KART", 82)
		
		/**
		 * Player's Field of View increases, with their world model playing the Bumper Car boosting animation, and if the player has condition 82, the player is forced to move forwards at a boosted speed until the condition is removed or upon collision with a wall or an enemy player.
		 */
		@JvmField val HalloweenKartDash = TFCondition("TF_COND_HALLOWEEN_KART_DASH", 83)
		
		/**
		 * Player gains a larger head and lowered gravity.
		 */
		@JvmField val BalloonHead = TFCondition("TF_COND_BALLOON_HEAD", 84)
		
		/**
		 * Player is forced to use melee weapons. Automatically adds conditions 32 and 75 when added.
		 */
		@JvmField val MeleeOnly = TFCondition("TF_COND_MELEE_ONLY", 85)
		
		/**
		 * Player can swim in air, and gains vision effects as if underwater or covered in Jarate.
		 */
		@JvmField val SwimmingCurse = TFCondition("TF_COND_SWIMMING_CURSE", 86)
		
		/**
		 * Player is locked in place and cannot turn, attack, or switch weapons. The player can still taunt, however.
		 */
		@JvmField val FreezeInput = TFCondition("TF_COND_FREEZE_INPUT", 87)
		
		/**
		 * Player gains a cage surrounding them. Automatically adds condition 87 when added. This is used for the Scream Fortress Halloween bumper car minigames. This will crash the game unless you are on a map that supports bumper cars (currently only Carnival of Carnage).
		 */
		@JvmField val HalloweenKartCage = TFCondition("TF_COND_HALLOWEEN_KART_CAGE", 88)
		
		/**
		 * Player is considered as holding a Mannpower powerup. Using the dropitem command (Default key:L) will drop a powerup pickup (usually Strength) and remove this condition.
		 */
		@JvmField val Donotuse0 = TFCondition("TF_COND_DONOTUSE_0", 89)
		
		/**
		 * Player gains double damage for all weapons and distance damage fall-off immunity. Used for the "Strength" powerup in Mannpower mode.
		 */
		@JvmField val RuneStrength = TFCondition("TF_COND_RUNE_STRENGTH", 90)
		
		/**
		 * Player gains double firing rate, reload rate, clip size, and max ammo count. Movement speed is also increased by 30%. Used for the "Haste" powerup in Mannpower mode.
		 */
		@JvmField val RuneHaste = TFCondition("TF_COND_RUNE_HASTE", 91)
		
		/**
		 * Player periodically regenerates ammo, health, and metal. Health regeneration rate is inversely proportional to maximum health. Used for the "Regen" powerup in Mannpower mode.
		 */
		@JvmField val RuneRegen = TFCondition("TF_COND_RUNE_REGEN", 92)
		
		/**
		 * Player gains a 50% resistance to all incoming damage, as well as an immunity to all critical hits. Used for the "Resistance" powerup in Mannpower mode.
		 */
		@JvmField val RuneResist = TFCondition("TF_COND_RUNE_RESIST", 93)
		
		/**
		 * Player gains the ability to receive HP based on damage dealt, a 25% damage resistance, and a 40% increase in maximum HP. Used for the "Vampire" powerup in Mannpower mode.
		 */
		@JvmField val RuneVampire = TFCondition("TF_COND_RUNE_VAMPIRE", 94)
		
		/**
		 * Player gains the ability to reflect damage dealt to them back at the attacker, although this cannot directly cause death. Player additionally gets a 50% increase in max HP. Used for the "Reflect" powerup in Mannpower mode.
		 */
		@JvmField val RuneReflect = TFCondition("TF_COND_RUNE_REFLECT", 95)
		
		/**
		 * Player gains a drastic decrease in bullet spread, as well as damage falloff immunity. Projectiles fired by the player gain a 250% increase in projectile speed. Sniper rifles deal double damage, gain faster damage ramp-up, and will re-zoom quicker after firing. Used for the "Precision" powerup in Mannpower mode.
		 */
		@JvmField val RunePrecision = TFCondition("TF_COND_RUNE_PRECISION", 96)
		
		/**
		 * Player gains an increase in movement speed, grapple speed, and jump height. The player can instantly switch between their weapons. Used for the "Agility" powerup in Mannpower mode.
		 */
		@JvmField val RuneAgility = TFCondition("TF_COND_RUNE_AGILITY", 97)
		
		/**
		 * Added when a player fires the Grappling Hook. Addition or removal via commands has no effect.
		 */
		@JvmField val Grapplinghook = TFCondition("TF_COND_GRAPPLINGHOOK", 98)
		
		/**
		 * Added when a player's Grappling Hook begins pulling them. Removed when the player lands. Addition or removal via commands has no effect.
		 */
		@JvmField val GrapplinghookSafefall = TFCondition("TF_COND_GRAPPLINGHOOK_SAFEFALL", 99)
		
		/**
		 * Added when a player's Grappling Hook latches to a wall, and removed when player disengages the Grappling Hook. Addition of this condition causes the player's world model to play the Grappling Hook shoot animation briefly, then does nothing.
		 */
		@JvmField val GrapplinghookLatched = TFCondition("TF_COND_GRAPPLINGHOOK_LATCHED", 100)
		
		/**
		 * Added when a player is latched by another player's Grappling Hook. Adding this condition does not initiate bleeding, but does show the icon in the HUD.
		 */
		@JvmField val GrapplinghookBleeding = TFCondition("TF_COND_GRAPPLINGHOOK_BLEEDING", 101)
		
		/**
		 * Added when a player activates their Dead Ringer, giving them immunity to afterburn.
		 */
		@JvmField val AfterburnImmune = TFCondition("TF_COND_AFTERBURN_IMMUNE", 102)
		
		/**
		 * Player is restricted to Melee and their Grappling Hook, has their max health increased by 150 and becomes immune to knockback. They also do 4x damage to Buildings. Used for the "Knockout" powerup in Mannpower mode.
		 */
		@JvmField val RuneKnockout = TFCondition("TF_COND_RUNE_KNOCKOUT", 103)
		
		/**
		 * Added when player gains the Mannpower Revenge powerup. Prevents pickup of the Mannpower Crit or Uber powerups.
		 */
		@JvmField val RuneImbalance = TFCondition("TF_COND_RUNE_IMBALANCE", 104)
		
		/**
		 * Mannpower Crit powerup.
		 */
		@JvmField val CritboostedRuneTemp = TFCondition("TF_COND_CRITBOOSTED_RUNE_TEMP", 105)
		
		/**
		 * Added whenever a player intercepts the Jack/Ball in the PASS Time gamemode. When added, displays the distortion effect.
		 */
		@JvmField val PasstimeInterception = TFCondition("TF_COND_PASSTIME_INTERCEPTION", 106)
		
		/**
		 * Player can swim in air, similar to condition 86, but without swimming animations, forced third-person perspective, and underwater overlay.
		 */
		@JvmField val SwimmingNoEffects = TFCondition("TF_COND_SWIMMING_NO_EFFECTS", 107)
		
		/**
		 * "Purgatory", used for Eyeaduct when the player enters the Underworld. When added, refills health and adds 1 second of ÜberCharge to the player. When removed, displays "<playername> has escaped the underworld!", additionally granting the effects of escaping the Underworld if the player had condition 108 when removecond was used.
		 */
		@JvmField val Purgatory = TFCondition("TF_COND_PURGATORY", 108)
		
		/**
		 * Player gains an increase in max health, health regen, fire rate, and reload rate. Used for the "King" powerup in Mannpower mode.
		 */
		@JvmField val RuneKing = TFCondition("TF_COND_RUNE_KING", 109)
		
		/**
		 * The Plague powerup from Mannpower.
		 */
		@JvmField val RunePlague = TFCondition("TF_COND_RUNE_PLAGUE", 110)
		
		/**
		 * The Supernova powerup from Mannpower.
		 */
		@JvmField val RuneSupernova = TFCondition("TF_COND_RUNE_SUPERNOVA", 111)
		
		/**
		 * Plagued by the Plague powerup from Mannpower. Player bleeds until they pick up a health kit, touch a Resupply locker, or die. Blocks the health regen and team buff from the King powerup.
		 */
		@JvmField val Plague = TFCondition("TF_COND_PLAGUE", 112)
		
		/**
		 * The area-of-effect buffs from the King powerup from Mannpower.  Player gains an increase in health regen, fire rate, and reload rate.
		 */
		@JvmField val KingBuffed = TFCondition("TF_COND_KING_BUFFED", 113)
		
		/**
		 * Enables glow outlines on friendly players and buildings. Used when player respawns.
		 */
		@JvmField val TeamGlows = TFCondition("TF_COND_TEAM_GLOWS", 114)
		
		/**
		 * Used whenever a player is under the effects of Compression blast. Removed when the player touches the ground.
		 */
		@JvmField val KnockedIntoAir = TFCondition("TF_COND_KNOCKED_INTO_AIR", 115)
		
		/**
		 * Applied when the player is on the competitive winner's podium.
		 */
		@JvmField val CompetitiveWinner = TFCondition("TF_COND_COMPETITIVE_WINNER", 116)
		
		/**
		 * Applied when the player is on the loser team in competitive match summary. Prevents taunting.
		 */
		@JvmField val CompetitiveLoser = TFCondition("TF_COND_COMPETITIVE_LOSER", 117)
		
		/**
		 * The healing debuff added by the Pyro's Flamethrower.
		 */
		@JvmField val HealingDebuff = TFCondition("TF_COND_HEALING_DEBUFF", 118)
		
		/**
		 * Applied when the player is carrying the Jack in PASS Time with no nearby teammates. Marks the player for death.
		 */
		@JvmField val PasstimePenaltyDebuff = TFCondition("TF_COND_PASSTIME_PENALTY_DEBUFF", 119)
		
		/**
		 * Used when a player with the Grappling Hook is grappled to another player. Prevents taunting and performs some grappling hook movement logic.
		 */
		@JvmField val GrappledToPlayer = TFCondition("TF_COND_GRAPPLED_TO_PLAYER", 120)
		
		/**
		 * Unknown. Checked when attempting to set the target for a grappling hook.
		 */
		@JvmField val GrappledByPlayer = TFCondition("TF_COND_GRAPPLED_BY_PLAYER", 121)
		
		/**
		 * Added when deploying the B.A.S.E. Jumper.
		 */
		@JvmField val ParachuteDeployed = TFCondition("TF_COND_PARACHUTE_DEPLOYED", 122)
		
		/**
		 * Gas coating effect from the Gas Passer.
		 */
		@JvmField val Gas = TFCondition("TF_COND_GAS", 123)
		
		/**
		 * Afterburn effect applied to Pyros when hit by the Dragon's Fury projectile.
		 */
		@JvmField val BurningPyro = TFCondition("TF_COND_BURNING_PYRO", 124)
		
		/**
		 * Applied when the boosters on the Thermal Thruster activate. Removed when the player touches the ground.
		 */
		@JvmField val Rocketpack = TFCondition("TF_COND_ROCKETPACK", 125)
		
		/**
		 * When added while moving, decreases the player's friction, causing them to slide around. Removed when the player stops moving.
		 */
		@JvmField val LostFooting = TFCondition("TF_COND_LOST_FOOTING", 126)
		
		/**
		 * Used whenever a player is under the effects of an air current (such as Compression blast). Applies a multiplier on air control and surface friction.
		 */
		@JvmField val AirCurrent = TFCondition("TF_COND_AIR_CURRENT", 127)
		
		/**
		 * Used whenever a player gets teleported to Hell. Does nothing when added, but stops the gradual healing effect from the teleport when removed.
		 */
		@JvmField val HalloweenHellHeal = TFCondition("TF_COND_HALLOWEEN_HELL_HEAL", 128)
		
		/**
		 * Used in Mannpower when a player has a high kill count compared to the rest of the players in the game. Reduces the strength of the currently equipped powerup.
		 */
		@JvmField val PowerupModeDominant = TFCondition("TF_COND_POWERUPMODE_DOMINANT", 129)
		
		/**
		 * Become immune to all sources of knockback, such as an airblast or explosive damage.
		 */
		@JvmField val ImmuneToPushback = TFCondition("TF_COND_IMMUNE_TO_PUSHBACK", 130)
	}
}