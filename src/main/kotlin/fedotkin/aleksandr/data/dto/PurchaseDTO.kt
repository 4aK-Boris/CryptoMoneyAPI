package fedotkin.aleksandr.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseDTO(
    val buyerId: Int,
    val sellerId: Int,
    val productId: Int,
    val count: Int
)
