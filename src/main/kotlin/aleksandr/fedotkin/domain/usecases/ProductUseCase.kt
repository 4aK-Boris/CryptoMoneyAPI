package aleksandr.fedotkin.domain.usecases

import aleksandr.fedotkin.data.dto.SellerProductDTO
import aleksandr.fedotkin.data.dto.ProductDTO
import aleksandr.fedotkin.domain.repositories.ProductRepository

class ProductUseCase(
    private val productRepository: ProductRepository
) {

    suspend fun getProducts(): List<ProductDTO> {
        return productRepository.getProductDTOs(productModels = productRepository.getProductModels())
    }

    suspend fun getSellerProducts(sellerId: Int): List<SellerProductDTO> {
        return productRepository.getSellerProductDTOs(
            sellerId = sellerId,
            sellerProductModels = productRepository.getProductModels()
        )
    }
}
