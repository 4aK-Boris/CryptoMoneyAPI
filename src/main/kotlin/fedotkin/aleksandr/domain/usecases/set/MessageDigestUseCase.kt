package fedotkin.aleksandr.domain.usecases.set

import fedotkin.aleksandr.domain.repositories.set.MessageDigestRepository
import kotlinx.serialization.KSerializer

class MessageDigestUseCase(
    private val messageDigestRepository: MessageDigestRepository
) {

    suspend fun <T> messageDigest(data: T, serializer: KSerializer<T>): ByteArray {
        return messageDigestRepository.messageDigest(data = data, serializer = serializer)
    }

    suspend fun <T> verifyMessageDigest(data: T, serializer: KSerializer<T>, array: ByteArray): Boolean {
        return messageDigestRepository.verifyMessageDigest(data = data, serializer = serializer, array = array)
    }
}