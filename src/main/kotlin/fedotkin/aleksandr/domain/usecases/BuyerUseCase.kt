package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.BuyerDTO
import fedotkin.aleksandr.data.repositories.BuyerRepositoryImpl
import fedotkin.aleksandr.domain.kstore.CryptoMoneyKStore

class BuyerUseCase(
    private val cryptoMoneyKStore: CryptoMoneyKStore,
    private val buyerRepositoryImpl: BuyerRepositoryImpl
) {

    suspend fun getBuyers(): List<BuyerDTO> {
        val buyerModels = cryptoMoneyKStore.getBuyers()
        return buyerRepositoryImpl.getBuyers(buyerModels = buyerModels)
    }
}
