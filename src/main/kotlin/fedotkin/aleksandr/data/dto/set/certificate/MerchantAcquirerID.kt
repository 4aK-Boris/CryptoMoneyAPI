package fedotkin.aleksandr.data.dto.set.certificate

import kotlinx.serialization.Serializable

@Serializable
data class MerchantAcquirerID(
    val merchantBIN: Long,
    val merchantID: Long
)
