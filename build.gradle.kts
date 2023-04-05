val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kgraphql_version: String by project

plugins {
    kotlin("jvm") version "1.8.20"
    id("io.ktor.plugin") version "2.2.4"
}

group = "com.jorbital.jorbichef"
version = "0.0.1"
application {
    mainClass.set("com.jorbital.jorbichef.ApplicationKt")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("com.apurebase:kgraphql:$kgraphql_version")
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}