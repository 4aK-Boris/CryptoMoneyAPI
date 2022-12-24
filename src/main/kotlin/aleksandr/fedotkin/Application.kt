package aleksandr.fedotkin

import aleksandr.fedotkin.presentation.plugins.configurePlugins
import aleksandr.fedotkin.presentation.routing.configureRouting
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
