package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.BuyerDTO
import fedotkin.aleksandr.data.mappers.BuyerMapper
import fedotkin.aleksandr.data.kstore.CryptoMoneyKStore
import fedotkin.aleksandr.domain.models.BuyerModel
import fedotkin.aleksandr.domain.repositories.BuyerRepository

class BuyerRepositoryImpl(
    private val buyerMapper: BuyerMapper,
    private val cryptoMoneyKStore: CryptoMoneyKStore
) : BuyerRepository {

    override suspend fun getBuyerDTOs(buyerModels: List<BuyerModel>): List<BuyerDTO> {
        return buyerModels.map { buyerModel -> buyerMapper.map(buyerModel = buyerModel) }
    }

    override suspend fun getBuyerModels(): List<BuyerModel> {
        return cryptoMoneyKStore.getBuyers()
    }

    override suspend fun getBuyerNickName(buyerId: Int): String {
        return getBuyerModels().first { buyerModel -> buyerModel.id == buyerId }.nickName
    }

    override suspend fun changeMoney(buyerId: Int, money: Int) {
        cryptoMoneyKStore.changeMoneyBuyer(buyerId = buyerId, money = money)
    }
}
