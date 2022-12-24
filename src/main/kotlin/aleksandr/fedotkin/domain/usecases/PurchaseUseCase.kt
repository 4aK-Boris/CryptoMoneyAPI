package aleksandr.fedotkin.domain.usecases

import aleksandr.fedotkin.data.dto.BuyDTO
import aleksandr.fedotkin.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.domain.models.BuyModel
import aleksandr.fedotkin.domain.repositories.PurchaseRepository

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
