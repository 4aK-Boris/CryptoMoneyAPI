package fedotkin.aleksandr

import fedotkin.aleksandr.presentation.plugins.configurePlugins
import fedotkin.aleksandr.presentation.routing.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

private const val PORT = 8080
private const val HOST = "localhost"

fun main() {
    embeddedServer(Netty, port = PORT, host = HOST, module = Application::module).start(wait = true)
}

fun Application.module() {
    configurePlugins()
    configureRouting()
}
