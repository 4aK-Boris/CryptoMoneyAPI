package fedotkin.aleksandr.domain.repositories

import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.domain.models.PurchaseModel

interface PurchaseRepository {

    suspend fun getPurchaseModels(): List<PurchaseModel>

    suspend fun getSellerPurchaseDTOs(sellerId: Int, purchaseModels: List<PurchaseModel>): List<SellerPurchaseDTO>
}
