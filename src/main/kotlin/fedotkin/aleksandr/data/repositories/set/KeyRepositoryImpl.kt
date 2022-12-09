package fedotkin.aleksandr.data.repositories.set

import fedotkin.aleksandr.domain.repositories.set.KeyRepository
import java.security.Key
import java.security.KeyPair
import java.security.KeyPairGenerator
import javax.crypto.KeyGenerator

class KeyRepositoryImpl(
    private val keyGenerator: KeyGenerator,
    private val keyPairGenerator: KeyPairGenerator
): KeyRepository {
    override suspend fun generateKey(): Key {
        return keyGenerator.generateKey()
    }

    override suspend fun generateKeyPair(): KeyPair {
        return keyPairGenerator.generateKeyPair()
    }
}