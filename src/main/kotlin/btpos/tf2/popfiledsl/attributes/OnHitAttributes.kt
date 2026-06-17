package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.KeyValueMapImpl
import btpos.tf2.popfiledsl.modeling.delegate
import btpos.tf2.popfiledsl.serialization.VDFStringLiteral.Companion.literal


class OnHitFoeScope(attr: KeyValueMapImpl) {
	// I use context parameters so you can reference them as a namespaced `OnHitFoe.MARK_FOR_DEATH = true`
	// instead of an un-namepaced "this.MARK_FOR_DEATH = true" where everything from every category is visible at once
	var MARK_FOR_DEATH: Boolean? by attr.delegate("mark_for_death".literal())
	
	var STUN_MIDAIR_ENEMIES: Boolean? by attr.delegate("mod stun waist high airborne".literal())
}

