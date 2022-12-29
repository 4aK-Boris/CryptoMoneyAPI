package fedotkin.aleksandr.presentation.routing.applications

import fedotkin.aleksandr.core.SELLER_ID
import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.domain.usecases.NotificationUseCase
import fedotkin.aleksandr.domain.usecases.PurchaseUseCase
import io.ktor.client.HttpClient
import io.ktor.client.request.get
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
import kotlin.random.Random

fun Application.configurePurchases() {

    val purchasesUseCase by inject<PurchaseUseCase>()
    val notificationUseCase by inject<NotificationUseCase>()

    val client by inject<HttpClient>()

    var code: Int = Random.nextInt(from = 100000, until = 999999)

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

        get("/code") {
            code = Random.nextInt(from = 100000, until = 999999)
            notificationUseCase.sendCode(code = code, apiKeyBuyer = apiKeyBuyer)
            call.respond(true)
        }

        post ("/checkCode") {
            val newCode = call.receive<Int>()
            call.respond(newCode == code)
        }

        get("/check") {
            client.get("http://127.0.0.1:8081/check")
            call.respond("OK")
        }
    }
}


