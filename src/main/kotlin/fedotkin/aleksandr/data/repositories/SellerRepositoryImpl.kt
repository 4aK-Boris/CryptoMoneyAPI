package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.SellerDTO
import fedotkin.aleksandr.data.mappers.SellerMapper
import fedotkin.aleksandr.domain.models.SellerModel
import fedotkin.aleksandr.domain.repositories.SellerRepository

class SellerRepositoryImpl(private val sellerMapper: SellerMapper): SellerRepository {
    override suspend fun getSellers(sellerModels: List<SellerModel>): List<SellerDTO> {
        return sellerModels.map { sellerModel -> sellerMapper.map(sellerModel = sellerModel) }
    }
}
