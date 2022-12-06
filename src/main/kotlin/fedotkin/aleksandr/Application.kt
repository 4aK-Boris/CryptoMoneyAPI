package fedotkin.aleksandr

import fedotkin.aleksandr.presentation.plugins.configurePlugins
import fedotkin.aleksandr.presentation.routing.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    configurePlugins()
    configureRouting()
}
