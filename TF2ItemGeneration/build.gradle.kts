import org.gradle.kotlin.dsl.kotlin

plugins {
	id("general-convention")
}

group = Constants.Groups.tf2("filegeneration")
version = Constants.PROJECT_VERSION

repositories {
	mavenCentral()
	
	flatDir {
		dir("../libs")
	}
}

dependencies {
	api("com.mojang:datafixerupper:1.0.20")
	
	implementation("btpos.source.vdfdsl.vdf:vdf-parser:${Constants.PROJECT_VERSION}")
	testImplementation(kotlin("test"))
}

val basePackage = Constants.Groups.TF2

buildConfig {
	buildConfigField("String", "OUT_DIR", "\"${gradle.includedBuild("TF2Items").projectDir.toPath().resolve("src/generated/kotlin")}\"")
	
	buildConfigField("String", "BASE_PACKAGE", "\"$basePackage\"")
	
	buildConfigField("String", "ITEM_FACTORY_LOCATION", "\"$basePackage.items.TFItemFactory\"")
	buildConfigField("String", "ATTRIBUTES_TARGET_PACKAGE", "\"$basePackage.itemattributes\"")
	buildConfigField("String", "COSMETICS_TARGET_PACKAGE", "\"$basePackage.items.cosmetics\"")
	buildConfigField("String", "POPFILETEMPLATE_LOCATION", "\"$basePackage.templates.PopFileTemplate\"")
	buildConfigField("String", "POPFILETEMPLATE_CTOR", "\"PopFileTemplate({NAME}, {BASE})\"")
}

//tasks.register<JavaExec>("createTemplates") {
//
//	description = "Generate vanilla popfile templates"
//	workingDir = project.projectDir
//	mainClass = "$basePackage.filegeneration.Main_GenerateTemplateEntriesKt"
////	standardInput = "".byteInputStream() // TODO
//}