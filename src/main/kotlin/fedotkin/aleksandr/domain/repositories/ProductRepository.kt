package fedotkin.aleksandr.domain.repositories

import fedotkin.aleksandr.data.dto.ProductDTO
import fedotkin.aleksandr.domain.models.ProductModel

interface ProductRepository {

    suspend fun getProducts(productModels: List<ProductModel>): List<ProductDTO>
}
