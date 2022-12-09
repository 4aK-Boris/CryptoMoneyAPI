package fedotkin.aleksandr.domain.models.set

data class CryptoData(val message: ByteArray, val oaep: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CryptoData

        if (!message.contentEquals(other.message)) return false
        if (!oaep.contentEquals(other.oaep)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = message.contentHashCode()
        result = 31 * result + oaep.contentHashCode()
        return result
    }
}