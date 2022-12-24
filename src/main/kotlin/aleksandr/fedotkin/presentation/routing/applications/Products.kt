package aleksandr.fedotkin.presentation.routing.applications

import aleksandr.fedotkin.core.SELLER_ID
import aleksandr.fedotkin.data.dto.SellerProductDTO
import aleksandr.fedotkin.domain.usecases.ProductUseCase
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.util.reflect.TypeInfo
import org.koin.ktor.ext.inject

fun Application.configureProducts() {

    val productUseCase by inject<ProductUseCase>()

    routing {

        get("/products") {
            call.respond(productUseCase.getProducts())
        }

        get("/sellerProducts") {
            call.parameters[SELLER_ID]?.let { stringId ->
                val sellerId = stringId.toInt()
                call.respond(productUseCase.getSellerProducts(sellerId = sellerId))
            } ?: call.respond(
                status = HttpStatusCode.BadRequest,
                message = null,
                messageType = TypeInfo(type = SellerProductDTO::class, reifiedType = SellerProductDTO::class.java)
            )
        }
    }
}
