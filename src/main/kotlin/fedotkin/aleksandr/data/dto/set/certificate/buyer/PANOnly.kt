package fedotkin.aleksandr.data.dto.set.certificate.buyer

import fedotkin.aleksandr.data.core.DTO
import kotlinx.serialization.Serializable

@Serializable
data class PANOnly(
    val pan: String,
    val exNonce: String
): DTO
