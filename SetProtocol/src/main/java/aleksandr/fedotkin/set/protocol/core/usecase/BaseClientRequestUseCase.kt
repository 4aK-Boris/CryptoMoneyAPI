package aleksandr.fedotkin.set.protocol.core.usecase

import aleksandr.fedotkin.set.protocol.core.DTO
import aleksandr.fedotkin.set.protocol.core.Model
import aleksandr.fedotkin.set.protocol.data.network.SetNetworkAPI
import org.koin.core.component.inject

abstract class BaseClientRequestUseCase<T: Model, R: DTO>: BaseSetUseCase<T, R>() {

    protected val networkAPI by inject<SetNetworkAPI>()

    abstract suspend fun sendMessage(json: String): String

    protected suspend fun send(): String {
        return sendMessage(json)
    }
    override suspend fun sendError(json: String) {
        networkAPI.sendError(json = json)
    }
}