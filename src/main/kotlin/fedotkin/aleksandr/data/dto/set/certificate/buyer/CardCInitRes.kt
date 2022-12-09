package fedotkin.aleksandr.data.dto.set.certificate.buyer

import kotlinx.serialization.Serializable

@Serializable
data class CardCInitRes(
    val ca: ByteArray,
    val cardCInitResTBS: CardCInitResTBS
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardCInitRes

        if (!ca.contentEquals(other.ca)) return false
        if (cardCInitResTBS != other.cardCInitResTBS) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ca.contentHashCode()
        result = 31 * result + cardCInitResTBS.hashCode()
        return result
    }
}
