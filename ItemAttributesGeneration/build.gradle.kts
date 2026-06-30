import org.gradle.internal.impldep.org.apache.http.client.methods.RequestBuilder.options
import org.jetbrains.kotlin.gradle.targets.js.npm.importedPackageDir
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
	id("com.github.gmazzo.buildconfig") version "6.0.10"
}

group = "btpos.source.vdfdsl.itemattributesgenerator"
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
	buildConfigField("String", "TARGET_PACKAGE", "\"btpos.source.vdfdsl.tf2.itemattributes\"")
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