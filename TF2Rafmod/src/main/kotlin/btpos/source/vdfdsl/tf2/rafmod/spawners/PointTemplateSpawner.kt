package btpos.source.vdfdsl.tf2.rafmod.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.rafmod.data.Rot3
import btpos.source.vdfdsl.tf2.rafmod.types.PointTemplate
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.spawners.AbstractSpawner

/**
 * Spawns a given template at a specific location.
 *
 * This template counts as "alive" until all entities in the [templateToSpawn] template are removed.
 */
@PopFileDSL
open class PointTemplateSpawner protected constructor(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	constructor(spawnedTemplate: PointTemplate) : this() {
		this.templateToSpawn = spawnedTemplate
	}
	
	override val _structIdentifier: String
		get() = "PointTemplateSpawner"
	
	override val _conditional: String?
		get() = SIGSEGV
	
	override fun copy(): PointTemplateSpawner {
		return PointTemplateSpawner(copyInternal())
	}
	
	
	/**
	 * The entity to spawn the template at. "Where" spawns at the bot spawn as indicated by [where][btpos.source.vdfdsl.types.populators.WaveSpawnPopulator.where]. If omitted, spawns at the world origin.
	 *
	 * Example:
	 * ```kotlin
	 * spawnAtEntity = "custom_spawn_entity"
	 * ```
	 */
	open var spawnAtEntity: String? by addField("SpawnAtEntity", conditional = SIGSEGV)
	
	/**
	 * If true, gives this bot's icon in the wave preview a "crit" outline.
	 */
	open var iconHasCritOutline: Boolean? by addField("IsCrit", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, gives this bot's icon in the wave preview a red background.
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
	 * The template to spawn with these parameters.  Automatically set by constructor.
	 *
	 * Example:
	 * ```kotlin
	 * templateToSpawn = MyPointTemplates.SENTRY_STACK
	 * ```
	 */
	open var templateToSpawn: PointTemplate? by addField("Name", conditional = SIGSEGV, serializer = RafmodSerializers.POINTTEMPLATE_NAME)
	
	/**
	 * The position to spawn the template.  If [spawnAtEntity] is set, this is a relative offset from that entity's position.
	 *
	 * Example:
	 * ```kotlin
	 * startPos = Vec3(0, 1, 0)
	 * ```
	 */
	open var startPos: Vec3? by addField("Origin", conditional = SIGSEGV)
	
	/**
	 * The pitch, yaw, and roll that this template should have when spawned, relative to TODO figure out what direction
	 * 
	 * Example:
	 * ```kotlin
	 * direction = Rot3(0, 85, 0) // turn entities 85 degrees clockwise from TODO
	 * ```
	 */
	open var direction: Rot3? by addField("Angles", conditional = SIGSEGV)
	
	/**
	 * The name of the entity that will drop money. If not specified, currency is distributed automatically when the template is removed.
	 *
	 * Example:
	 * ```kotlin
	 * entityThatSpawnsCurrencyPack = "sentry3"
	 * ```
	 */
	open var entityThatSpawnsCurrencyPack: String? by addField("SpawnCurrencyPack", conditional = SIGSEGV)
	
	
	
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
	
	
}