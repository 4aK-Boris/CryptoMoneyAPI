package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.SellerDTO
import fedotkin.aleksandr.data.mappers.SellerMapper
import fedotkin.aleksandr.data.kstore.CryptoMoneyKStore
import fedotkin.aleksandr.domain.models.SellerModel
import fedotkin.aleksandr.domain.repositories.SellerRepository

class SellerRepositoryImpl(
    private val sellerMapper: SellerMapper,
    private val cryptoMoneyKStore: CryptoMoneyKStore
): SellerRepository {

    override suspend fun getSellerDTOs(sellerModels: List<SellerModel>): List<SellerDTO> {
        return sellerModels.map { sellerModel -> sellerMapper.map(sellerModel = sellerModel) }
    }

    override suspend fun getSellerModels(): List<SellerModel> {
        return cryptoMoneyKStore.getSellers()
    }

    override suspend fun changeMoney(sellerId: Int, money: Int) {
        cryptoMoneyKStore.changeMoneySeller(sellerId = sellerId, money = money)
    }
}
