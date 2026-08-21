package btpos.source.vdfdsl.types.populators

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.specifics.Where
import java.lang.ScopedValue.where
import java.time.Period

class PeriodicSpawnPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "PeriodicSpawn"
	
	override fun copy() = PeriodicSpawnPopulator(this.copyInternal())
	
	/**
	 * Will usually be a [RandomChoice][btpos.source.vdfdsl.types.spawners.RandomChoiceSpawner].
	 *
	 * [Squad][btpos.source.vdfdsl.types.spawners.SquadSpawner] and [Mob (deprecated)][btpos.source.vdfdsl.types.spawners.MobSpawner] work as well, but there is no practical use for this.
	 */
	override var spawner: AbstractSpawner?
		get() = super.spawner
		set(value) { super.spawner = value }
	
	/**
	 *
	 *
	 * @see Where
	 */
	var where: String? by addField("Where")
	
	/**
	 * Can be either a [Number] or a [When] instance
	 */
	var `when`: Any? by addField("When", serializer = IVDFRepresentableValue::serializeDynamic)
	
	open class When(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
		override val _structIdentifier: String get() = "When"
		
		open var minInterval: Number? by addField("MinInterval")
		
		open var maxInterval: Number? by addField("MaxInterval")
		
		override fun copy() = When(copyInternal())
		
		companion object {
			val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<When>(factoryMethod = { Codegen.basicApplyFactory<When>() })
		}
	}

	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<PeriodicSpawnPopulator>(
			customFieldDecoders = {
				mapOf(
					PeriodicSpawnPopulator::`when`.name to CodegenProvider {
						ValueDecoder { value, parent ->
							if (value is VDFPrimitive) {
								listOf(Codegen.code(value.stringValue))
							} else {
								When.CODEGEN.get()
									.decodeValue(value, parent)
							}
						}
					}
				)
			}, factoryMethod = { Codegen.basicBlockScope(Populators::PeriodicSpawn) }
		)
	}
}


