package aleksandr.fedotkin.data.mappers

import aleksandr.fedotkin.data.dto.SellerProductDTO
import aleksandr.fedotkin.data.dto.ProductDTO
import aleksandr.fedotkin.domain.models.ProductModel

class ProductMapper {

    fun map(productModel: ProductModel): ProductDTO {
        return ProductDTO(
            id = productModel.id,
            imageUrl = productModel.imageUrl,
            title = productModel.title,
            quantity = productModel.quantity,
            rating = productModel.rating,
            price = productModel.price,
            sellerId = productModel.sellerId
        )
    }

    fun mapSellerProduct(productModel: ProductModel): SellerProductDTO {
        return SellerProductDTO(
            id = productModel.id,
            imageUrl = productModel.imageUrl,
            title = productModel.title,
            quantity = productModel.quantity,
            rating = productModel.rating,
            price = productModel.price,
        )
    }
}
