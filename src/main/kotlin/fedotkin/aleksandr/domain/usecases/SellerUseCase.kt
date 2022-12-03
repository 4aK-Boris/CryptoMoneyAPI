package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.SellerDTO
import fedotkin.aleksandr.data.repositories.SellerRepositoryImpl
import fedotkin.aleksandr.domain.kstore.CryptoMoneyKStore

class SellerUseCase(
    private val cryptoMoneyKStore: CryptoMoneyKStore,
    private val sellerRepositoryImpl: SellerRepositoryImpl
) {

    suspend fun getSellers(): List<SellerDTO> {
        val sellerModels = cryptoMoneyKStore.getSellers()
        return sellerRepositoryImpl.getSellers(sellerModels = sellerModels)
    }
}
