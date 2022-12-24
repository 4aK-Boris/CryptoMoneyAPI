package aleksandr.fedotkin.domain.repositories

import aleksandr.fedotkin.data.dto.BuyerDTO
import aleksandr.fedotkin.domain.models.BuyerModel

interface BuyerRepository {

    suspend fun getBuyerDTOs(buyerModels: List<BuyerModel>): List<BuyerDTO>

    suspend fun getBuyerModels(): List<BuyerModel>

    suspend fun getBuyerNickName(buyerId: Int): String

    suspend fun changeMoney(buyerId: Int, money: Int)
}
