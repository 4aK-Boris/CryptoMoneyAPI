package fedotkin.aleksandr.data.repositories.set

import fedotkin.aleksandr.data.dto.set.OAEP
import fedotkin.aleksandr.data.mappers.set.JsonMapper
import fedotkin.aleksandr.data.mappers.set.OAEPMapper
import fedotkin.aleksandr.domain.models.set.CryptoData
import fedotkin.aleksandr.domain.models.set.OAEPModel
import fedotkin.aleksandr.domain.models.set.PANOnlyModel
import fedotkin.aleksandr.domain.repositories.set.CipherRepository
import fedotkin.aleksandr.domain.repositories.set.EXHRepository
import fedotkin.aleksandr.domain.repositories.set.KeyRepository
import fedotkin.aleksandr.domain.repositories.set.MessageDigestRepository
import java.security.PublicKey
import kotlinx.serialization.KSerializer

class EXHRepositoryImpl(
    private val jsonMapper: JsonMapper,
    private val cipherRepository: CipherRepository,
    private val keyRepository: KeyRepository,
    private val messageDigestRepository: MessageDigestRepository,
    private val map: (PANOnlyModel) -> P
): EXHRepository {

    override suspend fun <T, P> encrypt(
        r: PublicKey,
        t: T,
        p: P,
        tSerializer: KSerializer<T>,
        pSerializer: KSerializer<P>
    ): CryptoData {
        val tArray = jsonMapper.objectToByteArray(data = t, serializer = tSerializer)
        val pArray = jsonMapper.objectToByteArray(data = p, serializer = pSerializer)
        val array = tArray + pArray
        val key = keyRepository.generateKey()
        val cryptoArray = cipherRepository.symmetricEncrypt(data = array, key = key)
        val hash = messageDigestRepository.messageDigest(data = t, serializer = tSerializer)
        val oaep = OAEP(k = key, hash = hash, p = p)
        val oaepModel = oaepMapper.map<OAEP<P>, OAEPModel<P>>(oaep = oaep, mapper)
        val oaepArray = jsonMapper.objectToByteArray(data = oaep)
        return CryptoData(byteArrayOf(), byteArrayOf())
    }

    override suspend fun <T, P> decrypt(cryptoData: CryptoData): Pair<T, P> {
        TODO("Not yet implemented")
    }
}