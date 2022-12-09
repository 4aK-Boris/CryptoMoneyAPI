package fedotkin.aleksandr.data.dto.set.certificate

import kotlinx.serialization.Serializable

@Serializable
data class MeAqCInitResTBS(
    val rrpID: Long,
    val lidEE: Long,
    val challEE: Long,
    val lidCA: LongArray,
    val challCA: Long,
    val requestType: RequestType,
    val regFormOrReferral: RegFormOrReferral,
    val acctDataField: BooleanArray,
    val thumbs: Array<ByteArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MeAqCInitResTBS

        if (rrpID != other.rrpID) return false
        if (lidEE != other.lidEE) return false
        if (challEE != other.challEE) return false
        if (!lidCA.contentEquals(other.lidCA)) return false
        if (challCA != other.challCA) return false
        if (requestType != other.requestType) return false
        if (regFormOrReferral != other.regFormOrReferral) return false
        if (!acctDataField.contentEquals(other.acctDataField)) return false
        if (!thumbs.contentDeepEquals(other.thumbs)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rrpID.hashCode()
        result = 31 * result + lidEE.hashCode()
        result = 31 * result + challEE.hashCode()
        result = 31 * result + lidCA.contentHashCode()
        result = 31 * result + challCA.hashCode()
        result = 31 * result + requestType.hashCode()
        result = 31 * result + regFormOrReferral.hashCode()
        result = 31 * result + acctDataField.contentHashCode()
        result = 31 * result + thumbs.contentDeepHashCode()
        return result
    }
}
