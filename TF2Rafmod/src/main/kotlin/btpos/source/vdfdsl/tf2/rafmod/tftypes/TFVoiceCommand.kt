package btpos.source.vdfdsl.tf2.rafmod.tftypes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

class TFVoiceCommand(override val _vdfRepr: VDFPrimitive) : IVDFRepresentableValue_Trivial {
	constructor(name: String) : this(VDFPrimitive.Companion(name))
	
	companion object {
		@JvmField val MEDIC = TFVoiceCommand("MEDIC")
		@JvmField val THANKS = TFVoiceCommand("Thanks")
		@JvmField val GO_GO_GO = TFVoiceCommand("Go Go Go")
		@JvmField val MOVE_UP = TFVoiceCommand("Move Up")
		@JvmField val GO_LEFT = TFVoiceCommand("Go Left")
		@JvmField val GO_RIGHT = TFVoiceCommand("Go Right")
		@JvmField val YES = TFVoiceCommand("Yes")
		@JvmField val NO = TFVoiceCommand("No")
		@JvmField val PASS_TO_ME = TFVoiceCommand("Pass to me")
		@JvmField val INCOMING = TFVoiceCommand("Incoming")
		@JvmField val SPY = TFVoiceCommand("Spy")
		@JvmField val SENTRY_AHEAD = TFVoiceCommand("Sentry Ahead")
		@JvmField val TELEPORTER_HERE = TFVoiceCommand("Teleporter Here")
		@JvmField val DISPENSER_HERE = TFVoiceCommand("Dispenser Here")
		@JvmField val SENTRY_HERE = TFVoiceCommand("Sentry Here")
		@JvmField val ACTIVATE_UBERCHARGE = TFVoiceCommand("Activate ÜberCharge")
		@JvmField val UBERCHARGE_READY = TFVoiceCommand("MEDIC: ÜberCharge Ready")
		@JvmField val HELP = TFVoiceCommand("Help")
		@JvmField val BATTLE_CRY = TFVoiceCommand("Battle Cry")
		@JvmField val CHEERS = TFVoiceCommand("Cheers")
		@JvmField val JEERS = TFVoiceCommand("Jeers")
		@JvmField val POSITIVE = TFVoiceCommand("Positive")
		@JvmField val NEGATIVE = TFVoiceCommand("Negative")
		@JvmField val NICE_SHOT = TFVoiceCommand("Nice Shot")
		@JvmField val GOOD_JOB = TFVoiceCommand("Good Job")
	}
}