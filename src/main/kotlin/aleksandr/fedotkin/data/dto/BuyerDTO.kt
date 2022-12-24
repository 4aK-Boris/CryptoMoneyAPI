package aleksandr.fedotkin.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BuyerDTO(
    val id: Int,
    val nickName: String,
    val imageUrl: String,
    val amountOfMoney: Int
)
