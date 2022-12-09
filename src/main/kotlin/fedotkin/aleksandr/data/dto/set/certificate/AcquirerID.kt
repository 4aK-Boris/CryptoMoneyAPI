package fedotkin.aleksandr.data.dto.set.certificate

import kotlinx.serialization.Serializable

@Serializable
data class AcquirerID(
    val acquirerBIN: Long,
    val acquirerBusinessID: LongArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AcquirerID

        if (acquirerBIN != other.acquirerBIN) return false
        if (!acquirerBusinessID.contentEquals(other.acquirerBusinessID)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = acquirerBIN.hashCode()
        result = 31 * result + acquirerBusinessID.contentHashCode()
        return result
    }
}
