import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
}

dependencies {
	val kotlin = libs.plugins.kotlin.jvm.get()

	implementation("${kotlin.pluginId}:${kotlin.pluginId}.gradle.plugin:${kotlin.version}")

	val buildconfig = libs.plugins.buildconfig.get()
	implementation("${buildconfig.pluginId}:${buildconfig.pluginId}.gradle.plugin:${buildconfig.version}")
}