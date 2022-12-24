package aleksandr.fedotkin.presentation.routing.applications

import aleksandr.fedotkin.core.SELLER_ID
import aleksandr.fedotkin.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.domain.usecases.NotificationUseCase
import aleksandr.fedotkin.domain.usecases.PurchaseUseCase
import io.ktor.client.HttpClient
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

    val client by inject<HttpClient>()

    val apiKeySeller = environment.config.property(path = "onesignal.api_key_seller").getString()
    val apiKeyBuyer = environment.config.property(path = "onesignal.api_key_buyer").getString()

    routing {
        get("/sellerPurchases") {
            call.parameters[SELLER_ID]?.let { stringId ->
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
            call.respond(message = true)
        }
    }
}


