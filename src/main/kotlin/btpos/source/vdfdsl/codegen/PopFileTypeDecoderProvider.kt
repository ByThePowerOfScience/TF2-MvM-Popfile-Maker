package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import kotlin.reflect.KClass

class PopFileTypeDecoderProvider : TypeDecoderProvider {
	override val typeDecoders: Map<KClass<*>, Decoder<KtExpression>>
		get() = mapOf(
			TFClass::class to TFClass.CODEGEN.get(),
			BotSkill::class to BotSkill.CODEGEN.get(),
			BehaviorModifiers::class to BehaviorModifiers.CODEGEN.get(),
			TFBotAttributes::class to TFBotAttributes.CODEGEN.get(),
		)
	
	override val subtypeNavigation: Map<KClass<*>, StructSubclassNavigator>
		get() = mapOf(
			AbstractSpawner::class to AbstractSpawner.NAV.get(),
		)
}