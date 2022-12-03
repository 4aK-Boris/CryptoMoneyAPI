package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.BuyerDTO
import fedotkin.aleksandr.data.mappers.BuyerMapper
import fedotkin.aleksandr.domain.models.BuyerModel
import fedotkin.aleksandr.domain.repositories.BuyerRepository

class BuyerRepositoryImpl(private val buyerMapper: BuyerMapper): BuyerRepository {

    override suspend fun getBuyers(buyerModels: List<BuyerModel>): List<BuyerDTO> {
        return buyerModels.map { buyerModel -> buyerMapper.map(buyerModel = buyerModel) }
    }
}
