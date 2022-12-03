package fedotkin.aleksandr.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class KStoreModel(
    val buyers: List<BuyerModel>,
    val sellers: List<SellerModel>,
    val products: List<ProductModel>,
    val purchases: List<PurchaseModel>
)
