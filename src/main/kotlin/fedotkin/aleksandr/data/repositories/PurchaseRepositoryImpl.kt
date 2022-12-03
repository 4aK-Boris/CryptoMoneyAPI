package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.data.mappers.PurchaseMapper
import fedotkin.aleksandr.data.kstore.CryptoMoneyKStore
import fedotkin.aleksandr.domain.models.PurchaseModel
import fedotkin.aleksandr.domain.repositories.BuyerRepository
import fedotkin.aleksandr.domain.repositories.ProductRepository
import fedotkin.aleksandr.domain.repositories.PurchaseRepository

class PurchaseRepositoryImpl(
    private val cryptoMoneyKStore: CryptoMoneyKStore,
    private val buyerRepository: BuyerRepository,
    private val productRepository: ProductRepository,
    private val purchaseMapper: PurchaseMapper
) : PurchaseRepository {

    override suspend fun getPurchaseModels(): List<PurchaseModel> {
        return cryptoMoneyKStore.getPurchases()
    }

    override suspend fun getSellerPurchaseDTOs(
        sellerId: Int,
        purchaseModels: List<PurchaseModel>
    ): List<SellerPurchaseDTO> {
        return purchaseModels.filter { purchaseModel -> purchaseModel.sellerId == sellerId }.map { purchaseModel ->
            val productModel = productRepository.getProductModel(productId = purchaseModel.productId)
            val buyerNickName = buyerRepository.getBuyerNickName(buyerId = purchaseModel.buyerId)
            purchaseMapper.mapSellerPurchase(
                buyerNickName = buyerNickName, productModel = productModel, count = purchaseModel.count
            )
        }
    }
}
