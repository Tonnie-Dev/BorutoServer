val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val koinVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
}

group = "com.uxstate"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // Koin for Ktor
    implementation("io.insert-koin:koin-ktor:$koinVersion")
    // SLF4J Logger
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
    //adds the standard Server and Date headers into each response.
    implementation("io.ktor:ktor-server-default-headers:$ktorVersion")

    //status pages
    implementation("io.ktor:ktor-server-status-pages:$ktorVersion")


    //testing
    //testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
    //testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")


    //new dependencies
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")


}