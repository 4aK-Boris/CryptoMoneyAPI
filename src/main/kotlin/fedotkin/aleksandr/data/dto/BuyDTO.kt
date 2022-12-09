package fedotkin.aleksandr.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BuyDTO(
    val purchase: PurchaseDTO,
    val card: CardDTO
)
