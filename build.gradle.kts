plugins {
    application
    kotlin(Dependencies.Plugins.jvm) version Dependencies.Kotlin.version
    id(Dependencies.Plugins.ktor) version Dependencies.Ktor.version
    id(Dependencies.Plugins.serialization) version Dependencies.Kotlin.version
}

group = "fedotkin.aleksandr"
version = "0.0.1"
application {
    mainClass.set("fedotkin.aleksandr.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Ktor.core)
    implementation(Dependencies.Ktor.callLogging)
    implementation(Dependencies.Ktor.callId)
    implementation(Dependencies.Ktor.negotiation)
    implementation(Dependencies.Ktor.serialization)
    implementation(Dependencies.Ktor.netty)

    implementation(Dependencies.Koin.di)
    implementation(Dependencies.Koin.logger)

    implementation(Dependencies.KStore.kstore)

    implementation(Dependencies.Logback.classic)

    implementation(Dependencies.Kotlin.coroutines)

    testImplementation(Dependencies.Ktor.tests)

    testImplementation(Dependencies.Kotlin.jUnit)
}
