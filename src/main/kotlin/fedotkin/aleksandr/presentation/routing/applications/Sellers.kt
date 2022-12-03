package fedotkin.aleksandr.presentation.routing.applications

import fedotkin.aleksandr.domain.usecases.SellerUseCase
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureSellers() {

    val sellerUseCase by inject<SellerUseCase>()

    routing {
        get("/sellers") {
            call.respond(sellerUseCase.getSellers())
        }
    }
}
