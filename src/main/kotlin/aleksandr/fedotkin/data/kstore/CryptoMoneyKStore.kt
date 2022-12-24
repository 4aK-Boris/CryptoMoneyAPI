package aleksandr.fedotkin.data.kstore

import aleksandr.fedotkin.domain.models.BuyerModel
import aleksandr.fedotkin.domain.models.KStoreModel
import aleksandr.fedotkin.domain.models.ProductModel
import aleksandr.fedotkin.domain.models.PurchaseModel
import aleksandr.fedotkin.domain.models.SellerModel
import aleksandr.fedotkin.presentation.exceptions.KStoreException
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storeOf

class CryptoMoneyKStore {

    private val store: KStore<KStoreModel> by lazy { storeOf(filePath = "data.json") }

    private suspend fun getKStoreModel(): KStoreModel {
        return store.get() ?: throw KStoreException()
    }

    suspend fun getProducts(): List<ProductModel> {
        return getKStoreModel().products
    }

    suspend fun getBuyers(): List<BuyerModel> {
        return getKStoreModel().buyers
    }

    suspend fun getSellers(): List<SellerModel> {
        return getKStoreModel().sellers
    }

    suspend fun getPurchases(): List<PurchaseModel> {
        return getKStoreModel().purchases
    }

    suspend fun changeMoneyBuyer(buyerId: Int, money: Int) {
        store.update { kStoreModel ->
            kStoreModel?.buyers?.indexOfFirst { it.id == buyerId }?.let { index ->
                kStoreModel.buyers[index].amountOfMoney -= money
            }
            kStoreModel
        }
    }

    suspend fun changeCount(productId: Int, count: Int) {
        store.update { kStoreModel ->
            kStoreModel?.products?.indexOfFirst { it.id == productId }?.let { index ->
                kStoreModel.products[index].quantity -= count
            }
            kStoreModel
        }
    }

    suspend fun changeMoneySeller(sellerId: Int, money: Int) {
        store.update { kStoreModel ->
            kStoreModel?.sellers?.indexOfFirst { it.id == sellerId }?.let { index ->
                kStoreModel.sellers[index].amountOfMoney += money
            }
            kStoreModel
        }
    }

    suspend fun savePurchase(purchaseModel: PurchaseModel) {
        store.update { kStoreModel ->
            kStoreModel?.purchases?.add(purchaseModel)
            kStoreModel
        }
    }
}
