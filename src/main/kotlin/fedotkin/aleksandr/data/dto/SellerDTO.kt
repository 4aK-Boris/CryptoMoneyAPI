package fedotkin.aleksandr.data.dto

@kotlinx.serialization.Serializable
data class SellerDTO(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val amountOfMoney: Int
)
