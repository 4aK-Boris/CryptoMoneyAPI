package fedotkin.aleksandr.data.dto

@kotlinx.serialization.Serializable
data class SellerPurchaseDTO(
    val count: Int,
    val price: Int,
    val titleProduct: String,
    val buyerNickName: String
)
