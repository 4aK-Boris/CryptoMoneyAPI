package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.SellerProductDTO
import fedotkin.aleksandr.data.dto.ProductDTO
import fedotkin.aleksandr.data.mappers.ProductMapper
import fedotkin.aleksandr.data.kstore.CryptoMoneyKStore
import fedotkin.aleksandr.domain.models.ProductModel
import fedotkin.aleksandr.domain.repositories.ProductRepository

class ProductRepositoryImpl(
    private val productMapper: ProductMapper,
    private val cryptoMoneyKStore: CryptoMoneyKStore
) : ProductRepository {

    override suspend fun getProductDTOs(productModels: List<ProductModel>): List<ProductDTO> {
        return productModels.map { productModel -> productMapper.map(productModel = productModel) }
    }

    override suspend fun getProductModels(): List<ProductModel> {
        return cryptoMoneyKStore.getProducts()
    }

    override suspend fun getSellerProductDTOs(
        sellerId: Int,
        sellerProductModels: List<ProductModel>
    ): List<SellerProductDTO> {
        return sellerProductModels.filter { productModel -> productModel.sellerId == sellerId }
            .map { productModel -> productMapper.mapSellerProduct(productModel = productModel) }
    }

    override suspend fun getProductModel(productId: Int): ProductModel {
        return getProductModels().first { productModel -> productModel.id == productId }
    }

}
