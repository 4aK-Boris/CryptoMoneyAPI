package aleksandr.fedotkin.presentation.routing.applications

import aleksandr.fedotkin.domain.usecases.BuyerUseCase
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureBuyers() {

    val buyerUseCase by inject<BuyerUseCase>()

    routing {
        get("/buyers") {
            call.respond(buyerUseCase.getBuyers())
        }
    }

}
