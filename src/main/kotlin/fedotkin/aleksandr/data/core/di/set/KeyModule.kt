package fedotkin.aleksandr.data.core.di.set

import fedotkin.aleksandr.core.ASYMMETRIC_KEY_LENGTH
import fedotkin.aleksandr.core.CIPHER_ALGORITHM
import fedotkin.aleksandr.core.RSA
import fedotkin.aleksandr.core.SYMMETRIC_KEY_LENGTH
import java.security.KeyPairGenerator
import java.security.SecureRandom
import javax.crypto.KeyGenerator
import org.koin.dsl.module

val keyModule = module {

    single {
        SecureRandom()
    }

    single<KeyGenerator> {
        KeyGenerator.getInstance(CIPHER_ALGORITHM).apply {
            init(SYMMETRIC_KEY_LENGTH, get())
        }
    }

    single<KeyPairGenerator> {
        KeyPairGenerator.getInstance(RSA).apply {
            initialize(ASYMMETRIC_KEY_LENGTH)
        }
    }
}