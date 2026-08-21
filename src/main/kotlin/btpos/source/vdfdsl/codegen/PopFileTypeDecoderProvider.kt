package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.populators.AbstractPopulator
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.spawners.TFBotSpawner
import btpos.source.vdfdsl.types.specifics.NavArea
import btpos.source.vdfdsl.types.specifics.Where
import kotlin.reflect.KClass

class PopFileTypeDecoderProvider : TypeDecoderProvider {
	override val valueDecoders: Map<KClass<*>, ValueDecoder<KtExpression>> = mapOf(
		TFClass::class to TFClass.CODEGEN.get(),
		BotSkill::class to BotSkill.CODEGEN.get(),
		BehaviorModifiers::class to BehaviorModifiers.CODEGEN.get(),
		TFBotAttributes::class to TFBotAttributes.CODEGEN.get(),
		NavArea::class to NavArea.CODEGEN.get(),
		Where::class to Where.CODEGEN.get()
	)
	// Subtypes of these are already registered as value decoders for their types through IExtensibleSubtree.Codegen
	override val selfNamedDecoders: Map<KClass<*>, SelfNamedDecoder<KtExpression>> = mapOf(
		AbstractSpawner::class to AbstractSpawner.CODEGEN_NAV.get(),
		AbstractPopulator::class to AbstractPopulator.NAV.get()
	)
}