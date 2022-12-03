package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.SellerProductDTO
import fedotkin.aleksandr.data.dto.ProductDTO
import fedotkin.aleksandr.domain.models.ProductModel

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
