import org.gradle.internal.impldep.org.apache.http.client.methods.RequestBuilder.options
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.targets.js.npm.importedPackageDir
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
	id("com.github.gmazzo.buildconfig") version "6.0.10"
}

group = "btpos.source.vdfdsl.tf2.assetgeneration"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	maven(url="https://libraries.minecraft.net")
	
}

dependencies {
	api("com.mojang:datafixerupper:1.0.20")
	
	implementation(project(":VDFParser"))
	testImplementation(kotlin("test"))
}

buildConfig {
	buildConfigField("String", "OUT_DIR", "\"${project(":Extensions:TF2ItemAttributes").projectDir.toPath().resolve("src/generated/kotlin")}\"")
	
	buildConfigField("String", "BASE_PACKAGE", rootProject.group.toString() + "\".tf2\"")
	
	buildConfigField("String", "ITEM_FACTORY_LOCATION", "\"items.TFItemFactory\"")
	buildConfigField("String", "ATTRIBUTES_TARGET_PACKAGE", "\"attributes\"")
	buildConfigField("String", "COSMETICS_TARGET_PACKAGE", "\"items.cosmetics\"")
}

kotlin {
	jvmToolchain(21)
}


tasks.test {
	useJUnitPlatform()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.compilerOptions {
	freeCompilerArgs.set(listOf("-Xcontext-parameters"))
}