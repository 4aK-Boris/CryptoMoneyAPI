package fedotkin.aleksandr.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductBuyDTO(
    val buyerId: Int,
    val sellerId: Int,
    val snippetId: Int
)
