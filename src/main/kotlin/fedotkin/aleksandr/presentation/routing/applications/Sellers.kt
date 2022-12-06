package fedotkin.aleksandr.presentation.routing.applications

import fedotkin.aleksandr.data.dto.SellerTitleDTO
import fedotkin.aleksandr.domain.usecases.SellerUseCase
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.util.reflect.TypeInfo
import org.koin.ktor.ext.inject

fun Application.configureSellers() {

    val sellerUseCase by inject<SellerUseCase>()

    routing {
        get("/sellers") {
            call.respond(sellerUseCase.getSellers())
        }

        get("/seller") {
            call.parameters["seller_id"]?.let { sellerId ->
                call.respond(sellerUseCase.getSeller(sellerId = sellerId.toInt()))
            } ?: call.respond(
                status = HttpStatusCode.InternalServerError,
                message = null,
                messageType = TypeInfo(type = SellerTitleDTO::class, reifiedType = SellerTitleDTO::class.java)
            )
        }
    }
}
