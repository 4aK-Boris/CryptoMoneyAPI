package aleksandr.fedotkin.domain.repositories

import aleksandr.fedotkin.data.dto.BuyDTO
import aleksandr.fedotkin.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.domain.models.BuyModel
import aleksandr.fedotkin.domain.models.PurchaseModel

interface PurchaseRepository {

    suspend fun getPurchaseModels(): List<PurchaseModel>

    suspend fun getSellerPurchaseDTOs(sellerId: Int, purchaseModels: List<PurchaseModel>): List<SellerPurchaseDTO>

    suspend fun getBuyModel(buyDTO: BuyDTO): BuyModel

    suspend fun savePurchase(purchaseModel: PurchaseModel)
}
