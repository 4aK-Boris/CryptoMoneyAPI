package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.ProductDTO
import fedotkin.aleksandr.data.repositories.ProductRepositoryImpl
import fedotkin.aleksandr.domain.kstore.CryptoMoneyKStore

class ProductUseCase(
    private val cryptoMoneyKStore: CryptoMoneyKStore,
    private val productRepositoryImpl: ProductRepositoryImpl
) {

    suspend fun getProducts(): List<ProductDTO> {
        val productModels = cryptoMoneyKStore.getProducts()
        return productRepositoryImpl.getProducts(productModels = productModels)
    }
}
