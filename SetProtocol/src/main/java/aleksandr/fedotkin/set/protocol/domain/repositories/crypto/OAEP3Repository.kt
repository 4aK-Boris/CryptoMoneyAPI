package aleksandr.fedotkin.set.protocol.domain.repositories.crypto

import aleksandr.fedotkin.set.protocol.core.DTO
import aleksandr.fedotkin.set.protocol.core.Model
import aleksandr.fedotkin.set.protocol.data.dto.crypto.oaep.OAEP4
import aleksandr.fedotkin.set.protocol.domain.models.crypto.oaep.OAEP4Model
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.SecretKey
import kotlinx.serialization.KSerializer

interface OAEP3Repository {

    suspend fun <T: Model> createOAEPModel(
        secretKey: SecretKey,
        hash: ByteArray,
        p: T
    ): OAEP4Model<T>

    suspend fun <T: Model, R: DTO> createAndEncryptOAEPModel(
        secretKey: SecretKey,
        hash: ByteArray,
        p: T,
        map: (T) -> R,
        serializer: KSerializer<R>,
        publicKey: PublicKey
    ): ByteArray

    suspend fun <T: Model, R: DTO> encryptOAEPModel(
        oaepModel: OAEP4Model<T>,
        map: (T) -> R,
        serializer: KSerializer<R>,
        publicKey: PublicKey
    ): ByteArray

    suspend fun <T: Model, R: DTO> decryptOAEPModel(
        cipherOAEP: ByteArray,
        privateKey: PrivateKey,
        serializer: KSerializer<R>,
        map: (R) -> T
    ): OAEP4Model<T>

    fun <T: Model, R: DTO> convertToModel(
        oaep: OAEP4<R>,
        map: (R) -> T,
        serializer: KSerializer<R>
    ): OAEP4Model<T>

    fun <T: Model, R: DTO> convertToDTO(
        oaepModel: OAEP4Model<T>,
        map: (T) -> R,
        serializer: KSerializer<R>
    ): OAEP4<R>
}
