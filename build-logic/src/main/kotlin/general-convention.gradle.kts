import org.gradle.kotlin.dsl.getValue
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmExtension

plugins {
	kotlin("jvm")
	id("com.github.gmazzo.buildconfig")
	id("publishing-convention")
}

val kotlin: KotlinJvmExtension get() = extensions.getByType()

kotlin {
	jvmToolchain(21)
	
	compilerOptions {
		freeCompilerArgs.set(listOf("-Xcontext-parameters", "-Xreturn-value-checker=check"))
	}
}

java {
	withSourcesJar()
	withJavadocJar()
}

repositories {
	maven(url="https://libraries.minecraft.net")
	maven(url="https://jitpack.io")
}

dependencies {
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}