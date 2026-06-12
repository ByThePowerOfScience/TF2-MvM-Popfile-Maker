package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.modeling.KeyValueMapImpl
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileMap

class ItemAttributesContainer(private val attrs: KeyValueMapImpl = KeyValueMapImpl())
	: IKeyValueMap by attrs, IPopFileSerializable<PopFileMap> by attrs

class WeaponAttributesContainer(private val attrs: KeyValueMapImpl = KeyValueMapImpl())
	: IKeyValueMap by attrs, IPopFileSerializable<PopFileMap> by attrs

class CharacterAttributesContainer(private val attrs: KeyValueMapImpl = KeyValueMapImpl())
	: IKeyValueMap by attrs, IPopFileSerializable<PopFileMap> by attrs

