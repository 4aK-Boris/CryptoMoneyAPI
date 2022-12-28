package aleksandr.fedotkin.set.protocol.core.usecase

import aleksandr.fedotkin.set.protocol.core.DTO
import aleksandr.fedotkin.set.protocol.core.Model
import aleksandr.fedotkin.set.protocol.data.network.SetNetworkAPI

//class TestUseCase(
//    private val networkAPI: SetNetworkAPI
//): BaseUseCase<Model, DTO, Model, Model>() {
//
//    override lateinit var messageWrapperModel: Model
//
//    override val url: String
//        get() = "dwa"
//
//    override suspend fun networkSend(json: String): String {
//        return networkAPI.sendCardCInit(messageWrapperJson = json)
//    }
//}