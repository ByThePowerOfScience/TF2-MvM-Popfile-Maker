package btpos.tf2.popfiledsl.attributes

import btpos.tf2.popfiledsl.modeling.IKeyValueMap
import btpos.tf2.popfiledsl.modeling.KeyValueMapImpl
import btpos.tf2.popfiledsl.serialization.IVDFSerializableValue
import btpos.tf2.popfiledsl.serialization.VDFSubtree

class ItemAttributesContainer(private val attrs: KeyValueMapImpl = KeyValueMapImpl())
	: IKeyValueMap by attrs, IVDFSerializableValue<VDFSubtree> by attrs

class WeaponAttributesContainer(private val attrs: KeyValueMapImpl = KeyValueMapImpl())
	: IKeyValueMap by attrs, IVDFSerializableValue<VDFSubtree> by attrs

class CharacterAttributesContainer(private val attrs: KeyValueMapImpl = KeyValueMapImpl())
	: IKeyValueMap by attrs, IVDFSerializableValue<VDFSubtree> by attrs

