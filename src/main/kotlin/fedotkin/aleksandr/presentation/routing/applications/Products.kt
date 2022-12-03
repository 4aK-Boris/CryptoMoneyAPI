package fedotkin.aleksandr.presentation.routing.applications

import fedotkin.aleksandr.domain.usecases.ProductUseCase
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureProducts() {

    val productUseCase by inject<ProductUseCase>()

    routing {
        get("/products") {
            call.respond(productUseCase.getProducts())
        }
    }
}
