package fedotkin.aleksandr.presentation.plugins

import io.ktor.server.application.Application

fun Application.configurePlugins() {
    configureKoin()
    configureMonitoring()
    configureSerialization()
}
