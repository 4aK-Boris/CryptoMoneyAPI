package fedotkin.aleksandr.data.dto.set.certificate

enum class PaymentSystem {
    VISA, MASTERCARD, MIR;

    override fun toString(): String {
        return "${this.name}:CryptoMoney"
    }
}