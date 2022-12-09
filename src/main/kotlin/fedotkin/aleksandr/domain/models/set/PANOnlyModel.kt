package fedotkin.aleksandr.domain.models.set

import fedotkin.aleksandr.domain.core.Model
import java.math.BigInteger

data class PANOnlyModel(
    val pan: BigInteger,
    val exNonce: BigInteger
) : Model