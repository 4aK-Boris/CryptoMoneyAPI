package aleksandr.fedotkin.set.protocol.core.usecase

import aleksandr.fedotkin.set.protocol.core.DTO
import aleksandr.fedotkin.set.protocol.core.Model

abstract class BaseServerResponseUseCase<T: Model, R: DTO>: BaseSetUseCase<T, R>()  {

    abstract var sendMessage: suspend (String) -> Unit

    protected suspend fun send() {
        sendError(json)
    }

    override suspend fun sendError(json: String) {
        sendMessage(json)
    }
}