package fedotkin.aleksandr.data.dto.set.certificate.buyer

import fedotkin.aleksandr.data.dto.set.Identification
import kotlinx.serialization.Serializable

@Serializable
data class CardCInitResTBS(
    val rrpID: Identification,
    val lidEE: Identification,
    val challEE: Identification,
    val lidCA: Identification?,
    val caeThumb: ByteArray,
    val brandCRLIdentifier: List<ByteArray>,
    val thumbs: List<ByteArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardCInitResTBS

        if (rrpID != other.rrpID) return false
        if (lidEE != other.lidEE) return false
        if (challEE != other.challEE) return false
        if (lidCA != other.lidCA) return false
        if (!caeThumb.contentEquals(other.caeThumb)) return false
        if (brandCRLIdentifier != other.brandCRLIdentifier) return false
        if (thumbs != other.thumbs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rrpID.hashCode()
        result = 31 * result + lidEE.hashCode()
        result = 31 * result + challEE.hashCode()
        result = 31 * result + (lidCA?.hashCode() ?: 0)
        result = 31 * result + caeThumb.contentHashCode()
        result = 31 * result + brandCRLIdentifier.hashCode()
        result = 31 * result + thumbs.hashCode()
        return result
    }
}
