package fedotkin.aleksandr.data.dto.set.certificate.buyer

import fedotkin.aleksandr.data.dto.set.Identification
import kotlinx.serialization.Serializable

@Serializable
data class CardCInitReq(
    val rrpID: Identification,
    val lidEE: Identification,
    val challEE: Identification,
    val brandID: String,
    val thumbs: List<ByteArray>
)
