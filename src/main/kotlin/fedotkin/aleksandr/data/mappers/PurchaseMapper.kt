package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.domain.models.ProductModel

class PurchaseMapper {

    fun mapSellerPurchase(
        buyerNickName: String,
        productModel: ProductModel,
        count: Int
    ): SellerPurchaseDTO {
        return SellerPurchaseDTO(
            count = count,
            price = productModel.price,
            titleProduct = productModel.title,
            buyerNickName = buyerNickName
        )
    }
}
