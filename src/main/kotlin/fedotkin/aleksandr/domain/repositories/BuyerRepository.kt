package fedotkin.aleksandr.domain.repositories

import fedotkin.aleksandr.data.dto.BuyerDTO
import fedotkin.aleksandr.domain.models.BuyerModel

interface BuyerRepository {

    suspend fun getBuyerDTOs(buyerModels: List<BuyerModel>): List<BuyerDTO>

    suspend fun getBuyerModels(): List<BuyerModel>

    suspend fun getBuyerNickName(buyerId: Int): String
}
