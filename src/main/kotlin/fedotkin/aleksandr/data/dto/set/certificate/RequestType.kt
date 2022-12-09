package fedotkin.aleksandr.data.dto.set.certificate

enum class RequestType(val type: Int) {
    SELLER_ONLY_SIGNATURE_CERTIFICATE_INITIAL(type = 4),
    SELLER_ONLY_ENCRYPTION_CERTIFICATE_INITIAL(type = 5),
    SELLER_ALL_INITIAL(type = 6),
    SELLER_ONLY_SIGNATURE_CERTIFICATE_UPDATE(type = 13),
    SELLER_ONLY_ENCRYPTION_CERTIFICATE_UPDATE(type = 14),
    SELLER_ALL_UPDATE(type = 15),
    SETTLEMENT_CENTER_ONLY_SIGNATURE_CERTIFICATE_INITIAL(type = 7),
    SETTLEMENT_CENTER_ONLY_ENCRYPTION_CERTIFICATE_INITIAL(type = 8),
    SETTLEMENT_CENTER_ALL_INITIAL(type = 9),
    SETTLEMENT_CENTER_ONLY_SIGNATURE_CERTIFICATE_UPDATE(type = 16),
    SETTLEMENT_CENTER_ONLY_ENCRYPTION_CERTIFICATE_UPDATE(type = 17),
    SETTLEMENT_CENTER_ALL_UPDATE(type = 18)
}