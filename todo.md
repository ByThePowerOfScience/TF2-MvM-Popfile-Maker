change attribute interfaces to be specifically THEIR attributes, and then add an "inherited" variant that's used for the item scopes, that way people will only see the attributes for a specific type when they do for example BuffItemAttributes.XXX

generate object for templates with parent file ref for populating the `#base x.pop` thing

give VDFSubtrees a reference to their parent so keyvalues can.... 
hm wait no but templates aren't keyvalues, they're just values. 
I don't have values able to traverse the tree atm....

maybe I change it from _vdfRepr to addKeyValue(subtree, key)