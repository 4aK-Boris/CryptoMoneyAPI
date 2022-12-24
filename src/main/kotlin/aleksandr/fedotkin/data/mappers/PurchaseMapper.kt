package aleksandr.fedotkin.data.mappers

import aleksandr.fedotkin.data.dto.PurchaseDTO
import aleksandr.fedotkin.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.domain.models.ProductModel
import aleksandr.fedotkin.domain.models.PurchaseModel

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
