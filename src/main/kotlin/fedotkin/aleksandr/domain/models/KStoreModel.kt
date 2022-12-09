package fedotkin.aleksandr.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class KStoreModel(
    val buyers: MutableList<BuyerModel>,
    val sellers: MutableList<SellerModel>,
    val products: MutableList<ProductModel>,
    val purchases: MutableList<PurchaseModel>
)
