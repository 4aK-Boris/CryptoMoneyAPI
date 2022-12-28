package aleksandr.fedotkin.set.protocol.domain.useceses.client

import aleksandr.fedotkin.set.protocol.core.usecase.BaseClientRequestUseCase
import aleksandr.fedotkin.set.protocol.data.dto.certificate.card.c.init.req.CardCInitReq
import aleksandr.fedotkin.set.protocol.data.network.SetNetworkAPI
import aleksandr.fedotkin.set.protocol.domain.models.certificate.card.c.init.req.CardCInitReqModel
import aleksandr.fedotkin.set.protocol.domain.models.general.MessageWrapperModel
import aleksandr.fedotkin.set.protocol.domain.repositories.certificate.card.c.init.req.CardCInitReqRepository
import java.math.BigInteger
import java.security.PrivateKey
import java.security.PublicKey

class CardCInitReqClientUseCase(
    override val repository : CardCInitReqRepository,
    override val publicKey: PublicKey,
    override val privateKey: PrivateKey
) : BaseClientRequestUseCase<CardCInitReqModel, CardCInitReq>() {

    override lateinit var messageWrapperModel: MessageWrapperModel<CardCInitReqModel>

    override var rrpid: BigInteger = generateNewNumber()
    override suspend fun sendError(json: String) {
        networkAPI.sendError(json = json)
    }

    override suspend fun sendMessage(json: String): String {
        return networkAPI.sendCardCInit(json = json)
    }

    suspend fun createAndSend(): String {
        messageWrapperModel = createMessageWrapperModel(model = repository.createCardCInitReqModel(rrpid))
        return send()
    }
}
