package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.ProductDTO
import fedotkin.aleksandr.data.mappers.ProductMapper
import fedotkin.aleksandr.domain.models.ProductModel
import fedotkin.aleksandr.domain.repositories.ProductRepository

class ProductRepositoryImpl(
    private val productMapper: ProductMapper
) : ProductRepository {
    override suspend fun getProducts(productModels: List<ProductModel>): List<ProductDTO> {
        return productModels.map { productModel -> productMapper.map(productModel = productModel) }
    }

}
