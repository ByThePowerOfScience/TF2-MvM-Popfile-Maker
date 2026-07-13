import org.gradle.kotlin.dsl.kotlin

plugins {
	id("general-convention")
}

group = Constants.Groups.tf2("filegeneration")
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	
	flatDir {
		dir("../libs")
	}
}

dependencies {
	api("com.mojang:datafixerupper:1.0.20")
	
	implementation("btpos.source.vdfdsl.vdf:vdf-parser:1.0-SNAPSHOT")
	testImplementation(kotlin("test"))
}

val basePackage = Constants.Groups.TF2

buildConfig {
	buildConfigField("String", "OUT_DIR", "\"${gradle.includedBuild("TF2Items").projectDir.toPath().resolve("src/generated/kotlin")}\"")
	
	buildConfigField("String", "BASE_PACKAGE", "\"$basePackage\"")
	
	buildConfigField("String", "ITEM_FACTORY_LOCATION", "\"$basePackage.items.TFItemFactory\"")
	buildConfigField("String", "ATTRIBUTES_TARGET_PACKAGE", "\"$basePackage.attributes\"")
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