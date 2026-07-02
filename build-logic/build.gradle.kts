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

dependencies {
	val kotlin = libs.plugins.kotlin.jvm.get()

	implementation("${kotlin.pluginId}:${kotlin.pluginId}.gradle.plugin:${kotlin.version}")

	val buildconfig = libs.plugins.buildconfig.get()
	implementation("${buildconfig.pluginId}:${buildconfig.pluginId}.gradle.plugin:${buildconfig.version}")
	
	
	val clojure = libs.plugins.clojure.get()
	implementation("${clojure.pluginId}:${clojure.pluginId}.gradle.plugin:${clojure.version}")
	
}