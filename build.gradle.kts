plugins {
    application
    kotlin(Dependencies.Plugins.jvm) version Dependencies.Kotlin.version
    id(Dependencies.Plugins.ktor) version Dependencies.Ktor.version
    id(Dependencies.Plugins.serialization) version Dependencies.Kotlin.version
}

group = "aleksandr.fedotkin"
version = "0.0.1"
application {
    mainClass.set("aleksandr.fedotkin.ApplicationKt")

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
    implementation(Dependencies.Ktor.websockets)

    implementation(Dependencies.Ktor.clientCore)
    implementation(Dependencies.Ktor.cio)
    implementation(Dependencies.Ktor.clientSerialization)
    implementation(Dependencies.Ktor.clientNegotiation)
    implementation(Dependencies.Ktor.json)

    implementation(Dependencies.Koin.di)
    implementation(Dependencies.Koin.logger)

    implementation(Dependencies.KStore.kStore)

    implementation(Dependencies.Logback.classic)

    implementation(Dependencies.Kotlin.coroutines)
    implementation(Dependencies.Kotlin.dateTime)

    implementation(Dependencies.BouncyCastle.bcprov)
    implementation(Dependencies.BouncyCastle.bcpkix)
    implementation(Dependencies.BouncyCastle.bcutil)

    implementation(project(":SetProtocol"))

    testImplementation(Dependencies.Ktor.tests)

    testImplementation(Dependencies.Kotlin.jUnit)
}
