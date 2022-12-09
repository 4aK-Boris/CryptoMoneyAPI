package fedotkin.aleksandr.data.dto.set

import java.security.Key
import kotlinx.serialization.Serializable

@Serializable
data class OAEP<T>(
    val k: Key,
    val hash: ByteArray,
    val p: T
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OAEP<*>

        if (k != other.k) return false
        if (!hash.contentEquals(other.hash)) return false
        if (p != other.p) return false

        return true
    }

    override fun hashCode(): Int {
        var result = k.hashCode()
        result = 31 * result + hash.contentHashCode()
        result = 31 * result + (p?.hashCode() ?: 0)
        return result
    }
}
