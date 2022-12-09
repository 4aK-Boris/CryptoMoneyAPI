package fedotkin.aleksandr.data.repositories.set

import fedotkin.aleksandr.data.mappers.set.JsonMapper
import fedotkin.aleksandr.domain.repositories.set.MessageDigestRepository
import java.security.MessageDigest
import kotlinx.serialization.KSerializer

class MessageDigestRepositoryImpl(
    private val messageDigest: MessageDigest,
    private val jsonMapper: JsonMapper
) : MessageDigestRepository {
    override suspend fun <T> messageDigest(data: T, serializer: KSerializer<T>): ByteArray {
        val byteArrayData = jsonMapper.objectToByteArray(serializer = serializer, data = data)
        return messageDigest.digest(byteArrayData)
    }

    override suspend fun <T> verifyMessageDigest(data: T, serializer: KSerializer<T>, array: ByteArray): Boolean {
        val byteArrayData = jsonMapper.objectToByteArray(serializer = serializer, data = data)
        return byteArrayData == array
    }
}