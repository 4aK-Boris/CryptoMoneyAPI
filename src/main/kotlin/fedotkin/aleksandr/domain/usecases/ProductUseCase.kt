package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.SellerProductDTO
import fedotkin.aleksandr.data.dto.ProductDTO
import fedotkin.aleksandr.domain.repositories.ProductRepository

class ProductUseCase(
    private val productRepository: ProductRepository
) {

    suspend fun getProducts(): List<ProductDTO> {
        return productRepository.getProductDTOs(productModels = productRepository.getProductModels())
    }

    suspend fun getProduct(productId: Int): ProductDTO {
        return productRepository.getProductDTO(productId = productId)
    }

    suspend fun getSellerProducts(sellerId: Int): List<SellerProductDTO> {
        return productRepository.getSellerProductDTOs(
            sellerId = sellerId,
            sellerProductModels = productRepository.getProductModels()
        )
    }
}
