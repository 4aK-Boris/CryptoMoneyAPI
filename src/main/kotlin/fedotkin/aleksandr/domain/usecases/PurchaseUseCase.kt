package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.BuyDTO
import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.domain.models.BuyModel
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

    suspend fun getBuyModel(buyDTO: BuyDTO): BuyModel {
        return purchaseRepository.getBuyModel(buyDTO = buyDTO)
    }

    suspend fun buy(buyModel: BuyModel) {
        purchaseRepository.savePurchase(purchaseModel = buyModel.purchase)
    }
}
