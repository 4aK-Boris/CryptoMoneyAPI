package aleksandr.fedotkin.data.repositories

import aleksandr.fedotkin.data.dto.BuyDTO
import aleksandr.fedotkin.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.data.mappers.PurchaseMapper
import aleksandr.fedotkin.data.kstore.CryptoMoneyKStore
import aleksandr.fedotkin.data.mappers.BuyMapper
import aleksandr.fedotkin.domain.models.BuyModel
import aleksandr.fedotkin.domain.models.PurchaseModel
import aleksandr.fedotkin.domain.repositories.BuyerRepository
import aleksandr.fedotkin.domain.repositories.ProductRepository
import aleksandr.fedotkin.domain.repositories.PurchaseRepository
import aleksandr.fedotkin.domain.repositories.SellerRepository

class PurchaseRepositoryImpl(
    private val cryptoMoneyKStore: CryptoMoneyKStore,
    private val buyerRepository: BuyerRepository,
    private val productRepository: ProductRepository,
    private val sellerRepository: SellerRepository,
    private val purchaseMapper: PurchaseMapper,
    private val buyMapper: BuyMapper
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

    override suspend fun getBuyModel(buyDTO: BuyDTO): BuyModel {
        return buyMapper.map(buyDTO = buyDTO)
    }

    override suspend fun savePurchase(purchaseModel: PurchaseModel) {
        cryptoMoneyKStore.savePurchase(purchaseModel = purchaseModel)
        val productPrice = productRepository.getProductPrice(productId = purchaseModel.productId)
        val productCount = purchaseModel.count
        productRepository.changeCount(productId = purchaseModel.productId, count = productCount)
        buyerRepository.changeMoney(buyerId = purchaseModel.buyerId, money = productPrice * productCount)
        sellerRepository.changeMoney(sellerId = purchaseModel.sellerId, money = productPrice * productCount)
    }
}
