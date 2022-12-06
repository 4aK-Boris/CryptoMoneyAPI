package fedotkin.aleksandr.presentation.routing.applications

import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.domain.usecases.NotificationUseCase
import fedotkin.aleksandr.domain.usecases.PurchaseUseCase
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import io.ktor.util.reflect.TypeInfo
import org.koin.ktor.ext.inject

fun Application.configurePurchases() {

    val purchasesUseCase by inject<PurchaseUseCase>()
    val notificationUseCase by inject<NotificationUseCase>()

    val apiKeySeller = environment.config.property(path = "onesignal.api_key_seller").getString()
    val apiKeyBuyer = environment.config.property(path = "onesignal.api_key_buyer").getString()

    routing {
        get("/sellerPurchases") {
            call.parameters["sellerId"]?.let { stringId ->
                val sellerId = stringId.toInt()
                call.respond(purchasesUseCase.getSellerPurchases(sellerId = sellerId))
            } ?: call.respond(
                status = HttpStatusCode.BadRequest,
                message = null,
                messageType = TypeInfo(type = SellerPurchaseDTO::class, reifiedType = SellerPurchaseDTO::class.java)
            )
        }

        post("/purchase") {
            val buyModel = purchasesUseCase.getBuyModel(buyDTO = call.receive())
            purchasesUseCase.buy(buyModel = buyModel)
            notificationUseCase.sendNotification(
                productId = buyModel.purchase.productId,
                apiKeySeller = apiKeySeller,
                apiKeyBuyer = apiKeyBuyer
            )
        }
    }
}
