package fedotkin.aleksandr.domain.repositories.set

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

interface MessageDigestRepository {

    suspend fun <T> messageDigest(data: T, serializer: KSerializer<T>): ByteArray
    suspend fun <T> verifyMessageDigest(data: T, serializer: KSerializer<T>, array: ByteArray): Boolean
}