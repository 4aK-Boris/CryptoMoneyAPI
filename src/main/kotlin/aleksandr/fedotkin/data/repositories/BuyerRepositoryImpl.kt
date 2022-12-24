package aleksandr.fedotkin.data.repositories

import aleksandr.fedotkin.data.dto.BuyerDTO
import aleksandr.fedotkin.data.mappers.BuyerMapper
import aleksandr.fedotkin.data.kstore.CryptoMoneyKStore
import aleksandr.fedotkin.domain.models.BuyerModel
import aleksandr.fedotkin.domain.repositories.BuyerRepository

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
