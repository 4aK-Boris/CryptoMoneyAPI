package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.PurchaseDTO
import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.domain.models.ProductModel
import fedotkin.aleksandr.domain.models.PurchaseModel

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

    fun map(purchaseDTO: PurchaseDTO): PurchaseModel {
        return PurchaseModel(
            buyerId = purchaseDTO.buyerId,
            sellerId = purchaseDTO.sellerId,
            productId = purchaseDTO.productId,
            count = purchaseDTO.count
        )
    }
}
