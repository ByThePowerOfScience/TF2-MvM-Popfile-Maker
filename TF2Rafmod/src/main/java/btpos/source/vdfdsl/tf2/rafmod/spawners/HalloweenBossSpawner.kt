package btpos.source.vdfdsl.tf2.rafmod.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.mapEach
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFHalloweenBoss
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFTeam
import btpos.source.vdfdsl.tf2.rafmod.types.PointTemplate
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import kotlin.time.Duration

open class HalloweenBossSpawner protected constructor(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(subtree) {
	constructor(boss: TFHalloweenBoss) : this() {
		this.boss = boss
	}
	
	override val _structIdentifier: String
		get() = "HalloweenBoss"
	
	override fun copy() = HalloweenBossSpawner(copyInternal())
	
	
	/**
	 * The boss this spawner should spawn. For skeletons, note that by default there may only be 30 alive at any given time, unless modified by [maxActiveSkeletons].
	 *
	 * Example:
	 * ```kotlin
	 * boss = TFHalloweenBoss.MONOCULOUS
	 * ```
	 */
	open var boss: TFHalloweenBoss? by addField("BossType", conditional = SIGSEGV)
	
	
	/**
	 * If true, gives this boss's icon in the wave preview a "crit" outline.
	 */
	open var iconHasCritOutline: Boolean? by addField("IsCrit", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, gives this boss's icon in the wave preview a red background.
	 */
	open var iconHasMinibossBackground: Boolean? by addField("IsMiniboss", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * The class icon to use for this bot.
	 *
	 * Example:
	 * ```kotlin
	 * classIcon = TFClass.Soldier
	 * ```
	 */
	open var classIcon: TFClass? by addField("ClassIcon", conditional = SIGSEGV)
	
	/**
	 * If true, the boss will drop money on death. If false, its money is distributed automatically upon death. (Default: true)
	 */
	open var spawnCurrencyPackOnDeath: Boolean? by addField("SpawnCurrencyPack", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * Monoculus will not target this team.
	 * 
	 * Example:
	 * ```kotlin
	 * team = TFTeam.BLU
	 * ```
	 */
	open var monoculusNoAttackTeam: TFTeam? by addField("TeamNum", conditional = SIGSEGV, serializer = RafmodSerializers.TFTEAM_NUMBER)
	
	/**
	 * Boss' HP. If 0 (or unset), uses default health pool for the boss.
	 *
	 * Example:
	 * ```kotlin
	 * health = 11111
	 * ```
	 */
	open var health: Int? by addField("Health", conditional = SIGSEGV)
	
	/**
	 * Amount of time Monoculus, Merasmus, and Skeletons should remain before despawning/"going away".
	 *
	 * Example:
	 * ```kotlin
	 * lifetime = 2.minute + 45.seconds
	 * ```
	 */
	open var lifetime: Duration? by addField("Lifetime", conditional = SIGSEGV, serializer = IExtensibleSubtree.Serializers.durationInSeconds())
	
	/**
	 * Overrides boss movespeed.
	 *
	 * Example:
	 * ```kotlin
	 * moveSpeed = 0
	 * ```
	 */
	open var moveSpeed: Number? by addField("Speed", conditional = SIGSEGV)
	
	
	/**
	 * The position to spawn this boss.  If [spawnAtEntity] is set, this is a relative offset from that entity's position.
	 *
	 * Example:
	 * ```kotlin
	 * startPos = Vec3(0, 1, 0)
	 * ```
	 */
	open var startPos: Vec3? by addField("Origin", conditional = SIGSEGV)
	
	
	/**
	 * Randomly spreads entities within a box of these dimensions centered on [startPos].
	 *
	 * Example:
	 * ```kotlin
	 * spawnRadius = Vec3(60, 60, 0) // No "z" (height) open variation,
	 * ```
	 */
	open var spawnRadius: Vec3? by addField("SpreadRadius", conditional = SIGSEGV)
	
	/**
	 * Snap the spawned template to the ground, as long as it is within this many HU above the ground.
	 *
	 * Example:
	 * ```kotlin
	 * snapToGroundWithin = 6000
	 * ```
	 */
	open var snapToGroundWithin: Int? by addField("StickToGround", conditional = SIGSEGV)
	
	/**
	 * Multiplies the boss' damage by this amount.
	 *
	 * Example:
	 * ```kotlin
	 * damageMultiplier = 2.5
	 * ```
	 */
	open var damageMultiplier: Number? by addField("DamageMultiplier", conditional = SIGSEGV)
	
	
	/**
	 * If set, spawns the boss at this entity instead of at the WaveSpawn's [where][btpos.source.vdfdsl.types.populators.WaveSpawnPopulator.where] location.
	 *
	 * Example:
	 * ```kotlin
	 * spawnAtEntity = "custom_spawn_entity"
	 * ```
	 */
	open var spawnAtEntity: String? by addField("SpawnAtEntity", conditional = SIGSEGV)
	
	/**
	 * If set, also spawn these point templates on the boss's location when the boss spawns.
	 *
	 * Example:
	 * ```kotlin
	 * spawnedTemplates += MyPointTemplates.WEAPON_MIMIC
	 * ```
	 */
	open var spawnedTemplates: List<PointTemplate> by addField("SpawnTemplate", conditional = SIGSEGV, serializer = flatListWithKey<String>().mapEach(RafmodSerializers.POINTTEMPLATE_NAME), initialValue = ::listOf)
	
	
	
}