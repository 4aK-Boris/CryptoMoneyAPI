package aleksandr.fedotkin.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class SellerModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    var amountOfMoney: Int
)
