import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
	maven {
		name = "Clojars"
		url = uri("https://repo.clojars.org/")
	}
}

fun PluginDependency.asDep(): String {
	return "${pluginId}:${pluginId}.gradle.plugin:${version}"
}

dependencies {
	val kotlin = libs.plugins.kotlin.jvm.get()

	implementation(kotlin.asDep())

	val buildconfig = libs.plugins.buildconfig.get()
	implementation(buildconfig.asDep())
	
	
	val vanniktech = libs.plugins.vanniktech.get()
	implementation(vanniktech.asDep())
	
	implementation("org.jetbrains.kotlin.plugin.assignment:org.jetbrains.kotlin.plugin.assignment.gradle.plugin:${libs.versions.kotlin.get()}")
//	val clojure = libs.plugins.clojure.get()
//	implementation("${clojure.pluginId}:${clojure.pluginId}.gradle.plugin:${clojure.version}")
//
}