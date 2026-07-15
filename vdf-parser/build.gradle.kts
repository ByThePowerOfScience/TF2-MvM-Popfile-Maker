import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
	id("general-convention")
	alias(libs.plugins.shadow)
}

group = "btpos.source.vdfdsl.vdf"
version = Constants.PROJECT_VERSION

repositories {
	mavenCentral()
	maven(url="https://libraries.minecraft.net")
	
	flatDir {
		dir("../libs")
	}
}

dependencies {
	// Source: https://mvnrepository.com/artifact/org.antlr/antlr4-runtime
	shadow("org.antlr:antlr4-runtime:4.13.2")
	api("btpos.source.vdfdsl.vdf:vdf-modeling:${Constants.PROJECT_VERSION}")
}




configurations {
	implementation.extendsFrom(shadow)
}

tasks.shadowJar {
	relocate("org.antlr", project.group.toString() + "impldep.org.antlr")
}

sourceSets.main {
	java.srcDir("src/generated/java")
}