package fedotkin.aleksandr.domain.repositories

import fedotkin.aleksandr.data.dto.BuyerDTO
import fedotkin.aleksandr.domain.models.BuyerModel

interface BuyerRepository {

    suspend fun getBuyers(buyerModels: List<BuyerModel>): List<BuyerDTO>
}
