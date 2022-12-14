package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.BuyDTO
import fedotkin.aleksandr.data.dto.SellerPurchaseDTO
import fedotkin.aleksandr.data.kstore.CryptoMoneyKStore
import fedotkin.aleksandr.data.mappers.BuyMapper
import fedotkin.aleksandr.data.mappers.PurchaseMapper
import fedotkin.aleksandr.domain.models.BuyModel
import fedotkin.aleksandr.domain.models.PurchaseModel
import fedotkin.aleksandr.domain.repositories.BuyerRepository
import fedotkin.aleksandr.domain.repositories.ProductRepository
import fedotkin.aleksandr.domain.repositories.PurchaseRepository
import fedotkin.aleksandr.domain.repositories.SellerRepository
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.delay

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
        createLogs()
    }

    private suspend fun createLogs() {
        printMessage(message = "???????????? ???????????? CardCInitReq")
        printMessage(message = "???????????? ?????????? CardCInitRes")
        delay(DELAY)
        printMessage(message = "???????????? ???????????? RegFormReq")
        printMessage(message = "???????????? ?????????? RegFormRes")
        delay(DELAY)
        printMessage(message = "???????????? ???????????? CertReq")
        printMessage(message = "???????????? ?????????? CertRes")
        printMessage(message = "???????????????????? ?????????? ????????????????????")
        delay(DELAY)
        printMessage(message = "???????????? ???????????? Me-AqCInitReq")
        printMessage(message = "???????????? ?????????? Me-AqCInitRes")
        delay(DELAY)
        printMessage(message = "???????????? ???????????? CertReq")
        printMessage(message = "???????????? ?????????? CertRes")
        printMessage(message = "???????????????? ???????????? ??????????????????????")
        delay(DELAY)
        printMessage(message = "?????????????? ???????????? ??????????????")
    }

    private fun printMessage(message: String) {
        println("SetProtocol ${getTime()} -> $message")
    }

    private fun getTime(): String {
        return LocalTime.now().format(formatter)
    }

    companion object {
        private const val DELAY = 500L
        private val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    }
}
