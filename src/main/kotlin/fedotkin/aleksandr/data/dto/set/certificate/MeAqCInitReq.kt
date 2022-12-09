package fedotkin.aleksandr.data.dto.set.certificate

import fedotkin.aleksandr.data.dto.set.Language
import kotlinx.serialization.Serializable

@Serializable
data class MeAqCInitReq(
    val rrpID: Long,
    val lidEE: Long,
    val challEE: Long,
    val requestType: RequestType,
    val idData: IDData,
    val brandID: Long,
    val language: Language,
    val thumbs: Array<ByteArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MeAqCInitReq

        if (rrpID != other.rrpID) return false
        if (lidEE != other.lidEE) return false
        if (challEE != other.challEE) return false
        if (requestType != other.requestType) return false
        if (idData != other.idData) return false
        if (brandID != other.brandID) return false
        if (language != other.language) return false
        if (!thumbs.contentDeepEquals(other.thumbs)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rrpID.hashCode()
        result = 31 * result + lidEE.hashCode()
        result = 31 * result + challEE.hashCode()
        result = 31 * result + requestType.hashCode()
        result = 31 * result + idData.hashCode()
        result = 31 * result + brandID.hashCode()
        result = 31 * result + language.hashCode()
        result = 31 * result + thumbs.contentDeepHashCode()
        return result
    }
}
