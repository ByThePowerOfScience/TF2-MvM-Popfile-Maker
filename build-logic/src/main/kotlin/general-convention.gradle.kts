import org.gradle.kotlin.dsl.kotlin

plugins {
	kotlin("jvm")
	id("com.github.gmazzo.buildconfig")
}

kotlin {
	jvmToolchain(21)
	
	compilerOptions {
		freeCompilerArgs.set(listOf("-Xcontext-parameters"))
	}
}

repositories {
	maven(url="https://libraries.minecraft.net")
}

dependencies {
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}