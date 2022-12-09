package fedotkin.aleksandr.data.core.di.set

import fedotkin.aleksandr.core.CIPHER_ALGORITHM
import fedotkin.aleksandr.core.HASH_ALGORITHM
import fedotkin.aleksandr.core.RSA
import java.security.MessageDigest
import javax.crypto.Cipher
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module


val cryptoModule = module {

    single {
        MessageDigest.getInstance(HASH_ALGORITHM)
    }

    single(qualifier = qualifier(name = RSA)) {
        Cipher.getInstance(RSA)
    }

    single(qualifier = qualifier(name = CIPHER_ALGORITHM)) {
        Cipher.getInstance(CIPHER_ALGORITHM)
    }
}