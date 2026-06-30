plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "PopFileDSL"
include("ItemAttributesGeneration")
include("Extensions:TF2ItemAttributes")
includeBuild("vdf-modeling")
includeBuild("VDFParser")