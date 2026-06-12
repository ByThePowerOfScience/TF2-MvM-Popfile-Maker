This is designed to be fully extensible, so you can easily create mappings for whatever plugins or mods you're using.

Here's how to do it:

# Adding Struct Fields
For any class that extends `AbstractMvMStruct`, you can add new fields in the exact same way *I* added new fields inside the class.

1. Create a namespace with the `object` keyword. This is what your items will be stored under.
2. Define your extension properties (extra fields on a class type) with the `var SomeClass.myCustomItem: ItemType` syntax.
3. Use one of the property delegates in IMvMMap with the `by` syntax. (e.g. `var SomeClass.myCustomItem: String? by )

Example:
```kotlin
object MyMissionExtensions {
	// This will be serialized as `MyCustomItem 0`
	var MissionPopulator.myCustomItem: Int by addField("NameUsedInPopFile")
    
    
    class CustomMissionParameters : AbstractMvMStruct() {
		
	}
}
```


# Enum entries
Anything that's supposed to have an "enumerable" number of values is instead implemented as a class.

To add new entries, 