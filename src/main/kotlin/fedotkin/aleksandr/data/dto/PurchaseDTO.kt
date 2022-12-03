package fedotkin.aleksandr.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseDTO(
    val productDTO: ProductBuyDTO,
    val bankCardDTO: BankCardDTO
)
