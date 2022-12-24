package aleksandr.fedotkin.domain.repositories

import aleksandr.fedotkin.data.dto.SellerProductDTO
import aleksandr.fedotkin.data.dto.ProductDTO
import aleksandr.fedotkin.domain.models.ProductModel

interface ProductRepository {

    suspend fun getProductDTOs(productModels: List<ProductModel>): List<ProductDTO>

    suspend fun getProductModels(): List<ProductModel>

    suspend fun getSellerProductDTOs(sellerId: Int, sellerProductModels: List<ProductModel>): List<SellerProductDTO>

    suspend fun getProductModel(productId: Int): ProductModel

    suspend fun changeCount(productId: Int, count: Int)

    suspend fun getProductPrice(productId: Int): Int
}
