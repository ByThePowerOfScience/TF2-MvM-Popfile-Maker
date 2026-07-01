import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("general-convention")
}

group = Constants.Groups.tf2("itemattributes")
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("btpos.source.vdfdsl.vdf:vdf-modeling:1.0-SNAPSHOT")
	
	testImplementation(platform("org.junit:junit-bom:6.0.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

sourceSets.main {
	kotlin.srcDir("src/generated/kotlin")
}

sourceSets.create("file-generation")

tasks.test {
	useJUnitPlatform()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.compilerOptions {
	freeCompilerArgs.set(listOf("-XXLanguage:+ContextParameters"))
}