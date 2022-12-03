package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.domain.repositories.PurchaseRepository

class PurchaseUseCase(
    private val purchaseRepository: PurchaseRepository
) {

    suspend fun getSellerPurchases(sellerId: Int): List<SellerPurchaseDTO> {
        return purchaseRepository.getSellerPurchaseDTOs(
            sellerId = sellerId,
            purchaseModels = purchaseRepository.getPurchaseModels()
        )
    }
}
