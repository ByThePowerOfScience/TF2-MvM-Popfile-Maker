package btpos.source.vdfdsl.tf2.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtGetValueExpression
import btpos.misc.kt.codegen.identifiers.KtMemberReference
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.identifiers.KtObjectReference
import btpos.misc.kt.codegen.util.ReflectionUtils.declaredMemberPropertiesGettable
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.ConstantsFinder
import btpos.source.vdfdsl.codegen.SelfNamedDecoder
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.orElse
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.tf2.itemattributes.*
import btpos.source.vdfdsl.tf2.items.PaintColors
import btpos.source.vdfdsl.tf2.items.PaintColors.intToColor
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.items.TFItemFactories
import btpos.source.vdfdsl.tf2.items.TFItemFactory
import btpos.source.vdfdsl.tf2.items.cosmetics.Cosmetics
import btpos.source.vdfdsl.tf2.items.weapons.MannpowerPowerups
import btpos.source.vdfdsl.tf2.items.weapons.Weapons
import btpos.source.vdfdsl.tf2.templates.PopFileTemplate
import btpos.source.vdfdsl.tf2.templates.RobotGatebotTemplates
import btpos.source.vdfdsl.tf2.templates.RobotGiantTemplates
import btpos.source.vdfdsl.tf2.templates.RobotStandardTemplates
import btpos.misc.kt.codegen.util.ReflectionUtils.actuallyGet
import java.awt.Color
import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class TF2ItemsTypeDecoderProvider : TypeDecoderProvider {
	override val valueDecoders: Map<KClass<*>, ValueDecoder<KtExpression>> = java.util.Map.of(
		Color::class, PaintColors.CODEGEN.get().orElse { value, _ ->
			value.asPrimitive?.stringValue
				?.toIntOrNull()
				?.let { intToColor(it) }
				?.let { listOf(
					KtFunctionCall(
						KtName("Color", "java.awt"),
						mutableListOf(
							Codegen.code(it.red.toString()),
							Codegen.code(it.blue.toString()),
							Codegen.code(it.green.toString()))))
				}
		},
		PopFileTemplate::class, PopFileTemplate.CODEGEN.get(),
		IAttributeContainer::class, IAttributeContainer.CODEGEN_TYPE.get(),
		TFItem::class, TFItem.CODEGEN.get()
	)
	
	override val selfNamedDecoders: Map<KClass<*>, SelfNamedDecoder<KtExpression>> = java.util.Map.of(
		TFItem::class, TFItem.CODEGEN.get() // handles ItemAttribute blocks from further up the chain
	)
	
	
	init {
		TFItem.CODEGEN.applyToContained { codegen ->
			// all properties are on the top level in these objects so whatever this is fine
			arrayOf(
				Weapons::class,
				Cosmetics::class,
				MannpowerPowerups::class
			).forEach {
				val getItsInstance = KtObjectReference(it)
				ConstantsFinder(it, TFItem::class) { _, property, objectInstance ->
					val item = (property.javaGetter?.invoke(objectInstance)
					            ?: property.javaField!!.get(objectInstance)) as TFItem<*>
					codegen.itemNameToTFItemInstance[item.namePrimitive] = KtGetValueExpression(KtMemberReference(KtName(property.name)), getItsInstance)
				}
			}
		}
		
		
		PopFileTemplate.CODEGEN.applyToContained {
			it.decoders += RobotStandardTemplates.CODEGEN.get()
			it.decoders += RobotGiantTemplates.CODEGEN.get()
			it.decoders += RobotGatebotTemplates.CODEGEN.get()
		}
		
		
		IAttributeContainer.CODEGEN_ATTRS.applyToContained { codegen ->
			// I generate a property in TFItemFactories for every XAttributes.Inherited class, so this should be fine for now
			val itemFactory = TFItemFactory::class
			TFItemFactories::class.declaredMemberPropertiesGettable().forEach {
				if (it.returnType.classifier == itemFactory)
					codegen.instancesToCheck += (it.actuallyGet(TFItemFactories) as TFItemFactory<Any>).scope
			}
			
			codegen.extensionProperties += arrayOf(
				FlamethrowerAttributes::flameParticles,
				SMGAttributes::canHeadshot,
				LunchboxAttributes::lunchType,
				KnifeAttributes::knifeType,
				SniperRifleAttributes::rifleType,
				StickybombLauncherAttributes::detonationType,
				GrenadeLauncherAttributes::bombsShatterOnSurfaces,
				FistsAttributes::fistsType,
				FistsAttributes::fistsHaveRadialBuff
			)
		}
	}
}