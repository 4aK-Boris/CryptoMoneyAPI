package fedotkin.aleksandr.data.kstore

import fedotkin.aleksandr.domain.models.BuyerModel
import fedotkin.aleksandr.domain.models.KStoreModel
import fedotkin.aleksandr.domain.models.ProductModel
import fedotkin.aleksandr.domain.models.PurchaseModel
import fedotkin.aleksandr.domain.models.SellerModel
import fedotkin.aleksandr.presentation.exceptions.KStoreException
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
}
