package fedotkin.aleksandr.domain.repositories.set

import fedotkin.aleksandr.domain.models.set.CryptoData
import java.security.PublicKey
import kotlinx.serialization.KSerializer

interface EXHRepository {

    suspend fun <T, P> encrypt(
        r: PublicKey,
        t: T,
        p: P,
        tSerializer: KSerializer<T>,
        pSerializer: KSerializer<P>
    ): CryptoData

    suspend fun <T, P> decrypt(cryptoData: CryptoData): Pair<T, P>
}