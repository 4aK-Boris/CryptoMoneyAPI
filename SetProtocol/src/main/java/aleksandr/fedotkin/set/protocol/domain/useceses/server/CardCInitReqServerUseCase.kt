package aleksandr.fedotkin.set.protocol.domain.useceses.server

import aleksandr.fedotkin.set.protocol.core.usecase.BaseServerRequestUseCase
import aleksandr.fedotkin.set.protocol.data.dto.certificate.card.c.init.req.CardCInitReq
import aleksandr.fedotkin.set.protocol.domain.models.certificate.card.c.init.req.CardCInitReqModel
import aleksandr.fedotkin.set.protocol.domain.models.general.MessageWrapperModel
import aleksandr.fedotkin.set.protocol.domain.repositories.certificate.card.c.init.req.CardCInitReqRepository
import java.math.BigInteger
import java.security.PrivateKey
import java.security.PublicKey

class CardCInitReqServerUseCase(
    cardCInitReqRepository: CardCInitReqRepository,
    override val publicKey: PublicKey,
    override val privateKey: PrivateKey
) : BaseServerRequestUseCase<CardCInitReqModel, CardCInitReq>() {

    override val repository = cardCInitReqRepository

    override lateinit var rrpid: BigInteger

    override lateinit var messageWrapperModel: MessageWrapperModel<CardCInitReqModel>

    override lateinit var sendMessage: suspend (String) -> Unit

    suspend fun processingMessage(json: String): MessageWrapperModel<CardCInitReqModel> {
        messageWrapperModel = convertFromString(json = json)
        rrpid = messageWrapperModel.messageModel.rrpID
        checkRRPID(rrpid = messageWrapperModel.messageModel.rrpID)
        return messageWrapperModel
    }
}
