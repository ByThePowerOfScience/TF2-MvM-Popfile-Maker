This is designed to be fully extensible, so you can easily create mappings for whatever plugins or mods you're using.

Here's how to do it:

# Adding Struct Fields
For any class that extends `AbstractMvMStruct`, you can add new fields in the exact same way *I* added new fields inside the class.

1. Create a namespace with the `object` keyword. This is what your items will be stored under.
2. Define your extension properties (extra fields on a class type) with the `var SomeClass.myCustomItem: ItemType` syntax.
3. Use one of the property delegates in [IExtensibleSubtree](vdf-modeling/src/main/kotlin/btpos/source/vdfdsl/modeling/IExtensibleSubtree.kt) with the `by` syntax. (e.g. `var SomeClass.myCustomItem: String? by addField("MyCustomItem")`)

Example:
```kotlin
object MyMissionExtensions {
	// This will be serialized as `NameUsedInPopFile <value>`
	var MissionPopulator.myCustomItem: Int? by addField("NameUsedInPopFile")
}
```

# Adding New Types

NOTE: All classes in this project are designed to be fully copyable without any issues.  To support this, **EVERY FIELD YOU ADD MUST BE IMMUTABLE**.

```kotlin
// we have _subtree in the constructor with a default value so we can make a copy of ourselves in `copy()`
class CustomMissionParameters(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) 
    : AbstractMvMStruct(_subtree) 
{
    override fun copy(): CustomMissionParameters { // <-- Should always be overridden to return a new instance of the current class
		return CustomMissionParameters(copyInternal())
	}
    
    var myField: String? by addField("MyField")
    
    // For things that name themselves, like "TFBot" telling the game that the subtree is a bot:
    var selfNamedThing: ComplexThing? by selfNamed()
    
    var multipleSelfNamedThings: List<ComplexThing> by selfNamedList()
    
    
    // Values must be serializable, meaning they can only be strings, numbers, booleans, or things that implement IVDFRepresentableValue.
    // For things that aren't one of those, you can add a serializer to turn it INTO one of those.
    
    var myList: List<String>? by addField("MyList", serializer=Serializers.flatListWithKey())
    
    // (You can also add a default value so it's not nullable:
    // var myList: List<String> by addField("MyList", serializer=Serializers.flatListWithKey(), defaultValue={ emptyList() })
    
    // NOTE: ALL VALUES MUST BE **IMMUTABLE**.
    // i.e. DON'T DO THIS!!! If it's mutable, any changes to it will also change any copies of this created with CustomMissionParameters.copy().
    val multipleThingsMutable: MutableList<Thing> by addField("MultipleThings", serializer=Serializers.flatListWithKey(), defaultValue={ mutableListOf() }) 
}
```


# Enum entries
Anything that's supposed to have an "enumerable" number of values is instead implemented as a class for extensibility.

To add new entries, save a new instance the same way it's done there:

```kotlin
// Standard:
class BotSkill(val name: String) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object {
		val Easy = BotSkill("Easy")
		val Normal = BotSkill("Normal")
		val Hard = BotSkill("Hard")
		val Expert = BotSkill("Expert")
	}
}

// You can add your own like this:
object CustomBotSkills {
	val LemonDifficult = BotSkill("DifficultDifficultLemonDifficult")
}

TFBot {
	skill = CustomBotSkills.LemonDifficult
}
```