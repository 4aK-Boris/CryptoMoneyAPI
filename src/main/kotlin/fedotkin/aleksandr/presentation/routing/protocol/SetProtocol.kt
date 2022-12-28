package fedotkin.aleksandr.presentation.routing.protocol

import aleksandr.fedotkin.set.protocol.core.CARD_C_INIT
import aleksandr.fedotkin.set.protocol.domain.useceses.server.CardCInitReqServerUseCase
import aleksandr.fedotkin.set.protocol.domain.useceses.server.CardCInitResServerUseCase
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receiveText
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureSetProtocol() {

    val cardCInitReqUseCase: CardCInitReqServerUseCase by inject()
    val cardCInitResUseCase: CardCInitResServerUseCase by inject()

    routing {
        get(CARD_C_INIT) {
            cardCInitReqUseCase.sendMessage = { json ->
                call.respondText(text = json)
            }
            cardCInitResUseCase.sendMessage = { json ->
                call.respondText(text = json)
            }
            cardCInitResUseCase.createAndSend(cardCInitReqUseCase.processingMessage(json = call.receiveText()))
        }
    }

}
