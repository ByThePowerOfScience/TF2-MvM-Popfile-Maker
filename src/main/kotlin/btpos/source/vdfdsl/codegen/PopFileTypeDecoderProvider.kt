package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.spawners.TFBotSpawner
import kotlin.reflect.KClass

class PopFileTypeDecoderProvider : TypeDecoderProvider {
	override val valueDecoders: Map<KClass<*>, ValueDecoder<KtExpression>> = mapOf(
		TFClass::class to TFClass.CODEGEN.get(),
		BotSkill::class to BotSkill.CODEGEN.get(),
		BehaviorModifiers::class to BehaviorModifiers.CODEGEN.get(),
		TFBotAttributes::class to TFBotAttributes.CODEGEN.get()
	)
	
	override val selfNamedDecoders: Map<KClass<*>, SelfNamedDecoder<KtExpression>> = mapOf(
		TFBotSpawner::class to TFBotSpawner.CODEGEN_SELF.get(),
		AbstractSpawner::class to AbstractSpawner.CODEGEN_NAV.get()
	)
}