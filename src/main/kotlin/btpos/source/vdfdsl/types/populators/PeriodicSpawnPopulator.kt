package btpos.source.vdfdsl.types.populators

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.identifiers.KtMemberReference
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.types.KtClass
import btpos.misc.kt.codegen.types.KtSimpleType
import btpos.misc.kt.codegen.types.KtType
import btpos.misc.kt.codegen.types.toName
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.map
import btpos.source.vdfdsl.codegen.orElse
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.types.specifics.Where

class PeriodicSpawnPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "PeriodicSpawn"
	
	override fun copy() = PeriodicSpawnPopulator(this.copyInternal())
	
	/**
	 * Will usually be a [RandomChoice][btpos.source.vdfdsl.types.spawners.RandomChoiceSpawner].
	 *
	 * [Squad][btpos.source.vdfdsl.types.spawners.SquadSpawner] and [Mob (deprecated)][btpos.source.vdfdsl.types.spawners.MobSpawner] work as well, but there is no practical use for this.
	 */
	override val spawner get() = super.spawner
	
	/**
	 *
	 *
	 * @see Where
	 */
	val where by addField<String>("Where")
	
	/**
	 * Can be either a [Number] or a [When] instance
	 */
	val `when` by addField<When>("When") // TODO document
	
	interface When : IVDFRepresentableValue {
		companion object {
		    operator fun invoke(configure: Struct.() -> Unit): Struct {
		        return Struct().apply(configure)
		    }
			
			operator fun invoke(time: Number): Time {
				return Time(time)
			}
			
			val CODEGEN = Time.CODEGEN.map { it.orElse(Struct.CODEGEN.get()) }
		}
		
		open class Time(val number: Number) : When, IVDFRepresentableValue_Trivial {
			override val _vdfRepr: VDFPrimitive = VDFPrimitive(number)
			
			companion object {
				val CODEGEN = CodegenProvider<ValueDecoder<KtExpression>> {
					val cls = KtClass(When::class).toName()
					ValueDecoder { value, _ ->
						value.asPrimitive?.let { listOf(KtFunctionCall(cls, mutableListOf(Codegen.code(it.stringValue)))) }
					}
				}
			}
		}
		
		open class Struct(val _subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl())
			: IExtensibleSubtree_VDFRepresentable by _subtree, When
		{
			open val minInterval by addField<Number>("MinInterval")
			
			open val maxInterval by addField<Number>("MaxInterval")
			
			override fun copy() = Struct(_subtree.copy())
			
			companion object {
				val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<Struct>(factoryMethod = { Codegen.basicBlockScope(KtClass(When::class).toName()) })
			}
		}
	}
	
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<PeriodicSpawnPopulator>(factoryMethod = { Codegen.basicBlockScope(Populators::PeriodicSpawn) })
	}
}


