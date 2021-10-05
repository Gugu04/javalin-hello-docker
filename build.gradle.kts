import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "mx.javalinDocker"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:4.0.0")
    implementation("org.slf4j:slf4j-simple:1.7.32")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes("Main-Class" to "MainKt")
    }
    from(configurations.runtimeClasspath.get().filter {
        it.name.endsWith("jar") }.map { zipTree(it) })
    {
        exclude("META-INF/INDEX.LIST",
            "META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
    }
}

application {
    mainClass.set("MainKt")
}