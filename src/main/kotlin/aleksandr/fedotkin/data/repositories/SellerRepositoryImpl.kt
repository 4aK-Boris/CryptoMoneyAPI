package aleksandr.fedotkin.data.repositories

import aleksandr.fedotkin.data.dto.SellerDTO
import aleksandr.fedotkin.data.dto.SellerTitleDTO
import aleksandr.fedotkin.data.mappers.SellerMapper
import aleksandr.fedotkin.data.kstore.CryptoMoneyKStore
import aleksandr.fedotkin.domain.models.SellerModel
import aleksandr.fedotkin.domain.repositories.SellerRepository

class SellerRepositoryImpl(
    private val sellerMapper: SellerMapper,
    private val cryptoMoneyKStore: CryptoMoneyKStore
) : SellerRepository {

    override suspend fun getSellerDTOs(sellerModels: List<SellerModel>): List<SellerDTO> {
        return sellerModels.map { sellerModel -> sellerMapper.map(sellerModel = sellerModel) }
    }

    override suspend fun getSellerModels(): List<SellerModel> {
        return cryptoMoneyKStore.getSellers()
    }

    override suspend fun changeMoney(sellerId: Int, money: Int) {
        cryptoMoneyKStore.changeMoneySeller(sellerId = sellerId, money = money)
    }

    override suspend fun getSellerTitle(sellerId: Int): SellerTitleDTO {
        return sellerMapper.mapSellerTitle(sellerModel = getSellerModel(sellerId = sellerId))
    }

    private suspend fun getSellerModel(sellerId: Int): SellerModel {
        return getSellerModels().first { sellerModel -> sellerModel.id == sellerId }
    }
}
