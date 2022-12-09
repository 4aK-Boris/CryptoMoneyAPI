package fedotkin.aleksandr.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class BuyerModel(
    val id: Int,
    val nickName: String,
    val imageUrl: String,
    var amountOfMoney: Int
)
