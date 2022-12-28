object Dependencies {

    object Kotlin {
        const val version = "1.7.22"
        private const val coroutinesVersion = "1.6.4"
        private const val dateTimeVersion = "0.4.0"

        const val jUnit = "org.jetbrains.kotlin:kotlin-test-junit:$version"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
    }

    object BouncyCastle {

        private const val version = "1.72"

        const val bcprov = "org.bouncycastle:bcprov-jdk18on:$version"
        const val bcpkix = "org.bouncycastle:bcpkix-jdk18on:$version"
        const val bcutil = "org.bouncycastle:bcutil-jdk18on:$version"
    }

    object Ktor {

        const val version = "2.2.1"

        const val core = "io.ktor:ktor-server-core-jvm:$version"
        const val callLogging = "io.ktor:ktor-server-call-logging-jvm:$version"
        const val callId = "io.ktor:ktor-server-call-id-jvm:$version"
        const val negotiation = "io.ktor:ktor-server-content-negotiation-jvm:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json-jvm:$version"
        const val netty = "io.ktor:ktor-server-netty-jvm:$version"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val websockets = "io.ktor:ktor-server-websockets:$version"

        const val clientCore = "io.ktor:ktor-client-core:$version"
        const val cio = "io.ktor:ktor-client-cio:$version"
        const val clientSerialization = "io.ktor:ktor-client-serialization:$version"
        const val clientNegotiation = "io.ktor:ktor-client-content-negotiation:$version"

        const val tests = "io.ktor:ktor-server-tests-jvm:$version"
    }

    object Logback {

        private const val version = "1.4.5"
        const val classic = "ch.qos.logback:logback-classic:$version"
    }

    object Koin {

        private const val version = "3.2.2"

        const val di = "io.insert-koin:koin-ktor:$version"
        const val logger = "io.insert-koin:koin-logger-slf4j:$version"
        const val koinJUnit = "io.insert-koin:koin-test-junit4:$version"
    }

    object KStore {

        private const val version = "0.1.1"

        const val kStore = "io.github.xxfast:kstore:$version"
    }

    object Plugins {

        const val jvm = "jvm"
        const val ktor = "io.ktor.plugin"
        const val serialization = "org.jetbrains.kotlin.plugin.serialization"
    }
}
