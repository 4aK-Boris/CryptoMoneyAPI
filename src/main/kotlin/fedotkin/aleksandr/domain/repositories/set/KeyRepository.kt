package fedotkin.aleksandr.domain.repositories.set

import java.security.Key
import java.security.KeyPair

interface KeyRepository {

    suspend fun generateKey(): Key

    suspend fun generateKeyPair(): KeyPair
}