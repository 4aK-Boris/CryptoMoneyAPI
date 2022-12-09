package fedotkin.aleksandr.data.dto.set.certificate

import kotlinx.serialization.Serializable

@Serializable
data class IDData(
    val merchantAcquirerID: MerchantAcquirerID,
    val acquirerID: AcquirerID
)
