package fedotkin.aleksandr.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductModel(
    val id: Int,
    val imageUrl: String,
    val title: String,
    var quantity: Int,
    val rating: Double,
    val price: Int,
    val sellerId: Int
)
